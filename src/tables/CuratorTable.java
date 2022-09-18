package tables;

import java.sql.SQLException;

public class CuratorTable extends AbsTable {

    public static final String TABLE_NAME = "Curator";
    public static final String FIO_COLUMN = "FIO";
    public static final String ID_COLUMN = "Id";

    public CuratorTable() {
        super(TABLE_NAME);
    }

    @Override
    public void create() throws SQLException {
        iDbExecutor.execute(String.format("create table %s (%s int AUTO_INCREMENT,%s varchar(25) NOT NULL, PRIMARY KEY(%s));",getTableName(),
                        ID_COLUMN,
                        FIO_COLUMN,
                        ID_COLUMN),
                false);
    }

    @Override
    public void insert() throws SQLException {
        iDbExecutor.execute(String.format("insert into %s values (1, 'Green Dave'), (2, 'Ross Sonia'), (3, 'Mitchell Sophia'), (4, 'Stewart Leah');",
                getTableName()),false);
    }
}
