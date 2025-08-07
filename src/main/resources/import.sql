INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Peru', 'PE', 'PER', 'S/', 'Peruvian sol', 51);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Chile', 'CL', 'CHL', '$', 'Chilean peso', 56);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Ecuador', 'EC', 'ECU', '$', 'United States dollar', 593);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Argentina', 'AR', 'ARG', '$', 'Argentine peso', 54);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Uruguay', 'UY', 'URY', '$', 'Uruguayan peso', 598);


INSERT INTO roles (description, enabled) VALUES ('ADMINISTRATOR', true);
INSERT INTO roles (description, enabled) VALUES ('EMPLOYEE', true);

INSERT INTO users (first_name, last_name, country_id, email, username, password, rol_id, created_at, updated_at, enabled) VALUES ('Arias Huapaya', 'Xavier Alexis', 1, 'xavieralexisariashuapaya@hotmail.com', 'alexis', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);

INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('INBOUND', 'Initial Amount', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --1
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('INBOUND', 'SUELDO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --1
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('INBOUND', 'AHORROS', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --2
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'DEUDA', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --3
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'INTERNET', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --4
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'LUZ', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --5
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'ESTUDIOS', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --6
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'COMIDAS', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --7
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'GASTOS INNECESARIO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --8
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'PASAJES', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --9
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'PRENDAS DE VESTIR', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --10
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'SERVIDOR CONTABO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --11
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'SPOTIFY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --12
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'PLAN CELULAR', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --13
-- INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'COMPRA ELECTRODOMESTICO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --14
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'Transfer', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --15

INSERT INTO bank_accounts (type_account, name, user_id, created_at, updated_at, enabled) VALUES ('BANK', 'BCP', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);
INSERT INTO bank_accounts (type_account, name, user_id, created_at, updated_at, enabled) VALUES ('BANK', 'INTERBANK', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);
INSERT INTO bank_accounts (type_account, name, user_id, created_at, updated_at, enabled) VALUES ('CASH', 'BILLETERA/MONEDERO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);

-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 2, 2, null, 'BILLETERA', 65.50, '2025-04-01', true);

-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 1, 1, null, 'M&S CONSULTORES', 2000, '2025-04-15', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 2, 1, null, 'MES PASADO', 3257.35, '2025-04-01', true);


-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 3, 1, null, 'SEGUNDA CASA', 300, '2025-07-01', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 4, 1, null, '', 150, '2025-07-01', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 5, 1, null, '', 150, '2025-07-01', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 6, 1, null, 'UTP', 685.53, '2025-07-12', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 7, 1, null, 'CENA EN LA PLAZA', 12, '2025-07-12', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 8, 1, null, 'DISCOTECA - MALA', 225.43, '2025-07-12', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 9, 1, null, 'PASAJES PARA IR A ESTUDIAR (UTP)', 200, '2025-07-12', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 10, 1, null, 'ROPA PARA EL LABORATORIO (UTP)', 38, '2025-07-12', true);
-- INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 13, 1, null, 'OPERADOR CLARO', 29.90, '2025-07-09', true);



INSERT INTO modules (name, base_path) VALUES ('AUTHENTICATION', '/auth');
INSERT INTO modules (name, base_path) VALUES ('CATEGORY', '/category');
INSERT INTO modules (name, base_path) VALUES ('BANK-ACCOUNT', '/bank-account');
INSERT INTO modules (name, base_path) VALUES ('COUNTRY', '/country');
INSERT INTO modules (name, base_path) VALUES ('TRANSACTION', '/transaction');
INSERT INTO modules (name, base_path) VALUES ('USER', '/user');
INSERT INTO modules (name, base_path) VALUES ('USER-SETTING', '/user-setting');

INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('AUTHENTICATE', '/authenticate', 'POST', true, 1);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('VALIDATE-TOKEN', '/validate', 'POST', true, 1);

INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('CATEGORY_CREATE', '', 'POST', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('CATEGORY_UPDATE', '', 'PATCH', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('CATEGORY_FIND_ALL', '/user/[0-9]*', 'GET', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('CATEGORY_FIND_ONE', '/[0-9]*', 'GET', false, 2);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('CATEGORY_PAGINATION', '/pagination/[0-9]*', 'GET', false, 2);

INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('BANK_ACCOUNT_CREATE', '', 'POST', false, 3);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('BANK_ACCOUNT_UPDATE', '', 'PATCH', false, 3);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('BANK_ACCOUNT_FIND_ALL', '/user/[0-9]*', 'GET', false, 3);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('BANK_ACCOUNT_FIND_ONE', '/[0-9]*', 'GET', false, 3);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('BANK_ACCOUNT_PAGINATION', '/pagination/[0-9]*', 'GET', false, 3);


INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('COUNTRY_ACCOUNT_FIND_ALL', '', 'GET', true, 4);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('COUNTRY_ACCOUNT_FIND_ONE', '/[0-9]*', 'GET', true, 4);


INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('TRANSACTION_CREATE', '', 'POST', false, 5);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('TRANSACTION_PAGINATION', '/pagination/[0-9]*', 'GET', false, 5);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('TRANSACTION_BALANCE', '/balance/[0-9]*', 'GET', false, 5);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('TRANSACTION_DASHBOARD_BAR', '/dashboard/bar/[0-9]*', 'GET', false, 5);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('TRANSACTION_DASHBOARD_BAR_TYPE', '/dashboard/bar/[0-9]*/type/[A-Za-z]*', 'GET', false, 5);


INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_CREATE', '', 'POST', true, 6);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_UPDATE', '', 'PATCH', false, 6);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_UPDATE_PASSWORD', '/password', 'PATCH', false, 6);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_FIND_ONE', '/[0-9]*', 'GET', false, 6);


INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_SETTING_CREATE', '', 'POST', false, 7);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_SETTING_UPDATE', '', 'PATCH', false, 7);
INSERT INTO operations (name, path, http_method, permit_all, module_id) VALUES ('USER_SETTING_FIND_ALL_BY_USER', '/user/[0-9]*', 'GET', false, 7);

INSERT INTO permissions (rol_id, operation_id) VALUES (1, 3);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 4);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 5);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 6);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 7);

INSERT INTO permissions (rol_id, operation_id) VALUES (1, 8);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 9);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 10);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 11);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 12);

INSERT INTO permissions (rol_id, operation_id) VALUES (1, 15);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 16);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 17);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 18);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 19);

INSERT INTO permissions (rol_id, operation_id) VALUES (1, 21);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 22);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 23);

INSERT INTO permissions (rol_id, operation_id) VALUES (1, 24);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 25);
INSERT INTO permissions (rol_id, operation_id) VALUES (1, 26);



INSERT INTO permissions (rol_id, operation_id) VALUES (2, 3);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 4);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 5);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 6);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 7);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 8);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 9);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 10);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 11);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 12);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 15);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 16);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 17);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 18);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 19);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 21);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 22);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 23);

INSERT INTO permissions (rol_id, operation_id) VALUES (2, 24);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 25);
INSERT INTO permissions (rol_id, operation_id) VALUES (2, 26);

-- INSERT INTO users (username, password, rol_id, enabled) VALUES ('administrator', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 1, true);
-- INSERT INTO users (username, password, rol_id, enabled) VALUES ('employee', '$2a$10$7.kqP/Rb5aFoYnaPXt7jXOzJMrvXiLfYP1d5YSjqEIkpELpjjYl8C', 2, true);
