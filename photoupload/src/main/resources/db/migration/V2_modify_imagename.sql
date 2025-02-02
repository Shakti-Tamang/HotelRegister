-- V2__Modify_images_table.sql
ALTER TABLE images ADD COLUMN name VARCHAR(255);
ALTER TABLE images CHANGE imageUrl img_url VARCHAR(500);
