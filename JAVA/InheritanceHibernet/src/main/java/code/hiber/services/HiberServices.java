package code.hiber.services;

import java.util.List;

import code.hiber.doa.HiberDoa;
import code.hiber.doa.HiberDoaInterface;
import code.hiber.model.CD;
import code.hiber.model.FeaturedEdition;
import code.hiber.model.specialCd;

public class HiberServices implements HiberDoaInterface  {
private HiberDoa hiberDoa=null;
{
	hiberDoa = new HiberDoa();
}
	@Override
	public void createCd(CD cd) {
		hiberDoa.createCd(cd);
	}

	@Override
	public void createCd(FeaturedEdition featuredEdition) {
		// TODO Auto-generated method stub
		hiberDoa.createCd(featuredEdition);
	}

	@Override
	public void createCd(specialCd sCd) {
		// TODO Auto-generated method stub
		hiberDoa.createCd(sCd);
	}

	@Override
	public List<FeaturedEdition> getCD() {
		return hiberDoa.getCD();
	}

}
