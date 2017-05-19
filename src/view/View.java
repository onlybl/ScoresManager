package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import action.ImpActions;

public class View extends JFrame{
	//初始化需要使用的图标
	ImageIcon import_icon = new ImageIcon("ui/import.png");
	ImageIcon export_icon = new ImageIcon("ui/export.png");
	ImageIcon sort_icon = new ImageIcon("ui/sort.png");
	ImageIcon search_icon = new ImageIcon("ui/search.png");
	ImageIcon modify_icon = new ImageIcon("ui/modify.png");
	ImageIcon save_icon = new ImageIcon("ui/save.png");
	
	ImpActions actions = new ImpActions();
	//菜单栏
	private JMenuBar jmb = new JMenuBar();
	//菜单
	private JMenu me_file = new JMenu("文件");
	private JMenu me_edit = new JMenu("编辑");
	private JMenu me_search = new JMenu("查找");
	private JMenu me_help = new JMenu("帮助");
	//菜单项
	private JMenuItem jmi_open = new JMenuItem("打开");
	private JMenuItem jmi_export = new JMenuItem("导出");
	//
	private JMenuItem jmi_modify = new JMenuItem("修改");
	//
	private JMenuItem jmi_search = new JMenuItem("查找");
	private JMenuItem jmi_statistics = new JMenuItem("统计");
	//
	private JMenuItem jmi_instruction = new JMenuItem("说明");
	private JMenuItem jmi_about = new JMenuItem("关于");
	void init_menu(){
		setJMenuBar(jmb);
		jmb.add(me_file);
		jmb.add(me_edit);
		jmb.add(me_search);
		jmb.add(me_help);
		me_file.add(jmi_open);
		jmi_open.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				actions.action_import(tm);
			}
			
		});
		me_file.add(jmi_export);
		jmi_export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actions.action_export(tm);
			}
		});
		me_edit.add(jmi_modify);
		me_search.add(jmi_search);
		jmi_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actions.action_search(tm);
			}
		});
		me_search.add(jmi_statistics);
		me_help.add(jmi_instruction);
		me_help.add(jmi_about);
	}
	
	//工具条
	private JToolBar tb = new JToolBar();
	private JButton jb_import = new JButton("导入",import_icon);
	private JButton jb_export = new JButton("导出",export_icon);
	private JButton jb_search = new JButton("查找",search_icon);
	private JButton jb_modify = new JButton("修改",modify_icon);
	void init_toolBar(){
		//jp1.setOpaque(false);
		getContentPane().add("North",tb);
		
		tb.add(jb_import);
		jb_import.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actions.action_import(tm);
			}
		});
		
		tb.add(jb_export);
		jb_export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actions.action_export(tm);
			}
		});
		
		tb.add(jb_search);
		jb_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actions.action_search(tm);
			}
		});
		
		tb.add(jb_modify);
		jb_modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actions.action_modify(table, jb_modify,modify_icon,save_icon);
			}
		});
	}
	
//	private JPanel jp2 = new JPanel(){
//
//		@Override
//		public Insets getInsets() {
//			return new Insets(0,30,0,30);
//		}
//		
//	};
	//表单
	private DefaultTableModel tm = new DefaultTableModel(new Object[][]{
	},new Object[]{
					"序号","学号","姓名","成绩"
	});
	private JTable table;
	@SuppressWarnings("rawtypes")
	void init_table(){
		for(int i =0;i<10;i++){
			tm.addRow((Vector)null);
			tm.setValueAt(new Integer(i), i, 0);
		}
		table = new JTable(tm);
		JScrollPane jtable = new JScrollPane(table);
		getContentPane().add("Center",jtable);
		table.setEnabled(false);
		//TableColumn tc1 = table.getColumn("序号");
		//tc1.setMaxWidth(30);
	}

	public View(){
		super("学生成绩管理系统");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		
		init_menu();
		init_toolBar();
		init_table();
		setSize(800, 600);
		//设置居中
		setLocationRelativeTo(null);
//		b1.setIcon(new ImageIcon("ui/button_qd_00.png"));
//		b1.setBackground(new Color(255,255,255));
//		b1.setBorder(null);
//		getContentPane().setLayout(new FlowLayout());
//		Icon b1_icon = b1.getIcon();
//		
//		b1.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				super.mouseEntered(e);
//				b1.setIcon(new ImageIcon("ui/button_qd_01.png"));
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				super.mouseExited(e);
//				b1.setIcon(b1_icon);
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				super.mousePressed(e);
//				b1.setIcon(new ImageIcon("ui/button_qd_02.png"));
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				super.mouseReleased(e);
//				b1.setIcon(new ImageIcon("ui/button_qd_01.png"));
//			}
//
//		});
//		
//		getContentPane().add(b1);
		
	}
}
