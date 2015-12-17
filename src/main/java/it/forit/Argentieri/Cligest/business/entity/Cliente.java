package it.forit.Argentieri.Cligest.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private int version;
    
    @Column
    private String ragioneSociale;
    
    @Column
    private String nomeBreve;
    
    @Column
    private String indirizzoWeb;
    
    @Column
    private String note; // Può essere una Lista
    
    @ManyToOne
    private ModalitaDiPagamento modalitaDiPagamento;
    
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    List<Stabilimento> stabilimenti;
    
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    List<PersonaDiRiferimento> personeDiRiferimento;

    public Cliente() {
        stabilimenti = new ArrayList<>();
        personeDiRiferimento = new ArrayList<>();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public ModalitaDiPagamento getModalitaDiPagamento() {
        return modalitaDiPagamento;
    }

    public void setModalitaDiPagamento(ModalitaDiPagamento modalitaDiPagamento) {
        this.modalitaDiPagamento = modalitaDiPagamento;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getNomeBreve() {
        return nomeBreve;
    }

    public void setNomeBreve(String nomeBreve) {
        this.nomeBreve = nomeBreve;
    }

    public String getIndirizzoWeb() {
        return indirizzoWeb;
    }

    public void setIndirizzoWeb(String indirizzoWeb) {
        this.indirizzoWeb = indirizzoWeb;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Stabilimento> getStabilimenti() {
        return stabilimenti;
    }

    public void setStabilimenti(List<Stabilimento> stabilimenti) {
        this.stabilimenti = stabilimenti;
    }

    public List<PersonaDiRiferimento> getPersoneDiRiferimento() {
        return personeDiRiferimento;
    }

    public void setPersoneDiRiferimento(List<PersonaDiRiferimento> personeDiRiferimento) {
        this.personeDiRiferimento = personeDiRiferimento;
    }
    
}
