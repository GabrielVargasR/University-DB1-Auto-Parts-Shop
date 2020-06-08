DROP DATABASE IF EXISTS progra1;
CREATE DATABASE progra1;

USE progra1;

CREATE TABLE cliente (
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(80),
    direccion VARCHAR(100),
    ciudad VARCHAR(20),
    estado DECIMAL(1) NOT NULL DEFAULT 0,
    
    PRIMARY KEY(id)
);

CREATE TABLE persona (
	cedula DECIMAL(9) NOT NULL,
    telefono DECIMAL(8),
    id_cliente INT NOT NULL,
    
    PRIMARY KEY(cedula),
    CONSTRAINT fk_id_persona FOREIGN KEY(id_cliente) REFERENCES cliente(id)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE contacto (
	nombre VARCHAR(40),
    telefono DECIMAL(8) NOT NULL,
    cargo VARCHAR(25),
    
    PRIMARY KEY(telefono)
);

CREATE TABLE organizacion (
	cedula DECIMAL(10) NOT NULL, 
    id_cliente INT NOT NULL, 
    tel_contacto DECIMAL(8) NOT NULL,
    
    PRIMARY KEY(cedula),
    UNIQUE (id_cliente),
    CONSTRAINT fk_id_cliente_organizacion FOREIGN KEY(id_cliente) REFERENCES cliente(id)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_contacto_organizacion FOREIGN KEY(tel_contacto) REFERENCES contacto(telefono)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE telefonos_organizacion (
	cedula_juridica DECIMAL(10) NOT NULL,
    telefono DECIMAL(8) NOT NULL,
    
    PRIMARY KEY(cedula_juridica, telefono),
    UNIQUE(telefono),
    CONSTRAINT fk_cedula_tel_org FOREIGN KEY(cedula_juridica) REFERENCES organizacion(cedula)
		ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE fabricante_automovil (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(nombre)
);

CREATE TABLE automovil (
	id INT NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(15) NOT NULL,
    año DECIMAL(4) NOT NULL,
    detalle VARCHAR(50),
    id_fabricante INT NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(modelo, año),
    CONSTRAINT fk_fabricante_auto FOREIGN KEY(id_fabricante) REFERENCES fabricante_automovil(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE fabricante_parte (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(nombre)
);

CREATE TABLE marca_parte (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(id),
    UNIQUE(Nombre)
);

CREATE TABLE parte (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    marca INT NOT NULL,
    id_fabricante_parte INT NOT NULL, 
    
    PRIMARY KEY(id),
    UNIQUE (nombre, marca),
    CONSTRAINT fk_marca_parte FOREIGN KEY(marca) REFERENCES marca_parte(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_fabricante_parte_parte FOREIGN KEY(id_fabricante_parte) REFERENCES fabricante_parte(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE parteautomovil (
	id_parte INT NOT NULL,
    id_auto INT NOT NULL,
    
    PRIMARY KEY(id_parte, id_auto),
    CONSTRAINT fk_parte_pa FOREIGN KEY(id_parte) REFERENCES parte(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
	CONSTRAINT fk_auto_pa FOREIGN KEY(id_auto) REFERENCES automovil(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE orden (
	consecutivo INT NOT NULL AUTO_INCREMENT,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    -- monto DECIMAL (12, 2) NOT NULL DEFAULT(0),
    id_cliente INT NOT NULL,
    
    PRIMARY KEY(consecutivo),
    -- UNIQUE(fecha, monto, id_cliente),
    CONSTRAINT fk_id_cliente_orden FOREIGN KEY(id_cliente) REFERENCES cliente(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE proveedor (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    ciudad VARCHAR(20),
    contacto VARCHAR(50),
    
    PRIMARY KEY(id),
    CONSTRAINT c_name UNIQUE(nombre),
    UNIQUE(nombre, direccion)
);

CREATE TABLE telefonos_proveedor (
	id_proveedor INT NOT NULL AUTO_INCREMENT,
    telefono DECIMAL(8) NOT NULL,
    
    PRIMARY KEY(id_proveedor, telefono),
    UNIQUE(telefono),
    CONSTRAINT fk_id_proveedor_tel_prov FOREIGN KEY(id_proveedor) REFERENCES proveedor(id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE detalle_orden (
	consecutivo_detalle INT NOT NULL AUTO_INCREMENT,
    consecutivo_orden INT NOT NULL,
    id_proveedor INT NOT NULL,
    id_parte INT NOT NULL,
    cantidad SMALLINT DEFAULT(1),
    
    PRIMARY KEY(consecutivo_detalle, consecutivo_orden),
    UNIQUE(consecutivo_orden, id_parte, id_proveedor),
    CONSTRAINT fk_cons_orden_detalle FOREIGN KEY(consecutivo_orden) REFERENCES orden(consecutivo)
		ON DELETE RESTRICT
        ON UPDATE RESTRICT,
    CONSTRAINT fk_id_proveedor_detalle FOREIGN KEY(id_proveedor) REFERENCES proveedor(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_id_parte_detalle FOREIGN KEY(id_parte) REFERENCES parte(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE provee_parte (
	id_parte INT NOT NULL,
    id_proveedor INT NOT NULL,
    precio_proveedor DECIMAL(12, 2) NOT NULL,
    porcentaje_ganancia DECIMAL(3, 2) NOT NULL,
    
    PRIMARY KEY(id_parte, id_proveedor),
    CONSTRAINT fk_parte_prov_parte FOREIGN KEY(id_parte) references parte(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_proveedor_prov_parte FOREIGN KEY(id_proveedor) references proveedor(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE provee (
	id_proveedor INT NOT NULL,
    consecutivo_detalle INT NOT NULL,
    consecutivo_orden INT NOT NULL,
    
    PRIMARY KEY(id_proveedor, consecutivo_detalle),
    CONSTRAINT fk_proveedor_provee FOREIGN KEY(id_proveedor) references proveedor(id)
		ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_orden_provee FOREIGN KEY(consecutivo_detalle, consecutivo_orden) 
		references detalle_orden(consecutivo_detalle, consecutivo_orden)
			ON DELETE RESTRICT
			ON UPDATE RESTRICT
);
