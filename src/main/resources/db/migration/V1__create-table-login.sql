CREATE TABLE login (
   id_login VARCHAR(36) PRIMARY KEY,
   email_login VARCHAR(255) NOT NULL,
   password_login VARCHAR(255) NOT NULL,
   type_of_user ENUM('PETOWNER')
);