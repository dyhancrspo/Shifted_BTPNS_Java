-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2020 at 08:13 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jpamahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(23);

-- --------------------------------------------------------

--
-- Table structure for table `my_mhs`
--

CREATE TABLE `my_mhs` (
  `id` bigint(20) NOT NULL,
  `absensi` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `my_mhs`
--

INSERT INTO `my_mhs` (`id`, `absensi`, `address`, `fullname`, `status`) VALUES
(1, 1, 'Jakarta', 'Soleh Said', 'Active'),
(2, 3, 'Lombok', 'Susi Astutipudji', 'Non Active'),
(3, 2, 'Bandung', 'Ridwan Jamil', 'Active'),
(4, 1, 'Solo', 'Jojo Wikoko', 'Active'),
(5, 1, 'Jakarta', 'Nadiem Jakariem', 'Active'),
(6, 3, 'Jakarata', 'Erick Mahir', 'Active'),
(20, 0, 'Bekasi', 'Dummy 99', 'Non Active'),
(21, 0, 'Bekasi', 'Dummy 21', 'Non Active'),
(22, 0, 'Lombok', 'Jaenab', 'Non Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `my_mhs`
--
ALTER TABLE `my_mhs`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
