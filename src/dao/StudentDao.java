package dao;

import java.io.File;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import domain.Student;

public interface StudentDao {
	public void writeToTable(Vector<Student> students,DefaultTableModel tm);
	public void readFromTable(Vector<Student> students,DefaultTableModel tm);
	public void readFromFile(Vector<Student> students,File file);
	public void sort(Vector<Student> students,String type);
	public Vector<Student> search(Vector<Student> students,Student student);
}
