package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private static Stage stagePrincipal;
    private AnchorPane rootPane;

    Modelo modelo;
    Vista vista;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        modelo = new Modelo();
        vista = new Vista();

        mostrarVentanaPrincipal();
    }

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
            vista.setProgramaPrincipal(this);
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
		modelo.setDatos(cantidad, tiempo, interes);
		vista.cuotaActualizada();
	}

    public static void main(String[] args) {
        launch(args);
    }
}
