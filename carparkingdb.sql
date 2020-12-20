-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2017 at 03:16 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carparkingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE `pay` (
  `id` int(10) NOT NULL,
  `price` varchar(10) NOT NULL,
  `arrdate` varchar(10) NOT NULL,
  `arrtime` varchar(10) NOT NULL,
  `Tid` int(10) NOT NULL,
  `locationid` int(10) NOT NULL,
  `slotno` int(10) NOT NULL,
  `locationname` varchar(30) NOT NULL,
  `uid` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pay`
--

INSERT INTO `pay` (`id`, `price`, `arrdate`, `arrtime`, `Tid`, `locationid`, `slotno`, `locationname`, `uid`) VALUES
(22, ' null', '14/1/1970', '23:0', 1234, 1, 4, 'airportroa', '0'),
(23, ' null', '22/1/1970', '4:7', 45556, 1, 2, 'airportroad', '0'),
(24, ' null', '2/1/1970', '12:5', 5555, 2, 4, 'malegoan', 'null'),
(25, ' null', '14/1/1970', '20:33', 4578, 1, 1, 'airportroad', 'null'),
(26, ' null', '2/1/1970', '1:10', 0, 2, 1, 'malegoan', '10'),
(27, ' null', '2/1/1970', '1:20', 12, 1, 1, 'airportroad', '10'),
(28, ' 10', '2/1/1970', '1:5', 11, 1, 1, 'airportroad', '2'),
(29, ' 10', '7/1/1970', '3:10', 11, 1, 2, 'airportroad', '1');

-- --------------------------------------------------------

--
-- Table structure for table `slot`
--

CREATE TABLE `slot` (
  `id` int(10) NOT NULL,
  `location` varchar(20) NOT NULL,
  `nslot` int(10) NOT NULL,
  `longitude` varchar(10) NOT NULL,
  `latitude` varchar(10) NOT NULL,
  `price` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slot`
--

INSERT INTO `slot` (`id`, `location`, `nslot`, `longitude`, `latitude`, `price`) VALUES
(1, 'airportroad', 4, '19.179675', '77.324267', 10),
(2, 'malegoan', 5, '19.104154', '77.318364', 20),
(3, 'qwer', 2, '77.301173', '19.184256', 20),
(4, 'qwe', 2, '1', '77.301173', 19),
(5, 'lkjh', 2, '77.319117', '19.100766', 20);

-- --------------------------------------------------------

--
-- Table structure for table `slotinfo1`
--

CREATE TABLE `slotinfo1` (
  `id` int(11) NOT NULL,
  `locationid` int(11) NOT NULL,
  `slotno` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `location` varchar(10) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slotinfo1`
--

INSERT INTO `slotinfo1` (`id`, `locationid`, `slotno`, `status`, `location`, `price`) VALUES
(1, 1, 1, 1, '', 0),
(2, 1, 2, 1, '', 0),
(3, 1, 3, 2, '', 0),
(4, 1, 4, 0, '', 0),
(5, 2, 1, 0, '', 0),
(6, 2, 2, 0, '', 0),
(7, 2, 3, 2, '', 0),
(8, 2, 4, 1, '', 0),
(9, 2, 5, 1, '', 0),
(10, 4, 1, 0, 'qwe', 0),
(11, 4, 2, 0, 'qwe', 0),
(12, 5, 1, 0, 'lkjh', 20),
(13, 5, 2, 0, 'lkjh', 20);

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `id` int(11) NOT NULL,
  `fullname` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `cno` varchar(10) NOT NULL,
  `vno` varchar(10) NOT NULL,
  `pwd` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`id`, `fullname`, `email`, `cno`, `vno`, `pwd`) VALUES
(1, 'shital', 'ss@gmail.com', '7894561231', '0', '343434'),
(2, 'pranjali', 'pp@gmail.com', '7896543214', '0', '121212'),
(9, 'ghjjkk', 'wyiv@gmail.cpm', '2801493530', 'G19000', 'mmmmmmmmm'),
(10, 'eyug', 'dfg@gjk.vhji', '3737464678', '4679966', '1234567'),
(11, 'sheetalmahagade', 'sheetal@gmail.com', '8983012459', '12123', '22222222');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pay`
--
ALTER TABLE `pay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `slot`
--
ALTER TABLE `slot`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `slotinfo1`
--
ALTER TABLE `slotinfo1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pay`
--
ALTER TABLE `pay`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `slot`
--
ALTER TABLE `slot`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `slotinfo1`
--
ALTER TABLE `slotinfo1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
