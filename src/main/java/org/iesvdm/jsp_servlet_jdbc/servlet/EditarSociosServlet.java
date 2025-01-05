package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.io.IOException;
@WebServlet(name = "EditarSociosServlet", value = "/EditarSociosServlet")
public class EditarSociosServlet extends HttpServlet {

    private SocioDAO socioDAO = new SocioDAOImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/FormularioEditarSocios.jsp");

        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String idUsuario = request.getParameter("idUsuario");


        if(!idUsuario.isBlank() && !idUsuario.isEmpty()){
            System.out.println("<h2>Vamos a editar al usuario" + idUsuario + "</h2>");
            String nombre = request.getParameter("nombre");
            String estatura = request.getParameter("estatura");
            String edad = request.getParameter("edad");
            String localidad = request.getParameter("localidad");

            Socio s = new Socio();
            s.setSocioId(Integer.parseInt(idUsuario));
            s.setNombre(nombre);
            s.setEstatura(Integer.parseInt(estatura));
            s.setEdad(Integer.parseInt(edad));
            s.setLocalidad(localidad);
            socioDAO.update(s);
            System.out.println("<h2>Editado al usuario" + idUsuario + "</h2>");
        }else{
            System.out.println("<h2>No se puede editar el usuario" + idUsuario + "</h2>");
        }
    }

}
