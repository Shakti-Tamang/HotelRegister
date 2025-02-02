-- V1__Create_images_table.sql
CREATE TABLE images (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imageUrl VARCHAR(255) NOT NULL,
    publicId VARCHAR(255) NOT NULL,
);
