CREATE TABLE tasks (
  id bigserial primary key ,
  name varchar(100) NOT NULL ,
  status_id bigint ,
  user_id bigint,
  FOREIGN KEY (status_id) REFERENCES statuses(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO tasks (name, status_id, user_id) VALUES ('Test Task',1,1);