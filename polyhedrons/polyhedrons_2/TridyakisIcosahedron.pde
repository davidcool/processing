/*
TridyakisIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TridyakisIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 120;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.772542485937368560255733542957;  //5 * (sqrt(5) - 1) / 8
  final float C1 = 1.03647450843757886384655987423;   //3 * (5 - sqrt(5)) / 8
  final float C2 = 1.677050983124842272306880251548;  //3 * sqrt(5) / 4
  final float C3 = 2.02254248593736856025573354296;   //5 * (1 + sqrt(5)) / 8
  final float C4 = 2.71352549156242113615344012577;   //3 * (5 + sqrt(5)) / 8
  private PVector[] vert = new PVector[44]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TridyakisIcosahedron() {   
    // set vertices
    vert[  0] = new PVector(    C2,   0.0,    C4 );
    vert[  1] = new PVector(    C2,   0.0,   -C4 );
    vert[  2] = new PVector(   -C2,   0.0,    C4 );
    vert[  3] = new PVector(   -C2,   0.0,   -C4 );
    vert[  4] = new PVector(    C4,    C2,   0.0 );
    vert[  5] = new PVector(    C4,   -C2,   0.0 );
    vert[  6] = new PVector(   -C4,    C2,   0.0 );
    vert[  7] = new PVector(   -C4,   -C2,   0.0 );
    vert[  8] = new PVector(   0.0,    C4,    C2 );
    vert[  9] = new PVector(   0.0,    C4,   -C2 );
    vert[ 10] = new PVector(   0.0,   -C4,    C2 );
    vert[ 11] = new PVector(   0.0,   -C4,   -C2 );
    vert[ 12] = new PVector(   0.0,    C0,    C3 );
    vert[ 13] = new PVector(   0.0,    C0,   -C3 );
    vert[ 14] = new PVector(   0.0,   -C0,    C3 );
    vert[ 15] = new PVector(   0.0,   -C0,   -C3 );
    vert[ 16] = new PVector(    C3,   0.0,    C0 );
    vert[ 17] = new PVector(    C3,   0.0,   -C0 );
    vert[ 18] = new PVector(   -C3,   0.0,    C0 );
    vert[ 19] = new PVector(   -C3,   0.0,   -C0 );
    vert[ 20] = new PVector(    C0,    C3,   0.0 );
    vert[ 21] = new PVector(    C0,   -C3,   0.0 );
    vert[ 22] = new PVector(   -C0,    C3,   0.0 );
    vert[ 23] = new PVector(   -C0,   -C3,   0.0 );
    vert[ 24] = new PVector(    C1,   0.0,    C2 );
    vert[ 25] = new PVector(    C1,   0.0,   -C2 );
    vert[ 26] = new PVector(   -C1,   0.0,    C2 );
    vert[ 27] = new PVector(   -C1,   0.0,   -C2 );
    vert[ 28] = new PVector(    C2,    C1,   0.0 );
    vert[ 29] = new PVector(    C2,   -C1,   0.0 );
    vert[ 30] = new PVector(   -C2,    C1,   0.0 );
    vert[ 31] = new PVector(   -C2,   -C1,   0.0 );
    vert[ 32] = new PVector(   0.0,    C2,    C1 );
    vert[ 33] = new PVector(   0.0,    C2,   -C1 );
    vert[ 34] = new PVector(   0.0,   -C2,    C1 );
    vert[ 35] = new PVector(   0.0,   -C2,   -C1 );
    vert[ 36] = new PVector(  1.25,  1.25,  1.25 );
    vert[ 37] = new PVector(  1.25,  1.25, -1.25 );
    vert[ 38] = new PVector(  1.25, -1.25,  1.25 );
    vert[ 39] = new PVector(  1.25, -1.25, -1.25 );
    vert[ 40] = new PVector( -1.25,  1.25,  1.25 );
    vert[ 41] = new PVector( -1.25,  1.25, -1.25 );
    vert[ 42] = new PVector( -1.25, -1.25,  1.25 );
    vert[ 43] = new PVector( -1.25, -1.25, -1.25 );
    // set faces
    faces[  0] = new int[] {  0, 17, 28 };
    faces[  1] = new int[] {  0, 28, 20 };
    faces[  2] = new int[] {  0, 20, 32 };
    faces[  3] = new int[] {  0, 32, 40 };
    faces[  4] = new int[] {  0, 40, 26 };
    faces[  5] = new int[] {  0, 26, 42 };
    faces[  6] = new int[] {  0, 42, 34 };
    faces[  7] = new int[] {  0, 34, 21 };
    faces[  8] = new int[] {  0, 21, 29 };
    faces[  9] = new int[] {  0, 29, 17 };
    faces[ 10] = new int[] {  1, 16, 29 };
    faces[ 11] = new int[] {  1, 29, 21 };
    faces[ 12] = new int[] {  1, 21, 35 };
    faces[ 13] = new int[] {  1, 35, 43 };
    faces[ 14] = new int[] {  1, 43, 27 };
    faces[ 15] = new int[] {  1, 27, 41 };
    faces[ 16] = new int[] {  1, 41, 33 };
    faces[ 17] = new int[] {  1, 33, 20 };
    faces[ 18] = new int[] {  1, 20, 28 };
    faces[ 19] = new int[] {  1, 28, 16 };
    faces[ 20] = new int[] {  2, 19, 31 };
    faces[ 21] = new int[] {  2, 31, 23 };
    faces[ 22] = new int[] {  2, 23, 34 };
    faces[ 23] = new int[] {  2, 34, 38 };
    faces[ 24] = new int[] {  2, 38, 24 };
    faces[ 25] = new int[] {  2, 24, 36 };
    faces[ 26] = new int[] {  2, 36, 32 };
    faces[ 27] = new int[] {  2, 32, 22 };
    faces[ 28] = new int[] {  2, 22, 30 };
    faces[ 29] = new int[] {  2, 30, 19 };
    faces[ 30] = new int[] {  3, 18, 30 };
    faces[ 31] = new int[] {  3, 30, 22 };
    faces[ 32] = new int[] {  3, 22, 33 };
    faces[ 33] = new int[] {  3, 33, 37 };
    faces[ 34] = new int[] {  3, 37, 25 };
    faces[ 35] = new int[] {  3, 25, 39 };
    faces[ 36] = new int[] {  3, 39, 35 };
    faces[ 37] = new int[] {  3, 35, 23 };
    faces[ 38] = new int[] {  3, 23, 31 };
    faces[ 39] = new int[] {  3, 31, 18 };
    faces[ 40] = new int[] {  4, 12, 24 };
    faces[ 41] = new int[] {  4, 24, 38 };
    faces[ 42] = new int[] {  4, 38, 29 };
    faces[ 43] = new int[] {  4, 29, 39 };
    faces[ 44] = new int[] {  4, 39, 25 };
    faces[ 45] = new int[] {  4, 25, 13 };
    faces[ 46] = new int[] {  4, 13, 33 };
    faces[ 47] = new int[] {  4, 33, 22 };
    faces[ 48] = new int[] {  4, 22, 32 };
    faces[ 49] = new int[] {  4, 32, 12 };
    faces[ 50] = new int[] {  5, 14, 34 };
    faces[ 51] = new int[] {  5, 34, 23 };
    faces[ 52] = new int[] {  5, 23, 35 };
    faces[ 53] = new int[] {  5, 35, 15 };
    faces[ 54] = new int[] {  5, 15, 25 };
    faces[ 55] = new int[] {  5, 25, 37 };
    faces[ 56] = new int[] {  5, 37, 28 };
    faces[ 57] = new int[] {  5, 28, 36 };
    faces[ 58] = new int[] {  5, 36, 24 };
    faces[ 59] = new int[] {  5, 24, 14 };
    faces[ 60] = new int[] {  6, 12, 32 };
    faces[ 61] = new int[] {  6, 32, 20 };
    faces[ 62] = new int[] {  6, 20, 33 };
    faces[ 63] = new int[] {  6, 33, 13 };
    faces[ 64] = new int[] {  6, 13, 27 };
    faces[ 65] = new int[] {  6, 27, 43 };
    faces[ 66] = new int[] {  6, 43, 31 };
    faces[ 67] = new int[] {  6, 31, 42 };
    faces[ 68] = new int[] {  6, 42, 26 };
    faces[ 69] = new int[] {  6, 26, 12 };
    faces[ 70] = new int[] {  7, 14, 26 };
    faces[ 71] = new int[] {  7, 26, 40 };
    faces[ 72] = new int[] {  7, 40, 30 };
    faces[ 73] = new int[] {  7, 30, 41 };
    faces[ 74] = new int[] {  7, 41, 27 };
    faces[ 75] = new int[] {  7, 27, 15 };
    faces[ 76] = new int[] {  7, 15, 35 };
    faces[ 77] = new int[] {  7, 35, 21 };
    faces[ 78] = new int[] {  7, 21, 34 };
    faces[ 79] = new int[] {  7, 34, 14 };
    faces[ 80] = new int[] {  8, 14, 24 };
    faces[ 81] = new int[] {  8, 24, 16 };
    faces[ 82] = new int[] {  8, 16, 28 };
    faces[ 83] = new int[] {  8, 28, 37 };
    faces[ 84] = new int[] {  8, 37, 33 };
    faces[ 85] = new int[] {  8, 33, 41 };
    faces[ 86] = new int[] {  8, 41, 30 };
    faces[ 87] = new int[] {  8, 30, 18 };
    faces[ 88] = new int[] {  8, 18, 26 };
    faces[ 89] = new int[] {  8, 26, 14 };
    faces[ 90] = new int[] {  9, 15, 27 };
    faces[ 91] = new int[] {  9, 27, 19 };
    faces[ 92] = new int[] {  9, 19, 30 };
    faces[ 93] = new int[] {  9, 30, 40 };
    faces[ 94] = new int[] {  9, 40, 32 };
    faces[ 95] = new int[] {  9, 32, 36 };
    faces[ 96] = new int[] {  9, 36, 28 };
    faces[ 97] = new int[] {  9, 28, 17 };
    faces[ 98] = new int[] {  9, 17, 25 };
    faces[ 99] = new int[] {  9, 25, 15 };
    faces[100] = new int[] { 10, 12, 26 };
    faces[101] = new int[] { 10, 26, 18 };
    faces[102] = new int[] { 10, 18, 31 };
    faces[103] = new int[] { 10, 31, 43 };
    faces[104] = new int[] { 10, 43, 35 };
    faces[105] = new int[] { 10, 35, 39 };
    faces[106] = new int[] { 10, 39, 29 };
    faces[107] = new int[] { 10, 29, 16 };
    faces[108] = new int[] { 10, 16, 24 };
    faces[109] = new int[] { 10, 24, 12 };
    faces[110] = new int[] { 11, 13, 25 };
    faces[111] = new int[] { 11, 25, 17 };
    faces[112] = new int[] { 11, 17, 29 };
    faces[113] = new int[] { 11, 29, 38 };
    faces[114] = new int[] { 11, 38, 34 };
    faces[115] = new int[] { 11, 34, 42 };
    faces[116] = new int[] { 11, 42, 31 };
    faces[117] = new int[] { 11, 31, 19 };
    faces[118] = new int[] { 11, 19, 27 };
    faces[119] = new int[] { 11, 27, 13 };
  } //end TridyakisIcosahedron()

  public String name() {
    return "Tridyakis Icosahedron";
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
   
} //end class TridyakisIcosahedron
