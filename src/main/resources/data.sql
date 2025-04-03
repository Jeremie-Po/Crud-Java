DROP TABLE IF EXISTS "annonces_immobilieres";
CREATE TABLE "public"."annonces_immobilieres"
(
    "prix"          double precision NOT NULL,
    "date_creation" timestamp(6),
    "id"            SERIAL PRIMARY KEY,
    "description"   character varying(255),
    "emplacement"   character varying(255),
    "titre"         character varying(255)
) WITH (oids = false);

INSERT INTO "annonces_immobilieres" ("prix", "date_creation", "description", "emplacement", "titre")
VALUES (340000, CURRENT_TIMESTAMP, 'description annonce 1', 'Lyon', 'Annonce 1'),
       (240000, CURRENT_TIMESTAMP + INTERVAL '1 day', 'description annonce 2', 'paris', 'Annonce 2'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '2 day', 'description annonce 3', 'Bordeaux', 'Annonce 3'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '2 day', 'description annonce 4', 'Lyon', 'Annonce 4'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '3 day', 'description annonce 5', 'Lyon', 'Annonce 5'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '3 day', 'description annonce 6', 'Lyon', 'Annonce 8'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '3 day', 'description annonce 7', 'Lyon', 'Annonce 7'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '4 day', 'description annonce 8', 'Bordeaux', 'Annonce 8'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '4 day', 'description annonce 9', 'Paris', 'Annonce 9'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '5 day', 'description annonce 10', 'Paris', 'Annonce 10');
