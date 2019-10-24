
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `developer` (
  `person` int(11) NOT NULL,
  `developer_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`person`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
  `person` int(11) NOT NULL,
  `user_agreement` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`person`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
 


CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `primary_number` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_person_idx` (`person`),
  CONSTRAINT `phone_person` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary_address` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `adress_person_idx` (`person`),
  CONSTRAINT `adress_person` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `privilege` (
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `privilege`(`type`)VALUES('create');
INSERT INTO `privilege`(`type`)VALUES('read');
INSERT INTO `privilege`(`type`)VALUES('update');
INSERT INTO `privilege`(`type`)VALUES('delete');


CREATE TABLE `role` (
  `role_type` varchar(45) NOT NULL,
  PRIMARY KEY (`role_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

INSERT INTO `role`(`role_type`)VALUES('owner');
INSERT INTO `role`(`role_type`)VALUES('admin');
INSERT INTO `role`(`role_type`)VALUES('writer');
INSERT INTO `role`(`role_type`)VALUES('editor');
INSERT INTO `role`(`role_type`)VALUES('reviewer');



CREATE TABLE `website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `visits` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `developer_person_generalization_idx` (`developer`),
  CONSTRAINT `website_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`person`)
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE `website_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_type` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_idx` (`role_type`),
  KEY `website_role_developer_idx` (`developer`),
  KEY `website_role_website_idx` (`website`),
  CONSTRAINT `role` FOREIGN KEY (`role_type`) REFERENCES `role` (`role_type`),
  CONSTRAINT `website_role_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`person`),
  CONSTRAINT `website_role_website` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `website_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `privilege_idx` (`privilege`),
  KEY `website_privilege_developer_idx` (`developer`),
  KEY `website_privilege_website_idx` (`website`),
  CONSTRAINT `privilege` FOREIGN KEY (`privilege`) REFERENCES `privilege` (`type`),
  CONSTRAINT `website_privilege_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`person`),
  CONSTRAINT `website_privilege_website` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4;



CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `views` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_idx` (`website`),
  CONSTRAINT `website_page` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=568 DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE `page_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_privilege_idx` (`privilege`),
  KEY `page_privilege_developer_idx` (`developer`),
  KEY `page_privilege_page_idx` (`page`),
  CONSTRAINT `page_privilege` FOREIGN KEY (`privilege`) REFERENCES `privilege` (`type`),
  CONSTRAINT `page_privilege_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`person`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `page_privilege_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `page_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_type` varchar(45) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_idx` (`role_type`),
  KEY `page_role_developer_idx` (`developer`),
  KEY `page_role_page_idx` (`page`),
  CONSTRAINT `page_role` FOREIGN KEY (`role_type`) REFERENCES `role` (`role_type`),
  CONSTRAINT `page_role_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`person`)ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `page_role_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `widget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `cssClass` varchar(45) DEFAULT NULL,
  `cssStyle` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL,
  `dtype` varchar(45) NOT NULL COMMENT 'youtube/image/heading/html',
  `page` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT '2' COMMENT 'heading_size',
  `html` varchar(45) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareble` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `widget_page_idx` (`page`),
  CONSTRAINT `widget_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(50) NOT NULL,
  `askedBy` int(11) NOT NULL,
  `postedOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `length` int(11) DEFAULT '0',
  `views` int(11) DEFAULT '0',
  `endorsedByInstructor` tinyint(1) DEFAULT '0',
  `module` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Question_By_User` (`askedBy`),
  KEY `Question_On_Module` (`module`),
  CONSTRAINT `Question_By_User` FOREIGN KEY (`askedBy`) REFERENCES `user` (`person`),
  CONSTRAINT `Question_On_Module` FOREIGN KEY (`module`) REFERENCES `module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(45) NOT NULL,
  `postedBy` int(11) NOT NULL,
  `postedOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `correctAnswer` tinyint(1) DEFAULT '0',
  `upVotes` int(11) DEFAULT '0',
  `downVotes` int(11) DEFAULT '0',
  `questionId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `answer_by_user` (`postedBy`),
  KEY `answer_of_question` (`questionId`),
  CONSTRAINT `answer_by_user` FOREIGN KEY (`postedBy`) REFERENCES `user` (`person`),
  CONSTRAINT `answer_of_question` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;



CREATE TABLE `module` (
  `id` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




