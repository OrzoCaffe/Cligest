package it.forit.Argentieri.Cligest.presentation;

import it.forit.Argentieri.Cligest.business.boundary.ClienteBoundary;
import it.forit.Argentieri.Cligest.business.entity.Cliente;
import it.forit.Argentieri.Cligest.business.entity.ModalitaDiPagamento;
import it.forit.Argentieri.Cligest.business.entity.PersonaDiRiferimento;
import it.forit.Argentieri.Cligest.business.entity.Stabilimento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

//------------------PRESENTER DI STABILIMENTO E PERSONADIRIFERIMENTO ACCORPATI A CLIENTE------------------
@Named
@SessionScoped
public class ClientePresenter implements Serializable {

    @Inject
    ClienteBoundary clienteBoundary;

    private Cliente cliente;
    private Stabilimento stabilimento;
    private PersonaDiRiferimento personaDiRiferimento;
    private ModalitaDiPagamento modalitaDiPagamento;

    public Cliente getCliente() {
        return cliente;
    }

    public ModalitaDiPagamento getModalitaDiPagamento() {
        return modalitaDiPagamento;
    }

    public void setModalitaDiPagamento(ModalitaDiPagamento modalitaDiPagamento) {
        this.modalitaDiPagamento = modalitaDiPagamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Stabilimento getStabilimento() {
        return stabilimento;
    }

    public void setStabilimento(Stabilimento stabilimento) {
        this.stabilimento = stabilimento;
    }

    public PersonaDiRiferimento getPersonaDiRiferimento() {
        return personaDiRiferimento;
    }

    public void setPersonaDiRiferimento(PersonaDiRiferimento personaDiRiferimento) {
        this.personaDiRiferimento = personaDiRiferimento;
    }

    public String dettaglioCliente(Long id) {
        if (id == null) {
            this.cliente = new Cliente();
        } else {
            this.cliente = clienteBoundary.readCliente(id);
        }

        return "dettaglioCliente";
    }

    public String salvaCliente() {
        clienteBoundary.saveCliente(this.cliente);
        return "elencoCliente";
    }

    public void eliminaCliente(Cliente cliente) {
        clienteBoundary.deleteCliente(cliente);
    }

    public List<Cliente> elencoCliente() {
        return clienteBoundary.listCliente();
    }

    public String creaStabilimento() {
        stabilimento = new Stabilimento();

        return "dettaglioStabilimento";
    }

    public String creaPersonaDiRiferimento() {
        personaDiRiferimento = new PersonaDiRiferimento();

        return "dettaglioPersonaDiRiferimento";
    }

    public String salvaStabilimento() {
        if (stabilimento.getCliente() == null) {
            cliente.getStabilimenti().add(stabilimento);
            stabilimento.setCliente(cliente);
        }

        return "dettaglioCliente";
    }

    public String salvaPersonaDiRiferimento() {
        if (personaDiRiferimento.getCliente() == null) {
            cliente.getPersoneDiRiferimento().add(personaDiRiferimento);
            personaDiRiferimento.setCliente(cliente);
        }

        return "dettaglioCliente";
    }

    public String dettaglioStabilimento(Stabilimento stabilimentoTMP) {
        stabilimento = stabilimentoTMP;
        return "dettaglioStabilimento";
    }

    public String dettaglioPersonaDiRiferimento(PersonaDiRiferimento personaTMP) {
        personaDiRiferimento = personaTMP;

        return "dettaglioPersonaDiRiferimento";
    }

    public void eliminaStabilimento(Stabilimento stabilimento) {
        cliente.getStabilimenti().remove(stabilimento);
        if (stabilimento.getId() != null) {
            clienteBoundary.deleteStabilimento(stabilimento);
        }
    }

    public void eliminaPersonaDiRiferimento(PersonaDiRiferimento personaDiRiferimento) {
        cliente.getPersoneDiRiferimento().remove(personaDiRiferimento);
        if (personaDiRiferimento.getId() != null) {
            clienteBoundary.deletePersonaDiRiferimento(personaDiRiferimento);
        }
    }
    
}
