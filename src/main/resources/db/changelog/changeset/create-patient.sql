--changeset Roman:create-patient-table
CREATE TABLE patient (
  id SERIAL primary key  NOT NULL,
   full_name VARCHAR(255) NOT NULL,
   phone_number VARCHAR(255) NOT NULL,
   age INTEGER,
   UNIQUE (phone_number)
);
