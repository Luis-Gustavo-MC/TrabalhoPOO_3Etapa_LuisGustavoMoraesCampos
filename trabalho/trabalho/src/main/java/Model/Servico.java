package Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServico;

    @Column(name = "dataServico", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "observacoes", nullable = false, length = 200)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "idAnimal_Servico", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "idProprietario_Servico", nullable = false)
    private Proprietario proprietario;

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

   
}
