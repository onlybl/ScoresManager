package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import domain.Student;

public class StudentDaoImp implements StudentDao {

	@Override
	public void writeToTable(Vector<Student> students, DefaultTableModel tm) {
		//根据数据数增加行数
				tm.setRowCount(students.size()+1);
				//添加序号
				for(int i = 0;i<tm.getRowCount();i++){
					tm.setValueAt(new Integer(i), i, 0);
				}
				int count = 0;
				for(Student i : students){
					tm.setValueAt(i.getId(), count, 1);
					tm.setValueAt(i.getName(), count, 2);
					tm.setValueAt(i.getScore(), count, 3);
					count++;
				}
	}

	@Override
	public void readFromTable(Vector<Student> students, DefaultTableModel tm) {
		for(int row = 0;row<tm.getRowCount()-1;row++){
			students.add(new Student());
			students.lastElement().setId((String)tm.getValueAt(row, 1));
			students.lastElement().setName((String)tm.getValueAt(row, 2));
			students.lastElement().setScore((String)tm.getValueAt(row, 3));
		}
	}
	
	@Override
	public void sort(Vector<Student> students,String type) {
		if(type.equals("score up")){
			students.sort(new Comparator<Student>(){

				@Override
				public int compare(Student o1, Student o2) {
					if(Double.parseDouble(o1.getScore())>Double.parseDouble(o2.getScore())){
						return -1;
					}
					return 0;
				}
				
			});
		}
		else if(type.equals("score down")){
			students.sort(new Comparator<Student>(){

				@Override
				public int compare(Student o1, Student o2) {
					if(Double.parseDouble(o1.getScore())<Double.parseDouble(o2.getScore())){
						return -1;
					}
					return 0;
				}
				
			});
		}
		else if(type.equals("id up")){
			students.sort(new Comparator<Student>(){

				@Override
				public int compare(Student o1, Student o2) {
					if(Double.parseDouble(o1.getId())>Double.parseDouble(o2.getId())){
						return -1;
					}
					return 0;
				}
				
			});
		}
		else if(type.equals("id down")){
			students.sort(new Comparator<Student>(){

				@Override
				public int compare(Student o1, Student o2) {
					if(Double.parseDouble(o1.getId())<Double.parseDouble(o2.getId())){
						return -1;
					}
					return 0;
				}
				
			});
		}
		else if(type.equals("name up")){
			students.sort(new Comparator<Student>(){

				@Override
				public int compare(Student o1, Student o2) {
					return o1.getName().compareTo(o2.getName());
				}
				
			});
		}
		else if(type.equals("name down")){
			students.sort(new Comparator<Student>(){

				@Override
				public int compare(Student o1, Student o2) {
					return o2.getName().compareTo(o1.getName());
				}
				
			});
		}
	}

	@Override
	public Vector<Student> search(Vector<Student> students,Student student) {
		Vector<Student> stuList = new Vector<Student>();
		for(Student i : students){
			if(i.getId().equals(student.getId())||i.getName().equals(student.getName())||i.getScore().equals(student.getScore())){
				stuList.add(i);
			}
		}
		return stuList;
	}

	@Override
	public void readFromFile(Vector<Student> student, File file) {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String item = null;
			int count=1;
			while((item = reader.readLine())!=null){
				if(count%3==0){
					student.lastElement().setScore(item);
				}
				else if(count%3==2){
					student.lastElement().setName(item);
				}
				else{
					student.add(new Student());
					student.lastElement().setId(item);
				}
				count++;
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
