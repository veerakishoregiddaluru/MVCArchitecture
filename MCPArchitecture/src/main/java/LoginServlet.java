

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	Model model;

public void init() {
	
	model=new Model();
	
}
public void service(HttpServletRequest req,HttpServletResponse res) {
	try {
		
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		
		boolean result=model.loginForm(id, pass);
		if(result) {
			res.sendRedirect("/MVCArchitecture/Welcome.html");

		}
		else {
			res.sendRedirect("/MVCArchitecture/SignUp.html");
		}
		
	}catch (Exception e) {

	e.printStackTrace();
	}
	
	
	
}

}
