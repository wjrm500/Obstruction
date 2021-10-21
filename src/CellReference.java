public class CellReference implements Cellular {
    private int r;
    private int c;

    public CellReference(int r, int c) {
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
}
