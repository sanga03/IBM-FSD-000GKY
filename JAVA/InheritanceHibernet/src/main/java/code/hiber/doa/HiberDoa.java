package code.hiber.doa;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import code.hiber.factory.HiberFactory;
import code.hiber.model.CD;
import code.hiber.model.FeaturedEdition;
import code.hiber.model.specialCd;

public class HiberDoa implements HiberDoaInterface {
private Session session=null;
{
	session = HiberFactory.getSession();
}
	@Override
	public void createCd(CD cd) {
	session.getTransaction().begin();
	session.persist(cd);
	session.getTransaction().commit();
	}

	@Override
	public void createCd(FeaturedEdition featuredEdition) {
		session.getTransaction().begin();
		session.persist(featuredEdition);
		session.getTransaction().commit();
		
	}

	@Override
	public void createCd(specialCd sCd) {
		session.getTransaction().begin();
		session.persist(sCd);
		session.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeaturedEdition> getCD() {
		session.getTransaction().begin();
		Query query = session.createQuery("from FeaturedEdition" );
		return query.getResultList();
	}

	
	
}
