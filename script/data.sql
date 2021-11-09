INSERT  INTO `user`(`id`,`firstname`,`lastname`,`username`,`email`,`password`,`phone`,`address`,`active`) VALUES
(1,'Khandker','Qaiduzzaman','nafees','nafees@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dortmund',''),
(2,'Sadman','Sobhan','imran','imran@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(3,'Md','Amin','amin','amin@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Dhaka',''),
(4,'Tulip','Sarker','tulip','tulip@gmail.com','$2a$10$cBi8wPjrntyeUmf0I1dYLe8lIiVnl4D52VILNkXRl4kYpUf1h2StG','01912070224','Maoa',''),
(5,'Zahidul','Haque','shawon','shawon@gmail.com','$2a$10$pGv5BjUq367eFin.vgvPeugs3ugRywvlveGVZAdZidkXF2WBa0sHG','013258965','Dhaka',''),
(6,'Reaz','Uddin','reaz','reaz@gmail.com','$2a$10$WtZSoxojxPih9upyYS5teu6jcEwLZJpgIleWZDiuzIW8cdf6jYE2O','01912070224','Khulna',''),
(7,'Ahasan','Habib','royal','reaz@gmail.com','$2a$10$WtZSoxojxPih9upyYS5teu6jcEwLZJpgIleWZDiuzIW8cdf6jYE2O','01912070224','Khulna','');

INSERT  INTO `role`(`id`,`name`) VALUES
(1,'SUPER_ADMIN'),
(2,'INVESTOR'),
(3,'WORKER'),
(4,'SELLER'),
(5,'SUPPLIER');

INSERT  INTO `user_role`(`id`,`user_id`,`role_id`) VALUES
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












