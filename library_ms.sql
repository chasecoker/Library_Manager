-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Oct 20, 2022 at 06:54 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(250) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `quantity`) VALUES
(1, 'Java Advanced', 'Unknown', 6),
(2, 'Java Basics', 'Unknown', 4),
(3, 'Flask Web Development', 'Miguel Grinberg', 5),
(4, 'SpringBoot Basics', 'Unknown', 2),
(5, 'Intro to C#', 'Unknown', 5),
(6, 'PHP Web Development', 'Unknown', 4),
(7, 'MySQL', 'Unknown', 9),
(8, 'Data Structures', 'Unknown', 4);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(150) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(1, 3, 'Flask Web Development', 1, 'Chase', '2022-09-07', '2022-09-12', 'returned'),
(4, 3, 'Flask Web Development', 2, 'Paul', '2022-09-07', '2022-09-12', 'returned'),
(5, 1, 'Java Advanced', 3, 'Kate', '2022-09-07', '2022-09-05', 'returned'),
(7, 1, 'Java Advanced', 1, 'Chase', '2022-09-10', '2022-09-15', 'returned'),
(8, 1, 'Java Advanced', 2, 'Paul', '2022-09-07', '2022-09-09', 'returned'),
(9, 4, 'SpringBoot Basics', 1, 'Chase', '2022-09-14', '2022-09-21', 'pending'),
(10, 2, 'Java Basics', 3, 'Kate', '2022-09-14', '2022-09-19', 'pending'),
(11, 5, 'Intro to C#', 2, 'Paul', '2022-09-14', '2022-09-18', 'pending'),
(12, 6, 'PHP Web Development', 2, 'Paul', '2022-09-14', '2022-09-17', 'pending'),
(13, 7, 'MySQL', 2, 'Paul', '2022-09-14', '2022-09-16', 'pending'),
(14, 7, 'MySQL', 1, 'Chase', '2022-10-15', '2022-10-17', 'returned'),
(15, 5, 'Intro to C#', 3, 'Kate', '2022-10-05', '2022-10-20', 'pending'),
(16, 7, 'MySQL', 3, 'Kate', '2022-10-15', '2022-10-18', 'pending'),
(17, 3, 'Flask Web Development', 2, 'Paul', '2022-10-15', '2022-10-23', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `course` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `name`, `course`, `branch`) VALUES
(1, 'Chase', 'Java', 'CS'),
(2, 'Paul', 'BSC', 'IT'),
(3, 'Kate', 'MSC', 'ELECTRONICS');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(1, 'chasewavez', 'password1', 'chasewavez@gmail.com', '2102627274'),
(2, 'katewavez', 'password2', 'katewavez@gmail.com', '2106727913'),
(3, 'test', 'test', 'test@gmail.com', '1111111111'),
(4, 'tracie', 'password', 'rhaohrfal@fjal.com', '2102033646');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_details`
--
ALTER TABLE `book_details`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
