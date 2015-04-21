/*
MedialHexagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialHexagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0  = 0.03581639493949013983380209116851;  //square-root of a root of the polynomial:  102400*(x^6) - 66560*(x^5) + 19456*(x^4) + 8896*(x^3) - 2768*(x^2) - 776*x + 1
  final float C1  = 0.0474466215401124369879652440389;   //square-root of a root of the polynomial:  102400*(x^6) - 10240*(x^5) - 18944*(x^4) - 13184*(x^3) - 64*(x^2) - 444*x + 1
  final float C2  = 0.105398765906697216676314189282;    //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C3  = 0.112586641242744945279481298926;    //sqrt(30 * (cbrt(4 * (7157 + 885 * sqrt(69))) - cbrt(4 * (885 * sqrt(69) - 7157)) - 28)) / 60
  final float C4  = 0.134722390669839585134028153001;    //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 97536*(x^4) - 40128*(x^3) + 1408*(x^2) - 68*x + 1
  final float C5  = 0.37604495239790042473910409039502;  //square-root of a root of the polynomial:  102400*(x^6) - 168960*(x^5) + 84736*(x^4) - 18432*(x^3) + 1808*(x^2) - 72*x + 1
  final float C6  = 0.438898343962682737883306417824;    //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C7  = 0.486344965502795174871271661863;    //square-root of a root of the polynomial:  102400*(x^6) - 240640*(x^5) + 226816*(x^4) - 114176*(x^3) + 33152*(x^2) - 5304*x + 361
  final float C8  = 0.537942209374520181919397458719;    //square-root of a root of the polynomial:  1478656*(x^6) - 2528256*(x^5) + 694016*(x^4) - 24064*(x^3) - 240*(x^2) - 8*x + 1
  final float C9  = 0.544297109869379954559620607106;    //sqrt(6 * (2 + cbrt(4 * (101 + 15 * sqrt(69))) - cbrt(4 * (15 * sqrt(69) - 101)))) / 12
  final float C10 = 0.608453514277639159564031071848;    //sqrt(30 * (22 + cbrt(4 * (367 + 15 * sqrt(69))) + cbrt(4 * (367 - 15 * sqrt(69))))) / 60
  final float C11 = 0.621067356172634760005299814864;    //square-root of a root of the polynomial:  102400*(x^6) - 66560*(x^5) + 19456*(x^4) + 8896*(x^3) - 2768*(x^2) - 776*x + 1
  final float C12 = 0.656883751112124899839101906033;    //sqrt(15 * (31 - cbrt(4 * (101 + 15 * sqrt(69))) + cbrt(4 * (15 * sqrt(69) - 101)))) / 30
  final float C13 = 0.725451430403416911803282769524;    //square-root of a root of the polynomial:  1478656*(x^6) - 2192384*(x^5) + 980736*(x^4) - 134656*(x^3) + 5200*(x^2) + 88*x + 1
  final float C14 = 0.822739079380407825858706772981;    //square-root of a root of the polynomial:  102400*(x^6) - 10240*(x^5) - 18944*(x^4) - 13184*(x^3) - 64*(x^2) - 444*x + 1
  final float C15 = 0.844874828807502465713253627056;    //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 27136*(x^4) + 17472*(x^3) - 352*(x^2) - 448*x + 121
  final float C16 = 0.870408778751185966979274045269;    //square-root of a root of the polynomial:  1478656*(x^6) - 2192384*(x^5) + 980736*(x^4) - 134656*(x^3) + 5200*(x^2) + 88*x + 1
  final float C17 = 0.89232145034761490270121887109501;  //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 97536*(x^4) - 40128*(x^3) + 1408*(x^2) - 68*x + 1
  final float C18 = 0.928137845287105042535020962264;    //square-root of a root of the polynomial:  102400*(x^6) - 240640*(x^5) + 226816*(x^4) - 114176*(x^3) + 33152*(x^2) - 5304*x + 361
  final float C19 = 0.957461470050247410992734925983;    //square-root of a root of the polynomial:  102400*(x^6) - 143360*(x^5) + 27136*(x^4) + 17472*(x^3) - 352*(x^2) - 448*x + 121
  final float C20 = 0.984498466675539584303135162243;    //square-root of a root of the polynomial:  102400*(x^6) - 168960*(x^5) + 84736*(x^4) - 18432*(x^3) + 1808*(x^2) - 72*x + 1
  final float C21 = 1.173805071579957404913880606454;    //square-root of a root of the polynomial:  1478656*(x^6) - 2528256*(x^5) + 694016*(x^4) - 24064*(x^3) - 240*(x^2) - 8*x + 1
  private PVector[] vert = new PVector[104]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialHexagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C13,  0.0,  C21 );
    vert[  1] = new PVector(  C13,  0.0, -C21 );
    vert[  2] = new PVector( -C13,  0.0,  C21 );
    vert[  3] = new PVector( -C13,  0.0, -C21 );
    vert[  4] = new PVector(  C21,  C13,  0.0 );
    vert[  5] = new PVector(  C21, -C13,  0.0 );
    vert[  6] = new PVector( -C21,  C13,  0.0 );
    vert[  7] = new PVector( -C21, -C13,  0.0 );
    vert[  8] = new PVector(  0.0,  C21,  C13 );
    vert[  9] = new PVector(  0.0,  C21, -C13 );
    vert[ 10] = new PVector(  0.0, -C21,  C13 );
    vert[ 11] = new PVector(  0.0, -C21, -C13 );
    vert[ 12] = new PVector(  0.0,   C5,  C20 );
    vert[ 13] = new PVector(  0.0,   C5, -C20 );
    vert[ 14] = new PVector(  0.0,  -C5,  C20 );
    vert[ 15] = new PVector(  0.0,  -C5, -C20 );
    vert[ 16] = new PVector(  C20,  0.0,   C5 );
    vert[ 17] = new PVector(  C20,  0.0,  -C5 );
    vert[ 18] = new PVector( -C20,  0.0,   C5 );
    vert[ 19] = new PVector( -C20,  0.0,  -C5 );
    vert[ 20] = new PVector(   C5,  C20,  0.0 );
    vert[ 21] = new PVector(   C5, -C20,  0.0 );
    vert[ 22] = new PVector(  -C5,  C20,  0.0 );
    vert[ 23] = new PVector(  -C5, -C20,  0.0 );
    vert[ 24] = new PVector(   C6,   C0,  C19 );
    vert[ 25] = new PVector(   C6,  -C0, -C19 );
    vert[ 26] = new PVector(  -C6,  -C0,  C19 );
    vert[ 27] = new PVector(  -C6,   C0, -C19 );
    vert[ 28] = new PVector(  C19,   C6,   C0 );
    vert[ 29] = new PVector(  C19,  -C6,  -C0 );
    vert[ 30] = new PVector( -C19,  -C6,   C0 );
    vert[ 31] = new PVector( -C19,   C6,  -C0 );
    vert[ 32] = new PVector(   C0,  C19,   C6 );
    vert[ 33] = new PVector(   C0, -C19,  -C6 );
    vert[ 34] = new PVector(  -C0, -C19,   C6 );
    vert[ 35] = new PVector(  -C0,  C19,  -C6 );
    vert[ 36] = new PVector(   C7,  -C3,  C18 );
    vert[ 37] = new PVector(   C7,   C3, -C18 );
    vert[ 38] = new PVector(  -C7,   C3,  C18 );
    vert[ 39] = new PVector(  -C7,  -C3, -C18 );
    vert[ 40] = new PVector(  C18,  -C7,   C3 );
    vert[ 41] = new PVector(  C18,   C7,  -C3 );
    vert[ 42] = new PVector( -C18,   C7,   C3 );
    vert[ 43] = new PVector( -C18,  -C7,  -C3 );
    vert[ 44] = new PVector(   C3, -C18,   C7 );
    vert[ 45] = new PVector(   C3,  C18,  -C7 );
    vert[ 46] = new PVector(  -C3,  C18,   C7 );
    vert[ 47] = new PVector(  -C3, -C18,  -C7 );
    vert[ 48] = new PVector(   C9,   C4,  C17 );
    vert[ 49] = new PVector(   C9,  -C4, -C17 );
    vert[ 50] = new PVector(  -C9,  -C4,  C17 );
    vert[ 51] = new PVector(  -C9,   C4, -C17 );
    vert[ 52] = new PVector(  C17,   C9,   C4 );
    vert[ 53] = new PVector(  C17,  -C9,  -C4 );
    vert[ 54] = new PVector( -C17,  -C9,   C4 );
    vert[ 55] = new PVector( -C17,   C9,  -C4 );
    vert[ 56] = new PVector(   C4,  C17,   C9 );
    vert[ 57] = new PVector(   C4, -C17,  -C9 );
    vert[ 58] = new PVector(  -C4, -C17,   C9 );
    vert[ 59] = new PVector(  -C4,  C17,  -C9 );
    vert[ 60] = new PVector(   C8,  0.0,  C16 );
    vert[ 61] = new PVector(   C8,  0.0, -C16 );
    vert[ 62] = new PVector(  -C8,  0.0,  C16 );
    vert[ 63] = new PVector(  -C8,  0.0, -C16 );
    vert[ 64] = new PVector(  C16,   C8,  0.0 );
    vert[ 65] = new PVector(  C16,  -C8,  0.0 );
    vert[ 66] = new PVector( -C16,   C8,  0.0 );
    vert[ 67] = new PVector( -C16,  -C8,  0.0 );
    vert[ 68] = new PVector(  0.0,  C16,   C8 );
    vert[ 69] = new PVector(  0.0,  C16,  -C8 );
    vert[ 70] = new PVector(  0.0, -C16,   C8 );
    vert[ 71] = new PVector(  0.0, -C16,  -C8 );
    vert[ 72] = new PVector(  C11,  -C2,  C15 );
    vert[ 73] = new PVector(  C11,   C2, -C15 );
    vert[ 74] = new PVector( -C11,   C2,  C15 );
    vert[ 75] = new PVector( -C11,  -C2, -C15 );
    vert[ 76] = new PVector(  C15, -C11,   C2 );
    vert[ 77] = new PVector(  C15,  C11,  -C2 );
    vert[ 78] = new PVector( -C15,  C11,   C2 );
    vert[ 79] = new PVector( -C15, -C11,  -C2 );
    vert[ 80] = new PVector(   C2, -C15,  C11 );
    vert[ 81] = new PVector(   C2,  C15, -C11 );
    vert[ 82] = new PVector(  -C2,  C15,  C11 );
    vert[ 83] = new PVector(  -C2, -C15, -C11 );
    vert[ 84] = new PVector(  C12,   C1,  C14 );
    vert[ 85] = new PVector(  C12,  -C1, -C14 );
    vert[ 86] = new PVector( -C12,  -C1,  C14 );
    vert[ 87] = new PVector( -C12,   C1, -C14 );
    vert[ 88] = new PVector(  C14,  C12,   C1 );
    vert[ 89] = new PVector(  C14, -C12,  -C1 );
    vert[ 90] = new PVector( -C14, -C12,   C1 );
    vert[ 91] = new PVector( -C14,  C12,  -C1 );
    vert[ 92] = new PVector(   C1,  C14,  C12 );
    vert[ 93] = new PVector(   C1, -C14, -C12 );
    vert[ 94] = new PVector(  -C1, -C14,  C12 );
    vert[ 95] = new PVector(  -C1,  C14, -C12 );
    vert[ 96] = new PVector(  C10,  C10,  C10 );
    vert[ 97] = new PVector(  C10,  C10, -C10 );
    vert[ 98] = new PVector(  C10, -C10,  C10 );
    vert[ 99] = new PVector(  C10, -C10, -C10 );
    vert[100] = new PVector( -C10,  C10,  C10 );
    vert[101] = new PVector( -C10,  C10, -C10 );
    vert[102] = new PVector( -C10, -C10,  C10 );
    vert[103] = new PVector( -C10, -C10, -C10 );
    // set faces
    faces[ 0] = new int[] {   0,  28,  64,  77,  20,  56 };
    faces[ 1] = new int[] {   0,  56,  68,  46, 100,  38 };
    faces[ 2] = new int[] {   0,  38,  62,  86, 102,  94 };
    faces[ 3] = new int[] {   0,  94,  70,  34,  21,  76 };
    faces[ 4] = new int[] {   0,  76,  65,  53,  17,  28 };
    faces[ 5] = new int[] {   1,  29,  65,  76,  21,  57 };
    faces[ 6] = new int[] {   1,  57,  71,  47, 103,  39 };
    faces[ 7] = new int[] {   1,  39,  63,  87, 101,  95 };
    faces[ 8] = new int[] {   1,  95,  69,  35,  20,  77 };
    faces[ 9] = new int[] {   1,  77,  64,  52,  16,  29 };
    faces[10] = new int[] {   2,  30,  67,  79,  23,  58 };
    faces[11] = new int[] {   2,  58,  70,  44,  98,  36 };
    faces[12] = new int[] {   2,  36,  60,  84,  96,  92 };
    faces[13] = new int[] {   2,  92,  68,  32,  22,  78 };
    faces[14] = new int[] {   2,  78,  66,  55,  19,  30 };
    faces[15] = new int[] {   3,  31,  66,  78,  22,  59 };
    faces[16] = new int[] {   3,  59,  69,  45,  97,  37 };
    faces[17] = new int[] {   3,  37,  61,  85,  99,  93 };
    faces[18] = new int[] {   3,  93,  71,  33,  23,  79 };
    faces[19] = new int[] {   3,  79,  67,  54,  18,  31 };
    faces[20] = new int[] {   4,  32,  68,  82,  12,  48 };
    faces[21] = new int[] {   4,  48,  60,  36,  98,  40 };
    faces[22] = new int[] {   4,  40,  65,  89,  99,  85 };
    faces[23] = new int[] {   4,  85,  61,  25,  13,  81 };
    faces[24] = new int[] {   4,  81,  69,  59,  22,  32 };
    faces[25] = new int[] {   5,  33,  71,  83,  15,  49 };
    faces[26] = new int[] {   5,  49,  61,  37,  97,  41 };
    faces[27] = new int[] {   5,  41,  64,  88,  96,  84 };
    faces[28] = new int[] {   5,  84,  60,  24,  14,  80 };
    faces[29] = new int[] {   5,  80,  70,  58,  23,  33 };
    faces[30] = new int[] {   6,  35,  69,  81,  13,  51 };
    faces[31] = new int[] {   6,  51,  63,  39, 103,  43 };
    faces[32] = new int[] {   6,  43,  67,  90, 102,  86 };
    faces[33] = new int[] {   6,  86,  62,  26,  12,  82 };
    faces[34] = new int[] {   6,  82,  68,  56,  20,  35 };
    faces[35] = new int[] {   7,  34,  70,  80,  14,  50 };
    faces[36] = new int[] {   7,  50,  62,  38, 100,  42 };
    faces[37] = new int[] {   7,  42,  66,  91, 101,  87 };
    faces[38] = new int[] {   7,  87,  63,  27,  15,  83 };
    faces[39] = new int[] {   7,  83,  71,  57,  21,  34 };
    faces[40] = new int[] {   8,  24,  60,  72,  16,  52 };
    faces[41] = new int[] {   8,  52,  64,  41,  97,  45 };
    faces[42] = new int[] {   8,  45,  69,  95, 101,  91 };
    faces[43] = new int[] {   8,  91,  66,  31,  18,  74 };
    faces[44] = new int[] {   8,  74,  62,  50,  14,  24 };
    faces[45] = new int[] {   9,  27,  63,  75,  19,  55 };
    faces[46] = new int[] {   9,  55,  66,  42, 100,  46 };
    faces[47] = new int[] {   9,  46,  68,  92,  96,  88 };
    faces[48] = new int[] {   9,  88,  64,  28,  17,  73 };
    faces[49] = new int[] {   9,  73,  61,  49,  15,  27 };
    faces[50] = new int[] {  10,  26,  62,  74,  18,  54 };
    faces[51] = new int[] {  10,  54,  67,  43, 103,  47 };
    faces[52] = new int[] {  10,  47,  71,  93,  99,  89 };
    faces[53] = new int[] {  10,  89,  65,  29,  16,  72 };
    faces[54] = new int[] {  10,  72,  60,  48,  12,  26 };
    faces[55] = new int[] {  11,  25,  61,  73,  17,  53 };
    faces[56] = new int[] {  11,  53,  65,  40,  98,  44 };
    faces[57] = new int[] {  11,  44,  70,  94, 102,  90 };
    faces[58] = new int[] {  11,  90,  67,  30,  19,  75 };
    faces[59] = new int[] {  11,  75,  63,  51,  13,  25 };
  } //end MedialHexagonalHexecontahedron()

  public String name() {
    return "Medial Hexagonal Hexecontahedron";
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
   
} //end class MedialHexagonalHexecontahedron
