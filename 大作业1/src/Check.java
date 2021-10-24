import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2021-09-14 20:02
 */
public class Check {

    static Statement sql=ConTest.doConnection();
    static ResultSet rs;

    public static void doCheck() throws SQLException {
        if(sql !=null) {
            if (Start.r1.isSelected()) {
                String str;
                //查询需要的数据
                str="select * from student where sno='" + Start.sno + "'and spassword='" + Start.password + "'";
                //执行给定的 SQL 语句，它返回单个 ResultSet 对象
                rs = sql.executeQuery(str);
                if(rs.next()){
                    new Student();
                }else{
                    JOptionPane.showMessageDialog(null,"登录失败，请重新输入");
                    new Start();
                }
            }
            if (Start.r2.isSelected()) {
                String str;
                str="select * from teacher where sno='" + Start.sno +  "'and spassword='" + Start.password + "'" ;
                System.out.println(str);
                rs = sql.executeQuery(str);
                if(rs.next()){
                    new Teacher();
                }else{
                    JOptionPane.showMessageDialog(null,"登录失败，请重新输入");
                    new Start();
                }
            }
        }
    }
}