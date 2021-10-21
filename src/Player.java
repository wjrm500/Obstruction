public class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String name() {
        return String.format("Player %c", symbol);
    }
}
