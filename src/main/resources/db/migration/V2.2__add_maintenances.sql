UPDATE plane p SET p.maintenances = (
   SELECT JSON_ARRAYAGG(JSON_OBJECT(
            'id', r.id,
             'review_type',r.review_type,
             'airport_id',r.airport_id,
             'begin_date',r.begin_date,
             'end_date',r.end_date,
             'mechanic_id',r.mechanic_id,
             'review_description',r.review_description,
             'worked_hours',r.worked_hours
       ))  FROM review r
    WHERE r.plane_id = p.id
    GROUP BY r.plane_id
);