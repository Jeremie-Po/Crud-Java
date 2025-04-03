-- Supprimer la table si elle existe
DROP TABLE IF EXISTS "annonces_immobilieres";
DROP TABLE IF EXISTS "agences_immobilieres";

-- Créer la table pour les annonces immobilières
CREATE TABLE "public"."annonces_immobilieres"
(
    "id"            SERIAL PRIMARY KEY,
    "titre"         VARCHAR(255),
    "description"   VARCHAR(255),
    "prix"          DOUBLE PRECISION NOT NULL,
    "emplacement"   VARCHAR(255),
    "date_creation" TIMESTAMP,
    "agence_id"     SERIAL

);

-- Créer la table pour les agences immobilières
CREATE TABLE "public"."agences_immobilieres"
(
    "id"      SERIAL PRIMARY KEY,
    "nom"     VARCHAR(255),
    "adresse" VARCHAR(255)
);

-- Insérer des données d'exemple pour les agences
INSERT INTO "agences_immobilieres" ("nom", "adresse")
VALUES ('Agence Paris', '10 rue de Paris'),
       ('Agence Lyon', '5 avenue de Lyon');

-- Insérer des données d'exemple pour les annonces
INSERT INTO "annonces_immobilieres" ("prix", "date_creation", "description", "emplacement", "titre")
VALUES (340000, CURRENT_TIMESTAMP, 'Description annonce 1', 'Paris', 'Annonce 1'),
       (90000, CURRENT_TIMESTAMP + INTERVAL '1 day', 'Description annonce 2', 'Lyon', 'Annonce 2'),
       (110000, CURRENT_TIMESTAMP + INTERVAL '2 day', 'Description annonce 3', 'Nice', 'Annonce 3');

-- Mettre à jour les annonces pour les lier aux agences correspondantes
UPDATE "annonces_immobilieres"
SET "agence_id" = 1
WHERE "titre" IN ('Annonce 1', 'Annonce 2');
UPDATE "annonces_immobilieres"
SET "agence_id" = 2
WHERE "titre" = 'Annonce 3';


-- Ajouter la contrainte de clé étrangère pour la colonne agence_id
ALTER TABLE "public"."annonces_immobilieres"
    ADD CONSTRAINT "fk_agence_id"
        FOREIGN KEY ("agence_id")
            REFERENCES "public"."agences_immobilieres" ("id");

