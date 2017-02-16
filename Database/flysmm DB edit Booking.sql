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
-- Table `flysmmdb`.`passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`passenger` (
  `Fiscal_code` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Fiscal_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`flight` (
  `Departure_ICAO` VARCHAR(4) NOT NULL,
  `Arrival_ICAO` VARCHAR(4) NOT NULL,
  `Flight_ID` VARCHAR(5) NOT NULL,
  `Departure_Date` DATE NOT NULL,
  `Departure_Time` TIME(2) NOT NULL,
  `Arrival_Date` DATE NOT NULL,
  `Arrival_Time` TIME(2) NOT NULL,
  `Aircraft_ID_aircraft` INT(11) NOT NULL,
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
-- Table `flysmmdb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`customer` (
  `ID_Customer` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Surname` VARCHAR(45) NULL DEFAULT NULL,
  `Date_of_birth` DATE NULL DEFAULT NULL,
  `Fidelity_Points` INT(11) NULL DEFAULT NULL,
  `Type_of_custumers` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(45) NULL DEFAULT NULL,
  `Phone_NO` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Customer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`book` (
  `IdBook` INT(11) NOT NULL AUTO_INCREMENT,
  `User_ID` INT(11) NOT NULL,
  `Payed` INT(1) NOT NULL,
  `Expired` INT(1) NOT NULL,
  `Booking_date` DATETIME NOT NULL,
  `Flight_Flight_ID` VARCHAR(45) NOT NULL,
  `Total_Price` FLOAT NOT NULL,
  `passenger_Fiscal_code` INT(11) NOT NULL,
  PRIMARY KEY (`IdBook`, `User_ID`, `Flight_Flight_ID`),
  INDEX `fk_User_has_Flight_User1_idx` (`User_ID` ASC),
  INDEX `fk_Book_Flight1_idx` (`Flight_Flight_ID` ASC),
  INDEX `fk_book_passenger1_idx` (`passenger_Fiscal_code` ASC),
  CONSTRAINT `fk_Book_Flight1`
    FOREIGN KEY (`Flight_Flight_ID`)
    REFERENCES `flysmmdb`.`flight` (`Flight_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Flight_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `flysmmdb`.`customer` (`ID_Customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_passenger1`
    FOREIGN KEY (`passenger_Fiscal_code`)
    REFERENCES `flysmmdb`.`passenger` (`Fiscal_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 64
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`baggage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`baggage` (
  `ID_Baggage` INT(11) NOT NULL,
  `Weight` INT(11) NOT NULL,
  `passenger_Fiscal_code` INT(11) NOT NULL,
  `book_IdBook` INT(11) NOT NULL,
  `book_User_ID` INT(11) NOT NULL,
  `book_Flight_Flight_ID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Baggage`),
  INDEX `fk_baggage_passenger1_idx` (`passenger_Fiscal_code` ASC),
  INDEX `fk_baggage_book1_idx` (`book_IdBook` ASC, `book_User_ID` ASC, `book_Flight_Flight_ID` ASC),
  CONSTRAINT `fk_baggage_passenger1`
    FOREIGN KEY (`passenger_Fiscal_code`)
    REFERENCES `flysmmdb`.`passenger` (`Fiscal_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_baggage_book1`
    FOREIGN KEY (`book_IdBook` , `book_User_ID` , `book_Flight_Flight_ID`)
    REFERENCES `flysmmdb`.`book` (`IdBook` , `User_ID` , `Flight_Flight_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `flysmmdb`.`payment_methods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flysmmdb`.`payment_methods` (
  `No_card` INT(11) NOT NULL,
  `Owner` VARCHAR(45) NOT NULL,
  `CVV` VARCHAR(45) NOT NULL,
  `Expire` DATE NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `User_Fiscal_Code` INT(11) NOT NULL,
  PRIMARY KEY (`No_card`, `User_Fiscal_Code`),
  INDEX `fk_Payment_methods_User1_idx` (`User_Fiscal_Code` ASC),
  CONSTRAINT `fk_Payment_methods_User1`
    FOREIGN KEY (`User_Fiscal_Code`)
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
  `Price` FLOAT NOT NULL,
  `No_Seats_Available` INT(11) NOT NULL,
  `Promotion_IdPromo` INT(11) NULL DEFAULT NULL,
  `Flight_Flight_ID` VARCHAR(5) NOT NULL,
  `Flight_Departure_Date` DATE NOT NULL,
  `Seat_Row` INT(11) NOT NULL,
  `Seat_Seat` VARCHAR(45) NOT NULL,
  `Seat_Aircraft_ID_aircraft` INT(11) NOT NULL,
  `Price_baggage` FLOAT NOT NULL,
  PRIMARY KEY (`Flight_Flight_ID`, `Flight_Departure_Date`),
  INDEX `fk_Price_Promotion1_idx` (`Promotion_IdPromo` ASC),
  INDEX `fk_Price_Seat1_idx` (`Seat_Row` ASC, `Seat_Seat` ASC, `Seat_Aircraft_ID_aircraft` ASC),
  CONSTRAINT `fk_Price_Flight1`
    FOREIGN KEY (`Flight_Flight_ID` , `Flight_Departure_Date`)
    REFERENCES `flysmmdb`.`flight` (`Flight_ID` , `Departure_Date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Price_Promotion1`
    FOREIGN KEY (`Promotion_IdPromo`)
    REFERENCES `flysmmdb`.`promotion` (`IdPromo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Price_Seat1`
    FOREIGN KEY (`Seat_Row` , `Seat_Seat` , `Seat_Aircraft_ID_aircraft`)
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
