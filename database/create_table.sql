CREATE TABLE `role`
(
    `id`   BIGINT UNSIGNED AUTO_INCREMENT,
    `code` VARCHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY (`id`, `code`)
);

CREATE TABLE `user`
(
    `username`  VARCHAR(255) PRIMARY KEY,
    `password`  LONGTEXT    NOT NULL,
    `full_name` LONGTEXT,
    `email`     LONGTEXT,
    `birthday`  DATE,
    `phone`     LONGTEXT,
    `avatar`    LONGTEXT,
    `role_code` VARCHAR(15) NOT NULL,
    FOREIGN KEY (`role_code`) REFERENCES role (`code`)
);

CREATE TABLE `subject`
(
    `id`   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name` LONGTEXT NOT NULL
);

CREATE TABLE `class`
(
    `id`              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name`            LONGTEXT NOT NULL,
    `description`     LONGTEXT,
    `password`        LONGTEXT,
    `author_username` VARCHAR(255),
    `subject_id`      BIGINT UNSIGNED,
    FOREIGN KEY (`author_username`) REFERENCES `user` (`username`),
    FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
);

CREATE TABLE `join`
(
    `username` VARCHAR(255),
    `class_id` BIGINT UNSIGNED,
    FOREIGN KEY (`username`) REFERENCES `user` (`username`),
    FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
);

CREATE TABLE `lesson`
(
    `id`              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `title`           LONGTEXT NOT NULL,
    `description`     LONGTEXT,
    `video`        LONGTEXT,
    `class_id` BIGINT UNSIGNED,
    FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
);

CREATE TABLE `question`
(
    `id`              BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `content`           LONGTEXT NOT NULL,
    `option`     LONGTEXT NOT NULL,
    `correct`        INT NOT NULL,
    `lesson_id` BIGINT UNSIGNED,
    FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
);

CREATE TABLE `do`
(
    `username` VARCHAR(255),
    `question_id` BIGINT UNSIGNED,
    FOREIGN KEY (`username`) REFERENCES `user` (`username`),
    FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
);

