--changeset Roman:create-table-address
CREATE TABLE address (
   id serial primary key NOT NULL,
   city VARCHAR(255) NOT NULL,
   street VARCHAR(255) NOT NULL,
   house INTEGER NOT NULL,
   UNIQUE (city, street, house)
);