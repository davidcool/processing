/*
GreatHexagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatHexagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.0467276373631543033303677305706;    //sqrt(sqrt(5) - 1 - 2 * sqrt(2 * (5 * sqrt(5) - 11))) / 4
  final float C1  = 0.0594384729013000505963734214209;    //sqrt(2 * (1 - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C2  = 0.135045378368863226800771578524547;  //(3 * sqrt(2) - sqrt(10)) / 8
  final float C3  = 0.142901106756847359195252445424;     //sqrt(2 * (3 - sqrt(5) - sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C4  = 0.171780374861256232069282871957;     //sqrt(2 * (sqrt(5) - 2)) / 4
  final float C5  = 0.218508012224410535399650602528;     //(sqrt(10) - sqrt(2)) / 8
  final float C6  = 0.277946485125710585996024023949;     //sqrt(sqrt(5) - 1) / 4
  final float C7  = 0.314681481618103591264535317382;     //sqrt(2 * (4 - sqrt(5) - 2 * sqrt(sqrt(5) - 2))) / 4
  final float C8  = 0.353553390593273762200422181052;     //sqrt(2) / 4
  final float C9  = 0.3902883870856667674689334744852;    //sqrt(sqrt(5) - 1 + 2 * sqrt(2 * (5 * sqrt(5) - 11))) / 4
  final float C10 = 0.412991863494573812796795602473;     //sqrt(2 * (3 - sqrt(5) + sqrt(2 * (5 * sqrt(5) - 11)))) / 4
  final float C11 = 0.449726859986966818065306895906;     //sqrt(1 + sqrt(5)) / 4
  final float C12 = 0.496454497350121121395674626477;     //sqrt(2 * (1 + 2 * sqrt(sqrt(5) - 2))) / 4
  final float C13 = 0.555892970251421171992048047898;     //sqrt(sqrt(5) - 1) / 2
  final float C14 = 0.572061402817684297600072783580;     //(sqrt(2) + sqrt(10)) / 8
  final float C15 = 0.584772238355830044866078474431;     //sqrt(2 * (4 - sqrt(5) + 2 * sqrt(sqrt(5) - 2))) / 4
  private PVector[] vert = new PVector[104]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatHexagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C4,   C1,  C15 );
    vert[  1] = new PVector(   C4,  -C1, -C15 );
    vert[  2] = new PVector(  -C4,  -C1,  C15 );
    vert[  3] = new PVector(  -C4,   C1, -C15 );
    vert[  4] = new PVector(  C15,   C4,   C1 );
    vert[  5] = new PVector(  C15,  -C4,  -C1 );
    vert[  6] = new PVector( -C15,  -C4,   C1 );
    vert[  7] = new PVector( -C15,   C4,  -C1 );
    vert[  8] = new PVector(   C1,  C15,   C4 );
    vert[  9] = new PVector(   C1, -C15,  -C4 );
    vert[ 10] = new PVector(  -C1, -C15,   C4 );
    vert[ 11] = new PVector(  -C1,  C15,  -C4 );
    vert[ 12] = new PVector(  0.0,   C5,  C14 );
    vert[ 13] = new PVector(  0.0,   C5, -C14 );
    vert[ 14] = new PVector(  0.0,  -C5,  C14 );
    vert[ 15] = new PVector(  0.0,  -C5, -C14 );
    vert[ 16] = new PVector(  C14,  0.0,   C5 );
    vert[ 17] = new PVector(  C14,  0.0,  -C5 );
    vert[ 18] = new PVector( -C14,  0.0,   C5 );
    vert[ 19] = new PVector( -C14,  0.0,  -C5 );
    vert[ 20] = new PVector(   C5,  C14,  0.0 );
    vert[ 21] = new PVector(   C5, -C14,  0.0 );
    vert[ 22] = new PVector(  -C5,  C14,  0.0 );
    vert[ 23] = new PVector(  -C5, -C14,  0.0 );
    vert[ 24] = new PVector(   C5,  -C2,  C13 );
    vert[ 25] = new PVector(   C5,   C2, -C13 );
    vert[ 26] = new PVector(  -C5,   C2,  C13 );
    vert[ 27] = new PVector(  -C5,  -C2, -C13 );
    vert[ 28] = new PVector(  C13,  -C5,   C2 );
    vert[ 29] = new PVector(  C13,   C5,  -C2 );
    vert[ 30] = new PVector( -C13,   C5,   C2 );
    vert[ 31] = new PVector( -C13,  -C5,  -C2 );
    vert[ 32] = new PVector(   C2, -C13,   C5 );
    vert[ 33] = new PVector(   C2,  C13,  -C5 );
    vert[ 34] = new PVector(  -C2,  C13,   C5 );
    vert[ 35] = new PVector(  -C2, -C13,  -C5 );
    vert[ 36] = new PVector(   C7,   C4,  C12 );
    vert[ 37] = new PVector(   C7,  -C4, -C12 );
    vert[ 38] = new PVector(  -C7,  -C4,  C12 );
    vert[ 39] = new PVector(  -C7,   C4, -C12 );
    vert[ 40] = new PVector(  C12,   C7,   C4 );
    vert[ 41] = new PVector(  C12,  -C7,  -C4 );
    vert[ 42] = new PVector( -C12,  -C7,   C4 );
    vert[ 43] = new PVector( -C12,   C7,  -C4 );
    vert[ 44] = new PVector(   C4,  C12,   C7 );
    vert[ 45] = new PVector(   C4, -C12,  -C7 );
    vert[ 46] = new PVector(  -C4, -C12,   C7 );
    vert[ 47] = new PVector(  -C4,  C12,  -C7 );
    vert[ 48] = new PVector(   C6,  0.0,  C11 );
    vert[ 49] = new PVector(   C6,  0.0,  C11 );
    vert[ 50] = new PVector(   C6,  0.0, -C11 );
    vert[ 51] = new PVector(   C6,  0.0, -C11 );
    vert[ 52] = new PVector(  -C6,  0.0,  C11 );
    vert[ 53] = new PVector(  -C6,  0.0,  C11 );
    vert[ 54] = new PVector(  -C6,  0.0, -C11 );
    vert[ 55] = new PVector(  -C6,  0.0, -C11 );
    vert[ 56] = new PVector(  C11,   C6,  0.0 );
    vert[ 57] = new PVector(  C11,   C6,  0.0 );
    vert[ 58] = new PVector(  C11,  -C6,  0.0 );
    vert[ 59] = new PVector(  C11,  -C6,  0.0 );
    vert[ 60] = new PVector( -C11,   C6,  0.0 );
    vert[ 61] = new PVector( -C11,   C6,  0.0 );
    vert[ 62] = new PVector( -C11,  -C6,  0.0 );
    vert[ 63] = new PVector( -C11,  -C6,  0.0 );
    vert[ 64] = new PVector(  0.0,  C11,   C6 );
    vert[ 65] = new PVector(  0.0,  C11,   C6 );
    vert[ 66] = new PVector(  0.0,  C11,  -C6 );
    vert[ 67] = new PVector(  0.0,  C11,  -C6 );
    vert[ 68] = new PVector(  0.0, -C11,   C6 );
    vert[ 69] = new PVector(  0.0, -C11,   C6 );
    vert[ 70] = new PVector(  0.0, -C11,  -C6 );
    vert[ 71] = new PVector(  0.0, -C11,  -C6 );
    vert[ 72] = new PVector(   C9,  -C3,  C11 );
    vert[ 73] = new PVector(   C9,   C3, -C11 );
    vert[ 74] = new PVector(  -C9,   C3,  C11 );
    vert[ 75] = new PVector(  -C9,  -C3, -C11 );
    vert[ 76] = new PVector(  C11,  -C9,   C3 );
    vert[ 77] = new PVector(  C11,   C9,  -C3 );
    vert[ 78] = new PVector( -C11,   C9,   C3 );
    vert[ 79] = new PVector( -C11,  -C9,  -C3 );
    vert[ 80] = new PVector(   C3, -C11,   C9 );
    vert[ 81] = new PVector(   C3,  C11,  -C9 );
    vert[ 82] = new PVector(  -C3,  C11,   C9 );
    vert[ 83] = new PVector(  -C3, -C11,  -C9 );
    vert[ 84] = new PVector(   C0,  C10,  C11 );
    vert[ 85] = new PVector(   C0, -C10, -C11 );
    vert[ 86] = new PVector(  -C0, -C10,  C11 );
    vert[ 87] = new PVector(  -C0,  C10, -C11 );
    vert[ 88] = new PVector(  C11,   C0,  C10 );
    vert[ 89] = new PVector(  C11,  -C0, -C10 );
    vert[ 90] = new PVector( -C11,  -C0,  C10 );
    vert[ 91] = new PVector( -C11,   C0, -C10 );
    vert[ 92] = new PVector(  C10,  C11,   C0 );
    vert[ 93] = new PVector(  C10, -C11,  -C0 );
    vert[ 94] = new PVector( -C10, -C11,   C0 );
    vert[ 95] = new PVector( -C10,  C11,  -C0 );
    vert[ 96] = new PVector(   C8,   C8,   C8 );
    vert[ 97] = new PVector(   C8,   C8,  -C8 );
    vert[ 98] = new PVector(   C8,  -C8,   C8 );
    vert[ 99] = new PVector(   C8,  -C8,  -C8 );
    vert[100] = new PVector(  -C8,   C8,   C8 );
    vert[101] = new PVector(  -C8,   C8,  -C8 );
    vert[102] = new PVector(  -C8,  -C8,   C8 );
    vert[103] = new PVector(  -C8,  -C8,  -C8 );
    // set faces
    faces[ 0] = new int[] {  12,  30,  62,  10,  68,  80 };
    faces[ 1] = new int[] {  12,  80,  59,  29,  57,  92 };
    faces[ 2] = new int[] {  12,  92,  67,  43,  60,  30 };
    faces[ 3] = new int[] {  13,  29,  59,   9,  71,  83 };
    faces[ 4] = new int[] {  13,  83,  62,  30,  60,  95 };
    faces[ 5] = new int[] {  13,  95,  64,  40,  57,  29 };
    faces[ 6] = new int[] {  14,  28,  56,   8,  65,  82 };
    faces[ 7] = new int[] {  14,  82,  61,  31,  63,  94 };
    faces[ 8] = new int[] {  14,  94,  70,  41,  58,  28 };
    faces[ 9] = new int[] {  15,  31,  61,  11,  66,  81 };
    faces[10] = new int[] {  15,  81,  56,  28,  58,  93 };
    faces[11] = new int[] {  15,  93,  69,  42,  63,  31 };
    faces[12] = new int[] {  16,  32,  70,   1,  51,  73 };
    faces[13] = new int[] {  16,  73,  67,  34,  65,  84 };
    faces[14] = new int[] {  16,  84,  52,  46,  68,  32 };
    faces[15] = new int[] {  17,  33,  64,   0,  48,  72 };
    faces[16] = new int[] {  17,  72,  69,  35,  71,  85 };
    faces[17] = new int[] {  17,  85,  55,  47,  66,  33 };
    faces[18] = new int[] {  18,  34,  67,   3,  54,  75 };
    faces[19] = new int[] {  18,  75,  70,  32,  68,  86 };
    faces[20] = new int[] {  18,  86,  49,  44,  65,  34 };
    faces[21] = new int[] {  19,  35,  69,   2,  53,  74 };
    faces[22] = new int[] {  19,  74,  64,  33,  66,  87 };
    faces[23] = new int[] {  19,  87,  50,  45,  71,  35 };
    faces[24] = new int[] {  20,  25,  55,   7,  60,  78 };
    faces[25] = new int[] {  20,  78,  52,  24,  48,  88 };
    faces[26] = new int[] {  20,  88,  59,  37,  51,  25 };
    faces[27] = new int[] {  21,  24,  52,   6,  63,  79 };
    faces[28] = new int[] {  21,  79,  55,  25,  51,  89 };
    faces[29] = new int[] {  21,  89,  56,  36,  48,  24 };
    faces[30] = new int[] {  22,  26,  49,   4,  57,  77 };
    faces[31] = new int[] {  22,  77,  50,  27,  54,  91 };
    faces[32] = new int[] {  22,  91,  62,  38,  53,  26 };
    faces[33] = new int[] {  23,  27,  50,   5,  58,  76 };
    faces[34] = new int[] {  23,  76,  49,  26,  53,  90 };
    faces[35] = new int[] {  23,  90,  61,  39,  54,  27 };
    faces[36] = new int[] {  96,   2,  69,  93,  58,   5 };
    faces[37] = new int[] {  96,   5,  50,  87,  66,  11 };
    faces[38] = new int[] {  96,  11,  61,  90,  53,   2 };
    faces[39] = new int[] {  97,  39,  61,  82,  65,  44 };
    faces[40] = new int[] {  97,  44,  49,  76,  58,  41 };
    faces[41] = new int[] {  97,  41,  70,  75,  54,  39 };
    faces[42] = new int[] {  98,  38,  62,  83,  71,  45 };
    faces[43] = new int[] {  98,  45,  50,  77,  57,  40 };
    faces[44] = new int[] {  98,  40,  64,  74,  53,  38 };
    faces[45] = new int[] {  99,   3,  67,  92,  57,   4 };
    faces[46] = new int[] {  99,   4,  49,  86,  68,  10 };
    faces[47] = new int[] {  99,  10,  62,  91,  54,   3 };
    faces[48] = new int[] { 100,  36,  56,  81,  66,  47 };
    faces[49] = new int[] { 100,  47,  55,  79,  63,  42 };
    faces[50] = new int[] { 100,  42,  69,  72,  48,  36 };
    faces[51] = new int[] { 101,   1,  70,  94,  63,   6 };
    faces[52] = new int[] { 101,   6,  52,  84,  65,   8 };
    faces[53] = new int[] { 101,   8,  56,  89,  51,   1 };
    faces[54] = new int[] { 102,   0,  64,  95,  60,   7 };
    faces[55] = new int[] { 102,   7,  55,  85,  71,   9 };
    faces[56] = new int[] { 102,   9,  59,  88,  48,   0 };
    faces[57] = new int[] { 103,  37,  59,  80,  68,  46 };
    faces[58] = new int[] { 103,  46,  52,  78,  60,  43 };
    faces[59] = new int[] { 103,  43,  67,  73,  51,  37 };
  } //end GreatHexagonalHexecontahedron()

  public String name() {
    return "Great Hexagonal Hexecontahedron";
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
   
} //end class GreatHexagonalHexecontahedron
