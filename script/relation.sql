-- Add Key
  
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `units`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `product_types`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `type_id` (`type_id`);

ALTER TABLE `roles`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `user_roles`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `users`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `customers`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `products`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `units`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `types`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

  ALTER TABLE `product_types`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=16;

-- Add Foreign Key

ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_role_fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `user_role_fk_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

ALTER TABLE `product_types`
  ADD CONSTRAINT `product_type_fk_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `product_type_fk_type` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`);

ALTER TABLE `products`
  ADD CONSTRAINT `product_fk_unit` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`);