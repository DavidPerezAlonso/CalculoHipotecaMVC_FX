package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Vista implements Initializable{

		// TODO Auto-generated method stub
		private  Main ProgramaPrincipal;

		@FXML
	    private Button myButton;

	    @FXML
	    private TextField cantidad;

	    @FXML
	    private TextField years;

	    @FXML
	    private TextField interes;

	    @FXML
	    private TextField cuota;

	    @FXML
	    private Label CuotaLabel;

		private Modelo modelo;

	    public void setModelo(Modelo modelo){
			this.modelo = modelo;
		}

	    public void setProgramaPrincipal(Main ProgramaPrincipal) {
	        this.ProgramaPrincipal = ProgramaPrincipal;
	    }

		public double getCantidad() {
			// TODO Auto-generated method stub
			double dCantidad = Double.valueOf(cantidad.getText());
			return dCantidad;
		}

		public int getTiempo() {
			// TODO Auto-generated method stub
			int iTiempo = Integer.valueOf(years.getText());
			return iTiempo;
		}

		public double getInteres() {
			double dCantidad = Double.valueOf(interes.getText());
			return dCantidad;
		}


		public void cuotaActualizada() {
			// TODO Auto-generated method stub
			CuotaLabel.setVisible(true);
			cuota.setVisible(true);
			String sAux = String.format("%.2f",modelo.getCuota());
			cuota.setText(sAux);


		}

		public void escuchador(){
			ProgramaPrincipal.solicitadoCalculo();
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub

		}


}
