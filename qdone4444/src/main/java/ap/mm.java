package ap;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "Mail_To_Admins",
    urlPatterns = {"/mm"}
)
public class mm extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  
		String shttp = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath();

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    String s = _info.m2a("test1",_info.ss);
    response.getWriter().print(s);
  }
}