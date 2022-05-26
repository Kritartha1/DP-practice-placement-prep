#https://leetcode.com/problems/big-countries/
# # Write your MySQL query statement below
#Approach 1: slower
# SELECT name,population,area FROM world WHERE area>=3000000 OR population>=25000000

#Approach 2: faster
SELECT name,population,area FROM world WHERE area>=3000000
UNION
SELECT name,population,area FROM world WHERE  population>=25000000;
