package com.servlet;

import com.dao.DepenseDAO;
import com.dao.PrevisionDAO;
import com.model.Depense;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DepenseServlet", value = {"/depenses", "/add-depense"})
public class DepenseServlet extends HttpServlet {
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
            
            request.getRequestDispatcher("/depenses.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur lors du chargement des dépenses");
            request.getRequestDispatcher("/depenses.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idPrevision = (Integer) session.getAttribute("idPrevision");
        
        if (idPrevision == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        
        String type = request.getParameter("type");
        double montant = Double.parseDouble(request.getParameter("montant"));
        
        Depense depense = new Depense();
        depense.setIdPrevision(idPrevision);
        depense.setTypeDepense(type);
        depense.setMontant(montant);
        
        try {
            DepenseDAO dao = new DepenseDAO();
            dao.createDepense(depense);
            
            response.sendRedirect(request.getContextPath() + "/depenses");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur lors de l'ajout de la dépense");
            doGet(request, response);
        }
    }
}