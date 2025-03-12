import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Table {
	private String name;
	private Map<String, String> dataTypes;
	private List<String> columnNames;
	private String primaryKey;
	private File tableFile;
	private BinarySearchTree <Integer, Long> primaryKeyIndex;
	
	public Table(String name, List<String> columnNames, Map<String, String> dataTypes) {
		this.name = name;
		this.dataTypes = dataTypes;
		this.columnNames = columnNames;
		this.tableFile = new File(name + ".txt");
		
		if (!columnNames.isEmpty()) {
			this.primaryKey = columnNames.get(0);
			if (dataTypes.get(primaryKey).equals("INTEGER")) {
				primaryKeyIndex = new BinarySearchTree<>();
			}
		}
	}
	
	public void saveSchemaToFile() throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(tableFile))) {
			writer.println(columnNames.size());
			for (String column : columnNames) {
				writer.print(column + " " + dataTypes.get(column));
				if (column.equals(primaryKey)) writer.print(" PRIMARY_KEY");
				writer.println();
			}
		}
	}
	
	public static Table loadTable(String tableName) throws IOException {
	    File file = new File(tableName + ".txt");
	    if (!file.exists()) throw new IOException("Table '" + tableName + "' does not exist.");

	    List<String> columns = new ArrayList<>();
	    Map<String, String> dataTypes = new HashMap<>();
	    boolean hasPrimaryKey = false;
	    String primaryKey = null;

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        int columnCount = Integer.parseInt(reader.readLine().trim());
	        for (int i = 0; i < columnCount; i++) {
	            String[] parts = reader.readLine().split(" ");
	            String columnName = parts[0];
	            String columnType = parts[1];

	            columns.add(columnName);
	            dataTypes.put(columnName, columnType);

	            if (parts.length > 2 && parts[2].equals("PRIMARY_KEY")) {
	                primaryKey = columnName;
	                hasPrimaryKey = true;
	            }
	        }
	    }

	    Table table = new Table(tableName, columns, dataTypes);
	    if (hasPrimaryKey) table.primaryKey = primaryKey;
	    return table;
	}
	
	public void printTableSchema() {
	    System.out.println("📌 Table Name: " + name);
	    System.out.println("Primary Key: " + (primaryKey != null ? primaryKey : "None"));
	    System.out.println("Columns:");
	    for (String column : columnNames) {
	        System.out.println("  - " + column + " (" + dataTypes.get(column) + ")");
	    }
	}


	
	
}
