/*
MedialDisdyakisTriacontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialDisdyakisTriacontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 120;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.5150283239582457068371556953047;  //5 * (sqrt(5) - 1) / 12
  final float C1 = 0.833333333333333333333333333333;   //5 / 6
  final float C2 = 0.854101966249684544613760503097;   //(3 * sqrt(5) - 5) / 2
  final float C3 = 1.34836165729157904017048902864;    //5 * (1 + sqrt(5)) / 12
  final float C4 = 1.38196601125010515179541316563;    //(5 - sqrt(5)) / 2
  final float C5 = 1.66666666666666666666666666667;    //5 / 3
  final float C6 = 3.61803398874989484820458683437;    //(5 + sqrt(5)) / 2
  final float C7 = 5.85410196624968454461376050310;    //(5 + 3 * sqrt(5)) / 2
  private PVector[] vert = new PVector[54]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialDisdyakisTriacontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C6, 0.0,  C7 );
    vert[  1] = new PVector(  C6, 0.0, -C7 );
    vert[  2] = new PVector( -C6, 0.0,  C7 );
    vert[  3] = new PVector( -C6, 0.0, -C7 );
    vert[  4] = new PVector(  C7,  C6, 0.0 );
    vert[  5] = new PVector(  C7, -C6, 0.0 );
    vert[  6] = new PVector( -C7,  C6, 0.0 );
    vert[  7] = new PVector( -C7, -C6, 0.0 );
    vert[  8] = new PVector( 0.0,  C7,  C6 );
    vert[  9] = new PVector( 0.0,  C7, -C6 );
    vert[ 10] = new PVector( 0.0, -C7,  C6 );
    vert[ 11] = new PVector( 0.0, -C7, -C6 );
    vert[ 12] = new PVector( 0.0, 0.0,  C5 );
    vert[ 13] = new PVector( 0.0, 0.0, -C5 );
    vert[ 14] = new PVector(  C5, 0.0, 0.0 );
    vert[ 15] = new PVector( -C5, 0.0, 0.0 );
    vert[ 16] = new PVector( 0.0,  C5, 0.0 );
    vert[ 17] = new PVector( 0.0, -C5, 0.0 );
    vert[ 18] = new PVector(  C2, 0.0,  C4 );
    vert[ 19] = new PVector(  C2, 0.0, -C4 );
    vert[ 20] = new PVector( -C2, 0.0,  C4 );
    vert[ 21] = new PVector( -C2, 0.0, -C4 );
    vert[ 22] = new PVector(  C4,  C2, 0.0 );
    vert[ 23] = new PVector(  C4, -C2, 0.0 );
    vert[ 24] = new PVector( -C4,  C2, 0.0 );
    vert[ 25] = new PVector( -C4, -C2, 0.0 );
    vert[ 26] = new PVector( 0.0,  C4,  C2 );
    vert[ 27] = new PVector( 0.0,  C4, -C2 );
    vert[ 28] = new PVector( 0.0, -C4,  C2 );
    vert[ 29] = new PVector( 0.0, -C4, -C2 );
    vert[ 30] = new PVector(  C0,  C1,  C3 );
    vert[ 31] = new PVector(  C0,  C1, -C3 );
    vert[ 32] = new PVector(  C0, -C1,  C3 );
    vert[ 33] = new PVector(  C0, -C1, -C3 );
    vert[ 34] = new PVector( -C0,  C1,  C3 );
    vert[ 35] = new PVector( -C0,  C1, -C3 );
    vert[ 36] = new PVector( -C0, -C1,  C3 );
    vert[ 37] = new PVector( -C0, -C1, -C3 );
    vert[ 38] = new PVector(  C3,  C0,  C1 );
    vert[ 39] = new PVector(  C3,  C0, -C1 );
    vert[ 40] = new PVector(  C3, -C0,  C1 );
    vert[ 41] = new PVector(  C3, -C0, -C1 );
    vert[ 42] = new PVector( -C3,  C0,  C1 );
    vert[ 43] = new PVector( -C3,  C0, -C1 );
    vert[ 44] = new PVector( -C3, -C0,  C1 );
    vert[ 45] = new PVector( -C3, -C0, -C1 );
    vert[ 46] = new PVector(  C1,  C3,  C0 );
    vert[ 47] = new PVector(  C1,  C3, -C0 );
    vert[ 48] = new PVector(  C1, -C3,  C0 );
    vert[ 49] = new PVector(  C1, -C3, -C0 );
    vert[ 50] = new PVector( -C1,  C3,  C0 );
    vert[ 51] = new PVector( -C1,  C3, -C0 );
    vert[ 52] = new PVector( -C1, -C3,  C0 );
    vert[ 53] = new PVector( -C1, -C3, -C0 );
    // set faces
    faces[  0] = new int[] {  0, 14, 22 };
    faces[  1] = new int[] {  0, 22, 46 };
    faces[  2] = new int[] {  0, 46, 26 };
    faces[  3] = new int[] {  0, 26, 34 };
    faces[  4] = new int[] {  0, 34, 20 };
    faces[  5] = new int[] {  0, 20, 36 };
    faces[  6] = new int[] {  0, 36, 28 };
    faces[  7] = new int[] {  0, 28, 48 };
    faces[  8] = new int[] {  0, 48, 23 };
    faces[  9] = new int[] {  0, 23, 14 };
    faces[ 10] = new int[] {  1, 14, 23 };
    faces[ 11] = new int[] {  1, 23, 49 };
    faces[ 12] = new int[] {  1, 49, 29 };
    faces[ 13] = new int[] {  1, 29, 37 };
    faces[ 14] = new int[] {  1, 37, 21 };
    faces[ 15] = new int[] {  1, 21, 35 };
    faces[ 16] = new int[] {  1, 35, 27 };
    faces[ 17] = new int[] {  1, 27, 47 };
    faces[ 18] = new int[] {  1, 47, 22 };
    faces[ 19] = new int[] {  1, 22, 14 };
    faces[ 20] = new int[] {  2, 15, 25 };
    faces[ 21] = new int[] {  2, 25, 52 };
    faces[ 22] = new int[] {  2, 52, 28 };
    faces[ 23] = new int[] {  2, 28, 32 };
    faces[ 24] = new int[] {  2, 32, 18 };
    faces[ 25] = new int[] {  2, 18, 30 };
    faces[ 26] = new int[] {  2, 30, 26 };
    faces[ 27] = new int[] {  2, 26, 50 };
    faces[ 28] = new int[] {  2, 50, 24 };
    faces[ 29] = new int[] {  2, 24, 15 };
    faces[ 30] = new int[] {  3, 15, 24 };
    faces[ 31] = new int[] {  3, 24, 51 };
    faces[ 32] = new int[] {  3, 51, 27 };
    faces[ 33] = new int[] {  3, 27, 31 };
    faces[ 34] = new int[] {  3, 31, 19 };
    faces[ 35] = new int[] {  3, 19, 33 };
    faces[ 36] = new int[] {  3, 33, 29 };
    faces[ 37] = new int[] {  3, 29, 53 };
    faces[ 38] = new int[] {  3, 53, 25 };
    faces[ 39] = new int[] {  3, 25, 15 };
    faces[ 40] = new int[] {  4, 16, 26 };
    faces[ 41] = new int[] {  4, 26, 30 };
    faces[ 42] = new int[] {  4, 30, 18 };
    faces[ 43] = new int[] {  4, 18, 40 };
    faces[ 44] = new int[] {  4, 40, 23 };
    faces[ 45] = new int[] {  4, 23, 41 };
    faces[ 46] = new int[] {  4, 41, 19 };
    faces[ 47] = new int[] {  4, 19, 31 };
    faces[ 48] = new int[] {  4, 31, 27 };
    faces[ 49] = new int[] {  4, 27, 16 };
    faces[ 50] = new int[] {  5, 17, 29 };
    faces[ 51] = new int[] {  5, 29, 33 };
    faces[ 52] = new int[] {  5, 33, 19 };
    faces[ 53] = new int[] {  5, 19, 39 };
    faces[ 54] = new int[] {  5, 39, 22 };
    faces[ 55] = new int[] {  5, 22, 38 };
    faces[ 56] = new int[] {  5, 38, 18 };
    faces[ 57] = new int[] {  5, 18, 32 };
    faces[ 58] = new int[] {  5, 32, 28 };
    faces[ 59] = new int[] {  5, 28, 17 };
    faces[ 60] = new int[] {  6, 16, 27 };
    faces[ 61] = new int[] {  6, 27, 35 };
    faces[ 62] = new int[] {  6, 35, 21 };
    faces[ 63] = new int[] {  6, 21, 45 };
    faces[ 64] = new int[] {  6, 45, 25 };
    faces[ 65] = new int[] {  6, 25, 44 };
    faces[ 66] = new int[] {  6, 44, 20 };
    faces[ 67] = new int[] {  6, 20, 34 };
    faces[ 68] = new int[] {  6, 34, 26 };
    faces[ 69] = new int[] {  6, 26, 16 };
    faces[ 70] = new int[] {  7, 17, 28 };
    faces[ 71] = new int[] {  7, 28, 36 };
    faces[ 72] = new int[] {  7, 36, 20 };
    faces[ 73] = new int[] {  7, 20, 42 };
    faces[ 74] = new int[] {  7, 42, 24 };
    faces[ 75] = new int[] {  7, 24, 43 };
    faces[ 76] = new int[] {  7, 43, 21 };
    faces[ 77] = new int[] {  7, 21, 37 };
    faces[ 78] = new int[] {  7, 37, 29 };
    faces[ 79] = new int[] {  7, 29, 17 };
    faces[ 80] = new int[] {  8, 12, 18 };
    faces[ 81] = new int[] {  8, 18, 38 };
    faces[ 82] = new int[] {  8, 38, 22 };
    faces[ 83] = new int[] {  8, 22, 47 };
    faces[ 84] = new int[] {  8, 47, 27 };
    faces[ 85] = new int[] {  8, 27, 51 };
    faces[ 86] = new int[] {  8, 51, 24 };
    faces[ 87] = new int[] {  8, 24, 42 };
    faces[ 88] = new int[] {  8, 42, 20 };
    faces[ 89] = new int[] {  8, 20, 12 };
    faces[ 90] = new int[] {  9, 13, 21 };
    faces[ 91] = new int[] {  9, 21, 43 };
    faces[ 92] = new int[] {  9, 43, 24 };
    faces[ 93] = new int[] {  9, 24, 50 };
    faces[ 94] = new int[] {  9, 50, 26 };
    faces[ 95] = new int[] {  9, 26, 46 };
    faces[ 96] = new int[] {  9, 46, 22 };
    faces[ 97] = new int[] {  9, 22, 39 };
    faces[ 98] = new int[] {  9, 39, 19 };
    faces[ 99] = new int[] {  9, 19, 13 };
    faces[100] = new int[] { 10, 12, 20 };
    faces[101] = new int[] { 10, 20, 44 };
    faces[102] = new int[] { 10, 44, 25 };
    faces[103] = new int[] { 10, 25, 53 };
    faces[104] = new int[] { 10, 53, 29 };
    faces[105] = new int[] { 10, 29, 49 };
    faces[106] = new int[] { 10, 49, 23 };
    faces[107] = new int[] { 10, 23, 40 };
    faces[108] = new int[] { 10, 40, 18 };
    faces[109] = new int[] { 10, 18, 12 };
    faces[110] = new int[] { 11, 13, 19 };
    faces[111] = new int[] { 11, 19, 41 };
    faces[112] = new int[] { 11, 41, 23 };
    faces[113] = new int[] { 11, 23, 48 };
    faces[114] = new int[] { 11, 48, 28 };
    faces[115] = new int[] { 11, 28, 52 };
    faces[116] = new int[] { 11, 52, 25 };
    faces[117] = new int[] { 11, 25, 45 };
    faces[118] = new int[] { 11, 45, 21 };
    faces[119] = new int[] { 11, 21, 13 };
  } //end MedialDisdyakisTriacontahedron()

  public String name() {
    return "Medial Disdyakis Triacontahedron";
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
   
} //end class MedialDisdyakisTriacontahedron
