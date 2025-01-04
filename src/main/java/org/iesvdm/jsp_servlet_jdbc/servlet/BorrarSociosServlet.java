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
import java.util.List;
import java.util.Optional;
@WebServlet(name = "BorrarSociosServlet", value = "/BorrarSociosServlet")
public class BorrarSociosServlet extends HttpServlet {
    private SocioDAO socioDAO = new SocioDAOImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Variables
        RequestDispatcher dispatcher = null;

        //Recogemos el valor del formulario
        String cod = request.getParameter("codigo");

        Integer codigo = null;

        try{
            codigo = Integer.parseInt(cod);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }

        //Cogemos y vemos si el usuario está entonces entrará en el if para borrarlo
        if(codigo != null && !cod.isEmpty()){
            //Borramos al usuario con la capa DAO
            socioDAO.delete(codigo);

            List<Socio> listado = socioDAO.getAll();
            request.setAttribute("listado", listado);

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp");
            dispatcher.forward(request, response);
        }

    }

}
