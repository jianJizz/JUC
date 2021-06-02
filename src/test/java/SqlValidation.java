import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLUseStatement;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.util.JdbcConstants;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @date 2020/12/23 8:02 下午
 */
public class SqlValidation {
    public static Map<String, TreeSet<String>> getFromTo (String sql) throws ParserException {
        Map<String, TreeSet<String>> result = new HashMap<String, TreeSet<String>>();
        List<SQLStatement> stmts = SQLUtils.parseStatements(sql, JdbcConstants.HIVE);
        TreeSet<String> selectSet = new TreeSet<String>();
        TreeSet<String> updateSet = new TreeSet<String>();
        TreeSet<String> insertSet = new TreeSet<String>();
        TreeSet<String> deleteSet = new TreeSet<String>();

        if (stmts == null) {
            return null;
        }

        String database = "DEFAULT";
        for (SQLStatement stmt : stmts) {
            SchemaStatVisitor statVisitor = SQLUtils.createSchemaStatVisitor(stmts,JdbcConstants.HIVE);
            if (stmt instanceof SQLUseStatement) {
                database = ((SQLUseStatement) stmt).getDatabase().getSimpleName();
            }
            stmt.accept(statVisitor);
            Map<TableStat.Name, TableStat> tables = statVisitor.getTables();

            if (tables != null) {
                final String db = database;
                for (Map.Entry<TableStat.Name, TableStat> table : tables.entrySet()) {
                    TableStat.Name tableName = table.getKey();
                    TableStat stat = table.getValue();

                    if (stat.getCreateCount() > 0 || stat.getInsertCount() > 0) { //create
                        String insert = tableName.getName();
                        if (!insert.contains("."))
                            insert = db + "." + insert;
                        insertSet.add(insert);
                    } else if (stat.getSelectCount() > 0) { //select
                        String select = tableName.getName();
                        if (!select.contains("."))
                            select = db + "." + select;
                        selectSet.add(select);
                    }else if (stat.getUpdateCount() > 0 ) { //update
                        String update = tableName.getName();
                        if (!update.contains("."))
                            update = db + "." + update;
                        updateSet.add(update);
                    }else if (stat.getDeleteCount() > 0) { //delete
                        String delete = tableName.getName();
                        if (!delete.contains("."))
                            delete = db + "." + delete;
                        deleteSet.add(delete);
                    }
                }
            }
        }

        result.put("select",selectSet);
        result.put("insert",insertSet);
        result.put("update",updateSet);
        result.put("delete",deleteSet);

        return result;
    }

    public static void main(String[] args) throws IOException {
        String path = SqlValidation.class.getClassLoader().getResource("in.txt").getPath();
        String sql = FileUtils.readFileToString(new File(path), "utf-8");
//        String sql = "select * from " +
//                "(select * from supindb.student d where dt='20190202')a " +
//                "left join " +
//                "(select * from supindb.college c where dt='20190202')b " +
//                " on a.uid=b.uid " +
//                "where a.uid > 0";

        //sql = "update supindb.college set uid='22333' where name='小明'";
        //sql = "delete from supindb.college where uid= '22223333'";

        Map<String, TreeSet<String>> getfrom = getFromTo(sql);

        for (Map.Entry<String, TreeSet<String>> entry : getfrom.entrySet()){
            System.out.println("================");
            System.out.println("key=" + entry.getKey());
            for (String table : entry.getValue()){
                System.out.println(table);
            }
        }
    }
}
