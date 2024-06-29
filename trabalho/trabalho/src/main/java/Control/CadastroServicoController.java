package Control;

import java.util.List;

import DAO.CadastroServicoDAO;
import Model.CadastroServico;

public class CadastroServicoController {
    private CadastroServicoDAO cadastroServicoDAO = new CadastroServicoDAO();

    public void addCadastroServico(CadastroServico servico) {
        cadastroServicoDAO.save(servico);
    }

    public CadastroServico getCadastroServico(Integer id) {
        return cadastroServicoDAO.findById(id);
    }

    public List<CadastroServico> getAllCadastroServicos() {
        return cadastroServicoDAO.findAll();
    }

    public void updateCadastroServico(CadastroServico servico) {
        cadastroServicoDAO.update(servico);
    }

    public void deleteCadastroServico(Integer id) {
        CadastroServico servico = cadastroServicoDAO.findById(id);
        if (servico != null) {
            cadastroServicoDAO.delete(servico);
        }
    }
}
