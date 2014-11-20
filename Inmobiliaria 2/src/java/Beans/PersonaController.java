package Beans;

import Entities.Persona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    @Inject
    private InmuebleController inmuebleCollectionController;
    @Inject
    private RolController idRolController;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona?cap_first Entity
        super(Persona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idRolController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Inmueble entities that
     * are retrieved from Persona?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRol(ActionEvent event) {
        if (this.getSelected() != null && idRolController.getSelected() == null) {
            idRolController.setSelected(this.getSelected().getIdRol());
        }
    }
}
