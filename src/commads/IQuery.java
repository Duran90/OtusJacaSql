package commads;

import java.sql.SQLException;

public interface IQuery {

    void selectAllInfo() throws SQLException;
    void selectStudentsCount() throws SQLException;
    void selectAllFemaleStudents() throws SQLException;
    void updateGroupCurator() throws SQLException;
    void selectAllGroupsAngCurator() throws SQLException;
    void selectAllStudentsFromGroup() throws SQLException;
}
