package Model;

import javax.persistence.*;

@Entity
@Table(name = "Cadastro_servico")
public class CadastroServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCServicos;

    @Column(name = "nomeCServico", nullable = false, length = 30)
    private String nome;

    @Column(name = "descricaoCServico", nullable = false, length = 200)
    private String descricao;

    @Column(name = "precoCServico", nullable = false)
    private Double preco;

	public Integer getIdCServicos() {
		return idCServicos;
	}

	public void setIdCServicos(Integer idCServicos) {
		this.idCServicos = idCServicos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

    
}
