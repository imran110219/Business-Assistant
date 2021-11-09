-- Add Key
  
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `role`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `user_role`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `user`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `customer`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

-- Add Foreign Key

ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_role_fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
