package code.hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class FeaturedEdition extends CD{
	@Column(name = "featuredEdition")
String featuredEdition;

int year;
	public FeaturedEdition(CD cd,String featuredEdition,int year) {
		super(cd.title,cd.artists,cd.cdate);
		this.featuredEdition = featuredEdition;
		
	}
	@Override
	public String toString() {
		return "FeaturedEdition [featuredEdition=" + featuredEdition + ", year=" + year + ", id=" + id + ", title="
				+ title + ", artists=" + artists + ", cdate=" + cdate + "]";
	}


}
