DROP TABLE IF EXISTS "annonces_immobilieres";
CREATE TABLE "public"."annonces_immobilieres" (
                                                  "prix" double precision NOT NULL,
                                                  "date_creation" timestamp(6),
                                                  "id" bigint NOT NULL,
                                                  "description" character varying(255),
                                                  "emplacement" character varying(255),
                                                  "titre" character varying(255),
                                                  CONSTRAINT "annonces_immobilieres_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "annonces_immobilieres" ("prix", "date_creation", "id", "description", "emplacement", "titre") VALUES
                                                                                                               (340000,	CURRENT_TIMESTAMP,	1,	'description annonce 1',	'Lyon',	'Annonce 1'),
                                                                                                               (240000,	CURRENT_TIMESTAMP + INTERVAL '1 day',	2,	'description annonce 2',	'paris',	'Annonce 2'),
                                                                                                               (4000000,	CURRENT_TIMESTAMP + INTERVAL '2 day',	3,	'description annonce 3',	'Bordeaux',	'Annonce 3');
