package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Animal;

import java.util.List;

public class AnimalDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshopPU");

    public void save(Animal animal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
        em.close();
    }

    public Animal findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Animal animal = em.find(Animal.class, id);
        em.close();
        return animal;
    }

    public List<Animal> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Animal> animais = em.createQuery("from Animal", Animal.class).getResultList();
        em.close();
        return animais;
    }

    public void update(Animal animal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Animal animal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(animal) ? animal : em.merge(animal));
        em.getTransaction().commit();
        em.close();
    }
}

