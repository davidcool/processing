/*
InvertedSnubDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class InvertedSnubDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 84;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0696395523817213604419851293951;   //square-root of a root of the polynomial:  65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C1  = 0.09104043995654983602406069932748;  //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 69632*(x^6) - 43008*(x^5) + 22528*(x^4) - 4544*(x^3) + 1888*(x^2) - 136*x + 1
  final float C2  = 0.158913928975781502336378249411;    //square-root of a root of the polynomial:  65536*(x^8) - 65536*(x^7) - 16384*(x^6) + 26624*(x^5) + 3584*(x^4) - 4864*(x^3) + 928*(x^2) - 60*x + 1
  final float C3  = 0.249954368932331338360438948738;    //square-root of a root of the polynomial:  4096*(x^8) - 5120*(x^7) + 3072*(x^6) - 1920*(x^5) + 1248*(x^4) - 600*(x^3) + 177*(x^2) - 25*x + 1
  final float C4  = 0.271593091690735355039435204098;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 69632*(x^6) - 43008*(x^5) + 22528*(x^4) - 4544*(x^3) + 1888*(x^2) - 136*x + 1
  final float C5  = 0.326767690750322596730834708807;    //square-root of a root of the polynomial:  64*(x^4) - 112*(x^3) + 64*(x^2) - 15*x + 1
  final float C6  = 0.362633531647285191063495903426;    //square-root of a root of the polynomial:  256*(x^4) - 448*(x^3) + 240*(x^2) - 32*x + 1
  final float C7  = 0.369807301083555088991906534100;    //square-root of a root of the polynomial:  65536*(x^8) - 81920*(x^7) - 36864*(x^6) + 5120*(x^5) + 10496*(x^4) + 320*(x^3) - 144*(x^2) - 20*x + 1
  final float C8  = 0.474074216950764231535287447394;    //square-root of a root of the polynomial:  65536*(x^8) - 65536*(x^7) - 16384*(x^6) + 26624*(x^5) + 3584*(x^4) - 4864*(x^3) + 928*(x^2) - 60*x + 1
  final float C9  = 0.517113827283996723796359272686;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 90112*(x^6) - 48128*(x^5) + 11008*(x^4) + 2496*(x^3) - 592*(x^2) - 76*x + 1
  final float C10 = 0.619761670015886427352345482838;    //square-root of a root of the polynomial:  65536*(x^8) - 163840*(x^7) + 196608*(x^6) - 138240*(x^5) + 60928*(x^4) - 17280*(x^3) + 2928*(x^2) - 220*x + 1
  final float C11 = 0.676027756259778226132737522097;    //square-root of a root of the polynomial:  65536*(x^8) - 81920*(x^7) - 36864*(x^6) + 5120*(x^5) + 10496*(x^4) + 320*(x^3) - 144*(x^2) - 20*x + 1
  final float C12 = 0.689401222397607787794330612233;    //square-root of a root of the polynomial:  256*(x^4) - 512*(x^3) + 240*(x^2) - 28*x + 1
  final float C13 = 0.745667308641499586574722651492;    //square-root of a root of the polynomial:  4096*(x^8) - 5120*(x^7) + 3072*(x^6) - 1920*(x^5) + 1248*(x^4) - 600*(x^3) + 177*(x^2) - 25*x + 1
  final float C14 = 0.843881518034319320527193981494;    //square-root of a root of the polynomial:  65536*(x^8) - 114688*(x^7) + 90112*(x^6) - 48128*(x^5) + 11008*(x^4) + 2496*(x^3) - 592*(x^2) - 76*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private InvertedSnubDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  C11,   C6,   C7 );
    vert[  1] = new PVector(  C11,  -C6,  -C7 );
    vert[  2] = new PVector( -C11,  -C6,   C7 );
    vert[  3] = new PVector( -C11,   C6,  -C7 );
    vert[  4] = new PVector(   C7,  C11,   C6 );
    vert[  5] = new PVector(   C7, -C11,  -C6 );
    vert[  6] = new PVector(  -C7, -C11,   C6 );
    vert[  7] = new PVector(  -C7,  C11,  -C6 );
    vert[  8] = new PVector(   C6,   C7,  C11 );
    vert[  9] = new PVector(   C6,  -C7, -C11 );
    vert[ 10] = new PVector(  -C6,  -C7,  C11 );
    vert[ 11] = new PVector(  -C6,   C7, -C11 );
    vert[ 12] = new PVector(   C2,   C8,  C12 );
    vert[ 13] = new PVector(   C2,  -C8, -C12 );
    vert[ 14] = new PVector(  -C2,  -C8,  C12 );
    vert[ 15] = new PVector(  -C2,   C8, -C12 );
    vert[ 16] = new PVector(  C12,  -C2,  -C8 );
    vert[ 17] = new PVector(  C12,   C2,   C8 );
    vert[ 18] = new PVector( -C12,   C2,  -C8 );
    vert[ 19] = new PVector( -C12,  -C2,   C8 );
    vert[ 20] = new PVector(  -C8, -C12,   C2 );
    vert[ 21] = new PVector(  -C8,  C12,  -C2 );
    vert[ 22] = new PVector(   C8,  C12,   C2 );
    vert[ 23] = new PVector(   C8, -C12,  -C2 );
    vert[ 24] = new PVector(  -C9,  C10,   C4 );
    vert[ 25] = new PVector(  -C9, -C10,  -C4 );
    vert[ 26] = new PVector(   C9, -C10,   C4 );
    vert[ 27] = new PVector(   C9,  C10,  -C4 );
    vert[ 28] = new PVector(   C4,  -C9,  C10 );
    vert[ 29] = new PVector(   C4,   C9, -C10 );
    vert[ 30] = new PVector(  -C4,   C9,  C10 );
    vert[ 31] = new PVector(  -C4,  -C9, -C10 );
    vert[ 32] = new PVector(  C10,   C4,  -C9 );
    vert[ 33] = new PVector(  C10,  -C4,   C9 );
    vert[ 34] = new PVector( -C10,  -C4,  -C9 );
    vert[ 35] = new PVector( -C10,   C4,   C9 );
    vert[ 36] = new PVector(  C13,  -C3,   C5 );
    vert[ 37] = new PVector(  C13,   C3,  -C5 );
    vert[ 38] = new PVector( -C13,   C3,   C5 );
    vert[ 39] = new PVector( -C13,  -C3,  -C5 );
    vert[ 40] = new PVector(   C5,  C13,  -C3 );
    vert[ 41] = new PVector(   C5, -C13,   C3 );
    vert[ 42] = new PVector(  -C5, -C13,  -C3 );
    vert[ 43] = new PVector(  -C5,  C13,   C3 );
    vert[ 44] = new PVector(  -C3,   C5,  C13 );
    vert[ 45] = new PVector(  -C3,  -C5, -C13 );
    vert[ 46] = new PVector(   C3,  -C5,  C13 );
    vert[ 47] = new PVector(   C3,   C5, -C13 );
    vert[ 48] = new PVector(  -C1,  -C0,  C14 );
    vert[ 49] = new PVector(  -C1,   C0, -C14 );
    vert[ 50] = new PVector(   C1,   C0,  C14 );
    vert[ 51] = new PVector(   C1,  -C0, -C14 );
    vert[ 52] = new PVector(  C14,   C1,   C0 );
    vert[ 53] = new PVector(  C14,  -C1,  -C0 );
    vert[ 54] = new PVector( -C14,  -C1,   C0 );
    vert[ 55] = new PVector( -C14,   C1,  -C0 );
    vert[ 56] = new PVector(   C0, -C14,  -C1 );
    vert[ 57] = new PVector(   C0,  C14,   C1 );
    vert[ 58] = new PVector(  -C0,  C14,  -C1 );
    vert[ 59] = new PVector(  -C0, -C14,   C1 );
    // set faces
    faces[  0] = new int[] {  0, 28, 12, 36, 48 };
    faces[  1] = new int[] {  1, 29, 13, 37, 49 };
    faces[  2] = new int[] {  2, 30, 14, 38, 50 };
    faces[  3] = new int[] {  3, 31, 15, 39, 51 };
    faces[  4] = new int[] {  4, 32, 17, 40, 53 };
    faces[  5] = new int[] {  5, 33, 16, 41, 52 };
    faces[  6] = new int[] {  6, 34, 19, 42, 55 };
    faces[  7] = new int[] {  7, 35, 18, 43, 54 };
    faces[  8] = new int[] {  8, 24, 22, 44, 58 };
    faces[  9] = new int[] {  9, 25, 23, 45, 59 };
    faces[ 10] = new int[] { 10, 26, 20, 46, 56 };
    faces[ 11] = new int[] { 11, 27, 21, 47, 57 };
    faces[ 12] = new int[] {  0, 26, 42, 18, 58 };
    faces[ 13] = new int[] {  1, 27, 43, 19, 59 };
    faces[ 14] = new int[] {  2, 24, 40, 16, 56 };
    faces[ 15] = new int[] {  3, 25, 41, 17, 57 };
    faces[ 16] = new int[] {  4, 29, 45, 20, 48 };
    faces[ 17] = new int[] {  5, 28, 44, 21, 49 };
    faces[ 18] = new int[] {  6, 31, 47, 22, 50 };
    faces[ 19] = new int[] {  7, 30, 46, 23, 51 };
    faces[ 20] = new int[] {  8, 35, 39, 13, 53 };
    faces[ 21] = new int[] {  9, 34, 38, 12, 52 };
    faces[ 22] = new int[] { 10, 33, 37, 15, 55 };
    faces[ 23] = new int[] { 11, 32, 36, 14, 54 };
    faces[ 24] = new int[] {  0, 58, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] {  1, 59, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] {  2, 56, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] {  3, 57, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] {  4, 48, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] {  5, 49, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] {  6, 50, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] {  7, 51, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] {  8, 53, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] {  9, 52, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 10, 55, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 11, 54, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 12, 38, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 13, 39, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 14, 36, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 15, 37, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 16, 40, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 17, 41, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 18, 42, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 19, 43, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 20, 45, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 21, 44, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 22, 47, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 23, 46, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 24,  2, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 25,  3, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 26,  0, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 27,  1, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 28,  5, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 29,  4, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 30,  7, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 31,  6, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 32, 11, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 33, 10, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 34,  9, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 35,  8, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 36, 32,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 37, 33,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 38, 34,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 39, 35,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 40, 24,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 41, 25,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 42, 26, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 43, 27, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 44, 28,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 45, 29,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 46, 30,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 47, 31,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 48, 20, 26, 26, 26 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 49, 21, 27, 27, 27 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 50, 22, 24, 24, 24 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 51, 23, 25, 25, 25 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 52, 12, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 53, 13, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 54, 14, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 55, 15, 31, 31, 31 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 56, 16, 33, 33, 33 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 57, 17, 32, 32, 32 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 58, 18, 35, 35, 35 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 59, 19, 34, 34, 34 };  //added 2x 3rd row to fill gaps
  } //end InvertedSnubDodecadodecahedron()

  public String name() {
    return "Inverted Snub Dodecadodecahedron";
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
   
} //end class InvertedSnubDodecadodecahedron
