/***
 * This is a helper class to read CSV data.
 * 
 * @author oshorab971
 *
 */
public class CSVData {
	private double[][] data;
	private String[] columnNames;
	private String filePathToCSV;
	private int numRows;

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
				if (coords[j].endsWith("#"))
					coords[j] = coords[j].substring(0, coords[j].length() - 1);
				double val = Double.parseDouble(coords[j]);
				data[i][j] = val;
			}
		}
	}

	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] colNames) {

		return null;
	}

	public double[] getRow(int rowIndex) {
		double[] rowArr = new double[data[rowIndex].length];
		for (int i = 0; i < rowArr.length; i++) {
			rowArr[i] = data[rowIndex][i];
		}

		return rowArr;
	}

	public void setRow(double[] rowArr, int rowIndex) {
		for (int i = 0; i < rowArr.length; i++) {
			data[rowIndex][i] = rowArr[i];
		}
	}

	public double[] getColumn(int colIndex) {
		double[] colArr = new double[data.length];

		for (int i = 0; i < colArr.length; i++) {
			colArr[i] = data[i][colIndex];
		}

		return colArr;
	}

	public void setCol(double[] colArr, int colIndex) {
		for (int i = 0; i < colArr.length; i++) {
			data[i][colIndex] = colArr[i];
		}
	}

	public double[] getColumn(String name) {
		return null;
	}

	public double[][] getRows(int startIndex, int endIndex) {
		double[][] rowsArr = new double[endIndex - startIndex][data[0].length];
		for (int i = startIndex; i < endIndex; i++) {
			rowsArr[i] = data[i];
		}
		return rowsArr;
	}

	// public double[][] getRows(int[] rowIndexes) {
	// return null;


	public double[][] getColumns(int startIndex, int endIndex) {
		double[][] ColsArr = new double[data.length][endIndex - startIndex];
		for(int i = startIndex; i <= endIndex; i++) {
			ColsArr[i] = getColumn(i);
		}
		
		return ColsArr;
}
