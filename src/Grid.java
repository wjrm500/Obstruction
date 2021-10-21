public class Grid {
    private int height;
    private int width;
    private Cell[][] cells;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private Cell getCell(int r, int c) {
        return cells[r][c];
    }

    private Cell getCell(CellReference cellReference) {
        int r = cellReference.getR();
        int c = cellReference.getC();
        return cells[r][c];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean allCellsBlocked() {
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                if (!cell.isBlocked()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean cellsBorder(Cell cell1, Cell cell2) {
        int rDiff = Math.abs(cell1.getR() - cell2.getR());
        int cDiff = Math.abs(cell1.getC() - cell2.getC());
        return rDiff < 2 && cDiff < 2 && rDiff * cDiff < 2;
    }

    public boolean isCellReferenceValid(CellReference cellReference) {
        if (cellReference == null) {
            return false;
        }
        int r = cellReference.getR();
        int c = cellReference.getC();
        boolean rTooBig = r - 1 > height;
        boolean cTooBig = c - 1 > width;
        if (rTooBig || cTooBig) {
            return false;
        }
        Cell cell = getCell(r, c);
        Player player = cell.getPlayer();
        if (player != null) {
            return false;
        }
        return !cell.isBlocked();
    }

    public void selectCell(CellReference cellReference, Player player) {
        Cell selectedCell = getCell(cellReference);
        selectedCell.select(player);
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                if (cellsBorder(selectedCell, cell)) {
                    cell.block();
                }
            }
        }
    }
}
