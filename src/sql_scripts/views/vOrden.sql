DROP VIEW IF EXISTS vOrden;
CREATE VIEW vOrden AS
	SELECT d.consecutivo_orden as orden, d.id_parte as parte, d.cantidad, p.precio_proveedor as precio, p.porcentaje_ganancia as porcentaje
    FROM detalle_orden as d, provee_parte as p
    WHERE (d.id_parte, d.id_proveedor) = (p.id_parte, p.id_proveedor)