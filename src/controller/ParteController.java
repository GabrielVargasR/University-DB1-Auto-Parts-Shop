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
	
	public String asociarProveedor(String pNombreParte, String pMarcaParte, String pNombreProveedor, String pPrecioProv, String pPorcentajeGanancia){
		float precioP = Float.parseFloat(pPrecioProv);
		float porcentaje = Float.parseFloat(pPorcentajeGanancia);

		return dataBase.asociarProveedorParte(pNombreParte, pMarcaParte, pNombreProveedor, precioP, porcentaje);
	}

	public String asociarAuto(String pNombreParte, String pMarcaParte, String pModeloAuto, String pAnnoAuto){
		int auto = Integer.parseInt(pAnnoAuto);
		return dataBase.asociarAutoParte(pNombreParte, pMarcaParte, pModeloAuto, auto);
	}

	public String actualizarPrecio(String pNombreParte, String pMarcaParte, String pNombreProveedor, String pPrecioProv, String pPorcentajeGanancia){
		float precioP = Float.parseFloat(pPrecioProv);
		float porcentaje = Float.parseFloat(pPorcentajeGanancia);

		return dataBase.actualizarPrecioProv(pNombreParte, pMarcaParte, pNombreProveedor, precioP, porcentaje);
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
