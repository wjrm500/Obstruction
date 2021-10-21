public class Main {
    private Displayable display;
    private Grid grid;
    private Player[] players;

    public static void main(String[] args) {
        Main m = new Main();

        m.go();
    }

    public void go() {
        display = new CLIDisplay();
        grid = new Grid(5, 5);
        players = new Player[] {new Player('A'), new Player('B')};
        int playerIndex = 0;
        while (!grid.allCellsBlocked()) {
            display.displayGrid(grid);
            Player activePlayer = players[playerIndex];
            CellReference cellReference = display.getCellReference(activePlayer);
            boolean valid = grid.isCellReferenceValid(cellReference);
            if (!valid) {
                display.notifyInvalidInput();
                continue;
            }
            grid.selectCell(cellReference, activePlayer);
            playerIndex = Math.abs(playerIndex - 1);
        }
        display.displayGrid(grid);
        display.notifyWinner(players[Math.abs(playerIndex - 1)]);
    }
}
