package cs545.mum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class App 
{
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String welcome()
    {
        System.out.println( "Hello World!" );
        return "index";
    }
}
