package controller;

import model.DataBaseCommunicator;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class OrdenController {

	private DataBaseCommunicator dataBase;

	public OrdenController() {
		this.dataBase = new DataBaseCommunicator();
	}

	public String[][] localizarProveedores(String pNombre, String pMarca){
		ArrayList<String[]> proveedores = dataBase.listarProveedores(pNombre, pMarca);
		String[][] array = new String[proveedores.size()][];

		int i = 0;
		for (String [] row : proveedores){
			array[i] = row;
			i++;
		}

		return array;
	}

	public String insertarNueva(String pCedula, String pTipo, String pFecha){
		int cedula = Integer.parseInt(pCedula);
		int tipo = Integer.parseInt(pTipo);
		Timestamp fecha;
		if (pFecha.compareTo("") == 0){
			Date date = new Date();
			fecha = new Timestamp(date.getTime());
		} else{
			fecha = Timestamp.valueOf(pFecha);
		}
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
