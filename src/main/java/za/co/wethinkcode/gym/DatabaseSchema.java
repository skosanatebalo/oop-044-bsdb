package za.co.wethinkcode.gym;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSchema {

    private DatabaseSchema() {
    }

    public static void createSchema(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            // TODO: create the `members` and `memberships` tables described in
            // resources/erd.png, including the primary key on each table, the
            // NOT NULL constraints, and the foreign key from
            // memberships.member_id to members.id.
            //
            // Execute one CREATE TABLE statement per table, like this:
            //
            //     statement.execute("""
            //             CREATE TABLE ...
            //
            //           """);



        }
    }
}
