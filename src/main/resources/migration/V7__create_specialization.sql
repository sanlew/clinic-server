CREATE TABLE  IF NOT EXISTS SPECIALIZATION (
   ID  BIGSERIAL NOT NULL,
   DESCRIPTION VARCHAR(255),
   NAME VARCHAR(255)NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE  IF NOT EXISTS DOCTOR (
   ID  BIGSERIAL NOT NULL,
   FIRST_NAME VARCHAR(255) NOT NULL,
   LAST_NAME VARCHAR(255) NOT NULL,
   SPECIALIZATION_ID BIGSERIAL NOT NULL,
   FOREIGN KEY (SPECIALIZATION_ID) REFERENCES SPECIALIZATION (ID),
   PRIMARY KEY (ID)
);
