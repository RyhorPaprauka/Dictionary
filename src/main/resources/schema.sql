DROP TABLE IF EXISTS dictionary_1;
DROP TABLE IF EXISTS dictionary_2;

CREATE TABLE dictionary_1
(
    word         VARCHAR(50) NOT NULL UNIQUE,
    reference_id BIGINT      PRIMARY KEY
);

CREATE TABLE dictionary_2
(
    word         VARCHAR(50) NOT NULL UNIQUE,
    reference_id BIGINT      PRIMARY KEY
);