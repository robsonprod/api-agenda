package br.com.mobitbrasil.interview.beans;

import br.com.mobitbrasil.interview.db.JpaRepository;
import br.com.mobitbrasil.interview.model.Contato;
import lombok.val;
import org.hibernate.NonUniqueResultException;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class ContatoBean extends JpaRepository<Contato> {

    protected ContatoBean() {
        super(Contato.class);
    }

    public Optional<Contato> findByIdAndAgendaId(Long id, Long agendaId) {
        val query = getManager().createNamedQuery("Contato.findByIdAndAgendaId");
        query.setParameter("id", id);
        query.setParameter("agendaId", agendaId);

        try {
            return Optional.ofNullable((Contato) query.getSingleResult());
        } catch (NonUniqueResultException e) {
            return Optional.empty();
        }
    }

    public List<Contato> findAllByAgendaId(Long agendaId) {
        val query = getManager().createNamedQuery("Contato.findAllByAgendaId");
        query.setParameter("agendaId", agendaId);
        return query.getResultList();
    }
}
