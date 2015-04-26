/*
Sketch for testing new classes

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public TriakisTetrahedron poly;
public float zoom = 0.025;
public int toggle = 0;
public PFont f;

public void setup(){
  size(1000,1000,OPENGL);
  lights();
  smooth();
  frameRate(30);
  f = createFont("Arial",24,true);
  textFont(f,24);
  textAlign(CENTER);
  //Instantiate the object
  poly = new TriakisTetrahedron();
  //Call some methods on the TetradyakisHexahedron object
  poly.fillColor(int(random(255)), int(random(255)), int(random(255)), 255);
  poly.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
} //end setup()

public void draw(){
  background(0);
  pointLight(200, 200, 200, width/2, height/2, 500);
  ambientLight(102, 102, 102);
  spotLight(51, 102, 126, 80, 20, 40, -1, 0, 0, PI/2, 2);
  translate(width/2, height/2, 0);
  if (mousePressed) {
    poly.rotate(mouseX/100., mouseY/100., 0);
  } else {
    poly.rotate(radians(frameCount%360),radians(frameCount%360),0);
  }
  poly.strokeColorWeight(0.003);
  poly.render();
  text(poly.name(),0,400);
} //end draw()

public void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -5, 5, 0.01, -0.01);
  zoom = constrain(zoom, 0.001, 0.2);
}

public void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      poly.fillColor(int(random(255)), int(random(255)), int(random(255)), 255);
      poly.noStrokeToggle(false);
      poly.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
      poly.strokeColorWeight(0.005);
    }
    if (keyCode == DOWN) {
      poly.noFillToggle(true);
      poly.noStrokeToggle(false);
      poly.strokeColorWeight(0.01);      
    } 
  }
  if (key == ' ') {        
    poly.noFillToggle(false);
    poly.noStrokeToggle(true);
  }
}