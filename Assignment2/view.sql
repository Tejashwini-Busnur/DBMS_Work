
//create view

CREATE VIEW `   developer_roles_and_privileges` AS
SELECT p.first_name,p.last_name,p.username,p.email,w.name,w.visits AS website_visits ,w.updated AS website_updated,wr.role_type AS w_role, wp.privilege AS website_privilege,
	page.title,page.views, page.updated AS page_updated,pr.role_type AS page_role,pp.privilege AS page_privilege
    FROM person p
	JOIN developer d ON p.id = d.person
	JOIN website_role wr ON d.person = wr.developer
	JOIN website w ON wr.website = w.id
	JOIN website_privilege wp ON wp.developer = d.person
	AND wp.website = w.id
	LEFT JOIN page ON w.id = page.website
	LEFT JOIN page_role pr ON page.id = pr.page
	AND d.person = pr.developer
	LEFT JOIN page_privilege pp ON page.id = pp.page
	AND d.person = pp.developer;