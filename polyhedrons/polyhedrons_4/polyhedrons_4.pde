/*
polyhedrons 3

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes

April, 2015

based on:
Spherical Coordinates Tutorial File
April, 2008
blprnt@blprnt.com
*/

//import processing.opengl.*; // not needed for processing 3 ???
import java.util.*;

float zoom = 0.025;
boolean toggle = true;
ArrayList<Sphere> spheres = new ArrayList<Sphere>();
PFont f;

void setup() {
  //code here is executed once, when the app initializes
  size(displayWidth,displayHeight,OPENGL);
  smooth();
  lights();
  background(0);
  frameRate(15);
  noCursor();
  //create an instance of the Sphere Class
  for (int i = 0; i < 5; i++) {
    spheres.add(new Sphere());
    spheres.get(i).radius = 200;
  }
  f = createFont("Arial",16,true);
};

void draw() {
  noCursor();
  background(0);
  pointLight(200, 200, 200, width/2, height/2, 200);
  ambientLight(102, 102, 102);
  spotLight(51, 102, 126, 80, 20, 40, -1, 0, 0, PI/2, 2);
  for (Sphere s: spheres) {
    pushMatrix();
    s.update();
    s.render();
    popMatrix();
  }
  if (toggle) {
    textFont(f,24); 
    fill(255);
    textAlign(CENTER);
    text("Left click to add polyhedrons, right click to destroy!",width/2,height/2 - 25);
    text("Use the mouse wheel or trackpad up/down scroll to zoom.",width/2,height/2 + 25);
  }
};

void mousePressed() {
  if (mouseButton == LEFT) {
    toggle = false;
    spheres.get(0).addSphereItem("StellatedTruncatedHexahedron");
    spheres.get(1).addSphereItem("TruncatedGreatDodecahedron");
    spheres.get(2).addSphereItem("SmallStellatedTruncatedDodecahedron");
    spheres.get(3).addSphereItem("GreatStellatedTruncatedDodecahedron");
    spheres.get(4).addSphereItem("TruncatedGreatIcosahedron");
  } else if (mouseButton == RIGHT) {
    spheres.get(0).removeSphereItem();
    spheres.get(1).removeSphereItem();
    spheres.get(2).removeSphereItem();
    spheres.get(3).removeSphereItem();
    spheres.get(4).removeSphereItem();
  }

};

void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -10, 10, 0.001, -0.001);
  zoom = constrain(zoom, 0.00001, 1.5);
};

void keyPressed() {
  if (key == ' ') {
    spheres.clear();
    setup();
  }
  if (key == CODED) {
    if (keyCode == LEFT) {
    } 
    if (keyCode == RIGHT) {
    }
    if (keyCode == UP) {
    } 
  }
};