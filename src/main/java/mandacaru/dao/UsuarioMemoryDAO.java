package mandacaru.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import mandacaru.model.Usuario;

public class UsuarioMemoryDAO implements UsuarioDAO {
	
	 private Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
	    int i = 0;
	 
	    @Override
	    public void save(Usuario entity) {
	        if(entity.getId() == 0) {
	            i++;
	            entity.setId(i);    
	        }
	        
	        usuarios.put(entity.getId(), entity);
	    }
	 
	    @Override
	    public void delete(int id) {
	    	usuarios.remove(id);
	    }
	    
	    @Override
	    public Usuario find(int id) {
	        return usuarios.get(id);
	    }
	 
	    @Override
	    public List<Usuario> findall() {
	        return new ArrayList<Usuario>(usuarios.values());
	    }
	
}
