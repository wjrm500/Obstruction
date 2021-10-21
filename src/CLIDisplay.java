import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIDisplay implements Displayable {
    public void displayGrid(Grid grid) {
        // Print alphabetic column names
        System.out.print(' ');
        for (int i = 97; i < 97 + grid.getWidth(); i++) {
            char c = (char) i;
            System.out.print(String.format("  %c  ", c));
        }
        System.out.print('\n');
        int i = 1;
        for (Cell[] cellRow : grid.getCells()) {
            System.out.print(i); i++;
            for (Cell cell : cellRow) {
                char symbol = '·';
                Player player = cell.getPlayer();
                if (player != null) {
                    symbol = player.getSymbol();
                } else {
                    if (cell.isBlocked()) {
                        symbol = '#';
                    }
                }
                System.out.print(String.format("  %c  ", symbol));
            }
            System.out.println('\n');
        }
    }

    public CellReference getCellReference(Player player) {
        System.out.println(String.format("%s - it's your turn. Input a cell reference like \"1,a\" or \"2,b\"", player.name()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (input.matches("\\d,[a-z]")) {
            String[] splits = input.split(",");
            int rowNum = Integer.parseInt(splits[0]) - 1;
            char col = splits[1].charAt(0);
            int colNum = (int) col - 97;
            return new CellReference(rowNum, colNum);
        }
        return null;
    }

    @Override
    public void notifyInvalidInput() {
        System.out.println("Invalid input detected. Please try harder!");
    }

    @Override
    public void notifyWinner(Player player) {
        System.out.println(String.format("%s won!", player.name()));
    }
}
