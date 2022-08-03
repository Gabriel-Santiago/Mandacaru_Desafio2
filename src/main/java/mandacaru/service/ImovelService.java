package mandacaru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mandacaru.dao.ImovelDAO;
import mandacaru.dao.ImovelMemoryDAO;
import mandacaru.model.Imovel;

@Service
public class ImovelService {

	ImovelDAO imovelDAO = new ImovelMemoryDAO();

	public void save(int id, Imovel entity) {
		if(id != 0) {
			entity.setId(id);
		}
		imovelDAO.save(entity);
	}

	public void delete(int id) {
		imovelDAO.delete(id);
	}

	public Imovel find(int id) {
		if(id < 1) {
			return null;
		}
		
		return imovelDAO.find(id);
	}

	public List<Imovel> findall() {
		return imovelDAO.findall();
	}

}
