-- creazione della tabella review
-- README - devo ancora inserire le foreign key per collegare la tabella alle future tabelle di user e room




CREATE TABLE `review` (
	`review_id` INT(10) NOT NULL AUTO_INCREMENT,
	`location_rating` DOUBLE NULL DEFAULT NULL,
	`service_rating` DOUBLE NULL DEFAULT NULL,
	`quality_price_rating` DOUBLE NULL DEFAULT NULL,
	`comment_review` VARCHAR(500) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`data_review` DATETIME NULL DEFAULT (now()),
	PRIMARY KEY (`review_id`) USING BTREE
)
COMMENT='in questa tabella sono presenti le recensioni che gli utenti rilasciano dopo aver soggiornato'
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=16
;