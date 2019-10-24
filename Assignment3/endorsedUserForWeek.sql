DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `endorsedUserForWeek`(IN Start DATE, IN END DATE)
BEGIN
select temp1.userid, first_name,total_count from
(select u.person as userid, first_name, last_name,count(*) as total_count from answer a
join user u on u.person = a.postedBy
join person p on p.id =u.person
where correctAnswer = 1
and postedOn between Start and End
group by postedBy
order by total_count desc) as temp1
order by first_name desc
Limit 5;
END$$
DELIMITER ;
