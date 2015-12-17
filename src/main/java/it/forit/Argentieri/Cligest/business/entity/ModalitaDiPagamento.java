
package it.forit.Argentieri.Cligest.business.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class ModalitaDiPagamento implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private int version;
    
    @Column
    private String tipo;
    
    @Column
    private int fraQuantoPago;

    public ModalitaDiPagamento() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFraQuantoPago() {
        return fraQuantoPago;
    }

    public void setFraQuantoPago(int fraQuantoPago) {
        this.fraQuantoPago = fraQuantoPago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModalitaDiPagamento other = (ModalitaDiPagamento) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

}
