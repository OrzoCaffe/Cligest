package it.forit.Argentieri.Cligest.business.boundary;

import it.forit.Argentieri.Cligest.business.entity.Cliente;
import it.forit.Argentieri.Cligest.business.entity.PersonaDiRiferimento;
import it.forit.Argentieri.Cligest.business.entity.Stabilimento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

//---------------BOUNDARY DI STABILIMENTO E PERSONADIRIFERIMENTO ACCORPATI A CLIENTE-----------------
@Stateless
public class ClienteBoundary {

    @PersistenceContext
    EntityManager em;
    
    
    public Cliente readCliente(Long id) {
        return em.find(Cliente.class, id);
    }

    public Cliente saveCliente(Cliente cliente) {
        return em.merge(cliente);
    }

    public void deleteCliente(Cliente cliente) {
        em.remove(em.merge(cliente));
    }

    public List<Cliente> listCliente() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> unitaRoot = query.from(Cliente.class);
        query.select(unitaRoot);
        return em.createQuery(query).getResultList();
    }

    public void deleteStabilimento(Stabilimento stabilimento) {
        em.remove(em.merge(stabilimento));
    }

    public void deletePersonaDiRiferimento(PersonaDiRiferimento personaDiRiferimento) {
        em.remove(em.merge(personaDiRiferimento));
    }

}
