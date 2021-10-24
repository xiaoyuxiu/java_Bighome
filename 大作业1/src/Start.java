import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2021-09-11 9:42
 */
public class Start extends JFrame {
    public static void main(String[] args) {
        Start ssc = new Start();         //开启运行程序
    }

    static JRadioButton r1;
    static JRadioButton r2;
    static JTextField text1;
    static JPasswordField text2;
    static String sno;
    static String password;
    static JButton button1;

    //构造函数
    public Start() {
        //初始化界面函数
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);//窗体大小
        setLocationRelativeTo(null);
    }

    public void init() {
        setLayout(new GridLayout(6, 1));
        setTitle("登陆界面");
        text1 = new JTextField(15);
        text2 = new JPasswordField(15);
        JLabel label1 = new JLabel("账号");
        JLabel label2 = new JLabel("密码");
        button1 = new JButton("登录");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        ButtonGroup group = new ButtonGroup();
        r1 = new JRadioButton("学生", true);
        r2 = new JRadioButton("教师", false);
        group.add(r1);
        group.add(r2);
        panel1.add(r1);
        panel1.add(r2);
        panel2.add(label1);
        panel2.add(text1);
        panel3.add(label2);
        panel3.add(text2);
        panel4.add(button1);
        text1.addActionListener(this::actionPerformed);
        text2.addActionListener(this::actionPerformed);
        button1.addActionListener(this::actionPerformed);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
    }

    //添加事件响应
    public void actionPerformed(ActionEvent e) {
        //获取账号和密码
        sno=text1.getText();
        password=text2.getText();
        if (e.getSource() == button1) {
            try {
                Check.doCheck();
                this.dispose();
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }
    }
}