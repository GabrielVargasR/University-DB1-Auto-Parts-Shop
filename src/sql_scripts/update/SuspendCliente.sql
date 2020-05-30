DELIMITER //

CREATE PROCEDURE SuspendCliente(
	IN pCedula DECIMAL(9,0),
    IN pCedulaJ DECIMAL(10,0)
)

BEGIN

	DECLARE vID INT;

	IF (pCedula IS NULL) THEN
		SELECT o.id_cliente
        INTO vID
        FROM organizacion as o
        WHERE o.cedula = pCedulaJ;
	ELSE
		SELECT p.id_cliente
        INTO vID
        FROM persona as p
        WHERE p.cedula = pCedula;
	END IF;

	UPDATE cliente
    SET estado = 2
    WHERE id = vID;
END //

DELIMITER ;