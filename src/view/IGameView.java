
package view;

import javafx.geometry.Bounds;

public interface IGameView {
    public void animationLoop();
    public void outOfSpace();
    public void remove();
    public Bounds getBounds();
    public void flicker();
    public void stopFlicker();
    public void moveElementBy(int dx, int dy);
    public void moveElementTo(double x, double y);
    public void fire(int direction);
    public void set(int x, int y);
    public void setSound(boolean value);
    public int getHashId();
    public String getType();
    public boolean intersect(GameView b);
}
