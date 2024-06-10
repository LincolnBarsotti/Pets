create table service_history(
  service_id VARCHAR(36) PRIMARY KEY,
  person_id VARCHAR(36) NOT NULL,
    animal_id VARCHAR(36) NOT NULL,
    update_history_date DATETIME NOT NULL,
    service_name VARCHAR(80)
);