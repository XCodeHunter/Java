CREATE DATABASE cadastroAluno;
USE cadastroAluno;


CREATE TABLE campus(
idCampus int primary key auto_increment,
nomeCampus nvarchar(255)
);

CREATE TABLE curso(
idCurso INT PRIMARY KEY auto_increment,
curso nvarchar(255),
periodo nvarchar(255),
idCampus int,
FOREIGN KEY (idCampus) REFERENCES campus(idCampus)
);

CREATE TABLE aluno(
idAluno int primary key auto_increment,
nome nvarchar(255),
rgm int,
dataNascimento nvarchar(255),
cpf nvarchar(255),
email nvarchar(255),
celular nvarchar(255),
cep char(8),
logradouro nvarchar(255),
municipio nvarchar(255),
estado nvarchar(255),
idCurso int,
FOREIGN KEY (idCurso) REFERENCES curso(idCurso)
);

INSERT INTO campus(nomeCampus) VALUES ("TATUAPE"), ("ANALIA FRANCO"), ("PAULISTA");
INSERT INTO curso(curso, periodo, idCampus) values ("PSICOLOGIA","NOTURNO", 1);
INSERT INTO curso(curso, periodo, idCampus) values ("ADS","VESPERTINO", 1);
INSERT INTO curso(curso, periodo, idCampus) values ("ASSS","VESPERTINO", 2);

SELECT * from aluno a 
INNER JOIN curso c ON a.idCurso = c.idCurso
INNER JOIN campus cam ON c.idCampus = cam.idCampus;

SELECT * from curso c;