DELIMITER //

CREATE PROCEDURE DeleteParte (
	IN p_nombre_parte VARCHAR(30),
    IN p_marca_parte VARCHAR(50), 
    OUT vResult VARCHAR(70)
)

BEGIN
	DECLARE v_orden_con_parte, v_id_parte INT;
    
    SELECT p.id
		INTO v_id_parte
        FROM parte AS p, marca_parte AS m
        WHERE p.nombre = p_nombre_parte AND
			  m.nombre = p_marca_parte;
    
    SELECT d.consecutivo_orden
		INTO v_orden_con_parte
        FROM detalle_orden AS d
        WHERE d.id_parte = v_id_parte
        LIMIT 1;
    
    IF (v_orden_con_parte IS NULL) THEN
		DELETE FROM parte WHERE id = v_id_parte;
        SET vResult = 'Parte borrada con éxito';
	ELSE
		SET vResult = 'No se pudo borrar la parte porque estaba asociada a una orden.';
	END IF;
    
END //

DELIMITER ;