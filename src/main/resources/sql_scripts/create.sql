CREATE DATABASE jaxrs_demo;
USE jaxrs_demo;

DROP TABLE IF EXISTS todos;
CREATE TABLE todos
(
    id INT NOT NULL,
    task NVARCHAR(250) NOT NULL,
    due_date DATETIME NOT NULL,
    creation_date DATETIME NOT NULL,
    completed_date DATETIME NULL,
    PRIMARY KEY (id)
);
 
 DROP TABLE IF EXISTS hibernate_sequence;
 CREATE TABLE hibernate_sequence(
     todos INT NOT NULL
 );