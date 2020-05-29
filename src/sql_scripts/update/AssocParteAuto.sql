DELIMITER //

CREATE PROCEDURE AssocParteAuto(
	IN pIdParte       INT,
    IN pIdAuto   INT
)

BEGIN
	INSERT INTO parteautomovil(id_parte, id_auto) VALUES (pIdParte, pIdAuto);
END //
DELIMITER ;