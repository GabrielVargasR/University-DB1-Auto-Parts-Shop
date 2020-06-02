DELIMITER //

CREATE PROCEDURE UpdateCliente(
	IN pId INT,
	IN pNombre VARCHAR(80),
    IN pDireccion VARCHAR(100),
    IN pCiudad VARCHAR(20)
)

BEGIN
	UPDATE cliente
    SET nombre = pNombre, direccion = pDireccion, ciudad = pCiudad
    WHERE id = pId;
END //

DELIMITER ;