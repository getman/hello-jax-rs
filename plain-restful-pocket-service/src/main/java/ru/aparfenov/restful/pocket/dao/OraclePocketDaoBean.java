package ru.aparfenov.restful.pocket.dao;

import ru.aparfenov.restful.pocket.model.PocketElement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ArtemParfenov on 12.04.2018.
 */

@Stateless
public class OraclePocketDaoBean implements PocketDao {
    private static final String GET_POCKET_LIST_QUERY = "select * from pocket";
    private static final String ADD_INTO_POCKET =
            "insert into pocket(pocket_data, data_title) values (?, ?)";

    @Resource(name="jdbc/myOracleDataSource")
    private DataSource myDs;
    private Connection conn;

    public OraclePocketDaoBean() {
    }

    @PostConstruct
    private void init() {
    }

    private List<PocketElement> getPocketElements() {
        List<PocketElement> result = new ArrayList<PocketElement>();
        try {
            this.conn = myDs.getConnection();
            Locale.setDefault(Locale.ENGLISH);
            this.conn = myDs.getConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(GET_POCKET_LIST_QUERY);
            while (rs.next()) {
                result.add(new PocketElement(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
//            result.append("SQL exception while executing the query");
//            result.append(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
//                result.append("SQL exception while trying to close the connection");
//                result.append(e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<PocketElement> getPockets() {
        return getPocketElements();
    }

    @Override
    public void putIntoPocket(PocketElement newPocketElement) {
        try {
            this.conn = myDs.getConnection();
            Locale.setDefault(Locale.ENGLISH);
            this.conn = myDs.getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_INTO_POCKET);
            ps.setString(1, newPocketElement.getData());
            ps.setString(2, newPocketElement.getDataTitle());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
