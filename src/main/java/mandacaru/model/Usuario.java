package mandacaru.model;

import java.util.Arrays;

public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String telefone;
	private String endereco;
	private Imovel anuncios[];
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Imovel[] getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(Imovel[] anuncios) {
		this.anuncios = anuncios;
	}

	public Usuario(int id, String nome, String email, String senha, String cpf, String telefone, String endereco,
			Imovel[] anuncios) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.anuncios = anuncios;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", endereco=" + endereco + ", anuncios=" + Arrays.toString(anuncios) + "]";
	}

}
