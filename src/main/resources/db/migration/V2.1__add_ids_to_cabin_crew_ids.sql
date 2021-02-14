UPDATE flight f SET cabin_crew_ids = (
    SELECT JSON_ARRAYAGG(fc.crew_id) as 'ids'
    FROM flight_crew fc
    WHERE fc.flight_id = f.id
    GROUP BY fc.flight_id
);