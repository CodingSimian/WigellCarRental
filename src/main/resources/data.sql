
INSERT INTO Cars(brand,modell,registrationnumber,price,available)
         VALUES('Volvo','S90','ABC123',1200,false),
               ('Volkswagen','Golf','ACK467',900,true),
               ('Dacia','Duster','LAB378',800,true),
               ('Volvo','XC90','HMJ213', 1500,false),
               ('BMW','M3','WIGELL1',1400,true);

INSERT INTO customers(username, name, email, phone_nmbr)
VALUES('xxxtentacion','Greg','Greg@example.com',123456789),
      ('Lil Yachty','Keith','Keith@example.com',09876543),
      ('Tyler the creator','Sanna','Sanna@example.com',5634978),
      ('Gang starr','Amanda','Amanda@example.com',11111111),
      ('The notorious B.I.G', 'Sam','Sam@example.com',9999999);

INSERT INTO Orders(active,dateOfBooking,car_id,customer_id)
VALUES(true,'2023-04-17',1,2),
      (true,'2023-04-25',4,3),
      (false,'2023-04-02',2,5);

INSERT INTO USERS(username,password,enabled)
VALUES('Greg@example.com','{bcrypt}$2y$10$Vk7/b0WilrfdT6iMV2StbOF3peuDI5EEeJkoIxRZ9jEIM/ZXix4Ne',true),
      ('Keith@example.com','{bcrypt}$2y$10$BnPtbsB/l/iE.TAdZSjJG.TTJ.7kxadTYOXns9bU91qQ0nA3z2hW2',true),
      ('Sanna@example.com','{bcrypt}$2y$10$awhR3cNG9tCMyXkouIWsC.mZfxMQthvyGAJZPgSVgxvldGDHAIysC',true),
      ('Amanda@example.com','{bcrypt}$2y$10$WHz9eHmfjYqMgIjsotfT9OZR3j0Q0AEmceL4C1LUye48aZ4j22K62',true),
      ('Sam@example.com','{bcrypt}$2y$10$3G1dPw1xb1HPyz/IscSwkuUIyq/eBVei2pfWcEX8XgHkrc0nv6S1u',true),
      ('Admin','{bcrypt}$2y$10$VK1xS6PabWIuwcnKz4lh..a1mtb9zDZHeUXv7hiqfpcv8eaaRD0ZG',true);

INSERT INTO AUTHORITIES(username,authority)
    VALUES('Greg@example.com','ROLE_CUSTOMER'),
          ('Keith@example.com','ROLE_CUSTOMER'),
          ('Sanna@example.com','ROLE_CUSTOMER'),
          ('Amanda@example.com','ROLE_CUSTOMER'),
          ('Sam@example.com','ROLE_CUSTOMER'),
          ('Admin','ROLE_CUSTOMER'),
          ('Admin','ROLE_ADMIN');








