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
  final float C0 = 0.309016994374947424102293417183; //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183; //(1 + sqrt(5)) / 4
  final float C2 = 1.30901699437494742410229341718;  //(3 + sqrt(5)) / 4
  final float C3 = 1.61803398874989484820458683437;  //(1 + sqrt(5)) / 2
  final float C4 = 1.80901699437494742410229341718;  //(5 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedGreatDodecahedron() {   
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
    vert[ 12] = new PVector(   C1,  0.5,   C3 );
    vert[ 13] = new PVector(   C1,  0.5,  -C3 );
    vert[ 14] = new PVector(   C1, -0.5,   C3 );
    vert[ 15] = new PVector(   C1, -0.5,  -C3 );
    vert[ 16] = new PVector(  -C1,  0.5,   C3 );
    vert[ 17] = new PVector(  -C1,  0.5,  -C3 );
    vert[ 18] = new PVector(  -C1, -0.5,   C3 );
    vert[ 19] = new PVector(  -C1, -0.5,  -C3 );
    vert[ 20] = new PVector(   C3,   C1,  0.5 );
    vert[ 21] = new PVector(   C3,   C1, -0.5 );
    vert[ 22] = new PVector(   C3,  -C1,  0.5 );
    vert[ 23] = new PVector(   C3,  -C1, -0.5 );
    vert[ 24] = new PVector(  -C3,   C1,  0.5 );
    vert[ 25] = new PVector(  -C3,   C1, -0.5 );
    vert[ 26] = new PVector(  -C3,  -C1,  0.5 );
    vert[ 27] = new PVector(  -C3,  -C1, -0.5 );
    vert[ 28] = new PVector(  0.5,   C3,   C1 );
    vert[ 29] = new PVector(  0.5,   C3,  -C1 );
    vert[ 30] = new PVector(  0.5,  -C3,   C1 );
    vert[ 31] = new PVector(  0.5,  -C3,  -C1 );
    vert[ 32] = new PVector( -0.5,   C3,   C1 );
    vert[ 33] = new PVector( -0.5,   C3,  -C1 );
    vert[ 34] = new PVector( -0.5,  -C3,   C1 );
    vert[ 35] = new PVector( -0.5,  -C3,  -C1 );
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
