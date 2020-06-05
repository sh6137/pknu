package swingjtable;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest1 extends JFrame {
	public  JTableTest1() {
		super("JTableTest1()");
		String [] columnNames = {
			"상품번호", "상품이름", "상품가격", "상품설명"	
		};
		
		Object[][] rowData = getDataSet();
//		Object[][] rowData = {
//				{1,"맛동산",1000,"오리온"},
//				{2,"초코파이",7000,"롯데"},
//				{3,"오예스",6000,"해테"}
//		};
		//DataSet 기법
		DefaultTableModel tm= new DefaultTableModel(rowData,columnNames);
		JTable jt = new JTable(tm);
		JScrollPane jScrollPane  = new JScrollPane(jt);
		this.add(jScrollPane);
		
		
		//data 추가
		Object [] insertRow = new Object[] {3,"새우깡",6000,"농심"};
		tm.addRow(insertRow);
		this.add(jScrollPane);
		
		//data 조작
		//1.향과 열 수
		System.out.println("줄수 : " + jt.getRowCount());
		System.out.println("칸수 : " + jt.getColumnCount());
		
		//2.칼럼이름 가져오기
		System.out.println("0 번째 칸 제목 : " + tm.getColumnName(0));
		System.out.println("0 번째 칸 제목 : " + tm.getColumnName(0));
		
		//3.데이터 줄 삭제
		tm.removeRow(0); //줄이 삭제됨
		
		
		//4. data 가져오기 (2,2) 위치의 자료 가져오기
		System.out.println("(2,2)위치의 data" + tm.getValueAt(2, 2));
		
		//5.data 고치기
		tm.setValueAt(10000, 2, 2);
		//6.선택한 row relection 고치기
		
		jt.setRowSelectionInterval(1, 1);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	private Object[][] getDataSet() {
		Object[][] rowData = {
				{1,"맛동산",1000,"오리온"},
				{2,"초코파이",7000,"롯데"},
				{3,"오예스",6000,"해테"}
		};
		return rowData;
	}

	public static void main(String[] args) {
		new JTableTest1();

	}

}
