package com.servlet;

import com.dao.PrevisionDAO;
import com.model.Prevision;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")

public class InitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        double montant = Double.parseDouble(request.getParameter("montant"));
        
        Prevision prevision = new Prevision();
        prevision.setLibelle(libelle);
        prevision.setMontantInitial(montant);
        
        try {
            PrevisionDAO dao = new PrevisionDAO();
            int idPrevision = dao.createPrevision(prevision);
            
            HttpSession session = request.getSession();
            session.setAttribute("idPrevision", idPrevision);
            
            response.sendRedirect(request.getContextPath() + "/depenses");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur lors de la création de la prévision");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
