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
  final float C0 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C1 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C2 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDitrigonalDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C2, -0.5,   C1 );
    vert[  1] = new PVector(   C2, -0.5,  -C1 );
    vert[  2] = new PVector(  -C2, -0.5,   C1 );
    vert[  3] = new PVector(  -C2, -0.5,  -C1 );
    vert[  4] = new PVector(   C2,  0.5,   C1 );
    vert[  5] = new PVector(   C2,  0.5,  -C1 );
    vert[  6] = new PVector(  -C2,  0.5,   C1 );
    vert[  7] = new PVector(  -C2,  0.5,  -C1 );
    vert[  8] = new PVector( -0.5,   C1,   C2 );
    vert[  9] = new PVector( -0.5,   C1,  -C2 );
    vert[ 10] = new PVector(  0.5,   C1,   C2 );
    vert[ 11] = new PVector(  0.5,   C1,  -C2 );
    vert[ 12] = new PVector( -0.5,  -C1,   C2 );
    vert[ 13] = new PVector( -0.5,  -C1,  -C2 );
    vert[ 14] = new PVector(  0.5,  -C1,   C2 );
    vert[ 15] = new PVector(  0.5,  -C1,  -C2 );
    vert[ 16] = new PVector(   C1,   C2, -0.5 );
    vert[ 17] = new PVector(   C1,   C2,  0.5 );
    vert[ 18] = new PVector(  -C1,   C2, -0.5 );
    vert[ 19] = new PVector(  -C1,   C2,  0.5 );
    vert[ 20] = new PVector(   C1,  -C2, -0.5 );
    vert[ 21] = new PVector(   C1,  -C2,  0.5 );
    vert[ 22] = new PVector(  -C1,  -C2, -0.5 );
    vert[ 23] = new PVector(  -C1,  -C2,  0.5 );
    vert[ 24] = new PVector(   C3,  0.0,  -C0 );
    vert[ 25] = new PVector(   C3,  0.0,   C0 );
    vert[ 26] = new PVector(  -C3,  0.0,  -C0 );
    vert[ 27] = new PVector(  -C3,  0.0,   C0 );
    vert[ 28] = new PVector(  0.0,  -C0,   C3 );
    vert[ 29] = new PVector(  0.0,  -C0,  -C3 );
    vert[ 30] = new PVector(  0.0,   C0,   C3 );
    vert[ 31] = new PVector(  0.0,   C0,  -C3 );
    vert[ 32] = new PVector(  -C0,   C3,  0.0 );
    vert[ 33] = new PVector(   C0,   C3,  0.0 );
    vert[ 34] = new PVector(  -C0,  -C3,  0.0 );
    vert[ 35] = new PVector(   C0,  -C3,  0.0 );
    vert[ 36] = new PVector( -0.5, -1.0,  -C0 );
    vert[ 37] = new PVector( -0.5, -1.0,   C0 );
    vert[ 38] = new PVector(  0.5, -1.0,  -C0 );
    vert[ 39] = new PVector(  0.5, -1.0,   C0 );
    vert[ 40] = new PVector( -0.5,  1.0,  -C0 );
    vert[ 41] = new PVector( -0.5,  1.0,   C0 );
    vert[ 42] = new PVector(  0.5,  1.0,  -C0 );
    vert[ 43] = new PVector(  0.5,  1.0,   C0 );
    vert[ 44] = new PVector( -1.0,  -C0, -0.5 );
    vert[ 45] = new PVector( -1.0,  -C0,  0.5 );
    vert[ 46] = new PVector(  1.0,  -C0, -0.5 );
    vert[ 47] = new PVector(  1.0,  -C0,  0.5 );
    vert[ 48] = new PVector( -1.0,   C0, -0.5 );
    vert[ 49] = new PVector( -1.0,   C0,  0.5 );
    vert[ 50] = new PVector(  1.0,   C0, -0.5 );
    vert[ 51] = new PVector(  1.0,   C0,  0.5 );
    vert[ 52] = new PVector(  -C0, -0.5, -1.0 );
    vert[ 53] = new PVector(  -C0, -0.5,  1.0 );
    vert[ 54] = new PVector(   C0, -0.5, -1.0 );
    vert[ 55] = new PVector(   C0, -0.5,  1.0 );
    vert[ 56] = new PVector(  -C0,  0.5, -1.0 );
    vert[ 57] = new PVector(  -C0,  0.5,  1.0 );
    vert[ 58] = new PVector(   C0,  0.5, -1.0 );
    vert[ 59] = new PVector(   C0,  0.5,  1.0 );
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
