import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2021-09-11 11:11
 */
public class Student extends JFrame{
    static Statement sql = ConTest.doConnection();
    ResultSet rs;
    static JTextArea text;
    static String cno;
    static String cname;
    static String sname;
    static String sno;
    static JTextField jt1;
    static JTextField jt2;
    static JTextField jt3;
    static JTextField jt4;
    static JButton jb1;
    static JButton jb2;
    static JButton jb3;
    //构造函数
    public Student(){
        //初始化界面
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);//窗体大小
        setLocationRelativeTo(null);
    }

    public void init(){
        setTitle("学生页面");
        setLayout(new GridLayout(8, 2));
        ButtonGroup group = new ButtonGroup();
        jb1=new JButton("确定");
        jb2=new JButton("返回");
        jb3=new JButton("查看课程信息");
        JLabel l1=new JLabel("课程号");
        JLabel l2=new JLabel("课程名");
        JLabel l3=new JLabel("学生姓名");
        JLabel l4=new JLabel("学生学号");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);
        jt3 = new JTextField(20);
        jt4 = new JTextField(20);
        text= new JTextArea(9, 30);
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        JPanel jp4=new JPanel();
        JPanel jp5=new JPanel();
        JPanel jp6=new JPanel();
        JPanel jp7=new JPanel();
        jp1.add(l1);
        jp1.add(jt1);
        jt1.addActionListener(this::actionPerformed);
        jp2.add(l2);
        jp2.add(jt2);
        jt2.addActionListener(this::actionPerformed);
        jp3.add(l3);
        jp3.add(jt3);
        jt3.addActionListener(this::actionPerformed);
        jp4.add(l4);
        jp4.add(jt4);
        jt4.addActionListener(this::actionPerformed);
        jp5.add(jb3);
        jb3.addActionListener(this::actionPerformed);
        jp6.add(text);
        jb1.addActionListener(this::actionPerformed);
        jb2.addActionListener(this::actionPerformed);
        jp7.add(jb1);
        jp7.add(jb2);
        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        add(jp5);
        add(jp6);
        add(jp7);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jb3) {
            try {
                //获取对象
                rs = sql.executeQuery("SELECT * FROM course");
                while (rs.next()) {
                    String cno = this.rs.getString(1);
                    String cname = this.rs.getString(2);
                    String credit = this.rs.getString(3);
                    this.text.append("开课信息:" + "课程号---"+ cno + " " +" 课程名---" + cname + " " + "课程学分---"+ credit + "\n" );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==jb1){
            this.cno=jt1.getText();
            this.cname=jt2.getText();
            this.sname=jt3.getText();
            try {
                this.sno=jt4.getText();
                String str;
                str = "insert into choose values('" + this.cno + "','" + this.cname + "','" + this.sname + "','" + this.sno+"')";
                System.out.println(str);
                System.out.println(this.sql);
                int i = this.sql.executeUpdate(str);
                if (i > 0) {
                    //提示信息
                    JOptionPane.showMessageDialog(null, "选修课程成功", "成功", JOptionPane.YES_NO_CANCEL_OPTION);
                    this.dispose();
                    new Student();
                } else {
                    JOptionPane.showMessageDialog((Component) null, "写入失败", "写入失败,重新写入", 2);
                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
        if(e.getSource()==jb2){
            this.dispose();
            new Start();
        }
    }
}
