/*
SmallSnubIcosicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallSnubIcosicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 112;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.267843693395936526330702957199; //(1 - sqrt(5) + sqrt(2*(3*sqrt(5)-1)))/8
  final float C1 = 0.309016994374947424102293417183; //(sqrt(5) - 1) / 4
  final float C2 = 0.576860687770883950432996374382; //(sqrt(5) - 1 + sqrt(2*(3*sqrt(5)-1)))/8
  final float C3 = 0.933380199586931046495436031247; //(1 + sqrt(3 + 2 * sqrt(5))) / 4
  final float C4 = 1.07686068777088395043299637438;  //(3 + sqrt(5) + sqrt(2*(3*sqrt(5)-1)))/8
  final float C5 = 1.24239719396187847059772944843;  //(sqrt(5) + sqrt(3 + 2 * sqrt(5))) / 4
  final float C6 = 1.433380199586931046495436031247; //(3 + sqrt(3 + 2 * sqrt(5))) / 4
  
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallSnubIcosicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  0.0,   C6 );
    vert[  1] = new PVector(   C0,  0.0,  -C6 );
    vert[  2] = new PVector(  -C0,  0.0,   C6 );
    vert[  3] = new PVector(  -C0,  0.0,  -C6 );
    vert[  4] = new PVector(   C6,   C0,  0.0 );
    vert[  5] = new PVector(   C6,  -C0,  0.0 );
    vert[  6] = new PVector(  -C6,   C0,  0.0 );
    vert[  7] = new PVector(  -C6,  -C0,  0.0 );
    vert[  8] = new PVector(  0.0,   C6,   C0 );
    vert[  9] = new PVector(  0.0,   C6,  -C0 );
    vert[ 10] = new PVector(  0.0,  -C6,   C0 );
    vert[ 11] = new PVector(  0.0,  -C6,  -C0 );
    vert[ 12] = new PVector(   C2,  0.5,   C5 );
    vert[ 13] = new PVector(   C2,  0.5,  -C5 );
    vert[ 14] = new PVector(   C2, -0.5,   C5 );
    vert[ 15] = new PVector(   C2, -0.5,  -C5 );
    vert[ 16] = new PVector(  -C2,  0.5,   C5 );
    vert[ 17] = new PVector(  -C2,  0.5,  -C5 );
    vert[ 18] = new PVector(  -C2, -0.5,   C5 );
    vert[ 19] = new PVector(  -C2, -0.5,  -C5 );
    vert[ 20] = new PVector(   C5,   C2,  0.5 );
    vert[ 21] = new PVector(   C5,   C2, -0.5 );
    vert[ 22] = new PVector(   C5,  -C2,  0.5 );
    vert[ 23] = new PVector(   C5,  -C2, -0.5 );
    vert[ 24] = new PVector(  -C5,   C2,  0.5 );
    vert[ 25] = new PVector(  -C5,   C2, -0.5 );
    vert[ 26] = new PVector(  -C5,  -C2,  0.5 );
    vert[ 27] = new PVector(  -C5,  -C2, -0.5 );
    vert[ 28] = new PVector(  0.5,   C5,   C2 );
    vert[ 29] = new PVector(  0.5,   C5,  -C2 );
    vert[ 30] = new PVector(  0.5,  -C5,   C2 );
    vert[ 31] = new PVector(  0.5,  -C5,  -C2 );
    vert[ 32] = new PVector( -0.5,   C5,   C2 );
    vert[ 33] = new PVector( -0.5,   C5,  -C2 );
    vert[ 34] = new PVector( -0.5,  -C5,   C2 );
    vert[ 35] = new PVector( -0.5,  -C5,  -C2 );
    vert[ 36] = new PVector(   C1,   C3,   C4 );
    vert[ 37] = new PVector(   C1,   C3,  -C4 );
    vert[ 38] = new PVector(   C1,  -C3,   C4 );
    vert[ 39] = new PVector(   C1,  -C3,  -C4 );
    vert[ 40] = new PVector(  -C1,   C3,   C4 );
    vert[ 41] = new PVector(  -C1,   C3,  -C4 );
    vert[ 42] = new PVector(  -C1,  -C3,   C4 );
    vert[ 43] = new PVector(  -C1,  -C3,  -C4 );
    vert[ 44] = new PVector(   C4,   C1,   C3 );
    vert[ 45] = new PVector(   C4,   C1,  -C3 );
    vert[ 46] = new PVector(   C4,  -C1,   C3 );
    vert[ 47] = new PVector(   C4,  -C1,  -C3 );
    vert[ 48] = new PVector(  -C4,   C1,   C3 );
    vert[ 49] = new PVector(  -C4,   C1,  -C3 );
    vert[ 50] = new PVector(  -C4,  -C1,   C3 );
    vert[ 51] = new PVector(  -C4,  -C1,  -C3 );
    vert[ 52] = new PVector(   C3,   C4,   C1 );
    vert[ 53] = new PVector(   C3,   C4,  -C1 );
    vert[ 54] = new PVector(   C3,  -C4,   C1 );
    vert[ 55] = new PVector(   C3,  -C4,  -C1 );
    vert[ 56] = new PVector(  -C3,   C4,   C1 );
    vert[ 57] = new PVector(  -C3,   C4,  -C1 );
    vert[ 58] = new PVector(  -C3,  -C4,   C1 );
    vert[ 59] = new PVector(  -C3,  -C4,  -C1 );
    // set faces
    faces[  0] = new int[] {  0, 46, 12, 14, 44 };
    faces[  1] = new int[] {  1, 45, 15, 13, 47 };
    faces[  2] = new int[] {  2, 48, 18, 16, 50 };
    faces[  3] = new int[] {  3, 51, 17, 19, 49 };
    faces[  4] = new int[] {  4, 53, 20, 21, 52 };
    faces[  5] = new int[] {  5, 54, 23, 22, 55 };
    faces[  6] = new int[] {  6, 56, 25, 24, 57 };
    faces[  7] = new int[] {  7, 59, 26, 27, 58 };
    faces[  8] = new int[] {  8, 40, 28, 32, 36 };
    faces[  9] = new int[] {  9, 37, 33, 29, 41 };
    faces[ 10] = new int[] { 10, 38, 34, 30, 42 };
    faces[ 11] = new int[] { 11, 43, 31, 35, 39 };
    faces[ 12] = new int[] {  0, 16, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 13] = new int[] {  1, 19, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2, 14, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3, 13, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4, 22, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5, 21, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6, 27, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7, 24, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 29, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 32, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10, 35, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11, 30, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 28, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 41, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 42, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 31, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 36, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 33, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 34, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 39, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 12, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 47, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 44, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 15, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 50, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 17, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 18, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 49, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 20, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 52, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 55, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 23, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 57, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 25, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 26, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 58, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37, 45,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38, 46,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  1, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40, 48,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  3, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  2, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43, 51,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  4, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45, 53,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 54,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47,  5, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 56,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49,  6, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50,  7, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 59,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52,  8, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 37,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 38, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 11, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 40,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57,  9, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 10, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 43, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] {  0, 18, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] {  0, 36, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] {  1, 17, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] {  1, 39, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] {  2, 12, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] {  2, 42, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] {  3, 15, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] {  3, 41, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 21,  5, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 21, 13, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 22,  4, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 22, 14, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 25, 33, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 25, 51,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 26, 34, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 26, 48,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 28, 12, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 28, 53,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 31, 15, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 31, 54, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] { 32,  9, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] { 32, 24, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] { 35, 10, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] { 35, 27, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] { 45,  4, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] { 45, 37, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] { 46,  5, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] { 46, 38, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 49, 27,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 49, 57, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 50, 24,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 50, 58, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[104] = new int[] { 52, 29,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[105] = new int[] { 52, 36, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[106] = new int[] { 55, 30, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[107] = new int[] { 55, 39, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[108] = new int[] { 56,  8, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[109] = new int[] { 56, 48, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[110] = new int[] { 59, 11, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[111] = new int[] { 59, 51, 43, 43, 43 };  //added 2x 3rd row to fill gaps
  } //end SmallSnubIcosicosidodecahedron()

  public String name() {
    return "Small Snub Icosicosidodecahedron";
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
   
} //end class SmallSnubIcosicosidodecahedron
