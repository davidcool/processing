/*
GreatDodecicosacron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDodecicosacron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.572949016875157727693119748452;  //3 * (3 - sqrt(5)) / 4
  final float C1 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  final float C2 = 0.927050983124842272306880251548;  //3 * (sqrt(5) - 1) / 4
  final float C3 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  final float C4 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  private PVector[] vert = new PVector[32]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDodecicosacron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, -C2,  C0 );
    vert[  1] = new PVector( 0.0, -C2, -C0 );
    vert[  2] = new PVector( 0.0,  C2,  C0 );
    vert[  3] = new PVector( 0.0,  C2, -C0 );
    vert[  4] = new PVector( -C2,  C0, 0.0 );
    vert[  5] = new PVector(  C2,  C0, 0.0 );
    vert[  6] = new PVector( -C2, -C0, 0.0 );
    vert[  7] = new PVector(  C2, -C0, 0.0 );
    vert[  8] = new PVector(  C0, 0.0, -C2 );
    vert[  9] = new PVector(  C0, 0.0,  C2 );
    vert[ 10] = new PVector( -C0, 0.0, -C2 );
    vert[ 11] = new PVector( -C0, 0.0,  C2 );
    vert[ 12] = new PVector(  C4, 0.0,  C1 );
    vert[ 13] = new PVector(  C4, 0.0, -C1 );
    vert[ 14] = new PVector( -C4, 0.0,  C1 );
    vert[ 15] = new PVector( -C4, 0.0, -C1 );
    vert[ 16] = new PVector( 0.0,  C1,  C4 );
    vert[ 17] = new PVector( 0.0,  C1, -C4 );
    vert[ 18] = new PVector( 0.0, -C1,  C4 );
    vert[ 19] = new PVector( 0.0, -C1, -C4 );
    vert[ 20] = new PVector(  C1,  C4, 0.0 );
    vert[ 21] = new PVector( -C1,  C4, 0.0 );
    vert[ 22] = new PVector(  C1, -C4, 0.0 );
    vert[ 23] = new PVector( -C1, -C4, 0.0 );
    vert[ 24] = new PVector( -C3, -C3, -C3 );
    vert[ 25] = new PVector( -C3, -C3,  C3 );
    vert[ 26] = new PVector(  C3, -C3, -C3 );
    vert[ 27] = new PVector(  C3, -C3,  C3 );
    vert[ 28] = new PVector( -C3,  C3, -C3 );
    vert[ 29] = new PVector( -C3,  C3,  C3 );
    vert[ 30] = new PVector(  C3,  C3, -C3 );
    vert[ 31] = new PVector(  C3,  C3,  C3 );
    // set faces
    faces[ 0] = new int[] {  0, 18,  6, 14 };
    faces[ 1] = new int[] {  0, 22,  9, 12 };
    faces[ 2] = new int[] {  0, 25,  1, 24 };
    faces[ 3] = new int[] {  0, 27, 11, 16 };
    faces[ 4] = new int[] {  0, 23,  7, 26 };
    faces[ 5] = new int[] {  1, 19,  7, 13 };
    faces[ 6] = new int[] {  1, 23, 10, 15 };
    faces[ 7] = new int[] {  1, 26,  0, 27 };
    faces[ 8] = new int[] {  1, 24,  8, 17 };
    faces[ 9] = new int[] {  1, 22,  6, 25 };
    faces[10] = new int[] {  2, 16,  5, 12 };
    faces[11] = new int[] {  2, 21, 11, 14 };
    faces[12] = new int[] {  2, 31,  3, 30 };
    faces[13] = new int[] {  2, 29,  9, 18 };
    faces[14] = new int[] {  2, 20,  4, 28 };
    faces[15] = new int[] {  3, 17,  4, 15 };
    faces[16] = new int[] {  3, 20,  8, 13 };
    faces[17] = new int[] {  3, 28,  2, 29 };
    faces[18] = new int[] {  3, 30, 10, 19 };
    faces[19] = new int[] {  3, 21,  5, 31 };
    faces[20] = new int[] {  4, 14,  2, 16 };
    faces[21] = new int[] {  4, 28,  6, 24 };
    faces[22] = new int[] {  4, 29,  3, 20 };
    faces[23] = new int[] {  4, 15, 11, 25 };
    faces[24] = new int[] {  4, 21, 10, 17 };
    faces[25] = new int[] {  5, 12,  8, 26 };
    faces[26] = new int[] {  5, 20,  9, 16 };
    faces[27] = new int[] {  5, 13,  3, 17 };
    faces[28] = new int[] {  5, 31,  7, 27 };
    faces[29] = new int[] {  5, 30,  2, 21 };
    faces[30] = new int[] {  6, 14, 10, 28 };
    faces[31] = new int[] {  6, 23, 11, 18 };
    faces[32] = new int[] {  6, 15,  1, 19 };
    faces[33] = new int[] {  6, 25,  4, 29 };
    faces[34] = new int[] {  6, 24,  0, 22 };
    faces[35] = new int[] {  7, 12,  0, 18 };
    faces[36] = new int[] {  7, 26,  5, 30 };
    faces[37] = new int[] {  7, 27,  1, 23 };
    faces[38] = new int[] {  7, 13,  9, 31 };
    faces[39] = new int[] {  7, 22,  8, 19 };
    faces[40] = new int[] {  8, 13,  1, 22 };
    faces[41] = new int[] {  8, 17,  5, 20 };
    faces[42] = new int[] {  8, 26, 10, 24 };
    faces[43] = new int[] {  8, 30,  7, 12 };
    faces[44] = new int[] {  8, 19,  3, 28 };
    faces[45] = new int[] {  9, 12,  2, 20 };
    faces[46] = new int[] {  9, 18,  7, 22 };
    faces[47] = new int[] {  9, 31, 11, 29 };
    faces[48] = new int[] {  9, 27,  5, 13 };
    faces[49] = new int[] {  9, 16,  0, 25 };
    faces[50] = new int[] { 10, 15,  3, 21 };
    faces[51] = new int[] { 10, 19,  6, 23 };
    faces[52] = new int[] { 10, 28,  8, 30 };
    faces[53] = new int[] { 10, 24,  4, 14 };
    faces[54] = new int[] { 10, 17,  1, 26 };
    faces[55] = new int[] { 11, 14,  0, 23 };
    faces[56] = new int[] { 11, 16,  4, 21 };
    faces[57] = new int[] { 11, 25,  9, 27 };
    faces[58] = new int[] { 11, 29,  6, 15 };
    faces[59] = new int[] { 11, 18,  2, 31 };
  } //end GreatDodecicosacron()

  public String name() {
    return "Great Dodecicosacron";
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
   
} //end class GreatDodecicosacron
