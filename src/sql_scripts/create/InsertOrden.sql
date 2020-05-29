DELIMITER //

CREATE PROCEDURE InsertOrden (
	IN pCedulaJ DECIMAL(10,0),
    IN pCedula DECIMAL(9, 0),
    IN pFecha DATETIME
)

BEGIN

	DECLARE vFecha DATETIME;
    DECLARE idCliente INT;
    
    IF (pCedula IS NULL) THEN
		SELECT o.id_cliente
			INTO idCliente
			FROM organizcion AS o
			WHERE o.cedula = pCedulaJ;
    ELSE
		SELECT p.id_cliente
			INTO idCliente
			FROM persona AS p
			WHERE p.cedula = pCedula;
    END IF;
    
    INSERT INTO orden (id_cliente, fecha) VALUES (idCliente, pFecha);
    
END //

DELIMITER ;