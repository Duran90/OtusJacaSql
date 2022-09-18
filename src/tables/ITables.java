package tables;

import java.sql.SQLException;

public interface ITables {
    void create() throws SQLException;
    void drop() throws SQLException;
    void insert() throws SQLException;
}
