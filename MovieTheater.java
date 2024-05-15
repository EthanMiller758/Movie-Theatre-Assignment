public class MovieTheater {
    private char[][] seatingChart;
    private int numRows;
    private int numSeatsPerRow;

    public MovieTheater(int numRows, int numSeatsPerRow) {
        this.numRows = numRows;
        this.numSeatsPerRow = numSeatsPerRow;
        this.seatingChart = new char[numRows][numSeatsPerRow];
        initializeSeatingChart();
    }

    private void initializeSeatingChart() {
        for (int row = 0; row < numRows; row++) {
            for (int seat = 0; seat < numSeatsPerRow; seat++) {
                seatingChart[row][seat] = '0'; // '0' represents an available seat
            }
        }
    }

    public void displaySeatingChart() {
        System.out.println("Seating Chart: ");
        for (int row = 0; row < numRows; row++) {
            for (int seat = 0; seat < numSeatsPerRow; seat++) {
                System.out.print(seatingChart[row][seat] + " ");
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int seat) {
        if (row < 0 || row >= numRows || seat < 0 || seat >= numSeatsPerRow) {
            System.out.println("Invalid seat selection. Please choose a valid seat.");
            return false;
        }

        if (seatingChart[row][seat] == 'X') {
            System.out.println("This seat is already taken.");
            return false;
        }

        seatingChart[row][seat] = 'X'; // 'X' represents a reserved seat
        System.out.println("Seat reserved successfully!");
        return true;
    }

    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater(5, 10);
        movieTheater.reserveSeat(2, 3);
        movieTheater.displaySeatingChart();
    }
}
