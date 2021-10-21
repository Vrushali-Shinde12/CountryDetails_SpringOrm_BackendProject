package springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.country;

@Transactional
@Repository
public class countryDao {

HibernateTemplate template;  
    
	public void setTemplate(HibernateTemplate template) {    
	    this.template = template;    
	} 

	public void save(country c){    
	    template.save(c);    
	}    
	public void update(country c){    
	   template.update(c);    
	}    
	public void delete(country c){    
	   template.delete(c);    
	}    


	public country getcountryById(int id){    
	    country c = (country)this.template.get(country.class, id);
	    return c;  
	}    
	
	
	public List<country> getCountry(){    
		List<country> list=new ArrayList<country>();  
	    list=template.loadAll(country.class);  
	    return list;     
	}  
}
