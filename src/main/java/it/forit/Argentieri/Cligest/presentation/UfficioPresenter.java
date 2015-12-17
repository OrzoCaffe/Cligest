package it.forit.Argentieri.Cligest.presentation;

import it.forit.Argentieri.Cligest.business.boundary.UfficioBoundary;
import it.forit.Argentieri.Cligest.business.entity.UfficioDiAppartenenza;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UfficioPresenter implements Serializable {

    @Inject
    UfficioBoundary ufficioBoundary;

    private UfficioDiAppartenenza ufficioDiAppartenenza;

    public UfficioDiAppartenenza getUfficioDiAppartenenza() {
        return ufficioDiAppartenenza;
    }

    public void setUfficioDiAppartenenza(UfficioDiAppartenenza ufficioDiAppartenenza) {
        this.ufficioDiAppartenenza = ufficioDiAppartenenza;
    }

    public String dettaglioUfficioDiAppartenenza(Long id) {
        if (id == null) {
            this.ufficioDiAppartenenza = new UfficioDiAppartenenza();
        } else {
            this.ufficioDiAppartenenza = ufficioBoundary.readUfficio(id);
        }

        return "dettaglioUfficioDiAppartenenza";
    }

    public String salvaUfficioDiAppartenenza() {
        ufficioBoundary.saveUfficio(this.ufficioDiAppartenenza);
        return "elencoUfficioDiAppartenenza";
    }

    public void eliminaUfficioDiAppartenenza(UfficioDiAppartenenza ufficioDiAppartenenza) {
       // ufficioBoundary.deleteUfficio(ufficioDiAppartenenza);

        UfficioDiAppartenenza tmp;
        tmp = ufficioDiAppartenenza;
        tmp.setNomeUfficio("Inserire qui un nome per l'ufficio ");
        ufficioBoundary.saveUfficio(tmp);
    }

    public List<UfficioDiAppartenenza> elencoUfficioDiAppartenenza() {
        return ufficioBoundary.listUfficioDiAppartenenza();
    }

}
