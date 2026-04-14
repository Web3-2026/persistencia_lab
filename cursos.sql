CREATE TABLE curso (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(60) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE professor (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(60) NOT NULL,
  email varchar(100) NOT NULL,
  dataNascimento datetime NOT NULL,
  salarioBase double NOT NULL,
  cursoId int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cursoId) REFERENCES curso (id)
);

INSERT INTO curso (nome) VALUES 
  ('Tecnólogo em Análise de Desenvolvimento de Sistemas'),
  ('Engenharia de Aquicultura'),
  ('Bacharelado em Física'),
  ('Ensino Médio');

INSERT INTO professor (nome, email, dataNascimento, salarioBase, cursoId) VALUES 
  ('Alcyon Bennacchyo', 'alcyon.bennacchyo@gmail.com', '1980-05-10 00:00:00', 500.0, 1),
  ('Akana Arrunda de Olanda', 'akana.olanda@gmail.com', '1985-08-15 00:00:00', 520.0, 1),
  ('Pola Anatauke', 'pola.anatauke@gmail.com', '1978-03-22 00:00:00', 550.0, 1),
  ('Danel Di Domenikko', 'danel.domenikko@gmail.com', '1982-11-30 00:00:00', 510.0, 1),
  ('Fabyo Ramosa da Sylva', 'fabyo.sylva@gmail.com', '1988-06-12 00:00:00', 480.0, 1),
  ('Feliphe Alescheydt', 'feliphe.alescheydt@gmail.com', '1983-09-05 00:00:00', 530.0, 2),
  ('Franko Ezequiel Harlo', 'franko.harlo@gmail.com', '1987-01-18 00:00:00', 490.0, 2),
  ('Govane Carloss Sotthe', 'govane.sotthe@gmail.com', '1975-12-25 00:00:00', 580.0, 2),
  ('Umberto Martyns Ben Duzzi', 'umberto.beniduzzi@gmail.com', '1981-04-03 00:00:00', 540.0, 2),
  ('Itammar Pennadieraka', 'itammar.pennadieraka@gmail.com', '1979-07-29 00:00:00', 560.0, 2),
  ('Jefersson Olveirachave', 'jefersson.chave@gmail.com', '1984-02-14 00:00:00', 600.0, 3),
  ('Julyana Hoffmann Quinonez', 'julyana.quinonez@gmail.com', '1986-10-20 00:00:00', 520.0, 3),
  ('Jullyo Cesary Rayer', 'jullyo.royer@gmail.com', '1977-11-11 00:00:00', 570.0, 3),
  ('Kaylla Walkiria Grarmuss', 'kaylla.garmus@gmail.com', '1989-05-05 00:00:00', 470.0, 3),
  ('Leonard Vieira Junyor', 'leonard.junyor@gmail.com', '1980-01-01 00:00:00', 510.0, 4),
  ('Marcy Tiem Saytol', 'marcy.sayto@gmail.com', '1982-08-08 00:00:00', 530.0, 4),
  ('Markos Abrue Santoss', 'markos.santoss@gmail.com', '1976-04-12 00:00:00', 550.0, 4),
  ('Sydny Kleyn', 'sydny.kleyn@gmail.com', '1985-03-30 00:00:00', 540.0, 4);
