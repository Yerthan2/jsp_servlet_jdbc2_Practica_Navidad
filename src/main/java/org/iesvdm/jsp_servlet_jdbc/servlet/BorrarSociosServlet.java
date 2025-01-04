package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.util.Optional;

public class BorrarSociosServlet extends HttpServlet {
    private SocioDAO socioDAO = new SocioDAOImpl();

    public void post(int id){

        //variables
        boolean existeUsuario = false;
        RequestDispatcher dispatcher = null;

        Optional<Socio> optional = socioDAO.find(id);
        if(optional.isPresent()){
            Socio s = optional.get();
            socioDAO.delete(s.getSocioId());
        }else{
            System.out.println("Socio no encontrado, con lo cual, no borrado");
        }



    }

}
