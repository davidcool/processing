/*
HexagonalPrism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HexagonalPrism extends Polyhedron {
  
  // polyhedron
  final int FACES = 8;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.866025403784438646763723170753;  //sqrt(3) / 2
  private PVector[] vert = new PVector[12]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HexagonalPrism() {   
    // set vertices
    vert[  0] = new PVector(  1.0, 0.0,  0.5 );
    vert[  1] = new PVector(  1.0, 0.0, -0.5 );
    vert[  2] = new PVector( -1.0, 0.0,  0.5 );
    vert[  3] = new PVector( -1.0, 0.0, -0.5 );
    vert[  4] = new PVector(  0.5,  C0,  0.5 );
    vert[  5] = new PVector(  0.5,  C0, -0.5 );
    vert[  6] = new PVector(  0.5, -C0,  0.5 );
    vert[  7] = new PVector(  0.5, -C0, -0.5 );
    vert[  8] = new PVector( -0.5,  C0,  0.5 );
    vert[  9] = new PVector( -0.5,  C0, -0.5 );
    vert[ 10] = new PVector( -0.5, -C0,  0.5 );
    vert[ 11] = new PVector( -0.5, -C0, -0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  4,  8,  2, 10,  6 };
    faces[ 1] = new int[] {  1,  7, 11,  3,  9,  5 };
    faces[ 2] = new int[] {  0,  1,  5,  4,  4,  4 };  //added 2x 4th number to fill gap
    faces[ 3] = new int[] {  4,  5,  9,  8,  8,  8 };  //added 2x 4th number to fill gap
    faces[ 4] = new int[] {  8,  9,  3,  2,  2,  2 };  //added 2x 4th number to fill gap
    faces[ 5] = new int[] {  2,  3, 11, 10, 10, 10 };  //added 2x 4th number to fill gap
    faces[ 6] = new int[] { 10, 11,  7,  6,  6,  6 };  //added 2x 4th number to fill gap
    faces[ 7] = new int[] {  6,  7,  1,  0,  0,  0 };  //added 2x 4th number to fill gap
  } //end HexagonalPrism()

  public String name() {
    return "Hexagonal Prism";
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
   
} //end class HexagonalPrism
