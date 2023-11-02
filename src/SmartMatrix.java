
public class SmartMatrix implements Matrix {
	private int n;
	private int m;
	private double[][] data;

	public SmartMatrix(int rows, int cols) {
		n = rows;
		m = cols;
		data = new double[n][m];
	}

	public SmartMatrix(int rows, int cols, double[] content) throws Exception {
		n = rows;
		m = cols;
		data = new double[n][m];

		if (content.length != n * m) {

			throw new Exception("Wrong input size.");
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				data[r][c] = content[r * m + c];
			}
		}
	}

	public String toString() {
		String retStr = "";

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				retStr += Double.toString(data[r][c]) + " ";
			}

			retStr += "\n";
		}

		return retStr;
	}

	public void addSecondRowToFirst(int i, int j) {
		// Not implemented to save time in class
	}

	public void swapRows(int i, int j) {
		for (int c = 0; c < m; c++) {
			double tmp = data[i][c];
			data[i][c] = data[j][c];
			data[j][c] = tmp;
		}

	}

	public static void main(String[] args) {

		SmartMatrix m = new SmartMatrix(3, 3);
		System.out.println(m);

		double[] content = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		try {
			SmartMatrix sm = new SmartMatrix(3, 4, content);
			System.out.println(sm);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
}
