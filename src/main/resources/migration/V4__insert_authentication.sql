
	INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('clientR', 'resource-server-rest-api',
	/*password*/'$2a$10$lKsb.FOtUbWQGWP24IQu2uyYm.tx0LYIesmQs4fXXoFYTAlOMSufy',
	'read', 'password,authorization_code,refresh_token,implicit', 'USER', 3600, 2592000);

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('clientRW', 'resource-server-rest-api',
	/*password*/'$2a$10$lKsb.FOtUbWQGWP24IQu2uyYm.tx0LYIesmQs4fXXoFYTAlOMSufy',
	'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 3600, 2592000);