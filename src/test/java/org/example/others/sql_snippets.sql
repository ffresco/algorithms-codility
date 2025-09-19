--Suma:
SELECT TRUNC(total, 4) AS total
FROM (  SELECT SUM(LAT_N) AS total  FROM Station)
WHERE total > 38.7880 AND total < 137.2345;

--Max value:
SELECT TRUNC(MAX(lat_n),4) FROM station where lat_n < 137.2345;

--Filtrar agrupacion
SELECT COD_PERSONA,Count(bcorreo.TIP_PRODUCTO )
FROM it.BA_ENV_CORREOS bcorreo
GROUP BY bcorreo.COD_PERSONA
HAVING Count(bcorreo.TIP_PRODUCTO )> 10
    FETCH FIRST 50 ROWS ONLY;

--SUBGRUPOS - SUBQUERY
SELECT ROUND(long_w, 4)
FROM station
WHERE lat_n = (
    SELECT MIN(lat_n)
    FROM station
    WHERE lat_n > 38.7780
);

--MANHATAN DISTANCE
SELECT ROUND(
               ABS(MAX(LAT_N) - MIN(LAT_N)) + ABS(MAX(LONG_W) - MIN(LONG_W)),
               4
       ) AS manhattan_distance
FROM STATION;

--MEDIA de una Muestra
SELECT ROUND(
               PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY LAT_N), 4
       ) AS median_lat_n
FROM STATION;

--Calcular tabla posiciones partido futbol
SELECT
    t.team_id,
    t.team_name,
    COALESCE(
            (SELECT SUM(
                            CASE
                                WHEN (m.host_goals > m.guest_goals) THEN 3
                                WHEN (m.host_goals = m.guest_goals) THEN 1
                                ELSE 0
                                END)
             FROM matches m
             WHERE m.host_team = t.team_id), 0
    ) +
    COALESCE(
            (SELECT SUM(
                            CASE
                                WHEN (m.guest_goals > m.host_goals) THEN 3
                                WHEN (m.guest_goals = m.host_goals) THEN 1
                                ELSE 0
                                END)
             FROM matches m
             WHERE m.guest_team = t.team_id), 0
    ) AS num_points
FROM teams t
ORDER BY num_points DESC, t.team_id ASC
--where m.host_team =