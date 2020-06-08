DELIMITER //

DROP PROCEDURE IF EXISTS ReadOrden//
CREATE PROCEDURE ReadOrden(
	IN pConsecutivo INT
)

BEGIN
	SELECT c.nombre, o.fecha, v.cantidad, v.precio, v.porcentaje
    FROM vOrden as v, orden as o, cliente as c
    WHERE v.orden = o.consecutivo AND o.consecutivo = pConsecutivo AND c.id = o.id_cliente;
END//
DELIMITER ;