package co.com.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutenticacionServlet
 */
@WebServlet("/AutenticacionServlet")
public class AutenticacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName").trim();
        if(userName != null && userName.contains("admin")){
        	
        	UserContext user = new UserContext();  
	    	user.setUser("admin");
	    			((javax.servlet.http.HttpServletRequest) request)
			.getSession().setAttribute("user", user);
        	
        	String greetings = "ok";            
            response.setContentType("text/plain");
            response.getWriter().write(greetings);
        }else
        {
        	String greetings = "El usuario " + userName +" no existe.";            
            response.setContentType("text/plain");
            response.getWriter().write(greetings);        	
        }
         
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
