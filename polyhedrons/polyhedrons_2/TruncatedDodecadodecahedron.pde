/*
TruncatedDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 54;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C3 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C4 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  final float C5 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  final float C6 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[120]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TruncatedDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C1,   C0,   C6 );
    vert[  1] = new PVector(   C1,   C0,  -C6 );
    vert[  2] = new PVector(   C1,  -C0,   C6 );
    vert[  3] = new PVector(   C1,  -C0,  -C6 );
    vert[  4] = new PVector(  -C1,   C0,   C6 );
    vert[  5] = new PVector(  -C1,   C0,  -C6 );
    vert[  6] = new PVector(  -C1,  -C0,   C6 );
    vert[  7] = new PVector(  -C1,  -C0,  -C6 );
    vert[  8] = new PVector(   C6,   C1,   C0 );
    vert[  9] = new PVector(   C6,   C1,  -C0 );
    vert[ 10] = new PVector(   C6,  -C1,   C0 );
    vert[ 11] = new PVector(   C6,  -C1,  -C0 );
    vert[ 12] = new PVector(  -C6,   C1,   C0 );
    vert[ 13] = new PVector(  -C6,   C1,  -C0 );
    vert[ 14] = new PVector(  -C6,  -C1,   C0 );
    vert[ 15] = new PVector(  -C6,  -C1,  -C0 );
    vert[ 16] = new PVector(   C0,   C6,   C1 );
    vert[ 17] = new PVector(   C0,   C6,  -C1 );
    vert[ 18] = new PVector(   C0,  -C6,   C1 );
    vert[ 19] = new PVector(   C0,  -C6,  -C1 );
    vert[ 20] = new PVector(  -C0,   C6,   C1 );
    vert[ 21] = new PVector(  -C0,   C6,  -C1 );
    vert[ 22] = new PVector(  -C0,  -C6,   C1 );
    vert[ 23] = new PVector(  -C0,  -C6,  -C1 );
    vert[ 24] = new PVector(  0.5,  0.5,  1.5 );
    vert[ 25] = new PVector(  0.5,  0.5, -1.5 );
    vert[ 26] = new PVector(  0.5, -0.5,  1.5 );
    vert[ 27] = new PVector(  0.5, -0.5, -1.5 );
    vert[ 28] = new PVector( -0.5,  0.5,  1.5 );
    vert[ 29] = new PVector( -0.5,  0.5, -1.5 );
    vert[ 30] = new PVector( -0.5, -0.5,  1.5 );
    vert[ 31] = new PVector( -0.5, -0.5, -1.5 );
    vert[ 32] = new PVector(  1.5,  0.5,  0.5 );
    vert[ 33] = new PVector(  1.5,  0.5, -0.5 );
    vert[ 34] = new PVector(  1.5, -0.5,  0.5 );
    vert[ 35] = new PVector(  1.5, -0.5, -0.5 );
    vert[ 36] = new PVector( -1.5,  0.5,  0.5 );
    vert[ 37] = new PVector( -1.5,  0.5, -0.5 );
    vert[ 38] = new PVector( -1.5, -0.5,  0.5 );
    vert[ 39] = new PVector( -1.5, -0.5, -0.5 );
    vert[ 40] = new PVector(  0.5,  1.5,  0.5 );
    vert[ 41] = new PVector(  0.5,  1.5, -0.5 );
    vert[ 42] = new PVector(  0.5, -1.5,  0.5 );
    vert[ 43] = new PVector(  0.5, -1.5, -0.5 );
    vert[ 44] = new PVector( -0.5,  1.5,  0.5 );
    vert[ 45] = new PVector( -0.5,  1.5, -0.5 );
    vert[ 46] = new PVector( -0.5, -1.5,  0.5 );
    vert[ 47] = new PVector( -0.5, -1.5, -0.5 );
    vert[ 48] = new PVector(   C0,  1.0,   C5 );
    vert[ 49] = new PVector(   C0,  1.0,  -C5 );
    vert[ 50] = new PVector(   C0, -1.0,   C5 );
    vert[ 51] = new PVector(   C0, -1.0,  -C5 );
    vert[ 52] = new PVector(  -C0,  1.0,   C5 );
    vert[ 53] = new PVector(  -C0,  1.0,  -C5 );
    vert[ 54] = new PVector(  -C0, -1.0,   C5 );
    vert[ 55] = new PVector(  -C0, -1.0,  -C5 );
    vert[ 56] = new PVector(   C5,   C0,  1.0 );
    vert[ 57] = new PVector(   C5,   C0, -1.0 );
    vert[ 58] = new PVector(   C5,  -C0,  1.0 );
    vert[ 59] = new PVector(   C5,  -C0, -1.0 );
    vert[ 60] = new PVector(  -C5,   C0,  1.0 );
    vert[ 61] = new PVector(  -C5,   C0, -1.0 );
    vert[ 62] = new PVector(  -C5,  -C0,  1.0 );
    vert[ 63] = new PVector(  -C5,  -C0, -1.0 );
    vert[ 64] = new PVector(  1.0,   C5,   C0 );
    vert[ 65] = new PVector(  1.0,   C5,  -C0 );
    vert[ 66] = new PVector(  1.0,  -C5,   C0 );
    vert[ 67] = new PVector(  1.0,  -C5,  -C0 );
    vert[ 68] = new PVector( -1.0,   C5,   C0 );
    vert[ 69] = new PVector( -1.0,   C5,  -C0 );
    vert[ 70] = new PVector( -1.0,  -C5,   C0 );
    vert[ 71] = new PVector( -1.0,  -C5,  -C0 );
    vert[ 72] = new PVector(   C3,   C2,   C5 );
    vert[ 73] = new PVector(   C3,   C2,  -C5 );
    vert[ 74] = new PVector(   C3,  -C2,   C5 );
    vert[ 75] = new PVector(   C3,  -C2,  -C5 );
    vert[ 76] = new PVector(  -C3,   C2,   C5 );
    vert[ 77] = new PVector(  -C3,   C2,  -C5 );
    vert[ 78] = new PVector(  -C3,  -C2,   C5 );
    vert[ 79] = new PVector(  -C3,  -C2,  -C5 );
    vert[ 80] = new PVector(   C5,   C3,   C2 );
    vert[ 81] = new PVector(   C5,   C3,  -C2 );
    vert[ 82] = new PVector(   C5,  -C3,   C2 );
    vert[ 83] = new PVector(   C5,  -C3,  -C2 );
    vert[ 84] = new PVector(  -C5,   C3,   C2 );
    vert[ 85] = new PVector(  -C5,   C3,  -C2 );
    vert[ 86] = new PVector(  -C5,  -C3,   C2 );
    vert[ 87] = new PVector(  -C5,  -C3,  -C2 );
    vert[ 88] = new PVector(   C2,   C5,   C3 );
    vert[ 89] = new PVector(   C2,   C5,  -C3 );
    vert[ 90] = new PVector(   C2,  -C5,   C3 );
    vert[ 91] = new PVector(   C2,  -C5,  -C3 );
    vert[ 92] = new PVector(  -C2,   C5,   C3 );
    vert[ 93] = new PVector(  -C2,   C5,  -C3 );
    vert[ 94] = new PVector(  -C2,  -C5,   C3 );
    vert[ 95] = new PVector(  -C2,  -C5,  -C3 );
    vert[ 96] = new PVector(  0.5,   C4,   C4 );
    vert[ 97] = new PVector(  0.5,   C4,  -C4 );
    vert[ 98] = new PVector(  0.5,  -C4,   C4 );
    vert[ 99] = new PVector(  0.5,  -C4,  -C4 );
    vert[100] = new PVector( -0.5,   C4,   C4 );
    vert[101] = new PVector( -0.5,   C4,  -C4 );
    vert[102] = new PVector( -0.5,  -C4,   C4 );
    vert[103] = new PVector( -0.5,  -C4,  -C4 );
    vert[104] = new PVector(   C4,  0.5,   C4 );
    vert[105] = new PVector(   C4,  0.5,  -C4 );
    vert[106] = new PVector(   C4, -0.5,   C4 );
    vert[107] = new PVector(   C4, -0.5,  -C4 );
    vert[108] = new PVector(  -C4,  0.5,   C4 );
    vert[109] = new PVector(  -C4,  0.5,  -C4 );
    vert[110] = new PVector(  -C4, -0.5,   C4 );
    vert[111] = new PVector(  -C4, -0.5,  -C4 );
    vert[112] = new PVector(   C4,   C4,  0.5 );
    vert[113] = new PVector(   C4,   C4, -0.5 );
    vert[114] = new PVector(   C4,  -C4,  0.5 );
    vert[115] = new PVector(   C4,  -C4, -0.5 );
    vert[116] = new PVector(  -C4,   C4,  0.5 );
    vert[117] = new PVector(  -C4,   C4, -0.5 );
    vert[118] = new PVector(  -C4,  -C4,  0.5 );
    vert[119] = new PVector(  -C4,  -C4, -0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  74,  56,  24,  26,  58,  72,   2, 106, 104 };
    faces[ 1] = new int[] {  1, 105, 107,   3,  73,  59,  27,  25,  57,  75 };
    faces[ 2] = new int[] {  4, 108, 110,   6,  76,  62,  30,  28,  60,  78 };
    faces[ 3] = new int[] {  5,  79,  61,  29,  31,  63,  77,   7, 111, 109 };
    faces[ 4] = new int[] {  8,  81,  64,  32,  33,  65,  80,   9, 113, 112 };
    faces[ 5] = new int[] { 10, 114, 115,  11,  82,  67,  35,  34,  66,  83 };
    faces[ 6] = new int[] { 12, 116, 117,  13,  84,  69,  37,  36,  68,  85 };
    faces[ 7] = new int[] { 14,  87,  70,  38,  39,  71,  86,  15, 119, 118 };
    faces[ 8] = new int[] { 16,  92,  48,  40,  44,  52,  88,  20, 100,  96 };
    faces[ 9] = new int[] { 17,  97, 101,  21,  89,  53,  45,  41,  49,  93 };
    faces[10] = new int[] { 18,  98, 102,  22,  90,  54,  46,  42,  50,  94 };
    faces[11] = new int[] { 19,  95,  51,  43,  47,  55,  91,  23, 103,  99 };
    faces[12] = new int[] {  0,  52,  44,  45,  53,   1,  75, 115, 114,  74 };
    faces[13] = new int[] {  2,  72, 112, 113,  73,   3,  55,  47,  46,  54 };
    faces[14] = new int[] {  4,  78, 118, 119,  79,   5,  49,  41,  40,  48 };
    faces[15] = new int[] {  6,  50,  42,  43,  51,   7,  77, 117, 116,  76 };
    faces[16] = new int[] {  8,  58,  26,  30,  62,  12,  85, 101,  97,  81 };
    faces[17] = new int[] {  9,  80,  96, 100,  84,  13,  63,  31,  27,  59 };
    faces[18] = new int[] { 10,  83,  99, 103,  87,  14,  60,  28,  24,  56 };
    faces[19] = new int[] { 11,  57,  25,  29,  61,  15,  86, 102,  98,  82 };
    faces[20] = new int[] { 16,  65,  33,  35,  67,  18,  94, 110, 108,  92 };
    faces[21] = new int[] { 17,  93, 109, 111,  95,  19,  66,  34,  32,  64 };
    faces[22] = new int[] { 20,  88, 104, 106,  90,  22,  71,  39,  37,  69 };
    faces[23] = new int[] { 21,  68,  36,  38,  70,  23,  91, 107, 105,  89 };
    faces[24] = new int[] {  0, 104,  88,  52,  52,  52,  52,  52,  52,  52 };  //added 6x 4th number to fill gap
    faces[25] = new int[] {  1,  53,  89, 105, 105, 105, 105, 105, 105, 105 };  //added 6x 4th number to fill gap
    faces[26] = new int[] {  2,  54,  90, 106, 106, 106, 106, 106, 106, 106 };  //added 6x 4th number to fill gap
    faces[27] = new int[] {  3, 107,  91,  55,  55,  55,  55,  55,  55,  55 };  //added 6x 4th number to fill gap
    faces[28] = new int[] {  4,  48,  92, 108, 108, 108, 108, 108, 108, 108 };  //added 6x 4th number to fill gap
    faces[29] = new int[] {  5, 109,  93,  49,  49,  49,  49,  49,  49,  49 };  //added 6x 4th number to fill gap
    faces[30] = new int[] {  6, 110,  94,  50,  50,  50,  50,  50,  50,  50 };  //added 6x 4th number to fill gap
    faces[31] = new int[] {  7,  51,  95, 111, 111, 111, 111, 111, 111, 111 };  //added 6x 4th number to fill gap
    faces[32] = new int[] {  8, 112,  72,  58,  58,  58,  58,  58,  58,  58 };  //added 6x 4th number to fill gap
    faces[33] = new int[] {  9,  59,  73, 113, 113, 113, 113, 113, 113, 113 };  //added 6x 4th number to fill gap
    faces[34] = new int[] { 10,  56,  74, 114, 114, 114, 114, 114, 114, 114 };  //added 6x 4th number to fill gap
    faces[35] = new int[] { 11, 115,  75,  57,  57,  57,  57,  57,  57,  57 };  //added 6x 4th number to fill gap
    faces[36] = new int[] { 12,  62,  76, 116, 116, 116, 116, 116, 116, 116 };  //added 6x 4th number to fill gap
    faces[37] = new int[] { 13, 117,  77,  63,  63,  63,  63,  63,  63,  63 };  //added 6x 4th number to fill gap
    faces[38] = new int[] { 14, 118,  78,  60,  60,  60,  60,  60,  60,  60 };  //added 6x 4th number to fill gap
    faces[39] = new int[] { 15,  61,  79, 119, 119, 119, 119, 119, 119, 119 };  //added 6x 4th number to fill gap
    faces[40] = new int[] { 16,  96,  80,  65,  65,  65,  65,  65,  65,  65 };  //added 6x 4th number to fill gap
    faces[41] = new int[] { 17,  64,  81,  97,  97,  97,  97,  97,  97,  97 };  //added 6x 4th number to fill gap
    faces[42] = new int[] { 18,  67,  82,  98,  98,  98,  98,  98,  98,  98 };  //added 6x 4th number to fill gap
    faces[43] = new int[] { 19,  99,  83,  66,  66,  66,  66,  66,  66,  66 };  //added 6x 4th number to fill gap
    faces[44] = new int[] { 20,  69,  84, 100, 100, 100, 100, 100, 100, 100 };  //added 6x 4th number to fill gap
    faces[45] = new int[] { 21, 101,  85,  68,  68,  68,  68,  68,  68,  68 };  //added 6x 4th number to fill gap
    faces[46] = new int[] { 22, 102,  86,  71,  71,  71,  71,  71,  71,  71 };  //added 6x 4th number to fill gap
    faces[47] = new int[] { 23,  70,  87, 103, 103, 103, 103, 103, 103, 103 };  //added 6x 4th number to fill gap
    faces[48] = new int[] { 24,  28,  30,  26,  26,  26,  26,  26,  26,  26 };  //added 6x 4th number to fill gap
    faces[49] = new int[] { 25,  27,  31,  29,  29,  29,  29,  29,  29,  29 };  //added 6x 4th number to fill gap
    faces[50] = new int[] { 32,  34,  35,  33,  33,  33,  33,  33,  33,  33 };  //added 6x 4th number to fill gap
    faces[51] = new int[] { 36,  37,  39,  38,  38,  38,  38,  38,  38,  38 };  //added 6x 4th number to fill gap
    faces[52] = new int[] { 40,  41,  45,  44,  44,  44,  44,  44,  44,  44 };  //added 6x 4th number to fill gap
    faces[53] = new int[] { 42,  46,  47,  43,  43,  43,  43,  43,  43,  43 };  //added 6x 4th number to fill gap
  } //end TruncatedDodecadodecahedron()

  public String name() {
    return "Truncated Dodecadodecahedron";
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
   
} //end class TruncatedDodecadodecahedron
