DROP TABLE IF EXISTS `airport`;
CREATE TABLE `airport` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `iata_code` varchar(3) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `crew`;
CREATE TABLE `crew` (
  `id` bigint NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `worker_code` varchar(255) DEFAULT NULL,
  `job_position` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `plane`;
CREATE TABLE `plane` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `flight_hours` decimal(19,2) NOT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) NOT NULL,
  `plate_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g2w3381o6f6budn5dvyk4j0ru` (`plate_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `flight_code` varchar(255) NOT NULL,
  `flight_departure_datetime` datetime(6) NOT NULL,
  `flight_duration` decimal(19,2) NOT NULL,
  `departureAirport_id` bigint NOT NULL,
  `destinationAirport_id` bigint NOT NULL,
  `plane_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdqdarhceq6341gu1w83mkm2mu` (`departureAirport_id`),
  KEY `FKpnn6xogjrgugsw5rr1r5076ju` (`destinationAirport_id`),
  KEY `FK7p9fvp6d7uh9cgn47uet8a8nb` (`plane_id`),
  CONSTRAINT `FK7p9fvp6d7uh9cgn47uet8a8nb` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKdqdarhceq6341gu1w83mkm2mu` FOREIGN KEY (`departureAirport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKpnn6xogjrgugsw5rr1r5076ju` FOREIGN KEY (`destinationAirport_id`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `flight_crew`;
CREATE TABLE `flight_crew` (
  `crew_id` bigint NOT NULL,
  `flight_id` bigint NOT NULL,
  PRIMARY KEY (`crew_id`,`flight_id`),
  KEY `FKdxicgx6j3pmoveat3b67tnj49` (`flight_id`),
  CONSTRAINT `FK431tm199jr2n82locnt0gt08t` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`id`),
  CONSTRAINT `FKdxicgx6j3pmoveat3b67tnj49` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `hibernate_sequence` VALUES (12);

DROP TABLE IF EXISTS `mechanic`;
CREATE TABLE `mechanic` (
  `id` bigint NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `worker_code` varchar(255) DEFAULT NULL,
  `incorporation_year` int NOT NULL,
  `training_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `begin_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `review_description` varchar(255) DEFAULT NULL,
  `review_type` varchar(255) DEFAULT NULL,
  `worked_hours` decimal(10,2) DEFAULT NULL,
  `airport_id` bigint NOT NULL,
  `mechanic_id` bigint NOT NULL,
  `plane_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfiifebyp058mg84wscmxrxyyk` (`airport_id`),
  KEY `FKqbvyg26idtfd92sgqpy6h2wt` (`mechanic_id`),
  KEY `FKe1kp6wijwg4mn3979be8uwgjm` (`plane_id`),
  CONSTRAINT `FKe1kp6wijwg4mn3979be8uwgjm` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKfiifebyp058mg84wscmxrxyyk` FOREIGN KEY (`airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKqbvyg26idtfd92sgqpy6h2wt` FOREIGN KEY (`mechanic_id`) REFERENCES `mechanic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



insert into airport (id, city, country, iata_code, name)
values  (12, 'MADRID', 'ES', 'MAD', 'Adolfo Suárez Madrid-Barajas'),
        (13, 'LONDON', 'UK', 'LHR', 'Heathrow'),
        (14, 'PARIS', 'FR', 'ORY', 'Paris-Orly');

insert into crew (id, company_name, name, surname, worker_code, job_position)
values  (15, 'Air Europa', 'Santiago', 'Paradelas', 'CAP-0001', 'Captain'),
        (16, 'Air Europa', 'Ana', 'Garcia', 'HOS-3421', 'Hostess'),
        (17, 'British Airways', 'Pedro', 'Mancias', 'CAP-0002', 'Captain'),
        (18, 'British Airways', 'Maria', 'Fernandez', 'HOS-3421', 'Hostess'),
        (19, 'Air Europa', 'John', 'Doe', 'LTD-0001', 'Copilot'),
        (20, 'British Airways', 'Juan', 'Pil', 'LTD-0001', 'Copilot');

insert into plane (id, flight_hours, manufacturer, model, plate_number)
values  (4, 1755.00, 'AIRBUS', 'A380', 'AAAAA'),
        (5, 685.50, 'AIRBUS', 'A380', 'BBBBB'),
        (6, 150.00, 'BOING', '747', 'CCCCC');

insert into flight (id, company_name, flight_code, flight_departure_datetime, flight_duration, departureAirport_id, destinationAirport_id, plane_id)
values  (4, 'Air Europa', 'AE999', '2020-01-01 12:45:00', 1.50, 12, 14, 4),
        (5, 'British Airways', 'BA555', '2020-01-01 12:45:00', 2.50, 13, 14, 6),
        (6, 'Air Europa', 'AE111', '2020-01-31 07:30:00', 2.00, 12, 13, 4);

insert into flight_crew (crew_id, flight_id)
values  (15, 4),
        (16, 4),
        (19, 4),
        (17, 5),
        (18, 5),
        (20, 5),
        (15, 6),
        (16, 6),
        (19, 6);

insert into mechanic (id, company_name, name, surname, worker_code, incorporation_year, training_description)
values  (21, 'British Airways', 'Otilio', 'Otilio', 'MEC-1002', 2016, 'FP'),
        (22, 'Air Europa', 'Pepe', 'Gotera', 'MEC-0001', 2014, 'Grado');


insert into review (id, begin_date, end_date, review_description, review_type, worked_hours, airport_id, mechanic_id, plane_id)
values  (4, '2019-12-12', '2019-12-12', 'Review cockpit wire installation', 'COCKPIT REVIEW', 10.00, 12, 22, 4),
        (5, '2019-11-11', '2019-11-11', 'Check wheel integrity', 'WHEELS REVIEW', 1.00, 13, 21, 4),
        (6, '2019-12-04', '2019-12-04', 'General maintenance', 'GENERAL REVIEW', 2.50, 13, 21, 5);
