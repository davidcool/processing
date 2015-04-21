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
  final float C0 = 1.24264068711928514640506617263;   //3 * (sqrt(2) - 1)
  final float C1 = 7.24264068711928514640506617263;   //3 * (1 + sqrt(2))
  private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TetradyakisHexahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,   C1 );
    vert[  1] = new PVector(  0.0,  0.0,  -C1 );
    vert[  2] = new PVector(   C1,  0.0,  0.0 );
    vert[  3] = new PVector(  -C1,  0.0,  0.0 );
    vert[  4] = new PVector(  0.0,   C1,  0.0 );
    vert[  5] = new PVector(  0.0,  -C1,  0.0 );
    vert[  6] = new PVector(  0.0,  0.0,   C0 );
    vert[  7] = new PVector(  0.0,  0.0,  -C0 );
    vert[  8] = new PVector(   C0,  0.0,  0.0 );
    vert[  9] = new PVector(  -C0,  0.0,  0.0 );
    vert[ 10] = new PVector(  0.0,   C0,  0.0 );
    vert[ 11] = new PVector(  0.0,  -C0,  0.0 );
    vert[ 12] = new PVector(  1.0,  1.0,  1.0 );
    vert[ 13] = new PVector(  1.0,  1.0, -1.0 );
    vert[ 14] = new PVector(  1.0, -1.0,  1.0 );
    vert[ 15] = new PVector(  1.0, -1.0, -1.0 );
    vert[ 16] = new PVector( -1.0,  1.0,  1.0 );
    vert[ 17] = new PVector( -1.0,  1.0, -1.0 );
    vert[ 18] = new PVector( -1.0, -1.0,  1.0 );
    vert[ 19] = new PVector( -1.0, -1.0, -1.0 );
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
