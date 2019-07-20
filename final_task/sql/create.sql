CREATE SCHEMA `lawmapsdb` ;

use `lawmapsdb`;

  CREATE TABLE `lawmapsdb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` TINYINT(3) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `phone` LONG NOT NULL,
  CONSTRAINT `users_id`
  PRIMARY KEY (`id`),
  INDEX `users_role_idx` (`id` ASC));

  CREATE TABLE `lawmapsdb`.`materials` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(3000) NOT NULL,
  `discription` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `lawmapsdb`.`action` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NOT NULL,
  `instructions` TEXT,
  `user_id` INT, 
  PRIMARY KEY (`id`),
  INDEX `action_user_idx` (`user_id` ASC) ,
  CONSTRAINT `action_users_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `lawmapsdb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
  CREATE TABLE `lawmapsdb`.`material_links_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `action_id` INT NOT NULL,
  `materia_id` INT NOT NULL,
   PRIMARY KEY (`id`),
  INDEX `action_link_fk_idx` (`action_id` ASC),
  CONSTRAINT `action_link_fk`
    FOREIGN KEY (`action_id`)
    REFERENCES `lawmapsdb`.`action` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `material_link_fk`
    FOREIGN KEY (`materia_id`)
    REFERENCES `lawmapsdb`.`materials` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
  CREATE TABLE `lawmapsdb`.`law_map_name` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));  

  CREATE TABLE `lawmapsdb`.`action_graphs` (
  `law_map_name_id` INT,
  `parent` INT,
  `child` INT NOT NULL,
  INDEX `graphs_action_idx` (`parent` ASC) ,
  INDEX `graphs_parent_action_id_idx` (`child` ASC) ,
  CONSTRAINT `graphs_parent_action_id`
    FOREIGN KEY (`parent`)
    REFERENCES `lawmapsdb`.`action` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `graphs_child_action_id`
    FOREIGN KEY (`child`)
    REFERENCES `lawmapsdb`.`action` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `graphs_law_map_name_id`
    FOREIGN KEY (`law_map_name_id`)
    REFERENCES `lawmapsdb`.`law_map_name` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);