package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class opcionesPregunta extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
         HttpSession session=request.getSession();
         
         String tipo= (String)session.getAttribute("tipo"); 


            //aquí ya se manda a imprimir lo que la página 
           out.println("<!DOCTYPE html>");
            out.println("<html>"); 
            out.println("<head>");
            out.println("<title>dinamica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hot Objects</h1>");
            out.println("<br>");
            out.println("<br>");
            out.println("<form action='Preguntas' method='post' id='fo' > ");
            out.println("Feedback                        Tries <input type='text' name='intentos' />");
            out.println("<br>");
            out.println("Feedback Inicial <input type='text' name='inicial' />");
            out.println("<br>");
            out.println("Feedback de Evaluacion <input type='text' name='evaluacion' />");
            out.println("<br>");
            out.println("Feedback Correcto <input type='text' name='correcto' />");
            out.println("<br>");
            out.println("Feedback Incorrecto <input type='text' name='incorrecto' />");
            out.println("<br>");
            out.println("Feedback Intentos <input type='text' name='intentos1' />");
            out.println("<br>");
            out.println("<button form='fo' name='boton' formaction='Preguntas' type='submit' value='hotobject' >");
            out.println("guardar");
            out.println("</button>");
            out.println("</form>");
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    