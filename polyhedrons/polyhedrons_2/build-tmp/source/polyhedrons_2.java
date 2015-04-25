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

public class polyhedrons_2 extends PApplet {

/*
Cube class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Cube extends Polyhedron {
  
  // polyhedron
  final int FACES = 6;     // number of faces 
  final int VERTICES = 4;  // VERTICES per face
  PVector[] vert = new PVector[8]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private Cube() {   
    // set vertices
    vert[ 0] = new PVector( 0.5f,  0.5f,  0.5f);
    vert[ 1] = new PVector( 0.5f,  0.5f, -0.5f);
    vert[ 2] = new PVector( 0.5f, -0.5f,  0.5f);
    vert[ 3] = new PVector( 0.5f, -0.5f, -0.5f);
    vert[ 4] = new PVector(-0.5f,  0.5f,  0.5f);
    vert[ 5] = new PVector(-0.5f,  0.5f, -0.5f);
    vert[ 6] = new PVector(-0.5f, -0.5f,  0.5f);
    vert[ 7] = new PVector(-0.5f, -0.5f, -0.5f);
    // set faces
    faces[ 0] = new int[] { 0, 1, 5, 4 };
    faces[ 1] = new int[] { 0, 4, 6, 2 };
    faces[ 2] = new int[] { 0, 2, 3, 1 };
    faces[ 3] = new int[] { 7, 3, 2, 6 };
    faces[ 4] = new int[] { 7, 6, 4, 5 };  
    faces[ 5] = new int[] { 7, 5, 1, 3 };
  } //end Cube()

  public String name() {
    return "Cube";
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
   
} //end class Cube
/*
Cuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Cuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048f; //sqrt(2) / 2
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Cuboctahedron() {   
    // set vertices
    vert[ 0] = new PVector(  C0, 0.0f,  C0 );
    vert[ 1] = new PVector(  C0, 0.0f, -C0 );
    vert[ 2] = new PVector( -C0, 0.0f,  C0 );
    vert[ 3] = new PVector( -C0, 0.0f, -C0 );
    vert[ 4] = new PVector(  C0,  C0, 0.0f );
    vert[ 5] = new PVector(  C0, -C0, 0.0f );
    vert[ 6] = new PVector( -C0,  C0, 0.0f );
    vert[ 7] = new PVector( -C0, -C0, 0.0f );
    vert[ 8] = new PVector( 0.0f,  C0,  C0 );
    vert[ 9] = new PVector( 0.0f,  C0, -C0 );
    vert[10] = new PVector( 0.0f, -C0,  C0 );
    vert[11] = new PVector( 0.0f, -C0, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  5,  1,  4 };
    faces[ 1] = new int[] { 0,  8,  2, 10 };
    faces[ 2] = new int[] { 7,  2,  6,  3 };
    faces[ 3] = new int[] { 7, 11,  5, 10 };
    faces[ 4] = new int[] { 9,  1, 11,  3 };
    faces[ 5] = new int[] { 9,  6,  8,  4 };
    faces[ 6] = new int[] { 0,  4,  8,  8 }; //added 1x 3rd number to fill gap
    faces[ 7] = new int[] { 1,  5, 11, 11 }; //added 1x 3rd number to fill gap
    faces[ 8] = new int[] { 2,  7, 10, 10 }; //added 1x 3rd number to fill gap
    faces[ 9] = new int[] { 3,  6,  9,  9 }; //added 1x 3rd number to fill gap
    faces[10] = new int[] { 4,  1,  9,  9 }; //added 1x 3rd number to fill gap
    faces[11] = new int[] { 5,  0, 10, 10 }; //added 1x 3rd number to fill gap
    faces[12] = new int[] { 6,  2,  8,  8 }; //added 1x 3rd number to fill gap
    faces[13] = new int[] { 7,  3, 11, 11 }; //added 1x 3rd number to fill gap
  } //end Cuboctahedron()

  public String name() {
    return "Cuboctahedron";
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
   
} //end class Cuboctahedron
/*
Cubohemioctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Cubohemioctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 10;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048f; //sqrt(2) / 2
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Cubohemioctahedron() {   
    // set vertices
    vert[ 0] = new PVector(  C0, 0.0f,  C0);
    vert[ 1] = new PVector(  C0, 0.0f, -C0);
    vert[ 2] = new PVector( -C0, 0.0f,  C0);
    vert[ 3] = new PVector( -C0, 0.0f, -C0);
    vert[ 4] = new PVector(  C0,  C0, 0.0f);
    vert[ 5] = new PVector(  C0, -C0, 0.0f);
    vert[ 6] = new PVector( -C0,  C0, 0.0f);
    vert[ 7] = new PVector( -C0, -C0, 0.0f);
    vert[ 8] = new PVector( 0.0f,  C0,  C0);
    vert[ 9] = new PVector( 0.0f,  C0, -C0);
    vert[10] = new PVector( 0.0f, -C0,  C0);
    vert[11] = new PVector( 0.0f, -C0, -C0);
    // set faces
    faces[ 0] = new int[] {  0,  4,  9,  3,  7, 10 };
    faces[ 1] = new int[] {  0,  5, 11,  3,  6,  8 };
    faces[ 2] = new int[] {  1,  4,  8,  2,  7, 11 };
    faces[ 3] = new int[] {  1,  5, 10,  2,  6,  9 };
    faces[ 4] = new int[] {  0,  5,  1,  4,  4,  4 }; //added 2x 4th number to fill gap
    faces[ 5] = new int[] {  0,  8,  2, 10, 10, 10 }; //added 2x 4th number to fill gap
    faces[ 6] = new int[] {  7,  2,  6,  3,  3,  3 }; //added 2x 4th number to fill gap
    faces[ 7] = new int[] {  7, 11,  5, 10, 10, 10 }; //added 2x 4th number to fill gap
    faces[ 8] = new int[] {  9,  1, 11,  3,  3,  3 }; //added 2x 4th number to fill gap
    faces[ 9] = new int[] {  9,  6,  8,  4,  4,  4 }; //added 2x 4th number to fill gap
  } //end Cubohemioctahedron()

  public String name() {
    return "Cubohemioctahedron";
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
   
} //end class Cubohemioctahedron
/*
DitrigonalDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class DitrigonalDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
   private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private DitrigonalDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,   C0,   C1 );
    vert[  1] = new PVector(  0.0f,   C0,  -C1 );
    vert[  2] = new PVector(  0.0f,  -C0,   C1 );
    vert[  3] = new PVector(  0.0f,  -C0,  -C1 );
    vert[  4] = new PVector(   C1,  0.0f,   C0 );
    vert[  5] = new PVector(   C1,  0.0f,  -C0 );
    vert[  6] = new PVector(  -C1,  0.0f,   C0 );
    vert[  7] = new PVector(  -C1,  0.0f,  -C0 );
    vert[  8] = new PVector(   C0,   C1,  0.0f );
    vert[  9] = new PVector(   C0,  -C1,  0.0f );
    vert[ 10] = new PVector(  -C0,   C1,  0.0f );
    vert[ 11] = new PVector(  -C0,  -C1,  0.0f );
    vert[ 12] = new PVector(  0.5f,  0.5f,  0.5f );
    vert[ 13] = new PVector(  0.5f,  0.5f, -0.5f );
    vert[ 14] = new PVector(  0.5f, -0.5f,  0.5f );
    vert[ 15] = new PVector(  0.5f, -0.5f, -0.5f );
    vert[ 16] = new PVector( -0.5f,  0.5f,  0.5f );
    vert[ 17] = new PVector( -0.5f,  0.5f, -0.5f );
    vert[ 18] = new PVector( -0.5f, -0.5f,  0.5f );
    vert[ 19] = new PVector( -0.5f, -0.5f, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  6,  2, 16, 18 };
    faces[ 1] = new int[] {  0,  8, 16, 12, 10 };
    faces[ 2] = new int[] {  0, 14, 12,  2,  4 };
    faces[ 3] = new int[] {  7,  1, 19, 17,  3 };
    faces[ 4] = new int[] {  7, 11,  6, 19, 18 };
    faces[ 5] = new int[] {  7, 16, 17,  6, 10 };
    faces[ 6] = new int[] {  9,  2, 11, 14, 18 };
    faces[ 7] = new int[] {  9,  5, 14, 15,  4 };
    faces[ 8] = new int[] {  9, 19, 15, 11,  3 };
    faces[ 9] = new int[] { 13, 12,  5,  8,  4 };
    faces[10] = new int[] { 13, 15,  1,  5,  3 };
    faces[11] = new int[] { 13, 17,  8,  1, 10 };
    faces[12] = new int[] {  0,  4, 15, 19,  6 };
    faces[13] = new int[] {  0, 10,  1, 15, 14 };
    faces[14] = new int[] {  0, 18, 19,  1,  8 };
    faces[15] = new int[] {  7,  3,  5, 12, 16 };
    faces[16] = new int[] {  7, 10, 12, 14, 11 };
    faces[17] = new int[] {  7, 18, 14,  5,  1 };
    faces[18] = new int[] {  9,  3, 17, 16,  2 };
    faces[19] = new int[] {  9,  4,  8, 17, 19 };
    faces[20] = new int[] {  9, 18, 16,  8,  5 };
    faces[21] = new int[] { 13,  3, 11,  2, 12 };
    faces[22] = new int[] { 13,  4,  2,  6, 17 };
    faces[23] = new int[] { 13, 10,  6, 11, 15 };
  } //end DitrigonalDodecadodecahedron()

  public String name() {
    return "Ditrigonal Dodecadodecahedron";
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
   
} //end class DitrigonalDodecadodecahedron
/*
Dodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Dodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
   private PVector[] vert = new PVector[30]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Dodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,  0.0f,  1.0f );
    vert[  1] = new PVector(  0.0f,  0.0f, -1.0f );
    vert[  2] = new PVector(  1.0f,  0.0f,  0.0f );
    vert[  3] = new PVector( -1.0f,  0.0f,  0.0f );
    vert[  4] = new PVector(  0.0f,  1.0f,  0.0f );
    vert[  5] = new PVector(  0.0f, -1.0f,  0.0f );
    vert[  6] = new PVector(   C0,  0.5f,   C1 );
    vert[  7] = new PVector(   C0,  0.5f,  -C1 );
    vert[  8] = new PVector(   C0, -0.5f,   C1 );
    vert[  9] = new PVector(   C0, -0.5f,  -C1 );
    vert[ 10] = new PVector(  -C0,  0.5f,   C1 );
    vert[ 11] = new PVector(  -C0,  0.5f,  -C1 );
    vert[ 12] = new PVector(  -C0, -0.5f,   C1 );
    vert[ 13] = new PVector(  -C0, -0.5f,  -C1 );
    vert[ 14] = new PVector(   C1,   C0,  0.5f );
    vert[ 15] = new PVector(   C1,   C0, -0.5f );
    vert[ 16] = new PVector(   C1,  -C0,  0.5f );
    vert[ 17] = new PVector(   C1,  -C0, -0.5f );
    vert[ 18] = new PVector(  -C1,   C0,  0.5f );
    vert[ 19] = new PVector(  -C1,   C0, -0.5f );
    vert[ 20] = new PVector(  -C1,  -C0,  0.5f );
    vert[ 21] = new PVector(  -C1,  -C0, -0.5f );
    vert[ 22] = new PVector(  0.5f,   C1,   C0 );
    vert[ 23] = new PVector(  0.5f,   C1,  -C0 );
    vert[ 24] = new PVector(  0.5f,  -C1,   C0 );
    vert[ 25] = new PVector(  0.5f,  -C1,  -C0 );
    vert[ 26] = new PVector( -0.5f,   C1,   C0 );
    vert[ 27] = new PVector( -0.5f,   C1,  -C0 );
    vert[ 28] = new PVector( -0.5f,  -C1,   C0 );
    vert[ 29] = new PVector( -0.5f,  -C1,  -C0 );
    // set faces
    faces[ 0] = new int[] { 0, 14, 23, 27, 18 };
    faces[ 1] = new int[] { 0, 18, 12, 10, 20 };
    faces[ 2] = new int[] { 0, 20, 29, 25, 16 };
    faces[ 3] = new int[] { 0, 16,  6,  8, 14 };
    faces[ 4] = new int[] { 1, 17, 24, 28, 21 };
    faces[ 5] = new int[] { 1, 21, 11, 13, 19 };
    faces[ 6] = new int[] { 1, 19, 26, 22, 15 };
    faces[ 7] = new int[] { 1, 15,  9,  7, 17 };
    faces[ 8] = new int[] { 2, 22, 10, 12, 24 };
    faces[ 9] = new int[] { 2, 24, 17, 16, 25 };
    faces[10] = new int[] { 2, 25, 13, 11, 23 };
    faces[11] = new int[] { 2, 23, 14, 15, 22 };
    faces[12] = new int[] { 3, 27,  7,  9, 29 };
    faces[13] = new int[] { 3, 29, 20, 21, 28 };
    faces[14] = new int[] { 3, 28,  8,  6, 26 };
    faces[15] = new int[] { 3, 26, 19, 18, 27 };
    faces[16] = new int[] { 4,  6, 16, 17,  7 };
    faces[17] = new int[] { 4,  7, 27, 23, 11 };
    faces[18] = new int[] { 4, 11, 21, 20, 10 };
    faces[19] = new int[] { 4, 10, 22, 26,  6 };
    faces[20] = new int[] { 5,  8, 28, 24, 12 };
    faces[21] = new int[] { 5, 12, 18, 19, 13 };
    faces[22] = new int[] { 5, 13, 25, 29,  9 };
    faces[23] = new int[] { 5,  9, 15, 14,  8 };
  } //end Dodecadodecahedron  //added 2x 3rd number to fill gap()

  public String name() {
    return "Dodecadodecahedron";
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
   
} //end class Dodecadodecahedron
/*
Dodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Dodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float A = 1.618033989f; // (1 + sqr(5) / 2) - wikipedia
  final float B = 0.618033989f; // 1 / (1 + sqr(5) / 2) - wikipedia
  private PVector[] vert = new PVector[20]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Dodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 1,  1,  1);
    vert[ 1] = new PVector( 1,  1, -1);
    vert[ 2] = new PVector( 1, -1,  1);
    vert[ 3] = new PVector( 1, -1, -1);  
    vert[ 4] = new PVector(-1,  1,  1);
    vert[ 5] = new PVector(-1,  1, -1);
    vert[ 6] = new PVector(-1, -1,  1);
    vert[ 7] = new PVector(-1, -1, -1); 
    vert[ 8] = new PVector( 0,  B,  A);
    vert[ 9] = new PVector( 0,  B, -A);
    vert[10] = new PVector( 0, -B,  A);
    vert[11] = new PVector( 0, -B, -A); 
    vert[12] = new PVector( B,  A,  0);
    vert[13] = new PVector( B, -A,  0);
    vert[14] = new PVector(-B,  A,  0);
    vert[15] = new PVector(-B, -A,  0);
    vert[16] = new PVector( A,  0,  B);
    vert[17] = new PVector( A,  0, -B);
    vert[18] = new PVector(-A,  0,  B);
    vert[19] = new PVector(-A,  0, -B); 
    // set faces
    faces[ 0] = new int[] { 0, 16,  2, 10,  8};
    faces[ 1] = new int[] { 0,  8,  4, 14, 12};
    faces[ 2] = new int[] {16, 17,  1, 12,  0};
    faces[ 3] = new int[] { 1,  9, 11,  3, 17};
    faces[ 4] = new int[] { 1, 12, 14,  5,  9};
    faces[ 5] = new int[] { 2, 13, 15,  6, 10};
    faces[ 6] = new int[] {13,  3, 17, 16,  2};
    faces[ 7] = new int[] { 3, 11,  7, 15, 13};
    faces[ 8] = new int[] { 4,  8, 10,  6, 18};
    faces[ 9] = new int[] {14,  5, 19, 18,  4};
    faces[10] = new int[] { 5, 19,  7, 11,  9};
    faces[11] = new int[] {15,  7, 19, 18,  6};
  } //end dodecahedron()

  public String name() {
    return "Dodecahedron";
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
   
} //end class Dodecahedron
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
GreatDirhombicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDirhombicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 124;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.142901106756847359195252445424f;  //sqrt(2 * (3 - sqrt(5) - sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C1 = 0.1817730157320175301311393090951f; //sqrt(2 * (sqrt(5) - 1 - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C2 = 0.231218847762556282665656293378f;  //sqrt(2 * (2 - sqrt(2 * (sqrt(5) - 1)))) / 4
  final float C3 = 0.412991863494573812796795602473f;  //sqrt(2 * (3 - sqrt(5) + sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C4 = 0.437016024448821070799301205056f;  //sqrt((3 - sqrt(5)) / 4)
  final float C5 = 0.525333765454529994269705053010f;  //sqrt(2 * (sqrt(5) - 1 + 2 * sqrt(sqrt(5) - 2))) / 4
  final float C6 = 0.555892970251421171992048047898f;  //sqrt((sqrt(5) - 1) / 4)
  final float C7 = 0.668234872211377353464957498434f;  //sqrt(2 * (2 + sqrt(2 * (sqrt(5) - 1)))) / 4
  
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDirhombicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  C1,  C0,  C7 );
    vert[  1] = new PVector(  C1,  C0, -C7 );
    vert[  2] = new PVector(  C1, -C0,  C7 );
    vert[  3] = new PVector(  C1, -C0, -C7 );
    vert[  4] = new PVector( -C1,  C0,  C7 );
    vert[  5] = new PVector( -C1,  C0, -C7 );
    vert[  6] = new PVector( -C1, -C0,  C7 );
    vert[  7] = new PVector( -C1, -C0, -C7 );
    vert[  8] = new PVector(  C7,  C1,  C0 );
    vert[  9] = new PVector(  C7,  C1, -C0 );
    vert[ 10] = new PVector(  C7, -C1,  C0 );
    vert[ 11] = new PVector(  C7, -C1, -C0 );
    vert[ 12] = new PVector( -C7,  C1,  C0 );
    vert[ 13] = new PVector( -C7,  C1, -C0 );
    vert[ 14] = new PVector( -C7, -C1,  C0 );
    vert[ 15] = new PVector( -C7, -C1, -C0 );
    vert[ 16] = new PVector(  C0,  C7,  C1 );
    vert[ 17] = new PVector(  C0,  C7, -C1 );
    vert[ 18] = new PVector(  C0, -C7,  C1 );
    vert[ 19] = new PVector(  C0, -C7, -C1 );
    vert[ 20] = new PVector( -C0,  C7,  C1 );
    vert[ 21] = new PVector( -C0,  C7, -C1 );
    vert[ 22] = new PVector( -C0, -C7,  C1 );
    vert[ 23] = new PVector( -C0, -C7, -C1 );
    vert[ 24] = new PVector( 0.0f,  C4,  C6 );
    vert[ 25] = new PVector( 0.0f,  C4, -C6 );
    vert[ 26] = new PVector( 0.0f, -C4,  C6 );
    vert[ 27] = new PVector( 0.0f, -C4, -C6 );
    vert[ 28] = new PVector(  C6, 0.0f,  C4 );
    vert[ 29] = new PVector(  C6, 0.0f, -C4 );
    vert[ 30] = new PVector( -C6, 0.0f,  C4 );
    vert[ 31] = new PVector( -C6, 0.0f, -C4 );
    vert[ 32] = new PVector(  C4,  C6, 0.0f );
    vert[ 33] = new PVector(  C4, -C6, 0.0f );
    vert[ 34] = new PVector( -C4,  C6, 0.0f );
    vert[ 35] = new PVector( -C4, -C6, 0.0f );
    vert[ 36] = new PVector(  C3,  C2,  C5 );
    vert[ 37] = new PVector(  C3,  C2, -C5 );
    vert[ 38] = new PVector(  C3, -C2,  C5 );
    vert[ 39] = new PVector(  C3, -C2, -C5 );
    vert[ 40] = new PVector( -C3,  C2,  C5 );
    vert[ 41] = new PVector( -C3,  C2, -C5 );
    vert[ 42] = new PVector( -C3, -C2,  C5 );
    vert[ 43] = new PVector( -C3, -C2, -C5 );
    vert[ 44] = new PVector(  C5,  C3,  C2 );
    vert[ 45] = new PVector(  C5,  C3, -C2 );
    vert[ 46] = new PVector(  C5, -C3,  C2 );
    vert[ 47] = new PVector(  C5, -C3, -C2 );
    vert[ 48] = new PVector( -C5,  C3,  C2 );
    vert[ 49] = new PVector( -C5,  C3, -C2 );
    vert[ 50] = new PVector( -C5, -C3,  C2 );
    vert[ 51] = new PVector( -C5, -C3, -C2 );
    vert[ 52] = new PVector(  C2,  C5,  C3 );
    vert[ 53] = new PVector(  C2,  C5, -C3 );
    vert[ 54] = new PVector(  C2, -C5,  C3 );
    vert[ 55] = new PVector(  C2, -C5, -C3 );
    vert[ 56] = new PVector( -C2,  C5,  C3 );
    vert[ 57] = new PVector( -C2,  C5, -C3 );
    vert[ 58] = new PVector( -C2, -C5,  C3 );
    vert[ 59] = new PVector( -C2, -C5, -C3 );
    // set faces
    faces[  0] = new int[] { 16, 10, 53, 36, 29 };
    faces[  1] = new int[] { 16, 41, 45, 34,  1 };
    faces[  2] = new int[] { 17, 11, 52, 37, 28 };
    faces[  3] = new int[] { 17, 40, 44, 34,  0 };
    faces[  4] = new int[] { 18,  8, 55, 38, 29 };
    faces[  5] = new int[] { 18, 43, 47, 35,  3 };
    faces[  6] = new int[] { 19,  9, 54, 39, 28 };
    faces[  7] = new int[] { 19, 42, 46, 35,  2 };
    faces[  8] = new int[] { 20, 14, 57, 40, 31 };
    faces[  9] = new int[] { 20, 37, 49, 32,  5 };
    faces[ 10] = new int[] { 21, 15, 56, 41, 30 };
    faces[ 11] = new int[] { 21, 36, 48, 32,  4 };
    faces[ 12] = new int[] { 22, 12, 59, 42, 31 };
    faces[ 13] = new int[] { 22, 39, 51, 33,  7 };
    faces[ 14] = new int[] { 23, 13, 58, 43, 30 };
    faces[ 15] = new int[] { 23, 38, 50, 33,  6 };
    faces[ 16] = new int[] { 24, 10,  6, 44, 54 };
    faces[ 17] = new int[] { 24, 14,  2, 48, 58 };
    faces[ 18] = new int[] { 25, 11,  7, 45, 55 };
    faces[ 19] = new int[] { 25, 15,  3, 49, 59 };
    faces[ 20] = new int[] { 26,  8,  4, 46, 52 };
    faces[ 21] = new int[] { 26, 12,  0, 50, 56 };
    faces[ 22] = new int[] { 27,  9,  5, 47, 53 };
    faces[ 23] = new int[] { 27, 13,  1, 51, 57 };
    faces[ 24] = new int[] {  0, 12,  7, 11, 11 };  //added 1x 4th row to fill gaps
    faces[ 25] = new int[] {  0, 34,  7, 33, 33 };  //added 1x 4th row to fill gaps
    faces[ 26] = new int[] {  2, 14,  5,  9,  9 };  //added 1x 4th row to fill gaps
    faces[ 27] = new int[] {  2, 35,  5, 32, 32 };  //added 1x 4th row to fill gaps
    faces[ 28] = new int[] {  4,  8,  3, 15, 15 };  //added 1x 4th row to fill gaps
    faces[ 29] = new int[] {  4, 32,  3, 35, 35 };  //added 1x 4th row to fill gaps
    faces[ 30] = new int[] {  6, 10,  1, 13, 13 };  //added 1x 4th row to fill gaps
    faces[ 31] = new int[] {  6, 33,  1, 34, 34 };  //added 1x 4th row to fill gaps
    faces[ 32] = new int[] {  8, 18, 15, 21, 21 };  //added 1x 4th row to fill gaps
    faces[ 33] = new int[] {  8, 26, 15, 25, 25 };  //added 1x 4th row to fill gaps
    faces[ 34] = new int[] { 10, 16, 13, 23, 23 };  //added 1x 4th row to fill gaps
    faces[ 35] = new int[] { 10, 24, 13, 27, 27 };  //added 1x 4th row to fill gaps
    faces[ 36] = new int[] { 12, 22, 11, 17, 17 };  //added 1x 4th row to fill gaps
    faces[ 37] = new int[] { 12, 26, 11, 25, 25 };  //added 1x 4th row to fill gaps
    faces[ 38] = new int[] { 14, 20,  9, 19, 19 };  //added 1x 4th row to fill gaps
    faces[ 39] = new int[] { 14, 24,  9, 27, 27 };  //added 1x 4th row to fill gaps
    faces[ 40] = new int[] { 16,  1, 23,  6,  6 };  //added 1x 4th row to fill gaps
    faces[ 41] = new int[] { 16, 29, 23, 30, 30 };  //added 1x 4th row to fill gaps
    faces[ 42] = new int[] { 18,  3, 21,  4,  4 };  //added 1x 4th row to fill gaps
    faces[ 43] = new int[] { 18, 29, 21, 30, 30 };  //added 1x 4th row to fill gaps
    faces[ 44] = new int[] { 20,  5, 19,  2,  2 };  //added 1x 4th row to fill gaps
    faces[ 45] = new int[] { 20, 31, 19, 28, 28 };  //added 1x 4th row to fill gaps
    faces[ 46] = new int[] { 22,  7, 17,  0,  0 };  //added 1x 4th row to fill gaps
    faces[ 47] = new int[] { 22, 31, 17, 28, 28 };  //added 1x 4th row to fill gaps
    faces[ 48] = new int[] { 24, 54, 27, 57, 57 };  //added 1x 4th row to fill gaps
    faces[ 49] = new int[] { 24, 58, 27, 53, 53 };  //added 1x 4th row to fill gaps
    faces[ 50] = new int[] { 26, 52, 25, 59, 59 };  //added 1x 4th row to fill gaps
    faces[ 51] = new int[] { 26, 56, 25, 55, 55 };  //added 1x 4th row to fill gaps
    faces[ 52] = new int[] { 28, 37, 31, 42, 42 };  //added 1x 4th row to fill gaps
    faces[ 53] = new int[] { 28, 39, 31, 40, 40 };  //added 1x 4th row to fill gaps
    faces[ 54] = new int[] { 30, 41, 29, 38, 38 };  //added 1x 4th row to fill gaps
    faces[ 55] = new int[] { 30, 43, 29, 36, 36 };  //added 1x 4th row to fill gaps
    faces[ 56] = new int[] { 32, 48, 35, 47, 47 };  //added 1x 4th row to fill gaps
    faces[ 57] = new int[] { 32, 49, 35, 46, 46 };  //added 1x 4th row to fill gaps
    faces[ 58] = new int[] { 34, 44, 33, 51, 51 };  //added 1x 4th row to fill gaps
    faces[ 59] = new int[] { 34, 45, 33, 50, 50 };  //added 1x 4th row to fill gaps
    faces[ 60] = new int[] { 36, 21, 43, 18, 18 };  //added 1x 4th row to fill gaps
    faces[ 61] = new int[] { 36, 47, 43, 48, 48 };  //added 1x 4th row to fill gaps
    faces[ 62] = new int[] { 38, 23, 41, 16, 16 };  //added 1x 4th row to fill gaps
    faces[ 63] = new int[] { 38, 45, 41, 50, 50 };  //added 1x 4th row to fill gaps
    faces[ 64] = new int[] { 40, 17, 39, 22, 22 };  //added 1x 4th row to fill gaps
    faces[ 65] = new int[] { 40, 51, 39, 44, 44 };  //added 1x 4th row to fill gaps
    faces[ 66] = new int[] { 42, 19, 37, 20, 20 };  //added 1x 4th row to fill gaps
    faces[ 67] = new int[] { 42, 49, 37, 46, 46 };  //added 1x 4th row to fill gaps
    faces[ 68] = new int[] { 44,  6, 51,  1,  1 };  //added 1x 4th row to fill gaps
    faces[ 69] = new int[] { 44, 57, 51, 54, 54 };  //added 1x 4th row to fill gaps
    faces[ 70] = new int[] { 46,  4, 49,  3,  3 };  //added 1x 4th row to fill gaps
    faces[ 71] = new int[] { 46, 59, 49, 52, 52 };  //added 1x 4th row to fill gaps
    faces[ 72] = new int[] { 48,  2, 47,  5,  5 };  //added 1x 4th row to fill gaps
    faces[ 73] = new int[] { 48, 53, 47, 58, 58 };  //added 1x 4th row to fill gaps
    faces[ 74] = new int[] { 50,  0, 45,  7,  7 };  //added 1x 4th row to fill gaps
    faces[ 75] = new int[] { 50, 55, 45, 56, 56 };  //added 1x 4th row to fill gaps
    faces[ 76] = new int[] { 52, 11, 59, 12, 12 };  //added 1x 4th row to fill gaps
    faces[ 77] = new int[] { 52, 42, 59, 37, 37 };  //added 1x 4th row to fill gaps
    faces[ 78] = new int[] { 54,  9, 57, 14, 14 };  //added 1x 4th row to fill gaps
    faces[ 79] = new int[] { 54, 40, 57, 39, 39 };  //added 1x 4th row to fill gaps
    faces[ 80] = new int[] { 56, 15, 55,  8,  8 };  //added 1x 4th row to fill gaps
    faces[ 81] = new int[] { 56, 38, 55, 41, 41 };  //added 1x 4th row to fill gaps
    faces[ 82] = new int[] { 58, 13, 53, 10, 10 };  //added 1x 4th row to fill gaps
    faces[ 83] = new int[] { 58, 36, 53, 43, 43 };  //added 1x 4th row to fill gaps
    faces[ 84] = new int[] {  0, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] {  0, 33, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] {  1, 10, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] {  1, 33, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] {  2,  9, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] {  2, 32, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] {  3,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] {  3, 32, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] {  4, 15, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] {  4, 35, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] {  5, 14, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] {  5, 35, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] {  6, 13, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] {  6, 34, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] {  7, 12, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] {  7, 34, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 24, 53, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 24, 57,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 25, 52, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 25, 56,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[104] = new int[] { 26, 55, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[105] = new int[] { 26, 59, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[106] = new int[] { 27, 54, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[107] = new int[] { 27, 58, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[108] = new int[] { 36, 18, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[109] = new int[] { 36, 58, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 37, 19, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[111] = new int[] { 37, 59, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[112] = new int[] { 38, 16, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[113] = new int[] { 38, 56, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[114] = new int[] { 39, 17, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[115] = new int[] { 39, 57, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[116] = new int[] { 40, 22, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[117] = new int[] { 40, 54, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[118] = new int[] { 41, 23, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[119] = new int[] { 41, 55, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 42, 20, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[121] = new int[] { 42, 52, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[122] = new int[] { 43, 21, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[123] = new int[] { 43, 53, 48, 48, 48 };  //added 2x 3rd row to fill gaps
  } //end GreatDirhombicosidodecahedron()

  public String name() {
    return "Great Dirhombicosidodecahedron";
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
   
} //end class GreatDirhombicosidodecahedron
/*
GreatDisdyakisDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDisdyakisDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 48;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.783611624891224327544304620751f;   //3 * (2 * sqrt(2) - 1) / 7
  final float C1 = 0.961131723051122205602171216841f;   //3 * (3 * sqrt(2) - 2) / 7
  final float C2 = 1.41421356237309504880168872421f;    //sqrt(2)
  private PVector[] vert = new PVector[26]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDisdyakisDodecahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0f, 0.0f,  C1 );
    vert[  1] = new PVector( 0.0f, 0.0f, -C1 );
    vert[  2] = new PVector(  C1, 0.0f, 0.0f );
    vert[  3] = new PVector( -C1, 0.0f, 0.0f );
    vert[  4] = new PVector( 0.0f,  C1, 0.0f );
    vert[  5] = new PVector( 0.0f, -C1, 0.0f );
    vert[  6] = new PVector(  C0, 0.0f,  C0 );
    vert[  7] = new PVector(  C0, 0.0f, -C0 );
    vert[  8] = new PVector( -C0, 0.0f,  C0 );
    vert[  9] = new PVector( -C0, 0.0f, -C0 );
    vert[ 10] = new PVector(  C0,  C0, 0.0f );
    vert[ 11] = new PVector(  C0, -C0, 0.0f );
    vert[ 12] = new PVector( -C0,  C0, 0.0f );
    vert[ 13] = new PVector( -C0, -C0, 0.0f );
    vert[ 14] = new PVector( 0.0f,  C0,  C0 );
    vert[ 15] = new PVector( 0.0f,  C0, -C0 );
    vert[ 16] = new PVector( 0.0f, -C0,  C0 );
    vert[ 17] = new PVector( 0.0f, -C0, -C0 );
    vert[ 18] = new PVector(  C2,  C2,  C2 );
    vert[ 19] = new PVector(  C2,  C2, -C2 );
    vert[ 20] = new PVector(  C2, -C2,  C2 );
    vert[ 21] = new PVector(  C2, -C2, -C2 );
    vert[ 22] = new PVector( -C2,  C2,  C2 );
    vert[ 23] = new PVector( -C2,  C2, -C2 );
    vert[ 24] = new PVector( -C2, -C2,  C2 );
    vert[ 25] = new PVector( -C2, -C2, -C2 );
    // set faces
    faces[  0] = new int[] { 0,  6, 18 };
    faces[  1] = new int[] { 0, 18, 14 };
    faces[  2] = new int[] { 0, 14, 22 };
    faces[  3] = new int[] { 0, 22,  8 };
    faces[  4] = new int[] { 0,  8, 24 };
    faces[  5] = new int[] { 0, 24, 16 };
    faces[  6] = new int[] { 0, 16, 20 };
    faces[  7] = new int[] { 0, 20,  6 };
    faces[  8] = new int[] { 1,  7, 21 };
    faces[  9] = new int[] { 1, 21, 17 };
    faces[ 10] = new int[] { 1, 17, 25 };
    faces[ 11] = new int[] { 1, 25,  9 };
    faces[ 12] = new int[] { 1,  9, 23 };
    faces[ 13] = new int[] { 1, 23, 15 };
    faces[ 14] = new int[] { 1, 15, 19 };
    faces[ 15] = new int[] { 1, 19,  7 };
    faces[ 16] = new int[] { 2,  6, 20 };
    faces[ 17] = new int[] { 2, 20, 11 };
    faces[ 18] = new int[] { 2, 11, 21 };
    faces[ 19] = new int[] { 2, 21,  7 };
    faces[ 20] = new int[] { 2,  7, 19 };
    faces[ 21] = new int[] { 2, 19, 10 };
    faces[ 22] = new int[] { 2, 10, 18 };
    faces[ 23] = new int[] { 2, 18,  6 };
    faces[ 24] = new int[] { 3,  8, 22 };
    faces[ 25] = new int[] { 3, 22, 12 };
    faces[ 26] = new int[] { 3, 12, 23 };
    faces[ 27] = new int[] { 3, 23,  9 };
    faces[ 28] = new int[] { 3,  9, 25 };
    faces[ 29] = new int[] { 3, 25, 13 };
    faces[ 30] = new int[] { 3, 13, 24 };
    faces[ 31] = new int[] { 3, 24,  8 };
    faces[ 32] = new int[] { 4, 10, 19 };
    faces[ 33] = new int[] { 4, 19, 15 };
    faces[ 34] = new int[] { 4, 15, 23 };
    faces[ 35] = new int[] { 4, 23, 12 };
    faces[ 36] = new int[] { 4, 12, 22 };
    faces[ 37] = new int[] { 4, 22, 14 };
    faces[ 38] = new int[] { 4, 14, 18 };
    faces[ 39] = new int[] { 4, 18, 10 };
    faces[ 40] = new int[] { 5, 11, 20 };
    faces[ 41] = new int[] { 5, 20, 16 };
    faces[ 42] = new int[] { 5, 16, 24 };
    faces[ 43] = new int[] { 5, 24, 13 };
    faces[ 44] = new int[] { 5, 13, 25 };
    faces[ 45] = new int[] { 5, 25, 17 };
    faces[ 46] = new int[] { 5, 17, 21 };
    faces[ 47] = new int[] { 5, 21, 11 };
  } //end GreatDisdyakisDodecahedron()

  public String name() {
    return "Great Disdyakis Dodecahedron";
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
   
} //end class GreatDisdyakisDodecahedron
/*
GreatDisdyakisTriacontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDisdyakisTriacontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 120;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.332412831988765413567097976006f; //3 * (25 - 9 * sqrt(5)) / 44
  final float C1 = 0.512461179749810726768256301858f; //3 * (3 * sqrt(5) - 5) / 10
  final float C2 = 0.537855260454430743495912910217f; //3 * (4 * sqrt(5) - 5) / 22
  final float C3 = 0.829179606750063091077247899381f; //3 * (5 - sqrt(5)) / 10
  final float C4 = 0.870268092443196157063010886223f; //3 * (15 - sqrt(5)) / 44
  final float C5 = 1.07571052090886148699182582043f;  //3 * (4 * sqrt(5) - 5) / 11
  final float C6 = 1.38196601125010515179541316563f;  //(5 - sqrt(5)) / 2
  final float C7 = 2.23606797749978969640917366873f;  //sqrt(5)
  final float C8 = 3.61803398874989484820458683437f;  //(5 + sqrt(5)) / 2
  private PVector[] vert = new PVector[104]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDisdyakisTriacontahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0f, -0.0f, -C5 );
    vert[  1] = new PVector( 0.0f, -0.0f,  C5 );
    vert[  2] = new PVector( 0.0f,  -C5, 0.0f );
    vert[  3] = new PVector( 0.0f,   C5, 0.0f );
    vert[  4] = new PVector( -C5, -0.0f, 0.0f );
    vert[  5] = new PVector(  C5, -0.0f, 0.0f );
    vert[  6] = new PVector(  C8, -0.0f,  C6 );
    vert[  7] = new PVector(  C8, -0.0f, -C6 );
    vert[  8] = new PVector( -C8, -0.0f,  C6 );
    vert[  9] = new PVector( -C8, -0.0f, -C6 );
    vert[ 10] = new PVector( 0.0f,   C6,  C8 );
    vert[ 11] = new PVector( 0.0f,   C6, -C8 );
    vert[ 12] = new PVector( 0.0f,  -C6,  C8 );
    vert[ 13] = new PVector( 0.0f,  -C6, -C8 );
    vert[ 14] = new PVector(  C6,   C8, 0.0f );
    vert[ 15] = new PVector( -C6,   C8, 0.0f );
    vert[ 16] = new PVector(  C6,  -C8, 0.0f );
    vert[ 17] = new PVector( -C6,  -C8, 0.0f );
    vert[ 18] = new PVector( 0.0f,   C3, -C1 );
    vert[ 19] = new PVector( 0.0f,   C3,  C1 );
    vert[ 20] = new PVector( 0.0f,  -C3, -C1 );
    vert[ 21] = new PVector( 0.0f,  -C3,  C1 );
    vert[ 22] = new PVector(  C3,  -C1, 0.0f );
    vert[ 23] = new PVector( -C3,  -C1, 0.0f );
    vert[ 24] = new PVector(  C3,   C1, 0.0f );
    vert[ 25] = new PVector( -C3,   C1, 0.0f );
    vert[ 26] = new PVector( -C1, -0.0f,  C3 );
    vert[ 27] = new PVector( -C1, -0.0f, -C3 );
    vert[ 28] = new PVector(  C1, -0.0f,  C3 );
    vert[ 29] = new PVector(  C1, -0.0f, -C3 );
    vert[ 30] = new PVector( -C2,   C4,  C0 );
    vert[ 31] = new PVector( -C2,   C4, -C0 );
    vert[ 32] = new PVector(  C2,   C4,  C0 );
    vert[ 33] = new PVector(  C2,   C4, -C0 );
    vert[ 34] = new PVector( -C2,  -C4,  C0 );
    vert[ 35] = new PVector( -C2,  -C4, -C0 );
    vert[ 36] = new PVector(  C2,  -C4,  C0 );
    vert[ 37] = new PVector(  C2,  -C4, -C0 );
    vert[ 38] = new PVector(  C4,   C0, -C2 );
    vert[ 39] = new PVector(  C4,   C0,  C2 );
    vert[ 40] = new PVector( -C4,   C0, -C2 );
    vert[ 41] = new PVector( -C4,   C0,  C2 );
    vert[ 42] = new PVector(  C4,  -C0, -C2 );
    vert[ 43] = new PVector(  C4,  -C0,  C2 );
    vert[ 44] = new PVector( -C4,  -C0, -C2 );
    vert[ 45] = new PVector( -C4,  -C0,  C2 );
    vert[ 46] = new PVector(  C0,  -C2,  C4 );
    vert[ 47] = new PVector(  C0,  -C2, -C4 );
    vert[ 48] = new PVector( -C0,  -C2,  C4 );
    vert[ 49] = new PVector( -C0,  -C2, -C4 );
    vert[ 50] = new PVector(  C0,   C2,  C4 );
    vert[ 51] = new PVector(  C0,   C2, -C4 );
    vert[ 52] = new PVector( -C0,   C2,  C4 );
    vert[ 53] = new PVector( -C0,   C2, -C4 );
    vert[ 54] = new PVector( -C7,  -C7, -C7 );
    vert[ 55] = new PVector( -C7,  -C7,  C7 );
    vert[ 56] = new PVector(  C7,  -C7, -C7 );
    vert[ 57] = new PVector(  C7,  -C7,  C7 );
    vert[ 58] = new PVector( -C7,   C7, -C7 );
    vert[ 59] = new PVector( -C7,   C7,  C7 );
    vert[ 60] = new PVector(  C7,   C7, -C7 );
    vert[ 61] = new PVector(  C7,   C7,  C7 );
    // set faces
    faces[  0] = new int[] { 18,  0,  8 };
    faces[  1] = new int[] { 18,  8, 32 };
    faces[  2] = new int[] { 18, 32, 56 };
    faces[  3] = new int[] { 18, 56, 40 };
    faces[  4] = new int[] { 18, 40, 10 };
    faces[  5] = new int[] { 18, 10, 38 };
    faces[  6] = new int[] { 18, 38, 54 };
    faces[  7] = new int[] { 18, 54, 30 };
    faces[  8] = new int[] { 18, 30,  6 };
    faces[  9] = new int[] { 18,  6,  0 };
    faces[ 10] = new int[] { 19,  1,  7 };
    faces[ 11] = new int[] { 19,  7, 31 };
    faces[ 12] = new int[] { 19, 31, 55 };
    faces[ 13] = new int[] { 19, 55, 39 };
    faces[ 14] = new int[] { 19, 39, 11 };
    faces[ 15] = new int[] { 19, 11, 41 };
    faces[ 16] = new int[] { 19, 41, 57 };
    faces[ 17] = new int[] { 19, 57, 33 };
    faces[ 18] = new int[] { 19, 33,  9 };
    faces[ 19] = new int[] { 19,  9,  1 };
    faces[ 20] = new int[] { 20,  0,  6 };
    faces[ 21] = new int[] { 20,  6, 34 };
    faces[ 22] = new int[] { 20, 34, 58 };
    faces[ 23] = new int[] { 20, 58, 42 };
    faces[ 24] = new int[] { 20, 42, 12 };
    faces[ 25] = new int[] { 20, 12, 44 };
    faces[ 26] = new int[] { 20, 44, 60 };
    faces[ 27] = new int[] { 20, 60, 36 };
    faces[ 28] = new int[] { 20, 36,  8 };
    faces[ 29] = new int[] { 20,  8,  0 };
    faces[ 30] = new int[] { 21,  1,  9 };
    faces[ 31] = new int[] { 21,  9, 37 };
    faces[ 32] = new int[] { 21, 37, 61 };
    faces[ 33] = new int[] { 21, 61, 45 };
    faces[ 34] = new int[] { 21, 45, 13 };
    faces[ 35] = new int[] { 21, 13, 43 };
    faces[ 36] = new int[] { 21, 43, 59 };
    faces[ 37] = new int[] { 21, 59, 35 };
    faces[ 38] = new int[] { 21, 35,  7 };
    faces[ 39] = new int[] { 21,  7,  1 };
    faces[ 40] = new int[] { 22,  2, 11 };
    faces[ 41] = new int[] { 22, 11, 39 };
    faces[ 42] = new int[] { 22, 39, 55 };
    faces[ 43] = new int[] { 22, 55, 47 };
    faces[ 44] = new int[] { 22, 47, 14 };
    faces[ 45] = new int[] { 22, 14, 46 };
    faces[ 46] = new int[] { 22, 46, 54 };
    faces[ 47] = new int[] { 22, 54, 38 };
    faces[ 48] = new int[] { 22, 38, 10 };
    faces[ 49] = new int[] { 22, 10,  2 };
    faces[ 50] = new int[] { 23,  2, 10 };
    faces[ 51] = new int[] { 23, 10, 40 };
    faces[ 52] = new int[] { 23, 40, 56 };
    faces[ 53] = new int[] { 23, 56, 48 };
    faces[ 54] = new int[] { 23, 48, 15 };
    faces[ 55] = new int[] { 23, 15, 49 };
    faces[ 56] = new int[] { 23, 49, 57 };
    faces[ 57] = new int[] { 23, 57, 41 };
    faces[ 58] = new int[] { 23, 41, 11 };
    faces[ 59] = new int[] { 23, 11,  2 };
    faces[ 60] = new int[] { 24,  3, 12 };
    faces[ 61] = new int[] { 24, 12, 42 };
    faces[ 62] = new int[] { 24, 42, 58 };
    faces[ 63] = new int[] { 24, 58, 50 };
    faces[ 64] = new int[] { 24, 50, 16 };
    faces[ 65] = new int[] { 24, 16, 51 };
    faces[ 66] = new int[] { 24, 51, 59 };
    faces[ 67] = new int[] { 24, 59, 43 };
    faces[ 68] = new int[] { 24, 43, 13 };
    faces[ 69] = new int[] { 24, 13,  3 };
    faces[ 70] = new int[] { 25,  3, 13 };
    faces[ 71] = new int[] { 25, 13, 45 };
    faces[ 72] = new int[] { 25, 45, 61 };
    faces[ 73] = new int[] { 25, 61, 53 };
    faces[ 74] = new int[] { 25, 53, 17 };
    faces[ 75] = new int[] { 25, 17, 52 };
    faces[ 76] = new int[] { 25, 52, 60 };
    faces[ 77] = new int[] { 25, 60, 44 };
    faces[ 78] = new int[] { 25, 44, 12 };
    faces[ 79] = new int[] { 25, 12,  3 };
    faces[ 80] = new int[] { 26,  4, 16 };
    faces[ 81] = new int[] { 26, 16, 50 };
    faces[ 82] = new int[] { 26, 50, 58 };
    faces[ 83] = new int[] { 26, 58, 34 };
    faces[ 84] = new int[] { 26, 34,  6 };
    faces[ 85] = new int[] { 26,  6, 30 };
    faces[ 86] = new int[] { 26, 30, 54 };
    faces[ 87] = new int[] { 26, 54, 46 };
    faces[ 88] = new int[] { 26, 46, 14 };
    faces[ 89] = new int[] { 26, 14,  4 };
    faces[ 90] = new int[] { 27,  4, 14 };
    faces[ 91] = new int[] { 27, 14, 47 };
    faces[ 92] = new int[] { 27, 47, 55 };
    faces[ 93] = new int[] { 27, 55, 31 };
    faces[ 94] = new int[] { 27, 31,  7 };
    faces[ 95] = new int[] { 27,  7, 35 };
    faces[ 96] = new int[] { 27, 35, 59 };
    faces[ 97] = new int[] { 27, 59, 51 };
    faces[ 98] = new int[] { 27, 51, 16 };
    faces[ 99] = new int[] { 27, 16,  4 };
    faces[100] = new int[] { 28,  5, 15 };
    faces[101] = new int[] { 28, 15, 48 };
    faces[102] = new int[] { 28, 48, 56 };
    faces[103] = new int[] { 28, 56, 32 };
    faces[104] = new int[] { 28, 32,  8 };
    faces[105] = new int[] { 28,  8, 36 };
    faces[106] = new int[] { 28, 36, 60 };
    faces[107] = new int[] { 28, 60, 52 };
    faces[108] = new int[] { 28, 52, 17 };
    faces[109] = new int[] { 28, 17,  5 };
    faces[110] = new int[] { 29,  5, 17 };
    faces[111] = new int[] { 29, 17, 53 };
    faces[112] = new int[] { 29, 53, 61 };
    faces[113] = new int[] { 29, 61, 37 };
    faces[114] = new int[] { 29, 37,  9 };
    faces[115] = new int[] { 29,  9, 33 };
    faces[116] = new int[] { 29, 33, 57 };
    faces[117] = new int[] { 29, 57, 49 };
    faces[118] = new int[] { 29, 49, 15 };
    faces[119] = new int[] { 29, 15,  5 };
  } //end GreatDisdyakisTriacontahedron()

  public String name() {
    return "Great Disdyakis Triacontahedron";
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
   
} //end class GreatDisdyakisTriacontahedron
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
GreatDitrigonalIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDitrigonalIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
   private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDitrigonalIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,   C0,   C1 );
    vert[  1] = new PVector(  0.0f,   C0,  -C1 );
    vert[  2] = new PVector(  0.0f,  -C0,   C1 );
    vert[  3] = new PVector(  0.0f,  -C0,  -C1 );
    vert[  4] = new PVector(   C1,  0.0f,   C0 );
    vert[  5] = new PVector(   C1,  0.0f,  -C0 );
    vert[  6] = new PVector(  -C1,  0.0f,   C0 );
    vert[  7] = new PVector(  -C1,  0.0f,  -C0 );
    vert[  8] = new PVector(   C0,   C1,  0.0f );
    vert[  9] = new PVector(   C0,  -C1,  0.0f );
    vert[ 10] = new PVector(  -C0,   C1,  0.0f );
    vert[ 11] = new PVector(  -C0,  -C1,  0.0f );
    vert[ 12] = new PVector(  0.5f,  0.5f,  0.5f );
    vert[ 13] = new PVector(  0.5f,  0.5f, -0.5f );
    vert[ 14] = new PVector(  0.5f, -0.5f,  0.5f );
    vert[ 15] = new PVector(  0.5f, -0.5f, -0.5f );
    vert[ 16] = new PVector( -0.5f,  0.5f,  0.5f );
    vert[ 17] = new PVector( -0.5f,  0.5f, -0.5f );
    vert[ 18] = new PVector( -0.5f, -0.5f,  0.5f );
    vert[ 19] = new PVector( -0.5f, -0.5f, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  6, 19, 15,  4 };
    faces[ 1] = new int[] {  0,  8,  1, 19, 18 };
    faces[ 2] = new int[] {  0, 14, 15,  1, 10 };
    faces[ 3] = new int[] {  7,  1,  5, 14, 18 };
    faces[ 4] = new int[] {  7, 11, 14, 12, 10 };
    faces[ 5] = new int[] {  7, 16, 12,  5,  3 };
    faces[ 6] = new int[] {  9,  2, 16, 17,  3 };
    faces[ 7] = new int[] {  9,  5,  8, 16, 18 };
    faces[ 8] = new int[] {  9, 19, 17,  8,  4 };
    faces[ 9] = new int[] { 13, 12,  2, 11,  3 };
    faces[10] = new int[] { 13, 15, 11,  6, 10 };
    faces[11] = new int[] { 13, 17,  6,  2,  4 };
    faces[12] = new int[] {  0,  4,  8,  8,  8 };  //added 2x 3rd number to fill gap
    faces[13] = new int[] {  0, 10,  6,  6,  6 };  //added 2x 3rd number to fill gap
    faces[14] = new int[] {  0, 18, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[15] = new int[] {  1,  7, 10, 10, 10 };  //added 2x 3rd number to fill gap
    faces[16] = new int[] {  1,  8,  5,  5,  5 };  //added 2x 3rd number to fill gap
    faces[17] = new int[] {  1, 15, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[18] = new int[] {  2,  6, 11, 11, 11 };  //added 2x 3rd number to fill gap
    faces[19] = new int[] {  2,  9,  4,  4,  4 };  //added 2x 3rd number to fill gap
    faces[20] = new int[] {  2, 12, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[21] = new int[] {  3,  5,  9,  9,  9 };  //added 2x 3rd number to fill gap
    faces[22] = new int[] {  3, 11,  7,  7,  7 };  //added 2x 3rd number to fill gap
    faces[23] = new int[] {  3, 17, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[24] = new int[] {  4, 15, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[25] = new int[] {  5, 12, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[26] = new int[] {  6, 17, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[27] = new int[] {  7, 18, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[28] = new int[] {  8, 17, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[29] = new int[] {  9, 18, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[30] = new int[] { 10, 12, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[31] = new int[] { 11, 15, 14, 14, 14 };  //added 2x 3rd number to fill gap
  } //end GreatDitrigonalIcosidodecahedron  //added 2x 3rd number to fill gap()

  public String name() {
    return "Great Ditrigonal Icosidodecahedron";
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
   
} //end class GreatDitrigonalIcosidodecahedron
/*
GreatDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f; // (1 + sqrt(5)) / 4
  PVector[] vert = new PVector[12]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private GreatDodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.5f,  0.0f,   C0);
    vert[ 1] = new PVector( 0.5f,  0.0f,  -C0);
    vert[ 2] = new PVector(-0.5f,  0.0f,   C0);
    vert[ 3] = new PVector(-0.5f,  0.0f,  -C0);
    vert[ 4] = new PVector(  C0,  0.5f,  0.0f);
    vert[ 5] = new PVector(  C0, -0.5f,  0.0f);
    vert[ 6] = new PVector( -C0,  0.5f,  0.0f);
    vert[ 7] = new PVector( -C0, -0.5f,  0.0f);
    vert[ 8] = new PVector( 0.0f,   C0,  0.5f);
    vert[ 9] = new PVector( 0.0f,   C0, -0.5f);
    vert[10] = new PVector( 0.0f,  -C0,  0.5f);
    vert[11] = new PVector( 0.0f,  -C0, -0.5f);
    // set faces
    faces[ 0] = new int[] {  0,  2,  7, 11,  5 };
    faces[ 1] = new int[] {  0,  5,  1,  9,  8 };
    faces[ 2] = new int[] {  0,  8,  6,  7, 10 };
    faces[ 3] = new int[] {  1,  3,  6,  8,  4 };
    faces[ 4] = new int[] {  1,  4,  0, 10, 11 };  
    faces[ 5] = new int[] {  1, 11,  7,  6,  9 };
    faces[ 6] = new int[] {  2,  0,  4,  9,  6 };
    faces[ 7] = new int[] {  2,  6,  3, 11, 10 };
    faces[ 8] = new int[] {  2, 10,  5,  4,  8 };
    faces[ 9] = new int[] {  3,  1,  5, 10,  7 };  
    faces[10] = new int[] {  3,  7,  2,  8,  9 };
    faces[11] = new int[] {  3,  9,  4,  5, 11 };
  } //end GreatDodecahedron()

  public String name() {
    return "Great Dodecahedron";
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
   
} //end class GreatDodecahedron
/*
GreatDodecahemicosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDodecahemicosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 22;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDodecahemicosahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0f,  0.0f,  1.0f );
    vert[ 1] = new PVector(  0.0f,  0.0f, -1.0f );
    vert[ 2] = new PVector(  1.0f,  0.0f,  0.0f );
    vert[ 3] = new PVector( -1.0f,  0.0f,  0.0f );
    vert[ 4] = new PVector(  0.0f,  1.0f,  0.0f );
    vert[ 5] = new PVector(  0.0f, -1.0f,  0.0f );
    vert[ 6] = new PVector(   C0,  0.5f,   C1 );
    vert[ 7] = new PVector(   C0,  0.5f,  -C1 );
    vert[ 8] = new PVector(   C0, -0.5f,   C1 );
    vert[ 9] = new PVector(   C0, -0.5f,  -C1 );
    vert[10] = new PVector(  -C0,  0.5f,   C1 );
    vert[11] = new PVector(  -C0,  0.5f,  -C1 );
    vert[12] = new PVector(  -C0, -0.5f,   C1 );
    vert[13] = new PVector(  -C0, -0.5f,  -C1 );
    vert[14] = new PVector(   C1,   C0,  0.5f );
    vert[15] = new PVector(   C1,   C0, -0.5f );
    vert[16] = new PVector(   C1,  -C0,  0.5f );
    vert[17] = new PVector(   C1,  -C0, -0.5f );
    vert[18] = new PVector(  -C1,   C0,  0.5f );
    vert[19] = new PVector(  -C1,   C0, -0.5f );
    vert[20] = new PVector(  -C1,  -C0,  0.5f );
    vert[21] = new PVector(  -C1,  -C0, -0.5f );
    vert[22] = new PVector(  0.5f,   C1,   C0 );
    vert[23] = new PVector(  0.5f,   C1,  -C0 );
    vert[24] = new PVector(  0.5f,  -C1,   C0 );
    vert[25] = new PVector(  0.5f,  -C1,  -C0 );
    vert[26] = new PVector( -0.5f,   C1,   C0 );
    vert[27] = new PVector( -0.5f,   C1,  -C0 );
    vert[28] = new PVector( -0.5f,  -C1,   C0 );
    vert[29] = new PVector( -0.5f,  -C1,  -C0 );
    // set faces
    faces[ 0] = new int[] { 0, 14, 15,  1, 21, 20 };
    faces[ 1] = new int[] { 0, 16, 17,  1, 19, 18 };
    faces[ 2] = new int[] { 2, 22, 26,  3, 29, 25 };
    faces[ 3] = new int[] { 2, 23, 27,  3, 28, 24 };
    faces[ 4] = new int[] { 4,  6,  8,  5, 13, 11 };
    faces[ 5] = new int[] { 4,  7,  9,  5, 12, 10 };
    faces[ 6] = new int[] { 6, 16, 25, 13, 19, 26 };
    faces[ 7] = new int[] { 7, 17, 24, 12, 18, 27 };
    faces[ 8] = new int[] { 8, 14, 23, 11, 21, 28 };
    faces[ 9] = new int[] { 9, 15, 22, 10, 20, 29 };
    faces[10] = new int[] { 0, 14, 23, 27, 18, 18 }; //added 1x 5th number to fill gap
    faces[11] = new int[] { 0, 20, 29, 25, 16, 16 }; //added 1x 5th number to fill gap
    faces[12] = new int[] { 1, 17, 24, 28, 21, 21 }; //added 1x 5th number to fill gap
    faces[13] = new int[] { 1, 19, 26, 22, 15, 15 }; //added 1x 5th number to fill gap
    faces[14] = new int[] { 2, 22, 10, 12, 24, 24 }; //added 1x 5th number to fill gap
    faces[15] = new int[] { 2, 25, 13, 11, 23, 23 }; //added 1x 5th number to fill gap
    faces[16] = new int[] { 3, 27,  7,  9, 29, 29 }; //added 1x 5th number to fill gap
    faces[17] = new int[] { 3, 28,  8,  6, 26, 26 }; //added 1x 5th number to fill gap
    faces[18] = new int[] { 4,  6, 16, 17,  7,  7 }; //added 1x 5th number to fill gap
    faces[19] = new int[] { 4, 11, 21, 20, 10, 10 }; //added 1x 5th number to fill gap
    faces[20] = new int[] { 5, 12, 18, 19, 13, 13 }; //added 1x 5th number to fill gap
    faces[21] = new int[] { 5,  9, 15, 14,  8,  8 }; //added 1x 5th number to fill gap
  } //end GreatDodecahemicosahedron()

  public String name() {
    return "Great Dodecahemicosahedron";
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
   
} //end class GreatDodecahemicosahedron
/*
GreatDodecahemidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDodecahemidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 18;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f; //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366f; //(sqrt(5) - 1) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDodecahemidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0f,  0.0f,   C2 );
    vert[ 1] = new PVector(  0.0f,  0.0f,  -C2 );
    vert[ 2] = new PVector(  0.0f,   C2,  0.0f );
    vert[ 3] = new PVector(  0.0f,  -C2,  0.0f );
    vert[ 4] = new PVector(   C2,  0.0f,  0.0f );
    vert[ 5] = new PVector(  -C2,  0.0f,  0.0f );
    vert[ 6] = new PVector(   C1, -0.5f,  -C0 );
    vert[ 7] = new PVector(   C1, -0.5f,   C0 );
    vert[ 8] = new PVector(  -C1, -0.5f,  -C0 );
    vert[ 9] = new PVector(  -C1, -0.5f,   C0 );
    vert[10] = new PVector(   C1,  0.5f,  -C0 );
    vert[11] = new PVector(   C1,  0.5f,   C0 );
    vert[12] = new PVector(  -C1,  0.5f,  -C0 );
    vert[13] = new PVector(  -C1,  0.5f,   C0 );
    vert[14] = new PVector( -0.5f,  -C0,   C1 );
    vert[15] = new PVector( -0.5f,  -C0,  -C1 );
    vert[16] = new PVector(  0.5f,  -C0,   C1 );
    vert[17] = new PVector(  0.5f,  -C0,  -C1 );
    vert[18] = new PVector( -0.5f,   C0,   C1 );
    vert[19] = new PVector( -0.5f,   C0,  -C1 );
    vert[20] = new PVector(  0.5f,   C0,   C1 );
    vert[21] = new PVector(  0.5f,   C0,  -C1 );
    vert[22] = new PVector(  -C0,   C1, -0.5f );
    vert[23] = new PVector(  -C0,   C1,  0.5f );
    vert[24] = new PVector(   C0,   C1, -0.5f );
    vert[25] = new PVector(   C0,   C1,  0.5f );
    vert[26] = new PVector(  -C0,  -C1, -0.5f );
    vert[27] = new PVector(  -C0,  -C1,  0.5f );
    vert[28] = new PVector(   C0,  -C1, -0.5f );
    vert[29] = new PVector(   C0,  -C1,  0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  6, 22, 23,  7,  1, 13, 29, 28, 12 };
    faces[ 1] = new int[] {  0,  8, 24, 25,  9,  1, 11, 27, 26, 10 };
    faces[ 2] = new int[] {  2, 14,  6, 10, 18,  3, 21, 13,  9, 17 };
    faces[ 3] = new int[] {  2, 15,  7, 11, 19,  3, 20, 12,  8, 16 };
    faces[ 4] = new int[] {  4, 22, 14, 16, 24,  5, 29, 21, 19, 27 };
    faces[ 5] = new int[] {  4, 23, 15, 17, 25,  5, 28, 20, 18, 26 };
    faces[ 6] = new int[] {  0,  8, 16, 14,  6,  6,  6,  6,  6,  6 }; //added 5x 5th number to fill gap
    faces[ 7] = new int[] {  0, 10, 18, 20, 12, 12, 12, 12, 12, 12 }; //added 5x 5th number to fill gap
    faces[ 8] = new int[] {  1,  7, 15, 17,  9,  9,  9,  9,  9,  9 }; //added 5x 5th number to fill gap
    faces[ 9] = new int[] {  1, 13, 21, 19, 11, 11, 11, 11, 11, 11 }; //added 5x 5th number to fill gap
    faces[10] = new int[] {  2, 15, 23, 22, 14, 14, 14, 14, 14, 14 }; //added 5x 5th number to fill gap
    faces[11] = new int[] {  2, 16, 24, 25, 17, 17, 17, 17, 17, 17 }; //added 5x 5th number to fill gap
    faces[12] = new int[] {  3, 18, 26, 27, 19, 19, 19, 19, 19, 19 }; //added 5x 5th number to fill gap
    faces[13] = new int[] {  3, 21, 29, 28, 20, 20, 20, 20, 20, 20 }; //added 5x 5th number to fill gap
    faces[14] = new int[] {  4, 23,  7, 11, 27, 27, 27, 27, 27, 27 }; //added 5x 5th number to fill gap
    faces[15] = new int[] {  4, 26, 10,  6, 22, 22, 22, 22, 22, 22 }; //added 5x 5th number to fill gap
    faces[16] = new int[] {  5, 24,  8, 12, 28, 28, 28, 28, 28, 28 }; //added 5x 5th number to fill gap
    faces[17] = new int[] {  5, 29, 13,  9, 25, 25, 25, 25, 25, 25 }; //added 5x 5th number to fill gap
  } //end GreatDodecahemidodecahedron()

  public String name() {
    return "Great Dodecahemidodecahedron";
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
   
} //end class GreatDodecahemidodecahedron
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
GreatHexagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatHexagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.0467276373631543033303677305706f;    //sqrt(sqrt(5) - 1 - 2 * sqrt(2 * (5 * sqrt(5) - 11))) / 4
  final float C1  = 0.0594384729013000505963734214209f;    //sqrt(2 * (1 - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C2  = 0.135045378368863226800771578524547f;  //(3 * sqrt(2) - sqrt(10)) / 8
  final float C3  = 0.142901106756847359195252445424f;     //sqrt(2 * (3 - sqrt(5) - sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C4  = 0.171780374861256232069282871957f;     //sqrt(2 * (sqrt(5) - 2)) / 4
  final float C5  = 0.218508012224410535399650602528f;     //(sqrt(10) - sqrt(2)) / 8
  final float C6  = 0.277946485125710585996024023949f;     //sqrt(sqrt(5) - 1) / 4
  final float C7  = 0.314681481618103591264535317382f;     //sqrt(2 * (4 - sqrt(5) - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C8  = 0.353553390593273762200422181052f;     //sqrt(2) / 4
  final float C9  = 0.3902883870856667674689334744852f;    //sqrt(sqrt(5) - 1 + 2 * sqrt(2 * (5 * sqrt(5) - 11))) / 4
  final float C10 = 0.412991863494573812796795602473f;     //sqrt(2 * (3 - sqrt(5) + sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C11 = 0.449726859986966818065306895906f;     //sqrt(1 + sqrt(5)) / 4
  final float C12 = 0.496454497350121121395674626477f;     //sqrt(2 * (1 + 2 * sqrt(sqrt(5) - 2))) / 4
  final float C13 = 0.555892970251421171992048047898f;     //sqrt(sqrt(5) - 1) / 2
  final float C14 = 0.572061402817684297600072783580f;     //(sqrt(2) + sqrt(10)) / 8
  final float C15 = 0.584772238355830044866078474431f;     //sqrt(2 * (4 - sqrt(5) + 2 * sqrt(sqrt(5) - 2))) / 4
  private PVector[] vert = new PVector[104]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatHexagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C4,   C1,  C15 );
    vert[  1] = new PVector(   C4,  -C1, -C15 );
    vert[  2] = new PVector(  -C4,  -C1,  C15 );
    vert[  3] = new PVector(  -C4,   C1, -C15 );
    vert[  4] = new PVector(  C15,   C4,   C1 );
    vert[  5] = new PVector(  C15,  -C4,  -C1 );
    vert[  6] = new PVector( -C15,  -C4,   C1 );
    vert[  7] = new PVector( -C15,   C4,  -C1 );
    vert[  8] = new PVector(   C1,  C15,   C4 );
    vert[  9] = new PVector(   C1, -C15,  -C4 );
    vert[ 10] = new PVector(  -C1, -C15,   C4 );
    vert[ 11] = new PVector(  -C1,  C15,  -C4 );
    vert[ 12] = new PVector(  0.0f,   C5,  C14 );
    vert[ 13] = new PVector(  0.0f,   C5, -C14 );
    vert[ 14] = new PVector(  0.0f,  -C5,  C14 );
    vert[ 15] = new PVector(  0.0f,  -C5, -C14 );
    vert[ 16] = new PVector(  C14,  0.0f,   C5 );
    vert[ 17] = new PVector(  C14,  0.0f,  -C5 );
    vert[ 18] = new PVector( -C14,  0.0f,   C5 );
    vert[ 19] = new PVector( -C14,  0.0f,  -C5 );
    vert[ 20] = new PVector(   C5,  C14,  0.0f );
    vert[ 21] = new PVector(   C5, -C14,  0.0f );
    vert[ 22] = new PVector(  -C5,  C14,  0.0f );
    vert[ 23] = new PVector(  -C5, -C14,  0.0f );
    vert[ 24] = new PVector(   C5,  -C2,  C13 );
    vert[ 25] = new PVector(   C5,   C2, -C13 );
    vert[ 26] = new PVector(  -C5,   C2,  C13 );
    vert[ 27] = new PVector(  -C5,  -C2, -C13 );
    vert[ 28] = new PVector(  C13,  -C5,   C2 );
    vert[ 29] = new PVector(  C13,   C5,  -C2 );
    vert[ 30] = new PVector( -C13,   C5,   C2 );
    vert[ 31] = new PVector( -C13,  -C5,  -C2 );
    vert[ 32] = new PVector(   C2, -C13,   C5 );
    vert[ 33] = new PVector(   C2,  C13,  -C5 );
    vert[ 34] = new PVector(  -C2,  C13,   C5 );
    vert[ 35] = new PVector(  -C2, -C13,  -C5 );
    vert[ 36] = new PVector(   C7,   C4,  C12 );
    vert[ 37] = new PVector(   C7,  -C4, -C12 );
    vert[ 38] = new PVector(  -C7,  -C4,  C12 );
    vert[ 39] = new PVector(  -C7,   C4, -C12 );
    vert[ 40] = new PVector(  C12,   C7,   C4 );
    vert[ 41] = new PVector(  C12,  -C7,  -C4 );
    vert[ 42] = new PVector( -C12,  -C7,   C4 );
    vert[ 43] = new PVector( -C12,   C7,  -C4 );
    vert[ 44] = new PVector(   C4,  C12,   C7 );
    vert[ 45] = new PVector(   C4, -C12,  -C7 );
    vert[ 46] = new PVector(  -C4, -C12,   C7 );
    vert[ 47] = new PVector(  -C4,  C12,  -C7 );
    vert[ 48] = new PVector(   C6,  0.0f,  C11 );
    vert[ 49] = new PVector(   C6,  0.0f,  C11 );
    vert[ 50] = new PVector(   C6,  0.0f, -C11 );
    vert[ 51] = new PVector(   C6,  0.0f, -C11 );
    vert[ 52] = new PVector(  -C6,  0.0f,  C11 );
    vert[ 53] = new PVector(  -C6,  0.0f,  C11 );
    vert[ 54] = new PVector(  -C6,  0.0f, -C11 );
    vert[ 55] = new PVector(  -C6,  0.0f, -C11 );
    vert[ 56] = new PVector(  C11,   C6,  0.0f );
    vert[ 57] = new PVector(  C11,   C6,  0.0f );
    vert[ 58] = new PVector(  C11,  -C6,  0.0f );
    vert[ 59] = new PVector(  C11,  -C6,  0.0f );
    vert[ 60] = new PVector( -C11,   C6,  0.0f );
    vert[ 61] = new PVector( -C11,   C6,  0.0f );
    vert[ 62] = new PVector( -C11,  -C6,  0.0f );
    vert[ 63] = new PVector( -C11,  -C6,  0.0f );
    vert[ 64] = new PVector(  0.0f,  C11,   C6 );
    vert[ 65] = new PVector(  0.0f,  C11,   C6 );
    vert[ 66] = new PVector(  0.0f,  C11,  -C6 );
    vert[ 67] = new PVector(  0.0f,  C11,  -C6 );
    vert[ 68] = new PVector(  0.0f, -C11,   C6 );
    vert[ 69] = new PVector(  0.0f, -C11,   C6 );
    vert[ 70] = new PVector(  0.0f, -C11,  -C6 );
    vert[ 71] = new PVector(  0.0f, -C11,  -C6 );
    vert[ 72] = new PVector(   C9,  -C3,  C11 );
    vert[ 73] = new PVector(   C9,   C3, -C11 );
    vert[ 74] = new PVector(  -C9,   C3,  C11 );
    vert[ 75] = new PVector(  -C9,  -C3, -C11 );
    vert[ 76] = new PVector(  C11,  -C9,   C3 );
    vert[ 77] = new PVector(  C11,   C9,  -C3 );
    vert[ 78] = new PVector( -C11,   C9,   C3 );
    vert[ 79] = new PVector( -C11,  -C9,  -C3 );
    vert[ 80] = new PVector(   C3, -C11,   C9 );
    vert[ 81] = new PVector(   C3,  C11,  -C9 );
    vert[ 82] = new PVector(  -C3,  C11,   C9 );
    vert[ 83] = new PVector(  -C3, -C11,  -C9 );
    vert[ 84] = new PVector(   C0,  C10,  C11 );
    vert[ 85] = new PVector(   C0, -C10, -C11 );
    vert[ 86] = new PVector(  -C0, -C10,  C11 );
    vert[ 87] = new PVector(  -C0,  C10, -C11 );
    vert[ 88] = new PVector(  C11,   C0,  C10 );
    vert[ 89] = new PVector(  C11,  -C0, -C10 );
    vert[ 90] = new PVector( -C11,  -C0,  C10 );
    vert[ 91] = new PVector( -C11,   C0, -C10 );
    vert[ 92] = new PVector(  C10,  C11,   C0 );
    vert[ 93] = new PVector(  C10, -C11,  -C0 );
    vert[ 94] = new PVector( -C10, -C11,   C0 );
    vert[ 95] = new PVector( -C10,  C11,  -C0 );
    vert[ 96] = new PVector(   C8,   C8,   C8 );
    vert[ 97] = new PVector(   C8,   C8,  -C8 );
    vert[ 98] = new PVector(   C8,  -C8,   C8 );
    vert[ 99] = new PVector(   C8,  -C8,  -C8 );
    vert[100] = new PVector(  -C8,   C8,   C8 );
    vert[101] = new PVector(  -C8,   C8,  -C8 );
    vert[102] = new PVector(  -C8,  -C8,   C8 );
    vert[103] = new PVector(  -C8,  -C8,  -C8 );
    // set faces
    faces[ 0] = new int[] {  12,  30,  62,  10,  68,  80 };
    faces[ 1] = new int[] {  12,  80,  59,  29,  57,  92 };
    faces[ 2] = new int[] {  12,  92,  67,  43,  60,  30 };
    faces[ 3] = new int[] {  13,  29,  59,   9,  71,  83 };
    faces[ 4] = new int[] {  13,  83,  62,  30,  60,  95 };
    faces[ 5] = new int[] {  13,  95,  64,  40,  57,  29 };
    faces[ 6] = new int[] {  14,  28,  56,   8,  65,  82 };
    faces[ 7] = new int[] {  14,  82,  61,  31,  63,  94 };
    faces[ 8] = new int[] {  14,  94,  70,  41,  58,  28 };
    faces[ 9] = new int[] {  15,  31,  61,  11,  66,  81 };
    faces[10] = new int[] {  15,  81,  56,  28,  58,  93 };
    faces[11] = new int[] {  15,  93,  69,  42,  63,  31 };
    faces[12] = new int[] {  16,  32,  70,   1,  51,  73 };
    faces[13] = new int[] {  16,  73,  67,  34,  65,  84 };
    faces[14] = new int[] {  16,  84,  52,  46,  68,  32 };
    faces[15] = new int[] {  17,  33,  64,   0,  48,  72 };
    faces[16] = new int[] {  17,  72,  69,  35,  71,  85 };
    faces[17] = new int[] {  17,  85,  55,  47,  66,  33 };
    faces[18] = new int[] {  18,  34,  67,   3,  54,  75 };
    faces[19] = new int[] {  18,  75,  70,  32,  68,  86 };
    faces[20] = new int[] {  18,  86,  49,  44,  65,  34 };
    faces[21] = new int[] {  19,  35,  69,   2,  53,  74 };
    faces[22] = new int[] {  19,  74,  64,  33,  66,  87 };
    faces[23] = new int[] {  19,  87,  50,  45,  71,  35 };
    faces[24] = new int[] {  20,  25,  55,   7,  60,  78 };
    faces[25] = new int[] {  20,  78,  52,  24,  48,  88 };
    faces[26] = new int[] {  20,  88,  59,  37,  51,  25 };
    faces[27] = new int[] {  21,  24,  52,   6,  63,  79 };
    faces[28] = new int[] {  21,  79,  55,  25,  51,  89 };
    faces[29] = new int[] {  21,  89,  56,  36,  48,  24 };
    faces[30] = new int[] {  22,  26,  49,   4,  57,  77 };
    faces[31] = new int[] {  22,  77,  50,  27,  54,  91 };
    faces[32] = new int[] {  22,  91,  62,  38,  53,  26 };
    faces[33] = new int[] {  23,  27,  50,   5,  58,  76 };
    faces[34] = new int[] {  23,  76,  49,  26,  53,  90 };
    faces[35] = new int[] {  23,  90,  61,  39,  54,  27 };
    faces[36] = new int[] {  96,   2,  69,  93,  58,   5 };
    faces[37] = new int[] {  96,   5,  50,  87,  66,  11 };
    faces[38] = new int[] {  96,  11,  61,  90,  53,   2 };
    faces[39] = new int[] {  97,  39,  61,  82,  65,  44 };
    faces[40] = new int[] {  97,  44,  49,  76,  58,  41 };
    faces[41] = new int[] {  97,  41,  70,  75,  54,  39 };
    faces[42] = new int[] {  98,  38,  62,  83,  71,  45 };
    faces[43] = new int[] {  98,  45,  50,  77,  57,  40 };
    faces[44] = new int[] {  98,  40,  64,  74,  53,  38 };
    faces[45] = new int[] {  99,   3,  67,  92,  57,   4 };
    faces[46] = new int[] {  99,   4,  49,  86,  68,  10 };
    faces[47] = new int[] {  99,  10,  62,  91,  54,   3 };
    faces[48] = new int[] { 100,  36,  56,  81,  66,  47 };
    faces[49] = new int[] { 100,  47,  55,  79,  63,  42 };
    faces[50] = new int[] { 100,  42,  69,  72,  48,  36 };
    faces[51] = new int[] { 101,   1,  70,  94,  63,   6 };
    faces[52] = new int[] { 101,   6,  52,  84,  65,   8 };
    faces[53] = new int[] { 101,   8,  56,  89,  51,   1 };
    faces[54] = new int[] { 102,   0,  64,  95,  60,   7 };
    faces[55] = new int[] { 102,   7,  55,  85,  71,   9 };
    faces[56] = new int[] { 102,   9,  59,  88,  48,   0 };
    faces[57] = new int[] { 103,  37,  59,  80,  68,  46 };
    faces[58] = new int[] { 103,  46,  52,  78,  60,  43 };
    faces[59] = new int[] { 103,  43,  67,  73,  51,  37 };
  } //end GreatHexagonalHexecontahedron()

  public String name() {
    return "Great Hexagonal Hexecontahedron";
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
   
} //end class GreatHexagonalHexecontahedron
/*
GreatIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.0f, -0.5f,   C0);
    vert[ 1] = new PVector( 0.0f, -0.5f,  -C0);
    vert[ 2] = new PVector( 0.0f,  0.5f,   C0);
    vert[ 3] = new PVector( 0.0f,  0.5f,  -C0);
    vert[ 4] = new PVector(-0.5f,   C0,  0.0f);
    vert[ 5] = new PVector( 0.5f,   C0,  0.0f);
    vert[ 6] = new PVector(-0.5f,  -C0,  0.0f);
    vert[ 7] = new PVector( 0.5f,  -C0,  0.0f);  
    vert[ 8] = new PVector(  C0,  0.0f, -0.5f);
    vert[ 9] = new PVector(  C0,  0.0f,  0.5f);
    vert[10] = new PVector( -C0,  0.0f, -0.5f);
    vert[11] = new PVector( -C0,  0.0f,  0.5f);
    // set faces
    faces[ 0] = new int[] { 0,  2, 10};
    faces[ 1] = new int[] { 0, 10,  5};
    faces[ 2] = new int[] { 0,  5,  4};
    faces[ 3] = new int[] { 0,  4,  8};
    faces[ 4] = new int[] { 0,  8,  2};
    faces[ 5] = new int[] { 3,  1, 11};
    faces[ 6] = new int[] { 3, 11,  7};
    faces[ 7] = new int[] { 3,  7,  6};
    faces[ 8] = new int[] { 3,  6,  9};
    faces[ 9] = new int[] { 3,  9,  1};
    faces[10] = new int[] { 2,  6,  7};
    faces[11] = new int[] { 2,  7, 10};
    faces[12] = new int[] {10,  7, 11};
    faces[13] = new int[] {10, 11,  5};
    faces[14] = new int[] { 5, 11,  1};
    faces[15] = new int[] { 5,  1,  4};
    faces[16] = new int[] { 4,  1,  9};
    faces[17] = new int[] { 4,  9,  8};
    faces[18] = new int[] { 8,  9,  6};
    faces[19] = new int[] { 8,  6,  2};
  } //end GreatIcosahedron()

  public String name() {
    return "Great Icosahedron";
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
  
} //end class GreatIcosahedron
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
GreatIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f;  //3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f;  //sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366f;  //sqrt(5) - 1) / 2
   private PVector[] vert = new PVector[30]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,  0.0f,   C2 );
    vert[  1] = new PVector(  0.0f,  0.0f,  -C2 );
    vert[  2] = new PVector(  0.0f,   C2,  0.0f );
    vert[  3] = new PVector(  0.0f,  -C2,  0.0f );
    vert[  4] = new PVector(   C2,  0.0f,  0.0f );
    vert[  5] = new PVector(  -C2,  0.0f,  0.0f );
    vert[  6] = new PVector(   C1, -0.5f,  -C0 );
    vert[  7] = new PVector(   C1, -0.5f,   C0 );
    vert[  8] = new PVector(  -C1, -0.5f,  -C0 );
    vert[  9] = new PVector(  -C1, -0.5f,   C0 );
    vert[ 10] = new PVector(   C1,  0.5f,  -C0 );
    vert[ 11] = new PVector(   C1,  0.5f,   C0 );
    vert[ 12] = new PVector(  -C1,  0.5f,  -C0 );
    vert[ 13] = new PVector(  -C1,  0.5f,   C0 );
    vert[ 14] = new PVector( -0.5f,  -C0,   C1 );
    vert[ 15] = new PVector( -0.5f,  -C0,  -C1 );
    vert[ 16] = new PVector(  0.5f,  -C0,   C1 );
    vert[ 17] = new PVector(  0.5f,  -C0,  -C1 );
    vert[ 18] = new PVector( -0.5f,   C0,   C1 );
    vert[ 19] = new PVector( -0.5f,   C0,  -C1 );
    vert[ 20] = new PVector(  0.5f,   C0,   C1 );
    vert[ 21] = new PVector(  0.5f,   C0,  -C1 );
    vert[ 22] = new PVector(  -C0,   C1, -0.5f );
    vert[ 23] = new PVector(  -C0,   C1,  0.5f );
    vert[ 24] = new PVector(   C0,   C1, -0.5f );
    vert[ 25] = new PVector(   C0,   C1,  0.5f );
    vert[ 26] = new PVector(  -C0,  -C1, -0.5f );
    vert[ 27] = new PVector(  -C0,  -C1,  0.5f );
    vert[ 28] = new PVector(   C0,  -C1, -0.5f );
    vert[ 29] = new PVector(   C0,  -C1,  0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  8, 16, 14,  6 };
    faces[ 1] = new int[] {  0, 10, 18, 20, 12 };
    faces[ 2] = new int[] {  1,  7, 15, 17,  9 };
    faces[ 3] = new int[] {  1, 13, 21, 19, 11 };
    faces[ 4] = new int[] {  2, 15, 23, 22, 14 };
    faces[ 5] = new int[] {  2, 16, 24, 25, 17 };
    faces[ 6] = new int[] {  3, 18, 26, 27, 19 };
    faces[ 7] = new int[] {  3, 21, 29, 28, 20 };
    faces[ 8] = new int[] {  4, 23,  7, 11, 27 };
    faces[ 9] = new int[] {  4, 26, 10,  6, 22 };
    faces[10] = new int[] {  5, 24,  8, 12, 28 };
    faces[11] = new int[] {  5, 29, 13,  9, 25 };
    faces[12] = new int[] {  0,  6, 10, 10, 10 };  // added 2x 3rd number to fill gap
    faces[13] = new int[] {  0, 12,  8,  8,  8 };  // added 2x 3rd number to fill gap
    faces[14] = new int[] {  1,  9, 13, 13, 13 };  // added 2x 3rd number to fill gap
    faces[15] = new int[] {  1, 11,  7,  7,  7 };  // added 2x 3rd number to fill gap
    faces[16] = new int[] {  2, 14, 16, 16, 16 };  // added 2x 3rd number to fill gap
    faces[17] = new int[] {  2, 17, 15, 15, 15 };  // added 2x 3rd number to fill gap
    faces[18] = new int[] {  3, 19, 21, 21, 21 };  // added 2x 3rd number to fill gap
    faces[19] = new int[] {  3, 20, 18, 18, 18 };  // added 2x 3rd number to fill gap
    faces[20] = new int[] {  4, 22, 23, 23, 23 };  // added 2x 3rd number to fill gap
    faces[21] = new int[] {  4, 27, 26, 26, 26 };  // added 2x 3rd number to fill gap
    faces[22] = new int[] {  5, 25, 24, 24, 24 };  // added 2x 3rd number to fill gap
    faces[23] = new int[] {  5, 28, 29, 29, 29 };  // added 2x 3rd number to fill gap
    faces[24] = new int[] {  6, 14, 22, 22, 22 };  // added 2x 3rd number to fill gap
    faces[25] = new int[] {  7, 23, 15, 15, 15 };  // added 2x 3rd number to fill gap
    faces[26] = new int[] {  8, 24, 16, 16, 16 };  // added 2x 3rd number to fill gap
    faces[27] = new int[] {  9, 17, 25, 25, 25 };  // added 2x 3rd number to fill gap
    faces[28] = new int[] { 10, 26, 18, 18, 18 };  // added 2x 3rd number to fill gap
    faces[29] = new int[] { 11, 19, 27, 27, 27 };  // added 2x 3rd number to fill gap
    faces[30] = new int[] { 12, 20, 28, 28, 28 };  // added 2x 3rd number to fill gap
    faces[31] = new int[] { 13, 29, 21, 21, 21 };  // added 2x 3rd number to fill gap
  } //end GreatIcosidodecahedron  //added 2x 3rd number to fill gap()

  public String name() {
    return "Great Icosidodecahedron";
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
   
} //end class GreatIcosidodecahedron
/*
GreatIcosihemidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosihemidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 26;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f; //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366f; //(sqrt(5) - 1) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosihemidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.0f,  0.0f,   C2);
    vert[ 1] = new PVector( 0.0f,  0.0f,  -C2);
    vert[ 2] = new PVector( 0.0f,   C2,  0.0f);
    vert[ 3] = new PVector( 0.0f,  -C2,  0.0f);
    vert[ 4] = new PVector(  C2,  0.0f,  0.0f);
    vert[ 5] = new PVector( -C2,  0.0f,  0.0f);
    vert[ 6] = new PVector(  C1, -0.5f,  -C0);
    vert[ 7] = new PVector(  C1, -0.5f,   C0);
    vert[ 8] = new PVector( -C1, -0.5f,  -C0);
    vert[ 9] = new PVector( -C1, -0.5f,   C0);
    vert[10] = new PVector(  C1,  0.5f,  -C0);
    vert[11] = new PVector(  C1,  0.5f,   C0);
    vert[12] = new PVector( -C1,  0.5f,  -C0);
    vert[13] = new PVector( -C1,  0.5f,   C0);
    vert[14] = new PVector(-0.5f,  -C0,   C1);
    vert[15] = new PVector(-0.5f,  -C0,  -C1);
    vert[16] = new PVector( 0.5f,  -C0,   C1);
    vert[17] = new PVector( 0.5f,  -C0,  -C1);
    vert[18] = new PVector(-0.5f,   C0,   C1);
    vert[19] = new PVector(-0.5f,   C0,  -C1);
    vert[20] = new PVector( 0.5f,   C0,   C1);
    vert[21] = new PVector( 0.5f,   C0,  -C1);
    vert[22] = new PVector( -C0,   C1, -0.5f);
    vert[23] = new PVector( -C0,   C1,  0.5f);
    vert[24] = new PVector(  C0,   C1, -0.5f);
    vert[25] = new PVector(  C0,   C1,  0.5f);
    vert[26] = new PVector( -C0,  -C1, -0.5f);
    vert[27] = new PVector( -C0,  -C1,  0.5f);
    vert[28] = new PVector(  C0,  -C1, -0.5f);
    vert[29] = new PVector(  C0,  -C1,  0.5f);
    // set faces
    faces[ 0] = new int[] { 0,  6, 22, 23,  7,  1, 13, 29, 28, 12};
    faces[ 1] = new int[] { 0,  8, 24, 25,  9,  1, 11, 27, 26, 10};
    faces[ 2] = new int[] { 2, 14,  6, 10, 18,  3, 21, 13,  9, 17};
    faces[ 3] = new int[] { 2, 15,  7, 11, 19,  3, 20, 12,  8, 16};
    faces[ 4] = new int[] { 4, 22, 14, 16, 24,  5, 29, 21, 19, 27};
    faces[ 5] = new int[] { 4, 23, 15, 17, 25,  5, 28, 20, 18, 26};
    faces[ 6] = new int[] { 0,  6, 10, 10, 10, 10, 10, 10, 10, 10}; //added 7x 3th number to fill gap
    faces[ 7] = new int[] { 0, 12,  8,  8,  8,  8,  8,  8,  8,  8}; //added 7x 3th number to fill gap
    faces[ 8] = new int[] { 1,  9, 13, 13, 13, 13, 13, 13, 13, 13}; //added 7x 3th number to fill gap
    faces[ 9] = new int[] { 1, 11,  7,  7,  7,  7,  7,  7,  7,  7}; //added 7x 3th number to fill gap
    faces[10] = new int[] {14, 16,  2,  2,  2,  2,  2,  2,  2,  2}; //added 7x 3th number to fill gap
    faces[11] = new int[] {14, 22,  6,  6,  6,  6,  6,  6,  6,  6}; //added 7x 3th number to fill gap
    faces[12] = new int[] {17, 15,  2,  2,  2,  2,  2,  2,  2,  2}; //added 7x 3th number to fill gap
    faces[13] = new int[] {17, 25,  9,  9,  9,  9,  9,  9,  9,  9}; //added 7x 3th number to fill gap
    faces[14] = new int[] {19, 21,  3,  3,  3,  3,  3,  3,  3,  3}; //added 7x 3th number to fill gap
    faces[15] = new int[] {19, 27, 11, 11, 11, 11, 11, 11, 11, 11}; //added 7x 3th number to fill gap
    faces[16] = new int[] {20, 18,  3,  3,  3,  3,  3,  3,  3,  3}; //added 7x 3th number to fill gap
    faces[17] = new int[] {20, 28, 12, 12, 12, 12, 12, 12, 12, 12}; //added 7x 3th number to fill gap
    faces[18] = new int[] {23,  4, 22, 22, 22, 22, 22, 22, 22, 22}; //added 7x 3th number to fill gap
    faces[19] = new int[] {23, 15,  7,  7,  7,  7,  7,  7,  7,  7}; //added 7x 3th number to fill gap
    faces[20] = new int[] {24,  5, 25, 25, 25, 25, 25, 25, 25, 25}; //added 7x 3th number to fill gap
    faces[21] = new int[] {24, 16,  8,  8,  8,  8,  8,  8,  8,  8}; //added 7x 3th number to fill gap
    faces[22] = new int[] {26,  4, 27, 27, 27, 27, 27, 27, 27, 27}; //added 7x 3th number to fill gap
    faces[23] = new int[] {26, 18, 10, 10, 10, 10, 10, 10, 10, 10}; //added 7x 3th number to fill gap
    faces[24] = new int[] {29,  5, 28, 28, 28, 28, 28, 28, 28, 28}; //added 7x 3th number to fill gap
    faces[25] = new int[] {29, 21, 13, 13, 13, 13, 13, 13, 13, 13}; //added 7x 3th number to fill gap
  } //end GreatIcosihemidodecahedron()

  public String name() {
    return "Great Icosihemidodecahedron";
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
  
} //end class GreatIcosihemidodecahedron
/*
GreatInvertedPentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatInvertedPentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0374913943475815612447678400668f;    //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) + 16896*(x^4) - 14528*(x^3) + 6112*(x^2) - 720*x + 1
  final float C1  = 0.0926952885354777710872481278869f;    //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C2  = 0.104151922611206820966596455724f;     //square-root of a root of the polynomial:  4096*(x^6) - 18432*(x^5) + 16384*(x^4) - 8960*(x^3) + 8928*(x^2) - 188*x + 1
  final float C3  = 0.153357638875490426256644060007f;     //square-root of a root of the polynomial:  4096*(x^6) + 3072*(x^5) - 16128*(x^4) - 17152*(x^3) + 2176*(x^2) - 84*x + 1
  final float C4  = 0.187475521794963058008011505776f;     //square-root of a root of the polynomial:  4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C5  = 0.196847211146684592053844583611f;     //square-root of a root of the polynomial:  4096*(x^6) - 27648*(x^5) + 72704*(x^4) - 92160*(x^3) + 54448*(x^2) - 11292*x + 361
  final float C6  = 0.206012745126162897462898732354f;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1
  final float C7  = 0.210646477787394151932639597830f;     //square-root of a root of the polynomial:  4096*(x^6) - 16384*(x^5) + 24832*(x^4) - 17344*(x^3) + 4992*(x^2) - 212*x + 1
  final float C8  = 0.233599921462949641107705607317f;     //square-root of a root of the polynomial:  3936256*(x^6) - 14764032*(x^5) + 2619648*(x^4) - 103040*(x^3) - 736*(x^2) + 32*x + 1
  final float C9  = 0.257509561486697247223240515731f;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C10 = 0.333335623729800812354123280131f;     //square-root of a root of the polynomial:  4096*(x^6) - 11264*(x^5) + 9472*(x^4) - 2944*(x^3) + 432*(x^2) - 32*x + 1
  final float C11 = 0.355996872573544394226142398063f;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 4608*(x^4) + 9920*(x^3) - 96*(x^2) - 1108*x + 121
  final float C12 = 0.377972612696358579690731668528f;     //square-root of a root of the polynomial:  3936256*(x^6) - 7502848*(x^5) + 3239168*(x^4) - 452480*(x^3) + 17264*(x^2) + 208*x + 1
  final float C13 = 0.379167828565975488150770490117f;     //square-root of a root of the polynomial:  4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C14 = 0.407493688934078743986484181441f;     //square-root of a root of the polynomial:  4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C15 = 0.444985083281660305231252021507f;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 40704*(x^4) - 44288*(x^3) + 21504*(x^2) - 3420*x + 121
  final float C16 = 0.471863117101453259238018618004f;     //square-root of a root of the polynomial:  4096*(x^6) - 4096*(x^5) + 3840*(x^4) - 14720*(x^3) + 17040*(x^2) - 6876*x + 841
  final float C17 = 0.509354511449034820482786458071f;     //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C18 = 0.5393483688559637098170220124854f;    //square-root of a root of the polynomial:  4096*(x^6) - 14336*(x^5) + 14592*(x^4) - 6016*(x^3) + 992*(x^2) - 48*x + 1
  final float C19 = 0.566643350360938546158781995893f;     //square-root of a root of the polynomial:  4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  private PVector[] vert = new PVector[92]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatInvertedPentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C3,  C13, -C14 );
    vert[  1] = new PVector(  -C3,  C13,  C14 );
    vert[  2] = new PVector(  -C3, -C13, -C14 );
    vert[  3] = new PVector(   C3, -C13,  C14 );
    vert[  4] = new PVector(  C13, -C14,   C3 );
    vert[  5] = new PVector( -C13, -C14,  -C3 );
    vert[  6] = new PVector( -C13,  C14,   C3 );
    vert[  7] = new PVector(  C13,  C14,  -C3 );
    vert[  8] = new PVector( -C14,   C3,  C13 );
    vert[  9] = new PVector(  C14,   C3, -C13 );
    vert[ 10] = new PVector(  C14,  -C3,  C13 );
    vert[ 11] = new PVector( -C14,  -C3, -C13 );
    vert[ 12] = new PVector(  C18, -0.0f,   C6 );
    vert[ 13] = new PVector(  C18, -0.0f,  -C6 );
    vert[ 14] = new PVector( -C18, -0.0f,   C6 );
    vert[ 15] = new PVector( -C18, -0.0f,  -C6 );
    vert[ 16] = new PVector(  0.0f,   C6,  C18 );
    vert[ 17] = new PVector(  0.0f,   C6, -C18 );
    vert[ 18] = new PVector(  0.0f,  -C6,  C18 );
    vert[ 19] = new PVector(  0.0f,  -C6, -C18 );
    vert[ 20] = new PVector(   C6,  C18,  0.0f );
    vert[ 21] = new PVector(  -C6,  C18,  0.0f );
    vert[ 22] = new PVector(   C6, -C18,  0.0f );
    vert[ 23] = new PVector(  -C6, -C18,  0.0f );
    vert[ 24] = new PVector(  0.0f,  C12,  -C8 );
    vert[ 25] = new PVector(  0.0f,  C12,   C8 );
    vert[ 26] = new PVector(  0.0f, -C12,  -C8 );
    vert[ 27] = new PVector(  0.0f, -C12,   C8 );
    vert[ 28] = new PVector(  C12,  -C8,  0.0f );
    vert[ 29] = new PVector( -C12,  -C8,  0.0f );
    vert[ 30] = new PVector(  C12,   C8,  0.0f );
    vert[ 31] = new PVector( -C12,   C8,  0.0f );
    vert[ 32] = new PVector(  -C8, -0.0f,  C12 );
    vert[ 33] = new PVector(  -C8, -0.0f, -C12 );
    vert[ 34] = new PVector(   C8, -0.0f,  C12 );
    vert[ 35] = new PVector(   C8, -0.0f, -C12 );
    vert[ 36] = new PVector(  -C0,  C19,  -C2 );
    vert[ 37] = new PVector(   C0,  C19,   C2 );
    vert[ 38] = new PVector(   C0, -C19,  -C2 );
    vert[ 39] = new PVector(  -C0, -C19,   C2 );
    vert[ 40] = new PVector( -C19,  -C2,   C0 );
    vert[ 41] = new PVector(  C19,  -C2,  -C0 );
    vert[ 42] = new PVector(  C19,   C2,   C0 );
    vert[ 43] = new PVector( -C19,   C2,  -C0 );
    vert[ 44] = new PVector(   C2,   C0,  C19 );
    vert[ 45] = new PVector(  -C2,   C0, -C19 );
    vert[ 46] = new PVector(  -C2,  -C0,  C19 );
    vert[ 47] = new PVector(   C2,  -C0, -C19 );
    vert[ 48] = new PVector(  -C5,   C4,  C17 );
    vert[ 49] = new PVector(   C5,   C4, -C17 );
    vert[ 50] = new PVector(   C5,  -C4,  C17 );
    vert[ 51] = new PVector(  -C5,  -C4, -C17 );
    vert[ 52] = new PVector(   C4,  C17,  -C5 );
    vert[ 53] = new PVector(  -C4,  C17,   C5 );
    vert[ 54] = new PVector(  -C4, -C17,  -C5 );
    vert[ 55] = new PVector(   C4, -C17,   C5 );
    vert[ 56] = new PVector(  C17,  -C5,   C4 );
    vert[ 57] = new PVector( -C17,  -C5,  -C4 );
    vert[ 58] = new PVector( -C17,   C5,   C4 );
    vert[ 59] = new PVector(  C17,   C5,  -C4 );
    vert[ 60] = new PVector(  -C7,  C16,  -C9 );
    vert[ 61] = new PVector(   C7,  C16,   C9 );
    vert[ 62] = new PVector(   C7, -C16,  -C9 );
    vert[ 63] = new PVector(  -C7, -C16,   C9 );
    vert[ 64] = new PVector(  C16,  -C9,  -C7 );
    vert[ 65] = new PVector( -C16,  -C9,   C7 );
    vert[ 66] = new PVector( -C16,   C9,  -C7 );
    vert[ 67] = new PVector(  C16,   C9,   C7 );
    vert[ 68] = new PVector(  -C9,  -C7,  C16 );
    vert[ 69] = new PVector(   C9,  -C7, -C16 );
    vert[ 70] = new PVector(   C9,   C7,  C16 );
    vert[ 71] = new PVector(  -C9,   C7, -C16 );
    vert[ 72] = new PVector(  C15,   C1,  C11 );
    vert[ 73] = new PVector( -C15,   C1, -C11 );
    vert[ 74] = new PVector( -C15,  -C1,  C11 );
    vert[ 75] = new PVector(  C15,  -C1, -C11 );
    vert[ 76] = new PVector(  -C1,  C11, -C15 );
    vert[ 77] = new PVector(   C1,  C11,  C15 );
    vert[ 78] = new PVector(   C1, -C11, -C15 );
    vert[ 79] = new PVector(  -C1, -C11,  C15 );
    vert[ 80] = new PVector( -C11, -C15,   C1 );
    vert[ 81] = new PVector(  C11, -C15,  -C1 );
    vert[ 82] = new PVector(  C11,  C15,   C1 );
    vert[ 83] = new PVector( -C11,  C15,  -C1 );
    vert[ 84] = new PVector( -C10, -C10, -C10 );
    vert[ 85] = new PVector( -C10, -C10,  C10 );
    vert[ 86] = new PVector(  C10, -C10, -C10 );
    vert[ 87] = new PVector(  C10, -C10,  C10 );
    vert[ 88] = new PVector( -C10,  C10, -C10 );
    vert[ 89] = new PVector( -C10,  C10,  C10 );
    vert[ 90] = new PVector(  C10,  C10, -C10 );
    vert[ 91] = new PVector(  C10,  C10,  C10 );
    // set faces
    faces[ 0] = new int[] { 24,  0,  2, 14, 36 };
    faces[ 1] = new int[] { 24, 36, 72, 86, 76 };
    faces[ 2] = new int[] { 24, 76, 40, 16, 52 };
    faces[ 3] = new int[] { 24, 52, 64, 84, 60 };
    faces[ 4] = new int[] { 24, 60, 48, 12,  0 };
    faces[ 5] = new int[] { 25,  1,  3, 13, 37 };
    faces[ 6] = new int[] { 25, 37, 73, 85, 77 };
    faces[ 7] = new int[] { 25, 77, 41, 17, 53 };
    faces[ 8] = new int[] { 25, 53, 65, 87, 61 };
    faces[ 9] = new int[] { 25, 61, 49, 15,  1 };
    faces[10] = new int[] { 26,  2,  0, 12, 38 };
    faces[11] = new int[] { 26, 38, 74, 88, 78 };
    faces[12] = new int[] { 26, 78, 42, 18, 54 };
    faces[13] = new int[] { 26, 54, 66, 90, 62 };
    faces[14] = new int[] { 26, 62, 50, 14,  2 };
    faces[15] = new int[] { 27,  3,  1, 15, 39 };
    faces[16] = new int[] { 27, 39, 75, 91, 79 };
    faces[17] = new int[] { 27, 79, 43, 19, 55 };
    faces[18] = new int[] { 27, 55, 67, 89, 63 };
    faces[19] = new int[] { 27, 63, 51, 13,  3 };
    faces[20] = new int[] { 28,  4,  5, 17, 41 };
    faces[21] = new int[] { 28, 41, 77, 85, 81 };
    faces[22] = new int[] { 28, 81, 45, 20, 56 };
    faces[23] = new int[] { 28, 56, 68, 84, 64 };
    faces[24] = new int[] { 28, 64, 52, 16,  4 };
    faces[25] = new int[] { 29,  5,  4, 16, 40 };
    faces[26] = new int[] { 29, 40, 76, 86, 80 };
    faces[27] = new int[] { 29, 80, 44, 21, 57 };
    faces[28] = new int[] { 29, 57, 69, 87, 65 };
    faces[29] = new int[] { 29, 65, 53, 17,  5 };
    faces[30] = new int[] { 30,  7,  6, 18, 42 };
    faces[31] = new int[] { 30, 42, 78, 88, 82 };
    faces[32] = new int[] { 30, 82, 46, 22, 59 };
    faces[33] = new int[] { 30, 59, 71, 89, 67 };
    faces[34] = new int[] { 30, 67, 55, 19,  7 };
    faces[35] = new int[] { 31,  6,  7, 19, 43 };
    faces[36] = new int[] { 31, 43, 79, 91, 83 };
    faces[37] = new int[] { 31, 83, 47, 23, 58 };
    faces[38] = new int[] { 31, 58, 70, 90, 66 };
    faces[39] = new int[] { 31, 66, 54, 18,  6 };
    faces[40] = new int[] { 32,  8, 11, 22, 46 };
    faces[41] = new int[] { 32, 46, 82, 88, 74 };
    faces[42] = new int[] { 32, 74, 38, 12, 48 };
    faces[43] = new int[] { 32, 48, 60, 84, 68 };
    faces[44] = new int[] { 32, 68, 56, 20,  8 };
    faces[45] = new int[] { 33, 11,  8, 20, 45 };
    faces[46] = new int[] { 33, 45, 81, 85, 73 };
    faces[47] = new int[] { 33, 73, 37, 13, 51 };
    faces[48] = new int[] { 33, 51, 63, 89, 71 };
    faces[49] = new int[] { 33, 71, 59, 22, 11 };
    faces[50] = new int[] { 34, 10,  9, 21, 44 };
    faces[51] = new int[] { 34, 44, 80, 86, 72 };
    faces[52] = new int[] { 34, 72, 36, 14, 50 };
    faces[53] = new int[] { 34, 50, 62, 90, 70 };
    faces[54] = new int[] { 34, 70, 58, 23, 10 };
    faces[55] = new int[] { 35,  9, 10, 23, 47 };
    faces[56] = new int[] { 35, 47, 83, 91, 75 };
    faces[57] = new int[] { 35, 75, 39, 15, 49 };
    faces[58] = new int[] { 35, 49, 61, 87, 69 };
    faces[59] = new int[] { 35, 69, 57, 21,  9 };
  } //end GreatInvertedPentagonalHexecontahedron()

  public String name() {
    return "Great Inverted Pentagonal Hexecontahedron";
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
   
} //end class GreatInvertedPentagonalHexecontahedron
/*
GreatInvertedSnubIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatInvertedSnubIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 92;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0458322048361746757966472099854f;  //square-root of a root of the polynomial: 4096*(x^6) - 18432*(x^5) + 29184*(x^4) - 20160*(x^3) + 5728*(x^2) - 488*x + 1
  final float C1  = 0.0926952885354777710872481278869f;  //square-root of a root of the polynomial: 4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C2  = 0.113317456590685126375650604467f;   //square-root of a root of the polynomial: 4096*(x^6) - 9728*(x^4) - 3072*(x^3) + 4256*(x^2) - 132*x + 1
  final float C3  = 0.187475521794963058008011505776f;   //square-root of a root of the polynomial: 4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C4  = 0.206012745126162897462898732354f;   //square-root of a root of the polynomial: 4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1
  final float C5  = 0.229183701118593991387526824407f;   //square-root of a root of the polynomial: 4096*(x^6) - 5120*(x^5) + 9472*(x^4) - 5888*(x^3) + 1216*(x^2) - 68*x + 1
  final float C6  = 0.257509561486697247223240515731f;   //square-root of a root of the polynomial: 4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C7  = 0.280170810330440829095259633663f;   //square-root of a root of the polynomial:  4096*(x^6) - 17408*(x^5) + 28672*(x^4) - 21696*(x^3) + 6672*(x^2) - 416*x + 1
  final float C8  = 0.379167828565975488150770490117f;   //square-root of a root of the polynomial: 4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C9  = 0.407493688934078743986484181441f;   //square-root of a root of the polynomial: 4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C10 = 0.4635223066128601446861392480851f;  //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) + 15872*(x^4) - 6016*(x^3) + 912*(x^2) - 56*x + 1
  final float C11 = 0.509354511449034820482786458071f;   //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C12 = 0.520811145524763870362134785908f;   //square-root of a root of the polynomial: 4096*(x^6) + 3072*(x^5) - 3584*(x^4) - 2048*(x^3) + 1312*(x^2) - 160*x + 1
  final float C13 = 0.566643350360938546158781995893f;   //square-root of a root of the polynomial: 4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  final float C14 = 0.636677390052672735374011005848f;   //square-root of a root of the polynomial: 4096*(x^6) - 8192*(x^5) + 1792*(x^4) - 7488*(x^3) + 3456*(x^2) - 116*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatInvertedSnubIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector( -C10,   C3,  -C9 );
    vert[  1] = new PVector(  C10,   C3,   C9 );
    vert[  2] = new PVector(  C10,  -C3,  -C9 );
    vert[  3] = new PVector( -C10,  -C3,   C9 );
    vert[  4] = new PVector(  -C3,  -C9,  C10 );
    vert[  5] = new PVector(   C3,  -C9, -C10 );
    vert[  6] = new PVector(   C3,   C9,  C10 );
    vert[  7] = new PVector(  -C3,   C9, -C10 );
    vert[  8] = new PVector(   C9,  C10,   C3 );
    vert[  9] = new PVector(  -C9,  C10,  -C3 );
    vert[ 10] = new PVector(  -C9, -C10,   C3 );
    vert[ 11] = new PVector(   C9, -C10,  -C3 );
    vert[ 12] = new PVector(   C5,  C13,   C4 );
    vert[ 13] = new PVector(  -C5,  C13,  -C4 );
    vert[ 14] = new PVector(  -C5, -C13,   C4 );
    vert[ 15] = new PVector(   C5, -C13,  -C4 );
    vert[ 16] = new PVector(  C13,   C4,   C5 );
    vert[ 17] = new PVector( -C13,   C4,  -C5 );
    vert[ 18] = new PVector( -C13,  -C4,   C5 );
    vert[ 19] = new PVector(  C13,  -C4,  -C5 );
    vert[ 20] = new PVector(   C4,   C5,  C13 );
    vert[ 21] = new PVector(  -C4,   C5, -C13 );
    vert[ 22] = new PVector(  -C4,  -C5,  C13 );
    vert[ 23] = new PVector(   C4,  -C5, -C13 );
    vert[ 24] = new PVector(  -C2,   C8,  C11 );
    vert[ 25] = new PVector(   C2,   C8, -C11 );
    vert[ 26] = new PVector(   C2,  -C8,  C11 );
    vert[ 27] = new PVector(  -C2,  -C8, -C11 );
    vert[ 28] = new PVector(  -C8,  C11,   C2 );
    vert[ 29] = new PVector(   C8,  C11,  -C2 );
    vert[ 30] = new PVector(   C8, -C11,   C2 );
    vert[ 31] = new PVector(  -C8, -C11,  -C2 );
    vert[ 32] = new PVector( -C11,   C2,   C8 );
    vert[ 33] = new PVector(  C11,   C2,  -C8 );
    vert[ 34] = new PVector(  C11,  -C2,   C8 );
    vert[ 35] = new PVector( -C11,  -C2,  -C8 );
    vert[ 36] = new PVector(  C12,   C7,  -C6 );
    vert[ 37] = new PVector( -C12,   C7,   C6 );
    vert[ 38] = new PVector( -C12,  -C7,  -C6 );
    vert[ 39] = new PVector(  C12,  -C7,   C6 );
    vert[ 40] = new PVector(  -C7,  -C6, -C12 );
    vert[ 41] = new PVector(   C7,  -C6,  C12 );
    vert[ 42] = new PVector(   C7,   C6, -C12 );
    vert[ 43] = new PVector(  -C7,   C6,  C12 );
    vert[ 44] = new PVector(   C6, -C12,   C7 );
    vert[ 45] = new PVector(  -C6, -C12,  -C7 );
    vert[ 46] = new PVector(  -C6,  C12,   C7 );
    vert[ 47] = new PVector(   C6,  C12,  -C7 );
    vert[ 48] = new PVector(   C1,   C0, -C14 );
    vert[ 49] = new PVector(  -C1,   C0,  C14 );
    vert[ 50] = new PVector(  -C1,  -C0, -C14 );
    vert[ 51] = new PVector(   C1,  -C0,  C14 );
    vert[ 52] = new PVector(   C0, -C14,   C1 );
    vert[ 53] = new PVector(  -C0, -C14,  -C1 );
    vert[ 54] = new PVector(  -C0,  C14,   C1 );
    vert[ 55] = new PVector(   C0,  C14,  -C1 );
    vert[ 56] = new PVector( -C14,   C1,   C0 );
    vert[ 57] = new PVector(  C14,   C1,  -C0 );
    vert[ 58] = new PVector(  C14,  -C1,   C0 );
    vert[ 59] = new PVector( -C14,  -C1,  -C0 );
    // set faces
    faces[  0] = new int[] {  0, 36, 28, 48, 12 };
    faces[  1] = new int[] {  1, 37, 29, 49, 13 };
    faces[  2] = new int[] {  2, 38, 30, 50, 14 };
    faces[  3] = new int[] {  3, 39, 31, 51, 15 };
    faces[  4] = new int[] {  4, 40, 32, 53, 17 };
    faces[  5] = new int[] {  5, 41, 33, 52, 16 };
    faces[  6] = new int[] {  6, 42, 34, 55, 19 };
    faces[  7] = new int[] {  7, 43, 35, 54, 18 };
    faces[  8] = new int[] {  8, 44, 24, 58, 22 };
    faces[  9] = new int[] {  9, 45, 25, 59, 23 };
    faces[ 10] = new int[] { 10, 46, 26, 56, 20 };
    faces[ 11] = new int[] { 11, 47, 27, 57, 21 };
    faces[ 12] = new int[] {  0,  2, 14, 14, 14 };
    faces[ 13] = new int[] {  1,  3, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2,  0, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3,  1, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4,  5, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5,  4, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6,  7, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7,  6, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 11, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 10, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10,  9, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11,  8, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 48, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 49, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 50, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 51, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 52, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 53, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 54, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 55, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 56, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 57, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 58, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 59, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 44, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 45, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 46, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 47, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 36, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 37, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 38, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 39, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 40, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 41, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 42, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 43, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37,  1, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38,  2, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  3, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40,  4, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  5, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  6, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43,  7, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  8, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45,  9, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 10, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47, 11, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 28, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49, 29, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50, 30, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 31, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52, 33, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 32, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 35, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 34, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 26, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57, 27, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 24, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 25, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 24,  0, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 25,  1, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 26,  2, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 27,  3, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 28,  4, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 29,  5, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 30,  6, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 31,  7, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 32,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 33,  9, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 34, 10, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 35, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 36, 44, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 37, 45, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 38, 46, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 39, 47, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 48, 52, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 49, 53, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 50, 54, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 51, 55, 59, 59, 59 };  //added 2x 3rd row to fill gaps
  } //end GreatInvertedSnubIcosidodecahedron()

  public String name() {
    return "Great Inverted Snub Icosidodecahedron";
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
   
} //end class GreatInvertedSnubIcosidodecahedron
/*
GreatPentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatPentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0734018217014516670841263130528f;    //square-root of a root of the polynomial:  4096*(x^6) - 16384*(x^5) + 24832*(x^4) - 17344*(x^3) + 4992*(x^2) - 212*x + 1
  final float C1  = 0.102690663988850052252480093759f;     //square-root of a root of the polynomial:  4096*(x^6) - 18432*(x^5) + 16384*(x^4) - 8960*(x^3) + 8928*(x^2) - 188*x + 1
  final float C2  = 0.113690409611386992694315866713f;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C3  = 0.216381073600237044946795960472f;     //square-root of a root of the polynomial:  4096*(x^6) + 3072*(x^5) - 16128*(x^4) - 17152*(x^3) + 2176*(x^2) - 84*x + 1
  final float C4  = 0.221457306337958486476607569170f;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 40704*(x^4) - 44288*(x^3) + 21504*(x^2) - 3420*x + 121
  final float C5  = 0.239558806362705904548162003542f;     //square-root of a root of the polynomial:  4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C6  = 0.257356768647573545542485428757f;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1
  final float C7  = 0.284923627010362671688163165899f;     //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C8  = 0.335147715949345479170923435882f;     //square-root of a root of the polynomial:  4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C9  = 0.350378738996896029181911236597f;     //square-root of a root of the polynomial:  3936256*(x^6) - 14764032*(x^5) + 2619648*(x^4) - 103040*(x^3) - 736*(x^2) + 32*x + 1
  final float C10 = 0.416411998906617305376802457828f;     //square-root of a root of the polynomial:  4096*(x^6) - 11264*(x^5) + 9472*(x^4) - 2944*(x^3) + 432*(x^2) - 32*x + 1
  final float C11 = 0.423513753308827783006521119246f;     //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) + 16896*(x^4) - 14528*(x^3) + 6112*(x^2) - 720*x + 1
  final float C12 = 0.468878573956484550146522281604f;     //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C13 = 0.501304700610599716634959126371f;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 4608*(x^4) + 9920*(x^3) - 96*(x^2) - 1108*x + 121
  final float C14 = 0.566924708632306013012764112928f;     //square-root of a root of the polynomial:  3936256*(x^6) - 7502848*(x^5) + 3239168*(x^4) - 452480*(x^3) + 17264*(x^2) + 208*x + 1
  final float C15 = 0.571569237945334602399002375363f;     //square-root of a root of the polynomial:  4096*(x^6) - 27648*(x^5) + 72704*(x^4) - 92160*(x^3) + 54448*(x^2) - 11292*x + 361
  final float C16 = 0.574706522312051383719085439424f;     //square-root of a root of the polynomial:  4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  final float C17 = 0.644971059646786269483128688416f;     //square-root of a root of the polynomial:  4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C18 = 0.6737687675541908509192878865853f;    //square-root of a root of the polynomial:  4096*(x^6) - 14336*(x^5) + 14592*(x^4) - 6016*(x^3) + 992*(x^2) - 48*x + 1
  final float C19 = 0.708437380319190454694684285146f;     //square-root of a root of the polynomial:  4096*(x^6) - 4096*(x^5) + 3840*(x^4) - 14720*(x^3) + 17040*(x^2) - 6876*x + 841
  private PVector[] vert = new PVector[92]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatPentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C3,  -C5,  C17 );
    vert[  1] = new PVector(  -C3,  -C5, -C17 );
    vert[  2] = new PVector(  -C3,   C5,  C17 );
    vert[  3] = new PVector(   C3,   C5, -C17 );
    vert[  4] = new PVector(  -C5,  C17,   C3 );
    vert[  5] = new PVector(   C5,  C17,  -C3 );
    vert[  6] = new PVector(   C5, -C17,   C3 );
    vert[  7] = new PVector(  -C5, -C17,  -C3 );
    vert[  8] = new PVector(  C17,   C3,  -C5 );
    vert[  9] = new PVector( -C17,   C3,   C5 );
    vert[ 10] = new PVector( -C17,  -C3,  -C5 );
    vert[ 11] = new PVector(  C17,  -C3,   C5 );
    vert[ 12] = new PVector(  C18,  0.0f,   C6 );
    vert[ 13] = new PVector(  C18,  0.0f,  -C6 );
    vert[ 14] = new PVector( -C18,  0.0f,   C6 );
    vert[ 15] = new PVector( -C18,  0.0f,  -C6 );
    vert[ 16] = new PVector(  0.0f,   C6,  C18 );
    vert[ 17] = new PVector(  0.0f,   C6, -C18 );
    vert[ 18] = new PVector(  0.0f,  -C6,  C18 );
    vert[ 19] = new PVector(  0.0f,  -C6, -C18 );
    vert[ 20] = new PVector(   C6,  C18,  0.0f );
    vert[ 21] = new PVector(  -C6,  C18,  0.0f );
    vert[ 22] = new PVector(   C6, -C18,  0.0f );
    vert[ 23] = new PVector(  -C6, -C18,  0.0f );
    vert[ 24] = new PVector(  0.0f, -C14,   C9 );
    vert[ 25] = new PVector(  0.0f, -C14,  -C9 );
    vert[ 26] = new PVector(  0.0f,  C14,   C9 );
    vert[ 27] = new PVector(  0.0f,  C14,  -C9 );
    vert[ 28] = new PVector( -C14,   C9,  0.0f );
    vert[ 29] = new PVector(  C14,   C9,  0.0f );
    vert[ 30] = new PVector( -C14,  -C9,  0.0f );
    vert[ 31] = new PVector(  C14,  -C9,  0.0f );
    vert[ 32] = new PVector(   C9,  0.0f, -C14 );
    vert[ 33] = new PVector(   C9,  0.0f,  C14 );
    vert[ 34] = new PVector(  -C9,  0.0f, -C14 );
    vert[ 35] = new PVector(  -C9,  0.0f,  C14 );
    vert[ 36] = new PVector( -C11, -C16,   C1 );
    vert[ 37] = new PVector(  C11, -C16,  -C1 );
    vert[ 38] = new PVector(  C11,  C16,   C1 );
    vert[ 39] = new PVector( -C11,  C16,  -C1 );
    vert[ 40] = new PVector(  C16,   C1,  C11 );
    vert[ 41] = new PVector( -C16,   C1, -C11 );
    vert[ 42] = new PVector( -C16,  -C1,  C11 );
    vert[ 43] = new PVector(  C16,  -C1, -C11 );
    vert[ 44] = new PVector(  -C1,  C11, -C16 );
    vert[ 45] = new PVector(   C1,  C11,  C16 );
    vert[ 46] = new PVector(   C1, -C11, -C16 );
    vert[ 47] = new PVector(  -C1, -C11,  C16 );
    vert[ 48] = new PVector(  C15,  -C8,  -C7 );
    vert[ 49] = new PVector( -C15,  -C8,   C7 );
    vert[ 50] = new PVector( -C15,   C8,  -C7 );
    vert[ 51] = new PVector(  C15,   C8,   C7 );
    vert[ 52] = new PVector(  -C8,  -C7,  C15 );
    vert[ 53] = new PVector(   C8,  -C7, -C15 );
    vert[ 54] = new PVector(   C8,   C7,  C15 );
    vert[ 55] = new PVector(  -C8,   C7, -C15 );
    vert[ 56] = new PVector(  -C7,  C15,  -C8 );
    vert[ 57] = new PVector(   C7,  C15,   C8 );
    vert[ 58] = new PVector(   C7, -C15,  -C8 );
    vert[ 59] = new PVector(  -C7, -C15,   C8 );
    vert[ 60] = new PVector(   C0, -C19,  -C2 );
    vert[ 61] = new PVector(  -C0, -C19,   C2 );
    vert[ 62] = new PVector(  -C0,  C19,  -C2 );
    vert[ 63] = new PVector(   C0,  C19,   C2 );
    vert[ 64] = new PVector( -C19,  -C2,   C0 );
    vert[ 65] = new PVector(  C19,  -C2,  -C0 );
    vert[ 66] = new PVector(  C19,   C2,   C0 );
    vert[ 67] = new PVector( -C19,   C2,  -C0 );
    vert[ 68] = new PVector(  -C2,   C0, -C19 );
    vert[ 69] = new PVector(   C2,   C0,  C19 );
    vert[ 70] = new PVector(   C2,  -C0, -C19 );
    vert[ 71] = new PVector(  -C2,  -C0,  C19 );
    vert[ 72] = new PVector(  -C4, -C12, -C13 );
    vert[ 73] = new PVector(   C4, -C12,  C13 );
    vert[ 74] = new PVector(   C4,  C12, -C13 );
    vert[ 75] = new PVector(  -C4,  C12,  C13 );
    vert[ 76] = new PVector(  C12, -C13,   C4 );
    vert[ 77] = new PVector( -C12, -C13,  -C4 );
    vert[ 78] = new PVector( -C12,  C13,   C4 );
    vert[ 79] = new PVector(  C12,  C13,  -C4 );
    vert[ 80] = new PVector(  C13,   C4, -C12 );
    vert[ 81] = new PVector( -C13,   C4,  C12 );
    vert[ 82] = new PVector( -C13,  -C4, -C12 );
    vert[ 83] = new PVector(  C13,  -C4,  C12 );
    vert[ 84] = new PVector( -C10, -C10, -C10 );
    vert[ 85] = new PVector( -C10, -C10,  C10 );
    vert[ 86] = new PVector(  C10, -C10, -C10 );
    vert[ 87] = new PVector(  C10, -C10,  C10 );
    vert[ 88] = new PVector( -C10,  C10, -C10 );
    vert[ 89] = new PVector( -C10,  C10,  C10 );
    vert[ 90] = new PVector(  C10,  C10, -C10 );
    vert[ 91] = new PVector(  C10,  C10,  C10 );
    // set faces
    faces[ 0] = new int[] { 24,  0,  2, 14, 36 };
    faces[ 1] = new int[] { 24, 36, 72, 86, 76 };
    faces[ 2] = new int[] { 24, 76, 40, 16, 52 };
    faces[ 3] = new int[] { 24, 52, 64, 84, 60 };
    faces[ 4] = new int[] { 24, 60, 48, 12,  0 };
    faces[ 5] = new int[] { 25,  1,  3, 13, 37 };
    faces[ 6] = new int[] { 25, 37, 73, 85, 77 };
    faces[ 7] = new int[] { 25, 77, 41, 17, 53 };
    faces[ 8] = new int[] { 25, 53, 65, 87, 61 };
    faces[ 9] = new int[] { 25, 61, 49, 15,  1 };
    faces[10] = new int[] { 26,  2,  0, 12, 38 };
    faces[11] = new int[] { 26, 38, 74, 88, 78 };
    faces[12] = new int[] { 26, 78, 42, 18, 54 };
    faces[13] = new int[] { 26, 54, 66, 90, 62 };
    faces[14] = new int[] { 26, 62, 50, 14,  2 };
    faces[15] = new int[] { 27,  3,  1, 15, 39 };
    faces[16] = new int[] { 27, 39, 75, 91, 79 };
    faces[17] = new int[] { 27, 79, 43, 19, 55 };
    faces[18] = new int[] { 27, 55, 67, 89, 63 };
    faces[19] = new int[] { 27, 63, 51, 13,  3 };
    faces[20] = new int[] { 28,  4,  5, 17, 41 };
    faces[21] = new int[] { 28, 41, 77, 85, 81 };
    faces[22] = new int[] { 28, 81, 45, 20, 56 };
    faces[23] = new int[] { 28, 56, 68, 84, 64 };
    faces[24] = new int[] { 28, 64, 52, 16,  4 };
    faces[25] = new int[] { 29,  5,  4, 16, 40 };
    faces[26] = new int[] { 29, 40, 76, 86, 80 };
    faces[27] = new int[] { 29, 80, 44, 21, 57 };
    faces[28] = new int[] { 29, 57, 69, 87, 65 };
    faces[29] = new int[] { 29, 65, 53, 17,  5 };
    faces[30] = new int[] { 30,  7,  6, 18, 42 };
    faces[31] = new int[] { 30, 42, 78, 88, 82 };
    faces[32] = new int[] { 30, 82, 46, 22, 59 };
    faces[33] = new int[] { 30, 59, 71, 89, 67 };
    faces[34] = new int[] { 30, 67, 55, 19,  7 };
    faces[35] = new int[] { 31,  6,  7, 19, 43 };
    faces[36] = new int[] { 31, 43, 79, 91, 83 };
    faces[37] = new int[] { 31, 83, 47, 23, 58 };
    faces[38] = new int[] { 31, 58, 70, 90, 66 };
    faces[39] = new int[] { 31, 66, 54, 18,  6 };
    faces[40] = new int[] { 32,  8, 11, 22, 46 };
    faces[41] = new int[] { 32, 46, 82, 88, 74 };
    faces[42] = new int[] { 32, 74, 38, 12, 48 };
    faces[43] = new int[] { 32, 48, 60, 84, 68 };
    faces[44] = new int[] { 32, 68, 56, 20,  8 };
    faces[45] = new int[] { 33, 11,  8, 20, 45 };
    faces[46] = new int[] { 33, 45, 81, 85, 73 };
    faces[47] = new int[] { 33, 73, 37, 13, 51 };
    faces[48] = new int[] { 33, 51, 63, 89, 71 };
    faces[49] = new int[] { 33, 71, 59, 22, 11 };
    faces[50] = new int[] { 34, 10,  9, 21, 44 };
    faces[51] = new int[] { 34, 44, 80, 86, 72 };
    faces[52] = new int[] { 34, 72, 36, 14, 50 };
    faces[53] = new int[] { 34, 50, 62, 90, 70 };
    faces[54] = new int[] { 34, 70, 58, 23, 10 };
    faces[55] = new int[] { 35,  9, 10, 23, 47 };
    faces[56] = new int[] { 35, 47, 83, 91, 75 };
    faces[57] = new int[] { 35, 75, 39, 15, 49 };
    faces[58] = new int[] { 35, 49, 61, 87, 69 };
    faces[59] = new int[] { 35, 69, 57, 21,  9 };
  } //end GreatPentagonalHexecontahedron()

  public String name() {
    return "Great Pentagonal Hexecontahedron";
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
   
} //end class GreatPentagonalHexecontahedron
/*
GreatPentagrammicHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatPentagrammicHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0560019989928211678603893479474f;    //square-root of a root of the polynomial:  4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  final float C1  = 0.185429852490318573673699052310f;     //square-root of a root of the polynomial:  3936256*(x^6) - 14764032*(x^5) + 2619648*(x^4) - 103040*(x^3) - 736*(x^2) + 32*x + 1
  final float C2  = 0.203328600270301223480224804384f;     //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C3  = 0.293941738078623251618063062732f;     //square-root of a root of the polynomial:  4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C4  = 0.3000318038582147842375534631151f;    //square-root of a root of the polynomial:  3936256*(x^6) - 7502848*(x^5) + 3239168*(x^4) - 452480*(x^3) + 17264*(x^2) + 208*x + 1
  final float C5  = 0.384994585115109604284725376882f;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C6  = 0.419605723930610464562174287283f;     //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C7  = 0.469641273709560175343498358929f;     //square-root of a root of the polynomial:  4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C8  = 0.525643272702381343203887706876f;     //square-root of a root of the polynomial:  4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C9  = 0.556566943111559552415834560497f;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1
  final float C10 = 0.854635858824669779628223735812f;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 40704*(x^4) - 44288*(x^3) + 21504*(x^2) - 3420*x + 121
  final float C11 = 0.9005442309691325148152216948752f;    //square-root of a root of the polynomial:  4096*(x^6) - 11264*(x^5) + 9472*(x^4) - 2944*(x^3) + 432*(x^2) - 32*x + 1
  final float C12 = 0.945248996632991807766061994160f;     //square-root of a root of the polynomial:  4096*(x^6) - 4096*(x^5) + 3840*(x^4) - 14720*(x^3) + 17040*(x^2) - 6876*x + 841
  final float C13 = 1.05383728146048402751412242761f;      //square-root of a root of the polynomial:  4096*(x^6) - 18432*(x^5) + 16384*(x^4) - 8960*(x^3) + 8928*(x^2) - 188*x + 1
  final float C14 = 1.14857759690329303124628679854f;      //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) + 16896*(x^4) - 14528*(x^3) + 6112*(x^2) - 720*x + 1
  final float C15 = 1.17950126731247124045823365216f;      //square-root of a root of the polynomial:  4096*(x^6) - 16384*(x^5) + 24832*(x^4) - 17344*(x^3) + 4992*(x^2) - 212*x + 1
  final float C16 = 1.23550326630529240831862300011f;      //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 4608*(x^4) + 9920*(x^3) - 96*(x^2) - 1108*x + 121
  final float C17 = 1.438831866575593631798847804496f;     //square-root of a root of the polynomial:  4096*(x^6) + 3072*(x^5) - 16128*(x^4) - 17152*(x^3) + 2176*(x^2) - 84*x + 1
  final float C18 = 1.45711117408069206723105625537f;      //square-root of a root of the polynomial:  4096*(x^6) - 14336*(x^5) + 14592*(x^4) - 6016*(x^3) + 992*(x^2) - 48*x + 1
  final float C19 = 1.47344300539109449207629671490f;      //square-root of a root of the polynomial:  4096*(x^6) - 27648*(x^5) + 72704*(x^4) - 92160*(x^3) + 54448*(x^2) - 11292*x + 361
  private PVector[] vert = new PVector[92]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatPentagrammicHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector( -C17,   C8,  -C3 );
    vert[  1] = new PVector(  C17,   C8,   C3 );
    vert[  2] = new PVector(  C17,  -C8,  -C3 );
    vert[  3] = new PVector( -C17,  -C8,   C3 );
    vert[  4] = new PVector(   C8,  -C3, -C17 );
    vert[  5] = new PVector(  -C8,  -C3,  C17 );
    vert[  6] = new PVector(  -C8,   C3, -C17 );
    vert[  7] = new PVector(   C8,   C3,  C17 );
    vert[  8] = new PVector(  -C3, -C17,   C8 );
    vert[  9] = new PVector(   C3, -C17,  -C8 );
    vert[ 10] = new PVector(   C3,  C17,   C8 );
    vert[ 11] = new PVector(  -C3,  C17,  -C8 );
    vert[ 12] = new PVector(  C18, -0.0f,   C9 );
    vert[ 13] = new PVector(  C18, -0.0f,  -C9 );
    vert[ 14] = new PVector( -C18, -0.0f,   C9 );
    vert[ 15] = new PVector( -C18, -0.0f,  -C9 );
    vert[ 16] = new PVector(  0.0f,   C9,  C18 );
    vert[ 17] = new PVector(  0.0f,   C9, -C18 );
    vert[ 18] = new PVector(  0.0f,  -C9,  C18 );
    vert[ 19] = new PVector(  0.0f,  -C9, -C18 );
    vert[ 20] = new PVector(   C9,  C18,  0.0f );
    vert[ 21] = new PVector(  -C9,  C18,  0.0f );
    vert[ 22] = new PVector(   C9, -C18,  0.0f );
    vert[ 23] = new PVector(  -C9, -C18,  0.0f );
    vert[ 24] = new PVector(  0.0f,  -C4,   C1 );
    vert[ 25] = new PVector(  0.0f,  -C4,  -C1 );
    vert[ 26] = new PVector(  0.0f,   C4,   C1 );
    vert[ 27] = new PVector(  0.0f,   C4,  -C1 );
    vert[ 28] = new PVector(  -C4,   C1,  0.0f );
    vert[ 29] = new PVector(   C4,   C1,  0.0f );
    vert[ 30] = new PVector(  -C4,  -C1,  0.0f );
    vert[ 31] = new PVector(   C4,  -C1,  0.0f );
    vert[ 32] = new PVector(   C1, -0.0f,  -C4 );
    vert[ 33] = new PVector(   C1, -0.0f,   C4 );
    vert[ 34] = new PVector(  -C1, -0.0f,  -C4 );
    vert[ 35] = new PVector(  -C1, -0.0f,   C4 );
    vert[ 36] = new PVector(  C14,   C0, -C13 );
    vert[ 37] = new PVector( -C14,   C0,  C13 );
    vert[ 38] = new PVector( -C14,  -C0, -C13 );
    vert[ 39] = new PVector(  C14,  -C0,  C13 );
    vert[ 40] = new PVector(  -C0, -C13, -C14 );
    vert[ 41] = new PVector(   C0, -C13,  C14 );
    vert[ 42] = new PVector(   C0,  C13, -C14 );
    vert[ 43] = new PVector(  -C0,  C13,  C14 );
    vert[ 44] = new PVector(  C13, -C14,   C0 );
    vert[ 45] = new PVector( -C13, -C14,  -C0 );
    vert[ 46] = new PVector( -C13,  C14,   C0 );
    vert[ 47] = new PVector(  C13,  C14,  -C0 );
    vert[ 48] = new PVector( -C19,  -C7,  -C2 );
    vert[ 49] = new PVector(  C19,  -C7,   C2 );
    vert[ 50] = new PVector(  C19,   C7,  -C2 );
    vert[ 51] = new PVector( -C19,   C7,   C2 );
    vert[ 52] = new PVector(  -C7,  -C2, -C19 );
    vert[ 53] = new PVector(   C7,  -C2,  C19 );
    vert[ 54] = new PVector(   C7,   C2, -C19 );
    vert[ 55] = new PVector(  -C7,   C2,  C19 );
    vert[ 56] = new PVector(  -C2, -C19,  -C7 );
    vert[ 57] = new PVector(   C2, -C19,   C7 );
    vert[ 58] = new PVector(   C2,  C19,  -C7 );
    vert[ 59] = new PVector(  -C2,  C19,   C7 );
    vert[ 60] = new PVector(  C15,  C12,   C5 );
    vert[ 61] = new PVector( -C15,  C12,  -C5 );
    vert[ 62] = new PVector( -C15, -C12,   C5 );
    vert[ 63] = new PVector(  C15, -C12,  -C5 );
    vert[ 64] = new PVector(  C12,   C5,  C15 );
    vert[ 65] = new PVector( -C12,   C5, -C15 );
    vert[ 66] = new PVector( -C12,  -C5,  C15 );
    vert[ 67] = new PVector(  C12,  -C5, -C15 );
    vert[ 68] = new PVector(   C5,  C15,  C12 );
    vert[ 69] = new PVector(  -C5,  C15, -C12 );
    vert[ 70] = new PVector(  -C5, -C15,  C12 );
    vert[ 71] = new PVector(   C5, -C15, -C12 );
    vert[ 72] = new PVector( -C10,   C6,  C16 );
    vert[ 73] = new PVector(  C10,   C6, -C16 );
    vert[ 74] = new PVector(  C10,  -C6,  C16 );
    vert[ 75] = new PVector( -C10,  -C6, -C16 );
    vert[ 76] = new PVector(  -C6,  C16,  C10 );
    vert[ 77] = new PVector(   C6,  C16, -C10 );
    vert[ 78] = new PVector(   C6, -C16,  C10 );
    vert[ 79] = new PVector(  -C6, -C16, -C10 );
    vert[ 80] = new PVector( -C16,  C10,   C6 );
    vert[ 81] = new PVector(  C16,  C10,  -C6 );
    vert[ 82] = new PVector(  C16, -C10,   C6 );
    vert[ 83] = new PVector( -C16, -C10,  -C6 );
    vert[ 84] = new PVector( -C11, -C11, -C11 );
    vert[ 85] = new PVector( -C11, -C11,  C11 );
    vert[ 86] = new PVector(  C11, -C11, -C11 );
    vert[ 87] = new PVector(  C11, -C11,  C11 );
    vert[ 88] = new PVector( -C11,  C11, -C11 );
    vert[ 89] = new PVector( -C11,  C11,  C11 );
    vert[ 90] = new PVector(  C11,  C11, -C11 );
    vert[ 91] = new PVector(  C11,  C11,  C11 );
    // set faces
    faces[ 0] = new int[] { 24,  0,  2, 14, 36 };
    faces[ 1] = new int[] { 24, 36, 72, 86, 76 };
    faces[ 2] = new int[] { 24, 76, 40, 16, 52 };
    faces[ 3] = new int[] { 24, 52, 64, 84, 60 };
    faces[ 4] = new int[] { 24, 60, 48, 12,  0 };
    faces[ 5] = new int[] { 25,  1,  3, 13, 37 };
    faces[ 6] = new int[] { 25, 37, 73, 85, 77 };
    faces[ 7] = new int[] { 25, 77, 41, 17, 53 };
    faces[ 8] = new int[] { 25, 53, 65, 87, 61 };
    faces[ 9] = new int[] { 25, 61, 49, 15,  1 };
    faces[10] = new int[] { 26,  2,  0, 12, 38 };
    faces[11] = new int[] { 26, 38, 74, 88, 78 };
    faces[12] = new int[] { 26, 78, 42, 18, 54 };
    faces[13] = new int[] { 26, 54, 66, 90, 62 };
    faces[14] = new int[] { 26, 62, 50, 14,  2 };
    faces[15] = new int[] { 27,  3,  1, 15, 39 };
    faces[16] = new int[] { 27, 39, 75, 91, 79 };
    faces[17] = new int[] { 27, 79, 43, 19, 55 };
    faces[18] = new int[] { 27, 55, 67, 89, 63 };
    faces[19] = new int[] { 27, 63, 51, 13,  3 };
    faces[20] = new int[] { 28,  4,  5, 17, 41 };
    faces[21] = new int[] { 28, 41, 77, 85, 81 };
    faces[22] = new int[] { 28, 81, 45, 20, 56 };
    faces[23] = new int[] { 28, 56, 68, 84, 64 };
    faces[24] = new int[] { 28, 64, 52, 16,  4 };
    faces[25] = new int[] { 29,  5,  4, 16, 40 };
    faces[26] = new int[] { 29, 40, 76, 86, 80 };
    faces[27] = new int[] { 29, 80, 44, 21, 57 };
    faces[28] = new int[] { 29, 57, 69, 87, 65 };
    faces[29] = new int[] { 29, 65, 53, 17,  5 };
    faces[30] = new int[] { 30,  7,  6, 18, 42 };
    faces[31] = new int[] { 30, 42, 78, 88, 82 };
    faces[32] = new int[] { 30, 82, 46, 22, 59 };
    faces[33] = new int[] { 30, 59, 71, 89, 67 };
    faces[34] = new int[] { 30, 67, 55, 19,  7 };
    faces[35] = new int[] { 31,  6,  7, 19, 43 };
    faces[36] = new int[] { 31, 43, 79, 91, 83 };
    faces[37] = new int[] { 31, 83, 47, 23, 58 };
    faces[38] = new int[] { 31, 58, 70, 90, 66 };
    faces[39] = new int[] { 31, 66, 54, 18,  6 };
    faces[40] = new int[] { 32,  8, 11, 22, 46 };
    faces[41] = new int[] { 32, 46, 82, 88, 74 };
    faces[42] = new int[] { 32, 74, 38, 12, 48 };
    faces[43] = new int[] { 32, 48, 60, 84, 68 };
    faces[44] = new int[] { 32, 68, 56, 20,  8 };
    faces[45] = new int[] { 33, 11,  8, 20, 45 };
    faces[46] = new int[] { 33, 45, 81, 85, 73 };
    faces[47] = new int[] { 33, 73, 37, 13, 51 };
    faces[48] = new int[] { 33, 51, 63, 89, 71 };
    faces[49] = new int[] { 33, 71, 59, 22, 11 };
    faces[50] = new int[] { 34, 10,  9, 21, 44 };
    faces[51] = new int[] { 34, 44, 80, 86, 72 };
    faces[52] = new int[] { 34, 72, 36, 14, 50 };
    faces[53] = new int[] { 34, 50, 62, 90, 70 };
    faces[54] = new int[] { 34, 70, 58, 23, 10 };
    faces[55] = new int[] { 35,  9, 10, 23, 47 };
    faces[56] = new int[] { 35, 47, 83, 91, 75 };
    faces[57] = new int[] { 35, 75, 39, 15, 49 };
    faces[58] = new int[] { 35, 49, 61, 87, 69 };
    faces[59] = new int[] { 35, 69, 57, 21,  9 };
  } //end GreatPentagrammicHexecontahedron()

  public String name() {
    return "Great Pentagrammic Hexecontahedron";
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
   
} //end class GreatPentagrammicHexecontahedron
/*
GreatRetrosnubIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatRetrosnubIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 92;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0500355497789497107813240716460f; //square-root of a root of the polynomial:  4096*(x^6) - 17408*(x^5) + 28672*(x^4) - 21696*(x^3) + 6672*(x^2) - 416*x + 1
  final float C1  = 0.0560019989928211678603893479474f; //square-root of a root of the polynomial: 4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  final float C2  = 0.136961219180949087853660273214f;  //square-root of a root of the polynomial: 4096*(x^6) - 9728*(x^4) - 3072*(x^3) + 4256*(x^2) - 132*x + 1
  final float C3  = 0.140648687587271738919162329994f;  //square-root of a root of the polynomial: 4096*(x^6) - 8192*(x^5) + 1792*(x^4) - 7488*(x^3) + 3456*(x^2) - 116*x + 1
  final float C4  = 0.153293050491351512698900732738f;  //square-root of a root of the polynomial: 4096*(x^6) - 5120*(x^5) + 9472*(x^4) - 5888*(x^3) + 1216*(x^2) - 68*x + 1
  final float C5  = 0.1715723579964499481311091836148f; //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) + 15872*(x^4) - 6016*(x^3) + 912*(x^2) - 56*x + 1
  final float C6  = 0.203328600270301223480224804384f;  //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C7  = 0.293941738078623251618063062732f;  //square-root of a root of the polynomial: 4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C8  = 0.374900958266751171611333987999f;  //square-root of a root of the polynomial: 4096*(x^6) - 18432*(x^5) + 29184*(x^4) - 20160*(x^3) + 5728*(x^2) - 488*x + 1
  final float C9  = 0.384994585115109604284725376882f;  //square-root of a root of the polynomial: 4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C10 = 0.419605723930610464562174287283f;  //square-root of a root of the polynomial: 4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C11 = 0.430902957259572339471723335946f;  //square-root of a root of the polynomial: 4096*(x^6) + 3072*(x^5) - 3584*(x^4) - 2048*(x^3) + 1312*(x^2) - 160*x + 1
  final float C12 = 0.469641273709560175343498358929f;  //square-root of a root of the polynomial: 4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C13 = 0.525643272702381343203887706876f;  //square-root of a root of the polynomial: 4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C14 = 0.556566943111559552415834560497f;  //square-root of a root of the polynomial: 4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatRetrosnubIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C5,  C12,   C7 );
    vert[  1] = new PVector(   C5,  C12,  -C7 );
    vert[  2] = new PVector(   C5, -C12,   C7 );
    vert[  3] = new PVector(  -C5, -C12,  -C7 );
    vert[  4] = new PVector(  C12,   C7,  -C5 );
    vert[  5] = new PVector( -C12,   C7,   C5 );
    vert[  6] = new PVector( -C12,  -C7,  -C5 );
    vert[  7] = new PVector(  C12,  -C7,   C5 );
    vert[  8] = new PVector(   C7,  -C5,  C12 );
    vert[  9] = new PVector(  -C7,  -C5, -C12 );
    vert[ 10] = new PVector(  -C7,   C5,  C12 );
    vert[ 11] = new PVector(   C7,   C5, -C12 );
    vert[ 12] = new PVector(  -C4,  -C1, -C14 );
    vert[ 13] = new PVector(   C4,  -C1,  C14 );
    vert[ 14] = new PVector(   C4,   C1, -C14 );
    vert[ 15] = new PVector(  -C4,   C1,  C14 );
    vert[ 16] = new PVector(   C1, -C14,   C4 );
    vert[ 17] = new PVector(  -C1, -C14,  -C4 );
    vert[ 18] = new PVector(  -C1,  C14,   C4 );
    vert[ 19] = new PVector(   C1,  C14,  -C4 );
    vert[ 20] = new PVector(  C14,   C4,  -C1 );
    vert[ 21] = new PVector( -C14,   C4,   C1 );
    vert[ 22] = new PVector( -C14,  -C4,  -C1 );
    vert[ 23] = new PVector(  C14,  -C4,   C1 );
    vert[ 24] = new PVector(  -C2, -C13,   C6 );
    vert[ 25] = new PVector(   C2, -C13,  -C6 );
    vert[ 26] = new PVector(   C2,  C13,   C6 );
    vert[ 27] = new PVector(  -C2,  C13,  -C6 );
    vert[ 28] = new PVector( -C13,   C6,  -C2 );
    vert[ 29] = new PVector(  C13,   C6,   C2 );
    vert[ 30] = new PVector(  C13,  -C6,  -C2 );
    vert[ 31] = new PVector( -C13,  -C6,   C2 );
    vert[ 32] = new PVector(   C6,  -C2, -C13 );
    vert[ 33] = new PVector(  -C6,  -C2,  C13 );
    vert[ 34] = new PVector(  -C6,   C2, -C13 );
    vert[ 35] = new PVector(   C6,   C2,  C13 );
    vert[ 36] = new PVector(  C11,   C0,  -C9 );
    vert[ 37] = new PVector( -C11,   C0,   C9 );
    vert[ 38] = new PVector( -C11,  -C0,  -C9 );
    vert[ 39] = new PVector(  C11,  -C0,   C9 );
    vert[ 40] = new PVector(   C0,  -C9,  C11 );
    vert[ 41] = new PVector(  -C0,  -C9, -C11 );
    vert[ 42] = new PVector(  -C0,   C9,  C11 );
    vert[ 43] = new PVector(   C0,   C9, -C11 );
    vert[ 44] = new PVector(  -C9,  C11,   C0 );
    vert[ 45] = new PVector(   C9,  C11,  -C0 );
    vert[ 46] = new PVector(   C9, -C11,   C0 );
    vert[ 47] = new PVector(  -C9, -C11,  -C0 );
    vert[ 48] = new PVector(  C10,   C8,   C3 );
    vert[ 49] = new PVector( -C10,   C8,  -C3 );
    vert[ 50] = new PVector( -C10,  -C8,   C3 );
    vert[ 51] = new PVector(  C10,  -C8,  -C3 );
    vert[ 52] = new PVector(  -C8,   C3, -C10 );
    vert[ 53] = new PVector(   C8,   C3,  C10 );
    vert[ 54] = new PVector(   C8,  -C3, -C10 );
    vert[ 55] = new PVector(  -C8,  -C3,  C10 );
    vert[ 56] = new PVector(  -C3, -C10,   C8 );
    vert[ 57] = new PVector(   C3, -C10,  -C8 );
    vert[ 58] = new PVector(   C3,  C10,   C8 );
    vert[ 59] = new PVector(  -C3,  C10,  -C8 );
    // set faces
    faces[  0] = new int[] {  0, 36, 28, 48, 12 };
    faces[  1] = new int[] {  1, 37, 29, 49, 13 };
    faces[  2] = new int[] {  2, 38, 30, 50, 14 };
    faces[  3] = new int[] {  3, 39, 31, 51, 15 };
    faces[  4] = new int[] {  4, 40, 32, 53, 17 };
    faces[  5] = new int[] {  5, 41, 33, 52, 16 };
    faces[  6] = new int[] {  6, 42, 34, 55, 19 };
    faces[  7] = new int[] {  7, 43, 35, 54, 18 };
    faces[  8] = new int[] {  8, 44, 24, 58, 22 };
    faces[  9] = new int[] {  9, 45, 25, 59, 23 };
    faces[ 10] = new int[] { 10, 46, 26, 56, 20 };
    faces[ 11] = new int[] { 11, 47, 27, 57, 21 };
    faces[ 12] = new int[] {  0,  2, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 13] = new int[] {  1,  3, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2,  0, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3,  1, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4,  5, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5,  4, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6,  7, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7,  6, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 11, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 10, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10,  9, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11,  8, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 48, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 49, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 50, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 51, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 52, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 53, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 54, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 55, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 56, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 57, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 58, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 59, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 44, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 45, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 46, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 47, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 36, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 37, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 38, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 39, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 40, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 41, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 42, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 43, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37,  1, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38,  2, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  3, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40,  4, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  5, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  6, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43,  7, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  8, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45,  9, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 10, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47, 11, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 28, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49, 29, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50, 30, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 31, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52, 33, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 32, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 35, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 34, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 26, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57, 27, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 24, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 25, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 24,  0, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 25,  1, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 26,  2, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 27,  3, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 28,  4, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 29,  5, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 30,  6, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 31,  7, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 32,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 33,  9, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 34, 10, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 35, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 36, 44, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 37, 45, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 38, 46, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 39, 47, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 48, 52, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 49, 53, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 50, 54, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 51, 55, 59, 59, 59 };  //added 2x 3rd row to fill gaps
  } //end GreatRetrosnubIcosidodecahedron()

  public String name() {
    return "Great Retrosnub Icosidodecahedron";
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
   
} //end class GreatRetrosnubIcosidodecahedron
/*
GreatSnubDodecicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatSnubDodecicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 104;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.142901106756847359195252445424f;  //sqrt(2 * (3 - sqrt(5) - sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C1 = 0.1817730157320175301311393090951f; //sqrt(2 * (sqrt(5) - 1 - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C2 = 0.231218847762556282665656293378f;  //sqrt(2 * (2 - sqrt(2 * (sqrt(5) - 1)))) / 4
  final float C3 = 0.412991863494573812796795602473f;  //sqrt(2 * (3 - sqrt(5) + sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C4 = 0.437016024448821070799301205056f;  //sqrt((3 - sqrt(5)) / 4)
  final float C5 = 0.525333765454529994269705053010f;  //sqrt(2 * (sqrt(5) - 1 + 2 * sqrt(sqrt(5) - 2))) / 4
  final float C6 = 0.555892970251421171992048047898f;  //sqrt((sqrt(5) - 1) / 4)
  final float C7 = 0.668234872211377353464957498434f;  //sqrt(2 * (2 + sqrt(2 * (sqrt(5) - 1)))) / 4
  
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatSnubDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  C1,  C0,  C7 );
    vert[  1] = new PVector(  C1,  C0, -C7 );
    vert[  2] = new PVector(  C1, -C0,  C7 );
    vert[  3] = new PVector(  C1, -C0, -C7 );
    vert[  4] = new PVector( -C1,  C0,  C7 );
    vert[  5] = new PVector( -C1,  C0, -C7 );
    vert[  6] = new PVector( -C1, -C0,  C7 );
    vert[  7] = new PVector( -C1, -C0, -C7 );
    vert[  8] = new PVector(  C7,  C1,  C0 );
    vert[  9] = new PVector(  C7,  C1, -C0 );
    vert[ 10] = new PVector(  C7, -C1,  C0 );
    vert[ 11] = new PVector(  C7, -C1, -C0 );
    vert[ 12] = new PVector( -C7,  C1,  C0 );
    vert[ 13] = new PVector( -C7,  C1, -C0 );
    vert[ 14] = new PVector( -C7, -C1,  C0 );
    vert[ 15] = new PVector( -C7, -C1, -C0 );
    vert[ 16] = new PVector(  C0,  C7,  C1 );
    vert[ 17] = new PVector(  C0,  C7, -C1 );
    vert[ 18] = new PVector(  C0, -C7,  C1 );
    vert[ 19] = new PVector(  C0, -C7, -C1 );
    vert[ 20] = new PVector( -C0,  C7,  C1 );
    vert[ 21] = new PVector( -C0,  C7, -C1 );
    vert[ 22] = new PVector( -C0, -C7,  C1 );
    vert[ 23] = new PVector( -C0, -C7, -C1 );
    vert[ 24] = new PVector( 0.0f,  C4,  C6 );
    vert[ 25] = new PVector( 0.0f,  C4, -C6 );
    vert[ 26] = new PVector( 0.0f, -C4,  C6 );
    vert[ 27] = new PVector( 0.0f, -C4, -C6 );
    vert[ 28] = new PVector(  C6, 0.0f,  C4 );
    vert[ 29] = new PVector(  C6, 0.0f, -C4 );
    vert[ 30] = new PVector( -C6, 0.0f,  C4 );
    vert[ 31] = new PVector( -C6, 0.0f, -C4 );
    vert[ 32] = new PVector(  C4,  C6, 0.0f );
    vert[ 33] = new PVector(  C4, -C6, 0.0f );
    vert[ 34] = new PVector( -C4,  C6, 0.0f );
    vert[ 35] = new PVector( -C4, -C6, 0.0f );
    vert[ 36] = new PVector(  C3,  C2,  C5 );
    vert[ 37] = new PVector(  C3,  C2, -C5 );
    vert[ 38] = new PVector(  C3, -C2,  C5 );
    vert[ 39] = new PVector(  C3, -C2, -C5 );
    vert[ 40] = new PVector( -C3,  C2,  C5 );
    vert[ 41] = new PVector( -C3,  C2, -C5 );
    vert[ 42] = new PVector( -C3, -C2,  C5 );
    vert[ 43] = new PVector( -C3, -C2, -C5 );
    vert[ 44] = new PVector(  C5,  C3,  C2 );
    vert[ 45] = new PVector(  C5,  C3, -C2 );
    vert[ 46] = new PVector(  C5, -C3,  C2 );
    vert[ 47] = new PVector(  C5, -C3, -C2 );
    vert[ 48] = new PVector( -C5,  C3,  C2 );
    vert[ 49] = new PVector( -C5,  C3, -C2 );
    vert[ 50] = new PVector( -C5, -C3,  C2 );
    vert[ 51] = new PVector( -C5, -C3, -C2 );
    vert[ 52] = new PVector(  C2,  C5,  C3 );
    vert[ 53] = new PVector(  C2,  C5, -C3 );
    vert[ 54] = new PVector(  C2, -C5,  C3 );
    vert[ 55] = new PVector(  C2, -C5, -C3 );
    vert[ 56] = new PVector( -C2,  C5,  C3 );
    vert[ 57] = new PVector( -C2,  C5, -C3 );
    vert[ 58] = new PVector( -C2, -C5,  C3 );
    vert[ 59] = new PVector( -C2, -C5, -C3 );
    // set faces
    faces[  0] = new int[] { 16, 10, 53, 36, 29 };
    faces[  1] = new int[] { 16, 41, 45, 34,  1 };
    faces[  2] = new int[] { 17, 11, 52, 37, 28 };
    faces[  3] = new int[] { 17, 40, 44, 34,  0 };
    faces[  4] = new int[] { 18,  8, 55, 38, 29 };
    faces[  5] = new int[] { 18, 43, 47, 35,  3 };
    faces[  6] = new int[] { 19,  9, 54, 39, 28 };
    faces[  7] = new int[] { 19, 42, 46, 35,  2 };
    faces[  8] = new int[] { 20, 14, 57, 40, 31 };
    faces[  9] = new int[] { 20, 37, 49, 32,  5 };
    faces[ 10] = new int[] { 21, 15, 56, 41, 30 };
    faces[ 11] = new int[] { 21, 36, 48, 32,  4 };
    faces[ 12] = new int[] { 22, 12, 59, 42, 31 };
    faces[ 13] = new int[] { 22, 39, 51, 33,  7 };
    faces[ 14] = new int[] { 23, 13, 58, 43, 30 };
    faces[ 15] = new int[] { 23, 38, 50, 33,  6 };
    faces[ 16] = new int[] { 24, 10,  6, 44, 54 };
    faces[ 17] = new int[] { 24, 14,  2, 48, 58 };
    faces[ 18] = new int[] { 25, 11,  7, 45, 55 };
    faces[ 19] = new int[] { 25, 15,  3, 49, 59 };
    faces[ 20] = new int[] { 26,  8,  4, 46, 52 };
    faces[ 21] = new int[] { 26, 12,  0, 50, 56 };
    faces[ 22] = new int[] { 27,  9,  5, 47, 53 };
    faces[ 23] = new int[] { 27, 13,  1, 51, 57 };
    faces[ 24] = new int[] {  0, 34, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] {  1, 13, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] {  2, 14, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] {  3, 35, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] {  4,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] {  5, 32, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] {  6, 33, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] {  7, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] {  8, 26, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] {  9, 19,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 10, 16,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 11, 25, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 12, 22,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 13, 27, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 14, 24, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 15, 21,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 16, 29, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 17,  0, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 18,  3,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 19, 28, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 20,  5, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 21, 30, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 22, 31, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 23,  6, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 24, 58, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 25, 55, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 26, 52, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 27, 57,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 28, 39, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 29, 36, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 30, 41, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 31, 42, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 32, 49,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 33, 50,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 34, 44,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 35, 47,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 36, 53, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 37, 20, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 38, 23, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 39, 54, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 40, 17, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 41, 56, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 42, 59, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 43, 18, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 44, 40, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 45,  7, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 46,  4, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 47, 43, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 48,  2, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 49, 37, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 50, 38, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 51,  1, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 52, 46, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 53, 10, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 54,  9, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 55, 45, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 56, 15, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 57, 51, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 58, 48, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 59, 12, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] {  0, 22, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] {  1, 44, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] {  2, 47, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] {  3, 21,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] {  4, 49, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] {  5, 19, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] {  6, 16, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] {  7, 50, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] { 28, 20, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] { 29, 23, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] { 30, 18, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] { 31, 17, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] { 52, 25, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] { 53, 43, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] { 54, 40, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] { 55, 26, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 56, 38, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 57, 24,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 58, 27, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 59, 37, 46, 46, 46 };  //added 2x 3rd row to fill gaps
  } //end GreatSnubDodecicosidodecahedron()

  public String name() {
    return "Great Snub Dodecicosidodecahedron";
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
   
} //end class GreatSnubDodecicosidodecahedron
/*
GreatSnubIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatSnubIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 92;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0812642829572718262058790219454f;  //square-root of a root of the polynomial: 4096*(x^6) + 3072*(x^5) - 3584*(x^4) - 2048*(x^3) + 1312*(x^2) - 160*x + 1
  final float C1  = 0.113690409611386992694315866713f;   //square-root of a root of the polynomial: 4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C2  = 0.125868396751318911853846136829f;   //square-root of a root of the polynomial: 4096*(x^6) - 8192*(x^5) + 1792*(x^4) - 7488*(x^3) + 3456*(x^2) - 116*x + 1
  final float C3  = 0.239558806362705904548162003542f;   //square-root of a root of the polynomial: 4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C4  = 0.257356768647573545542485428757f;   //square-root of a root of the polynomial: 4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1
  final float C5  = 0.284923627010362671688163165899f;   //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C6  = 0.335147715949345479170923435882f;   //square-root of a root of the polynomial: 4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C7  = 0.371047178258960538236801295470f;   //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) + 15872*(x^4) - 6016*(x^3) + 912*(x^2) - 56*x + 1
  final float C8  = 0.468878573956484550146522281604f;   //square-root of a root of the polynomial: 4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C9  = 0.519102662895467357629282551587f;   //square-root of a root of the polynomial: 4096*(x^6) - 5120*(x^5) + 9472*(x^4) - 5888*(x^3) + 1216*(x^2) - 68*x + 1
  final float C10 = 0.574706522312051383719085439424f;   //square-root of a root of the polynomial: 4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  final float C11 = 0.644971059646786269483128688416f;   //square-root of a root of the polynomial: 4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C12 = 0.655970805269323209924964461370f;   //square-root of a root of the polynomial:  4096*(x^6) - 18432*(x^5) + 29184*(x^4) - 20160*(x^3) + 5728*(x^2) - 488*x + 1
  final float C13 = 0.726235342604058095689007710362f;   //square-root of a root of the polynomial: 4096*(x^6) - 9728*(x^4) - 3072*(x^3) + 4256*(x^2) - 132*x + 1
  final float C14 = 0.804026289905830029317445717487f;   //square-root of a root of the polynomial:  4096*(x^6) - 17408*(x^5) + 28672*(x^4) - 21696*(x^3) + 6672*(x^2) - 416*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatSnubIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C7,   C6, -C11 );
    vert[  1] = new PVector(   C7,   C6,  C11 );
    vert[  2] = new PVector(   C7,  -C6, -C11 );
    vert[  3] = new PVector(  -C7,  -C6,  C11 );
    vert[  4] = new PVector(   C6, -C11,  -C7 );
    vert[  5] = new PVector(  -C6, -C11,   C7 );
    vert[  6] = new PVector(  -C6,  C11,  -C7 );
    vert[  7] = new PVector(   C6,  C11,   C7 );
    vert[  8] = new PVector( -C11,  -C7,   C6 );
    vert[  9] = new PVector(  C11,  -C7,  -C6 );
    vert[ 10] = new PVector(  C11,   C7,   C6 );
    vert[ 11] = new PVector( -C11,   C7,  -C6 );
    vert[ 12] = new PVector(   C9,  C10,  -C4 );
    vert[ 13] = new PVector(  -C9,  C10,   C4 );
    vert[ 14] = new PVector(  -C9, -C10,  -C4 );
    vert[ 15] = new PVector(   C9, -C10,   C4 );
    vert[ 16] = new PVector( -C10,  -C4,  -C9 );
    vert[ 17] = new PVector(  C10,  -C4,   C9 );
    vert[ 18] = new PVector(  C10,   C4,  -C9 );
    vert[ 19] = new PVector( -C10,   C4,   C9 );
    vert[ 20] = new PVector(   C4,  -C9,  C10 );
    vert[ 21] = new PVector(  -C4,  -C9, -C10 );
    vert[ 22] = new PVector(  -C4,   C9,  C10 );
    vert[ 23] = new PVector(   C4,   C9, -C10 );
    vert[ 24] = new PVector( -C13,   C3,   C5 );
    vert[ 25] = new PVector(  C13,   C3,  -C5 );
    vert[ 26] = new PVector(  C13,  -C3,   C5 );
    vert[ 27] = new PVector( -C13,  -C3,  -C5 );
    vert[ 28] = new PVector(   C3,   C5, -C13 );
    vert[ 29] = new PVector(  -C3,   C5,  C13 );
    vert[ 30] = new PVector(  -C3,  -C5, -C13 );
    vert[ 31] = new PVector(   C3,  -C5,  C13 );
    vert[ 32] = new PVector(   C5, -C13,   C3 );
    vert[ 33] = new PVector(  -C5, -C13,  -C3 );
    vert[ 34] = new PVector(  -C5,  C13,   C3 );
    vert[ 35] = new PVector(   C5,  C13,  -C3 );
    vert[ 36] = new PVector(   C0,  C14,   C1 );
    vert[ 37] = new PVector(  -C0,  C14,  -C1 );
    vert[ 38] = new PVector(  -C0, -C14,   C1 );
    vert[ 39] = new PVector(   C0, -C14,  -C1 );
    vert[ 40] = new PVector(  C14,   C1,   C0 );
    vert[ 41] = new PVector( -C14,   C1,  -C0 );
    vert[ 42] = new PVector( -C14,  -C1,   C0 );
    vert[ 43] = new PVector(  C14,  -C1,  -C0 );
    vert[ 44] = new PVector(   C1,   C0,  C14 );
    vert[ 45] = new PVector(  -C1,   C0, -C14 );
    vert[ 46] = new PVector(  -C1,  -C0,  C14 );
    vert[ 47] = new PVector(   C1,  -C0, -C14 );
    vert[ 48] = new PVector(  -C8,  C12,  -C2 );
    vert[ 49] = new PVector(   C8,  C12,   C2 );
    vert[ 50] = new PVector(   C8, -C12,  -C2 );
    vert[ 51] = new PVector(  -C8, -C12,   C2 );
    vert[ 52] = new PVector( -C12,  -C2,   C8 );
    vert[ 53] = new PVector(  C12,  -C2,  -C8 );
    vert[ 54] = new PVector(  C12,   C2,   C8 );
    vert[ 55] = new PVector( -C12,   C2,  -C8 );
    vert[ 56] = new PVector(   C2,   C8,  C12 );
    vert[ 57] = new PVector(  -C2,   C8, -C12 );
    vert[ 58] = new PVector(  -C2,  -C8,  C12 );
    vert[ 59] = new PVector(   C2,  -C8, -C12 );
    // set faces
    faces[  0] = new int[] {  0, 36, 28, 48, 12 };
    faces[  1] = new int[] {  1, 37, 29, 49, 13 };
    faces[  2] = new int[] {  2, 38, 30, 50, 14 };
    faces[  3] = new int[] {  3, 39, 31, 51, 15 };
    faces[  4] = new int[] {  4, 40, 32, 53, 17 };
    faces[  5] = new int[] {  5, 41, 33, 52, 16 };
    faces[  6] = new int[] {  6, 42, 34, 55, 19 };
    faces[  7] = new int[] {  7, 43, 35, 54, 18 };
    faces[  8] = new int[] {  8, 44, 24, 58, 22 };
    faces[  9] = new int[] {  9, 45, 25, 59, 23 };
    faces[ 10] = new int[] { 10, 46, 26, 56, 20 };
    faces[ 11] = new int[] { 11, 47, 27, 57, 21 };
    faces[ 12] = new int[] {  0,  2, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 13] = new int[] {  1,  3, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2,  0, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3,  1, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4,  5, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5,  4, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6,  7, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7,  6, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 11, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 10, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10,  9, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11,  8, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 48, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 49, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 50, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 51, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 52, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 53, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 54, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 55, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 56, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 57, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 58, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 59, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 44, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 45, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 46, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 47, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 36, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 37, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 38, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 39, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 40, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 41, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 42, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 43, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37,  1, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38,  2, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  3, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40,  4, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  5, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  6, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43,  7, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  8, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45,  9, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 10, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47, 11, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 28, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49, 29, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50, 30, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 31, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52, 33, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 32, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 35, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 34, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 26, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57, 27, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 24, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 25, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 24,  0, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 25,  1, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 26,  2, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 27,  3, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 28,  4, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 29,  5, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 30,  6, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 31,  7, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 32,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 33,  9, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 34, 10, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 35, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 36, 44, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 37, 45, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 38, 46, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 39, 47, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 48, 52, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 49, 53, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 50, 54, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 51, 55, 59, 59, 59 };  //added 2x 3rd row to fill gaps
  } //end GreatSnubIcosidodecahedron()

  public String name() {
    return "Great Snub Icosidodecahedron";
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
   
} //end class GreatSnubIcosidodecahedron
/*
GreatStellatedDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatStellatedDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;  // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f; // (3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f; // (sqrt(5) - 1) / 4
  PVector[] vert = new PVector[20]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private GreatStellatedDodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.5f,  0.0f,   C0);
    vert[ 1] = new PVector( 0.5f,  0.0f,  -C0);
    vert[ 2] = new PVector(-0.5f,  0.0f,   C0);
    vert[ 3] = new PVector(-0.5f,  0.0f,  -C0);
    vert[ 4] = new PVector( 0.0f,   C0,  0.5f);
    vert[ 5] = new PVector( 0.0f,   C0, -0.5f);
    vert[ 6] = new PVector( 0.0f,  -C0,  0.5f);
    vert[ 7] = new PVector( 0.0f,  -C0, -0.5f);
    vert[ 8] = new PVector(  C0,  0.5f,  0.0f);
    vert[ 9] = new PVector( -C0,  0.5f,  0.0f);
    vert[10] = new PVector(  C0, -0.5f,  0.0f);
    vert[11] = new PVector( -C0, -0.5f,  0.0f);
    vert[12] = new PVector( -C1,  -C1,  -C1);
    vert[13] = new PVector( -C1,  -C1,   C1);
    vert[14] = new PVector(  C1,  -C1,  -C1);
    vert[15] = new PVector(  C1,  -C1,   C1);
    vert[16] = new PVector( -C1,   C1,  -C1);
    vert[17] = new PVector( -C1,   C1,   C1);
    vert[18] = new PVector(  C1,   C1,  -C1);
    vert[19] = new PVector(  C1,   C1,   C1);
    // set faces
    faces[ 0] = new int[] {  0,  2, 14,  4, 12 };
    faces[ 1] = new int[] {  0, 12,  8, 10, 16 };
    faces[ 2] = new int[] {  0, 16,  6, 18,  2 };
    faces[ 3] = new int[] {  7,  6, 16, 10, 17 };
    faces[ 4] = new int[] {  7, 17,  1,  3, 19 };  
    faces[ 5] = new int[] {  7, 19, 11, 18,  6 };
    faces[ 6] = new int[] {  9, 11, 19,  3, 15 };
    faces[ 7] = new int[] {  9, 15,  5,  4, 14 };
    faces[ 8] = new int[] {  9, 14,  2, 18, 11 };
    faces[ 9] = new int[] { 13,  1, 17, 10,  8 };  
    faces[10] = new int[] { 13,  8, 12,  4,  5 };
    faces[11] = new int[] { 13,  5, 15,  3,  1 };
  } //end GreatStellatedDodecahedron()

  public String name() {
    return "Great Stellated Dodecahedron";
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
  
} //end class GreatStellatedDodecahedron
/*
GreatStellatedTruncatedDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatStellatedTruncatedDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.118033988749894848204586834366f; //(sqrt(5) - 2) / 2
  final float C1 = 0.190983005625052575897706582817f; //(3 - sqrt(5)) / 4
  final float C2 = 0.381966011250105151795413165634f; //(3 - sqrt(5)) / 2
  final float C3 = 0.427050983124842272306880251548f; //(3 * sqrt(5) - 5) / 4
  final float C4 = 0.618033988749894848204586834366f; //(sqrt(5) - 1) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatStellatedTruncatedDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.0f,  -C3 );
    vert[  1] = new PVector(  0.5f,  0.0f,   C3 );
    vert[  2] = new PVector( -0.5f,  0.0f,  -C3 );
    vert[  3] = new PVector( -0.5f,  0.0f,   C3 );
    vert[  4] = new PVector(  0.0f,  -C3,  0.5f );
    vert[  5] = new PVector(  0.0f,  -C3, -0.5f );
    vert[  6] = new PVector(  0.0f,   C3,  0.5f );
    vert[  7] = new PVector(  0.0f,   C3, -0.5f );
    vert[  8] = new PVector(  -C3,  0.5f,  0.0f );
    vert[  9] = new PVector(   C3,  0.5f,  0.0f );
    vert[ 10] = new PVector(  -C3, -0.5f,  0.0f );
    vert[ 11] = new PVector(   C3, -0.5f,  0.0f );
    vert[ 12] = new PVector(   C1,  0.5f,   C2 );
    vert[ 13] = new PVector(   C1,  0.5f,  -C2 );
    vert[ 14] = new PVector(  -C1,  0.5f,   C2 );
    vert[ 15] = new PVector(  -C1,  0.5f,  -C2 );
    vert[ 16] = new PVector(   C1, -0.5f,   C2 );
    vert[ 17] = new PVector(   C1, -0.5f,  -C2 );
    vert[ 18] = new PVector(  -C1, -0.5f,   C2 );
    vert[ 19] = new PVector(  -C1, -0.5f,  -C2 );
    vert[ 20] = new PVector(  0.5f,   C2,   C1 );
    vert[ 21] = new PVector(  0.5f,   C2,  -C1 );
    vert[ 22] = new PVector( -0.5f,   C2,   C1 );
    vert[ 23] = new PVector( -0.5f,   C2,  -C1 );
    vert[ 24] = new PVector(  0.5f,  -C2,   C1 );
    vert[ 25] = new PVector(  0.5f,  -C2,  -C1 );
    vert[ 26] = new PVector( -0.5f,  -C2,   C1 );
    vert[ 27] = new PVector( -0.5f,  -C2,  -C1 );
    vert[ 28] = new PVector(   C2,   C1,  0.5f );
    vert[ 29] = new PVector(   C2,   C1, -0.5f );
    vert[ 30] = new PVector(  -C2,   C1,  0.5f );
    vert[ 31] = new PVector(  -C2,   C1, -0.5f );
    vert[ 32] = new PVector(   C2,  -C1,  0.5f );
    vert[ 33] = new PVector(   C2,  -C1, -0.5f );
    vert[ 34] = new PVector(  -C2,  -C1,  0.5f );
    vert[ 35] = new PVector(  -C2,  -C1, -0.5f );
    vert[ 36] = new PVector(  -C4,   C1,  -C0 );
    vert[ 37] = new PVector(  -C4,   C1,   C0 );
    vert[ 38] = new PVector(   C4,   C1,  -C0 );
    vert[ 39] = new PVector(   C4,   C1,   C0 );
    vert[ 40] = new PVector(  -C4,  -C1,  -C0 );
    vert[ 41] = new PVector(  -C4,  -C1,   C0 );
    vert[ 42] = new PVector(   C4,  -C1,  -C0 );
    vert[ 43] = new PVector(   C4,  -C1,   C0 );
    vert[ 44] = new PVector(   C1,  -C0,  -C4 );
    vert[ 45] = new PVector(   C1,  -C0,   C4 );
    vert[ 46] = new PVector(  -C1,  -C0,  -C4 );
    vert[ 47] = new PVector(  -C1,  -C0,   C4 );
    vert[ 48] = new PVector(   C1,   C0,  -C4 );
    vert[ 49] = new PVector(   C1,   C0,   C4 );
    vert[ 50] = new PVector(  -C1,   C0,  -C4 );
    vert[ 51] = new PVector(  -C1,   C0,   C4 );
    vert[ 52] = new PVector(  -C0,  -C4,   C1 );
    vert[ 53] = new PVector(  -C0,  -C4,  -C1 );
    vert[ 54] = new PVector(   C0,  -C4,   C1 );
    vert[ 55] = new PVector(   C0,  -C4,  -C1 );
    vert[ 56] = new PVector(  -C0,   C4,   C1 );
    vert[ 57] = new PVector(  -C0,   C4,  -C1 );
    vert[ 58] = new PVector(   C0,   C4,   C1 );
    vert[ 59] = new PVector(   C0,   C4,  -C1 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 14, 38, 46, 22, 20, 44, 36, 12 };
    faces[ 1] = new int[] {  1,  3, 19, 43, 51, 27, 25, 49, 41, 17 };
    faces[ 2] = new int[] {  2,  0, 16, 40, 48, 24, 26, 50, 42, 18 };
    faces[ 3] = new int[] {  3,  1, 13, 37, 45, 21, 23, 47, 39, 15 };
    faces[ 4] = new int[] {  4,  5, 21, 45, 53, 29, 28, 52, 44, 20 };
    faces[ 5] = new int[] {  5,  4, 22, 46, 54, 30, 31, 55, 47, 23 };
    faces[ 6] = new int[] {  6,  7, 27, 51, 59, 35, 34, 58, 50, 26 };
    faces[ 7] = new int[] {  7,  6, 24, 48, 56, 32, 33, 57, 49, 25 };
    faces[ 8] = new int[] {  8, 10, 32, 56, 40, 16, 12, 36, 52, 28 };
    faces[ 9] = new int[] {  9, 11, 35, 59, 43, 19, 15, 39, 55, 31 };
    faces[10] = new int[] { 10,  8, 29, 53, 37, 13, 17, 41, 57, 33 };
    faces[11] = new int[] { 11,  9, 30, 54, 38, 14, 18, 42, 58, 34 };
    faces[12] = new int[] {  0, 12, 16, 16, 16, 16, 16, 16, 16, 16 };  //repeat 7x 3rd column to fill gap
    faces[13] = new int[] {  1, 17, 13, 13, 13, 13, 13, 13, 13, 13 };  //repeat 7x 3rd column to fill gap
    faces[14] = new int[] {  2, 18, 14, 14, 14, 14, 14, 14, 14, 14 };  //repeat 7x 3rd column to fill gap
    faces[15] = new int[] {  3, 15, 19, 19, 19, 19, 19, 19, 19, 19 };  //repeat 7x 3rd column to fill gap
    faces[16] = new int[] {  4, 20, 22, 22, 22, 22, 22, 22, 22, 22 };  //repeat 7x 3rd column to fill gap
    faces[17] = new int[] {  5, 23, 21, 21, 21, 21, 21, 21, 21, 21 };  //repeat 7x 3rd column to fill gap
    faces[18] = new int[] {  6, 26, 24, 24, 24, 24, 24, 24, 24, 24 };  //repeat 7x 3rd column to fill gap
    faces[19] = new int[] {  7, 25, 27, 27, 27, 27, 27, 27, 27, 27 };  //repeat 7x 3rd column to fill gap
    faces[20] = new int[] {  8, 28, 29, 29, 29, 29, 29, 29, 29, 29 };  //repeat 7x 3rd column to fill gap
    faces[21] = new int[] {  9, 31, 30, 30, 30, 30, 30, 30, 30, 30 };  //repeat 7x 3rd column to fill gap
    faces[22] = new int[] { 10, 33, 32, 32, 32, 32, 32, 32, 32, 32 };  //repeat 7x 3rd column to fill gap
    faces[23] = new int[] { 11, 34, 35, 35, 35, 35, 35, 35, 35, 35 };  //repeat 7x 3rd column to fill gap
    faces[24] = new int[] { 36, 44, 52, 52, 52, 52, 52, 52, 52, 52 };  //repeat 7x 3rd column to fill gap
    faces[25] = new int[] { 37, 53, 45, 45, 45, 45, 45, 45, 45, 45 };  //repeat 7x 3rd column to fill gap
    faces[26] = new int[] { 38, 54, 46, 46, 46, 46, 46, 46, 46, 46 };  //repeat 7x 3rd column to fill gap
    faces[27] = new int[] { 39, 47, 55, 55, 55, 55, 55, 55, 55, 55 };  //repeat 7x 3rd column to fill gap
    faces[28] = new int[] { 40, 56, 48, 48, 48, 48, 48, 48, 48, 48 };  //repeat 7x 3rd column to fill gap
    faces[29] = new int[] { 41, 49, 57, 57, 57, 57, 57, 57, 57, 57 };  //repeat 7x 3rd column to fill gap
    faces[30] = new int[] { 42, 50, 58, 58, 58, 58, 58, 58, 58, 58 };  //repeat 7x 3rd column to fill gap
    faces[31] = new int[] { 43, 59, 51, 51, 51, 51, 51, 51, 51, 51 };  //repeat 7x 3rd column to fill gap
  } //end GreatStellatedTruncatedDodecahedron()

  public String name() {
    return "Great Stellated Truncated Dodecahedron";
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
   
} //end class GreatStellatedTruncatedDodecahedron
/*
Icosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Icosahedron extends Polyhedron {

  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 3;  // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  PVector[] vert = new PVector[12]; //list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private Icosahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.5f,  0.0f,   C0);
    vert[ 1] = new PVector( 0.5f,  0.0f,  -C0);
    vert[ 2] = new PVector(-0.5f,  0.0f,   C0);
    vert[ 3] = new PVector(-0.5f,  0.0f,  -C0);
    vert[ 4] = new PVector(  C0,  0.5f,  0.0f);
    vert[ 5] = new PVector(  C0, -0.5f,  0.0f);
    vert[ 6] = new PVector( -C0,  0.5f,  0.0f);
    vert[ 7] = new PVector( -C0, -0.5f,  0.0f);
    vert[ 8] = new PVector( 0.0f,   C0,  0.5f);
    vert[ 9] = new PVector( 0.0f,   C0, -0.5f);
    vert[10] = new PVector( 0.0f,  -C0,  0.5f);
    vert[11] = new PVector( 0.0f,  -C0, -0.5f);
    // set faces
    faces[ 0] = new int[] { 0,  2, 10};
    faces[ 1] = new int[] { 0, 10,  5};
    faces[ 2] = new int[] { 0,  5,  4};
    faces[ 3] = new int[] { 0,  4,  8};
    faces[ 4] = new int[] { 0,  8,  2};
    faces[ 5] = new int[] { 3,  1, 11};
    faces[ 6] = new int[] { 3, 11,  7};
    faces[ 7] = new int[] { 3,  7,  6};
    faces[ 8] = new int[] { 3,  6,  9};
    faces[ 9] = new int[] { 3,  9,  1};
    faces[10] = new int[] { 2,  6,  7};
    faces[11] = new int[] { 2,  7, 10};
    faces[12] = new int[] {10,  7, 11};
    faces[13] = new int[] {10, 11,  5};
    faces[14] = new int[] { 5, 11,  1};
    faces[15] = new int[] { 5,  1,  4};
    faces[16] = new int[] { 4,  1,  9};
    faces[17] = new int[] { 4,  9,  8};
    faces[18] = new int[] { 8,  9,  6};
    faces[19] = new int[] { 8,  6,  2};
  } //end Icosahedron()

  public String name() {
    return "Icosahedron";
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
   
} //end class Icosahedron
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
Icosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Icosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Icosidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0f,  0.0f,   C2 );
    vert[ 1] = new PVector(  0.0f,  0.0f,  -C2 );
    vert[ 2] = new PVector(   C2,  0.0f,  0.0f );
    vert[ 3] = new PVector(  -C2,  0.0f,  0.0f );
    vert[ 4] = new PVector(  0.0f,   C2,  0.0f );
    vert[ 5] = new PVector(  0.0f,  -C2,  0.0f );
    vert[ 6] = new PVector(  0.5f,   C0,   C1 );
    vert[ 7] = new PVector(  0.5f,   C0,  -C1 );
    vert[ 8] = new PVector(  0.5f,  -C0,   C1 );
    vert[ 9] = new PVector(  0.5f,  -C0,  -C1 );
    vert[10] = new PVector( -0.5f,   C0,   C1 );
    vert[11] = new PVector( -0.5f,   C0,  -C1 );
    vert[12] = new PVector( -0.5f,  -C0,   C1 );
    vert[13] = new PVector( -0.5f,  -C0,  -C1 );
    vert[14] = new PVector(   C1,  0.5f,   C0 );
    vert[15] = new PVector(   C1,  0.5f,  -C0 );
    vert[16] = new PVector(   C1, -0.5f,   C0 );
    vert[17] = new PVector(   C1, -0.5f,  -C0 );
    vert[18] = new PVector(  -C1,  0.5f,   C0 );
    vert[19] = new PVector(  -C1,  0.5f,  -C0 );
    vert[20] = new PVector(  -C1, -0.5f,   C0 );
    vert[21] = new PVector(  -C1, -0.5f,  -C0 );
    vert[22] = new PVector(   C0,   C1,  0.5f );
    vert[23] = new PVector(   C0,   C1, -0.5f );
    vert[24] = new PVector(   C0,  -C1,  0.5f );
    vert[25] = new PVector(   C0,  -C1, -0.5f );
    vert[26] = new PVector(  -C0,   C1,  0.5f );
    vert[27] = new PVector(  -C0,   C1, -0.5f );
    vert[28] = new PVector(  -C0,  -C1,  0.5f );
    vert[29] = new PVector(  -C0,  -C1, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  8, 16, 14,  6 };
    faces[ 1] = new int[] {  0, 10, 18, 20, 12 };
    faces[ 2] = new int[] {  1,  7, 15, 17,  9 };
    faces[ 3] = new int[] {  1, 13, 21, 19, 11 };
    faces[ 4] = new int[] {  2, 15, 23, 22, 14 };
    faces[ 5] = new int[] {  2, 16, 24, 25, 17 };
    faces[ 6] = new int[] {  3, 18, 26, 27, 19 };
    faces[ 7] = new int[] {  3, 21, 29, 28, 20 };
    faces[ 8] = new int[] {  4, 23,  7, 11, 27 };
    faces[ 9] = new int[] {  4, 26, 10,  6, 22 };
    faces[10] = new int[] {  5, 24,  8, 12, 28 };
    faces[11] = new int[] {  5, 29, 13,  9, 25 };
    faces[12] = new int[] {  0,  6, 10, 10, 10 }; //added 2x 3rd number to fill gap
    faces[13] = new int[] {  0, 12,  8,  8,  8 }; //added 2x 3rd number to fill gap
    faces[14] = new int[] {  1,  9, 13, 13, 13 }; //added 2x 3rd number to fill gap
    faces[15] = new int[] {  1, 11,  7,  7,  7 }; //added 2x 3rd number to fill gap
    faces[16] = new int[] {  2, 14, 16, 16, 16 }; //added 2x 3rd number to fill gap
    faces[17] = new int[] {  2, 17, 15, 15, 15 }; //added 2x 3rd number to fill gap
    faces[18] = new int[] {  3, 19, 21, 21, 21 }; //added 2x 3rd number to fill gap
    faces[19] = new int[] {  3, 20, 18, 18, 18 }; //added 2x 3rd number to fill gap
    faces[20] = new int[] {  4, 22, 23, 23, 23 }; //added 2x 3rd number to fill gap
    faces[21] = new int[] {  4, 27, 26, 26, 26 }; //added 2x 3rd number to fill gap
    faces[22] = new int[] {  5, 25, 24, 24, 24 }; //added 2x 3rd number to fill gap
    faces[23] = new int[] {  5, 28, 29, 29, 29 }; //added 2x 3rd number to fill gap
    faces[24] = new int[] {  6, 14, 22, 22, 22 }; //added 2x 3rd number to fill gap
    faces[25] = new int[] {  7, 23, 15, 15, 15 }; //added 2x 3rd number to fill gap
    faces[26] = new int[] {  8, 24, 16, 16, 16 }; //added 2x 3rd number to fill gap
    faces[27] = new int[] {  9, 17, 25, 25, 25 }; //added 2x 3rd number to fill gap
    faces[28] = new int[] { 10, 26, 18, 18, 18 }; //added 2x 3rd number to fill gap
    faces[29] = new int[] { 11, 19, 27, 27, 27 }; //added 2x 3rd number to fill gap
    faces[30] = new int[] { 12, 20, 28, 28, 28 }; //added 2x 3rd number to fill gap
    faces[31] = new int[] { 13, 29, 21, 21, 21 }; //added 2x 3rd number to fill gap
  } //end Icosidodecahedron()

  public String name() {
    return "Icosidodecahedron";
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
   
} //end class Icosidodecahedron
/*
InvertedSnubDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class InvertedSnubDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 84;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0696395523817213604419851293951f;   //square-root of a root of the polynomial:  65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C1  = 0.09104043995654983602406069932748f;  //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 69632*(x^6) - 43008*(x^5) + 22528*(x^4) - 4544*(x^3) + 1888*(x^2) - 136*x + 1
  final float C2  = 0.158913928975781502336378249411f;    //square-root of a root of the polynomial:  65536*(x^8) - 65536*(x^7) - 16384*(x^6) + 26624*(x^5) + 3584*(x^4) - 4864*(x^3) + 928*(x^2) - 60*x + 1
  final float C3  = 0.249954368932331338360438948738f;    //square-root of a root of the polynomial:  4096*(x^8) - 5120*(x^7) + 3072*(x^6) - 1920*(x^5) + 1248*(x^4) - 600*(x^3) + 177*(x^2) - 25*x + 1
  final float C4  = 0.271593091690735355039435204098f;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 69632*(x^6) - 43008*(x^5) + 22528*(x^4) - 4544*(x^3) + 1888*(x^2) - 136*x + 1
  final float C5  = 0.326767690750322596730834708807f;    //square-root of a root of the polynomial:  64*(x^4) - 112*(x^3) + 64*(x^2) - 15*x + 1
  final float C6  = 0.362633531647285191063495903426f;    //square-root of a root of the polynomial:  256*(x^4) - 448*(x^3) + 240*(x^2) - 32*x + 1
  final float C7  = 0.369807301083555088991906534100f;    //square-root of a root of the polynomial:  65536*(x^8) - 81920*(x^7) - 36864*(x^6) + 5120*(x^5) + 10496*(x^4) + 320*(x^3) - 144*(x^2) - 20*x + 1
  final float C8  = 0.474074216950764231535287447394f;    //square-root of a root of the polynomial:  65536*(x^8) - 65536*(x^7) - 16384*(x^6) + 26624*(x^5) + 3584*(x^4) - 4864*(x^3) + 928*(x^2) - 60*x + 1
  final float C9  = 0.517113827283996723796359272686f;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 90112*(x^6) - 48128*(x^5) + 11008*(x^4) + 2496*(x^3) - 592*(x^2) - 76*x + 1
  final float C10 = 0.619761670015886427352345482838f;    //square-root of a root of the polynomial:  65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C11 = 0.676027756259778226132737522097f;    //square-root of a root of the polynomial:  65536*(x^8) - 81920*(x^7) - 36864*(x^6) + 5120*(x^5) + 10496*(x^4) + 320*(x^3) - 144*(x^2) - 20*x + 1
  final float C12 = 0.689401222397607787794330612233f;    //square-root of a root of the polynomial:  256*(x^4) - 512*(x^3) + 240*(x^2) - 28*x + 1
  final float C13 = 0.745667308641499586574722651492f;    //square-root of a root of the polynomial:  4096*(x^8) - 5120*(x^7) + 3072*(x^6) - 1920*(x^5) + 1248*(x^4) - 600*(x^3) + 177*(x^2) - 25*x + 1
  final float C14 = 0.843881518034319320527193981494f;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 90112*(x^6) - 48128*(x^5) + 11008*(x^4) + 2496*(x^3) - 592*(x^2) - 76*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private InvertedSnubDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  C11,   C6,   C7 );
    vert[  1] = new PVector(  C11,  -C6,  -C7 );
    vert[  2] = new PVector( -C11,  -C6,   C7 );
    vert[  3] = new PVector( -C11,   C6,  -C7 );
    vert[  4] = new PVector(   C7,  C11,   C6 );
    vert[  5] = new PVector(   C7, -C11,  -C6 );
    vert[  6] = new PVector(  -C7, -C11,   C6 );
    vert[  7] = new PVector(  -C7,  C11,  -C6 );
    vert[  8] = new PVector(   C6,   C7,  C11 );
    vert[  9] = new PVector(   C6,  -C7, -C11 );
    vert[ 10] = new PVector(  -C6,  -C7,  C11 );
    vert[ 11] = new PVector(  -C6,   C7, -C11 );
    vert[ 12] = new PVector(   C2,   C8,  C12 );
    vert[ 13] = new PVector(   C2,  -C8, -C12 );
    vert[ 14] = new PVector(  -C2,  -C8,  C12 );
    vert[ 15] = new PVector(  -C2,   C8, -C12 );
    vert[ 16] = new PVector(  C12,  -C2,  -C8 );
    vert[ 17] = new PVector(  C12,   C2,   C8 );
    vert[ 18] = new PVector( -C12,   C2,  -C8 );
    vert[ 19] = new PVector( -C12,  -C2,   C8 );
    vert[ 20] = new PVector(  -C8, -C12,   C2 );
    vert[ 21] = new PVector(  -C8,  C12,  -C2 );
    vert[ 22] = new PVector(   C8,  C12,   C2 );
    vert[ 23] = new PVector(   C8, -C12,  -C2 );
    vert[ 24] = new PVector(  -C9,  C10,   C4 );
    vert[ 25] = new PVector(  -C9, -C10,  -C4 );
    vert[ 26] = new PVector(   C9, -C10,   C4 );
    vert[ 27] = new PVector(   C9,  C10,  -C4 );
    vert[ 28] = new PVector(   C4,  -C9,  C10 );
    vert[ 29] = new PVector(   C4,   C9, -C10 );
    vert[ 30] = new PVector(  -C4,   C9,  C10 );
    vert[ 31] = new PVector(  -C4,  -C9, -C10 );
    vert[ 32] = new PVector(  C10,   C4,  -C9 );
    vert[ 33] = new PVector(  C10,  -C4,   C9 );
    vert[ 34] = new PVector( -C10,  -C4,  -C9 );
    vert[ 35] = new PVector( -C10,   C4,   C9 );
    vert[ 36] = new PVector(  C13,  -C3,   C5 );
    vert[ 37] = new PVector(  C13,   C3,  -C5 );
    vert[ 38] = new PVector( -C13,   C3,   C5 );
    vert[ 39] = new PVector( -C13,  -C3,  -C5 );
    vert[ 40] = new PVector(   C5,  C13,  -C3 );
    vert[ 41] = new PVector(   C5, -C13,   C3 );
    vert[ 42] = new PVector(  -C5, -C13,  -C3 );
    vert[ 43] = new PVector(  -C5,  C13,   C3 );
    vert[ 44] = new PVector(  -C3,   C5,  C13 );
    vert[ 45] = new PVector(  -C3,  -C5, -C13 );
    vert[ 46] = new PVector(   C3,  -C5,  C13 );
    vert[ 47] = new PVector(   C3,   C5, -C13 );
    vert[ 48] = new PVector(  -C1,  -C0,  C14 );
    vert[ 49] = new PVector(  -C1,   C0, -C14 );
    vert[ 50] = new PVector(   C1,   C0,  C14 );
    vert[ 51] = new PVector(   C1,  -C0, -C14 );
    vert[ 52] = new PVector(  C14,   C1,   C0 );
    vert[ 53] = new PVector(  C14,  -C1,  -C0 );
    vert[ 54] = new PVector( -C14,  -C1,   C0 );
    vert[ 55] = new PVector( -C14,   C1,  -C0 );
    vert[ 56] = new PVector(   C0, -C14,  -C1 );
    vert[ 57] = new PVector(   C0,  C14,   C1 );
    vert[ 58] = new PVector(  -C0,  C14,  -C1 );
    vert[ 59] = new PVector(  -C0, -C14,   C1 );
    // set faces
    faces[  0] = new int[] {  0, 28, 12, 36, 48 };
    faces[  1] = new int[] {  1, 29, 13, 37, 49 };
    faces[  2] = new int[] {  2, 30, 14, 38, 50 };
    faces[  3] = new int[] {  3, 31, 15, 39, 51 };
    faces[  4] = new int[] {  4, 32, 17, 40, 53 };
    faces[  5] = new int[] {  5, 33, 16, 41, 52 };
    faces[  6] = new int[] {  6, 34, 19, 42, 55 };
    faces[  7] = new int[] {  7, 35, 18, 43, 54 };
    faces[  8] = new int[] {  8, 24, 22, 44, 58 };
    faces[  9] = new int[] {  9, 25, 23, 45, 59 };
    faces[ 10] = new int[] { 10, 26, 20, 46, 56 };
    faces[ 11] = new int[] { 11, 27, 21, 47, 57 };
    faces[ 12] = new int[] {  0, 26, 42, 18, 58 };
    faces[ 13] = new int[] {  1, 27, 43, 19, 59 };
    faces[ 14] = new int[] {  2, 24, 40, 16, 56 };
    faces[ 15] = new int[] {  3, 25, 41, 17, 57 };
    faces[ 16] = new int[] {  4, 29, 45, 20, 48 };
    faces[ 17] = new int[] {  5, 28, 44, 21, 49 };
    faces[ 18] = new int[] {  6, 31, 47, 22, 50 };
    faces[ 19] = new int[] {  7, 30, 46, 23, 51 };
    faces[ 20] = new int[] {  8, 35, 39, 13, 53 };
    faces[ 21] = new int[] {  9, 34, 38, 12, 52 };
    faces[ 22] = new int[] { 10, 33, 37, 15, 55 };
    faces[ 23] = new int[] { 11, 32, 36, 14, 54 };
    faces[ 24] = new int[] {  0, 58, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] {  1, 59, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] {  2, 56, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] {  3, 57, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] {  4, 48, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] {  5, 49, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] {  6, 50, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] {  7, 51, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] {  8, 53, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] {  9, 52, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 10, 55, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 11, 54, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 12, 38, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 13, 39, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 14, 36, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 15, 37, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 16, 40, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 17, 41, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 18, 42, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 19, 43, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 20, 45, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 21, 44, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 22, 47, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 23, 46, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 24,  2, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 25,  3, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 26,  0, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 27,  1, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 28,  5, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 29,  4, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 30,  7, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 31,  6, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 32, 11, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 33, 10, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 34,  9, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 35,  8, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 36, 32,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 37, 33,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 38, 34,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 39, 35,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 40, 24,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 41, 25,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 42, 26, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 43, 27, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 44, 28,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 45, 29,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 46, 30,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 47, 31,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 48, 20, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 49, 21, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 50, 22, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 51, 23, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 52, 12, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 53, 13, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 54, 14, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 55, 15, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 56, 16, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 57, 17, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 58, 18, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 59, 19, 34, 34, 34 };  //added 2x 3rd row to fill gaps
  } //end InvertedSnubDodecadodecahedron()

  public String name() {
    return "Inverted Snub Dodecadodecahedron";
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
   
} //end class InvertedSnubDodecadodecahedron
/*
MedialDisdyakisTriacontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialDisdyakisTriacontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 120;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.5150283239582457068371556953047f;  //5 * (sqrt(5) - 1) / 12
  final float C1 = 0.833333333333333333333333333333f;   //5 / 6
  final float C2 = 0.854101966249684544613760503097f;   //(3 * sqrt(5) - 5) / 2
  final float C3 = 1.34836165729157904017048902864f;    //5 * (1 + sqrt(5)) / 12
  final float C4 = 1.38196601125010515179541316563f;    //(5 - sqrt(5)) / 2
  final float C5 = 1.66666666666666666666666666667f;    //5 / 3
  final float C6 = 3.61803398874989484820458683437f;    //(5 + sqrt(5)) / 2
  final float C7 = 5.85410196624968454461376050310f;    //(5 + 3 * sqrt(5)) / 2
  private PVector[] vert = new PVector[54]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialDisdyakisTriacontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C6, 0.0f,  C7 );
    vert[  1] = new PVector(  C6, 0.0f, -C7 );
    vert[  2] = new PVector( -C6, 0.0f,  C7 );
    vert[  3] = new PVector( -C6, 0.0f, -C7 );
    vert[  4] = new PVector(  C7,  C6, 0.0f );
    vert[  5] = new PVector(  C7, -C6, 0.0f );
    vert[  6] = new PVector( -C7,  C6, 0.0f );
    vert[  7] = new PVector( -C7, -C6, 0.0f );
    vert[  8] = new PVector( 0.0f,  C7,  C6 );
    vert[  9] = new PVector( 0.0f,  C7, -C6 );
    vert[ 10] = new PVector( 0.0f, -C7,  C6 );
    vert[ 11] = new PVector( 0.0f, -C7, -C6 );
    vert[ 12] = new PVector( 0.0f, 0.0f,  C5 );
    vert[ 13] = new PVector( 0.0f, 0.0f, -C5 );
    vert[ 14] = new PVector(  C5, 0.0f, 0.0f );
    vert[ 15] = new PVector( -C5, 0.0f, 0.0f );
    vert[ 16] = new PVector( 0.0f,  C5, 0.0f );
    vert[ 17] = new PVector( 0.0f, -C5, 0.0f );
    vert[ 18] = new PVector(  C2, 0.0f,  C4 );
    vert[ 19] = new PVector(  C2, 0.0f, -C4 );
    vert[ 20] = new PVector( -C2, 0.0f,  C4 );
    vert[ 21] = new PVector( -C2, 0.0f, -C4 );
    vert[ 22] = new PVector(  C4,  C2, 0.0f );
    vert[ 23] = new PVector(  C4, -C2, 0.0f );
    vert[ 24] = new PVector( -C4,  C2, 0.0f );
    vert[ 25] = new PVector( -C4, -C2, 0.0f );
    vert[ 26] = new PVector( 0.0f,  C4,  C2 );
    vert[ 27] = new PVector( 0.0f,  C4, -C2 );
    vert[ 28] = new PVector( 0.0f, -C4,  C2 );
    vert[ 29] = new PVector( 0.0f, -C4, -C2 );
    vert[ 30] = new PVector(  C0,  C1,  C3 );
    vert[ 31] = new PVector(  C0,  C1, -C3 );
    vert[ 32] = new PVector(  C0, -C1,  C3 );
    vert[ 33] = new PVector(  C0, -C1, -C3 );
    vert[ 34] = new PVector( -C0,  C1,  C3 );
    vert[ 35] = new PVector( -C0,  C1, -C3 );
    vert[ 36] = new PVector( -C0, -C1,  C3 );
    vert[ 37] = new PVector( -C0, -C1, -C3 );
    vert[ 38] = new PVector(  C3,  C0,  C1 );
    vert[ 39] = new PVector(  C3,  C0, -C1 );
    vert[ 40] = new PVector(  C3, -C0,  C1 );
    vert[ 41] = new PVector(  C3, -C0, -C1 );
    vert[ 42] = new PVector( -C3,  C0,  C1 );
    vert[ 43] = new PVector( -C3,  C0, -C1 );
    vert[ 44] = new PVector( -C3, -C0,  C1 );
    vert[ 45] = new PVector( -C3, -C0, -C1 );
    vert[ 46] = new PVector(  C1,  C3,  C0 );
    vert[ 47] = new PVector(  C1,  C3, -C0 );
    vert[ 48] = new PVector(  C1, -C3,  C0 );
    vert[ 49] = new PVector(  C1, -C3, -C0 );
    vert[ 50] = new PVector( -C1,  C3,  C0 );
    vert[ 51] = new PVector( -C1,  C3, -C0 );
    vert[ 52] = new PVector( -C1, -C3,  C0 );
    vert[ 53] = new PVector( -C1, -C3, -C0 );
    // set faces
    faces[  0] = new int[] {  0, 14, 22 };
    faces[  1] = new int[] {  0, 22, 46 };
    faces[  2] = new int[] {  0, 46, 26 };
    faces[  3] = new int[] {  0, 26, 34 };
    faces[  4] = new int[] {  0, 34, 20 };
    faces[  5] = new int[] {  0, 20, 36 };
    faces[  6] = new int[] {  0, 36, 28 };
    faces[  7] = new int[] {  0, 28, 48 };
    faces[  8] = new int[] {  0, 48, 23 };
    faces[  9] = new int[] {  0, 23, 14 };
    faces[ 10] = new int[] {  1, 14, 23 };
    faces[ 11] = new int[] {  1, 23, 49 };
    faces[ 12] = new int[] {  1, 49, 29 };
    faces[ 13] = new int[] {  1, 29, 37 };
    faces[ 14] = new int[] {  1, 37, 21 };
    faces[ 15] = new int[] {  1, 21, 35 };
    faces[ 16] = new int[] {  1, 35, 27 };
    faces[ 17] = new int[] {  1, 27, 47 };
    faces[ 18] = new int[] {  1, 47, 22 };
    faces[ 19] = new int[] {  1, 22, 14 };
    faces[ 20] = new int[] {  2, 15, 25 };
    faces[ 21] = new int[] {  2, 25, 52 };
    faces[ 22] = new int[] {  2, 52, 28 };
    faces[ 23] = new int[] {  2, 28, 32 };
    faces[ 24] = new int[] {  2, 32, 18 };
    faces[ 25] = new int[] {  2, 18, 30 };
    faces[ 26] = new int[] {  2, 30, 26 };
    faces[ 27] = new int[] {  2, 26, 50 };
    faces[ 28] = new int[] {  2, 50, 24 };
    faces[ 29] = new int[] {  2, 24, 15 };
    faces[ 30] = new int[] {  3, 15, 24 };
    faces[ 31] = new int[] {  3, 24, 51 };
    faces[ 32] = new int[] {  3, 51, 27 };
    faces[ 33] = new int[] {  3, 27, 31 };
    faces[ 34] = new int[] {  3, 31, 19 };
    faces[ 35] = new int[] {  3, 19, 33 };
    faces[ 36] = new int[] {  3, 33, 29 };
    faces[ 37] = new int[] {  3, 29, 53 };
    faces[ 38] = new int[] {  3, 53, 25 };
    faces[ 39] = new int[] {  3, 25, 15 };
    faces[ 40] = new int[] {  4, 16, 26 };
    faces[ 41] = new int[] {  4, 26, 30 };
    faces[ 42] = new int[] {  4, 30, 18 };
    faces[ 43] = new int[] {  4, 18, 40 };
    faces[ 44] = new int[] {  4, 40, 23 };
    faces[ 45] = new int[] {  4, 23, 41 };
    faces[ 46] = new int[] {  4, 41, 19 };
    faces[ 47] = new int[] {  4, 19, 31 };
    faces[ 48] = new int[] {  4, 31, 27 };
    faces[ 49] = new int[] {  4, 27, 16 };
    faces[ 50] = new int[] {  5, 17, 29 };
    faces[ 51] = new int[] {  5, 29, 33 };
    faces[ 52] = new int[] {  5, 33, 19 };
    faces[ 53] = new int[] {  5, 19, 39 };
    faces[ 54] = new int[] {  5, 39, 22 };
    faces[ 55] = new int[] {  5, 22, 38 };
    faces[ 56] = new int[] {  5, 38, 18 };
    faces[ 57] = new int[] {  5, 18, 32 };
    faces[ 58] = new int[] {  5, 32, 28 };
    faces[ 59] = new int[] {  5, 28, 17 };
    faces[ 60] = new int[] {  6, 16, 27 };
    faces[ 61] = new int[] {  6, 27, 35 };
    faces[ 62] = new int[] {  6, 35, 21 };
    faces[ 63] = new int[] {  6, 21, 45 };
    faces[ 64] = new int[] {  6, 45, 25 };
    faces[ 65] = new int[] {  6, 25, 44 };
    faces[ 66] = new int[] {  6, 44, 20 };
    faces[ 67] = new int[] {  6, 20, 34 };
    faces[ 68] = new int[] {  6, 34, 26 };
    faces[ 69] = new int[] {  6, 26, 16 };
    faces[ 70] = new int[] {  7, 17, 28 };
    faces[ 71] = new int[] {  7, 28, 36 };
    faces[ 72] = new int[] {  7, 36, 20 };
    faces[ 73] = new int[] {  7, 20, 42 };
    faces[ 74] = new int[] {  7, 42, 24 };
    faces[ 75] = new int[] {  7, 24, 43 };
    faces[ 76] = new int[] {  7, 43, 21 };
    faces[ 77] = new int[] {  7, 21, 37 };
    faces[ 78] = new int[] {  7, 37, 29 };
    faces[ 79] = new int[] {  7, 29, 17 };
    faces[ 80] = new int[] {  8, 12, 18 };
    faces[ 81] = new int[] {  8, 18, 38 };
    faces[ 82] = new int[] {  8, 38, 22 };
    faces[ 83] = new int[] {  8, 22, 47 };
    faces[ 84] = new int[] {  8, 47, 27 };
    faces[ 85] = new int[] {  8, 27, 51 };
    faces[ 86] = new int[] {  8, 51, 24 };
    faces[ 87] = new int[] {  8, 24, 42 };
    faces[ 88] = new int[] {  8, 42, 20 };
    faces[ 89] = new int[] {  8, 20, 12 };
    faces[ 90] = new int[] {  9, 13, 21 };
    faces[ 91] = new int[] {  9, 21, 43 };
    faces[ 92] = new int[] {  9, 43, 24 };
    faces[ 93] = new int[] {  9, 24, 50 };
    faces[ 94] = new int[] {  9, 50, 26 };
    faces[ 95] = new int[] {  9, 26, 46 };
    faces[ 96] = new int[] {  9, 46, 22 };
    faces[ 97] = new int[] {  9, 22, 39 };
    faces[ 98] = new int[] {  9, 39, 19 };
    faces[ 99] = new int[] {  9, 19, 13 };
    faces[100] = new int[] { 10, 12, 20 };
    faces[101] = new int[] { 10, 20, 44 };
    faces[102] = new int[] { 10, 44, 25 };
    faces[103] = new int[] { 10, 25, 53 };
    faces[104] = new int[] { 10, 53, 29 };
    faces[105] = new int[] { 10, 29, 49 };
    faces[106] = new int[] { 10, 49, 23 };
    faces[107] = new int[] { 10, 23, 40 };
    faces[108] = new int[] { 10, 40, 18 };
    faces[109] = new int[] { 10, 18, 12 };
    faces[110] = new int[] { 11, 13, 19 };
    faces[111] = new int[] { 11, 19, 41 };
    faces[112] = new int[] { 11, 41, 23 };
    faces[113] = new int[] { 11, 23, 48 };
    faces[114] = new int[] { 11, 48, 28 };
    faces[115] = new int[] { 11, 28, 52 };
    faces[116] = new int[] { 11, 52, 25 };
    faces[117] = new int[] { 11, 25, 45 };
    faces[118] = new int[] { 11, 45, 21 };
    faces[119] = new int[] { 11, 21, 13 };
  } //end MedialDisdyakisTriacontahedron()

  public String name() {
    return "Medial Disdyakis Triacontahedron";
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
   
} //end class MedialDisdyakisTriacontahedron
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
MedialInvertedPentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialInvertedPentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0194022103980084253546867792920f;    //square-root of a root of the polynomial: 1048576*(x^8) - 2228224*(x^7) + 1380352*(x^6) + 189440*(x^5) - 355584*(x^4) + 26880*(x^3) + 20112*(x^2) - 2664*x + 1
  final float C1  = 0.0696395523817213604419851293951f;    //square-root of a root of the polynomial: 65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C2  = 0.101032988262575617797477277823f;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) + 1576960*(x^6) - 47104*(x^5) + 547584*(x^4) - 106944*(x^3) + 6720*(x^2) - 156*x + 1
  final float C3  = 0.132081373112962278057743733979f;     //square-root of a root of the polynomial: 1024*(x^4) + 832*(x^3) + 368*(x^2) - 64*x + 1
  final float C4  = 0.1440725985958081100585491031151f;    //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) - 847872*(x^6) - 262144*(x^5) + 388608*(x^4) - 66688*(x^3) + 6992*(x^2) - 168*x + 1
  final float C5  = 0.282000788731638777713749470244f;     //square-root of a root of the polynomial: 1048576*(x^8) - 1638400*(x^7) + 643072*(x^6) - 627712*(x^5) + 1304064*(x^4) - 982272*(x^3) + 310464*(x^2) - 40248*x + 1681
  final float C6  = 0.301402999129647203068436249536f;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) + 1576960*(x^6) - 47104*(x^5) + 547584*(x^4) - 106944*(x^3) + 6720*(x^2) - 156*x + 1
  final float C7  = 0.372942812188055051898209029977f;     //square-root of a root of the polynomial: 1048576*(x^8) - 104988672*(x^7) + 215617536*(x^6) - 97037312*(x^5) + 12262144*(x^4) - 362752*(x^3) - 1584*(x^2) + 88*x + 1
  final float C8  = 0.414082161844601055771493204223f;     //square-root of a root of the polynomial: 1048576*(x^8) - 1638400*(x^7) + 643072*(x^6) - 627712*(x^5) + 1304064*(x^4) - 982272*(x^3) + 310464*(x^2) - 40248*x + 1681
  final float C9  = 0.445475597725455313126985352651f;     //square-root of a root of the polynomial: 1048576*(x^8) - 3014656*(x^7) + 3444736*(x^6) - 2287616*(x^5) + 1100544*(x^4) - 455104*(x^3) + 131008*(x^2) - 18860*x + 961
  final float C10 = 0.515115150107176673568970482046f;     //square-root of a root of the polynomial: 1048576*(x^8) - 2228224*(x^7) + 1380352*(x^6) + 189440*(x^5) - 355584*(x^4) + 26880*(x^3) + 20112*(x^2) - 2664*x + 1
  final float C11 = 0.557319849284645509736586878254f;     //square-root of a root of the polynomial: 16*(x^4) + (x^3) - 9*(x^2) - x + 1
  final float C12 = 0.600359459617878001997658703546f;     //square-root of a root of the polynomial: 1048576*(x^8) - 3014656*(x^7) + 3444736*(x^6) - 2287616*(x^5) + 1100544*(x^4) - 455104*(x^3) + 131008*(x^2) - 18860*x + 961
  final float C13 = 0.603434145980241615121159406736f;     //square-root of a root of the polynomial: 1048576*(x^8) - 41484288*(x^7) + 84627456*(x^6) - 58661888*(x^5) + 16132864*(x^4) - 1589248*(x^3) + 46096*(x^2) + 392*x + 1
  final float C14 = 0.619761670015886427352345482838f;     //square-root of a root of the polynomial: 65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C15 = 0.689401222397607787794330612233f;     //square-root of a root of the polynomial: 256*(x^4) - 512*(x^3) + 240*(x^2) - 28*x + 1
  final float C16 = 0.701392447880453619795135981369f;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) - 847872*(x^6) - 262144*(x^5) + 388608*(x^4) - 66688*(x^3) + 6992*(x^2) - 168*x + 1
  final float C17 = 6.11938410981012529494715820772f;      //square-root of a root of the polynomial: 1048576*(x^8) - 41484288*(x^7) + 84627456*(x^6) - 58661888*(x^5) + 16132864*(x^4) - 1589248*(x^3) + 46096*(x^2) + 392*x + 1
  final float C18 = 9.90137147988880157189465128431f;      //square-root of a root of the polynomial: 1048576*(x^8) - 104988672*(x^7) + 215617536*(x^6) - 97037312*(x^5) + 12262144*(x^4) - 362752*(x^3) - 1584*(x^2) + 88*x + 1
  private PVector[] vert = new PVector[84]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialInvertedPentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,  C13,  -C7 );
    vert[  1] = new PVector(  0.0f,  C13,   C7 );
    vert[  2] = new PVector(  0.0f, -C13,  -C7 );
    vert[  3] = new PVector(  0.0f, -C13,   C7 );
    vert[  4] = new PVector(  C13,  -C7,  0.0f );
    vert[  5] = new PVector( -C13,  -C7,  0.0f );
    vert[  6] = new PVector(  C13,   C7,  0.0f );
    vert[  7] = new PVector( -C13,   C7,  0.0f );
    vert[  8] = new PVector(  -C7,  0.0f,  C13 );
    vert[  9] = new PVector(  -C7,  0.0f, -C13 );
    vert[ 10] = new PVector(   C7,  0.0f,  C13 );
    vert[ 11] = new PVector(   C7,  0.0f, -C13 );
    vert[ 12] = new PVector(   C6,   C2,  C15 );
    vert[ 13] = new PVector(  -C6,   C2, -C15 );
    vert[ 14] = new PVector(  -C6,  -C2,  C15 );
    vert[ 15] = new PVector(   C6,  -C2, -C15 );
    vert[ 16] = new PVector(  -C2,  C15,  -C6 );
    vert[ 17] = new PVector(   C2,  C15,   C6 );
    vert[ 18] = new PVector(   C2, -C15,  -C6 );
    vert[ 19] = new PVector(  -C2, -C15,   C6 );
    vert[ 20] = new PVector( -C15,  -C6,   C2 );
    vert[ 21] = new PVector(  C15,  -C6,  -C2 );
    vert[ 22] = new PVector(  C15,   C6,   C2 );
    vert[ 23] = new PVector( -C15,   C6,  -C2 );
    vert[ 24] = new PVector(   C3, -C12,  -C9 );
    vert[ 25] = new PVector(  -C3, -C12,   C9 );
    vert[ 26] = new PVector(  -C3,  C12,  -C9 );
    vert[ 27] = new PVector(   C3,  C12,   C9 );
    vert[ 28] = new PVector( -C12,  -C9,   C3 );
    vert[ 29] = new PVector(  C12,  -C9,  -C3 );
    vert[ 30] = new PVector(  C12,   C9,   C3 );
    vert[ 31] = new PVector( -C12,   C9,  -C3 );
    vert[ 32] = new PVector(  -C9,   C3, -C12 );
    vert[ 33] = new PVector(   C9,   C3,  C12 );
    vert[ 34] = new PVector(   C9,  -C3, -C12 );
    vert[ 35] = new PVector(  -C9,  -C3,  C12 );
    vert[ 36] = new PVector(  0.0f,  C18, -C17 );
    vert[ 37] = new PVector(  0.0f,  C18,  C17 );
    vert[ 38] = new PVector(  0.0f, -C18, -C17 );
    vert[ 39] = new PVector(  0.0f, -C18,  C17 );
    vert[ 40] = new PVector(  C18, -C17,  0.0f );
    vert[ 41] = new PVector( -C18, -C17,  0.0f );
    vert[ 42] = new PVector(  C18,  C17,  0.0f );
    vert[ 43] = new PVector( -C18,  C17,  0.0f );
    vert[ 44] = new PVector( -C17,  0.0f,  C18 );
    vert[ 45] = new PVector( -C17,  0.0f, -C18 );
    vert[ 46] = new PVector(  C17,  0.0f,  C18 );
    vert[ 47] = new PVector(  C17,  0.0f, -C18 );
    vert[ 48] = new PVector(  -C1, -C16,  -C5 );
    vert[ 49] = new PVector(   C1, -C16,   C5 );
    vert[ 50] = new PVector(   C1,  C16,  -C5 );
    vert[ 51] = new PVector(  -C1,  C16,   C5 );
    vert[ 52] = new PVector(  C16,  -C5,   C1 );
    vert[ 53] = new PVector( -C16,  -C5,  -C1 );
    vert[ 54] = new PVector( -C16,   C5,   C1 );
    vert[ 55] = new PVector(  C16,   C5,  -C1 );
    vert[ 56] = new PVector(   C5,   C1, -C16 );
    vert[ 57] = new PVector(  -C5,   C1,  C16 );
    vert[ 58] = new PVector(  -C5,  -C1, -C16 );
    vert[ 59] = new PVector(   C5,  -C1,  C16 );
    vert[ 60] = new PVector( -C14,  -C8,  -C4 );
    vert[ 61] = new PVector(  C14,  -C8,   C4 );
    vert[ 62] = new PVector(  C14,   C8,  -C4 );
    vert[ 63] = new PVector( -C14,   C8,   C4 );
    vert[ 64] = new PVector(   C8,  -C4,  C14 );
    vert[ 65] = new PVector(  -C8,  -C4, -C14 );
    vert[ 66] = new PVector(  -C8,   C4,  C14 );
    vert[ 67] = new PVector(   C8,   C4, -C14 );
    vert[ 68] = new PVector(   C4,  C14,  -C8 );
    vert[ 69] = new PVector(  -C4,  C14,   C8 );
    vert[ 70] = new PVector(  -C4, -C14,  -C8 );
    vert[ 71] = new PVector(   C4, -C14,   C8 );
    vert[ 72] = new PVector( -C10,   C0,  C11 );
    vert[ 73] = new PVector(  C10,   C0, -C11 );
    vert[ 74] = new PVector(  C10,  -C0,  C11 );
    vert[ 75] = new PVector( -C10,  -C0, -C11 );
    vert[ 76] = new PVector(   C0,  C11, -C10 );
    vert[ 77] = new PVector(  -C0,  C11,  C10 );
    vert[ 78] = new PVector(  -C0, -C11, -C10 );
    vert[ 79] = new PVector(   C0, -C11,  C10 );
    vert[ 80] = new PVector(  C11, -C10,   C0 );
    vert[ 81] = new PVector( -C11, -C10,  -C0 );
    vert[ 82] = new PVector( -C11,  C10,   C0 );
    vert[ 83] = new PVector(  C11,  C10,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0, 16, 17, 40, 76 };
    faces[ 1] = new int[] {  0, 76, 32, 44, 50 };
    faces[ 2] = new int[] {  0, 50, 62, 38, 26 };
    faces[ 3] = new int[] {  0, 26, 82, 46, 68 };
    faces[ 4] = new int[] {  0, 68, 56, 41, 16 };
    faces[ 5] = new int[] {  1, 17, 16, 41, 77 };
    faces[ 6] = new int[] {  1, 77, 33, 47, 51 };
    faces[ 7] = new int[] {  1, 51, 63, 39, 27 };
    faces[ 8] = new int[] {  1, 27, 83, 45, 69 };
    faces[ 9] = new int[] {  1, 69, 57, 40, 17 };
    faces[10] = new int[] {  2, 18, 19, 43, 78 };
    faces[11] = new int[] {  2, 78, 34, 46, 48 };
    faces[12] = new int[] {  2, 48, 60, 36, 24 };
    faces[13] = new int[] {  2, 24, 80, 44, 70 };
    faces[14] = new int[] {  2, 70, 58, 42, 18 };
    faces[15] = new int[] {  3, 19, 18, 42, 79 };
    faces[16] = new int[] {  3, 79, 35, 45, 49 };
    faces[17] = new int[] {  3, 49, 61, 37, 25 };
    faces[18] = new int[] {  3, 25, 81, 47, 71 };
    faces[19] = new int[] {  3, 71, 59, 43, 19 };
    faces[20] = new int[] {  4, 21, 22, 44, 80 };
    faces[21] = new int[] {  4, 80, 24, 36, 52 };
    faces[22] = new int[] {  4, 52, 64, 41, 29 };
    faces[23] = new int[] {  4, 29, 73, 37, 61 };
    faces[24] = new int[] {  4, 61, 49, 45, 21 };
    faces[25] = new int[] {  5, 20, 23, 47, 81 };
    faces[26] = new int[] {  5, 81, 25, 37, 53 };
    faces[27] = new int[] {  5, 53, 65, 40, 28 };
    faces[28] = new int[] {  5, 28, 72, 36, 60 };
    faces[29] = new int[] {  5, 60, 48, 46, 20 };
    faces[30] = new int[] {  6, 22, 21, 45, 83 };
    faces[31] = new int[] {  6, 83, 27, 39, 55 };
    faces[32] = new int[] {  6, 55, 67, 43, 30 };
    faces[33] = new int[] {  6, 30, 74, 38, 62 };
    faces[34] = new int[] {  6, 62, 50, 44, 22 };
    faces[35] = new int[] {  7, 23, 20, 46, 82 };
    faces[36] = new int[] {  7, 82, 26, 38, 54 };
    faces[37] = new int[] {  7, 54, 66, 42, 31 };
    faces[38] = new int[] {  7, 31, 75, 39, 63 };
    faces[39] = new int[] {  7, 63, 51, 47, 23 };
    faces[40] = new int[] {  8, 14, 12, 36, 72 };
    faces[41] = new int[] {  8, 72, 28, 40, 57 };
    faces[42] = new int[] {  8, 57, 69, 45, 35 };
    faces[43] = new int[] {  8, 35, 79, 42, 66 };
    faces[44] = new int[] {  8, 66, 54, 38, 14 };
    faces[45] = new int[] {  9, 13, 15, 39, 75 };
    faces[46] = new int[] {  9, 75, 31, 42, 58 };
    faces[47] = new int[] {  9, 58, 70, 44, 32 };
    faces[48] = new int[] {  9, 32, 76, 40, 65 };
    faces[49] = new int[] {  9, 65, 53, 37, 13 };
    faces[50] = new int[] { 10, 12, 14, 38, 74 };
    faces[51] = new int[] { 10, 74, 30, 43, 59 };
    faces[52] = new int[] { 10, 59, 71, 47, 33 };
    faces[53] = new int[] { 10, 33, 77, 41, 64 };
    faces[54] = new int[] { 10, 64, 52, 36, 12 };
    faces[55] = new int[] { 11, 15, 13, 37, 73 };
    faces[56] = new int[] { 11, 73, 29, 41, 56 };
    faces[57] = new int[] { 11, 56, 68, 46, 34 };
    faces[58] = new int[] { 11, 34, 78, 43, 67 };
    faces[59] = new int[] { 11, 67, 55, 39, 15 };
  } //end MedialInvertedPentagonalHexecontahedron()

  public String name() {
    return "Medial Inverted Pentagonal Hexecontahedron";
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
   
} //end class MedialInvertedPentagonalHexecontahedron
/*
MedialPentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialPentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0956375228054126600288251856007f;    //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) - 847872*(x^6) - 262144*(x^5) + 388608*(x^4) - 66688*(x^3) + 6992*(x^2) - 168*x + 1
  final float C1  = 0.185557856078737208916498067410f;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) + 1576960*(x^6) - 47104*(x^5) + 547584*(x^4) - 106944*(x^3) + 6720*(x^2) - 156*x + 1
  final float C2  = 0.232983484058011057773884196064f;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) + 1576960*(x^6) - 47104*(x^5) + 547584*(x^4) - 106944*(x^3) + 6720*(x^2) - 156*x + 1
  final float C3  = 0.3286210068634237178027093816646f;    //square-root of a root of the polynomial:  1048576*(x^8) - 3014656*(x^7) + 3444736*(x^6) - 2287616*(x^5) + 1100544*(x^4) - 455104*(x^3) + 131008*(x^2) - 18860*x + 961
  final float C4  = 0.340302618577738088855453915730f;     //square-root of a root of the polynomial: 1024*(x^4) + 832*(x^3) + 368*(x^2) - 64*x + 1
  final float C5  = 0.395876440820370748493308922286f;     //square-root of a root of the polynomial: 1048576*(x^8) - 2228224*(x^7) + 1380352*(x^6) + 189440*(x^5) - 355584*(x^4) + 26880*(x^3) + 20112*(x^2) - 2664*x + 1
  final float C6  = 0.4549836805139589684034395850047f;    //square-root of a root of the polynomial: 65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C7  = 0.622299338042328798044313589880f;     //square-root of a root of the polynomial: 1048576*(x^8) - 104988672*(x^7) + 215617536*(x^6) - 97037312*(x^5) + 12262144*(x^4) - 362752*(x^3) - 1584*(x^2) + 88*x + 1
  final float C8  = 0.62885992487838180626719311834997f;   //square-root of a root of the polynomial: 1048576*(x^8) - 1638400*(x^7) + 643072*(x^6) - 627712*(x^5) + 1304064*(x^4) - 982272*(x^3) + 310464*(x^2) - 40248*x + 1681
  final float C9  = 0.717277814600969258425288142552f;     //square-root of a root of the polynomial: 65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C10 = 0.76128814508384772869302314304499f;   //square-root of a root of the polynomial: 1048576*(x^8) - 41484288*(x^7) + 84627456*(x^6) - 58661888*(x^5) + 16132864*(x^4) - 1589248*(x^3) + 46096*(x^2) + 392*x + 1
  final float C11 = 0.783604687377382686206148966669f;     //square-root of a root of the polynomial: 1048576*(x^8) - 2228224*(x^7) + 1380352*(x^6) + 189440*(x^5) - 355584*(x^4) + 26880*(x^3) + 20112*(x^2) - 2664*x + 1
  final float C12 = 0.831958876537190137973273811827f;     //square-root of a root of the polynomial: 16*(x^4) + (x^3) - 9*(x^2) - x + 1
  final float C13 = 0.927596399342602798002098997427f;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) - 847872*(x^6) - 262144*(x^5) + 388608*(x^4) - 66688*(x^3) + 6992*(x^2) - 168*x + 1
  final float C14 = 0.969162543456119895122647034080f;     //square-root of a root of the polynomial: 1048576*(x^8) - 1638400*(x^7) + 643072*(x^6) - 627712*(x^5) + 1304064*(x^4) - 982272*(x^3) + 310464*(x^2) - 40248*x + 1681
  final float C15 = 1.00690148012904844554595434173f;      //square-root of a root of the polynomial: 1048576*(x^8) - 41484288*(x^7) + 84627456*(x^6) - 58661888*(x^5) + 16132864*(x^4) - 1589248*(x^3) + 46096*(x^2) + 392*x + 1
  final float C16 = 1.11315425542134000691859706484f;      //square-root of a root of the polynomial: 1048576*(x^8) - 3014656*(x^7) + 3444736*(x^6) - 2287616*(x^5) + 1100544*(x^4) - 455104*(x^3) + 131008*(x^2) - 18860*x + 961
  final float C17 = 1.17226149511492822682872772756f;      //square-root of a root of the polynomial: 256*(x^4) - 512*(x^3) + 240*(x^2) - 28*x + 1
  final float C18 = 1.23179009397802679283951773532f;      //square-root of a root of the polynomial: 1048576*(x^8) - 104988672*(x^7) + 215617536*(x^6) - 97037312*(x^5) + 12262144*(x^4) - 362752*(x^3) - 1584*(x^2) + 88*x + 1
  private PVector[] vert = new PVector[84]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialPentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C10,  0.0f,  C18 );
    vert[  1] = new PVector(  C10,  0.0f, -C18 );
    vert[  2] = new PVector( -C10,  0.0f,  C18 );
    vert[  3] = new PVector( -C10,  0.0f, -C18 );
    vert[  4] = new PVector(  C18,  C10,  0.0f );
    vert[  5] = new PVector(  C18, -C10,  0.0f );
    vert[  6] = new PVector( -C18,  C10,  0.0f );
    vert[  7] = new PVector( -C18, -C10,  0.0f );
    vert[  8] = new PVector(  0.0f,  C18,  C10 );
    vert[  9] = new PVector(  0.0f,  C18, -C10 );
    vert[ 10] = new PVector(  0.0f, -C18,  C10 );
    vert[ 11] = new PVector(  0.0f, -C18, -C10 );
    vert[ 12] = new PVector(   C2,  -C1,  C17 );
    vert[ 13] = new PVector(   C2,   C1, -C17 );
    vert[ 14] = new PVector(  -C2,   C1,  C17 );
    vert[ 15] = new PVector(  -C2,  -C1, -C17 );
    vert[ 16] = new PVector(  C17,  -C2,   C1 );
    vert[ 17] = new PVector(  C17,   C2,  -C1 );
    vert[ 18] = new PVector( -C17,   C2,   C1 );
    vert[ 19] = new PVector( -C17,  -C2,  -C1 );
    vert[ 20] = new PVector(   C1, -C17,   C2 );
    vert[ 21] = new PVector(   C1,  C17,  -C2 );
    vert[ 22] = new PVector(  -C1,  C17,   C2 );
    vert[ 23] = new PVector(  -C1, -C17,  -C2 );
    vert[ 24] = new PVector(   C3,   C4,  C16 );
    vert[ 25] = new PVector(   C3,  -C4, -C16 );
    vert[ 26] = new PVector(  -C3,  -C4,  C16 );
    vert[ 27] = new PVector(  -C3,   C4, -C16 );
    vert[ 28] = new PVector(  C16,   C3,   C4 );
    vert[ 29] = new PVector(  C16,  -C3,  -C4 );
    vert[ 30] = new PVector( -C16,  -C3,   C4 );
    vert[ 31] = new PVector( -C16,   C3,  -C4 );
    vert[ 32] = new PVector(   C4,  C16,   C3 );
    vert[ 33] = new PVector(   C4, -C16,  -C3 );
    vert[ 34] = new PVector(  -C4, -C16,   C3 );
    vert[ 35] = new PVector(  -C4,  C16,  -C3 );
    vert[ 36] = new PVector(   C7,  0.0f,  C15 );
    vert[ 37] = new PVector(   C7,  0.0f, -C15 );
    vert[ 38] = new PVector(  -C7,  0.0f,  C15 );
    vert[ 39] = new PVector(  -C7,  0.0f, -C15 );
    vert[ 40] = new PVector(  C15,   C7,  0.0f );
    vert[ 41] = new PVector(  C15,  -C7,  0.0f );
    vert[ 42] = new PVector( -C15,   C7,  0.0f );
    vert[ 43] = new PVector( -C15,  -C7,  0.0f );
    vert[ 44] = new PVector(  0.0f,  C15,   C7 );
    vert[ 45] = new PVector(  0.0f,  C15,  -C7 );
    vert[ 46] = new PVector(  0.0f, -C15,   C7 );
    vert[ 47] = new PVector(  0.0f, -C15,  -C7 );
    vert[ 48] = new PVector(   C0,  -C9,  C14 );
    vert[ 49] = new PVector(   C0,   C9, -C14 );
    vert[ 50] = new PVector(  -C0,   C9,  C14 );
    vert[ 51] = new PVector(  -C0,  -C9, -C14 );
    vert[ 52] = new PVector(  C14,  -C0,   C9 );
    vert[ 53] = new PVector(  C14,   C0,  -C9 );
    vert[ 54] = new PVector( -C14,   C0,   C9 );
    vert[ 55] = new PVector( -C14,  -C0,  -C9 );
    vert[ 56] = new PVector(   C9, -C14,   C0 );
    vert[ 57] = new PVector(   C9,  C14,  -C0 );
    vert[ 58] = new PVector(  -C9,  C14,   C0 );
    vert[ 59] = new PVector(  -C9, -C14,  -C0 );
    vert[ 60] = new PVector(   C8,  -C6,  C13 );
    vert[ 61] = new PVector(   C8,   C6, -C13 );
    vert[ 62] = new PVector(  -C8,   C6,  C13 );
    vert[ 63] = new PVector(  -C8,  -C6, -C13 );
    vert[ 64] = new PVector(  C13,  -C8,   C6 );
    vert[ 65] = new PVector(  C13,   C8,  -C6 );
    vert[ 66] = new PVector( -C13,   C8,   C6 );
    vert[ 67] = new PVector( -C13,  -C8,  -C6 );
    vert[ 68] = new PVector(   C6, -C13,   C8 );
    vert[ 69] = new PVector(   C6,  C13,  -C8 );
    vert[ 70] = new PVector(  -C6,  C13,   C8 );
    vert[ 71] = new PVector(  -C6, -C13,  -C8 );
    vert[ 72] = new PVector(  C11,   C5,  C12 );
    vert[ 73] = new PVector(  C11,  -C5, -C12 );
    vert[ 74] = new PVector( -C11,  -C5,  C12 );
    vert[ 75] = new PVector( -C11,   C5, -C12 );
    vert[ 76] = new PVector(  C12,  C11,   C5 );
    vert[ 77] = new PVector(  C12, -C11,  -C5 );
    vert[ 78] = new PVector( -C12, -C11,   C5 );
    vert[ 79] = new PVector( -C12,  C11,  -C5 );
    vert[ 80] = new PVector(   C5,  C12,  C11 );
    vert[ 81] = new PVector(   C5, -C12, -C11 );
    vert[ 82] = new PVector(  -C5, -C12,  C11 );
    vert[ 83] = new PVector(  -C5,  C12, -C11 );
    // set faces
    faces[ 0] = new int[] {  0, 16, 17, 40, 76 };
    faces[ 1] = new int[] {  0, 76, 32, 44, 50 };
    faces[ 2] = new int[] {  0, 50, 62, 38, 26 };
    faces[ 3] = new int[] {  0, 26, 82, 46, 68 };
    faces[ 4] = new int[] {  0, 68, 56, 41, 16 };
    faces[ 5] = new int[] {  1, 17, 16, 41, 77 };
    faces[ 6] = new int[] {  1, 77, 33, 47, 51 };
    faces[ 7] = new int[] {  1, 51, 63, 39, 27 };
    faces[ 8] = new int[] {  1, 27, 83, 45, 69 };
    faces[ 9] = new int[] {  1, 69, 57, 40, 17 };
    faces[10] = new int[] {  2, 18, 19, 43, 78 };
    faces[11] = new int[] {  2, 78, 34, 46, 48 };
    faces[12] = new int[] {  2, 48, 60, 36, 24 };
    faces[13] = new int[] {  2, 24, 80, 44, 70 };
    faces[14] = new int[] {  2, 70, 58, 42, 18 };
    faces[15] = new int[] {  3, 19, 18, 42, 79 };
    faces[16] = new int[] {  3, 79, 35, 45, 49 };
    faces[17] = new int[] {  3, 49, 61, 37, 25 };
    faces[18] = new int[] {  3, 25, 81, 47, 71 };
    faces[19] = new int[] {  3, 71, 59, 43, 19 };
    faces[20] = new int[] {  4, 21, 22, 44, 80 };
    faces[21] = new int[] {  4, 80, 24, 36, 52 };
    faces[22] = new int[] {  4, 52, 64, 41, 29 };
    faces[23] = new int[] {  4, 29, 73, 37, 61 };
    faces[24] = new int[] {  4, 61, 49, 45, 21 };
    faces[25] = new int[] {  5, 20, 23, 47, 81 };
    faces[26] = new int[] {  5, 81, 25, 37, 53 };
    faces[27] = new int[] {  5, 53, 65, 40, 28 };
    faces[28] = new int[] {  5, 28, 72, 36, 60 };
    faces[29] = new int[] {  5, 60, 48, 46, 20 };
    faces[30] = new int[] {  6, 22, 21, 45, 83 };
    faces[31] = new int[] {  6, 83, 27, 39, 55 };
    faces[32] = new int[] {  6, 55, 67, 43, 30 };
    faces[33] = new int[] {  6, 30, 74, 38, 62 };
    faces[34] = new int[] {  6, 62, 50, 44, 22 };
    faces[35] = new int[] {  7, 23, 20, 46, 82 };
    faces[36] = new int[] {  7, 82, 26, 38, 54 };
    faces[37] = new int[] {  7, 54, 66, 42, 31 };
    faces[38] = new int[] {  7, 31, 75, 39, 63 };
    faces[39] = new int[] {  7, 63, 51, 47, 23 };
    faces[40] = new int[] {  8, 14, 12, 36, 72 };
    faces[41] = new int[] {  8, 72, 28, 40, 57 };
    faces[42] = new int[] {  8, 57, 69, 45, 35 };
    faces[43] = new int[] {  8, 35, 79, 42, 66 };
    faces[44] = new int[] {  8, 66, 54, 38, 14 };
    faces[45] = new int[] {  9, 13, 15, 39, 75 };
    faces[46] = new int[] {  9, 75, 31, 42, 58 };
    faces[47] = new int[] {  9, 58, 70, 44, 32 };
    faces[48] = new int[] {  9, 32, 76, 40, 65 };
    faces[49] = new int[] {  9, 65, 53, 37, 13 };
    faces[50] = new int[] { 10, 12, 14, 38, 74 };
    faces[51] = new int[] { 10, 74, 30, 43, 59 };
    faces[52] = new int[] { 10, 59, 71, 47, 33 };
    faces[53] = new int[] { 10, 33, 77, 41, 64 };
    faces[54] = new int[] { 10, 64, 52, 36, 12 };
    faces[55] = new int[] { 11, 15, 13, 37, 73 };
    faces[56] = new int[] { 11, 73, 29, 41, 56 };
    faces[57] = new int[] { 11, 56, 68, 46, 34 };
    faces[58] = new int[] { 11, 34, 78, 43, 67 };
    faces[59] = new int[] { 11, 67, 55, 39, 15 };
  } //end MedialPentagonalHexecontahedron()

  public String name() {
    return "Medial Pentagonal Hexecontahedron";
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
   
} //end class MedialPentagonalHexecontahedron
/*
OctagonalIrisToroid class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class OctagonalIrisToroid extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 1.20710678118654752440084436210f; //(1 + sqrt(2)) / 2
  private PVector[] vert = new PVector[16]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private OctagonalIrisToroid() {   
    // set vertices
    vert[ 0] = new PVector(  C0,  0.5f,  0.5f);
    vert[ 1] = new PVector(  C0,  0.5f, -0.5f);
    vert[ 2] = new PVector(  C0, -0.5f,  0.5f);
    vert[ 3] = new PVector(  C0, -0.5f, -0.5f);
    vert[ 4] = new PVector( -C0,  0.5f,  0.5f);
    vert[ 5] = new PVector( -C0,  0.5f, -0.5f);
    vert[ 6] = new PVector( -C0, -0.5f,  0.5f);
    vert[ 7] = new PVector( -C0, -0.5f, -0.5f);
    vert[ 8] = new PVector( 0.5f,   C0,  0.5f);
    vert[ 9] = new PVector( 0.5f,   C0, -0.5f);
    vert[10] = new PVector( 0.5f,  -C0,  0.5f);
    vert[11] = new PVector( 0.5f,  -C0, -0.5f);
    vert[12] = new PVector(-0.5f,   C0,  0.5f);
    vert[13] = new PVector(-0.5f,   C0, -0.5f);
    vert[14] = new PVector(-0.5f,  -C0,  0.5f);
    vert[15] = new PVector(-0.5f,  -C0, -0.5f);
    // set faces
    faces[ 0] = new int[] {  0,  1,  9,  8 };
    faces[ 1] = new int[] {  8,  9, 13, 12 };
    faces[ 2] = new int[] { 12, 13,  5,  4 };
    faces[ 3] = new int[] {  4,  5,  7,  6 };
    faces[ 4] = new int[] {  6,  7, 15, 14 };
    faces[ 5] = new int[] { 14, 15, 11, 10 };
    faces[ 6] = new int[] { 10, 11,  3,  2 };
    faces[ 7] = new int[] {  2,  3,  1,  0 };
    faces[ 8] = new int[] {  0, 11, 15, 15 }; //added 1x 3rd number to fill gap
    faces[ 9] = new int[] {  0, 15,  2,  2 }; //added 1x 3rd number to fill gap
    faces[10] = new int[] {  2, 15,  7,  7 }; //added 1x 3rd number to fill gap
    faces[11] = new int[] {  2,  7, 10, 10 }; //added 1x 3rd number to fill gap
    faces[12] = new int[] {  4,  9,  1,  1 }; //added 1x 3rd number to fill gap
    faces[13] = new int[] {  4,  1, 12, 12 }; //added 1x 3rd number to fill gap
    faces[14] = new int[] {  6, 13,  9,  9 }; //added 1x 3rd number to fill gap
    faces[15] = new int[] {  6,  9,  4,  4 }; //added 1x 3rd number to fill gap
    faces[16] = new int[] {  8,  3, 11, 11 }; //added 1x 3rd number to fill gap
    faces[17] = new int[] {  8, 11,  0,  0 }; //added 1x 3rd number to fill gap
    faces[18] = new int[] { 10,  7,  5,  5 }; //added 1x 3rd number to fill gap
    faces[19] = new int[] { 10,  5, 14, 14 }; //added 1x 3rd number to fill gap
    faces[20] = new int[] { 12,  1,  3,  3 }; //added 1x 3rd number to fill gap
    faces[21] = new int[] { 12,  3,  8,  8 }; //added 1x 3rd number to fill gap
    faces[22] = new int[] { 14, 13,  6,  6 }; //added 1x 3rd number to fill gap
    faces[23] = new int[] { 14,  5, 13, 13 }; //added 1x 3rd number to fill gap
  } //end OctagonalIrisToroid()

  public String name() {
    return "Octagonal Iris Toroid";
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
   
} //end class OctagonalIrisToroid
/*
Octahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Octahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 8;     // number of faces 
  final int VERTICES = 3;  // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048f;  //sqrt(2) / 2
  PVector[] vert = new PVector[6]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private Octahedron() {   
    // set vertices
    vert[ 0] = new PVector(0.0f, 0.0f,  C0);
    vert[ 1] = new PVector(0.0f, 0.0f, -C0);
    vert[ 2] = new PVector( C0, 0.0f, 0.0f);
    vert[ 3] = new PVector(-C0, 0.0f, 0.0f);
    vert[ 4] = new PVector(0.0f,  C0, 0.0f);
    vert[ 5] = new PVector(0.0f, -C0, 0.0f);
    // set faces
    faces[ 0] = new int[] {0, 2, 4};
    faces[ 1] = new int[] {0, 4, 3};
    faces[ 2] = new int[] {0, 3, 5};
    faces[ 3] = new int[] {0, 5, 2};
    faces[ 4] = new int[] {1, 2, 5};
    faces[ 5] = new int[] {1, 5, 3};
    faces[ 6] = new int[] {1, 3, 4};
    faces[ 7] = new int[] {1, 4, 2};
  } //end Octahedron()

  public String name() {
    return "Octahedron";
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

} //end class Octahedron
/*
Octahemioctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Octahemioctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048f; //sqrt(2) / 2
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Octahemioctahedron() {   
    // set vertices
    vert[ 0] = new PVector(  C0, 0.0f,  C0 );
    vert[ 1] = new PVector(  C0, 0.0f, -C0 );
    vert[ 2] = new PVector( -C0, 0.0f,  C0 );
    vert[ 3] = new PVector( -C0, 0.0f, -C0 );
    vert[ 4] = new PVector(  C0,  C0, 0.0f );
    vert[ 5] = new PVector(  C0, -C0, 0.0f );
    vert[ 6] = new PVector( -C0,  C0, 0.0f );
    vert[ 7] = new PVector( -C0, -C0, 0.0f );
    vert[ 8] = new PVector( 0.0f,  C0,  C0 );
    vert[ 9] = new PVector( 0.0f,  C0, -C0 );
    vert[10] = new PVector( 0.0f, -C0,  C0 );
    vert[11] = new PVector( 0.0f, -C0, -C0 );
    // set faces
    faces[ 0] = new int[] {  0,  4,  9,  3,  7, 10 };
    faces[ 1] = new int[] {  0,  5, 11,  3,  6,  8 };
    faces[ 2] = new int[] {  1,  4,  8,  2,  7, 11 };
    faces[ 3] = new int[] {  1,  5, 10,  2,  6,  9 };
    faces[ 4] = new int[] {  0,  8,  4,  4,  4,  4 }; //added 3x 3rd number to fill gap
    faces[ 5] = new int[] {  0, 10,  5,  5,  5,  5 }; //added 3x 3rd number to fill gap
    faces[ 6] = new int[] {  1,  9,  4,  4,  4,  4 }; //added 3x 3rd number to fill gap
    faces[ 7] = new int[] {  1, 11,  5,  5,  5,  5 }; //added 3x 3rd number to fill gap
    faces[ 8] = new int[] {  2,  8,  6,  6,  6,  6 }; //added 3x 3rd number to fill gap
    faces[ 9] = new int[] {  2, 10,  7,  7,  7,  7 }; //added 3x 3rd number to fill gap
    faces[10] = new int[] {  3,  9,  6,  6,  6,  6 }; //added 3x 3rd number to fill gap
    faces[11] = new int[] {  3, 11,  7,  7,  7,  7 }; //added 3x 3rd number to fill gap
  } //end Octahemioctahedron()
 
  public String name() {
    return "Octahemioctahedron";
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
   
} //end class Octahemioctahedron
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
Polyhedrons Demo 4

use left/right arrow keys to cycle through the polyhedrons
up arrow key to change colors
mouse wheel/trackpad scroll zooms in/out

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public ArrayList<Polyhedron> polyObjects = new ArrayList<Polyhedron>();
public Polyhedron poly;
public float zoom = 0.025f;
public int num = 0;
public PFont f;

public void setup(){
  size(displayWidth,displayHeight,OPENGL);
  lights();
  smooth();
  frameRate(30);
  f = createFont("Arial",24,true);
  textFont(f,24);
  textAlign(CENTER);
  noCursor();
  //Instantiate each object
  //platonic solids
  polyObjects.add(new Tetrahedron());
  polyObjects.add(new Octahedron());
  polyObjects.add(new Cube());
  polyObjects.add(new Icosahedron());
  polyObjects.add(new Dodecahedron());
  //kepler-poinsot solids
  polyObjects.add(new SmallStellatedDodecahedron());
  polyObjects.add(new GreatDodecahedron());
  polyObjects.add(new GreatStellatedDodecahedron());
  polyObjects.add(new GreatIcosahedron());
  //versi-regular polyhedra
  polyObjects.add(new Tetrahemihexahedron());
  polyObjects.add(new Cubohemioctahedron());
  polyObjects.add(new Octahemioctahedron());
  polyObjects.add(new SmallDodecahemidodecahedron());
  polyObjects.add(new GreatDodecahemidodecahedron());
  polyObjects.add(new SmallDodecahemicosahedron());
  polyObjects.add(new GreatDodecahemicosahedron());
  polyObjects.add(new SmallIcosihemidodecahedron());
  polyObjects.add(new GreatIcosihemidodecahedron());
  //archimedean solids
  polyObjects.add(new TruncatedTetrahedron());
  polyObjects.add(new Cuboctahedron());
  polyObjects.add(new TruncatedOctahedron());
  polyObjects.add(new TruncatedCube());
  polyObjects.add(new Rhombicuboctahedron());
  polyObjects.add(new SnubCube());
  polyObjects.add(new Icosidodecahedron());
  polyObjects.add(new TruncatedCuboctahedron());
  polyObjects.add(new TruncatedIcosahedron());
  polyObjects.add(new TruncatedDodecahedron());
  polyObjects.add(new Rhombicosidodecahedron());
  polyObjects.add(new SnubDodecahedron());
  polyObjects.add(new TruncatedIcosidodecahedron());
  //self-intersecting quasi-regular polyhedra
  polyObjects.add(new DitrigonalDodecadodecahedron());
  polyObjects.add(new SmallDitrigonalIcosidodecahedron());
  polyObjects.add(new GreatDitrigonalIcosidodecahedron());
  polyObjects.add(new Dodecadodecahedron());
  polyObjects.add(new GreatIcosidodecahedron());
  //self-intersecting quasi-quasi-regular polyhedra
  polyObjects.add(new SmallCubicuboctahedron());
  polyObjects.add(new GreatCubicuboctahedron());
  polyObjects.add(new UniformGreatRhombicuboctahedron());
  polyObjects.add(new SmallDodecicosidodecahedron());
  polyObjects.add(new GreatDodecicosidodecahedron());
  polyObjects.add(new SmallDitrigonalDodecicosidodecahedron());
  polyObjects.add(new GreatDitrigonalDodecicosidodecahedron());
  polyObjects.add(new Icosidodecadodecahedron());
  polyObjects.add(new SmallIcosicosidodecahedron());
  polyObjects.add(new GreatIcosicosidodecahedron());
  polyObjects.add(new Rhombidodecadodecahedron());
  polyObjects.add(new UniformGreatRhombicosidodecahedron());
  //self-intersecting truncated regular polyhedra
  polyObjects.add(new StellatedTruncatedHexahedron());
  polyObjects.add(new TruncatedGreatDodecahedron());
  polyObjects.add(new SmallStellatedTruncatedDodecahedron());
  polyObjects.add(new GreatStellatedTruncatedDodecahedron());
  polyObjects.add(new TruncatedGreatIcosahedron());
  //self-intersecting snub quasi-regular polyhedra
  polyObjects.add(new SnubDodecadodecahedron());
  polyObjects.add(new InvertedSnubDodecadodecahedron());
  polyObjects.add(new GreatSnubIcosidodecahedron());
  polyObjects.add(new GreatInvertedSnubIcosidodecahedron());
  polyObjects.add(new GreatRetrosnubIcosidodecahedron());
  polyObjects.add(new SnubIcosidodecadodecahedron());
  polyObjects.add(new GreatSnubDodecicosidodecahedron());
  polyObjects.add(new SmallSnubIcosicosidodecahedron());
  polyObjects.add(new SmallRetrosnubIcosicosidodecahedron());
  polyObjects.add(new GreatDirhombicosidodecahedron());
  //self-intersecting truncated quasi-regular duals
  polyObjects.add(new TetradyakisHexahedron());
  polyObjects.add(new GreatDisdyakisDodecahedron());
  polyObjects.add(new TridyakisIcosahedron());
  polyObjects.add(new MedialDisdyakisTriacontahedron());
  polyObjects.add(new GreatDisdyakisTriacontahedron());
  //self-intersecting snub quasi-regular duals
  polyObjects.add(new MedialPentagonalHexecontahedron());
  polyObjects.add(new MedialInvertedPentagonalHexecontahedron());
  polyObjects.add(new GreatPentagonalHexecontahedron());
  polyObjects.add(new GreatInvertedPentagonalHexecontahedron());
  polyObjects.add(new GreatPentagrammicHexecontahedron());
  polyObjects.add(new MedialHexagonalHexecontahedron());
  polyObjects.add(new GreatHexagonalHexecontahedron());
  polyObjects.add(new SmallHexagonalHexecontahedron());
  polyObjects.add(new SmallHexagrammicHexecontahedron());
  //non-regular toroidal solids
  polyObjects.add(new OctagonalIrisToroid());
  //regular hexagonal toroidal solids
  polyObjects.add(new RegularHexagonalToroid12faces());
  polyObjects.add(new RegularHexagonalToroid24Faces());
  
  for(Polyhedron p: polyObjects) {
    p.fillColor(PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), 255);
    p.strokeColor(PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), PApplet.parseInt(random(255)), 255);
  }
} //end setup()

public void draw(){
  noCursor();
  background(0);
  pointLight(200, 200, 600, width/2, height/2, 600);
  ambientLight(102, 102, 102);
  spotLight(51, 102, 126, 80, 20, 40, -1, 0, 0, PI/2, 2);
  translate(width/2, height/2, 0);
  poly = polyObjects.get(num);
  if (mousePressed) {
      poly.rotate(mouseX/100.f, mouseY/100.f, 0);
    } else {
      poly.rotate(radians(frameCount%360),radians(frameCount%360),0);
    }
  poly.scaleFactor(5000);
  poly.render();
  text(poly.name(),0,400);
} //end draw()

public void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -5, 5, 0.01f, -0.01f);
  zoom = constrain(zoom, 0.001f, 0.2f);
}

public void keyPressed() {
  if (key == CODED) {
    if (keyCode == LEFT) {
      if (num == 0) {
        num = (polyObjects.size() - 1);
      } else {
        num--;
      }
    } 
    if (keyCode == RIGHT) {
      if (num == (polyObjects.size() - 1)) {
        num = 0;
      } else {
        num++;
      }
    }
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
RegularHexagonalToroid12faces class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class RegularHexagonalToroid12faces extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private RegularHexagonalToroid12faces() {   
    // set vertices
    vert[  0] = new PVector(  3,  3,  3 );
    vert[  1] = new PVector(  3,  3, -3 );
    vert[  2] = new PVector( -3,  3,  3 );
    vert[  3] = new PVector(  3, -3, -3 );
    vert[  4] = new PVector( -3, -3,  3 );
    vert[  5] = new PVector( -3, -3, -3 );
    vert[  6] = new PVector(  3,  1,  3 );
    vert[  7] = new PVector( -3, -1, -3 );
    vert[  8] = new PVector( -3,  3,  1 );
    vert[  9] = new PVector(  3, -3, -1 );
    vert[ 10] = new PVector( -1, -3,  3 );
    vert[ 11] = new PVector(  1,  3, -3 );
    vert[ 12] = new PVector( -1,  1,  3 );
    vert[ 13] = new PVector(  1, -1, -3 );
    vert[ 14] = new PVector( -3, -1,  1 );
    vert[ 15] = new PVector(  3,  1, -1 );
    vert[ 16] = new PVector(  1,  3,  1 );
    vert[ 17] = new PVector( -1, -3, -1 );
    vert[ 18] = new PVector(  1,  1,  1 );
    vert[ 19] = new PVector(  1,  1, -1 );
    vert[ 20] = new PVector( -1,  1,  1 );
    vert[ 21] = new PVector(  1, -1, -1 );
    vert[ 22] = new PVector( -1, -1,  1 );
    vert[ 23] = new PVector( -1, -1, -1 );
    // set faces
    faces[ 0] = new int[] {  0,  1, 11, 16,  8,  2 };
    faces[ 1] = new int[] {  0,  2,  4, 10, 12,  6 };
    faces[ 2] = new int[] {  0,  6, 15,  9,  3,  1 };
    faces[ 3] = new int[] {  5,  3,  9, 17, 10,  4 };
    faces[ 4] = new int[] {  5,  4,  2,  8, 14,  7 };
    faces[ 5] = new int[] {  5,  7, 13, 11,  1,  3 };
    faces[ 6] = new int[] { 18, 16, 11, 13, 21, 19 };
    faces[ 7] = new int[] { 18, 19, 15,  6, 12, 20 };
    faces[ 8] = new int[] { 18, 20, 22, 14,  8, 16 };
    faces[ 9] = new int[] { 23, 17,  9, 15, 19, 21 };
    faces[10] = new int[] { 23, 21, 13,  7, 14, 22 };
    faces[11] = new int[] { 23, 22, 20, 12, 10, 17 };
  } //end RegularHexagonalToroid12faces()

  public String name() {
    return "Regular Hexagonal Toroid with 12 faces (type C) (simple form)";
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
   
} //end class RegularHexagonalToroid12faces
/*
RegularHexagonalToroid24Faces class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class RegularHexagonalToroid24Faces extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  private PVector[] vert = new PVector[48]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private RegularHexagonalToroid24Faces() {   
    // set vertices
    vert[  0] = new PVector( -11,   5,  11 );
    vert[  1] = new PVector( -11,  -5,  11 );
    vert[  2] = new PVector(  11, -11,   5 );
    vert[  3] = new PVector(  11, -11,  -5 );
    vert[  4] = new PVector(   5,  11, -11 );
    vert[  5] = new PVector(  -5,  11, -11 );
    vert[  6] = new PVector(  -7,   5,  11 );
    vert[  7] = new PVector(  11,  -7,   5 );
    vert[  8] = new PVector(   5,  11,  -7 );
    vert[  9] = new PVector(  -5,   7, -11 );
    vert[ 10] = new PVector( -11,  -5,   7 );
    vert[ 11] = new PVector(   7, -11,  -5 );
    vert[ 12] = new PVector(  -7,  -1,  11 );
    vert[ 13] = new PVector(  11,  -7,  -1 );
    vert[ 14] = new PVector(  -1,  11,  -7 );
    vert[ 15] = new PVector(   1,   7, -11 );
    vert[ 16] = new PVector( -11,   1,   7 );
    vert[ 17] = new PVector(   7, -11,   1 );
    vert[ 18] = new PVector(   5,  -5,  11 );
    vert[ 19] = new PVector(   5,  -5, -11 );
    vert[ 20] = new PVector(  11,   5,  -5 );
    vert[ 21] = new PVector( -11,   5,  -5 );
    vert[ 22] = new PVector(  -5,  11,   5 );
    vert[ 23] = new PVector(  -5, -11,   5 );
    vert[ 24] = new PVector(   5,  -1,  11 );
    vert[ 25] = new PVector(  11,   5,  -1 );
    vert[ 26] = new PVector(  -1,  11,   5 );
    vert[ 27] = new PVector(   1,  -5, -11 );
    vert[ 28] = new PVector( -11,   1,  -5 );
    vert[ 29] = new PVector(  -5, -11,   1 );
    vert[ 30] = new PVector(  -7,   1,   7 );
    vert[ 31] = new PVector(  -7,  -1,   7 );
    vert[ 32] = new PVector(   7,  -7,   1 );
    vert[ 33] = new PVector(   7,  -7,  -1 );
    vert[ 34] = new PVector(   1,   7,  -7 );
    vert[ 35] = new PVector(  -1,   7,  -7 );
    vert[ 36] = new PVector(   5,  -1,  -7 );
    vert[ 37] = new PVector(  -7,   5,  -1 );
    vert[ 38] = new PVector(  -1,  -7,   5 );
    vert[ 39] = new PVector(   1,  -5,   7 );
    vert[ 40] = new PVector(   7,   1,  -5 );
    vert[ 41] = new PVector(  -5,   7,   1 );
    vert[ 42] = new PVector(   1,  -1,   7 );
    vert[ 43] = new PVector(   1,  -1,  -7 );
    vert[ 44] = new PVector(   7,   1,  -1 );
    vert[ 45] = new PVector(  -7,   1,  -1 );
    vert[ 46] = new PVector(  -1,   7,   1 );
    vert[ 47] = new PVector(  -1,  -7,   1 );
    // set faces
    faces[ 0] = new int[] {  0,  1, 18, 24, 12,  6 };
    faces[ 1] = new int[] {  0,  6, 37, 25, 20, 21 };
    faces[ 2] = new int[] {  0, 21, 28, 16, 10,  1 };
    faces[ 3] = new int[] {  3,  2, 23, 29, 17, 11 };
    faces[ 4] = new int[] {  3, 11, 40, 28, 21, 20 };
    faces[ 5] = new int[] {  3, 20, 25, 13,  7,  2 };
    faces[ 6] = new int[] { 19,  4,  8, 36, 24, 18 };
    faces[ 7] = new int[] { 19, 18,  1, 10, 39, 27 };
    faces[ 8] = new int[] { 19, 27, 15,  9,  5,  4 };
    faces[ 9] = new int[] { 22,  5,  9, 41, 29, 23 };
    faces[10] = new int[] { 22, 23,  2,  7, 38, 26 };
    faces[11] = new int[] { 22, 26, 14,  8,  4,  5 };
    faces[12] = new int[] { 30, 16, 28, 40, 44, 45 };
    faces[13] = new int[] { 30, 45, 37,  6, 12, 31 };
    faces[14] = new int[] { 30, 31, 42, 39, 10, 16 };
    faces[15] = new int[] { 33, 13, 25, 37, 45, 44 };
    faces[16] = new int[] { 33, 44, 40, 11, 17, 32 };
    faces[17] = new int[] { 33, 32, 47, 38,  7, 13 };
    faces[18] = new int[] { 43, 34, 15, 27, 39, 42 };
    faces[19] = new int[] { 43, 42, 31, 12, 24, 36 };
    faces[20] = new int[] { 43, 36,  8, 14, 35, 34 };
    faces[21] = new int[] { 46, 35, 14, 26, 38, 47 };
    faces[22] = new int[] { 46, 47, 32, 17, 29, 41 };
    faces[23] = new int[] { 46, 41,  9, 15, 34, 35 };
  } //end RegularHexagonalToroid24Faces()

  public String name() {
    return "Regular Hexagonal Toroid with 24 faces";
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
   
} //end class RegularHexagonalToroid24Faces
/*
Rhombicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Rhombicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 62;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  final float C3 = 1.80901699437494742410229341718f;   //(5 + sqrt(5)) / 4
  final float C4 = 2.11803398874989484820458683437f;   //(2 + sqrt(5)) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Rhombicosidodecahedron() {   
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
    faces[12] = new int[] {  0, 36, 52, 24, 24 };  //added 1x 4th number to fill gap
    faces[13] = new int[] {  1, 25, 53, 37, 37 };  //added 1x 4th number to fill gap
    faces[14] = new int[] {  2, 26, 54, 38, 38 };  //added 1x 4th number to fill gap
    faces[15] = new int[] {  3, 39, 55, 27, 27 };  //added 1x 4th number to fill gap
    faces[16] = new int[] {  4, 24, 56, 40, 40 };  //added 1x 4th number to fill gap
    faces[17] = new int[] {  5, 41, 57, 25, 25 };  //added 1x 4th number to fill gap
    faces[18] = new int[] {  6, 42, 58, 26, 26 };  //added 1x 4th number to fill gap
    faces[19] = new int[] {  7, 27, 59, 43, 43 };  //added 1x 4th number to fill gap
    faces[20] = new int[] {  8, 44, 36, 28, 28 };  //added 1x 4th number to fill gap
    faces[21] = new int[] {  9, 29, 37, 45, 45 };  //added 1x 4th number to fill gap
    faces[22] = new int[] { 10, 28, 38, 46, 46 };  //added 1x 4th number to fill gap
    faces[23] = new int[] { 11, 47, 39, 29, 29 };  //added 1x 4th number to fill gap
    faces[24] = new int[] { 12, 30, 40, 48, 48 };  //added 1x 4th number to fill gap
    faces[25] = new int[] { 13, 49, 41, 31, 31 };  //added 1x 4th number to fill gap
    faces[26] = new int[] { 14, 50, 42, 30, 30 };  //added 1x 4th number to fill gap
    faces[27] = new int[] { 15, 31, 43, 51, 51 };  //added 1x 4th number to fill gap
    faces[28] = new int[] { 16, 52, 44, 32, 32 };  //added 1x 4th number to fill gap
    faces[29] = new int[] { 17, 32, 45, 53, 53 };  //added 1x 4th number to fill gap
    faces[30] = new int[] { 18, 33, 46, 54, 54 };  //added 1x 4th number to fill gap
    faces[31] = new int[] { 19, 55, 47, 33, 33 };  //added 1x 4th number to fill gap
    faces[32] = new int[] { 20, 34, 48, 56, 56 };  //added 1x 4th number to fill gap
    faces[33] = new int[] { 21, 57, 49, 34, 34 };  //added 1x 4th number to fill gap
    faces[34] = new int[] { 22, 58, 50, 35, 35 };  //added 1x 4th number to fill gap
    faces[35] = new int[] { 23, 35, 51, 59, 59 };  //added 1x 4th number to fill gap
    faces[36] = new int[] {  0,  4,  6,  2,  2 };  //added 1x 4th number to fill gap
    faces[37] = new int[] {  1,  3,  7,  5,  5 };  //added 1x 4th number to fill gap
    faces[38] = new int[] {  8, 10, 11,  9,  9 };  //added 1x 4th number to fill gap
    faces[39] = new int[] { 12, 13, 15, 14, 14 };  //added 1x 4th number to fill gap
    faces[40] = new int[] { 16, 17, 21, 20, 20 };  //added 1x 4th number to fill gap
    faces[41] = new int[] { 18, 22, 23, 19, 19 };  //added 1x 4th number to fill gap
    faces[42] = new int[] { 24,  4,  0,  0,  0 };  //added 2x 3rd number to fill gap
    faces[43] = new int[] { 25,  1,  5,  5,  5 };  //added 2x 3rd number to fill gap
    faces[44] = new int[] { 26,  2,  6,  6,  6 };  //added 2x 3rd number to fill gap
    faces[45] = new int[] { 27,  7,  3,  3,  3 };  //added 2x 3rd number to fill gap
    faces[46] = new int[] { 28, 10,  8,  8,  8 };  //added 2x 3rd number to fill gap
    faces[47] = new int[] { 29,  9, 11, 11, 11 };  //added 2x 3rd number to fill gap
    faces[48] = new int[] { 30, 12, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[49] = new int[] { 31, 15, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[50] = new int[] { 32, 17, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[51] = new int[] { 33, 18, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[52] = new int[] { 34, 20, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[53] = new int[] { 35, 23, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[54] = new int[] { 36, 44, 52, 52, 52 };  //added 2x 3rd number to fill gap
    faces[55] = new int[] { 37, 53, 45, 45, 45 };  //added 2x 3rd number to fill gap
    faces[56] = new int[] { 38, 54, 46, 46, 46 };  //added 2x 3rd number to fill gap
    faces[57] = new int[] { 39, 47, 55, 55, 55 };  //added 2x 3rd number to fill gap
    faces[58] = new int[] { 40, 56, 48, 48, 48 };  //added 2x 3rd number to fill gap
    faces[59] = new int[] { 41, 49, 57, 57, 57 };  //added 2x 3rd number to fill gap
    faces[60] = new int[] { 42, 50, 58, 58, 58 };  //added 2x 3rd number to fill gap
    faces[61] = new int[] { 43, 59, 51, 51, 51 };  //added 2x 3rd number to fill gap

  } //end Rhombicosidodecahedron()

  public String name() {
    return "Rhombicosidodecahedron";
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
   
} //end class Rhombicosidodecahedron
/*
Rhombicuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Rhombicuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 26;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 1.20710678118654752440084436210f; //(1 + sqrt(2)) / 2
  private PVector[] vert = new PVector[24]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Rhombicuboctahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.5f,  0.5f,   C0 );
    vert[ 1] = new PVector(  0.5f,  0.5f,  -C0 );
    vert[ 2] = new PVector(  0.5f, -0.5f,   C0 );
    vert[ 3] = new PVector(  0.5f, -0.5f,  -C0 );
    vert[ 4] = new PVector( -0.5f,  0.5f,   C0 );
    vert[ 5] = new PVector( -0.5f,  0.5f,  -C0 );
    vert[ 6] = new PVector( -0.5f, -0.5f,   C0 );
    vert[ 7] = new PVector( -0.5f, -0.5f,  -C0 );
    vert[ 8] = new PVector(   C0,  0.5f,  0.5f );
    vert[ 9] = new PVector(   C0,  0.5f, -0.5f );
    vert[10] = new PVector(   C0, -0.5f,  0.5f );
    vert[11] = new PVector(   C0, -0.5f, -0.5f );
    vert[12] = new PVector(  -C0,  0.5f,  0.5f );
    vert[13] = new PVector(  -C0,  0.5f, -0.5f );
    vert[14] = new PVector(  -C0, -0.5f,  0.5f );
    vert[15] = new PVector(  -C0, -0.5f, -0.5f );
    vert[16] = new PVector(  0.5f,   C0,  0.5f );
    vert[17] = new PVector(  0.5f,   C0, -0.5f );
    vert[18] = new PVector(  0.5f,  -C0,  0.5f );
    vert[19] = new PVector(  0.5f,  -C0, -0.5f );
    vert[20] = new PVector( -0.5f,   C0,  0.5f );
    vert[21] = new PVector( -0.5f,   C0, -0.5f );
    vert[22] = new PVector( -0.5f,  -C0,  0.5f );
    vert[23] = new PVector( -0.5f,  -C0, -0.5f );
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
    faces[18] = new int[] {  0,  8, 16, 16 }; //added 1x 3rd number to fill gap
    faces[19] = new int[] {  1, 17,  9,  9 }; //added 1x 3rd number to fill gap
    faces[20] = new int[] {  2, 18, 10, 10 }; //added 1x 3rd number to fill gap
    faces[21] = new int[] {  3, 11, 19, 19 }; //added 1x 3rd number to fill gap
    faces[22] = new int[] {  4, 20, 12, 12 }; //added 1x 3rd number to fill gap
    faces[23] = new int[] {  5, 13, 21, 21 }; //added 1x 3rd number to fill gap
    faces[24] = new int[] {  6, 14, 22, 22 }; //added 1x 3rd number to fill gap
    faces[25] = new int[] {  7, 23, 15, 15 }; //added 1x 3rd number to fill gap
  } //end Rhombicuboctahedron()

  public String name() {
    return "Rhombicuboctahedron";
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
   
} //end class Rhombicuboctahedron
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
SmallDitrigonalIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDitrigonalIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
   private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDitrigonalIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C1,  0.0f,  -C0 );
    vert[  1] = new PVector(  -C1,  0.0f,   C0 );
    vert[  2] = new PVector(   C1,  0.0f,  -C0 );
    vert[  3] = new PVector(   C1,  0.0f,   C0 );
    vert[  4] = new PVector(  0.0f,  -C0,  -C1 );
    vert[  5] = new PVector(  0.0f,  -C0,   C1 );
    vert[  6] = new PVector(  0.0f,   C0,  -C1 );
    vert[  7] = new PVector(  0.0f,   C0,   C1 );
    vert[  8] = new PVector(  -C0,  -C1,  0.0f );
    vert[  9] = new PVector(   C0,  -C1,  0.0f );
    vert[ 10] = new PVector(  -C0,   C1,  0.0f );
    vert[ 11] = new PVector(   C0,   C1,  0.0f );
    vert[ 12] = new PVector(  0.5f,  0.5f,  0.5f );
    vert[ 13] = new PVector(  0.5f,  0.5f, -0.5f );
    vert[ 14] = new PVector( -0.5f,  0.5f,  0.5f );
    vert[ 15] = new PVector( -0.5f,  0.5f, -0.5f );
    vert[ 16] = new PVector(  0.5f, -0.5f,  0.5f );
    vert[ 17] = new PVector(  0.5f, -0.5f, -0.5f );
    vert[ 18] = new PVector( -0.5f, -0.5f,  0.5f );
    vert[ 19] = new PVector( -0.5f, -0.5f, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  6, 19, 15,  4 };
    faces[ 1] = new int[] {  0,  8,  1, 19, 18 };
    faces[ 2] = new int[] {  0, 14, 15,  1, 10 };
    faces[ 3] = new int[] {  7,  1,  5, 14, 18 };
    faces[ 4] = new int[] {  7, 11, 14, 12, 10 };
    faces[ 5] = new int[] {  7, 16, 12,  5,  3 };
    faces[ 6] = new int[] {  9,  2, 16, 17,  3 };
    faces[ 7] = new int[] {  9,  5,  8, 16, 18 };
    faces[ 8] = new int[] {  9, 19, 17,  8,  4 };
    faces[ 9] = new int[] { 13, 12,  2, 11,  3 };
    faces[10] = new int[] { 13, 15, 11,  6, 10 };
    faces[11] = new int[] { 13, 17,  6,  2,  4 };
    faces[12] = new int[] {  0,  4,  8,  8,  8 };  //added 2x 3rd number to fill gap
    faces[13] = new int[] {  0, 10,  6,  6,  6 };  //added 2x 3rd number to fill gap
    faces[14] = new int[] {  0, 18, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[15] = new int[] {  1,  7, 10, 10, 10 };  //added 2x 3rd number to fill gap
    faces[16] = new int[] {  1,  8,  5,  5,  5 };  //added 2x 3rd number to fill gap
    faces[17] = new int[] {  1, 15, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[18] = new int[] {  2,  6, 11, 11, 11 };  //added 2x 3rd number to fill gap
    faces[19] = new int[] {  2,  9,  4,  4,  4 };  //added 2x 3rd number to fill gap
    faces[20] = new int[] {  2, 12, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[21] = new int[] {  3,  5,  9,  9,  9 };  //added 2x 3rd number to fill gap
    faces[22] = new int[] {  3, 11,  7,  7,  7 };  //added 2x 3rd number to fill gap
    faces[23] = new int[] {  3, 17, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[24] = new int[] {  4, 15, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[25] = new int[] {  5, 12, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[26] = new int[] {  6, 17, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[27] = new int[] {  7, 18, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[28] = new int[] {  8, 17, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[29] = new int[] {  9, 18, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[30] = new int[] { 10, 12, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[31] = new int[] { 11, 15, 14, 14, 14 };  //added 2x 3rd number to fill gap
  } //end SmallDitrigonalIcosidodecahedron  //added 2x 3rd number to fill gap()

  public String name() {
    return "Small Ditrigonal Icosidodecahedron";
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
   
} //end class SmallDitrigonalIcosidodecahedron
/*
SmallDodecahemicosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDodecahemicosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 22;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDodecahemicosahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0f,  0.0f, -1.0f );
    vert[ 1] = new PVector(  0.0f,  0.0f,  1.0f );
    vert[ 2] = new PVector(  0.0f, -1.0f,  0.0f );
    vert[ 3] = new PVector(  0.0f,  1.0f,  0.0f );
    vert[ 4] = new PVector( -1.0f,  0.0f,  0.0f );
    vert[ 5] = new PVector(  1.0f,  0.0f,  0.0f );
    vert[ 6] = new PVector( -0.5f,   C1,   C0 );
    vert[ 7] = new PVector( -0.5f,   C1,  -C0 );
    vert[ 8] = new PVector(  0.5f,   C1,   C0 );
    vert[ 9] = new PVector(  0.5f,   C1,  -C0 );
    vert[10] = new PVector( -0.5f,  -C1,   C0 );
    vert[11] = new PVector( -0.5f,  -C1,  -C0 );
    vert[12] = new PVector(  0.5f,  -C1,   C0 );
    vert[13] = new PVector(  0.5f,  -C1,  -C0 );
    vert[14] = new PVector(   C1,   C0, -0.5f );
    vert[15] = new PVector(   C1,   C0,  0.5f );
    vert[16] = new PVector(  -C1,   C0, -0.5f );
    vert[17] = new PVector(  -C1,   C0,  0.5f );
    vert[18] = new PVector(   C1,  -C0, -0.5f );
    vert[19] = new PVector(   C1,  -C0,  0.5f );
    vert[20] = new PVector(  -C1,  -C0, -0.5f );
    vert[21] = new PVector(  -C1,  -C0,  0.5f );
    vert[22] = new PVector(   C0, -0.5f,   C1 );
    vert[23] = new PVector(   C0, -0.5f,  -C1 );
    vert[24] = new PVector(  -C0, -0.5f,   C1 );
    vert[25] = new PVector(  -C0, -0.5f,  -C1 );
    vert[26] = new PVector(   C0,  0.5f,   C1 );
    vert[27] = new PVector(   C0,  0.5f,  -C1 );
    vert[28] = new PVector(  -C0,  0.5f,   C1 );
    vert[29] = new PVector(  -C0,  0.5f,  -C1 );
    // set faces
    faces[ 0] = new int[] { 0, 14, 15,  1, 21, 20 };
    faces[ 1] = new int[] { 0, 16, 17,  1, 19, 18 };
    faces[ 2] = new int[] { 2, 22, 26,  3, 29, 25 };
    faces[ 3] = new int[] { 2, 23, 27,  3, 28, 24 };
    faces[ 4] = new int[] { 4,  6,  8,  5, 13, 11 };
    faces[ 5] = new int[] { 4,  7,  9,  5, 12, 10 };
    faces[ 6] = new int[] { 6, 16, 25, 13, 19, 26 };
    faces[ 7] = new int[] { 7, 17, 24, 12, 18, 27 };
    faces[ 8] = new int[] { 8, 14, 23, 11, 21, 28 };
    faces[ 9] = new int[] { 9, 15, 22, 10, 20, 29 };
    faces[10] = new int[] { 0, 14, 23, 27, 18, 18 }; //added 1x 5th number to fill gap
    faces[11] = new int[] { 0, 20, 29, 25, 16, 16 }; //added 1x 5th number to fill gap
    faces[12] = new int[] { 1, 17, 24, 28, 21, 21 }; //added 1x 5th number to fill gap
    faces[13] = new int[] { 1, 19, 26, 22, 15, 15 }; //added 1x 5th number to fill gap
    faces[14] = new int[] { 2, 22, 10, 12, 24, 24 }; //added 1x 5th number to fill gap
    faces[15] = new int[] { 2, 25, 13, 11, 23, 23 }; //added 1x 5th number to fill gap
    faces[16] = new int[] { 3, 27,  7,  9, 29, 29 }; //added 1x 5th number to fill gap
    faces[17] = new int[] { 3, 28,  8,  6, 26, 26 }; //added 1x 5th number to fill gap
    faces[18] = new int[] { 4,  6, 16, 17,  7,  7 }; //added 1x 5th number to fill gap
    faces[19] = new int[] { 4, 11, 21, 20, 10, 10 }; //added 1x 5th number to fill gap
    faces[20] = new int[] { 5, 12, 18, 19, 13, 13 }; //added 1x 5th number to fill gap
    faces[21] = new int[] { 5,  9, 15, 14,  8,  8 }; //added 1x 5th number to fill gap
  } //end SmallDodecahemicosahedron()

  public String name() {
    return "Small Dodecahemicosahedron";
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
   
} //end class SmallDodecahemicosahedron
/*
SmallDodecahemidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDodecahemidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 18;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718f;  //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437f;  //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDodecahemidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0f,  0.0f,   C2 );
    vert[ 1] = new PVector(  0.0f,  0.0f,  -C2 );
    vert[ 2] = new PVector(   C2,  0.0f,  0.0f );
    vert[ 3] = new PVector(  -C2,  0.0f,  0.0f );
    vert[ 4] = new PVector(  0.0f,   C2,  0.0f );
    vert[ 5] = new PVector(  0.0f,  -C2,  0.0f );
    vert[ 6] = new PVector(  0.5f,   C0,   C1 );
    vert[ 7] = new PVector(  0.5f,   C0,  -C1 );
    vert[ 8] = new PVector(  0.5f,  -C0,   C1 );
    vert[ 9] = new PVector(  0.5f,  -C0,  -C1 );
    vert[10] = new PVector( -0.5f,   C0,   C1 );
    vert[11] = new PVector( -0.5f,   C0,  -C1 );
    vert[12] = new PVector( -0.5f,  -C0,   C1 );
    vert[13] = new PVector( -0.5f,  -C0,  -C1 );
    vert[14] = new PVector(   C1,  0.5f,   C0 );
    vert[15] = new PVector(   C1,  0.5f,  -C0 );
    vert[16] = new PVector(   C1, -0.5f,   C0 );
    vert[17] = new PVector(   C1, -0.5f,  -C0 );
    vert[18] = new PVector(  -C1,  0.5f,   C0 );
    vert[19] = new PVector(  -C1,  0.5f,  -C0 );
    vert[20] = new PVector(  -C1, -0.5f,   C0 );
    vert[21] = new PVector(  -C1, -0.5f,  -C0 );
    vert[22] = new PVector(   C0,   C1,  0.5f );
    vert[23] = new PVector(   C0,   C1, -0.5f );
    vert[24] = new PVector(   C0,  -C1,  0.5f );
    vert[25] = new PVector(   C0,  -C1, -0.5f );
    vert[26] = new PVector(  -C0,   C1,  0.5f );
    vert[27] = new PVector(  -C0,   C1, -0.5f );
    vert[28] = new PVector(  -C0,  -C1,  0.5f );
    vert[29] = new PVector(  -C0,  -C1, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  6, 22, 23,  7,  1, 13, 29, 28, 12 };
    faces[ 1] = new int[] {  0,  8, 24, 25,  9,  1, 11, 27, 26, 10 };
    faces[ 2] = new int[] {  2, 14,  6, 10, 18,  3, 21, 13,  9, 17 };
    faces[ 3] = new int[] {  2, 15,  7, 11, 19,  3, 20, 12,  8, 16 };
    faces[ 4] = new int[] {  4, 22, 14, 16, 24,  5, 29, 21, 19, 27 };
    faces[ 5] = new int[] {  4, 23, 15, 17, 25,  5, 28, 20, 18, 26 };
    faces[ 6] = new int[] {  0,  8, 16, 14,  6,  6,  6,  6,  6,  6 }; //added 5x 5th number to fill gap
    faces[ 7] = new int[] {  0, 10, 18, 20, 12, 12, 12, 12, 12, 12 }; //added 5x 5th number to fill gap
    faces[ 8] = new int[] {  1,  7, 15, 17,  9,  9,  9,  9,  9,  9 }; //added 5x 5th number to fill gap
    faces[ 9] = new int[] {  1, 13, 21, 19, 11, 11, 11, 11, 11, 11 }; //added 5x 5th number to fill gap
    faces[10] = new int[] {  2, 15, 23, 22, 14, 14, 14, 14, 14, 14 }; //added 5x 5th number to fill gap
    faces[11] = new int[] {  2, 16, 24, 25, 17, 17, 17, 17, 17, 17 }; //added 5x 5th number to fill gap
    faces[12] = new int[] {  3, 18, 26, 27, 19, 19, 19, 19, 19, 19 }; //added 5x 5th number to fill gap
    faces[13] = new int[] {  3, 21, 29, 28, 20, 20, 20, 20, 20, 20 }; //added 5x 5th number to fill gap
    faces[14] = new int[] {  4, 23,  7, 11, 27, 27, 27, 27, 27, 27 }; //added 5x 5th number to fill gap
    faces[15] = new int[] {  4, 26, 10,  6, 22, 22, 22, 22, 22, 22 }; //added 5x 5th number to fill gap
    faces[16] = new int[] {  5, 24,  8, 12, 28, 28, 28, 28, 28, 28 }; //added 5x 5th number to fill gap
    faces[17] = new int[] {  5, 29, 13,  9, 25, 25, 25, 25, 25, 25 }; //added 5x 5th number to fill gap
  } //end SmallDodecahemidodecahedron()

  public String name() {
    return "Small Dodecahemidodecahedron";
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
   
} //end class SmallDodecahemidodecahedron
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
SmallHexagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallHexagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.267843693395936526330702957199f;  //(1 - sqrt(5) + sqrt(2 * (3 * sqrt(5) - 1))) / 8
  final float C1  = 0.309016994374947424102293417183f;  //(sqrt(5) - 1) / 4
  final float C2  = 0.433380199586931046495436031247f;  //(sqrt(3 + 2 * sqrt(5)) - 1) / 4
  final float C3  = 0.576860687770883950432996374382f;  //(sqrt(5) - 1 + sqrt(2 * (3 * sqrt(5) - 1))) / 8
  final float C4  = 0.725259131182936505697721826559f;  //(1 + sqrt(5) + 2 * sqrt(3 + 2 * sqrt(5))) / 12
  final float C5  = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C6  = 0.933380199586931046495436031247f;  //(1 + sqrt(3 + 2 * sqrt(5))) / 4
  final float C7  = 1.01024088735781499692843240563f;   //(sqrt(5) - 3 + sqrt(2 * (19 + 9 * sqrt(5)))) / 8
  final float C8  = 1.17349392490520999795228827042f;   //(3 + sqrt(5) + sqrt(2 * (19 + 9 * sqrt(5)))) / 12
  final float C9  = 1.201223892982867572826138988446f;  //(3 - sqrt(5) + sqrt(2 * (19 + 9 * sqrt(5)))) / 8
  final float C10 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C11 = 1.36676039917386209299087206249f;   //sqrt(3 + 2 * sqrt(5)) / 2
  private PVector[] vert = new PVector[112]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallHexagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C1,  0.0f,  C11 );
    vert[  1] = new PVector(   C1,  0.0f, -C11 );
    vert[  2] = new PVector(  -C1,  0.0f,  C11 );
    vert[  3] = new PVector(  -C1,  0.0f, -C11 );
    vert[  4] = new PVector(  C11,   C1,  0.0f );
    vert[  5] = new PVector(  C11,  -C1,  0.0f );
    vert[  6] = new PVector( -C11,   C1,  0.0f );
    vert[  7] = new PVector( -C11,  -C1,  0.0f );
    vert[  8] = new PVector(  0.0f,  C11,   C1 );
    vert[  9] = new PVector(  0.0f,  C11,  -C1 );
    vert[ 10] = new PVector(  0.0f, -C11,   C1 );
    vert[ 11] = new PVector(  0.0f, -C11,  -C1 );
    vert[ 12] = new PVector(  0.0f,  0.5f,  C10 );
    vert[ 13] = new PVector(  0.0f,  0.5f,  C10 );
    vert[ 14] = new PVector(  0.0f,  0.5f, -C10 );
    vert[ 15] = new PVector(  0.0f,  0.5f, -C10 );
    vert[ 16] = new PVector(  0.0f, -0.5f,  C10 );
    vert[ 17] = new PVector(  0.0f, -0.5f,  C10 );
    vert[ 18] = new PVector(  0.0f, -0.5f, -C10 );
    vert[ 19] = new PVector(  0.0f, -0.5f, -C10 );
    vert[ 20] = new PVector(  C10,  0.0f,  0.5f );
    vert[ 21] = new PVector(  C10,  0.0f,  0.5f );
    vert[ 22] = new PVector(  C10,  0.0f, -0.5f );
    vert[ 23] = new PVector(  C10,  0.0f, -0.5f );
    vert[ 24] = new PVector( -C10,  0.0f,  0.5f );
    vert[ 25] = new PVector( -C10,  0.0f,  0.5f );
    vert[ 26] = new PVector( -C10,  0.0f, -0.5f );
    vert[ 27] = new PVector( -C10,  0.0f, -0.5f );
    vert[ 28] = new PVector(  0.5f,  C10,  0.0f );
    vert[ 29] = new PVector(  0.5f,  C10,  0.0f );
    vert[ 30] = new PVector(  0.5f, -C10,  0.0f );
    vert[ 31] = new PVector(  0.5f, -C10,  0.0f );
    vert[ 32] = new PVector( -0.5f,  C10,  0.0f );
    vert[ 33] = new PVector( -0.5f,  C10,  0.0f );
    vert[ 34] = new PVector( -0.5f, -C10,  0.0f );
    vert[ 35] = new PVector( -0.5f, -C10,  0.0f );
    vert[ 36] = new PVector(   C3,   C2,   C9 );
    vert[ 37] = new PVector(   C3,   C2,  -C9 );
    vert[ 38] = new PVector(   C3,  -C2,   C9 );
    vert[ 39] = new PVector(   C3,  -C2,  -C9 );
    vert[ 40] = new PVector(  -C3,   C2,   C9 );
    vert[ 41] = new PVector(  -C3,   C2,  -C9 );
    vert[ 42] = new PVector(  -C3,  -C2,   C9 );
    vert[ 43] = new PVector(  -C3,  -C2,  -C9 );
    vert[ 44] = new PVector(   C9,   C3,   C2 );
    vert[ 45] = new PVector(   C9,   C3,  -C2 );
    vert[ 46] = new PVector(   C9,  -C3,   C2 );
    vert[ 47] = new PVector(   C9,  -C3,  -C2 );
    vert[ 48] = new PVector(  -C9,   C3,   C2 );
    vert[ 49] = new PVector(  -C9,   C3,  -C2 );
    vert[ 50] = new PVector(  -C9,  -C3,   C2 );
    vert[ 51] = new PVector(  -C9,  -C3,  -C2 );
    vert[ 52] = new PVector(   C2,   C9,   C3 );
    vert[ 53] = new PVector(   C2,   C9,  -C3 );
    vert[ 54] = new PVector(   C2,  -C9,   C3 );
    vert[ 55] = new PVector(   C2,  -C9,  -C3 );
    vert[ 56] = new PVector(  -C2,   C9,   C3 );
    vert[ 57] = new PVector(  -C2,   C9,  -C3 );
    vert[ 58] = new PVector(  -C2,  -C9,   C3 );
    vert[ 59] = new PVector(  -C2,  -C9,  -C3 );
    vert[ 60] = new PVector(   C4,  0.0f,   C8 );
    vert[ 61] = new PVector(   C4,  0.0f,  -C8 );
    vert[ 62] = new PVector(  -C4,  0.0f,   C8 );
    vert[ 63] = new PVector(  -C4,  0.0f,  -C8 );
    vert[ 64] = new PVector(   C8,   C4,  0.0f );
    vert[ 65] = new PVector(   C8,  -C4,  0.0f );
    vert[ 66] = new PVector(  -C8,   C4,  0.0f );
    vert[ 67] = new PVector(  -C8,  -C4,  0.0f );
    vert[ 68] = new PVector(  0.0f,   C8,   C4 );
    vert[ 69] = new PVector(  0.0f,   C8,  -C4 );
    vert[ 70] = new PVector(  0.0f,  -C8,   C4 );
    vert[ 71] = new PVector(  0.0f,  -C8,  -C4 );
    vert[ 72] = new PVector(   C0,   C6,   C7 );
    vert[ 73] = new PVector(   C0,   C6,  -C7 );
    vert[ 74] = new PVector(   C0,  -C6,   C7 );
    vert[ 75] = new PVector(   C0,  -C6,  -C7 );
    vert[ 76] = new PVector(  -C0,   C6,   C7 );
    vert[ 77] = new PVector(  -C0,   C6,  -C7 );
    vert[ 78] = new PVector(  -C0,  -C6,   C7 );
    vert[ 79] = new PVector(  -C0,  -C6,  -C7 );
    vert[ 80] = new PVector(   C7,   C0,   C6 );
    vert[ 81] = new PVector(   C7,   C0,  -C6 );
    vert[ 82] = new PVector(   C7,  -C0,   C6 );
    vert[ 83] = new PVector(   C7,  -C0,  -C6 );
    vert[ 84] = new PVector(  -C7,   C0,   C6 );
    vert[ 85] = new PVector(  -C7,   C0,  -C6 );
    vert[ 86] = new PVector(  -C7,  -C0,   C6 );
    vert[ 87] = new PVector(  -C7,  -C0,  -C6 );
    vert[ 88] = new PVector(   C6,   C7,   C0 );
    vert[ 89] = new PVector(   C6,   C7,  -C0 );
    vert[ 90] = new PVector(   C6,  -C7,   C0 );
    vert[ 91] = new PVector(   C6,  -C7,  -C0 );
    vert[ 92] = new PVector(  -C6,   C7,   C0 );
    vert[ 93] = new PVector(  -C6,   C7,  -C0 );
    vert[ 94] = new PVector(  -C6,  -C7,   C0 );
    vert[ 95] = new PVector(  -C6,  -C7,  -C0 );
    vert[ 96] = new PVector(   C5,   C5,   C5 );
    vert[ 97] = new PVector(   C5,   C5,   C5 );
    vert[ 98] = new PVector(   C5,   C5,  -C5 );
    vert[ 99] = new PVector(   C5,   C5,  -C5 );
    vert[100] = new PVector(   C5,  -C5,   C5 );
    vert[101] = new PVector(   C5,  -C5,   C5 );
    vert[102] = new PVector(   C5,  -C5,  -C5 );
    vert[103] = new PVector(   C5,  -C5,  -C5 );
    vert[104] = new PVector(  -C5,   C5,   C5 );
    vert[105] = new PVector(  -C5,   C5,   C5 );
    vert[106] = new PVector(  -C5,   C5,  -C5 );
    vert[107] = new PVector(  -C5,   C5,  -C5 );
    vert[108] = new PVector(  -C5,  -C5,   C5 );
    vert[109] = new PVector(  -C5,  -C5,   C5 );
    vert[110] = new PVector(  -C5,  -C5,  -C5 );
    vert[111] = new PVector(  -C5,  -C5,  -C5 );
    // set faces
    faces[ 0] = new int[] { 60,   0,  17,  74, 100,  82 };
    faces[ 1] = new int[] { 60,  82,  20,  44,  97,  36 };
    faces[ 2] = new int[] { 60,  36,  12,   2,  16,  38 };
    faces[ 3] = new int[] { 60,  38, 101,  46,  21,  80 };
    faces[ 4] = new int[] { 60,  80,  96,  72,  13,   0 };
    faces[ 5] = new int[] { 61,   1,  15,  73,  98,  81 };
    faces[ 6] = new int[] { 61,  81,  22,  47, 103,  39 };
    faces[ 7] = new int[] { 61,  39,  18,   3,  14,  37 };
    faces[ 8] = new int[] { 61,  37,  99,  45,  23,  83 };
    faces[ 9] = new int[] { 61,  83, 102,  75,  19,   1 };
    faces[10] = new int[] { 62,   2,  12,  76, 104,  84 };
    faces[11] = new int[] { 62,  84,  25,  50, 109,  42 };
    faces[12] = new int[] { 62,  42,  17,   0,  13,  40 };
    faces[13] = new int[] { 62,  40, 105,  48,  24,  86 };
    faces[14] = new int[] { 62,  86, 108,  78,  16,   2 };
    faces[15] = new int[] { 63,   3,  18,  79, 110,  87 };
    faces[16] = new int[] { 63,  87,  27,  49, 107,  41 };
    faces[17] = new int[] { 63,  41,  15,   1,  19,  43 };
    faces[18] = new int[] { 63,  43, 111,  51,  26,  85 };
    faces[19] = new int[] { 63,  85, 106,  77,  14,   3 };
    faces[20] = new int[] { 64,   4,  22,  81,  98,  89 };
    faces[21] = new int[] { 64,  89,  29,  52,  97,  44 };
    faces[22] = new int[] { 64,  44,  20,   5,  23,  45 };
    faces[23] = new int[] { 64,  45,  99,  53,  28,  88 };
    faces[24] = new int[] { 64,  88,  96,  80,  21,   4 };
    faces[25] = new int[] { 65,   5,  20,  82, 100,  90 };
    faces[26] = new int[] { 65,  90,  31,  55, 103,  47 };
    faces[27] = new int[] { 65,  47,  22,   4,  21,  46 };
    faces[28] = new int[] { 65,  46, 101,  54,  30,  91 };
    faces[29] = new int[] { 65,  91, 102,  83,  23,   5 };
    faces[30] = new int[] { 66,   6,  25,  84, 104,  92 };
    faces[31] = new int[] { 66,  92,  32,  57, 107,  49 };
    faces[32] = new int[] { 66,  49,  27,   7,  24,  48 };
    faces[33] = new int[] { 66,  48, 105,  56,  33,  93 };
    faces[34] = new int[] { 66,  93, 106,  85,  26,   6 };
    faces[35] = new int[] { 67,   7,  27,  87, 110,  95 };
    faces[36] = new int[] { 67,  95,  34,  58, 109,  50 };
    faces[37] = new int[] { 67,  50,  25,   6,  26,  51 };
    faces[38] = new int[] { 67,  51, 111,  59,  35,  94 };
    faces[39] = new int[] { 67,  94, 108,  86,  24,   7 };
    faces[40] = new int[] { 68,   8,  32,  92, 104,  76 };
    faces[41] = new int[] { 68,  76,  12,  36,  97,  52 };
    faces[42] = new int[] { 68,  52,  29,   9,  33,  56 };
    faces[43] = new int[] { 68,  56, 105,  40,  13,  72 };
    faces[44] = new int[] { 68,  72,  96,  88,  28,   8 };
    faces[45] = new int[] { 69,   9,  29,  89,  98,  73 };
    faces[46] = new int[] { 69,  73,  15,  41, 107,  57 };
    faces[47] = new int[] { 69,  57,  32,   8,  28,  53 };
    faces[48] = new int[] { 69,  53,  99,  37,  14,  77 };
    faces[49] = new int[] { 69,  77, 106,  93,  33,   9 };
    faces[50] = new int[] { 70,  10,  31,  90, 100,  74 };
    faces[51] = new int[] { 70,  74,  17,  42, 109,  58 };
    faces[52] = new int[] { 70,  58,  34,  11,  30,  54 };
    faces[53] = new int[] { 70,  54, 101,  38,  16,  78 };
    faces[54] = new int[] { 70,  78, 108,  94,  35,  10 };
    faces[55] = new int[] { 71,  11,  34,  95, 110,  79 };
    faces[56] = new int[] { 71,  79,  18,  39, 103,  55 };
    faces[57] = new int[] { 71,  55,  31,  10,  35,  59 };
    faces[58] = new int[] { 71,  59, 111,  43,  19,  75 };
    faces[59] = new int[] { 71,  75, 102,  91,  30,  11 };
  } //end SmallHexagonalHexecontahedron()

  public String name() {
    return "Small Hexagonal Hexecontahedron";
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
   
} //end class SmallHexagonalHexecontahedron
/*
SmallHexagrammicHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallHexagrammicHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.185914468266304889629526215104f;    //(2 * sqrt(3 + 2 * sqrt(5)) - 1 - sqrt(5)) / 12
  final float C1  = 0.267843693395936526330702957199f;    //(1 - sqrt(5) + sqrt(2 * (3 * sqrt(5) - 1))) / 8
  final float C2  = 0.300815928655245048550759325631f;    //(sqrt(2 * (19 + 9 * sqrt(5))) - 3 - sqrt(5)) / 12
  final float C3  = 0.309016994374947424102293417183f;    //(sqrt(5) - 1) / 4 
  final float C4  = 0.433380199586931046495436031247f;    //(sqrt(3 + 2 * sqrt(5)) - 1) / 4 
  final float C5  = 0.576860687770883950432996374382f;    //(sqrt(5) - 1 + sqrt(2 * (3 * sqrt(5) - 1))) / 8 
  final float C6  = 0.809016994374947424102293417183f;    //(1 + sqrt(5)) / 4 
  final float C7  = 0.933380199586931046495436031247f;    //(1 + sqrt(3 + 2 * sqrt(5))) / 4 
  final float C8  = 1.01024088735781499692843240563f;     //(sqrt(5) - 3 + sqrt(2 * (19 + 9 * sqrt(5)))) / 8 
  final float C9  = 1.201223892982867572826138988446f;    //(3 - sqrt(5) + sqrt(2 * (19 + 9 * sqrt(5)))) / 8 
  final float C10 = 1.30901699437494742410229341718f;     //(3 + sqrt(5)) / 4 
  final float C11 = 1.36676039917386209299087206249f;     //sqrt(3 + 2 * sqrt(5)) / 2      
  private PVector[] vert = new PVector[112]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallHexagrammicHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C3,  0.0f, -C11 );
    vert[  1] = new PVector(   C3,  0.0f,  C11 );
    vert[  2] = new PVector(  -C3,  0.0f, -C11 );
    vert[  3] = new PVector(  -C3,  0.0f,  C11 );
    vert[  4] = new PVector( -C11,   C3,  0.0f );
    vert[  5] = new PVector( -C11,  -C3,  0.0f );
    vert[  6] = new PVector(  C11,   C3,  0.0f );
    vert[  7] = new PVector(  C11,  -C3,  0.0f );
    vert[  8] = new PVector(  0.0f, -C11,   C3 );
    vert[  9] = new PVector(  0.0f, -C11,  -C3 );
    vert[ 10] = new PVector(  0.0f,  C11,   C3 );
    vert[ 11] = new PVector(  0.0f,  C11,  -C3 );
    vert[ 12] = new PVector(  0.0f,  0.5f,  C10 );
    vert[ 13] = new PVector(  0.0f,  0.5f,  C10 );
    vert[ 14] = new PVector(  0.0f,  0.5f, -C10 );
    vert[ 15] = new PVector(  0.0f,  0.5f, -C10 );
    vert[ 16] = new PVector(  0.0f, -0.5f,  C10 );
    vert[ 17] = new PVector(  0.0f, -0.5f,  C10 );
    vert[ 18] = new PVector(  0.0f, -0.5f, -C10 );
    vert[ 19] = new PVector(  0.0f, -0.5f, -C10 );
    vert[ 20] = new PVector(  C10,  0.0f,  0.5f );
    vert[ 21] = new PVector(  C10,  0.0f,  0.5f );
    vert[ 22] = new PVector(  C10,  0.0f, -0.5f );
    vert[ 23] = new PVector(  C10,  0.0f, -0.5f );
    vert[ 24] = new PVector( -C10,  0.0f,  0.5f );
    vert[ 25] = new PVector( -C10,  0.0f,  0.5f );
    vert[ 26] = new PVector( -C10,  0.0f, -0.5f );
    vert[ 27] = new PVector( -C10,  0.0f, -0.5f );
    vert[ 28] = new PVector(  0.5f,  C10,  0.0f );
    vert[ 29] = new PVector(  0.5f,  C10,  0.0f );
    vert[ 30] = new PVector(  0.5f, -C10,  0.0f );
    vert[ 31] = new PVector(  0.5f, -C10,  0.0f );
    vert[ 32] = new PVector( -0.5f,  C10,  0.0f );
    vert[ 33] = new PVector( -0.5f,  C10,  0.0f );
    vert[ 34] = new PVector( -0.5f, -C10,  0.0f );
    vert[ 35] = new PVector( -0.5f, -C10,  0.0f );
    vert[ 36] = new PVector(  -C1,  -C7,  -C8 );
    vert[ 37] = new PVector(  -C1,  -C7,   C8 );
    vert[ 38] = new PVector(  -C1,   C7,  -C8 );
    vert[ 39] = new PVector(  -C1,   C7,   C8 );
    vert[ 40] = new PVector(   C1,  -C7,  -C8 );
    vert[ 41] = new PVector(   C1,  -C7,   C8 );
    vert[ 42] = new PVector(   C1,   C7,  -C8 );
    vert[ 43] = new PVector(   C1,   C7,   C8 );
    vert[ 44] = new PVector(  -C8,  -C1,  -C7 );
    vert[ 45] = new PVector(  -C8,  -C1,   C7 );
    vert[ 46] = new PVector(  -C8,   C1,  -C7 );
    vert[ 47] = new PVector(  -C8,   C1,   C7 );
    vert[ 48] = new PVector(   C8,  -C1,  -C7 );
    vert[ 49] = new PVector(   C8,  -C1,   C7 );
    vert[ 50] = new PVector(   C8,   C1,  -C7 );
    vert[ 51] = new PVector(   C8,   C1,   C7 );
    vert[ 52] = new PVector(  -C7,  -C8,  -C1 );
    vert[ 53] = new PVector(  -C7,  -C8,   C1 );
    vert[ 54] = new PVector(  -C7,   C8,  -C1 );
    vert[ 55] = new PVector(  -C7,   C8,   C1 );
    vert[ 56] = new PVector(   C7,  -C8,  -C1 );
    vert[ 57] = new PVector(   C7,  -C8,   C1 );
    vert[ 58] = new PVector(   C7,   C8,  -C1 );
    vert[ 59] = new PVector(   C7,   C8,   C1 );
    vert[ 60] = new PVector(  -C0,  0.0f,  -C2 );
    vert[ 61] = new PVector(  -C0,  0.0f,   C2 );
    vert[ 62] = new PVector(   C0,  0.0f,  -C2 );
    vert[ 63] = new PVector(   C0,  0.0f,   C2 );
    vert[ 64] = new PVector(  -C2,  -C0,  0.0f );
    vert[ 65] = new PVector(  -C2,   C0,  0.0f );
    vert[ 66] = new PVector(   C2,  -C0,  0.0f );
    vert[ 67] = new PVector(   C2,   C0,  0.0f );
    vert[ 68] = new PVector(  0.0f,  -C2,  -C0 );
    vert[ 69] = new PVector(  0.0f,  -C2,   C0 );
    vert[ 70] = new PVector(  0.0f,   C2,  -C0 );
    vert[ 71] = new PVector(  0.0f,   C2,   C0 );
    vert[ 72] = new PVector(  -C5,  -C4,  -C9 );
    vert[ 73] = new PVector(  -C5,  -C4,   C9 );
    vert[ 74] = new PVector(  -C5,   C4,  -C9 );
    vert[ 75] = new PVector(  -C5,   C4,   C9 );
    vert[ 76] = new PVector(   C5,  -C4,  -C9 );
    vert[ 77] = new PVector(   C5,  -C4,   C9 );
    vert[ 78] = new PVector(   C5,   C4,  -C9 );
    vert[ 79] = new PVector(   C5,   C4,   C9 );
    vert[ 80] = new PVector(  -C9,  -C5,  -C4 );
    vert[ 81] = new PVector(  -C9,  -C5,   C4 );
    vert[ 82] = new PVector(  -C9,   C5,  -C4 );
    vert[ 83] = new PVector(  -C9,   C5,   C4 );
    vert[ 84] = new PVector(   C9,  -C5,  -C4 );
    vert[ 85] = new PVector(   C9,  -C5,   C4 );
    vert[ 86] = new PVector(   C9,   C5,  -C4 );
    vert[ 87] = new PVector(   C9,   C5,   C4 );
    vert[ 88] = new PVector(  -C4,  -C9,  -C5 );
    vert[ 89] = new PVector(  -C4,  -C9,   C5 );
    vert[ 90] = new PVector(  -C4,   C9,  -C5 );
    vert[ 91] = new PVector(  -C4,   C9,   C5 );
    vert[ 92] = new PVector(   C4,  -C9,  -C5 );
    vert[ 93] = new PVector(   C4,  -C9,   C5 );
    vert[ 94] = new PVector(   C4,   C9,  -C5 );
    vert[ 95] = new PVector(   C4,   C9,   C5 );
    vert[ 96] = new PVector(   C6,   C6,   C6 );
    vert[ 97] = new PVector(   C6,   C6,   C6 );
    vert[ 98] = new PVector(   C6,   C6,  -C6 );
    vert[ 99] = new PVector(   C6,   C6,  -C6 );
    vert[100] = new PVector(   C6,  -C6,   C6 );
    vert[101] = new PVector(   C6,  -C6,   C6 );
    vert[102] = new PVector(   C6,  -C6,  -C6 );
    vert[103] = new PVector(   C6,  -C6,  -C6 );
    vert[104] = new PVector(  -C6,   C6,   C6 );
    vert[105] = new PVector(  -C6,   C6,   C6 );
    vert[106] = new PVector(  -C6,   C6,  -C6 );
    vert[107] = new PVector(  -C6,   C6,  -C6 );
    vert[108] = new PVector(  -C6,  -C6,   C6 );
    vert[109] = new PVector(  -C6,  -C6,   C6 );
    vert[110] = new PVector(  -C6,  -C6,  -C6 );
    vert[111] = new PVector(  -C6,  -C6,  -C6 );
    // set faces
    faces[ 0] = new int[] { 60,   0,  17,  74, 100,  82 };
    faces[ 1] = new int[] { 60,  82,  20,  44,  97,  36 };
    faces[ 2] = new int[] { 60,  36,  12,   2,  16,  38 };
    faces[ 3] = new int[] { 60,  38, 101,  46,  21,  80 };
    faces[ 4] = new int[] { 60,  80,  96,  72,  13,   0 };
    faces[ 5] = new int[] { 61,   1,  15,  73,  98,  81 };
    faces[ 6] = new int[] { 61,  81,  22,  47, 103,  39 };
    faces[ 7] = new int[] { 61,  39,  18,   3,  14,  37 };
    faces[ 8] = new int[] { 61,  37,  99,  45,  23,  83 };
    faces[ 9] = new int[] { 61,  83, 102,  75,  19,   1 };
    faces[10] = new int[] { 62,   2,  12,  76, 104,  84 };
    faces[11] = new int[] { 62,  84,  25,  50, 109,  42 };
    faces[12] = new int[] { 62,  42,  17,   0,  13,  40 };
    faces[13] = new int[] { 62,  40, 105,  48,  24,  86 };
    faces[14] = new int[] { 62,  86, 108,  78,  16,   2 };
    faces[15] = new int[] { 63,   3,  18,  79, 110,  87 };
    faces[16] = new int[] { 63,  87,  27,  49, 107,  41 };
    faces[17] = new int[] { 63,  41,  15,   1,  19,  43 };
    faces[18] = new int[] { 63,  43, 111,  51,  26,  85 };
    faces[19] = new int[] { 63,  85, 106,  77,  14,   3 };
    faces[20] = new int[] { 64,   4,  22,  81,  98,  89 };
    faces[21] = new int[] { 64,  89,  29,  52,  97,  44 };
    faces[22] = new int[] { 64,  44,  20,   5,  23,  45 };
    faces[23] = new int[] { 64,  45,  99,  53,  28,  88 };
    faces[24] = new int[] { 64,  88,  96,  80,  21,   4 };
    faces[25] = new int[] { 65,   5,  20,  82, 100,  90 };
    faces[26] = new int[] { 65,  90,  31,  55, 103,  47 };
    faces[27] = new int[] { 65,  47,  22,   4,  21,  46 };
    faces[28] = new int[] { 65,  46, 101,  54,  30,  91 };
    faces[29] = new int[] { 65,  91, 102,  83,  23,   5 };
    faces[30] = new int[] { 66,   6,  25,  84, 104,  92 };
    faces[31] = new int[] { 66,  92,  32,  57, 107,  49 };
    faces[32] = new int[] { 66,  49,  27,   7,  24,  48 };
    faces[33] = new int[] { 66,  48, 105,  56,  33,  93 };
    faces[34] = new int[] { 66,  93, 106,  85,  26,   6 };
    faces[35] = new int[] { 67,   7,  27,  87, 110,  95 };
    faces[36] = new int[] { 67,  95,  34,  58, 109,  50 };
    faces[37] = new int[] { 67,  50,  25,   6,  26,  51 };
    faces[38] = new int[] { 67,  51, 111,  59,  35,  94 };
    faces[39] = new int[] { 67,  94, 108,  86,  24,   7 };
    faces[40] = new int[] { 68,   8,  32,  92, 104,  76 };
    faces[41] = new int[] { 68,  76,  12,  36,  97,  52 };
    faces[42] = new int[] { 68,  52,  29,   9,  33,  56 };
    faces[43] = new int[] { 68,  56, 105,  40,  13,  72 };
    faces[44] = new int[] { 68,  72,  96,  88,  28,   8 };
    faces[45] = new int[] { 69,   9,  29,  89,  98,  73 };
    faces[46] = new int[] { 69,  73,  15,  41, 107,  57 };
    faces[47] = new int[] { 69,  57,  32,   8,  28,  53 };
    faces[48] = new int[] { 69,  53,  99,  37,  14,  77 };
    faces[49] = new int[] { 69,  77, 106,  93,  33,   9 };
    faces[50] = new int[] { 70,  10,  31,  90, 100,  74 };
    faces[51] = new int[] { 70,  74,  17,  42, 109,  58 };
    faces[52] = new int[] { 70,  58,  34,  11,  30,  54 };
    faces[53] = new int[] { 70,  54, 101,  38,  16,  78 };
    faces[54] = new int[] { 70,  78, 108,  94,  35,  10 };
    faces[55] = new int[] { 71,  11,  34,  95, 110,  79 };
    faces[56] = new int[] { 71,  79,  18,  39, 103,  55 };
    faces[57] = new int[] { 71,  55,  31,  10,  35,  59 };
    faces[58] = new int[] { 71,  59, 111,  43,  19,  75 };
    faces[59] = new int[] { 71,  75, 102,  91,  30,  11 };
  } //end SmallHexagrammicHexecontahedron()

  public String name() {
    return "Small Hexagrammic Hexecontahedron";
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
   
} //end class SmallHexagrammicHexecontahedron
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
SmallIcosihemidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallIcosihemidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 26;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718f;  //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallIcosihemidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0f,  0.0f,   C2 );
    vert[ 1] = new PVector(  0.0f,  0.0f,  -C2 );
    vert[ 2] = new PVector(   C2,  0.0f,  0.0f );
    vert[ 3] = new PVector(  -C2,  0.0f,  0.0f );
    vert[ 4] = new PVector(  0.0f,   C2,  0.0f );
    vert[ 5] = new PVector(  0.0f,  -C2,  0.0f );
    vert[ 6] = new PVector(  0.5f,   C0,   C1 );
    vert[ 7] = new PVector(  0.5f,   C0,  -C1 );
    vert[ 8] = new PVector(  0.5f,  -C0,   C1 );
    vert[ 9] = new PVector(  0.5f,  -C0,  -C1 );
    vert[10] = new PVector( -0.5f,   C0,   C1 );
    vert[11] = new PVector( -0.5f,   C0,  -C1 );
    vert[12] = new PVector( -0.5f,  -C0,   C1 );
    vert[13] = new PVector( -0.5f,  -C0,  -C1 );
    vert[14] = new PVector(   C1,  0.5f,   C0 );
    vert[15] = new PVector(   C1,  0.5f,  -C0 );
    vert[16] = new PVector(   C1, -0.5f,   C0 );
    vert[17] = new PVector(   C1, -0.5f,  -C0 );
    vert[18] = new PVector(  -C1,  0.5f,   C0 );
    vert[19] = new PVector(  -C1,  0.5f,  -C0 );
    vert[20] = new PVector(  -C1, -0.5f,   C0 );
    vert[21] = new PVector(  -C1, -0.5f,  -C0 );
    vert[22] = new PVector(   C0,   C1,  0.5f );
    vert[23] = new PVector(   C0,   C1, -0.5f );
    vert[24] = new PVector(   C0,  -C1,  0.5f );
    vert[25] = new PVector(   C0,  -C1, -0.5f );
    vert[26] = new PVector(  -C0,   C1,  0.5f );
    vert[27] = new PVector(  -C0,   C1, -0.5f );
    vert[28] = new PVector(  -C0,  -C1,  0.5f );
    vert[29] = new PVector(  -C0,  -C1, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  6, 22, 23,  7,  1, 13, 29, 28, 12 };
    faces[ 1] = new int[] {  0,  8, 24, 25,  9,  1, 11, 27, 26, 10 };
    faces[ 2] = new int[] {  2, 14,  6, 10, 18,  3, 21, 13,  9, 17 };
    faces[ 3] = new int[] {  2, 15,  7, 11, 19,  3, 20, 12,  8, 16 };
    faces[ 4] = new int[] {  4, 22, 14, 16, 24,  5, 29, 21, 19, 27 };
    faces[ 5] = new int[] {  4, 23, 15, 17, 25,  5, 28, 20, 18, 26 };
    faces[ 6] = new int[] {  0,  6, 10, 10, 10, 10, 10, 10, 10, 10 }; //added 7x 3rd number to fill gap
    faces[ 7] = new int[] {  0, 12,  8,  8,  8,  8,  8,  8,  8,  8 }; //added 7x 3rd number to fill gap
    faces[ 8] = new int[] {  1,  9, 13, 13, 13, 13, 13, 13, 13, 13 }; //added 7x 3rd number to fill gap
    faces[ 9] = new int[] {  1, 11,  7,  7,  7,  7,  7,  7,  7,  7 }; //added 7x 3rd number to fill gap
    faces[10] = new int[] { 14, 16,  2,  2,  2,  2,  2,  2,  2,  2 }; //added 7x 3rd number to fill gap
    faces[11] = new int[] { 14, 22,  6,  6,  6,  6,  6,  6,  6,  6 }; //added 7x 3rd number to fill gap
    faces[12] = new int[] { 17, 15,  2,  2,  2,  2,  2,  2,  2,  2 }; //added 7x 3rd number to fill gap
    faces[13] = new int[] { 17, 25,  9,  9,  9,  9,  9,  9,  9,  9 }; //added 7x 3rd number to fill gap
    faces[14] = new int[] { 19, 21,  3,  3,  3,  3,  3,  3,  3,  3 }; //added 7x 3rd number to fill gap
    faces[15] = new int[] { 19, 27, 11, 11, 11, 11, 11, 11, 11, 11 }; //added 7x 3rd number to fill gap
    faces[16] = new int[] { 20, 18,  3,  3,  3,  3,  3,  3,  3,  3 }; //added 7x 3rd number to fill gap
    faces[17] = new int[] { 20, 28, 12, 12, 12, 12, 12, 12, 12, 12 }; //added 7x 3rd number to fill gap
    faces[18] = new int[] { 23,  4, 22, 22, 22, 22, 22, 22, 22, 22 }; //added 7x 3rd number to fill gap
    faces[19] = new int[] { 23, 15,  7,  7,  7,  7,  7,  7,  7,  7 }; //added 7x 3rd number to fill gap
    faces[20] = new int[] { 24,  5, 25, 25, 25, 25, 25, 25, 25, 25 }; //added 7x 3rd number to fill gap
    faces[21] = new int[] { 24, 16,  8,  8,  8,  8,  8,  8,  8,  8 }; //added 7x 3rd number to fill gap
    faces[22] = new int[] { 26,  4, 27, 27, 27, 27, 27, 27, 27, 27 }; //added 7x 3rd number to fill gap
    faces[23] = new int[] { 26, 18, 10, 10, 10, 10, 10, 10, 10, 10 }; //added 7x 3rd number to fill gap
    faces[24] = new int[] { 29,  5, 28, 28, 28, 28, 28, 28, 28, 28 }; //added 7x 3rd number to fill gap
    faces[25] = new int[] { 29, 21, 13, 13, 13, 13, 13, 13, 13, 13 }; //added 7x 3rd number to fill gap
  } //end SmallIcosihemidodecahedron()

  public String name() {
    return "Small Icosihemidodecahedron";
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
   
} //end class SmallIcosihemidodecahedron
/*
SmallRetrosnubIcosicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallRetrosnubIcosicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 112;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.0666198004130689535045639687526f;  //(3 - sqrt(3 + 2 * sqrt(5))) / 4
  final float C1 = 0.12436320521198362239314261406454f; //(sqrt(3 + 2 * sqrt(5)) - sqrt(5)) / 4
  final float C2 = 0.232156306604063473669297042801f;   //(3+sqrt(5)-sqrt(2*(3*sqrt(5)-1))) / 8
  final float C3 = 0.267843693395936526330702957199f;   //(1-sqrt(5)+sqrt(2*(3*sqrt(5)-1))) / 8
  final float C4 = 0.309016994374947424102293417183f;   //(sqrt(5) - 1) / 4
  final float C5 = 0.433380199586931046495436031247f;   //(sqrt(3 + 2 * sqrt(5)) - 1) / 4
  final float C6 = 0.576860687770883950432996374382f;   //(sqrt(5)-1+sqrt(2*(3*sqrt(5)-1))) / 8
  
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallRetrosnubIcosicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C6,  0.0f,   C0 );
    vert[  1] = new PVector(  -C6,  0.0f,  -C0 );
    vert[  2] = new PVector(   C6,  0.0f,   C0 );
    vert[  3] = new PVector(   C6,  0.0f,  -C0 );
    vert[  4] = new PVector(   C0,  -C6,  0.0f );
    vert[  5] = new PVector(   C0,   C6,  0.0f );
    vert[  6] = new PVector(  -C0,  -C6,  0.0f );
    vert[  7] = new PVector(  -C0,   C6,  0.0f );
    vert[  8] = new PVector(  0.0f,   C0,  -C6 );
    vert[  9] = new PVector(  0.0f,   C0,   C6 );
    vert[ 10] = new PVector(  0.0f,  -C0,  -C6 );
    vert[ 11] = new PVector(  0.0f,  -C0,   C6 );
    vert[ 12] = new PVector(  -C3,  0.5f,  -C1 );
    vert[ 13] = new PVector(  -C3,  0.5f,   C1 );
    vert[ 14] = new PVector(  -C3, -0.5f,  -C1 );
    vert[ 15] = new PVector(  -C3, -0.5f,   C1 );
    vert[ 16] = new PVector(   C3,  0.5f,  -C1 );
    vert[ 17] = new PVector(   C3,  0.5f,   C1 );
    vert[ 18] = new PVector(   C3, -0.5f,  -C1 );
    vert[ 19] = new PVector(   C3, -0.5f,   C1 );
    vert[ 20] = new PVector(  -C1,  -C3,  0.5f );
    vert[ 21] = new PVector(  -C1,  -C3, -0.5f );
    vert[ 22] = new PVector(  -C1,   C3,  0.5f );
    vert[ 23] = new PVector(  -C1,   C3, -0.5f );
    vert[ 24] = new PVector(   C1,  -C3,  0.5f );
    vert[ 25] = new PVector(   C1,  -C3, -0.5f );
    vert[ 26] = new PVector(   C1,   C3,  0.5f );
    vert[ 27] = new PVector(   C1,   C3, -0.5f );
    vert[ 28] = new PVector(  0.5f,  -C1,  -C3 );
    vert[ 29] = new PVector(  0.5f,  -C1,   C3 );
    vert[ 30] = new PVector(  0.5f,   C1,  -C3 );
    vert[ 31] = new PVector(  0.5f,   C1,   C3 );
    vert[ 32] = new PVector( -0.5f,  -C1,  -C3 );
    vert[ 33] = new PVector( -0.5f,  -C1,   C3 );
    vert[ 34] = new PVector( -0.5f,   C1,  -C3 );
    vert[ 35] = new PVector( -0.5f,   C1,   C3 );
    vert[ 36] = new PVector(   C4,  -C5,   C2 );
    vert[ 37] = new PVector(   C4,  -C5,  -C2 );
    vert[ 38] = new PVector(   C4,   C5,   C2 );
    vert[ 39] = new PVector(   C4,   C5,  -C2 );
    vert[ 40] = new PVector(  -C4,  -C5,   C2 );
    vert[ 41] = new PVector(  -C4,  -C5,  -C2 );
    vert[ 42] = new PVector(  -C4,   C5,   C2 );
    vert[ 43] = new PVector(  -C4,   C5,  -C2 );
    vert[ 44] = new PVector(   C2,   C4,  -C5 );
    vert[ 45] = new PVector(   C2,   C4,   C5 );
    vert[ 46] = new PVector(   C2,  -C4,  -C5 );
    vert[ 47] = new PVector(   C2,  -C4,   C5 );
    vert[ 48] = new PVector(  -C2,   C4,  -C5 );
    vert[ 49] = new PVector(  -C2,   C4,   C5 );
    vert[ 50] = new PVector(  -C2,  -C4,  -C5 );
    vert[ 51] = new PVector(  -C2,  -C4,   C5 );
    vert[ 52] = new PVector(  -C5,   C2,   C4 );
    vert[ 53] = new PVector(  -C5,   C2,  -C4 );
    vert[ 54] = new PVector(  -C5,  -C2,   C4 );
    vert[ 55] = new PVector(  -C5,  -C2,  -C4 );
    vert[ 56] = new PVector(   C5,   C2,   C4 );
    vert[ 57] = new PVector(   C5,   C2,  -C4 );
    vert[ 58] = new PVector(   C5,  -C2,   C4 );
    vert[ 59] = new PVector(   C5,  -C2,  -C4 );
    // set faces
    faces[  0] = new int[] {  0, 46, 12, 14, 44 };
    faces[  1] = new int[] {  1, 45, 15, 13, 47 };
    faces[  2] = new int[] {  2, 48, 18, 16, 50 };
    faces[  3] = new int[] {  3, 51, 17, 19, 49 };
    faces[  4] = new int[] {  4, 53, 20, 21, 52 };
    faces[  5] = new int[] {  5, 54, 23, 22, 55 };
    faces[  6] = new int[] {  6, 56, 25, 24, 57 };
    faces[  7] = new int[] {  7, 59, 26, 27, 58 };
    faces[  8] = new int[] {  8, 40, 28, 32, 36 };
    faces[  9] = new int[] {  9, 37, 33, 29, 41 };
    faces[ 10] = new int[] { 10, 38, 34, 30, 42 };
    faces[ 11] = new int[] { 11, 43, 31, 35, 39 };
    faces[ 12] = new int[] {  0, 16, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 13] = new int[] {  1, 19, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2, 14, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3, 13, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4, 22, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5, 21, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6, 27, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7, 24, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 29, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 32, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10, 35, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11, 30, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 28, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 41, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 42, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 31, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 36, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 33, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 34, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 39, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 12, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 47, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 44, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 15, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 50, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 17, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 18, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 49, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 20, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 52, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 55, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 23, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 57, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 25, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 26, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 58, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37, 45,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38, 46,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  1, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40, 48,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  3, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  2, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43, 51,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  4, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45, 53,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 54,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47,  5, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 56,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49,  6, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50,  7, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 59,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52,  8, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 37,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 38, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 11, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 40,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57,  9, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 10, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 43, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] {  0, 18, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] {  0, 36, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] {  1, 17, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] {  1, 39, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] {  2, 12, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] {  2, 42, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] {  3, 15, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] {  3, 41, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 21,  5, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 21, 13, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 22,  4, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 22, 14, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 25, 33, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 25, 51,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 26, 34, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 26, 48,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 28, 12, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 28, 53,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 31, 15, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 31, 54, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] { 32,  9, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] { 32, 24, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] { 35, 10, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] { 35, 27, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] { 45,  4, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] { 45, 37, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] { 46,  5, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] { 46, 38, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 49, 27,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 49, 57, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 50, 24,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 50, 58, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[104] = new int[] { 52, 29,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[105] = new int[] { 52, 36, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[106] = new int[] { 55, 30, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[107] = new int[] { 55, 39, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[108] = new int[] { 56,  8, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[109] = new int[] { 56, 48, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 59, 11, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[111] = new int[] { 59, 51, 43, 43, 43 };  //added 2x 3rd row to fill gaps
  } //end SmallRetrosnubIcosicosidodecahedron()

  public String name() {
    return "Small Retrosnub Icosicosidodecahedron";
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
   
} //end class SmallRetrosnubIcosicosidodecahedron
/*
SmallSnubIcosicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallSnubIcosicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 112;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.267843693395936526330702957199f; //(1 - sqrt(5) + sqrt(2*(3*sqrt(5)-1)))/8
  final float C1 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C2 = 0.576860687770883950432996374382f; //(sqrt(5) - 1 + sqrt(2*(3*sqrt(5)-1)))/8
  final float C3 = 0.933380199586931046495436031247f; //(1 + sqrt(3 + 2 * sqrt(5))) / 4
  final float C4 = 1.07686068777088395043299637438f;  //(3 + sqrt(5) + sqrt(2*(3*sqrt(5)-1)))/8
  final float C5 = 1.24239719396187847059772944843f;  //(sqrt(5) + sqrt(3 + 2 * sqrt(5))) / 4
  final float C6 = 1.433380199586931046495436031247f; //(3 + sqrt(3 + 2 * sqrt(5))) / 4
  
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallSnubIcosicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  0.0f,   C6 );
    vert[  1] = new PVector(   C0,  0.0f,  -C6 );
    vert[  2] = new PVector(  -C0,  0.0f,   C6 );
    vert[  3] = new PVector(  -C0,  0.0f,  -C6 );
    vert[  4] = new PVector(   C6,   C0,  0.0f );
    vert[  5] = new PVector(   C6,  -C0,  0.0f );
    vert[  6] = new PVector(  -C6,   C0,  0.0f );
    vert[  7] = new PVector(  -C6,  -C0,  0.0f );
    vert[  8] = new PVector(  0.0f,   C6,   C0 );
    vert[  9] = new PVector(  0.0f,   C6,  -C0 );
    vert[ 10] = new PVector(  0.0f,  -C6,   C0 );
    vert[ 11] = new PVector(  0.0f,  -C6,  -C0 );
    vert[ 12] = new PVector(   C2,  0.5f,   C5 );
    vert[ 13] = new PVector(   C2,  0.5f,  -C5 );
    vert[ 14] = new PVector(   C2, -0.5f,   C5 );
    vert[ 15] = new PVector(   C2, -0.5f,  -C5 );
    vert[ 16] = new PVector(  -C2,  0.5f,   C5 );
    vert[ 17] = new PVector(  -C2,  0.5f,  -C5 );
    vert[ 18] = new PVector(  -C2, -0.5f,   C5 );
    vert[ 19] = new PVector(  -C2, -0.5f,  -C5 );
    vert[ 20] = new PVector(   C5,   C2,  0.5f );
    vert[ 21] = new PVector(   C5,   C2, -0.5f );
    vert[ 22] = new PVector(   C5,  -C2,  0.5f );
    vert[ 23] = new PVector(   C5,  -C2, -0.5f );
    vert[ 24] = new PVector(  -C5,   C2,  0.5f );
    vert[ 25] = new PVector(  -C5,   C2, -0.5f );
    vert[ 26] = new PVector(  -C5,  -C2,  0.5f );
    vert[ 27] = new PVector(  -C5,  -C2, -0.5f );
    vert[ 28] = new PVector(  0.5f,   C5,   C2 );
    vert[ 29] = new PVector(  0.5f,   C5,  -C2 );
    vert[ 30] = new PVector(  0.5f,  -C5,   C2 );
    vert[ 31] = new PVector(  0.5f,  -C5,  -C2 );
    vert[ 32] = new PVector( -0.5f,   C5,   C2 );
    vert[ 33] = new PVector( -0.5f,   C5,  -C2 );
    vert[ 34] = new PVector( -0.5f,  -C5,   C2 );
    vert[ 35] = new PVector( -0.5f,  -C5,  -C2 );
    vert[ 36] = new PVector(   C1,   C3,   C4 );
    vert[ 37] = new PVector(   C1,   C3,  -C4 );
    vert[ 38] = new PVector(   C1,  -C3,   C4 );
    vert[ 39] = new PVector(   C1,  -C3,  -C4 );
    vert[ 40] = new PVector(  -C1,   C3,   C4 );
    vert[ 41] = new PVector(  -C1,   C3,  -C4 );
    vert[ 42] = new PVector(  -C1,  -C3,   C4 );
    vert[ 43] = new PVector(  -C1,  -C3,  -C4 );
    vert[ 44] = new PVector(   C4,   C1,   C3 );
    vert[ 45] = new PVector(   C4,   C1,  -C3 );
    vert[ 46] = new PVector(   C4,  -C1,   C3 );
    vert[ 47] = new PVector(   C4,  -C1,  -C3 );
    vert[ 48] = new PVector(  -C4,   C1,   C3 );
    vert[ 49] = new PVector(  -C4,   C1,  -C3 );
    vert[ 50] = new PVector(  -C4,  -C1,   C3 );
    vert[ 51] = new PVector(  -C4,  -C1,  -C3 );
    vert[ 52] = new PVector(   C3,   C4,   C1 );
    vert[ 53] = new PVector(   C3,   C4,  -C1 );
    vert[ 54] = new PVector(   C3,  -C4,   C1 );
    vert[ 55] = new PVector(   C3,  -C4,  -C1 );
    vert[ 56] = new PVector(  -C3,   C4,   C1 );
    vert[ 57] = new PVector(  -C3,   C4,  -C1 );
    vert[ 58] = new PVector(  -C3,  -C4,   C1 );
    vert[ 59] = new PVector(  -C3,  -C4,  -C1 );
    // set faces
    faces[  0] = new int[] {  0, 46, 12, 14, 44 };
    faces[  1] = new int[] {  1, 45, 15, 13, 47 };
    faces[  2] = new int[] {  2, 48, 18, 16, 50 };
    faces[  3] = new int[] {  3, 51, 17, 19, 49 };
    faces[  4] = new int[] {  4, 53, 20, 21, 52 };
    faces[  5] = new int[] {  5, 54, 23, 22, 55 };
    faces[  6] = new int[] {  6, 56, 25, 24, 57 };
    faces[  7] = new int[] {  7, 59, 26, 27, 58 };
    faces[  8] = new int[] {  8, 40, 28, 32, 36 };
    faces[  9] = new int[] {  9, 37, 33, 29, 41 };
    faces[ 10] = new int[] { 10, 38, 34, 30, 42 };
    faces[ 11] = new int[] { 11, 43, 31, 35, 39 };
    faces[ 12] = new int[] {  0, 16, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 13] = new int[] {  1, 19, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2, 14, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3, 13, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4, 22, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5, 21, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6, 27, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7, 24, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 29, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 32, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10, 35, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11, 30, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 28, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 41, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 42, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 31, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 36, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 33, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 34, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 39, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 12, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 47, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 44, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 15, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 50, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 17, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 18, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 49, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 20, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 52, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 55, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 23, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 57, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 25, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 26, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 58, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37, 45,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38, 46,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  1, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40, 48,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  3, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  2, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43, 51,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  4, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45, 53,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 54,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47,  5, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 56,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49,  6, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50,  7, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 59,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52,  8, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 37,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 38, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 11, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 40,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57,  9, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 10, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 43, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] {  0, 18, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] {  0, 36, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] {  1, 17, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] {  1, 39, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] {  2, 12, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] {  2, 42, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] {  3, 15, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] {  3, 41, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 21,  5, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 21, 13, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 22,  4, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 22, 14, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 25, 33, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 25, 51,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 26, 34, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 26, 48,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 28, 12, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 28, 53,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 31, 15, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 31, 54, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] { 32,  9, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] { 32, 24, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] { 35, 10, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] { 35, 27, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] { 45,  4, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] { 45, 37, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] { 46,  5, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] { 46, 38, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 49, 27,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 49, 57, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 50, 24,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 50, 58, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[104] = new int[] { 52, 29,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[105] = new int[] { 52, 36, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[106] = new int[] { 55, 30, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[107] = new int[] { 55, 39, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[108] = new int[] { 56,  8, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[109] = new int[] { 56, 48, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 59, 11, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[111] = new int[] { 59, 51, 43, 43, 43 };  //added 2x 3rd row to fill gaps
  } //end SmallSnubIcosicosidodecahedron()

  public String name() {
    return "Small Snub Icosicosidodecahedron";
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
   
} //end class SmallSnubIcosicosidodecahedron
/*
SmallStellatedDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallStellatedDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;  // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f; // (sqrt(5) - 1) / 4
  PVector[] vert = new PVector[12]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private SmallStellatedDodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.0f,  0.5f,  -C0);
    vert[ 1] = new PVector( 0.0f,  0.5f,   C0);
    vert[ 2] = new PVector( 0.0f, -0.5f,  -C0);
    vert[ 3] = new PVector( 0.0f, -0.5f,   C0);
    vert[ 4] = new PVector( 0.5f,  -C0,  0.0f);
    vert[ 5] = new PVector(-0.5f,  -C0,  0.0f);
    vert[ 6] = new PVector( 0.5f,   C0,  0.0f);
    vert[ 7] = new PVector(-0.5f,   C0,  0.0f);
    vert[ 8] = new PVector( -C0,  0.0f,  0.5f);
    vert[ 9] = new PVector( -C0,  0.0f, -0.5f);
    vert[10] = new PVector(  C0,  0.0f,  0.5f);
    vert[11] = new PVector(  C0,  0.0f, -0.5f);
    // set faces
    faces[ 0] = new int[] {  0,  2,  7, 11,  5 };
    faces[ 1] = new int[] {  0,  5,  1,  9,  8 };
    faces[ 2] = new int[] {  0,  8,  6,  7, 10 };
    faces[ 3] = new int[] {  1,  3,  6,  8,  4 };
    faces[ 4] = new int[] {  1,  4,  0, 10, 11 };  
    faces[ 5] = new int[] {  1, 11,  7,  6,  9 };
    faces[ 6] = new int[] {  2,  0,  4,  9,  6 };
    faces[ 7] = new int[] {  2,  6,  3, 11, 10 };
    faces[ 8] = new int[] {  2, 10,  5,  4,  8 };
    faces[ 9] = new int[] {  3,  1,  5, 10,  7 };  
    faces[10] = new int[] {  3,  7,  2,  8,  9 };
    faces[11] = new int[] {  3,  9,  4,  5, 11 };
  } //end SmallStellatedDodecahedron()

  public String name() {
    return "Small Stellated Dodecahedron";
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
   
} //end class SmallStellatedDodecahedron
/*
SmallStellatedTruncatedDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallStellatedTruncatedDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817f; //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366f; //(sqrt(5) - 1) / 2
  final float C3 = 0.690983005625052575897706582817f; //(5 - sqrt(5)) / 4
  final float C4 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallStellatedTruncatedDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,  0.5f,   C3 );
    vert[  1] = new PVector(  0.0f,  0.5f,  -C3 );
    vert[  2] = new PVector(  0.0f, -0.5f,   C3 );
    vert[  3] = new PVector(  0.0f, -0.5f,  -C3 );
    vert[  4] = new PVector(  0.5f,   C3,  0.0f );
    vert[  5] = new PVector( -0.5f,   C3,  0.0f );
    vert[  6] = new PVector(  0.5f,  -C3,  0.0f );
    vert[  7] = new PVector( -0.5f,  -C3,  0.0f );
    vert[  8] = new PVector(   C3,  0.0f,  0.5f );
    vert[  9] = new PVector(   C3,  0.0f, -0.5f );
    vert[ 10] = new PVector(  -C3,  0.0f,  0.5f );
    vert[ 11] = new PVector(  -C3,  0.0f, -0.5f );
    vert[ 12] = new PVector(  0.5f,  -C1,  -C2 );
    vert[ 13] = new PVector(  0.5f,  -C1,   C2 );
    vert[ 14] = new PVector( -0.5f,  -C1,  -C2 );
    vert[ 15] = new PVector( -0.5f,  -C1,   C2 );
    vert[ 16] = new PVector(  0.5f,   C1,  -C2 );
    vert[ 17] = new PVector(  0.5f,   C1,   C2 );
    vert[ 18] = new PVector( -0.5f,   C1,  -C2 );
    vert[ 19] = new PVector( -0.5f,   C1,   C2 );
    vert[ 20] = new PVector(  -C1,  -C2,  0.5f );
    vert[ 21] = new PVector(  -C1,  -C2, -0.5f );
    vert[ 22] = new PVector(   C1,  -C2,  0.5f );
    vert[ 23] = new PVector(   C1,  -C2, -0.5f );
    vert[ 24] = new PVector(  -C1,   C2,  0.5f );
    vert[ 25] = new PVector(  -C1,   C2, -0.5f );
    vert[ 26] = new PVector(   C1,   C2,  0.5f );
    vert[ 27] = new PVector(   C1,   C2, -0.5f );
    vert[ 28] = new PVector(  -C2,  0.5f,  -C1 );
    vert[ 29] = new PVector(  -C2,  0.5f,   C1 );
    vert[ 30] = new PVector(   C2,  0.5f,  -C1 );
    vert[ 31] = new PVector(   C2,  0.5f,   C1 );
    vert[ 32] = new PVector(  -C2, -0.5f,  -C1 );
    vert[ 33] = new PVector(  -C2, -0.5f,   C1 );
    vert[ 34] = new PVector(   C2, -0.5f,  -C1 );
    vert[ 35] = new PVector(   C2, -0.5f,   C1 );
    vert[ 36] = new PVector(  -C4,   C0,   C0 );
    vert[ 37] = new PVector(  -C4,   C0,  -C0 );
    vert[ 38] = new PVector(   C4,   C0,   C0 );
    vert[ 39] = new PVector(   C4,   C0,  -C0 );
    vert[ 40] = new PVector(  -C4,  -C0,   C0 );
    vert[ 41] = new PVector(  -C4,  -C0,  -C0 );
    vert[ 42] = new PVector(   C4,  -C0,   C0 );
    vert[ 43] = new PVector(   C4,  -C0,  -C0 );
    vert[ 44] = new PVector(   C0,   C0,  -C4 );
    vert[ 45] = new PVector(   C0,   C0,   C4 );
    vert[ 46] = new PVector(  -C0,   C0,  -C4 );
    vert[ 47] = new PVector(  -C0,   C0,   C4 );
    vert[ 48] = new PVector(   C0,  -C0,  -C4 );
    vert[ 49] = new PVector(   C0,  -C0,   C4 );
    vert[ 50] = new PVector(  -C0,  -C0,  -C4 );
    vert[ 51] = new PVector(  -C0,  -C0,   C4 );
    vert[ 52] = new PVector(   C0,  -C4,   C0 );
    vert[ 53] = new PVector(   C0,  -C4,  -C0 );
    vert[ 54] = new PVector(  -C0,  -C4,   C0 );
    vert[ 55] = new PVector(  -C0,  -C4,  -C0 );
    vert[ 56] = new PVector(   C0,   C4,   C0 );
    vert[ 57] = new PVector(   C0,   C4,  -C0 );
    vert[ 58] = new PVector(  -C0,   C4,   C0 );
    vert[ 59] = new PVector(  -C0,   C4,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 42, 26, 51, 35, 31, 47, 22, 38 };
    faces[ 1] = new int[] {  1,  3, 41, 25, 48, 32, 28, 44, 21, 37 };
    faces[ 2] = new int[] {  2,  0, 36, 20, 45, 29, 33, 49, 24, 40 };
    faces[ 3] = new int[] {  3,  1, 39, 23, 46, 30, 34, 50, 27, 43 };
    faces[ 4] = new int[] {  4,  5, 47, 31, 59, 19, 17, 57, 29, 45 };
    faces[ 5] = new int[] {  5,  4, 44, 28, 56, 16, 18, 58, 30, 46 };
    faces[ 6] = new int[] {  6,  7, 50, 34, 54, 14, 12, 52, 32, 48 };
    faces[ 7] = new int[] {  7,  6, 49, 33, 53, 13, 15, 55, 35, 51 };
    faces[ 8] = new int[] {  8,  9, 57, 17, 43, 27, 26, 42, 16, 56 };
    faces[ 9] = new int[] {  9,  8, 52, 12, 38, 22, 23, 39, 13, 53 };
    faces[10] = new int[] { 10, 11, 55, 15, 37, 21, 20, 36, 14, 54 };
    faces[11] = new int[] { 11, 10, 58, 18, 40, 24, 25, 41, 19, 59 };
    faces[12] = new int[] {  0, 38, 12, 14, 36, 36, 36, 36, 36, 36 };  //repeat 5x 5th column to fill gap
    faces[13] = new int[] {  1, 37, 15, 13, 39, 39, 39, 39, 39, 39 };  //repeat 5x 5th column to fill gap
    faces[14] = new int[] {  2, 40, 18, 16, 42, 42, 42, 42, 42, 42 };  //repeat 5x 5th column to fill gap
    faces[15] = new int[] {  3, 43, 17, 19, 41, 41, 41, 41, 41, 41 };  //repeat 5x 5th column to fill gap
    faces[16] = new int[] {  4, 45, 20, 21, 44, 44, 44, 44, 44, 44 };  //repeat 5x 5th column to fill gap
    faces[17] = new int[] {  5, 46, 23, 22, 47, 47, 47, 47, 47, 47 };  //repeat 5x 5th column to fill gap
    faces[18] = new int[] {  6, 48, 25, 24, 49, 49, 49, 49, 49, 49 };  //repeat 5x 5th column to fill gap
    faces[19] = new int[] {  7, 51, 26, 27, 50, 50, 50, 50, 50, 50 };  //repeat 5x 5th column to fill gap
    faces[20] = new int[] {  8, 56, 28, 32, 52, 52, 52, 52, 52, 52 };  //repeat 5x 5th column to fill gap
    faces[21] = new int[] {  9, 53, 33, 29, 57, 57, 57, 57, 57, 57 };  //repeat 5x 5th column to fill gap
    faces[22] = new int[] { 10, 54, 34, 30, 58, 58, 58, 58, 58, 58 };  //repeat 5x 5th column to fill gap
    faces[23] = new int[] { 11, 59, 31, 35, 55, 55, 55, 55, 55, 55 };  //repeat 5x 5th column to fill gap
  } //end SmallStellatedTruncatedDodecahedron()

  public String name() {
    return "Small Stellated Truncated Dodecahedron";
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
   
} //end class SmallStellatedTruncatedDodecahedron
/*
SnubCube class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubCube extends Polyhedron {
  
  // polyhedron
  final int FACES = 38;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.33775397381375235213753224516503f; //C0 = sqrt(3 * (4 - cbrt(17 + 3*sqrt(33)) - cbrt(17 - 3*sqrt(33)))) / 6
  final float C1 = 0.621226410556585311692500954490f;   //C1 = sqrt(3 * (2 + cbrt(17 + 3*sqrt(33)) + cbrt(17 - 3*sqrt(33)))) / 6
  final float C2 = 1.14261350892596209347948408672f;    //C2 = sqrt(3 * (4 + cbrt(199 + 3*sqrt(33)) + cbrt(199 - 3*sqrt(33)))) / 6
  private PVector[] vert = new PVector[24]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubCube() {   
    // set vertices
    vert[ 0] = new PVector(  C1,  C0,  C2 );
    vert[ 1] = new PVector(  C1, -C0, -C2 );
    vert[ 2] = new PVector( -C1, -C0,  C2 );
    vert[ 3] = new PVector( -C1,  C0, -C2 );
    vert[ 4] = new PVector(  C2,  C1,  C0 );
    vert[ 5] = new PVector(  C2, -C1, -C0 );
    vert[ 6] = new PVector( -C2, -C1,  C0 );
    vert[ 7] = new PVector( -C2,  C1, -C0 );
    vert[ 8] = new PVector(  C0,  C2,  C1 );
    vert[ 9] = new PVector(  C0, -C2, -C1 );
    vert[10] = new PVector( -C0, -C2,  C1 );
    vert[11] = new PVector( -C0,  C2, -C1 );
    vert[12] = new PVector(  C0, -C1,  C2 );
    vert[13] = new PVector(  C0,  C1, -C2 );
    vert[14] = new PVector( -C0,  C1,  C2 );
    vert[15] = new PVector( -C0, -C1, -C2 );
    vert[16] = new PVector(  C2, -C0,  C1 );
    vert[17] = new PVector(  C2,  C0, -C1 );
    vert[18] = new PVector( -C2,  C0,  C1 );
    vert[19] = new PVector( -C2, -C0, -C1 );
    vert[20] = new PVector(  C1, -C2,  C0 );
    vert[21] = new PVector(  C1,  C2, -C0 );
    vert[22] = new PVector( -C1,  C2,  C0 );
    vert[23] = new PVector( -C1, -C2, -C0 );
    // set faces
    faces[ 0] = new int[] {  2, 12,  0, 14 };
    faces[ 1] = new int[] {  3, 13,  1, 15 };
    faces[ 2] = new int[] {  4, 16,  5, 17 };
    faces[ 3] = new int[] {  7, 19,  6, 18 };
    faces[ 4] = new int[] {  8, 21, 11, 22 };
    faces[ 5] = new int[] {  9, 20, 10, 23 };
    faces[ 6] = new int[] {  0,  8, 14, 14 }; //added 1x 3rd number to fill gap
    faces[ 7] = new int[] {  1,  9, 15, 15 }; //added 1x 3rd number to fill gap
    faces[ 8] = new int[] {  2, 10, 12, 12 }; //added 1x 3rd number to fill gap
    faces[ 9] = new int[] {  3, 11, 13, 13 }; //added 1x 3rd number to fill gap
    faces[10] = new int[] {  4,  0, 16, 16 }; //added 1x 3rd number to fill gap
    faces[11] = new int[] {  5,  1, 17, 17 }; //added 1x 3rd number to fill gap
    faces[12] = new int[] {  6,  2, 18, 18 }; //added 1x 3rd number to fill gap
    faces[13] = new int[] {  7,  3, 19, 19 }; //added 1x 3rd number to fill gap
    faces[14] = new int[] {  8,  4, 21, 21 }; //added 1x 3rd number to fill gap
    faces[15] = new int[] {  9,  5, 20, 20 }; //added 1x 3rd number to fill gap
    faces[16] = new int[] { 10,  6, 23, 23 }; //added 1x 3rd number to fill gap
    faces[17] = new int[] { 11,  7, 22, 22 }; //added 1x 3rd number to fill gap
    faces[18] = new int[] { 12, 16,  0,  0 }; //added 1x 3rd number to fill gap
    faces[19] = new int[] { 13, 17,  1,  1 }; //added 1x 3rd number to fill gap
    faces[20] = new int[] { 14, 18,  2,  2 }; //added 1x 3rd number to fill gap
    faces[21] = new int[] { 15, 19,  3,  3 }; //added 1x 3rd number to fill gap
    faces[22] = new int[] { 16, 20,  5,  5 }; //added 1x 3rd number to fill gap
    faces[23] = new int[] { 17, 21,  4,  4 }; //added 1x 3rd number to fill gap
    faces[24] = new int[] { 18, 22,  7,  7 }; //added 1x 3rd number to fill gap
    faces[25] = new int[] { 19, 23,  6,  6 }; //added 1x 3rd number to fill gap
    faces[26] = new int[] { 20, 12, 10, 10 }; //added 1x 3rd number to fill gap
    faces[27] = new int[] { 21, 13, 11, 11 }; //added 1x 3rd number to fill gap
    faces[28] = new int[] { 22, 14,  8,  8 }; //added 1x 3rd number to fill gap
    faces[29] = new int[] { 23, 15,  9,  9 }; //added 1x 3rd number to fill gap
    faces[30] = new int[] {  8,  0,  4,  4 }; //added 1x 3rd number to fill gap
    faces[31] = new int[] {  9,  1,  5,  5 }; //added 1x 3rd number to fill gap
    faces[32] = new int[] { 10,  2,  6,  6 }; //added 1x 3rd number to fill gap
    faces[33] = new int[] { 11,  3,  7,  7 }; //added 1x 3rd number to fill gap
    faces[34] = new int[] { 12, 20, 16, 16 }; //added 1x 3rd number to fill gap
    faces[35] = new int[] { 13, 21, 17, 17 }; //added 1x 3rd number to fill gap
    faces[36] = new int[] { 14, 22, 18, 18 }; //added 1x 3rd number to fill gap
    faces[37] = new int[] { 15, 23, 19, 19 }; //added 1x 3rd number to fill gap
  } //end SnubCube()

  public String name() {
    return "Snub Cube (laevo)";
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
   
} //end class SnubCube
/*
SnubDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 84;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.109916902433172651090492403707f;   //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 90112*(x^6) - 48128*(x^5) + 11008*(x^4) + 2496*(x^3) - 592*(x^2) - 76*x + 1
  final float C1  = 0.201581385528028781981346763340f;   //square-root of a root of the polynomial:  65536*(x^8) - 81920*(x^7) - 36864*(x^6) + 5120*(x^5) + 10496*(x^4) + 320*(x^3) - 144*(x^2) - 20*x + 1
  final float C2  = 0.2132629972423431530340912974046f;  //square-root of a root of the polynomial:  256*(x^4) - 448*(x^3)+ 240*(x^2) - 32*x + 1
  final float C3  = 0.311498287961201433071839167047f;   //square-root of a root of the polynomial:  65536*(x^8) - 65536*(x^7) - 16384*(x^6) + 26624*(x^5) + 3584*(x^4) - 4864*(x^3) + 928*(x^2) - 60*x + 1
  final float C4  = 0.391112281317322520035815656719f;   //square-root of a root of the polynomial:  65536*(x^8) - 65536*(x^7) - 16384*(x^6) + 26624*(x^5) + 3584*(x^4) - 4864*(x^3) + 928*(x^2) - 60*x + 1
  final float C5  = 0.4549836805139589684034395850047f;  //square-root of a root of the polynomial:  65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C6  = 0.522916062155765684314671540611f;   //square-root of a root of the polynomial:  4096*(x^8) - 5120*(x^7) + 3072*(x^6) - 1920*(x^5) + 1248*(x^4) - 600*(x^3) + 177*(x^2) - 25*x + 1
  final float C7  = 0.656565066041987750384786348344f;   //square-root of a root of the polynomial:  4096*(x^8) - 5120*(x^7) + 3072*(x^6) - 1920*(x^5) + 1248*(x^4) - 600*(x^3) + 177*(x^2) - 25*x + 1
  final float C8  = 0.717277814600969258425288142552f;   //square-root of a root of the polynomial:  65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C9  = 0.834414350116967117386510707658f;   //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 69632*(x^6) - 43008*(x^5) + 22528*(x^4) - 4544*(x^3) + 1888*(x^2) - 136*x + 1
  final float C10 = 0.849081595439412422704144026444f;   //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 90112*(x^6) - 48128*(x^5) + 11008*(x^4) + 2496*(x^3) - 592*(x^2) - 76*x + 1
  final float C11 = 0.958998497872585073794636430152f;   //square-root of a root of the polynomial:  64*(x^4) - 112*(x^3) + 64*(x^2) - 15*x + 1
  final float C12 = 1.04767734735931027042060200506f;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 69632*(x^6) - 43008*(x^5) + 22528*(x^4) - 4544*(x^3) + 1888*(x^2) - 136*x + 1
  final float C13 = 1.17226149511492822682872772756f;    //square-root of a root of the polynomial:  256*(x^4) - 512*(x^3) + 240*(x^2) - 28*x + 1
  final float C14 = 1.24019387675673494273995968316f;    //square-root of a root of the polynomial:  65536*(x^8) - 81920*(x^7) - 36864*(x^6) + 5120*(x^5) + 10496*(x^4) + 320*(x^3) - 144*(x^2) - 20*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C1,  -C2,  C14 );
    vert[  1] = new PVector(   C1,   C2, -C14 );
    vert[  2] = new PVector(  -C1,   C2,  C14 );
    vert[  3] = new PVector(  -C1,  -C2, -C14 );
    vert[  4] = new PVector(  C14,  -C1,   C2 );
    vert[  5] = new PVector(  C14,   C1,  -C2 );
    vert[  6] = new PVector( -C14,   C1,   C2 );
    vert[  7] = new PVector( -C14,  -C1,  -C2 );
    vert[  8] = new PVector(   C2, -C14,   C1 );
    vert[  9] = new PVector(   C2,  C14,  -C1 );
    vert[ 10] = new PVector(  -C2,  C14,   C1 );
    vert[ 11] = new PVector(  -C2, -C14,  -C1 );
    vert[ 12] = new PVector(   C3,   C4,  C13 );
    vert[ 13] = new PVector(   C3,  -C4, -C13 );
    vert[ 14] = new PVector(  -C3,  -C4,  C13 );
    vert[ 15] = new PVector(  -C3,   C4, -C13 );
    vert[ 16] = new PVector(  C13,   C3,   C4 );
    vert[ 17] = new PVector(  C13,  -C3,  -C4 );
    vert[ 18] = new PVector( -C13,  -C3,   C4 );
    vert[ 19] = new PVector( -C13,   C3,  -C4 );
    vert[ 20] = new PVector(   C4,  C13,   C3 );
    vert[ 21] = new PVector(   C4, -C13,  -C3 );
    vert[ 22] = new PVector(  -C4, -C13,   C3 );
    vert[ 23] = new PVector(  -C4,  C13,  -C3 );
    vert[ 24] = new PVector(   C0,  -C8,  C12 );
    vert[ 25] = new PVector(   C0,   C8, -C12 );
    vert[ 26] = new PVector(  -C0,   C8,  C12 );
    vert[ 27] = new PVector(  -C0,  -C8, -C12 );
    vert[ 28] = new PVector(  C12,  -C0,   C8 );
    vert[ 29] = new PVector(  C12,   C0,  -C8 );
    vert[ 30] = new PVector( -C12,   C0,   C8 );
    vert[ 31] = new PVector( -C12,  -C0,  -C8 );
    vert[ 32] = new PVector(   C8, -C12,   C0 );
    vert[ 33] = new PVector(   C8,  C12,  -C0 );
    vert[ 34] = new PVector(  -C8,  C12,   C0 );
    vert[ 35] = new PVector(  -C8, -C12,  -C0 );
    vert[ 36] = new PVector(   C7,  -C6,  C11 );
    vert[ 37] = new PVector(   C7,   C6, -C11 );
    vert[ 38] = new PVector(  -C7,   C6,  C11 );
    vert[ 39] = new PVector(  -C7,  -C6, -C11 );
    vert[ 40] = new PVector(  C11,  -C7,   C6 );
    vert[ 41] = new PVector(  C11,   C7,  -C6 );
    vert[ 42] = new PVector( -C11,   C7,   C6 );
    vert[ 43] = new PVector( -C11,  -C7,  -C6 );
    vert[ 44] = new PVector(   C6, -C11,   C7 );
    vert[ 45] = new PVector(   C6,  C11,  -C7 );
    vert[ 46] = new PVector(  -C6,  C11,   C7 );
    vert[ 47] = new PVector(  -C6, -C11,  -C7 );
    vert[ 48] = new PVector(   C9,   C5,  C10 );
    vert[ 49] = new PVector(   C9,  -C5, -C10 );
    vert[ 50] = new PVector(  -C9,  -C5,  C10 );
    vert[ 51] = new PVector(  -C9,   C5, -C10 );
    vert[ 52] = new PVector(  C10,   C9,   C5 );
    vert[ 53] = new PVector(  C10,  -C9,  -C5 );
    vert[ 54] = new PVector( -C10,  -C9,   C5 );
    vert[ 55] = new PVector( -C10,   C9,  -C5 );
    vert[ 56] = new PVector(   C5,  C10,   C9 );
    vert[ 57] = new PVector(   C5, -C10,  -C9 );
    vert[ 58] = new PVector(  -C5, -C10,   C9 );
    vert[ 59] = new PVector(  -C5,  C10,  -C9 );
    // set faces
    faces[  0] = new int[] {  0, 28, 12, 36, 48 };
    faces[  1] = new int[] {  1, 29, 13, 37, 49 };
    faces[  2] = new int[] {  2, 30, 14, 38, 50 };
    faces[  3] = new int[] {  3, 31, 15, 39, 51 };
    faces[  4] = new int[] {  4, 32, 17, 40, 53 };
    faces[  5] = new int[] {  5, 33, 16, 41, 52 };
    faces[  6] = new int[] {  6, 34, 19, 42, 55 };
    faces[  7] = new int[] {  7, 35, 18, 43, 54 };
    faces[  8] = new int[] {  8, 24, 22, 44, 58 };
    faces[  9] = new int[] {  9, 25, 23, 45, 59 };
    faces[ 10] = new int[] { 10, 26, 20, 46, 56 };
    faces[ 11] = new int[] { 11, 27, 21, 47, 57 };
    faces[ 12] = new int[] {  0, 26, 42, 18, 58 };
    faces[ 13] = new int[] {  1, 27, 43, 19, 59 };
    faces[ 14] = new int[] {  2, 24, 40, 16, 56 };
    faces[ 15] = new int[] {  3, 25, 41, 17, 57 };
    faces[ 16] = new int[] {  4, 29, 45, 20, 48 };
    faces[ 17] = new int[] {  5, 28, 44, 21, 49 };
    faces[ 18] = new int[] {  6, 31, 47, 22, 50 };
    faces[ 19] = new int[] {  7, 30, 46, 23, 51 };
    faces[ 20] = new int[] {  8, 35, 39, 13, 53 };
    faces[ 21] = new int[] {  9, 34, 38, 12, 52 };
    faces[ 22] = new int[] { 10, 33, 37, 15, 55 };
    faces[ 23] = new int[] { 11, 32, 36, 14, 54 };
    faces[ 24] = new int[] {  0, 58, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] {  1, 59, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] {  2, 56, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] {  3, 57, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] {  4, 48, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] {  5, 49, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] {  6, 50, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] {  7, 51, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] {  8, 53, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] {  9, 52, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 10, 55, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 11, 54, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 12, 38, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 13, 39, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 14, 36, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 15, 37, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 16, 40, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 17, 41, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 18, 42, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 19, 43, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 20, 45, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 21, 44, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 22, 47, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 23, 46, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 24,  2, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 25,  3, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 26,  0, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 27,  1, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 28,  5, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 29,  4, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 30,  7, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 31,  6, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 32, 11, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 33, 10, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 34,  9, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 35,  8, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 36, 32,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 37, 33,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 38, 34,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 39, 35,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 40, 24,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 41, 25,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 42, 26, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 43, 27, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 44, 28,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 45, 29,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 46, 30,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 47, 31,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 48, 20, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 49, 21, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 50, 22, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 51, 23, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 52, 12, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 53, 13, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 54, 14, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 55, 15, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 56, 16, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 57, 17, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 58, 18, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 59, 19, 34, 34, 34 };  //added 2x 3rd row to fill gaps
  } //end SnubDodecadodecahedron()

  public String name() {
    return "Snub Dodecadodecahedron";
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
   
} //end class SnubDodecadodecahedron
/*
SnubDodecahedron (laevo) class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 92;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.192893711352359022108262546061f;
  final float C1  = 0.330921024729844230963655269187f;
  final float C2  = 0.374821658114562295266609516608f;
  final float C3  = 0.567715369466921317374872062669f;
  final float C4  = 0.643029605914072573107464141441f;
  final float C5  = 0.728335176957191477360671629838f;
  final float C6  = 0.847550046789060797396217956030f;
  final float C7  = 1.103156835071753772627281146446f;
  final float C8  = 1.24950378846302719500774109632f;
  final float C9  = 1.41526541625598211477109001870f;
  final float C10 = 1.45402422933801541929649491091f;
  final float C11 = 1.64691794069037444140475745697f;
  final float C12 = 1.74618644098582634573474528789f;
  final float C13 = 1.97783896542021867236841272616f;
  final float C14 = 2.097053835252087992403959052348f;
  //C0  = phi * sqrt(3 - (x^2)) / 2
  //C1  = x * phi * sqrt(3 - (x^2)) / 2
  //C2  = phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C3  = (x^2) * phi * sqrt(3 - (x^2)) / 2
  //C4  = x * phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C5  = phi * sqrt(1 - x + (phi + 1) / x) / 2
  //C6  = phi * sqrt(x - phi + 1) / 2
  //C7  = (x^2) * phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C8  = x * phi * sqrt(1 - x + (phi + 1) / x) / 2
  //C9  = sqrt((x + 2) * phi + 2) / 2
  //C10 = x * sqrt(x * (phi + 1) - phi) / 2
  //C11 = sqrt((x^2) * (2 * phi + 1) - phi) / 2
  //C12 = phi * sqrt((x^2) + x) / 2
  //C13 = (phi^2) * sqrt(x * (x + phi) + 1) / (2 * x)
  //C14 = phi * sqrt(x * (x + phi) + 1) / 2
  //WHERE:  phi = (1 + sqrt(5)) / 2
  //        x = cbrt((phi + sqrt(phi-5/27))/2) + cbrt((phi - sqrt(phi-5/27))/2)
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C2,  -C1,  C14 );
    vert[  1] = new PVector(   C2,   C1, -C14 );
    vert[  2] = new PVector(  -C2,   C1,  C14 );
    vert[  3] = new PVector(  -C2,  -C1, -C14 );
    vert[  4] = new PVector(  C14,  -C2,   C1 );
    vert[  5] = new PVector(  C14,   C2,  -C1 );
    vert[  6] = new PVector( -C14,   C2,   C1 );
    vert[  7] = new PVector( -C14,  -C2,  -C1 );
    vert[  8] = new PVector(   C1, -C14,   C2 );
    vert[  9] = new PVector(   C1,  C14,  -C2 );
    vert[ 10] = new PVector(  -C1,  C14,   C2 );
    vert[ 11] = new PVector(  -C1, -C14,  -C2 );
    vert[ 12] = new PVector(   C3,   C4,  C13 );
    vert[ 13] = new PVector(   C3,  -C4, -C13 );
    vert[ 14] = new PVector(  -C3,  -C4,  C13 );
    vert[ 15] = new PVector(  -C3,   C4, -C13 );
    vert[ 16] = new PVector(  C13,   C3,   C4 );
    vert[ 17] = new PVector(  C13,  -C3,  -C4 );
    vert[ 18] = new PVector( -C13,  -C3,   C4 );
    vert[ 19] = new PVector( -C13,   C3,  -C4 );
    vert[ 20] = new PVector(   C4,  C13,   C3 );
    vert[ 21] = new PVector(   C4, -C13,  -C3 );
    vert[ 22] = new PVector(  -C4, -C13,   C3 );
    vert[ 23] = new PVector(  -C4,  C13,  -C3 );
    vert[ 24] = new PVector(   C0,  -C8,  C12 );
    vert[ 25] = new PVector(   C0,   C8, -C12 );
    vert[ 26] = new PVector(  -C0,   C8,  C12 );
    vert[ 27] = new PVector(  -C0,  -C8, -C12 );
    vert[ 28] = new PVector(  C12,  -C0,   C8 );
    vert[ 29] = new PVector(  C12,   C0,  -C8 );
    vert[ 30] = new PVector( -C12,   C0,   C8 );
    vert[ 31] = new PVector( -C12,  -C0,  -C8 );
    vert[ 32] = new PVector(   C8, -C12,   C0 );
    vert[ 33] = new PVector(   C8,  C12,  -C0 );
    vert[ 34] = new PVector(  -C8,  C12,   C0 );
    vert[ 35] = new PVector(  -C8, -C12,  -C0 );
    vert[ 36] = new PVector(   C7,  -C6,  C11 );
    vert[ 37] = new PVector(   C7,   C6, -C11 );
    vert[ 38] = new PVector(  -C7,   C6,  C11 );
    vert[ 39] = new PVector(  -C7,  -C6, -C11 );
    vert[ 40] = new PVector(  C11,  -C7,   C6 );
    vert[ 41] = new PVector(  C11,   C7,  -C6 );
    vert[ 42] = new PVector( -C11,   C7,   C6 );
    vert[ 43] = new PVector( -C11,  -C7,  -C6 );
    vert[ 44] = new PVector(   C6, -C11,   C7 );
    vert[ 45] = new PVector(   C6,  C11,  -C7 );
    vert[ 46] = new PVector(  -C6,  C11,   C7 );
    vert[ 47] = new PVector(  -C6, -C11,  -C7 );
    vert[ 48] = new PVector(   C9,   C5,  C10 );
    vert[ 49] = new PVector(   C9,  -C5, -C10 );
    vert[ 50] = new PVector(  -C9,  -C5,  C10 );
    vert[ 51] = new PVector(  -C9,   C5, -C10 );
    vert[ 52] = new PVector(  C10,   C9,   C5 );
    vert[ 53] = new PVector(  C10,  -C9,  -C5 );
    vert[ 54] = new PVector( -C10,  -C9,   C5 );
    vert[ 55] = new PVector( -C10,   C9,  -C5 );
    vert[ 56] = new PVector(   C5,  C10,   C9 );
    vert[ 57] = new PVector(   C5, -C10,  -C9 );
    vert[ 58] = new PVector(  -C5, -C10,   C9 );
    vert[ 59] = new PVector(  -C5,  C10,  -C9 );
    // set faces
    faces[ 0] = new int[] {  0, 36, 28, 48, 12 };
    faces[ 1] = new int[] {  1, 37, 29, 49, 13 };
    faces[ 2] = new int[] {  2, 38, 30, 50, 14 };
    faces[ 3] = new int[] {  3, 39, 31, 51, 15 };
    faces[ 4] = new int[] {  4, 40, 32, 53, 17 };
    faces[ 5] = new int[] {  5, 41, 33, 52, 16 };
    faces[ 6] = new int[] {  6, 42, 34, 55, 19 };
    faces[ 7] = new int[] {  7, 43, 35, 54, 18 };
    faces[ 8] = new int[] {  8, 44, 24, 58, 22 };
    faces[ 9] = new int[] {  9, 45, 25, 59, 23 };
    faces[10] = new int[] { 10, 46, 26, 56, 20 };
    faces[11] = new int[] { 11, 47, 27, 57, 21 };
    faces[12] = new int[] {  0,  2, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[13] = new int[] {  1,  3, 15, 15, 15 };  //added 2x 3rd number to fill gap
    faces[14] = new int[] {  2,  0, 12, 12, 12 };  //added 2x 3rd number to fill gap
    faces[15] = new int[] {  3,  1, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[16] = new int[] {  4,  5, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[17] = new int[] {  5,  4, 17, 17, 17 };  //added 2x 3rd number to fill gap
    faces[18] = new int[] {  6,  7, 18, 18, 18 };  //added 2x 3rd number to fill gap
    faces[19] = new int[] {  7,  6, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[20] = new int[] {  8, 11, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[21] = new int[] {  9, 10, 20, 20, 20 };  //added 2x 3rd number to fill gap
    faces[22] = new int[] { 10,  9, 23, 23, 23 };  //added 2x 3rd number to fill gap
    faces[23] = new int[] { 11,  8, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[24] = new int[] { 12, 48, 56, 56, 56 };  //added 2x 3rd number to fill gap
    faces[25] = new int[] { 13, 49, 57, 57, 57 };  //added 2x 3rd number to fill gap
    faces[26] = new int[] { 14, 50, 58, 58, 58 };  //added 2x 3rd number to fill gap
    faces[27] = new int[] { 15, 51, 59, 59, 59 };  //added 2x 3rd number to fill gap
    faces[28] = new int[] { 16, 52, 48, 48, 48 };  //added 2x 3rd number to fill gap
    faces[29] = new int[] { 17, 53, 49, 49, 49 };  //added 2x 3rd number to fill gap
    faces[30] = new int[] { 18, 54, 50, 50, 50 };  //added 2x 3rd number to fill gap
    faces[31] = new int[] { 19, 55, 51, 51, 51 };  //added 2x 3rd number to fill gap
    faces[32] = new int[] { 20, 56, 52, 52, 52 };  //added 2x 3rd number to fill gap
    faces[33] = new int[] { 21, 57, 53, 53, 53 };  //added 2x 3rd number to fill gap
    faces[34] = new int[] { 22, 58, 54, 54, 54 };  //added 2x 3rd number to fill gap
    faces[35] = new int[] { 23, 59, 55, 55, 55 };  //added 2x 3rd number to fill gap
    faces[36] = new int[] { 24, 44, 36, 36, 36 };  //added 2x 3rd number to fill gap
    faces[37] = new int[] { 25, 45, 37, 37, 37 };  //added 2x 3rd number to fill gap
    faces[38] = new int[] { 26, 46, 38, 38, 38 };  //added 2x 3rd number to fill gap
    faces[39] = new int[] { 27, 47, 39, 39, 39 };  //added 2x 3rd number to fill gap
    faces[40] = new int[] { 28, 36, 40, 40, 40 };  //added 2x 3rd number to fill gap
    faces[41] = new int[] { 29, 37, 41, 41, 41 };  //added 2x 3rd number to fill gap
    faces[42] = new int[] { 30, 38, 42, 42, 42 };  //added 2x 3rd number to fill gap
    faces[43] = new int[] { 31, 39, 43, 43, 43 };  //added 2x 3rd number to fill gap
    faces[44] = new int[] { 32, 40, 44, 44, 44 };  //added 2x 3rd number to fill gap
    faces[45] = new int[] { 33, 41, 45, 45, 45 };  //added 2x 3rd number to fill gap
    faces[46] = new int[] { 34, 42, 46, 46, 46 };  //added 2x 3rd number to fill gap
    faces[47] = new int[] { 35, 43, 47, 47, 47 };  //added 2x 3rd number to fill gap
    faces[48] = new int[] { 36,  0, 24, 24, 24 };  //added 2x 3rd number to fill gap
    faces[49] = new int[] { 37,  1, 25, 25, 25 };  //added 2x 3rd number to fill gap
    faces[50] = new int[] { 38,  2, 26, 26, 26 };  //added 2x 3rd number to fill gap
    faces[51] = new int[] { 39,  3, 27, 27, 27 };  //added 2x 3rd number to fill gap
    faces[52] = new int[] { 40,  4, 28, 28, 28 };  //added 2x 3rd number to fill gap
    faces[53] = new int[] { 41,  5, 29, 29, 29 };  //added 2x 3rd number to fill gap
    faces[54] = new int[] { 42,  6, 30, 30, 30 };  //added 2x 3rd number to fill gap
    faces[55] = new int[] { 43,  7, 31, 31, 31 };  //added 2x 3rd number to fill gap
    faces[56] = new int[] { 44,  8, 32, 32, 32 };  //added 2x 3rd number to fill gap
    faces[57] = new int[] { 45,  9, 33, 33, 33 };  //added 2x 3rd number to fill gap
    faces[58] = new int[] { 46, 10, 34, 34, 34 };  //added 2x 3rd number to fill gap
    faces[59] = new int[] { 47, 11, 35, 35, 35 };  //added 2x 3rd number to fill gap
    faces[60] = new int[] { 48, 28, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[61] = new int[] { 49, 29, 17, 17, 17 };  //added 2x 3rd number to fill gap
    faces[62] = new int[] { 50, 30, 18, 18, 18 };  //added 2x 3rd number to fill gap
    faces[63] = new int[] { 51, 31, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[64] = new int[] { 52, 33, 20, 20, 20 };  //added 2x 3rd number to fill gap
    faces[65] = new int[] { 53, 32, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[66] = new int[] { 54, 35, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[67] = new int[] { 55, 34, 23, 23, 23 };  //added 2x 3rd number to fill gap
    faces[68] = new int[] { 56, 26, 12, 12, 12 };  //added 2x 3rd number to fill gap
    faces[69] = new int[] { 57, 27, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[70] = new int[] { 58, 24, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[71] = new int[] { 59, 25, 15, 15, 15 };  //added 2x 3rd number to fill gap
    faces[72] = new int[] { 24,  0, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[73] = new int[] { 25,  1, 15, 15, 15 };  //added 2x 3rd number to fill gap
    faces[74] = new int[] { 26,  2, 12, 12, 12 };  //added 2x 3rd number to fill gap
    faces[75] = new int[] { 27,  3, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[76] = new int[] { 28,  4, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[77] = new int[] { 29,  5, 17, 17, 17 };  //added 2x 3rd number to fill gap
    faces[78] = new int[] { 30,  6, 18, 18, 18 };  //added 2x 3rd number to fill gap
    faces[79] = new int[] { 31,  7, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[80] = new int[] { 32,  8, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[81] = new int[] { 33,  9, 20, 20, 20 };  //added 2x 3rd number to fill gap
    faces[82] = new int[] { 34, 10, 23, 23, 23 };  //added 2x 3rd number to fill gap
    faces[83] = new int[] { 35, 11, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[84] = new int[] { 36, 44, 40, 40, 40 };  //added 2x 3rd number to fill gap
    faces[85] = new int[] { 37, 45, 41, 41, 41 };  //added 2x 3rd number to fill gap
    faces[86] = new int[] { 38, 46, 42, 42, 42 };  //added 2x 3rd number to fill gap
    faces[87] = new int[] { 39, 47, 43, 43, 43 };  //added 2x 3rd number to fill gap
    faces[88] = new int[] { 48, 52, 56, 56, 56 };  //added 2x 3rd number to fill gap
    faces[89] = new int[] { 49, 53, 57, 57, 57 };  //added 2x 3rd number to fill gap
    faces[90] = new int[] { 50, 54, 58, 58, 58 };  //added 2x 3rd number to fill gap
    faces[91] = new int[] { 51, 55, 59, 59, 59 };  //added 2x 3rd number to fill gap
  } //end SnubDodecahedron()

  public String name() {
    return "Snub Dodecahedron (laevo)";
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
   
} //end class SnubDodecahedron
/*
SnubIcosidodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubIcosidodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 104;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.105398765906697216676314189282f; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C1  = 0.139623637868037118589881535187f; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 3840*(x^4) - 1792*(x^3) + 480*(x^2) - 60*x + 1
  final float C2  = 0.184961940339626297836961737414f; //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) - 1024*(x^4) + 64*(x^3) + 80*(x^2) - 32*x + 1
  final float C3  = 0.245022403774734335266195724469f; //square-root of a root of the polynomial:  4096*(x^6) - 2048*(x^5) - 1536*(x^4) - 704*(x^3) - 96*(x^2) - 8*x + 1
  final float C4  = 0.410877732043017261285800591418f; //sqrt(6 * (12 - cbrt(12*(9 + sqrt(69))) - cbrt(12*(9 - sqrt(69))))) / 12
  final float C5  = 0.438898343962682737883306417824f; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C6  = 0.525190497798036582742263736641f; //square-root of a root of the polynomial:  4096*(x^6) - 7168*(x^5) + 5120*(x^4) - 1664*(x^3) + 96*(x^2) + 24*x + 1
  final float C7  = 0.544297109869379954559620607106f; //sqrt(6*(2+cbrt(4*(101 + 15*sqrt(69)))-cbrt(4*(15*sqrt(69) - 101)))) / 12
  final float C8  = 0.581416517652346986253630835588f; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 3840*(x^4) - 1792*(x^3) + 480*(x^2) - 60*x + 1
  final float C9  = 0.695729283407366307710093980810f; //square-root of a root of the polynomial:  4096*(x^6) - 10240*(x^5) + 8960*(x^4) - 3648*(x^3) + 640*(x^2) - 20*x + 1
  final float C10 = 0.770212901572770918008459461110f; //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) - 1024*(x^4) + 64*(x^3) + 80*(x^2) - 32*x + 1
  final float C11 = 0.835352921275403426299975515997f; //square-root of a root of the polynomial:  4096*(x^6) - 7168*(x^5) + 5120*(x^4) - 1664*(x^3) + 96*(x^2) + 24*x + 1
  final float C12 = 0.955174841912397215845421198524f; //sqrt(3 * (3 + cbrt(12 * (9 + sqrt(69))) + cbrt(12 * (9 - sqrt(69))))) / 6
  final float C13 = 1.02031486161502972413693725341f;  //square-root of a root of the polynomial:  4096*(x^6) - 2048*(x^5) - 1536*(x^4) - 704*(x^3) - 96*(x^2) - 8*x + 1
  final float C14 = 1.10660701545038356899589457223f;  //square-root of a root of the polynomial:  4096*(x^6) - 10240*(x^5) + 8960*(x^4) - 3648*(x^3) + 640*(x^2) - 20*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubIcosidodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  -C2,  C14 );
    vert[  1] = new PVector(   C0,   C2, -C14 );
    vert[  2] = new PVector(  -C0,   C2,  C14 );
    vert[  3] = new PVector(  -C0,  -C2, -C14 );
    vert[  4] = new PVector(  C14,  -C0,   C2 );
    vert[  5] = new PVector(  C14,   C0,  -C2 );
    vert[  6] = new PVector( -C14,   C0,   C2 );
    vert[  7] = new PVector( -C14,  -C0,  -C2 );
    vert[  8] = new PVector(   C2, -C14,   C0 );
    vert[  9] = new PVector(   C2,  C14,  -C0 );
    vert[ 10] = new PVector(  -C2,  C14,   C0 );
    vert[ 11] = new PVector(  -C2, -C14,  -C0 );
    vert[ 12] = new PVector(   C3,   C4,  C13 );
    vert[ 13] = new PVector(   C3,  -C4, -C13 );
    vert[ 14] = new PVector(  -C3,  -C4,  C13 );
    vert[ 15] = new PVector(  -C3,   C4, -C13 );
    vert[ 16] = new PVector(  C13,   C3,   C4 );
    vert[ 17] = new PVector(  C13,  -C3,  -C4 );
    vert[ 18] = new PVector( -C13,  -C3,   C4 );
    vert[ 19] = new PVector( -C13,   C3,  -C4 );
    vert[ 20] = new PVector(   C4,  C13,   C3 );
    vert[ 21] = new PVector(   C4, -C13,  -C3 );
    vert[ 22] = new PVector(  -C4, -C13,   C3 );
    vert[ 23] = new PVector(  -C4,  C13,  -C3 );
    vert[ 24] = new PVector(   C1,  -C8,  C12 );
    vert[ 25] = new PVector(   C1,   C8, -C12 );
    vert[ 26] = new PVector(  -C1,   C8,  C12 );
    vert[ 27] = new PVector(  -C1,  -C8, -C12 );
    vert[ 28] = new PVector(  C12,  -C1,   C8 );
    vert[ 29] = new PVector(  C12,   C1,  -C8 );
    vert[ 30] = new PVector( -C12,   C1,   C8 );
    vert[ 31] = new PVector( -C12,  -C1,  -C8 );
    vert[ 32] = new PVector(   C8, -C12,   C1 );
    vert[ 33] = new PVector(   C8,  C12,  -C1 );
    vert[ 34] = new PVector(  -C8,  C12,   C1 );
    vert[ 35] = new PVector(  -C8, -C12,  -C1 );
    vert[ 36] = new PVector(   C7,  -C6,  C11 );
    vert[ 37] = new PVector(   C7,   C6, -C11 );
    vert[ 38] = new PVector(  -C7,   C6,  C11 );
    vert[ 39] = new PVector(  -C7,  -C6, -C11 );
    vert[ 40] = new PVector(  C11,  -C7,   C6 );
    vert[ 41] = new PVector(  C11,   C7,  -C6 );
    vert[ 42] = new PVector( -C11,   C7,   C6 );
    vert[ 43] = new PVector( -C11,  -C7,  -C6 );
    vert[ 44] = new PVector(   C6, -C11,   C7 );
    vert[ 45] = new PVector(   C6,  C11,  -C7 );
    vert[ 46] = new PVector(  -C6,  C11,   C7 );
    vert[ 47] = new PVector(  -C6, -C11,  -C7 );
    vert[ 48] = new PVector(   C5,   C9,  C10 );
    vert[ 49] = new PVector(   C5,  -C9, -C10 );
    vert[ 50] = new PVector(  -C5,  -C9,  C10 );
    vert[ 51] = new PVector(  -C5,   C9, -C10 );
    vert[ 52] = new PVector(  C10,   C5,   C9 );
    vert[ 53] = new PVector(  C10,  -C5,  -C9 );
    vert[ 54] = new PVector( -C10,  -C5,   C9 );
    vert[ 55] = new PVector( -C10,   C5,  -C9 );
    vert[ 56] = new PVector(   C9,  C10,   C5 );
    vert[ 57] = new PVector(   C9, -C10,  -C5 );
    vert[ 58] = new PVector(  -C9, -C10,   C5 );
    vert[ 59] = new PVector(  -C9,  C10,  -C5 );
    // set faces
    faces[  0] = new int[] {  0, 52, 36, 12, 28 };
    faces[  1] = new int[] {  1, 53, 37, 13, 29 };
    faces[  2] = new int[] {  2, 54, 38, 14, 30 };
    faces[  3] = new int[] {  3, 55, 39, 15, 31 };
    faces[  4] = new int[] {  4, 57, 40, 17, 32 };
    faces[  5] = new int[] {  5, 56, 41, 16, 33 };
    faces[  6] = new int[] {  6, 59, 42, 19, 34 };
    faces[  7] = new int[] {  7, 58, 43, 18, 35 };
    faces[  8] = new int[] {  8, 50, 44, 22, 24 };
    faces[  9] = new int[] {  9, 51, 45, 23, 25 };
    faces[ 10] = new int[] { 10, 48, 46, 20, 26 };
    faces[ 11] = new int[] { 11, 49, 47, 21, 27 };
    faces[ 12] = new int[] {  0, 54, 35, 21, 40 };
    faces[ 13] = new int[] {  1, 55, 34, 20, 41 };
    faces[ 14] = new int[] {  2, 52, 33, 23, 42 };
    faces[ 15] = new int[] {  3, 53, 32, 22, 43 };
    faces[ 16] = new int[] {  4, 56, 26, 14, 44 };
    faces[ 17] = new int[] {  5, 57, 27, 15, 45 };
    faces[ 18] = new int[] {  6, 58, 24, 12, 46 };
    faces[ 19] = new int[] {  7, 59, 25, 13, 47 };
    faces[ 20] = new int[] {  8, 49, 29, 16, 36 };
    faces[ 21] = new int[] {  9, 48, 28, 17, 37 };
    faces[ 22] = new int[] { 10, 51, 31, 18, 38 };
    faces[ 23] = new int[] { 11, 50, 30, 19, 39 };
    faces[ 24] = new int[] {  0, 28, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] {  1, 29, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] {  2, 30, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] {  3, 31, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] {  4, 32, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] {  5, 33, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] {  6, 34, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] {  7, 35, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] {  8, 24, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] {  9, 25, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 10, 26, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 11, 27, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 12, 20, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 13, 21, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 14, 22, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 15, 23, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 16, 12, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 17, 13, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 18, 14, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 19, 15, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 20, 16, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 21, 17, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 22, 18, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 23, 19, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 24, 28, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 25, 29, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 26, 30, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 27, 31, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 28, 32, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 29, 33, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 30, 34, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 31, 35, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 32, 24, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 33, 25, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 34, 26, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 35, 27, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 36, 50,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 37, 51,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 38, 48, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 39, 49, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 40, 52,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 41, 53,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 42, 54,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 43, 55,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 44, 57,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 45, 56,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 46, 59,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 47, 58,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 48,  9, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 49,  8, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 50, 11, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 51, 10, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 52,  2, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 53,  3, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 54,  0, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 55,  1, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 56,  4, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 57,  5, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 58,  6, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 59,  7, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] {  0, 48, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] {  1, 49, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] {  2, 50, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] {  3, 51, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] {  4, 53, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] {  5, 52, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] {  6, 55, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] {  7, 54, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] {  8, 58, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] {  9, 59, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] { 10, 56, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] { 11, 57, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] { 12, 16, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] { 13, 17, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] { 14, 18, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] { 15, 19, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 24, 32, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 25, 33, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 26, 34, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 27, 35, 31, 31, 31 };  //added 2x 3rd row to fill gaps
  } //end SnubIcosidodecadodecahedron()

  public String name() {
    return "Snub Icosidodecadodecahedron";
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
   
} //end class SnubIcosidodecadodecahedron
/*
StellatedTruncatedHexahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class StellatedTruncatedHexahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 0.2071067811865475244008443621048f;  //(sqrt(2) - 1) / 2
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private StellatedTruncatedHexahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C0,  0.5f,  -C0 );
    vert[  1] = new PVector(  -C0,  0.5f,   C0 );
    vert[  2] = new PVector(  -C0, -0.5f,  -C0 );
    vert[  3] = new PVector(  -C0, -0.5f,   C0 );
    vert[  4] = new PVector(   C0,  0.5f,  -C0 );
    vert[  5] = new PVector(   C0,  0.5f,   C0 );
    vert[  6] = new PVector(   C0, -0.5f,  -C0 );
    vert[  7] = new PVector(   C0, -0.5f,   C0 );
    vert[  8] = new PVector(  -C0,  -C0,  0.5f );
    vert[  9] = new PVector(  -C0,  -C0, -0.5f );
    vert[ 10] = new PVector(  -C0,   C0,  0.5f );
    vert[ 11] = new PVector(  -C0,   C0, -0.5f );
    vert[ 12] = new PVector(   C0,  -C0,  0.5f );
    vert[ 13] = new PVector(   C0,  -C0, -0.5f );
    vert[ 14] = new PVector(   C0,   C0,  0.5f );
    vert[ 15] = new PVector(   C0,   C0, -0.5f );
    vert[ 16] = new PVector(  0.5f,  -C0,  -C0 );
    vert[ 17] = new PVector(  0.5f,  -C0,   C0 );
    vert[ 18] = new PVector(  0.5f,   C0,  -C0 );
    vert[ 19] = new PVector(  0.5f,   C0,   C0 );
    vert[ 20] = new PVector( -0.5f,  -C0,  -C0 );
    vert[ 21] = new PVector( -0.5f,  -C0,   C0 );
    vert[ 22] = new PVector( -0.5f,   C0,  -C0 );
    vert[ 23] = new PVector( -0.5f,   C0,   C0 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 10, 11,  3,  1,  9,  8 };
    faces[ 1] = new int[] {  0, 16, 20,  4,  6, 22, 18,  2 };
    faces[ 2] = new int[] { 12, 13,  5,  7, 15, 14,  6,  4 };
    faces[ 3] = new int[] { 12, 20, 16,  8,  9, 17, 21, 13 };
    faces[ 4] = new int[] { 19, 23,  7,  5, 21, 17,  1,  3 };
    faces[ 5] = new int[] { 19, 11, 10, 18, 22, 14, 15, 23 };
    faces[ 6] = new int[] {  0,  8, 16, 16, 16, 16, 16, 16 }; //repeat 5x 3rd line to fill gaps
    faces[ 7] = new int[] {  1, 17,  9,  9,  9,  9,  9,  9 }; //repeat 5x 3rd line to fill gaps
    faces[ 8] = new int[] {  2, 18, 10, 10, 10, 10, 10, 10 }; //repeat 5x 3rd line to fill gaps
    faces[ 9] = new int[] {  3, 11, 19, 19, 19, 19, 19, 19 }; //repeat 5x 3rd line to fill gaps
    faces[10] = new int[] {  4, 20, 12, 12, 12, 12, 12, 12 }; //repeat 5x 3rd line to fill gaps
    faces[11] = new int[] {  5, 13, 21, 21, 21, 21, 21, 21 }; //repeat 5x 3rd line to fill gaps
    faces[12] = new int[] {  6, 14, 22, 22, 22, 22, 22, 22 }; //repeat 5x 3rd line to fill gaps
    faces[13] = new int[] {  7, 23, 15, 15, 15, 15, 15, 15 }; //repeat 5x 3rd line to fill gaps
  } //end StellatedTruncatedHexahedron()

  public String name() {
    return "Stellated Truncated Hexahedron";
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
   
} //end class StellatedTruncatedHexahedron
/*
TetradyakisHexahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TetradyakisHexahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 48;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 1.24264068711928514640506617263f;   //3 * (sqrt(2) - 1)
  final float C1 = 7.24264068711928514640506617263f;   //3 * (1 + sqrt(2))
  private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TetradyakisHexahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,  0.0f,   C1 );
    vert[  1] = new PVector(  0.0f,  0.0f,  -C1 );
    vert[  2] = new PVector(   C1,  0.0f,  0.0f );
    vert[  3] = new PVector(  -C1,  0.0f,  0.0f );
    vert[  4] = new PVector(  0.0f,   C1,  0.0f );
    vert[  5] = new PVector(  0.0f,  -C1,  0.0f );
    vert[  6] = new PVector(  0.0f,  0.0f,   C0 );
    vert[  7] = new PVector(  0.0f,  0.0f,  -C0 );
    vert[  8] = new PVector(   C0,  0.0f,  0.0f );
    vert[  9] = new PVector(  -C0,  0.0f,  0.0f );
    vert[ 10] = new PVector(  0.0f,   C0,  0.0f );
    vert[ 11] = new PVector(  0.0f,  -C0,  0.0f );
    vert[ 12] = new PVector(  1.0f,  1.0f,  1.0f );
    vert[ 13] = new PVector(  1.0f,  1.0f, -1.0f );
    vert[ 14] = new PVector(  1.0f, -1.0f,  1.0f );
    vert[ 15] = new PVector(  1.0f, -1.0f, -1.0f );
    vert[ 16] = new PVector( -1.0f,  1.0f,  1.0f );
    vert[ 17] = new PVector( -1.0f,  1.0f, -1.0f );
    vert[ 18] = new PVector( -1.0f, -1.0f,  1.0f );
    vert[ 19] = new PVector( -1.0f, -1.0f, -1.0f );
    // set faces
    faces[  0] = new int[] { 0,  8, 13 };
    faces[  1] = new int[] { 0, 13, 10 };
    faces[  2] = new int[] { 0, 10, 17 };
    faces[  3] = new int[] { 0, 17,  9 };
    faces[  4] = new int[] { 0,  9, 19 };
    faces[  5] = new int[] { 0, 19, 11 };
    faces[  6] = new int[] { 0, 11, 15 };
    faces[  7] = new int[] { 0, 15,  8 };
    faces[  8] = new int[] { 1,  8, 14 };
    faces[  9] = new int[] { 1, 14, 11 };
    faces[ 10] = new int[] { 1, 11, 18 };
    faces[ 11] = new int[] { 1, 18,  9 };
    faces[ 12] = new int[] { 1,  9, 16 };
    faces[ 13] = new int[] { 1, 16, 10 };
    faces[ 14] = new int[] { 1, 10, 12 };
    faces[ 15] = new int[] { 1, 12,  8 };
    faces[ 16] = new int[] { 2,  6, 18 };
    faces[ 17] = new int[] { 2, 18, 11 };
    faces[ 18] = new int[] { 2, 11, 19 };
    faces[ 19] = new int[] { 2, 19,  7 };
    faces[ 20] = new int[] { 2,  7, 17 };
    faces[ 21] = new int[] { 2, 17, 10 };
    faces[ 22] = new int[] { 2, 10, 16 };
    faces[ 23] = new int[] { 2, 16,  6 };
    faces[ 24] = new int[] { 3,  6, 12 };
    faces[ 25] = new int[] { 3, 12, 10 };
    faces[ 26] = new int[] { 3, 10, 13 };
    faces[ 27] = new int[] { 3, 13,  7 };
    faces[ 28] = new int[] { 3,  7, 15 };
    faces[ 29] = new int[] { 3, 15, 11 };
    faces[ 30] = new int[] { 3, 11, 14 };
    faces[ 31] = new int[] { 3, 14,  6 };
    faces[ 32] = new int[] { 4,  6, 14 };
    faces[ 33] = new int[] { 4, 14,  8 };
    faces[ 34] = new int[] { 4,  8, 15 };
    faces[ 35] = new int[] { 4, 15,  7 };
    faces[ 36] = new int[] { 4,  7, 19 };
    faces[ 37] = new int[] { 4, 19,  9 };
    faces[ 38] = new int[] { 4,  9, 18 };
    faces[ 39] = new int[] { 4, 18,  6 };
    faces[ 40] = new int[] { 5,  6, 16 };
    faces[ 41] = new int[] { 5, 16,  9 };
    faces[ 42] = new int[] { 5,  9, 17 };
    faces[ 43] = new int[] { 5, 17,  7 };
    faces[ 44] = new int[] { 5,  7, 13 };
    faces[ 45] = new int[] { 5, 13,  8 };
    faces[ 46] = new int[] { 5,  8, 12 };
    faces[ 47] = new int[] { 5, 12,  6 };
  } //end TetradyakisHexahedron()

  public String name() {
    return "Tetradyakis Hexahedron";
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
   
} //end class TetradyakisHexahedron
/*
Tetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Tetrahedron extends Polyhedron {

  // polyhedron
  final int FACES = 4;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.353553390593273762200422181052f; // sqrt(2) / 4
  private PVector[] vert = new PVector[20]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Tetrahedron() {   
    // set vertices
    vert[ 0] = new PVector( C0, -C0,  C0);
    vert[ 1] = new PVector( C0,  C0, -C0);
    vert[ 2] = new PVector(-C0,  C0,  C0);
    vert[ 3] = new PVector(-C0, -C0, -C0);
    // set faces
    faces[ 0] = new int[] {0, 1, 2};
    faces[ 1] = new int[] {1, 0, 3};
    faces[ 2] = new int[] {2, 3, 0};
    faces[ 3] = new int[] {3, 2, 1};
  } //end Tetrahedron()

  public String name() {
    return "Tetrahedron";
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
  
} //end class Tetrahedron
/*
Tetrahemihexahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Tetrahemihexahedron extends Polyhedron {

  // polyhedron
  final int FACES = 7;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048f; //sqrt(2) / 2
  private PVector[] vert = new PVector[28]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Tetrahemihexahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.0f,  0.0f,   C0);
    vert[ 1] = new PVector( 0.0f,  0.0f,  -C0);
    vert[ 2] = new PVector(  C0,  0.0f,  0.0f);
    vert[ 3] = new PVector( -C0,  0.0f,  0.0f);
    vert[ 4] = new PVector( 0.0f,   C0,  0.0f);
    vert[ 5] = new PVector( 0.0f,  -C0,  0.0f);
    // set faces
    faces[ 0] = new int[] { 0,  2,  1,  3};
    faces[ 1] = new int[] { 0,  5,  1,  4};
    faces[ 2] = new int[] { 2,  4,  3,  5};
    faces[ 3] = new int[] { 0,  2,  4,  4}; //added 1x 3rd number to fill gap
    faces[ 4] = new int[] { 0,  3,  5,  5}; //added 1x 3rd number to fill gap
    faces[ 5] = new int[] { 1,  2,  5,  5}; //added 1x 3rd number to fill gap
    faces[ 6] = new int[] { 1,  3,  4,  4}; //added 1x 3rd number to fill gap
  } //end Tetrahemihexahedron()

  public String name() {
    return "Tetrahemihexahedron";
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

} //end class Tetrahemihexahedron
/*
TridyakisIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TridyakisIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 120;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.772542485937368560255733542957f;  //5 * (sqrt(5) - 1) / 8
  final float C1 = 1.03647450843757886384655987423f;   //3 * (5 - sqrt(5)) / 8
  final float C2 = 1.677050983124842272306880251548f;  //3 * sqrt(5) / 4
  final float C3 = 2.02254248593736856025573354296f;   //5 * (1 + sqrt(5)) / 8
  final float C4 = 2.71352549156242113615344012577f;   //3 * (5 + sqrt(5)) / 8
  private PVector[] vert = new PVector[44]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TridyakisIcosahedron() {   
    // set vertices
    vert[  0] = new PVector(    C2,   0.0f,    C4 );
    vert[  1] = new PVector(    C2,   0.0f,   -C4 );
    vert[  2] = new PVector(   -C2,   0.0f,    C4 );
    vert[  3] = new PVector(   -C2,   0.0f,   -C4 );
    vert[  4] = new PVector(    C4,    C2,   0.0f );
    vert[  5] = new PVector(    C4,   -C2,   0.0f );
    vert[  6] = new PVector(   -C4,    C2,   0.0f );
    vert[  7] = new PVector(   -C4,   -C2,   0.0f );
    vert[  8] = new PVector(   0.0f,    C4,    C2 );
    vert[  9] = new PVector(   0.0f,    C4,   -C2 );
    vert[ 10] = new PVector(   0.0f,   -C4,    C2 );
    vert[ 11] = new PVector(   0.0f,   -C4,   -C2 );
    vert[ 12] = new PVector(   0.0f,    C0,    C3 );
    vert[ 13] = new PVector(   0.0f,    C0,   -C3 );
    vert[ 14] = new PVector(   0.0f,   -C0,    C3 );
    vert[ 15] = new PVector(   0.0f,   -C0,   -C3 );
    vert[ 16] = new PVector(    C3,   0.0f,    C0 );
    vert[ 17] = new PVector(    C3,   0.0f,   -C0 );
    vert[ 18] = new PVector(   -C3,   0.0f,    C0 );
    vert[ 19] = new PVector(   -C3,   0.0f,   -C0 );
    vert[ 20] = new PVector(    C0,    C3,   0.0f );
    vert[ 21] = new PVector(    C0,   -C3,   0.0f );
    vert[ 22] = new PVector(   -C0,    C3,   0.0f );
    vert[ 23] = new PVector(   -C0,   -C3,   0.0f );
    vert[ 24] = new PVector(    C1,   0.0f,    C2 );
    vert[ 25] = new PVector(    C1,   0.0f,   -C2 );
    vert[ 26] = new PVector(   -C1,   0.0f,    C2 );
    vert[ 27] = new PVector(   -C1,   0.0f,   -C2 );
    vert[ 28] = new PVector(    C2,    C1,   0.0f );
    vert[ 29] = new PVector(    C2,   -C1,   0.0f );
    vert[ 30] = new PVector(   -C2,    C1,   0.0f );
    vert[ 31] = new PVector(   -C2,   -C1,   0.0f );
    vert[ 32] = new PVector(   0.0f,    C2,    C1 );
    vert[ 33] = new PVector(   0.0f,    C2,   -C1 );
    vert[ 34] = new PVector(   0.0f,   -C2,    C1 );
    vert[ 35] = new PVector(   0.0f,   -C2,   -C1 );
    vert[ 36] = new PVector(  1.25f,  1.25f,  1.25f );
    vert[ 37] = new PVector(  1.25f,  1.25f, -1.25f );
    vert[ 38] = new PVector(  1.25f, -1.25f,  1.25f );
    vert[ 39] = new PVector(  1.25f, -1.25f, -1.25f );
    vert[ 40] = new PVector( -1.25f,  1.25f,  1.25f );
    vert[ 41] = new PVector( -1.25f,  1.25f, -1.25f );
    vert[ 42] = new PVector( -1.25f, -1.25f,  1.25f );
    vert[ 43] = new PVector( -1.25f, -1.25f, -1.25f );
    // set faces
    faces[  0] = new int[] {  0, 17, 28 };
    faces[  1] = new int[] {  0, 28, 20 };
    faces[  2] = new int[] {  0, 20, 32 };
    faces[  3] = new int[] {  0, 32, 40 };
    faces[  4] = new int[] {  0, 40, 26 };
    faces[  5] = new int[] {  0, 26, 42 };
    faces[  6] = new int[] {  0, 42, 34 };
    faces[  7] = new int[] {  0, 34, 21 };
    faces[  8] = new int[] {  0, 21, 29 };
    faces[  9] = new int[] {  0, 29, 17 };
    faces[ 10] = new int[] {  1, 16, 29 };
    faces[ 11] = new int[] {  1, 29, 21 };
    faces[ 12] = new int[] {  1, 21, 35 };
    faces[ 13] = new int[] {  1, 35, 43 };
    faces[ 14] = new int[] {  1, 43, 27 };
    faces[ 15] = new int[] {  1, 27, 41 };
    faces[ 16] = new int[] {  1, 41, 33 };
    faces[ 17] = new int[] {  1, 33, 20 };
    faces[ 18] = new int[] {  1, 20, 28 };
    faces[ 19] = new int[] {  1, 28, 16 };
    faces[ 20] = new int[] {  2, 19, 31 };
    faces[ 21] = new int[] {  2, 31, 23 };
    faces[ 22] = new int[] {  2, 23, 34 };
    faces[ 23] = new int[] {  2, 34, 38 };
    faces[ 24] = new int[] {  2, 38, 24 };
    faces[ 25] = new int[] {  2, 24, 36 };
    faces[ 26] = new int[] {  2, 36, 32 };
    faces[ 27] = new int[] {  2, 32, 22 };
    faces[ 28] = new int[] {  2, 22, 30 };
    faces[ 29] = new int[] {  2, 30, 19 };
    faces[ 30] = new int[] {  3, 18, 30 };
    faces[ 31] = new int[] {  3, 30, 22 };
    faces[ 32] = new int[] {  3, 22, 33 };
    faces[ 33] = new int[] {  3, 33, 37 };
    faces[ 34] = new int[] {  3, 37, 25 };
    faces[ 35] = new int[] {  3, 25, 39 };
    faces[ 36] = new int[] {  3, 39, 35 };
    faces[ 37] = new int[] {  3, 35, 23 };
    faces[ 38] = new int[] {  3, 23, 31 };
    faces[ 39] = new int[] {  3, 31, 18 };
    faces[ 40] = new int[] {  4, 12, 24 };
    faces[ 41] = new int[] {  4, 24, 38 };
    faces[ 42] = new int[] {  4, 38, 29 };
    faces[ 43] = new int[] {  4, 29, 39 };
    faces[ 44] = new int[] {  4, 39, 25 };
    faces[ 45] = new int[] {  4, 25, 13 };
    faces[ 46] = new int[] {  4, 13, 33 };
    faces[ 47] = new int[] {  4, 33, 22 };
    faces[ 48] = new int[] {  4, 22, 32 };
    faces[ 49] = new int[] {  4, 32, 12 };
    faces[ 50] = new int[] {  5, 14, 34 };
    faces[ 51] = new int[] {  5, 34, 23 };
    faces[ 52] = new int[] {  5, 23, 35 };
    faces[ 53] = new int[] {  5, 35, 15 };
    faces[ 54] = new int[] {  5, 15, 25 };
    faces[ 55] = new int[] {  5, 25, 37 };
    faces[ 56] = new int[] {  5, 37, 28 };
    faces[ 57] = new int[] {  5, 28, 36 };
    faces[ 58] = new int[] {  5, 36, 24 };
    faces[ 59] = new int[] {  5, 24, 14 };
    faces[ 60] = new int[] {  6, 12, 32 };
    faces[ 61] = new int[] {  6, 32, 20 };
    faces[ 62] = new int[] {  6, 20, 33 };
    faces[ 63] = new int[] {  6, 33, 13 };
    faces[ 64] = new int[] {  6, 13, 27 };
    faces[ 65] = new int[] {  6, 27, 43 };
    faces[ 66] = new int[] {  6, 43, 31 };
    faces[ 67] = new int[] {  6, 31, 42 };
    faces[ 68] = new int[] {  6, 42, 26 };
    faces[ 69] = new int[] {  6, 26, 12 };
    faces[ 70] = new int[] {  7, 14, 26 };
    faces[ 71] = new int[] {  7, 26, 40 };
    faces[ 72] = new int[] {  7, 40, 30 };
    faces[ 73] = new int[] {  7, 30, 41 };
    faces[ 74] = new int[] {  7, 41, 27 };
    faces[ 75] = new int[] {  7, 27, 15 };
    faces[ 76] = new int[] {  7, 15, 35 };
    faces[ 77] = new int[] {  7, 35, 21 };
    faces[ 78] = new int[] {  7, 21, 34 };
    faces[ 79] = new int[] {  7, 34, 14 };
    faces[ 80] = new int[] {  8, 14, 24 };
    faces[ 81] = new int[] {  8, 24, 16 };
    faces[ 82] = new int[] {  8, 16, 28 };
    faces[ 83] = new int[] {  8, 28, 37 };
    faces[ 84] = new int[] {  8, 37, 33 };
    faces[ 85] = new int[] {  8, 33, 41 };
    faces[ 86] = new int[] {  8, 41, 30 };
    faces[ 87] = new int[] {  8, 30, 18 };
    faces[ 88] = new int[] {  8, 18, 26 };
    faces[ 89] = new int[] {  8, 26, 14 };
    faces[ 90] = new int[] {  9, 15, 27 };
    faces[ 91] = new int[] {  9, 27, 19 };
    faces[ 92] = new int[] {  9, 19, 30 };
    faces[ 93] = new int[] {  9, 30, 40 };
    faces[ 94] = new int[] {  9, 40, 32 };
    faces[ 95] = new int[] {  9, 32, 36 };
    faces[ 96] = new int[] {  9, 36, 28 };
    faces[ 97] = new int[] {  9, 28, 17 };
    faces[ 98] = new int[] {  9, 17, 25 };
    faces[ 99] = new int[] {  9, 25, 15 };
    faces[100] = new int[] { 10, 12, 26 };
    faces[101] = new int[] { 10, 26, 18 };
    faces[102] = new int[] { 10, 18, 31 };
    faces[103] = new int[] { 10, 31, 43 };
    faces[104] = new int[] { 10, 43, 35 };
    faces[105] = new int[] { 10, 35, 39 };
    faces[106] = new int[] { 10, 39, 29 };
    faces[107] = new int[] { 10, 29, 16 };
    faces[108] = new int[] { 10, 16, 24 };
    faces[109] = new int[] { 10, 24, 12 };
    faces[110] = new int[] { 11, 13, 25 };
    faces[111] = new int[] { 11, 25, 17 };
    faces[112] = new int[] { 11, 17, 29 };
    faces[113] = new int[] { 11, 29, 38 };
    faces[114] = new int[] { 11, 38, 34 };
    faces[115] = new int[] { 11, 34, 42 };
    faces[116] = new int[] { 11, 42, 31 };
    faces[117] = new int[] { 11, 31, 19 };
    faces[118] = new int[] { 11, 19, 27 };
    faces[119] = new int[] { 11, 27, 13 };
  } //end TridyakisIcosahedron()

  public String name() {
    return "Tridyakis Icosahedron";
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
   
} //end class TridyakisIcosahedron
/*
TruncatedCube class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedCube extends Polyhedron {
  
  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 1.20710678118654752440084436210f; //(1 + sqrt(2)) / 2
  private PVector[] vert = new PVector[24]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedCube() {   
    // set vertices
    vert[ 0] = new PVector(   C0,  0.5f,   C0 );
    vert[ 1] = new PVector(   C0,  0.5f,  -C0 );
    vert[ 2] = new PVector(   C0, -0.5f,   C0 );
    vert[ 3] = new PVector(   C0, -0.5f,  -C0 );
    vert[ 4] = new PVector(  -C0,  0.5f,   C0 );
    vert[ 5] = new PVector(  -C0,  0.5f,  -C0 );
    vert[ 6] = new PVector(  -C0, -0.5f,   C0 );
    vert[ 7] = new PVector(  -C0, -0.5f,  -C0 );
    vert[ 8] = new PVector(   C0,   C0,  0.5f );
    vert[ 9] = new PVector(   C0,   C0, -0.5f );
    vert[10] = new PVector(   C0,  -C0,  0.5f );
    vert[11] = new PVector(   C0,  -C0, -0.5f );
    vert[12] = new PVector(  -C0,   C0,  0.5f );
    vert[13] = new PVector(  -C0,   C0, -0.5f );
    vert[14] = new PVector(  -C0,  -C0,  0.5f );
    vert[15] = new PVector(  -C0,  -C0, -0.5f );
    vert[16] = new PVector(  0.5f,   C0,   C0 );
    vert[17] = new PVector(  0.5f,   C0,  -C0 );
    vert[18] = new PVector(  0.5f,  -C0,   C0 );
    vert[19] = new PVector(  0.5f,  -C0,  -C0 );
    vert[20] = new PVector( -0.5f,   C0,   C0 );
    vert[21] = new PVector( -0.5f,   C0,  -C0 );
    vert[22] = new PVector( -0.5f,  -C0,   C0 );
    vert[23] = new PVector( -0.5f,  -C0,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 10, 11,  3,  1,  9,  8 };
    faces[ 1] = new int[] {  0, 16, 20,  4,  6, 22, 18,  2 };
    faces[ 2] = new int[] { 12, 13,  5,  7, 15, 14,  6,  4 };
    faces[ 3] = new int[] { 12, 20, 16,  8,  9, 17, 21, 13 };
    faces[ 4] = new int[] { 19, 23,  7,  5, 21, 17,  1,  3 };
    faces[ 5] = new int[] { 19, 11, 10, 18, 22, 14, 15, 23 };
    faces[ 6] = new int[] {  0,  8, 16, 16, 16, 16, 16, 16 }; //added 5x 3rd number to fill gap
    faces[ 7] = new int[] {  1, 17,  9,  9,  9,  9,  9,  9 }; //added 5x 3rd number to fill gap
    faces[ 8] = new int[] {  2, 18, 10, 10, 10, 10, 10, 10 }; //added 5x 3rd number to fill gap
    faces[ 9] = new int[] {  3, 11, 19, 19, 19, 19, 19, 19 }; //added 5x 3rd number to fill gap
    faces[10] = new int[] {  4, 20, 12, 12, 12, 12, 12, 12 }; //added 5x 3rd number to fill gap
    faces[11] = new int[] {  5, 13, 21, 21, 21, 21, 21, 21 }; //added 5x 3rd number to fill gap
    faces[12] = new int[] {  6, 14, 22, 22, 22, 22, 22, 22 }; //added 5x 3rd number to fill gap
    faces[13] = new int[] {  7, 23, 15, 15, 15, 15, 15, 15 }; //added 5x 3rd number to fill gap
  } //end TruncatedCube()

  public String name() {
    return "Truncated Cube";
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
   
} //end class TruncatedCube
/*
TruncatedCuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedCuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 26;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 1.20710678118654752440084436210f;  //(1 + sqrt(2)) / 2
  final float C1 = 1.91421356237309504880168872421f;  //(1 + 2 * sqrt(2)) / 2
  private PVector[] vert = new PVector[48]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedCuboctahedron() {   
    // set vertices
    vert[ 0] = new PVector(   C0,  0.5f,   C1 );
    vert[ 1] = new PVector(   C0,  0.5f,  -C1 );
    vert[ 2] = new PVector(   C0, -0.5f,   C1 );
    vert[ 3] = new PVector(   C0, -0.5f,  -C1 );
    vert[ 4] = new PVector(  -C0,  0.5f,   C1 );
    vert[ 5] = new PVector(  -C0,  0.5f,  -C1 );
    vert[ 6] = new PVector(  -C0, -0.5f,   C1 );
    vert[ 7] = new PVector(  -C0, -0.5f,  -C1 );
    vert[ 8] = new PVector(   C1,   C0,  0.5f );
    vert[ 9] = new PVector(   C1,   C0, -0.5f );
    vert[10] = new PVector(   C1,  -C0,  0.5f );
    vert[11] = new PVector(   C1,  -C0, -0.5f );
    vert[12] = new PVector(  -C1,   C0,  0.5f );
    vert[13] = new PVector(  -C1,   C0, -0.5f );
    vert[14] = new PVector(  -C1,  -C0,  0.5f );
    vert[15] = new PVector(  -C1,  -C0, -0.5f );
    vert[16] = new PVector(  0.5f,   C1,   C0 );
    vert[17] = new PVector(  0.5f,   C1,  -C0 );
    vert[18] = new PVector(  0.5f,  -C1,   C0 );
    vert[19] = new PVector(  0.5f,  -C1,  -C0 );
    vert[20] = new PVector( -0.5f,   C1,   C0 );
    vert[21] = new PVector( -0.5f,   C1,  -C0 );
    vert[22] = new PVector( -0.5f,  -C1,   C0 );
    vert[23] = new PVector( -0.5f,  -C1,  -C0 );
    vert[24] = new PVector(  0.5f,   C0,   C1 );
    vert[25] = new PVector(  0.5f,   C0,  -C1 );
    vert[26] = new PVector(  0.5f,  -C0,   C1 );
    vert[27] = new PVector(  0.5f,  -C0,  -C1 );
    vert[28] = new PVector( -0.5f,   C0,   C1 );
    vert[29] = new PVector( -0.5f,   C0,  -C1 );
    vert[30] = new PVector( -0.5f,  -C0,   C1 );
    vert[31] = new PVector( -0.5f,  -C0,  -C1 );
    vert[32] = new PVector(   C1,  0.5f,   C0 );
    vert[33] = new PVector(   C1,  0.5f,  -C0 );
    vert[34] = new PVector(   C1, -0.5f,   C0 );
    vert[35] = new PVector(   C1, -0.5f,  -C0 );
    vert[36] = new PVector(  -C1,  0.5f,   C0 );
    vert[37] = new PVector(  -C1,  0.5f,  -C0 );
    vert[38] = new PVector(  -C1, -0.5f,   C0 );
    vert[39] = new PVector(  -C1, -0.5f,  -C0 );
    vert[40] = new PVector(   C0,   C1,  0.5f );
    vert[41] = new PVector(   C0,   C1, -0.5f );
    vert[42] = new PVector(   C0,  -C1,  0.5f );
    vert[43] = new PVector(   C0,  -C1, -0.5f );
    vert[44] = new PVector(  -C0,   C1,  0.5f );
    vert[45] = new PVector(  -C0,   C1, -0.5f );
    vert[46] = new PVector(  -C0,  -C1,  0.5f );
    vert[47] = new PVector(  -C0,  -C1, -0.5f );
    // set faces
    faces[ 0] = new int[] {  0, 24, 28,  4,  6, 30, 26,  2 };
    faces[ 1] = new int[] {  1,  3, 27, 31,  7,  5, 29, 25 };
    faces[ 2] = new int[] {  8, 32, 34, 10, 11, 35, 33,  9 };
    faces[ 3] = new int[] { 12, 13, 37, 39, 15, 14, 38, 36 };
    faces[ 4] = new int[] { 16, 40, 41, 17, 21, 45, 44, 20 };
    faces[ 5] = new int[] { 18, 22, 46, 47, 23, 19, 43, 42 };
    faces[ 6] = new int[] {  0, 32,  8, 40, 16, 24, 24, 24 }; //added 2x 6th number to fill gap
    faces[ 7] = new int[] {  1, 25, 17, 41,  9, 33, 33, 33 }; //added 2x 6th number to fill gap
    faces[ 8] = new int[] {  2, 26, 18, 42, 10, 34, 34, 34 }; //added 2x 6th number to fill gap
    faces[ 9] = new int[] {  3, 35, 11, 43, 19, 27, 27, 27 }; //added 2x 6th number to fill gap
    faces[10] = new int[] {  4, 28, 20, 44, 12, 36, 36, 36 }; //added 2x 6th number to fill gap
    faces[11] = new int[] {  5, 37, 13, 45, 21, 29, 29, 29 }; //added 2x 6th number to fill gap
    faces[12] = new int[] {  6, 38, 14, 46, 22, 30, 30, 30 }; //added 2x 6th number to fill gap
    faces[13] = new int[] {  7, 31, 23, 47, 15, 39, 39, 39 }; //added 2x 6th number to fill gap
    faces[14] = new int[] {  0,  2, 34, 32, 32, 32, 32, 32 }; //added 4x 4th number to fill gap
    faces[15] = new int[] {  1, 33, 35,  3,  3,  3,  3,  3 }; //added 4x 4th number to fill gap
    faces[16] = new int[] {  4, 36, 38,  6,  6,  6,  6,  6 }; //added 4x 4th number to fill gap
    faces[17] = new int[] {  5,  7, 39, 37, 37, 37, 37, 37 }; //added 4x 4th number to fill gap
    faces[18] = new int[] {  8,  9, 41, 40, 40, 40, 40, 40 }; //added 4x 4th number to fill gap
    faces[19] = new int[] { 10, 42, 43, 11, 11, 11, 11, 11 }; //added 4x 4th number to fill gap
    faces[20] = new int[] { 12, 44, 45, 13, 13, 13, 13, 13 }; //added 4x 4th number to fill gap
    faces[21] = new int[] { 14, 15, 47, 46, 46, 46, 46, 46 }; //added 4x 4th number to fill gap
    faces[22] = new int[] { 16, 20, 28, 24, 24, 24, 24, 24 }; //added 4x 4th number to fill gap
    faces[23] = new int[] { 17, 25, 29, 21, 21, 21, 21, 21 }; //added 4x 4th number to fill gap
    faces[24] = new int[] { 18, 26, 30, 22, 22, 22, 22, 22 }; //added 4x 4th number to fill gap
    faces[25] = new int[] { 19, 23, 31, 27, 27, 27, 27, 27 }; //added 4x 4th number to fill gap
  } //end TruncatedCuboctahedron()

  public String name() {
    return "Truncated Cuboctahedron";
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
   
} //end class TruncatedCuboctahedron
/*
TruncatedDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C1 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  final float C2 = 2.11803398874989484820458683437f;   //(2 + sqrt(5)) / 2
  final float C3 = 2.61803398874989484820458683437f;   //(3 + sqrt(5)) / 2
  final float C4 = 2.927050983124842272306880251548f;  //(5 + 3 * sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f,  0.5f,   C4 );
    vert[  1] = new PVector(  0.0f,  0.5f,  -C4 );
    vert[  2] = new PVector(  0.0f, -0.5f,   C4 );
    vert[  3] = new PVector(  0.0f, -0.5f,  -C4 );
    vert[  4] = new PVector(   C4,  0.0f,  0.5f );
    vert[  5] = new PVector(   C4,  0.0f, -0.5f );
    vert[  6] = new PVector(  -C4,  0.0f,  0.5f );
    vert[  7] = new PVector(  -C4,  0.0f, -0.5f );
    vert[  8] = new PVector(  0.5f,   C4,  0.0f );
    vert[  9] = new PVector(  0.5f,  -C4,  0.0f );
    vert[ 10] = new PVector( -0.5f,   C4,  0.0f );
    vert[ 11] = new PVector( -0.5f,  -C4,  0.0f );
    vert[ 12] = new PVector(  0.5f,   C0,   C3 );
    vert[ 13] = new PVector(  0.5f,   C0,  -C3 );
    vert[ 14] = new PVector(  0.5f,  -C0,   C3 );
    vert[ 15] = new PVector(  0.5f,  -C0,  -C3 );
    vert[ 16] = new PVector( -0.5f,   C0,   C3 );
    vert[ 17] = new PVector( -0.5f,   C0,  -C3 );
    vert[ 18] = new PVector( -0.5f,  -C0,   C3 );
    vert[ 19] = new PVector( -0.5f,  -C0,  -C3 );
    vert[ 20] = new PVector(   C3,  0.5f,   C0 );
    vert[ 21] = new PVector(   C3,  0.5f,  -C0 );
    vert[ 22] = new PVector(   C3, -0.5f,   C0 );
    vert[ 23] = new PVector(   C3, -0.5f,  -C0 );
    vert[ 24] = new PVector(  -C3,  0.5f,   C0 );
    vert[ 25] = new PVector(  -C3,  0.5f,  -C0 );
    vert[ 26] = new PVector(  -C3, -0.5f,   C0 );
    vert[ 27] = new PVector(  -C3, -0.5f,  -C0 );
    vert[ 28] = new PVector(   C0,   C3,  0.5f );
    vert[ 29] = new PVector(   C0,   C3, -0.5f );
    vert[ 30] = new PVector(   C0,  -C3,  0.5f );
    vert[ 31] = new PVector(   C0,  -C3, -0.5f );
    vert[ 32] = new PVector(  -C0,   C3,  0.5f );
    vert[ 33] = new PVector(  -C0,   C3, -0.5f );
    vert[ 34] = new PVector(  -C0,  -C3,  0.5f );
    vert[ 35] = new PVector(  -C0,  -C3, -0.5f );
    vert[ 36] = new PVector(   C0,   C1,   C2 );
    vert[ 37] = new PVector(   C0,   C1,  -C2 );
    vert[ 38] = new PVector(   C0,  -C1,   C2 );
    vert[ 39] = new PVector(   C0,  -C1,  -C2 );
    vert[ 40] = new PVector(  -C0,   C1,   C2 );
    vert[ 41] = new PVector(  -C0,   C1,  -C2 );
    vert[ 42] = new PVector(  -C0,  -C1,   C2 );
    vert[ 43] = new PVector(  -C0,  -C1,  -C2 );
    vert[ 44] = new PVector(   C2,   C0,   C1 );
    vert[ 45] = new PVector(   C2,   C0,  -C1 );
    vert[ 46] = new PVector(   C2,  -C0,   C1 );
    vert[ 47] = new PVector(   C2,  -C0,  -C1 );
    vert[ 48] = new PVector(  -C2,   C0,   C1 );
    vert[ 49] = new PVector(  -C2,   C0,  -C1 );
    vert[ 50] = new PVector(  -C2,  -C0,   C1 );
    vert[ 51] = new PVector(  -C2,  -C0,  -C1 );
    vert[ 52] = new PVector(   C1,   C2,   C0 );
    vert[ 53] = new PVector(   C1,   C2,  -C0 );
    vert[ 54] = new PVector(   C1,  -C2,   C0 );
    vert[ 55] = new PVector(   C1,  -C2,  -C0 );
    vert[ 56] = new PVector(  -C1,   C2,   C0 );
    vert[ 57] = new PVector(  -C1,   C2,  -C0 );
    vert[ 58] = new PVector(  -C1,  -C2,   C0 );
    vert[ 59] = new PVector(  -C1,  -C2,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 14, 38, 46, 22, 20, 44, 36, 12 };
    faces[ 1] = new int[] {  1,  3, 19, 43, 51, 27, 25, 49, 41, 17 };
    faces[ 2] = new int[] {  2,  0, 16, 40, 48, 24, 26, 50, 42, 18 };
    faces[ 3] = new int[] {  3,  1, 13, 37, 45, 21, 23, 47, 39, 15 };
    faces[ 4] = new int[] {  4,  5, 21, 45, 53, 29, 28, 52, 44, 20 };
    faces[ 5] = new int[] {  5,  4, 22, 46, 54, 30, 31, 55, 47, 23 };
    faces[ 6] = new int[] {  6,  7, 27, 51, 59, 35, 34, 58, 50, 26 };
    faces[ 7] = new int[] {  7,  6, 24, 48, 56, 32, 33, 57, 49, 25 };
    faces[ 8] = new int[] {  8, 10, 32, 56, 40, 16, 12, 36, 52, 28 };
    faces[ 9] = new int[] {  9, 11, 35, 59, 43, 19, 15, 39, 55, 31 };
    faces[10] = new int[] { 10,  8, 29, 53, 37, 13, 17, 41, 57, 33 };
    faces[11] = new int[] { 11,  9, 30, 54, 38, 14, 18, 42, 58, 34 };
    faces[12] = new int[] {  0, 12, 16, 16, 16, 16, 16, 16, 16, 16 };  //added 7x 3rd number to fill gap
    faces[13] = new int[] {  1, 17, 13, 13, 13, 13, 13, 13, 13, 13 };  //added 7x 3rd number to fill gap
    faces[14] = new int[] {  2, 18, 14, 14, 14, 14, 14, 14, 14, 14 };  //added 7x 3rd number to fill gap
    faces[15] = new int[] {  3, 15, 19, 19, 19, 19, 19, 19, 19, 19 };  //added 7x 3rd number to fill gap
    faces[16] = new int[] {  4, 20, 22, 22, 22, 22, 22, 22, 22, 22 };  //added 7x 3rd number to fill gap
    faces[17] = new int[] {  5, 23, 21, 21, 21, 21, 21, 21, 21, 21 };  //added 7x 3rd number to fill gap
    faces[18] = new int[] {  6, 26, 24, 24, 24, 24, 24, 24, 24, 24 };  //added 7x 3rd number to fill gap
    faces[19] = new int[] {  7, 25, 27, 27, 27, 27, 27, 27, 27, 27 };  //added 7x 3rd number to fill gap
    faces[20] = new int[] {  8, 28, 29, 29, 29, 29, 29, 29, 29, 29 };  //added 7x 3rd number to fill gap
    faces[21] = new int[] {  9, 31, 30, 30, 30, 30, 30, 30, 30, 30 };  //added 7x 3rd number to fill gap
    faces[22] = new int[] { 10, 33, 32, 32, 32, 32, 32, 32, 32, 32 };  //added 7x 3rd number to fill gap
    faces[23] = new int[] { 11, 34, 35, 35, 35, 35, 35, 35, 35, 35 };  //added 7x 3rd number to fill gap
    faces[24] = new int[] { 36, 44, 52, 52, 52, 52, 52, 52, 52, 52 };  //added 7x 3rd number to fill gap
    faces[25] = new int[] { 37, 53, 45, 45, 45, 45, 45, 45, 45, 45 };  //added 7x 3rd number to fill gap
    faces[26] = new int[] { 38, 54, 46, 46, 46, 46, 46, 46, 46, 46 };  //added 7x 3rd number to fill gap
    faces[27] = new int[] { 39, 47, 55, 55, 55, 55, 55, 55, 55, 55 };  //added 7x 3rd number to fill gap
    faces[28] = new int[] { 40, 56, 48, 48, 48, 48, 48, 48, 48, 48 };  //added 7x 3rd number to fill gap
    faces[29] = new int[] { 41, 49, 57, 57, 57, 57, 57, 57, 57, 57 };  //added 7x 3rd number to fill gap
    faces[30] = new int[] { 42, 50, 58, 58, 58, 58, 58, 58, 58, 58 };  //added 7x 3rd number to fill gap
    faces[31] = new int[] { 43, 59, 51, 51, 51, 51, 51, 51, 51, 51 };  //added 7x 3rd number to fill gap
  } //end TruncatedDodecahedron()

  public String name() {
    return "Truncated Dodecahedron";
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
   
} //end class TruncatedDodecahedron
/*
TruncatedGreatDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedGreatDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183f; //(1 + sqrt(5)) / 4
  final float C2 = 1.30901699437494742410229341718f;  //(3 + sqrt(5)) / 4
  final float C3 = 1.61803398874989484820458683437f;  //(1 + sqrt(5)) / 2
  final float C4 = 1.80901699437494742410229341718f;  //(5 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedGreatDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.0f,   C4 );
    vert[  1] = new PVector(  0.5f,  0.0f,  -C4 );
    vert[  2] = new PVector( -0.5f,  0.0f,   C4 );
    vert[  3] = new PVector( -0.5f,  0.0f,  -C4 );
    vert[  4] = new PVector(   C4,  0.5f,  0.0f );
    vert[  5] = new PVector(   C4, -0.5f,  0.0f );
    vert[  6] = new PVector(  -C4,  0.5f,  0.0f );
    vert[  7] = new PVector(  -C4, -0.5f,  0.0f );
    vert[  8] = new PVector(  0.0f,   C4,  0.5f );
    vert[  9] = new PVector(  0.0f,   C4, -0.5f );
    vert[ 10] = new PVector(  0.0f,  -C4,  0.5f );
    vert[ 11] = new PVector(  0.0f,  -C4, -0.5f );
    vert[ 12] = new PVector(   C1,  0.5f,   C3 );
    vert[ 13] = new PVector(   C1,  0.5f,  -C3 );
    vert[ 14] = new PVector(   C1, -0.5f,   C3 );
    vert[ 15] = new PVector(   C1, -0.5f,  -C3 );
    vert[ 16] = new PVector(  -C1,  0.5f,   C3 );
    vert[ 17] = new PVector(  -C1,  0.5f,  -C3 );
    vert[ 18] = new PVector(  -C1, -0.5f,   C3 );
    vert[ 19] = new PVector(  -C1, -0.5f,  -C3 );
    vert[ 20] = new PVector(   C3,   C1,  0.5f );
    vert[ 21] = new PVector(   C3,   C1, -0.5f );
    vert[ 22] = new PVector(   C3,  -C1,  0.5f );
    vert[ 23] = new PVector(   C3,  -C1, -0.5f );
    vert[ 24] = new PVector(  -C3,   C1,  0.5f );
    vert[ 25] = new PVector(  -C3,   C1, -0.5f );
    vert[ 26] = new PVector(  -C3,  -C1,  0.5f );
    vert[ 27] = new PVector(  -C3,  -C1, -0.5f );
    vert[ 28] = new PVector(  0.5f,   C3,   C1 );
    vert[ 29] = new PVector(  0.5f,   C3,  -C1 );
    vert[ 30] = new PVector(  0.5f,  -C3,   C1 );
    vert[ 31] = new PVector(  0.5f,  -C3,  -C1 );
    vert[ 32] = new PVector( -0.5f,   C3,   C1 );
    vert[ 33] = new PVector( -0.5f,   C3,  -C1 );
    vert[ 34] = new PVector( -0.5f,  -C3,   C1 );
    vert[ 35] = new PVector( -0.5f,  -C3,  -C1 );
    vert[ 36] = new PVector(   C2,   C0,   C2 );
    vert[ 37] = new PVector(   C2,   C0,  -C2 );
    vert[ 38] = new PVector(   C2,  -C0,   C2 );
    vert[ 39] = new PVector(   C2,  -C0,  -C2 );
    vert[ 40] = new PVector(  -C2,   C0,   C2 );
    vert[ 41] = new PVector(  -C2,   C0,  -C2 );
    vert[ 42] = new PVector(  -C2,  -C0,   C2 );
    vert[ 43] = new PVector(  -C2,  -C0,  -C2 );
    vert[ 44] = new PVector(   C2,   C2,   C0 );
    vert[ 45] = new PVector(   C2,   C2,  -C0 );
    vert[ 46] = new PVector(   C2,  -C2,   C0 );
    vert[ 47] = new PVector(   C2,  -C2,  -C0 );
    vert[ 48] = new PVector(  -C2,   C2,   C0 );
    vert[ 49] = new PVector(  -C2,   C2,  -C0 );
    vert[ 50] = new PVector(  -C2,  -C2,   C0 );
    vert[ 51] = new PVector(  -C2,  -C2,  -C0 );
    vert[ 52] = new PVector(   C0,   C2,   C2 );
    vert[ 53] = new PVector(   C0,   C2,  -C2 );
    vert[ 54] = new PVector(   C0,  -C2,   C2 );
    vert[ 55] = new PVector(   C0,  -C2,  -C2 );
    vert[ 56] = new PVector(  -C0,   C2,   C2 );
    vert[ 57] = new PVector(  -C0,   C2,  -C2 );
    vert[ 58] = new PVector(  -C0,  -C2,   C2 );
    vert[ 59] = new PVector(  -C0,  -C2,  -C2 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 42, 26, 51, 35, 31, 47, 22, 38 };
    faces[ 1] = new int[] {  1,  3, 41, 25, 48, 32, 28, 44, 21, 37 };
    faces[ 2] = new int[] {  2,  0, 36, 20, 45, 29, 33, 49, 24, 40 };
    faces[ 3] = new int[] {  3,  1, 39, 23, 46, 30, 34, 50, 27, 43 };
    faces[ 4] = new int[] {  4,  5, 47, 31, 59, 19, 17, 57, 29, 45 };
    faces[ 5] = new int[] {  5,  4, 44, 28, 56, 16, 18, 58, 30, 46 };
    faces[ 6] = new int[] {  6,  7, 50, 34, 54, 14, 12, 52, 32, 48 };
    faces[ 7] = new int[] {  7,  6, 49, 33, 53, 13, 15, 55, 35, 51 };
    faces[ 8] = new int[] {  8,  9, 57, 17, 43, 27, 26, 42, 16, 56 };
    faces[ 9] = new int[] {  9,  8, 52, 12, 38, 22, 23, 39, 13, 53 };
    faces[10] = new int[] { 10, 11, 55, 15, 37, 21, 20, 36, 14, 54 };
    faces[11] = new int[] { 11, 10, 58, 18, 40, 24, 25, 41, 19, 59 };
    faces[12] = new int[] {  0, 38, 12, 14, 36, 36, 36, 36, 36, 36 };  //repeat 5x 5th column to fill gap
    faces[13] = new int[] {  1, 37, 15, 13, 39, 39, 39, 39, 39, 39 };  //repeat 5x 5th column to fill gap
    faces[14] = new int[] {  2, 40, 18, 16, 42, 42, 42, 42, 42, 42 };  //repeat 5x 5th column to fill gap
    faces[15] = new int[] {  3, 43, 17, 19, 41, 41, 41, 41, 41, 41 };  //repeat 5x 5th column to fill gap
    faces[16] = new int[] {  4, 45, 20, 21, 44, 44, 44, 44, 44, 44 };  //repeat 5x 5th column to fill gap
    faces[17] = new int[] {  5, 46, 23, 22, 47, 47, 47, 47, 47, 47 };  //repeat 5x 5th column to fill gap
    faces[18] = new int[] {  6, 48, 25, 24, 49, 49, 49, 49, 49, 49 };  //repeat 5x 5th column to fill gap
    faces[19] = new int[] {  7, 51, 26, 27, 50, 50, 50, 50, 50, 50 };  //repeat 5x 5th column to fill gap
    faces[20] = new int[] {  8, 56, 28, 32, 52, 52, 52, 52, 52, 52 };  //repeat 5x 5th column to fill gap
    faces[21] = new int[] {  9, 53, 33, 29, 57, 57, 57, 57, 57, 57 };  //repeat 5x 5th column to fill gap
    faces[22] = new int[] { 10, 54, 34, 30, 58, 58, 58, 58, 58, 58 };  //repeat 5x 5th column to fill gap
    faces[23] = new int[] { 11, 59, 31, 35, 55, 55, 55, 55, 55, 55 };  //repeat 5x 5th column to fill gap
  } //end TruncatedGreatDodecahedron()

  public String name() {
    return "Truncated Great Dodecahedron";
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
   
} //end class TruncatedGreatDodecahedron
/*
TruncatedGreatIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedGreatIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.118033988749894848204586834366f; //(sqrt(5) - 2) / 2
  final float C1 = 0.309016994374947424102293417183f; //(sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366f; //(sqrt(5) - 1) / 2
  final float C3 = 0.690983005625052575897706582817f; //(5 - sqrt(5)) / 4
  final float C4 = 0.927050983124842272306880251548f; //3 * (sqrt(5) - 1) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedGreatIcosahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0f, -0.5f,   C4 );
    vert[  1] = new PVector(  0.0f, -0.5f,  -C4 );
    vert[  2] = new PVector(  0.0f,  0.5f,   C4 );
    vert[  3] = new PVector(  0.0f,  0.5f,  -C4 );
    vert[  4] = new PVector( -0.5f,   C4,  0.0f );
    vert[  5] = new PVector(  0.5f,   C4,  0.0f );
    vert[  6] = new PVector( -0.5f,  -C4,  0.0f );
    vert[  7] = new PVector(  0.5f,  -C4,  0.0f );
    vert[  8] = new PVector(   C4,  0.0f, -0.5f );
    vert[  9] = new PVector(   C4,  0.0f,  0.5f );
    vert[ 10] = new PVector(  -C4,  0.0f, -0.5f );
    vert[ 11] = new PVector(  -C4,  0.0f,  0.5f );
    vert[ 12] = new PVector(   C1, -1.0f,   C0 );
    vert[ 13] = new PVector(   C1, -1.0f,  -C0 );
    vert[ 14] = new PVector(  -C1, -1.0f,   C0 );
    vert[ 15] = new PVector(  -C1, -1.0f,  -C0 );
    vert[ 16] = new PVector(   C1,  1.0f,   C0 );
    vert[ 17] = new PVector(   C1,  1.0f,  -C0 );
    vert[ 18] = new PVector(  -C1,  1.0f,   C0 );
    vert[ 19] = new PVector(  -C1,  1.0f,  -C0 );
    vert[ 20] = new PVector( -1.0f,   C0,   C1 );
    vert[ 21] = new PVector( -1.0f,   C0,  -C1 );
    vert[ 22] = new PVector(  1.0f,   C0,   C1 );
    vert[ 23] = new PVector(  1.0f,   C0,  -C1 );
    vert[ 24] = new PVector( -1.0f,  -C0,   C1 );
    vert[ 25] = new PVector( -1.0f,  -C0,  -C1 );
    vert[ 26] = new PVector(  1.0f,  -C0,   C1 );
    vert[ 27] = new PVector(  1.0f,  -C0,  -C1 );
    vert[ 28] = new PVector(   C0,   C1, -1.0f );
    vert[ 29] = new PVector(   C0,   C1,  1.0f );
    vert[ 30] = new PVector(  -C0,   C1, -1.0f );
    vert[ 31] = new PVector(  -C0,   C1,  1.0f );
    vert[ 32] = new PVector(   C0,  -C1, -1.0f );
    vert[ 33] = new PVector(   C0,  -C1,  1.0f );
    vert[ 34] = new PVector(  -C0,  -C1, -1.0f );
    vert[ 35] = new PVector(  -C0,  -C1,  1.0f );
    vert[ 36] = new PVector(   C2, -0.5f,  -C3 );
    vert[ 37] = new PVector(   C2, -0.5f,   C3 );
    vert[ 38] = new PVector(  -C2, -0.5f,  -C3 );
    vert[ 39] = new PVector(  -C2, -0.5f,   C3 );
    vert[ 40] = new PVector(   C2,  0.5f,  -C3 );
    vert[ 41] = new PVector(   C2,  0.5f,   C3 );
    vert[ 42] = new PVector(  -C2,  0.5f,  -C3 );
    vert[ 43] = new PVector(  -C2,  0.5f,   C3 );
    vert[ 44] = new PVector( -0.5f,  -C3,   C2 );
    vert[ 45] = new PVector( -0.5f,  -C3,  -C2 );
    vert[ 46] = new PVector(  0.5f,  -C3,   C2 );
    vert[ 47] = new PVector(  0.5f,  -C3,  -C2 );
    vert[ 48] = new PVector( -0.5f,   C3,   C2 );
    vert[ 49] = new PVector( -0.5f,   C3,  -C2 );
    vert[ 50] = new PVector(  0.5f,   C3,   C2 );
    vert[ 51] = new PVector(  0.5f,   C3,  -C2 );
    vert[ 52] = new PVector(  -C3,   C2, -0.5f );
    vert[ 53] = new PVector(  -C3,   C2,  0.5f );
    vert[ 54] = new PVector(   C3,   C2, -0.5f );
    vert[ 55] = new PVector(   C3,   C2,  0.5f );
    vert[ 56] = new PVector(  -C3,  -C2, -0.5f );
    vert[ 57] = new PVector(  -C3,  -C2,  0.5f );
    vert[ 58] = new PVector(   C3,  -C2, -0.5f );
    vert[ 59] = new PVector(   C3,  -C2,  0.5f );
    // set faces
    faces[ 0] = new int[] {  0,  2, 18, 42, 38, 14 };
    faces[ 1] = new int[] {  1,  3, 17, 41, 37, 13 };
    faces[ 2] = new int[] {  2,  0, 12, 36, 40, 16 };
    faces[ 3] = new int[] {  3,  1, 15, 39, 43, 19 };
    faces[ 4] = new int[] {  4,  5, 23, 47, 45, 21 };
    faces[ 5] = new int[] {  5,  4, 20, 44, 46, 22 };
    faces[ 6] = new int[] {  6,  7, 26, 50, 48, 24 };
    faces[ 7] = new int[] {  7,  6, 25, 49, 51, 27 };
    faces[ 8] = new int[] {  8,  9, 33, 57, 56, 32 };
    faces[ 9] = new int[] {  9,  8, 28, 52, 53, 29 };
    faces[10] = new int[] { 10, 11, 31, 55, 54, 30 };
    faces[11] = new int[] { 11, 10, 34, 58, 59, 35 };
    faces[12] = new int[] { 12, 44, 20, 52, 28, 36 };
    faces[13] = new int[] { 13, 37, 29, 53, 21, 45 };
    faces[14] = new int[] { 14, 38, 30, 54, 22, 46 };
    faces[15] = new int[] { 15, 47, 23, 55, 31, 39 };
    faces[16] = new int[] { 16, 40, 32, 56, 24, 48 };
    faces[17] = new int[] { 17, 49, 25, 57, 33, 41 };
    faces[18] = new int[] { 18, 50, 26, 58, 34, 42 };
    faces[19] = new int[] { 19, 43, 35, 59, 27, 51 };
    faces[20] = new int[] {  0, 14, 46, 44, 12, 12 };  //repeat 1x 5th column to fill gap
    faces[21] = new int[] {  1, 13, 45, 47, 15, 15 };  //repeat 1x 5th column to fill gap
    faces[22] = new int[] {  2, 16, 48, 50, 18, 18 };  //repeat 1x 5th column to fill gap
    faces[23] = new int[] {  3, 19, 51, 49, 17, 17 };  //repeat 1x 5th column to fill gap
    faces[24] = new int[] {  4, 21, 53, 52, 20, 20 };  //repeat 1x 5th column to fill gap
    faces[25] = new int[] {  5, 22, 54, 55, 23, 23 };  //repeat 1x 5th column to fill gap
    faces[26] = new int[] {  6, 24, 56, 57, 25, 25 };  //repeat 1x 5th column to fill gap
    faces[27] = new int[] {  7, 27, 59, 58, 26, 26 };  //repeat 1x 5th column to fill gap
    faces[28] = new int[] {  8, 32, 40, 36, 28, 28 };  //repeat 1x 5th column to fill gap
    faces[29] = new int[] {  9, 29, 37, 41, 33, 33 };  //repeat 1x 5th column to fill gap
    faces[30] = new int[] { 10, 30, 38, 42, 34, 34 };  //repeat 1x 5th column to fill gap
    faces[31] = new int[] { 11, 35, 43, 39, 31, 31 };  //repeat 1x 5th column to fill gap
  } //end TruncatedGreatIcosahedron()

  public String name() {
    return "Truncated Great Icosahedron";
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
   
} //end class TruncatedGreatIcosahedron
/*
TruncatedIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183f;  //(1 + sqrt(5)) / 4
  final float C1 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  final float C2 = 1.80901699437494742410229341718f;   //(5 + sqrt(5)) / 4
  final float C3 = 2.11803398874989484820458683437f;   //(2 + sqrt(5)) / 2
  final float C4 = 2.427050983124842272306880251548f;  //3 * (1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedIcosahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.0f,   C4 );
    vert[  1] = new PVector(  0.5f,  0.0f,  -C4 );
    vert[  2] = new PVector( -0.5f,  0.0f,   C4 );
    vert[  3] = new PVector( -0.5f,  0.0f,  -C4 );
    vert[  4] = new PVector(   C4,  0.5f,  0.0f );
    vert[  5] = new PVector(   C4, -0.5f,  0.0f );
    vert[  6] = new PVector(  -C4,  0.5f,  0.0f );
    vert[  7] = new PVector(  -C4, -0.5f,  0.0f );
    vert[  8] = new PVector(  0.0f,   C4,  0.5f );
    vert[  9] = new PVector(  0.0f,   C4, -0.5f );
    vert[ 10] = new PVector(  0.0f,  -C4,  0.5f );
    vert[ 11] = new PVector(  0.0f,  -C4, -0.5f );
    vert[ 12] = new PVector(  1.0f,   C0,   C3 );
    vert[ 13] = new PVector(  1.0f,   C0,  -C3 );
    vert[ 14] = new PVector(  1.0f,  -C0,   C3 );
    vert[ 15] = new PVector(  1.0f,  -C0,  -C3 );
    vert[ 16] = new PVector( -1.0f,   C0,   C3 );
    vert[ 17] = new PVector( -1.0f,   C0,  -C3 );
    vert[ 18] = new PVector( -1.0f,  -C0,   C3 );
    vert[ 19] = new PVector( -1.0f,  -C0,  -C3 );
    vert[ 20] = new PVector(   C3,  1.0f,   C0 );
    vert[ 21] = new PVector(   C3,  1.0f,  -C0 );
    vert[ 22] = new PVector(   C3, -1.0f,   C0 );
    vert[ 23] = new PVector(   C3, -1.0f,  -C0 );
    vert[ 24] = new PVector(  -C3,  1.0f,   C0 );
    vert[ 25] = new PVector(  -C3,  1.0f,  -C0 );
    vert[ 26] = new PVector(  -C3, -1.0f,   C0 );
    vert[ 27] = new PVector(  -C3, -1.0f,  -C0 );
    vert[ 28] = new PVector(   C0,   C3,  1.0f );
    vert[ 29] = new PVector(   C0,   C3, -1.0f );
    vert[ 30] = new PVector(   C0,  -C3,  1.0f );
    vert[ 31] = new PVector(   C0,  -C3, -1.0f );
    vert[ 32] = new PVector(  -C0,   C3,  1.0f );
    vert[ 33] = new PVector(  -C0,   C3, -1.0f );
    vert[ 34] = new PVector(  -C0,  -C3,  1.0f );
    vert[ 35] = new PVector(  -C0,  -C3, -1.0f );
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
    faces[ 0] = new int[] {  0,  2, 18, 42, 38, 14 };
    faces[ 1] = new int[] {  1,  3, 17, 41, 37, 13 };
    faces[ 2] = new int[] {  2,  0, 12, 36, 40, 16 };
    faces[ 3] = new int[] {  3,  1, 15, 39, 43, 19 };
    faces[ 4] = new int[] {  4,  5, 23, 47, 45, 21 };
    faces[ 5] = new int[] {  5,  4, 20, 44, 46, 22 };
    faces[ 6] = new int[] {  6,  7, 26, 50, 48, 24 };
    faces[ 7] = new int[] {  7,  6, 25, 49, 51, 27 };
    faces[ 8] = new int[] {  8,  9, 33, 57, 56, 32 };
    faces[ 9] = new int[] {  9,  8, 28, 52, 53, 29 };
    faces[10] = new int[] { 10, 11, 31, 55, 54, 30 };
    faces[11] = new int[] { 11, 10, 34, 58, 59, 35 };
    faces[12] = new int[] { 12, 44, 20, 52, 28, 36 };
    faces[13] = new int[] { 13, 37, 29, 53, 21, 45 };
    faces[14] = new int[] { 14, 38, 30, 54, 22, 46 };
    faces[15] = new int[] { 15, 47, 23, 55, 31, 39 };
    faces[16] = new int[] { 16, 40, 32, 56, 24, 48 };
    faces[17] = new int[] { 17, 49, 25, 57, 33, 41 };
    faces[18] = new int[] { 18, 50, 26, 58, 34, 42 };
    faces[19] = new int[] { 19, 43, 35, 59, 27, 51 };
    faces[20] = new int[] {  0, 14, 46, 44, 12, 12 };  //added 1x 5th number to fill gap
    faces[21] = new int[] {  1, 13, 45, 47, 15, 15 };  //added 1x 5th number to fill gap
    faces[22] = new int[] {  2, 16, 48, 50, 18, 18 };  //added 1x 5th number to fill gap
    faces[23] = new int[] {  3, 19, 51, 49, 17, 17 };  //added 1x 5th number to fill gap
    faces[24] = new int[] {  4, 21, 53, 52, 20, 20 };  //added 1x 5th number to fill gap
    faces[25] = new int[] {  5, 22, 54, 55, 23, 23 };  //added 1x 5th number to fill gap
    faces[26] = new int[] {  6, 24, 56, 57, 25, 25 };  //added 1x 5th number to fill gap
    faces[27] = new int[] {  7, 27, 59, 58, 26, 26 };  //added 1x 5th number to fill gap
    faces[28] = new int[] {  8, 32, 40, 36, 28, 28 };  //added 1x 5th number to fill gap
    faces[29] = new int[] {  9, 29, 37, 41, 33, 33 };  //added 1x 5th number to fill gap
    faces[30] = new int[] { 10, 30, 38, 42, 34, 34 };  //added 1x 5th number to fill gap
    faces[31] = new int[] { 11, 35, 43, 39, 31, 31 };  //added 1x 5th number to fill gap
  } //end TruncatedIcosahedron()

  public String name() {
    return "Truncated Icosahedron";
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
   
} //end class TruncatedIcosahedron
/*
TruncatedIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 62;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 1.30901699437494742410229341718f;   //(3 + sqrt(5)) / 4
  final float C1 = 1.61803398874989484820458683437f;   //(1 + sqrt(5)) / 2
  final float C2 = 1.80901699437494742410229341718f;   //(5 + sqrt(5)) / 4
  final float C3 = 2.11803398874989484820458683437f;   //(2 + sqrt(5)) / 2
  final float C4 = 2.427050983124842272306880251548f;  //3 * (1 + sqrt(5)) / 4
  final float C5 = 2.61803398874989484820458683437f;   //(3 + sqrt(5)) / 2
  final float C6 = 2.927050983124842272306880251548f;  //(5 + 3 * sqrt(5)) / 4
  final float C7 = 3.11803398874989484820458683437f;   //(4 + sqrt(5)) / 2
  final float C8 = 3.427050983124842272306880251548f;  //(7 + 3 * sqrt(5)) / 4
  final float C9 = 3.73606797749978969640917366873f;   //(3 + 2 * sqrt(5)) / 2
  private PVector[] vert = new PVector[120]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5f,  0.5f,   C9 );
    vert[  1] = new PVector(  0.5f,  0.5f,  -C9 );
    vert[  2] = new PVector(  0.5f, -0.5f,   C9 );
    vert[  3] = new PVector(  0.5f, -0.5f,  -C9 );
    vert[  4] = new PVector( -0.5f,  0.5f,   C9 );
    vert[  5] = new PVector( -0.5f,  0.5f,  -C9 );
    vert[  6] = new PVector( -0.5f, -0.5f,   C9 );
    vert[  7] = new PVector( -0.5f, -0.5f,  -C9 );
    vert[  8] = new PVector(   C9,  0.5f,  0.5f );
    vert[  9] = new PVector(   C9,  0.5f, -0.5f );
    vert[ 10] = new PVector(   C9, -0.5f,  0.5f );
    vert[ 11] = new PVector(   C9, -0.5f, -0.5f );
    vert[ 12] = new PVector(  -C9,  0.5f,  0.5f );
    vert[ 13] = new PVector(  -C9,  0.5f, -0.5f );
    vert[ 14] = new PVector(  -C9, -0.5f,  0.5f );
    vert[ 15] = new PVector(  -C9, -0.5f, -0.5f );
    vert[ 16] = new PVector(  0.5f,   C9,  0.5f );
    vert[ 17] = new PVector(  0.5f,   C9, -0.5f );
    vert[ 18] = new PVector(  0.5f,  -C9,  0.5f );
    vert[ 19] = new PVector(  0.5f,  -C9, -0.5f );
    vert[ 20] = new PVector( -0.5f,   C9,  0.5f );
    vert[ 21] = new PVector( -0.5f,   C9, -0.5f );
    vert[ 22] = new PVector( -0.5f,  -C9,  0.5f );
    vert[ 23] = new PVector( -0.5f,  -C9, -0.5f );
    vert[ 24] = new PVector(  1.0f,   C0,   C8 );
    vert[ 25] = new PVector(  1.0f,   C0,  -C8 );
    vert[ 26] = new PVector(  1.0f,  -C0,   C8 );
    vert[ 27] = new PVector(  1.0f,  -C0,  -C8 );
    vert[ 28] = new PVector( -1.0f,   C0,   C8 );
    vert[ 29] = new PVector( -1.0f,   C0,  -C8 );
    vert[ 30] = new PVector( -1.0f,  -C0,   C8 );
    vert[ 31] = new PVector( -1.0f,  -C0,  -C8 );
    vert[ 32] = new PVector(   C8,  1.0f,   C0 );
    vert[ 33] = new PVector(   C8,  1.0f,  -C0 );
    vert[ 34] = new PVector(   C8, -1.0f,   C0 );
    vert[ 35] = new PVector(   C8, -1.0f,  -C0 );
    vert[ 36] = new PVector(  -C8,  1.0f,   C0 );
    vert[ 37] = new PVector(  -C8,  1.0f,  -C0 );
    vert[ 38] = new PVector(  -C8, -1.0f,   C0 );
    vert[ 39] = new PVector(  -C8, -1.0f,  -C0 );
    vert[ 40] = new PVector(   C0,   C8,  1.0f );
    vert[ 41] = new PVector(   C0,   C8, -1.0f );
    vert[ 42] = new PVector(   C0,  -C8,  1.0f );
    vert[ 43] = new PVector(   C0,  -C8, -1.0f );
    vert[ 44] = new PVector(  -C0,   C8,  1.0f );
    vert[ 45] = new PVector(  -C0,   C8, -1.0f );
    vert[ 46] = new PVector(  -C0,  -C8,  1.0f );
    vert[ 47] = new PVector(  -C0,  -C8, -1.0f );
    vert[ 48] = new PVector(  0.5f,   C3,   C7 );
    vert[ 49] = new PVector(  0.5f,   C3,  -C7 );
    vert[ 50] = new PVector(  0.5f,  -C3,   C7 );
    vert[ 51] = new PVector(  0.5f,  -C3,  -C7 );
    vert[ 52] = new PVector( -0.5f,   C3,   C7 );
    vert[ 53] = new PVector( -0.5f,   C3,  -C7 );
    vert[ 54] = new PVector( -0.5f,  -C3,   C7 );
    vert[ 55] = new PVector( -0.5f,  -C3,  -C7 );
    vert[ 56] = new PVector(   C7,  0.5f,   C3 );
    vert[ 57] = new PVector(   C7,  0.5f,  -C3 );
    vert[ 58] = new PVector(   C7, -0.5f,   C3 );
    vert[ 59] = new PVector(   C7, -0.5f,  -C3 );
    vert[ 60] = new PVector(  -C7,  0.5f,   C3 );
    vert[ 61] = new PVector(  -C7,  0.5f,  -C3 );
    vert[ 62] = new PVector(  -C7, -0.5f,   C3 );
    vert[ 63] = new PVector(  -C7, -0.5f,  -C3 );
    vert[ 64] = new PVector(   C3,   C7,  0.5f );
    vert[ 65] = new PVector(   C3,   C7, -0.5f );
    vert[ 66] = new PVector(   C3,  -C7,  0.5f );
    vert[ 67] = new PVector(   C3,  -C7, -0.5f );
    vert[ 68] = new PVector(  -C3,   C7,  0.5f );
    vert[ 69] = new PVector(  -C3,   C7, -0.5f );
    vert[ 70] = new PVector(  -C3,  -C7,  0.5f );
    vert[ 71] = new PVector(  -C3,  -C7, -0.5f );
    vert[ 72] = new PVector(   C2,   C1,   C6 );
    vert[ 73] = new PVector(   C2,   C1,  -C6 );
    vert[ 74] = new PVector(   C2,  -C1,   C6 );
    vert[ 75] = new PVector(   C2,  -C1,  -C6 );
    vert[ 76] = new PVector(  -C2,   C1,   C6 );
    vert[ 77] = new PVector(  -C2,   C1,  -C6 );
    vert[ 78] = new PVector(  -C2,  -C1,   C6 );
    vert[ 79] = new PVector(  -C2,  -C1,  -C6 );
    vert[ 80] = new PVector(   C6,   C2,   C1 );
    vert[ 81] = new PVector(   C6,   C2,  -C1 );
    vert[ 82] = new PVector(   C6,  -C2,   C1 );
    vert[ 83] = new PVector(   C6,  -C2,  -C1 );
    vert[ 84] = new PVector(  -C6,   C2,   C1 );
    vert[ 85] = new PVector(  -C6,   C2,  -C1 );
    vert[ 86] = new PVector(  -C6,  -C2,   C1 );
    vert[ 87] = new PVector(  -C6,  -C2,  -C1 );
    vert[ 88] = new PVector(   C1,   C6,   C2 );
    vert[ 89] = new PVector(   C1,   C6,  -C2 );
    vert[ 90] = new PVector(   C1,  -C6,   C2 );
    vert[ 91] = new PVector(   C1,  -C6,  -C2 );
    vert[ 92] = new PVector(  -C1,   C6,   C2 );
    vert[ 93] = new PVector(  -C1,   C6,  -C2 );
    vert[ 94] = new PVector(  -C1,  -C6,   C2 );
    vert[ 95] = new PVector(  -C1,  -C6,  -C2 );
    vert[ 96] = new PVector(   C0,   C4,   C5 );
    vert[ 97] = new PVector(   C0,   C4,  -C5 );
    vert[ 98] = new PVector(   C0,  -C4,   C5 );
    vert[ 99] = new PVector(   C0,  -C4,  -C5 );
    vert[100] = new PVector(  -C0,   C4,   C5 );
    vert[101] = new PVector(  -C0,   C4,  -C5 );
    vert[102] = new PVector(  -C0,  -C4,   C5 );
    vert[103] = new PVector(  -C0,  -C4,  -C5 );
    vert[104] = new PVector(   C5,   C0,   C4 );
    vert[105] = new PVector(   C5,   C0,  -C4 );
    vert[106] = new PVector(   C5,  -C0,   C4 );
    vert[107] = new PVector(   C5,  -C0,  -C4 );
    vert[108] = new PVector(  -C5,   C0,   C4 );
    vert[109] = new PVector(  -C5,   C0,  -C4 );
    vert[110] = new PVector(  -C5,  -C0,   C4 );
    vert[111] = new PVector(  -C5,  -C0,  -C4 );
    vert[112] = new PVector(   C4,   C5,   C0 );
    vert[113] = new PVector(   C4,   C5,  -C0 );
    vert[114] = new PVector(   C4,  -C5,   C0 );
    vert[115] = new PVector(   C4,  -C5,  -C0 );
    vert[116] = new PVector(  -C4,   C5,   C0 );
    vert[117] = new PVector(  -C4,   C5,  -C0 );
    vert[118] = new PVector(  -C4,  -C5,   C0 );
    vert[119] = new PVector(  -C4,  -C5,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0,   2,  26,  74, 106,  58,  56, 104,  72,  24 };
    faces[ 1] = new int[] {  1,  25,  73, 105,  57,  59, 107,  75,  27,   3 };
    faces[ 2] = new int[] {  4,  28,  76, 108,  60,  62, 110,  78,  30,   6 };
    faces[ 3] = new int[] {  5,   7,  31,  79, 111,  63,  61, 109,  77,  29 };
    faces[ 4] = new int[] {  8,   9,  33,  81, 113,  65,  64, 112,  80,  32 };
    faces[ 5] = new int[] { 10,  34,  82, 114,  66,  67, 115,  83,  35,  11 };
    faces[ 6] = new int[] { 12,  36,  84, 116,  68,  69, 117,  85,  37,  13 };
    faces[ 7] = new int[] { 14,  15,  39,  87, 119,  71,  70, 118,  86,  38 };
    faces[ 8] = new int[] { 16,  20,  44,  92, 100,  52,  48,  96,  88,  40 };
    faces[ 9] = new int[] { 17,  41,  89,  97,  49,  53, 101,  93,  45,  21 };
    faces[10] = new int[] { 18,  42,  90,  98,  50,  54, 102,  94,  46,  22 };
    faces[11] = new int[] { 19,  23,  47,  95, 103,  55,  51,  99,  91,  43 };
    faces[12] = new int[] {  0,  24,  48,  52,  28,   4,   4,   4,   4,   4 };  //added 4x 6th number to fill gap
    faces[13] = new int[] {  1,   5,  29,  53,  49,  25,  25,  25,  25,  25 };  //added 4x 6th number to fill gap
    faces[14] = new int[] {  2,   6,  30,  54,  50,  26,  26,  26,  26,  26 };  //added 4x 6th number to fill gap
    faces[15] = new int[] {  3,  27,  51,  55,  31,   7,   7,   7,   7,   7 };  //added 4x 6th number to fill gap
    faces[16] = new int[] {  8,  32,  56,  58,  34,  10,  10,  10,  10,  10 };  //added 4x 6th number to fill gap
    faces[17] = new int[] {  9,  11,  35,  59,  57,  33,  33,  33,  33,  33 };  //added 4x 6th number to fill gap
    faces[18] = new int[] { 12,  14,  38,  62,  60,  36,  36,  36,  36,  36 };  //added 4x 6th number to fill gap
    faces[19] = new int[] { 13,  37,  61,  63,  39,  15,  15,  15,  15,  15 };  //added 4x 6th number to fill gap
    faces[20] = new int[] { 16,  40,  64,  65,  41,  17,  17,  17,  17,  17 };  //added 4x 6th number to fill gap
    faces[21] = new int[] { 18,  19,  43,  67,  66,  42,  42,  42,  42,  42 };  //added 4x 6th number to fill gap
    faces[22] = new int[] { 20,  21,  45,  69,  68,  44,  44,  44,  44,  44 };  //added 4x 6th number to fill gap
    faces[23] = new int[] { 22,  46,  70,  71,  47,  23,  23,  23,  23,  23 };  //added 4x 6th number to fill gap
    faces[24] = new int[] { 72, 104,  80, 112,  88,  96,  96,  96,  96,  96 };  //added 4x 6th number to fill gap
    faces[25] = new int[] { 73,  97,  89, 113,  81, 105, 105, 105, 105, 105 };  //added 4x 6th number to fill gap
    faces[26] = new int[] { 74,  98,  90, 114,  82, 106, 106, 106, 106, 106 };  //added 4x 6th number to fill gap
    faces[27] = new int[] { 75, 107,  83, 115,  91,  99,  99,  99,  99,  99 };  //added 4x 6th number to fill gap
    faces[28] = new int[] { 76, 100,  92, 116,  84, 108, 108, 108, 108, 108 };  //added 4x 6th number to fill gap
    faces[29] = new int[] { 77, 109,  85, 117,  93, 101, 101, 101, 101, 101 };  //added 4x 6th number to fill gap
    faces[30] = new int[] { 78, 110,  86, 118,  94, 102, 102, 102, 102, 102 };  //added 4x 6th number to fill gap
    faces[31] = new int[] { 79, 103,  95, 119,  87, 111, 111, 111, 111, 111 };  //added 4x 6th number to fill gap
    faces[32] = new int[] {  0,   4,   6,   2,   2,   2,   2,   2,   2,   2 };  //added 6x 4th number to fill gap
    faces[33] = new int[] {  1,   3,   7,   5,   5,   5,   5,   5,   5,   5 };  //added 6x 4th number to fill gap
    faces[34] = new int[] {  8,  10,  11,   9,   9,   9,   9,   9,   9,   9 };  //added 6x 4th number to fill gap
    faces[35] = new int[] { 12,  13,  15,  14,  14,  14,  14,  14,  14,  14 };  //added 6x 4th number to fill gap
    faces[36] = new int[] { 16,  17,  21,  20,  20,  20,  20,  20,  20,  20 };  //added 6x 4th number to fill gap
    faces[37] = new int[] { 18,  22,  23,  19,  19,  19,  19,  19,  19,  19 };  //added 6x 4th number to fill gap
    faces[38] = new int[] { 24,  72,  96,  48,  48,  48,  48,  48,  48,  48 };  //added 6x 4th number to fill gap
    faces[39] = new int[] { 25,  49,  97,  73,  73,  73,  73,  73,  73,  73 };  //added 6x 4th number to fill gap
    faces[40] = new int[] { 26,  50,  98,  74,  74,  74,  74,  74,  74,  74 };  //added 6x 4th number to fill gap
    faces[41] = new int[] { 27,  75,  99,  51,  51,  51,  51,  51,  51,  51 };  //added 6x 4th number to fill gap
    faces[42] = new int[] { 28,  52, 100,  76,  76,  76,  76,  76,  76,  76 };  //added 6x 4th number to fill gap
    faces[43] = new int[] { 29,  77, 101,  53,  53,  53,  53,  53,  53,  53 };  //added 6x 4th number to fill gap
    faces[44] = new int[] { 30,  78, 102,  54,  54,  54,  54,  54,  54,  54 };  //added 6x 4th number to fill gap
    faces[45] = new int[] { 31,  55, 103,  79,  79,  79,  79,  79,  79,  79 };  //added 6x 4th number to fill gap
    faces[46] = new int[] { 32,  80, 104,  56,  56,  56,  56,  56,  56,  56 };  //added 6x 4th number to fill gap
    faces[47] = new int[] { 33,  57, 105,  81,  81,  81,  81,  81,  81,  81 };  //added 6x 4th number to fill gap
    faces[48] = new int[] { 34,  58, 106,  82,  82,  82,  82,  82,  82,  82 };  //added 6x 4th number to fill gap
    faces[49] = new int[] { 35,  83, 107,  59,  59,  59,  59,  59,  59,  59 };  //added 6x 4th number to fill gap
    faces[50] = new int[] { 36,  60, 108,  84,  84,  84,  84,  84,  84,  84 };  //added 6x 4th number to fill gap
    faces[51] = new int[] { 37,  85, 109,  61,  61,  61,  61,  61,  61,  61 };  //added 6x 4th number to fill gap
    faces[52] = new int[] { 38,  86, 110,  62,  62,  62,  62,  62,  62,  62 };  //added 6x 4th number to fill gap
    faces[53] = new int[] { 39,  63, 111,  87,  87,  87,  87,  87,  87,  87 };  //added 6x 4th number to fill gap
    faces[54] = new int[] { 40,  88, 112,  64,  64,  64,  64,  64,  64,  64 };  //added 6x 4th number to fill gap
    faces[55] = new int[] { 41,  65, 113,  89,  89,  89,  89,  89,  89,  89 };  //added 6x 4th number to fill gap
    faces[56] = new int[] { 42,  66, 114,  90,  90,  90,  90,  90,  90,  90 };  //added 6x 4th number to fill gap
    faces[57] = new int[] { 43,  91, 115,  67,  67,  67,  67,  67,  67,  67 };  //added 6x 4th number to fill gap
    faces[58] = new int[] { 44,  68, 116,  92,  92,  92,  92,  92,  92,  92 };  //added 6x 4th number to fill gap
    faces[59] = new int[] { 45,  93, 117,  69,  69,  69,  69,  69,  69,  69 };  //added 6x 4th number to fill gap
    faces[60] = new int[] { 46,  94, 118,  70,  70,  70,  70,  70,  70,  70 };  //added 6x 4th number to fill gap
    faces[61] = new int[] { 47,  71, 119,  95,  95,  95,  95,  95,  95,  95 };  //added 6x 4th number to fill gap
  } //end TruncatedIcosidodecahedron()

  public String name() {
    return "Truncated Icosidodecahedron";
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
   
} //end class TruncatedIcosidodecahedron
/*
TruncatedOctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedOctahedron extends Polyhedron {

  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 6;  // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048f; //sqrt(2) / 2
  final float C1 = 1.41421356237309504880168872421f;   //sqrt(2)
  PVector[] vert = new PVector[24]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private TruncatedOctahedron() {   
    // set vertices
    vert[ 0] = new PVector( C0, 0.0f,  C1);
    vert[ 1] = new PVector( C0, 0.0f, -C1);
    vert[ 2] = new PVector(-C0, 0.0f,  C1);
    vert[ 3] = new PVector(-C0, 0.0f, -C1);
    vert[ 4] = new PVector( C1,  C0, 0.0f);
    vert[ 5] = new PVector( C1, -C0, 0.0f);
    vert[ 6] = new PVector(-C1,  C0, 0.0f);
    vert[ 7] = new PVector(-C1, -C0, 0.0f);
    vert[ 8] = new PVector(0.0f,  C1,  C0);
    vert[ 9] = new PVector(0.0f,  C1, -C0);
    vert[10] = new PVector(0.0f, -C1,  C0);
    vert[11] = new PVector(0.0f, -C1, -C0);  
    vert[12] = new PVector(0.0f,  C0,  C1);
    vert[13] = new PVector(0.0f,  C0, -C1);
    vert[14] = new PVector(0.0f, -C0,  C1);
    vert[15] = new PVector(0.0f, -C0, -C1);
    vert[16] = new PVector( C1, 0.0f,  C0);
    vert[17] = new PVector( C1, 0.0f, -C0);
    vert[18] = new PVector(-C1, 0.0f,  C0);
    vert[19] = new PVector(-C1, 0.0f, -C0);
    vert[20] = new PVector( C0,  C1, 0.0f);
    vert[21] = new PVector( C0, -C1, 0.0f);
    vert[22] = new PVector(-C0,  C1, 0.0f);
    vert[23] = new PVector(-C0, -C1, 0.0f);
    // set faces
    faces[ 0] = new int[] { 0, 14, 10, 21,  5, 16};
    faces[ 1] = new int[] { 1, 13,  9, 20,  4, 17};
    faces[ 2] = new int[] { 2, 12,  8, 22,  6, 18};
    faces[ 3] = new int[] { 3, 15, 11, 23,  7, 19};
    faces[ 4] = new int[] { 4, 20,  8, 12,  0, 16};  
    faces[ 5] = new int[] { 5, 21, 11, 15,  1, 17};
    faces[ 6] = new int[] { 7, 23, 10, 14,  2, 18};
    faces[ 7] = new int[] { 6, 22,  9, 13,  3, 19};
    faces[ 8] = new int[] { 0, 12,  2, 14, 14, 14}; //added 2x 4th number to fill gap
    faces[ 9] = new int[] { 1, 15,  3, 13, 13, 13}; //added 2x 4th number to fill gap
    faces[10] = new int[] { 4, 16,  5, 17, 17, 17}; //added 2x 4th number to fill gap
    faces[11] = new int[] { 6, 19,  7, 18, 18, 18}; //added 2x 4th number to fill gap
    faces[12] = new int[] { 8, 20,  9, 22, 22, 22}; //added 2x 4th number to fill gap
    faces[13] = new int[] {10, 23, 11, 21, 21, 21}; //added 2x 4th number to fill gap
  } //end TruncatedOctahedron()

  public String name() {
    return "Truncated Octahedron";
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

} //end class TruncatedOctahedron
/*
TruncatedTetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedTetrahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 8;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.353553390593273762200422181052f; //sqrt(2) / 4
  final float C1 = 1.06066017177982128660126654316f;  //3 * sqrt(2) / 4
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedTetrahedron() {   
    // set vertices
    vert[ 0] = new PVector(  C0, -C0,  C1 );
    vert[ 1] = new PVector(  C0,  C0, -C1 );
    vert[ 2] = new PVector( -C0,  C0,  C1 );
    vert[ 3] = new PVector( -C0, -C0, -C1 );
    vert[ 4] = new PVector(  C1, -C0,  C0 );
    vert[ 5] = new PVector(  C1,  C0, -C0 );
    vert[ 6] = new PVector( -C1,  C0,  C0 );
    vert[ 7] = new PVector( -C1, -C0, -C0 );
    vert[ 8] = new PVector(  C0, -C1,  C0 );
    vert[ 9] = new PVector(  C0,  C1, -C0 );
    vert[10] = new PVector( -C0,  C1,  C0 );
    vert[11] = new PVector( -C0, -C1, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  4,  5,  9, 10,  2 };
    faces[ 1] = new int[] { 1,  5,  4,  8, 11,  3 };
    faces[ 2] = new int[] { 2,  6,  7, 11,  8,  0 };
    faces[ 3] = new int[] { 3,  7,  6, 10,  9,  1 };
    faces[ 4] = new int[] { 0,  8,  4,  4,  4,  4 }; //added 3x 3rd number to fill gap
    faces[ 5] = new int[] { 1,  9,  5,  5,  5,  5 }; //added 3x 3rd number to fill gap
    faces[ 6] = new int[] { 2, 10,  6,  6,  6,  6 }; //added 3x 3rd number to fill gap
    faces[ 7] = new int[] { 3, 11,  7,  7,  7,  7 }; //added 3x 3rd number to fill gap
  } //end TruncatedTetrahedron()

  public String name() {
    return "Truncated Tetrahedron";
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
   
} //end class TruncatedTetrahedron
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
    String[] appletArgs = new String[] { "polyhedrons_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
