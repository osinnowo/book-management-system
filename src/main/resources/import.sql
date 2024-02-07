-- This file is used to populate the database with some initial data

-- Insert some initial data into the categories table
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (1, 'Fiction', 'Books that are not based on real events or people', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (2, 'Non-fiction', 'Books that are based on real events or people', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (3, 'Science Fiction', 'Books that speculate on future scientific and technological advancements', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (4, 'Mystery', 'Books that involve solving a crime or puzzle', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (5, 'Thriller', 'Books that create excitement and tension in the reader', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (6, 'Romance', 'Books that focus on romantic relationships', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (7, 'Horror', 'Books that aim to scare or unsettle the reader', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (8, 'Biography', 'Books that tell the story of a persons life written by someone else', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (9, 'History', 'Books that examine past events, people, and societies', CURRENT_DATE, CURRENT_DATE, false);
INSERT INTO categories (id, name, description, date_created, date_modified, is_soft_deleted) VALUES (10, 'Self-help', 'Books that provide advice and guidance on personal growth and improvement', CURRENT_DATE, CURRENT_DATE, false);

