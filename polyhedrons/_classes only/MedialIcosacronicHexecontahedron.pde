/*
MedialIcosacronicHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialIcosacronicHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C1 = 0.649627093977301405035112681537;  //3 * (7 - sqrt(5)) / 22
  final float C2 = 0.778391445340823057621934682663;  //3 * (3 * sqrt(5) - 1) / 22
  final float C3 = 1.05111871806809578489466195539;   //3 * (1 + 3 * sqrt(5)) / 22
  final float C4 = 1.259463815113607685873978227554;  //3 * (7 + sqrt(5)) / 22
  final float C5 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[44]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialIcosacronicHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,   C0,   C5 );
    vert[  1] = new PVector(  0.0,   C0,  -C5 );
    vert[  2] = new PVector(  0.0,  -C0,   C5 );
    vert[  3] = new PVector(  0.0,  -C0,  -C5 );
    vert[  4] = new PVector(   C5,  0.0,   C0 );
    vert[  5] = new PVector(   C5,  0.0,  -C0 );
    vert[  6] = new PVector(  -C5,  0.0,   C0 );
    vert[  7] = new PVector(  -C5,  0.0,  -C0 );
    vert[  8] = new PVector(   C0,   C5,  0.0 );
    vert[  9] = new PVector(   C0,  -C5,  0.0 );
    vert[ 10] = new PVector(  -C0,   C5,  0.0 );
    vert[ 11] = new PVector(  -C0,  -C5,  0.0 );
    vert[ 12] = new PVector(   C2,  0.0,   C4 );
    vert[ 13] = new PVector(   C2,  0.0,  -C4 );
    vert[ 14] = new PVector(  -C2,  0.0,   C4 );
    vert[ 15] = new PVector(  -C2,  0.0,  -C4 );
    vert[ 16] = new PVector(   C4,   C2,  0.0 );
    vert[ 17] = new PVector(   C4,  -C2,  0.0 );
    vert[ 18] = new PVector(  -C4,   C2,  0.0 );
    vert[ 19] = new PVector(  -C4,  -C2,  0.0 );
    vert[ 20] = new PVector(  0.0,   C4,   C2 );
    vert[ 21] = new PVector(  0.0,   C4,  -C2 );
    vert[ 22] = new PVector(  0.0,  -C4,   C2 );
    vert[ 23] = new PVector(  0.0,  -C4,  -C2 );
    vert[ 24] = new PVector(   C1,  0.0,   C3 );
    vert[ 25] = new PVector(   C1,  0.0,  -C3 );
    vert[ 26] = new PVector(  -C1,  0.0,   C3 );
    vert[ 27] = new PVector(  -C1,  0.0,  -C3 );
    vert[ 28] = new PVector(   C3,   C1,  0.0 );
    vert[ 29] = new PVector(   C3,  -C1,  0.0 );
    vert[ 30] = new PVector(  -C3,   C1,  0.0 );
    vert[ 31] = new PVector(  -C3,  -C1,  0.0 );
    vert[ 32] = new PVector(  0.0,   C3,   C1 );
    vert[ 33] = new PVector(  0.0,   C3,  -C1 );
    vert[ 34] = new PVector(  0.0,  -C3,   C1 );
    vert[ 35] = new PVector(  0.0,  -C3,  -C1 );
    vert[ 36] = new PVector(  1.0,  1.0,  1.0 );
    vert[ 37] = new PVector(  1.0,  1.0, -1.0 );
    vert[ 38] = new PVector(  1.0, -1.0,  1.0 );
    vert[ 39] = new PVector(  1.0, -1.0, -1.0 );
    vert[ 40] = new PVector( -1.0,  1.0,  1.0 );
    vert[ 41] = new PVector( -1.0,  1.0, -1.0 );
    vert[ 42] = new PVector( -1.0, -1.0,  1.0 );
    vert[ 43] = new PVector( -1.0, -1.0, -1.0 );
    // set faces
    faces[ 0] = new int[] { 12,  5, 28,  8 };
    faces[ 1] = new int[] { 12,  8, 32, 40 };
    faces[ 2] = new int[] { 12, 40, 26, 42 };
    faces[ 3] = new int[] { 12, 42, 34,  9 };
    faces[ 4] = new int[] { 12,  9, 29,  5 };
    faces[ 5] = new int[] { 13,  4, 29,  9 };
    faces[ 6] = new int[] { 13,  9, 35, 43 };
    faces[ 7] = new int[] { 13, 43, 27, 41 };
    faces[ 8] = new int[] { 13, 41, 33,  8 };
    faces[ 9] = new int[] { 13,  8, 28,  4 };
    faces[10] = new int[] { 14,  7, 31, 11 };
    faces[11] = new int[] { 14, 11, 34, 38 };
    faces[12] = new int[] { 14, 38, 24, 36 };
    faces[13] = new int[] { 14, 36, 32, 10 };
    faces[14] = new int[] { 14, 10, 30,  7 };
    faces[15] = new int[] { 15,  6, 30, 10 };
    faces[16] = new int[] { 15, 10, 33, 37 };
    faces[17] = new int[] { 15, 37, 25, 39 };
    faces[18] = new int[] { 15, 39, 35, 11 };
    faces[19] = new int[] { 15, 11, 31,  6 };
    faces[20] = new int[] { 16,  1, 33, 10 };
    faces[21] = new int[] { 16, 10, 32,  0 };
    faces[22] = new int[] { 16,  0, 24, 38 };
    faces[23] = new int[] { 16, 38, 29, 39 };
    faces[24] = new int[] { 16, 39, 25,  1 };
    faces[25] = new int[] { 17,  2, 34, 11 };
    faces[26] = new int[] { 17, 11, 35,  3 };
    faces[27] = new int[] { 17,  3, 25, 37 };
    faces[28] = new int[] { 17, 37, 28, 36 };
    faces[29] = new int[] { 17, 36, 24,  2 };
    faces[30] = new int[] { 18,  0, 32,  8 };
    faces[31] = new int[] { 18,  8, 33,  1 };
    faces[32] = new int[] { 18,  1, 27, 43 };
    faces[33] = new int[] { 18, 43, 31, 42 };
    faces[34] = new int[] { 18, 42, 26,  0 };
    faces[35] = new int[] { 19,  2, 26, 40 };
    faces[36] = new int[] { 19, 40, 30, 41 };
    faces[37] = new int[] { 19, 41, 27,  3 };
    faces[38] = new int[] { 19,  3, 35,  9 };
    faces[39] = new int[] { 19,  9, 34,  2 };
    faces[40] = new int[] { 20,  2, 24,  4 };
    faces[41] = new int[] { 20,  4, 28, 37 };
    faces[42] = new int[] { 20, 37, 33, 41 };
    faces[43] = new int[] { 20, 41, 30,  6 };
    faces[44] = new int[] { 20,  6, 26,  2 };
    faces[45] = new int[] { 21,  3, 27,  7 };
    faces[46] = new int[] { 21,  7, 30, 40 };
    faces[47] = new int[] { 21, 40, 32, 36 };
    faces[48] = new int[] { 21, 36, 28,  5 };
    faces[49] = new int[] { 21,  5, 25,  3 };
    faces[50] = new int[] { 22,  0, 26,  6 };
    faces[51] = new int[] { 22,  6, 31, 43 };
    faces[52] = new int[] { 22, 43, 35, 39 };
    faces[53] = new int[] { 22, 39, 29,  4 };
    faces[54] = new int[] { 22,  4, 24,  0 };
    faces[55] = new int[] { 23,  1, 25,  5 };
    faces[56] = new int[] { 23,  5, 29, 38 };
    faces[57] = new int[] { 23, 38, 34, 42 };
    faces[58] = new int[] { 23, 42, 31,  7 };
    faces[59] = new int[] { 23,  7, 27,  1 };
  } //end MedialIcosacronicHexecontahedron()

  public String name() {
    return "Medial Icosacronic Hexecontahedron";
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
   
} //end class MedialIcosacronicHexecontahedron
