import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2021-09-16 23:56
 */
public class CheckNumber extends JFrame{
    static JTextField jt1;
    static JTextField jt2;
    static JButton jb1;
    static JButton jb2;
    JTextArea a;
    String str;
    String str1;
    String str2;
    static Statement sql = ConTest.doConnection();
    static ResultSet rs;
    static int count=0;

    public CheckNumber() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);//窗体大小
        setLocationRelativeTo(null);
    }

    public void init() {
        setTitle("教师页面-查看选修人数");
        setLayout(new GridLayout(6, 1));
        jb1=new JButton("确定");
        jb2=new JButton("返回");
        //通过课程号和课程名筛选
        JLabel lb1 = new JLabel("课程号");
        JLabel lb2 = new JLabel("课程名");
        jt1 = new JTextField(15);
        jt2 = new JTextField(15);
        jb1.addActionListener(this::actionPerformed);
        jb2.addActionListener(this::actionPerformed);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3  = new JPanel();
        JPanel jp4 = new JPanel();
        a = new JTextArea(9, 30);
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
        this.str1 = jt1.getText();
        this.str2 = jt2.getText();
        if (e.getSource() == jb1) {
            try {
                //从表格查询数据
                this.rs = sql.executeQuery("SELECT sname FROM choose WHERE cno= "+str1 + " || cname= 'str2 '");
                System.out.println("eere "+rs);
                while (this.rs.next()) {
                    count++;
                }
                a.append("选择" + str2 + "的人有" + count + "个" + "\n");
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
