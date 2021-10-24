import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2021-09-14 22:31
 */
public class CheckStudent extends JFrame{
    static JTextField jt1;
    static JTextField jt2;
    static JButton jb1;
    static JButton jb2;
    JTextArea a;
    static String s1;
    static String s2;
    static int s3;
    static Statement sql = ConTest.doConnection();
    static ResultSet rs;

    //构造函数
    public CheckStudent() {
        //初始化数据
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);//窗体大小
        setLocationRelativeTo(null);
    }
    public void init(){
        setTitle("教师页面-查看学生选课");
        setLayout(new GridLayout(6, 1));
        jb1=new JButton("确定");
        jb2=new JButton("返回");
        //通过名字和学号筛选
        JLabel lb1=new JLabel("姓名");
        JLabel lb2=new JLabel("学号");
        jt1=new JTextField(15);
        jt2=new JTextField(15);
        jb1.addActionListener(this::actionPerformed);
        jb2.addActionListener(this::actionPerformed);
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        JPanel jp4=new JPanel();
        a=new JTextArea(9,30);
        jp1.add(lb1);
        jp1.add(jt1);
        jp2.add(lb2);
        jp2.add(jt2);
        jp3.add(jb1);
        jp3.add(jb2);
        jp4.add(a);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            try {
                this.s1 = jt1.getText();
                this.s2 = jt2.getText();
                //查询表格的数据
                rs = sql.executeQuery("select * from choose where sno=" + s2 + "|| sname= 's1'" );
                while (rs.next()) {
                    //课程号 课程名 学生名 学号
                    String st1 = this.rs.getString(1);
                    String st2 = this.rs.getString(2);
                    String st3 = this.rs.getString(3);
                    String st4 = this.rs.getString(4);
                    this.a.append("学号---" + st4 + "  " + "姓名---" + st3 + " " + "课程号---" + st1 + " " + "课程名---" + st2 + " "  + "\n");
                }
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }
        if (e.getSource() == jb2) {
            this.dispose();
            new Teacher();
        }
    }
}


