DROP TABLE IF EXISTS "annonces_immobilieres";
CREATE TABLE "public"."annonces_immobilieres"
(
    "prix"          double precision NOT NULL,
    "date_creation" timestamp(6),
    "id"            bigint           NOT NULL,
    "description"   character varying(255),
    "emplacement"   character varying(255),
    "titre"         character varying(255),
    CONSTRAINT "annonces_immobilieres_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "annonces_immobilieres" ("prix", "date_creation", "id", "description", "emplacement", "titre")
VALUES (340000, CURRENT_TIMESTAMP, 1, 'description annonce 1', 'Lyon', 'Annonce 1'),
       (240000, CURRENT_TIMESTAMP + INTERVAL '1 day', 2, 'description annonce 2', 'paris', 'Annonce 2'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '2 day', 3, 'description annonce 3', 'Bordeaux', 'Annonce 3'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '2 day', 4, 'description annonce 4', 'Lyon', 'Annonce 4'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '3 day', 5, 'description annonce 5', 'Lyon', 'Annonce 5'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '3 day', 6, 'description annonce 6', 'Lyon', 'Annonce 8'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '3 day', 7, 'description annonce 7', 'Lyon', 'Annonce 7'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '4 day', 8, 'description annonce 8', 'Bordeaux', 'Annonce 8'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '4 day', 9, 'description annonce 9', 'Paris', 'Annonce 9'),
       (4000000, CURRENT_TIMESTAMP + INTERVAL '5 day', 10, 'description annonce 10', 'Paris', 'Annonce 10');
