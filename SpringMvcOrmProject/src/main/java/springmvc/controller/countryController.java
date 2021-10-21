package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.dao.countryDao;
import springmvc.model.country;

@Controller
public class countryController {


	@Autowired  
	countryDao dao;
	
	@RequestMapping("/index")
	public String index() 
	{
		return "index";	
	}
	
    @RequestMapping("/countryform")    
    public String showform(Model m){    
        m.addAttribute("command", new country());  
        return "countryform";   
    }   
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("c") country c){    
        dao.save(c);    
        return "redirect:/viewcountry";   
    }    
    
    @RequestMapping("/viewcountry")    
    public String viewcountry(Model m){    
        List<country> list=dao.getCountry();    
        m.addAttribute("list",list);  
        return "viewcountry";    
    }   
    
    @RequestMapping(value="/editcountry/{id}")    
    public String edit(@PathVariable int id, Model m){    
        country c=dao.getcountryById(id);    
        m.addAttribute("command",c);  
        return "countryeditform";    
    }    

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("c") country c){    
        dao.update(c);    
        return "redirect:/viewcountry";    
    }    
 
    @RequestMapping(value="/deletecountry/{id}",method = RequestMethod.GET)    
    public String delete(@ModelAttribute("c") country c){    
        dao.delete(c);    
        return "redirect:/viewcountry";    
    } 
}
