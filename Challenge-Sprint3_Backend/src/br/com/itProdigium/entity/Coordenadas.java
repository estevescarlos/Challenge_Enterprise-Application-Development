package br.com.itProdigium.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PDG_COORDENADAS")
@SequenceGenerator(name = "coord", sequenceName = "SQ_T_PDG_COORDENADAS", allocationSize = 1, initialValue = 1)
public class Coordenadas {

	@Id
	@GeneratedValue(generator = "coord", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_local")
	private int id;
	
	@Column(name = "ds_latitude", nullable = false, length = 100)
	private String latitude;
	
	@Column(name = "ds_longitude", nullable = false, length = 100)
	private String longitude;

	@ManyToMany(mappedBy = "coordenadas")
	private List<Viagem> viagens;
	
	public Coordenadas(int id, String latitude, String longitude, List<Viagem> viagens) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.viagens = viagens;
	}
	
	public Coordenadas(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Coordenadas(String latitude, String longitude, List<Viagem> viagens) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.viagens = viagens;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
}
