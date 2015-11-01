/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-10-30 13:14:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for p_random_down
-- ----------------------------
DROP TABLE IF EXISTS `p_random_down`;
CREATE TABLE `p_random_down` (
  `id` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `owner_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `isdown` int(11) DEFAULT NULL,
  `spend` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_random_down
-- ----------------------------
INSERT INTO `p_random_down` VALUES ('441237', 'https://api.github.com/repos/clhuang/SPinACh', '212334', 'SPinACh', null, 'Java', '2012-08-16 02:14:59', '43', '1', '6');
INSERT INTO `p_random_down` VALUES ('842798', 'https://api.github.com/repos/dalbz/doodle-lock', '187378', 'doodle-lock', 'An Android home screen app to lock the phone via a user-drawn doodle', 'Java', '2012-09-17 02:18:22', '1537', '1', '8');
INSERT INTO `p_random_down` VALUES ('868546', 'https://api.github.com/repos/jagsler/IPSEN6', '787068', 'IPSEN6', 'IPSEN6 Android Applicatie', 'Java', '2012-09-05 21:51:30', '689', '1', '7');
INSERT INTO `p_random_down` VALUES ('2258717', 'https://api.github.com/repos/ratcashdev/play-with-orientdb', '1398694', 'play-with-orientdb', 'OrientDB plugin for Play 2.x', 'Java', '2012-11-30 15:17:33', '77', '1', '3');
INSERT INTO `p_random_down` VALUES ('2860534', 'https://api.github.com/repos/Superindy/Geraphne', '1649178', 'Geraphne', 'Geraphne 1.0', 'Java', '2013-02-18 02:43:56', '59', '1', '2');
INSERT INTO `p_random_down` VALUES ('3588651', 'https://api.github.com/repos/sheldonzipingchen/Gallery', '339449', 'Gallery', 'phone gallery', 'Java', '2013-05-05 20:41:07', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('3619828', 'https://api.github.com/repos/chargeover/chargeover_java', '1943236', 'chargeover_java', 'ChargeOver API Wrapper for Java', 'Java', '2013-04-09 21:56:49', '1045', '1', '10');
INSERT INTO `p_random_down` VALUES ('3646152', 'https://api.github.com/repos/frankcalise/Hydrate', '564231', 'Hydrate', 'An open source Android application to allow a user to help track water intake (or lack thereof).', 'Java', '2013-04-09 08:05:07', '491', '1', '23');
INSERT INTO `p_random_down` VALUES ('3740656', 'https://api.github.com/repos/Tublood/FlickrTest', '1978101', 'FlickrTest', 'Junior Android Bootcamp Test 01', 'Java', '2013-05-16 15:00:20', '4076', '1', '88');
INSERT INTO `p_random_down` VALUES ('3779535', 'https://api.github.com/repos/purpleposeidon/ExoArmor', '38042', 'ExoArmor', 'Non-working archive of ExoArmor code, which is removed from Factorization', 'Java', '2013-05-19 04:52:49', '57', '1', '3');
INSERT INTO `p_random_down` VALUES ('4052630', 'https://api.github.com/repos/ashaukat/SecondTestProject', '2070312', 'SecondTestProject', null, 'Java', '2013-06-07 16:12:06', '42', '1', '2');
INSERT INTO `p_random_down` VALUES ('4253020', 'https://api.github.com/repos/jpfaria/caelum-fj-31-loja-ejb3', '220385', 'caelum-fj-31-loja-ejb3', null, 'Java', '2013-06-25 05:10:22', '13', '1', '1');
INSERT INTO `p_random_down` VALUES ('4554385', 'https://api.github.com/repos/hiiroo/LevenshteinDistance-NumericalAnalysis', '183938', 'LevenshteinDistance-NumericalAnalysis', 'Levenshtein Distance algorithm', 'Java', '2013-07-12 14:48:27', '1', '1', '2');
INSERT INTO `p_random_down` VALUES ('4650059', 'https://api.github.com/repos/Staartvin/Scroll-Teleportation', '809156', 'Scroll-Teleportation', 'Github repository for the bukkit plugin \'Scroll Teleportation\'', 'Java', '2013-07-23 01:22:44', '49', '1', '3');
INSERT INTO `p_random_down` VALUES ('4684704', 'https://api.github.com/repos/speedlinkdayo/twelvegames', '2325111', 'twelvegames', null, 'Java', '2013-07-23 15:05:33', '518', '1', '5');
INSERT INTO `p_random_down` VALUES ('5702798', 'https://api.github.com/repos/liuhuo/stanford-algo-part2', '6906', 'stanford-algo-part2', null, 'Java', '2013-09-13 15:28:53', '23760', '1', '79');
INSERT INTO `p_random_down` VALUES ('5714789', 'https://api.github.com/repos/dpesha/hfdp', '52945', 'hfdp', 'Head First Design Patterns', 'Java', '2013-09-17 19:27:22', '12', '1', '3');
INSERT INTO `p_random_down` VALUES ('5751801', 'https://api.github.com/repos/Vivekbhusal/Mobile-Nepal-Android-Training-Day-2', '257647', 'Mobile-Nepal-Android-Training-Day-2', 'This repository contains the android project of Day 2 developed in Android Training Organized in Mobile Nepal. ', 'Java', '2013-09-24 16:56:14', '562', '1', '11');
INSERT INTO `p_random_down` VALUES ('5788037', 'https://api.github.com/repos/smilk12/AA-UAV', '2711772', 'AA-UAV', 'AA-UAV - (Ar.Drone Android - Unmanned aerial vehicle)', 'Java', '2013-09-29 23:42:03', '56089', '1', '795');
INSERT INTO `p_random_down` VALUES ('5849120', 'https://api.github.com/repos/gunawan/appengine-maven-template', '184150', 'appengine-maven-template', 'AppEngine Maven Template', 'Java', '2013-10-07 13:11:06', '26086', '1', '348');
INSERT INTO `p_random_down` VALUES ('6195385', 'https://api.github.com/repos/martinrevert/GCMjavadaemon', '146152', 'GCMjavadaemon', 'This is a stupid polling solution used for parse and send to Google Push service the new info from aRGENTeaM', 'Java', '2013-11-01 12:05:12', '6086', '1', '35');
INSERT INTO `p_random_down` VALUES ('6405188', 'https://api.github.com/repos/ramosisw/Pila', '2480171', 'Pila', null, 'Java', '2013-11-14 07:44:04', '18', '1', '3');
INSERT INTO `p_random_down` VALUES ('8396619', 'https://api.github.com/repos/jywjyw/packreader', '3524449', 'packreader', 'ipa/apk??', 'Java', '2014-03-06 13:33:32', '11567', '1', '105');
INSERT INTO `p_random_down` VALUES ('8850417', 'https://api.github.com/repos/takuaraki/ChienLock', '3458827', 'ChienLock', null, 'Java', '2014-03-26 08:34:22', '7648', '1', '117');
INSERT INTO `p_random_down` VALUES ('9363492', 'https://api.github.com/repos/Mivey/AutonSysCameraBot', '3593799', 'AutonSysCameraBot', 'Projekt für Intelligente und Autonome Systeme', 'Java', '2014-04-25 16:48:20', '570', '1', '4');
INSERT INTO `p_random_down` VALUES ('9408211', 'https://api.github.com/repos/RomanStecenko/SafeInfo2', '2675944', 'SafeInfo2', 'application for data encryption\\decryption', 'Java', '2014-04-18 00:47:17', '1897', '1', '6');
INSERT INTO `p_random_down` VALUES ('9573181', 'https://api.github.com/repos/bonescarfer/scratch', '3894368', 'scratch', null, 'Java', '2014-04-28 22:14:09', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('10005488', 'https://api.github.com/repos/venjee/CatchYou', '4130762', 'CatchYou', null, 'Java', '2014-05-29 15:32:29', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('10627236', 'https://api.github.com/repos/PeterShepley/ducking-avenger', '3283', 'ducking-avenger', 'This is a spades scoring system.', 'Java', '2014-07-06 03:04:11', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('10786938', 'https://api.github.com/repos/bytekast/kettle-httplite-plugin', '573523', 'kettle-httplite-plugin', null, 'Java', '2014-07-11 03:22:46', '238', '1', '4');
INSERT INTO `p_random_down` VALUES ('10812920', 'https://api.github.com/repos/lgvalle/RecyclerViewDemos', '567101', 'RecyclerViewDemos', 'RecyclerView Demo', 'Java', '2014-07-14 00:50:34', '649', '1', '5');
INSERT INTO `p_random_down` VALUES ('10918204', 'https://api.github.com/repos/adjohnson916/HttpMethodOverrideFilter', '60188', 'HttpMethodOverrideFilter', null, 'Java', '2014-07-20 12:23:56', '6', '1', '2');
INSERT INTO `p_random_down` VALUES ('11186913', 'https://api.github.com/repos/GrimSmiler/Brahms', '2248585', 'Brahms', null, 'Java', '2014-08-04 21:57:26', '186', '1', '6');
INSERT INTO `p_random_down` VALUES ('11324136', 'https://api.github.com/repos/mpoehler/optiker-verzeichnis', '2405935', 'optiker-verzeichnis', 'directory for opticians, used to evaluate the creation a real world JS-Frontend, Spring-Backend, Ajax driven, response and SEO friendly Website. It is also used to test the development and deployment mechanics with maven and intellij.', 'Java', '2014-08-11 01:59:24', '61', '1', '3');
INSERT INTO `p_random_down` VALUES ('11606714', 'https://api.github.com/repos/lfuelling/textie', '4495510', 'textie', 'Ein kleines Textadventure.', 'Java', '2014-09-02 16:07:21', '50', '1', '3');
INSERT INTO `p_random_down` VALUES ('12259144', 'https://api.github.com/repos/Sashenka/android-grocerylists', '3413797', 'android-grocerylists', 'A simple application to create and manage grocery lists.', 'Java', '2014-09-20 01:55:52', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('12390518', 'https://api.github.com/repos/mini890/Adfgvx-Cipher', '1391470', 'Adfgvx-Cipher', null, 'Java', '2014-09-06 04:48:42', '4', '1', '2');
INSERT INTO `p_random_down` VALUES ('12562161', 'https://api.github.com/repos/philiplarsson/Washingmachine', '1681295', 'Washingmachine', 'A project that implements a wachingmachine', 'Java', '2014-10-10 20:47:11', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('12732804', 'https://api.github.com/repos/x3r/hello-world', '3462549', 'hello-world', 'Sample Hello World Application', 'Java', '2014-10-20 08:53:30', '13', '1', '4');
INSERT INTO `p_random_down` VALUES ('13531268', 'https://api.github.com/repos/atulmirajkar/Mahout-KMeans-Learner', '3965959', 'Mahout-KMeans-Learner', null, 'Java', '2014-11-02 06:36:30', '32', '1', '8');
INSERT INTO `p_random_down` VALUES ('14005956', 'https://api.github.com/repos/fakhirsh/GL2libpng-android', '1712335', 'GL2libpng-android', 'This code first loads raw png stream from the apk asset folder using JNI asset manager. Then it passes that stream to libPNG to extract bitmap data. Finally it generates openGL textures and renders the picture on the screen.', 'Java', '2014-12-04 05:10:56', '2157', '1', '33');
INSERT INTO `p_random_down` VALUES ('14969744', 'https://api.github.com/repos/dabbihall/timaverkefni', '6632053', 'timaverkefni', 'timaverkefni i hugbunaðarverkefni', 'Java', '2014-10-10 19:33:25', '744', '1', '15');
INSERT INTO `p_random_down` VALUES ('16609653', 'https://api.github.com/repos/CustomCraftDev/HubPvp', '4556685', 'HubPvp', null, 'Java', '2015-02-21 22:53:14', '5', '1', '3');
INSERT INTO `p_random_down` VALUES ('16841181', 'https://api.github.com/repos/austinv11/CollectiveFramework', '3194544', 'CollectiveFramework', 'A framework for all my mods', 'Java', '2015-02-27 09:52:07', '329', '1', '7');
INSERT INTO `p_random_down` VALUES ('17447931', 'https://api.github.com/repos/albertyhong/Hello', '1718683', 'Hello', null, 'Java', '2015-03-14 09:51:07', '113', '1', '4');
INSERT INTO `p_random_down` VALUES ('17476428', 'https://api.github.com/repos/Rohit-Erande/DataLossPrevention', '1684637', 'DataLossPrevention', 'Detects the data accessed and send over the network. This project is based on big data analytics.', 'Java', '2015-03-16 10:14:49', '5226', '1', '73');
INSERT INTO `p_random_down` VALUES ('17524594', 'https://api.github.com/repos/dcandrade/htmlparser', '7318877', 'htmlparser', null, 'Java', '2015-03-14 08:05:08', '2', '1', '6');
INSERT INTO `p_random_down` VALUES ('17536489', 'https://api.github.com/repos/vladlen2292/testproject', '7010886', 'testproject', '???????? ???????', 'Java', '2015-03-15 05:46:26', '0', '0', '0');
INSERT INTO `p_random_down` VALUES ('17618435', 'https://api.github.com/repos/JacobVelarde/CoparmexBeta', '6262989', 'CoparmexBeta', null, 'Java', '2015-03-18 11:26:51', '1421', '1', '16');
INSERT INTO `p_random_down` VALUES ('17661801', 'https://api.github.com/repos/ekilah/lollipop', '1455384', 'lollipop', null, 'Java', '2015-03-19 09:18:50', '618', '1', '6');
