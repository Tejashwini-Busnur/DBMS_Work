//updates

//1 Update developer - Update Charlies primary phone number to 333-444-5555

UPDATE phone
SET phone.phone = 333-444-5555
where primary_number =1 and phone.person = (SELECT id FROM person where first_name = 'charles') ;

//2


UPDATE widget
SET order_type =
CASE 
when name = 'head345' then 3
when name = 'image345' then 1
END
WHERE name IN ('head345', 'image345');

//3

UPDATE page 
JOIN website ON page.website = website.id 
SET page.title = CONCAT('CNET - ', page.title)
WHERE website.name = 'CNET';

//4

select page_role.role_type
from page_role, page, website, developer, person
where page_role.page = page.id
and page_role.developer = developer.person
and page.website = website.id
and developer.person = person.id
and website.name = "CNET"
and page.title like "%Home"
and person.username = "bob"
into @temp_bob;


select page_role.role_type
from page_role, page, website, developer, person
where page_role.page = page.id
and page_role.developer = developer.person
and page.website = website.id
and developer.person = person.id
and website.name = "CNET"
and page.title like "%Home"
and person.username = "charlie"
into @temp_charlie;

update page_role
set role_type = @temp_charlie
where developer = 23
and page = 123;

update page_role
set page_role.role_type = @temp_bob
where page_role.developer = 34
and page_role.page = 123;
