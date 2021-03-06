package br.com.itProdigium.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PDG_VIAGEM")
@SequenceGenerator(name = "viagem", sequenceName = "SQ_T_PDG_VIAGEM", allocationSize = 1, initialValue = 1)
public class Viagem {

	@Id
	@GeneratedValue(generator = "viagem", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_viagem", nullable = false)
	private int id;
	

	@Column(name = "ds_peso", nullable = false, precision = 6)
	private int peso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_viagem")
	private Calendar dtViagem;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "T_PDG_VIAGEM_COORDENADAS",
				joinColumns = @JoinColumn(name = "id_viagem"),
				inverseJoinColumns = @JoinColumn(name = "id_local"))
	private List<Coordenadas> coordenadas;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	
	public Viagem(int peso, Calendar dtViagem, List<Coordenadas> coordenadas, Usuario usuario) {
		super();
		this.peso = peso;
		this.dtViagem = dtViagem;
		this.coordenadas = coordenadas;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Calendar getDtViagem() {
		return dtViagem;
	}

	public void setDtViagem(Calendar dtViagem) {
		this.dtViagem = dtViagem;
	}

	public List<Coordenadas> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenadas> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
