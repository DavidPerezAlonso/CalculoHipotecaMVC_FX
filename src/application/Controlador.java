package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controlador {

	private Stage stagePrincipal;
    private AnchorPane rootPane;
    private Modelo modelo;
    Vista vista;

	/*
     * cargamos la ventana principal
     */
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("UI.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Calculo Hipoteca");
            stagePrincipal.setScene(scene);

            vista = loader.getController();
            vista.setControlador(this);
            vista.setModelo(modelo);

            stagePrincipal.show();
        } catch (IOException e) {
            //tratar la excepción.
        }
   }

    /* Método que es llamado desde el controlador de la vista cuando se presiona el botón
     * calcular
     */
    public void solicitadoCalculo(){
		double cantidad = vista.getCantidad();
		int tiempo = vista.getTiempo();
		double interes = vista.getInteres();
		this.modelo.setDatos(cantidad, tiempo, interes);
		vista.cuotaActualizada();
	}

	public void setModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		this.modelo = modelo;
	}

	public void setVista(Vista vista2) {
		// TODO Auto-generated method stub
		this.vista = vista2;
	}

	public void setStage(Stage stagePrincipal2) {
		// TODO Auto-generated method stub
		this.stagePrincipal = stagePrincipal2;
	}

}
