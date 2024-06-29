package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.CadastroServico;

import java.util.List;

public class CadastroServicoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshopPU");

    public void save(CadastroServico servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
    }

    public CadastroServico findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        CadastroServico servico = em.find(CadastroServico.class, id);
        em.close();
        return servico;
    }

    public List<CadastroServico> findAll() {
        EntityManager em = emf.createEntityManager();
        List<CadastroServico> servicos = em.createQuery("from CadastroServico", CadastroServico.class).getResultList();
        em.close();
        return servicos;
    }

    public void update(CadastroServico servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(CadastroServico servico) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(servico) ? servico : em.merge(servico));
        em.getTransaction().commit();
        em.close();
    }
}

