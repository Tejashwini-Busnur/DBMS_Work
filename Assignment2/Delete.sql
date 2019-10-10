//delete

//1 Delete developer - Delete Alice primary address
 
 DELETE from address 
 WHERE primary_address = 1 and address.person = (SELECT id FROM person where first_name = 'alice') ;
 
//2 
 
DELETE from widget
WHERE order_type IN 
(SELECT * from
(SELECT max(order_type) from widget) temp);
 

//3

DELETE 
FROM page 
where page.id = (select page.id from website w
				where page.website = w.id 
				and w.name = "Wikipedia")
order by updated desc 
limit 1;
			
//4

DELETE from website where name = 'CNET';
 