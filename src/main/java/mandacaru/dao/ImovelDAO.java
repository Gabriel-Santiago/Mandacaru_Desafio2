package mandacaru.dao;

import java.util.List;
import mandacaru.model.Imovel;

public interface ImovelDAO {
	
	public void save(Imovel entity);
	
	public void delete(int id);
	
	public Imovel find(int id);
	
	public List<Imovel> findall();
}
