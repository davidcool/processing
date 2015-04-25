/*
SmallHexagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallHexagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.267843693395936526330702957199;  //(1 - sqrt(5) + sqrt(2 * (3 * sqrt(5) - 1))) / 8
  final float C1  = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C2  = 0.433380199586931046495436031247;  //(sqrt(3 + 2 * sqrt(5)) - 1) / 4
  final float C3  = 0.576860687770883950432996374382;  //(sqrt(5) - 1 + sqrt(2 * (3 * sqrt(5) - 1))) / 8
  final float C4  = 0.725259131182936505697721826559;  //(1 + sqrt(5) + 2 * sqrt(3 + 2 * sqrt(5))) / 12
  final float C5  = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C6  = 0.933380199586931046495436031247;  //(1 + sqrt(3 + 2 * sqrt(5))) / 4
  final float C7  = 1.01024088735781499692843240563;   //(sqrt(5) - 3 + sqrt(2 * (19 + 9 * sqrt(5)))) / 8
  final float C8  = 1.17349392490520999795228827042;   //(3 + sqrt(5) + sqrt(2 * (19 + 9 * sqrt(5)))) / 12
  final float C9  = 1.201223892982867572826138988446;  //(3 - sqrt(5) + sqrt(2 * (19 + 9 * sqrt(5)))) / 8
  final float C10 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  final float C11 = 1.36676039917386209299087206249;   //sqrt(3 + 2 * sqrt(5)) / 2
  private PVector[] vert = new PVector[112]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallHexagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C1,  0.0,  C11 );
    vert[  1] = new PVector(   C1,  0.0, -C11 );
    vert[  2] = new PVector(  -C1,  0.0,  C11 );
    vert[  3] = new PVector(  -C1,  0.0, -C11 );
    vert[  4] = new PVector(  C11,   C1,  0.0 );
    vert[  5] = new PVector(  C11,  -C1,  0.0 );
    vert[  6] = new PVector( -C11,   C1,  0.0 );
    vert[  7] = new PVector( -C11,  -C1,  0.0 );
    vert[  8] = new PVector(  0.0,  C11,   C1 );
    vert[  9] = new PVector(  0.0,  C11,  -C1 );
    vert[ 10] = new PVector(  0.0, -C11,   C1 );
    vert[ 11] = new PVector(  0.0, -C11,  -C1 );
    vert[ 12] = new PVector(  0.0,  0.5,  C10 );
    vert[ 13] = new PVector(  0.0,  0.5,  C10 );
    vert[ 14] = new PVector(  0.0,  0.5, -C10 );
    vert[ 15] = new PVector(  0.0,  0.5, -C10 );
    vert[ 16] = new PVector(  0.0, -0.5,  C10 );
    vert[ 17] = new PVector(  0.0, -0.5,  C10 );
    vert[ 18] = new PVector(  0.0, -0.5, -C10 );
    vert[ 19] = new PVector(  0.0, -0.5, -C10 );
    vert[ 20] = new PVector(  C10,  0.0,  0.5 );
    vert[ 21] = new PVector(  C10,  0.0,  0.5 );
    vert[ 22] = new PVector(  C10,  0.0, -0.5 );
    vert[ 23] = new PVector(  C10,  0.0, -0.5 );
    vert[ 24] = new PVector( -C10,  0.0,  0.5 );
    vert[ 25] = new PVector( -C10,  0.0,  0.5 );
    vert[ 26] = new PVector( -C10,  0.0, -0.5 );
    vert[ 27] = new PVector( -C10,  0.0, -0.5 );
    vert[ 28] = new PVector(  0.5,  C10,  0.0 );
    vert[ 29] = new PVector(  0.5,  C10,  0.0 );
    vert[ 30] = new PVector(  0.5, -C10,  0.0 );
    vert[ 31] = new PVector(  0.5, -C10,  0.0 );
    vert[ 32] = new PVector( -0.5,  C10,  0.0 );
    vert[ 33] = new PVector( -0.5,  C10,  0.0 );
    vert[ 34] = new PVector( -0.5, -C10,  0.0 );
    vert[ 35] = new PVector( -0.5, -C10,  0.0 );
    vert[ 36] = new PVector(   C3,   C2,   C9 );
    vert[ 37] = new PVector(   C3,   C2,  -C9 );
    vert[ 38] = new PVector(   C3,  -C2,   C9 );
    vert[ 39] = new PVector(   C3,  -C2,  -C9 );
    vert[ 40] = new PVector(  -C3,   C2,   C9 );
    vert[ 41] = new PVector(  -C3,   C2,  -C9 );
    vert[ 42] = new PVector(  -C3,  -C2,   C9 );
    vert[ 43] = new PVector(  -C3,  -C2,  -C9 );
    vert[ 44] = new PVector(   C9,   C3,   C2 );
    vert[ 45] = new PVector(   C9,   C3,  -C2 );
    vert[ 46] = new PVector(   C9,  -C3,   C2 );
    vert[ 47] = new PVector(   C9,  -C3,  -C2 );
    vert[ 48] = new PVector(  -C9,   C3,   C2 );
    vert[ 49] = new PVector(  -C9,   C3,  -C2 );
    vert[ 50] = new PVector(  -C9,  -C3,   C2 );
    vert[ 51] = new PVector(  -C9,  -C3,  -C2 );
    vert[ 52] = new PVector(   C2,   C9,   C3 );
    vert[ 53] = new PVector(   C2,   C9,  -C3 );
    vert[ 54] = new PVector(   C2,  -C9,   C3 );
    vert[ 55] = new PVector(   C2,  -C9,  -C3 );
    vert[ 56] = new PVector(  -C2,   C9,   C3 );
    vert[ 57] = new PVector(  -C2,   C9,  -C3 );
    vert[ 58] = new PVector(  -C2,  -C9,   C3 );
    vert[ 59] = new PVector(  -C2,  -C9,  -C3 );
    vert[ 60] = new PVector(   C4,  0.0,   C8 );
    vert[ 61] = new PVector(   C4,  0.0,  -C8 );
    vert[ 62] = new PVector(  -C4,  0.0,   C8 );
    vert[ 63] = new PVector(  -C4,  0.0,  -C8 );
    vert[ 64] = new PVector(   C8,   C4,  0.0 );
    vert[ 65] = new PVector(   C8,  -C4,  0.0 );
    vert[ 66] = new PVector(  -C8,   C4,  0.0 );
    vert[ 67] = new PVector(  -C8,  -C4,  0.0 );
    vert[ 68] = new PVector(  0.0,   C8,   C4 );
    vert[ 69] = new PVector(  0.0,   C8,  -C4 );
    vert[ 70] = new PVector(  0.0,  -C8,   C4 );
    vert[ 71] = new PVector(  0.0,  -C8,  -C4 );
    vert[ 72] = new PVector(   C0,   C6,   C7 );
    vert[ 73] = new PVector(   C0,   C6,  -C7 );
    vert[ 74] = new PVector(   C0,  -C6,   C7 );
    vert[ 75] = new PVector(   C0,  -C6,  -C7 );
    vert[ 76] = new PVector(  -C0,   C6,   C7 );
    vert[ 77] = new PVector(  -C0,   C6,  -C7 );
    vert[ 78] = new PVector(  -C0,  -C6,   C7 );
    vert[ 79] = new PVector(  -C0,  -C6,  -C7 );
    vert[ 80] = new PVector(   C7,   C0,   C6 );
    vert[ 81] = new PVector(   C7,   C0,  -C6 );
    vert[ 82] = new PVector(   C7,  -C0,   C6 );
    vert[ 83] = new PVector(   C7,  -C0,  -C6 );
    vert[ 84] = new PVector(  -C7,   C0,   C6 );
    vert[ 85] = new PVector(  -C7,   C0,  -C6 );
    vert[ 86] = new PVector(  -C7,  -C0,   C6 );
    vert[ 87] = new PVector(  -C7,  -C0,  -C6 );
    vert[ 88] = new PVector(   C6,   C7,   C0 );
    vert[ 89] = new PVector(   C6,   C7,  -C0 );
    vert[ 90] = new PVector(   C6,  -C7,   C0 );
    vert[ 91] = new PVector(   C6,  -C7,  -C0 );
    vert[ 92] = new PVector(  -C6,   C7,   C0 );
    vert[ 93] = new PVector(  -C6,   C7,  -C0 );
    vert[ 94] = new PVector(  -C6,  -C7,   C0 );
    vert[ 95] = new PVector(  -C6,  -C7,  -C0 );
    vert[ 96] = new PVector(   C5,   C5,   C5 );
    vert[ 97] = new PVector(   C5,   C5,   C5 );
    vert[ 98] = new PVector(   C5,   C5,  -C5 );
    vert[ 99] = new PVector(   C5,   C5,  -C5 );
    vert[100] = new PVector(   C5,  -C5,   C5 );
    vert[101] = new PVector(   C5,  -C5,   C5 );
    vert[102] = new PVector(   C5,  -C5,  -C5 );
    vert[103] = new PVector(   C5,  -C5,  -C5 );
    vert[104] = new PVector(  -C5,   C5,   C5 );
    vert[105] = new PVector(  -C5,   C5,   C5 );
    vert[106] = new PVector(  -C5,   C5,  -C5 );
    vert[107] = new PVector(  -C5,   C5,  -C5 );
    vert[108] = new PVector(  -C5,  -C5,   C5 );
    vert[109] = new PVector(  -C5,  -C5,   C5 );
    vert[110] = new PVector(  -C5,  -C5,  -C5 );
    vert[111] = new PVector(  -C5,  -C5,  -C5 );
    // set faces
    faces[ 0] = new int[] { 60,   0,  17,  74, 100,  82 };
    faces[ 1] = new int[] { 60,  82,  20,  44,  97,  36 };
    faces[ 2] = new int[] { 60,  36,  12,   2,  16,  38 };
    faces[ 3] = new int[] { 60,  38, 101,  46,  21,  80 };
    faces[ 4] = new int[] { 60,  80,  96,  72,  13,   0 };
    faces[ 5] = new int[] { 61,   1,  15,  73,  98,  81 };
    faces[ 6] = new int[] { 61,  81,  22,  47, 103,  39 };
    faces[ 7] = new int[] { 61,  39,  18,   3,  14,  37 };
    faces[ 8] = new int[] { 61,  37,  99,  45,  23,  83 };
    faces[ 9] = new int[] { 61,  83, 102,  75,  19,   1 };
    faces[10] = new int[] { 62,   2,  12,  76, 104,  84 };
    faces[11] = new int[] { 62,  84,  25,  50, 109,  42 };
    faces[12] = new int[] { 62,  42,  17,   0,  13,  40 };
    faces[13] = new int[] { 62,  40, 105,  48,  24,  86 };
    faces[14] = new int[] { 62,  86, 108,  78,  16,   2 };
    faces[15] = new int[] { 63,   3,  18,  79, 110,  87 };
    faces[16] = new int[] { 63,  87,  27,  49, 107,  41 };
    faces[17] = new int[] { 63,  41,  15,   1,  19,  43 };
    faces[18] = new int[] { 63,  43, 111,  51,  26,  85 };
    faces[19] = new int[] { 63,  85, 106,  77,  14,   3 };
    faces[20] = new int[] { 64,   4,  22,  81,  98,  89 };
    faces[21] = new int[] { 64,  89,  29,  52,  97,  44 };
    faces[22] = new int[] { 64,  44,  20,   5,  23,  45 };
    faces[23] = new int[] { 64,  45,  99,  53,  28,  88 };
    faces[24] = new int[] { 64,  88,  96,  80,  21,   4 };
    faces[25] = new int[] { 65,   5,  20,  82, 100,  90 };
    faces[26] = new int[] { 65,  90,  31,  55, 103,  47 };
    faces[27] = new int[] { 65,  47,  22,   4,  21,  46 };
    faces[28] = new int[] { 65,  46, 101,  54,  30,  91 };
    faces[29] = new int[] { 65,  91, 102,  83,  23,   5 };
    faces[30] = new int[] { 66,   6,  25,  84, 104,  92 };
    faces[31] = new int[] { 66,  92,  32,  57, 107,  49 };
    faces[32] = new int[] { 66,  49,  27,   7,  24,  48 };
    faces[33] = new int[] { 66,  48, 105,  56,  33,  93 };
    faces[34] = new int[] { 66,  93, 106,  85,  26,   6 };
    faces[35] = new int[] { 67,   7,  27,  87, 110,  95 };
    faces[36] = new int[] { 67,  95,  34,  58, 109,  50 };
    faces[37] = new int[] { 67,  50,  25,   6,  26,  51 };
    faces[38] = new int[] { 67,  51, 111,  59,  35,  94 };
    faces[39] = new int[] { 67,  94, 108,  86,  24,   7 };
    faces[40] = new int[] { 68,   8,  32,  92, 104,  76 };
    faces[41] = new int[] { 68,  76,  12,  36,  97,  52 };
    faces[42] = new int[] { 68,  52,  29,   9,  33,  56 };
    faces[43] = new int[] { 68,  56, 105,  40,  13,  72 };
    faces[44] = new int[] { 68,  72,  96,  88,  28,   8 };
    faces[45] = new int[] { 69,   9,  29,  89,  98,  73 };
    faces[46] = new int[] { 69,  73,  15,  41, 107,  57 };
    faces[47] = new int[] { 69,  57,  32,   8,  28,  53 };
    faces[48] = new int[] { 69,  53,  99,  37,  14,  77 };
    faces[49] = new int[] { 69,  77, 106,  93,  33,   9 };
    faces[50] = new int[] { 70,  10,  31,  90, 100,  74 };
    faces[51] = new int[] { 70,  74,  17,  42, 109,  58 };
    faces[52] = new int[] { 70,  58,  34,  11,  30,  54 };
    faces[53] = new int[] { 70,  54, 101,  38,  16,  78 };
    faces[54] = new int[] { 70,  78, 108,  94,  35,  10 };
    faces[55] = new int[] { 71,  11,  34,  95, 110,  79 };
    faces[56] = new int[] { 71,  79,  18,  39, 103,  55 };
    faces[57] = new int[] { 71,  55,  31,  10,  35,  59 };
    faces[58] = new int[] { 71,  59, 111,  43,  19,  75 };
    faces[59] = new int[] { 71,  75, 102,  91,  30,  11 };
  } //end SmallHexagonalHexecontahedron()

  public String name() {
    return "Small Hexagonal Hexecontahedron";
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
   
} //end class SmallHexagonalHexecontahedron
