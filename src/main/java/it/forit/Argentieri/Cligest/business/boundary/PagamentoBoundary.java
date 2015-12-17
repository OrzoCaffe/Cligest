package it.forit.Argentieri.Cligest.business.boundary;

import it.forit.Argentieri.Cligest.business.entity.ModalitaDiPagamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class PagamentoBoundary {

    @PersistenceContext
    EntityManager em;

    public ModalitaDiPagamento readPagamento(Long id) {
        return em.find(ModalitaDiPagamento.class, id);
    }

    public ModalitaDiPagamento savePagamento(ModalitaDiPagamento modalitaDiPagamento) {
        return em.merge(modalitaDiPagamento);
    }

    public void deletePagamento(ModalitaDiPagamento modalitaDiPagamento) {
        em.remove(em.merge(modalitaDiPagamento));
    }

    public List<ModalitaDiPagamento> listModalitaDiPagamento() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ModalitaDiPagamento> query = cb.createQuery(ModalitaDiPagamento.class);
        Root<ModalitaDiPagamento> unitaRoot = query.from(ModalitaDiPagamento.class);
        query.select(unitaRoot);

        return em.createQuery(query).getResultList();
    }

}
