package ap;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
	String shttp = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath();

    String s = "<a href='" + shttp + "/mm' >Email to admins</a> " + shttp;
    
    
    //_info.m2a("test1",_info.ss);
    response.getWriter().print(s);

  }
}