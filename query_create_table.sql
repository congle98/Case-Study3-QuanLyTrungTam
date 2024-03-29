CREATE DATABASE DEMO_CASE_STUDY3;
USE DEMO_CASE_STUDY3;
CREATE TABLE ADMIN(
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      email varchar(255) not null unique ,
                      password varchar(255) not null
);
create table address(
                        id int primary key auto_increment,
                        name varchar(255) not null
);
create table status(
                               id int primary key auto_increment,
                               name varchar(255)
);
create table teacher(
                        id int primary key auto_increment,
                        name varchar(255) not null ,
                        email varchar(255) not null unique ,
                        password varchar(255) not null ,
                        url_img varchar(255),
                        address_id int,
                        dob date,
                        status_id int,
                        foreign key (status_id) references status(id),
                        FOREIGN KEY (address_id) references address(id)
);
create table supervisor(
                           id int primary key auto_increment,
                           name varchar(255) not null ,
                           email varchar(255) not null unique ,
                           password varchar(255) not null ,
                           address_id int,
                           url_img varchar(255),
                           dob date,
                           status_id int,
                           foreign key (status_id) references status(id),
                           FOREIGN KEY (address_id) references address(id)
);
create table course(
                       id int primary key auto_increment,
                       name varchar(255) not null ,
                       price double not null

);
create table class(
                      id int primary key auto_increment,
                      name varchar(255) not null ,
                      teacher_id int,
                      course_id int,
                      FOREIGN KEY (teacher_id) references teacher(id),
                      foreign key (course_id) references course(id)
);

create table module(
                       id int primary key auto_increment,
                       name varchar(255),
                       class_id int,
                       date_start date,
                       foreign key (class_id) references  class(id)
);
create table student(
                        id int primary key  auto_increment,
                        name varchar(255) not null ,
                        email varchar(255) not null unique ,
                        password varchar(255) not null ,
                        address_id int,
                        class_id int,
                        dob date,
                        url_img varchar(255),
                        status_id int,
                         foreign key (status_id) references status(id),
                        foreign key (class_id) references class(id),
                        foreign key (address_id) references address(id)

);


create table student_module(
                               id int primary key auto_increment,
                               student_id int,
                               module_id int,
                               date_end date,
                               score double not null ,
                               foreign key (student_id) references student(id),
                               foreign key (module_id) references module(id)
);
create table blog(
                     id int auto_increment primary key ,
                     description varchar(255),
                     date date,
                     class_id int,
                     foreign key (class_id) references class(id)
);




insert into address(name) value ('ha noi');
insert into address(name) value ('hai phong');
insert into address(name) value ('bac ninh');
insert into address(name) value ('phu tho');

insert into status(name) value ('dang hoc');
insert into status(name) value ('da tot nghiep');
insert into status(name) value ('thoi hoc');
insert into status(name) value ('dang cong tac');
insert into status(name) value ('da nghi viec');



insert into teacher(name, email, password, url_img, address_id, dob,status_id) VALUE
    ('kieu anh','kieuanh@gmail.com','123456','img1',1,'1990-10-20',4);
insert into teacher(name, email, password, url_img, address_id, dob,status_id) VALUE
    ('thay tuan','thaytuan@gmail.com','12345678','img2',2,'1980-02-20',4);
insert into teacher(name, email, password, url_img, address_id, dob,status_id) VALUE
    ('thay huan','thayhuan@gmail.com','123456789','img3',3,'1992-11-22',4);

insert into course(name, price) VALUE ('java',60000000);
insert into course(name, price) VALUE ('python',50000000);
insert into course(name, price) VALUE ('php',40000000);



insert into class(name, teacher_id, course_id) value ('c0221i1',1,1);
insert into class(name, teacher_id, course_id) value ('c1020k2',2,2);
insert into class(name, teacher_id, course_id) value ('c1119d3',3,3);

insert into admin(email, password) VALUE ('cong@gmail.com','123456');
insert into admin(email, password) VALUE ('ha@gmail.com','123456');
insert into admin(email, password) VALUE ('tung@gmail.com','123456');

insert into module(name, class_id, date_start) VALUE ('module1java',1,'2020-01-20');
insert into module(name, class_id, date_start) VALUE ('module2java',1,'2020-02-20');
insert into module(name, class_id, date_start) VALUE ('module3java',1,'2020-03-20');
insert into module(name, class_id, date_start) VALUE ('module4java',1,'2020-04-20');
insert into module(name, class_id, date_start) VALUE ('module5java',1,'2020-05-20');
insert into module(name, class_id, date_start) VALUE ('module6java',1,'2020-06-20');

insert into module(name, class_id, date_start) VALUE ('module1php',2,'2021-02-15');
insert into module(name, class_id, date_start) VALUE ('module2php',2,'2021-03-15');
insert into module(name, class_id, date_start) VALUE ('module3php',2,'2021-04-15');
insert into module(name, class_id, date_start) VALUE ('module4php',2,'2021-05-15');
insert into module(name, class_id, date_start) VALUE ('module5php',2,'2021-06-15');
insert into module(name, class_id, date_start) VALUE ('module6php',2,'2021-07-15');

insert into module(name, class_id, date_start) VALUE ('module1python',3,'2020-07-10');
insert into module(name, class_id, date_start) VALUE ('module2python',3,'2020-08-10');
insert into module(name, class_id, date_start) VALUE ('module3python',3,'2020-09-10');
insert into module(name, class_id, date_start) VALUE ('module4python',3,'2020-10-10');
insert into module(name, class_id, date_start) VALUE ('module5python',3,'2020-11-10');
insert into module(name, class_id, date_start) VALUE ('module6python',3,'2020-12-10');




insert into supervisor(name, email, password, address_id, url_img, dob,status_id) VALUE
    ('giao vu 1','giaovu1@gmail.com','123456',2,'anhgiaovu','1997-12-21',4);

insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh1','hocsinh1@gmail.com','123456',1,1,'1998-12-15','anhhocsinh1',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh2','hocsinh2@gmail.com','123456',2,1,'1997-12-15','anhhocsinh2',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh3','hocsinh3@gmail.com','123456',3,1,'1996-12-15','anhhocsinh3',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh4','hocsinh4@gmail.com','123456',2,1,'1995-12-15','anhhocsinh4',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh5','hocsinh5@gmail.com','123456',3,2,'1994-12-15','anhhocsinh5',3);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh6','hocsinh6@gmail.com','123456',1,3,'1993-12-15','anhhocsinh6',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh7','hocsinh7@gmail.com','123456',4,2,'1992-12-15','anhhocsinh7',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh8','hocsinh8@gmail.com','123456',4,2,'1991-12-15','anhhocsinh8',2);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh9','hocsinh9@gmail.com','123456',1,2,'1990-05-15','anhhocsinh9',2);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh10','hocsinh10@gmail.com','123456',1,3,'1995-04-15','anhhocsinh10',1);
insert into student(name, email, password, address_id, class_id, dob, url_img, status_id) VALUE
    ('hocsinh11','hocsinh11@gmail.com','123456',1,3,'1996-02-15','anhhocsinh11',1);



insert into student_module(student_id, module_id, date_end, score) VALUE (1,1,'2020-2-19',80);
insert into student_module(student_id, module_id, date_end, score) VALUE (1,2,'2020-3-19',83);
insert into student_module(student_id, module_id, date_end, score) VALUE (1,3,'2020-4-19',84);
insert into student_module(student_id, module_id, date_end, score) VALUE (1,4,'2020-5-19',88);
insert into student_module(student_id, module_id, date_end, score) VALUE (1,5,'2020-6-19',92);
insert into student_module(student_id, module_id, date_end, score) VALUE (1,6,'2020-7-19',70);

insert into student_module(student_id, module_id, date_end, score) VALUE (2,1,'2020-2-19',60);
insert into student_module(student_id, module_id, date_end, score) VALUE (2,2,'2020-3-19',62);
insert into student_module(student_id, module_id, date_end, score) VALUE (2,3,'2020-4-19',71);
insert into student_module(student_id, module_id, date_end, score) VALUE (2,4,'2020-5-19',73);
insert into student_module(student_id, module_id, date_end, score) VALUE (2,5,'2020-6-19',78);
insert into student_module(student_id, module_id, date_end, score) VALUE (2,5,'2020-7-19',80);


insert into blog(description, date, class_id) VALUE ('hoc tap cho doang hoang','2021-05-12',1);
insert into blog(description, date, class_id) VALUE ('nghien game it thoi','2021-06-12',2);
insert into blog(description, date, class_id) VALUE ('hom nay chung ta se hoc bai bootstrap','2021-07-12',3);




