package arias.huapaya.digital.peru.money.track.configuration.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import arias.huapaya.digital.peru.money.track.configuration.security.filter.JwtAuthenticationFilter;
import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.enums.AuthProviderEnum;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserProviderCreateDTO;
import arias.huapaya.digital.peru.money.track.service.UserService;
import arias.huapaya.digital.peru.money.track.service.security.JwtService;
import arias.huapaya.digital.peru.money.track.util.exception.ObjectNotFoundException;
// import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class HttpSecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    private final JwtAuthenticationFilter authenticationFilter;

    private final AccessDeniedHandler accessDeniedHandler;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    private final AuthorizationManager<RequestAuthorizationContext> authorizationManager;

    private final CorsConfigurationSource corsConfigurationSource;

    private final UserService userService;

    private final JwtService jwtService;

    private final Environment environment;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        SecurityFilterChain filter = httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors.configurationSource(this.corsConfigurationSource))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(this.authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requestConfig -> {
                    requestConfig.anyRequest().access(authorizationManager);
                })
                .oauth2Login(oauth -> {
                    oauth.successHandler((request, response, authentication) -> {
                        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
                        String email = oAuth2User.getAttribute("email");

                        Optional<UserEntity> userOpt = this.userService.findByEmail(email);
                        UserEntity user = null;

                        if (!userOpt.isPresent()) {
                            this.createGoogleProvider(oAuth2User);
                        } else {
                            user = userOpt.get();
                        }

                        if (user == null) {
                            user = this.userService.findByUsername(email)
                                    .orElseThrow(() -> new ObjectNotFoundException("User not found: " + email));
                        }

                        Map<String, Object> claims = new HashMap<>();
                        claims.put("authorities", user.getAuthorities());

                        String jwt = this.jwtService.generateToken(user, claims);

                        String profile = this.environment.getProperty("spring.profiles.active");


                        String urlProfile = profile.equals("dev") ? "http://localhost:4200/auth/login"
                                : "https://money-track.techbackend.work/auth/login";
                        String url = (urlProfile + "?token=" + jwt);
                        response.sendRedirect(url);

                    });
                })
                .exceptionHandling(exceptionConfig -> {
                    exceptionConfig.authenticationEntryPoint(this.authenticationEntryPoint);
                    exceptionConfig.accessDeniedHandler(this.accessDeniedHandler);
                })
                .build();

        return filter;
    }

    private void createGoogleProvider(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String providerUserId = oAuth2User.getAttribute("sub");

        UserCreateDTO user = UserCreateDTO.builder()
                .firstName(name)
                .lastName("")
                .country(null)
                .email(email)
                .username(email)
                .password(null)
                .build();

        UserProviderCreateDTO userProvider = UserProviderCreateDTO.builder()
                .user(user)
                .authProvider(AuthProviderEnum.GOOGLE)
                .providerUserId(providerUserId)
                .accessToken("")
                .build();

        this.userService.createUserAndProvider(userProvider);
    }

}
