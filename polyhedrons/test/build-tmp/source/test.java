import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class test extends PApplet {

/*
Sketch for testing new classes

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public UniformGreatRhombicosidodecahedron poly;
public float zoom = 0.025f;
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
  poly = new UniformGreatRhombicosidodecahedron();
  //Call some methods on the TetradyakisHexahedron object
  poly.fillColor(PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), 255);
  poly.strokeColor(PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), 255);
} //end setup()

public void draw(){
  background(0);
  pointLight(200, 200, 200, width/2, height/2, 500);
  ambientLight(102, 102, 102);
  spotLight(51, 102, 126, 80, 20, 40, -1, 0, 0, PI/2, 2);
  translate(width/2, height/2, 0);
  if (mousePressed) {
    poly.rotate(mouseX/100.f, mouseY/100.f, 0);
  } else {
    poly.rotate(radians(frameCount%360),radians(frameCount%360),0);
  }
  poly.strokeColorWeight(0.003f);
  poly.render();
  text(poly.name(),0,400);
} //end draw()

public void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -5, 5, 0.01f, -0.01f);
  zoom = constrain(zoom, 0.001f, 0.2f);
}

public void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      poly.fillColor(PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), 255);
      poly.noStrokeToggle(false);
      poly.strokeColor(PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), 255);
      poly.strokeColorWeight(0.005f);
    }
    if (keyCode == DOWN) {
      poly.noFillToggle(true);
      poly.noStrokeToggle(false);
      poly.strokeColorWeight(0.01f);      
    } 
  }
  if (key == ' ') {        
    poly.noFillToggle(false);
    poly.noStrokeToggle(true);
  }
}
/*
GreatCubicuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatCubicuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 0.2071067811865475244008443621048f; //(sqrt(2) - 1) / 2
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatCubicuboctahedron() {   
    // set vertices
    vert[  0] = new PVector( -0.5f, -0.5f,   C0 );
    vert[  1] = new PVector( -0.5f, -0.5f,  -C0 );
    vert[  2] = new PVector( -0.5f,  0.5f,   C0 );
    vert[  3] = new PVector( -0.5f,  0.5f,  -C0 );
    vert[  4] = new PVector(  0.5f, -0.5f,   C0 );
    vert[  5] = new PVector(  0.5f, -0.5f,  -C0 );
    vert[  6] = new PVector(  0.5f,  0.5f,   C0 );
    vert[  7] = new PVector(  0.5f,  0.5f,  -C0 );
    vert[  8] = new PVector(   C0, -0.5f, -0.5f );
    vert[  9] = new PVector(   C0, -0.5f,  0.5f );
    vert[ 10] = new PVector(   C0,  0.5f, -0.5f );
    vert[ 11] = new PVector(   C0,  0.5f,  0.5f );
    vert[ 12] = new PVector(  -C0, -0.5f, -0.5f );
    vert[ 13] = new PVector(  -C0, -0.5f,  0.5f );
    vert[ 14] = new PVector(  -C0,  0.5f, -0.5f );
    vert[ 15] = new PVector(  -C0,  0.5f,  0.5f );
    vert[ 16] = new PVector( -0.5f,   C0, -0.5f );
    vert[ 17] = new PVector( -0.5f,   C0,  0.5f );
    vert[ 18] = new PVector( -0.5f,  -C0, -0.5f );
    vert[ 19] = new PVector( -0.5f,  -C0,  0.5f );
    vert[ 20] = new PVector(  0.5f,   C0, -0.5f );
    vert[ 21] = new PVector(  0.5f,   C0,  0.5f );
    vert[ 22] = new PVector(  0.5f,  -C0, -0.5f );
    vert[ 23] = new PVector(  0.5f,  -C0,  0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  2, 18, 19,  3,  1, 17, 16 };
    faces[ 1] = new int[] {  0,  8,  9,  1,  5, 13, 12,  4 };
    faces[ 2] = new int[] { 11, 10,  2,  6, 14, 15,  7,  3 };
    faces[ 3] = new int[] { 11, 19, 23, 15, 13, 21, 17,  9 };
    faces[ 4] = new int[] { 20, 12, 14, 22, 18, 10,  8, 16 };
    faces[ 5] = new int[] { 20, 21,  5,  7, 23, 22,  6,  4 };
    faces[ 6] = new int[] {  0,  4,  6,  2,  2,  2,  2,  2 };  //repeated 4x 4th number to fill gap
    faces[ 7] = new int[] {  1,  3,  7,  5,  5,  5,  5,  5 };  //repeated 4x 4th number to fill gap
    faces[ 8] = new int[] {  8, 10, 11,  9,  9,  9,  9,  9 };  //repeated 4x 4th number to fill gap
    faces[ 9] = new int[] { 12, 13, 15, 14, 14, 14, 14, 14 };  //repeated 4x 4th number to fill gap
    faces[10] = new int[] { 16, 17, 21, 20, 20, 20, 20, 20 };  //repeated 4x 4th number to fill gap
    faces[11] = new int[] { 18, 22, 23, 19, 19, 19, 19, 19 };  //repeated 4x 4th number to fill gap
    faces[12] = new int[] {  0, 16,  8,  8,  8,  8,  8,  8 };  //repeated 5x 3rd number to fill gap
    faces[13] = new int[] {  1,  9, 17, 17, 17, 17, 17, 17 };  //repeated 5x 3rd number to fill gap
    faces[14] = new int[] {  2, 10, 18, 18, 18, 18, 18, 18 };  //repeated 5x 3rd number to fill gap
    faces[15] = new int[] {  3, 19, 11, 11, 11, 11, 11, 11 };  //repeated 5x 3rd number to fill gap
    faces[16] = new int[] {  4, 12, 20, 20, 20, 20, 20, 20 };  //repeated 5x 3rd number to fill gap
    faces[17] = new int[] {  5, 21, 13, 13, 13, 13, 13, 13 };  //repeated 5x 3rd number to fill gap
    faces[18] = new int[] {  6, 22, 14, 14, 14, 14, 14, 14 };  //repeated 5x 3rd number to fill gap
    faces[19] = new int[] {  7, 15, 23, 23, 23, 23, 23, 23 };  //repeated 5x 3rd number to fill gap
  } //end GreatCubicuboctahedron()

  public String name() {
    return "Great Cubicuboctahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class GreatCubicuboctahedron
/*
GreatDitrigonalDodecicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDitrigonalDodecicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f;  //(3 - sqrt(5)) / 4
  final float C1 = 0.618033988749894848204586834366f;  //(sqrt(5) - 1) / 2
  final float C2 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437f;   //sqrt(5) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDitrigonalDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C2, -0.5f,   C1 );
    vert[  1] = new PVector(   C2, -0.5f,  -C1 );
    vert[  2] = new PVector(  -C2, -0.5f,   C1 );
    vert[  3] = new PVector(  -C2, -0.5f,  -C1 );
    vert[  4] = new PVector(   C2,  0.5f,   C1 );
    vert[  5] = new PVector(   C2,  0.5f,  -C1 );
    vert[  6] = new PVector(  -C2,  0.5f,   C1 );
    vert[  7] = new PVector(  -C2,  0.5f,  -C1 );
    vert[  8] = new PVector( -0.5f,   C1,   C2 );
    vert[  9] = new PVector( -0.5f,   C1,  -C2 );
    vert[ 10] = new PVector(  0.5f,   C1,   C2 );
    vert[ 11] = new PVector(  0.5f,   C1,  -C2 );
    vert[ 12] = new PVector( -0.5f,  -C1,   C2 );
    vert[ 13] = new PVector( -0.5f,  -C1,  -C2 );
    vert[ 14] = new PVector(  0.5f,  -C1,   C2 );
    vert[ 15] = new PVector(  0.5f,  -C1,  -C2 );
    vert[ 16] = new PVector(   C1,   C2, -0.5f );
    vert[ 17] = new PVector(   C1,   C2,  0.5f );
    vert[ 18] = new PVector(  -C1,   C2, -0.5f );
    vert[ 19] = new PVector(  -C1,   C2,  0.5f );
    vert[ 20] = new PVector(   C1,  -C2, -0.5f );
    vert[ 21] = new PVector(   C1,  -C2,  0.5f );
    vert[ 22] = new PVector(  -C1,  -C2, -0.5f );
    vert[ 23] = new PVector(  -C1,  -C2,  0.5f );
    vert[ 24] = new PVector(   C3,  0.0f,  -C0 );
    vert[ 25] = new PVector(   C3,  0.0f,   C0 );
    vert[ 26] = new PVector(  -C3,  0.0f,  -C0 );
    vert[ 27] = new PVector(  -C3,  0.0f,   C0 );
    vert[ 28] = new PVector(  0.0f,  -C0,   C3 );
    vert[ 29] = new PVector(  0.0f,  -C0,  -C3 );
    vert[ 30] = new PVector(  0.0f,   C0,   C3 );
    vert[ 31] = new PVector(  0.0f,   C0,  -C3 );
    vert[ 32] = new PVector(  -C0,   C3,  0.0f );
    vert[ 33] = new PVector(   C0,   C3,  0.0f );
    vert[ 34] = new PVector(  -C0,  -C3,  0.0f );
    vert[ 35] = new PVector(   C0,  -C3,  0.0f );
    vert[ 36] = new PVector( -0.5f, -1.0f,  -C0 );
    vert[ 37] = new PVector( -0.5f, -1.0f,   C0 );
    vert[ 38] = new PVector(  0.5f, -1.0f,  -C0 );
    vert[ 39] = new PVector(  0.5f, -1.0f,   C0 );
    vert[ 40] = new PVector( -0.5f,  1.0f,  -C0 );
    vert[ 41] = new PVector( -0.5f,  1.0f,   C0 );
    vert[ 42] = new PVector(  0.5f,  1.0f,  -C0 );
    vert[ 43] = new PVector(  0.5f,  1.0f,   C0 );
    vert[ 44] = new PVector( -1.0f,  -C0, -0.5f );
    vert[ 45] = new PVector( -1.0f,  -C0,  0.5f );
    vert[ 46] = new PVector(  1.0f,  -C0, -0.5f );
    vert[ 47] = new PVector(  1.0f,  -C0,  0.5f );
    vert[ 48] = new PVector( -1.0f,   C0, -0.5f );
    vert[ 49] = new PVector( -1.0f,   C0,  0.5f );
    vert[ 50] = new PVector(  1.0f,   C0, -0.5f );
    vert[ 51] = new PVector(  1.0f,   C0,  0.5f );
    vert[ 52] = new PVector(  -C0, -0.5f, -1.0f );
    vert[ 53] = new PVector(  -C0, -0.5f,  1.0f );
    vert[ 54] = new PVector(   C0, -0.5f, -1.0f );
    vert[ 55] = new PVector(   C0, -0.5f,  1.0f );
    vert[ 56] = new PVector(  -C0,  0.5f, -1.0f );
    vert[ 57] = new PVector(  -C0,  0.5f,  1.0f );
    vert[ 58] = new PVector(   C0,  0.5f, -1.0f );
    vert[ 59] = new PVector(   C0,  0.5f,  1.0f );
    // set faces
    faces[ 0] = new int[] {  0,  4, 30, 14, 51, 59, 55, 47, 10, 28 };
    faces[ 1] = new int[] {  0, 38, 46, 47, 39,  1, 25, 21, 20, 24 };
    faces[ 2] = new int[] {  2, 26, 22, 23, 27,  3, 37, 45, 44, 36 };
    faces[ 3] = new int[] {  2, 28,  8, 45, 53, 57, 49, 12, 30,  6 };
    faces[ 4] = new int[] {  5,  1, 29, 11, 46, 54, 58, 50, 15, 31 };
    faces[ 5] = new int[] {  5, 43, 51, 50, 42,  4, 24, 16, 17, 25 };
    faces[ 6] = new int[] {  7, 27, 19, 18, 26,  6, 40, 48, 49, 41 };
    faces[ 7] = new int[] {  7, 31, 13, 48, 56, 52, 44,  9, 29,  3 };
    faces[ 8] = new int[] { 33, 11,  9, 32, 16, 56, 40, 42, 58, 18 };
    faces[ 9] = new int[] { 33, 19, 59, 43, 41, 57, 17, 32,  8, 10 };
    faces[10] = new int[] { 34, 13, 15, 35, 22, 54, 38, 36, 52, 20 };
    faces[11] = new int[] { 34, 21, 53, 37, 39, 55, 23, 35, 14, 12 };
    faces[12] = new int[] { 24, 20, 52, 56, 16, 16, 16, 16, 16, 16 };  // repated 5x 5th number to fill gap
    faces[13] = new int[] { 25, 17, 57, 53, 21, 21, 21, 21, 21, 21 };  // repated 5x 5th number to fill gap
    faces[14] = new int[] { 26, 18, 58, 54, 22, 22, 22, 22, 22, 22 };  // repated 5x 5th number to fill gap
    faces[15] = new int[] { 27, 23, 55, 59, 19, 19, 19, 19, 19, 19 };  // repated 5x 5th number to fill gap
    faces[16] = new int[] { 28,  2, 36, 38,  0,  0,  0,  0,  0,  0 };  // repated 5x 5th number to fill gap
    faces[17] = new int[] { 29,  1, 39, 37,  3,  3,  3,  3,  3,  3 };  // repated 5x 5th number to fill gap
    faces[18] = new int[] { 30,  4, 42, 40,  6,  6,  6,  6,  6,  6 };  // repated 5x 5th number to fill gap
    faces[19] = new int[] { 31,  7, 41, 43,  5,  5,  5,  5,  5,  5 };  // repated 5x 5th number to fill gap
    faces[20] = new int[] { 32,  9, 44, 45,  8,  8,  8,  8,  8,  8 };  // repated 5x 5th number to fill gap
    faces[21] = new int[] { 33, 10, 47, 46, 11, 11, 11, 11, 11, 11 };  // repated 5x 5th number to fill gap
    faces[22] = new int[] { 34, 12, 49, 48, 13, 13, 13, 13, 13, 13 };  // repated 5x 5th number to fill gap
    faces[23] = new int[] { 35, 15, 50, 51, 14, 14, 14, 14, 14, 14 };  // repated 5x 5th number to fill gap
    faces[24] = new int[] { 24,  4,  0,  0,  0,  0,  0,  0,  0,  0 };  // repated 7x 3rd number to fill gap
    faces[25] = new int[] { 25,  1,  5,  5,  5,  5,  5,  5,  5,  5 };  // repated 7x 3rd number to fill gap
    faces[26] = new int[] { 26,  2,  6,  6,  6,  6,  6,  6,  6,  6 };  // repated 7x 3rd number to fill gap
    faces[27] = new int[] { 27,  7,  3,  3,  3,  3,  3,  3,  3,  3 };  // repated 7x 3rd number to fill gap
    faces[28] = new int[] { 28, 10,  8,  8,  8,  8,  8,  8,  8,  8 };  // repated 7x 3rd number to fill gap
    faces[29] = new int[] { 29,  9, 11, 11, 11, 11, 11, 11, 11, 11 };  // repated 7x 3rd number to fill gap
    faces[30] = new int[] { 30, 12, 14, 14, 14, 14, 14, 14, 14, 14 };  // repated 7x 3rd number to fill gap
    faces[31] = new int[] { 31, 15, 13, 13, 13, 13, 13, 13, 13, 13 };  // repated 7x 3rd number to fill gap
    faces[32] = new int[] { 32, 17, 16, 16, 16, 16, 16, 16, 16, 16 };  // repated 7x 3rd number to fill gap
    faces[33] = new int[] { 33, 18, 19, 19, 19, 19, 19, 19, 19, 19 };  // repated 7x 3rd number to fill gap
    faces[34] = new int[] { 34, 20, 21, 21, 21, 21, 21, 21, 21, 21 };  // repated 7x 3rd number to fill gap
    faces[35] = new int[] { 35, 23, 22, 22, 22, 22, 22, 22, 22, 22 };  // repated 7x 3rd number to fill gap
    faces[36] = new int[] { 36, 44, 52, 52, 52, 52, 52, 52, 52, 52 };  // repated 7x 3rd number to fill gap
    faces[37] = new int[] { 37, 53, 45, 45, 45, 45, 45, 45, 45, 45 };  // repated 7x 3rd number to fill gap
    faces[38] = new int[] { 38, 54, 46, 46, 46, 46, 46, 46, 46, 46 };  // repated 7x 3rd number to fill gap
    faces[39] = new int[] { 39, 47, 55, 55, 55, 55, 55, 55, 55, 55 };  // repated 7x 3rd number to fill gap
    faces[40] = new int[] { 40, 56, 48, 48, 48, 48, 48, 48, 48, 48 };  // repated 7x 3rd number to fill gap
    faces[41] = new int[] { 41, 49, 57, 57, 57, 57, 57, 57, 57, 57 };  // repated 7x 3rd number to fill gap
    faces[42] = new int[] { 42, 50, 58, 58, 58, 58, 58, 58, 58, 58 };  // repated 7x 3rd number to fill gap
    faces[43] = new int[] { 43, 59, 51, 51, 51, 51, 51, 51, 51, 51 };  // repated 7x 3rd number to fill gap
  } //end GreatDitrigonalDodecicosidodecahedron()

  public String name() {
    return "Great Ditrigonal Dodecicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class GreatDitrigonalDodecicosidodecahedron
/*
GreatDodecicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDodecicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.118033988749894848204586834366f;  //(sqrt(5) - 2) / 2
  final float C1 = 0.190983005625052575897706582817f;  //(3 - sqrt(5)) / 4
  final float C2 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C3 = 0.618033988749894848204586834366f;  //(sqrt(5) - 1) / 2
  final float C4 = 0.690983005625052575897706582817f;  //(5 - sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector( -0.5f, -0.5f,   C0 );
    vert[  1] = new PVector( -0.5f, -0.5f,  -C0 );
    vert[  2] = new PVector(  0.5f, -0.5f,   C0 );
    vert[  3] = new PVector(  0.5f, -0.5f,  -C0 );
    vert[  4] = new PVector( -0.5f,  0.5f,   C0 );
    vert[  5] = new PVector( -0.5f,  0.5f,  -C0 );
    vert[  6] = new PVector(  0.5f,  0.5f,   C0 );
    vert[  7] = new PVector(  0.5f,  0.5f,  -C0 );
    vert[  8] = new PVector( -0.5f,   C0, -0.5f );
    vert[  9] = new PVector( -0.5f,   C0,  0.5f );
    vert[ 10] = new PVector(  0.5f,   C0, -0.5f );
    vert[ 11] = new PVector(  0.5f,   C0,  0.5f );
    vert[ 12] = new PVector( -0.5f,  -C0, -0.5f );
    vert[ 13] = new PVector( -0.5f,  -C0,  0.5f );
    vert[ 14] = new PVector(  0.5f,  -C0, -0.5f );
    vert[ 15] = new PVector(  0.5f,  -C0,  0.5f );
    vert[ 16] = new PVector(   C0, -0.5f, -0.5f );
    vert[ 17] = new PVector(   C0, -0.5f,  0.5f );
    vert[ 18] = new PVector(  -C0, -0.5f, -0.5f );
    vert[ 19] = new PVector(  -C0, -0.5f,  0.5f );
    vert[ 20] = new PVector(   C0,  0.5f, -0.5f );
    vert[ 21] = new PVector(   C0,  0.5f,  0.5f );
    vert[ 22] = new PVector(  -C0,  0.5f, -0.5f );
    vert[ 23] = new PVector(  -C0,  0.5f,  0.5f );
    vert[ 24] = new PVector(  -C1,  0.0f,  -C4 );
    vert[ 25] = new PVector(  -C1,  0.0f,   C4 );
    vert[ 26] = new PVector(   C1,  0.0f,  -C4 );
    vert[ 27] = new PVector(   C1,  0.0f,   C4 );
    vert[ 28] = new PVector(  0.0f,  -C4,  -C1 );
    vert[ 29] = new PVector(  0.0f,  -C4,   C1 );
    vert[ 30] = new PVector(  0.0f,   C4,  -C1 );
    vert[ 31] = new PVector(  0.0f,   C4,   C1 );
    vert[ 32] = new PVector(  -C4,  -C1,  0.0f );
    vert[ 33] = new PVector(   C4,  -C1,  0.0f );
    vert[ 34] = new PVector(  -C4,   C1,  0.0f );
    vert[ 35] = new PVector(   C4,   C1,  0.0f );
    vert[ 36] = new PVector(   C2,  -C1,   C3 );
    vert[ 37] = new PVector(   C2,  -C1,  -C3 );
    vert[ 38] = new PVector(  -C2,  -C1,   C3 );
    vert[ 39] = new PVector(  -C2,  -C1,  -C3 );
    vert[ 40] = new PVector(   C2,   C1,   C3 );
    vert[ 41] = new PVector(   C2,   C1,  -C3 );
    vert[ 42] = new PVector(  -C2,   C1,   C3 );
    vert[ 43] = new PVector(  -C2,   C1,  -C3 );
    vert[ 44] = new PVector(  -C1,   C3,   C2 );
    vert[ 45] = new PVector(  -C1,   C3,  -C2 );
    vert[ 46] = new PVector(   C1,   C3,   C2 );
    vert[ 47] = new PVector(   C1,   C3,  -C2 );
    vert[ 48] = new PVector(  -C1,  -C3,   C2 );
    vert[ 49] = new PVector(  -C1,  -C3,  -C2 );
    vert[ 50] = new PVector(   C1,  -C3,   C2 );
    vert[ 51] = new PVector(   C1,  -C3,  -C2 );
    vert[ 52] = new PVector(   C3,   C2,  -C1 );
    vert[ 53] = new PVector(   C3,   C2,   C1 );
    vert[ 54] = new PVector(  -C3,   C2,  -C1 );
    vert[ 55] = new PVector(  -C3,   C2,   C1 );
    vert[ 56] = new PVector(   C3,  -C2,  -C1 );
    vert[ 57] = new PVector(   C3,  -C2,   C1 );
    vert[ 58] = new PVector(  -C3,  -C2,  -C1 );
    vert[ 59] = new PVector(  -C3,  -C2,   C1 );
    // set faces
    faces[ 0] = new int[] {  0, 24, 56, 48, 12, 14, 50, 58, 26,  2 };
    faces[ 1] = new int[] {  0, 36, 44, 32, 17, 21, 34, 48, 40,  4 };
    faces[ 2] = new int[] {  7,  3, 39, 47, 33, 18, 22, 35, 51, 43 };
    faces[ 3] = new int[] {  7,  5, 25, 53, 45,  9, 11, 47, 55, 27 };
    faces[ 4] = new int[] { 10,  8, 44, 52, 24,  4,  6, 26, 54, 46 };
    faces[ 5] = new int[] { 10, 11, 29, 37, 53, 17, 16, 52, 36, 28 };
    faces[ 6] = new int[] { 13, 31, 43, 59, 23, 22, 58, 42, 30, 12 };
    faces[ 7] = new int[] { 13, 49, 57, 25,  1,  3, 27, 59, 51, 15 };
    faces[ 8] = new int[] { 19, 33, 46, 38,  2,  6, 42, 50, 35, 23 };
    faces[ 9] = new int[] { 19, 55, 39, 29,  9,  8, 28, 38, 54, 18 };
    faces[10] = new int[] { 20, 16, 32, 45, 37,  1,  5, 41, 49, 34 };
    faces[11] = new int[] { 20, 21, 57, 41, 31, 15, 14, 30, 40, 56 };
    faces[12] = new int[] { 24, 52, 16, 20, 56, 56, 56, 56, 56, 56 };  // repated 5x 5th number to fill gap
    faces[13] = new int[] { 25, 57, 21, 17, 53, 53, 53, 53, 53, 53 };  // repated 5x 5th number to fill gap
    faces[14] = new int[] { 26, 58, 22, 18, 54, 54, 54, 54, 54, 54 };  // repated 5x 5th number to fill gap
    faces[15] = new int[] { 27, 55, 19, 23, 59, 59, 59, 59, 59, 59 };  // repated 5x 5th number to fill gap
    faces[16] = new int[] { 28, 36,  0,  2, 38, 38, 38, 38, 38, 38 };  // repated 5x 5th number to fill gap
    faces[17] = new int[] { 29, 39,  3,  1, 37, 37, 37, 37, 37, 37 };  // repated 5x 5th number to fill gap
    faces[18] = new int[] { 30, 42,  6,  4, 40, 40, 40, 40, 40, 40 };  // repated 5x 5th number to fill gap
    faces[19] = new int[] { 31, 41,  5,  7, 43, 43, 43, 43, 43, 43 };  // repated 5x 5th number to fill gap
    faces[20] = new int[] { 32, 44,  8,  9, 45, 45, 45, 45, 45, 45 };  // repated 5x 5th number to fill gap
    faces[21] = new int[] { 33, 47, 11, 10, 46, 46, 46, 46, 46, 46 };  // repated 5x 5th number to fill gap
    faces[22] = new int[] { 34, 49, 13, 12, 48, 48, 48, 48, 48, 48 };  // repated 5x 5th number to fill gap
    faces[23] = new int[] { 35, 50, 14, 15, 51, 51, 51, 51, 51, 51 };  // repated 5x 5th number to fill gap
    faces[24] = new int[] { 24,  0,  4,  4,  4,  4,  4,  4,  4,  4 };  // repated 7x 3rd number to fill gap
    faces[25] = new int[] { 25,  5,  1,  1,  1,  1,  1,  1,  1,  1 };  // repated 7x 3rd number to fill gap
    faces[26] = new int[] { 26,  6,  2,  2,  2,  2,  2,  2,  2,  2 };  // repated 7x 3rd number to fill gap
    faces[27] = new int[] { 27,  3,  7,  7,  7,  7,  7,  7,  7,  7 };  // repated 7x 3rd number to fill gap
    faces[28] = new int[] { 28,  8, 10, 10, 10, 10, 10, 10, 10, 10 };  // repated 7x 3rd number to fill gap
    faces[29] = new int[] { 29, 11,  9,  9,  9,  9,  9,  9,  9,  9 };  // repated 7x 3rd number to fill gap
    faces[30] = new int[] { 30, 14, 12, 12, 12, 12, 12, 12, 12, 12 };  // repated 7x 3rd number to fill gap
    faces[31] = new int[] { 31, 13, 15, 15, 15, 15, 15, 15, 15, 15 };  // repated 7x 3rd number to fill gap
    faces[32] = new int[] { 32, 16, 17, 17, 17, 17, 17, 17, 17, 17 };  // repated 7x 3rd number to fill gap
    faces[33] = new int[] { 33, 19, 18, 18, 18, 18, 18, 18, 18, 18 };  // repated 7x 3rd number to fill gap
    faces[34] = new int[] { 34, 21, 20, 20, 20, 20, 20, 20, 20, 20 };  // repated 7x 3rd number to fill gap
    faces[35] = new int[] { 35, 22, 23, 23, 23, 23, 23, 23, 23, 23 };  // repated 7x 3rd number to fill gap
    faces[36] = new int[] { 36, 52, 44, 44, 44, 44, 44, 44, 44, 44 };  // repated 7x 3rd number to fill gap
    faces[37] = new int[] { 37, 45, 53, 53, 53, 53, 53, 53, 53, 53 };  // repated 7x 3rd number to fill gap
    faces[38] = new int[] { 38, 46, 54, 54, 54, 54, 54, 54, 54, 54 };  // repated 7x 3rd number to fill gap
    faces[39] = new int[] { 39, 55, 47, 47, 47, 47, 47, 47, 47, 47 };  // repated 7x 3rd number to fill gap
    faces[40] = new int[] { 40, 48, 56, 56, 56, 56, 56, 56, 56, 56 };  // repated 7x 3rd number to fill gap
    faces[41] = new int[] { 41, 57, 49, 49, 49, 49, 49, 49, 49, 49 };  // repated 7x 3rd number to fill gap
    faces[42] = new int[] { 42, 58, 50, 50, 50, 50, 50, 50, 50, 50 };  // repated 7x 3rd number to fill gap
    faces[43] = new int[] { 43, 51, 59, 59, 59, 59, 59, 59, 59, 59 };  // repated 7x 3rd number to fill gap
  } //end GreatDodecicosidodecahedron()

  public String name() {
    return "Great Dodecicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class GreatDodecicosidodecahedron
/*
GreatIcosicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 52;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f;  //(3 - sqrt(5)) / 4
  final float C1 = 0.618033988749894848204586834366f;  //(sqrt(5) - 1) / 2
  final float C2 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437f;   //sqrt(5) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,   C0,   C3 );
    vert[  1] = new PVector(  0.0f,   C0,  -C3 );
    vert[  2] = new PVector(  0.0f,  -C0,   C3 );
    vert[  3] = new PVector(  0.0f,  -C0,  -C3 );
    vert[  4] = new PVector(   C3,  0.0f,   C0 );
    vert[  5] = new PVector(   C3,  0.0f,  -C0 );
    vert[  6] = new PVector(  -C3,  0.0f,   C0 );
    vert[  7] = new PVector(  -C3,  0.0f,  -C0 );
    vert[  8] = new PVector(   C0,   C3,  0.0f );
    vert[  9] = new PVector(   C0,  -C3,  0.0f );
    vert[ 10] = new PVector(  -C0,   C3,  0.0f );
    vert[ 11] = new PVector(  -C0,  -C3,  0.0f );
    vert[ 12] = new PVector(   C0,  0.5f,  1.0f );
    vert[ 13] = new PVector(   C0,  0.5f, -1.0f );
    vert[ 14] = new PVector(   C0, -0.5f,  1.0f );
    vert[ 15] = new PVector(   C0, -0.5f, -1.0f );
    vert[ 16] = new PVector(  -C0,  0.5f,  1.0f );
    vert[ 17] = new PVector(  -C0,  0.5f, -1.0f );
    vert[ 18] = new PVector(  -C0, -0.5f,  1.0f );
    vert[ 19] = new PVector(  -C0, -0.5f, -1.0f );
    vert[ 20] = new PVector(  1.0f,   C0,  0.5f );
    vert[ 21] = new PVector(  1.0f,   C0, -0.5f );
    vert[ 22] = new PVector(  1.0f,  -C0,  0.5f );
    vert[ 23] = new PVector(  1.0f,  -C0, -0.5f );
    vert[ 24] = new PVector( -1.0f,   C0,  0.5f );
    vert[ 25] = new PVector( -1.0f,   C0, -0.5f );
    vert[ 26] = new PVector( -1.0f,  -C0,  0.5f );
    vert[ 27] = new PVector( -1.0f,  -C0, -0.5f );
    vert[ 28] = new PVector(  0.5f,  1.0f,   C0 );
    vert[ 29] = new PVector(  0.5f,  1.0f,  -C0 );
    vert[ 30] = new PVector(  0.5f, -1.0f,   C0 );
    vert[ 31] = new PVector(  0.5f, -1.0f,  -C0 );
    vert[ 32] = new PVector( -0.5f,  1.0f,   C0 );
    vert[ 33] = new PVector( -0.5f,  1.0f,  -C0 );
    vert[ 34] = new PVector( -0.5f, -1.0f,   C0 );
    vert[ 35] = new PVector( -0.5f, -1.0f,  -C0 );
    vert[ 36] = new PVector(  0.5f,   C1,   C2 );
    vert[ 37] = new PVector(  0.5f,   C1,  -C2 );
    vert[ 38] = new PVector(  0.5f,  -C1,   C2 );
    vert[ 39] = new PVector(  0.5f,  -C1,  -C2 );
    vert[ 40] = new PVector( -0.5f,   C1,   C2 );
    vert[ 41] = new PVector( -0.5f,   C1,  -C2 );
    vert[ 42] = new PVector( -0.5f,  -C1,   C2 );
    vert[ 43] = new PVector( -0.5f,  -C1,  -C2 );
    vert[ 44] = new PVector(   C2,  0.5f,   C1 );
    vert[ 45] = new PVector(   C2,  0.5f,  -C1 );
    vert[ 46] = new PVector(   C2, -0.5f,   C1 );
    vert[ 47] = new PVector(   C2, -0.5f,  -C1 );
    vert[ 48] = new PVector(  -C2,  0.5f,   C1 );
    vert[ 49] = new PVector(  -C2,  0.5f,  -C1 );
    vert[ 50] = new PVector(  -C2, -0.5f,   C1 );
    vert[ 51] = new PVector(  -C2, -0.5f,  -C1 );
    vert[ 52] = new PVector(   C1,   C2,  0.5f );
    vert[ 53] = new PVector(   C1,   C2, -0.5f );
    vert[ 54] = new PVector(   C1,  -C2,  0.5f );
    vert[ 55] = new PVector(   C1,  -C2, -0.5f );
    vert[ 56] = new PVector(  -C1,   C2,  0.5f );
    vert[ 57] = new PVector(  -C1,   C2, -0.5f );
    vert[ 58] = new PVector(  -C1,  -C2,  0.5f );
    vert[ 59] = new PVector(  -C1,  -C2, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0, 42, 11, 55,  5, 44 };
    faces[ 1] = new int[] {  0, 48,  7, 59,  9, 38 };
    faces[ 2] = new int[] {  1, 39,  9, 58,  6, 49 };
    faces[ 3] = new int[] {  1, 45,  4, 54, 11, 43 };
    faces[ 4] = new int[] {  2, 36,  8, 57,  7, 50 };
    faces[ 5] = new int[] {  2, 46,  5, 53, 10, 40 };
    faces[ 6] = new int[] {  3, 41, 10, 52,  4, 47 };
    faces[ 7] = new int[] {  3, 51,  6, 56,  8, 37 };
    faces[ 8] = new int[] { 15, 13, 29, 44, 46, 31 };
    faces[ 9] = new int[] { 15, 23, 22, 14, 58, 59 };
    faces[10] = new int[] { 18, 16, 32, 49, 51, 34 };
    faces[11] = new int[] { 18, 26, 27, 19, 55, 54 };
    faces[12] = new int[] { 20, 21, 13, 57, 56, 12 };
    faces[13] = new int[] { 20, 28, 32, 24, 42, 38 };
    faces[14] = new int[] { 25, 24, 16, 52, 53, 17 };
    faces[15] = new int[] { 25, 33, 29, 21, 39, 43 };
    faces[16] = new int[] { 30, 22, 36, 40, 26, 34 };
    faces[17] = new int[] { 30, 47, 45, 28, 12, 14 };
    faces[18] = new int[] { 35, 27, 41, 37, 23, 31 };
    faces[19] = new int[] { 35, 50, 48, 33, 17, 19 };
    faces[20] = new int[] {  0, 44, 29, 33, 48, 48 };  // repated 1x 5th number to fill gap
    faces[21] = new int[] {  1, 49, 32, 28, 45, 45 };  // repated 1x 5th number to fill gap
    faces[22] = new int[] {  2, 50, 35, 31, 46, 46 };  // repated 1x 5th number to fill gap
    faces[23] = new int[] {  3, 47, 30, 34, 51, 51 };  // repated 1x 5th number to fill gap
    faces[24] = new int[] {  4, 52, 16, 18, 54, 54 };  // repated 1x 5th number to fill gap
    faces[25] = new int[] {  5, 55, 19, 17, 53, 53 };  // repated 1x 5th number to fill gap
    faces[26] = new int[] {  6, 58, 14, 12, 56, 56 };  // repated 1x 5th number to fill gap
    faces[27] = new int[] {  7, 57, 13, 15, 59, 59 };  // repated 1x 5th number to fill gap
    faces[28] = new int[] {  8, 36, 22, 23, 37, 37 };  // repated 1x 5th number to fill gap
    faces[29] = new int[] {  9, 39, 21, 20, 38, 38 };  // repated 1x 5th number to fill gap
    faces[30] = new int[] { 10, 41, 27, 26, 40, 40 };  // repated 1x 5th number to fill gap
    faces[31] = new int[] { 11, 42, 24, 25, 43, 43 };  // repated 1x 5th number to fill gap
    faces[32] = new int[] {  0, 38, 42, 42, 42, 42 };  // repated 3x 3rd number to fill gap
    faces[33] = new int[] {  1, 43, 39, 39, 39, 39 };  // repated 3x 3rd number to fill gap
    faces[34] = new int[] {  2, 40, 36, 36, 36, 36 };  // repated 3x 3rd number to fill gap
    faces[35] = new int[] {  3, 37, 41, 41, 41, 41 };  // repated 3x 3rd number to fill gap
    faces[36] = new int[] {  4, 45, 47, 47, 47, 47 };  // repated 3x 3rd number to fill gap
    faces[37] = new int[] {  5, 46, 44, 44, 44, 44 };  // repated 3x 3rd number to fill gap
    faces[38] = new int[] {  6, 51, 49, 49, 49, 49 };  // repated 3x 3rd number to fill gap
    faces[39] = new int[] {  7, 48, 50, 50, 50, 50 };  // repated 3x 3rd number to fill gap
    faces[40] = new int[] {  8, 56, 57, 57, 57, 57 };  // repated 3x 3rd number to fill gap
    faces[41] = new int[] {  9, 59, 58, 58, 58, 58 };  // repated 3x 3rd number to fill gap
    faces[42] = new int[] { 10, 53, 52, 52, 52, 52 };  // repated 3x 3rd number to fill gap
    faces[43] = new int[] { 11, 54, 55, 55, 55, 55 };  // repated 3x 3rd number to fill gap
    faces[44] = new int[] { 12, 28, 20, 20, 20, 20 };  // repated 3x 3rd number to fill gap
    faces[45] = new int[] { 13, 21, 29, 29, 29, 29 };  // repated 3x 3rd number to fill gap
    faces[46] = new int[] { 14, 22, 30, 30, 30, 30 };  // repated 3x 3rd number to fill gap
    faces[47] = new int[] { 15, 31, 23, 23, 23, 23 };  // repated 3x 3rd number to fill gap
    faces[48] = new int[] { 16, 24, 32, 32, 32, 32 };  // repated 3x 3rd number to fill gap
    faces[49] = new int[] { 17, 33, 25, 25, 25, 25 };  // repated 3x 3rd number to fill gap
    faces[50] = new int[] { 18, 34, 26, 26, 26, 26 };  // repated 3x 3rd number to fill gap
    faces[51] = new int[] { 19, 27, 35, 35, 35, 35 };  // repated 3x 3rd number to fill gap
  } //end GreatIcosicosidodecahedron()

  public String name() {
    return "Great Icosicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class GreatIcosicosidodecahedron
/*
Icosidodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Icosidodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f;  //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C2 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437f;   //sqrt(5) / 2
  final float C4 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Icosidodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  0.0f,   C4 );
    vert[  1] = new PVector(   C0,  0.0f,  -C4 );
    vert[  2] = new PVector(  -C0,  0.0f,   C4 );
    vert[  3] = new PVector(  -C0,  0.0f,  -C4 );
    vert[  4] = new PVector(   C4,   C0,  0.0f );
    vert[  5] = new PVector(   C4,  -C0,  0.0f );
    vert[  6] = new PVector(  -C4,   C0,  0.0f );
    vert[  7] = new PVector(  -C4,  -C0,  0.0f );
    vert[  8] = new PVector(  0.0f,   C4,   C0 );
    vert[  9] = new PVector(  0.0f,   C4,  -C0 );
    vert[ 10] = new PVector(  0.0f,  -C4,   C0 );
    vert[ 11] = new PVector(  0.0f,  -C4,  -C0 );
    vert[ 12] = new PVector(  0.5f,  0.5f,   C3 );
    vert[ 13] = new PVector(  0.5f,  0.5f,  -C3 );
    vert[ 14] = new PVector(  0.5f, -0.5f,   C3 );
    vert[ 15] = new PVector(  0.5f, -0.5f,  -C3 );
    vert[ 16] = new PVector( -0.5f,  0.5f,   C3 );
    vert[ 17] = new PVector( -0.5f,  0.5f,  -C3 );
    vert[ 18] = new PVector( -0.5f, -0.5f,   C3 );
    vert[ 19] = new PVector( -0.5f, -0.5f,  -C3 );
    vert[ 20] = new PVector(   C3,  0.5f,  0.5f );
    vert[ 21] = new PVector(   C3,  0.5f, -0.5f );
    vert[ 22] = new PVector(   C3, -0.5f,  0.5f );
    vert[ 23] = new PVector(   C3, -0.5f, -0.5f );
    vert[ 24] = new PVector(  -C3,  0.5f,  0.5f );
    vert[ 25] = new PVector(  -C3,  0.5f, -0.5f );
    vert[ 26] = new PVector(  -C3, -0.5f,  0.5f );
    vert[ 27] = new PVector(  -C3, -0.5f, -0.5f );
    vert[ 28] = new PVector(  0.5f,   C3,  0.5f );
    vert[ 29] = new PVector(  0.5f,   C3, -0.5f );
    vert[ 30] = new PVector(  0.5f,  -C3,  0.5f );
    vert[ 31] = new PVector(  0.5f,  -C3, -0.5f );
    vert[ 32] = new PVector( -0.5f,   C3,  0.5f );
    vert[ 33] = new PVector( -0.5f,   C3, -0.5f );
    vert[ 34] = new PVector( -0.5f,  -C3,  0.5f );
    vert[ 35] = new PVector( -0.5f,  -C3, -0.5f );
    vert[ 36] = new PVector(   C1,   C2,  1.0f );
    vert[ 37] = new PVector(   C1,   C2, -1.0f );
    vert[ 38] = new PVector(   C1,  -C2,  1.0f );
    vert[ 39] = new PVector(   C1,  -C2, -1.0f );
    vert[ 40] = new PVector(  -C1,   C2,  1.0f );
    vert[ 41] = new PVector(  -C1,   C2, -1.0f );
    vert[ 42] = new PVector(  -C1,  -C2,  1.0f );
    vert[ 43] = new PVector(  -C1,  -C2, -1.0f );
    vert[ 44] = new PVector(  1.0f,   C1,   C2 );
    vert[ 45] = new PVector(  1.0f,   C1,  -C2 );
    vert[ 46] = new PVector(  1.0f,  -C1,   C2 );
    vert[ 47] = new PVector(  1.0f,  -C1,  -C2 );
    vert[ 48] = new PVector( -1.0f,   C1,   C2 );
    vert[ 49] = new PVector( -1.0f,   C1,  -C2 );
    vert[ 50] = new PVector( -1.0f,  -C1,   C2 );
    vert[ 51] = new PVector( -1.0f,  -C1,  -C2 );
    vert[ 52] = new PVector(   C2,  1.0f,   C1 );
    vert[ 53] = new PVector(   C2,  1.0f,  -C1 );
    vert[ 54] = new PVector(   C2, -1.0f,   C1 );
    vert[ 55] = new PVector(   C2, -1.0f,  -C1 );
    vert[ 56] = new PVector(  -C2,  1.0f,   C1 );
    vert[ 57] = new PVector(  -C2,  1.0f,  -C1 );
    vert[ 58] = new PVector(  -C2, -1.0f,   C1 );
    vert[ 59] = new PVector(  -C2, -1.0f,  -C1 );
    // set faces
    faces[ 0] = new int[] {  0, 42, 10, 55,  5, 44 };
    faces[ 1] = new int[] {  0, 46,  4, 53,  8, 40 };
    faces[ 2] = new int[] {  2, 36,  8, 57,  6, 50 };
    faces[ 3] = new int[] {  2, 48,  7, 59, 10, 38 };
    faces[ 4] = new int[] { 15, 13, 53, 20, 22, 55 };
    faces[ 5] = new int[] { 15, 19, 49, 33, 29, 45 };
    faces[ 6] = new int[] { 17, 13, 47, 31, 35, 51 };
    faces[ 7] = new int[] { 17, 19, 59, 26, 24, 57 };
    faces[ 8] = new int[] { 30, 46, 12, 16, 50, 34 };
    faces[ 9] = new int[] { 30, 42, 26, 27, 43, 31 };
    faces[10] = new int[] { 32, 48, 18, 14, 44, 28 };
    faces[11] = new int[] { 32, 36, 20, 21, 37, 33 };
    faces[12] = new int[] { 39, 23, 22, 38, 34, 35 };
    faces[13] = new int[] { 39, 11, 58,  7, 49,  3 };
    faces[14] = new int[] { 41, 25, 24, 40, 28, 29 };
    faces[15] = new int[] { 41,  9, 52,  4, 47,  1 };
    faces[16] = new int[] { 54, 11, 43,  1, 45,  5 };
    faces[17] = new int[] { 54, 23, 21, 52, 12, 14 };
    faces[18] = new int[] { 56,  9, 37,  3, 51,  6 };
    faces[19] = new int[] { 56, 25, 27, 58, 18, 16 };
    faces[20] = new int[] {  0, 40, 24, 26, 42, 42 };  // repated 1x 5th number to fill gap
    faces[21] = new int[] {  1, 43, 27, 25, 41, 41 };  // repated 1x 5th number to fill gap
    faces[22] = new int[] {  2, 38, 22, 20, 36, 36 };  // repated 1x 5th number to fill gap
    faces[23] = new int[] {  3, 37, 21, 23, 39, 39 };  // repated 1x 5th number to fill gap
    faces[24] = new int[] {  4, 46, 30, 31, 47, 47 };  // repated 1x 5th number to fill gap
    faces[25] = new int[] {  5, 45, 29, 28, 44, 44 };  // repated 1x 5th number to fill gap
    faces[26] = new int[] {  6, 51, 35, 34, 50, 50 };  // repated 1x 5th number to fill gap
    faces[27] = new int[] {  7, 48, 32, 33, 49, 49 };  // repated 1x 5th number to fill gap
    faces[28] = new int[] {  8, 53, 13, 17, 57, 57 };  // repated 1x 5th number to fill gap
    faces[29] = new int[] {  9, 56, 16, 12, 52, 52 };  // repated 1x 5th number to fill gap
    faces[30] = new int[] { 10, 59, 19, 15, 55, 55 };  // repated 1x 5th number to fill gap
    faces[31] = new int[] { 11, 54, 14, 18, 58, 58 };  // repated 1x 5th number to fill gap
    faces[32] = new int[] {  0, 44, 14, 12, 46, 46 };  // repated 1x 5th number to fill gap
    faces[33] = new int[] {  1, 47, 13, 15, 45, 45 };  // repated 1x 5th number to fill gap
    faces[34] = new int[] {  2, 50, 16, 18, 48, 48 };  // repated 1x 5th number to fill gap
    faces[35] = new int[] {  3, 49, 19, 17, 51, 51 };  // repated 1x 5th number to fill gap
    faces[36] = new int[] {  4, 52, 21, 20, 53, 53 };  // repated 1x 5th number to fill gap
    faces[37] = new int[] {  5, 55, 22, 23, 54, 54 };  // repated 1x 5th number to fill gap
    faces[38] = new int[] {  6, 57, 24, 25, 56, 56 };  // repated 1x 5th number to fill gap
    faces[39] = new int[] {  7, 58, 27, 26, 59, 59 };  // repated 1x 5th number to fill gap
    faces[40] = new int[] {  8, 36, 32, 28, 40, 40 };  // repated 1x 5th number to fill gap
    faces[41] = new int[] {  9, 41, 29, 33, 37, 37 };  // repated 1x 5th number to fill gap
    faces[42] = new int[] { 10, 42, 30, 34, 38, 38 };  // repated 1x 5th number to fill gap
    faces[43] = new int[] { 11, 39, 35, 31, 43, 43 };  // repated 1x 5th number to fill gap
  } //end Icosidodecadodecahedron()

  public String name() {
    return "Icosidodecadodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class Icosidodecadodecahedron
/*
MedialHexagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialHexagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.03581639493949013983380209116851f;  //square-root of a root of the polynomial:  102400*(x^6) - 66560*(x^5) + 19456*(x^4) + 8896*(x^3) - 2768*(x^2) - 776*x + 1
  final float C1  = 0.0474466215401124369879652440389f;   //square-root of a root of the polynomial:  102400*(x^6) - 10240*(x^5) - 18944*(x^4) - 13184*(x^3) - 64*(x^2) - 444*x + 1
  final float C2  = 0.105398765906697216676314189282f;    //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C3  = 0.112586641242744945279481298926f;    //sqrt(30 * (cbrt(4 * (7157 + 885 * sqrt(69))) - cbrt(4 * (885 * sqrt(69) - 7157)) - 28)) / 60
  final float C4  = 0.134722390669839585134028153001f;    //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 97536*(x^4) - 40128*(x^3) + 1408*(x^2) - 68*x + 1
  final float C5  = 0.37604495239790042473910409039502f;  //square-root of a root of the polynomial:  102400*(x^6) - 168960*(x^5) + 84736*(x^4) - 18432*(x^3) + 1808*(x^2) - 72*x + 1
  final float C6  = 0.438898343962682737883306417824f;    //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C7  = 0.486344965502795174871271661863f;    //square-root of a root of the polynomial:  102400*(x^6) - 240640*(x^5) + 226816*(x^4) - 114176*(x^3) + 33152*(x^2) - 5304*x + 361
  final float C8  = 0.537942209374520181919397458719f;    //square-root of a root of the polynomial:  1478656*(x^6) - 2528256*(x^5) + 694016*(x^4) - 24064*(x^3) - 240*(x^2) - 8*x + 1
  final float C9  = 0.544297109869379954559620607106f;    //sqrt(6 * (2 + cbrt(4 * (101 + 15 * sqrt(69))) - cbrt(4 * (15 * sqrt(69) - 101)))) / 12
  final float C10 = 0.608453514277639159564031071848f;    //sqrt(30 * (22 + cbrt(4 * (367 + 15 * sqrt(69))) + cbrt(4 * (367 - 15 * sqrt(69))))) / 60
  final float C11 = 0.621067356172634760005299814864f;    //square-root of a root of the polynomial:  102400*(x^6) - 66560*(x^5) + 19456*(x^4) + 8896*(x^3) - 2768*(x^2) - 776*x + 1
  final float C12 = 0.656883751112124899839101906033f;    //sqrt(15 * (31 - cbrt(4 * (101 + 15 * sqrt(69))) + cbrt(4 * (15 * sqrt(69) - 101)))) / 30
  final float C13 = 0.725451430403416911803282769524f;    //square-root of a root of the polynomial:  1478656*(x^6) - 2192384*(x^5) + 980736*(x^4) - 134656*(x^3) + 5200*(x^2) + 88*x + 1
  final float C14 = 0.822739079380407825858706772981f;    //square-root of a root of the polynomial:  102400*(x^6) - 10240*(x^5) - 18944*(x^4) - 13184*(x^3) - 64*(x^2) - 444*x + 1
  final float C15 = 0.844874828807502465713253627056f;    //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 27136*(x^4) + 17472*(x^3) - 352*(x^2) - 448*x + 121
  final float C16 = 0.870408778751185966979274045269f;    //square-root of a root of the polynomial:  1478656*(x^6) - 2192384*(x^5) + 980736*(x^4) - 134656*(x^3) + 5200*(x^2) + 88*x + 1
  final float C17 = 0.89232145034761490270121887109501f;  //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 97536*(x^4) - 40128*(x^3) + 1408*(x^2) - 68*x + 1
  final float C18 = 0.928137845287105042535020962264f;    //square-root of a root of the polynomial:  102400*(x^6) - 240640*(x^5) + 226816*(x^4) - 114176*(x^3) + 33152*(x^2) - 5304*x + 361
  final float C19 = 0.957461470050247410992734925983f;    //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 27136*(x^4) + 17472*(x^3) - 352*(x^2) - 448*x + 121
  final float C20 = 0.984498466675539584303135162243f;    //square-root of a root of the polynomial:  102400*(x^6) - 168960*(x^5) + 84736*(x^4) - 18432*(x^3) + 1808*(x^2) - 72*x + 1
  final float C21 = 1.173805071579957404913880606454f;    //square-root of a root of the polynomial:  1478656*(x^6) - 2528256*(x^5) + 694016*(x^4) - 24064*(x^3) - 240*(x^2) - 8*x + 1
  private PVector[] vert = new PVector[104]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialHexagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C13,  0.0f,  C21 );
    vert[  1] = new PVector(  C13,  0.0f, -C21 );
    vert[  2] = new PVector( -C13,  0.0f,  C21 );
    vert[  3] = new PVector( -C13,  0.0f, -C21 );
    vert[  4] = new PVector(  C21,  C13,  0.0f );
    vert[  5] = new PVector(  C21, -C13,  0.0f );
    vert[  6] = new PVector( -C21,  C13,  0.0f );
    vert[  7] = new PVector( -C21, -C13,  0.0f );
    vert[  8] = new PVector(  0.0f,  C21,  C13 );
    vert[  9] = new PVector(  0.0f,  C21, -C13 );
    vert[ 10] = new PVector(  0.0f, -C21,  C13 );
    vert[ 11] = new PVector(  0.0f, -C21, -C13 );
    vert[ 12] = new PVector(  0.0f,   C5,  C20 );
    vert[ 13] = new PVector(  0.0f,   C5, -C20 );
    vert[ 14] = new PVector(  0.0f,  -C5,  C20 );
    vert[ 15] = new PVector(  0.0f,  -C5, -C20 );
    vert[ 16] = new PVector(  C20,  0.0f,   C5 );
    vert[ 17] = new PVector(  C20,  0.0f,  -C5 );
    vert[ 18] = new PVector( -C20,  0.0f,   C5 );
    vert[ 19] = new PVector( -C20,  0.0f,  -C5 );
    vert[ 20] = new PVector(   C5,  C20,  0.0f );
    vert[ 21] = new PVector(   C5, -C20,  0.0f );
    vert[ 22] = new PVector(  -C5,  C20,  0.0f );
    vert[ 23] = new PVector(  -C5, -C20,  0.0f );
    vert[ 24] = new PVector(   C6,   C0,  C19 );
    vert[ 25] = new PVector(   C6,  -C0, -C19 );
    vert[ 26] = new PVector(  -C6,  -C0,  C19 );
    vert[ 27] = new PVector(  -C6,   C0, -C19 );
    vert[ 28] = new PVector(  C19,   C6,   C0 );
    vert[ 29] = new PVector(  C19,  -C6,  -C0 );
    vert[ 30] = new PVector( -C19,  -C6,   C0 );
    vert[ 31] = new PVector( -C19,   C6,  -C0 );
    vert[ 32] = new PVector(   C0,  C19,   C6 );
    vert[ 33] = new PVector(   C0, -C19,  -C6 );
    vert[ 34] = new PVector(  -C0, -C19,   C6 );
    vert[ 35] = new PVector(  -C0,  C19,  -C6 );
    vert[ 36] = new PVector(   C7,  -C3,  C18 );
    vert[ 37] = new PVector(   C7,   C3, -C18 );
    vert[ 38] = new PVector(  -C7,   C3,  C18 );
    vert[ 39] = new PVector(  -C7,  -C3, -C18 );
    vert[ 40] = new PVector(  C18,  -C7,   C3 );
    vert[ 41] = new PVector(  C18,   C7,  -C3 );
    vert[ 42] = new PVector( -C18,   C7,   C3 );
    vert[ 43] = new PVector( -C18,  -C7,  -C3 );
    vert[ 44] = new PVector(   C3, -C18,   C7 );
    vert[ 45] = new PVector(   C3,  C18,  -C7 );
    vert[ 46] = new PVector(  -C3,  C18,   C7 );
    vert[ 47] = new PVector(  -C3, -C18,  -C7 );
    vert[ 48] = new PVector(   C9,   C4,  C17 );
    vert[ 49] = new PVector(   C9,  -C4, -C17 );
    vert[ 50] = new PVector(  -C9,  -C4,  C17 );
    vert[ 51] = new PVector(  -C9,   C4, -C17 );
    vert[ 52] = new PVector(  C17,   C9,   C4 );
    vert[ 53] = new PVector(  C17,  -C9,  -C4 );
    vert[ 54] = new PVector( -C17,  -C9,   C4 );
    vert[ 55] = new PVector( -C17,   C9,  -C4 );
    vert[ 56] = new PVector(   C4,  C17,   C9 );
    vert[ 57] = new PVector(   C4, -C17,  -C9 );
    vert[ 58] = new PVector(  -C4, -C17,   C9 );
    vert[ 59] = new PVector(  -C4,  C17,  -C9 );
    vert[ 60] = new PVector(   C8,  0.0f,  C16 );
    vert[ 61] = new PVector(   C8,  0.0f, -C16 );
    vert[ 62] = new PVector(  -C8,  0.0f,  C16 );
    vert[ 63] = new PVector(  -C8,  0.0f, -C16 );
    vert[ 64] = new PVector(  C16,   C8,  0.0f );
    vert[ 65] = new PVector(  C16,  -C8,  0.0f );
    vert[ 66] = new PVector( -C16,   C8,  0.0f );
    vert[ 67] = new PVector( -C16,  -C8,  0.0f );
    vert[ 68] = new PVector(  0.0f,  C16,   C8 );
    vert[ 69] = new PVector(  0.0f,  C16,  -C8 );
    vert[ 70] = new PVector(  0.0f, -C16,   C8 );
    vert[ 71] = new PVector(  0.0f, -C16,  -C8 );
    vert[ 72] = new PVector(  C11,  -C2,  C15 );
    vert[ 73] = new PVector(  C11,   C2, -C15 );
    vert[ 74] = new PVector( -C11,   C2,  C15 );
    vert[ 75] = new PVector( -C11,  -C2, -C15 );
    vert[ 76] = new PVector(  C15, -C11,   C2 );
    vert[ 77] = new PVector(  C15,  C11,  -C2 );
    vert[ 78] = new PVector( -C15,  C11,   C2 );
    vert[ 79] = new PVector( -C15, -C11,  -C2 );
    vert[ 80] = new PVector(   C2, -C15,  C11 );
    vert[ 81] = new PVector(   C2,  C15, -C11 );
    vert[ 82] = new PVector(  -C2,  C15,  C11 );
    vert[ 83] = new PVector(  -C2, -C15, -C11 );
    vert[ 84] = new PVector(  C12,   C1,  C14 );
    vert[ 85] = new PVector(  C12,  -C1, -C14 );
    vert[ 86] = new PVector( -C12,  -C1,  C14 );
    vert[ 87] = new PVector( -C12,   C1, -C14 );
    vert[ 88] = new PVector(  C14,  C12,   C1 );
    vert[ 89] = new PVector(  C14, -C12,  -C1 );
    vert[ 90] = new PVector( -C14, -C12,   C1 );
    vert[ 91] = new PVector( -C14,  C12,  -C1 );
    vert[ 92] = new PVector(   C1,  C14,  C12 );
    vert[ 93] = new PVector(   C1, -C14, -C12 );
    vert[ 94] = new PVector(  -C1, -C14,  C12 );
    vert[ 95] = new PVector(  -C1,  C14, -C12 );
    vert[ 96] = new PVector(  C10,  C10,  C10 );
    vert[ 97] = new PVector(  C10,  C10, -C10 );
    vert[ 98] = new PVector(  C10, -C10,  C10 );
    vert[ 99] = new PVector(  C10, -C10, -C10 );
    vert[100] = new PVector( -C10,  C10,  C10 );
    vert[101] = new PVector( -C10,  C10, -C10 );
    vert[102] = new PVector( -C10, -C10,  C10 );
    vert[103] = new PVector( -C10, -C10, -C10 );
    // set faces
    faces[ 0] = new int[] {   0,  28,  64,  77,  20,  56 };
    faces[ 1] = new int[] {   0,  56,  68,  46, 100,  38 };
    faces[ 2] = new int[] {   0,  38,  62,  86, 102,  94 };
    faces[ 3] = new int[] {   0,  94,  70,  34,  21,  76 };
    faces[ 4] = new int[] {   0,  76,  65,  53,  17,  28 };
    faces[ 5] = new int[] {   1,  29,  65,  76,  21,  57 };
    faces[ 6] = new int[] {   1,  57,  71,  47, 103,  39 };
    faces[ 7] = new int[] {   1,  39,  63,  87, 101,  95 };
    faces[ 8] = new int[] {   1,  95,  69,  35,  20,  77 };
    faces[ 9] = new int[] {   1,  77,  64,  52,  16,  29 };
    faces[10] = new int[] {   2,  30,  67,  79,  23,  58 };
    faces[11] = new int[] {   2,  58,  70,  44,  98,  36 };
    faces[12] = new int[] {   2,  36,  60,  84,  96,  92 };
    faces[13] = new int[] {   2,  92,  68,  32,  22,  78 };
    faces[14] = new int[] {   2,  78,  66,  55,  19,  30 };
    faces[15] = new int[] {   3,  31,  66,  78,  22,  59 };
    faces[16] = new int[] {   3,  59,  69,  45,  97,  37 };
    faces[17] = new int[] {   3,  37,  61,  85,  99,  93 };
    faces[18] = new int[] {   3,  93,  71,  33,  23,  79 };
    faces[19] = new int[] {   3,  79,  67,  54,  18,  31 };
    faces[20] = new int[] {   4,  32,  68,  82,  12,  48 };
    faces[21] = new int[] {   4,  48,  60,  36,  98,  40 };
    faces[22] = new int[] {   4,  40,  65,  89,  99,  85 };
    faces[23] = new int[] {   4,  85,  61,  25,  13,  81 };
    faces[24] = new int[] {   4,  81,  69,  59,  22,  32 };
    faces[25] = new int[] {   5,  33,  71,  83,  15,  49 };
    faces[26] = new int[] {   5,  49,  61,  37,  97,  41 };
    faces[27] = new int[] {   5,  41,  64,  88,  96,  84 };
    faces[28] = new int[] {   5,  84,  60,  24,  14,  80 };
    faces[29] = new int[] {   5,  80,  70,  58,  23,  33 };
    faces[30] = new int[] {   6,  35,  69,  81,  13,  51 };
    faces[31] = new int[] {   6,  51,  63,  39, 103,  43 };
    faces[32] = new int[] {   6,  43,  67,  90, 102,  86 };
    faces[33] = new int[] {   6,  86,  62,  26,  12,  82 };
    faces[34] = new int[] {   6,  82,  68,  56,  20,  35 };
    faces[35] = new int[] {   7,  34,  70,  80,  14,  50 };
    faces[36] = new int[] {   7,  50,  62,  38, 100,  42 };
    faces[37] = new int[] {   7,  42,  66,  91, 101,  87 };
    faces[38] = new int[] {   7,  87,  63,  27,  15,  83 };
    faces[39] = new int[] {   7,  83,  71,  57,  21,  34 };
    faces[40] = new int[] {   8,  24,  60,  72,  16,  52 };
    faces[41] = new int[] {   8,  52,  64,  41,  97,  45 };
    faces[42] = new int[] {   8,  45,  69,  95, 101,  91 };
    faces[43] = new int[] {   8,  91,  66,  31,  18,  74 };
    faces[44] = new int[] {   8,  74,  62,  50,  14,  24 };
    faces[45] = new int[] {   9,  27,  63,  75,  19,  55 };
    faces[46] = new int[] {   9,  55,  66,  42, 100,  46 };
    faces[47] = new int[] {   9,  46,  68,  92,  96,  88 };
    faces[48] = new int[] {   9,  88,  64,  28,  17,  73 };
    faces[49] = new int[] {   9,  73,  61,  49,  15,  27 };
    faces[50] = new int[] {  10,  26,  62,  74,  18,  54 };
    faces[51] = new int[] {  10,  54,  67,  43, 103,  47 };
    faces[52] = new int[] {  10,  47,  71,  93,  99,  89 };
    faces[53] = new int[] {  10,  89,  65,  29,  16,  72 };
    faces[54] = new int[] {  10,  72,  60,  48,  12,  26 };
    faces[55] = new int[] {  11,  25,  61,  73,  17,  53 };
    faces[56] = new int[] {  11,  53,  65,  40,  98,  44 };
    faces[57] = new int[] {  11,  44,  70,  94, 102,  90 };
    faces[58] = new int[] {  11,  90,  67,  30,  19,  75 };
    faces[59] = new int[] {  11,  75,  63,  51,  13,  25 };
  } //end MedialHexagonalHexecontahedron()

  public String name() {
    return "Medial Hexagonal Hexecontahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class MedialHexagonalHexecontahedron
/*
Polyhedron abstract class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public abstract class Polyhedron {
	// position
  public float x = 0;
  public float y = 0;
  public float z = 0;
  //Spherical Coordinates
  public boolean parentSphere = false;
  public float radius;
  public float theta;
  public float phi;
  public float r;
  //Speed properties
  public float thetaSpeed = random(-0.01f, 0.01f);
  public float phiSpeed = random(-0.01f, 0.01f);
  //Stray
  public float stray = random(2,-2);
  // scale
  public float scaleSize = 5000;
  // rotation
  public boolean rotate = true;
  public float rx = 0;
  public float ry = 0;
  public float rz = 0;
  // fill
  public boolean nofill = false;
  public int fc0 = 255;
  public int fc1 = 255;
  public int fc2 = 255;
  public int fc3 = 255;
  // stroke
  public boolean nostroke = false;
  public float sw = 0.01f;
  public int sc0 = 0;
  public int sc1 = 0;
  public int sc2 = 0;
  public int sc3 = 255;

  public void position(float _x, float _y, float _z) {
    x = _x;
    y = _y;
    z = _z;
  }

  public void positionSphere(float _radius, float _theta, float _phi) {
    parentSphere = true;
    radius = _radius;
    theta = _theta;
    phi = _phi;
  }
  
  public void speed(float _thetaSpeed, float _phiSpeed) {
    thetaSpeed = _thetaSpeed;
    phiSpeed = _phiSpeed;
  }
  
  public void strayFactor(float _stray) {
    stray = _stray;
  }
  
  public void scaleFactor(float _scaleSize) {
    scaleSize = _scaleSize;  
  }
  
  public void fillColor(int _fc0, int _fc1, int _fc2, int _fc3) {
    fc0 = _fc0;
    fc1 = _fc1;
    fc2 = _fc2;
    fc3 = _fc3;
  }
  
  public void noFillToggle(boolean _nofill) {
    nofill = _nofill;
  }
  
  public void strokeColor(int _sc0, int _sc1, int _sc2, int _sc3) {
    sc0 = _sc0;
    sc1 = _sc1;
    sc2 = _sc2;
    sc3 = _sc3;
  }
  
  public void noStrokeToggle(boolean _nostroke) {
    nostroke = _nostroke;
  }
  
  public void strokeColorWeight(float _sw) {
    sw = _sw;
  }
  
  public void rotate(float _rx, float _ry, float _rz) {
    rx = _rx;
    ry = _ry;
    rz = _rz;
  }
  
  public void update() {
    theta += thetaSpeed;
    phi += phiSpeed;
  }
  
  public abstract String name();

  public abstract void render();

} //end Polyhedron class
/*
Rhombidodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Rhombidodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 54;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f;  //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C2 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437f;   //sqrt(5) / 2
  final float C4 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Rhombidodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  0.0f,   C4 );
    vert[  1] = new PVector(   C0,  0.0f,  -C4 );
    vert[  2] = new PVector(  -C0,  0.0f,   C4 );
    vert[  3] = new PVector(  -C0,  0.0f,  -C4 );
    vert[  4] = new PVector(   C4,   C0,  0.0f );
    vert[  5] = new PVector(   C4,  -C0,  0.0f );
    vert[  6] = new PVector(  -C4,   C0,  0.0f );
    vert[  7] = new PVector(  -C4,  -C0,  0.0f );
    vert[  8] = new PVector(  0.0f,   C4,   C0 );
    vert[  9] = new PVector(  0.0f,   C4,  -C0 );
    vert[ 10] = new PVector(  0.0f,  -C4,   C0 );
    vert[ 11] = new PVector(  0.0f,  -C4,  -C0 );
    vert[ 12] = new PVector(  0.5f,  0.5f,   C3 );
    vert[ 13] = new PVector(  0.5f,  0.5f,  -C3 );
    vert[ 14] = new PVector(  0.5f, -0.5f,   C3 );
    vert[ 15] = new PVector(  0.5f, -0.5f,  -C3 );
    vert[ 16] = new PVector( -0.5f,  0.5f,   C3 );
    vert[ 17] = new PVector( -0.5f,  0.5f,  -C3 );
    vert[ 18] = new PVector( -0.5f, -0.5f,   C3 );
    vert[ 19] = new PVector( -0.5f, -0.5f,  -C3 );
    vert[ 20] = new PVector(   C3,  0.5f,  0.5f );
    vert[ 21] = new PVector(   C3,  0.5f, -0.5f );
    vert[ 22] = new PVector(   C3, -0.5f,  0.5f );
    vert[ 23] = new PVector(   C3, -0.5f, -0.5f );
    vert[ 24] = new PVector(  -C3,  0.5f,  0.5f );
    vert[ 25] = new PVector(  -C3,  0.5f, -0.5f );
    vert[ 26] = new PVector(  -C3, -0.5f,  0.5f );
    vert[ 27] = new PVector(  -C3, -0.5f, -0.5f );
    vert[ 28] = new PVector(  0.5f,   C3,  0.5f );
    vert[ 29] = new PVector(  0.5f,   C3, -0.5f );
    vert[ 30] = new PVector(  0.5f,  -C3,  0.5f );
    vert[ 31] = new PVector(  0.5f,  -C3, -0.5f );
    vert[ 32] = new PVector( -0.5f,   C3,  0.5f );
    vert[ 33] = new PVector( -0.5f,   C3, -0.5f );
    vert[ 34] = new PVector( -0.5f,  -C3,  0.5f );
    vert[ 35] = new PVector( -0.5f,  -C3, -0.5f );
    vert[ 36] = new PVector(   C1,   C2,  1.0f );
    vert[ 37] = new PVector(   C1,   C2, -1.0f );
    vert[ 38] = new PVector(   C1,  -C2,  1.0f );
    vert[ 39] = new PVector(   C1,  -C2, -1.0f );
    vert[ 40] = new PVector(  -C1,   C2,  1.0f );
    vert[ 41] = new PVector(  -C1,   C2, -1.0f );
    vert[ 42] = new PVector(  -C1,  -C2,  1.0f );
    vert[ 43] = new PVector(  -C1,  -C2, -1.0f );
    vert[ 44] = new PVector(  1.0f,   C1,   C2 );
    vert[ 45] = new PVector(  1.0f,   C1,  -C2 );
    vert[ 46] = new PVector(  1.0f,  -C1,   C2 );
    vert[ 47] = new PVector(  1.0f,  -C1,  -C2 );
    vert[ 48] = new PVector( -1.0f,   C1,   C2 );
    vert[ 49] = new PVector( -1.0f,   C1,  -C2 );
    vert[ 50] = new PVector( -1.0f,  -C1,   C2 );
    vert[ 51] = new PVector( -1.0f,  -C1,  -C2 );
    vert[ 52] = new PVector(   C2,  1.0f,   C1 );
    vert[ 53] = new PVector(   C2,  1.0f,  -C1 );
    vert[ 54] = new PVector(   C2, -1.0f,   C1 );
    vert[ 55] = new PVector(   C2, -1.0f,  -C1 );
    vert[ 56] = new PVector(  -C2,  1.0f,   C1 );
    vert[ 57] = new PVector(  -C2,  1.0f,  -C1 );
    vert[ 58] = new PVector(  -C2, -1.0f,   C1 );
    vert[ 59] = new PVector(  -C2, -1.0f,  -C1 );
    // set faces
    faces[ 0] = new int[] {  0, 40, 24, 26, 42 };
    faces[ 1] = new int[] {  1, 43, 27, 25, 41 };
    faces[ 2] = new int[] {  2, 38, 22, 20, 36 };
    faces[ 3] = new int[] {  3, 37, 21, 23, 39 };
    faces[ 4] = new int[] {  4, 46, 30, 31, 47 };
    faces[ 5] = new int[] {  5, 45, 29, 28, 44 };
    faces[ 6] = new int[] {  6, 51, 35, 34, 50 };
    faces[ 7] = new int[] {  7, 48, 32, 33, 49 };
    faces[ 8] = new int[] {  8, 53, 13, 17, 57 };
    faces[ 9] = new int[] {  9, 56, 16, 12, 52 };
    faces[10] = new int[] { 10, 59, 19, 15, 55 };
    faces[11] = new int[] { 11, 54, 14, 18, 58 };
    faces[12] = new int[] {  0, 46, 12, 14, 44 };
    faces[13] = new int[] {  1, 45, 15, 13, 47 };
    faces[14] = new int[] {  2, 48, 18, 16, 50 };
    faces[15] = new int[] {  3, 51, 17, 19, 49 };
    faces[16] = new int[] {  4, 53, 20, 21, 52 };
    faces[17] = new int[] {  5, 54, 23, 22, 55 };
    faces[18] = new int[] {  6, 56, 25, 24, 57 };
    faces[19] = new int[] {  7, 59, 26, 27, 58 };
    faces[20] = new int[] {  8, 40, 28, 32, 36 };
    faces[21] = new int[] {  9, 37, 33, 29, 41 };
    faces[22] = new int[] { 10, 38, 34, 30, 42 };
    faces[23] = new int[] { 11, 43, 31, 35, 39 };
    faces[24] = new int[] {  0, 42, 30, 46, 46 };  // repated 1x 4th number to fill gap
    faces[25] = new int[] {  0, 44, 28, 40, 40 };  // repated 1x 4th number to fill gap
    faces[26] = new int[] {  1, 41, 29, 45, 45 };  // repated 1x 4th number to fill gap
    faces[27] = new int[] {  1, 47, 31, 43, 43 };  // repated 1x 4th number to fill gap
    faces[28] = new int[] {  3, 39, 35, 51, 51 };  // repated 1x 4th number to fill gap
    faces[29] = new int[] {  3, 49, 33, 37, 37 };  // repated 1x 4th number to fill gap
    faces[30] = new int[] {  5, 44, 14, 54, 54 };  // repated 1x 4th number to fill gap
    faces[31] = new int[] {  5, 55, 15, 45, 45 };  // repated 1x 4th number to fill gap
    faces[32] = new int[] {  6, 50, 16, 56, 56 };  // repated 1x 4rd number to fill gap
    faces[33] = new int[] {  6, 57, 17, 51, 51 };  // repated 1x 4rd number to fill gap
    faces[34] = new int[] {  7, 49, 19, 59, 59 };  // repated 1x 4rd number to fill gap
    faces[35] = new int[] {  7, 58, 18, 48, 48 };  // repated 1x 4rd number to fill gap
    faces[36] = new int[] {  8, 36, 20, 53, 53 };  // repated 1x 4rd number to fill gap
    faces[37] = new int[] {  8, 57, 24, 40, 40 };  // repated 1x 4rd number to fill gap
    faces[38] = new int[] {  9, 41, 25, 56, 56 };  // repated 1x 4rd number to fill gap
    faces[39] = new int[] {  9, 52, 21, 37, 37 };  // repated 1x 4rd number to fill gap
    faces[40] = new int[] { 11, 39, 23, 54, 54 };  // repated 1x 4rd number to fill gap
    faces[41] = new int[] { 11, 58, 27, 43, 43 };  // repated 1x 4rd number to fill gap
    faces[42] = new int[] { 12, 16, 18, 14, 14 };  // repated 1x 4rd number to fill gap
    faces[43] = new int[] { 12, 46,  4, 52, 52 };  // repated 1x 4rd number to fill gap
    faces[44] = new int[] { 13, 15, 19, 17, 17 };  // repated 1x 4rd number to fill gap
    faces[45] = new int[] { 13, 53,  4, 47, 47 };  // repated 1x 4rd number to fill gap
    faces[46] = new int[] { 22, 23, 21, 20, 20 };  // repated 1x 4rd number to fill gap
    faces[47] = new int[] { 22, 38, 10, 55, 55 };  // repated 1x 4rd number to fill gap
    faces[48] = new int[] { 26, 24, 25, 27, 27 };  // repated 1x 4rd number to fill gap
    faces[49] = new int[] { 26, 59, 10, 42, 42 };  // repated 1x 4rd number to fill gap
    faces[50] = new int[] { 32, 28, 29, 33, 33 };  // repated 1x 4rd number to fill gap
    faces[51] = new int[] { 32, 48,  2, 36, 36 };  // repated 1x 4rd number to fill gap
    faces[52] = new int[] { 34, 35, 31, 30, 30 };  // repated 1x 4rd number to fill gap
    faces[53] = new int[] { 34, 38,  2, 50, 50 };  // repated 1x 4rd number to fill gap
  } //end Rhombidodecadodecahedron()

  public String name() {
    return "Rhombidodecadodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class Rhombidodecadodecahedron
/*
SmallCubicuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallCubicuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 1.20710678118654752440084436210f; //(1 + sqrt(2)) / 2
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallCubicuboctahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.5f,   C0 );
    vert[  1] = new PVector(  0.5f,  0.5f,  -C0 );
    vert[  2] = new PVector(  0.5f, -0.5f,   C0 );
    vert[  3] = new PVector(  0.5f, -0.5f,  -C0 );
    vert[  4] = new PVector( -0.5f,  0.5f,   C0 );
    vert[  5] = new PVector( -0.5f,  0.5f,  -C0 );
    vert[  6] = new PVector( -0.5f, -0.5f,   C0 );
    vert[  7] = new PVector( -0.5f, -0.5f,  -C0 );
    vert[  8] = new PVector(   C0,  0.5f,  0.5f );
    vert[  9] = new PVector(   C0,  0.5f, -0.5f );
    vert[ 10] = new PVector(   C0, -0.5f,  0.5f );
    vert[ 11] = new PVector(   C0, -0.5f, -0.5f );
    vert[ 12] = new PVector(  -C0,  0.5f,  0.5f );
    vert[ 13] = new PVector(  -C0,  0.5f, -0.5f );
    vert[ 14] = new PVector(  -C0, -0.5f,  0.5f );
    vert[ 15] = new PVector(  -C0, -0.5f, -0.5f );
    vert[ 16] = new PVector(  0.5f,   C0,  0.5f );
    vert[ 17] = new PVector(  0.5f,   C0, -0.5f );
    vert[ 18] = new PVector(  0.5f,  -C0,  0.5f );
    vert[ 19] = new PVector(  0.5f,  -C0, -0.5f );
    vert[ 20] = new PVector( -0.5f,   C0,  0.5f );
    vert[ 21] = new PVector( -0.5f,   C0, -0.5f );
    vert[ 22] = new PVector( -0.5f,  -C0,  0.5f );
    vert[ 23] = new PVector( -0.5f,  -C0, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  2, 18, 19,  3,  1, 17, 16 };
    faces[ 1] = new int[] {  0,  8,  9,  1,  5, 13, 12,  4 };
    faces[ 2] = new int[] { 11, 10,  2,  6, 14, 15,  7,  3 };
    faces[ 3] = new int[] { 11, 19, 23, 15, 13, 21, 17,  9 };
    faces[ 4] = new int[] { 20, 12, 14, 22, 18, 10,  8, 16 };
    faces[ 5] = new int[] { 20, 21,  5,  7, 23, 22,  6,  4 };
    faces[ 6] = new int[] {  0,  4,  6,  2,  2,  2,  2,  2 };  //repeated 4x 4th number to fill gap
    faces[ 7] = new int[] {  1,  3,  7,  5,  5,  5,  5,  5 };  //repeated 4x 4th number to fill gap
    faces[ 8] = new int[] {  8, 10, 11,  9,  9,  9,  9,  9 };  //repeated 4x 4th number to fill gap
    faces[ 9] = new int[] { 12, 13, 15, 14, 14, 14, 14, 14 };  //repeated 4x 4th number to fill gap
    faces[10] = new int[] { 16, 17, 21, 20, 20, 20, 20, 20 };  //repeated 4x 4th number to fill gap
    faces[11] = new int[] { 18, 22, 23, 19, 19, 19, 19, 19 };  //repeated 4x 4th number to fill gap
    faces[12] = new int[] {  0, 16,  8,  8,  8,  8,  8,  8 };  //repeated 5x 3rd number to fill gap
    faces[13] = new int[] {  1,  9, 17, 17, 17, 17, 17, 17 };  //repeated 5x 3rd number to fill gap
    faces[14] = new int[] {  2, 10, 18, 18, 18, 18, 18, 18 };  //repeated 5x 3rd number to fill gap
    faces[15] = new int[] {  3, 19, 11, 11, 11, 11, 11, 11 };  //repeated 5x 3rd number to fill gap
    faces[16] = new int[] {  4, 12, 20, 20, 20, 20, 20, 20 };  //repeated 5x 3rd number to fill gap
    faces[17] = new int[] {  5, 21, 13, 13, 13, 13, 13, 13 };  //repeated 5x 3rd number to fill gap
    faces[18] = new int[] {  6, 22, 14, 14, 14, 14, 14, 14 };  //repeated 5x 3rd number to fill gap
    faces[19] = new int[] {  7, 15, 23, 23, 23, 23, 23, 23 };  //repeated 5x 3rd number to fill gap
  } //end SmallCubicuboctahedron()

  public String name() {
    return "Small Cubicuboctahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class SmallCubicuboctahedron
/*
SmallDitrigonalDodecicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDitrigonalDodecicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C1 = 1.11803398874989484820458683437f;   //sqrt(5) / 2
  final float C2 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C3 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDitrigonalDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,   C0,   C3 );
    vert[  1] = new PVector(  0.5f,   C0,  -C3 );
    vert[  2] = new PVector(  0.5f,  -C0,   C3 );
    vert[  3] = new PVector(  0.5f,  -C0,  -C3 );
    vert[  4] = new PVector( -0.5f,   C0,   C3 );
    vert[  5] = new PVector( -0.5f,   C0,  -C3 );
    vert[  6] = new PVector( -0.5f,  -C0,   C3 );
    vert[  7] = new PVector( -0.5f,  -C0,  -C3 );
    vert[  8] = new PVector(   C3,  0.5f,   C0 );
    vert[  9] = new PVector(   C3,  0.5f,  -C0 );
    vert[ 10] = new PVector(   C3, -0.5f,   C0 );
    vert[ 11] = new PVector(   C3, -0.5f,  -C0 );
    vert[ 12] = new PVector(  -C3,  0.5f,   C0 );
    vert[ 13] = new PVector(  -C3,  0.5f,  -C0 );
    vert[ 14] = new PVector(  -C3, -0.5f,   C0 );
    vert[ 15] = new PVector(  -C3, -0.5f,  -C0 );
    vert[ 16] = new PVector(   C0,   C3,  0.5f );
    vert[ 17] = new PVector(   C0,   C3, -0.5f );
    vert[ 18] = new PVector(   C0,  -C3,  0.5f );
    vert[ 19] = new PVector(   C0,  -C3, -0.5f );
    vert[ 20] = new PVector(  -C0,   C3,  0.5f );
    vert[ 21] = new PVector(  -C0,   C3, -0.5f );
    vert[ 22] = new PVector(  -C0,  -C3,  0.5f );
    vert[ 23] = new PVector(  -C0,  -C3, -0.5f );
    vert[ 24] = new PVector(  0.0f,   C1,   C2 );
    vert[ 25] = new PVector(  0.0f,   C1,  -C2 );
    vert[ 26] = new PVector(  0.0f,  -C1,   C2 );
    vert[ 27] = new PVector(  0.0f,  -C1,  -C2 );
    vert[ 28] = new PVector(   C2,  0.0f,   C1 );
    vert[ 29] = new PVector(   C2,  0.0f,  -C1 );
    vert[ 30] = new PVector(  -C2,  0.0f,   C1 );
    vert[ 31] = new PVector(  -C2,  0.0f,  -C1 );
    vert[ 32] = new PVector(   C1,   C2,  0.0f );
    vert[ 33] = new PVector(   C1,  -C2,  0.0f );
    vert[ 34] = new PVector(  -C1,   C2,  0.0f );
    vert[ 35] = new PVector(  -C1,  -C2,  0.0f );
    vert[ 36] = new PVector(  1.0f,  0.5f,   C2 );
    vert[ 37] = new PVector(  1.0f,  0.5f,  -C2 );
    vert[ 38] = new PVector(  1.0f, -0.5f,   C2 );
    vert[ 39] = new PVector(  1.0f, -0.5f,  -C2 );
    vert[ 40] = new PVector( -1.0f,  0.5f,   C2 );
    vert[ 41] = new PVector( -1.0f,  0.5f,  -C2 );
    vert[ 42] = new PVector( -1.0f, -0.5f,   C2 );
    vert[ 43] = new PVector( -1.0f, -0.5f,  -C2 );
    vert[ 44] = new PVector(   C2,  1.0f,  0.5f );
    vert[ 45] = new PVector(   C2,  1.0f, -0.5f );
    vert[ 46] = new PVector(   C2, -1.0f,  0.5f );
    vert[ 47] = new PVector(   C2, -1.0f, -0.5f );
    vert[ 48] = new PVector(  -C2,  1.0f,  0.5f );
    vert[ 49] = new PVector(  -C2,  1.0f, -0.5f );
    vert[ 50] = new PVector(  -C2, -1.0f,  0.5f );
    vert[ 51] = new PVector(  -C2, -1.0f, -0.5f );
    vert[ 52] = new PVector(  0.5f,   C2,  1.0f );
    vert[ 53] = new PVector(  0.5f,   C2, -1.0f );
    vert[ 54] = new PVector(  0.5f,  -C2,  1.0f );
    vert[ 55] = new PVector(  0.5f,  -C2, -1.0f );
    vert[ 56] = new PVector( -0.5f,   C2,  1.0f );
    vert[ 57] = new PVector( -0.5f,   C2, -1.0f );
    vert[ 58] = new PVector( -0.5f,  -C2,  1.0f );
    vert[ 59] = new PVector( -0.5f,  -C2, -1.0f );
    // set faces
    faces[ 0] = new int[] {  0,  4, 30, 14, 51, 59, 55, 47, 10, 28 };
    faces[ 1] = new int[] {  0, 38, 46, 47, 39,  1, 25, 21, 20, 24 };
    faces[ 2] = new int[] {  2, 26, 22, 23, 27,  3, 37, 45, 44, 36 };
    faces[ 3] = new int[] {  2, 28,  8, 45, 53, 57, 49, 12, 30,  6 };
    faces[ 4] = new int[] {  5,  1, 29, 11, 46, 54, 58, 50, 15, 31 };
    faces[ 5] = new int[] {  5, 43, 51, 50, 42,  4, 24, 16, 17, 25 };
    faces[ 6] = new int[] {  7, 27, 19, 18, 26,  6, 40, 48, 49, 41 };
    faces[ 7] = new int[] {  7, 31, 13, 48, 56, 52, 44,  9, 29,  3 };
    faces[ 8] = new int[] { 33, 11,  9, 32, 16, 56, 40, 42, 58, 18 };
    faces[ 9] = new int[] { 33, 19, 59, 43, 41, 57, 17, 32,  8, 10 };
    faces[10] = new int[] { 34, 13, 15, 35, 22, 54, 38, 36, 52, 20 };
    faces[11] = new int[] { 34, 21, 53, 37, 39, 55, 23, 35, 14, 12 };
    faces[12] = new int[] { 24, 20, 52, 56, 16, 16, 16, 16, 16, 16 };  // repated 5x 5th number to fill gap
    faces[13] = new int[] { 25, 17, 57, 53, 21, 21, 21, 21, 21, 21 };  // repated 5x 5th number to fill gap
    faces[14] = new int[] { 26, 18, 58, 54, 22, 22, 22, 22, 22, 22 };  // repated 5x 5th number to fill gap
    faces[15] = new int[] { 27, 23, 55, 59, 19, 19, 19, 19, 19, 19 };  // repated 5x 5th number to fill gap
    faces[16] = new int[] { 28,  2, 36, 38,  0,  0,  0,  0,  0,  0 };  // repated 5x 5th number to fill gap
    faces[17] = new int[] { 29,  1, 39, 37,  3,  3,  3,  3,  3,  3 };  // repated 5x 5th number to fill gap
    faces[18] = new int[] { 30,  4, 42, 40,  6,  6,  6,  6,  6,  6 };  // repated 5x 5th number to fill gap
    faces[19] = new int[] { 31,  7, 41, 43,  5,  5,  5,  5,  5,  5 };  // repated 5x 5th number to fill gap
    faces[20] = new int[] { 32,  9, 44, 45,  8,  8,  8,  8,  8,  8 };  // repated 5x 5th number to fill gap
    faces[21] = new int[] { 33, 10, 47, 46, 11, 11, 11, 11, 11, 11 };  // repated 5x 5th number to fill gap
    faces[22] = new int[] { 34, 12, 49, 48, 13, 13, 13, 13, 13, 13 };  // repated 5x 5th number to fill gap
    faces[23] = new int[] { 35, 15, 50, 51, 14, 14, 14, 14, 14, 14 };  // repated 5x 5th number to fill gap
    faces[24] = new int[] { 24,  4,  0,  0,  0,  0,  0,  0,  0,  0 };  // repated 7x 3rd number to fill gap
    faces[25] = new int[] { 25,  1,  5,  5,  5,  5,  5,  5,  5,  5 };  // repated 7x 3rd number to fill gap
    faces[26] = new int[] { 26,  2,  6,  6,  6,  6,  6,  6,  6,  6 };  // repated 7x 3rd number to fill gap
    faces[27] = new int[] { 27,  7,  3,  3,  3,  3,  3,  3,  3,  3 };  // repated 7x 3rd number to fill gap
    faces[28] = new int[] { 28, 10,  8,  8,  8,  8,  8,  8,  8,  8 };  // repated 7x 3rd number to fill gap
    faces[29] = new int[] { 29,  9, 11, 11, 11, 11, 11, 11, 11, 11 };  // repated 7x 3rd number to fill gap
    faces[30] = new int[] { 30, 12, 14, 14, 14, 14, 14, 14, 14, 14 };  // repated 7x 3rd number to fill gap
    faces[31] = new int[] { 31, 15, 13, 13, 13, 13, 13, 13, 13, 13 };  // repated 7x 3rd number to fill gap
    faces[32] = new int[] { 32, 17, 16, 16, 16, 16, 16, 16, 16, 16 };  // repated 7x 3rd number to fill gap
    faces[33] = new int[] { 33, 18, 19, 19, 19, 19, 19, 19, 19, 19 };  // repated 7x 3rd number to fill gap
    faces[34] = new int[] { 34, 20, 21, 21, 21, 21, 21, 21, 21, 21 };  // repated 7x 3rd number to fill gap
    faces[35] = new int[] { 35, 23, 22, 22, 22, 22, 22, 22, 22, 22 };  // repated 7x 3rd number to fill gap
    faces[36] = new int[] { 36, 44, 52, 52, 52, 52, 52, 52, 52, 52 };  // repated 7x 3rd number to fill gap
    faces[37] = new int[] { 37, 53, 45, 45, 45, 45, 45, 45, 45, 45 };  // repated 7x 3rd number to fill gap
    faces[38] = new int[] { 38, 54, 46, 46, 46, 46, 46, 46, 46, 46 };  // repated 7x 3rd number to fill gap
    faces[39] = new int[] { 39, 47, 55, 55, 55, 55, 55, 55, 55, 55 };  // repated 7x 3rd number to fill gap
    faces[40] = new int[] { 40, 56, 48, 48, 48, 48, 48, 48, 48, 48 };  // repated 7x 3rd number to fill gap
    faces[41] = new int[] { 41, 49, 57, 57, 57, 57, 57, 57, 57, 57 };  // repated 7x 3rd number to fill gap
    faces[42] = new int[] { 42, 50, 58, 58, 58, 58, 58, 58, 58, 58 };  // repated 7x 3rd number to fill gap
    faces[43] = new int[] { 43, 59, 51, 51, 51, 51, 51, 51, 51, 51 };  // repated 7x 3rd number to fill gap
  } //end SmallDitrigonalDodecicosidodecahedron()

  public String name() {
    return "Small Ditrigonal Dodecicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class SmallDitrigonalDodecicosidodecahedron
/*
SmallDodecicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDodecicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  final float C3 = 1.80901699437494742410229341718f;   //(5 + sqrt(5)) / 4
  final float C4 = 2.11803398874989484820458683437f;   //(2 + sqrt(5)) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.5f,   C4 );
    vert[  1] = new PVector(  0.5f,  0.5f,  -C4 );
    vert[  2] = new PVector(  0.5f, -0.5f,   C4 );
    vert[  3] = new PVector(  0.5f, -0.5f,  -C4 );
    vert[  4] = new PVector( -0.5f,  0.5f,   C4 );
    vert[  5] = new PVector( -0.5f,  0.5f,  -C4 );
    vert[  6] = new PVector( -0.5f, -0.5f,   C4 );
    vert[  7] = new PVector( -0.5f, -0.5f,  -C4 );
    vert[  8] = new PVector(   C4,  0.5f,  0.5f );
    vert[  9] = new PVector(   C4,  0.5f, -0.5f );
    vert[ 10] = new PVector(   C4, -0.5f,  0.5f );
    vert[ 11] = new PVector(   C4, -0.5f, -0.5f );
    vert[ 12] = new PVector(  -C4,  0.5f,  0.5f );
    vert[ 13] = new PVector(  -C4,  0.5f, -0.5f );
    vert[ 14] = new PVector(  -C4, -0.5f,  0.5f );
    vert[ 15] = new PVector(  -C4, -0.5f, -0.5f );
    vert[ 16] = new PVector(  0.5f,   C4,  0.5f );
    vert[ 17] = new PVector(  0.5f,   C4, -0.5f );
    vert[ 18] = new PVector(  0.5f,  -C4,  0.5f );
    vert[ 19] = new PVector(  0.5f,  -C4, -0.5f );
    vert[ 20] = new PVector( -0.5f,   C4,  0.5f );
    vert[ 21] = new PVector( -0.5f,   C4, -0.5f );
    vert[ 22] = new PVector( -0.5f,  -C4,  0.5f );
    vert[ 23] = new PVector( -0.5f,  -C4, -0.5f );
    vert[ 24] = new PVector(  0.0f,   C1,   C3 );
    vert[ 25] = new PVector(  0.0f,   C1,  -C3 );
    vert[ 26] = new PVector(  0.0f,  -C1,   C3 );
    vert[ 27] = new PVector(  0.0f,  -C1,  -C3 );
    vert[ 28] = new PVector(   C3,  0.0f,   C1 );
    vert[ 29] = new PVector(   C3,  0.0f,  -C1 );
    vert[ 30] = new PVector(  -C3,  0.0f,   C1 );
    vert[ 31] = new PVector(  -C3,  0.0f,  -C1 );
    vert[ 32] = new PVector(   C1,   C3,  0.0f );
    vert[ 33] = new PVector(   C1,  -C3,  0.0f );
    vert[ 34] = new PVector(  -C1,   C3,  0.0f );
    vert[ 35] = new PVector(  -C1,  -C3,  0.0f );
    vert[ 36] = new PVector(   C1,   C0,   C2 );
    vert[ 37] = new PVector(   C1,   C0,  -C2 );
    vert[ 38] = new PVector(   C1,  -C0,   C2 );
    vert[ 39] = new PVector(   C1,  -C0,  -C2 );
    vert[ 40] = new PVector(  -C1,   C0,   C2 );
    vert[ 41] = new PVector(  -C1,   C0,  -C2 );
    vert[ 42] = new PVector(  -C1,  -C0,   C2 );
    vert[ 43] = new PVector(  -C1,  -C0,  -C2 );
    vert[ 44] = new PVector(   C2,   C1,   C0 );
    vert[ 45] = new PVector(   C2,   C1,  -C0 );
    vert[ 46] = new PVector(   C2,  -C1,   C0 );
    vert[ 47] = new PVector(   C2,  -C1,  -C0 );
    vert[ 48] = new PVector(  -C2,   C1,   C0 );
    vert[ 49] = new PVector(  -C2,   C1,  -C0 );
    vert[ 50] = new PVector(  -C2,  -C1,   C0 );
    vert[ 51] = new PVector(  -C2,  -C1,  -C0 );
    vert[ 52] = new PVector(   C0,   C2,   C1 );
    vert[ 53] = new PVector(   C0,   C2,  -C1 );
    vert[ 54] = new PVector(   C0,  -C2,   C1 );
    vert[ 55] = new PVector(   C0,  -C2,  -C1 );
    vert[ 56] = new PVector(  -C0,   C2,   C1 );
    vert[ 57] = new PVector(  -C0,   C2,  -C1 );
    vert[ 58] = new PVector(  -C0,  -C2,   C1 );
    vert[ 59] = new PVector(  -C0,  -C2,  -C1 );
    // set faces
    faces[ 0] = new int[] {  0, 24, 56, 48, 12, 14, 50, 58, 26,  2 };
    faces[ 1] = new int[] {  0, 36, 44, 32, 17, 21, 34, 48, 40,  4 };
    faces[ 2] = new int[] {  7,  3, 39, 47, 33, 18, 22, 35, 51, 43 };
    faces[ 3] = new int[] {  7,  5, 25, 53, 45,  9, 11, 47, 55, 27 };
    faces[ 4] = new int[] { 10,  8, 44, 52, 24,  4,  6, 26, 54, 46 };
    faces[ 5] = new int[] { 10, 11, 29, 37, 53, 17, 16, 52, 36, 28 };
    faces[ 6] = new int[] { 13, 31, 43, 59, 23, 22, 58, 42, 30, 12 };
    faces[ 7] = new int[] { 13, 49, 57, 25,  1,  3, 27, 59, 51, 15 };
    faces[ 8] = new int[] { 19, 33, 46, 38,  2,  6, 42, 50, 35, 23 };
    faces[ 9] = new int[] { 19, 55, 39, 29,  9,  8, 28, 38, 54, 18 };
    faces[10] = new int[] { 20, 16, 32, 45, 37,  1,  5, 41, 49, 34 };
    faces[11] = new int[] { 20, 21, 57, 41, 31, 15, 14, 30, 40, 56 };
    faces[12] = new int[] { 24, 52, 16, 20, 56, 56, 56, 56, 56, 56 };  // repated 5x 5th number to fill gap
    faces[13] = new int[] { 25, 57, 21, 17, 53, 53, 53, 53, 53, 53 };  // repated 5x 5th number to fill gap
    faces[14] = new int[] { 26, 58, 22, 18, 54, 54, 54, 54, 54, 54 };  // repated 5x 5th number to fill gap
    faces[15] = new int[] { 27, 55, 19, 23, 59, 59, 59, 59, 59, 59 };  // repated 5x 5th number to fill gap
    faces[16] = new int[] { 28, 36,  0,  2, 38, 38, 38, 38, 38, 38 };  // repated 5x 5th number to fill gap
    faces[17] = new int[] { 29, 39,  3,  1, 37, 37, 37, 37, 37, 37 };  // repated 5x 5th number to fill gap
    faces[18] = new int[] { 30, 42,  6,  4, 40, 40, 40, 40, 40, 40 };  // repated 5x 5th number to fill gap
    faces[19] = new int[] { 31, 41,  5,  7, 43, 43, 43, 43, 43, 43 };  // repated 5x 5th number to fill gap
    faces[20] = new int[] { 32, 44,  8,  9, 45, 45, 45, 45, 45, 45 };  // repated 5x 5th number to fill gap
    faces[21] = new int[] { 33, 47, 11, 10, 46, 46, 46, 46, 46, 46 };  // repated 5x 5th number to fill gap
    faces[22] = new int[] { 34, 49, 13, 12, 48, 48, 48, 48, 48, 48 };  // repated 5x 5th number to fill gap
    faces[23] = new int[] { 35, 50, 14, 15, 51, 51, 51, 51, 51, 51 };  // repated 5x 5th number to fill gap
    faces[24] = new int[] { 24,  0,  4,  4,  4,  4,  4,  4,  4,  4 };  // repated 7x 3rd number to fill gap
    faces[25] = new int[] { 25,  5,  1,  1,  1,  1,  1,  1,  1,  1 };  // repated 7x 3rd number to fill gap
    faces[26] = new int[] { 26,  6,  2,  2,  2,  2,  2,  2,  2,  2 };  // repated 7x 3rd number to fill gap
    faces[27] = new int[] { 27,  3,  7,  7,  7,  7,  7,  7,  7,  7 };  // repated 7x 3rd number to fill gap
    faces[28] = new int[] { 28,  8, 10, 10, 10, 10, 10, 10, 10, 10 };  // repated 7x 3rd number to fill gap
    faces[29] = new int[] { 29, 11,  9,  9,  9,  9,  9,  9,  9,  9 };  // repated 7x 3rd number to fill gap
    faces[30] = new int[] { 30, 14, 12, 12, 12, 12, 12, 12, 12, 12 };  // repated 7x 3rd number to fill gap
    faces[31] = new int[] { 31, 13, 15, 15, 15, 15, 15, 15, 15, 15 };  // repated 7x 3rd number to fill gap
    faces[32] = new int[] { 32, 16, 17, 17, 17, 17, 17, 17, 17, 17 };  // repated 7x 3rd number to fill gap
    faces[33] = new int[] { 33, 19, 18, 18, 18, 18, 18, 18, 18, 18 };  // repated 7x 3rd number to fill gap
    faces[34] = new int[] { 34, 21, 20, 20, 20, 20, 20, 20, 20, 20 };  // repated 7x 3rd number to fill gap
    faces[35] = new int[] { 35, 22, 23, 23, 23, 23, 23, 23, 23, 23 };  // repated 7x 3rd number to fill gap
    faces[36] = new int[] { 36, 52, 44, 44, 44, 44, 44, 44, 44, 44 };  // repated 7x 3rd number to fill gap
    faces[37] = new int[] { 37, 45, 53, 53, 53, 53, 53, 53, 53, 53 };  // repated 7x 3rd number to fill gap
    faces[38] = new int[] { 38, 46, 54, 54, 54, 54, 54, 54, 54, 54 };  // repated 7x 3rd number to fill gap
    faces[39] = new int[] { 39, 55, 47, 47, 47, 47, 47, 47, 47, 47 };  // repated 7x 3rd number to fill gap
    faces[40] = new int[] { 40, 48, 56, 56, 56, 56, 56, 56, 56, 56 };  // repated 7x 3rd number to fill gap
    faces[41] = new int[] { 41, 57, 49, 49, 49, 49, 49, 49, 49, 49 };  // repated 7x 3rd number to fill gap
    faces[42] = new int[] { 42, 58, 50, 50, 50, 50, 50, 50, 50, 50 };  // repated 7x 3rd number to fill gap
    faces[43] = new int[] { 43, 51, 59, 59, 59, 59, 59, 59, 59, 59 };  // repated 7x 3rd number to fill gap
  } //end SmallDodecicosidodecahedron()

  public String name() {
    return "Small Dodecicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class SmallDodecicosidodecahedron
/*
SmallIcosicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallIcosicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 52;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C1 = 1.11803398874989484820458683437f;  //sqrt(5) / 2
  final float C2 = 1.30901699437494742410229341718f;  //(3 + sqrt(5)) / 4
  final float C3 = 1.61803398874989484820458683437f;  //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallIcosicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C2,  0.0f,  -C1 );
    vert[  1] = new PVector(   C2,  0.0f,   C1 );
    vert[  2] = new PVector(  -C2,  0.0f,  -C1 );
    vert[  3] = new PVector(  -C2,  0.0f,   C1 );
    vert[  4] = new PVector(  0.0f,  -C1,   C2 );
    vert[  5] = new PVector(  0.0f,  -C1,  -C2 );
    vert[  6] = new PVector(  0.0f,   C1,   C2 );
    vert[  7] = new PVector(  0.0f,   C1,  -C2 );
    vert[  8] = new PVector(  -C1,   C2,  0.0f );
    vert[  9] = new PVector(   C1,   C2,  0.0f );
    vert[ 10] = new PVector(  -C1,  -C2,  0.0f );
    vert[ 11] = new PVector(   C1,  -C2,  0.0f );
    vert[ 12] = new PVector(  0.5f,   C2,  1.0f );
    vert[ 13] = new PVector(  0.5f,   C2, -1.0f );
    vert[ 14] = new PVector( -0.5f,   C2,  1.0f );
    vert[ 15] = new PVector( -0.5f,   C2, -1.0f );
    vert[ 16] = new PVector(  0.5f,  -C2,  1.0f );
    vert[ 17] = new PVector(  0.5f,  -C2, -1.0f );
    vert[ 18] = new PVector( -0.5f,  -C2,  1.0f );
    vert[ 19] = new PVector( -0.5f,  -C2, -1.0f );
    vert[ 20] = new PVector(   C2,  1.0f,  0.5f );
    vert[ 21] = new PVector(   C2,  1.0f, -0.5f );
    vert[ 22] = new PVector(  -C2,  1.0f,  0.5f );
    vert[ 23] = new PVector(  -C2,  1.0f, -0.5f );
    vert[ 24] = new PVector(   C2, -1.0f,  0.5f );
    vert[ 25] = new PVector(   C2, -1.0f, -0.5f );
    vert[ 26] = new PVector(  -C2, -1.0f,  0.5f );
    vert[ 27] = new PVector(  -C2, -1.0f, -0.5f );
    vert[ 28] = new PVector(  1.0f,  0.5f,   C2 );
    vert[ 29] = new PVector(  1.0f,  0.5f,  -C2 );
    vert[ 30] = new PVector( -1.0f,  0.5f,   C2 );
    vert[ 31] = new PVector( -1.0f,  0.5f,  -C2 );
    vert[ 32] = new PVector(  1.0f, -0.5f,   C2 );
    vert[ 33] = new PVector(  1.0f, -0.5f,  -C2 );
    vert[ 34] = new PVector( -1.0f, -0.5f,   C2 );
    vert[ 35] = new PVector( -1.0f, -0.5f,  -C2 );
    vert[ 36] = new PVector(  -C3,  0.5f,  -C0 );
    vert[ 37] = new PVector(  -C3,  0.5f,   C0 );
    vert[ 38] = new PVector(   C3,  0.5f,  -C0 );
    vert[ 39] = new PVector(   C3,  0.5f,   C0 );
    vert[ 40] = new PVector(  -C3, -0.5f,  -C0 );
    vert[ 41] = new PVector(  -C3, -0.5f,   C0 );
    vert[ 42] = new PVector(   C3, -0.5f,  -C0 );
    vert[ 43] = new PVector(   C3, -0.5f,   C0 );
    vert[ 44] = new PVector(  0.5f,  -C0,  -C3 );
    vert[ 45] = new PVector(  0.5f,  -C0,   C3 );
    vert[ 46] = new PVector( -0.5f,  -C0,  -C3 );
    vert[ 47] = new PVector( -0.5f,  -C0,   C3 );
    vert[ 48] = new PVector(  0.5f,   C0,  -C3 );
    vert[ 49] = new PVector(  0.5f,   C0,   C3 );
    vert[ 50] = new PVector( -0.5f,   C0,  -C3 );
    vert[ 51] = new PVector( -0.5f,   C0,   C3 );
    vert[ 52] = new PVector(  -C0,  -C3,  0.5f );
    vert[ 53] = new PVector(  -C0,  -C3, -0.5f );
    vert[ 54] = new PVector(   C0,  -C3,  0.5f );
    vert[ 55] = new PVector(   C0,  -C3, -0.5f );
    vert[ 56] = new PVector(  -C0,   C3,  0.5f );
    vert[ 57] = new PVector(  -C0,   C3, -0.5f );
    vert[ 58] = new PVector(   C0,   C3,  0.5f );
    vert[ 59] = new PVector(   C0,   C3, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0, 42, 11, 55,  5, 44 };
    faces[ 1] = new int[] {  0, 48,  7, 59,  9, 38 };
    faces[ 2] = new int[] {  1, 39,  9, 58,  6, 49 };
    faces[ 3] = new int[] {  1, 45,  4, 54, 11, 43 };
    faces[ 4] = new int[] {  2, 36,  8, 57,  7, 50 };
    faces[ 5] = new int[] {  2, 46,  5, 53, 10, 40 };
    faces[ 6] = new int[] {  3, 41, 10, 52,  4, 47 };
    faces[ 7] = new int[] {  3, 51,  6, 56,  8, 37 };
    faces[ 8] = new int[] { 15, 13, 29, 44, 46, 31 };
    faces[ 9] = new int[] { 15, 23, 22, 14, 58, 59 };
    faces[10] = new int[] { 18, 16, 32, 49, 51, 34 };
    faces[11] = new int[] { 18, 26, 27, 19, 55, 54 };
    faces[12] = new int[] { 20, 21, 13, 57, 56, 12 };
    faces[13] = new int[] { 20, 28, 32, 24, 42, 38 };
    faces[14] = new int[] { 25, 24, 16, 52, 53, 17 };
    faces[15] = new int[] { 25, 33, 29, 21, 39, 43 };
    faces[16] = new int[] { 30, 22, 36, 40, 26, 34 };
    faces[17] = new int[] { 30, 47, 45, 28, 12, 14 };
    faces[18] = new int[] { 35, 27, 41, 37, 23, 31 };
    faces[19] = new int[] { 35, 50, 48, 33, 17, 19 };
    faces[20] = new int[] {  0, 44, 29, 33, 48, 48 };  // repated 1x 5th number to fill gap
    faces[21] = new int[] {  1, 49, 32, 28, 45, 45 };  // repated 1x 5th number to fill gap
    faces[22] = new int[] {  2, 50, 35, 31, 46, 46 };  // repated 1x 5th number to fill gap
    faces[23] = new int[] {  3, 47, 30, 34, 51, 51 };  // repated 1x 5th number to fill gap
    faces[24] = new int[] {  4, 52, 16, 18, 54, 54 };  // repated 1x 5th number to fill gap
    faces[25] = new int[] {  5, 55, 19, 17, 53, 53 };  // repated 1x 5th number to fill gap
    faces[26] = new int[] {  6, 58, 14, 12, 56, 56 };  // repated 1x 5th number to fill gap
    faces[27] = new int[] {  7, 57, 13, 15, 59, 59 };  // repated 1x 5th number to fill gap
    faces[28] = new int[] {  8, 36, 22, 23, 37, 37 };  // repated 1x 5th number to fill gap
    faces[29] = new int[] {  9, 39, 21, 20, 38, 38 };  // repated 1x 5th number to fill gap
    faces[30] = new int[] { 10, 41, 27, 26, 40, 40 };  // repated 1x 5th number to fill gap
    faces[31] = new int[] { 11, 42, 24, 25, 43, 43 };  // repated 1x 5th number to fill gap
    faces[32] = new int[] {  0, 38, 42, 42, 42, 42 };  // repated 3x 3rd number to fill gap
    faces[33] = new int[] {  1, 43, 39, 39, 39, 39 };  // repated 3x 3rd number to fill gap
    faces[34] = new int[] {  2, 40, 36, 36, 36, 36 };  // repated 3x 3rd number to fill gap
    faces[35] = new int[] {  3, 37, 41, 41, 41, 41 };  // repated 3x 3rd number to fill gap
    faces[36] = new int[] {  4, 45, 47, 47, 47, 47 };  // repated 3x 3rd number to fill gap
    faces[37] = new int[] {  5, 46, 44, 44, 44, 44 };  // repated 3x 3rd number to fill gap
    faces[38] = new int[] {  6, 51, 49, 49, 49, 49 };  // repated 3x 3rd number to fill gap
    faces[39] = new int[] {  7, 48, 50, 50, 50, 50 };  // repated 3x 3rd number to fill gap
    faces[40] = new int[] {  8, 56, 57, 57, 57, 57 };  // repated 3x 3rd number to fill gap
    faces[41] = new int[] {  9, 59, 58, 58, 58, 58 };  // repated 3x 3rd number to fill gap
    faces[42] = new int[] { 10, 53, 52, 52, 52, 52 };  // repated 3x 3rd number to fill gap
    faces[43] = new int[] { 11, 54, 55, 55, 55, 55 };  // repated 3x 3rd number to fill gap
    faces[44] = new int[] { 12, 28, 20, 20, 20, 20 };  // repated 3x 3rd number to fill gap
    faces[45] = new int[] { 13, 21, 29, 29, 29, 29 };  // repated 3x 3rd number to fill gap
    faces[46] = new int[] { 14, 22, 30, 30, 30, 30 };  // repated 3x 3rd number to fill gap
    faces[47] = new int[] { 15, 31, 23, 23, 23, 23 };  // repated 3x 3rd number to fill gap
    faces[48] = new int[] { 16, 24, 32, 32, 32, 32 };  // repated 3x 3rd number to fill gap
    faces[49] = new int[] { 17, 33, 25, 25, 25, 25 };  // repated 3x 3rd number to fill gap
    faces[50] = new int[] { 18, 34, 26, 26, 26, 26 };  // repated 3x 3rd number to fill gap
    faces[51] = new int[] { 19, 27, 35, 35, 35, 35 };  // repated 3x 3rd number to fill gap
  } //end SmallIcosicosidodecahedron()

  public String name() {
    return "Small Icosicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class SmallIcosicosidodecahedron
/*
UniformGreatRhombicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class UniformGreatRhombicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 62;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.118033988749894848204586834366f;  //(sqrt(5) - 2) / 2
  final float C1 = 0.190983005625052575897706582817f;  //(3 - sqrt(5)) / 4
  final float C2 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C3 = 0.618033988749894848204586834366f;  //(sqrt(5) - 1) / 2
  final float C4 = 0.690983005625052575897706582817f;  //(5 - sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private UniformGreatRhombicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.5f,  -C0 );
    vert[  1] = new PVector(  0.5f,  0.5f,   C0 );
    vert[  2] = new PVector( -0.5f,  0.5f,  -C0 );
    vert[  3] = new PVector( -0.5f,  0.5f,   C0 );
    vert[  4] = new PVector(  0.5f, -0.5f,  -C0 );
    vert[  5] = new PVector(  0.5f, -0.5f,   C0 );
    vert[  6] = new PVector( -0.5f, -0.5f,  -C0 );
    vert[  7] = new PVector( -0.5f, -0.5f,   C0 );
    vert[  8] = new PVector(  0.5f,  -C0,  0.5f );
    vert[  9] = new PVector(  0.5f,  -C0, -0.5f );
    vert[ 10] = new PVector( -0.5f,  -C0,  0.5f );
    vert[ 11] = new PVector( -0.5f,  -C0, -0.5f );
    vert[ 12] = new PVector(  0.5f,   C0,  0.5f );
    vert[ 13] = new PVector(  0.5f,   C0, -0.5f );
    vert[ 14] = new PVector( -0.5f,   C0,  0.5f );
    vert[ 15] = new PVector( -0.5f,   C0, -0.5f );
    vert[ 16] = new PVector(  -C0,  0.5f,  0.5f );
    vert[ 17] = new PVector(  -C0,  0.5f, -0.5f );
    vert[ 18] = new PVector(   C0,  0.5f,  0.5f );
    vert[ 19] = new PVector(   C0,  0.5f, -0.5f );
    vert[ 20] = new PVector(  -C0, -0.5f,  0.5f );
    vert[ 21] = new PVector(  -C0, -0.5f, -0.5f );
    vert[ 22] = new PVector(   C0, -0.5f,  0.5f );
    vert[ 23] = new PVector(   C0, -0.5f, -0.5f );
    vert[ 24] = new PVector(   C1,  0.0f,   C4 );
    vert[ 25] = new PVector(   C1,  0.0f,  -C4 );
    vert[ 26] = new PVector(  -C1,  0.0f,   C4 );
    vert[ 27] = new PVector(  -C1,  0.0f,  -C4 );
    vert[ 28] = new PVector(  0.0f,   C4,   C1 );
    vert[ 29] = new PVector(  0.0f,   C4,  -C1 );
    vert[ 30] = new PVector(  0.0f,  -C4,   C1 );
    vert[ 31] = new PVector(  0.0f,  -C4,  -C1 );
    vert[ 32] = new PVector(   C4,   C1,  0.0f );
    vert[ 33] = new PVector(  -C4,   C1,  0.0f );
    vert[ 34] = new PVector(   C4,  -C1,  0.0f );
    vert[ 35] = new PVector(  -C4,  -C1,  0.0f );
    vert[ 36] = new PVector(  -C2,   C1,  -C3 );
    vert[ 37] = new PVector(  -C2,   C1,   C3 );
    vert[ 38] = new PVector(   C2,   C1,  -C3 );
    vert[ 39] = new PVector(   C2,   C1,   C3 );
    vert[ 40] = new PVector(  -C2,  -C1,  -C3 );
    vert[ 41] = new PVector(  -C2,  -C1,   C3 );
    vert[ 42] = new PVector(   C2,  -C1,  -C3 );
    vert[ 43] = new PVector(   C2,  -C1,   C3 );
    vert[ 44] = new PVector(   C1,  -C3,  -C2 );
    vert[ 45] = new PVector(   C1,  -C3,   C2 );
    vert[ 46] = new PVector(  -C1,  -C3,  -C2 );
    vert[ 47] = new PVector(  -C1,  -C3,   C2 );
    vert[ 48] = new PVector(   C1,   C3,  -C2 );
    vert[ 49] = new PVector(   C1,   C3,   C2 );
    vert[ 50] = new PVector(  -C1,   C3,  -C2 );
    vert[ 51] = new PVector(  -C1,   C3,   C2 );
    vert[ 52] = new PVector(  -C3,  -C2,   C1 );
    vert[ 53] = new PVector(  -C3,  -C2,  -C1 );
    vert[ 54] = new PVector(   C3,  -C2,   C1 );
    vert[ 55] = new PVector(   C3,  -C2,  -C1 );
    vert[ 56] = new PVector(  -C3,   C2,   C1 );
    vert[ 57] = new PVector(  -C3,   C2,  -C1 );
    vert[ 58] = new PVector(   C3,   C2,   C1 );
    vert[ 59] = new PVector(   C3,   C2,  -C1 );
    // set faces
    faces[ 0] = new int[] { 24, 52, 16, 20, 56 };
    faces[ 1] = new int[] { 25, 57, 21, 17, 53 };
    faces[ 2] = new int[] { 26, 58, 22, 18, 54 };
    faces[ 3] = new int[] { 27, 55, 19, 23, 59 };
    faces[ 4] = new int[] { 28, 36,  0,  2, 38 };
    faces[ 5] = new int[] { 29, 39,  3,  1, 37 };
    faces[ 6] = new int[] { 30, 42,  6,  4, 40 };
    faces[ 7] = new int[] { 31, 41,  5,  7, 43 };
    faces[ 8] = new int[] { 32, 44,  8,  9, 45 };
    faces[ 9] = new int[] { 33, 47, 11, 10, 46 };
    faces[10] = new int[] { 34, 49, 13, 12, 48 };
    faces[11] = new int[] { 35, 50, 14, 15, 51 };
    faces[12] = new int[] {  0, 36, 52, 24, 24 };  // repated 1x 4th number to fill gap
    faces[13] = new int[] {  1, 25, 53, 37, 37 };  // repated 1x 4th number to fill gap
    faces[14] = new int[] {  2, 26, 54, 38, 38 };  // repated 1x 4th number to fill gap
    faces[15] = new int[] {  3, 39, 55, 27, 27 };  // repated 1x 4th number to fill gap
    faces[16] = new int[] {  4, 24, 56, 40, 40 };  // repated 1x 4th number to fill gap
    faces[17] = new int[] {  5, 41, 57, 25, 25 };  // repated 1x 4th number to fill gap
    faces[18] = new int[] {  6, 42, 58, 26, 26 };  // repated 1x 4th number to fill gap
    faces[19] = new int[] {  7, 27, 59, 43, 43 };  // repated 1x 4th number to fill gap
    faces[20] = new int[] {  8, 44, 36, 28, 28 };  // repated 1x 4th number to fill gap
    faces[21] = new int[] {  9, 29, 37, 45, 45 };  // repated 1x 4th number to fill gap
    faces[22] = new int[] { 10, 28, 38, 46, 46 };  // repated 1x 4th number to fill gap
    faces[23] = new int[] { 11, 47, 39, 29, 29 };  // repated 1x 4th number to fill gap
    faces[24] = new int[] { 12, 30, 40, 48, 48 };  // repated 1x 4th number to fill gap
    faces[25] = new int[] { 13, 49, 41, 31, 31 };  // repated 1x 4th number to fill gap
    faces[26] = new int[] { 14, 50, 42, 30, 30 };  // repated 1x 4th number to fill gap
    faces[27] = new int[] { 15, 31, 43, 51, 51 };  // repated 1x 4th number to fill gap
    faces[28] = new int[] { 16, 52, 44, 32, 32 };  // repated 1x 4th number to fill gap
    faces[29] = new int[] { 17, 32, 45, 53, 53 };  // repated 1x 4th number to fill gap
    faces[30] = new int[] { 18, 33, 46, 54, 54 };  // repated 1x 4th number to fill gap
    faces[31] = new int[] { 19, 55, 47, 33, 33 };  // repated 1x 4th number to fill gap
    faces[32] = new int[] { 20, 34, 48, 56, 56 };  // repated 1x 4th number to fill gap
    faces[33] = new int[] { 21, 57, 49, 34, 34 };  // repated 1x 4th number to fill gap
    faces[34] = new int[] { 22, 58, 50, 35, 35 };  // repated 1x 4th number to fill gap
    faces[35] = new int[] { 23, 35, 51, 59, 59 };  // repated 1x 4th number to fill gap
    faces[36] = new int[] {  0,  4,  6,  2,  2 };  // repated 1x 4th number to fill gap
    faces[37] = new int[] {  1,  3,  7,  5,  5 };  // repated 1x 4th number to fill gap
    faces[38] = new int[] {  8, 10, 11,  9,  9 };  // repated 1x 4th number to fill gap
    faces[39] = new int[] { 12, 13, 15, 14, 14 };  // repated 1x 4th number to fill gap
    faces[40] = new int[] { 16, 17, 21, 20, 20 };  // repated 1x 4th number to fill gap
    faces[41] = new int[] { 18, 22, 23, 19, 19 };  // repated 1x 4th number to fill gap
    faces[42] = new int[] { 24,  4,  0,  0,  0 };  // repated 2x 3rd number to fill gap
    faces[43] = new int[] { 25,  1,  5,  5,  5 };  // repated 2x 3rd number to fill gap
    faces[44] = new int[] { 26,  2,  6,  6,  6 };  // repated 2x 3rd number to fill gap
    faces[45] = new int[] { 27,  7,  3,  3,  3 };  // repated 2x 3rd number to fill gap
    faces[46] = new int[] { 28, 10,  8,  8,  8 };  // repated 2x 3rd number to fill gap
    faces[47] = new int[] { 29,  9, 11, 11, 11 };  // repated 2x 3rd number to fill gap
    faces[48] = new int[] { 30, 12, 14, 14, 14 };  // repated 2x 3rd number to fill gap
    faces[49] = new int[] { 31, 15, 13, 13, 13 };  // repated 2x 3rd number to fill gap
    faces[50] = new int[] { 32, 17, 16, 16, 16 };  // repated 2x 3rd number to fill gap
    faces[51] = new int[] { 33, 18, 19, 19, 19 };  // repated 2x 3rd number to fill gap
    faces[52] = new int[] { 34, 20, 21, 21, 21 };  // repated 2x 3rd number to fill gap
    faces[53] = new int[] { 35, 23, 22, 22, 22 };  // repated 2x 3rd number to fill gap
    faces[54] = new int[] { 36, 44, 52, 52, 52 };  // repated 2x 3rd number to fill gap
    faces[55] = new int[] { 37, 53, 45, 45, 45 };  // repated 2x 3rd number to fill gap
    faces[56] = new int[] { 38, 54, 46, 46, 46 };  // repated 2x 3rd number to fill gap
    faces[57] = new int[] { 39, 47, 55, 55, 55 };  // repated 2x 3rd number to fill gap
    faces[58] = new int[] { 40, 56, 48, 48, 48 };  // repated 2x 3rd number to fill gap
    faces[59] = new int[] { 41, 49, 57, 57, 57 };  // repated 2x 3rd number to fill gap
    faces[60] = new int[] { 42, 50, 58, 58, 58 };  // repated 2x 3rd number to fill gap
    faces[61] = new int[] { 43, 59, 51, 51, 51 };  // repated 2x 3rd number to fill gap
  } //end UniformGreatRhombicosidodecahedron()

  public String name() {
    return "Uniform Great Rhombicosidodecahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class UniformGreatRhombicosidodecahedron
/*
UniformGreatRhombicuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class UniformGreatRhombicuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 26;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.2071067811865475244008443621048f; //(sqrt(2) - 1) / 2
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private UniformGreatRhombicuboctahedron() {   
    // set vertices
    vert[  0] = new PVector( -0.5f, -0.5f,   C0 );
    vert[  1] = new PVector( -0.5f, -0.5f,  -C0 );
    vert[  2] = new PVector( -0.5f,  0.5f,   C0 );
    vert[  3] = new PVector( -0.5f,  0.5f,  -C0 );
    vert[  4] = new PVector(  0.5f, -0.5f,   C0 );
    vert[  5] = new PVector(  0.5f, -0.5f,  -C0 );
    vert[  6] = new PVector(  0.5f,  0.5f,   C0 );
    vert[  7] = new PVector(  0.5f,  0.5f,  -C0 );
    vert[  8] = new PVector(   C0, -0.5f, -0.5f );
    vert[  9] = new PVector(   C0, -0.5f,  0.5f );
    vert[ 10] = new PVector(   C0,  0.5f, -0.5f );
    vert[ 11] = new PVector(   C0,  0.5f,  0.5f );
    vert[ 12] = new PVector(  -C0, -0.5f, -0.5f );
    vert[ 13] = new PVector(  -C0, -0.5f,  0.5f );
    vert[ 14] = new PVector(  -C0,  0.5f, -0.5f );
    vert[ 15] = new PVector(  -C0,  0.5f,  0.5f );
    vert[ 16] = new PVector( -0.5f,   C0, -0.5f );
    vert[ 17] = new PVector( -0.5f,   C0,  0.5f );
    vert[ 18] = new PVector( -0.5f,  -C0, -0.5f );
    vert[ 19] = new PVector( -0.5f,  -C0,  0.5f );
    vert[ 20] = new PVector(  0.5f,   C0, -0.5f );
    vert[ 21] = new PVector(  0.5f,   C0,  0.5f );
    vert[ 22] = new PVector(  0.5f,  -C0, -0.5f );
    vert[ 23] = new PVector(  0.5f,  -C0,  0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  4,  6,  2 };
    faces[ 1] = new int[] {  1,  3,  7,  5 };
    faces[ 2] = new int[] {  8, 10, 11,  9 };
    faces[ 3] = new int[] { 12, 13, 15, 14 };
    faces[ 4] = new int[] { 16, 17, 21, 20 };
    faces[ 5] = new int[] { 18, 22, 23, 19 };
    faces[ 6] = new int[] {  0,  2, 10,  8 };
    faces[ 7] = new int[] {  0, 16, 20,  4 };
    faces[ 8] = new int[] {  7,  3, 19, 23 };
    faces[ 9] = new int[] {  7, 15, 13,  5 };
    faces[10] = new int[] { 11,  3,  1,  9 };
    faces[11] = new int[] { 11, 10, 18, 19 };
    faces[12] = new int[] { 12, 14,  6,  4 };
    faces[13] = new int[] { 12, 20, 21, 13 };
    faces[14] = new int[] { 17,  1,  5, 21 };
    faces[15] = new int[] { 17, 16,  8,  9 };
    faces[16] = new int[] { 22, 14, 15, 23 };
    faces[17] = new int[] { 22, 18,  2,  6 };
    faces[18] = new int[] {  0,  8, 16, 16 };  //repeated 1x 3rd number to fill gap
    faces[19] = new int[] {  1, 17,  9,  9 };  //repeated 1x 3rd number to fill gap
    faces[20] = new int[] {  2, 18, 10, 10 };  //repeated 1x 3rd number to fill gap
    faces[21] = new int[] {  3, 11, 19, 19 };  //repeated 1x 3rd number to fill gap
    faces[22] = new int[] {  4, 20, 12, 12 };  //repeated 1x 3rd number to fill gap
    faces[23] = new int[] {  5, 13, 21, 21 };  //repeated 1x 3rd number to fill gap
    faces[24] = new int[] {  6, 14, 22, 22 };  //repeated 1x 3rd number to fill gap
    faces[25] = new int[] {  7, 23, 15, 15 };  //repeated 1x 3rd number to fill gap
  } //end UniformGreatRhombicuboctahedron()

  public String name() {
    return "Uniform Great Rhombicuboctahedron";
  }

  public void render() {  
    if (nofill) {
      noFill();
    } else {
      fill(fc0, fc1, fc2, fc3);
    }
        
    if (nostroke) {
      noStroke();
    } else {
      stroke(sc0, sc1, sc2, sc3);
    }
    
    if (parentSphere) {
      //Get parent sphere radius
      r = radius + stray;
      //Convert spherical coordinates into Cartesian coordinates
      x = cos(theta) * sin(phi) * r;
      y = sin(theta) * sin(phi) * r;
      z = cos(phi) * r;
    }
    
    pushMatrix();
    translate(x, y, z);
    scale(scaleSize * zoom); 
    strokeWeight(sw);
    rotateX(rx);
    rotateY(ry);
    rotateZ(rz);
    for (int i = 0; i < FACES; i = i+1) {
      beginShape();
      for (int i2 = 0; i2 < VERTICES; i2 = i2+1) {
        vertex(vert[faces[i][i2]].x,vert[faces[i][i2]].y,vert[faces[i][i2]].z);
      } // end for
      endShape(CLOSE);
    } // end for 
    popMatrix();
  } //end render()
   
} //end class UniformGreatRhombicuboctahedron
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "test" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
