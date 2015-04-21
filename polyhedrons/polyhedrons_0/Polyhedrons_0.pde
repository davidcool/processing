/*
Polyhedrons Demo 0

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public Polyhedron poly;
public float zoom = 0.025;
public int toggle = 0;

public void setup(){
  size(1000,1000,OPENGL);
  lights();
  smooth();
  frameRate(30);
  //Instantiate the object
  poly = new Dodecahedron();
  //Call some methods on the Dodecahedron object
  poly.fillColor(int(random(255)), int(random(255)), int(random(255)), 255);
  poly.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
} //end setup()

public void draw(){
  background(0);
  //camera(width/2, height/2, 300, width/2, height/2, 0, 0, 1, 0);
  pointLight(200, 200, 200, width/2, height/2, 200);
  ambientLight(102, 102, 102);
  spotLight(51, 102, 126, 80, 20, 40, -1, 0, 0, PI/2, 2);
  translate(width/2, height/2, 0);
  poly.rotate(radians(frameCount%360),radians(frameCount%360),0);
  poly.render();
} //end draw()

public void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -5, 5, 0.01, -0.01);
  zoom = constrain(zoom, 0.001, 0.2);
}