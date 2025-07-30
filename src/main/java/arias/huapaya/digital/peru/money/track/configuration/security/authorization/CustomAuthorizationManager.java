package arias.huapaya.digital.peru.money.track.configuration.security.authorization;

import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import arias.huapaya.digital.peru.money.track.persistence.entity.OperationEntity;
import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.OperationRepository;
import arias.huapaya.digital.peru.money.track.persistence.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private final OperationRepository operationRepository;

    private final UserRepository userRepository;

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication,
            RequestAuthorizationContext requestContext) {
        HttpServletRequest request = requestContext.getRequest();
        String url = this.extractUrl(request);
        String httpMethod = request.getMethod();

        Boolean isPublic = this.isPublic(url, httpMethod);

        if (isPublic) {
            return new AuthorizationDecision(true);
        }

        Boolean isGranted = this.isGranted(url, httpMethod, authentication.get());

        return new AuthorizationDecision(isGranted);
    }

    private String extractUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String url = request.getRequestURI();
        url = url.replace(contextPath, "");
        return url;
    }

    private Boolean isPublic(String url, String httpMethod) {
        List<OperationEntity> operations = this.operationRepository.findByPublicAccess();
        Boolean isPublic = operations.stream().anyMatch(operation -> {
            String basePath = operation.getModule().getBasePath();
            Pattern pattern = Pattern.compile(basePath.concat(operation.getPath()));
            Matcher matcher = pattern.matcher(url);
            return matcher.matches() && operation.getHttpMethod().equals(httpMethod);
        });
        return isPublic;
    }

    private Boolean isGranted(String url, String httpMethod, Authentication authentication) {
        if (authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken)) {
            throw new AuthenticationCredentialsNotFoundException("User not logged in");
        }

        List<OperationEntity> operations = this.obtainOperations(authentication);

        Boolean isGranted = operations.stream().anyMatch(operation -> {
            String basePath = operation.getModule().getBasePath();
            Pattern pattern = Pattern.compile(basePath.concat(operation.getPath()));
            Matcher matcher = pattern.matcher(url);
            return matcher.matches() && operation.getHttpMethod().equals(httpMethod);
        });
        return isGranted;
    }

    private List<OperationEntity> obtainOperations(Authentication authentication) {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
        String username = (String) authToken.getPrincipal();
        UserEntity userEntity = this.userRepository.findByUsername(username).get();

        return userEntity.getRol().getPermissions().stream()
                .map(grantedPermissions -> grantedPermissions.getOperations())
                .collect(Collectors.toList());
    }

}
