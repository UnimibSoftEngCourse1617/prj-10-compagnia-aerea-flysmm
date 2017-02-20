-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema flysmmdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flysmmdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flysmmdb` DEFAULT CHARACTER SET utf8 ;
USE `flysmmdb` ;

-- -----------------------------------------------------
-- Table `flysmmdb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`address` (
  `idAddress` INT(11) NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NULL DEFAULT NULL,
  `Street_number` VARCHAR(45) NULL DEFAULT NULL,
  `CAP` VARCHAR(45) NULL DEFAULT NULL,
  `City` VARCHAR(45) NULL DEFAULT NULL,
  `Country` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idAddress`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`aircraft`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`aircraft` (
  `ID_aircraft` INT(11) NOT NULL,
  `Model` VARCHAR(45) NULL DEFAULT NULL,
  `Seat_Number` INT(11) NULL DEFAULT NULL,
  `Weight_Bound` INT(11) NULL DEFAULT NULL,
  `Constructor` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_aircraft`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`airport` (
  `ICAO` VARCHAR(4) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  `Timezone` INT(11) NOT NULL,
  PRIMARY KEY (`ICAO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`baggage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`baggage` (
  `ID_Baggage` VARCHAR(45) NOT NULL,
  `Weight` INT(11) NOT NULL,
  `Price_baggage` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Baggage`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`flight` (
  `Departure_ICAO` VARCHAR(4) NOT NULL,
  `Arrival_ICAO` VARCHAR(4) NOT NULL,
  `Flight_ID` VARCHAR(5) NOT NULL,
  `Departure_Date` DATE NOT NULL,
  `Departure_Time` TIME NOT NULL,
  `Arrival_Date` DATE NOT NULL,
  `Arrival_Time` TIME NOT NULL,
  `Aircraft_ID_aircraft` INT(11) NOT NULL,
  `Distance` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Flight_ID`, `Departure_Date`, `Aircraft_ID_aircraft`),
  INDEX `fk_Airport_has_Airport_Airport1_idx` (`Arrival_ICAO` ASC),
  INDEX `fk_Airport_has_Airport_Airport_idx` (`Departure_ICAO` ASC),
  INDEX `fk_Flight_Aircraft1_idx` (`Aircraft_ID_aircraft` ASC),
  CONSTRAINT `fk_Airport_has_Airport_Airport`
    FOREIGN KEY (`Departure_ICAO`)
    REFERENCES `flysmmdb`.`airport` (`ICAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Airport_has_Airport_Airport1`
    FOREIGN KEY (`Arrival_ICAO`)
    REFERENCES `flysmmdb`.`airport` (`ICAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Flight_Aircraft1`
    FOREIGN KEY (`Aircraft_ID_aircraft`)
    REFERENCES `flysmmdb`.`aircraft` (`ID_aircraft`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`passenger` (
  `Fiscal_code` VARCHAR(16) NOT NULL DEFAULT 'nnn',
  `Name` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL,
  `Birth_date` DATE NOT NULL,
  `ID_code` VARCHAR(45) NOT NULL,
  `Type_ID` VARCHAR(45) NOT NULL,
  `Baggage_ID_Baggage` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Fiscal_code`),
  INDEX `fk_Passenger_Baggage1_idx` (`Baggage_ID_Baggage` ASC),
  CONSTRAINT `fk_Passenger_Baggage1`
    FOREIGN KEY (`Baggage_ID_Baggage`)
    REFERENCES `flysmmdb`.`baggage` (`ID_Baggage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`customer` (
  `ID_Customer` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Surname` VARCHAR(45) NULL DEFAULT NULL,
  `Address_idAddress` INT(11) NOT NULL,
  `Date_of_birth` DATE NULL DEFAULT NULL,
  `Fidelity_Points` INT(11) NULL DEFAULT NULL,
  `Type_of_customers` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(45) NULL DEFAULT NULL,
  `Phone_NO` VARCHAR(45) NULL DEFAULT NULL,
  `Date_start_fidelity` DATE NULL DEFAULT NULL,
  `Date_last_book` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Customer`),
  INDEX `fk_customer_Address1_idx` (`Address_idAddress` ASC),
  CONSTRAINT `fk_customer_Address1`
    FOREIGN KEY (`Address_idAddress`)
    REFERENCES `flysmmdb`.`address` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`book` (
  `User_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `IdBook` VARCHAR(45) NOT NULL,
  `Payed` INT(1) NOT NULL,
  `Expired` INT(1) NOT NULL,
  `Booking_date` DATETIME NOT NULL,
  `Passenger_Fiscal_code` VARCHAR(16) NOT NULL,
  `Flight_Flight_ID` VARCHAR(5) NOT NULL,
  `Flight_Departure_Date` DATE NOT NULL,
  `Flight_Airplane_ID` INT(11) NOT NULL,
  `Total_Price` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`User_ID`, `IdBook`, `Flight_Flight_ID`, `Flight_Departure_Date`, `Flight_Airplane_ID`),
  INDEX `fk_User_has_Flight_User1_idx` (`User_ID` ASC),
  INDEX `fk_Book_Passenger1_idx` (`Passenger_Fiscal_code` ASC),
  INDEX `fk_Book_Flight1_idx` (`Flight_Flight_ID` ASC, `Flight_Departure_Date` ASC, `Flight_Airplane_ID` ASC),
  CONSTRAINT `fk_Book_Flight1`
    FOREIGN KEY (`Flight_Flight_ID` , `Flight_Departure_Date`)
    REFERENCES `flysmmdb`.`flight` (`Flight_ID` , `Departure_Date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Passenger1`
    FOREIGN KEY (`Passenger_Fiscal_code`)
    REFERENCES `flysmmdb`.`passenger` (`Fiscal_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Flight_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `flysmmdb`.`customer` (`ID_Customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`payment_methods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`payment_methods` (
  `Customer_id_customer` INT(11) NOT NULL AUTO_INCREMENT,
  `No_card` INT(11) NOT NULL,
  `Owner` VARCHAR(45) NOT NULL,
  `CVV` VARCHAR(45) NOT NULL,
  `Expire` DATE NOT NULL,
  PRIMARY KEY (`Customer_id_customer`, `No_card`),
  INDEX `fk_Payment_methods_User1_idx` (`Customer_id_customer` ASC),
  CONSTRAINT `fk_Payment_methods_User1`
    FOREIGN KEY (`Customer_id_customer`)
    REFERENCES `flysmmdb`.`customer` (`ID_Customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`promotion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`promotion` (
  `IdPromo` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Expire_Date` DATE NULL DEFAULT NULL,
  `Discount_rate` INT(11) NULL DEFAULT NULL,
  `Start_Date` DATE NULL DEFAULT NULL,
  `Fidelity` TINYINT(1) NULL DEFAULT NULL,
  `Description` VARCHAR(255) NULL DEFAULT NULL,
  `promo_type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`IdPromo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`seat` (
  `Row` INT(11) NOT NULL,
  `Seat` VARCHAR(45) NOT NULL,
  `Tariff` VARCHAR(45) NOT NULL,
  `Aircraft_ID_aircraft` INT(11) NOT NULL,
  PRIMARY KEY (`Row`, `Seat`, `Aircraft_ID_aircraft`),
  INDEX `fk_Seat_Aircraft1_idx` (`Aircraft_ID_aircraft` ASC),
  CONSTRAINT `fk_Seat_Aircraft1`
    FOREIGN KEY (`Aircraft_ID_aircraft`)
    REFERENCES `flysmmdb`.`aircraft` (`ID_aircraft`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`price` (
  `flight_Flight_ID` VARCHAR(5) NOT NULL,
  `flight_Departure_Date` DATE NOT NULL,
  `flight_Aircraft_ID_aircraft` INT(11) NOT NULL,
  `seat_Row` INT(11) NOT NULL,
  `seat_Seat` VARCHAR(45) NOT NULL,
  `seat_Aircraft_ID_aircraft` INT(11) NOT NULL,
  `promotion_IdPromo` INT(11) NULL DEFAULT NULL,
  `amount` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`flight_Flight_ID`, `flight_Departure_Date`, `flight_Aircraft_ID_aircraft`, `seat_Row`, `seat_Seat`, `seat_Aircraft_ID_aircraft`),
  INDEX `fk_flight_has_seat_seat1_idx` (`seat_Row` ASC, `seat_Seat` ASC, `seat_Aircraft_ID_aircraft` ASC),
  INDEX `fk_flight_has_seat_flight1_idx` (`flight_Flight_ID` ASC, `flight_Departure_Date` ASC, `flight_Aircraft_ID_aircraft` ASC),
  INDEX `fk_flight_has_seat_promotion1_idx` (`promotion_IdPromo` ASC),
  CONSTRAINT `fk_flight_has_seat_flight1`
    FOREIGN KEY (`flight_Flight_ID` , `flight_Departure_Date` , `flight_Aircraft_ID_aircraft`)
    REFERENCES `flysmmdb`.`flight` (`Flight_ID` , `Departure_Date` , `Aircraft_ID_aircraft`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_has_seat_promotion1`
    FOREIGN KEY (`promotion_IdPromo`)
    REFERENCES `flysmmdb`.`promotion` (`IdPromo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_has_seat_seat1`
    FOREIGN KEY (`seat_Row` , `seat_Seat` , `seat_Aircraft_ID_aircraft`)
    REFERENCES `flysmmdb`.`seat` (`Row` , `Seat` , `Aircraft_ID_aircraft`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`registrer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`registrer` (
  `Code_prenotazione` INT(11) NOT NULL,
  `ID_payment` VARCHAR(45) NULL DEFAULT NULL,
  `Date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`Code_prenotazione`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
