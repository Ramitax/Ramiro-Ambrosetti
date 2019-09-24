/**
 * @AXIOMAS: 
 * 			- La cerradura funciona a partir de la clave que el usuario le otorgue y los intentos fallidos maximos que elija.
 * 			- La cerradura por defecto esta cerrada.
 * 			- La cerradura por defecto no esta bloqueada.
 * 			- Si la cerradura se bloquea, debera comunicarse con los programadores.
 * 
 * @author Ramiro Ambrosetti
 *
 */

public class Cerradura {

	// Variables 
	private int clave; 
	private int cantidadDeFallosConsecutivosQueLaBloquean;
	private int contadorDeAperturasExitosas;
	private int contadorDeAperturasFallidas;
	private boolean estadoDeLaCerradura;
	private boolean bloqueoDeLaCerradura;

	// Constructor

	public Cerradura (int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean){
		this.clave = claveDeApertura;
		this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
		this.contadorDeAperturasExitosas = 0;
		this.contadorDeAperturasFallidas = 0;
		this.estadoDeLaCerradura = false;
		this.bloqueoDeLaCerradura = false;
	}

	/**
	 * Pre: Introduce la clave para abrir la cerradura
	 * Post: Si la clave es correcta y la cerradura no esta bloqueada, entonces se abre la cerradura.
	 * @param clave loide
	 */

	public boolean abrirCerradura(int clave){
		if ((clave == this.clave) && (fueBloqueada() == false)){
			estadoDeLaCerradura = true;
			contadorDeAperturasExitosas++;
			contadorDeAperturasFallidas = 0;
			return true;
		}else {
			estadoDeLaCerradura = false;
			contadorDeAperturasFallidas++;
			return false;
		}

	}

	/**
	 *  Post: Cierra la cerradura si su estado es abierto.
	 */

	public void cerrar(){
		if(estadoDeLaCerradura == true){
			estadoDeLaCerradura = false;
		}
	}

	/**
	 * Post: Confirma si el estado de la cerradura es abierto.
	 */

	public boolean estaAbierta(){
		if(estadoDeLaCerradura == true){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Post: Confirma si el estado de la cerradura es cerrado.
	 */

	public boolean estaCerrada(){
		if(estadoDeLaCerradura == false){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Post: Confirma si el estado de la cerradura es bloqueado.
	 */

	public boolean fueBloqueada(){
		if(contadorDeAperturasFallidas >= cantidadDeFallosConsecutivosQueLaBloquean){
			bloqueoDeLaCerradura = true;
			return true;
		}else {
			bloqueoDeLaCerradura = false;
			return false;
		}
	}

	/**
	 * Post: Informa sobre la cantidad de veces que fue abierta la cerradura exitosamente.
	 */

	public int contarAperturasExitosas(){
		return contadorDeAperturasExitosas;
	}

	/**
	 * Post: Informa sobre la cantidad de veces que fallo la apertura de la cerradura.
	 */

	public int contarAperturasFallidas(){
		return contadorDeAperturasFallidas;
	}

}
