package paquete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class CrearPregunta extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
           
            


            //aquí ya se manda a imprimir lo que la página 
           out.println("<!DOCTYPE html>");
            out.println("<html>"); 
            out.println("<head>");
            out.println("<title>dinamica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>hola mundo</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    