package org.library.demo.repository;

import org.library.demo.models.Loan;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;

import java.sql.*;

public class LoanDao extends BaseDaoImpl {

    public LoanDao() { }

    public Loan get(String titleId) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM loans WHERE title_id=?";
        Connection conn = getConnection();
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, titleId);
        ResultSet res = stat.executeQuery();
        Loan loan = null;
        while (res.next()) {
            titleId = res.getString("title_id");
            String taxCode = res.getString("tax_code");
            Date creationDate = res.getDate("creation_date");
            loan = new Loan();
            loan.setTitleId(titleId);
            loan.setTaxCode(taxCode);
            loan.setCreationDate(creationDate); }
        conn.close();
        return loan;
    }
}
