
package it.forit.Argentieri.Cligest.business.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class PersonaDiRiferimento implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private int version;
    
    @Column
    private String nome;
    
    @Column
    private String postaElettronica;
    
    @Column
    private String cellulare;
    
    @ManyToOne
    private UfficioDiAppartenenza ufficioDiAppartenenza;
    
    @ManyToOne
    private Cliente cliente;

    public PersonaDiRiferimento() {
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostaElettronica() {
        return postaElettronica;
    }

    public void setPostaElettronica(String postaElettronica) {
        this.postaElettronica = postaElettronica;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public UfficioDiAppartenenza getUfficioDiAppartenenza() {
        return ufficioDiAppartenenza;
    }

    public void setUfficioDiAppartenenza(UfficioDiAppartenenza ufficioDiAppartenenza) {
        this.ufficioDiAppartenenza = ufficioDiAppartenenza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
