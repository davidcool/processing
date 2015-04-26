/*
SmallDodecacronicHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDodecacronicHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.783457635340899531654962439488;  //(15 + sqrt(5)) / 22
  final float C1 = 1.20601132958329828273486227812;   //(5 + sqrt(5)) / 6
  final float C2 = 1.26766108272719625323969951590;   //(5 + 4 * sqrt(5)) / 11
  final float C3 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C4 = 1.95136732208322818153792016770;   //(5 + 3 * sqrt(5)) / 6
  final float C5 = 2.05111871806809578489466195539;   //(25 + 9 * sqrt(5)) / 22
  final float C6 = 2.61803398874989484820458683437;   //(3 + sqrt(5)) / 2
  private PVector[] vert = new PVector[44]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDodecacronicHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C3, 0.0,  C6 );
    vert[  1] = new PVector(  C3, 0.0, -C6 );
    vert[  2] = new PVector( -C3, 0.0,  C6 );
    vert[  3] = new PVector( -C3, 0.0, -C6 );
    vert[  4] = new PVector(  C6,  C3, 0.0 );
    vert[  5] = new PVector(  C6, -C3, 0.0 );
    vert[  6] = new PVector( -C6,  C3, 0.0 );
    vert[  7] = new PVector( -C6, -C3, 0.0 );
    vert[  8] = new PVector( 0.0,  C6,  C3 );
    vert[  9] = new PVector( 0.0,  C6, -C3 );
    vert[ 10] = new PVector( 0.0, -C6,  C3 );
    vert[ 11] = new PVector( 0.0, -C6, -C3 );
    vert[ 12] = new PVector( 0.0,  C0,  C5 );
    vert[ 13] = new PVector( 0.0,  C0, -C5 );
    vert[ 14] = new PVector( 0.0, -C0,  C5 );
    vert[ 15] = new PVector( 0.0, -C0, -C5 );
    vert[ 16] = new PVector(  C5, 0.0,  C0 );
    vert[ 17] = new PVector(  C5, 0.0, -C0 );
    vert[ 18] = new PVector( -C5, 0.0,  C0 );
    vert[ 19] = new PVector( -C5, 0.0, -C0 );
    vert[ 20] = new PVector(  C0,  C5, 0.0 );
    vert[ 21] = new PVector(  C0, -C5, 0.0 );
    vert[ 22] = new PVector( -C0,  C5, 0.0 );
    vert[ 23] = new PVector( -C0, -C5, 0.0 );
    vert[ 24] = new PVector(  C1, 0.0,  C4 );
    vert[ 25] = new PVector(  C1, 0.0, -C4 );
    vert[ 26] = new PVector( -C1, 0.0,  C4 );
    vert[ 27] = new PVector( -C1, 0.0, -C4 );
    vert[ 28] = new PVector(  C4,  C1, 0.0 );
    vert[ 29] = new PVector(  C4, -C1, 0.0 );
    vert[ 30] = new PVector( -C4,  C1, 0.0 );
    vert[ 31] = new PVector( -C4, -C1, 0.0 );
    vert[ 32] = new PVector( 0.0,  C4,  C1 );
    vert[ 33] = new PVector( 0.0,  C4, -C1 );
    vert[ 34] = new PVector( 0.0, -C4,  C1 );
    vert[ 35] = new PVector( 0.0, -C4, -C1 );
    vert[ 36] = new PVector(  C2,  C2,  C2 );
    vert[ 37] = new PVector(  C2,  C2, -C2 );
    vert[ 38] = new PVector(  C2, -C2,  C2 );
    vert[ 39] = new PVector(  C2, -C2, -C2 );
    vert[ 40] = new PVector( -C2,  C2,  C2 );
    vert[ 41] = new PVector( -C2,  C2, -C2 );
    vert[ 42] = new PVector( -C2, -C2,  C2 );
    vert[ 43] = new PVector( -C2, -C2, -C2 );
    // set faces
    faces[ 0] = new int[] { 24,  2, 14, 10 };
    faces[ 1] = new int[] { 24, 10, 38,  5 };
    faces[ 2] = new int[] { 24,  5, 16,  4 };
    faces[ 3] = new int[] { 24,  4, 36,  8 };
    faces[ 4] = new int[] { 24,  8, 12,  2 };
    faces[ 5] = new int[] { 25,  3, 13,  9 };
    faces[ 6] = new int[] { 25,  9, 37,  4 };
    faces[ 7] = new int[] { 25,  4, 17,  5 };
    faces[ 8] = new int[] { 25,  5, 39, 11 };
    faces[ 9] = new int[] { 25, 11, 15,  3 };
    faces[10] = new int[] { 26,  0, 12,  8 };
    faces[11] = new int[] { 26,  8, 40,  6 };
    faces[12] = new int[] { 26,  6, 18,  7 };
    faces[13] = new int[] { 26,  7, 42, 10 };
    faces[14] = new int[] { 26, 10, 14,  0 };
    faces[15] = new int[] { 27,  1, 15, 11 };
    faces[16] = new int[] { 27, 11, 43,  7 };
    faces[17] = new int[] { 27,  7, 19,  6 };
    faces[18] = new int[] { 27,  6, 41,  9 };
    faces[19] = new int[] { 27,  9, 13,  1 };
    faces[20] = new int[] { 28,  0, 16,  5 };
    faces[21] = new int[] { 28,  5, 17,  1 };
    faces[22] = new int[] { 28,  1, 37,  9 };
    faces[23] = new int[] { 28,  9, 20,  8 };
    faces[24] = new int[] { 28,  8, 36,  0 };
    faces[25] = new int[] { 29,  0, 38, 10 };
    faces[26] = new int[] { 29, 10, 21, 11 };
    faces[27] = new int[] { 29, 11, 39,  1 };
    faces[28] = new int[] { 29,  1, 17,  4 };
    faces[29] = new int[] { 29,  4, 16,  0 };
    faces[30] = new int[] { 30,  2, 40,  8 };
    faces[31] = new int[] { 30,  8, 22,  9 };
    faces[32] = new int[] { 30,  9, 41,  3 };
    faces[33] = new int[] { 30,  3, 19,  7 };
    faces[34] = new int[] { 30,  7, 18,  2 };
    faces[35] = new int[] { 31,  2, 18,  6 };
    faces[36] = new int[] { 31,  6, 19,  3 };
    faces[37] = new int[] { 31,  3, 43, 11 };
    faces[38] = new int[] { 31, 11, 23, 10 };
    faces[39] = new int[] { 31, 10, 42,  2 };
    faces[40] = new int[] { 32,  0, 36,  4 };
    faces[41] = new int[] { 32,  4, 20,  9 };
    faces[42] = new int[] { 32,  9, 22,  6 };
    faces[43] = new int[] { 32,  6, 40,  2 };
    faces[44] = new int[] { 32,  2, 12,  0 };
    faces[45] = new int[] { 33,  1, 13,  3 };
    faces[46] = new int[] { 33,  3, 41,  6 };
    faces[47] = new int[] { 33,  6, 22,  8 };
    faces[48] = new int[] { 33,  8, 20,  4 };
    faces[49] = new int[] { 33,  4, 37,  1 };
    faces[50] = new int[] { 34,  0, 14,  2 };
    faces[51] = new int[] { 34,  2, 42,  7 };
    faces[52] = new int[] { 34,  7, 23, 11 };
    faces[53] = new int[] { 34, 11, 21,  5 };
    faces[54] = new int[] { 34,  5, 38,  0 };
    faces[55] = new int[] { 35,  1, 39,  5 };
    faces[56] = new int[] { 35,  5, 21, 10 };
    faces[57] = new int[] { 35, 10, 23,  7 };
    faces[58] = new int[] { 35,  7, 43,  3 };
    faces[59] = new int[] { 35,  3, 15,  1 };
  } //end SmallDodecacronicHexecontahedron()

  public String name() {
    return "Small Dodecacronic Hexecontahedron";
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
   
} //end class SmallDodecacronicHexecontahedron
