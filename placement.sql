-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2017 at 11:03 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `placement`
--

-- --------------------------------------------------------

--
-- Table structure for table `application_details`
--

CREATE TABLE `application_details` (
  `user_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category_table`
--

CREATE TABLE `category_table` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employer`
--

CREATE TABLE `employer` (
  `email_id` varchar(45) DEFAULT NULL,
  `company_name` varchar(80) NOT NULL,
  `department` varchar(80) DEFAULT NULL,
  `emp_id` int(11) NOT NULL,
  `comp_address` varchar(200) DEFAULT NULL,
  `comp_website` varchar(200) DEFAULT NULL,
  `comp_zip` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `job_postings`
--

CREATE TABLE `job_postings` (
  `job_id` int(11) NOT NULL,
  `emp_id` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `job_title` varchar(150) NOT NULL,
  `job_description` varchar(500) DEFAULT NULL,
  `deadline` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_postings`
--

INSERT INTO `job_postings` (`job_id`, `emp_id`, `company_name`, `location`, `job_title`, `job_description`, `deadline`) VALUES
(1, 'manohar@gmail.com', 'Solutions', 'Dallas', 'Software Developer', 'Java, Python', '2017-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `email_id` varchar(50) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin_status` int(11) DEFAULT '0',
  `member_type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`email_id`, `first_name`, `last_name`, `password`, `admin_status`, `member_type`) VALUES
('kmreddyhyd@gmail.com', 'Manohar', 'Katam', 'qwerty', 0, 'Applicant'),
('manohar@gmail.com', 'Manohar', 'Katam', '123456', 0, 'Employer'),
('ram@gmail.com', 'Ram', 'Anand', '123456', 0, 'Applicant');

-- --------------------------------------------------------

--
-- Table structure for table `skills_table`
--

CREATE TABLE `skills_table` (
  `skill_id` int(11) NOT NULL,
  `skill_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_application`
--

CREATE TABLE `user_application` (
  `application_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `application_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_education`
--

CREATE TABLE `user_education` (
  `user_id` int(11) NOT NULL,
  `email_id` varchar(200) NOT NULL,
  `institution` varchar(100) NOT NULL,
  `level` varchar(45) NOT NULL,
  `gpa` float DEFAULT NULL,
  `major` varchar(100) NOT NULL,
  `edu_from` int(11) DEFAULT NULL,
  `edu_to` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_education`
--

INSERT INTO `user_education` (`user_id`, `email_id`, `institution`, `level`, `gpa`, `major`, `edu_from`, `edu_to`) VALUES
(1, 'ram@gmail.com', 'UTD', 'MS', 3, 'CS', 2016, 2018);

-- --------------------------------------------------------

--
-- Table structure for table `user_primary`
--

CREATE TABLE `user_primary` (
  `user_id` int(11) NOT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_no` varchar(12) NOT NULL,
  `zip_code` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_skills`
--

CREATE TABLE `user_skills` (
  `user_id` int(11) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `skills` varchar(100) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `skill_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_work_experience`
--

CREATE TABLE `user_work_experience` (
  `user_id` int(11) NOT NULL,
  `email_id` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `organization_name` varchar(45) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `exp_from` int(11) DEFAULT NULL,
  `exp_to` int(11) DEFAULT NULL,
  `achievements` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application_details`
--
ALTER TABLE `application_details`
  ADD PRIMARY KEY (`user_id`,`job_id`),
  ADD KEY `job_id_idx` (`job_id`);

--
-- Indexes for table `category_table`
--
ALTER TABLE `category_table`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `employer`
--
ALTER TABLE `employer`
  ADD PRIMARY KEY (`emp_id`),
  ADD KEY `email_id_idx` (`email_id`);

--
-- Indexes for table `job_postings`
--
ALTER TABLE `job_postings`
  ADD PRIMARY KEY (`job_id`),
  ADD KEY `emp_id_idx` (`emp_id`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`email_id`);

--
-- Indexes for table `skills_table`
--
ALTER TABLE `skills_table`
  ADD PRIMARY KEY (`skill_id`);

--
-- Indexes for table `user_application`
--
ALTER TABLE `user_application`
  ADD PRIMARY KEY (`application_id`,`user_id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- Indexes for table `user_education`
--
ALTER TABLE `user_education`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `email_id` (`email_id`);

--
-- Indexes for table `user_primary`
--
ALTER TABLE `user_primary`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `email_id_idx` (`email_id`);

--
-- Indexes for table `user_skills`
--
ALTER TABLE `user_skills`
  ADD KEY `user_id_idx` (`user_id`),
  ADD KEY `category_id_idx` (`category_id`),
  ADD KEY `skill_id_idx` (`skill_id`);

--
-- Indexes for table `user_work_experience`
--
ALTER TABLE `user_work_experience`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `email_id` (`email_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category_table`
--
ALTER TABLE `category_table`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employer`
--
ALTER TABLE `employer`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `job_postings`
--
ALTER TABLE `job_postings`
  MODIFY `job_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_education`
--
ALTER TABLE `user_education`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_primary`
--
ALTER TABLE `user_primary`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_work_experience`
--
ALTER TABLE `user_work_experience`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `application_details`
--
ALTER TABLE `application_details`
  ADD CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `job_postings` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_id2` FOREIGN KEY (`user_id`) REFERENCES `user_primary` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `employer`
--
ALTER TABLE `employer`
  ADD CONSTRAINT `email_id` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `job_postings`
--
ALTER TABLE `job_postings`
  ADD CONSTRAINT `emp_id2` FOREIGN KEY (`emp_id`) REFERENCES `registration` (`email_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_application`
--
ALTER TABLE `user_application`
  ADD CONSTRAINT `user_id3` FOREIGN KEY (`user_id`) REFERENCES `user_primary` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_education`
--
ALTER TABLE `user_education`
  ADD CONSTRAINT `user_education_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`);

--
-- Constraints for table `user_primary`
--
ALTER TABLE `user_primary`
  ADD CONSTRAINT `email_id1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_skills`
--
ALTER TABLE `user_skills`
  ADD CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category_table` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `skill_id` FOREIGN KEY (`skill_id`) REFERENCES `skills_table` (`skill_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_id1` FOREIGN KEY (`user_id`) REFERENCES `user_primary` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_work_experience`
--
ALTER TABLE `user_work_experience`
  ADD CONSTRAINT `user_work_experience_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
