INSERT INTO `role`(`id`, `code`)
VALUES (1, "TEACHER"),
       (2, "STUDENT");

INSERT INTO `user`(`username`, `password`, `full_name`, `birthday`, `role_id`)
VALUES ("user1", "123456", "Đinh Thị Thùy Linh", "2001-04-20", 1),
       ("user2", "123456", "Cao Đinh Sỹ Vỹ", "2001-04-15", 2);

INSERT INTO `subject`(`id`, `name`)
VALUES (1, "Subject 1"),
       (2, "Subject 2"),
       (3, "Subject 3"),
       (4, "Subject 4");

INSERT INTO `class`(`id`, `name`, `description`, `password`, `author_username`, `subject_id`)
VALUES (1, "Class 1", "This is description", "123", "user2", 2),
       (2, "Class 2", "This is description", "123", "user1", 3),
       (3, "Class 3", "This is description", "123", "user1", 1),
       (4, "Class 4", "This is description", "123", "user2", 4),
       (5, "Class 5", "This is description", "123", "user1", 4),
       (6, "Class 6", "This is description", "123", "user2", 1),
       (7, "Class 7", "This is description", "123", "user1", 1),
       (8, "Class 8", "This is description", "123", "user1", 1),
       (9, "Class 9", "This is description", "123", "user2", 1),
       (10, "Class 10", "This is description", "123", "user1", 2),
       (11, "Class 11", "This is description", "123", "user2", 2),
       (12, "Class 12", "This is description", "123", "user1", 2),
       (13, "Class 13", "This is description", "123", "user2", 2),
       (14, "Class 14", "This is description", "123", "user1", 2),
       (15, "Class 15", "This is description", "123", "user2", 3),
       (16, "Class 16", "This is description", "123", "user1", 3),
       (17, "Class 17", "This is description", "123", "user2", 3),
       (18, "Class 18", "This is description", "123", "user1", 3),
       (19, "Class 19", "This is description", "123", "user2", 4),
       (20, "Class 20", "This is description", "123", "user1", 4),
       (21, "Class 21", "This is description", "123", "user2", 4),
       (22, "Class 22", "This is description", "123", "user1", 4),
       (23, "Class 23", "This is description", "123", "user2", 4);

INSERT INTO `lesson`(`id`, `title`, `description`, `video`, `class_id`)
VALUES (1, "Lesson 1", "Description", null, 1),
       (2, "Lesson 2", "Description", null, 3),
       (3, "Lesson 3", "Description", null, 4),
       (4, "Lesson 4", "Description", null, 1);

INSERT INTO `question`(`id`, `content`, `option`, `correct`, `lesson_id`)
VALUES (1, "Content lesson 1", "option1|option2|option3|option4", 2, 1),
       (2, "Content lesson 2", "option1|option2|option3|option4", 3, 1),
       (3, "Content lesson 3", "option1|option2|option3|option4", 2, 2),
       (4, "Content lesson 4", "option1|option2|option3|option4", 4, 3);

INSERT INTO `do`(`username`, `question_id`)
VALUES ("user1", 1),
       ("user1", 2),
       ("user2", 2),
       ("user2", 3);

INSERT INTO `joined`(`username`, `class_id`)
VALUES ('user2', '1');




