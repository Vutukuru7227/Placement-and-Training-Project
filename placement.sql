-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 24, 2017 at 04:15 AM
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
  `email_id` varchar(200) NOT NULL,
  `job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `application_details`
--

INSERT INTO `application_details` (`email_id`, `job_id`) VALUES
('ram@gmail.com', 1),
('ram@gmail.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `employer`
--

CREATE TABLE `employer` (
  `emp_id` int(11) NOT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `company_name` varchar(80) NOT NULL,
  `department` varchar(80) DEFAULT NULL,
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
(1, 'manohar@gmail.com', 'Solutions', 'Dallas', 'Software Developer', 'Java, Python', '2017-01-01'),
(2, 'mano@gmail.com', 'Solutions', 'Dallas', 'Software Developer', 'Java, C++', '0009-12-29');

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
('mano@gmail.com', 'Manohar', 'Katam', '123456', 0, 'Employer'),
('manohar@gmail.com', 'Manohar', 'Katam', '123456', 0, 'Employer'),
('ram@gmail.com', 'Ram', 'Anand', '123456', 0, 'Applicant');

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
(3, 'ram@gmail.com', 'University of Texas at Dallas', 'Master of Science', 3.904, 'Computer Science', 2016, 2018),
(4, 'kmreddyhyd@gmail.com', 'IIST', 'Bachelors', 3.71, 'Electronics', 2011, 2015),
(9, 'ram@gmail.com', 'IIST', 'Bachelors', 3.71, 'Electronics', 2011, 2015);

-- --------------------------------------------------------

--
-- Table structure for table `user_primary`
--

CREATE TABLE `user_primary` (
  `user_id` int(11) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_no` varchar(12) NOT NULL,
  `zip_code` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_primary`
--

INSERT INTO `user_primary` (`user_id`, `email_id`, `address`, `phone_no`, `zip_code`) VALUES
(1, 'ram@gmail.com', '7575 Frankford Rd, Apt 2923', '6822569203', '75252');

-- --------------------------------------------------------

--
-- Table structure for table `user_skills`
--

CREATE TABLE `user_skills` (
  `user_id` int(11) NOT NULL,
  `email_id` varchar(200) NOT NULL,
  `category` varchar(200) NOT NULL,
  `skill` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_skills`
--

INSERT INTO `user_skills` (`user_id`, `email_id`, `category`, `skill`) VALUES
(1, 'ram@gmail.com', 'Programming', 'Java'),
(4, 'ram@gmail.com', 'Programming', 'PHP'),
(5, 'ram@gmail.com', 'Databases', 'MySQL');

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
-- Dumping data for table `user_work_experience`
--

INSERT INTO `user_work_experience` (`user_id`, `email_id`, `title`, `organization_name`, `location`, `exp_from`, `exp_to`, `achievements`) VALUES
(1, 'ram@gmail.com', 'Software Developer', 'ISRO', 'Bangalore', 2015, 2017, 'aaaaa'),
(4, 'ram@gmail.com', 'Web Developer', 'University of Texas at Dallas', 'Dallas', 2017, 2017, 'Web Page');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application_details`
--
ALTER TABLE `application_details`
  ADD PRIMARY KEY (`email_id`,`job_id`),
  ADD KEY `job_id_idx` (`job_id`);

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
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `emai_id` (`email_id`);

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
-- AUTO_INCREMENT for table `employer`
--
ALTER TABLE `employer`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `job_postings`
--
ALTER TABLE `job_postings`
  MODIFY `job_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_education`
--
ALTER TABLE `user_education`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_primary`
--
ALTER TABLE `user_primary`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_skills`
--
ALTER TABLE `user_skills`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user_work_experience`
--
ALTER TABLE `user_work_experience`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `application_details`
--
ALTER TABLE `application_details`
  ADD CONSTRAINT `application_details_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`),
  ADD CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `job_postings` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
-- Constraints for table `user_education`
--
ALTER TABLE `user_education`
  ADD CONSTRAINT `user_education_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`);

--
-- Constraints for table `user_primary`
--
ALTER TABLE `user_primary`
  ADD CONSTRAINT `user_primary_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`);

--
-- Constraints for table `user_skills`
--
ALTER TABLE `user_skills`
  ADD CONSTRAINT `user_skills_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`);

--
-- Constraints for table `user_work_experience`
--
ALTER TABLE `user_work_experience`
  ADD CONSTRAINT `user_work_experience_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `registration` (`email_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
