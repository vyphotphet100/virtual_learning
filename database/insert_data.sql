INSERT INTO `role`(`id`, `code`)
VALUES (1, "TEACHER"),
       (2, "STUDENT");

INSERT INTO `user`(`username`, `password`, `full_name`, `birthday`, `role_code`)
VALUES ("user1", "123456", "Đinh Thị Thùy Linh", "2001-04-20", "TEACHER"),
       ("user2", "123456", "Cao Đinh Sỹ Vỹ", "2001-04-15", "STUDENT");

INSERT INTO `subject`(`id`, `name`)
VALUES (1, "Subject 1"),
       (2, "Subject 2"),
       (3, "Subject 3"),
       (4, "Subject 4");

INSERT INTO `class`(`id`, `name`, `description`, `password`, `author_username`, `subject_id`)
VALUES (1, "Class 1", "This is description", "123", "user2", "2"),
       (2, "Class 2", "This is description", "123", "user1", "3"),
       (3, "Class 3", "This is description", "123", "user1", "1"),
       (4, "Class 4", "This is description", "123", "user2", "4"),
       (5, "Class 5", "This is description", "123", "user1", "4");

INSERT INTO `lesson`(`id`, `title`, `description`, `video`, `class_id`)
VALUES (1, "Lesson 1", "Description", null, 1),
       (2, "Lesson 2", "Description", null, 3),
       (3, "Lesson 3", "Description", null, 4),
       (4, "Lesson 4", "Description", null, 1);







