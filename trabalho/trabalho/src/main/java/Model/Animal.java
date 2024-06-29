package Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnimal;

    @Column(name = "nomeAnimal", nullable = false, length = 30)
    private String nome;

    @Column(name = "especieAnimal", nullable = false, length = 30)
    private String especie;

    @Column(name = "racaAnimal", nullable = false, length = 30)
    private String raca;

    @Column(name = "idadeAnimal", nullable = false)
    private Integer idade;

    @Column(name = "sexoAnimal", nullable = false, length = 30)
    private String sexo;

    @Column(name = "pesoAnimal", nullable = false)
    private Double peso;

    @Column(name = "fotoAnimal", length = 255)
    private String foto;

    @Column(name = "statusAnimal", nullable = false)
    private boolean status;

    @Column(name = "caminhoFoto", length = 255)
    private String caminhoFoto;

    @ManyToOne
    @JoinColumn(name = "idProprietario_Animal", nullable = false)
    private Proprietario proprietario;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Servico> servicos;
    
 // Getters and Setters
	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

    
}
