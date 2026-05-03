package co.edu.uptc.model;

public class Paddle {
    private int x, y;
    private int width, height;
    private int speed;

    public Paddle(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void moveUp(int panelHeight) {
        y = Math.max(0, y - speed);
    }

    public void moveDown(int panelHeight) {
        y = Math.min(panelHeight - this.height, y + speed);
    }

    public boolean collidesWithBall(Ball ball) {

        return ball.getX() + ball.getSize() >= x &&
                ball.getX() <= x + width &&
                ball.getY() + ball.getSize() >= y &&
                ball.getY() <= y + height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
