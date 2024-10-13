CREATE TABLE IF NOT EXISTS university (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS faculty (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255),
     university_id BIGINT,
     FOREIGN KEY (university_id) REFERENCES university(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    age INT,
    signContractDate DATE,
    onBudget BOOLEAN,
    abbr VARCHAR(100),
    faculty_id BIGINT,
    university_id BIGINT,
    FOREIGN KEY (faculty_id) REFERENCES faculty(id) ON DELETE SET NULL,
    FOREIGN KEY (university_id) REFERENCES university(id) ON DELETE SET NULL
);