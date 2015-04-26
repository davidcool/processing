/*
Rhombicosacron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Rhombicosacron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.414589803375031545538623949690;  //3 * (5 - sqrt(5)) / 20
  final float C1 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C2 = 0.670820393249936908922752100619;  //3 * sqrt(5) / 10
  final float C3 = 1.08541019662496845446137605031;   //3 * (5 + sqrt(5)) / 20
  final float C4 = 1.34164078649987381784550420124;   //3 * sqrt(5) / 5
  final float C5 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[50]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Rhombicosacron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,   C1,   C5 );
    vert[  1] = new PVector(  0.0,   C1,  -C5 );
    vert[  2] = new PVector(  0.0,  -C1,   C5 );
    vert[  3] = new PVector(  0.0,  -C1,  -C5 );
    vert[  4] = new PVector(   C5,  0.0,   C1 );
    vert[  5] = new PVector(   C5,  0.0,  -C1 );
    vert[  6] = new PVector(  -C5,  0.0,   C1 );
    vert[  7] = new PVector(  -C5,  0.0,  -C1 );
    vert[  8] = new PVector(   C1,   C5,  0.0 );
    vert[  9] = new PVector(   C1,  -C5,  0.0 );
    vert[ 10] = new PVector(  -C1,   C5,  0.0 );
    vert[ 11] = new PVector(  -C1,  -C5,  0.0 );
    vert[ 12] = new PVector(  0.0,  0.0,   C4 );
    vert[ 13] = new PVector(  0.0,  0.0,  -C4 );
    vert[ 14] = new PVector(   C4,  0.0,  0.0 );
    vert[ 15] = new PVector(  -C4,  0.0,  0.0 );
    vert[ 16] = new PVector(  0.0,   C4,  0.0 );
    vert[ 17] = new PVector(  0.0,  -C4,  0.0 );
    vert[ 18] = new PVector(   C0,   C2,   C3 );
    vert[ 19] = new PVector(   C0,   C2,  -C3 );
    vert[ 20] = new PVector(   C0,  -C2,   C3 );
    vert[ 21] = new PVector(   C0,  -C2,  -C3 );
    vert[ 22] = new PVector(  -C0,   C2,   C3 );
    vert[ 23] = new PVector(  -C0,   C2,  -C3 );
    vert[ 24] = new PVector(  -C0,  -C2,   C3 );
    vert[ 25] = new PVector(  -C0,  -C2,  -C3 );
    vert[ 26] = new PVector(   C3,   C0,   C2 );
    vert[ 27] = new PVector(   C3,   C0,  -C2 );
    vert[ 28] = new PVector(   C3,  -C0,   C2 );
    vert[ 29] = new PVector(   C3,  -C0,  -C2 );
    vert[ 30] = new PVector(  -C3,   C0,   C2 );
    vert[ 31] = new PVector(  -C3,   C0,  -C2 );
    vert[ 32] = new PVector(  -C3,  -C0,   C2 );
    vert[ 33] = new PVector(  -C3,  -C0,  -C2 );
    vert[ 34] = new PVector(   C2,   C3,   C0 );
    vert[ 35] = new PVector(   C2,   C3,  -C0 );
    vert[ 36] = new PVector(   C2,  -C3,   C0 );
    vert[ 37] = new PVector(   C2,  -C3,  -C0 );
    vert[ 38] = new PVector(  -C2,   C3,   C0 );
    vert[ 39] = new PVector(  -C2,   C3,  -C0 );
    vert[ 40] = new PVector(  -C2,  -C3,   C0 );
    vert[ 41] = new PVector(  -C2,  -C3,  -C0 );
    vert[ 42] = new PVector(  1.0,  1.0,  1.0 );
    vert[ 43] = new PVector(  1.0,  1.0, -1.0 );
    vert[ 44] = new PVector(  1.0, -1.0,  1.0 );
    vert[ 45] = new PVector(  1.0, -1.0, -1.0 );
    vert[ 46] = new PVector( -1.0,  1.0,  1.0 );
    vert[ 47] = new PVector( -1.0,  1.0, -1.0 );
    vert[ 48] = new PVector( -1.0, -1.0,  1.0 );
    vert[ 49] = new PVector( -1.0, -1.0, -1.0 );
    // set faces
    faces[ 0] = new int[] {  0, 16,  8, 22 };
    faces[ 1] = new int[] {  0, 28, 44, 18 };
    faces[ 2] = new int[] {  0, 32,  6, 12 };
    faces[ 3] = new int[] {  1, 16, 10, 19 };
    faces[ 4] = new int[] {  1, 33, 49, 23 };
    faces[ 5] = new int[] {  1, 29,  5, 13 };
    faces[ 6] = new int[] {  2, 17, 11, 20 };
    faces[ 7] = new int[] {  2, 30, 46, 24 };
    faces[ 8] = new int[] {  2, 26,  4, 12 };
    faces[ 9] = new int[] {  3, 17,  9, 25 };
    faces[10] = new int[] {  3, 27, 43, 21 };
    faces[11] = new int[] {  3, 31,  7, 13 };
    faces[12] = new int[] {  4, 12,  0, 28 };
    faces[13] = new int[] {  4, 35, 43, 26 };
    faces[14] = new int[] {  4, 37,  9, 14 };
    faces[15] = new int[] {  5, 13,  3, 27 };
    faces[16] = new int[] {  5, 36, 44, 29 };
    faces[17] = new int[] {  5, 34,  8, 14 };
    faces[18] = new int[] {  6, 12,  2, 30 };
    faces[19] = new int[] {  6, 41, 49, 32 };
    faces[20] = new int[] {  6, 39, 10, 15 };
    faces[21] = new int[] {  7, 13,  1, 33 };
    faces[22] = new int[] {  7, 38, 46, 31 };
    faces[23] = new int[] {  7, 40, 11, 15 };
    faces[24] = new int[] {  8, 14,  4, 35 };
    faces[25] = new int[] {  8, 22, 46, 34 };
    faces[26] = new int[] {  8, 23,  1, 16 };
    faces[27] = new int[] {  9, 14,  5, 36 };
    faces[28] = new int[] {  9, 25, 49, 37 };
    faces[29] = new int[] {  9, 24,  2, 17 };
    faces[30] = new int[] { 10, 15,  7, 38 };
    faces[31] = new int[] { 10, 19, 43, 39 };
    faces[32] = new int[] { 10, 18,  0, 16 };
    faces[33] = new int[] { 11, 15,  6, 41 };
    faces[34] = new int[] { 11, 20, 44, 40 };
    faces[35] = new int[] { 11, 21,  3, 17 };
    faces[36] = new int[] { 42, 20,  2, 26 };
    faces[37] = new int[] { 42, 38, 10, 18 };
    faces[38] = new int[] { 42, 27,  5, 34 };
    faces[39] = new int[] { 43, 21, 45, 19 };
    faces[40] = new int[] { 43, 26, 42, 27 };
    faces[41] = new int[] { 43, 39, 47, 35 };
    faces[42] = new int[] { 44, 18, 42, 20 };
    faces[43] = new int[] { 44, 29, 45, 28 };
    faces[44] = new int[] { 44, 40, 48, 36 };
    faces[45] = new int[] { 45, 19,  1, 29 };
    faces[46] = new int[] { 45, 41, 11, 21 };
    faces[47] = new int[] { 45, 28,  4, 37 };
    faces[48] = new int[] { 46, 24, 48, 22 };
    faces[49] = new int[] { 46, 31, 47, 30 };
    faces[50] = new int[] { 46, 34, 42, 38 };
    faces[51] = new int[] { 47, 25,  3, 31 };
    faces[52] = new int[] { 47, 35,  8, 23 };
    faces[53] = new int[] { 47, 30,  6, 39 };
    faces[54] = new int[] { 48, 22,  0, 32 };
    faces[55] = new int[] { 48, 36,  9, 24 };
    faces[56] = new int[] { 48, 33,  7, 40 };
    faces[57] = new int[] { 49, 23, 47, 25 };
    faces[58] = new int[] { 49, 32, 48, 33 };
    faces[59] = new int[] { 49, 37, 45, 41 };
  } //end Rhombicosacron()

  public String name() {
    return "Rhombicosacron";
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
   
} //end class Rhombicosacron
