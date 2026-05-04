package co.edu.uptc.model;

public class Ball {

    private double x, y;
    private double angle;
    private double speed;
    private int size;

    public Ball(int initialX, int initialY, int size, double angle, double speed) {
        this.x = initialX;
        this.y = initialY;
        this.angle = angle;
        this.speed = speed;
        this.size = size;
    }

    public void update(int width, int height) {
        double movimientoX = Math.cos(Math.toRadians(angle)) * speed;
        double movimientoY = Math.sin(Math.toRadians(angle)) * speed;

        x += movimientoX;
        y += movimientoY;

        if (x <= 0 || x + size >= width) {
            x = Math.max(0, Math.min(x, width - size));
            angle = 180 - angle; // Invertir horizontalmente
        }

        if (y <= 0 || y + size >= height) {
            y = Math.max(0, Math.min(y, height - size));
            angle = -angle; // Invertir verticalmente
        }
    }

    public void bounceOffPaddle(Paddle paddle) {

        double distanciaDesdeArriba = this.y - paddle.getY();
        double proporcion = distanciaDesdeArriba / paddle.getHeight();

        proporcion = Math.max(0, Math.min(1, proporcion));

        angle = -60 + (proporcion * 120);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDy() {
        return y;
    }

    public int getSize() {
        return size;
    }    
    
    public double getAngle() {
        return angle;
    }    
    public void setAngle(double angle) {
        this.angle = angle;
    }    

}
