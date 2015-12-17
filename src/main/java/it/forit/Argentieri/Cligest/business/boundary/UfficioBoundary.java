package it.forit.Argentieri.Cligest.business.boundary;

import it.forit.Argentieri.Cligest.business.entity.UfficioDiAppartenenza;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class UfficioBoundary {

    @PersistenceContext
    EntityManager em;

    public UfficioDiAppartenenza readUfficio(Long id) {
        return em.find(UfficioDiAppartenenza.class, id);
    }

    public UfficioDiAppartenenza saveUfficio(UfficioDiAppartenenza ufficioDiAppartenenza) {
        return em.merge(ufficioDiAppartenenza);
    }

    public void deleteUfficio(UfficioDiAppartenenza ufficioDiAppartenenza) {
        em.remove(em.merge(ufficioDiAppartenenza));
    }

    public List<UfficioDiAppartenenza> listUfficioDiAppartenenza() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UfficioDiAppartenenza> query = cb.createQuery(UfficioDiAppartenenza.class);
        //simile al From
        Root<UfficioDiAppartenenza> unitaRoot = query.from(UfficioDiAppartenenza.class);
        query.select(unitaRoot);

        return em.createQuery(query).getResultList();
    }
}
