DELIMITER //

DROP PROCEDURE IF EXISTS AssocParteAuto//
CREATE PROCEDURE AssocParteAuto(
	IN pNombreParte      VARCHAR(30),
    IN pMarcaParte       VARCHAR(50),
    IN pModelo 			 VARCHAR(15),
    IN pAnno 			 DECIMAL(4,0)
)

BEGIN
	DECLARE var_id_parte, var_id_auto INT;
    SET var_id_parte = GetIDParte(pNombreParte, pMarcaParte);
    SET var_id_auto = GetIDAuto(pModelo, pAnno);
	INSERT INTO parteautomovil(id_parte, id_auto) VALUES (var_id_parte, var_id_auto);
END //
DELIMITER ;