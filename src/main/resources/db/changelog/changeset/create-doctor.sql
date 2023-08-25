--changeset Roman:create-doctor-table
CREATE TABLE doctor (
  id SERIAL primary key  NOT NULL,
   specialization VARCHAR(255),
   full_name VARCHAR(255) NOT NULL,
   age INTEGER NOT NULL,
   UNIQUE (full_name, specialization)
);
