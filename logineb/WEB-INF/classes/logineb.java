import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class logineb extends HttpServlet {
public void init() throws ServletException {
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String correu = request.getParameter("usuari");
//Agafa l'input usuari que arriba per paràmetre del formulari i el guarda a una variable
String contra = request.getParameter("contrasenya");
//Agafa l'input contrasenya que arriba per paràmetre del formulari i el guarda a una variable
PrintWriter p = response.getWriter();
p.println("<!doctype html>");
p.println("<html>");
p.println("<body>");
if(correu.equals("eloi") && contra.equals("12345678")){
//Comprovo que l'usuari i la contrasenya siguin iguals a eloi i 12345678
p.println("<h1>Login success!!!</h1>");
}else{
//Mostro login error si les dades que ha introduit no són correctes
p.println("<h1>Login error!!!</h1>");
}
p.println("</html>");
p.println("</body>");
}
}
