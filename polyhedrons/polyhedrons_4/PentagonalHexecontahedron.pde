/*
PentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class PentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.192893711352359022108262546061;
  final float C1  = 0.218483370127321224365534157111;
  final float C2  = 0.374821658114562295266609516608;
  final float C3  = 0.567715369466921317374872062669;
  final float C4  = 0.728335176957191477360671629838;
  final float C5  = 0.755467260516595579705585253517;
  final float C6  = 0.824957552676275846265811111988;
  final float C7  = 0.921228888309550499468934175898;
  final float C8  = 0.959987701391583803994339068107;
  final float C9  = 1.13706613386050418840961998424;
  final float C10 = 1.16712343647533397917215468549;
  final float C11 = 1.22237170490362309266282747264;
  final float C12 = 1.27209628257581214613814794036;
  final float C13 = 1.52770307085850512136921113078;
  final float C14 = 1.64691794069037444140475745697;
  final float C15 = 1.74618644098582634573474528789;
  final float C16 = 1.86540131081769566577029161408;
  final float C17 = 1.88844538928366915418351670356;
  final float C18 = 1.97783896542021867236841272616;
  final float C19 = 2.097053835252087992403959052348;
  //C0  = phi * sqrt(3 - (x^2)) / 2
  //C1  = phi * sqrt((x - 1 - (1/x)) * phi) / (2 * x)
  //C2  = phi * sqrt((x - 1 - (1/x)) * phi) / 2
  //C3  = (x^2) * phi * sqrt(3 - (x^2)) / 2
  //C4  = phi * sqrt(1 - x + (phi + 1) / x) / 2
  //C5  = sqrt(x * (x + phi) + 1) / (2 * x)
  //C6  = sqrt((x + 2) * phi + 2) / (2 * x)
  //C7  = sqrt(-(x^2) * (phi + 2) + x * (3 * phi + 1) + 4) / 2
  //C8  = (phi + 1) * sqrt(1 + (1/x)) / (2 * x)
  //C9  = sqrt(3 * phi + 2 - 2 * x + (3/x)) / 2
  //C10 = sqrt((x^2)*(225*phi + 392) + x*(670*phi + 249) + (157*phi + 470))/62
  //C11 = phi * sqrt(x * (x + phi) + 1) / (2 * x)
  //C12 = phi * sqrt((x^2) + x + phi + 1) / (2 * x)
  //C13 = phi * sqrt((x^2) + 2 * x * phi + 2) / (2 * x)
  //C14 = sqrt((x^2) * (2 * phi + 1) - phi) / 2
  //C15 = phi * sqrt((x^2) + x) / 2
  //C16 = (phi^3) * sqrt(x * (x + phi) + 1) / (2 * (x^2))
  //C17 = sqrt((x^2)*(842*phi + 617) + x*(1589*phi + 919) + (784*phi + 627))/62
  //C18 = (phi^2) * sqrt(x * (x + phi) + 1) / (2 * x)
  //C19 = phi * sqrt(x * (x + phi) + 1) / 2
  //WHERE:  phi = (1 + sqrt(5)) / 2
  //        x = cbrt((phi + sqrt(phi-5/27))/2) + cbrt((phi - sqrt(phi-5/27))/2)
  private PVector[] vert = new PVector[92]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private PentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C0,  -C1, -C19 );
    vert[  1] = new PVector(  -C0,   C1,  C19 );
    vert[  2] = new PVector(   C0,   C1, -C19 );
    vert[  3] = new PVector(   C0,  -C1,  C19 );
    vert[  4] = new PVector( -C19,  -C0,  -C1 );
    vert[  5] = new PVector( -C19,   C0,   C1 );
    vert[  6] = new PVector(  C19,   C0,  -C1 );
    vert[  7] = new PVector(  C19,  -C0,   C1 );
    vert[  8] = new PVector(  -C1, -C19,  -C0 );
    vert[  9] = new PVector(  -C1,  C19,   C0 );
    vert[ 10] = new PVector(   C1,  C19,  -C0 );
    vert[ 11] = new PVector(   C1, -C19,   C0 );
    vert[ 12] = new PVector(  0.0,  -C5, -C18 );
    vert[ 13] = new PVector(  0.0,  -C5,  C18 );
    vert[ 14] = new PVector(  0.0,   C5, -C18 );
    vert[ 15] = new PVector(  0.0,   C5,  C18 );
    vert[ 16] = new PVector( -C18,  0.0,  -C5 );
    vert[ 17] = new PVector( -C18,  0.0,   C5 );
    vert[ 18] = new PVector(  C18,  0.0,  -C5 );
    vert[ 19] = new PVector(  C18,  0.0,   C5 );
    vert[ 20] = new PVector(  -C5, -C18,  0.0 );
    vert[ 21] = new PVector(  -C5,  C18,  0.0 );
    vert[ 22] = new PVector(   C5, -C18,  0.0 );
    vert[ 23] = new PVector(   C5,  C18,  0.0 );
    vert[ 24] = new PVector( -C10,  0.0, -C17 );
    vert[ 25] = new PVector( -C10,  0.0,  C17 );
    vert[ 26] = new PVector(  C10,  0.0, -C17 );
    vert[ 27] = new PVector(  C10,  0.0,  C17 );
    vert[ 28] = new PVector( -C17, -C10,  0.0 );
    vert[ 29] = new PVector( -C17,  C10,  0.0 );
    vert[ 30] = new PVector(  C17, -C10,  0.0 );
    vert[ 31] = new PVector(  C17,  C10,  0.0 );
    vert[ 32] = new PVector(  0.0, -C17, -C10 );
    vert[ 33] = new PVector(  0.0, -C17,  C10 );
    vert[ 34] = new PVector(  0.0,  C17, -C10 );
    vert[ 35] = new PVector(  0.0,  C17,  C10 );
    vert[ 36] = new PVector(  -C3,   C6, -C16 );
    vert[ 37] = new PVector(  -C3,  -C6,  C16 );
    vert[ 38] = new PVector(   C3,  -C6, -C16 );
    vert[ 39] = new PVector(   C3,   C6,  C16 );
    vert[ 40] = new PVector( -C16,   C3,  -C6 );
    vert[ 41] = new PVector( -C16,  -C3,   C6 );
    vert[ 42] = new PVector(  C16,  -C3,  -C6 );
    vert[ 43] = new PVector(  C16,   C3,   C6 );
    vert[ 44] = new PVector(  -C6,  C16,  -C3 );
    vert[ 45] = new PVector(  -C6, -C16,   C3 );
    vert[ 46] = new PVector(   C6, -C16,  -C3 );
    vert[ 47] = new PVector(   C6,  C16,   C3 );
    vert[ 48] = new PVector(  -C2,  -C9, -C15 );
    vert[ 49] = new PVector(  -C2,   C9,  C15 );
    vert[ 50] = new PVector(   C2,   C9, -C15 );
    vert[ 51] = new PVector(   C2,  -C9,  C15 );
    vert[ 52] = new PVector( -C15,  -C2,  -C9 );
    vert[ 53] = new PVector( -C15,   C2,   C9 );
    vert[ 54] = new PVector(  C15,   C2,  -C9 );
    vert[ 55] = new PVector(  C15,  -C2,   C9 );
    vert[ 56] = new PVector(  -C9, -C15,  -C2 );
    vert[ 57] = new PVector(  -C9,  C15,   C2 );
    vert[ 58] = new PVector(   C9,  C15,  -C2 );
    vert[ 59] = new PVector(   C9, -C15,   C2 );
    vert[ 60] = new PVector(  -C7,  -C8, -C14 );
    vert[ 61] = new PVector(  -C7,   C8,  C14 );
    vert[ 62] = new PVector(   C7,   C8, -C14 );
    vert[ 63] = new PVector(   C7,  -C8,  C14 );
    vert[ 64] = new PVector( -C14,  -C7,  -C8 );
    vert[ 65] = new PVector( -C14,   C7,   C8 );
    vert[ 66] = new PVector(  C14,   C7,  -C8 );
    vert[ 67] = new PVector(  C14,  -C7,   C8 );
    vert[ 68] = new PVector(  -C8, -C14,  -C7 );
    vert[ 69] = new PVector(  -C8,  C14,   C7 );
    vert[ 70] = new PVector(   C8,  C14,  -C7 );
    vert[ 71] = new PVector(   C8, -C14,   C7 );
    vert[ 72] = new PVector(  -C4,  C12, -C13 );
    vert[ 73] = new PVector(  -C4, -C12,  C13 );
    vert[ 74] = new PVector(   C4, -C12, -C13 );
    vert[ 75] = new PVector(   C4,  C12,  C13 );
    vert[ 76] = new PVector( -C13,   C4, -C12 );
    vert[ 77] = new PVector( -C13,  -C4,  C12 );
    vert[ 78] = new PVector(  C13,  -C4, -C12 );
    vert[ 79] = new PVector(  C13,   C4,  C12 );
    vert[ 80] = new PVector( -C12,  C13,  -C4 );
    vert[ 81] = new PVector( -C12, -C13,   C4 );
    vert[ 82] = new PVector(  C12, -C13,  -C4 );
    vert[ 83] = new PVector(  C12,  C13,   C4 );
    vert[ 84] = new PVector( -C11, -C11, -C11 );
    vert[ 85] = new PVector( -C11, -C11,  C11 );
    vert[ 86] = new PVector( -C11,  C11, -C11 );
    vert[ 87] = new PVector( -C11,  C11,  C11 );
    vert[ 88] = new PVector(  C11, -C11, -C11 );
    vert[ 89] = new PVector(  C11, -C11,  C11 );
    vert[ 90] = new PVector(  C11,  C11, -C11 );
    vert[ 91] = new PVector(  C11,  C11,  C11 );
    // set faces
    faces[  0] = new int[] { 24, 36, 14,  2,  0 };
    faces[  1] = new int[] { 24, 76, 86, 72, 36 };
    faces[  2] = new int[] { 24, 52, 16, 40, 76 };
    faces[  3] = new int[] { 24, 60, 84, 64, 52 };
    faces[  4] = new int[] { 24,  0, 12, 48, 60 };
    faces[  5] = new int[] { 25, 37, 13,  3,  1 };
    faces[  6] = new int[] { 25, 77, 85, 73, 37 };
    faces[  7] = new int[] { 25, 53, 17, 41, 77 };
    faces[  8] = new int[] { 25, 61, 87, 65, 53 };
    faces[  9] = new int[] { 25,  1, 15, 49, 61 };
    faces[ 10] = new int[] { 26, 38, 12,  0,  2 };
    faces[ 11] = new int[] { 26, 78, 88, 74, 38 };
    faces[ 12] = new int[] { 26, 54, 18, 42, 78 };
    faces[ 13] = new int[] { 26, 62, 90, 66, 54 };
    faces[ 14] = new int[] { 26,  2, 14, 50, 62 };
    faces[ 15] = new int[] { 27, 39, 15,  1,  3 };
    faces[ 16] = new int[] { 27, 79, 91, 75, 39 };
    faces[ 17] = new int[] { 27, 55, 19, 43, 79 };
    faces[ 18] = new int[] { 27, 63, 89, 67, 55 };
    faces[ 19] = new int[] { 27,  3, 13, 51, 63 };
    faces[ 20] = new int[] { 28, 41, 17,  5,  4 };
    faces[ 21] = new int[] { 28, 81, 85, 77, 41 };
    faces[ 22] = new int[] { 28, 56, 20, 45, 81 };
    faces[ 23] = new int[] { 28, 64, 84, 68, 56 };
    faces[ 24] = new int[] { 28,  4, 16, 52, 64 };
    faces[ 25] = new int[] { 29, 40, 16,  4,  5 };
    faces[ 26] = new int[] { 29, 80, 86, 76, 40 };
    faces[ 27] = new int[] { 29, 57, 21, 44, 80 };
    faces[ 28] = new int[] { 29, 65, 87, 69, 57 };
    faces[ 29] = new int[] { 29,  5, 17, 53, 65 };
    faces[ 30] = new int[] { 30, 42, 18,  6,  7 };
    faces[ 31] = new int[] { 30, 82, 88, 78, 42 };
    faces[ 32] = new int[] { 30, 59, 22, 46, 82 };
    faces[ 33] = new int[] { 30, 67, 89, 71, 59 };
    faces[ 34] = new int[] { 30,  7, 19, 55, 67 };
    faces[ 35] = new int[] { 31, 43, 19,  7,  6 };
    faces[ 36] = new int[] { 31, 83, 91, 79, 43 };
    faces[ 37] = new int[] { 31, 58, 23, 47, 83 };
    faces[ 38] = new int[] { 31, 66, 90, 70, 58 };
    faces[ 39] = new int[] { 31,  6, 18, 54, 66 };
    faces[ 40] = new int[] { 32, 46, 22, 11,  8 };
    faces[ 41] = new int[] { 32, 74, 88, 82, 46 };
    faces[ 42] = new int[] { 32, 48, 12, 38, 74 };
    faces[ 43] = new int[] { 32, 68, 84, 60, 48 };
    faces[ 44] = new int[] { 32,  8, 20, 56, 68 };
    faces[ 45] = new int[] { 33, 45, 20,  8, 11 };
    faces[ 46] = new int[] { 33, 73, 85, 81, 45 };
    faces[ 47] = new int[] { 33, 51, 13, 37, 73 };
    faces[ 48] = new int[] { 33, 71, 89, 63, 51 };
    faces[ 49] = new int[] { 33, 11, 22, 59, 71 };
    faces[ 50] = new int[] { 34, 44, 21,  9, 10 };
    faces[ 51] = new int[] { 34, 72, 86, 80, 44 };
    faces[ 52] = new int[] { 34, 50, 14, 36, 72 };
    faces[ 53] = new int[] { 34, 70, 90, 62, 50 };
    faces[ 54] = new int[] { 34, 10, 23, 58, 70 };
    faces[ 55] = new int[] { 35, 47, 23, 10,  9 };
    faces[ 56] = new int[] { 35, 75, 91, 83, 47 };
    faces[ 57] = new int[] { 35, 49, 15, 39, 75 };
    faces[ 58] = new int[] { 35, 69, 87, 61, 49 };
    faces[ 59] = new int[] { 35,  9, 21, 57, 69 };
  } //end PentagonalHexecontahedron()

  public String name() {
    return "Pentagonal Hexecontahedron (laevo)";
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
   
} //end class PentagonalHexecontahedron
