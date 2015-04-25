/*
GreatRhombidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatRhombidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 42;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.118033988749894848204586834366;  //(sqrt(5) - 2) / 2
  final float C1 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C2 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C3 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C4 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatRhombidodecahedron() {   
    // set vertices
    vert[  0] = new PVector( -0.5, -0.5,   C0 );
    vert[  1] = new PVector( -0.5, -0.5,  -C0 );
    vert[  2] = new PVector(  0.5, -0.5,   C0 );
    vert[  3] = new PVector(  0.5, -0.5,  -C0 );
    vert[  4] = new PVector( -0.5,  0.5,   C0 );
    vert[  5] = new PVector( -0.5,  0.5,  -C0 );
    vert[  6] = new PVector(  0.5,  0.5,   C0 );
    vert[  7] = new PVector(  0.5,  0.5,  -C0 );
    vert[  8] = new PVector( -0.5,   C0, -0.5 );
    vert[  9] = new PVector( -0.5,   C0,  0.5 );
    vert[ 10] = new PVector(  0.5,   C0, -0.5 );
    vert[ 11] = new PVector(  0.5,   C0,  0.5 );
    vert[ 12] = new PVector( -0.5,  -C0, -0.5 );
    vert[ 13] = new PVector( -0.5,  -C0,  0.5 );
    vert[ 14] = new PVector(  0.5,  -C0, -0.5 );
    vert[ 15] = new PVector(  0.5,  -C0,  0.5 );
    vert[ 16] = new PVector(   C0, -0.5, -0.5 );
    vert[ 17] = new PVector(   C0, -0.5,  0.5 );
    vert[ 18] = new PVector(  -C0, -0.5, -0.5 );
    vert[ 19] = new PVector(  -C0, -0.5,  0.5 );
    vert[ 20] = new PVector(   C0,  0.5, -0.5 );
    vert[ 21] = new PVector(   C0,  0.5,  0.5 );
    vert[ 22] = new PVector(  -C0,  0.5, -0.5 );
    vert[ 23] = new PVector(  -C0,  0.5,  0.5 );
    vert[ 24] = new PVector(  -C1,  0.0,  -C4 );
    vert[ 25] = new PVector(  -C1,  0.0,   C4 );
    vert[ 26] = new PVector(   C1,  0.0,  -C4 );
    vert[ 27] = new PVector(   C1,  0.0,   C4 );
    vert[ 28] = new PVector(  0.0,  -C4,  -C1 );
    vert[ 29] = new PVector(  0.0,  -C4,   C1 );
    vert[ 30] = new PVector(  0.0,   C4,  -C1 );
    vert[ 31] = new PVector(  0.0,   C4,   C1 );
    vert[ 32] = new PVector(  -C4,  -C1,  0.0 );
    vert[ 33] = new PVector(   C4,  -C1,  0.0 );
    vert[ 34] = new PVector(  -C4,   C1,  0.0 );
    vert[ 35] = new PVector(   C4,   C1,  0.0 );
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
    faces[12] = new int[] { 24,  0, 36, 52, 52, 52, 52, 52, 52, 52 }; //added 6x 4th number to fill gap
    faces[13] = new int[] { 24, 56, 40,  4,  4,  4,  4,  4,  4,  4 }; //added 6x 4th number to fill gap
    faces[14] = new int[] { 25,  5, 41, 57, 57, 57, 57, 57, 57, 57 }; //added 6x 4th number to fill gap
    faces[15] = new int[] { 25, 53, 37,  1,  1,  1,  1,  1,  1,  1 }; //added 6x 4th number to fill gap
    faces[16] = new int[] { 26,  6, 42, 58, 58, 58, 58, 58, 58, 58 }; //added 6x 4th number to fill gap
    faces[17] = new int[] { 26, 54, 38,  2,  2,  2,  2,  2,  2,  2 }; //added 6x 4th number to fill gap
    faces[18] = new int[] { 27,  3, 39, 55, 55, 55, 55, 55, 55, 55 }; //added 6x 4th number to fill gap
    faces[19] = new int[] { 27, 59, 43,  7,  7,  7,  7,  7,  7,  7 }; //added 6x 4th number to fill gap
    faces[20] = new int[] { 28,  8, 44, 36, 36, 36, 36, 36, 36, 36 }; //added 6x 4th number to fill gap
    faces[21] = new int[] { 28, 38, 46, 10, 10, 10, 10, 10, 10, 10 }; //added 6x 4th number to fill gap
    faces[22] = new int[] { 29, 11, 47, 39, 39, 39, 39, 39, 39, 39 }; //added 6x 4th number to fill gap
    faces[23] = new int[] { 29, 37, 45,  9,  9,  9,  9,  9,  9,  9 }; //added 6x 4th number to fill gap
    faces[24] = new int[] { 30, 14, 50, 42, 42, 42, 42, 42, 42, 42 }; //added 6x 4th number to fill gap
    faces[25] = new int[] { 30, 40, 48, 12, 12, 12, 12, 12, 12, 12 }; //added 6x 4th number to fill gap
    faces[26] = new int[] { 31, 13, 49, 41, 41, 41, 41, 41, 41, 41 }; //added 6x 4th number to fill gap
    faces[27] = new int[] { 31, 43, 51, 15, 15, 15, 15, 15, 15, 15 }; //added 6x 4th number to fill gap
    faces[28] = new int[] { 32, 16, 52, 44, 44, 44, 44, 44, 44, 44 }; //added 6x 4th number to fill gap
    faces[29] = new int[] { 32, 45, 53, 17, 17, 17, 17, 17, 17, 17 }; //added 6x 4th number to fill gap
    faces[30] = new int[] { 33, 19, 55, 47, 47, 47, 47, 47, 47, 47 }; //added 6x 4th number to fill gap
    faces[31] = new int[] { 33, 46, 54, 18, 18, 18, 18, 18, 18, 18 }; //added 6x 4th number to fill gap
    faces[32] = new int[] { 34, 21, 57, 49, 49, 49, 49, 49, 49, 49 }; //added 6x 4th number to fill gap
    faces[33] = new int[] { 34, 48, 56, 20, 20, 20, 20, 20, 20, 20 }; //added 6x 4th number to fill gap
    faces[34] = new int[] { 35, 22, 58, 50, 50, 50, 50, 50, 50, 50 }; //added 6x 4th number to fill gap
    faces[35] = new int[] { 35, 51, 59, 23, 23, 23, 23, 23, 23, 23 }; //added 6x 4th number to fill gap
    faces[36] = new int[] {  0,  4,  6,  2,  2,  2,  2,  2,  2,  2 }; //added 6x 4th number to fill gap
    faces[37] = new int[] {  1,  3,  7,  5,  5,  5,  5,  5,  5,  5 }; //added 6x 4th number to fill gap
    faces[38] = new int[] {  8, 10, 11,  9,  9,  9,  9,  9,  9,  9 }; //added 6x 4th number to fill gap
    faces[39] = new int[] { 12, 13, 15, 14, 14, 14, 14, 14, 14, 14 }; //added 6x 4th number to fill gap
    faces[40] = new int[] { 16, 17, 21, 20, 20, 20, 20, 20, 20, 20 }; //added 6x 4th number to fill gap
    faces[41] = new int[] { 18, 22, 23, 19, 19, 19, 19, 19, 19, 19 }; //added 6x 4th number to fill gap
  } //end GreatRhombidodecahedron()

  public String name() {
    return "Great Rhombidodecahedron";
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
   
} //end class GreatRhombidodecahedron
