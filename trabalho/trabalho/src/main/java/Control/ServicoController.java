package Control;

import java.util.List;

import DAO.ServicoDAO;
import Model.Servico;

public class ServicoController {
    private ServicoDAO servicoDAO = new ServicoDAO();

    public void addServico(Servico servico) {
        servicoDAO.save(servico);
    }

    public Servico getServico(Integer id) {
        return servicoDAO.findById(id);
    }

    public List<Servico> getAllServicos() {
        return servicoDAO.findAll();
    }

    public void updateServico(Servico servico) {
        servicoDAO.update(servico);
    }

    public void deleteServico(Integer id) {
        Servico servico = servicoDAO.findById(id);
        if (servico != null) {
            servicoDAO.delete(servico);
        }
    }
}

