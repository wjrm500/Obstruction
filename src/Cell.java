public class Cell implements Cellular {
    private int r;
    private int c;
    private Player player;
    private boolean blocked;

    public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int getR() {
        return r;
    }

    @Override
    public int getC() {
        return c;
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
