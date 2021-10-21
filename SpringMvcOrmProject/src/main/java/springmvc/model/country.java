package springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class country {

	@Id
	private int id;
	@Column(length = 50)
	private String countryname;
	@Column(length = 50)
	private String population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		return "country [id=" + id + ", countryname=" + countryname + ", population=" + population + "]";
	}

}
