/***
 * This is a helper class to read CSV data.
 * 
 * @author oshorab971
 *
 */
public class CSVData {
	private double[][] data;
	private String[] columnNames;

	public CSVData(String filepath, String[] columnNames, int startRow) {
		 this.filePathToCSV = filepath;

		 String dataString = readFileAsString(filepath);
		 String[] lines = dataString.split("\n");

		 // number of data points
		 int n = lines.length - startRow;
		 this.numRows = n;
		 int numColumns = columnNames.length;

		 // create storage for column names
		 this.columnNames = columnNames;

		 // create storage for data
		 this.data = new double[n][numColumns];
		 for (int i = 0; i < lines.length - startRow; i++) {
		 String line = lines[startRow + i];
		 String[] coords = line.split(",");
		 for (int j = 0; j < numColumns; j++) {
		 if (coords[j].endsWith("#")) coords[j] = coords[j].substring(0, coords[j].length()-1);
		 double val = Double.parseDouble(coords[j]);
		 data[i][j] = val;
		 }
		 }
		 }
	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] colNames) {
		
		
		return null;
	}
	
	public double[] getRow(int rowIndex) {
		
		return this.data[rowIndex];
	}
	
	public double[] getColumn(int colIndex) {
		return null;
	}
	
	public double[] getColumn(String name) {
		return null;
	}
	
	public double[][] getRows(int startIndex, int endIndex) {
		return null;
	}
	
	public double[][] getRows(int[] rowIndexes) {
		return null;
	}
	
	
}
