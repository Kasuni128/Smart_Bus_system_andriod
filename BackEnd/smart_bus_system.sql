-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2021 at 06:45 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smart_bus_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus_info`
--

CREATE TABLE `bus_info` (
  `tb_id` int(11) NOT NULL COMMENT 'to identify uniquely each bus  ',
  `bus_name` varchar(70) NOT NULL,
  `bus_no` varchar(70) NOT NULL,
  `bus_condtions` enum('Ac','Non-Ac') NOT NULL,
  `bus_contact_number` int(10) NOT NULL,
  `bus_avb_seats` varchar(70) NOT NULL,
  `bus_img_path` text NOT NULL,
  `isCompleteRoute` enum('Complete','Not-Complete') NOT NULL,
  `route_id` int(70) NOT NULL,
  `time_id` int(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bus_info`
--

INSERT INTO `bus_info` (`tb_id`, `bus_name`, `bus_no`, `bus_condtions`, `bus_contact_number`, `bus_avb_seats`, `bus_img_path`, `isCompleteRoute`, `route_id`, `time_id`) VALUES
(1, 'abc', '123', 'Ac', 12312312, '10', 'http://192.168.1.13/Smart_Bus_Systems/Image/Bus/2.jpg', 'Complete', 1, 1),
(2, 'asd', 'asdasw42', 'Non-Ac', 342342312, '23', 'http://192.168.1.13/Smart_Bus_Systems/Image/Bus/2.jpg', 'Not-Complete', 1, 2),
(3, 'ghjghj', '2342', 'Ac', 452, '30', 'http://192.168.1.13/Smart_Bus_Systems/Image/Bus/3.jpg', 'Not-Complete', 1, 3),
(4, 'sdgs', 'sfds', 'Ac', 12312312, '', '', 'Not-Complete', 1, 4),
(5, 'gcvbc', '54', 'Non-Ac', 12312312, '', '', 'Not-Complete', 1, 5),
(6, 'dfsdf', '43535', 'Non-Ac', 12312312, '', '', 'Not-Complete', 1, 6),
(7, 'bxvb', '3463xx', 'Non-Ac', 12312312, '', '', 'Not-Complete', 2, 7),
(8, 'abc', '123', 'Ac', 12312312, '', 'http://192.168.1.13/Smart_Bus_Systems/Image/Bus/2.jpg', 'Not-Complete', 1, 1),
(9, 'cxvxcv', '546xcv', 'Ac', 12312312, '', '', 'Not-Complete', 1, 2),
(10, 'bn,mbnm', '45645 ', 'Non-Ac', 12312312, '', '', 'Not-Complete', 1, 3),
(11, 'abc', '123', 'Non-Ac', 12312312, '', 'http://192.168.1.13/Smart_Bus_Systems/Image/Bus/2.jpg', 'Not-Complete', 1, 4),
(12, 'sdfsdf', 'sdfsd', 'Non-Ac', 12312312, '', '', 'Not-Complete', 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `route_info`
--

CREATE TABLE `route_info` (
  `route_id` int(11) NOT NULL,
  `start_point` varchar(70) NOT NULL,
  `end_point` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `route_info`
--

INSERT INTO `route_info` (`route_id`, `start_point`, `end_point`) VALUES
(1, 'Kaduwela', 'Malabe'),
(2, 'Homgama', 'Kaduwela'),
(3, 'Kalaniya', 'Kadawatha');

-- --------------------------------------------------------

--
-- Table structure for table `time_table`
--

CREATE TABLE `time_table` (
  `time_id` int(11) NOT NULL,
  `start_time` varchar(70) NOT NULL,
  `end_time` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `time_table`
--

INSERT INTO `time_table` (`time_id`, `start_time`, `end_time`) VALUES
(1, '10:00 AM', '10:30 AM'),
(2, '11:00 AM', '11:30 AM'),
(3, '12:00', '12:30 PM'),
(4, '12:30', '1:00 PM'),
(5, '1:00', '1:30 PM'),
(6, '1:30', '2:00 PM'),
(7, '2:00', '2:30 PM');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` int(50) NOT NULL,
  `name` varchar(70) NOT NULL,
  `email` varchar(70) NOT NULL,
  `uname` varchar(70) NOT NULL,
  `password` text NOT NULL,
  `contact` varchar(10) NOT NULL,
  `image_path` text NOT NULL,
  `state` enum('active','inactive') NOT NULL,
  `utype` enum('user','driver','time_keeper','admin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `name`, `email`, `uname`, `password`, `contact`, `image_path`, `state`, `utype`) VALUES
(1, 'ruwan', 'ruwan@gmail.com', 'ruwan', '123', '977453412', '', 'active', 'driver'),
(2, 'kamal ', 'kamal@gmai.com', 'kamal', '123456', '977453412', '', 'active', 'time_keeper');

-- --------------------------------------------------------

--
-- Table structure for table `user_types`
--

CREATE TABLE `user_types` (
  `tb_id` int(70) NOT NULL,
  `uid` int(70) NOT NULL,
  `bus_number` varchar(80) NOT NULL,
  `route_id` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_types`
--

INSERT INTO `user_types` (`tb_id`, `uid`, `bus_number`, `route_id`) VALUES
(1, 1, '123', '0'),
(2, 2, '0', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus_info`
--
ALTER TABLE `bus_info`
  ADD PRIMARY KEY (`tb_id`);

--
-- Indexes for table `route_info`
--
ALTER TABLE `route_info`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `time_table`
--
ALTER TABLE `time_table`
  ADD PRIMARY KEY (`time_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `user_types`
--
ALTER TABLE `user_types`
  ADD PRIMARY KEY (`tb_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus_info`
--
ALTER TABLE `bus_info`
  MODIFY `tb_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'to identify uniquely each bus  ', AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `route_info`
--
ALTER TABLE `route_info`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `time_table`
--
ALTER TABLE `time_table`
  MODIFY `time_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_types`
--
ALTER TABLE `user_types`
  MODIFY `tb_id` int(70) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
