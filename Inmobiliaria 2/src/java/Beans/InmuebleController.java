package Beans;

import Entities.Inmueble;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "inmuebleController")
@ViewScoped
public class InmuebleController extends AbstractController<Inmueble> {

    @Inject
    private PersonaController personaCollectionController;
    @Inject
    private BarrioController idBarrioController;
    @Inject
    private TipoInmuebleController idTipoInmuebleController;
    @Inject
    private DisponibilidadController idDisponibilidadController;
    @Inject
    private RangoPrecioController idRangoPrecioController;

    public InmuebleController() {
        // Inform the Abstract parent controller of the concrete Inmueble?cap_first Entity
        super(Inmueble.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBarrioController.setSelected(null);
        idTipoInmuebleController.setSelected(null);
        idDisponibilidadController.setSelected(null);
        idRangoPrecioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Inmueble?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", this.getSelected().getPersonaCollection());
        }
        return "/persona/index";
    }

    /**
     * Sets the "selected" attribute of the Barrio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBarrio(ActionEvent event) {
        if (this.getSelected() != null && idBarrioController.getSelected() == null) {
            idBarrioController.setSelected(this.getSelected().getIdBarrio());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoInmueble controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoInmueble(ActionEvent event) {
        if (this.getSelected() != null && idTipoInmuebleController.getSelected() == null) {
            idTipoInmuebleController.setSelected(this.getSelected().getIdTipoInmueble());
        }
    }

    /**
     * Sets the "selected" attribute of the Disponibilidad controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDisponibilidad(ActionEvent event) {
        if (this.getSelected() != null && idDisponibilidadController.getSelected() == null) {
            idDisponibilidadController.setSelected(this.getSelected().getIdDisponibilidad());
        }
    }

    /**
     * Sets the "selected" attribute of the RangoPrecio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRangoPrecio(ActionEvent event) {
        if (this.getSelected() != null && idRangoPrecioController.getSelected() == null) {
            idRangoPrecioController.setSelected(this.getSelected().getIdRangoPrecio());
        }
    }
}
