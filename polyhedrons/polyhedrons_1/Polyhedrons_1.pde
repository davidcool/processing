/*
Polyhedrons Demo 1

press spacebar to clear and generate new

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public int numPoly = 10;

Polyhedron newPoly;
public float zoom = 0.025;
public ArrayList<Polyhedron> polyhedrons = new ArrayList<Polyhedron>();

public void setup(){
  size(1000,1000,OPENGL);
  lights();
  smooth();
  frameRate(30);
  background(0);
  
  for (int count = 0; count < numPoly; count++) {
    newPoly = new Dodecahedron();
    newPoly.position(int(random(300,width-300)),int(random(300,height-300)),int(random(-500,500)));
    newPoly.scaleFactor(int(random(50,4000)));
    newPoly.fillColor(int(random(255)), int(random(255)), int(random(255)), 255);
    newPoly.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
    polyhedrons.add(newPoly);   
  }
} //end setup()

public void draw(){
  background(0);
  pushMatrix();
    //camera(width/2, height/2, 300, width/2, height/2, 0, 0, 1, 0);
    //pointLight(200, 200, 200, width/2, height/2, 200);
    translate(width/2, height/2, 0);
  popMatrix();
 
  for (Polyhedron p: polyhedrons) {
    pushMatrix();
      p.rotate(radians(random(0,0.05)+frameCount%360),radians(random(0,0.05)+frameCount%360),0);
      p.render();
    popMatrix();
  }
} //end draw()

public void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -5, 5, 0.01, -0.01);
  zoom = constrain(zoom, 0.001, 0.2);
}

public void keyPressed() {
  if (key == ' ') {
    polyhedrons.clear();
    setup();
  }
}