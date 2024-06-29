package View;

import java.util.Scanner;

import Control.AnimalController;
import Control.CadastroServicoController;
import Control.ProprietarioController;
import Control.ServicoController;
import Model.Animal;
import Model.CadastroServico;
import Model.Proprietario;
import Model.Servico;

import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ProprietarioController proprietarioController = new ProprietarioController();
    private static AnimalController animalController = new AnimalController();
    private static CadastroServicoController cadastroServicoController = new CadastroServicoController();
    private static ServicoController servicoController = new ServicoController();

    public static void main(String[] args) {
        int option = -1;
        while (option != 0) {
            System.out.println("1. Gerenciar Proprietários");
            System.out.println("2. Gerenciar Animais");
            System.out.println("3. Gerenciar Serviços");
            System.out.println("4. Lançar Serviços");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    manageProprietarios();
                    break;
                case 2:
                    manageAnimais();
                    break;
                case 3:
                    manageCadastroServicos();
                    break;
                case 4:
                    manageServicos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void manageProprietarios() {
        int option = -1;
        while (option != 0) {
            System.out.println("1. Adicionar Proprietário");
            System.out.println("2. Listar Proprietários");
            System.out.println("3. Atualizar Proprietário");
            System.out.println("4. Deletar Proprietário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addProprietario();
                    break;
                case 2:
                    listProprietarios();
                    break;
                case 3:
                    updateProprietario();
                    break;
                case 4:
                    deleteProprietario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void addProprietario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Status (true/false): ");
        boolean status = Boolean.parseBoolean(scanner.nextLine());

        Proprietario proprietario = new Proprietario();
        proprietario.setNome(nome);
        proprietario.setEndereco(endereco);
        proprietario.setTelefone(telefone);
        proprietario.setEmail(email);
        proprietario.setStatus(status);

        proprietarioController.addProprietario(proprietario);
        System.out.println("Proprietário adicionado com sucesso!");
    }

    private static void listProprietarios() {
        List<Proprietario> proprietarios = proprietarioController.getAllProprietarios();
        for (Proprietario proprietario : proprietarios) {
            System.out.println(proprietario);
        }
    }

    private static void updateProprietario() {
        System.out.print("ID do Proprietário: ");
        int id = Integer.parseInt(scanner.nextLine());
        Proprietario proprietario = proprietarioController.getProprietario(id);
        if (proprietario != null) {
            System.out.print("Nome (" + proprietario.getNome() + "): ");
            proprietario.setNome(scanner.nextLine());
            System.out.print("Endereço (" + proprietario.getEndereco() + "): ");
            proprietario.setEndereco(scanner.nextLine());
            System.out.print("Telefone (" + proprietario.getTelefone() + "): ");
            proprietario.setTelefone(scanner.nextLine());
            System.out.print("Email (" + proprietario.getEmail() + "): ");
            proprietario.setEmail(scanner.nextLine());
            System.out.print("Status (" + proprietario.isStatus() + "): ");
            proprietario.setStatus(Boolean.parseBoolean(scanner.nextLine()));

            proprietarioController.updateProprietario(proprietario);
            System.out.println("Proprietário atualizado com sucesso!");
        } else {
            System.out.println("Proprietário não encontrado!");
        }
    }

    private static void deleteProprietario() {
        System.out.print("ID do Proprietário: ");
        int id = Integer.parseInt(scanner.nextLine());
        proprietarioController.deleteProprietario(id);
        System.out.println("Proprietário deletado com sucesso!");
    }

    private static void manageAnimais() {
        int option = -1;
        while (option != 0) {
            System.out.println("1. Adicionar Animal");
            System.out.println("2. Listar Animais");
            System.out.println("3. Atualizar Animal");
            System.out.println("4. Deletar Animal");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listAnimais();
                    break;
                case 3:
                    updateAnimal();
                    break;
                case 4:
                    deleteAnimal();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void addAnimal() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Peso: ");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.print("Foto (opcional): ");
        String foto = scanner.nextLine();
        System.out.print("Status (true/false): ");
        boolean status = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Caminho da Foto: ");
        String caminhoFoto = scanner.nextLine();
        System.out.print("ID do Proprietário: ");
        int idProprietario = Integer.parseInt(scanner.nextLine());

        Animal animal = new Animal();
        animal.setNome(nome);
        animal.setEspecie(especie);
        animal.setRaca(raca);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setPeso(peso);
        animal.setFoto(foto);
        animal.setStatus(status);
        animal.setCaminhoFoto(caminhoFoto);
        animal.setProprietario(proprietarioController.getProprietario(idProprietario));

        animalController.addAnimal(animal);
        System.out.println("Animal adicionado com sucesso!");
    }

    private static void listAnimais() {
        List<Animal> animais = animalController.getAllAnimais();
        for (Animal animal : animais) {
            System.out.println(animal);
        }
    }

    private static void updateAnimal() {
        System.out.print("ID do Animal: ");
        int id = Integer.parseInt(scanner.nextLine());
        Animal animal = animalController.getAnimal(id);
        if (animal != null) {
            System.out.print("Nome (" + animal.getNome() + "): ");
            animal.setNome(scanner.nextLine());
            System.out.print("Espécie (" + animal.getEspecie() + "): ");
            animal.setEspecie(scanner.nextLine());
            System.out.print("Raça (" + animal.getRaca() + "): ");
            animal.setRaca(scanner.nextLine());
            System.out.print("Idade (" + animal.getIdade() + "): ");
            animal.setIdade(Integer.parseInt(scanner.nextLine()));
            System.out.print("Sexo (" + animal.getSexo() + "): ");
            animal.setSexo(scanner.nextLine());
            System.out.print("Peso (" + animal.getPeso() + "): ");
            animal.setPeso(Double.parseDouble(scanner.nextLine()));
            System.out.print("Foto (" + animal.getFoto() + "): ");
            animal.setFoto(scanner.nextLine());
            System.out.print("Status (" + animal.isStatus() + "): ");
            animal.setStatus(Boolean.parseBoolean(scanner.nextLine()));
            System.out.print("Caminho da Foto (" + animal.getCaminhoFoto() + "): ");
            animal.setCaminhoFoto(scanner.nextLine());

            animalController.updateAnimal(animal);
            System.out.println("Animal atualizado com sucesso!");
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    private static void deleteAnimal() {
        System.out.print("ID do Animal: ");
        int id = Integer.parseInt(scanner.nextLine());
        animalController.deleteAnimal(id);
        System.out.println("Animal deletado com sucesso!");
    }

    private static void manageCadastroServicos() {
        int option = -1;
        while (option != 0) {
            System.out.println("1. Adicionar Serviço");
            System.out.println("2. Listar Serviços");
            System.out.println("3. Atualizar Serviço");
            System.out.println("4. Deletar Serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addCadastroServico();
                    break;
                case 2:
                    listCadastroServicos();
                    break;
                case 3:
                    updateCadastroServico();
                    break;
                case 4:
                    deleteCadastroServico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void addCadastroServico() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        CadastroServico servico = new CadastroServico();
        servico.setNome(nome);
        servico.setDescricao(descricao);
        servico.setPreco(preco);

        cadastroServicoController.addCadastroServico(servico);
        System.out.println("Serviço adicionado com sucesso!");
    }

    private static void listCadastroServicos() {
        List<CadastroServico> servicos = cadastroServicoController.getAllCadastroServicos();
        for (CadastroServico servico : servicos) {
            System.out.println(servico);
        }
    }

    private static void updateCadastroServico() {
        System.out.print("ID do Serviço: ");
        int id = Integer.parseInt(scanner.nextLine());
        CadastroServico servico = cadastroServicoController.getCadastroServico(id);
        if (servico != null) {
            System.out.print("Nome (" + servico.getNome() + "): ");
            servico.setNome(scanner.nextLine());
            System.out.print("Descrição (" + servico.getDescricao() + "): ");
            servico.setDescricao(scanner.nextLine());
            System.out.print("Preço (" + servico.getPreco() + "): ");
            servico.setPreco(Double.parseDouble(scanner.nextLine()));

            cadastroServicoController.updateCadastroServico(servico);
            System.out.println("Serviço atualizado com sucesso!");
        } else {
            System.out.println("Serviço não encontrado!");
        }
    }

    private static void deleteCadastroServico() {
        System.out.print("ID do Serviço: ");
        int id = Integer.parseInt(scanner.nextLine());
        cadastroServicoController.deleteCadastroServico(id);
        System.out.println("Serviço deletado com sucesso!");
    }

    private static void manageServicos() {
        int option = -1;
        while (option != 0) {
            System.out.println("1. Lançar Serviço");
            System.out.println("2. Listar Serviços Lançados");
            System.out.println("3. Atualizar Serviço Lançado");
            System.out.println("4. Deletar Serviço Lançado");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addServico();
                    break;
                case 2:
                    listServicos();
                    break;
                case 3:
                    updateServico();
                    break;
                case 4:
                    deleteServico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void addServico() {
        System.out.print("Data (YYYY-MM-DD): ");
        String data = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());
        System.out.print("Observações: ");
        String observacoes = scanner.nextLine();
        System.out.print("ID do Animal: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        System.out.print("ID do Proprietário: ");
        int idProprietario = Integer.parseInt(scanner.nextLine());

        Servico servico = new Servico();
        servico.setData(java.sql.Date.valueOf(data));
        servico.setValor(valor);
        servico.setObservacoes(observacoes);
        servico.setAnimal(animalController.getAnimal(idAnimal));
        servico.setProprietario(proprietarioController.getProprietario(idProprietario));

        servicoController.addServico(servico);
        System.out.println("Serviço lançado com sucesso!");
    }

    private static void listServicos() {
        List<Servico> servicos = servicoController.getAllServicos();
        for (Servico servico : servicos) {
            System.out.println(servico);
        }
    }

    private static void updateServico() {
        System.out.print("ID do Serviço: ");
        int id = Integer.parseInt(scanner.nextLine());
        Servico servico = servicoController.getServico(id);
        if (servico != null) {
            System.out.print("Data (" + servico.getData() + "): ");
            servico.setData(java.sql.Date.valueOf(scanner.nextLine()));
            System.out.print("Valor (" + servico.getValor() + "): ");
            servico.setValor(Double.parseDouble(scanner.nextLine()));
            System.out.print("Observações (" + servico.getObservacoes() + "): ");
            servico.setObservacoes(scanner.nextLine());
            System.out.print("ID do Animal (" + servico.getAnimal().getIdAnimal() + "): ");
            servico.setAnimal(animalController.getAnimal(Integer.parseInt(scanner.nextLine())));
            System.out.print("ID do Proprietário (" + servico.getProprietario().getIdProprietario() + "): ");
            servico.setProprietario(proprietarioController.getProprietario(Integer.parseInt(scanner.nextLine())));

            servicoController.updateServico(servico);
            System.out.println("Serviço lançado atualizado com sucesso!");
        } else {
            System.out.println("Serviço não encontrado!");
        }
    }

    private static void deleteServico() {
        System.out.print("ID do Serviço: ");
        int id = Integer.parseInt(scanner.nextLine());
        servicoController.deleteServico(id);
        System.out.println("Serviço lançado deletado com sucesso!");
    }
}


