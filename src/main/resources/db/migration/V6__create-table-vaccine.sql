CREATE TABLE vaccine (
     id_vaccine VARCHAR(36) PRIMARY KEY ,
     name_vaccine VARCHAR(255) ,
     name_who_registered_vaccine VARCHAR(255) ,
     registration_date_vaccine DATE ,
     vaccine_function VARCHAR(255) ,
     vaccine_batch VARCHAR(255) ,
     vaccine_manufacturer VARCHAR(255)
);

CREATE TABLE vaccine_pet (
     vaccine_id VARCHAR(36),
     pet_id VARCHAR(36),
     FOREIGN KEY (vaccine_id) REFERENCES vaccine(id_vaccine),
     FOREIGN KEY (pet_id) REFERENCES pet(id),
     PRIMARY KEY (vaccine_id, pet_id)
);