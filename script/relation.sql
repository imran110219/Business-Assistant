-- Add Key

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `product_types`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `type_id` (`type_id`);

ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

ALTER TABLE `purchases`
  ADD PRIMARY KEY (`id`),
  ADD KEY `expense_id` (`expense_id`),
  ADD KEY `product_id` (`product_id`);

ALTER TABLE `stocks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `purchase_id` (`purchase_id`),
  ADD KEY `store_id` (`store_id`);

ALTER TABLE `stores`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `incomes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `seller_id` (`seller_id`);

ALTER TABLE `seller_commissions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `seller_id` (`seller_id`),
  ADD KEY `product_id` (`product_id`);

ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `income_id` (`income_id`),
  ADD KEY `stock_id` (`stock_id`);

ALTER TABLE `working_hours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `worker_id` (`worker_id`);

ALTER TABLE `bank_statement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);


ALTER TABLE `investment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `investor_id` (`investor_id`);

-- Add Auto Increment

ALTER TABLE `users`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `roles`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `user_roles`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `customers`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `types`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `product_types`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `products`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `expenses`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `purchases`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `stocks`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `stores`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `incomes`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `seller_commissions`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `sales`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `working_hours`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `bank_statement`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `investment`
  MODIFY `id` INT(11) AUTO_INCREMENT, AUTO_INCREMENT=1;

-- Add Foreign Key

ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_role_fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `user_role_fk_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

ALTER TABLE `product_types`
  ADD CONSTRAINT `product_type_fk_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `product_type_fk_type` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`);

ALTER TABLE `expenses`
  ADD CONSTRAINT `expense_fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `purchases`
  ADD CONSTRAINT `purchase_fk_expense` FOREIGN KEY (`expense_id`) REFERENCES `expenses` (`id`),
  ADD CONSTRAINT `purchase_fk_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `stocks`
  ADD CONSTRAINT `stock_fk_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchases` (`id`),
  ADD CONSTRAINT `stock_fk_store` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`);

ALTER TABLE `incomes`
  ADD CONSTRAINT `income_fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `income_fk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `income_fk_seller` FOREIGN KEY (`seller_id`) REFERENCES `users` (`id`);

ALTER TABLE `seller_commissions`
  ADD CONSTRAINT `seller_commission_fk_seller` FOREIGN KEY (`seller_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `seller_commission_fk_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `sales`
  ADD CONSTRAINT `sale_fk_income` FOREIGN KEY (`income_id`) REFERENCES `incomes` (`id`),
  ADD CONSTRAINT `sale_fk_stock` FOREIGN KEY (`stock_id`) REFERENCES `stocks` (`id`);

ALTER TABLE `working_hours`
  ADD CONSTRAINT `working_hour_fk_worker` FOREIGN KEY (`worker_id`) REFERENCES `users` (`id`);

ALTER TABLE `bank_statement`
  ADD CONSTRAINT `bank_statement_fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `investment`
  ADD CONSTRAINT `investment_fk_investor` FOREIGN KEY (`investor_id`) REFERENCES `users` (`id`);