/*
GreatIcosacronicHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosacronicHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.378818990230171841861878040370;   //3 * (11 * sqrt(5) - 15) / 76
  final float C1 = 0.6129420017763323923887494472054;  //3 * (10 - sqrt(5)) / 38
  final float C2 = 0.690983005625052575897706582817;   //(5 - sqrt(5)) / 4
  final float C3 = 0.726305171079445082377105614622;   //3 * (7 * sqrt(5) - 5) / 44
  final float C4 = 0.991760992006504234250627487576;   //3 * (5 + 9 * sqrt(5)) / 76
  final float C5 = 1.11803398874989484820458683437;    //sqrt(5) / 2
  final float C6 = 1.17518645301134929748244365923;    //3 * (15 + sqrt(5)) / 44
  final float C7 = 1.80901699437494742410229341718;    //(5 + sqrt(5)) / 4
  private PVector[] vert = new PVector[52]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosacronicHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0,  C2,  C7 );
    vert[  1] = new PVector( 0.0,  C2, -C7 );
    vert[  2] = new PVector( 0.0, -C2,  C7 );
    vert[  3] = new PVector( 0.0, -C2, -C7 );
    vert[  4] = new PVector(  C7, 0.0,  C2 );
    vert[  5] = new PVector(  C7, 0.0, -C2 );
    vert[  6] = new PVector( -C7, 0.0,  C2 );
    vert[  7] = new PVector( -C7, 0.0, -C2 );
    vert[  8] = new PVector(  C2,  C7, 0.0 );
    vert[  9] = new PVector(  C2, -C7, 0.0 );
    vert[ 10] = new PVector( -C2,  C7, 0.0 );
    vert[ 11] = new PVector( -C2, -C7, 0.0 );
    vert[ 12] = new PVector(  C3, 0.0,  C6 );
    vert[ 13] = new PVector(  C3, 0.0, -C6 );
    vert[ 14] = new PVector( -C3, 0.0,  C6 );
    vert[ 15] = new PVector( -C3, 0.0, -C6 );
    vert[ 16] = new PVector(  C6,  C3, 0.0 );
    vert[ 17] = new PVector(  C6, -C3, 0.0 );
    vert[ 18] = new PVector( -C6,  C3, 0.0 );
    vert[ 19] = new PVector( -C6, -C3, 0.0 );
    vert[ 20] = new PVector( 0.0,  C6,  C3 );
    vert[ 21] = new PVector( 0.0,  C6, -C3 );
    vert[ 22] = new PVector( 0.0, -C6,  C3 );
    vert[ 23] = new PVector( 0.0, -C6, -C3 );
    vert[ 24] = new PVector(  C5,  C5,  C5 );
    vert[ 25] = new PVector(  C5,  C5, -C5 );
    vert[ 26] = new PVector(  C5, -C5,  C5 );
    vert[ 27] = new PVector(  C5, -C5, -C5 );
    vert[ 28] = new PVector( -C5,  C5,  C5 );
    vert[ 29] = new PVector( -C5,  C5, -C5 );
    vert[ 30] = new PVector( -C5, -C5,  C5 );
    vert[ 31] = new PVector( -C5, -C5, -C5 );
    vert[ 32] = new PVector( 0.0,  C0,  C4 );
    vert[ 33] = new PVector( 0.0,  C0, -C4 );
    vert[ 34] = new PVector( 0.0, -C0,  C4 );
    vert[ 35] = new PVector( 0.0, -C0, -C4 );
    vert[ 36] = new PVector(  C4, 0.0,  C0 );
    vert[ 37] = new PVector(  C4, 0.0, -C0 );
    vert[ 38] = new PVector( -C4, 0.0,  C0 );
    vert[ 39] = new PVector( -C4, 0.0, -C0 );
    vert[ 40] = new PVector(  C0,  C4, 0.0 );
    vert[ 41] = new PVector(  C0, -C4, 0.0 );
    vert[ 42] = new PVector( -C0,  C4, 0.0 );
    vert[ 43] = new PVector( -C0, -C4, 0.0 );
    vert[ 44] = new PVector(  C1,  C1,  C1 );
    vert[ 45] = new PVector(  C1,  C1, -C1 );
    vert[ 46] = new PVector(  C1, -C1,  C1 );
    vert[ 47] = new PVector(  C1, -C1, -C1 );
    vert[ 48] = new PVector( -C1,  C1,  C1 );
    vert[ 49] = new PVector( -C1,  C1, -C1 );
    vert[ 50] = new PVector( -C1, -C1,  C1 );
    vert[ 51] = new PVector( -C1, -C1, -C1 );
    // set faces
    faces[ 0] = new int[] { 12,  6, 50, 11 };
    faces[ 1] = new int[] { 12, 11, 41, 27 };
    faces[ 2] = new int[] { 12, 27, 37, 25 };
    faces[ 3] = new int[] { 12, 25, 40, 10 };
    faces[ 4] = new int[] { 12, 10, 48,  6 };
    faces[ 5] = new int[] { 13,  7, 49, 10 };
    faces[ 6] = new int[] { 13, 10, 40, 24 };
    faces[ 7] = new int[] { 13, 24, 36, 26 };
    faces[ 8] = new int[] { 13, 26, 41, 11 };
    faces[ 9] = new int[] { 13, 11, 51,  7 };
    faces[10] = new int[] { 14,  4, 44,  8 };
    faces[11] = new int[] { 14,  8, 42, 29 };
    faces[12] = new int[] { 14, 29, 39, 31 };
    faces[13] = new int[] { 14, 31, 43,  9 };
    faces[14] = new int[] { 14,  9, 46,  4 };
    faces[15] = new int[] { 15,  5, 47,  9 };
    faces[16] = new int[] { 15,  9, 43, 30 };
    faces[17] = new int[] { 15, 30, 38, 28 };
    faces[18] = new int[] { 15, 28, 42,  8 };
    faces[19] = new int[] { 15,  8, 45,  5 };
    faces[20] = new int[] { 16,  2, 46,  9 };
    faces[21] = new int[] { 16,  9, 47,  3 };
    faces[22] = new int[] { 16,  3, 33, 29 };
    faces[23] = new int[] { 16, 29, 42, 28 };
    faces[24] = new int[] { 16, 28, 32,  2 };
    faces[25] = new int[] { 17,  0, 34, 30 };
    faces[26] = new int[] { 17, 30, 43, 31 };
    faces[27] = new int[] { 17, 31, 35,  1 };
    faces[28] = new int[] { 17,  1, 45,  8 };
    faces[29] = new int[] { 17,  8, 44,  0 };
    faces[30] = new int[] { 18,  2, 32, 24 };
    faces[31] = new int[] { 18, 24, 40, 25 };
    faces[32] = new int[] { 18, 25, 33,  3 };
    faces[33] = new int[] { 18,  3, 51, 11 };
    faces[34] = new int[] { 18, 11, 50,  2 };
    faces[35] = new int[] { 19,  0, 48, 10 };
    faces[36] = new int[] { 19, 10, 49,  1 };
    faces[37] = new int[] { 19,  1, 35, 27 };
    faces[38] = new int[] { 19, 27, 41, 26 };
    faces[39] = new int[] { 19, 26, 34,  0 };
    faces[40] = new int[] { 20,  1, 49,  7 };
    faces[41] = new int[] { 20,  7, 38, 30 };
    faces[42] = new int[] { 20, 30, 34, 26 };
    faces[43] = new int[] { 20, 26, 36,  5 };
    faces[44] = new int[] { 20,  5, 45,  1 };
    faces[45] = new int[] { 21,  0, 44,  4 };
    faces[46] = new int[] { 21,  4, 37, 27 };
    faces[47] = new int[] { 21, 27, 35, 31 };
    faces[48] = new int[] { 21, 31, 39,  6 };
    faces[49] = new int[] { 21,  6, 48,  0 };
    faces[50] = new int[] { 22,  3, 47,  5 };
    faces[51] = new int[] { 22,  5, 36, 24 };
    faces[52] = new int[] { 22, 24, 32, 28 };
    faces[53] = new int[] { 22, 28, 38,  7 };
    faces[54] = new int[] { 22,  7, 51,  3 };
    faces[55] = new int[] { 23,  2, 50,  6 };
    faces[56] = new int[] { 23,  6, 39, 29 };
    faces[57] = new int[] { 23, 29, 33, 25 };
    faces[58] = new int[] { 23, 25, 37,  4 };
    faces[59] = new int[] { 23,  4, 46,  2 };
  } //end GreatIcosacronicHexecontahedron()

  public String name() {
    return "Great Icosacronic Hexecontahedron";
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
   
} //end class GreatIcosacronicHexecontahedron
