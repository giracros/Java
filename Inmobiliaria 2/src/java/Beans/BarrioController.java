package Beans;

import Entities.Barrio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "barrioController")
@ViewScoped
public class BarrioController extends AbstractController<Barrio> {

    @Inject
    private TipoInmuebleController tipoInmuebleCollectionController;
    @Inject
    private InmuebleController inmuebleCollectionController;
    @Inject
    private ZonaController idZonaController;

    public BarrioController() {
        // Inform the Abstract parent controller of the concrete Barrio?cap_first Entity
        super(Barrio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idZonaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TipoInmueble entities
     * that are retrieved from Barrio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoInmueble page
     */
    public String navigateTipoInmuebleCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoInmueble_items", this.getSelected().getTipoInmuebleCollection());
        }
        return "/tipoInmueble/index";
    }

    /**
     * Sets the "items" attribute with a collection of Inmueble entities that
     * are retrieved from Barrio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Inmueble page
     */
    public String navigateInmuebleCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Inmueble_items", this.getSelected().getInmuebleCollection());
        }
        return "/inmueble/index";
    }

    /**
     * Sets the "selected" attribute of the Zona controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdZona(ActionEvent event) {
        if (this.getSelected() != null && idZonaController.getSelected() == null) {
            idZonaController.setSelected(this.getSelected().getIdZona());
        }
    }
}
