--changeset Roman:create-appointment-table
CREATE TABLE appointment (
   id SERIAL primary key  NOT NULL,
   doctor_id BIGINT NOT NULL,
   patient_id BIGINT NOT NULL,
   address_id BIGINT NOT NULL,
   date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   FOREIGN KEY (address_id) REFERENCES address (id),
   FOREIGN KEY (doctor_id) REFERENCES doctor (id),
   FOREIGN KEY (patient_id) REFERENCES patient (id)
);
