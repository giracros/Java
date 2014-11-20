package Beans;

import Entities.RangoPrecio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rangoPrecioController")
@ViewScoped
public class RangoPrecioController extends AbstractController<RangoPrecio> {

    @Inject
    private DisponibilidadController disponibilidadCollectionController;
    @Inject
    private InmuebleController inmuebleCollectionController;

    public RangoPrecioController() {
        // Inform the Abstract parent controller of the concrete RangoPrecio?cap_first Entity
        super(RangoPrecio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Disponibilidad entities
     * that are retrieved from RangoPrecio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Disponibilidad page
     */
    public String navigateDisponibilidadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Disponibilidad_items", this.getSelected().getDisponibilidadCollection());
        }
        return "/disponibilidad/index";
    }

    /**
     * Sets the "items" attribute with a collection of Inmueble entities that
     * are retrieved from RangoPrecio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Inmueble page
     */
    public String navigateInmuebleCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Inmueble_items", this.getSelected().getInmuebleCollection());
        }
        return "/inmueble/index";
    }

}
