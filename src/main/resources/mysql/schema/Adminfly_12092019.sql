SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE TABLE `blog_categories` (
  `id` int(11) NOT NULL,
  `domain_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `blog_domains` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `domain` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `blog_files` (
  `id` int(11) UNSIGNED NOT NULL,
  `path` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `size` int(11) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `blog_posts` (
  `id` int(10) UNSIGNED NOT NULL,
  `domain_id` int(10) UNSIGNED NOT NULL,
  `category_id` int(10) UNSIGNED NOT NULL,
  `image_id` int(10) UNSIGNED DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `body` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `views` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `enabled` tinyint(1) UNSIGNED NOT NULL DEFAULT '0',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `blog_users_domains` (
  `user_id` int(10) UNSIGNED NOT NULL,
  `domain_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `mdbv_rows` (
  `id` int(10) UNSIGNED NOT NULL,
  `source_id` int(10) UNSIGNED NOT NULL,
  `d_type` char(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'S',
  `name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `path` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `type` char(12) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'RAW',
  `position` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `mdbv_sources` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `db` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `collection` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `security_privileges` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_privileges` (`id`, `name`) VALUES
(2, 'CREATE'),
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
(3, 'EDITOR'),
(4, 'MANAGER'),
(1, 'SUPERUSER');

CREATE TABLE `security_roles_privileges` (
  `role_id` int(10) UNSIGNED NOT NULL,
  `privilege_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `security_roles_privileges` (`role_id`, `privilege_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 6),
(1, 7),
(2, 1),
(2, 4),
(3, 1),
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

ALTER TABLE `blog_categories`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `blog_domains`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `blog_files`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `blog_posts`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `mdbv_rows`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `source_path_uni_pair` (`source_id`,`path`) USING BTREE,
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

ALTER TABLE `blog_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `blog_domains`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `blog_posts`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `mdbv_rows`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `mdbv_sources`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

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
