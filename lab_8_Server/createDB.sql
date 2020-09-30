CREATE SEQUENCE sequence_id;

CREATE SEQUENCE sequence_user_id;

CREATE TABLE users (
                       id INT PRIMARY KEY,
                       login VARCHAR(256) NOT NULL,
                       password VARCHAR(256),
                       salt VARCHAR(256)
);

CREATE TABLE studyGroup (
                            id INT PRIMARY KEY,
                            name VARCHAR(256) NOT NULL,
                            Coordinates_x FLOAT,
                            Coordinates_y INT,
                            creationDate TIMESTAMP,
                            studentsCount INT,
                            expelledStudents INT,
                            averageMark FLOAT,
                            semesterEnum VARCHAR(10) NOT NULL,
                            Person_name VARCHAR(256) NOT NULL,
                            Person_height FLOAT,
                            Person_weight INT,
                            Location_x FLOAT,
                            Location_y INT,
                            Location_z INT,
                            Location_name VARCHAR(256) NOT NULL,
                            user_id INT REFERENCES users (id),
                            Color VARCHAR(50)
);