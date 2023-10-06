create database EasyBank;

\c EasyBank;
create table client (
                        code varchar(20) primary key ,
                        nom varchar(50) not null,
                        prenom varchar(50) not null,
                        dateNaissance date not null,
                        telephone varchar(50) not null,
                        adresse varchar(50) not null
);

CREATE TABLE agence (
                        code serial primary key,
                        nom VARCHAR(255),
                        adresse VARCHAR(255),
                        telephone VARCHAR(20)
);


create table Employe (
                         matricule varchar(20) primary key,
                         nom varchar(50) not null,
                         prenom varchar(50) not null,
                         dateNaissance date not null,
                         telephone varchar(50) not null,
                         dateDeRecrutement date not null,
                         adresseEmail varchar(50) not null
);

CREATE TABLE empagence (
                           id int serial primary key,
                           agence_code int,
                           emp_mat VARCHAR(255),
                           primary key (id,Emp_mat,agence_code),
                           foreign key (Emp_mat) references Employe(matricule) on delete cascade on update cascade,
                           foreign key (agence_code) references agence(code) on delete cascade on update cascade
);


create table compte(
                       code varchar(20) primary key,
                       solde float not null,
                       dateCreation date not null ,
                       etat varchar(20) not null,
                       client_id varchar(20) not null,
                       Emp_mat varchar(20) not null,
                       agence_code VARCHAR(20),
                       foreign key (client_id) references client(code) on delete cascade on update cascade,
                       foreign key (Emp_mat) references employe(matricule) on delete cascade on update cascade,
                       foreign key (agence_code) references agence(code) on delete cascade on update cascade);

create table CompteCourant (
                               code varchar(20) primary key,
                               decouvert float not null,
                               foreign key (code) references Compte(code) on delete cascade on update cascade
);
create table CompteEpargne (
                               code varchar(20) primary key,
                               taux float not null,
                               foreign key (code) references Compte(code) on delete cascade on update cascade
);

create table Mission (
                         code serial primary key,
                         nom varchar(50) not null,
                         description varchar(50) not null
);
create table Operation (
                           numero serial primary key,
                           dateOperation date not null,
                           montant float not null,
                           typeOp varchar(20) not null,
                           compte_id varchar(20) not null,
                           Emp_mat varchar(20) not null,
                           FOREIGN KEY (Emp_mat) REFERENCES Employe(matricule) ON DELETE CASCADE ON UPDATE CASCADE,
                           FOREIGN KEY (compte_id) REFERENCES CompteCourant(code) ON DELETE CASCADE ON UPDATE CASCADE ,
                           FOREIGN KEY (compte_id) REFERENCES CompteEpargne(code) ON DELETE CASCADE ON UPDATE CASCADE
);
create table affectation(
                            id serial,
                            Emp_mat varchar(20),
                            codeMission int,
                            dateChangement date not null,
                            primary key (id,Emp_mat,codeMission),
                            foreign key (Emp_mat) references Employe(matricule) on delete cascade on update cascade,
                            foreign key (codeMission) references Mission(code) on delete cascade on update cascade
);

ALTER TABLE empagence
    ADD date_affectation DATE DEFAULT CURRENT_DATE ;

ALTER TABLE compte
    ALTER COLUMN dateCreation SET DEFAULT CURRENT_DATE;


CREATE TABLE transactions (
                              numero serial PRIMARY KEY,
                              montant FLOAT,
                              source_id VARCHAR(255),
                              destinatair_id VARCHAR(255),
                              date DATE default CURRENT_DATE,
                              FOREIGN KEY (source_id) REFERENCES compte(code),
                              FOREIGN KEY (destinatair_id) REFERENCES compte(code)
);