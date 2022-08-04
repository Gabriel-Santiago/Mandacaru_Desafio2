package mandacaru.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mandacaru.model.Usuario;

@Component
public class UsuarioJDBCDAO implements UsuarioDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Usuario entity) {
		String insert_sql = "insert into usuarios (nome, senha, endereco, cpf, telefone, email) values (?, ?, ?, ?, ?, ?)";
		String update_sql = "update usuarios set nome = ?, senha = ?, endereco = ?, cpf = ?, telefone = ?, email = ? where id = ?";

		if (entity.getId() == 0) {
			jdbcTemplate.update(insert_sql, entity.getNome(), entity.getSenha(), entity.getEndereco(), entity.getCpf(), entity.getTelefone(), entity.getEmail());

		} else {
			jdbcTemplate.update(update_sql, entity.getNome(), entity.getSenha(), entity.getEndereco(), entity.getCpf(), entity.getTelefone(), entity.getEmail(),
					entity.getId());

		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from usuarios where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Usuario find(int id) {
		String sql = "select * from usuarios where id = ?";
		
		try {
			return jdbcTemplate.queryForObject(sql,
					(rs, rowNum) -> new Usuario(rs.getInt("id") ,rs.getString("nome"), rs.getString("Senha"), rs.getString("endereco"), rs.getString("cpf"),
							rs.getString("email"), rs.getString("telefone"), (int[]) rs.getArray("anuncios").getArray()), id);
		} catch (NullPointerException e) {
			return jdbcTemplate.queryForObject(sql,
					(rs, rowNum) -> new Usuario(rs.getInt("id") ,rs.getString("nome"), rs.getString("Senha"), rs.getString("endereco"), rs.getString("cpf"),
							rs.getString("email"), rs.getString("telefone"), null), id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Usuario> findall() {
		String sql = "select * from usuarios";
		
		try {
			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new Usuario(rs.getInt("id") ,rs.getString("nome"), rs.getString("Senha"), rs.getString("endereco"), rs.getString("cpf"),
							rs.getString("email"), rs.getString("telefone"), (int[]) rs.getArray("anuncios").getArray()));
		}
		catch(NullPointerException e) {
			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new Usuario(rs.getInt("id") ,rs.getString("nome"), rs.getString("Senha"), rs.getString("endereco"), rs.getString("cpf"),
							rs.getString("email"), rs.getString("telefone"), null));
		}

	}

}
