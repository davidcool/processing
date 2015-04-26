/*
MedialDeltoidalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialDeltoidalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.414589803375031545538623949690;  //3 * (5 - sqrt(5)) / 20
  final float C1 = 0.649627093977301405035112681537;  //3 * (7 - sqrt(5)) / 22
  final float C2 = 0.670820393249936908922752100619;  //3 * sqrt(5) / 10
  final float C3 = 0.778391445340823057621934682663;  //3 * (3 * sqrt(5) - 1) / 22
  final float C4 = 1.05111871806809578489466195539;   //3 * (1 + 3 * sqrt(5)) / 22
  final float C5 = 1.08541019662496845446137605031;   //3 * (5 + sqrt(5)) / 20
  final float C6 = 1.259463815113607685873978227554;  //3 * (7 + sqrt(5)) / 22
  final float C7 = 1.34164078649987381784550420124;   //3 * sqrt(5) / 5
  private PVector[] vert = new PVector[54]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialDeltoidalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, 0.0,  C7 );
    vert[  1] = new PVector( 0.0, 0.0, -C7 );
    vert[  2] = new PVector(  C7, 0.0, 0.0 );
    vert[  3] = new PVector( -C7, 0.0, 0.0 );
    vert[  4] = new PVector( 0.0,  C7, 0.0 );
    vert[  5] = new PVector( 0.0, -C7, 0.0 );
    vert[  6] = new PVector(  C3, 0.0,  C6 );
    vert[  7] = new PVector(  C3, 0.0, -C6 );
    vert[  8] = new PVector( -C3, 0.0,  C6 );
    vert[  9] = new PVector( -C3, 0.0, -C6 );
    vert[ 10] = new PVector(  C6,  C3, 0.0 );
    vert[ 11] = new PVector(  C6, -C3, 0.0 );
    vert[ 12] = new PVector( -C6,  C3, 0.0 );
    vert[ 13] = new PVector( -C6, -C3, 0.0 );
    vert[ 14] = new PVector( 0.0,  C6,  C3 );
    vert[ 15] = new PVector( 0.0,  C6, -C3 );
    vert[ 16] = new PVector( 0.0, -C6,  C3 );
    vert[ 17] = new PVector( 0.0, -C6, -C3 );
    vert[ 18] = new PVector(  C0,  C2,  C5 );
    vert[ 19] = new PVector(  C0,  C2, -C5 );
    vert[ 20] = new PVector(  C0, -C2,  C5 );
    vert[ 21] = new PVector(  C0, -C2, -C5 );
    vert[ 22] = new PVector( -C0,  C2,  C5 );
    vert[ 23] = new PVector( -C0,  C2, -C5 );
    vert[ 24] = new PVector( -C0, -C2,  C5 );
    vert[ 25] = new PVector( -C0, -C2, -C5 );
    vert[ 26] = new PVector(  C5,  C0,  C2 );
    vert[ 27] = new PVector(  C5,  C0, -C2 );
    vert[ 28] = new PVector(  C5, -C0,  C2 );
    vert[ 29] = new PVector(  C5, -C0, -C2 );
    vert[ 30] = new PVector( -C5,  C0,  C2 );
    vert[ 31] = new PVector( -C5,  C0, -C2 );
    vert[ 32] = new PVector( -C5, -C0,  C2 );
    vert[ 33] = new PVector( -C5, -C0, -C2 );
    vert[ 34] = new PVector(  C2,  C5,  C0 );
    vert[ 35] = new PVector(  C2,  C5, -C0 );
    vert[ 36] = new PVector(  C2, -C5,  C0 );
    vert[ 37] = new PVector(  C2, -C5, -C0 );
    vert[ 38] = new PVector( -C2,  C5,  C0 );
    vert[ 39] = new PVector( -C2,  C5, -C0 );
    vert[ 40] = new PVector( -C2, -C5,  C0 );
    vert[ 41] = new PVector( -C2, -C5, -C0 );
    vert[ 42] = new PVector(  C1, 0.0,  C4 );
    vert[ 43] = new PVector(  C1, 0.0, -C4 );
    vert[ 44] = new PVector( -C1, 0.0,  C4 );
    vert[ 45] = new PVector( -C1, 0.0, -C4 );
    vert[ 46] = new PVector(  C4,  C1, 0.0 );
    vert[ 47] = new PVector(  C4, -C1, 0.0 );
    vert[ 48] = new PVector( -C4,  C1, 0.0 );
    vert[ 49] = new PVector( -C4, -C1, 0.0 );
    vert[ 50] = new PVector( 0.0,  C4,  C1 );
    vert[ 51] = new PVector( 0.0,  C4, -C1 );
    vert[ 52] = new PVector( 0.0, -C4,  C1 );
    vert[ 53] = new PVector( 0.0, -C4, -C1 );
    // set faces
    faces[ 0] = new int[] {  6,  2, 46, 34 };
    faces[ 1] = new int[] {  6, 34, 50, 22 };
    faces[ 2] = new int[] {  6, 22, 44, 24 };
    faces[ 3] = new int[] {  6, 24, 52, 36 };
    faces[ 4] = new int[] {  6, 36, 47,  2 };
    faces[ 5] = new int[] {  7,  2, 47, 37 };
    faces[ 6] = new int[] {  7, 37, 53, 25 };
    faces[ 7] = new int[] {  7, 25, 45, 23 };
    faces[ 8] = new int[] {  7, 23, 51, 35 };
    faces[ 9] = new int[] {  7, 35, 46,  2 };
    faces[10] = new int[] {  8,  3, 49, 40 };
    faces[11] = new int[] {  8, 40, 52, 20 };
    faces[12] = new int[] {  8, 20, 42, 18 };
    faces[13] = new int[] {  8, 18, 50, 38 };
    faces[14] = new int[] {  8, 38, 48,  3 };
    faces[15] = new int[] {  9,  3, 48, 39 };
    faces[16] = new int[] {  9, 39, 51, 19 };
    faces[17] = new int[] {  9, 19, 43, 21 };
    faces[18] = new int[] {  9, 21, 53, 41 };
    faces[19] = new int[] {  9, 41, 49,  3 };
    faces[20] = new int[] { 10,  4, 50, 18 };
    faces[21] = new int[] { 10, 18, 42, 28 };
    faces[22] = new int[] { 10, 28, 47, 29 };
    faces[23] = new int[] { 10, 29, 43, 19 };
    faces[24] = new int[] { 10, 19, 51,  4 };
    faces[25] = new int[] { 11,  5, 53, 21 };
    faces[26] = new int[] { 11, 21, 43, 27 };
    faces[27] = new int[] { 11, 27, 46, 26 };
    faces[28] = new int[] { 11, 26, 42, 20 };
    faces[29] = new int[] { 11, 20, 52,  5 };
    faces[30] = new int[] { 12,  4, 51, 23 };
    faces[31] = new int[] { 12, 23, 45, 33 };
    faces[32] = new int[] { 12, 33, 49, 32 };
    faces[33] = new int[] { 12, 32, 44, 22 };
    faces[34] = new int[] { 12, 22, 50,  4 };
    faces[35] = new int[] { 13,  5, 52, 24 };
    faces[36] = new int[] { 13, 24, 44, 30 };
    faces[37] = new int[] { 13, 30, 48, 31 };
    faces[38] = new int[] { 13, 31, 45, 25 };
    faces[39] = new int[] { 13, 25, 53,  5 };
    faces[40] = new int[] { 14,  0, 42, 26 };
    faces[41] = new int[] { 14, 26, 46, 35 };
    faces[42] = new int[] { 14, 35, 51, 39 };
    faces[43] = new int[] { 14, 39, 48, 30 };
    faces[44] = new int[] { 14, 30, 44,  0 };
    faces[45] = new int[] { 15,  1, 45, 31 };
    faces[46] = new int[] { 15, 31, 48, 38 };
    faces[47] = new int[] { 15, 38, 50, 34 };
    faces[48] = new int[] { 15, 34, 46, 27 };
    faces[49] = new int[] { 15, 27, 43,  1 };
    faces[50] = new int[] { 16,  0, 44, 32 };
    faces[51] = new int[] { 16, 32, 49, 41 };
    faces[52] = new int[] { 16, 41, 53, 37 };
    faces[53] = new int[] { 16, 37, 47, 28 };
    faces[54] = new int[] { 16, 28, 42,  0 };
    faces[55] = new int[] { 17,  1, 43, 29 };
    faces[56] = new int[] { 17, 29, 47, 36 };
    faces[57] = new int[] { 17, 36, 52, 40 };
    faces[58] = new int[] { 17, 40, 49, 33 };
    faces[59] = new int[] { 17, 33, 45,  1 };
  } //end MedialDeltoidalHexecontahedron()

  public String name() {
    return "Medial Deltoidal Hexecontahedron";
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
   
} //end class MedialDeltoidalHexecontahedron
