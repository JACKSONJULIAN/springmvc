package springmvc;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//(ModelAttribute,RequestMapping,RequestMethod,SessionAttributes)
import org.springframework.web.servlet.ModelAndView;
import springmvc.Contact;
@Controller
@SessionAttributes
public class ContactController 
{
@RequestMapping(value="/add",method=RequestMethod.POST)
public String addContact(@ModelAttribute("contact")
Contact contact,BindingResult results)
{
	System.out.println("First Name:"+contact.getFirstname()+"\nLast Name:"+contact.getLastname());
	return "results";
}
@RequestMapping("/contacts")
public ModelAndView showContacts()
{
	return new ModelAndView("contact","command",new Contact());
}
}
