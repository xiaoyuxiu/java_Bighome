/**
 * @author shkstart
 * @create 2021-09-12 10:52
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用JDBC连接MySQL数据库
 *
 * @author pan_junbiao
 */
public class ConTest {
    public static  Connection conn;
    public static   Statement sql;

    public static Statement doConnection() {
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (Exception var5) {
        }

        try {
            // 获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/system?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root", "127523");
            //向数据库发送sql查询语句
            sql = conn.createStatement();
            return sql;
        } catch (SQLException var4) {
        }
        return null;
    }
}

