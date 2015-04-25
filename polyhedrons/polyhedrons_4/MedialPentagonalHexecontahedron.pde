/*
MedialPentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialPentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0956375228054126600288251856007;    //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) - 847872*(x^6) - 262144*(x^5) + 388608*(x^4) - 66688*(x^3) + 6992*(x^2) - 168*x + 1
  final float C1  = 0.185557856078737208916498067410;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) + 1576960*(x^6) - 47104*(x^5) + 547584*(x^4) - 106944*(x^3) + 6720*(x^2) - 156*x + 1
  final float C2  = 0.232983484058011057773884196064;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) + 1576960*(x^6) - 47104*(x^5) + 547584*(x^4) - 106944*(x^3) + 6720*(x^2) - 156*x + 1
  final float C3  = 0.3286210068634237178027093816646;    //square-root of a root of the polynomial:  1048576*(x^8) - 3014656*(x^7) + 3444736*(x^6) - 2287616*(x^5) + 1100544*(x^4) - 455104*(x^3) + 131008*(x^2) - 18860*x + 961
  final float C4  = 0.340302618577738088855453915730;     //square-root of a root of the polynomial: 1024*(x^4) + 832*(x^3) + 368*(x^2) - 64*x + 1
  final float C5  = 0.395876440820370748493308922286;     //square-root of a root of the polynomial: 1048576*(x^8) - 2228224*(x^7) + 1380352*(x^6) + 189440*(x^5) - 355584*(x^4) + 26880*(x^3) + 20112*(x^2) - 2664*x + 1
  final float C6  = 0.4549836805139589684034395850047;    //square-root of a root of the polynomial: 65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C7  = 0.622299338042328798044313589880;     //square-root of a root of the polynomial: 1048576*(x^8) - 104988672*(x^7) + 215617536*(x^6) - 97037312*(x^5) + 12262144*(x^4) - 362752*(x^3) - 1584*(x^2) + 88*x + 1
  final float C8  = 0.62885992487838180626719311834997;   //square-root of a root of the polynomial: 1048576*(x^8) - 1638400*(x^7) + 643072*(x^6) - 627712*(x^5) + 1304064*(x^4) - 982272*(x^3) + 310464*(x^2) - 40248*x + 1681
  final float C9  = 0.717277814600969258425288142552;     //square-root of a root of the polynomial: 65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C10 = 0.76128814508384772869302314304499;   //square-root of a root of the polynomial: 1048576*(x^8) - 41484288*(x^7) + 84627456*(x^6) - 58661888*(x^5) + 16132864*(x^4) - 1589248*(x^3) + 46096*(x^2) + 392*x + 1
  final float C11 = 0.783604687377382686206148966669;     //square-root of a root of the polynomial: 1048576*(x^8) - 2228224*(x^7) + 1380352*(x^6) + 189440*(x^5) - 355584*(x^4) + 26880*(x^3) + 20112*(x^2) - 2664*x + 1
  final float C12 = 0.831958876537190137973273811827;     //square-root of a root of the polynomial: 16*(x^4) + (x^3) - 9*(x^2) - x + 1
  final float C13 = 0.927596399342602798002098997427;     //square-root of a root of the polynomial: 1048576*(x^8) - 65536*(x^7) - 847872*(x^6) - 262144*(x^5) + 388608*(x^4) - 66688*(x^3) + 6992*(x^2) - 168*x + 1
  final float C14 = 0.969162543456119895122647034080;     //square-root of a root of the polynomial: 1048576*(x^8) - 1638400*(x^7) + 643072*(x^6) - 627712*(x^5) + 1304064*(x^4) - 982272*(x^3) + 310464*(x^2) - 40248*x + 1681
  final float C15 = 1.00690148012904844554595434173;      //square-root of a root of the polynomial: 1048576*(x^8) - 41484288*(x^7) + 84627456*(x^6) - 58661888*(x^5) + 16132864*(x^4) - 1589248*(x^3) + 46096*(x^2) + 392*x + 1
  final float C16 = 1.11315425542134000691859706484;      //square-root of a root of the polynomial: 1048576*(x^8) - 3014656*(x^7) + 3444736*(x^6) - 2287616*(x^5) + 1100544*(x^4) - 455104*(x^3) + 131008*(x^2) - 18860*x + 961
  final float C17 = 1.17226149511492822682872772756;      //square-root of a root of the polynomial: 256*(x^4) - 512*(x^3) + 240*(x^2) - 28*x + 1
  final float C18 = 1.23179009397802679283951773532;      //square-root of a root of the polynomial: 1048576*(x^8) - 104988672*(x^7) + 215617536*(x^6) - 97037312*(x^5) + 12262144*(x^4) - 362752*(x^3) - 1584*(x^2) + 88*x + 1
  private PVector[] vert = new PVector[84]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialPentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C10,  0.0,  C18 );
    vert[  1] = new PVector(  C10,  0.0, -C18 );
    vert[  2] = new PVector( -C10,  0.0,  C18 );
    vert[  3] = new PVector( -C10,  0.0, -C18 );
    vert[  4] = new PVector(  C18,  C10,  0.0 );
    vert[  5] = new PVector(  C18, -C10,  0.0 );
    vert[  6] = new PVector( -C18,  C10,  0.0 );
    vert[  7] = new PVector( -C18, -C10,  0.0 );
    vert[  8] = new PVector(  0.0,  C18,  C10 );
    vert[  9] = new PVector(  0.0,  C18, -C10 );
    vert[ 10] = new PVector(  0.0, -C18,  C10 );
    vert[ 11] = new PVector(  0.0, -C18, -C10 );
    vert[ 12] = new PVector(   C2,  -C1,  C17 );
    vert[ 13] = new PVector(   C2,   C1, -C17 );
    vert[ 14] = new PVector(  -C2,   C1,  C17 );
    vert[ 15] = new PVector(  -C2,  -C1, -C17 );
    vert[ 16] = new PVector(  C17,  -C2,   C1 );
    vert[ 17] = new PVector(  C17,   C2,  -C1 );
    vert[ 18] = new PVector( -C17,   C2,   C1 );
    vert[ 19] = new PVector( -C17,  -C2,  -C1 );
    vert[ 20] = new PVector(   C1, -C17,   C2 );
    vert[ 21] = new PVector(   C1,  C17,  -C2 );
    vert[ 22] = new PVector(  -C1,  C17,   C2 );
    vert[ 23] = new PVector(  -C1, -C17,  -C2 );
    vert[ 24] = new PVector(   C3,   C4,  C16 );
    vert[ 25] = new PVector(   C3,  -C4, -C16 );
    vert[ 26] = new PVector(  -C3,  -C4,  C16 );
    vert[ 27] = new PVector(  -C3,   C4, -C16 );
    vert[ 28] = new PVector(  C16,   C3,   C4 );
    vert[ 29] = new PVector(  C16,  -C3,  -C4 );
    vert[ 30] = new PVector( -C16,  -C3,   C4 );
    vert[ 31] = new PVector( -C16,   C3,  -C4 );
    vert[ 32] = new PVector(   C4,  C16,   C3 );
    vert[ 33] = new PVector(   C4, -C16,  -C3 );
    vert[ 34] = new PVector(  -C4, -C16,   C3 );
    vert[ 35] = new PVector(  -C4,  C16,  -C3 );
    vert[ 36] = new PVector(   C7,  0.0,  C15 );
    vert[ 37] = new PVector(   C7,  0.0, -C15 );
    vert[ 38] = new PVector(  -C7,  0.0,  C15 );
    vert[ 39] = new PVector(  -C7,  0.0, -C15 );
    vert[ 40] = new PVector(  C15,   C7,  0.0 );
    vert[ 41] = new PVector(  C15,  -C7,  0.0 );
    vert[ 42] = new PVector( -C15,   C7,  0.0 );
    vert[ 43] = new PVector( -C15,  -C7,  0.0 );
    vert[ 44] = new PVector(  0.0,  C15,   C7 );
    vert[ 45] = new PVector(  0.0,  C15,  -C7 );
    vert[ 46] = new PVector(  0.0, -C15,   C7 );
    vert[ 47] = new PVector(  0.0, -C15,  -C7 );
    vert[ 48] = new PVector(   C0,  -C9,  C14 );
    vert[ 49] = new PVector(   C0,   C9, -C14 );
    vert[ 50] = new PVector(  -C0,   C9,  C14 );
    vert[ 51] = new PVector(  -C0,  -C9, -C14 );
    vert[ 52] = new PVector(  C14,  -C0,   C9 );
    vert[ 53] = new PVector(  C14,   C0,  -C9 );
    vert[ 54] = new PVector( -C14,   C0,   C9 );
    vert[ 55] = new PVector( -C14,  -C0,  -C9 );
    vert[ 56] = new PVector(   C9, -C14,   C0 );
    vert[ 57] = new PVector(   C9,  C14,  -C0 );
    vert[ 58] = new PVector(  -C9,  C14,   C0 );
    vert[ 59] = new PVector(  -C9, -C14,  -C0 );
    vert[ 60] = new PVector(   C8,  -C6,  C13 );
    vert[ 61] = new PVector(   C8,   C6, -C13 );
    vert[ 62] = new PVector(  -C8,   C6,  C13 );
    vert[ 63] = new PVector(  -C8,  -C6, -C13 );
    vert[ 64] = new PVector(  C13,  -C8,   C6 );
    vert[ 65] = new PVector(  C13,   C8,  -C6 );
    vert[ 66] = new PVector( -C13,   C8,   C6 );
    vert[ 67] = new PVector( -C13,  -C8,  -C6 );
    vert[ 68] = new PVector(   C6, -C13,   C8 );
    vert[ 69] = new PVector(   C6,  C13,  -C8 );
    vert[ 70] = new PVector(  -C6,  C13,   C8 );
    vert[ 71] = new PVector(  -C6, -C13,  -C8 );
    vert[ 72] = new PVector(  C11,   C5,  C12 );
    vert[ 73] = new PVector(  C11,  -C5, -C12 );
    vert[ 74] = new PVector( -C11,  -C5,  C12 );
    vert[ 75] = new PVector( -C11,   C5, -C12 );
    vert[ 76] = new PVector(  C12,  C11,   C5 );
    vert[ 77] = new PVector(  C12, -C11,  -C5 );
    vert[ 78] = new PVector( -C12, -C11,   C5 );
    vert[ 79] = new PVector( -C12,  C11,  -C5 );
    vert[ 80] = new PVector(   C5,  C12,  C11 );
    vert[ 81] = new PVector(   C5, -C12, -C11 );
    vert[ 82] = new PVector(  -C5, -C12,  C11 );
    vert[ 83] = new PVector(  -C5,  C12, -C11 );
    // set faces
    faces[ 0] = new int[] {  0, 16, 17, 40, 76 };
    faces[ 1] = new int[] {  0, 76, 32, 44, 50 };
    faces[ 2] = new int[] {  0, 50, 62, 38, 26 };
    faces[ 3] = new int[] {  0, 26, 82, 46, 68 };
    faces[ 4] = new int[] {  0, 68, 56, 41, 16 };
    faces[ 5] = new int[] {  1, 17, 16, 41, 77 };
    faces[ 6] = new int[] {  1, 77, 33, 47, 51 };
    faces[ 7] = new int[] {  1, 51, 63, 39, 27 };
    faces[ 8] = new int[] {  1, 27, 83, 45, 69 };
    faces[ 9] = new int[] {  1, 69, 57, 40, 17 };
    faces[10] = new int[] {  2, 18, 19, 43, 78 };
    faces[11] = new int[] {  2, 78, 34, 46, 48 };
    faces[12] = new int[] {  2, 48, 60, 36, 24 };
    faces[13] = new int[] {  2, 24, 80, 44, 70 };
    faces[14] = new int[] {  2, 70, 58, 42, 18 };
    faces[15] = new int[] {  3, 19, 18, 42, 79 };
    faces[16] = new int[] {  3, 79, 35, 45, 49 };
    faces[17] = new int[] {  3, 49, 61, 37, 25 };
    faces[18] = new int[] {  3, 25, 81, 47, 71 };
    faces[19] = new int[] {  3, 71, 59, 43, 19 };
    faces[20] = new int[] {  4, 21, 22, 44, 80 };
    faces[21] = new int[] {  4, 80, 24, 36, 52 };
    faces[22] = new int[] {  4, 52, 64, 41, 29 };
    faces[23] = new int[] {  4, 29, 73, 37, 61 };
    faces[24] = new int[] {  4, 61, 49, 45, 21 };
    faces[25] = new int[] {  5, 20, 23, 47, 81 };
    faces[26] = new int[] {  5, 81, 25, 37, 53 };
    faces[27] = new int[] {  5, 53, 65, 40, 28 };
    faces[28] = new int[] {  5, 28, 72, 36, 60 };
    faces[29] = new int[] {  5, 60, 48, 46, 20 };
    faces[30] = new int[] {  6, 22, 21, 45, 83 };
    faces[31] = new int[] {  6, 83, 27, 39, 55 };
    faces[32] = new int[] {  6, 55, 67, 43, 30 };
    faces[33] = new int[] {  6, 30, 74, 38, 62 };
    faces[34] = new int[] {  6, 62, 50, 44, 22 };
    faces[35] = new int[] {  7, 23, 20, 46, 82 };
    faces[36] = new int[] {  7, 82, 26, 38, 54 };
    faces[37] = new int[] {  7, 54, 66, 42, 31 };
    faces[38] = new int[] {  7, 31, 75, 39, 63 };
    faces[39] = new int[] {  7, 63, 51, 47, 23 };
    faces[40] = new int[] {  8, 14, 12, 36, 72 };
    faces[41] = new int[] {  8, 72, 28, 40, 57 };
    faces[42] = new int[] {  8, 57, 69, 45, 35 };
    faces[43] = new int[] {  8, 35, 79, 42, 66 };
    faces[44] = new int[] {  8, 66, 54, 38, 14 };
    faces[45] = new int[] {  9, 13, 15, 39, 75 };
    faces[46] = new int[] {  9, 75, 31, 42, 58 };
    faces[47] = new int[] {  9, 58, 70, 44, 32 };
    faces[48] = new int[] {  9, 32, 76, 40, 65 };
    faces[49] = new int[] {  9, 65, 53, 37, 13 };
    faces[50] = new int[] { 10, 12, 14, 38, 74 };
    faces[51] = new int[] { 10, 74, 30, 43, 59 };
    faces[52] = new int[] { 10, 59, 71, 47, 33 };
    faces[53] = new int[] { 10, 33, 77, 41, 64 };
    faces[54] = new int[] { 10, 64, 52, 36, 12 };
    faces[55] = new int[] { 11, 15, 13, 37, 73 };
    faces[56] = new int[] { 11, 73, 29, 41, 56 };
    faces[57] = new int[] { 11, 56, 68, 46, 34 };
    faces[58] = new int[] { 11, 34, 78, 43, 67 };
    faces[59] = new int[] { 11, 67, 55, 39, 15 };
  } //end MedialPentagonalHexecontahedron()

  public String name() {
    return "Medial Pentagonal Hexecontahedron";
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
   
} //end class MedialPentagonalHexecontahedron
