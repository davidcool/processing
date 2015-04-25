/*
GreatIcosicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 52;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C1 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C2 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,   C0,   C3 );
    vert[  1] = new PVector(  0.0,   C0,  -C3 );
    vert[  2] = new PVector(  0.0,  -C0,   C3 );
    vert[  3] = new PVector(  0.0,  -C0,  -C3 );
    vert[  4] = new PVector(   C3,  0.0,   C0 );
    vert[  5] = new PVector(   C3,  0.0,  -C0 );
    vert[  6] = new PVector(  -C3,  0.0,   C0 );
    vert[  7] = new PVector(  -C3,  0.0,  -C0 );
    vert[  8] = new PVector(   C0,   C3,  0.0 );
    vert[  9] = new PVector(   C0,  -C3,  0.0 );
    vert[ 10] = new PVector(  -C0,   C3,  0.0 );
    vert[ 11] = new PVector(  -C0,  -C3,  0.0 );
    vert[ 12] = new PVector(   C0,  0.5,  1.0 );
    vert[ 13] = new PVector(   C0,  0.5, -1.0 );
    vert[ 14] = new PVector(   C0, -0.5,  1.0 );
    vert[ 15] = new PVector(   C0, -0.5, -1.0 );
    vert[ 16] = new PVector(  -C0,  0.5,  1.0 );
    vert[ 17] = new PVector(  -C0,  0.5, -1.0 );
    vert[ 18] = new PVector(  -C0, -0.5,  1.0 );
    vert[ 19] = new PVector(  -C0, -0.5, -1.0 );
    vert[ 20] = new PVector(  1.0,   C0,  0.5 );
    vert[ 21] = new PVector(  1.0,   C0, -0.5 );
    vert[ 22] = new PVector(  1.0,  -C0,  0.5 );
    vert[ 23] = new PVector(  1.0,  -C0, -0.5 );
    vert[ 24] = new PVector( -1.0,   C0,  0.5 );
    vert[ 25] = new PVector( -1.0,   C0, -0.5 );
    vert[ 26] = new PVector( -1.0,  -C0,  0.5 );
    vert[ 27] = new PVector( -1.0,  -C0, -0.5 );
    vert[ 28] = new PVector(  0.5,  1.0,   C0 );
    vert[ 29] = new PVector(  0.5,  1.0,  -C0 );
    vert[ 30] = new PVector(  0.5, -1.0,   C0 );
    vert[ 31] = new PVector(  0.5, -1.0,  -C0 );
    vert[ 32] = new PVector( -0.5,  1.0,   C0 );
    vert[ 33] = new PVector( -0.5,  1.0,  -C0 );
    vert[ 34] = new PVector( -0.5, -1.0,   C0 );
    vert[ 35] = new PVector( -0.5, -1.0,  -C0 );
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
    faces[ 0] = new int[] {  0, 42, 11, 55,  5, 44 };
    faces[ 1] = new int[] {  0, 48,  7, 59,  9, 38 };
    faces[ 2] = new int[] {  1, 39,  9, 58,  6, 49 };
    faces[ 3] = new int[] {  1, 45,  4, 54, 11, 43 };
    faces[ 4] = new int[] {  2, 36,  8, 57,  7, 50 };
    faces[ 5] = new int[] {  2, 46,  5, 53, 10, 40 };
    faces[ 6] = new int[] {  3, 41, 10, 52,  4, 47 };
    faces[ 7] = new int[] {  3, 51,  6, 56,  8, 37 };
    faces[ 8] = new int[] { 15, 13, 29, 44, 46, 31 };
    faces[ 9] = new int[] { 15, 23, 22, 14, 58, 59 };
    faces[10] = new int[] { 18, 16, 32, 49, 51, 34 };
    faces[11] = new int[] { 18, 26, 27, 19, 55, 54 };
    faces[12] = new int[] { 20, 21, 13, 57, 56, 12 };
    faces[13] = new int[] { 20, 28, 32, 24, 42, 38 };
    faces[14] = new int[] { 25, 24, 16, 52, 53, 17 };
    faces[15] = new int[] { 25, 33, 29, 21, 39, 43 };
    faces[16] = new int[] { 30, 22, 36, 40, 26, 34 };
    faces[17] = new int[] { 30, 47, 45, 28, 12, 14 };
    faces[18] = new int[] { 35, 27, 41, 37, 23, 31 };
    faces[19] = new int[] { 35, 50, 48, 33, 17, 19 };
    faces[20] = new int[] {  0, 44, 29, 33, 48, 48 };  // repated 1x 5th number to fill gap
    faces[21] = new int[] {  1, 49, 32, 28, 45, 45 };  // repated 1x 5th number to fill gap
    faces[22] = new int[] {  2, 50, 35, 31, 46, 46 };  // repated 1x 5th number to fill gap
    faces[23] = new int[] {  3, 47, 30, 34, 51, 51 };  // repated 1x 5th number to fill gap
    faces[24] = new int[] {  4, 52, 16, 18, 54, 54 };  // repated 1x 5th number to fill gap
    faces[25] = new int[] {  5, 55, 19, 17, 53, 53 };  // repated 1x 5th number to fill gap
    faces[26] = new int[] {  6, 58, 14, 12, 56, 56 };  // repated 1x 5th number to fill gap
    faces[27] = new int[] {  7, 57, 13, 15, 59, 59 };  // repated 1x 5th number to fill gap
    faces[28] = new int[] {  8, 36, 22, 23, 37, 37 };  // repated 1x 5th number to fill gap
    faces[29] = new int[] {  9, 39, 21, 20, 38, 38 };  // repated 1x 5th number to fill gap
    faces[30] = new int[] { 10, 41, 27, 26, 40, 40 };  // repated 1x 5th number to fill gap
    faces[31] = new int[] { 11, 42, 24, 25, 43, 43 };  // repated 1x 5th number to fill gap
    faces[32] = new int[] {  0, 38, 42, 42, 42, 42 };  // repated 3x 3rd number to fill gap
    faces[33] = new int[] {  1, 43, 39, 39, 39, 39 };  // repated 3x 3rd number to fill gap
    faces[34] = new int[] {  2, 40, 36, 36, 36, 36 };  // repated 3x 3rd number to fill gap
    faces[35] = new int[] {  3, 37, 41, 41, 41, 41 };  // repated 3x 3rd number to fill gap
    faces[36] = new int[] {  4, 45, 47, 47, 47, 47 };  // repated 3x 3rd number to fill gap
    faces[37] = new int[] {  5, 46, 44, 44, 44, 44 };  // repated 3x 3rd number to fill gap
    faces[38] = new int[] {  6, 51, 49, 49, 49, 49 };  // repated 3x 3rd number to fill gap
    faces[39] = new int[] {  7, 48, 50, 50, 50, 50 };  // repated 3x 3rd number to fill gap
    faces[40] = new int[] {  8, 56, 57, 57, 57, 57 };  // repated 3x 3rd number to fill gap
    faces[41] = new int[] {  9, 59, 58, 58, 58, 58 };  // repated 3x 3rd number to fill gap
    faces[42] = new int[] { 10, 53, 52, 52, 52, 52 };  // repated 3x 3rd number to fill gap
    faces[43] = new int[] { 11, 54, 55, 55, 55, 55 };  // repated 3x 3rd number to fill gap
    faces[44] = new int[] { 12, 28, 20, 20, 20, 20 };  // repated 3x 3rd number to fill gap
    faces[45] = new int[] { 13, 21, 29, 29, 29, 29 };  // repated 3x 3rd number to fill gap
    faces[46] = new int[] { 14, 22, 30, 30, 30, 30 };  // repated 3x 3rd number to fill gap
    faces[47] = new int[] { 15, 31, 23, 23, 23, 23 };  // repated 3x 3rd number to fill gap
    faces[48] = new int[] { 16, 24, 32, 32, 32, 32 };  // repated 3x 3rd number to fill gap
    faces[49] = new int[] { 17, 33, 25, 25, 25, 25 };  // repated 3x 3rd number to fill gap
    faces[50] = new int[] { 18, 34, 26, 26, 26, 26 };  // repated 3x 3rd number to fill gap
    faces[51] = new int[] { 19, 27, 35, 35, 35, 35 };  // repated 3x 3rd number to fill gap
  } //end GreatIcosicosidodecahedron()

  public String name() {
    return "Great Icosicosidodecahedron";
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
   
} //end class GreatIcosicosidodecahedron
