
package it.forit.Argentieri.Cligest.business.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class UfficioDiAppartenenza implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private int version;
    
    @Column
    private String nomeUfficio;

    public UfficioDiAppartenenza() {
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

    public String getNomeUfficio() {
        return nomeUfficio;
    }

    public void setNomeUfficio(String nomeUfficio) {
        this.nomeUfficio = nomeUfficio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + this.version;
        hash = 71 * hash + Objects.hashCode(this.nomeUfficio);
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
        final UfficioDiAppartenenza other = (UfficioDiAppartenenza) obj;
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.nomeUfficio, other.nomeUfficio)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
