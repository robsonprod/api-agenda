package br.com.mobitbrasil.interview.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class JpaRepository<T> {

    @PersistenceContext(unitName = "programmer")
    private EntityManager em;

    private final Class<T> clazz;

    protected JpaRepository(Class<T> e) {
        clazz = e;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public T save(T entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            Logger.getLogger(JpaRepository.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
        }

        return entity;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public T update(T entity) {
        try {
            em.merge(entity);
        } catch (Exception e) {
            Logger.getLogger(JpaRepository.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
        }

        return entity;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        em.remove(findById(id));
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(em.find(clazz, id));
    }

    public EntityManager getManager() {
        return em;
    }
}
