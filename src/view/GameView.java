/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.Controller;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

/**
 *
 * @author gabri
 */
public class GameView implements IGameView{
    protected static boolean sound = true;
    protected Image imageNormal;
    protected Image imageFlicker;
    protected ImageView imageDisplayed;
    protected AudioClip fireSound;
    protected int a;
    private int b;
    private int hashId;
    private String type;
    private boolean flicker;
    
    public GameView(int id, String typ){
        a=0;b=0;
        hashId = id;
        type = typ;
        flicker = false;
    }
   
    public void animationLoop(){
        
    }


    public void outOfSpace() {
        if(this.imageDisplayed.getBoundsInParent().getMaxX()<=-20 || this.imageDisplayed.getBoundsInParent().getMinX()>=820){
            this.remove();
            View.getInstance().removeElementById(hashId);
        }
    }
    public void remove(){
        Space.getInstance().getChildren().remove(imageDisplayed);
    }

    public Bounds getBounds() {
        return imageDisplayed.getBoundsInParent();
    }
    public void startFlicker(){
        flicker=true;
    }
    public void flicker(){
        if(a<15){
            imageDisplayed.setImage(imageFlicker);
            a++;
        }
        if(a == 15 && b<15){
            imageDisplayed.setImage(imageNormal);
            b++;
        }
        if(a==15 && b == 15){
            a=0;
            b=0;
        }
            
    }
    public void stopFlicker(){
        imageDisplayed.setImage(imageNormal);
        a=0;b=0;
        flicker = false;
    }
     public void moveElementBy(int dx, int dy){
        if(dx == 0 && dy == 0) return;        
        final double cx = this.getBounds().getWidth()/2;
        final double cy = this.getBounds().getHeight()/2;
        
        double x = cx + imageDisplayed.getLayoutX() + dx;
        double y = cy + imageDisplayed.getLayoutY() + dy;
        moveElementTo(x,y);
    }
    public void moveElementTo(double x, double y){
        final double cx = this.getBounds().getWidth() /2;
        final double cy = this.getBounds().getHeight() / 2;
        if( x - cx >= 0 && 
            x + cx <= 800 &&
            y - cy >= 0 &&
            y + cy <= 400)
            imageDisplayed.relocate(x - cx,y - cy);            
    }
    public void fire(int direction){
        int x;
        int y; 
        if(direction >0){
            x = (int)this.getBounds().getMaxX()+1;
            y = (int)(this.getBounds().getMaxY()-this.getBounds().getHeight()/2);
            int id = Controller.getInstance().addElement("ProjectileDx");
            GameView p = View.getInstance().getElementById(id);
            p.set(x, y);
            System.out.println("view.GameView.fire()");
        }
        else{
            if(direction == -5){
            x = (int)this.getBounds().getMinX()- 110;
            y = (int)(this.getBounds().getMaxY()- this.getBounds().getHeight()/2);
            int id = Controller.getInstance().addElement("ProjectileSx");
            GameView p = View.getInstance().getElementById(id);
            p.set(x, y);
            }else
            if(direction ==-1){
            x = (int)this.getBounds().getMinX()- 20;
            y = (int)(this.getBounds().getMaxY()- this.getBounds().getHeight()/2);
             int id = Controller.getInstance().addElement("ProjectileSx1");
            GameView p = View.getInstance().getElementById(id);
            p.set(x, y);  
            }
        }
            
 
    }
    public void set(int x, int y){
        this.imageDisplayed.relocate(x, y);
    }
    public void stopBackground(){}
    public void setSound(boolean value){
        sound = value;
    }

    public void setBackground(int i) {
    }
    public int getHashId(){
        return hashId;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean intersect(GameView b) {
        return this.getBounds().intersects(b.getBounds());
    }
    public void setHashId(int id){
        this.hashId= id;
    }

    public void loop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void collide(){
        Controller.getInstance().collide(this.hashId);
    }
}
