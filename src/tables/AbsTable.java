package tables;

import db.IDbExecutor;
import db.MySqlDbExecutor;

import java.sql.SQLException;

public abstract class AbsTable implements ITables{
    protected String tableName;

    protected IDbExecutor iDbExecutor;

    public IDbExecutor getIDbExecutor(){
      return iDbExecutor;
    }

    public AbsTable(String tableName){
        this.tableName = tableName;
        iDbExecutor = new MySqlDbExecutor();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public void drop() throws SQLException {
        iDbExecutor.execute(String.format("drop table %s);",tableName),false);
    }

}
