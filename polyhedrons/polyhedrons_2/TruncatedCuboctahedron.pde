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
  final float C0 = 1.20710678118654752440084436210;  //(1 + sqrt(2)) / 2
  final float C1 = 1.91421356237309504880168872421;  //(1 + 2 * sqrt(2)) / 2
  private PVector[] vert = new PVector[48]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedCuboctahedron() {   
    // set vertices
    vert[ 0] = new PVector(   C0,  0.5,   C1 );
    vert[ 1] = new PVector(   C0,  0.5,  -C1 );
    vert[ 2] = new PVector(   C0, -0.5,   C1 );
    vert[ 3] = new PVector(   C0, -0.5,  -C1 );
    vert[ 4] = new PVector(  -C0,  0.5,   C1 );
    vert[ 5] = new PVector(  -C0,  0.5,  -C1 );
    vert[ 6] = new PVector(  -C0, -0.5,   C1 );
    vert[ 7] = new PVector(  -C0, -0.5,  -C1 );
    vert[ 8] = new PVector(   C1,   C0,  0.5 );
    vert[ 9] = new PVector(   C1,   C0, -0.5 );
    vert[10] = new PVector(   C1,  -C0,  0.5 );
    vert[11] = new PVector(   C1,  -C0, -0.5 );
    vert[12] = new PVector(  -C1,   C0,  0.5 );
    vert[13] = new PVector(  -C1,   C0, -0.5 );
    vert[14] = new PVector(  -C1,  -C0,  0.5 );
    vert[15] = new PVector(  -C1,  -C0, -0.5 );
    vert[16] = new PVector(  0.5,   C1,   C0 );
    vert[17] = new PVector(  0.5,   C1,  -C0 );
    vert[18] = new PVector(  0.5,  -C1,   C0 );
    vert[19] = new PVector(  0.5,  -C1,  -C0 );
    vert[20] = new PVector( -0.5,   C1,   C0 );
    vert[21] = new PVector( -0.5,   C1,  -C0 );
    vert[22] = new PVector( -0.5,  -C1,   C0 );
    vert[23] = new PVector( -0.5,  -C1,  -C0 );
    vert[24] = new PVector(  0.5,   C0,   C1 );
    vert[25] = new PVector(  0.5,   C0,  -C1 );
    vert[26] = new PVector(  0.5,  -C0,   C1 );
    vert[27] = new PVector(  0.5,  -C0,  -C1 );
    vert[28] = new PVector( -0.5,   C0,   C1 );
    vert[29] = new PVector( -0.5,   C0,  -C1 );
    vert[30] = new PVector( -0.5,  -C0,   C1 );
    vert[31] = new PVector( -0.5,  -C0,  -C1 );
    vert[32] = new PVector(   C1,  0.5,   C0 );
    vert[33] = new PVector(   C1,  0.5,  -C0 );
    vert[34] = new PVector(   C1, -0.5,   C0 );
    vert[35] = new PVector(   C1, -0.5,  -C0 );
    vert[36] = new PVector(  -C1,  0.5,   C0 );
    vert[37] = new PVector(  -C1,  0.5,  -C0 );
    vert[38] = new PVector(  -C1, -0.5,   C0 );
    vert[39] = new PVector(  -C1, -0.5,  -C0 );
    vert[40] = new PVector(   C0,   C1,  0.5 );
    vert[41] = new PVector(   C0,   C1, -0.5 );
    vert[42] = new PVector(   C0,  -C1,  0.5 );
    vert[43] = new PVector(   C0,  -C1, -0.5 );
    vert[44] = new PVector(  -C0,   C1,  0.5 );
    vert[45] = new PVector(  -C0,   C1, -0.5 );
    vert[46] = new PVector(  -C0,  -C1,  0.5 );
    vert[47] = new PVector(  -C0,  -C1, -0.5 );
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
