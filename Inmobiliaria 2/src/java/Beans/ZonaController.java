package Beans;

import Entities.Zona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "zonaController")
@ViewScoped
public class ZonaController extends AbstractController<Zona> {

    @Inject
    private CiudadController idCiudadController;
    @Inject
    private BarrioController barrioCollectionController;

    public ZonaController() {
        // Inform the Abstract parent controller of the concrete Zona?cap_first Entity
        super(Zona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCiudadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCiudad(ActionEvent event) {
        if (this.getSelected() != null && idCiudadController.getSelected() == null) {
            idCiudadController.setSelected(this.getSelected().getIdCiudad());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Barrio entities that are
     * retrieved from Zona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Barrio page
     */
    public String navigateBarrioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Barrio_items", this.getSelected().getBarrioCollection());
        }
        return "/barrio/index";
    }

}
