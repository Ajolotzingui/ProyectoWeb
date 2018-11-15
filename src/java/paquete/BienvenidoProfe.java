package paquete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class BienvenidoProfe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String userName=(String)session.getAttribute("userName");
	PrintWriter out=response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido Profe: "+userName+"</h1>");
            out.println("<h1>CREACIÓN DE PREGUNTAS</h1>");
            out.println("<form method='post' id='1' >");
            out.println("<button form='1' name='boton' formaction='Preguntas' type='submit' value='hotobject' >");
            out.println("HOTOBJECT");
            out.println("</button>");
            out.println("<button form='1' name='boton' formaction='Preguntas' type='submit' value='multiplechoice' >");
            out.println("MULTIPLECHOICE");
            out.println("</button>");
            out.println("<br>");
            
            String carpeta= request.getSession().getServletContext().getRealPath("/");
            
            carpeta = carpeta.replace("\\", "/");
            carpeta = carpeta.replaceAll("/build", "");
            File ruta = new File(carpeta);
            File[] archivo = ruta.listFiles();
            //evaluamos si la carpeta tiene archivos 
            out.println("<table border='1'");
            if(archivo!=null){
                //recorremos el vector
                for(int i=0;i<archivo.length;i++){
                    File Arc= archivo[i];
                    //evaluamos si el archivo o ruta es una carpeta
                    if(archivo[i].isDirectory()==false){
                        if(archivo[i].getName().startsWith("pregunta") && archivo[i].getName().startsWith("preguntaM")){
                            out.println("<tr>");
                            out.println("<td>Pregunta"+(i-1)+"</td>");
                            out.println("<td><a href=''>Ver Pregunta</a> | <a href=''>Modificar</a> | <a href=''>Eliminar</a>   </td>");
                            out.println("<td > MultipleChoice </td>");
                            
                            
                        }else{
                            if(archivo[i].getName().startsWith("pregunta") && archivo[i].getName().startsWith("preguntaH")){
                            out.println("<tr>");
                            out.println("<td>Pregunta"+(i-1)+"</td>");
                            out.println("<td><a href=''>Ver Pregunta</a> | <a href=''>Modificar</a> | <a href=''>Eliminar</a>   </td>");
                            out.println("<td > HotObject </td>"); 
                            }
                        }
                    }
                }
                out.println("</tr>");
                out.println("</table>");
            }
            
            
            
            
            
            out.println("</body>");
            out.println("</html>");
    }
}
