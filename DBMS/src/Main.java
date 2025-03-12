import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main (String[] args) throws IOException {
//		Scanner kb = new Scanner(System.in);
//		List<String> columnNames = new ArrayList<>(); 
//		Map<String, String> dataTypes = new HashMap<>();
//		boolean run = true;
//		String column = "";
//		
//		System.out.print("Enter a table name: ");
//		String name = kb.next();
//		System.out.println();
//		
//		while (run) {
//			System.out.print("Enter a column name (or 'done' to stop): ");
//			column = kb.next();
//			
//			if (column.equals("done")) {
//				break;
//			}
//			
//			columnNames.add(column);
//			System.out.println();
//			
//			System.out.print("What's the data type ('INT', 'TEXT', 'FLOAT'): ");
//			column = kb.next();
//			System.out.println();
//			
//			while(true) {
//				if (!column.equalsIgnoreCase("INT") && !column.equalsIgnoreCase("TEXT") && !column.equalsIgnoreCase("FLOAT")) {
//					System.out.println("Enter a valid data type: ");
//					column = kb.next();
//				} else {
//					dataTypes.put(columnNames.get(columnNames.size()-1), column);
//					break;
//				}
//			}
//		}
//		
//		Table table = new Table(name, columnNames, dataTypes);
//		table.saveSchemaToFile();
//		
//		table.loadTable("Employee");
		
		Table loadedTable = Table.loadTable("Employee");
		loadedTable.printTableSchema();
	}
}
