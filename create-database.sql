create table patient(
    id serial primary key,
    tc varchar(11) not null unique,
    name varchar(50) not null,
    surname varchar(50) not null,
    phone varchar(11) not null,
    address text,
    blood varchar(10),
    alergies text,
    diseases text,
    insurance varchar(50)
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
   patient_id int references patient(id),
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
INSERT INTO account (username, name, surname, phone, password, role, polyclinic_id)
VALUES
    ('hakime', 'ramazan', 'agaslan', '05515555155', '123456', 'doktor', 2),
    ('canan', 'canan', 'karatay', '05350231529', '123456', 'doktor', 4),
    ('mehmet', 'mehmet', 'yılmaz', '05556667788', '123456', 'doktor', 3),
    ('ayse', 'ayse', 'ozcan', '05443332211', '123456', 'doktor', 1),
    ('ali', 'ali', 'demir', '05557778899', '123456', 'doktor', 5),
    ('elif', 'elif', 'kaya', '05335556677', '123456', 'doktor', 2),
    ('burak', 'burak', 'tekin', '05446667788', '123456', 'doktor', 4),
    ('eda', 'eda', 'cinar', '05558889900', '123456', 'doktor', 3),
    ('zeynep', 'zeynep', 'yıldız', '05443331122', '123456', 'doktor', 1),
    ('kerem', 'kerem', 'şahin', '05338889900', '123456', 'doktor', 5);

-- bas hekim icin
INSERT INTO account (username, name, surname, phone, password, role)
VALUES
    ('ali_veli', 'Ali', 'Veli', '05551234567', '123456', 'bashekim'),
    ('ayse_yilmaz', 'Ayşe', 'Yılmaz', '05556677888', '123456', 'bashekim'),
    ('mehmet_sahin', 'Mehmet', 'Şahin', '05336669999', '123456', 'bashekim'),
    ('fatma_kaya', 'Fatma', 'Kaya', '05443332211', '123456', 'bashekim'),
    ('ahmet_yildiz', 'Ahmet', 'Yıldız', '05324446677', '123456', 'bashekim'),
    ('zeynep_alisan', 'Zeynep', 'Alişan', '05557778899', '123456', 'bashekim'),
    ('mustafa_celik', 'Mustafa', 'Çelik', '05442223344', '123456', 'bashekim'),
    ('elif_arik', 'Elif', 'Arık', '05338889900', '123456', 'bashekim'),
    ('murat_gunes', 'Murat', 'Güneş', '05559998877', '123456', 'bashekim'),
    ('sevil_aydin', 'Sevil', 'Aydın', '05446667788', '123456', 'bashekim');


-- randevu gorevlisi ekleme
INSERT INTO account (username, name, surname, phone, password, role)
VALUES
    ('ali', 'Neslihan', 'Ağaslan', '05350231529', '123456', 'randevugorevlisi'),
    ('ayse', 'Derya', 'Demir', '05551112233', '123456', 'randevugorevlisi'),
    ('fatma', 'Zeynep', 'Kaya', '05443334455', '123456', 'randevugorevlisi'),
    ('mehmet', 'Aslı', 'Öztürk', '05336667788', '123456', 'randevugorevlisi'),
    ('ahmet', 'Elif', 'Yılmaz', '05557778899', '123456', 'randevugorevlisi'),
    ('aylin', 'Burak', 'Şahin', '05448889900', '123456', 'randevugorevlisi'),
    ('selim', 'Gizem', 'Aydın', '05339998877', '123456', 'randevugorevlisi'),
    ('eda', 'Onur', 'Koç', '05442221133', '123456', 'randevugorevlisi'),
    ('emre', 'Pelin', 'Serin', '05553334411', '123456', 'randevugorevlisi'),
    ('gizem', 'Cem', 'Turan', '05446665577', '123456', 'randevugorevlisi');

-- hasta ekleme
INSERT INTO account (username, name, surname, phone, password, role)
VALUES
    ('ramazan', 'Ramazan', 'Ağaslan', '05350231529', '123456', 'hasta'),
    ('neslihan', 'Neslihan', 'Ağaslan', '05510531129', '123456', 'hasta'),
    ('derya', 'Derya', 'Demir', '05443332211', '123456', 'hasta'),
    ('asli', 'Aslı', 'Öztürk', '05336667788', '123456', 'hasta'),
    ('ahmet', 'Ahmet', 'Yıldız', '05324446677', '123456', 'hasta'),
    ('elif', 'Elif', 'Yılmaz', '05557778899', '123456', 'hasta'),
    ('gizem', 'Gizem', 'Aydın', '05442223344', '123456', 'hasta'),
    ('onur', 'Onur', 'Koç', '05339998877', '123456', 'hasta'),
    ('pelin', 'Pelin', 'Serin', '05553334411', '123456', 'hasta'),
    ('cem', 'Cem', 'Turan', '05446665577', '123456', 'hasta');

INSERT INTO patient (tc, name, surname, phone, address, blood, alergies, diseases)
VALUES
    ('24913813304', 'Ramazan', 'Ağaslan', '05350231529', 'Gaziantep', 'AB+', 'polen', 'yok'),
    ('24913813305', 'Neslihan', 'Ağaslan', '05510531129', 'Ankara', 'A-', 'arachis', 'yok'),
    ('24913813306', 'Derya', 'Demir', '05443332211', 'İzmir', 'B+', 'yok', 'sedef hastalığı'),
    ('24913813307', 'Aslı', 'Öztürk', '05336667788', 'Bursa', 'O+', 'yaban mersini', 'yok'),
    ('24913813308', 'Ahmet', 'Yıldız', '05324446677', 'Antalya', 'AB-', 'süt', 'yok'),
    ('24913813309', 'Elif', 'Yılmaz', '05557778899', 'Adana', 'A+', 'yok', 'astım'),
    ('24913813310', 'Gizem', 'Aydın', '05442223344', 'Eskişehir', 'AB+', 'sarımsak', 'yok'),
    ('24913813311', 'Onur', 'Koç', '05339998877', 'Trabzon', 'B-', 'yok', 'yok'),
    ('24913813312', 'Pelin', 'Serin', '05553334411', 'İstanbul', 'O+', 'yok', 'soğuk alerjisi'),
    ('24913813313', 'Cem', 'Turan', '05446665577', 'Bodrum', 'A+', 'fındık', 'yok');

-- Veznedar 10 kayıt ekleme
INSERT INTO account (username, name, surname, phone, password, role)
VALUES
    ('veznedar1', 'Ayşe', 'Kara', '05551112233', '123456', 'veznedar'),
    ('veznedar2', 'Mehmet', 'Kurt', '05552223344', '123456', 'veznedar'),
    ('veznedar3', 'Fatma', 'Kaya', '05336669999', '123456', 'veznedar'),
    ('veznedar4', 'Ahmet', 'Demir', '05443332211', '123456', 'veznedar'),
    ('veznedar5', 'Zeynep', 'Yılmaz', '05324446677', '123456', 'veznedar'),
    ('veznedar6', 'Mustafa', 'Arslan', '05557778899', '123456', 'veznedar'),
    ('veznedar7', 'Elif', 'Şahin', '05442223344', '123456', 'veznedar'),
    ('veznedar8', 'Murat', 'Çelik', '05338889900', '123456', 'veznedar'),
    ('veznedar9', 'Sevil', 'Koç', '05559998877', '123456', 'veznedar'),
    ('veznedar10', 'Gizem', 'Aydın', '05446667788', '123456', 'veznedar')

-- 10 kayıt görevlisi ekleme
INSERT INTO account (username, name, surname, phone, password, role)
VALUES
    ('Ali3', 'Ali', 'Kara', '05551112233', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi2', 'Ayşe', 'Kurt', '05552223344', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi3', 'Mehmet', 'Kaya', '05336669999', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi4', 'Fatma', 'Demir', '05443332211', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi5', 'Ahmet', 'Yılmaz', '05324446677', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi6', 'Zeynep', 'Arslan', '05557778899', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi7', 'Mustafa', 'Şahin', '05442223344', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi8', 'Elif', 'Çelik', '05338889900', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi9', 'Murat', 'Koç', '05559998877', '123456', 'kayitgorevlisi'),
    ('kayitgorevlisi10', 'Sevil', 'Aydın', '05446667788', '123456', 'kayitgorevlisi')

-- Treatment tablosuna 10 satır ekleme
INSERT INTO treatment (doctor_id, patient_id, complaint, tests, diagnosis, prescriptions)
VALUES
    (1, 1, 'Baş ağrısı ve halsizlik', 'Kan tahlili, MR', 'Migren', 'İbuprofen'),
    (2, 2, 'Boğaz ağrısı ve ateş', 'Streptokok testi', 'Bademcik enfeksiyonu', 'Antibiyotik'),
    (3, 3, 'Karın ağrısı ve bulantı', 'Ultrason', 'Mide gastriti', 'Antiasit ilaçlar'),
    (4, 4, 'Bel ve sırt ağrısı', 'Röntgen, MR', 'Bel fıtığı', 'Fizik tedavi önerisi'),
    (5, 5, 'Nefes darlığı ve öksürük', 'Akciğer grafisi', 'Astım', 'Bronkodilatörler'),
    (6, 6, 'Baş dönmesi ve kulak çınlaması', 'İşitme testi', 'Meniere hastalığı', 'Diüretikler'),
    (7, 7, 'Kas ağrıları ve halsizlik', 'Kan testleri', 'Fibromiyalji', 'Ağrı kesici ve kas gevşetici'),
    (8, 8, 'Yüksek tansiyon ve baş ağrısı', 'EKG, Holter', 'Hipertansiyon', 'Tansiyon ilaçları'),
    (9, 9, 'Deri döküntüleri ve kaşıntı', 'Cilt muayenesi', 'Alerjik reaksiyon', 'Antihistaminikler'),
    (10, 10, 'Baş ağrısı ve uyuşukluk', 'Nörolojik muayene, EEG', 'Tansiyon düşüklüğü', 'B vitamini takviyesi');


-- appointment ayarla
INSERT INTO appointment (doctor_id, patient_id, polyclinic_id, month, day, hour, minute)
VALUES
    (1, 5, 2, 3, 15, 12, 30),
    (2, 6, 4, 3, 16, 14, 30),
    (3, 7, 2, 3, 17, 10, 0),
    (4, 8, 3, 3, 18, 11, 0),
    (5, 9, 1, 3, 19, 13, 0),
    (6, 10, 4, 3, 20, 9, 30),
    (7, 1, 2, 3, 21, 16, 0),
    (8, 2, 3, 3, 22, 14, 30),
    (9, 3, 1, 3, 23, 12, 0),
    (10, 4, 4, 3, 24, 10, 30);



