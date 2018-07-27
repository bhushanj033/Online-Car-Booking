package cdac.OnlineCarBookingBackEnd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try
       {
    	   ApplicationContext context=new ClassPathXmlApplicationContext("/OnlineCarBooking/src/main/webapp/WEB-INF/dispatcher-servlet.xml");
    	   System.out.println(context);
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
    	   
       }
    }
}
