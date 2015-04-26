/*
IcositruncatedDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class IcositruncatedDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C1 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C2 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  final float C3 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  final float C4 = 1.427050983124842272306880251548;  //(3 * sqrt(5) - 1) / 4
  final float C5 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C6 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  final float C7 = 1.927050983124842272306880251548;  //(1 + 3 * sqrt(5)) / 4
  private PVector[] vert = new PVector[120]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private IcositruncatedDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5,   C0,   C7 );
    vert[  1] = new PVector(  0.5,   C0,  -C7 );
    vert[  2] = new PVector(  0.5,  -C0,   C7 );
    vert[  3] = new PVector(  0.5,  -C0,  -C7 );
    vert[  4] = new PVector( -0.5,   C0,   C7 );
    vert[  5] = new PVector( -0.5,   C0,  -C7 );
    vert[  6] = new PVector( -0.5,  -C0,   C7 );
    vert[  7] = new PVector( -0.5,  -C0,  -C7 );
    vert[  8] = new PVector(   C7,  0.5,   C0 );
    vert[  9] = new PVector(   C7,  0.5,  -C0 );
    vert[ 10] = new PVector(   C7, -0.5,   C0 );
    vert[ 11] = new PVector(   C7, -0.5,  -C0 );
    vert[ 12] = new PVector(  -C7,  0.5,   C0 );
    vert[ 13] = new PVector(  -C7,  0.5,  -C0 );
    vert[ 14] = new PVector(  -C7, -0.5,   C0 );
    vert[ 15] = new PVector(  -C7, -0.5,  -C0 );
    vert[ 16] = new PVector(   C0,   C7,  0.5 );
    vert[ 17] = new PVector(   C0,   C7, -0.5 );
    vert[ 18] = new PVector(   C0,  -C7,  0.5 );
    vert[ 19] = new PVector(   C0,  -C7, -0.5 );
    vert[ 20] = new PVector(  -C0,   C7,  0.5 );
    vert[ 21] = new PVector(  -C0,   C7, -0.5 );
    vert[ 22] = new PVector(  -C0,  -C7,  0.5 );
    vert[ 23] = new PVector(  -C0,  -C7, -0.5 );
    vert[ 24] = new PVector(   C2,  0.5,   C6 );
    vert[ 25] = new PVector(   C2,  0.5,  -C6 );
    vert[ 26] = new PVector(   C2, -0.5,   C6 );
    vert[ 27] = new PVector(   C2, -0.5,  -C6 );
    vert[ 28] = new PVector(  -C2,  0.5,   C6 );
    vert[ 29] = new PVector(  -C2,  0.5,  -C6 );
    vert[ 30] = new PVector(  -C2, -0.5,   C6 );
    vert[ 31] = new PVector(  -C2, -0.5,  -C6 );
    vert[ 32] = new PVector(   C6,   C2,  0.5 );
    vert[ 33] = new PVector(   C6,   C2, -0.5 );
    vert[ 34] = new PVector(   C6,  -C2,  0.5 );
    vert[ 35] = new PVector(   C6,  -C2, -0.5 );
    vert[ 36] = new PVector(  -C6,   C2,  0.5 );
    vert[ 37] = new PVector(  -C6,   C2, -0.5 );
    vert[ 38] = new PVector(  -C6,  -C2,  0.5 );
    vert[ 39] = new PVector(  -C6,  -C2, -0.5 );
    vert[ 40] = new PVector(  0.5,   C6,   C2 );
    vert[ 41] = new PVector(  0.5,   C6,  -C2 );
    vert[ 42] = new PVector(  0.5,  -C6,   C2 );
    vert[ 43] = new PVector(  0.5,  -C6,  -C2 );
    vert[ 44] = new PVector( -0.5,   C6,   C2 );
    vert[ 45] = new PVector( -0.5,   C6,  -C2 );
    vert[ 46] = new PVector( -0.5,  -C6,   C2 );
    vert[ 47] = new PVector( -0.5,  -C6,  -C2 );
    vert[ 48] = new PVector(  1.0,   C1,   C5 );
    vert[ 49] = new PVector(  1.0,   C1,  -C5 );
    vert[ 50] = new PVector(  1.0,  -C1,   C5 );
    vert[ 51] = new PVector(  1.0,  -C1,  -C5 );
    vert[ 52] = new PVector( -1.0,   C1,   C5 );
    vert[ 53] = new PVector( -1.0,   C1,  -C5 );
    vert[ 54] = new PVector( -1.0,  -C1,   C5 );
    vert[ 55] = new PVector( -1.0,  -C1,  -C5 );
    vert[ 56] = new PVector(   C5,  1.0,   C1 );
    vert[ 57] = new PVector(   C5,  1.0,  -C1 );
    vert[ 58] = new PVector(   C5, -1.0,   C1 );
    vert[ 59] = new PVector(   C5, -1.0,  -C1 );
    vert[ 60] = new PVector(  -C5,  1.0,   C1 );
    vert[ 61] = new PVector(  -C5,  1.0,  -C1 );
    vert[ 62] = new PVector(  -C5, -1.0,   C1 );
    vert[ 63] = new PVector(  -C5, -1.0,  -C1 );
    vert[ 64] = new PVector(   C1,   C5,  1.0 );
    vert[ 65] = new PVector(   C1,   C5, -1.0 );
    vert[ 66] = new PVector(   C1,  -C5,  1.0 );
    vert[ 67] = new PVector(   C1,  -C5, -1.0 );
    vert[ 68] = new PVector(  -C1,   C5,  1.0 );
    vert[ 69] = new PVector(  -C1,   C5, -1.0 );
    vert[ 70] = new PVector(  -C1,  -C5,  1.0 );
    vert[ 71] = new PVector(  -C1,  -C5, -1.0 );
    vert[ 72] = new PVector(   C0,   C3,  1.5 );
    vert[ 73] = new PVector(   C0,   C3, -1.5 );
    vert[ 74] = new PVector(   C0,  -C3,  1.5 );
    vert[ 75] = new PVector(   C0,  -C3, -1.5 );
    vert[ 76] = new PVector(  -C0,   C3,  1.5 );
    vert[ 77] = new PVector(  -C0,   C3, -1.5 );
    vert[ 78] = new PVector(  -C0,  -C3,  1.5 );
    vert[ 79] = new PVector(  -C0,  -C3, -1.5 );
    vert[ 80] = new PVector(  1.5,   C0,   C3 );
    vert[ 81] = new PVector(  1.5,   C0,  -C3 );
    vert[ 82] = new PVector(  1.5,  -C0,   C3 );
    vert[ 83] = new PVector(  1.5,  -C0,  -C3 );
    vert[ 84] = new PVector( -1.5,   C0,   C3 );
    vert[ 85] = new PVector( -1.5,   C0,  -C3 );
    vert[ 86] = new PVector( -1.5,  -C0,   C3 );
    vert[ 87] = new PVector( -1.5,  -C0,  -C3 );
    vert[ 88] = new PVector(   C3,  1.5,   C0 );
    vert[ 89] = new PVector(   C3,  1.5,  -C0 );
    vert[ 90] = new PVector(   C3, -1.5,   C0 );
    vert[ 91] = new PVector(   C3, -1.5,  -C0 );
    vert[ 92] = new PVector(  -C3,  1.5,   C0 );
    vert[ 93] = new PVector(  -C3,  1.5,  -C0 );
    vert[ 94] = new PVector(  -C3, -1.5,   C0 );
    vert[ 95] = new PVector(  -C3, -1.5,  -C0 );
    vert[ 96] = new PVector(  0.5,   C4,   C3 );
    vert[ 97] = new PVector(  0.5,   C4,  -C3 );
    vert[ 98] = new PVector(  0.5,  -C4,   C3 );
    vert[ 99] = new PVector(  0.5,  -C4,  -C3 );
    vert[100] = new PVector( -0.5,   C4,   C3 );
    vert[101] = new PVector( -0.5,   C4,  -C3 );
    vert[102] = new PVector( -0.5,  -C4,   C3 );
    vert[103] = new PVector( -0.5,  -C4,  -C3 );
    vert[104] = new PVector(   C3,  0.5,   C4 );
    vert[105] = new PVector(   C3,  0.5,  -C4 );
    vert[106] = new PVector(   C3, -0.5,   C4 );
    vert[107] = new PVector(   C3, -0.5,  -C4 );
    vert[108] = new PVector(  -C3,  0.5,   C4 );
    vert[109] = new PVector(  -C3,  0.5,  -C4 );
    vert[110] = new PVector(  -C3, -0.5,   C4 );
    vert[111] = new PVector(  -C3, -0.5,  -C4 );
    vert[112] = new PVector(   C4,   C3,  0.5 );
    vert[113] = new PVector(   C4,   C3, -0.5 );
    vert[114] = new PVector(   C4,  -C3,  0.5 );
    vert[115] = new PVector(   C4,  -C3, -0.5 );
    vert[116] = new PVector(  -C4,   C3,  0.5 );
    vert[117] = new PVector(  -C4,   C3, -0.5 );
    vert[118] = new PVector(  -C4,  -C3,  0.5 );
    vert[119] = new PVector(  -C4,  -C3, -0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  50,  80,  24,  26,  82,  48,   2, 106, 104 };
    faces[ 1] = new int[] {  1, 105, 107,   3,  49,  83,  27,  25,  81,  51 };
    faces[ 2] = new int[] {  4, 108, 110,   6,  52,  86,  30,  28,  84,  54 };
    faces[ 3] = new int[] {  5,  55,  85,  29,  31,  87,  53,   7, 111, 109 };
    faces[ 4] = new int[] {  8,  57,  88,  32,  33,  89,  56,   9, 113, 112 };
    faces[ 5] = new int[] { 10, 114, 115,  11,  58,  91,  35,  34,  90,  59 };
    faces[ 6] = new int[] { 12, 116, 117,  13,  60,  93,  37,  36,  92,  61 };
    faces[ 7] = new int[] { 14,  63,  94,  38,  39,  95,  62,  15, 119, 118 };
    faces[ 8] = new int[] { 16,  68,  72,  40,  44,  76,  64,  20, 100,  96 };
    faces[ 9] = new int[] { 17,  97, 101,  21,  65,  77,  45,  41,  73,  69 };
    faces[10] = new int[] { 18,  98, 102,  22,  66,  78,  46,  42,  74,  70 };
    faces[11] = new int[] { 19,  71,  75,  43,  47,  79,  67,  23, 103,  99 };
    faces[12] = new int[] {  0, 104,  56,  89,  41,  45,  93,  60, 108,   4 };
    faces[13] = new int[] {  1,   5, 109,  61,  92,  44,  40,  88,  57, 105 };
    faces[14] = new int[] {  2,   6, 110,  62,  95,  47,  43,  91,  58, 106 };
    faces[15] = new int[] {  3, 107,  59,  90,  42,  46,  94,  63, 111,   7 };
    faces[16] = new int[] {  8, 112,  64,  76,  28,  30,  78,  66, 114,  10 };
    faces[17] = new int[] {  9,  11, 115,  67,  79,  31,  29,  77,  65, 113 };
    faces[18] = new int[] { 12,  14, 118,  70,  74,  26,  24,  72,  68, 116 };
    faces[19] = new int[] { 13, 117,  69,  73,  25,  27,  75,  71, 119,  15 };
    faces[20] = new int[] { 16,  96,  48,  82,  34,  35,  83,  49,  97,  17 };
    faces[21] = new int[] { 18,  19,  99,  51,  81,  33,  32,  80,  50,  98 };
    faces[22] = new int[] { 20,  21, 101,  53,  87,  39,  38,  86,  52, 100 };
    faces[23] = new int[] { 22, 102,  54,  84,  36,  37,  85,  55, 103,  23 };
    faces[24] = new int[] {  0,   4,  54, 102,  98,  50,  50,  50,  50,  50 };  //added 4x 4th number to fill gap
    faces[25] = new int[] {  1,  51,  99, 103,  55,   5,   5,   5,   5,   5 };  //added 4x 4th number to fill gap
    faces[26] = new int[] {  2,  48,  96, 100,  52,   6,   6,   6,   6,   6 };  //added 4x 6th number to fill gap
    faces[27] = new int[] {  3,   7,  53, 101,  97,  49,  49,  49,  49,  49 };  //added 4x 6th number to fill gap
    faces[28] = new int[] {  8,  10,  59, 107, 105,  57,  57,  57,  57,  57 };  //added 4x 6th number to fill gap
    faces[29] = new int[] {  9,  56, 104, 106,  58,  11,  11,  11,  11,  11 };  //added 4x 6th number to fill gap
    faces[30] = new int[] { 12,  61, 109, 111,  63,  14,  14,  14,  14,  14 };  //added 4x 6th number to fill gap
    faces[31] = new int[] { 13,  15,  62, 110, 108,  60,  60,  60,  60,  60 };  //added 4x 6th number to fill gap
    faces[32] = new int[] { 16,  17,  69, 117, 116,  68,  68,  68,  68,  68 };  //added 4x 6th number to fill gap
    faces[33] = new int[] { 18,  70, 118, 119,  71,  19,  19,  19,  19,  19 };  //added 4x 6th number to fill gap
    faces[34] = new int[] { 20,  64, 112, 113,  65,  21,  21,  21,  21,  21 };  //added 4x 4th number to fill gap
    faces[35] = new int[] { 22,  23,  67, 115, 114,  66,  66,  66,  66,  66 };  //added 4x 4th number to fill gap
    faces[36] = new int[] { 24,  80,  32,  88,  40,  72,  72,  72,  72,  72 };  //added 4x 4th number to fill gap
    faces[37] = new int[] { 25,  73,  41,  89,  33,  81,  81,  81,  81,  81 };  //added 4x 4th number to fill gap
    faces[38] = new int[] { 26,  74,  42,  90,  34,  82,  82,  82,  82,  82 };  //added 4x 4th number to fill gap
    faces[39] = new int[] { 27,  83,  35,  91,  43,  75,  75,  75,  75,  75 };  //added 4x 4th number to fill gap
    faces[40] = new int[] { 28,  76,  44,  92,  36,  84,  84,  84,  84,  84 };  //added 4x 4th number to fill gap
    faces[41] = new int[] { 29,  85,  37,  93,  45,  77,  77,  77,  77,  77 };  //added 4x 4th number to fill gap
    faces[42] = new int[] { 30,  86,  38,  94,  46,  78,  78,  78,  78,  78 };  //added 4x 4th number to fill gap
    faces[43] = new int[] { 31,  79,  47,  95,  39,  87,  87,  87,  87,  87 };  //added 4x 4th number to fill gap
  } //end IcositruncatedDodecadodecahedron()

  public String name() {
    return "Icositruncated Dodecadodecahedron";
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
   
} //end class IcositruncatedDodecadodecahedron
