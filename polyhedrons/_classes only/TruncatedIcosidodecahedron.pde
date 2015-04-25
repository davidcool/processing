/*
TruncatedIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 62;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  final float C1 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C2 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  final float C3 = 2.11803398874989484820458683437;   //(2 + sqrt(5)) / 2
  final float C4 = 2.427050983124842272306880251548;  //3 * (1 + sqrt(5)) / 4
  final float C5 = 2.61803398874989484820458683437;   //(3 + sqrt(5)) / 2
  final float C6 = 2.927050983124842272306880251548;  //(5 + 3 * sqrt(5)) / 4
  final float C7 = 3.11803398874989484820458683437;   //(4 + sqrt(5)) / 2
  final float C8 = 3.427050983124842272306880251548;  //(7 + 3 * sqrt(5)) / 4
  final float C9 = 3.73606797749978969640917366873;   //(3 + 2 * sqrt(5)) / 2
  private PVector[] vert = new PVector[120]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5,  0.5,   C9 );
    vert[  1] = new PVector(  0.5,  0.5,  -C9 );
    vert[  2] = new PVector(  0.5, -0.5,   C9 );
    vert[  3] = new PVector(  0.5, -0.5,  -C9 );
    vert[  4] = new PVector( -0.5,  0.5,   C9 );
    vert[  5] = new PVector( -0.5,  0.5,  -C9 );
    vert[  6] = new PVector( -0.5, -0.5,   C9 );
    vert[  7] = new PVector( -0.5, -0.5,  -C9 );
    vert[  8] = new PVector(   C9,  0.5,  0.5 );
    vert[  9] = new PVector(   C9,  0.5, -0.5 );
    vert[ 10] = new PVector(   C9, -0.5,  0.5 );
    vert[ 11] = new PVector(   C9, -0.5, -0.5 );
    vert[ 12] = new PVector(  -C9,  0.5,  0.5 );
    vert[ 13] = new PVector(  -C9,  0.5, -0.5 );
    vert[ 14] = new PVector(  -C9, -0.5,  0.5 );
    vert[ 15] = new PVector(  -C9, -0.5, -0.5 );
    vert[ 16] = new PVector(  0.5,   C9,  0.5 );
    vert[ 17] = new PVector(  0.5,   C9, -0.5 );
    vert[ 18] = new PVector(  0.5,  -C9,  0.5 );
    vert[ 19] = new PVector(  0.5,  -C9, -0.5 );
    vert[ 20] = new PVector( -0.5,   C9,  0.5 );
    vert[ 21] = new PVector( -0.5,   C9, -0.5 );
    vert[ 22] = new PVector( -0.5,  -C9,  0.5 );
    vert[ 23] = new PVector( -0.5,  -C9, -0.5 );
    vert[ 24] = new PVector(  1.0,   C0,   C8 );
    vert[ 25] = new PVector(  1.0,   C0,  -C8 );
    vert[ 26] = new PVector(  1.0,  -C0,   C8 );
    vert[ 27] = new PVector(  1.0,  -C0,  -C8 );
    vert[ 28] = new PVector( -1.0,   C0,   C8 );
    vert[ 29] = new PVector( -1.0,   C0,  -C8 );
    vert[ 30] = new PVector( -1.0,  -C0,   C8 );
    vert[ 31] = new PVector( -1.0,  -C0,  -C8 );
    vert[ 32] = new PVector(   C8,  1.0,   C0 );
    vert[ 33] = new PVector(   C8,  1.0,  -C0 );
    vert[ 34] = new PVector(   C8, -1.0,   C0 );
    vert[ 35] = new PVector(   C8, -1.0,  -C0 );
    vert[ 36] = new PVector(  -C8,  1.0,   C0 );
    vert[ 37] = new PVector(  -C8,  1.0,  -C0 );
    vert[ 38] = new PVector(  -C8, -1.0,   C0 );
    vert[ 39] = new PVector(  -C8, -1.0,  -C0 );
    vert[ 40] = new PVector(   C0,   C8,  1.0 );
    vert[ 41] = new PVector(   C0,   C8, -1.0 );
    vert[ 42] = new PVector(   C0,  -C8,  1.0 );
    vert[ 43] = new PVector(   C0,  -C8, -1.0 );
    vert[ 44] = new PVector(  -C0,   C8,  1.0 );
    vert[ 45] = new PVector(  -C0,   C8, -1.0 );
    vert[ 46] = new PVector(  -C0,  -C8,  1.0 );
    vert[ 47] = new PVector(  -C0,  -C8, -1.0 );
    vert[ 48] = new PVector(  0.5,   C3,   C7 );
    vert[ 49] = new PVector(  0.5,   C3,  -C7 );
    vert[ 50] = new PVector(  0.5,  -C3,   C7 );
    vert[ 51] = new PVector(  0.5,  -C3,  -C7 );
    vert[ 52] = new PVector( -0.5,   C3,   C7 );
    vert[ 53] = new PVector( -0.5,   C3,  -C7 );
    vert[ 54] = new PVector( -0.5,  -C3,   C7 );
    vert[ 55] = new PVector( -0.5,  -C3,  -C7 );
    vert[ 56] = new PVector(   C7,  0.5,   C3 );
    vert[ 57] = new PVector(   C7,  0.5,  -C3 );
    vert[ 58] = new PVector(   C7, -0.5,   C3 );
    vert[ 59] = new PVector(   C7, -0.5,  -C3 );
    vert[ 60] = new PVector(  -C7,  0.5,   C3 );
    vert[ 61] = new PVector(  -C7,  0.5,  -C3 );
    vert[ 62] = new PVector(  -C7, -0.5,   C3 );
    vert[ 63] = new PVector(  -C7, -0.5,  -C3 );
    vert[ 64] = new PVector(   C3,   C7,  0.5 );
    vert[ 65] = new PVector(   C3,   C7, -0.5 );
    vert[ 66] = new PVector(   C3,  -C7,  0.5 );
    vert[ 67] = new PVector(   C3,  -C7, -0.5 );
    vert[ 68] = new PVector(  -C3,   C7,  0.5 );
    vert[ 69] = new PVector(  -C3,   C7, -0.5 );
    vert[ 70] = new PVector(  -C3,  -C7,  0.5 );
    vert[ 71] = new PVector(  -C3,  -C7, -0.5 );
    vert[ 72] = new PVector(   C2,   C1,   C6 );
    vert[ 73] = new PVector(   C2,   C1,  -C6 );
    vert[ 74] = new PVector(   C2,  -C1,   C6 );
    vert[ 75] = new PVector(   C2,  -C1,  -C6 );
    vert[ 76] = new PVector(  -C2,   C1,   C6 );
    vert[ 77] = new PVector(  -C2,   C1,  -C6 );
    vert[ 78] = new PVector(  -C2,  -C1,   C6 );
    vert[ 79] = new PVector(  -C2,  -C1,  -C6 );
    vert[ 80] = new PVector(   C6,   C2,   C1 );
    vert[ 81] = new PVector(   C6,   C2,  -C1 );
    vert[ 82] = new PVector(   C6,  -C2,   C1 );
    vert[ 83] = new PVector(   C6,  -C2,  -C1 );
    vert[ 84] = new PVector(  -C6,   C2,   C1 );
    vert[ 85] = new PVector(  -C6,   C2,  -C1 );
    vert[ 86] = new PVector(  -C6,  -C2,   C1 );
    vert[ 87] = new PVector(  -C6,  -C2,  -C1 );
    vert[ 88] = new PVector(   C1,   C6,   C2 );
    vert[ 89] = new PVector(   C1,   C6,  -C2 );
    vert[ 90] = new PVector(   C1,  -C6,   C2 );
    vert[ 91] = new PVector(   C1,  -C6,  -C2 );
    vert[ 92] = new PVector(  -C1,   C6,   C2 );
    vert[ 93] = new PVector(  -C1,   C6,  -C2 );
    vert[ 94] = new PVector(  -C1,  -C6,   C2 );
    vert[ 95] = new PVector(  -C1,  -C6,  -C2 );
    vert[ 96] = new PVector(   C0,   C4,   C5 );
    vert[ 97] = new PVector(   C0,   C4,  -C5 );
    vert[ 98] = new PVector(   C0,  -C4,   C5 );
    vert[ 99] = new PVector(   C0,  -C4,  -C5 );
    vert[100] = new PVector(  -C0,   C4,   C5 );
    vert[101] = new PVector(  -C0,   C4,  -C5 );
    vert[102] = new PVector(  -C0,  -C4,   C5 );
    vert[103] = new PVector(  -C0,  -C4,  -C5 );
    vert[104] = new PVector(   C5,   C0,   C4 );
    vert[105] = new PVector(   C5,   C0,  -C4 );
    vert[106] = new PVector(   C5,  -C0,   C4 );
    vert[107] = new PVector(   C5,  -C0,  -C4 );
    vert[108] = new PVector(  -C5,   C0,   C4 );
    vert[109] = new PVector(  -C5,   C0,  -C4 );
    vert[110] = new PVector(  -C5,  -C0,   C4 );
    vert[111] = new PVector(  -C5,  -C0,  -C4 );
    vert[112] = new PVector(   C4,   C5,   C0 );
    vert[113] = new PVector(   C4,   C5,  -C0 );
    vert[114] = new PVector(   C4,  -C5,   C0 );
    vert[115] = new PVector(   C4,  -C5,  -C0 );
    vert[116] = new PVector(  -C4,   C5,   C0 );
    vert[117] = new PVector(  -C4,   C5,  -C0 );
    vert[118] = new PVector(  -C4,  -C5,   C0 );
    vert[119] = new PVector(  -C4,  -C5,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0,   2,  26,  74, 106,  58,  56, 104,  72,  24 };
    faces[ 1] = new int[] {  1,  25,  73, 105,  57,  59, 107,  75,  27,   3 };
    faces[ 2] = new int[] {  4,  28,  76, 108,  60,  62, 110,  78,  30,   6 };
    faces[ 3] = new int[] {  5,   7,  31,  79, 111,  63,  61, 109,  77,  29 };
    faces[ 4] = new int[] {  8,   9,  33,  81, 113,  65,  64, 112,  80,  32 };
    faces[ 5] = new int[] { 10,  34,  82, 114,  66,  67, 115,  83,  35,  11 };
    faces[ 6] = new int[] { 12,  36,  84, 116,  68,  69, 117,  85,  37,  13 };
    faces[ 7] = new int[] { 14,  15,  39,  87, 119,  71,  70, 118,  86,  38 };
    faces[ 8] = new int[] { 16,  20,  44,  92, 100,  52,  48,  96,  88,  40 };
    faces[ 9] = new int[] { 17,  41,  89,  97,  49,  53, 101,  93,  45,  21 };
    faces[10] = new int[] { 18,  42,  90,  98,  50,  54, 102,  94,  46,  22 };
    faces[11] = new int[] { 19,  23,  47,  95, 103,  55,  51,  99,  91,  43 };
    faces[12] = new int[] {  0,  24,  48,  52,  28,   4,   4,   4,   4,   4 };  //added 4x 6th number to fill gap
    faces[13] = new int[] {  1,   5,  29,  53,  49,  25,  25,  25,  25,  25 };  //added 4x 6th number to fill gap
    faces[14] = new int[] {  2,   6,  30,  54,  50,  26,  26,  26,  26,  26 };  //added 4x 6th number to fill gap
    faces[15] = new int[] {  3,  27,  51,  55,  31,   7,   7,   7,   7,   7 };  //added 4x 6th number to fill gap
    faces[16] = new int[] {  8,  32,  56,  58,  34,  10,  10,  10,  10,  10 };  //added 4x 6th number to fill gap
    faces[17] = new int[] {  9,  11,  35,  59,  57,  33,  33,  33,  33,  33 };  //added 4x 6th number to fill gap
    faces[18] = new int[] { 12,  14,  38,  62,  60,  36,  36,  36,  36,  36 };  //added 4x 6th number to fill gap
    faces[19] = new int[] { 13,  37,  61,  63,  39,  15,  15,  15,  15,  15 };  //added 4x 6th number to fill gap
    faces[20] = new int[] { 16,  40,  64,  65,  41,  17,  17,  17,  17,  17 };  //added 4x 6th number to fill gap
    faces[21] = new int[] { 18,  19,  43,  67,  66,  42,  42,  42,  42,  42 };  //added 4x 6th number to fill gap
    faces[22] = new int[] { 20,  21,  45,  69,  68,  44,  44,  44,  44,  44 };  //added 4x 6th number to fill gap
    faces[23] = new int[] { 22,  46,  70,  71,  47,  23,  23,  23,  23,  23 };  //added 4x 6th number to fill gap
    faces[24] = new int[] { 72, 104,  80, 112,  88,  96,  96,  96,  96,  96 };  //added 4x 6th number to fill gap
    faces[25] = new int[] { 73,  97,  89, 113,  81, 105, 105, 105, 105, 105 };  //added 4x 6th number to fill gap
    faces[26] = new int[] { 74,  98,  90, 114,  82, 106, 106, 106, 106, 106 };  //added 4x 6th number to fill gap
    faces[27] = new int[] { 75, 107,  83, 115,  91,  99,  99,  99,  99,  99 };  //added 4x 6th number to fill gap
    faces[28] = new int[] { 76, 100,  92, 116,  84, 108, 108, 108, 108, 108 };  //added 4x 6th number to fill gap
    faces[29] = new int[] { 77, 109,  85, 117,  93, 101, 101, 101, 101, 101 };  //added 4x 6th number to fill gap
    faces[30] = new int[] { 78, 110,  86, 118,  94, 102, 102, 102, 102, 102 };  //added 4x 6th number to fill gap
    faces[31] = new int[] { 79, 103,  95, 119,  87, 111, 111, 111, 111, 111 };  //added 4x 6th number to fill gap
    faces[32] = new int[] {  0,   4,   6,   2,   2,   2,   2,   2,   2,   2 };  //added 6x 4th number to fill gap
    faces[33] = new int[] {  1,   3,   7,   5,   5,   5,   5,   5,   5,   5 };  //added 6x 4th number to fill gap
    faces[34] = new int[] {  8,  10,  11,   9,   9,   9,   9,   9,   9,   9 };  //added 6x 4th number to fill gap
    faces[35] = new int[] { 12,  13,  15,  14,  14,  14,  14,  14,  14,  14 };  //added 6x 4th number to fill gap
    faces[36] = new int[] { 16,  17,  21,  20,  20,  20,  20,  20,  20,  20 };  //added 6x 4th number to fill gap
    faces[37] = new int[] { 18,  22,  23,  19,  19,  19,  19,  19,  19,  19 };  //added 6x 4th number to fill gap
    faces[38] = new int[] { 24,  72,  96,  48,  48,  48,  48,  48,  48,  48 };  //added 6x 4th number to fill gap
    faces[39] = new int[] { 25,  49,  97,  73,  73,  73,  73,  73,  73,  73 };  //added 6x 4th number to fill gap
    faces[40] = new int[] { 26,  50,  98,  74,  74,  74,  74,  74,  74,  74 };  //added 6x 4th number to fill gap
    faces[41] = new int[] { 27,  75,  99,  51,  51,  51,  51,  51,  51,  51 };  //added 6x 4th number to fill gap
    faces[42] = new int[] { 28,  52, 100,  76,  76,  76,  76,  76,  76,  76 };  //added 6x 4th number to fill gap
    faces[43] = new int[] { 29,  77, 101,  53,  53,  53,  53,  53,  53,  53 };  //added 6x 4th number to fill gap
    faces[44] = new int[] { 30,  78, 102,  54,  54,  54,  54,  54,  54,  54 };  //added 6x 4th number to fill gap
    faces[45] = new int[] { 31,  55, 103,  79,  79,  79,  79,  79,  79,  79 };  //added 6x 4th number to fill gap
    faces[46] = new int[] { 32,  80, 104,  56,  56,  56,  56,  56,  56,  56 };  //added 6x 4th number to fill gap
    faces[47] = new int[] { 33,  57, 105,  81,  81,  81,  81,  81,  81,  81 };  //added 6x 4th number to fill gap
    faces[48] = new int[] { 34,  58, 106,  82,  82,  82,  82,  82,  82,  82 };  //added 6x 4th number to fill gap
    faces[49] = new int[] { 35,  83, 107,  59,  59,  59,  59,  59,  59,  59 };  //added 6x 4th number to fill gap
    faces[50] = new int[] { 36,  60, 108,  84,  84,  84,  84,  84,  84,  84 };  //added 6x 4th number to fill gap
    faces[51] = new int[] { 37,  85, 109,  61,  61,  61,  61,  61,  61,  61 };  //added 6x 4th number to fill gap
    faces[52] = new int[] { 38,  86, 110,  62,  62,  62,  62,  62,  62,  62 };  //added 6x 4th number to fill gap
    faces[53] = new int[] { 39,  63, 111,  87,  87,  87,  87,  87,  87,  87 };  //added 6x 4th number to fill gap
    faces[54] = new int[] { 40,  88, 112,  64,  64,  64,  64,  64,  64,  64 };  //added 6x 4th number to fill gap
    faces[55] = new int[] { 41,  65, 113,  89,  89,  89,  89,  89,  89,  89 };  //added 6x 4th number to fill gap
    faces[56] = new int[] { 42,  66, 114,  90,  90,  90,  90,  90,  90,  90 };  //added 6x 4th number to fill gap
    faces[57] = new int[] { 43,  91, 115,  67,  67,  67,  67,  67,  67,  67 };  //added 6x 4th number to fill gap
    faces[58] = new int[] { 44,  68, 116,  92,  92,  92,  92,  92,  92,  92 };  //added 6x 4th number to fill gap
    faces[59] = new int[] { 45,  93, 117,  69,  69,  69,  69,  69,  69,  69 };  //added 6x 4th number to fill gap
    faces[60] = new int[] { 46,  94, 118,  70,  70,  70,  70,  70,  70,  70 };  //added 6x 4th number to fill gap
    faces[61] = new int[] { 47,  71, 119,  95,  95,  95,  95,  95,  95,  95 };  //added 6x 4th number to fill gap
  } //end TruncatedIcosidodecahedron()

  public String name() {
    return "Truncated Icosidodecahedron";
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
   
} //end class TruncatedIcosidodecahedron
