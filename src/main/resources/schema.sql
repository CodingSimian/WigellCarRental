CREATE TABLE CARS(
                     ID BIGINT not null PRIMARY KEY AUTO_INCREMENT,
                     AVAILABLE BOOLEAN NOT NULL,
                     BRAND VARCHAR(30) NOT NULL,
                     MODELL VARCHAR(30) NOT NULL,
                     PRICE BIGINT NOT NULL,
                     REGISTRATIONNUMBER VARCHAR(7) NOT NULL
);

CREATE TABLE CUSTOMERS(
                          ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          EMAIL VARCHAR(70) NOT NULL,
                          NAME VARCHAR(60) NOT NULL,
                          PHONE_NMBR INTEGER,
                          USERNAME VARCHAR(40) NOT NULL
);

CREATE TABLE ORDERS(
                       ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       ACTIVE BOOLEAN NOT NULL,
                       DATEOFBOOKING DATE NOT NULL,
                       CAR_ID BIGINT,
                       CUSTOMER_ID BIGINT,
                       FOREIGN KEY (CAR_ID) REFERENCES CARS(ID),
                       FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(ID)
);

CREATE TABLE USERS(
                      USERNAME VARCHAR(50) NOT NULL PRIMARY KEY ,
                      PASSWORD VARCHAR(70) NOT NULL,
                      ENABLED BOOLEAN NOT NULL
);

CREATE TABLE AUTHORITIES(
                            USERNAME VARCHAR(50) NOT NULL ,
                            AUTHORITY VARCHAR(50) NOT NULL,
                            FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME)
);