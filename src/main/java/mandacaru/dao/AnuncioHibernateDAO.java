package mandacaru.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mandacaru.entities.Anuncio;

public class AnuncioHibernateDAO implements AnuncioDAO{
	
	static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("mandacaru");
    static EntityManager entityManager;

	@Override
	public void save(Anuncio entity) {
		 entityManager = sessionFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	 
	        if (entity.getId() == 0) {
	            entityManager.persist(entity);
	        } else {
	            entityManager.merge(entity);
	        }
	 
	        entityManager.getTransaction().commit();
	        entityManager.close();
	}

	@Override
	public void delete(int id) {
        entityManager = sessionFactory.createEntityManager();
        Anuncio imovel = entityManager.find(Anuncio.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(imovel);
        entityManager.getTransaction().commit();
        entityManager.close();
	}

	@Override
	public Anuncio find(int id) {
		entityManager = sessionFactory.createEntityManager();
		Anuncio imovel = entityManager.find(Anuncio.class, id);
		entityManager.close();
		return imovel;
	}

	@Override
	public List<Anuncio> findall() {
        entityManager = sessionFactory.createEntityManager();
        List<Anuncio> imovel = entityManager.createQuery("from imovel", Anuncio.class).getResultList();
        entityManager.close();
 
        return imovel;
	}

}
