package application;

public class Modelo{
	private double cantidad;
	private int tiempo;
	private double interes;
	private double cuota;

	public Modelo(){
		super();
	}

	public synchronized void setDatos(double cantidad, int tiempo, double interes){
		this.cantidad = cantidad;
		this.tiempo = tiempo;
		this.interes = interes;
		calculaCuota();
		//vista.cuotaActualizada();
	}
	private void calculaCuota(){
		double n = interes/1200;
		cuota = cantidad*n/(1-(1/Math.pow(1+n, 12*tiempo)));
	}
	public synchronized double getCuota(){
		return cuota;
	}
}
