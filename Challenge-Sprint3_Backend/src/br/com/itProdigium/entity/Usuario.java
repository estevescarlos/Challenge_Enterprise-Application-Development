package br.com.itProdigium.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "T_PDG_USUARIO")
@SequenceGenerator(name = "user", sequenceName = "SQ_T_PDG_USUARIO", allocationSize = 1, initialValue = 1)
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private int id;
	
	@Column(name = "nm_usuario", nullable = false, length = 64)
	private String name;
	
	@Column(name = "ds_email", nullable = false, length = 64)
	private String email;
	
	@Column(name="nr_telefone", nullable = false, length = 11)
	private String tel;
	
	@Column(name = "ds_senha", nullable = false, length = 64)
	private String password;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
	private List<Viagem> viagens;
	
	public Usuario(int id, String name, String email, String tel, String password, List<Viagem> viagens) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.viagens = viagens;
	}
	
	
	public Usuario(String name, String email, String tel, String password, List<Viagem> viagens) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.viagens = viagens;
	}

	public Usuario(String name, String email, String tel, String password) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
