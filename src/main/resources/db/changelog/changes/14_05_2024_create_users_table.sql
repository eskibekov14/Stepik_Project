CREATE TABLE users (
    id bigserial primary key ,
    fullName varchar(105) NOT NULL ,
    email varchar(105) NOT NULL ,
    password varchar(105) NOT NULL
);
INSERT INTO users (fullName, email, password) VALUES
                                                  ('Test Testov','test@gmail.com',
                                                   '$2a$12$rwVG.KVJAp.r2HT1zmmnnOoZ1HS6y59OsGFG4nFczjwlE3BGrqEHa');
-- password is 'test'