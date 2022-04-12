```sql
-- solo las que tienen
select m.*, f.*
from movie m
inner join featurette f on f.movie_id = m.id
order by m.title asc, f.item_order asc;

-- todas las que cumplan, tengan o no
select m.*, f.*
from movie m
left join featurette f on f.movie_id = m.id
order by m.title asc, f.item_order asc;

-- inner join
select m.title as movie, p.name as available_on from movie m
inner join movie_platform mp on m.id = mp.movie_id
inner join platform p on p.id = mp.platform_id
order by m.title, p.name;

-- right join no matching on A
insert into platform values ('A.NEW.1', 'A new');
select m.title as movie, p.name as available_on from movie m
right join movie_platform mp on m.id = mp.movie_id
right join platform p on mp.platform_id = p.id
where m.title is null
order by m.title, p.name;

-- paginando en bloques de 4 qtt resultados - pagina 0, offset = pagina * qtt
select title from movie
order by title
limit 4
offset 0;

-- disponibilidad en plataformas
select m.title, count(mp.*) as platform_availability
from movie m left join movie_platform mp on m.id = mp.movie_id
group by m.title
order by platform_availability desc;

-- disponibilidad en más de una plataforma
select m.title, count(mp.*) as platform_availability
from movie m left join movie_platform mp on m.id = mp.movie_id
group by m.title
having count(mp.*) > 1
order by platform_availability desc;

-- años disponibles
select distinct(release_year) from movie order by 1;

-- window functions: row_number - asignacion de valor creciente segun fila
select m.title, m.release_year, row_number() over (order by m.release_year) from movie m
order by m.release_year;

-- window functions: rank - asignacion de valor creciente segun año
select m.title, m.release_year, dense_rank() over (order by m.release_year) from movie m
order by m.release_year;

-- window functions: partition rank - asignacion de valor creciente dentro de grupo (casos uso: top rankings)
select m.title, m.release_year, rank() over (partition by m.release_year order by m.title) from movie m
order by m.release_year;
`````