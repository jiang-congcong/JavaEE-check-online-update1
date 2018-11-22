package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet implementation class Submit
 */
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, Integer> score_list = new HashMap<String, Integer>();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int score=0;
		String q1 = request.getParameter("q1"); 
		String q2 = request.getParameter("q2"); 
		String[] q3 = request.getParameterValues("q3");

		if(q1!=null&&q1.equals("武汉")){
			score+=10;
		}

		if(q2!=null&&q2.equals("赵匡胤")){
			score+=10;
		}

		if(q3!=null&&q3.length==2&&q3[0].equals("红楼梦")&&q3[1].equals("水浒传")){
			score+=10;
		}
		
		HttpSession session=request.getSession();
		User user2 =(User) session.getAttribute("user");
		String username = user2.getUsername();
		score_list.put(username,score);

		//score_list.put((String)session.getAttribute("username"),score);
		ServletContext application = getServletContext();
		application.setAttribute("score_list", score_list);
		//response.sendRedirect("http://localhost:8080/HelloMaven2/logout.jsp");
		response.sendRedirect("Logout");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/logout.jsp");  
		//dispatcher.forward(request, response); 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
