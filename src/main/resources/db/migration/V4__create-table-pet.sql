create table pet(
    id VARCHAR(36) PRIMARY KEY,
    pet_name VARCHAR(255) NOT NULL,
    pet_weight VARCHAR(60),
    pet_birthday DATE,
    specie VARCHAR(255),
    race VARCHAR(255),
    gender INTEGER
);

create table pets_tutor(
   id int AUTO_INCREMENT primary key,
   pet_id VARCHAR(36),
   tutor_id VARCHAR(36),
   FOREIGN KEY (pet_id) REFERENCES pet(id),
   FOREIGN KEY (tutor_id) REFERENCES person(id_person)
)