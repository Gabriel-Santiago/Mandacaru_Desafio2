package mandacaru.dao;

import java.util.List;
import mandacaru.model.Usuario;

public interface UsuarioDAO {
	
	public void save(Usuario entity);
	
	public void delete(int id);
	
	public Usuario find(int id);
	
	public List<Usuario> findall();
}
