//insert developer and user

INSERT INTO person (first_name, last_name, username,password,email) VALUES('Alice','Wonder','alice','alice','alice@wonder.com'); 
INSERT INTO developer (person, developer_key) 
SELECT id, '4321rewq'
	FROM person
    WHERE person.id = 12;

	
INSERT INTO person (id,first_name, last_name, username,password,email) VALUES(23,  'Bob', 'Marley','bob', 'bob', 'bob@marley.com'); 
INSERT INTO developer (person, developer_key) 
SELECT id, '4321rewq'
	FROM person
    WHERE person.id = 23;
    
	
INSERT INTO person (id,first_name, last_name, username,password,email) VALUES(34,  'Charlie', 'Garcia', 'charlie', 'charlie','chuch@garcia.com'); 
INSERT INTO developer (person, developer_key) 
SELECT id, '6543erty'
	FROM person
    WHERE person.id = 34;
	
INSERT INTO person (id,first_name, last_name, username,password,email) VALUES(45,  'Dan', 'Martin', 'dan', 'dan','dan@martin.com'); 
INSERT INTO user (person) 
SELECT id
	FROM person
    WHERE person.id = 45;

INSERT INTO person (id,first_name, last_name, username,password,email) VALUES(56,  'Ed', 'Karaz','ed', 'ed', 'ed@kar.com');
INSERT INTO user (person) 
SELECT id
	FROM person
    WHERE person.id = 56;
    
//insert into website


INSERT INTO website(id,name, description, created, updated, visits)
VALUES ('123','Facebook', 'an online social media and social networking service',CURDATE(), CURDATE(), 1234234);

INSERT INTO website(id,name, description, created, updated, visits)
VALUES (234, 'Twitter', 'an online news and social networking service', CURDATE(), CURDATE(), 4321543);	

INSERT INTO website(id,name, description, created, updated, visits)
VALUES (345, 'Wikipedia', 'a free online encyclopedia', CURDATE(), CURDATE(), 3456654);

INSERT INTO website(id,name, description, created, updated, visits)
VALUES (456, 'CNN', 'an American basic cable and satellite television news channel', CURDATE(), CURDATE(), 6543345);

INSERT INTO website(id,name, description, created, updated, visits)
VALUES (567, 'CNET', 'an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics', CURDATE(), CURDATE(), 5433455);

INSERT INTO website(id,name, description, created, updated, visits)
VALUES (678, 'Gizmodo', 'a design, technology, science and science fiction website that also writes articles on politics', CURDATE(), CURDATE(), 4322345);

//insert into websiterole

//facebook

INSERT INTO website_role (role_type, developer, website) 
SELECT 'owner',  id, 123 
		FROM person 
		WHERE username = 'alice';
		
INSERT INTO website_role (role_type, developer, website) 
SELECT 'editor',  id, 123 
		FROM person 
		WHERE username = 'bob';

INSERT INTO website_role (role_type, developer, website) 
SELECT 'admin',  id, 123 
		FROM person 
		WHERE username = 'charlie';
		
//twitter

INSERT INTO website_role (role_type, developer, website) 
SELECT 'owner',  id, 234 
		FROM person 
		WHERE username = 'bob';
		
INSERT INTO website_role (role_type, developer, website) 
SELECT 'editor',  id, 234 
		FROM person 
		WHERE username = 'charlie';

INSERT INTO website_role (role_type, developer, website) 
SELECT 'admin',  id, 234 
		FROM person 
		WHERE username = 'alice';
		
//wikipedia

INSERT INTO website_role (role_type, developer, website) 
SELECT 'owner',  id, 345 
		FROM person 
		WHERE username = 'charlie';
		
INSERT INTO website_role (role_type, developer, website) 
SELECT 'editor',  id, 345 
		FROM person 
		WHERE username = 'alice';

INSERT INTO website_role (role_type, developer, website) 
SELECT 'admin',  id, 345 
		FROM person 
		WHERE username = 'bob';

//CNN	

INSERT INTO website_role (role_type, developer, website) 
SELECT 'owner',  id, 456 
		FROM person 
		WHERE username = 'alice';
		
INSERT INTO website_role (role_type, developer, website) 
SELECT 'editor',  id, 456 
		FROM person 
		WHERE username = 'bob';

INSERT INTO website_role (role_type, developer, website) 
SELECT 'admin',  id, 456 
		FROM person 
		WHERE username = 'charlie';

//CNET

INSERT INTO website_role (role_type, developer, website) 
SELECT 'owner',  id, 567 
		FROM person 
		WHERE username = 'bob';
		
INSERT INTO website_role (role_type, developer, website) 
SELECT 'editor',  id, 567 
		FROM person 
		WHERE username = 'charlie';

INSERT INTO website_role (role_type, developer, website) 
SELECT 'admin',  id, 567 
		FROM person 
		WHERE username = 'alice';

//Gizmodo		

INSERT INTO website_role (role_type, developer, website) 
SELECT 'owner',  id, 678 
		FROM person 
		WHERE username = 'charlie';
		
INSERT INTO website_role (role_type, developer, website) 
SELECT 'editor',  id, 678 
		FROM person 
		WHERE username = 'alice';

INSERT INTO website_role (role_type, developer, website) 
SELECT 'admin',  id, 678 
		FROM person 
		WHERE username = 'bob';
		
//insert into page

INSERT INTO page (id,title, description, created, updated, views, website)
SELECT '123','Home', 'Landing page', CURDATE(), CURDATE(), 123434, id
	FROM website
	WHERE name = 'CNET'; 

INSERT INTO page (id,title, description, created, updated, views, website)
SELECT '234','About', 'Website description', CURDATE(), CURDATE(),234545, id
	FROM website
	WHERE name = 'Gizmodo'; 
	
INSERT INTO page (id,title, description, created, updated, views, website)
SELECT '345','Contact', 'Address,phones and contact info',CURDATE(), CURDATE(),345656, id
	FROM website
	WHERE name = 'Wikipedia'; 
	
INSERT INTO page (id,title, description, created, updated, views, website)
SELECT '456','Preferences', 'Where users can configure their preferences', CURDATE(), CURDATE(),456776, id
	FROM website
	WHERE name = 'CNN'; 	
	
INSERT INTO page (id,title, description, created, updated, views, website)
SELECT '567','Profile', 'Users can configure their personal information',CURDATE(), CURDATE(),567878, id
	FROM website
	WHERE name = 'CNET'; 

//insert into page role

//home

INSERT INTO page_role (role_type, developer, page) 
SELECT 'editor', id, 123 
		FROM person 
		WHERE username = 'alice';
	
INSERT INTO page_role (role_type, developer, page) 
SELECT 'reviewer', id, 123 
		FROM person 
		WHERE username = 'bob';
		
INSERT INTO page_role (role_type, developer, page) 
SELECT 'writer', id, 123 
		FROM person 
		WHERE username = 'charlie';
        
//about

INSERT INTO page_role (role_type, developer, page) 
SELECT 'editor', id, 234 
		FROM person 
		WHERE username = 'bob';
	
INSERT INTO page_role (role_type, developer, page) 
SELECT 'reviewer', id, 234 
		FROM person 
		WHERE username = 'charlie';
		
INSERT INTO page_role (role_type, developer, page) 
SELECT 'writer', id, 234 
		FROM person 
		WHERE username = 'alice';

//contact

INSERT INTO page_role (role_type, developer, page) 
SELECT 'editor', id, 345 
		FROM person 
		WHERE username = 'charlie';
	
INSERT INTO page_role (role_type, developer, page) 
SELECT 'reviewer', id, 345 
		FROM person 
		WHERE username = 'alice';
		
INSERT INTO page_role (role_type, developer, page) 
SELECT 'writer', id, 345 
		FROM person 
		WHERE username = 'bob';		
		
//preferences

INSERT INTO page_role (role_type, developer, page) 
SELECT 'editor', id, 456 
		FROM person 
		WHERE username = 'alice';
	
INSERT INTO page_role (role_type, developer, page) 
SELECT 'reviewer', id, 456 
		FROM person 
		WHERE username = 'bob';
		
INSERT INTO page_role (role_type, developer, page) 
SELECT 'writer', id, 456 
		FROM person 
		WHERE username = 'charlie';	
		
//profile

INSERT INTO page_role (role_type, developer, page) 
SELECT 'editor', id, 567 
		FROM person 
		WHERE username = 'bob';
	
INSERT INTO page_role (role_type, developer, page) 
SELECT 'reviewer', id, 567 
		FROM person 
		WHERE username = 'charlie';
		
INSERT INTO page_role (role_type, developer, page) 
SELECT 'writer', id, 567 
		FROM person 
		WHERE username = 'alice';	
		
//insert into widgets

INSERT INTO widget (id,name,dtype,text,order_type,width,height,url,page)
SELECT '123','head123','heading','Welcome',0, null, null, null, id
FROM page
WHERE title = 'Home';

INSERT INTO widget (id,name,dtype,text,order_type,width,height,url,page)
SELECT '234','post234','html','<p>Lorem</p>',0, null, null, null, id
FROM page
WHERE title = 'About';
	
INSERT INTO widget (id,name,dtype,text,order_type,width,height,url,page)
SELECT '345','head345','heading','Hi',1, null, null, null, id
FROM page
WHERE title = 'Contact';

INSERT INTO widget (id,name,dtype,text,order_type,width,height,url,page)
SELECT '456','intro456','html','<h1>Hi</h1>',2, null, null, null, id
FROM page
WHERE title = 'Contact';

INSERT INTO widget (id,name,dtype,text,order_type,width,height,url,page)
SELECT '567','image345','image',null,3,50,100,"/img/567.png", id
FROM page
WHERE title = 'Contact';

INSERT INTO widget (id,name,dtype,text,order_type,width,height,url,page)
SELECT '678','video456','youtube',null,0,400,300,"https://youtu.be/h67VX51QXiQ", id
FROM page
WHERE title = 'Preferences';

//insert into phones

INSERT INTO phone(phone,primary_number,person)
SELECT '123-234-3456',1,id
FROM person
WHERE username = 'alice';

INSERT INTO phone(phone,primary_number,person)
SELECT '234-345-4566',0,id
FROM person
WHERE username = 'alice';

INSERT INTO phone(phone,primary_number,person)
SELECT '345-456-5677',1,id
FROM person
WHERE username = 'bob';

INSERT INTO phone(phone,primary_number,person)
SELECT '321-432-5435',1,id
FROM person
WHERE username = 'charlie';

INSERT INTO phone(phone,primary_number,person)
SELECT '432-432-5433',0,id
FROM person
WHERE username = 'charlie';

INSERT INTO phone(phone,primary_number,person)
SELECT '543-543-6544',0,id
FROM person
WHERE username = 'charlie';

//insert into address

INSERT INTO address(street1,street2,city,state,zip,primary_address,person) 
 SELECT '123 Adam St.',null,'Alton',null, 01234,1,id FROM person WHERE username = 'alice'
 
INSERT INTO address(street1,street2,city,state,zip,primary_address,person)
SELECT '234 Birch St.',null,'Boston',null, 02345,0,id
FROM person
WHERE username = 'alice';

INSERT INTO address(street1,street2,city,state,zip,primary_address,person)
SELECT '345 Charles St.',null,'Chelms',null, 03455,1,id
FROM person
WHERE username = 'bob';

INSERT INTO address(street1,street2,city,state,zip,primary_address,person)
SELECT '456 Down St.',null,'Dalton',null, 04566,0,id
FROM person
WHERE username = 'bob';


INSERT INTO address(street1,street2,city,state,zip,primary_address,person)
SELECT '543 East St.',null,'Everett',null, 01112,0,id
FROM person
WHERE username = 'bob';

INSERT INTO address(street1,street2,city,state,zip,primary_address,person)
SELECT '654 Frank St',null,'Foulton',null, 04322,1,id
FROM person
WHERE username = 'charlie';

	
        




	