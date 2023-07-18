# Write your MySQL query statement below
(SELECT `employee_id`, `salary` AS `bonus` FROM `Employees` WHERE `employee_id` % 2 != 0 AND `name` NOT LIKE "M%" UNION
SELECT `employee_id`, `salary` * 0 AS `bonus` FROM Employees WHERE `employee_id` %2 = 0 OR `name` LIKE "M%") ORDER BY `employee_id`;