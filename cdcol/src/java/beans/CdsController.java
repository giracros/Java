package beans;

import controllers.CdsFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

@ManagedBean(name = "cdsController")
@ViewScoped
public class CdsController extends AbstractController<Cds> {

    @EJB
    private CdsFacade ejbFacade;

    /**
     * Initialize the concrete Cds controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CdsController() {
        // Inform the Abstract parent controller of the concrete Cds?cap_first Entity
        super(Cds.class);
    }

}
