DELIMITER //

DROP PROCEDURE IF EXISTS InsertOrden//
CREATE PROCEDURE InsertOrden (
	IN pCedulaJ DECIMAL(10,0),
    IN pCedula DECIMAL(9, 0),
    IN pFecha DATETIME,
    OUT flag INT, 
    OUT consecutivo INT
)

BEGIN

	DECLARE vFecha DATETIME;
    DECLARE idCliente, estado INT;
    
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
    
    IF (pFecha IS NULL) THEN
		SET vFecha = CURRENT_TIMESTAMP;
    ELSE
		SET vFecha = pFecha;
    END IF;
    
    SELECT c.estado
    INTO estado
    FROM cliente as c
    WHERE c.id = idCliente;
    
    IF (estado = 2) THEN
		SET flag = 1;
	ELSE
		INSERT INTO orden (id_cliente, fecha) VALUES (idCliente, vFecha);
        SET flag = 0;
        SET consecutivo = last_insert_id();
	END IF;
END //

DELIMITER ;