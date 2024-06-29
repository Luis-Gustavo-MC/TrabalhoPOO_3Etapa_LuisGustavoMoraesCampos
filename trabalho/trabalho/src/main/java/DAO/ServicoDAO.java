package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Servico;

import java.util.List;

public class ServicoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshopPU");

    public void save(Servico servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
    }

    public Servico findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Servico servico = em.find(Servico.class, id);
        em.close();
        return servico;
    }

    public List<Servico> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Servico> servicos = em.createQuery("from Servico", Servico.class).getResultList();
        em.close();
        return servicos;
    }

    public void update(Servico servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Servico servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(servico) ? servico : em.merge(servico));
        em.getTransaction().commit();
        em.close();
    }
}

