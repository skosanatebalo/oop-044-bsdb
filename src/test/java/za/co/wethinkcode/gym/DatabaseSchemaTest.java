package za.co.wethinkcode.gym;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseSchemaTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = Database.connect(":memory:");
        DatabaseSchema.createSchema(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void membersTable_hasIdAsPrimaryKey() throws SQLException {
        assertTrue(primaryKeyFlags("members").get("id"));
    }

    @Test
    void membersTable_fullNameAndEmailAreNotNull() throws SQLException {
        Map<String, Boolean> notNull = notNullFlags("members");
        assertTrue(notNull.get("full_name"));
        assertTrue(notNull.get("email"));
    }

    @Test
    void membershipsTable_hasIdAsPrimaryKey() throws SQLException {
        assertTrue(primaryKeyFlags("memberships").get("id"));
    }

    @Test
    void membershipsTable_planTypeMonthsSubscribedAndMemberIdAreNotNull() throws SQLException {
        Map<String, Boolean> notNull = notNullFlags("memberships");
        assertTrue(notNull.get("plan_type"));
        assertTrue(notNull.get("months_subscribed"));
        assertTrue(notNull.get("member_id"));
    }

    @Test
    void membershipsTable_memberIdReferencesMembers() throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("PRAGMA foreign_key_list(memberships)")) {

            assertTrue(resultSet.next(), "expected memberships to declare a foreign key");
            assertEquals("members", resultSet.getString("table"));
            assertEquals("member_id", resultSet.getString("from"));
            assertEquals("id", resultSet.getString("to"));
        }
    }

    private Map<String, Boolean> primaryKeyFlags(String table) throws SQLException {
        return columnFlags(table, "pk");
    }

    private Map<String, Boolean> notNullFlags(String table) throws SQLException {
        return columnFlags(table, "notnull");
    }

    private Map<String, Boolean> columnFlags(String table, String flagColumn) throws SQLException {
        Map<String, Boolean> flags = new HashMap<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("PRAGMA table_info(" + table + ")")) {
            while (resultSet.next()) {
                flags.put(resultSet.getString("name"), resultSet.getInt(flagColumn) > 0);
            }
        }
        return flags;
    }
}
