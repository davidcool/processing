/*
CubitruncatedCuboctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class CubitruncatedCuboctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 0.2071067811865475244008443621048;  //(sqrt(2) - 1) / 2
  final float C1 = 1.20710678118654752440084436210;    //(1 + sqrt(2)) / 2
  private PVector[] vert = new PVector[48]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private CubitruncatedCuboctahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5,   C0,   C1 );
    vert[  1] = new PVector(  0.5,   C0,  -C1 );
    vert[  2] = new PVector(  0.5,  -C0,   C1 );
    vert[  3] = new PVector(  0.5,  -C0,  -C1 );
    vert[  4] = new PVector( -0.5,   C0,   C1 );
    vert[  5] = new PVector( -0.5,   C0,  -C1 );
    vert[  6] = new PVector( -0.5,  -C0,   C1 );
    vert[  7] = new PVector( -0.5,  -C0,  -C1 );
    vert[  8] = new PVector(   C1,  0.5,   C0 );
    vert[  9] = new PVector(   C1,  0.5,  -C0 );
    vert[ 10] = new PVector(   C1, -0.5,   C0 );
    vert[ 11] = new PVector(   C1, -0.5,  -C0 );
    vert[ 12] = new PVector(  -C1,  0.5,   C0 );
    vert[ 13] = new PVector(  -C1,  0.5,  -C0 );
    vert[ 14] = new PVector(  -C1, -0.5,   C0 );
    vert[ 15] = new PVector(  -C1, -0.5,  -C0 );
    vert[ 16] = new PVector(   C0,   C1,  0.5 );
    vert[ 17] = new PVector(   C0,   C1, -0.5 );
    vert[ 18] = new PVector(   C0,  -C1,  0.5 );
    vert[ 19] = new PVector(   C0,  -C1, -0.5 );
    vert[ 20] = new PVector(  -C0,   C1,  0.5 );
    vert[ 21] = new PVector(  -C0,   C1, -0.5 );
    vert[ 22] = new PVector(  -C0,  -C1,  0.5 );
    vert[ 23] = new PVector(  -C0,  -C1, -0.5 );
    vert[ 24] = new PVector(   C0,  0.5,   C1 );
    vert[ 25] = new PVector(   C0,  0.5,  -C1 );
    vert[ 26] = new PVector(   C0, -0.5,   C1 );
    vert[ 27] = new PVector(   C0, -0.5,  -C1 );
    vert[ 28] = new PVector(  -C0,  0.5,   C1 );
    vert[ 29] = new PVector(  -C0,  0.5,  -C1 );
    vert[ 30] = new PVector(  -C0, -0.5,   C1 );
    vert[ 31] = new PVector(  -C0, -0.5,  -C1 );
    vert[ 32] = new PVector(   C1,   C0,  0.5 );
    vert[ 33] = new PVector(   C1,   C0, -0.5 );
    vert[ 34] = new PVector(   C1,  -C0,  0.5 );
    vert[ 35] = new PVector(   C1,  -C0, -0.5 );
    vert[ 36] = new PVector(  -C1,   C0,  0.5 );
    vert[ 37] = new PVector(  -C1,   C0, -0.5 );
    vert[ 38] = new PVector(  -C1,  -C0,  0.5 );
    vert[ 39] = new PVector(  -C1,  -C0, -0.5 );
    vert[ 40] = new PVector(  0.5,   C1,   C0 );
    vert[ 41] = new PVector(  0.5,   C1,  -C0 );
    vert[ 42] = new PVector(  0.5,  -C1,   C0 );
    vert[ 43] = new PVector(  0.5,  -C1,  -C0 );
    vert[ 44] = new PVector( -0.5,   C1,   C0 );
    vert[ 45] = new PVector( -0.5,   C1,  -C0 );
    vert[ 46] = new PVector( -0.5,  -C1,   C0 );
    vert[ 47] = new PVector( -0.5,  -C1,  -C0 );
    // set faces
    faces[ 0] = new int[] {  0,  4, 26, 24,  6,  2, 28, 30 };
    faces[ 1] = new int[] {  1, 31, 29,  3,  7, 25, 27,  5 };
    faces[ 2] = new int[] {  8, 10, 33, 32, 11,  9, 34, 35 };
    faces[ 3] = new int[] { 12, 39, 38, 13, 15, 36, 37, 14 };
    faces[ 4] = new int[] { 16, 17, 44, 40, 21, 20, 41, 45 };
    faces[ 5] = new int[] { 18, 47, 43, 22, 23, 42, 46, 19 };
    faces[ 6] = new int[] {  0, 32, 33,  1,  5, 37, 36,  4 };
    faces[ 7] = new int[] {  2,  6, 38, 39,  7,  3, 35, 34 };
    faces[ 8] = new int[] {  8, 40, 44, 12, 14, 46, 42, 10 };
    faces[ 9] = new int[] {  9, 11, 43, 47, 15, 13, 45, 41 };
    faces[10] = new int[] { 16, 24, 26, 18, 19, 27, 25, 17 };
    faces[11] = new int[] { 20, 21, 29, 31, 23, 22, 30, 28 };
    faces[12] = new int[] {  0, 30, 22, 43, 11, 32, 32, 32 };  //added 2x 6th number to fill gap
    faces[13] = new int[] {  1, 33, 10, 42, 23, 31, 31, 31 };  //added 2x 6th number to fill gap
    faces[14] = new int[] {  2, 34,  9, 41, 20, 28, 28, 28 };  //added 2x 6th number to fill gap
    faces[15] = new int[] {  3, 29, 21, 40,  8, 35, 35, 35 };  //added 2x 6th number to fill gap
    faces[16] = new int[] {  4, 36, 15, 47, 18, 26, 26, 26 };  //added 2x 6th number to fill gap
    faces[17] = new int[] {  5, 27, 19, 46, 14, 37, 37, 37 };  //added 2x 6th number to fill gap
    faces[18] = new int[] {  6, 24, 16, 45, 13, 38, 38, 38 };  //added 2x 6th number to fill gap
    faces[19] = new int[] {  7, 39, 12, 44, 17, 25, 25, 25 };  //added 2x 6th number to fill gap
  } //end CubitruncatedCuboctahedron()

  public String name() {
    return "Cubitruncated Cuboctahedron";
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
   
} //end class CubitruncatedCuboctahedron
