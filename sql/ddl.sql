-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE `user` (
	`user_id` INT NOT NULL AUTO_INCREMENT COMMENT 'user id',
	`nickname` VARCHAR(50) NOT NULL COMMENT 'nickname',
	`password` VARCHAR(255) NOT NULL COMMENT '암호회된 password',
	`quiz_create` INT NOT NULL COMMENT '퀴즈 생성 여부',
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
CREATE TABLE `quiz`(
	`quiz_id` INT AUTO_INCREMENT NOT NULL,
	`content` varchar(255) NOT NULL,
	PRIMARY KEY(quiz_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
CREATE TABLE `user_quiz`(
	`quiz_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `answer` INT NOT NULL ,
    PRIMARY KEY(quiz_id, user_id),
    FOREIGN KEY(quiz_id) REFERENCES quiz(quiz_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
CREATE TABLE `score`(
	`examiner` INT NOT NULL,
	`answerer` INT NOT NULL,
	`score` INT NOT NULL,
	PRIMARY KEY(examiner, answerer),
	FOREIGN KEY(examiner) REFERENCES user(user_id),
	FOREIGN KEY(answerer) REFERENCES user(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
  