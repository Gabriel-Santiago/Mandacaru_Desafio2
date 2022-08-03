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

	//codigo em sql falta mudar
	
	@Override
	public void save(Usuario entity) {
		String insert_sql = "insert into imovel (titulo, endereco, metros_quadrados_de_terreno, quantidade_de_quartos, quantidade_de_banheiros, quantidade_de_vagas_de_garagem, preco) values (?, ?, ?, ?, ?, ?, ?)";
		String update_sql = "update imovel set titulo = ?, endereco = ?, metros_quadrados_de_terreno = ?, quantidade_de_quartos = ?, quantidade_de_banheiros = ?, quantidade_de_vagas_de_garagem = ?, preco = ? where id = ?";

		if (entity.getId() == 0) {
			jdbcTemplate.update(insert_sql, entity.getNome(), entity.getSenha(), entity.getEndereco(), entity.getCpf(), entity.getTelefone(), entity.getEmail(),
					entity.getAnuncios());

		} else {
			jdbcTemplate.update(update_sql, entity.getNome(), entity.getSenha(), entity.getEndereco(), entity.getCpf(), entity.getTelefone(), entity.getEmail(),
					entity.getId());

		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from products where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Usuario find(int id) {
		String sql = "select * from products where id = ?";
		// não sei como retornar isso aqui por enquanto
		try {
			return jdbcTemplate.queryForObject(sql,
					(rs, rowNum) -> new Usuario(rs.getInt("id") ,rs.getString("nome"), rs.getString("Senha"), rs.getString("endereco"), rs.getString("cpf"),
							rs.getString("email"), rs.getInt("anuncios")), id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Usuario> findall() {
		String sql = "select * from products";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new Usuario(rs.getInt("id") ,rs.getString("nome"), rs.getString("Senha"), rs.getString("endereco"), rs.getString("cpf"),
						rs.getString("email"), rs.getArray("anuncios")));

	}

}
