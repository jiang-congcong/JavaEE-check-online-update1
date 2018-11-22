package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet implementation class Login1
 */
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static Map<String,String> user_list=new HashMap<String,String>();
	
	static {
		user_list.put("zz", "888");
		user_list.put("qq", "222");
		user_list.put("yy", "666");
	}
	
	public boolean check(String username,String psd){
		if(user_list.containsKey(username))
			if(user_list.get(username).equals(psd)){
				return true;
			}
		return false;
	}
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
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
		
		String username=request.getParameter("username");
		String psd=request.getParameter("psd");

		User u=new User(username,psd);
		HttpSession session=request.getSession();
		
		if(check(username,psd)){
			session.setAttribute("error", " ");
			//HttpSession session=request.getSession();
		    //HttpSession session1=(HttpSession)session.getAttribute("error");
		    //session1.invalidate();
			session.setAttribute("user", u);
			out.print("欢迎"+username);
			out.print("<br/><br/>");
			out.print("<a href='test.jsp'>开始测试</a>");
			//response.sendRedirect("/HelloMaven3/test.jsp");
			
		}
		else{
			//out.print("登录失败，3秒之后重新登录");
			session.setAttribute("error", "用户名或者密码错误！");
			//response.setHeader("refresh", "3;url='index.jsp'");
		    //session.setAttribute("error", "用户名或者密码错误！");
			response.sendRedirect("http://localhost:8080/HelloMaven2/index.jsp");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
