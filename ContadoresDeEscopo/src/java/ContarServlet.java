import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author selvarpv
 */
@WebServlet(urlPatterns = {"/Contar"})
public class ContarServlet extends HttpServlet {
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //request
        if(request.getAttribute("contador") == null){
            request.setAttribute("contador", new Contador("request"));
        }
        ((Contador)request.getAttribute("contador")).contar();
    
     //Session
        if(request.getSession().getAttribute("contador") == null){
            request.getSession().setAttribute("contador", new Contador("request"));
        }
        ((Contador)request.getSession().getAttribute("contador")).contar();
     
//Aplication
        if(getServletContext().getAttribute("contador") == null){
            getServletContext().setAttribute("contador", new Contador("request"));
        }
        ((Contador)getServletContext().getAttribute("contador")).contar();
   
        PrintWriter pw  = response.getWriter();
        pw.append("<html>");
        pw.append("<h1>" + request.getAttribute("contador")+ "</h1>");
        pw.append("<h1>" + request.getSession().getAttribute("contador")+ "</h1>");
        pw.append("<h1>" + getServletContext().getAttribute("contador")+ "</h1>");
        pw.append("</html>");
    }
}
