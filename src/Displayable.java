public interface Displayable {
    void displayGrid(Grid grid);

    CellReference getCellReference(Player player);

    void notifyInvalidInput();

    void notifyWinner(Player player);
}
