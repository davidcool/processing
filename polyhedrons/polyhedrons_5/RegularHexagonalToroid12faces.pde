/*
RegularHexagonalToroid12faces class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class RegularHexagonalToroid12faces extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private RegularHexagonalToroid12faces() {   
    // set vertices
    vert[  0] = new PVector(  3,  3,  3 );
    vert[  1] = new PVector(  3,  3, -3 );
    vert[  2] = new PVector( -3,  3,  3 );
    vert[  3] = new PVector(  3, -3, -3 );
    vert[  4] = new PVector( -3, -3,  3 );
    vert[  5] = new PVector( -3, -3, -3 );
    vert[  6] = new PVector(  3,  1,  3 );
    vert[  7] = new PVector( -3, -1, -3 );
    vert[  8] = new PVector( -3,  3,  1 );
    vert[  9] = new PVector(  3, -3, -1 );
    vert[ 10] = new PVector( -1, -3,  3 );
    vert[ 11] = new PVector(  1,  3, -3 );
    vert[ 12] = new PVector( -1,  1,  3 );
    vert[ 13] = new PVector(  1, -1, -3 );
    vert[ 14] = new PVector( -3, -1,  1 );
    vert[ 15] = new PVector(  3,  1, -1 );
    vert[ 16] = new PVector(  1,  3,  1 );
    vert[ 17] = new PVector( -1, -3, -1 );
    vert[ 18] = new PVector(  1,  1,  1 );
    vert[ 19] = new PVector(  1,  1, -1 );
    vert[ 20] = new PVector( -1,  1,  1 );
    vert[ 21] = new PVector(  1, -1, -1 );
    vert[ 22] = new PVector( -1, -1,  1 );
    vert[ 23] = new PVector( -1, -1, -1 );
    // set faces
    faces[ 0] = new int[] {  0,  1, 11, 16,  8,  2 };
    faces[ 1] = new int[] {  0,  2,  4, 10, 12,  6 };
    faces[ 2] = new int[] {  0,  6, 15,  9,  3,  1 };
    faces[ 3] = new int[] {  5,  3,  9, 17, 10,  4 };
    faces[ 4] = new int[] {  5,  4,  2,  8, 14,  7 };
    faces[ 5] = new int[] {  5,  7, 13, 11,  1,  3 };
    faces[ 6] = new int[] { 18, 16, 11, 13, 21, 19 };
    faces[ 7] = new int[] { 18, 19, 15,  6, 12, 20 };
    faces[ 8] = new int[] { 18, 20, 22, 14,  8, 16 };
    faces[ 9] = new int[] { 23, 17,  9, 15, 19, 21 };
    faces[10] = new int[] { 23, 21, 13,  7, 14, 22 };
    faces[11] = new int[] { 23, 22, 20, 12, 10, 17 };
  } //end RegularHexagonalToroid12faces()

  public String name() {
    return "Regular Hexagonal Toroid with 12 faces (type C) (simple form)";
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
   
} //end class RegularHexagonalToroid12faces
