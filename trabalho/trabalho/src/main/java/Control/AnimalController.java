package Control;

import java.util.List;

import DAO.AnimalDAO;
import Model.Animal;

public class AnimalController {
    private AnimalDAO animalDAO = new AnimalDAO();

    public void addAnimal(Animal animal) {
        animalDAO.save(animal);
    }

    public Animal getAnimal(Integer id) {
        return animalDAO.findById(id);
    }

    public List<Animal> getAllAnimais() {
        return animalDAO.findAll();
    }

    public void updateAnimal(Animal animal) {
        animalDAO.update(animal);
    }

    public void deleteAnimal(Integer id) {
        Animal animal = animalDAO.findById(id);
        if (animal != null) {
            animalDAO.delete(animal);
        }
    }
}

