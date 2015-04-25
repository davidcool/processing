/*
SnubDodecahedron (laevo) class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 92;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.192893711352359022108262546061;
  final float C1  = 0.330921024729844230963655269187;
  final float C2  = 0.374821658114562295266609516608;
  final float C3  = 0.567715369466921317374872062669;
  final float C4  = 0.643029605914072573107464141441;
  final float C5  = 0.728335176957191477360671629838;
  final float C6  = 0.847550046789060797396217956030;
  final float C7  = 1.103156835071753772627281146446;
  final float C8  = 1.24950378846302719500774109632;
  final float C9  = 1.41526541625598211477109001870;
  final float C10 = 1.45402422933801541929649491091;
  final float C11 = 1.64691794069037444140475745697;
  final float C12 = 1.74618644098582634573474528789;
  final float C13 = 1.97783896542021867236841272616;
  final float C14 = 2.097053835252087992403959052348;
  //C0  = phi * sqrt(3 - (x^2)) / 2
  //C1  = x * phi * sqrt(3 - (x^2)) / 2
  //C2  = phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C3  = (x^2) * phi * sqrt(3 - (x^2)) / 2
  //C4  = x * phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C5  = phi * sqrt(1 - x + (phi + 1) / x) / 2
  //C6  = phi * sqrt(x - phi + 1) / 2
  //C7  = (x^2) * phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C8  = x * phi * sqrt(1 - x + (phi + 1) / x) / 2
  //C9  = sqrt((x + 2) * phi + 2) / 2
  //C10 = x * sqrt(x * (phi + 1) - phi) / 2
  //C11 = sqrt((x^2) * (2 * phi + 1) - phi) / 2
  //C12 = phi * sqrt((x^2) + x) / 2
  //C13 = (phi^2) * sqrt(x * (x + phi) + 1) / (2 * x)
  //C14 = phi * sqrt(x * (x + phi) + 1) / 2
  //WHERE:  phi = (1 + sqrt(5)) / 2
  //        x = cbrt((phi + sqrt(phi-5/27))/2) + cbrt((phi - sqrt(phi-5/27))/2)
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C2,  -C1,  C14 );
    vert[  1] = new PVector(   C2,   C1, -C14 );
    vert[  2] = new PVector(  -C2,   C1,  C14 );
    vert[  3] = new PVector(  -C2,  -C1, -C14 );
    vert[  4] = new PVector(  C14,  -C2,   C1 );
    vert[  5] = new PVector(  C14,   C2,  -C1 );
    vert[  6] = new PVector( -C14,   C2,   C1 );
    vert[  7] = new PVector( -C14,  -C2,  -C1 );
    vert[  8] = new PVector(   C1, -C14,   C2 );
    vert[  9] = new PVector(   C1,  C14,  -C2 );
    vert[ 10] = new PVector(  -C1,  C14,   C2 );
    vert[ 11] = new PVector(  -C1, -C14,  -C2 );
    vert[ 12] = new PVector(   C3,   C4,  C13 );
    vert[ 13] = new PVector(   C3,  -C4, -C13 );
    vert[ 14] = new PVector(  -C3,  -C4,  C13 );
    vert[ 15] = new PVector(  -C3,   C4, -C13 );
    vert[ 16] = new PVector(  C13,   C3,   C4 );
    vert[ 17] = new PVector(  C13,  -C3,  -C4 );
    vert[ 18] = new PVector( -C13,  -C3,   C4 );
    vert[ 19] = new PVector( -C13,   C3,  -C4 );
    vert[ 20] = new PVector(   C4,  C13,   C3 );
    vert[ 21] = new PVector(   C4, -C13,  -C3 );
    vert[ 22] = new PVector(  -C4, -C13,   C3 );
    vert[ 23] = new PVector(  -C4,  C13,  -C3 );
    vert[ 24] = new PVector(   C0,  -C8,  C12 );
    vert[ 25] = new PVector(   C0,   C8, -C12 );
    vert[ 26] = new PVector(  -C0,   C8,  C12 );
    vert[ 27] = new PVector(  -C0,  -C8, -C12 );
    vert[ 28] = new PVector(  C12,  -C0,   C8 );
    vert[ 29] = new PVector(  C12,   C0,  -C8 );
    vert[ 30] = new PVector( -C12,   C0,   C8 );
    vert[ 31] = new PVector( -C12,  -C0,  -C8 );
    vert[ 32] = new PVector(   C8, -C12,   C0 );
    vert[ 33] = new PVector(   C8,  C12,  -C0 );
    vert[ 34] = new PVector(  -C8,  C12,   C0 );
    vert[ 35] = new PVector(  -C8, -C12,  -C0 );
    vert[ 36] = new PVector(   C7,  -C6,  C11 );
    vert[ 37] = new PVector(   C7,   C6, -C11 );
    vert[ 38] = new PVector(  -C7,   C6,  C11 );
    vert[ 39] = new PVector(  -C7,  -C6, -C11 );
    vert[ 40] = new PVector(  C11,  -C7,   C6 );
    vert[ 41] = new PVector(  C11,   C7,  -C6 );
    vert[ 42] = new PVector( -C11,   C7,   C6 );
    vert[ 43] = new PVector( -C11,  -C7,  -C6 );
    vert[ 44] = new PVector(   C6, -C11,   C7 );
    vert[ 45] = new PVector(   C6,  C11,  -C7 );
    vert[ 46] = new PVector(  -C6,  C11,   C7 );
    vert[ 47] = new PVector(  -C6, -C11,  -C7 );
    vert[ 48] = new PVector(   C9,   C5,  C10 );
    vert[ 49] = new PVector(   C9,  -C5, -C10 );
    vert[ 50] = new PVector(  -C9,  -C5,  C10 );
    vert[ 51] = new PVector(  -C9,   C5, -C10 );
    vert[ 52] = new PVector(  C10,   C9,   C5 );
    vert[ 53] = new PVector(  C10,  -C9,  -C5 );
    vert[ 54] = new PVector( -C10,  -C9,   C5 );
    vert[ 55] = new PVector( -C10,   C9,  -C5 );
    vert[ 56] = new PVector(   C5,  C10,   C9 );
    vert[ 57] = new PVector(   C5, -C10,  -C9 );
    vert[ 58] = new PVector(  -C5, -C10,   C9 );
    vert[ 59] = new PVector(  -C5,  C10,  -C9 );
    // set faces
    faces[ 0] = new int[] {  0, 36, 28, 48, 12 };
    faces[ 1] = new int[] {  1, 37, 29, 49, 13 };
    faces[ 2] = new int[] {  2, 38, 30, 50, 14 };
    faces[ 3] = new int[] {  3, 39, 31, 51, 15 };
    faces[ 4] = new int[] {  4, 40, 32, 53, 17 };
    faces[ 5] = new int[] {  5, 41, 33, 52, 16 };
    faces[ 6] = new int[] {  6, 42, 34, 55, 19 };
    faces[ 7] = new int[] {  7, 43, 35, 54, 18 };
    faces[ 8] = new int[] {  8, 44, 24, 58, 22 };
    faces[ 9] = new int[] {  9, 45, 25, 59, 23 };
    faces[10] = new int[] { 10, 46, 26, 56, 20 };
    faces[11] = new int[] { 11, 47, 27, 57, 21 };
    faces[12] = new int[] {  0,  2, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[13] = new int[] {  1,  3, 15, 15, 15 };  //added 2x 3rd number to fill gap
    faces[14] = new int[] {  2,  0, 12, 12, 12 };  //added 2x 3rd number to fill gap
    faces[15] = new int[] {  3,  1, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[16] = new int[] {  4,  5, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[17] = new int[] {  5,  4, 17, 17, 17 };  //added 2x 3rd number to fill gap
    faces[18] = new int[] {  6,  7, 18, 18, 18 };  //added 2x 3rd number to fill gap
    faces[19] = new int[] {  7,  6, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[20] = new int[] {  8, 11, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[21] = new int[] {  9, 10, 20, 20, 20 };  //added 2x 3rd number to fill gap
    faces[22] = new int[] { 10,  9, 23, 23, 23 };  //added 2x 3rd number to fill gap
    faces[23] = new int[] { 11,  8, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[24] = new int[] { 12, 48, 56, 56, 56 };  //added 2x 3rd number to fill gap
    faces[25] = new int[] { 13, 49, 57, 57, 57 };  //added 2x 3rd number to fill gap
    faces[26] = new int[] { 14, 50, 58, 58, 58 };  //added 2x 3rd number to fill gap
    faces[27] = new int[] { 15, 51, 59, 59, 59 };  //added 2x 3rd number to fill gap
    faces[28] = new int[] { 16, 52, 48, 48, 48 };  //added 2x 3rd number to fill gap
    faces[29] = new int[] { 17, 53, 49, 49, 49 };  //added 2x 3rd number to fill gap
    faces[30] = new int[] { 18, 54, 50, 50, 50 };  //added 2x 3rd number to fill gap
    faces[31] = new int[] { 19, 55, 51, 51, 51 };  //added 2x 3rd number to fill gap
    faces[32] = new int[] { 20, 56, 52, 52, 52 };  //added 2x 3rd number to fill gap
    faces[33] = new int[] { 21, 57, 53, 53, 53 };  //added 2x 3rd number to fill gap
    faces[34] = new int[] { 22, 58, 54, 54, 54 };  //added 2x 3rd number to fill gap
    faces[35] = new int[] { 23, 59, 55, 55, 55 };  //added 2x 3rd number to fill gap
    faces[36] = new int[] { 24, 44, 36, 36, 36 };  //added 2x 3rd number to fill gap
    faces[37] = new int[] { 25, 45, 37, 37, 37 };  //added 2x 3rd number to fill gap
    faces[38] = new int[] { 26, 46, 38, 38, 38 };  //added 2x 3rd number to fill gap
    faces[39] = new int[] { 27, 47, 39, 39, 39 };  //added 2x 3rd number to fill gap
    faces[40] = new int[] { 28, 36, 40, 40, 40 };  //added 2x 3rd number to fill gap
    faces[41] = new int[] { 29, 37, 41, 41, 41 };  //added 2x 3rd number to fill gap
    faces[42] = new int[] { 30, 38, 42, 42, 42 };  //added 2x 3rd number to fill gap
    faces[43] = new int[] { 31, 39, 43, 43, 43 };  //added 2x 3rd number to fill gap
    faces[44] = new int[] { 32, 40, 44, 44, 44 };  //added 2x 3rd number to fill gap
    faces[45] = new int[] { 33, 41, 45, 45, 45 };  //added 2x 3rd number to fill gap
    faces[46] = new int[] { 34, 42, 46, 46, 46 };  //added 2x 3rd number to fill gap
    faces[47] = new int[] { 35, 43, 47, 47, 47 };  //added 2x 3rd number to fill gap
    faces[48] = new int[] { 36,  0, 24, 24, 24 };  //added 2x 3rd number to fill gap
    faces[49] = new int[] { 37,  1, 25, 25, 25 };  //added 2x 3rd number to fill gap
    faces[50] = new int[] { 38,  2, 26, 26, 26 };  //added 2x 3rd number to fill gap
    faces[51] = new int[] { 39,  3, 27, 27, 27 };  //added 2x 3rd number to fill gap
    faces[52] = new int[] { 40,  4, 28, 28, 28 };  //added 2x 3rd number to fill gap
    faces[53] = new int[] { 41,  5, 29, 29, 29 };  //added 2x 3rd number to fill gap
    faces[54] = new int[] { 42,  6, 30, 30, 30 };  //added 2x 3rd number to fill gap
    faces[55] = new int[] { 43,  7, 31, 31, 31 };  //added 2x 3rd number to fill gap
    faces[56] = new int[] { 44,  8, 32, 32, 32 };  //added 2x 3rd number to fill gap
    faces[57] = new int[] { 45,  9, 33, 33, 33 };  //added 2x 3rd number to fill gap
    faces[58] = new int[] { 46, 10, 34, 34, 34 };  //added 2x 3rd number to fill gap
    faces[59] = new int[] { 47, 11, 35, 35, 35 };  //added 2x 3rd number to fill gap
    faces[60] = new int[] { 48, 28, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[61] = new int[] { 49, 29, 17, 17, 17 };  //added 2x 3rd number to fill gap
    faces[62] = new int[] { 50, 30, 18, 18, 18 };  //added 2x 3rd number to fill gap
    faces[63] = new int[] { 51, 31, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[64] = new int[] { 52, 33, 20, 20, 20 };  //added 2x 3rd number to fill gap
    faces[65] = new int[] { 53, 32, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[66] = new int[] { 54, 35, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[67] = new int[] { 55, 34, 23, 23, 23 };  //added 2x 3rd number to fill gap
    faces[68] = new int[] { 56, 26, 12, 12, 12 };  //added 2x 3rd number to fill gap
    faces[69] = new int[] { 57, 27, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[70] = new int[] { 58, 24, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[71] = new int[] { 59, 25, 15, 15, 15 };  //added 2x 3rd number to fill gap
    faces[72] = new int[] { 24,  0, 14, 14, 14 };  //added 2x 3rd number to fill gap
    faces[73] = new int[] { 25,  1, 15, 15, 15 };  //added 2x 3rd number to fill gap
    faces[74] = new int[] { 26,  2, 12, 12, 12 };  //added 2x 3rd number to fill gap
    faces[75] = new int[] { 27,  3, 13, 13, 13 };  //added 2x 3rd number to fill gap
    faces[76] = new int[] { 28,  4, 16, 16, 16 };  //added 2x 3rd number to fill gap
    faces[77] = new int[] { 29,  5, 17, 17, 17 };  //added 2x 3rd number to fill gap
    faces[78] = new int[] { 30,  6, 18, 18, 18 };  //added 2x 3rd number to fill gap
    faces[79] = new int[] { 31,  7, 19, 19, 19 };  //added 2x 3rd number to fill gap
    faces[80] = new int[] { 32,  8, 21, 21, 21 };  //added 2x 3rd number to fill gap
    faces[81] = new int[] { 33,  9, 20, 20, 20 };  //added 2x 3rd number to fill gap
    faces[82] = new int[] { 34, 10, 23, 23, 23 };  //added 2x 3rd number to fill gap
    faces[83] = new int[] { 35, 11, 22, 22, 22 };  //added 2x 3rd number to fill gap
    faces[84] = new int[] { 36, 44, 40, 40, 40 };  //added 2x 3rd number to fill gap
    faces[85] = new int[] { 37, 45, 41, 41, 41 };  //added 2x 3rd number to fill gap
    faces[86] = new int[] { 38, 46, 42, 42, 42 };  //added 2x 3rd number to fill gap
    faces[87] = new int[] { 39, 47, 43, 43, 43 };  //added 2x 3rd number to fill gap
    faces[88] = new int[] { 48, 52, 56, 56, 56 };  //added 2x 3rd number to fill gap
    faces[89] = new int[] { 49, 53, 57, 57, 57 };  //added 2x 3rd number to fill gap
    faces[90] = new int[] { 50, 54, 58, 58, 58 };  //added 2x 3rd number to fill gap
    faces[91] = new int[] { 51, 55, 59, 59, 59 };  //added 2x 3rd number to fill gap
  } //end SnubDodecahedron()

  public String name() {
    return "Snub Dodecahedron (laevo)";
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
   
} //end class SnubDodecahedron
