package ap;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "ap.Rss",
    urlPatterns = {"/rss"}
)

public class Rss  extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    
	String s = request.getQueryString(),s2="";
		try {
		if(s==null)
			s="http://gamesnews.quicklydone.com/p/rss.html";	
		
		s=_info.get_random_rss(s);
		s2=s;
		s=_info.get_andr2(s);
		
	} catch (Exception e) {
		s=s2+ ": "+ e.toString() +" Pls, try again...";
	}

	PrintWriter wr = response.getWriter();
	wr.print(s);
	wr.close();

  }
}