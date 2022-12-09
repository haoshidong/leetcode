package 每日一题;

public class p1812_squareIsWhite {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + coordinates.charAt(1)) % 2 == 0;
        /*char x = coordinates.charAt(0);
        char y = coordinates.charAt(1);
        return (x - 'a') % 2 == 0 ? y % 2 == 0 : y % 2 == 1;*/
    }
}
