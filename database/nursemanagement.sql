-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3306
-- 產生時間： 2022-11-15 03:47:43
-- 伺服器版本： 5.7.24
-- PHP 版本： 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `nursemanagement`
--

-- --------------------------------------------------------

--
-- 資料表結構 `nurse`
--

CREATE TABLE `nurse` (
  `empID` int(11) NOT NULL,
  `empName` varchar(20) NOT NULL,
  `changetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `nurse`
--

INSERT INTO `nurse` (`empID`, `empName`, `changetime`) VALUES
(1, '陳宇彤', '2022-11-15 11:43:10');

-- --------------------------------------------------------

--
-- 資料表結構 `nursesite`
--

CREATE TABLE `nursesite` (
  `empID` int(11) NOT NULL,
  `siteID` int(11) NOT NULL,
  `addtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `nursesite`
--

INSERT INTO `nursesite` (`empID`, `siteID`, `addtime`) VALUES
(1, 1, '2022-11-15 11:43:10');

-- --------------------------------------------------------

--
-- 資料表結構 `site`
--

CREATE TABLE `site` (
  `siteID` int(11) NOT NULL,
  `siteName` varchar(20) NOT NULL,
  `changetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `site`
--

INSERT INTO `site` (`siteID`, `siteName`, `changetime`) VALUES
(1, '門診', '2022-11-15 11:41:18'),
(2, '急診', '2022-11-15 11:41:22');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`empID`);

--
-- 資料表索引 `nursesite`
--
ALTER TABLE `nursesite`
  ADD PRIMARY KEY (`empID`,`siteID`),
  ADD UNIQUE KEY `empID` (`empID`,`siteID`),
  ADD KEY `nursesite_siteid` (`siteID`);

--
-- 資料表索引 `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`siteID`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `nurse`
--
ALTER TABLE `nurse`
  MODIFY `empID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `site`
--
ALTER TABLE `site`
  MODIFY `siteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `nursesite`
--
ALTER TABLE `nursesite`
  ADD CONSTRAINT `nursesite_empid` FOREIGN KEY (`empID`) REFERENCES `nurse` (`empID`),
  ADD CONSTRAINT `nursesite_siteid` FOREIGN KEY (`siteID`) REFERENCES `site` (`siteID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
