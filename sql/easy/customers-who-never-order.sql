# Write your MySQL query statement below
#https://leetcode.com/problems/customers-who-never-order/
SELECT name as 'Customers' FROM customers where id not in(SELECT customerid FROM orders);
