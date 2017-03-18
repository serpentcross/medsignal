-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2017 at 01:01 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `zipcode` varchar(8) DEFAULT NULL,
  `country` int(11) NOT NULL,
  `region` int(11) NOT NULL,
  `city` int(11) NOT NULL,
  `street` varchar(220) NOT NULL,
  `building` int(11) DEFAULT NULL,
  `house` int(11) NOT NULL,
  `flat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `zipcode`, `country`, `region`, `city`, `street`, `building`, `house`, `flat`) VALUES
(1, '119313', 1, 7, 7, 'Улица Гоголя', 2, 3, 4),
(2, '34324', 2, 2, 2, 'Площадь восстания', 1, 3, 6),
(3, '18225', 3, 6, 6, 'Проспект ленина', 6, 3, 10),
(4, '99123', 1, 8, 8, 'Аллея Панкратова', 3, 7, 1),
(5, '436211', 3, 4, 4, 'Бульвар Филиппова', 12, 3, 9);

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `code`, `name`) VALUES
(2, 7347, 'Уфа'),
(1, 7499, 'Москва'),
(3, 7843, 'Казань'),
(7, 37517, 'Минск'),
(5, 38032, 'Львов'),
(4, 38044, 'Киев'),
(8, 375212, 'Витебск'),
(9, 375232, 'Гомель'),
(6, 380412, 'Житомир');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `code`, `name`) VALUES
(1, 112, 'Белоруссия'),
(2, 643, 'Россия'),
(3, 804, 'Украина');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `frst_name` varchar(250) NOT NULL,
  `midd_name` varchar(250) DEFAULT NULL,
  `last_name` varchar(250) DEFAULT NULL,
  `email` varchar(250) NOT NULL,
  `phone` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `frst_name`, `midd_name`, `last_name`, `email`, `phone`) VALUES
(1, 'Владимир', 'Ильич', 'Ленин', 'test1@mail.ru', '+79015674783'),
(2, 'Леонид', 'Ильич', 'Брежнев', 'test2@mail.ru', '+79010297783'),
(3, 'Иосиф', 'Виссарионович', 'Сталин', 'test1@mai3.ru', '+79049918383'),
(4, 'Никита', 'Сергеевич', 'Хрущёв', 'test4@mail.ru', '+79225698123'),
(5, 'Юрий', 'Владимирович', 'Андропов', 'test5@mail.ru', '+79825003813'),
(6, 'Михаил', 'Горбачёв', 'Сергеевич', 'test6@mail.ru', '+79065753283');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `artikul` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `name`, `price`, `description`, `artikul`) VALUES
(1, 'Браслет1', 200, 'Браслет из стали', 'MS-48730'),
(2, 'Браслет2', 250, 'Браслет из кожи', 'MS-48730'),
(3, 'Браслет3', 150, 'Браслет из стали', 'MS-48730'),
(4, 'Браслет4', 350, 'Браслет из кожи', 'MS-48730');

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE `region` (
  `id` int(11) NOT NULL,
  `code` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`id`, `code`, `name`) VALUES
(8, 2, 'Витебская область'),
(2, 2, 'Республика Башкортостан'),
(9, 3, 'Гомельская область'),
(7, 5, 'Минская область'),
(6, 6, 'Житомирская область'),
(4, 10, 'Киевская область'),
(5, 14, 'Львовская область'),
(3, 16, 'Республика Татарстан'),
(1, 77, 'Москва');

-- --------------------------------------------------------

--
-- Table structure for table `shoporder`
--

CREATE TABLE `shoporder` (
  `id` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  `address` int(11) NOT NULL,
  `order_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shoporder`
--

INSERT INTO `shoporder` (`id`, `customer`, `address`, `order_date`) VALUES
(1, 1, 1, '2017-03-06'),
(2, 1, 1, '2017-03-08'),
(3, 2, 3, '2017-03-24'),
(4, 3, 4, '2017-03-05');

-- --------------------------------------------------------

--
-- Table structure for table `shoporder_item`
--

CREATE TABLE `shoporder_item` (
  `id` int(11) NOT NULL,
  `shoporder` int(11) NOT NULL,
  `item` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shoporder_item`
--

INSERT INTO `shoporder_item` (`id`, `shoporder`, `item`, `quantity`) VALUES
(1, 1, 1, 3),
(2, 1, 2, 4),
(3, 2, 3, 1),
(4, 3, 4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `address_ix1` (`country`,`region`,`city`),
  ADD UNIQUE KEY `address_ix2` (`zipcode`,`city`,`street`,`building`,`house`,`flat`),
  ADD KEY `address_fk2` (`region`),
  ADD KEY `address_fk3` (`city`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `city_ix1` (`code`,`name`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `country_ix1` (`code`,`name`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `customer_ix1` (`frst_name`,`midd_name`,`last_name`),
  ADD UNIQUE KEY `customer_ix2` (`frst_name`,`midd_name`,`email`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `item_ix1` (`name`,`artikul`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `region_ix1` (`code`,`name`);

--
-- Indexes for table `shoporder`
--
ALTER TABLE `shoporder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shoporder_fk1` (`customer`),
  ADD KEY `shoporder_fk2` (`address`);

--
-- Indexes for table `shoporder_item`
--
ALTER TABLE `shoporder_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shoporderitem_fk1` (`shoporder`),
  ADD KEY `shoporderitem_fk2` (`item`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `shoporder`
--
ALTER TABLE `shoporder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `shoporder_item`
--
ALTER TABLE `shoporder_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_fk1` FOREIGN KEY (`country`) REFERENCES `country` (`id`),
  ADD CONSTRAINT `address_fk2` FOREIGN KEY (`region`) REFERENCES `region` (`id`),
  ADD CONSTRAINT `address_fk3` FOREIGN KEY (`city`) REFERENCES `city` (`id`);

--
-- Constraints for table `shoporder`
--
ALTER TABLE `shoporder`
  ADD CONSTRAINT `shoporder_fk1` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `shoporder_fk2` FOREIGN KEY (`address`) REFERENCES `address` (`id`);

--
-- Constraints for table `shoporder_item`
--
ALTER TABLE `shoporder_item`
  ADD CONSTRAINT `shoporderitem_fk1` FOREIGN KEY (`shoporder`) REFERENCES `shoporder` (`id`),
  ADD CONSTRAINT `shoporderitem_fk2` FOREIGN KEY (`item`) REFERENCES `item` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
