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
