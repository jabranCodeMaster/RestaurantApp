-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 24, 2017 at 08:03 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_info`
--

CREATE TABLE `employee_info` (
  `employee_id` int(4) NOT NULL,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(18) NOT NULL,
  `dob` date DEFAULT NULL,
  `email_id` varchar(256) NOT NULL,
  `position` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_info`
--

INSERT INTO `employee_info` (`employee_id`, `first_name`, `last_name`, `dob`, `email_id`, `position`, `password`) VALUES
(1, 'Bob', 'Marley', '1975-05-23', 'bobmarley@thedonald.com', 'worker', 'boo'),
(2, 'Meghan', 'Turner', '1992-08-17', 'mymusicsux@facebook.com', 'worker', 'allaboutthatbass'),
(3, 'Ozzy', 'Osborn', '1958-02-14', 'iamsoold@gmail.ca', 'worker', 'soold'),
(4, 'Jabran', 'Khan', '1998-01-06', 'random@email.com', 'owner', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
  `table_id` int(4) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `status` varchar(24) DEFAULT NULL,
  `num_people` int(4) DEFAULT NULL,
  `phone_num` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tables`
--

INSERT INTO `tables` (`table_id`, `name`, `email`, `status`, `num_people`, `phone_num`) VALUES
(1, NULL, NULL, 'empty', NULL, NULL),
(2, NULL, NULL, 'empty', NULL, NULL),
(3, NULL, NULL, 'empty', NULL, NULL),
(4, NULL, NULL, 'empty', NULL, NULL),
(5, NULL, NULL, 'empty', NULL, NULL),
(6, NULL, NULL, 'empty', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee_info`
--
ALTER TABLE `employee_info`
  ADD PRIMARY KEY (`employee_id`) USING BTREE;

--
-- Indexes for table `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`table_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
