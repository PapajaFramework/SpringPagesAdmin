SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE TABLE `mdbv_paths` (
  `id` int(10) UNSIGNED NOT NULL,
  `source_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `path` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `type` char(12) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'RAW'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `mdbv_paths` (`id`, `source_id`, `name`, `value_path`, `value_type`) VALUES
(13, 1, 'BuildInfo OS', 'buildinfo.buildEnvironment.target_os', 'STRING'),
(16, 1, 'Build Version', 'buildinfo.version', 'STRING'),
(17, 1, 'DB Directory', 'cmdLine.storage.dbPath', 'STRING'),
(20, 1, 'JS Engine', 'buildinfo.javascriptEngine', 'RAW');

CREATE TABLE `mdbv_scanned` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `source_id` int(10) unsigned NOT NULL,
 `path` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `path` (`path`),
 KEY `source_id` (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=788 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `mdbv_sources` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `db` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `collection` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `mdbv_sources` (`id`, `name`, `db`, `collection`) VALUES
(1, 'MongoDB Startup Logs', 'local', 'startup_log');

CREATE TABLE `security_privileges` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_privileges` (`id`, `name`) VALUES
(1, 'READ'),
(3, 'REMOVE'),
(7, 'SECURITY'),
(6, 'SYSTEM'),
(4, 'UPDATE');

CREATE TABLE `security_roles` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_roles` (`id`, `name`) VALUES
(2, 'ADMIN'),
(1, 'SUPERUSER'),
(4, 'WATCHER');

CREATE TABLE `security_roles_privileges` (
  `role_id` int(10) UNSIGNED NOT NULL,
  `privilege_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_roles_privileges` (`role_id`, `privilege_id`) VALUES
(1, 1),
(1, 3),
(1, 4),
(1, 6),
(1, 7),
(2, 1),
(2, 4),
(2, 6),
(4, 1);

CREATE TABLE `security_users` (
  `id` int(10) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  `expired` datetime DEFAULT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_users` (`id`, `username`, `password`, `enabled`, `expired`, `created`, `updated`) VALUES
(1, 'admin', '$2a$10$Vm7h9epGPUMpnyZ/UUC6fuDPbpKp6ZIdVvEtXCBGrWbYtX5rfRnNS', 1, NULL, '2019-05-30 19:18:36', '2019-08-23 17:16:52'),
(2, 'superuser', '$2a$10$51nD4hjmcMnaA26/LQJacOnfirrhLBANKyB8Ngmua7x91WOB9kpl.', 1, NULL, '2019-06-15 07:50:14', '2019-07-11 20:48:47'),
(9, 'ih', '$2a$10$74HSJRzeY1C8bNabo94Y3ugkBmg4ATTC8vhhZE.LAYC4z0MBzlhJ.', 1, NULL, '2019-06-24 18:34:09', '2019-07-03 19:49:23');

CREATE TABLE `security_users_roles` (
  `user_id` int(10) UNSIGNED NOT NULL,
  `role_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_users_roles` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 1),
(9, 1);

ALTER TABLE `mdbv_paths`
  ADD PRIMARY KEY (`id`),
  ADD KEY `source_id` (`source_id`);

ALTER TABLE `mdbv_sources`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `security_privileges`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

ALTER TABLE `security_roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

ALTER TABLE `security_roles_privileges`
  ADD UNIQUE KEY `unique_pair` (`role_id`,`privilege_id`);

ALTER TABLE `security_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

ALTER TABLE `security_users_roles`
  ADD UNIQUE KEY `unique_pair` (`user_id`,`role_id`);

ALTER TABLE `mdbv_paths`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

ALTER TABLE `mdbv_sources`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `security_privileges`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `security_roles`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `security_users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
