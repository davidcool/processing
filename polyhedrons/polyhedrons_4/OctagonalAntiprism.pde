/*
OctagonalAntiprism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class OctagonalAntiprism extends Polyhedron {
  
  // polyhedron
  final int FACES = 18;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 0.430147784931485783221150388002;  //sqrt(2 * (sqrt(2 * (10 + 7 * sqrt(2))) - 2 - 2 * sqrt(2))) / 4
  final float C1 = 0.923879532511286756128183189397;  //sqrt(2 + sqrt(2)) / 2
  final float C2 = 1.20710678118654752440084436210;   //(1 + sqrt(2)) / 2
  final float C3 = 1.30656296487637652785664317343;   //sqrt(2 * (2 + sqrt(2))) / 2
  private PVector[] vert = new PVector[16]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private OctagonalAntiprism() {   
    // set vertices
    vert[  0] = new PVector(   C2,  0.5,  C0 );
    vert[  1] = new PVector(   C2, -0.5,  C0 );
    vert[  2] = new PVector(  -C2,  0.5,  C0 );
    vert[  3] = new PVector(  -C2, -0.5,  C0 );
    vert[  4] = new PVector(  0.5,   C2,  C0 );
    vert[  5] = new PVector(  0.5,  -C2,  C0 );
    vert[  6] = new PVector( -0.5,   C2,  C0 );
    vert[  7] = new PVector( -0.5,  -C2,  C0 );
    vert[  8] = new PVector(   C3,  0.0, -C0 );
    vert[  9] = new PVector(  -C3,  0.0, -C0 );
    vert[ 10] = new PVector(  0.0,   C3, -C0 );
    vert[ 11] = new PVector(  0.0,  -C3, -C0 );
    vert[ 12] = new PVector(   C1,   C1, -C0 );
    vert[ 13] = new PVector(   C1,  -C1, -C0 );
    vert[ 14] = new PVector(  -C1,   C1, -C0 );
    vert[ 15] = new PVector(  -C1,  -C1, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  4,  6,  2,  3,  7,  5,  1 };
    faces[ 1] = new int[] { 8, 13, 11, 15,  9, 14, 10, 12 };
    faces[ 2] = new int[] { 0,  1,  8,  8,  8,  8,  8,  8 };  //added 5x 3rd number to fill gap
    faces[ 3] = new int[] { 0,  8, 12, 12, 12, 12, 12, 12 };  //added 5x 3rd number to fill gap
    faces[ 4] = new int[] { 1,  5, 13, 13, 13, 13, 13, 13 };  //added 5x 3rd number to fill gap
    faces[ 5] = new int[] { 1, 13,  8,  8,  8,  8,  8,  8 };  //added 5x 3rd number to fill gap
    faces[ 6] = new int[] { 2,  6, 14, 14, 14, 14, 14, 14 };  //added 5x 3rd number to fill gap
    faces[ 7] = new int[] { 2, 14,  9,  9,  9,  9,  9,  9 };  //added 5x 3rd number to fill gap
    faces[ 8] = new int[] { 3,  2,  9,  9,  9,  9,  9,  9 };  //added 5x 3rd number to fill gap
    faces[ 9] = new int[] { 3,  9, 15, 15, 15, 15, 15, 15 };  //added 5x 3rd number to fill gap
    faces[10] = new int[] { 4,  0, 12, 12, 12, 12, 12, 12 };  //added 5x 3rd number to fill gap
    faces[11] = new int[] { 4, 12, 10, 10, 10, 10, 10, 10 };  //added 5x 3rd number to fill gap
    faces[12] = new int[] { 5,  7, 11, 11, 11, 11, 11, 11 };  //added 5x 3rd number to fill gap
    faces[13] = new int[] { 5, 11, 13, 13, 13, 13, 13, 13 };  //added 5x 3rd number to fill gap
    faces[14] = new int[] { 6,  4, 10, 10, 10, 10, 10, 10 };  //added 5x 3rd number to fill gap
    faces[15] = new int[] { 6, 10, 14, 14, 14, 14, 14, 14 };  //added 5x 3rd number to fill gap
    faces[16] = new int[] { 7,  3, 15, 15, 15, 15, 15, 15 };  //added 5x 3rd number to fill gap
    faces[17] = new int[] { 7, 15, 11, 11, 11, 11, 11, 11 };  //added 5x 3rd number to fill gap
  } //end OctagonalAntiprism()

  public String name() {
    return "Octagonal Antiprism";
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
   
} //end class OctagonalAntiprism
