package it.forit.Argentieri.Cligest.presentation;

import it.forit.Argentieri.Cligest.business.boundary.PagamentoBoundary;
import it.forit.Argentieri.Cligest.business.entity.ModalitaDiPagamento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PagamentoPresenter implements Serializable {

    @Inject
    PagamentoBoundary pagamentoBoundary;

    private ModalitaDiPagamento modalitaDiPagamento;
        
    public ModalitaDiPagamento getModalitaDiPagamento() {
        return modalitaDiPagamento;
    }

    public void setModalitaDiPagamento(ModalitaDiPagamento modalitaDiPagamento) {
        this.modalitaDiPagamento = modalitaDiPagamento;
    }

    public String dettaglioModalitaDiPagamento(Long id) {
        if (id == null) {
            this.modalitaDiPagamento = new ModalitaDiPagamento();
        } else {
            this.modalitaDiPagamento = pagamentoBoundary.readPagamento(id);
        }

        return "dettaglioModalitaDiPagamento";
    }

    public String salvaModalitaDiPagamento() {
        pagamentoBoundary.savePagamento(this.modalitaDiPagamento);
        return "elencoModalitaDiPagamento";
    }

    public void eliminaModalitaDiPagamento(ModalitaDiPagamento modalitaDiPagamento/*, Long id*/) {
//         pagamentoBoundary.deletePagamento(modalitaDiPagamento); 

        ModalitaDiPagamento tmp;
        tmp = modalitaDiPagamento;
        tmp.setTipo("Inserire qui una modalità di pagamento ");
        tmp.setFraQuantoPago(0);
        pagamentoBoundary.savePagamento(tmp);
    }

    public List<ModalitaDiPagamento> elencoModalitaDiPagamento() {
        return pagamentoBoundary.listModalitaDiPagamento();
    }
}
