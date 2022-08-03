package mandacaru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mandacaru.dao.UsuarioDAO;
import mandacaru.dao.UsuarioMemoryDAO;
import mandacaru.model.Usuario;

@Service
public class UsuarioService {

	UsuarioDAO usuarioDAO = new UsuarioMemoryDAO();

	public void save(int id, Usuario entity) {
		if(id != 0) {
			entity.setId(id);
		}
		usuarioDAO.save(entity);
	}

	public void delete(int id) {
		usuarioDAO.delete(id);
	}

	public Usuario find(int id) {
		if(id < 1) {
			return null;
		}
		
		return usuarioDAO.find(id);
	}

	public List<Usuario> findall() {
		return usuarioDAO.findall();
	}

}