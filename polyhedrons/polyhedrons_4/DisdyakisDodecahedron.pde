/*
DisdyakisDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class DisdyakisDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 48;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 1.41421356237309504880168872421;  //sqrt(2)
  final float C1 = 1.64075448203408147040144747789;  //(3 + 6 * sqrt(2)) / 7
  final float C2 = 2.67541743733683649131645693113;  //(6 + 9 * sqrt(2)) / 7
  private PVector[] vert = new PVector[26]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private DisdyakisDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0, 0.0,  C2 );
    vert[  1] = new PVector(  0.0, 0.0, -C2 );
    vert[  2] = new PVector(   C2, 0.0, 0.0 );
    vert[  3] = new PVector(  -C2, 0.0, 0.0 );
    vert[  4] = new PVector(  0.0,  C2, 0.0 );
    vert[  5] = new PVector(  0.0, -C2, 0.0 );
    vert[  6] = new PVector(   C1, 0.0,  C1 );
    vert[  7] = new PVector(   C1, 0.0, -C1 );
    vert[  8] = new PVector(  -C1, 0.0,  C1 );
    vert[  9] = new PVector(  -C1, 0.0, -C1 );
    vert[ 10] = new PVector(   C1,  C1, 0.0 );
    vert[ 11] = new PVector(   C1, -C1, 0.0 );
    vert[ 12] = new PVector(  -C1,  C1, 0.0 );
    vert[ 13] = new PVector(  -C1, -C1, 0.0 );
    vert[ 14] = new PVector(  0.0,  C1,  C1 );
    vert[ 15] = new PVector(  0.0,  C1, -C1 );
    vert[ 16] = new PVector(  0.0, -C1,  C1 );
    vert[ 17] = new PVector(  0.0, -C1, -C1 );
    vert[ 18] = new PVector(   C0,  C0,  C0 );
    vert[ 19] = new PVector(   C0,  C0, -C0 );
    vert[ 20] = new PVector(   C0, -C0,  C0 );
    vert[ 21] = new PVector(   C0, -C0, -C0 );
    vert[ 22] = new PVector(  -C0,  C0,  C0 );
    vert[ 23] = new PVector(  -C0,  C0, -C0 );
    vert[ 24] = new PVector(  -C0, -C0,  C0 );
    vert[ 25] = new PVector(  -C0, -C0, -C0 );
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
  } //end DisdyakisDodecahedron()

  public String name() {
    return "Disdyakis Dodecahedron";
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
   
} //end class DisdyakisDodecahedron
