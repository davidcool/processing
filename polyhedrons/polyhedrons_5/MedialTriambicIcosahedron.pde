/*
MedialTriambicIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialTriambicIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.381966011250105151795413165634;  //(3 - sqrt(5)) / 2
  final float C1 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C2 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C3 = 2.61803398874989484820458683437;   //(3 + sqrt(5)) / 2
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialTriambicIcosahedron() {   
    // set vertices
    vert[  0] = new PVector(  C2, 0.0,  C3 );
    vert[  1] = new PVector(  C2, 0.0, -C3 );
    vert[  2] = new PVector( -C2, 0.0,  C3 );
    vert[  3] = new PVector( -C2, 0.0, -C3 );
    vert[  4] = new PVector(  C3,  C2, 0.0 );
    vert[  5] = new PVector(  C3, -C2, 0.0 );
    vert[  6] = new PVector( -C3,  C2, 0.0 );
    vert[  7] = new PVector( -C3, -C2, 0.0 );
    vert[  8] = new PVector( 0.0,  C3,  C2 );
    vert[  9] = new PVector( 0.0,  C3, -C2 );
    vert[ 10] = new PVector( 0.0, -C3,  C2 );
    vert[ 11] = new PVector( 0.0, -C3, -C2 );
    vert[ 12] = new PVector(  C0, 0.0,  C1 );
    vert[ 13] = new PVector(  C0, 0.0, -C1 );
    vert[ 14] = new PVector( -C0, 0.0,  C1 );
    vert[ 15] = new PVector( -C0, 0.0, -C1 );
    vert[ 16] = new PVector(  C1,  C0, 0.0 );
    vert[ 17] = new PVector(  C1, -C0, 0.0 );
    vert[ 18] = new PVector( -C1,  C0, 0.0 );
    vert[ 19] = new PVector( -C1, -C0, 0.0 );
    vert[ 20] = new PVector( 0.0,  C1,  C0 );
    vert[ 21] = new PVector( 0.0,  C1, -C0 );
    vert[ 22] = new PVector( 0.0, -C1,  C0 );
    vert[ 23] = new PVector( 0.0, -C1, -C0 );
    // set faces
    faces[ 0] = new int[] {  0, 14,  6, 19, 11, 22 };
    faces[ 1] = new int[] {  0, 22,  7, 23,  1, 17 };
    faces[ 2] = new int[] {  0, 17, 11, 13,  9, 16 };
    faces[ 3] = new int[] {  0, 16,  1, 21,  6, 20 };
    faces[ 4] = new int[] {  0, 20,  9, 18,  7, 14 };
    faces[ 5] = new int[] {  3, 13,  4, 17, 10, 23 };
    faces[ 6] = new int[] {  3, 23,  5, 22,  2, 19 };
    faces[ 7] = new int[] {  3, 19, 10, 14,  8, 18 };
    faces[ 8] = new int[] {  3, 18,  2, 20,  4, 21 };
    faces[ 9] = new int[] {  3, 21,  8, 16,  5, 13 };
    faces[10] = new int[] { 12,  2, 22, 11, 17,  4 };
    faces[11] = new int[] { 12,  4, 20,  6, 14, 10 };
    faces[12] = new int[] { 12, 10, 17,  1, 16,  8 };
    faces[13] = new int[] { 12,  8, 14,  7, 22,  5 };
    faces[14] = new int[] { 12,  5, 16,  9, 20,  2 };
    faces[15] = new int[] { 15,  1, 23, 10, 19,  6 };
    faces[16] = new int[] { 15,  6, 21,  4, 13, 11 };
    faces[17] = new int[] { 15, 11, 19,  2, 18,  9 };
    faces[18] = new int[] { 15,  9, 13,  5, 23,  7 };
    faces[19] = new int[] { 15,  7, 18,  8, 21,  1 };
  } //end MedialTriambicIcosahedron()

  public String name() {
    return "Medial Triambic Icosahedron";
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
   
} //end class MedialTriambicIcosahedron
