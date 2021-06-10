// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
// Extend HttpServlet class
public class Eloi extends HttpServlet {
public char[] nomchar;
public void init() throws ServletException {
// Do required initialization
nomchar = new char[] {'b', 'a', 'u', 'l','e','n','a','s'};
}
public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
// Set response content type
response.setContentType("text/html");
// Actual logic goes here.
PrintWriter out = response.getWriter();
out.println("<h1>");
for (char c:nomchar) {
out.println(c);
}
out.println("</h1>");
}
public void destroy() {
// do nothing.
}
}
