package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

public class ImpActions implements Actions {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void action_import(JTable table,DefaultTableModel tm) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		jfc.showSaveDialog(null);
		File file = jfc.getSelectedFile();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			Vector id = new Vector();
			Vector name = new Vector();
			Vector score = new Vector();
			String item = null;
			int count=1;
			while((item = reader.readLine())!=null){
				if(count%3==0){
					score.add(item);
				}
				else if(count%3==2){
					name.add(item);
				}
				else{
					id.add(item);
				}
				count++;
			}
			//根据数据数增加行数
			tm.setRowCount(id.size()+1);
			count = 0;
			for(Object i : id){
				tm.setValueAt(i, count, 1);
				count++;
			}
			count = 0;
			for(Object i : name){
				tm.setValueAt(i, count, 2);
				count++;
			}
			count = 0;
			for(Object i : score){
				tm.setValueAt(i, count, 3);
				count++;
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void action_export() {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();	
	}

	@Override
	public void action_sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action_search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action_modify(JTable table, JButton jb,ImageIcon origin,ImageIcon willing) {
		// TODO Auto-generated method stub
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
