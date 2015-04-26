/*
GreatRhombicTriacontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatRhombicTriacontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 30;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.213525491562421136153440125774;  //(3 * sqrt(5) - 5) / 8
  final float C1 = 0.345491502812526287948853291409;  //(5 - sqrt(5)) / 8
  final float C2 = 0.559016994374947424102293417183;  //sqrt(5) / 4
  private PVector[] vert = new PVector[32]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatRhombicTriacontahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, -C1,  C0 );
    vert[  1] = new PVector( 0.0, -C1, -C0 );
    vert[  2] = new PVector( 0.0,  C1,  C0 );
    vert[  3] = new PVector( 0.0,  C1, -C0 );
    vert[  4] = new PVector( -C1,  C0, 0.0 );
    vert[  5] = new PVector(  C1,  C0, 0.0 );
    vert[  6] = new PVector( -C1, -C0, 0.0 );
    vert[  7] = new PVector(  C1, -C0, 0.0 );
    vert[  8] = new PVector(  C0, 0.0, -C1 );
    vert[  9] = new PVector(  C0, 0.0,  C1 );
    vert[ 10] = new PVector( -C0, 0.0, -C1 );
    vert[ 11] = new PVector( -C0, 0.0,  C1 );
    vert[ 12] = new PVector(  C2, 0.0,  C0 );
    vert[ 13] = new PVector(  C2, 0.0, -C0 );
    vert[ 14] = new PVector( -C2, 0.0,  C0 );
    vert[ 15] = new PVector( -C2, 0.0, -C0 );
    vert[ 16] = new PVector( 0.0,  C0,  C2 );
    vert[ 17] = new PVector( 0.0,  C0, -C2 );
    vert[ 18] = new PVector( 0.0, -C0,  C2 );
    vert[ 19] = new PVector( 0.0, -C0, -C2 );
    vert[ 20] = new PVector(  C0,  C2, 0.0 );
    vert[ 21] = new PVector( -C0,  C2, 0.0 );
    vert[ 22] = new PVector(  C0, -C2, 0.0 );
    vert[ 23] = new PVector( -C0, -C2, 0.0 );
    vert[ 24] = new PVector( -C1, -C1, -C1 );
    vert[ 25] = new PVector( -C1, -C1,  C1 );
    vert[ 26] = new PVector(  C1, -C1, -C1 );
    vert[ 27] = new PVector(  C1, -C1,  C1 );
    vert[ 28] = new PVector( -C1,  C1, -C1 );
    vert[ 29] = new PVector( -C1,  C1,  C1 );
    vert[ 30] = new PVector(  C1,  C1, -C1 );
    vert[ 31] = new PVector(  C1,  C1,  C1 );
    // set faces
    faces[ 0] = new int[] {  0, 12,  2, 14 };
    faces[ 1] = new int[] {  0, 14, 10, 26 };
    faces[ 2] = new int[] {  0, 26,  5, 16 };
    faces[ 3] = new int[] {  1, 13,  9, 25 };
    faces[ 4] = new int[] {  1, 25,  4, 17 };
    faces[ 5] = new int[] {  1, 17,  5, 27 };
    faces[ 6] = new int[] {  2, 28,  6, 18 };
    faces[ 7] = new int[] {  2, 18,  7, 30 };
    faces[ 8] = new int[] {  2, 30, 10, 14 };
    faces[ 9] = new int[] {  3, 19,  6, 29 };
    faces[10] = new int[] {  3, 29,  9, 13 };
    faces[11] = new int[] {  3, 13,  1, 15 };
    faces[12] = new int[] {  4, 20,  8, 24 };
    faces[13] = new int[] {  4, 24,  0, 16 };
    faces[14] = new int[] {  4, 16,  5, 17 };
    faces[15] = new int[] {  7, 18,  6, 19 };
    faces[16] = new int[] {  7, 19,  3, 31 };
    faces[17] = new int[] {  7, 31, 11, 23 };
    faces[18] = new int[] {  8, 22,  6, 28 };
    faces[19] = new int[] {  8, 28,  2, 12 };
    faces[20] = new int[] {  8, 12,  0, 24 };
    faces[21] = new int[] {  9, 29,  6, 22 };
    faces[22] = new int[] {  9, 22,  8, 20 };
    faces[23] = new int[] {  9, 20,  4, 25 };
    faces[24] = new int[] { 10, 30,  7, 23 };
    faces[25] = new int[] { 10, 23, 11, 21 };
    faces[26] = new int[] { 10, 21,  5, 26 };
    faces[27] = new int[] { 11, 31,  3, 15 };
    faces[28] = new int[] { 11, 15,  1, 27 };
    faces[29] = new int[] { 11, 27,  5, 21 };
  } //end GreatRhombicTriacontahedron()

  public String name() {
    return "Great Rhombic Triacontahedron";
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
   
} //end class GreatRhombicTriacontahedron
