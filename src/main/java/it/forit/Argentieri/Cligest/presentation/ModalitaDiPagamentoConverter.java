package it.forit.Argentieri.Cligest.presentation;

import it.forit.Argentieri.Cligest.business.entity.ModalitaDiPagamento;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@RequestScoped
public class ModalitaDiPagamentoConverter implements Converter {
    @PersistenceContext
    EntityManager em;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return em.find(ModalitaDiPagamento.class, Long.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s non e' un ID valido", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof ModalitaDiPagamento) {
            return String.valueOf(((ModalitaDiPagamento) value).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s non e' una modalita' di pagamento valida", value)));
        }
    }

}
