-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2016 at 03:58 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_master`
--

CREATE TABLE `admin_master` (
  `adminId` int(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_master`
--

INSERT INTO `admin_master` (`adminId`, `userName`, `password`) VALUES
(6001, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `category_master`
--

CREATE TABLE `category_master` (
  `catId` int(50) NOT NULL,
  `catName` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category_master`
--

INSERT INTO `category_master` (`catId`, `catName`) VALUES
(101, 'Mobiles'),
(102, 'Television'),
(103, 'Tablets'),
(104, 'Laptops'),
(105, 'Cameras');

-- --------------------------------------------------------

--
-- Table structure for table `customer_registration`
--

CREATE TABLE `customer_registration` (
  `custId` int(50) NOT NULL,
  `custName` varchar(100) NOT NULL,
  `addr` varchar(300) NOT NULL,
  `city` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` bigint(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_registration`
--

INSERT INTO `customer_registration` (`custId`, `custName`, `addr`, `city`, `email`, `mobile`, `userName`, `password`) VALUES
(2001, 'kanchan', 'belapur', 'navi mumbai', 'skanchand@gmail.com', 9821336348, 'kanchan', 'kanchan'),
(2003, 'kaushal', 'belapur', 'navi mumbai', 'skanchand@gmail.com', 9821336348, 'kaushal', 'kaushal'),
(2004, 'komal', 'panvel', 'navi mumbai', 'skanchand@gmail.com', 9821336348, 'komal', 'komal'),
(2005, 'avin', 'kalyan', 'thane', 'patilavinrock@gmail.com', 7687654623, 'avin', 'avin'),
(2006, 'parag', 'ghatkopar', 'mumbai', 'parag@gmail.com', 5667654356, 'parag', 'parag'),
(2007, 'patil', 'kalyan', 'navi mumbai', 'avinpatil@gmail.com', 9821336348, 'patil', 'patil');

-- --------------------------------------------------------

--
-- Table structure for table `item_master`
--

CREATE TABLE `item_master` (
  `itemId` int(50) NOT NULL,
  `catId` int(50) NOT NULL,
  `itemName` varchar(200) NOT NULL,
  `catName` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `stocks` int(50) NOT NULL,
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_master`
--

INSERT INTO `item_master` (`itemId`, `catId`, `itemName`, `catName`, `description`, `price`, `total`, `stocks`, `image`) VALUES
(2, 1, 'gfg', 'xdfg', 'fddd', 545, 543456, 54564, '');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `itemId` int(30) NOT NULL,
  `catId` int(50) NOT NULL,
  `itemName` varchar(500) NOT NULL,
  `catName` varchar(100) NOT NULL,
  `description` varchar(700) NOT NULL,
  `price` float NOT NULL,
  `stocks` int(50) NOT NULL,
  `image` varchar(700) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`itemId`, `catId`, `itemName`, `catName`, `description`, `price`, `stocks`, `image`) VALUES
(1001, 101, 'SAMSUNG Galaxy J7 - 6 (New 2016 Edition) ', 'Mobiles', '1)5.5 inch Super AMOLED  Capacitive HD Touchscreen\r\n2)2GB RAM|16 GB ROM\r\n3)13 MP Primary Camera\r\n4)5 MP Secondary Camera\r\n5)1.6 GHz S5E7870 (Exynos 7870) Octa Core Processor\r\n6)3300 mAh Battery\r\n7)Android v6 (Marshmallow) OS\r\n', 20000, 10, 'images/samsung-galaxy-j7-6(New 2016 Edition).jpeg'),
(1002, 101, 'SAMSUNG Galaxy J5 - 6 (New 2016 Edition) ', 'Mobiles', '1)5.2 inch Super AMOLED Capacitive HD Touchscreen\r\n2)2GB RAM|16 GB ROM\r\n3)13 MP Primary Camera\r\n4)5 MP Secondary Camera\r\n5)1.2 GHz Qualcomm MSM8916 Quad Core Processor\r\n6)3100 mAh Battery\r\n7)Android v6 (Marshmallow) OS\r\n', 23000, 50, 'images/samsung-galaxy-j5-6(New 2016 Edition).jpeg'),
(1003, 101, 'SAMSUNG Galaxy Note 4 ', 'Mobiles', '1)Expandable Storage Capacity of 128 GB2)5.7 inch Super AMOLED Touchscreen3)LTE Cat 6 (300 / 50 Mbps)4)16 MP Primary Camera5)2.7 GHz Quad Core Processor6)3.7 MP Secondary Camera7)Android v4.4 (KitKat) OS', 45000, 16, ''),
(1004, 101, 'Tata indicom', 'Mobiles', '1) CDMA with single sim card. 2) with FM and messaging feature', 1500, 45, ''),
(1006, 101, 'Lenovo Vibe K5 Plus Dark Grey 16 GB ', 'Mobiles', '1)5 inch Full HD Capacitive Touchscreen\r\n2)1.5 GHz Qualcomm Snapdragon 616 Octa Core Processor\r\n3)Dolby Atmos Dual Stereo Speakers\r\n4)Android v5.1 (Lollipop) OS\r\n5)13 MP Primary Camera\r\n6)5 MP Secondary Camera\r\n7)Dual Standby Sim (LTE + LTE)\r\n8)Expandable Storage Capacity of 32 GB\r\n9)TheaterMax Support\r\n', 13000, 23, 'images/lenovo-vibe-k5-plus-Dark grey 16 GB.jpeg'),
(1007, 101, 'Apple iPhone 5S Space Grey 16 GB ', 'Mobiles', '1)Up to 56x Faster GPU than the Original iPhone\r\n2)Ultra-fast Wireless\r\n3)Up to 40x Faster CPU than the Original iPhone\r\n4)8 MP iSight Camera with 15% Large Images Sensor and Aperture of f/2.2\r\n5)Touch ID: New Fingerprint Identity Sensor\r\n6)1.2 MP FaceTime HD Camera\r\n', 62000, 21, 'images/apple-iphone-5s-Space Grey 16 GB.jpeg'),
(1008, 101, 'Apple iPhone 6S Plus Gold 16 GB ', 'Mobiles', '1)5.5 inch Touchscreen\r\n2)Bluetooth Support\r\n3)iOS 9\r\n4)5 MP Secondary Camera\r\n5)Wi-Fi Enabled\r\n6)12 MP Primary Camera\r\n7)3D Touch & Live Photos\r\n', 70000, 12, 'images/apple-iphone-6s-plus Gold 16 Gb.jpeg'),
(1009, 102, 'Mi Pad ', 'Tablets', '1)7.9 inch IPS (2048x1536) Display\r\n2)2 GB RAM\r\n3)8 MP Primary Camera\r\n4)5 MP Secondary Camera\r\n5)Android v4.4.4 (KitKat) OS\r\n6)2.2 GHz NVIDIA Tegra K1 ARM Cortex-A15 Quad Core Processor\r\n7)Expandable Storage Capacity of 128 GB\r\n', 13000, 2, 'images/mi-mi-pad-400x400-imaej3nkn9gdhzmx.jpeg'),
(1010, 102, 'Lenovo PHAB 16 GB 6.98 inch with Wi-Fi+4G', 'Tablets', '1)Android v5.1 (Lollipop) OS\r\n2)13 MP Primary Camera\r\n3)5 MP Secondary Camera\r\n4)6.98 inch Touchscreen\r\n5)1.2 GHz Qualcomm MSM8916 Quad Core 64-bit Processor\r\n6)Wi-Fi Enabled\r\n7)Expandable Storage Capacity of 64 GB\r\n', 22000, 3, 'images/lenovo-pb1-750m-400x400-imaehpgqth3q9rtn.jpeg'),
(1011, 102, 'Micromax Canvas P680 Tablet 16 GB 8 inch with Wi-Fi+3G', 'Tablets', '1)Android v5 (Lollipop) OS\r\n2)5 MP Primary Camera\r\n3)2 MP Secondary Camera\r\n4)8 inch Touchscreen\r\n5)1.3 GHz Mediatek MT8382 Quad Core Processor\r\n6)Wi-Fi Enabled\r\n7)Expandable Storage Capacity of 32 GB\r\n', 17599, 3, 'images/micromax-p680-400x400-imaeewb3c3hfcsyw.jpeg'),
(1012, 102, 'HP 7 Voice Tab ', 'Tablets', '1)0.3 MP Secondary Camera\r\n2)Wi-Fi Enabled\r\n3)7 inch LCD Touchscreen\r\n4)Android v4.4.2 (KitKat) OS\r\n5)5 MP Primary Camera\r\n6)1.3 GHz MT8382 ARM Cortex A7 Quad Core Processor\r\n7)Expandable Storage Capacity of 32 GB\r\n', 46000, 12, 'images/hp-7-voice-tab-400x400-imaeykp5fwychhhg.jpeg'),
(1013, 102, 'Apple iPad Air 2 Wi-Fi 64 GB Tablet', 'Tablets', '1)1.2 MP Secondary Camera\r\n2)A8X Chip with M8 Motion Co-processor\r\n3)9.7 inch Touchscreen\r\n4)Full HD Recording\r\n5)8 MP Primary Camera\r\n6)Wi-Fi Enabled\r\n', 75000, 4, 'images/apple-ipad-air-2-wi-fi-64-gb-400x400-imae22b2jkvujnun.jpeg'),
(1014, 103, 'HP AC 15-AC122TU core i3 (5th Gen) - (4 GB/1 TB HDD/Free DOS/128 MB Graphics) Notebook N8M18PA (15.6 inch, Grey, 2.2 kg) Price: Rs. 25,990 ', 'Laptops', '1)i3 5th gen, 4GB/1TB, Grey\r\n2)Included Software	FREE DOS 2.0 \r\n3)Display\r\nResolution	1366 x 768 pixel \r\nScreen Size	15.6 inch \r\nScreen Type	HD BrightView WLED-backlit \r\n4)Color Grey\r\n', 25990, 23, 'images/hp-af-notebook-400x400-imaeb8b3hvtjb7ub.jpeg'),
(1015, 103, 'Acer One 10 S1001-19p0 Intel Atom Quad Core - (2 GB/32 GB EMMC Storage/Windows 10) 2 in 1 Laptop NT.G86SI.002', 'Laptops', '1)Detachable keyboard\r\n2)HD Multi Finger Touch Display\r\n3)Dual Stereo Speakers\r\n4)Windows 10 OS\r\n', 45000, 3, 'images/acer-2-in-1-laptop-400x400-imaejpp8su6ncwum.jpeg'),
(1016, 103, 'Dell Inspiron 3558 Core i3 (5th Gen) - (4 GB/500 GB HDD/Windows 10) Notebook Z565104HIN9 ', 'Laptops', '1)Core i3 (5th Gen)\r\n2)4 GB RAM\r\n3)500 GB HDD\r\n4)Windows 10\r\n', 55000, 6, 'images/dell-inspiron-notebook-400x400-imaejv8vpngabbzf.jpeg'),
(1017, 103, 'Lenovo G50-80 Core i5 (5th Gen) - (8 GB/1 TB HDD/Free DOS/2 GB Graphics) Notebook 80E503CMIH', 'Laptops', '1)Core i5 (5th Gen)\r\n2)8 GB RAM\r\n3)1 TB HDD\r\n4)Free DOS\r\n', 27000, 0, 'images/lenovo-notebook-400x400-imaehffsv8j65jd6.jpeg'),
(1018, 103, 'HP AC SERIES 15-AC184TU Intel Core i3 (5th Gen) - (4 GB/1 TB HDD/Free DOS) Notebook T0X61PA ', 'Laptops', '1)DTS Studio Sound\r\n2)LED Backlit Widescreen display\r\n3)DOS Operating System\r\n4)Textured Island Style Keyboard\r\n', 33000, 4, 'images/hp-notebook-400x400-imaecfg3c5udctgy.jpeg'),
(1019, 105, 'Micromax 81cm (32) HD Ready LED TV', 'Television', '1)LED Display\r\n2)81 cm (32)\r\n3)HD Ready, 1366 x 768\r\n4)1 x HDMI, 1 x USB\r\n5)Refresh Rate - 60\r\n', 45000, 6, 'images/micromax-32t7260hd-400x400-imae73gygbqgv8gf.jpeg'),
(1020, 105, 'Panasonic 109cm (43) Full HD Smart LED TV', 'Television', '1)LED Display\r\n2)109 cm (43)\r\n3)Full HD, 1920 x 1080\r\n4)Smart TV\r\n5)3 x HDMI, 2 x USB\r\n6)Built-in Wi-Fi, Ethernet\r\n7)Refresh Rate - 100\r\n', 55000, 7, 'images/panasonic-th-43cs400dx-400x400-imaegnkrsbxgugyh.jpeg'),
(1021, 105, 'LG 108cm (43) Full HD LED TV', 'Television', '1)LED Display\r\n2)108 cm (43)\r\n3)Full HD, 1920 x 1080\r\n4)2 x HDMI, 1 x USB\r\n5)Refresh Rate - 300\r\n', 62000, 0, 'images/lg-43lf540a-400x400-imae8uqzdsmjrrmb.jpeg'),
(1022, 105, 'BPL Vivid 80cm (32) HD Ready LED TV', 'Television', '1)LED Display\r\n2)80 cm (32)\r\n3)HD Ready, 1366 x 768\r\n4)2 x HDMI, 2 x USB\r\n5)Refresh Rate - 60\r\n', 26000, 0, 'images/bpl-bpl080d51h-400x400-imaekd4kj5z4swb6.jpeg'),
(1023, 105, 'Sony 80cm (32) HD Ready LED TV', 'Television', '1)LED Display\r\n2)80 cm (32)\r\n3)HD Ready, 1366 x 768\r\n4)2 x HDMI, 1 x USB\r\n5)Refresh Rate - 100\r\n', 67000, 14, 'images/sony-klv-32r302d-bravia-klv-32r302d-400x400-imaejeszztkpadnh.jpeg'),
(1024, 106, 'Canon EOS 1200D (Kit with 8 GB Card & Bag EF S18-55 IS II+55-250mm IS II) DSLR Camera', 'Cameras', '1)18 Megapixel Camera\r\n2)Full HD Recording\r\n3)CMOS Image Sensor\r\n4)3 inch TFT LCD Screen\r\n5)ISO 100 - 6400\r\n6)f/3.5 - f/5.6\r\n', 44000, 5, 'images/canon-eos-1200D(kit with 8gb card Bag Ef s18-5s IS II)DSLR  CAMERA.jpeg'),
(1025, 106, 'Nikon D3300 (Body with 18-55 mm VR II Kit Lens) DSLR Camera', 'Cameras', '1)24.2 Megapixel Camera\r\n2)CMOS Image Sensor\r\n3)Full HD Recording\r\n4)3 inch TFT LCD\r\n5)ISO 200 - ISO 6400 Sensitivity\r\n6)f/3.5 - f/5.6 Aperture\r\n', 55000, 2, 'images/Nikon D3200 (Body ) DSLR Camera.jpeg'),
(1026, 106, 'Nikon Coolpix L340 Point & Shoot Camera', 'Cameras', '1)20.2 Megapixels Camera\r\n2)f/3.1 - f/5.9 Aperture\r\n3)CCD Image Sensor\r\n4)USB Support\r\n5)3 inch HVGA TFT LCD Screen\r\n6)ISO 80 - 1600\r\n', 10000, 6, 'images/Nikon Coolpix L340 Point & Shoot Camera.jpeg'),
(1027, 106, 'Sony Cyber-shot DSC-W830/VC Point & Shoot Camera', 'Cameras', '1)20.1 Megapixels Camera\r\n2)ISO 80 - 3200 (Auto)\r\n3)HAD CCD Sensor\r\n4)HD Recording\r\n5)2.7 inch TFT LCD Screen\r\n6)f/3.3 - f/8.0 Aperture\r\n', 17499, 0, 'images/sony-cyber-shot-dsc-w830-point-shoot-400x400-imadthtyr9dg3gn7.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart`
--

CREATE TABLE `shopping_cart` (
  `cartId` int(50) NOT NULL,
  `custId` int(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `quantity` int(50) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `orderDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart_final`
--

CREATE TABLE `shopping_cart_final` (
  `cartId` int(50) NOT NULL,
  `custId` int(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `quantity` int(50) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `orderDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopping_cart_final`
--

INSERT INTO `shopping_cart_final` (`cartId`, `custId`, `userName`, `email`, `itemName`, `quantity`, `price`, `total`, `orderDate`) VALUES
(43, 2005, 'avin', 'patilavinrock@gmail.com', 'Dell Inspiron 3558 Core i3 (5th Gen) - (4 GB/500 GB HDD/Windows 10) Notebook Z565104HIN9 ', 1, 55000, 55000, '2016-10-04'),
(44, 2005, 'avin', 'patilavinrock@gmail.com', 'Nikon D3300 (Body with 18-55 mm VR II Kit Lens) DSLR Camera', 1, 55000, 55000, '2016-10-04'),
(45, 2005, 'avin', 'patilavinrock@gmail.com', 'Dell Inspiron 3558 Core i3 (5th Gen) - (4 GB/500 GB HDD/Windows 10) Notebook Z565104HIN9 ', 1, 55000, 55000, '2016-10-04'),
(46, 2005, 'avin', 'patilavinrock@gmail.com', 'Nikon D3300 (Body with 18-55 mm VR II Kit Lens) DSLR Camera', 1, 55000, 55000, '2016-10-04'),
(47, 2005, 'avin', 'patilavinrock@gmail.com', 'Apple iPhone 5S Space Grey 16 GB ', 1, 62000, 62000, '2016-10-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_master`
--
ALTER TABLE `admin_master`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `category_master`
--
ALTER TABLE `category_master`
  ADD PRIMARY KEY (`catId`);

--
-- Indexes for table `customer_registration`
--
ALTER TABLE `customer_registration`
  ADD PRIMARY KEY (`custId`);

--
-- Indexes for table `item_master`
--
ALTER TABLE `item_master`
  ADD PRIMARY KEY (`itemId`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`itemId`);

--
-- Indexes for table `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD PRIMARY KEY (`cartId`);

--
-- Indexes for table `shopping_cart_final`
--
ALTER TABLE `shopping_cart_final`
  ADD PRIMARY KEY (`cartId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_master`
--
ALTER TABLE `admin_master`
  MODIFY `adminId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6002;
--
-- AUTO_INCREMENT for table `category_master`
--
ALTER TABLE `category_master`
  MODIFY `catId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;
--
-- AUTO_INCREMENT for table `customer_registration`
--
ALTER TABLE `customer_registration`
  MODIFY `custId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2008;
--
-- AUTO_INCREMENT for table `item_master`
--
ALTER TABLE `item_master`
  MODIFY `itemId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `itemId` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1040;
--
-- AUTO_INCREMENT for table `shopping_cart`
--
ALTER TABLE `shopping_cart`
  MODIFY `cartId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `shopping_cart_final`
--
ALTER TABLE `shopping_cart_final`
  MODIFY `cartId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
