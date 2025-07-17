INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Perú', 'PE', 'PER', 'S/', 'Peruvian sol', 51);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Chile', 'CL', 'CHL', '$', 'Chilean peso', 56);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Ecuador', 'EC', 'ECU', '$', 'United States dollar', 593);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Argentina', 'AR', 'ARG', '$', 'Argentine peso', 54);
INSERT INTO countries (name, cca2, cca3, currency_symbol, currency_name, code_country) VALUES ('Uruguay', 'UY', 'URY', '$', 'Uruguayan peso', 598);

INSERT INTO users (first_name, last_name, country_id, email, username, password, created_at, updated_at, enabled) VALUES ('Arias Huapaya', 'Xavier Alexis', 1, 'xavieralexisariashuapaya@hotmail.com', 'alexis', 'S0p0rt3123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);

INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('INBOUND', 'SUELDO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --1
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('INBOUND', 'AHORROS', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --2
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'DEUDA', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --3
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'INTERNET', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --4
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'LUZ', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --5
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'ESTUDIOS', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --6
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'COMIDAS', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --7
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'GASTOS INNECESARIO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --8
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'PASAJES', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --9
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'PRENDAS DE VESTIR', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --10
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'SERVIDOR CONTABO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --11
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'SPOTIFY', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --12
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'PLAN CELULAR', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --13
INSERT INTO categories (type, description, user_id, created_at, updated_at, enabled) VALUES ('OUTBOUND', 'COMPRA ELECTRODOMESTICO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true); --14

INSERT INTO bank_accounts (type_account, name, user_id, created_at, updated_at, enabled) VALUES ('BANK', 'BCP', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);
INSERT INTO bank_accounts (type_account, name, user_id, created_at, updated_at, enabled) VALUES ('CASH', 'BILLETERA/MONEDERO', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, true);

INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 2, 2, null, 'BILLETERA', 65.50, '2025-04-01', true);

INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 1, 1, null, 'M&S CONSULTORES', 2000, '2025-04-15', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 2, 1, null, 'MES PASADO', 3257.35, '2025-04-01', true);


INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 3, 1, null, 'SEGUNDA CASA', 300, '2025-07-01', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 4, 1, null, '', 150, '2025-07-01', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 5, 1, null, '', 150, '2025-07-01', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 6, 1, null, 'UTP', 685.53, '2025-07-12', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 7, 1, null, 'CENA EN LA PLAZA', 12, '2025-07-12', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 8, 1, null, 'DISCOTECA - MALA', 225.43, '2025-07-12', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 9, 1, null, 'PASAJES PARA IR A ESTUDIAR (UTP)', 200, '2025-07-12', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 10, 1, null, 'ROPA PARA EL LABORATORIO (UTP)', 38, '2025-07-12', true);
INSERT INTO transactions (user_id, category_id, bank_account_origin_id, bank_account_destination_id, description, amount, date, enabled) VALUES (1, 13, 1, null, 'OPERADOR CLARO', 29.90, '2025-07-09', true);