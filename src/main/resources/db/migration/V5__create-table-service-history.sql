create table service_history(
    service_id VARCHAR(36) PRIMARY KEY,
    name_service VARCHAR(255),
    creation_date DATE
);

create table pets_tutor_history_service(
  id int AUTO_INCREMENT primary key,
  pet_id VARCHAR(36),
  tutor_id VARCHAR(36),
  service_history_id VARCHAR(36),
  FOREIGN KEY (pet_id) REFERENCES pet(id),
  FOREIGN KEY (tutor_id) REFERENCES person(id_person),
  FOREIGN KEY (service_history_id) REFERENCES service_history(service_id)
)