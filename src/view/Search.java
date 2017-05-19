package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.StudentDaoImp;
import domain.Student;

public class Search extends JDialog {
	StudentDaoImp studentDaoImp = new StudentDaoImp();
	JLabel lbl_id = new JLabel("学号",JLabel.CENTER);
	JLabel lbl_name = new JLabel("姓名",JLabel.CENTER);
	JLabel lbl_score = new JLabel("成绩",JLabel.CENTER);
	JTextField jtf_id = new JTextField();
	JTextField jtf_name = new JTextField();
	JTextField jtf_score = new JTextField();
	JButton jb = new JButton("查找");
	public Search(DefaultTableModel tm){
		super();
		setLocationRelativeTo(null);
		setTitle("搜索");
		setSize(320, 130);
		JPanel jp_main = new JPanel(new GridLayout(2, 3,20,15));
		getContentPane().setLayout(new BorderLayout());
		add("Center",jp_main);
		jp_main.add(lbl_id);
		jp_main.add(lbl_name);
		jp_main.add(lbl_score);
		jp_main.add(jtf_id);
		jp_main.add(jtf_name);
		jp_main.add(jtf_score);
		add("South",jb);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//创建存储所有学生集合的列表
				Vector<Student> students = new Vector<>();
				//获得查找条件
				Student student = new Student();
				student.setId(jtf_id.getText());
				student.setName(jtf_name.getText());
				student.setScore(jtf_score.getText());
				//声明存储筛选后的学生集合的列表
				Vector<Student> stuList;
				//从表格读取信息至students
				studentDaoImp.readFromTable(students, tm);
				//筛选学生至stuList
				stuList = studentDaoImp.search(students,student);
				new SearchReasult();
			}
		});
		setVisible(true);
	}
}
