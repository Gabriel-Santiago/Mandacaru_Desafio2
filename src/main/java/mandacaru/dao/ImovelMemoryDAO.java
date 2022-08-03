package mandacaru.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import mandacaru.model.Imovel;

public class ImovelMemoryDAO implements ImovelDAO {
	
	 private Map<Integer, Imovel> imoveis = new HashMap<Integer, Imovel>();
	    int i = 0;
	 
	    @Override
	    public void save(Imovel entity) {
	        if(entity.getId() == 0) {
	            i++;
	            entity.setId(i);    
	        }
	        
	        imoveis.put(entity.getId(), entity);
	    }
	 
	    @Override
	    public void delete(int id) {
	    	imoveis.remove(id);
	    }
	    
	    @Override
	    public Imovel find(int id) {
	        return imoveis.get(id);
	    }
	 
	    @Override
	    public List<Imovel> findall() {
	        return new ArrayList<Imovel>(imoveis.values());
	    }
	
}
