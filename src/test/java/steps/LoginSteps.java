package steps;

import ui.LoginUI;
import utilities.Acciones;

public class LoginSteps {

    private Acciones acciones;

    public void registrar(){
        acciones.esperoElementoVisible(LoginUI.getBtnRegistrate());
        acciones.clickBoton(LoginUI.getBtnRegistrate());
    }


    public void ingresoCredenciales(String password){
//        String email = Acciones.generateRandomEmail();
        String email = "sergiotest@test.com";
        acciones.esperoElementoVisible(LoginUI.getInputEmail());
        acciones.escribirTexto(LoginUI.getInputEmail(), email);
        acciones.escribirTexto(LoginUI.getInputPassword(), password);
        acciones.esperoElementoHabilitado(LoginUI.getBtnSignup());
        acciones.clickBoton(LoginUI.getBtnSignup());
    }





}
