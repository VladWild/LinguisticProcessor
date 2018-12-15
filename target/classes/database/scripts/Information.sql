DELETE FROM Information WHERE 1=1;

--—уществительные
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'жен', 'им');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'жен', 'рп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'жен', 'дп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'жен', 'вп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'жен', 'тп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'жен', 'пп');

INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'муж', 'им');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'муж', 'рп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'муж', 'дп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'муж', 'вп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'муж', 'тп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'муж', 'пп');

INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'cp', 'им');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'cp', 'рп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'cp', 'дп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'cp', 'вп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'cp', 'тп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'ед', 'cp', 'пп');

INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'муж', 'им');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'муж', 'рп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'муж', 'дп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'муж', 'вп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'муж', 'тп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'муж', 'пп');

INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'жен', 'им');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'жен', 'рп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'жен', 'дп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'жен', 'вп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'жен', 'тп');
INSERT INTO Information (ChR, Od, Chislo, Rod, Padezh) VALUES ('сущ', 'неод', 'мн', 'жен', 'пп');

--Глаголы
INSERT INTO Information (ChR, Forma, Chislo, Rod, Vid, Time) VALUES ('гл', 'неинф', 'ед', 'муж', 'сов', 'прош');
INSERT INTO Information (ChR, Forma, Chislo, Rod, Vid, Time) VALUES ('гл', 'неинф', 'ед', 'жен', 'сов', 'прош');
INSERT INTO Information (ChR, Forma, Chislo, Vid, Time) VALUES ('гл', 'неинф', 'мн', 'сов', 'прош');

INSERT INTO Information (ChR, Forma, Chislo, Rod, Vid, Time) VALUES ('гл', 'неинф', 'ед', 'муж', 'несов', 'прош');
INSERT INTO Information (ChR, Forma, Chislo, Rod, Vid, Time) VALUES ('гл', 'неинф', 'ед', 'жен', 'несов', 'прош');
INSERT INTO Information (ChR, Forma, Chislo, Vid, Time) VALUES ('гл', 'неинф', 'мн', 'несов', 'прош');

--Числительные
INSERT INTO Information (ChR, Forma, Chislo, Rod) VALUES ('числ', 'порядк', 'ед', 'ср');
INSERT INTO Information (ChR, Forma, Chislo, Rod) VALUES ('числ', 'порядк', 'ед', 'муж');
INSERT INTO Information (ChR, Forma, Chislo, Rod) VALUES ('числ', 'порядк', 'ед', 'жен');
INSERT INTO Information (ChR, Forma, Chislo) VALUES ('числ', 'порядк', 'мн');

--Наречия
INSERT INTO Information (ChR, Vid) VALUES ('нар', 'вопр');
INSERT INTO Information (ChR, Vid) VALUES ('нар', 'опр/кач');

--Прилагательные
INSERT INTO Information (ChR, Chislo, Rod, Vid) VALUES ('прил', 'ед', 'муж',  'вопр');
INSERT INTO Information (ChR, Chislo, Rod, Vid) VALUES ('прил', 'ед', 'жен',  'вопр');
INSERT INTO Information (ChR, Chislo, Vid) VALUES ('прил', 'мн', 'вопр');

--Местоимения
INSERT INTO Information (ChR) VALUES ('мест');

--Предлоги
INSERT INTO Information (ChR) VALUES ('пред');

--Союзы
INSERT INTO Information (ChR) VALUES ('союз');






