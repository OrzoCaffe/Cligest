
package it.forit.Argentieri.Cligest.business.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Stabilimento implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private int version;
    
    @Column
    private String nome;
    
    @Column
    private String indirizzo;
    
    @Column
    private String numeroDiTelefono;
    
    @Column
    private String numeroDiFax;
    
    @ManyToOne(optional = false)
    private Cliente cliente; 

    public Stabilimento() {
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
    }

    public String getNumeroDiFax() {
        return numeroDiFax;
    }

    public void setNumeroDiFax(String numeroDiFax) {
        this.numeroDiFax = numeroDiFax;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
