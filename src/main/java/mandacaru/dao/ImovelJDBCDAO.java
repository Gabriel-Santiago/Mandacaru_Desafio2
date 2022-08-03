package mandacaru.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mandacaru.model.Imovel;

@Component
public class ImovelJDBCDAO implements ImovelDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//aqui não ta terminado falta o dono e o status tirando por esse o resto funciona

	@Override
	public void save(Imovel entity) {
		String insert_sql = "insert into imovel (titulo, endereco, metros_quadrados_de_terreno, quantidade_de_quartos, quantidade_de_banheiros, quantidade_de_vagas_de_garagem, preco) values (?, ?, ?, ?, ?, ?, ?)";
		String update_sql = "update imovel set titulo = ?, endereco = ?, metros_quadrados_de_terreno = ?, quantidade_de_quartos = ?, quantidade_de_banheiros = ?, quantidade_de_vagas_de_garagem = ?, preco = ? where id = ?";

		if (entity.getId() == 0) {
			jdbcTemplate.update(insert_sql, entity.getTitulo(), entity.getEndereco(), entity.getMetros_quadrados_de_terreno(), entity.getQuantidade_de_quartos(),
					entity.getQuantidade_de_banheiros(), entity.getQuantidade_de_vagas_de_garagem(), entity.getPreco());

		} else {
			jdbcTemplate.update(update_sql, entity.getTitulo(), entity.getEndereco(), entity.getMetros_quadrados_de_terreno(), entity.getQuantidade_de_quartos(),
					entity.getQuantidade_de_banheiros(), entity.getQuantidade_de_vagas_de_garagem(), entity.getPreco(), entity.getId());

		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from imoveis where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Imovel find(int id) {
		String sql = "select * from imoveis where id = ?";

		try {
			return jdbcTemplate.queryForObject(sql,
					(rs, rowNum) -> new Imovel(rs.getInt("id"), rs.getString("titulo"), rs.getString("endereco"), rs.getInt("metros_quadrados_de_terreno"),
							rs.getInt("quantidade_de_banheiros"), rs.getInt("quantidade_de_vagas_de_garagem"), rs.getInt("quantidade_de_quartos"),
							rs.getDouble("preco"), rs.getString("status"), rs.getInt("dono")), id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Imovel> findall() {
		String sql = "select * from imoveis";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new Imovel(rs.getInt("id"), rs.getString("titulo"), rs.getString("endereco"), rs.getInt("metros_quadrados_de_terreno"),
						rs.getInt("quantidade_de_banheiros"), rs.getInt("quantidade_de_vagas_de_garagem"), rs.getInt("quantidade_de_quartos"),
						rs.getDouble("preco"), rs.getString("status"), rs.getInt("dono")));

	}

}
