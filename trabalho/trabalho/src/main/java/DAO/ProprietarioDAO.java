package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Proprietario;

import java.util.List;

public class ProprietarioDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshopPU");

    public void save(Proprietario proprietario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(proprietario);
        em.getTransaction().commit();
        em.close();
    }

    public Proprietario findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Proprietario proprietario = em.find(Proprietario.class, id);
        em.close();
        return proprietario;
    }

    public List<Proprietario> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Proprietario> proprietarios = em.createQuery("from Proprietario", Proprietario.class).getResultList();
        em.close();
        return proprietarios;
    }

    public void update(Proprietario proprietario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(proprietario);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Proprietario proprietario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(proprietario) ? proprietario : em.merge(proprietario));
        em.getTransaction().commit();
        em.close();
    }
}

