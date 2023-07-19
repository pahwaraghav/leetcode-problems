# Write your MySQL query statement below
SELECT name, IFNULL(user_distance,0) AS travelled_distance FROM Users LEFT JOIN (
    SELECT user_id, SUM(distance) AS `user_distance` FROM Rides group by user_id
) temp ON temp.user_id = Users.id ORDER BY user_distance DESC, name;
