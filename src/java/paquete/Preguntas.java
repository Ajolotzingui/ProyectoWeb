package paquete;
/**
 *
 * @author MaFer
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Preguntas extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
           String tipo=request.getParameter("boton");
           HttpSession session=request.getSession();
           session.setAttribute("tipo",tipo);

            //aquí ya se manda a imprimir lo que la página 
            out.println("<!DOCTYPE html>");
            out.println("<html>"); 
            out.println("<head>");
            out.println("<title>dinamica</title>");            
            out.println("</head>");
            out.println("<body>");
            if(tipo.compareTo("hotobject")==0){
                out.println("<h1>HOTOBJECT</h1>");
                out.println("<br>");
                out.println("<br>");
                out.println("<form action='CrearPregunta' method='post' id='fo' > ");
                out.println("ID de Interaccion: <input type='text' name='id' />");
                out.println("<br>");
                out.println("Pregunta <br> <textarea rows='4' cols='30' placeholder='Ingresa Pregunta' name='pregunta' form='fo' >");
                out.println("</textarea>");
                out.println("<br>");
                out.println("Nombres de las instancias hotobject ");
                out.println("<br>");
                out.println("1. <input type='text' name='uno' />          <input type='checkbox' name='check1' /><br>");
                out.println("2. <input type='text' name='dos' />          <input type='checkbox' name='check2' /><br>");
                out.println("3. <input type='text' name='tres' />         <input type='checkbox' name='check3' /><br>");
                out.println("<br>");
                out.println("<br>");
                out.println("<input type='submit'  value='guardar' />    <input type='submit' value='opciones' formaction='opcionesPregunta' /> ");
             
                out.println("</form>");
                
            
            
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    