package com.dao;

import com.model.Depense;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepenseDAO {
    public void createDepense(Depense depense) throws SQLException {
        String sql = "INSERT INTO depense (id_prevision, type_depense, montant) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, depense.getIdPrevision());
            stmt.setString(2, depense.getTypeDepense());
            stmt.setDouble(3, depense.getMontant());
            stmt.executeUpdate();
        }
    }
    
    public List<Depense> getDepensesByPrevision(int idPrevision) throws SQLException {
        String sql = "SELECT * FROM depense WHERE id_prevision = ?";
        List<Depense> depenses = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPrevision);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Depense d = new Depense();
                    d.setIdDepense(rs.getInt("id_depense"));
                    d.setIdPrevision(rs.getInt("id_prevision"));
                    d.setTypeDepense(rs.getString("type_depense"));
                    d.setMontant(rs.getDouble("montant"));
                    d.setDateDepense(rs.getTimestamp("date_depense").toLocalDateTime());
                    depenses.add(d);
                }
            }
        }
        return depenses;
    }
    
    public double getTotalDepenses(int idPrevision) throws SQLException {
        String sql = "SELECT SUM(montant) as total FROM depense WHERE id_prevision = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idPrevision);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        }
        return 0;
    }
}