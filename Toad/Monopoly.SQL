/*
Created: 26/06/2023
Modified: 26/06/2023
Model: Monopoly
Database: Oracle 19c
*/




-- Create sequences section -------------------------------------------------

CREATE SEQUENCE plam_game_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

CREATE SEQUENCE plam_propiedades_seq01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table plam_Game
CREATE TABLE plam_Game (
  game_id Number NOT NULL,
  fecha Date NOT NULL,
  nom_jugador1 Varchar2(30) NOT NULL,
  nom_jugador2 Varchar2(30) NOT NULL,
  game_posi_ficha1 Number(2,0) NOT NULL,
  game_posi_ficha2 Number(2,0) NOT NULL,
  game_cuenta_jugador1 Number(10,0) NOT NULL,
  game_cuenta_jugador2 Number(10,0) NOT NULL,
  game_version Number DEFAULT 1 NOT NULL
)
;

-- Add keys for table plam_Game

ALTER TABLE plam_Game ADD CONSTRAINT PK_plam_Game PRIMARY KEY (game_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN plam_Game.game_id IS 'Id de la partida'
;
COMMENT ON COLUMN plam_Game.fecha IS 'Fecha de la partida'
;
COMMENT ON COLUMN plam_Game.nom_jugador1 IS 'Nombre del jugador1'
;
COMMENT ON COLUMN plam_Game.nom_jugador2 IS 'Nombre del jugador2'
;
COMMENT ON COLUMN plam_Game.game_posi_ficha1 IS 'Posicion de la ficha del jugador 1'
;
COMMENT ON COLUMN plam_Game.game_posi_ficha2 IS 'Posicion de la ficha del jugador 2'
;
COMMENT ON COLUMN plam_Game.game_cuenta_jugador1 IS 'Cuenta del jugador 1'
;
COMMENT ON COLUMN plam_Game.game_cuenta_jugador2 IS 'Cuenta del jugador 2'
;
COMMENT ON COLUMN plam_Game.game_version IS 'Version del regitro'
;

-- Table plam_propiedades

CREATE TABLE plam_propiedades (
  game_id Number NOT NULL,
  propi_id Number NOT NULL,
  propi_propietario Number(1,0) NOT NULL,
  propi_alquiler Number(10,0) NOT NULL,
  propi_casas Number(1,0),
  propi_hoteles Number(1,0),
  propi_hipoteca Number(1,0),
  propi_version Number DEFAULT 1 NOT NULL
)
;

-- Create indexes for table plam_propiedades

CREATE INDEX IX_Relationship5 ON plam_propiedades (game_id)
;

-- Add keys for table plam_propiedades

ALTER TABLE plam_propiedades ADD CONSTRAINT PK_plam_propiedades PRIMARY KEY (propi_id)
;

-- Table and Columns comments section

COMMENT ON COLUMN plam_propiedades.game_id IS 'Id de la partida';
COMMENT ON COLUMN plam_propiedades.propi_id IS 'Id de la propiedad';
COMMENT ON COLUMN plam_propiedades.propi_propietario IS 'Número del propietario';
COMMENT ON COLUMN plam_propiedades.propi_alquiler IS 'Monto de alquiler de la propiedad';
COMMENT ON COLUMN plam_propiedades.propi_casas IS 'Cantidad de casas que tiene la propiedad';
COMMENT ON COLUMN plam_propiedades.propi_hoteles IS 'Cantidad de hoteles que tiene la propiedad';
COMMENT ON COLUMN plam_propiedades.propi_hipoteca IS '1 si la propiedad está hipotecada, 0 si no está hipotecada';
COMMENT ON COLUMN plam_propiedades.propi_version IS 'Version del regitro';

-- Trigger for sequence plam_game_seq01 for column game_id in table plam_Game ---------
CREATE OR REPLACE TRIGGER plam_Game_tgr01 BEFORE INSERT
ON plam_Game FOR EACH ROW
BEGIN
  :new.game_id := plam_game_seq01.nextval;
END;
/
CREATE OR REPLACE TRIGGER plam_Game_tgr02 AFTER UPDATE OF game_id
ON plam_Game FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column game_id in table plam_Game as it uses sequence.');
END;
/

-- Trigger for sequence plam_propiedades_seq02 for column propi_id in table plam_propiedades ---------
CREATE OR REPLACE TRIGGER plam_propiedades_tgr01 BEFORE INSERT
ON plam_propiedades FOR EACH ROW
BEGIN
  :new.propi_id := plam_propiedades_seq01.nextval;
END;
/
CREATE OR REPLACE TRIGGER plam_propiedades_tgr02 AFTER UPDATE OF propi_id
ON plam_propiedades FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column propi_id in table plam_propiedades as it uses sequence.');
END;
/

-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE plam_propiedades ADD CONSTRAINT Relationship1 FOREIGN KEY (game_id) REFERENCES plam_Game (game_id)
;







