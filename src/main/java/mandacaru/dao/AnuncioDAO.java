package mandacaru.dao;

import java.util.List;
import mandacaru.entities.Anuncio;

public interface AnuncioDAO {
	
	public void save(Anuncio entity);
	
	public void delete(int id);
	
	public Anuncio find(int id);
	
	public List<Anuncio> findall();
}
