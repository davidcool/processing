/*
SmallRhombidodecacron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallRhombidodecacron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  final float C1 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  final float C2 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C3 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  final float C4 = 2.23606797749978969640917366873;   //sqrt(5)
  final float C5 = 2.61803398874989484820458683437;   //(3 + sqrt(5)) / 2
  private PVector[] vert = new PVector[42]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallRhombidodecacron() {   
    // set vertices
    vert[  0] = new PVector(  C2, 0.0,  C5 );
    vert[  1] = new PVector(  C2, 0.0, -C5 );
    vert[  2] = new PVector( -C2, 0.0,  C5 );
    vert[  3] = new PVector( -C2, 0.0, -C5 );
    vert[  4] = new PVector(  C5,  C2, 0.0 );
    vert[  5] = new PVector(  C5, -C2, 0.0 );
    vert[  6] = new PVector( -C5,  C2, 0.0 );
    vert[  7] = new PVector( -C5, -C2, 0.0 );
    vert[  8] = new PVector( 0.0,  C5,  C2 );
    vert[  9] = new PVector( 0.0,  C5, -C2 );
    vert[ 10] = new PVector( 0.0, -C5,  C2 );
    vert[ 11] = new PVector( 0.0, -C5, -C2 );
    vert[ 12] = new PVector( 0.0, 0.0,  C4 );
    vert[ 13] = new PVector( 0.0, 0.0, -C4 );
    vert[ 14] = new PVector(  C4, 0.0, 0.0 );
    vert[ 15] = new PVector( -C4, 0.0, 0.0 );
    vert[ 16] = new PVector( 0.0,  C4, 0.0 );
    vert[ 17] = new PVector( 0.0, -C4, 0.0 );
    vert[ 18] = new PVector(  C0,  C1,  C3 );
    vert[ 19] = new PVector(  C0,  C1, -C3 );
    vert[ 20] = new PVector(  C0, -C1,  C3 );
    vert[ 21] = new PVector(  C0, -C1, -C3 );
    vert[ 22] = new PVector( -C0,  C1,  C3 );
    vert[ 23] = new PVector( -C0,  C1, -C3 );
    vert[ 24] = new PVector( -C0, -C1,  C3 );
    vert[ 25] = new PVector( -C0, -C1, -C3 );
    vert[ 26] = new PVector(  C3,  C0,  C1 );
    vert[ 27] = new PVector(  C3,  C0, -C1 );
    vert[ 28] = new PVector(  C3, -C0,  C1 );
    vert[ 29] = new PVector(  C3, -C0, -C1 );
    vert[ 30] = new PVector( -C3,  C0,  C1 );
    vert[ 31] = new PVector( -C3,  C0, -C1 );
    vert[ 32] = new PVector( -C3, -C0,  C1 );
    vert[ 33] = new PVector( -C3, -C0, -C1 );
    vert[ 34] = new PVector(  C1,  C3,  C0 );
    vert[ 35] = new PVector(  C1,  C3, -C0 );
    vert[ 36] = new PVector(  C1, -C3,  C0 );
    vert[ 37] = new PVector(  C1, -C3, -C0 );
    vert[ 38] = new PVector( -C1,  C3,  C0 );
    vert[ 39] = new PVector( -C1,  C3, -C0 );
    vert[ 40] = new PVector( -C1, -C3,  C0 );
    vert[ 41] = new PVector( -C1, -C3, -C0 );
    // set faces
    faces[ 0] = new int[] {  0, 14,  5, 26 };
    faces[ 1] = new int[] {  0, 36, 10, 28 };
    faces[ 2] = new int[] {  0, 24,  2, 20 };
    faces[ 3] = new int[] {  0, 22,  8, 12 };
    faces[ 4] = new int[] {  0, 34,  4, 18 };
    faces[ 5] = new int[] {  1, 14,  4, 29 };
    faces[ 6] = new int[] {  1, 37,  5, 21 };
    faces[ 7] = new int[] {  1, 25, 11, 13 };
    faces[ 8] = new int[] {  1, 23,  3, 19 };
    faces[ 9] = new int[] {  1, 35,  9, 27 };
    faces[10] = new int[] {  2, 15,  6, 32 };
    faces[11] = new int[] {  2, 38,  8, 30 };
    faces[12] = new int[] {  2, 18,  0, 22 };
    faces[13] = new int[] {  2, 20, 10, 12 };
    faces[14] = new int[] {  2, 40,  7, 24 };
    faces[15] = new int[] {  3, 15,  7, 31 };
    faces[16] = new int[] {  3, 39,  6, 23 };
    faces[17] = new int[] {  3, 19,  9, 13 };
    faces[18] = new int[] {  3, 21,  1, 25 };
    faces[19] = new int[] {  3, 41, 11, 33 };
    faces[20] = new int[] {  4, 16,  9, 34 };
    faces[21] = new int[] {  4, 19,  1, 35 };
    faces[22] = new int[] {  4, 29,  5, 27 };
    faces[23] = new int[] {  4, 28,  0, 14 };
    faces[24] = new int[] {  4, 18,  8, 26 };
    faces[25] = new int[] {  5, 17, 10, 37 };
    faces[26] = new int[] {  5, 20,  0, 36 };
    faces[27] = new int[] {  5, 26,  4, 28 };
    faces[28] = new int[] {  5, 27,  1, 14 };
    faces[29] = new int[] {  5, 21, 11, 29 };
    faces[30] = new int[] {  6, 16,  8, 39 };
    faces[31] = new int[] {  6, 22,  2, 38 };
    faces[32] = new int[] {  6, 32,  7, 30 };
    faces[33] = new int[] {  6, 33,  3, 15 };
    faces[34] = new int[] {  6, 23,  9, 31 };
    faces[35] = new int[] {  7, 17, 11, 40 };
    faces[36] = new int[] {  7, 25,  3, 41 };
    faces[37] = new int[] {  7, 31,  6, 33 };
    faces[38] = new int[] {  7, 30,  2, 15 };
    faces[39] = new int[] {  7, 24, 10, 32 };
    faces[40] = new int[] {  8, 12,  2, 18 };
    faces[41] = new int[] {  8, 30,  6, 22 };
    faces[42] = new int[] {  8, 39,  9, 38 };
    faces[43] = new int[] {  8, 35,  4, 16 };
    faces[44] = new int[] {  8, 26,  0, 34 };
    faces[45] = new int[] {  9, 13,  1, 23 };
    faces[46] = new int[] {  9, 27,  4, 19 };
    faces[47] = new int[] {  9, 34,  8, 35 };
    faces[48] = new int[] {  9, 38,  6, 16 };
    faces[49] = new int[] {  9, 31,  3, 39 };
    faces[50] = new int[] { 10, 12,  0, 24 };
    faces[51] = new int[] { 10, 28,  5, 20 };
    faces[52] = new int[] { 10, 37, 11, 36 };
    faces[53] = new int[] { 10, 41,  7, 17 };
    faces[54] = new int[] { 10, 32,  2, 40 };
    faces[55] = new int[] { 11, 13,  3, 21 };
    faces[56] = new int[] { 11, 33,  7, 25 };
    faces[57] = new int[] { 11, 40, 10, 41 };
    faces[58] = new int[] { 11, 36,  5, 17 };
    faces[59] = new int[] { 11, 29,  1, 37 };
  } //end SmallRhombidodecacron()

  public String name() {
    return "Small Rhombidodecacron";
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
   
} //end class SmallRhombidodecacron
