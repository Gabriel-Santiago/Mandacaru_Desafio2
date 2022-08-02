package mandacaru.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mandacaru.dao.*;
import mandacaru.entities.Anuncio;

@Path("/anuncios")
public class AnuncioController {

	AnuncioDAO imovelDAO = new AnuncioHibernateDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> getAllProducts() {
		return imovelDAO.findall();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Anuncio getById(@PathParam("id") int id) {
		return imovelDAO.find(id);
	}


	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addProduct(@FormParam("titulo") String titulo, @FormParam("endereco") String endereco,
		@FormParam("metros_quadrados_de_terreno") int metros_quadrados_de_terreno,@FormParam("quantidade_de_quartos") int quantidade_de_quartos,
		@FormParam("quantidade_de_banheiros") int quantidade_de_banheiros,@FormParam("quantidade_de_vagas_de_garagem") int quantidade_de_vagas_de_garagem, 
		@FormParam("preco") double preco) {	
		
		Anuncio product = new Anuncio(0, titulo, endereco, metros_quadrados_de_terreno, quantidade_de_quartos, quantidade_de_banheiros, quantidade_de_vagas_de_garagem, preco);
		imovelDAO.save(product);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateProduct(@PathParam("id") int id,@FormParam("titulo") String titulo, @FormParam("endereco") String endereco, 
		@FormParam("metros_quadrados_de_terreno") int metros_quadrados_de_terreno,@FormParam("quantidade_de_quartos") int quantidade_de_quartos,
		@FormParam("quantidade_de_banheiros") int quantidade_de_banheiros,@FormParam("quantidade_de_vagas_de_garagem") int quantidade_de_vagas_de_garagem, 
		@FormParam("preco") double preco) {
		
		Anuncio product = new Anuncio(id, titulo, endereco, metros_quadrados_de_terreno, quantidade_de_quartos, quantidade_de_banheiros, quantidade_de_vagas_de_garagem, preco);
		imovelDAO.save(product);
	}

	@DELETE
	@Path("/{id}")
	public void deleteProduct(@PathParam("id") int id) {
		imovelDAO.delete(id);
	}
}
