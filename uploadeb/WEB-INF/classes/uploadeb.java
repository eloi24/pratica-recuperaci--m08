import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.http.Part;
@WebServlet("/uploadeb")
@MultipartConfig
public class uploadeb extends HttpServlet {
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
Part filePart = request.getPart("fitxer");
//Agafar el fitxer que hem enviat des de el formulari
String nom = request.getParameter("nom");
//Agafar el nom que enviem des de el formulari
String nomFitxer = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//Amb aquesta comanda agafem el nom del fitxer i la seva extensió
PrintWriter p = response.getWriter();
String[] extensiofitxer = nomFitxer.split("\\.");
//Creem una array on separarem el nom del fitxer per punts i llavors comprovarem si el format d'aquesta imatge és jpg o no
p.println("<!doctype html>");
p.println("<html>");
p.println("<body>");
if(extensiofitxer[extensiofitxer.length-1].equals("jpg")){
//Amb aquest if agafarem l'ultima posicio de l'array i comprovarem que el format d'aquesta sigui jpg
for (Part part : request.getParts()) {
part.write("/opt/tomcat/webapps/exercici3eb/imatges/"+nomFitxer);
}
p.println("<h1>S'ha guardat correctament el fitxer: " + nomFitxer + "</h1>");
}else{
p.println("<h1>No s'ha guardat el fitxer: " + nomFitxer + "</h1>");
//Mostrarem aquest error quan el format del fitxer que hem passat des de el formulari no sigui jpg
}
p.println("</body>");
p.println("</html>");
}
}

