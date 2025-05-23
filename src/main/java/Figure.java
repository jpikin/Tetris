public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int[][] getMatrix() {
        return matrix;
    }
    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    void left(){}
    void right(){}
    void up(){}
    void down(){}
    void rotate(){}
    void downMaximum(){}
    boolean isCurrentPositionAvailable(){
        return true;
    }
    void landed(){}
}
