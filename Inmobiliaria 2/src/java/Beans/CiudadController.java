package Beans;

import Entities.Ciudad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    @Inject
    private ZonaController zonaCollectionController;
    @Inject
    private DepartamentoController idDepartamentoController;

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad?cap_first Entity
        super(Ciudad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDepartamentoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Zona entities that are
     * retrieved from Ciudad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Zona page
     */
    public String navigateZonaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Zona_items", this.getSelected().getZonaCollection());
        }
        return "/zona/index";
    }

    /**
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDepartamento(ActionEvent event) {
        if (this.getSelected() != null && idDepartamentoController.getSelected() == null) {
            idDepartamentoController.setSelected(this.getSelected().getIdDepartamento());
        }
    }
}
