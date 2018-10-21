INSERT INTO users(
            id, active, changed_password, confirmed, email, first_name, last_name, password)
  VALUES (1, true, false, true,'admin@admin', 'S', 'L',/*admin*/'$2a$10$QPYWJlHN3uxwsyAWm6yLKuvPcXIjvV9HUR6jpuuAk5VBugoYN9/uG');

  
INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USERS_AUTHORITIES(USER_ID, AUTHORITY_ID) VALUES (1, 2);


