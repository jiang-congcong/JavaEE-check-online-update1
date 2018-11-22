package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Scorelist
 */
public class Scorelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Scorelist() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map)
    {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>()
        {
            
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username1 = null;
		int score1=0;
		ServletContext application = getServletContext();
		
		out.print("<h2>成绩榜</h2>");

		if(application.getAttribute("score_list")==null){
			out.print("<h3>没有成绩</h3>");
		}
		else{  //遍历显示所有成绩（Map遍历）
			Map<String, Integer> score_list= (Map<String, Integer>)application.getAttribute("score_list");
			score_list = sortByValueDescending(score_list);
			//遍历方法一
			//Iterator<Map.Entry<String, Integer>> it = score_list.entrySet().iterator();
			 //while (it.hasNext()) {
				   //Map.Entry<String, Integer> entry = it.next();
				   //out.print("key= " + entry.getKey() + " and value= " + entry.getValue());
				  //}	
			 //遍历方法二
			Set s=score_list.keySet();
			Iterator it=s.iterator();
			while(it.hasNext()){
				String username=(String)it.next();
				int score=score_list.get(username);
				out.print("<h3>"+username+":"+score+"</h3>");
			}
			
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
