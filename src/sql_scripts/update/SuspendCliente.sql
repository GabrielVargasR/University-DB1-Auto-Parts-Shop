DELIMITER //

CREATE PROCEDURE SuspendCliente(
	IN pId INT
)

BEGIN
	UPDATE cliente
    SET estado = 2
    WHERE id = pId;
END //

DELIMITER ;