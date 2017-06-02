package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    Modelo modelo;
    Controlador controlador;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        modelo = new Modelo();
        controlador = new Controlador();

        controlador.setModelo(modelo);
        controlador.setStage(stagePrincipal);

        /* Muestra la ventana principal */
        controlador.mostrarVentanaPrincipal();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
