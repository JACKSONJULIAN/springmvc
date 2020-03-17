
package springmvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloWorld {
@RequestMapping("/hello")
public ModelAndView hello()
{
String message="HELLO SPRING MVC HOW ARE U";
return new ModelAndView("hellopage","message",message);
}
}
