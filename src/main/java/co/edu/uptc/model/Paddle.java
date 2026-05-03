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

    public void moveUp(int height) {
        if (y > 0)
            y -= speed;
    }

    public void moveDown(int height) {
        if (y > 0)
            y += speed;
    }

    public boolean collidesWithBall(Ball ball) {
        boolean control = false;
        control = ball.getX() + ball.getSize() >= x && ball.getX() <= x + width && ball.getY() + ball.getSize() >= y && ball.getY() <= y + height;
        return control;
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
