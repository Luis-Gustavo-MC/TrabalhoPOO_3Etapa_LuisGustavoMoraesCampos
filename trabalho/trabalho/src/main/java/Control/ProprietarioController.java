package Control;

import java.util.List;

import DAO.ProprietarioDAO;
import Model.Proprietario;

public class ProprietarioController {
    private ProprietarioDAO proprietarioDAO = new ProprietarioDAO();

    public void addProprietario(Proprietario proprietario) {
        proprietarioDAO.save(proprietario);
    }

    public Proprietario getProprietario(Integer id) {
        return proprietarioDAO.findById(id);
    }

    public List<Proprietario> getAllProprietarios() {
        return proprietarioDAO.findAll();
    }

    public void updateProprietario(Proprietario proprietario) {
        proprietarioDAO.update(proprietario);
    }

    public void deleteProprietario(Integer id) {
        Proprietario proprietario = proprietarioDAO.findById(id);
        if (proprietario != null) {
            proprietarioDAO.delete(proprietario);
        }
    }
}

