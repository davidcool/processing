/*
GreatRetrosnubIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatRetrosnubIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 92;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0500355497789497107813240716460; //square-root of a root of the polynomial:  4096*(x^6) - 17408*(x^5) + 28672*(x^4) - 21696*(x^3) + 6672*(x^2) - 416*x + 1
  final float C1  = 0.0560019989928211678603893479474; //square-root of a root of the polynomial: 4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  final float C2  = 0.136961219180949087853660273214;  //square-root of a root of the polynomial: 4096*(x^6) - 9728*(x^4) - 3072*(x^3) + 4256*(x^2) - 132*x + 1
  final float C3  = 0.140648687587271738919162329994;  //square-root of a root of the polynomial: 4096*(x^6) - 8192*(x^5) + 1792*(x^4) - 7488*(x^3) + 3456*(x^2) - 116*x + 1
  final float C4  = 0.153293050491351512698900732738;  //square-root of a root of the polynomial: 4096*(x^6) - 5120*(x^5) + 9472*(x^4) - 5888*(x^3) + 1216*(x^2) - 68*x + 1
  final float C5  = 0.1715723579964499481311091836148; //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) + 15872*(x^4) - 6016*(x^3) + 912*(x^2) - 56*x + 1
  final float C6  = 0.203328600270301223480224804384;  //square-root of a root of the polynomial: 4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C7  = 0.293941738078623251618063062732;  //square-root of a root of the polynomial: 4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C8  = 0.374900958266751171611333987999;  //square-root of a root of the polynomial: 4096*(x^6) - 18432*(x^5) + 29184*(x^4) - 20160*(x^3) + 5728*(x^2) - 488*x + 1
  final float C9  = 0.384994585115109604284725376882;  //square-root of a root of the polynomial: 4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C10 = 0.419605723930610464562174287283;  //square-root of a root of the polynomial: 4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C11 = 0.430902957259572339471723335946;  //square-root of a root of the polynomial: 4096*(x^6) + 3072*(x^5) - 3584*(x^4) - 2048*(x^3) + 1312*(x^2) - 160*x + 1
  final float C12 = 0.469641273709560175343498358929;  //square-root of a root of the polynomial: 4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C13 = 0.525643272702381343203887706876;  //square-root of a root of the polynomial: 4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C14 = 0.556566943111559552415834560497;  //square-root of a root of the polynomial: 4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatRetrosnubIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C5,  C12,   C7 );
    vert[  1] = new PVector(   C5,  C12,  -C7 );
    vert[  2] = new PVector(   C5, -C12,   C7 );
    vert[  3] = new PVector(  -C5, -C12,  -C7 );
    vert[  4] = new PVector(  C12,   C7,  -C5 );
    vert[  5] = new PVector( -C12,   C7,   C5 );
    vert[  6] = new PVector( -C12,  -C7,  -C5 );
    vert[  7] = new PVector(  C12,  -C7,   C5 );
    vert[  8] = new PVector(   C7,  -C5,  C12 );
    vert[  9] = new PVector(  -C7,  -C5, -C12 );
    vert[ 10] = new PVector(  -C7,   C5,  C12 );
    vert[ 11] = new PVector(   C7,   C5, -C12 );
    vert[ 12] = new PVector(  -C4,  -C1, -C14 );
    vert[ 13] = new PVector(   C4,  -C1,  C14 );
    vert[ 14] = new PVector(   C4,   C1, -C14 );
    vert[ 15] = new PVector(  -C4,   C1,  C14 );
    vert[ 16] = new PVector(   C1, -C14,   C4 );
    vert[ 17] = new PVector(  -C1, -C14,  -C4 );
    vert[ 18] = new PVector(  -C1,  C14,   C4 );
    vert[ 19] = new PVector(   C1,  C14,  -C4 );
    vert[ 20] = new PVector(  C14,   C4,  -C1 );
    vert[ 21] = new PVector( -C14,   C4,   C1 );
    vert[ 22] = new PVector( -C14,  -C4,  -C1 );
    vert[ 23] = new PVector(  C14,  -C4,   C1 );
    vert[ 24] = new PVector(  -C2, -C13,   C6 );
    vert[ 25] = new PVector(   C2, -C13,  -C6 );
    vert[ 26] = new PVector(   C2,  C13,   C6 );
    vert[ 27] = new PVector(  -C2,  C13,  -C6 );
    vert[ 28] = new PVector( -C13,   C6,  -C2 );
    vert[ 29] = new PVector(  C13,   C6,   C2 );
    vert[ 30] = new PVector(  C13,  -C6,  -C2 );
    vert[ 31] = new PVector( -C13,  -C6,   C2 );
    vert[ 32] = new PVector(   C6,  -C2, -C13 );
    vert[ 33] = new PVector(  -C6,  -C2,  C13 );
    vert[ 34] = new PVector(  -C6,   C2, -C13 );
    vert[ 35] = new PVector(   C6,   C2,  C13 );
    vert[ 36] = new PVector(  C11,   C0,  -C9 );
    vert[ 37] = new PVector( -C11,   C0,   C9 );
    vert[ 38] = new PVector( -C11,  -C0,  -C9 );
    vert[ 39] = new PVector(  C11,  -C0,   C9 );
    vert[ 40] = new PVector(   C0,  -C9,  C11 );
    vert[ 41] = new PVector(  -C0,  -C9, -C11 );
    vert[ 42] = new PVector(  -C0,   C9,  C11 );
    vert[ 43] = new PVector(   C0,   C9, -C11 );
    vert[ 44] = new PVector(  -C9,  C11,   C0 );
    vert[ 45] = new PVector(   C9,  C11,  -C0 );
    vert[ 46] = new PVector(   C9, -C11,   C0 );
    vert[ 47] = new PVector(  -C9, -C11,  -C0 );
    vert[ 48] = new PVector(  C10,   C8,   C3 );
    vert[ 49] = new PVector( -C10,   C8,  -C3 );
    vert[ 50] = new PVector( -C10,  -C8,   C3 );
    vert[ 51] = new PVector(  C10,  -C8,  -C3 );
    vert[ 52] = new PVector(  -C8,   C3, -C10 );
    vert[ 53] = new PVector(   C8,   C3,  C10 );
    vert[ 54] = new PVector(   C8,  -C3, -C10 );
    vert[ 55] = new PVector(  -C8,  -C3,  C10 );
    vert[ 56] = new PVector(  -C3, -C10,   C8 );
    vert[ 57] = new PVector(   C3, -C10,  -C8 );
    vert[ 58] = new PVector(   C3,  C10,   C8 );
    vert[ 59] = new PVector(  -C3,  C10,  -C8 );
    // set faces
    faces[  0] = new int[] {  0, 36, 28, 48, 12 };
    faces[  1] = new int[] {  1, 37, 29, 49, 13 };
    faces[  2] = new int[] {  2, 38, 30, 50, 14 };
    faces[  3] = new int[] {  3, 39, 31, 51, 15 };
    faces[  4] = new int[] {  4, 40, 32, 53, 17 };
    faces[  5] = new int[] {  5, 41, 33, 52, 16 };
    faces[  6] = new int[] {  6, 42, 34, 55, 19 };
    faces[  7] = new int[] {  7, 43, 35, 54, 18 };
    faces[  8] = new int[] {  8, 44, 24, 58, 22 };
    faces[  9] = new int[] {  9, 45, 25, 59, 23 };
    faces[ 10] = new int[] { 10, 46, 26, 56, 20 };
    faces[ 11] = new int[] { 11, 47, 27, 57, 21 };
    faces[ 12] = new int[] {  0,  2, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 13] = new int[] {  1,  3, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 14] = new int[] {  2,  0, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 15] = new int[] {  3,  1, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 16] = new int[] {  4,  5, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 17] = new int[] {  5,  4, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 18] = new int[] {  6,  7, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 19] = new int[] {  7,  6, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 20] = new int[] {  8, 11, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 21] = new int[] {  9, 10, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 22] = new int[] { 10,  9, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 23] = new int[] { 11,  8, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 24] = new int[] { 12, 48, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] { 13, 49, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] { 14, 50, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] { 15, 51, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] { 16, 52, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] { 17, 53, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] { 18, 54, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] { 19, 55, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] { 20, 56, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] { 21, 57, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 22, 58, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 23, 59, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 24, 44, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 25, 45, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 26, 46, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 27, 47, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 28, 36, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 29, 37, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 30, 38, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 31, 39, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 32, 40, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 33, 41, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 34, 42, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 35, 43, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 36,  0, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 37,  1, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 38,  2, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 39,  3, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 40,  4, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 41,  5, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 42,  6, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 43,  7, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 44,  8, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 45,  9, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 46, 10, 34, 34, 34 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 47, 11, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 48, 28, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 49, 29, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 50, 30, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 51, 31, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 52, 33, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 53, 32, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 54, 35, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 55, 34, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 56, 26, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 57, 27, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 58, 24, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 59, 25, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 24,  0, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 25,  1, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 26,  2, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 27,  3, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 28,  4, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 29,  5, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 30,  6, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 31,  7, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 32,  8, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 33,  9, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 34, 10, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 35, 11, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] { 36, 44, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] { 37, 45, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] { 38, 46, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] { 39, 47, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] { 48, 52, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] { 49, 53, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] { 50, 54, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] { 51, 55, 59, 59, 59 };  //added 2x 3rd row to fill gaps
  } //end GreatRetrosnubIcosidodecahedron()

  public String name() {
    return "Great Retrosnub Icosidodecahedron";
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
   
} //end class GreatRetrosnubIcosidodecahedron
