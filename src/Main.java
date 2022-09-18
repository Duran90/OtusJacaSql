import db.IDbExecutor;
import db.MySqlDbExecutor;
import tables.AbsTable;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDbExecutor iDbExecutor = new MySqlDbExecutor();
        AbsTable students = new StudentTable();
        AbsTable curator = new CuratorTable();
        AbsTable group = new GroupTable();
        try {
            dropTableIfExist(iDbExecutor, List.of(students, curator, group));
            students.create();
            students.insert();
            curator.create();
            curator.insert();
            group.create();
            group.insert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            students.getIDbExecutor().close();
            curator.getIDbExecutor().close();
            group.getIDbExecutor().close();
        }

    }


    private static void dropTableIfExist(IDbExecutor iDbExecutor, List<AbsTable> tables) throws SQLException {
        for (AbsTable table : tables) {
            iDbExecutor.execute(String.format("DROP TABLE IF EXISTS `%s`", table.getTableName()),false);
        }

    }
}

