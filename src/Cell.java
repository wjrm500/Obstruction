public class Cell extends CellReference {
    private Player player;
    private boolean blocked;

    public Cell(int r, int c) {
        super(r, c);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public Player getPlayer() {
        return player;
    }

    public void select(Player player) {
        this.player = player;
    }

    public void block() {
        this.blocked = true;
    }
}
