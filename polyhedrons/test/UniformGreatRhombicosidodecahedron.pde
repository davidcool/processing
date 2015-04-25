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
  final float C0 = 0.118033988749894848204586834366;  //(sqrt(5) - 2) / 2
  final float C1 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C2 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C3 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C4 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private UniformGreatRhombicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5,  0.5,  -C0 );
    vert[  1] = new PVector(  0.5,  0.5,   C0 );
    vert[  2] = new PVector( -0.5,  0.5,  -C0 );
    vert[  3] = new PVector( -0.5,  0.5,   C0 );
    vert[  4] = new PVector(  0.5, -0.5,  -C0 );
    vert[  5] = new PVector(  0.5, -0.5,   C0 );
    vert[  6] = new PVector( -0.5, -0.5,  -C0 );
    vert[  7] = new PVector( -0.5, -0.5,   C0 );
    vert[  8] = new PVector(  0.5,  -C0,  0.5 );
    vert[  9] = new PVector(  0.5,  -C0, -0.5 );
    vert[ 10] = new PVector( -0.5,  -C0,  0.5 );
    vert[ 11] = new PVector( -0.5,  -C0, -0.5 );
    vert[ 12] = new PVector(  0.5,   C0,  0.5 );
    vert[ 13] = new PVector(  0.5,   C0, -0.5 );
    vert[ 14] = new PVector( -0.5,   C0,  0.5 );
    vert[ 15] = new PVector( -0.5,   C0, -0.5 );
    vert[ 16] = new PVector(  -C0,  0.5,  0.5 );
    vert[ 17] = new PVector(  -C0,  0.5, -0.5 );
    vert[ 18] = new PVector(   C0,  0.5,  0.5 );
    vert[ 19] = new PVector(   C0,  0.5, -0.5 );
    vert[ 20] = new PVector(  -C0, -0.5,  0.5 );
    vert[ 21] = new PVector(  -C0, -0.5, -0.5 );
    vert[ 22] = new PVector(   C0, -0.5,  0.5 );
    vert[ 23] = new PVector(   C0, -0.5, -0.5 );
    vert[ 24] = new PVector(   C1,  0.0,   C4 );
    vert[ 25] = new PVector(   C1,  0.0,  -C4 );
    vert[ 26] = new PVector(  -C1,  0.0,   C4 );
    vert[ 27] = new PVector(  -C1,  0.0,  -C4 );
    vert[ 28] = new PVector(  0.0,   C4,   C1 );
    vert[ 29] = new PVector(  0.0,   C4,  -C1 );
    vert[ 30] = new PVector(  0.0,  -C4,   C1 );
    vert[ 31] = new PVector(  0.0,  -C4,  -C1 );
    vert[ 32] = new PVector(   C4,   C1,  0.0 );
    vert[ 33] = new PVector(  -C4,   C1,  0.0 );
    vert[ 34] = new PVector(   C4,  -C1,  0.0 );
    vert[ 35] = new PVector(  -C4,  -C1,  0.0 );
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
