/*
GreatDirhombicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDirhombicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 124;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.142901106756847359195252445424;  //sqrt(2 * (3 - sqrt(5) - sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C1 = 0.1817730157320175301311393090951; //sqrt(2 * (sqrt(5) - 1 - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C2 = 0.231218847762556282665656293378;  //sqrt(2 * (2 - sqrt(2 * (sqrt(5) - 1)))) / 4
  final float C3 = 0.412991863494573812796795602473;  //sqrt(2 * (3 - sqrt(5) + sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C4 = 0.437016024448821070799301205056;  //sqrt((3 - sqrt(5)) / 4)
  final float C5 = 0.525333765454529994269705053010;  //sqrt(2 * (sqrt(5) - 1 + 2 * sqrt(sqrt(5) - 2))) / 4
  final float C6 = 0.555892970251421171992048047898;  //sqrt((sqrt(5) - 1) / 4)
  final float C7 = 0.668234872211377353464957498434;  //sqrt(2 * (2 + sqrt(2 * (sqrt(5) - 1)))) / 4
  
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDirhombicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  C1,  C0,  C7 );
    vert[  1] = new PVector(  C1,  C0, -C7 );
    vert[  2] = new PVector(  C1, -C0,  C7 );
    vert[  3] = new PVector(  C1, -C0, -C7 );
    vert[  4] = new PVector( -C1,  C0,  C7 );
    vert[  5] = new PVector( -C1,  C0, -C7 );
    vert[  6] = new PVector( -C1, -C0,  C7 );
    vert[  7] = new PVector( -C1, -C0, -C7 );
    vert[  8] = new PVector(  C7,  C1,  C0 );
    vert[  9] = new PVector(  C7,  C1, -C0 );
    vert[ 10] = new PVector(  C7, -C1,  C0 );
    vert[ 11] = new PVector(  C7, -C1, -C0 );
    vert[ 12] = new PVector( -C7,  C1,  C0 );
    vert[ 13] = new PVector( -C7,  C1, -C0 );
    vert[ 14] = new PVector( -C7, -C1,  C0 );
    vert[ 15] = new PVector( -C7, -C1, -C0 );
    vert[ 16] = new PVector(  C0,  C7,  C1 );
    vert[ 17] = new PVector(  C0,  C7, -C1 );
    vert[ 18] = new PVector(  C0, -C7,  C1 );
    vert[ 19] = new PVector(  C0, -C7, -C1 );
    vert[ 20] = new PVector( -C0,  C7,  C1 );
    vert[ 21] = new PVector( -C0,  C7, -C1 );
    vert[ 22] = new PVector( -C0, -C7,  C1 );
    vert[ 23] = new PVector( -C0, -C7, -C1 );
    vert[ 24] = new PVector( 0.0,  C4,  C6 );
    vert[ 25] = new PVector( 0.0,  C4, -C6 );
    vert[ 26] = new PVector( 0.0, -C4,  C6 );
    vert[ 27] = new PVector( 0.0, -C4, -C6 );
    vert[ 28] = new PVector(  C6, 0.0,  C4 );
    vert[ 29] = new PVector(  C6, 0.0, -C4 );
    vert[ 30] = new PVector( -C6, 0.0,  C4 );
    vert[ 31] = new PVector( -C6, 0.0, -C4 );
    vert[ 32] = new PVector(  C4,  C6, 0.0 );
    vert[ 33] = new PVector(  C4, -C6, 0.0 );
    vert[ 34] = new PVector( -C4,  C6, 0.0 );
    vert[ 35] = new PVector( -C4, -C6, 0.0 );
    vert[ 36] = new PVector(  C3,  C2,  C5 );
    vert[ 37] = new PVector(  C3,  C2, -C5 );
    vert[ 38] = new PVector(  C3, -C2,  C5 );
    vert[ 39] = new PVector(  C3, -C2, -C5 );
    vert[ 40] = new PVector( -C3,  C2,  C5 );
    vert[ 41] = new PVector( -C3,  C2, -C5 );
    vert[ 42] = new PVector( -C3, -C2,  C5 );
    vert[ 43] = new PVector( -C3, -C2, -C5 );
    vert[ 44] = new PVector(  C5,  C3,  C2 );
    vert[ 45] = new PVector(  C5,  C3, -C2 );
    vert[ 46] = new PVector(  C5, -C3,  C2 );
    vert[ 47] = new PVector(  C5, -C3, -C2 );
    vert[ 48] = new PVector( -C5,  C3,  C2 );
    vert[ 49] = new PVector( -C5,  C3, -C2 );
    vert[ 50] = new PVector( -C5, -C3,  C2 );
    vert[ 51] = new PVector( -C5, -C3, -C2 );
    vert[ 52] = new PVector(  C2,  C5,  C3 );
    vert[ 53] = new PVector(  C2,  C5, -C3 );
    vert[ 54] = new PVector(  C2, -C5,  C3 );
    vert[ 55] = new PVector(  C2, -C5, -C3 );
    vert[ 56] = new PVector( -C2,  C5,  C3 );
    vert[ 57] = new PVector( -C2,  C5, -C3 );
    vert[ 58] = new PVector( -C2, -C5,  C3 );
    vert[ 59] = new PVector( -C2, -C5, -C3 );
    // set faces
    faces[  0] = new int[] { 16, 10, 53, 36, 29 };
    faces[  1] = new int[] { 16, 41, 45, 34,  1 };
    faces[  2] = new int[] { 17, 11, 52, 37, 28 };
    faces[  3] = new int[] { 17, 40, 44, 34,  0 };
    faces[  4] = new int[] { 18,  8, 55, 38, 29 };
    faces[  5] = new int[] { 18, 43, 47, 35,  3 };
    faces[  6] = new int[] { 19,  9, 54, 39, 28 };
    faces[  7] = new int[] { 19, 42, 46, 35,  2 };
    faces[  8] = new int[] { 20, 14, 57, 40, 31 };
    faces[  9] = new int[] { 20, 37, 49, 32,  5 };
    faces[ 10] = new int[] { 21, 15, 56, 41, 30 };
    faces[ 11] = new int[] { 21, 36, 48, 32,  4 };
    faces[ 12] = new int[] { 22, 12, 59, 42, 31 };
    faces[ 13] = new int[] { 22, 39, 51, 33,  7 };
    faces[ 14] = new int[] { 23, 13, 58, 43, 30 };
    faces[ 15] = new int[] { 23, 38, 50, 33,  6 };
    faces[ 16] = new int[] { 24, 10,  6, 44, 54 };
    faces[ 17] = new int[] { 24, 14,  2, 48, 58 };
    faces[ 18] = new int[] { 25, 11,  7, 45, 55 };
    faces[ 19] = new int[] { 25, 15,  3, 49, 59 };
    faces[ 20] = new int[] { 26,  8,  4, 46, 52 };
    faces[ 21] = new int[] { 26, 12,  0, 50, 56 };
    faces[ 22] = new int[] { 27,  9,  5, 47, 53 };
    faces[ 23] = new int[] { 27, 13,  1, 51, 57 };
    faces[ 24] = new int[] {  0, 12,  7, 11, 11 };  //added 1x 4th row to fill gaps
    faces[ 25] = new int[] {  0, 34,  7, 33, 33 };  //added 1x 4th row to fill gaps
    faces[ 26] = new int[] {  2, 14,  5,  9,  9 };  //added 1x 4th row to fill gaps
    faces[ 27] = new int[] {  2, 35,  5, 32, 32 };  //added 1x 4th row to fill gaps
    faces[ 28] = new int[] {  4,  8,  3, 15, 15 };  //added 1x 4th row to fill gaps
    faces[ 29] = new int[] {  4, 32,  3, 35, 35 };  //added 1x 4th row to fill gaps
    faces[ 30] = new int[] {  6, 10,  1, 13, 13 };  //added 1x 4th row to fill gaps
    faces[ 31] = new int[] {  6, 33,  1, 34, 34 };  //added 1x 4th row to fill gaps
    faces[ 32] = new int[] {  8, 18, 15, 21, 21 };  //added 1x 4th row to fill gaps
    faces[ 33] = new int[] {  8, 26, 15, 25, 25 };  //added 1x 4th row to fill gaps
    faces[ 34] = new int[] { 10, 16, 13, 23, 23 };  //added 1x 4th row to fill gaps
    faces[ 35] = new int[] { 10, 24, 13, 27, 27 };  //added 1x 4th row to fill gaps
    faces[ 36] = new int[] { 12, 22, 11, 17, 17 };  //added 1x 4th row to fill gaps
    faces[ 37] = new int[] { 12, 26, 11, 25, 25 };  //added 1x 4th row to fill gaps
    faces[ 38] = new int[] { 14, 20,  9, 19, 19 };  //added 1x 4th row to fill gaps
    faces[ 39] = new int[] { 14, 24,  9, 27, 27 };  //added 1x 4th row to fill gaps
    faces[ 40] = new int[] { 16,  1, 23,  6,  6 };  //added 1x 4th row to fill gaps
    faces[ 41] = new int[] { 16, 29, 23, 30, 30 };  //added 1x 4th row to fill gaps
    faces[ 42] = new int[] { 18,  3, 21,  4,  4 };  //added 1x 4th row to fill gaps
    faces[ 43] = new int[] { 18, 29, 21, 30, 30 };  //added 1x 4th row to fill gaps
    faces[ 44] = new int[] { 20,  5, 19,  2,  2 };  //added 1x 4th row to fill gaps
    faces[ 45] = new int[] { 20, 31, 19, 28, 28 };  //added 1x 4th row to fill gaps
    faces[ 46] = new int[] { 22,  7, 17,  0,  0 };  //added 1x 4th row to fill gaps
    faces[ 47] = new int[] { 22, 31, 17, 28, 28 };  //added 1x 4th row to fill gaps
    faces[ 48] = new int[] { 24, 54, 27, 57, 57 };  //added 1x 4th row to fill gaps
    faces[ 49] = new int[] { 24, 58, 27, 53, 53 };  //added 1x 4th row to fill gaps
    faces[ 50] = new int[] { 26, 52, 25, 59, 59 };  //added 1x 4th row to fill gaps
    faces[ 51] = new int[] { 26, 56, 25, 55, 55 };  //added 1x 4th row to fill gaps
    faces[ 52] = new int[] { 28, 37, 31, 42, 42 };  //added 1x 4th row to fill gaps
    faces[ 53] = new int[] { 28, 39, 31, 40, 40 };  //added 1x 4th row to fill gaps
    faces[ 54] = new int[] { 30, 41, 29, 38, 38 };  //added 1x 4th row to fill gaps
    faces[ 55] = new int[] { 30, 43, 29, 36, 36 };  //added 1x 4th row to fill gaps
    faces[ 56] = new int[] { 32, 48, 35, 47, 47 };  //added 1x 4th row to fill gaps
    faces[ 57] = new int[] { 32, 49, 35, 46, 46 };  //added 1x 4th row to fill gaps
    faces[ 58] = new int[] { 34, 44, 33, 51, 51 };  //added 1x 4th row to fill gaps
    faces[ 59] = new int[] { 34, 45, 33, 50, 50 };  //added 1x 4th row to fill gaps
    faces[ 60] = new int[] { 36, 21, 43, 18, 18 };  //added 1x 4th row to fill gaps
    faces[ 61] = new int[] { 36, 47, 43, 48, 48 };  //added 1x 4th row to fill gaps
    faces[ 62] = new int[] { 38, 23, 41, 16, 16 };  //added 1x 4th row to fill gaps
    faces[ 63] = new int[] { 38, 45, 41, 50, 50 };  //added 1x 4th row to fill gaps
    faces[ 64] = new int[] { 40, 17, 39, 22, 22 };  //added 1x 4th row to fill gaps
    faces[ 65] = new int[] { 40, 51, 39, 44, 44 };  //added 1x 4th row to fill gaps
    faces[ 66] = new int[] { 42, 19, 37, 20, 20 };  //added 1x 4th row to fill gaps
    faces[ 67] = new int[] { 42, 49, 37, 46, 46 };  //added 1x 4th row to fill gaps
    faces[ 68] = new int[] { 44,  6, 51,  1,  1 };  //added 1x 4th row to fill gaps
    faces[ 69] = new int[] { 44, 57, 51, 54, 54 };  //added 1x 4th row to fill gaps
    faces[ 70] = new int[] { 46,  4, 49,  3,  3 };  //added 1x 4th row to fill gaps
    faces[ 71] = new int[] { 46, 59, 49, 52, 52 };  //added 1x 4th row to fill gaps
    faces[ 72] = new int[] { 48,  2, 47,  5,  5 };  //added 1x 4th row to fill gaps
    faces[ 73] = new int[] { 48, 53, 47, 58, 58 };  //added 1x 4th row to fill gaps
    faces[ 74] = new int[] { 50,  0, 45,  7,  7 };  //added 1x 4th row to fill gaps
    faces[ 75] = new int[] { 50, 55, 45, 56, 56 };  //added 1x 4th row to fill gaps
    faces[ 76] = new int[] { 52, 11, 59, 12, 12 };  //added 1x 4th row to fill gaps
    faces[ 77] = new int[] { 52, 42, 59, 37, 37 };  //added 1x 4th row to fill gaps
    faces[ 78] = new int[] { 54,  9, 57, 14, 14 };  //added 1x 4th row to fill gaps
    faces[ 79] = new int[] { 54, 40, 57, 39, 39 };  //added 1x 4th row to fill gaps
    faces[ 80] = new int[] { 56, 15, 55,  8,  8 };  //added 1x 4th row to fill gaps
    faces[ 81] = new int[] { 56, 38, 55, 41, 41 };  //added 1x 4th row to fill gaps
    faces[ 82] = new int[] { 58, 13, 53, 10, 10 };  //added 1x 4th row to fill gaps
    faces[ 83] = new int[] { 58, 36, 53, 43, 43 };  //added 1x 4th row to fill gaps
    faces[ 84] = new int[] {  0, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] {  0, 33, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] {  1, 10, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] {  1, 33, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] {  2,  9, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] {  2, 32, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] {  3,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] {  3, 32, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] {  4, 15, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] {  4, 35, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] {  5, 14, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] {  5, 35, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] {  6, 13, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] {  6, 34, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] {  7, 12, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] {  7, 34, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 24, 53, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 24, 57,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 25, 52, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 25, 56,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[104] = new int[] { 26, 55, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[105] = new int[] { 26, 59, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[106] = new int[] { 27, 54, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[107] = new int[] { 27, 58, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[108] = new int[] { 36, 18, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[109] = new int[] { 36, 58, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 37, 19, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[111] = new int[] { 37, 59, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[112] = new int[] { 38, 16, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[113] = new int[] { 38, 56, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[114] = new int[] { 39, 17, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[115] = new int[] { 39, 57, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[116] = new int[] { 40, 22, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[117] = new int[] { 40, 54, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[118] = new int[] { 41, 23, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[119] = new int[] { 41, 55, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 42, 20, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[121] = new int[] { 42, 52, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[122] = new int[] { 43, 21, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[123] = new int[] { 43, 53, 48, 48, 48 };  //added 2x 3rd row to fill gaps
  } //end GreatDirhombicosidodecahedron()

  public String name() {
    return "Great Dirhombicosidodecahedron";
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
   
} //end class GreatDirhombicosidodecahedron
