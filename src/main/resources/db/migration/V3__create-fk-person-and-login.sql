alter table login add column person_login_id varchar(36),
add constraint fk_login_person foreign key (person_login_id) references person(id_person);
