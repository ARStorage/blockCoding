use blockcoding;

drop table Teacher;
drop table Student;
drop table quiz;
drop table block;
drop table Status;
drop table solution;

create table Teacher(
 id varchar(10) primary key NOT NULL,
 pw varchar(20) NOT NULL,
 name varchar(10) NOT NULL
);

select *
from Teacher;

INSERT INTO `blockcoding`.`Teacher` (`id`, `pw`, `name`) VALUES ('aranbae', '1234', '배아란');
INSERT INTO `blockcoding`.`Teacher` (`id`, `pw`, `name`) VALUES ('minjikang', '1234', '강민지');
INSERT INTO `blockcoding`.`Teacher` (`id`, `pw`, `name`) VALUES ('daheeoh', '1234', '오다희');


create table Student(
 id varchar(10) primary key NOT NULL,
 pw varchar(20) NOT NULL,
 name varchar(10) NOT NULL,
 successrate Double NOT NULL,
 teacherid varchar(10), #FK
 FOREIGN KEY (teacherid) REFERENCES Teacher(id)
);

select *
from Student;

INSERT INTO `blockcoding`.`Student` (`id`, `pw`, `name`, `successrate`, `teacherid`) VALUES ('201810013', '1234', '강민자', '0', 'minjikang');
INSERT INTO `blockcoding`.`Student` (`id`, `pw`, `name`, `successrate`, `teacherid`) VALUES ('201810675', '1234', '조아란', '0', 'aranbae');
INSERT INTO `blockcoding`.`Student` (`id`, `pw`, `name`, `successrate`, `teacherid`) VALUES ('201810899', '1234', '이다희', '0', 'daheeoh');


create table quiz(
quizid int primary key NOT NULL,
contents varchar(100) NOT NULL,
studentid varchar(10),
teacherid varchar(10),
FOREIGN KEY (teacherid) REFERENCES Teacher(id),
FOREIGN KEY (studentid) REFERENCES Student(id)
);

select *
from quiz;

INSERT INTO `blockcoding`.`quiz` (`quizid`, `contents`, `teacherid`) VALUES ('1', '공 x로 10만큼 움직이기', 'aranbae');
INSERT INTO `blockcoding`.`quiz` (`quizid`, `contents`, `teacherid`) VALUES ('2', '공 y로 10만큼 움직이기', 'minjikang');
INSERT INTO `blockcoding`.`quiz` (`quizid`, `contents`, `studentid`) VALUES ('3', '공 x로 10만큼 5번 움직이기', '201810899');


create table block(
 id int primary key NOT NULL,
 color varchar(10) NOT NULL,
 func varchar(45) NOT NULL,
 division varchar(10) NOT NULL #스크래치처럼 제어문인지, ... 분류
);  

select *
from block;
INSERT INTO `blockcoding`.`block` (`id`, `color`, `func`, `division`) VALUES ('1', 'PURPLE', 'x로 10만큼 움직이기', '움직이기');
INSERT INTO `blockcoding`.`block` (`id`, `color`, `func`, `division`) VALUES ('2', 'PURPLE', 'y로 10만큼 움직이기', '움직이기');

create table Status(
 studentid varchar(10) NOT NULL, #학생아이디
 quizid int NOT NULL, #퀴즈아이디
 status int NOT NULL,
 FOREIGN KEY (studentid) REFERENCES Student(id),
 FOREIGN KEY (quizid) REFERENCES Quiz(quizid)
);

select *
from Status;

INSERT INTO `blockcoding`.`Status` (`studentid`, `quizid`, `status`)
VALUES ('201810675', 1,0);#0아직 풀지 않음, 1완벽히 품

create table solution(
 quizid int NOT NULL,
 num int NOT NULL,
 blockid int NOT NULL,
 FOREIGN KEY (blockid) REFERENCES block(id),
 primary key(quizid, num) #복합키
);
select *
from solution;

INSERT INTO `blockcoding`.`solution` (`quizid`, `num`, `blockid`) VALUES ('1', '1', '1');
INSERT INTO `blockcoding`.`solution` (`quizid`, `num`, `blockid`) VALUES ('2', '1', '2');
