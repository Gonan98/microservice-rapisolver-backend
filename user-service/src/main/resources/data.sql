INSERT INTO roles (name,can_publish,status,created_at) VALUES ('ROLE_CUSTOMER',false,'CREATED',CURRENT_TIMESTAMP);
INSERT INTO roles (name,can_publish,status,created_at) VALUES ('ROLE_SUPPLIER',true,'CREATED',CURRENT_TIMESTAMP);

INSERT INTO users (birthdate,created_at,email,firstname,lastname,password,phone,status,role_id)
    VALUES ('1998-03-14',CURRENT_TIMESTAMP,'andre.gonzales@gmail.com','Andre','Gonzales Soncco','12345','960522577','CREATED',1);
INSERT INTO users (birthdate,created_at,email,firstname,lastname,password,phone,status,role_id)
VALUES ('2001-12-17',CURRENT_TIMESTAMP,'marianne.blas@gmail.com','Marianne','Blas Palomino','12345','960333222','CREATED',1);