INSERT  INTO `users`(`id`,`first_name`,`last_name`,`username`,`email`,`password`,`phone`,`address`,`active`) VALUES
(1,'Khandker','Qaiduzzaman','nafees','nafees@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dortmund',''),
(2,'Sadman','Sobhan','imran','imran@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(3,'Md','Amin','amin','amin@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(4,'Tulip','Sarker','tulip','tulip@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Maoa',''),
(5,'Zahidul','Haque','shawon','shawon@gmail.com','$2a$10$pGv5BjUq367eFin.vgvPeugs3ugRywvlveGVZAdZidkXF2WBa0sHG','013258965','Dhaka',''),
(6,'Reaz','Uddin','reaz','reaz@gmail.com','$2a$10$WtZSoxojxPih9upyYS5teu6jcEwLZJpgIleWZDiuzIW8cdf6jYE2O','01912070224','Khulna',''),
(7,'Ahasan','Habib','royal','reaz@gmail.com','$2a$10$WtZSoxojxPih9upyYS5teu6jcEwLZJpgIleWZDiuzIW8cdf6jYE2O','01912070224','Khulna','');

INSERT  INTO `roles`(`id`,`name`) VALUES
(1,'SUPER_ADMIN'),
(2,'INVESTOR'),
(3,'WORKER'),
(4,'SELLER'),
(5,'SUPPLIER');

INSERT  INTO `user_roles`(`id`,`user_id`,`role_id`) VALUES
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,2,1),
(7,2,2),
(8,2,3),
(9,2,4),
(10,2,5),
(11,3,1),
(12,3,2),
(13,3,3),
(14,3,4),
(15,3,5),
(16,4,1),
(17,4,2),
(18,4,3),
(19,4,4),
(20,4,5),
(21,5,1),
(22,5,2),
(23,5,3),
(24,5,4),
(25,5,5),
(26,6,1),
(27,6,2),
(28,6,3),
(29,6,4),
(30,6,5),
(31,7,2),
(32,7,3),
(33,7,4),
(34,7,5);

INSERT  INTO `types`(`id`,`name`,`description`) VALUES
(1,'Honey','Honey Description'),
(2,'Peanut','Peanut Description'),
(3,'Hair Solution','Hair Solution Description'),
(4,'Face Solution','Face Solution Description'),
(5,'Herbal Medicine','Herbal Medicine Description');

INSERT  INTO `product_types`(`id`,`product_id`,`type_id`) VALUES
(1,1,4),
(2,2,4),
(3,3,3),
(4,4,4),
(5,5,4),
(6,6,3),
(7,7,3),
(8,8,3),
(9,9,4),
(10,10,3);

INSERT  INTO `products`(`id`,`unit`,`name`,`bn_name`,`purchase_price`,`sale_price`,`percentage`) VALUES
(1,'gm','Rose Petal Powder','গোলাপ গুড়া',70,140,15),
(2,'gm','Fullers Earth Powder','মুলতানি মাটি গুড়া',40,80,15),
(3,'gm','Fenugreek Seed Powder','মেথি গুড়া',25,50,15),
(4,'gm','Masoor Dal Powder','মসুর ডাল',15,30,15),
(5,'gm','Potatoes Powder','আলু গুড়া',90,180,15),
(6,'gm','Ginger Powder','আদা গুড়া',55,110,15),
(7,'gm','Shikkai Powder','শিককাই গুড়া',70,140,15),
(8,'gm','Triphala Powder','ত্রিফলা গুড়া',45,90,15),
(9,'gm','Cinnamon Powder','দারুচিনি গুড়া',40,80,15),
(10,'gm','Haratki Powder','হরতকি গুড়া',35,70,15);

INSERT  INTO `customers`(`id`,`full_name`,`phone`,`email`,`address`) VALUES
(1,'Sadman Sobhan','01711123456','sadman@email.com','Dhaka'),
(2,'Khandker Qaiduzzaman','01711123456','nafees@email.com','Dhaka'),
(3,'Tulip Sarker','01711123456','tulip@email.com','Dhaka'),
(4,'Md Amin','01711123456','amin@email.com','Dhaka'),
(5,'Md Zahidul','01711123456','zahid@email.com','Dhaka');

insert  into `expenses`(`id`,`user_id`,`amount`,`purpose`,`datetime`) values
(1,1,200,'buy','2021-11-25 23:22:56'),
(2,2,500,'transport','2021-11-25 23:23:09'),
(3,1,500,'buy','2021-11-25 23:23:22'),
(4,2,500,'buy','2021-11-25 23:23:34'),
(5,1,1000,'Boost','2021-11-25 23:24:09');

insert  into `investment`(`id`,`investor_id`,`amount`,`datetime`) values
(1,1,20000,'2021-11-27 22:43:22'),
(2,2,20000,'2021-11-27 22:43:26'),
(3,3,30000,'2021-11-27 22:43:30'),
(4,4,20000,'2021-11-27 22:43:35'),
(5,5,20000,'2021-11-27 22:43:39'),
(6,6,20000,'2021-11-27 22:43:43'),
(7,7,20000,'2021-11-27 22:43:49');

insert  into `working_hours`(`id`,`worker_id`,`hour`,`purpose`,`datetime`) values
(1,1,10,'Task','2021-11-30 21:49:57'),
(2,2,10,'Task','2021-11-30 21:50:06'),
(3,3,80,'Task','2021-11-30 21:50:13'),
(4,4,10,'Task','2021-11-30 21:50:19'),
(5,5,40,'Task','2021-11-30 21:50:27'),
(6,6,20,'Task','2021-11-30 21:50:33'),
(7,7,10,'Task','2021-11-30 21:50:40');













