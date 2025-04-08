package com.servlet;

import com.dao.DepenseDAO;
import com.dao.PrevisionDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EtatServlet", value = "/etat")
public class EtatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idPrevision = (Integer) session.getAttribute("idPrevision");
        
        if (idPrevision == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        
        try {
            PrevisionDAO previsionDAO = new PrevisionDAO();
            DepenseDAO depenseDAO = new DepenseDAO();
            
            request.setAttribute("prevision", previsionDAO.getPrevisionById(idPrevision));
            request.setAttribute("depenses", depenseDAO.getDepensesByPrevision(idPrevision));
            request.setAttribute("totalDepense", depenseDAO.getTotalDepenses(idPrevision));
            
            request.getRequestDispatcher("/etat.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur lors du chargement de l'état");
            request.getRequestDispatcher("/etat.jsp").forward(request, response);
        }
    }
}