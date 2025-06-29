CREATE TABLE IF NOT EXISTS students
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE,
    phone           VARCHAR(14)  NOT NULL UNIQUE,
    age             INT          NOT NULL,
    enrollment_date DATE         NOT NULL
);

ALTER TABLE IF EXISTS students
    ADD COLUMN IF NOT EXISTS degree FLOAT;

ALTER TABLE IF EXISTS students
    ADD COLUMN IF NOT EXISTS gender VARCHAR(6);


