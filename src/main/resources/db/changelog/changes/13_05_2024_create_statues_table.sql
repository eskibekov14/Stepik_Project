CREATE TABLE statuses (
                          id bigserial primary key ,
                          name varchar(50) NOT NULL
);

INSERT INTO statuses(name) VALUES ('New'), ('In Test'), ('Done'), ('Failed');