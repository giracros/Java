package Beans;

import Entities.TipoInmueble;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoInmuebleController")
@ViewScoped
public class TipoInmuebleController extends AbstractController<TipoInmueble> {

    @Inject
    private DisponibilidadController disponibilidadCollectionController;
    @Inject
    private BarrioController barrioCollectionController;
    @Inject
    private InmuebleController inmuebleCollectionController;

    public TipoInmuebleController() {
        // Inform the Abstract parent controller of the concrete TipoInmueble?cap_first Entity
        super(TipoInmueble.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Disponibilidad entities
     * that are retrieved from TipoInmueble?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Barrio entities that are
     * retrieved from TipoInmueble?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Barrio page
     */
    public String navigateBarrioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Barrio_items", this.getSelected().getBarrioCollection());
        }
        return "/barrio/index";
    }

    /**
     * Sets the "items" attribute with a collection of Inmueble entities that
     * are retrieved from TipoInmueble?cap_first and returns the navigation
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
