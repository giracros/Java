package Beans;

import Entities.Disponibilidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "disponibilidadController")
@ViewScoped
public class DisponibilidadController extends AbstractController<Disponibilidad> {

    @Inject
    private TipoInmuebleController tipoInmuebleCollectionController;
    @Inject
    private RangoPrecioController rangoPrecioCollectionController;
    @Inject
    private InmuebleController inmuebleCollectionController;

    public DisponibilidadController() {
        // Inform the Abstract parent controller of the concrete Disponibilidad?cap_first Entity
        super(Disponibilidad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of TipoInmueble entities
     * that are retrieved from Disponibilidad?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of RangoPrecio entities that
     * are retrieved from Disponibilidad?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RangoPrecio page
     */
    public String navigateRangoPrecioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RangoPrecio_items", this.getSelected().getRangoPrecioCollection());
        }
        return "/rangoPrecio/index";
    }

    /**
     * Sets the "items" attribute with a collection of Inmueble entities that
     * are retrieved from Disponibilidad?cap_first and returns the navigation
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
