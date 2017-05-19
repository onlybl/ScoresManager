package action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import dao.StudentDao;
import dao.StudentDaoImp;
import domain.Student;
import view.Search;
import view.View;

public class ImpActions implements Actions {
	StudentDao studentDaoImp = new StudentDaoImp();
	@Override
	public void action_import(DefaultTableModel tm) {
		JFileChooser jfc = new JFileChooser();
		jfc.showSaveDialog(null);
		File file = jfc.getSelectedFile();
		Vector<Student> students = new Vector<>();
		studentDaoImp.readFromFile(students, file);
			//信息导出到table
		studentDaoImp.writeToTable(students, tm);
	}
	
	@Override
	public void action_export(DefaultTableModel tm) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		jfc.showSaveDialog(null);
		File file = jfc.getSelectedFile();	
		try {
			FileWriter fw = new FileWriter(file,true);
			for(int i = 0;i<tm.getRowCount();i++){
				for(int j = 1;j<=3;j++){
					if(tm.getValueAt(i, j) == null){
						if(1==j||3==j){
							fw.write("0");
						}
						else{
							fw.write("null");
						}
					}
					fw.write((String)tm.getValueAt(i, j)+"\r\n");
				}
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void action_sort(DefaultTableModel tm) {
		// TODO Auto-generated method stub
		Vector<Student> students = new Vector<>();
		//从表格读取学生信息
		studentDaoImp.readFromTable(students, tm);
		//成绩升序排序
		studentDaoImp.sort(students, "name down");
		//导出到表格
		studentDaoImp.writeToTable(students, tm);
	}

	@Override
	public void action_search(DefaultTableModel tm) {
		new Search(tm);
	}

	@Override
	public void action_modify(JTable table, JButton jb,ImageIcon origin,ImageIcon willing) {
		if(table.isEnabled()){
			table.setEnabled(false);
			table.clearSelection();
			jb.setText("修改");
			jb.setIcon(origin);
		}
		else{
			
			table.setEnabled(true);
			jb.setIcon(willing);
			jb.setText("保存修改");
		}
	}

}
