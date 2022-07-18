-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2022 at 05:05 AM
-- Server version: 10.4.24-MariaDB-log
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mas_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` varchar(12) NOT NULL,
  `adminName` varchar(50) NOT NULL,
  `adminEmail` varchar(50) NOT NULL,
  `adminPhone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `adminName`, `adminEmail`, `adminPhone`) VALUES
('001221140088', 'FAMSHBOOM', '', ''),
('001221141312', 'Mohd Razzeq ', 'mrazzeq@outlook.com', '0167775678');

-- --------------------------------------------------------

--
-- Table structure for table `bookedslot`
--

CREATE TABLE `bookedslot` (
  `bookID` int(11) NOT NULL,
  `slotID` varchar(255) NOT NULL,
  `userID` varchar(12) NOT NULL,
  `bookDate` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookedslot`
--

INSERT INTO `bookedslot` (`bookID`, `slotID`, `userID`, `bookDate`) VALUES
(1, 'JP05', '980410059877', '2022-05-22'),
(2, 'M01', '000816030676', '2022-07-11'),
(3, 'JP01', '000816030676', '2022-07-31');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedbackID` int(11) NOT NULL,
  `userID` varchar(12) NOT NULL,
  `feedbackDesc` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `jumaat_prayer`
--

CREATE TABLE `jumaat_prayer` (
  `slotID` varchar(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `khutbahTitle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jumaat_prayer`
--

INSERT INTO `jumaat_prayer` (`slotID`, `date`, `khutbahTitle`) VALUES
('JP01', '2022-02-05', 'Berkorban Untuk Kejayaan'),
('JP02', '2022-07-22', 'Alam Sekitar Tanggungjawab Bersama'),
('JP03', '2022-07-29', 'Khutbah III');

--
-- Triggers `jumaat_prayer`
--
DELIMITER $$
CREATE TRIGGER `deleteJumaatSlot` AFTER DELETE ON `jumaat_prayer` FOR EACH ROW BEGIN
DELETE FROM slot WHERE slotID = OLD.slotID;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insertJumaatSlot` AFTER INSERT ON `jumaat_prayer` FOR EACH ROW BEGIN
INSERT INTO slot VALUES(null, NEW.slotID, 'N/A', NEW.date);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `updateJumaatSlot` AFTER UPDATE ON `jumaat_prayer` FOR EACH ROW BEGIN
UPDATE slot SET slotDate = NEW.date WHERE slotID = OLD.slotID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `mengaji`
--

CREATE TABLE `mengaji` (
  `slotID` varchar(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `guruname` varchar(255) NOT NULL,
  `venue` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mengaji`
--

INSERT INTO `mengaji` (`slotID`, `date`, `time`, `guruname`, `venue`) VALUES
('M01', '2022-02-04', '21:00', 'Najwa Latif', 'Kelas Mengaji Taman Sri Aman');

--
-- Triggers `mengaji`
--
DELIMITER $$
CREATE TRIGGER `deleteMengajiSlot` BEFORE DELETE ON `mengaji` FOR EACH ROW BEGIN
DELETE FROM slot WHERE slotID = OLD.slotID;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insertMengajiSlot` AFTER INSERT ON `mengaji` FOR EACH ROW BEGIN
INSERT INTO slot VALUES(null, NEW.slotID, NEW.time, NEW.date);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `updateMengajiSlot` AFTER UPDATE ON `mengaji` FOR EACH ROW BEGIN
UPDATE slot SET slotTime = NEW.time, slotDate = NEW.date WHERE slotID = OLD.slotID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reguser`
--

CREATE TABLE `reguser` (
  `userID` varchar(12) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `userEmail` varchar(100) NOT NULL,
  `userPhone` varchar(11) NOT NULL,
  `userAddress` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reguser`
--

INSERT INTO `reguser` (`userID`, `userName`, `userEmail`, `userPhone`, `userAddress`) VALUES
('000914011213', 'Tasya Nasir', 'tasyanasir90@gmail.com', '0128889010', 'Lot 21, Taman Maleha'),
('920101120007', 'Roshahidah', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `slot`
--

CREATE TABLE `slot` (
  `id` int(11) NOT NULL,
  `slotID` varchar(11) NOT NULL,
  `slotTime` varchar(50) NOT NULL,
  `slotDate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slot`
--

INSERT INTO `slot` (`id`, `slotID`, `slotTime`, `slotDate`) VALUES
(1, 'U01', '9:00 AM', '2022-07-15'),
(3, 'JP02', 'N/A', '2022-07-22'),
(4, 'JP02', 'N/A', '2022-07-22'),
(5, 'JP03', 'N/A', '2022-07-29');

-- --------------------------------------------------------

--
-- Table structure for table `umrah`
--

CREATE TABLE `umrah` (
  `slotID` varchar(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `chapter` varchar(255) NOT NULL,
  `venue` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `umrah`
--

INSERT INTO `umrah` (`slotID`, `date`, `time`, `chapter`, `venue`) VALUES
('U01', '2022-07-15', '9:00 AM', 'Umrah Chapter One', 'Venue One');

--
-- Triggers `umrah`
--
DELIMITER $$
CREATE TRIGGER `deleteUmrahSlot` AFTER DELETE ON `umrah` FOR EACH ROW BEGIN
DELETE FROM slot WHERE slotID = OLD.slotID;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insertUmrahSlot` AFTER INSERT ON `umrah` FOR EACH ROW BEGIN
INSERT INTO slot VALUES(null, NEW.slotID, NEW.time, NEW.date);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `updateUmrahSlot` AFTER UPDATE ON `umrah` FOR EACH ROW BEGIN
UPDATE slot SET slotTime=NEW.time, slotDate=NEW.date WHERE slotID = OLD.slotID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `useracc`
--

CREATE TABLE `useracc` (
  `userID` varchar(12) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(8) NOT NULL,
  `role` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useracc`
--

INSERT INTO `useracc` (`userID`, `username`, `password`, `role`) VALUES
('000914011213', 'Tasya Nasir', '123456', 'user'),
('000915110077', 'Aliza Daud', 'abc123', 'user'),
('001221140088', 'FAMSHBOOM', 'famshB00', 'admin'),
('001221141312', 'Mohd Razzeq ', '00000', 'admin'),
('920101120007', 'Roshahidah', 'isp551_4', 'user'),
('950801131687', 'Darwish Mizan', 'wadd', 'user');

--
-- Triggers `useracc`
--
DELIMITER $$
CREATE TRIGGER `insertUser` AFTER INSERT ON `useracc` FOR EACH ROW BEGIN
    IF(NEW.role = 'admin')
    THEN
    INSERT INTO admin(adminID, adminName) VALUES(NEW.userID, NEW.username);
    ELSE
    INSERT INTO reguser(userID, userName) VALUES(NEW.userID, NEW.username);
    END IF;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `bookedslot`
--
ALTER TABLE `bookedslot`
  ADD PRIMARY KEY (`bookID`),
  ADD KEY `slotID` (`slotID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedbackID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `jumaat_prayer`
--
ALTER TABLE `jumaat_prayer`
  ADD PRIMARY KEY (`slotID`);

--
-- Indexes for table `mengaji`
--
ALTER TABLE `mengaji`
  ADD PRIMARY KEY (`slotID`);

--
-- Indexes for table `reguser`
--
ALTER TABLE `reguser`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `slot`
--
ALTER TABLE `slot`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `umrah`
--
ALTER TABLE `umrah`
  ADD PRIMARY KEY (`slotID`);

--
-- Indexes for table `useracc`
--
ALTER TABLE `useracc`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookedslot`
--
ALTER TABLE `bookedslot`
  MODIFY `bookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedbackID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `slot`
--
ALTER TABLE `slot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_user_id_pk` FOREIGN KEY (`adminID`) REFERENCES `useracc` (`userID`);

--
-- Constraints for table `reguser`
--
ALTER TABLE `reguser`
  ADD CONSTRAINT `user_id_pkfk` FOREIGN KEY (`userID`) REFERENCES `useracc` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
