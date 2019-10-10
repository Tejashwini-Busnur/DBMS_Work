//Page

//after insert

CREATE DEFINER=`admin`@`%` TRIGGER `cs5200_fall2019_busnur`.`page_role_AFTER_INSERT` AFTER INSERT ON `page_role` FOR EACH ROW
BEGIN
IF NEW.role_type = 'owner'   OR NEW.role_type = 'admin' THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'create', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'update', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'delete', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
   	
    END;
END IF; 

IF NEW.role_type = 'writer'  THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'create', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'update', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 

    END;
END IF; 

IF NEW.role_type = 'editor'  THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'update', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 

    END;
END IF; 

IF NEW.role_type = 'reviewer'  THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	
    END;
END IF; 


END


//after update


CREATE DEFINER=`admin`@`%` TRIGGER `cs5200_fall2019_busnur`.`page_role_AFTER_UPDATE` AFTER UPDATE ON `page_role` FOR EACH ROW
BEGIN
DELETE FROM page_privilege WHERE OLD.developer = page_privilege.developer   AND page_privilege.page = OLD.page; 
IF NEW.role_type = 'owner'   OR NEW.role_type = 'admin' THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'create', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'update', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'delete', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
   	
    END;
END IF; 

IF NEW.role_type = 'writer'  THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'create', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'update', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 

    END;
END IF; 

IF NEW.role_type = 'editor'  THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'update', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 

    END;
END IF; 

IF NEW.role_type = 'reviewer'  THEN
	BEGIN
	INSERT INTO page_privilege (privilege, developer, page) 
    SELECT 'read', developer, page
		FROM page_role
        WHERE developer = NEW.developer AND page = NEW.page; 
	
    END;
END IF; 


END

//after delete

CREATE DEFINER=`admin`@`%` TRIGGER `cs5200_fall2019_busnur`.`page_role_AFTER_DELETE` AFTER DELETE ON `page_role` FOR EACH ROW
BEGIN
DELETE FROM page_privilege WHERE page_role.developer = page_priviledge.developer   AND page_priviledge.page = page_role.page; 
END

//website triggers

//after insert
CREATE DEFINER=`admin`@`%` TRIGGER `cs5200_fall2019_busnur`.`website_role_AFTER_INSERT` AFTER INSERT ON `website_role` FOR EACH ROW
BEGIN
IF NEW.role_type = 'owner'   OR NEW.role_type = 'admin' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'create', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website; 
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'update', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website; 
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'delete', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;         
END;
END IF;
IF NEW.role_type = 'writer' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'create', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website; 
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'update', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;      
END;
END IF;
IF NEW.role_type = 'editor' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'update', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;      
END;
END IF;
IF NEW.role_type = 'reviewer' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;   
END;
END IF;
END

//after update

CREATE DEFINER=`admin`@`%` TRIGGER `cs5200_fall2019_busnur`.`website_role_AFTER_UPDATE` AFTER UPDATE ON `website_role` FOR EACH ROW
BEGIN
DELETE FROM website_privilege WHERE old.developer = website_privilege.developer   AND old.website = website_privilege.website;  
IF NEW.role_type = 'owner'   OR NEW.role_type = 'admin' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'create', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website; 
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'update', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website; 
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'delete', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;         
END;
END IF;
IF NEW.role_type = 'writer' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'create', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website; 
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'update', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;      
END;
END IF;
IF NEW.role_type = 'editor' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'update', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;      
END;
END IF;
IF NEW.role_type = 'reviewer' THEN
BEGIN
INSERT INTO website_privilege (privilege, developer, website) 
    SELECT 'read', developer, website
		FROM website_role
        WHERE developer = NEW.developer AND website = NEW.website;   
END;
END IF;
END

//after delete

CREATE DEFINER=`admin`@`%` TRIGGER `cs5200_fall2019_busnur`.`website_role_AFTER_DELETE` AFTER DELETE ON `website_role` FOR EACH ROW
BEGIN
DELETE FROM website_privilege WHERE website_role.developer = website_privilege.developer   AND website_role.website = website_privilege.website; 
END