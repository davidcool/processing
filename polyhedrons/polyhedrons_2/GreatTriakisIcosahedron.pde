/*
GreatTriakisIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatTriakisIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.206779558238755854312969506403;  //5 * (13 - 5 * sqrt(5)) / 44
  final float C1 = 0.334576353408995316549624394878;  //5 * (2 * sqrt(5) - 3) / 22
  final float C2 = 0.427050983124842272306880251548;  //(3 * sqrt(5) - 5) / 4
  final float C3 = 0.541355911647751170862593901281;  //5 * (7 - sqrt(5)) / 44
  final float C4 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  private PVector[] vert = new PVector[32]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatTriakisIcosahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0,  C4, -C2 );
    vert[  1] = new PVector( 0.0,  C4,  C2 );
    vert[  2] = new PVector( 0.0, -C4, -C2 );
    vert[  3] = new PVector( 0.0, -C4,  C2 );
    vert[  4] = new PVector(  C4, -C2, 0.0 );
    vert[  5] = new PVector( -C4, -C2, 0.0 );
    vert[  6] = new PVector(  C4,  C2, 0.0 );
    vert[  7] = new PVector( -C4,  C2, 0.0 );
    vert[  8] = new PVector( -C2, 0.0,  C4 );
    vert[  9] = new PVector( -C2, 0.0, -C4 );
    vert[ 10] = new PVector(  C2, 0.0,  C4 );
    vert[ 11] = new PVector(  C2, 0.0, -C4 );
    vert[ 12] = new PVector(  C3, 0.0,  C0 );
    vert[ 13] = new PVector(  C3, 0.0, -C0 );
    vert[ 14] = new PVector( -C3, 0.0,  C0 );
    vert[ 15] = new PVector( -C3, 0.0, -C0 );
    vert[ 16] = new PVector( 0.0,  C0,  C3 );
    vert[ 17] = new PVector( 0.0,  C0, -C3 );
    vert[ 18] = new PVector( 0.0, -C0,  C3 );
    vert[ 19] = new PVector( 0.0, -C0, -C3 );
    vert[ 20] = new PVector(  C0,  C3, 0.0 );
    vert[ 21] = new PVector( -C0,  C3, 0.0 );
    vert[ 22] = new PVector(  C0, -C3, 0.0 );
    vert[ 23] = new PVector( -C0, -C3, 0.0 );
    vert[ 24] = new PVector( -C1, -C1, -C1 );
    vert[ 25] = new PVector( -C1, -C1,  C1 );
    vert[ 26] = new PVector(  C1, -C1, -C1 );
    vert[ 27] = new PVector(  C1, -C1,  C1 );
    vert[ 28] = new PVector( -C1,  C1, -C1 );
    vert[ 29] = new PVector( -C1,  C1,  C1 );
    vert[ 30] = new PVector(  C1,  C1, -C1 );
    vert[ 31] = new PVector(  C1,  C1,  C1 );
    // set faces
    faces[ 0] = new int[] { 12,  0,  8 };
    faces[ 1] = new int[] { 12,  8,  2 };
    faces[ 2] = new int[] { 12,  2,  0 };
    faces[ 3] = new int[] { 13,  1,  3 };
    faces[ 4] = new int[] { 13,  3,  9 };
    faces[ 5] = new int[] { 13,  9,  1 };
    faces[ 6] = new int[] { 14,  0,  2 };
    faces[ 7] = new int[] { 14,  2, 10 };
    faces[ 8] = new int[] { 14, 10,  0 };
    faces[ 9] = new int[] { 15,  1, 11 };
    faces[10] = new int[] { 15, 11,  3 };
    faces[11] = new int[] { 15,  3,  1 };
    faces[12] = new int[] { 16,  0,  5 };
    faces[13] = new int[] { 16,  5,  4 };
    faces[14] = new int[] { 16,  4,  0 };
    faces[15] = new int[] { 17,  1,  4 };
    faces[16] = new int[] { 17,  4,  5 };
    faces[17] = new int[] { 17,  5,  1 };
    faces[18] = new int[] { 18,  2,  6 };
    faces[19] = new int[] { 18,  6,  7 };
    faces[20] = new int[] { 18,  7,  2 };
    faces[21] = new int[] { 19,  3,  7 };
    faces[22] = new int[] { 19,  7,  6 };
    faces[23] = new int[] { 19,  6,  3 };
    faces[24] = new int[] { 20,  4,  9 };
    faces[25] = new int[] { 20,  9,  8 };
    faces[26] = new int[] { 20,  8,  4 };
    faces[27] = new int[] { 21,  5, 10 };
    faces[28] = new int[] { 21, 10, 11 };
    faces[29] = new int[] { 21, 11,  5 };
    faces[30] = new int[] { 22,  6,  8 };
    faces[31] = new int[] { 22,  8,  9 };
    faces[32] = new int[] { 22,  9,  6 };
    faces[33] = new int[] { 23,  7, 11 };
    faces[34] = new int[] { 23, 11, 10 };
    faces[35] = new int[] { 23, 10,  7 };
    faces[36] = new int[] { 24,  0,  4 };
    faces[37] = new int[] { 24,  4,  8 };
    faces[38] = new int[] { 24,  8,  0 };
    faces[39] = new int[] { 25,  1,  9 };
    faces[40] = new int[] { 25,  9,  4 };
    faces[41] = new int[] { 25,  4,  1 };
    faces[42] = new int[] { 26,  0, 10 };
    faces[43] = new int[] { 26, 10,  5 };
    faces[44] = new int[] { 26,  5,  0 };
    faces[45] = new int[] { 27,  1,  5 };
    faces[46] = new int[] { 27,  5, 11 };
    faces[47] = new int[] { 27, 11,  1 };
    faces[48] = new int[] { 28,  2,  8 };
    faces[49] = new int[] { 28,  8,  6 };
    faces[50] = new int[] { 28,  6,  2 };
    faces[51] = new int[] { 29,  3,  6 };
    faces[52] = new int[] { 29,  6,  9 };
    faces[53] = new int[] { 29,  9,  3 };
    faces[54] = new int[] { 30,  2,  7 };
    faces[55] = new int[] { 30,  7, 10 };
    faces[56] = new int[] { 30, 10,  2 };
    faces[57] = new int[] { 31,  3, 11 };
    faces[58] = new int[] { 31, 11,  7 };
    faces[59] = new int[] { 31,  7,  3 };
  } //end GreatTriakisIcosahedron()

  public String name() {
    return "Great Triakis Icosahedron";
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
   
} //end class GreatTriakisIcosahedron
