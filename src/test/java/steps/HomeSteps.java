package steps;

import ui.HomeUI;
import ui.MenuUI;
import utilities.Acciones;

public class HomeSteps {

    private Acciones acciones;


    public void ingresoInvitado(){
        acciones.esperoElementoVisible(HomeUI.getBtnInvitado());
        acciones.clickBoton(HomeUI.getBtnInvitado());

        acciones.esperoElementoVisible(HomeUI.getBtnSelubicacion());
        acciones.clickBoton(HomeUI.getBtnSelubicacion());

    }

    public void permisosUbicacion(){
        acciones.clickEnCoordenada(509, 1390);
        acciones.esperoElementoVisible(HomeUI.getListUbicacion());
        acciones.clickBoton(HomeUI.getListUbicacion());
        acciones.esperoElementoVisible(HomeUI.getOptionLeon());
        acciones.clickBoton(HomeUI.getOptionLeon());
        acciones.esperoElementoVisible(HomeUI.getBtnGuardar());
        acciones.clickBoton(HomeUI.getBtnGuardar());
    }

    public void clickMenu(){
        acciones.esperoElementoVisible(MenuUI.getBtnMenu());
        acciones.clickBoton(MenuUI.getBtnMenu());
    }

    public void verSucursales(){
        acciones.esperoElementoVisible(MenuUI.getBtnSucursales());
        acciones.tomarEvidencia();
        acciones.clickBoton(MenuUI.getBtnSucursales());
        acciones.esperoElementoVisible(MenuUI.getLblMap());
    }



}
