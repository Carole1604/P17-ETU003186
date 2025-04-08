package com.dao;

import com.model.Prevision;
import java.sql.*;


public class PrevisionDAO {
    public int createPrevision(Prevision prevision) throws SQLException {
        String sql = "INSERT INTO prevision (libelle, montant_initial) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, prevision.getLibelle());
            stmt.setDouble(2, prevision.getMontantInitial());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }
    public Prevision getPrevisionById(int id) throws SQLException {
        String sql = "SELECT * FROM prevision WHERE id_prevision = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Prevision p = new Prevision();
                    p.setIdPrevision(rs.getInt("id_prevision"));
                    p.setLibelle(rs.getString("libelle"));
                    p.setMontantInitial(rs.getDouble("montant_initial"));
                    p.setDateCreation(rs.getTimestamp("date_creation").toLocalDateTime());
                    return p;
                }
            }
        }
        return null;
    }
}