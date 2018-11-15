package paquete;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("userName",id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Para obtener la ruta absoluta del proyecto
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
        //Ruta absoluta del archivo BD.xml
        rutaAbsoluta = rutaAbsoluta.concat("users.xml");
        File users = new File(rutaAbsoluta);
        int tipo=validateUser(users, id, password);
        // check to see if this user/password combination are valid
        if (tipo>0) {
            if(tipo==1)
                response.sendRedirect("BienvenidoAdmin");
            else if(tipo==2)
                response.sendRedirect("BienvenidoProfe");
            else
                response.sendRedirect("BienvenidoAlumno");
        } else // username/password not validated
        {
            response.sendRedirect("fallo");
        }

    }

    public int validateUser(File users, String userName, String password) {
        try {
            SAXBuilder builder = new SAXBuilder();
            //File archivoXML = new File(url);
            Document documento = builder.build(users);
            Element raiz = documento.getRootElement();
            List lista = raiz.getChildren("user");

            for (int i = 0; i < lista.size(); i++) {
                Element elemento = (Element) lista.get(i);
                String name = elemento.getChildTextTrim("name");
                String pass = elemento.getChildTextTrim("password");
                if (name.equals(userName)) {
                    if (pass.equals(password)) {
                        System.out.println("Usuario logueado:" + userName );
                        Attribute attribute = elemento.getAttribute("type");
                        int tipo=Integer.parseInt(attribute.getValue());
                        System.out.println("tipo "+tipo);
                        return tipo;
                    }
                } 
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Usuario no logueado: Contraseña incorrecta");
        return 0;
    }
}
