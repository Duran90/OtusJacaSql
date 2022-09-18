package tables;

import java.sql.SQLException;

public class GroupTable extends AbsTable {

    public static final String TABLE_NAME = "Groups";
    public static final String ID_COLUMN = "Id";
    public static final String NAME_COLUMN = "Name";
    public static final String ID_CURATOR_COLUMN = "IdCurator";

    public GroupTable() {
        super(TABLE_NAME);
    }

    @Override
    public void create() throws SQLException {
        iDbExecutor.execute(String.format("create table %s (%s int AUTO_INCREMENT, %s varchar(10) NOT NULL, %s int NOT NULL, PRIMARY KEY(%s));",
                        tableName,
                        ID_COLUMN,
                        NAME_COLUMN,
                        ID_CURATOR_COLUMN,
                        ID_COLUMN),
                false);
    }

    @Override
    public void insert() throws SQLException {
        iDbExecutor.execute(String.format("INSERT INTO %s VALUES(1,'Alfa',2),(2,'Beta',1),(3,'Gamma',4);",
               tableName),false);
    }
}
