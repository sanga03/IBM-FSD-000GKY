package code.hiber.doa;

import java.util.List;

import code.hiber.model.CD;
import code.hiber.model.FeaturedEdition;
import code.hiber.model.specialCd;

public interface HiberDoaInterface {
public void createCd(CD cd);
public void createCd(FeaturedEdition featuredEdition);
public void createCd(specialCd sCd);
public List<FeaturedEdition> getCD();
}
