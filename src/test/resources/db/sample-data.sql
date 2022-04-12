delete from movie_platform;
delete from platform;
delete from featurette;
delete from movie;

-- movies
insert into movie(id, title, release_year, synopsis)
values('A202204010001', 'Matrix', 1999, 'Thomas Anderson lleva una doble vida: por el día es programador en una importante empresa de software, y por la noche un hacker informático llamado Neo. Su vida no volverá a ser igual cuando unos misteriosos personajes le inviten a descubrir la respuesta a la pregunta que no le deja dormir: ¿qué es Matrix?');
insert into movie(id, title, release_year, synopsis)
values('A202204010002', 'Los puentes de Madison', 1995, 'La apacible pero anodina vida de Francesca Johnson, un ama de casa que vive en una granja con su familia, se ve alterada con la llegada de Robert Kincaid, un veterano fotógrafo de la revista National Geographic, que visita el condado de Madison para fotografiar sus viejos puentes. Cuando Francesca invita a Robert a cenar, un amor verdadero y una pasión desconocida nacerá entre ellos.');
insert into movie(id, title, release_year, synopsis)
values('A202204010003', 'El callejón de las almas perdidas', 2021, 'Un buscavidas se compincha con una pitonisa para engañar a la gente y conseguir dinero... Remake del film \"El callejón de las almas perdidas\" (Nightmare Alley) de 1947.');
insert into movie(id, title, release_year, synopsis)
values('A202204010004', 'El proyecto Adam', 2022, 'Adam Reed es un piloto de caza que viaja en el tiempo. Cuando se estrella en el año 2022, conoce a su yo de 12 años y juntos emprenden una misión para salvar el futuro.');
insert into movie(id, title, release_year, synopsis)
values('A202204010005', 'Red', 2022, 'Toronto, curso 2002/2003: Meilin Lee, más conocida como Mei, es una chica chino-canadiense de 13 años, un poco friki pero segura de sí misma. Mei está en una edad difícil, en la que se debate entre obedecer a su madre y ser una buena hija o convertirse en una adolescente rebelde. \n\nUna mañana, al despertarse tras una noche de pesadillas, Mei se da cuenta de que le ocurre algo insólito: ¡se ha convertido en un panda rojo gigante! A partir de ese momento, la joven se transformará en un panda cada vez que se sienta estresada o nerviosa. Y, a los 13 años, esto pasa muy a menudo. A medida que Mei va enfrentándose al día a día, a la escuela y a su madre protectora que no la pierde de vista, también descubre que sus ancestros tienen más en común con los pandas rojos de lo que parece.');
insert into movie(id, title, release_year, synopsis)
values('A202204010006', 'RED', 2008, 'Frank (Bruce Willis), Joe (Morgan Freeman), Marvin (John Malkovich) y Victoria (Helen Mirren) son agentes especiales ya retirados, a los que la nueva administración de Washington desea ver muertos. El motivo: eran los mejores agentes de la CIA, pero saben demasiado. Adaptación del cómic de Warren Ellis.');
insert into movie(id, title, release_year, synopsis)
values('A202204010007', 'Aguas Profundas', 2022, 'Un marido adinerado, que permite que su esposa tenga relaciones extramatrimoniales para evitar el divorcio, se convierte en el principal sospechoso de la desaparición de los amantes de ella... Adaptación de la novela de Patricia Highsmith.');
insert into movie(id, title, release_year, synopsis)
values('A202204010008', 'El poder del perro', 2021, 'Los acaudalados hermanos Phil y George Burbank son las dos caras de la misma moneda. Phil es elegante, genial y cruel, mientras George es impasible, quisquilloso y amable. Juntos son copropietarios de un enorme rancho en Montana. Es un lugar donde la rápida modernización del siglo XX se mantiene y en el que la figura de Bronco Henry, el mayor cowboy que Phil ha conocido jamás, es venerado. Cuando George se casa en secreto con Rose, una viuda del pueblo, Phil, sorprendido y furioso, lleva a cabo una guerra sádica e implacable para destruirla por completo usando a su afeminado hijo, Peter, como peón.');
insert into movie(id, title, release_year, synopsis)
values('A202204010009', 'Dune', 2021, 'En un lejano futuro, la galaxia conocida es gobernada mediante un sistema feudal de casas nobles bajo el mandato del Emperador. Las alianzas y la política giran entorno a un pequeño planeta, Dune, del que extrae la \"especia melange\", la materia prima que permite los viajes espaciales. La Casa Atreides, bajo el mandato del Duque Leto Atreides recibe el encargo de custodiar el planeta, relevando en la encomienda a sus históricos enemigos, los Harkonnen. Paul Atreides, hijo del duque, se verá atrapado en las intrigas políticas mientras descubre el destino que le deparan los desiertos de Dune.');
insert into movie(id, title, release_year, synopsis)
values('A202204010010', 'Matrix Resurrections', 2021, 'En un mundo compuesto por dos realidades, lo cotidiano y lo oculto tras ella, Thomas Anderson se ve obligado de nuevo a ir tras el conejo blanco. Dicha elección continúa siendo la vía de acceso a Matrix, que esta vez es más poderosa e intrincada que en ocasiones anteriores.');

-- featurettes
insert into featurette (movie_id, item_order, name, url) values ('A202204010001', 0, 'Trailer 1', 'https://via.placeholder.com/300x250.png?text=Item+1');
insert into featurette (movie_id, item_order, name, url) values ('A202204010001', 1, 'Teaser 1', 'https://via.placeholder.com/300x250.png?text=Item+2');
insert into featurette (movie_id, item_order, name, url) values ('A202204010001', 2, 'Teaser 2', 'https://via.placeholder.com/300x250.png?text=Item+3');
insert into featurette (movie_id, item_order, name, url) values ('A202204010009', 0, 'Trailer 1', 'https://via.placeholder.com/300x250.png?text=Item+1');

-- platforms
insert into platform (id, name) values ('A20220401P001', 'Netflix');
insert into platform (id, name) values ('A20220401P002', 'HBO Max');
insert into platform (id, name) values ('A20220401P003', 'Prime Video');
insert into platform (id, name) values ('A20220401P004', 'Disney Plus');

-- movie platforms
insert into movie_platform(movie_id, platform_id) values ('A202204010001', 'A20220401P001');
insert into movie_platform(movie_id, platform_id) values ('A202204010001', 'A20220401P002');
insert into movie_platform(movie_id, platform_id) values ('A202204010001', 'A20220401P003');
insert into movie_platform(movie_id, platform_id) values ('A202204010002', 'A20220401P002');
insert into movie_platform(movie_id, platform_id) values ('A202204010002', 'A20220401P003');
insert into movie_platform(movie_id, platform_id) values ('A202204010003', 'A20220401P004');
insert into movie_platform(movie_id, platform_id) values ('A202204010004', 'A20220401P001');
insert into movie_platform(movie_id, platform_id) values ('A202204010007', 'A20220401P003');
insert into movie_platform(movie_id, platform_id) values ('A202204010008', 'A20220401P001');
insert into movie_platform(movie_id, platform_id) values ('A202204010009', 'A20220401P004');
insert into movie_platform(movie_id, platform_id) values ('A202204010010', 'A20220401P001');
insert into movie_platform(movie_id, platform_id) values ('A202204010010', 'A20220401P002');
insert into movie_platform(movie_id, platform_id) values ('A202204010010', 'A20220401P003');

