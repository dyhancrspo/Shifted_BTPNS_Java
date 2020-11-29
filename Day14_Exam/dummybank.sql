-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2020 at 01:47 PM
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
-- Database: `dummybank`
--

-- --------------------------------------------------------

--
-- Table structure for table `datanasabah`
--

CREATE TABLE `datanasabah` (
  `id` bigint(20) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `isLogin` tinyint(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datanasabah`
--

INSERT INTO `datanasabah` (`id`, `fullname`, `isLogin`, `password`, `phonenumber`, `status`, `username`) VALUES
(1, 'Jojo Wikoko', 0, 'RInomor1', '081100001111', 'Active', 'maspresiden@indohebat.co.id'),
(2, 'Prabowo Sukianto', 0, 'superdeffense007', '082200003333', 'Active', 'deffensiveline@indohebat.co.id'),
(3, 'Ridwan Jamils', 0, 'parisvanjava77', '087700770077', 'Non Active', 'rdwanjamil@bandungzzz.co.id'),
(4, 'Manies Basewedan', 1, 'superdkijakarta1', '08667755664', 'Active', 'nies@gmail.com'),
(5, 'Sri Malyuni', 0, 'moneygold666', '08666111000', 'Active', 'srimul@menkeu.co.xyz'),
(6, 'Mahfud D.M', 0, 'King0FL4W', '081100110011', 'Active', 'dmfud@superlaw.co.id');

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
(8);

-- --------------------------------------------------------

--
-- Table structure for table `nasabahbalance`
--

CREATE TABLE `nasabahbalance` (
  `id` int(8) NOT NULL,
  `balance` int(20) NOT NULL,
  `idNsb` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nasabahbalance`
--

INSERT INTO `nasabahbalance` (`id`, `balance`, `idNsb`) VALUES
(1, 10000000, 1),
(2, 55750000, 2),
(3, 1250000, 5),
(4, 5350450, 6),
(5, 51246800, 3),
(6, 76500201, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datanasabah`
--
ALTER TABLE `datanasabah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nasabahbalance`
--
ALTER TABLE `nasabahbalance`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nasabahbalance`
--
ALTER TABLE `nasabahbalance`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
