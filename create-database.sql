create table patient(
    id serial primary key,
    tc varchar(11) not null unique,
    name varchar(50) not null,
    surname varchar(50) not null,
    phone varchar(11) not null,
    address text,
    blood varchar(10),
    alergies text,
    diseases text
);

create table polyclinic (
    id serial primary key,
    name varchar(50) not null
);


create table account (
    id serial primary key,
    username varchar(50) unique not null,
    name varchar(50) not null,
    surname varchar(50) not null,
    phone varchar(50) not null,
    password varchar(11) not null,
    role text not null,
    polyclinic_id int references polyclinic(id)
);


create table treatment(
   id serial primary key,
   doctor_id int references account(id),
   complaint text,
   tests text,
   diagnosis text,
   prescriptions text
);

-- month: 9 day: 3 hour: 10 minute: 30 -> 03/09/2024 10:30 
-- we have doctor info and patient info 
create table appointment(
   id serial primary key,
   doctor_id int references account(id) not null,
   patient_id int references patient(id) not null,
   polyclinic_id int references polyclinic(id) not null,
   month int not null,
   day int not null,
   hour int not null,
   minute int not null
);


-- poliklinik ekleme sql kodları
insert into polyclinic (name) values ('Kulak Burun Boğaz');
insert into polyclinic (name) values ('Genel Cerrahi');
insert into polyclinic (name) values ('Göz Hastalıkları');
insert into polyclinic (name) values ('Diş Hastalıkları');
insert into polyclinic (name) values ('Cildiye');
insert into polyclinic (name) values ('Dahiliye');
insert into polyclinic (name) values ('Kadın Hastalıkları');

-- doktor kayıt etme
insert into account (username,name,surname,phone,password,role,polyclinic_id) values('hekim1','ramazan','agaslan','05515555155','123456','doktor',2);

insert into account (username,name,surname,phone,password,role,polyclinic_id) values('canan','canan','karatay','05350231529','123456','doktor',4);

-- bas hekim icin
insert into account (username,name,surname,phone,password,role) values('kutsi','kutsi','aslan','05350231529','123456','bashekim');

-- randevu gorevlisi ekleme
insert into account (username,name,surname,phone,password,role) values('nesli','neslihan','ağaslan','05350231529','123456','randevugorevlisi');

-- hasta ekleme
insert into account (username,name,surname,phone,password,role) values('ramo','ramazan','ağaslan','05350231529','123456','hasta');
insert into patient (tc,name,surname,phone,address,blood,alergies,diseases) values ('24913813304','ramazan','agaslan','05510531129','Gaziantep','AB+','yok','yok');

-- appointment ayarla
insert into appointment (doctor_id, patient_id, polyclinic_id, month, day, hour, minute) values (1,5,2,3,15,30);



