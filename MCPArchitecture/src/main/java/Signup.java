

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */

public class Signup extends HttpServlet {
	
Model model;
public void init() {
	model=new Model();
}

public void service(HttpServletRequest req,HttpServletResponse res) {

	
	try {
		
		
		String  id=req.getParameter("id");
		String  pass=req.getParameter("pass");

		String  name=req.getParameter("name");

		String  age=req.getParameter("age");

		String  gmail=req.getParameter("gmail");
		boolean result=model.performRegistration(id, pass, name, age, gmail);
if(result) {
	res.sendRedirect("/MCPArchitecture/Login.html");
}
else {
	System.out.println("/MCPArchitecture/SignUp.html");
}
	}catch (Exception e) {

	e.printStackTrace();
	}
}


}
