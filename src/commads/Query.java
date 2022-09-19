package commads;

import db.IDbExecutor;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.sql.SQLException;

public class Query implements IQuery{
    protected IDbExecutor iDbExecutor;

    @Override
    public void selectAllInfo() throws SQLException {
        iDbExecutor.execute(String.format("select %1$s.Id id, %1$s.FIO FIO, SEX, %2$s.Name Name, %3$s.FIO from %1$s inner join %2$s on  %1$s.IdGroup = %2$s.Id inner join %3$s on %2$s.IdCurator = %3$s.Id;",StudentTable.TABLE_NAME,GroupTable.TABLE_NAME, CuratorTable.TABLE_NAME),true);
    }

    @Override
    public void selectStudentsCount() throws SQLException{
        iDbExecutor.execute(String.format("select count(Id) from %1$s",StudentTable.TABLE_NAME),true);
    }

    @Override
    public void selectAllFemaleStudents()throws SQLException {
        iDbExecutor.execute(String.format("select %1$s.Id id, %1$s.FIO FIO, SEX, %2$s.Name Name, %2$s.FIO from %1$s inner join %2$s on  %1$s.IdGroup = %2$s.Id inner join %3$s on %2$s.IdCurator = %3$s.Id where SEX = 'f';", StudentTable.TABLE_NAME, GroupTable.TABLE_NAME,CuratorTable.TABLE_NAME),true);
    }

    @Override
    public void updateGroupCurator() throws SQLException{
        iDbExecutor.execute(String.format(""),true);
    }

    @Override
    public void selectAllGroupsAngCurator() throws SQLException {
        iDbExecutor.execute(String.format("select %1$s.Id id, Name, %2$s.FIO FIO from %1$s inner join %2$s on %1$s.IdCurator = %2$s.Id;",GroupTable.TABLE_NAME,CuratorTable.TABLE_NAME),true);
    }

    @Override
    public void selectAllStudentsFromGroup() throws SQLException {
        iDbExecutor.execute(String.format("select Id, FIO from %1$s where IdGroup = (select Id from %2$s where name like('Alfa'));",StudentTable.TABLE_NAME,GroupTable.TABLE_NAME),true);
    }
}
