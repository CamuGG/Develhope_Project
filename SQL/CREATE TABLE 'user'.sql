-- creazione della tabella che raccoglierà gli utenti







CREATE TABLE `user` (
	`id_user` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`surname` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`date_of_birth` DATE NOT NULL,
	`email` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`phone_number` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`method_payment` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id_user`) USING BTREE
)
COMMENT='in questa tabella sono presenti i dati degli utenti registrati'
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;