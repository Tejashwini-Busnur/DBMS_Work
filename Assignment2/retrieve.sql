//1retrieve developers

//a
SELECT first_name, last_name from person p
JOIN developer d ON d.person = p.id;

//b
SELECT first_name, last_name from person p
where id = 34;

//c Retrieve all developers who have a role in Twitter other than owner

SELECT p.id,first_name, last_name,wr.role_type from person p
JOIN developer d ON p.id = d.person
JOIN website_role wr ON d.person = wr.developer
JOIN website w ON w.id = wr.website
where w.name = 'Twitter' and wr.role_type != 'owner';


//d Retrieve all developers who are page reviewers of pages with less than 300000 views

SELECT p.id,first_name, last_name,pr.role_type from person p
JOIN developer d ON p.id = d.person
JOIN page_role pr ON d.person = pr.developer 
JOIN page On pr.page = page.id
WHERE pr.role_type = 'reviewer' and page.views <= 300000;

//e Retrieve the writer developer who added a heading widget to CNET home page

SELECT p.id,first_name, last_name,pr.role_type from person p
JOIN developer d ON p.id = d.person
JOIN page_role pr ON d.person = pr.developer
JOIN page ON pr.page = page.id
WHERE pr.role_type = 'writer' and page.title = 'home';


//Retrieve websites

//a Retrieve the website with the least number of visits

SELECT name,visits 
FROM website 
WHERE visits=(SELECT min(visits) FROM website); 

//b Retrieve the name of a website whose id is 678

SELECT id,name 
FROM website
WHERE id = 678;

//c Retrieve all websites with videos reviewed by bob 

select website.name
from website, page, page_role, widget, developer, person
where widget.dtype = "youtube"
and page.id = widget.page
and page.website = website.id
and page_role.page = page.id
and page_role.developer = developer.person
and developer.person = person.id
and person.username = "bob"
and page_role.role_type = "REVIEWER";
	
//d Retrieve all websites where alice is an owner 

SELECT w.name,first_name, last_name,wr.role_type from person p
JOIN developer d ON p.id = d.person
JOIN website_role wr ON d.person = wr.developer 
JOIN website w ON w.id = wr.website
where p.username = 'alice' and wr.role_type = 'owner';

// e Retrieve all websites where charlie is an admin and get more than 6000000 visits

 SELECT w.name, first_name, role_type, visits from website w
 JOIN website_role wr JOIN developer d JOIN person p
 ON w.id=wr.website and wr.developer=d.person and d.person =p.id
 and username='charlie' and role_type='admin' and visits>6000000;
 
 
 // Retrieve Pages

//a Retrieve the page with the most number of views

SELECT title,views 
FROM page 
WHERE views=(SELECT max(views) FROM page); 

//b Retrieve the title of a page whose id is 234

SELECT id,title 
FROM page
WHERE id = 234;

//c Retrieve all pages where alice is an editor 

SELECT page.title,p.first_name,pr.role_type from page
JOIN developer d JOIN page_role pr  JOIN person p
ON p.id = d.person
AND d.person = pr.developer 
AND pr.page = page.id WHERE p.username = 'alice' and pr.role_type = 'editor';

//d Retrieve the total number of pageviews in CNET

SELECT views, title , w.name from page 
JOIN website w 
ON w.id = page.website
where w.name = 'CNET';

//e Retrieve the average number of page views in the Website Wikipedia

SELECT avg(views), w.name from page 
JOIN website w 
ON w.id = page.website
where w.name = 'Wikipedia';
 
 
//Retrieve widgets

//a Retrieve all widgets in CNETs Home page

SELECT wd.name from widget wd
JOIN page pg ON wd.page= pg.id
JOIN website w ON pg.website=w.id 
WHERE w.name='cnet' and pg.title='home';

//b Retrieve all youtube widgets in CNN

SELECT title,dtype,website.name from widget
JOIN website JOIN page
ON page.id = widget.page and website.id = page.website
and dtype='youtube' and website.name='cnn';

//c Retrieve all image widgets on pages reviewed by Alice

SELECT wd.name from widget wd
    JOIN page pg ON pg.id = wd.page
    JOIN page_role pr ON pr.page = pg.id
    JOIN website w ON pg.website = w.id
    JOIN developer d ON d.person = pr.developer
    JOIN person p ON p.id = d.person
    where wd.dtype = 'image' AND pr.role_type = 'reviewer'AND p.username = 'alice';
	
//d Retrieve how many widgets are in Wikipedia

SELECT COUNT(*)
    FROM website w
    JOIN page p ON w.id = p.website
	JOIN widget wd ON p.id = wd.page
    AND w.name = 'Wikipedia';

//To verify the page and website triggers written earlier function properly:

//a Retrieve the names of all the websites where Bob has DELETE privileges.

select name AS website
from website, website_privilege, developer, person
where person.username = "bob"
and website_privilege.website = website.id
and website_privilege.developer = developer.person
and developer.person = person.id
and website_privilege.privilege = "DELETE";


//b Retrieve the names of all the pages where Charlie has CREATE privileges. 

select page.title
from page, page_privilege, developer, person
where person.username = "charlie"
and page_privilege.page = page.id
and page_privilege.developer = developer.person
and page_privilege.privilege = "CREATE"
and developer.person = person.id;
