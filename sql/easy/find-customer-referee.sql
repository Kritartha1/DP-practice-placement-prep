#//leetcode.com/problems/find-customer-referee/
# Write your MySQL query statement below
#Approach 1: slower
SELECT name  FROM Customer WHERE referee_id IS NULL OR referee_id!=2;


#Approach 2:faster
SELECT name  FROM Customer WHERE referee_id IS NULL OR referee_id <> 2;
