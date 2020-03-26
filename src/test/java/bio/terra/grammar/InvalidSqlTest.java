package bio.terra.grammar;

import bio.terra.common.category.Unit;
import bio.terra.grammar.exception.InvalidQueryException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(Unit.class)
@RunWith(Parameterized.class)
public class InvalidSqlTest {

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[] {
            // it has to be valid sql
            "mr. michael", "hi rori",

            // no unescaped quotes in the middle of strings
            "SELECT * FROM dataset.authors WHERE dataset.authors.forename = 'evil'ex'",

            // no comments
            "SELECT * FROM dataset.authors WHERE dataset.authors.forename = 'evil' OR 1=1 --'",

            // no drops
            "DROP TABLE dataset.authors",

            // no deletes
            "DELETE FROM dataset.authors",

            // no truncates
            "TRUNCATE dataset.authors",

            // full statement has to be valid
            "SELECT * FROM dataset.table WHERE dataset.table.x = 'string' AND THEN JUNK",

            // no inserts
            "INSERT INTO dataset.table (x) VALUES SELECT x FROM dataset.table",

            // tables need to be fully qualified
            "SELECT * FROM a_table",

            // columns also need to be fully qualified OR properly aliased
            "SELECT * FROM dataset.table WHERE col = 'foo'"
        };
    }

    private String sql;

    public InvalidSqlTest(String sql) {
        this.sql = sql;
    }

    @Test(expected = InvalidQueryException.class)
    public void test() {
        Query.parse(sql);
    }
}
