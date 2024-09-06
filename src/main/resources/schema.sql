CREATE TABLE partner  (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    companyName VARCHAR(255),
    ref VARCHAR(255),
    locale VARCHAR(255),
    expires TIMESTAMP 
);
