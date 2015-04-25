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
  final float C0 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C1 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C2 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  final float C3 = 2.11803398874989484820458683437;   //(2 + sqrt(5)) / 2
  final float C4 = 2.427050983124842272306880251548;  //3 * (1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedIcosahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5,  0.0,   C4 );
    vert[  1] = new PVector(  0.5,  0.0,  -C4 );
    vert[  2] = new PVector( -0.5,  0.0,   C4 );
    vert[  3] = new PVector( -0.5,  0.0,  -C4 );
    vert[  4] = new PVector(   C4,  0.5,  0.0 );
    vert[  5] = new PVector(   C4, -0.5,  0.0 );
    vert[  6] = new PVector(  -C4,  0.5,  0.0 );
    vert[  7] = new PVector(  -C4, -0.5,  0.0 );
    vert[  8] = new PVector(  0.0,   C4,  0.5 );
    vert[  9] = new PVector(  0.0,   C4, -0.5 );
    vert[ 10] = new PVector(  0.0,  -C4,  0.5 );
    vert[ 11] = new PVector(  0.0,  -C4, -0.5 );
    vert[ 12] = new PVector(  1.0,   C0,   C3 );
    vert[ 13] = new PVector(  1.0,   C0,  -C3 );
    vert[ 14] = new PVector(  1.0,  -C0,   C3 );
    vert[ 15] = new PVector(  1.0,  -C0,  -C3 );
    vert[ 16] = new PVector( -1.0,   C0,   C3 );
    vert[ 17] = new PVector( -1.0,   C0,  -C3 );
    vert[ 18] = new PVector( -1.0,  -C0,   C3 );
    vert[ 19] = new PVector( -1.0,  -C0,  -C3 );
    vert[ 20] = new PVector(   C3,  1.0,   C0 );
    vert[ 21] = new PVector(   C3,  1.0,  -C0 );
    vert[ 22] = new PVector(   C3, -1.0,   C0 );
    vert[ 23] = new PVector(   C3, -1.0,  -C0 );
    vert[ 24] = new PVector(  -C3,  1.0,   C0 );
    vert[ 25] = new PVector(  -C3,  1.0,  -C0 );
    vert[ 26] = new PVector(  -C3, -1.0,   C0 );
    vert[ 27] = new PVector(  -C3, -1.0,  -C0 );
    vert[ 28] = new PVector(   C0,   C3,  1.0 );
    vert[ 29] = new PVector(   C0,   C3, -1.0 );
    vert[ 30] = new PVector(   C0,  -C3,  1.0 );
    vert[ 31] = new PVector(   C0,  -C3, -1.0 );
    vert[ 32] = new PVector(  -C0,   C3,  1.0 );
    vert[ 33] = new PVector(  -C0,   C3, -1.0 );
    vert[ 34] = new PVector(  -C0,  -C3,  1.0 );
    vert[ 35] = new PVector(  -C0,  -C3, -1.0 );
    vert[ 36] = new PVector(  0.5,   C1,   C2 );
    vert[ 37] = new PVector(  0.5,   C1,  -C2 );
    vert[ 38] = new PVector(  0.5,  -C1,   C2 );
    vert[ 39] = new PVector(  0.5,  -C1,  -C2 );
    vert[ 40] = new PVector( -0.5,   C1,   C2 );
    vert[ 41] = new PVector( -0.5,   C1,  -C2 );
    vert[ 42] = new PVector( -0.5,  -C1,   C2 );
    vert[ 43] = new PVector( -0.5,  -C1,  -C2 );
    vert[ 44] = new PVector(   C2,  0.5,   C1 );
    vert[ 45] = new PVector(   C2,  0.5,  -C1 );
    vert[ 46] = new PVector(   C2, -0.5,   C1 );
    vert[ 47] = new PVector(   C2, -0.5,  -C1 );
    vert[ 48] = new PVector(  -C2,  0.5,   C1 );
    vert[ 49] = new PVector(  -C2,  0.5,  -C1 );
    vert[ 50] = new PVector(  -C2, -0.5,   C1 );
    vert[ 51] = new PVector(  -C2, -0.5,  -C1 );
    vert[ 52] = new PVector(   C1,   C2,  0.5 );
    vert[ 53] = new PVector(   C1,   C2, -0.5 );
    vert[ 54] = new PVector(   C1,  -C2,  0.5 );
    vert[ 55] = new PVector(   C1,  -C2, -0.5 );
    vert[ 56] = new PVector(  -C1,   C2,  0.5 );
    vert[ 57] = new PVector(  -C1,   C2, -0.5 );
    vert[ 58] = new PVector(  -C1,  -C2,  0.5 );
    vert[ 59] = new PVector(  -C1,  -C2, -0.5 );
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
