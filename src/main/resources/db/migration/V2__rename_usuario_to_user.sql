ALTER TABLE usuarios RENAME TO users;

ALTER TABLE users RENAME COLUMN nome TO name;
ALTER TABLE users RENAME COLUMN senha TO password;
ALTER TABLE users RENAME COLUMN idade TO age;
ALTER TABLE users RENAME COLUMN cidade TO city;
ALTER TABLE users RENAME COLUMN estado TO state;
ALTER TABLE users RENAME COLUMN data_cadastro TO created_at;

ALTER TABLE users RENAME CONSTRAINT usuarios_pkey TO users_pkey;
ALTER TABLE users RENAME CONSTRAINT usuarios_email_key TO users_email_key;
ALTER TABLE users RENAME CONSTRAINT usuarios_whatsapp_key TO users_whatsapp_key;
