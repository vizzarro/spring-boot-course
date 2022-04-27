package org.library.demo.repository;

import org.library.demo.models.Reservation;
import org.library.demo.repository.connection.BaseDaoImpl;

import java.sql.*;

public class ReservationDao extends BaseDaoImpl {

    public ReservationDao() { }

    public Reservation get(String titleId) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM reservation WHERE title_id=?";
        Connection conn = getConnection();
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, titleId);
        ResultSet res = stat.executeQuery();
        Reservation reservation = null;
        while (res.next()) {
            titleId = res.getString("title_id");
            String taxCode = res.getString("tax_code");
            Date creationDate = res.getDate("creation_date");
            reservation = new Reservation();
            reservation.setTitleId(titleId);
            reservation.setTaxCode(taxCode);
            reservation.setCreationDate(creationDate); }
        conn.close();
        return reservation;
    }
}
