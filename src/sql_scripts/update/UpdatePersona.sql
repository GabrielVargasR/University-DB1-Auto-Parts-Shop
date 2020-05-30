DELIMITER //

DROP PROCEDURE IF EXISTS UpdatePersona;
CREATE PROCEDURE UpdatePersona(
	IN pCedula DECIMAL(9,0),
	IN pNombre VARCHAR(80),
    IN pDireccion VARCHAR(100),
    IN pCiudad VARCHAR(20),
    IN pTelefono DECIMAL(8,0)
)

BEGIN

	DECLARE idPers INT;
    
    SELECT p.id_cliente
    INTO idPers
    FROM persona as p
    WHERE p.cedula = pCedula;
    
    CALL UpdateCliente(idPers, pNombre, pDireccion, pCiudad);

	UPDATE persona
    SET telefono = pTelefono
    WHERE cedula = pCedula;
    
END //

DELIMITER ;