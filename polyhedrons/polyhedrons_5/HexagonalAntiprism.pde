/*
HexagonalAntiprism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HexagonalAntiprism extends Polyhedron {
  
  // polyhedron
  final int FACES = 16;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.427799838583676096484617883106;  //sqrt(sqrt(3) - 1) / 2
  final float C1 = 0.866025403784438646763723170753;  //sqrt(3) / 2
  private PVector[] vert = new PVector[12]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HexagonalAntiprism() {   
    // set vertices
    vert[  0] = new PVector(  1.0,  0.0,  C0 );
    vert[  1] = new PVector( -1.0,  0.0,  C0 );
    vert[  2] = new PVector(  0.5,   C1,  C0 );
    vert[  3] = new PVector(  0.5,  -C1,  C0 );
    vert[  4] = new PVector( -0.5,   C1,  C0 );
    vert[  5] = new PVector( -0.5,  -C1,  C0 );
    vert[  6] = new PVector(   C1,  0.5, -C0 );
    vert[  7] = new PVector(   C1, -0.5, -C0 );
    vert[  8] = new PVector(  -C1,  0.5, -C0 );
    vert[  9] = new PVector(  -C1, -0.5, -C0 );
    vert[ 10] = new PVector(  0.0,  1.0, -C0 );
    vert[ 11] = new PVector(  0.0, -1.0, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  2,  4,  1,  5,  3 };
    faces[ 1] = new int[] { 6,  7, 11,  9,  8, 10 };
    faces[ 2] = new int[] { 0,  3,  7,  7,  7,  7 };  //added 3x 3rd number to fill gap
    faces[ 3] = new int[] { 0,  7,  6,  6,  6,  6 };  //added 3x 3rd number to fill gap
    faces[ 4] = new int[] { 1,  4,  8,  8,  8,  8 };  //added 3x 3rd number to fill gap
    faces[ 5] = new int[] { 1,  8,  9,  9,  9,  9 };  //added 3x 3rd number to fill gap
    faces[ 6] = new int[] { 2,  0,  6,  6,  6,  6 };  //added 3x 3rd number to fill gap
    faces[ 7] = new int[] { 2,  6, 10, 10, 10, 10 };  //added 3x 3rd number to fill gap
    faces[ 8] = new int[] { 3,  5, 11, 11, 11, 11 };  //added 3x 3rd number to fill gap
    faces[ 9] = new int[] { 3, 11,  7,  7,  7,  7 };  //added 3x 3rd number to fill gap
    faces[10] = new int[] { 4,  2, 10, 10, 10, 10 };  //added 3x 3rd number to fill gap
    faces[11] = new int[] { 4, 10,  8,  8,  8,  8 };  //added 3x 3rd number to fill gap
    faces[12] = new int[] { 5,  1,  9,  9,  9,  9 };  //added 3x 3rd number to fill gap
    faces[13] = new int[] { 5,  9, 11, 11, 11, 11 };  //added 3x 3rd number to fill gap
  } //end HexagonalAntiprism()

  public String name() {
    return "Hexagonal Antiprism";
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
   
} //end class HexagonalAntiprism
