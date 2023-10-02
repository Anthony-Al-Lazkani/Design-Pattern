package BridgeImplementation;
interface DrawingAPI{
    public void drawCircle(double x, double y, double radius);
}

class DrawingAPI1 implements DrawingAPI{
    public void drawCircle(double x, double y, double radius){
        System.out.println("API1.circle at "+x+","+y+" radius "+radius);
    }

}   
class DrawingAPI2 implements DrawingAPI{
    public void drawCircle(double x, double y, double radius){
        System.out.println("API2.circle at "+x+","+y+" radius "+radius);
    }
}
class DrawingAPI3 implements DrawingAPI{
    public void drawCircle(double x, double y, double radius){
        System.out.println("API3.circle at "+x+","+y+" radius "+radius);
    }
}

interface Shape{
    public void draw();
    public void resizeByPercentage(double pct);
}
class CircleShape implements Shape{
    private double x,y,radius;
    private DrawingAPI drawingAPI;
    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.drawingAPI=drawingAPI;
    }
    public void draw(){
        drawingAPI.drawCircle(x,y,radius);
    }
    public void resizeByPercentage(double pct){
        radius*=pct;
    }
}
public class BridgePattern{
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new CircleShape(1,2,3,new DrawingAPI1());
        shapes[1]=new CircleShape(5,7,11,new DrawingAPI2());
        shapes[2]=new CircleShape(9,10,13,new DrawingAPI3());

        for( Shape shape:shapes){
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }}
        