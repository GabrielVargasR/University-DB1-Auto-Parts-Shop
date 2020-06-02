package controller;

import model.DataBaseCommunicator;
import java.util.ArrayList;

public class ParteController {

	private DataBaseCommunicator dataBase;

	public ParteController() {
		this.dataBase = new DataBaseCommunicator();
	}

	public String insertarParte(String pNombre, String pMarca, String pNombreFacricante){
		return dataBase.insertarParte(pNombre, pMarca, pNombreFacricante);
	}

	public String borrarParte(String pNombre, String pMarca){
		return dataBase.borrarParte(pNombre, pMarca);
	}
	
	public String asociarProveedor(String pIdParte, String pIdProveedor, String pPrecioProv, String pPrecioCliente){
		int parte = Integer.parseInt(pIdParte);
		int proveedor = Integer.parseInt(pIdProveedor);
		float precioP = Float.parseFloat(pPrecioProv);
		float precioC = Float.parseFloat(pPrecioCliente);

		return dataBase.asociarProveedorParte(parte, proveedor, precioP, precioC);
	}

	public String asociarAuto(String pIdParte, String pIdAuto){
		int parte = Integer.parseInt(pIdParte);
		int auto = Integer.parseInt(pIdAuto);
		return dataBase.asociarAutoParte(parte, auto);
	}

	public String actualizarPrecio(String pIdParte, String pIdProveedor, String pPrecioProv, String pPrecioCliente){
		int parte = Integer.parseInt(pIdParte);
		int proveedor = Integer.parseInt(pIdProveedor);
		float precioP = Float.parseFloat(pPrecioProv);
		float precioC = Float.parseFloat(pPrecioCliente);

		return dataBase.actualizarPrecioProv(parte, proveedor, precioP, precioC);
	}

	public String[][] listar(String pModelo, String pAño){
		ArrayList<String[]> partes = dataBase.listarPartesAuto(pModelo, Integer.parseInt(pAño));

		String[][] array = new String[partes.size()][];
		int i = 0;

		for (String[] parte : partes){
			array[i] = parte;
			i++;
		}

		return array;
	}
}
