package tables;

import java.sql.SQLException;

public class StudentTable extends AbsTable {

    public static final String TABLE_NAME = "Students";
    public static final String ID_COLUMN = "Id";
    public static final String FIO_COLUMN = "FIO";
    public static final String SEX_COLUMN = "SEX";
    public static final String ID_GROUP_COLUMN = "IdGroup";

    public StudentTable() {
        super(TABLE_NAME);
    }


    @Override
    public void create() throws SQLException {
        iDbExecutor.execute(String.format("create table %s (%s int AUTO_INCREMENT, %s varchar(25) NOT NULL, %s varchar(1) NOT NULL, %s int NOT NULL, PRIMARY KEY(%s));",
                        tableName,
                        ID_COLUMN,
                        FIO_COLUMN,
                        SEX_COLUMN,
                        ID_GROUP_COLUMN,
                        ID_COLUMN),
                false);
    }

    public void insert()throws SQLException{
        iDbExecutor.execute(String.format("INSERT INTO %s VALUES (1, 'Wood Sienna', 'm', 3), (2, 'Allen Ruth', 'm', 2), (3, 'Cooper Kimberly', 'm', 2), (4, 'Saunders Helen', 'm', 3), (5, 'Harrison Faye', 'm', 2), (6, 'Wood Beth', 'f', 2), (7, 'Scott Steve', 'f', 1), (8, 'Jackson Beth', 'm', 1), (9, 'Wood Tiffany', 'm', 2), (10, 'Edwards Lilly', 'f', 3), (11, 'Phillips Sabrina', 'm', 1), (12, 'Brown Wendy', 'm', 3), (13, 'Walker Harrison', 'f', 1), (14, 'Smith Christopher', 'm', 1), (15, 'Moore Dave', 'f', 3);",tableName),false);
    }
}
