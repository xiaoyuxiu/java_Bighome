import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2021-09-11 11:12
 */
public class Teacher extends JFrame {
    static JRadioButton r1;
    static JRadioButton r2;
    static JRadioButton r3;
    static JRadioButton r4;
    static Statement sql= ConTest.doConnection();
    static ResultSet set;
    static JButton jb1;

    //构造函数
    public Teacher(){
        //初始化页面
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);//窗体大小
        setLocationRelativeTo(null);
    }
    public void init(){
        setTitle("教师页面-输入开课信息");
        setLayout(new GridLayout(6, 1));
        ButtonGroup group = new ButtonGroup();
        r1 = new JRadioButton("输入开课信息", true);
        r2 = new JRadioButton("查看学生选课", false);
        r3 = new JRadioButton("查看课程情况", false);
        r4 = new JRadioButton("查看选修人数", false);
        jb1=new JButton("返回");
        r1.addActionListener(this::actionPerformed);
        r2.addActionListener(this::actionPerformed);
        r3.addActionListener(this::actionPerformed);
        r4.addActionListener(this::actionPerformed);
        jb1.addActionListener(this::actionPerformed);
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        jp1.add(r1);
        jp1.add(r2);
        jp1.add(r3);
        jp1.add(r4);
        jp2.add(jb1);
        add(jp1);
        add(jp2);

    }

    //添加事件
    public void actionPerformed(ActionEvent e) {
        if (r1.isSelected()) {
            this.dispose();
            new InputCourse();
        }
        if(r2.isSelected()){
            this.dispose();
            new CheckStudent();
        }
        if(r3.isSelected()){
            this.dispose();
            new CheckCourse();
        }
        if(r4.isSelected()){
            this.dispose();
            new CheckNumber();
        }
        if (e.getSource() == jb1) {
            this.dispose();
            new Start();
        }
    }
}
