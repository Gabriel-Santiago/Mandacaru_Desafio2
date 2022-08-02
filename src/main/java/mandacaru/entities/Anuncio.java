package mandacaru.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "imovel")
public class Anuncio {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "metros_quadrados_de_terreno")
	private int metros_quadrados_de_terreno;
	@Column(name = "quantidade_de_quartos")
	private int quantidade_de_quartos;
	@Column(name = "quantidade_de_banheiros")
	private int quantidade_de_banheiros;
	@Column(name = "quantidade_de_vagas_de_garagem")
	private int quantidade_de_vagas_de_garagem;
	@Column(name = "preco")
	private double preco;
	
	public Anuncio(int id, String titulo, String endereco, int metros_quadrados_de_terreno, int quantidade_de_quartos,
			int quantidade_de_banheiros, int quantidade_de_vagas_de_garagem, double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.endereco = endereco;
		this.metros_quadrados_de_terreno = metros_quadrados_de_terreno;
		this.quantidade_de_quartos = quantidade_de_quartos;
		this.quantidade_de_banheiros = quantidade_de_banheiros;
		this.quantidade_de_vagas_de_garagem = quantidade_de_vagas_de_garagem;
		this.preco = preco;
	}
	
	public Anuncio() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getMetros_quadrados_de_terreno() {
		return metros_quadrados_de_terreno;
	}
	public void setMetros_quadrados_de_terreno(int metros_quadrados_de_terreno) {
		this.metros_quadrados_de_terreno = metros_quadrados_de_terreno;
	}
	public int getQuantidade_de_quartos() {
		return quantidade_de_quartos;
	}
	public void setQuantidade_de_quartos(int quantidade_de_quartos) {
		this.quantidade_de_quartos = quantidade_de_quartos;
	}
	public int getQuantidade_de_banheiros() {
		return quantidade_de_banheiros;
	}
	public void setQuantidade_de_banheiros(int quantidade_de_banheiros) {
		this.quantidade_de_banheiros = quantidade_de_banheiros;
	}
	public int getQuantidade_de_vagas_de_garagem() {
		return quantidade_de_vagas_de_garagem;
	}
	public void setQuantidade_de_vagas_de_garagem(int quantidade_de_vagas_de_garagem) {
		this.quantidade_de_vagas_de_garagem = quantidade_de_vagas_de_garagem;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "imovel [id=" + id + ", titulo=" + titulo + ", endereco=" + endereco + ", metros_quadrados_de_terreno="
				+ metros_quadrados_de_terreno + ", quantidade_de_quartos=" + quantidade_de_quartos
				+ ", quantidade_de_banheiros=" + quantidade_de_banheiros + ", quantidade_de_vagas_de_garagem="
				+ quantidade_de_vagas_de_garagem + ", preco=" + preco + "]";
	}

}
