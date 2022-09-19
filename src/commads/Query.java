package commads;

import db.IDbExecutor;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Query{

   private IDbExecutor iDbExecutor;

    public Query(IDbExecutor iDbExecutor) {
        this.iDbExecutor = iDbExecutor;
    }

    public void selectAllInfo() throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("select %1$s.Id id, %1$s.FIO FIO, SEX, %2$s.Name Name, %3$s.FIO Curator from %1$s inner join %2$s on  %1$s.IdGroup = %2$s.Id inner join %3$s on %2$s.IdCurator = %3$s.Id;",StudentTable.TABLE_NAME,GroupTable.TABLE_NAME, CuratorTable.TABLE_NAME),true);
        System.out.println("All students");
        while (result.next()){
            int id = result.getInt(1);
            String fio = result.getString(2);
            String name = result.getString(3);
            String sex = result.getString(4);
            String curator = result.getString(5);
            System.out.println(id + "|" + fio + "|" + name + "|" + sex + "|" + curator);
        }
    }

    public void selectStudentsCount() throws SQLException{
        ResultSet result = iDbExecutor.execute(String.format("select count(Id) from %1$s",StudentTable.TABLE_NAME),true);
        System.out.println("Count all students");
        while (result.next()){
            int count = result.getInt(1);
            System.out.println("Count = " + count);
        }
    }

    public void selectAllFemaleStudents()throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("select %1$s.Id id, %1$s.FIO FIO, SEX, %2$s.Name Name, %3$s.FIO from %1$s inner join %2$s on  %1$s.IdGroup = %2$s.Id inner join %3$s on %2$s.IdCurator = %3$s.Id where SEX = 'f';", StudentTable.TABLE_NAME, GroupTable.TABLE_NAME,CuratorTable.TABLE_NAME),true);
        System.out.println("All female students");
        while (result.next()){
            int id = result.getInt(1);
            String fio = result.getString(2);
            String name = result.getString(3);
            String sex = result.getString(4);
            String curator = result.getString(5);
            System.out.println(id + "|" + fio + "|" + name + "|" + sex + "|" + curator);
        }
    }

    public void updateGroupCurator() throws SQLException{
        iDbExecutor.execute(String.format("update %1$s set IdCurator = 3 where Id = 1",GroupTable.TABLE_NAME),false);
    }

    public void selectAllGroupsAngCurator() throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("select %1$s.Id id, Name, %2$s.FIO FIO from %1$s inner join %2$s on %1$s.IdCurator = %2$s.Id order by Id;",GroupTable.TABLE_NAME,CuratorTable.TABLE_NAME),true);
        System.out.println("All groups");
        while (result.next()){
            int id = result.getInt(1);
            String name = result.getString(2);
            String fio = result.getString(3);
            System.out.println(id + "|" + name + "|" + fio);
        }
    }

    public void selectAllStudentsFromGroup() throws SQLException {
        ResultSet result = iDbExecutor.execute(String.format("select Id, FIO from %1$s where IdGroup = (select Id from %2$s where name like('Alfa'));",StudentTable.TABLE_NAME,GroupTable.TABLE_NAME),true);
        System.out.println("All students from group");
        while (result.next()){
            int id = result.getInt(1);
            String fio = result.getString(2);
            System.out.println(id + "|" + fio  );
        }
    }
}
