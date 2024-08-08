CREATE TABLE `product_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`));

CREATE TABLE `size`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `product_size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `size_id` INT NOT NULL,
  `stock` INT DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  FOREIGN KEY (`size_id`) REFERENCES `size` (`id`));
  
CREATE TABLE `province` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(255) DEFAULT NULL,
  `province` VARCHAR(255) DEFAULT NULL,
  `street` VARCHAR(255) DEFAULT NULL,
  `zip_code` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) DEFAULT NULL,
  `last_name` VARCHAR(255) DEFAULT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_tracking_number` VARCHAR(255) DEFAULT NULL,
  `total_price` DECIMAL(19,2) DEFAULT NULL,
  `total_quantity` INT DEFAULT NULL,
  `billing_address_id` INT DEFAULT NULL,
  `customer_id` INT DEFAULT NULL,
  `shipping_address_id` INT DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  FOREIGN KEY (`billing_address_id`) REFERENCES `address` (`id`),
  FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`id`));
  
CREATE TABLE `order_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `quantity` INT DEFAULT NULL,
  `unit_price` DECIMAL(19,2) DEFAULT NULL,
  `order_id` INT DEFAULT NULL,
  `product_id` INT DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`id`));
  
 CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(255),
  `password` VARCHAR(255));
  
 CREATE TABLE `role` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255));
 
 CREATE TABLE `user_role` (
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    FOREIGN KEY (`role_id`) REFERENCES `role`(`id`)
);