import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2021-09-17 15:17
 */
public class InputCourse extends JFrame {
    static String cno;
    static String cname;
    static String credit;
    static JTextField jt1;
    static JTextField jt2;
    static JTextField jt3;
    static Statement sql = ConTest.doConnection();
    static ResultSet set;
    static JButton jb1;
    static JButton jb2;

    //构造函数
    public InputCourse() {
        //初始化界面
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);//窗体大小
        setLocationRelativeTo(null);
    }

    public void init() {
        setTitle("教师页面-开设课程信息");
        setLayout(new GridLayout(6, 1));
        JLabel lb1 = new JLabel("课程号");
        JLabel lb2 = new JLabel("课程名");
        JLabel lb3 = new JLabel("所得学分");
        jt1 = new JTextField(15);
        jt2 = new JTextField(15);
        jt3 = new JTextField(15);
        jb1 = new JButton("确定");
        jb2 = new JButton("返回");
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        jp1.add(lb1);
        jp1.add(jt1);
        jp2.add(lb2);
        jp2.add(jt2);
        jp3.add(lb3);
        jp3.add(jt3);
        jp4.add(jb1);
        jp4.add(jb2);
        jb1.addActionListener(this::actionPerformed);
        jb2.addActionListener(this::actionPerformed);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
    }

    //响应事件
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            try {
                this.cno = jt1.getText();
                this.cname = jt2.getText();
                this.credit = jt3.getText();
                String str;
                //插入数据到表格中
                str = "insert into course values('" + this.cno + "','" + this.cname + "','" + this.credit +  "')";
                //执行给定的 SQL 语句
                int i = this.sql.executeUpdate(str);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "录入课程成功", "成功", JOptionPane.YES_NO_CANCEL_OPTION);
                    this.dispose();
                    new Teacher();
                } else {
                    JOptionPane.showMessageDialog((Component) null, "写入失败", "写入失败,重新写入", 2);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == jb2) {
            this.dispose();
            new Teacher();
        }
    }
}

