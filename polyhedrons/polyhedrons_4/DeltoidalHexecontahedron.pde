/*
DeltoidalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class DeltoidalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  final float C1 = 0.783457635340899531654962439488;  //(15 + sqrt(5)) / 22
  final float C2 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  final float C3 = 1.20601132958329828273486227812;   //(5 + sqrt(5)) / 6
  final float C4 = 1.26766108272719625323969951590;   //(5 + 4 * sqrt(5)) / 11
  final float C5 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  final float C6 = 1.95136732208322818153792016770;   //(5 + 3 * sqrt(5)) / 6
  final float C7 = 2.05111871806809578489466195539;   //(25 + 9 * sqrt(5)) / 22
  final float C8 = 2.23606797749978969640917366873;   //sqrt(5)
  private PVector[] vert = new PVector[62]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private DeltoidalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, 0.0,  C8 );
    vert[  1] = new PVector( 0.0, 0.0, -C8 );
    vert[  2] = new PVector(  C8, 0.0, 0.0 );
    vert[  3] = new PVector( -C8, 0.0, 0.0 );
    vert[  4] = new PVector( 0.0,  C8, 0.0 );
    vert[  5] = new PVector( 0.0, -C8, 0.0 );
    vert[  6] = new PVector( 0.0,  C1,  C7 );
    vert[  7] = new PVector( 0.0,  C1, -C7 );
    vert[  8] = new PVector( 0.0, -C1,  C7 );
    vert[  9] = new PVector( 0.0, -C1, -C7 );
    vert[ 10] = new PVector(  C7, 0.0,  C1 );
    vert[ 11] = new PVector(  C7, 0.0, -C1 );
    vert[ 12] = new PVector( -C7, 0.0,  C1 );
    vert[ 13] = new PVector( -C7, 0.0, -C1 );
    vert[ 14] = new PVector(  C1,  C7, 0.0 );
    vert[ 15] = new PVector(  C1, -C7, 0.0 );
    vert[ 16] = new PVector( -C1,  C7, 0.0 );
    vert[ 17] = new PVector( -C1, -C7, 0.0 );
    vert[ 18] = new PVector(  C3, 0.0,  C6 );
    vert[ 19] = new PVector(  C3, 0.0, -C6 );
    vert[ 20] = new PVector( -C3, 0.0,  C6 );
    vert[ 21] = new PVector( -C3, 0.0, -C6 );
    vert[ 22] = new PVector(  C6,  C3, 0.0 );
    vert[ 23] = new PVector(  C6, -C3, 0.0 );
    vert[ 24] = new PVector( -C6,  C3, 0.0 );
    vert[ 25] = new PVector( -C6, -C3, 0.0 );
    vert[ 26] = new PVector( 0.0,  C6,  C3 );
    vert[ 27] = new PVector( 0.0,  C6, -C3 );
    vert[ 28] = new PVector( 0.0, -C6,  C3 );
    vert[ 29] = new PVector( 0.0, -C6, -C3 );
    vert[ 30] = new PVector(  C0,  C2,  C5 );
    vert[ 31] = new PVector(  C0,  C2, -C5 );
    vert[ 32] = new PVector(  C0, -C2,  C5 );
    vert[ 33] = new PVector(  C0, -C2, -C5 );
    vert[ 34] = new PVector( -C0,  C2,  C5 );
    vert[ 35] = new PVector( -C0,  C2, -C5 );
    vert[ 36] = new PVector( -C0, -C2,  C5 );
    vert[ 37] = new PVector( -C0, -C2, -C5 );
    vert[ 38] = new PVector(  C5,  C0,  C2 );
    vert[ 39] = new PVector(  C5,  C0, -C2 );
    vert[ 40] = new PVector(  C5, -C0,  C2 );
    vert[ 41] = new PVector(  C5, -C0, -C2 );
    vert[ 42] = new PVector( -C5,  C0,  C2 );
    vert[ 43] = new PVector( -C5,  C0, -C2 );
    vert[ 44] = new PVector( -C5, -C0,  C2 );
    vert[ 45] = new PVector( -C5, -C0, -C2 );
    vert[ 46] = new PVector(  C2,  C5,  C0 );
    vert[ 47] = new PVector(  C2,  C5, -C0 );
    vert[ 48] = new PVector(  C2, -C5,  C0 );
    vert[ 49] = new PVector(  C2, -C5, -C0 );
    vert[ 50] = new PVector( -C2,  C5,  C0 );
    vert[ 51] = new PVector( -C2,  C5, -C0 );
    vert[ 52] = new PVector( -C2, -C5,  C0 );
    vert[ 53] = new PVector( -C2, -C5, -C0 );
    vert[ 54] = new PVector(  C4,  C4,  C4 );
    vert[ 55] = new PVector(  C4,  C4, -C4 );
    vert[ 56] = new PVector(  C4, -C4,  C4 );
    vert[ 57] = new PVector(  C4, -C4, -C4 );
    vert[ 58] = new PVector( -C4,  C4,  C4 );
    vert[ 59] = new PVector( -C4,  C4, -C4 );
    vert[ 60] = new PVector( -C4, -C4,  C4 );
    vert[ 61] = new PVector( -C4, -C4, -C4 );
    // set faces
    faces[  0] = new int[] { 18,  0,  8, 32 };
    faces[  1] = new int[] { 18, 32, 56, 40 };
    faces[  2] = new int[] { 18, 40, 10, 38 };
    faces[  3] = new int[] { 18, 38, 54, 30 };
    faces[  4] = new int[] { 18, 30,  6,  0 };
    faces[  5] = new int[] { 19,  1,  7, 31 };
    faces[  6] = new int[] { 19, 31, 55, 39 };
    faces[  7] = new int[] { 19, 39, 11, 41 };
    faces[  8] = new int[] { 19, 41, 57, 33 };
    faces[  9] = new int[] { 19, 33,  9,  1 };
    faces[ 10] = new int[] { 20,  0,  6, 34 };
    faces[ 11] = new int[] { 20, 34, 58, 42 };
    faces[ 12] = new int[] { 20, 42, 12, 44 };
    faces[ 13] = new int[] { 20, 44, 60, 36 };
    faces[ 14] = new int[] { 20, 36,  8,  0 };
    faces[ 15] = new int[] { 21,  1,  9, 37 };
    faces[ 16] = new int[] { 21, 37, 61, 45 };
    faces[ 17] = new int[] { 21, 45, 13, 43 };
    faces[ 18] = new int[] { 21, 43, 59, 35 };
    faces[ 19] = new int[] { 21, 35,  7,  1 };
    faces[ 20] = new int[] { 22,  2, 11, 39 };
    faces[ 21] = new int[] { 22, 39, 55, 47 };
    faces[ 22] = new int[] { 22, 47, 14, 46 };
    faces[ 23] = new int[] { 22, 46, 54, 38 };
    faces[ 24] = new int[] { 22, 38, 10,  2 };
    faces[ 25] = new int[] { 23,  2, 10, 40 };
    faces[ 26] = new int[] { 23, 40, 56, 48 };
    faces[ 27] = new int[] { 23, 48, 15, 49 };
    faces[ 28] = new int[] { 23, 49, 57, 41 };
    faces[ 29] = new int[] { 23, 41, 11,  2 };
    faces[ 30] = new int[] { 24,  3, 12, 42 };
    faces[ 31] = new int[] { 24, 42, 58, 50 };
    faces[ 32] = new int[] { 24, 50, 16, 51 };
    faces[ 33] = new int[] { 24, 51, 59, 43 };
    faces[ 34] = new int[] { 24, 43, 13,  3 };
    faces[ 35] = new int[] { 25,  3, 13, 45 };
    faces[ 36] = new int[] { 25, 45, 61, 53 };
    faces[ 37] = new int[] { 25, 53, 17, 52 };
    faces[ 38] = new int[] { 25, 52, 60, 44 };
    faces[ 39] = new int[] { 25, 44, 12,  3 };
    faces[ 40] = new int[] { 26,  4, 16, 50 };
    faces[ 41] = new int[] { 26, 50, 58, 34 };
    faces[ 42] = new int[] { 26, 34,  6, 30 };
    faces[ 43] = new int[] { 26, 30, 54, 46 };
    faces[ 44] = new int[] { 26, 46, 14,  4 };
    faces[ 45] = new int[] { 27,  4, 14, 47 };
    faces[ 46] = new int[] { 27, 47, 55, 31 };
    faces[ 47] = new int[] { 27, 31,  7, 35 };
    faces[ 48] = new int[] { 27, 35, 59, 51 };
    faces[ 49] = new int[] { 27, 51, 16,  4 };
    faces[ 50] = new int[] { 28,  5, 15, 48 };
    faces[ 51] = new int[] { 28, 48, 56, 32 };
    faces[ 52] = new int[] { 28, 32,  8, 36 };
    faces[ 53] = new int[] { 28, 36, 60, 52 };
    faces[ 54] = new int[] { 28, 52, 17,  5 };
    faces[ 55] = new int[] { 29,  5, 17, 53 };
    faces[ 56] = new int[] { 29, 53, 61, 37 };
    faces[ 57] = new int[] { 29, 37,  9, 33 };
    faces[ 58] = new int[] { 29, 33, 57, 49 };
    faces[ 59] = new int[] { 29, 49, 15,  5 };
  } //end DeltoidalHexecontahedron()

  public String name() {
    return "Deltoidal Hexecontahedron";
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
   
} //end class DeltoidalHexecontahedron
