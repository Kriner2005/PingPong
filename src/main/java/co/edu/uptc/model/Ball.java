package co.edu.uptc.model;

public class Ball {

    private int x, y;
    private int dx, dy;
    private int size;

    public Ball(int initialX, int initialY, int size, int dx, int dy) {
        this.x = initialX;
        this.y = initialY;
        this.dx = dx;
        this.dy = dy;
        this.size = size;
    }

    public void update(int width, int height) {
        x += dx;
        y += dy;

        if (x < 0 || x + size >= width) {
            x = Math.max(0, Math.min(x, width));
            dx = -dx;
        }

        if (y < 0 || y + size >= height) {
            y = Math.max(0, Math.min(y, height));
            dy = -dy;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

}
