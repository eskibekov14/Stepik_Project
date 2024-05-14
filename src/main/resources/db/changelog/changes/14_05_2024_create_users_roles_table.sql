CREATE TABLE users_roles (
    users_id bigint ,
    roles_id bigint ,
    FOREIGN KEY (users_id) REFERENCES users(id) ,
    FOREIGN KEY (roles_id) REFERENCES permissions(id)
);

INSERT INTO users_roles (users_id, roles_id) VALUES (1,1),
                                                    (1,2);