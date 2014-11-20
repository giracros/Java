package Beans;

import Entities.Departamento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    @Inject
    private CiudadController ciudadCollectionController;

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento?cap_first Entity
        super(Departamento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Ciudad entities that are
     * retrieved from Departamento?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Ciudad page
     */
    public String navigateCiudadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ciudad_items", this.getSelected().getCiudadCollection());
        }
        return "/ciudad/index";
    }

}
