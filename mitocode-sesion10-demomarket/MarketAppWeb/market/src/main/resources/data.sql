
INSERT INTO  users(enabled,password,user_name) VALUES(true,'$2a$10$C6.VXm9rCct.1YICL/WPKe0yACRtHAAxoFDK1a8ze/KidWSKXCTv2','hampcode');
INSERT INTO  users(enabled,password,user_name) VALUES(true,'$2a$10$iI7OVtQWVb550SoHk.cf3.9WspTrVDmtO.Hif.p87S4RilxdOTSmG','usercode');


INSERT INTO authorities(authority,user_id) VALUES('ROLE_ADMIN',1);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',2);

INSERT INTO customers(dni, first_name,last_name) VALUES('40738787','Henry Antonio','Mendoza Puerta');

INSERT INTO products(name,price) VALUES('Arroz',5.00);
INSERT INTO products(name,price) VALUES('Caramelos',2.00);