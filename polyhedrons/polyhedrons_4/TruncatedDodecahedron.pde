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
  final float C0 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  final float C1 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C2 = 2.11803398874989484820458683437;   //(2 + sqrt(5)) / 2
  final float C3 = 2.61803398874989484820458683437;   //(3 + sqrt(5)) / 2
  final float C4 = 2.927050983124842272306880251548;  //(5 + 3 * sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.5,   C4 );
    vert[  1] = new PVector(  0.0,  0.5,  -C4 );
    vert[  2] = new PVector(  0.0, -0.5,   C4 );
    vert[  3] = new PVector(  0.0, -0.5,  -C4 );
    vert[  4] = new PVector(   C4,  0.0,  0.5 );
    vert[  5] = new PVector(   C4,  0.0, -0.5 );
    vert[  6] = new PVector(  -C4,  0.0,  0.5 );
    vert[  7] = new PVector(  -C4,  0.0, -0.5 );
    vert[  8] = new PVector(  0.5,   C4,  0.0 );
    vert[  9] = new PVector(  0.5,  -C4,  0.0 );
    vert[ 10] = new PVector( -0.5,   C4,  0.0 );
    vert[ 11] = new PVector( -0.5,  -C4,  0.0 );
    vert[ 12] = new PVector(  0.5,   C0,   C3 );
    vert[ 13] = new PVector(  0.5,   C0,  -C3 );
    vert[ 14] = new PVector(  0.5,  -C0,   C3 );
    vert[ 15] = new PVector(  0.5,  -C0,  -C3 );
    vert[ 16] = new PVector( -0.5,   C0,   C3 );
    vert[ 17] = new PVector( -0.5,   C0,  -C3 );
    vert[ 18] = new PVector( -0.5,  -C0,   C3 );
    vert[ 19] = new PVector( -0.5,  -C0,  -C3 );
    vert[ 20] = new PVector(   C3,  0.5,   C0 );
    vert[ 21] = new PVector(   C3,  0.5,  -C0 );
    vert[ 22] = new PVector(   C3, -0.5,   C0 );
    vert[ 23] = new PVector(   C3, -0.5,  -C0 );
    vert[ 24] = new PVector(  -C3,  0.5,   C0 );
    vert[ 25] = new PVector(  -C3,  0.5,  -C0 );
    vert[ 26] = new PVector(  -C3, -0.5,   C0 );
    vert[ 27] = new PVector(  -C3, -0.5,  -C0 );
    vert[ 28] = new PVector(   C0,   C3,  0.5 );
    vert[ 29] = new PVector(   C0,   C3, -0.5 );
    vert[ 30] = new PVector(   C0,  -C3,  0.5 );
    vert[ 31] = new PVector(   C0,  -C3, -0.5 );
    vert[ 32] = new PVector(  -C0,   C3,  0.5 );
    vert[ 33] = new PVector(  -C0,   C3, -0.5 );
    vert[ 34] = new PVector(  -C0,  -C3,  0.5 );
    vert[ 35] = new PVector(  -C0,  -C3, -0.5 );
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
