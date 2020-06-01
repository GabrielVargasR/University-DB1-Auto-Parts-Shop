package controller;

import model.DataBaseCommunicator;
import java.sql.Date;
import java.util.ArrayList;

public class OrdenController {

	private DataBaseCommunicator dataBase;

	public OrdenController() {
		this.dataBase = new DataBaseCommunicator();
	}

	public ArrayList<String[]> localizarProveedores(String pNombre, String pMarca){
		return dataBase.listarProveedores(pNombre, pMarca);
	}

	public String insertarNueva(String pCedula, String pTipo, String pFecha){
		int cedula = Integer.parseInt(pCedula);
		int tipo = Integer.parseInt(pTipo);
		Date fecha = Date.valueOf(pFecha);

		return dataBase.crearOrden(cedula, tipo, fecha);
	}

	public String asociarDetalle(String pConsOrden, String pIdParte, String pIdProveedor, String pCantidad){
		int cons = Integer.parseInt(pConsOrden);
		int parte = Integer.parseInt(pIdParte);
		int proveedor = Integer.parseInt(pIdProveedor);
		int cantidad = Integer.parseInt(pCantidad);

		return dataBase.asociarDetalleOrden(cons, parte, proveedor, cantidad);
	}
}
