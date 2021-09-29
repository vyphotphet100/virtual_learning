INSERT INTO `role`(`id`, `code`)
VALUES (1, "TEACHER"),
       (2, "STUDENT");

INSERT INTO `user`(`username`, `password`, `full_name`, `birthday`, `role_code`)
VALUES ("user1", "123456", "Đinh Thị Thùy Linh", "2001-04-20", "TEACHER"),
       ("user2", "123456", "Cao Đinh Sỹ Vỹ", "2001-04-15", "STUDENT");

