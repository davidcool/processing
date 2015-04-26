/*
HeptagonalAntiprism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HeptagonalAntiprism extends Polyhedron {
  
  // polyhedron
  final int FACES = 16;     // number of faces 
  final int VERTICES = 7;   // VERTICES per face
  final float C0 = 0.222520933956314404288902564497;  //sin(pi/14)4
  final float C1 = 0.671181371874405914756434334940;  //sqrt(2 * cos(pi/7)) / 2
  final float C2 = 0.836949481122492579754074026159;  //sqrt(1 + 2 * cos(pi/7)) / 2
  final float C3 = 0.900968867902419126236102319507;  //cos(pi/7)
  final float C4 = 1.12348980185873353052500488400;   //1 / (4 * sin(pi/14))
  final float C5 = 1.20942704154975214093810613957;   //sqrt(cos(pi/7) + 1 / (8 * sin(pi/14)))
  //C0 = root of the polynomial:  8*(x^3) - 4*(x^2) - 4*x + 1
  //C1 = square-root of a root of the polynomial:  64*(x^3) - 16*(x^2) - 8*x + 1
  //C2 = square-root of a root of the polynomial:  64*(x^3) - 64*(x^2) + 12*x + 1
  //C3 = root of the polynomial:  8*(x^3) - 4*(x^2) - 4*x + 1
  //C4 = root of the polynomial:  8*(x^3) - 8*(x^2) - 2*x + 1
  //C5 = square-root of a root of the polynomial:  64*(x^3) - 64*(x^2) - 44*x + 1
  private PVector[] vert = new PVector[14]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HeptagonalAntiprism() {   
    // set vertices
    vert[  0] = new PVector(  0.5, 0.0,   C4 );
    vert[  1] = new PVector(  0.5, 0.0,  -C4 );
    vert[  2] = new PVector( -0.5, 0.0,   C4 );
    vert[  3] = new PVector( -0.5, 0.0,  -C4 );
    vert[  4] = new PVector(  0.0,  C2,   C3 );
    vert[  5] = new PVector(  0.0,  C2,  -C3 );
    vert[  6] = new PVector(  0.0, -C2,   C3 );
    vert[  7] = new PVector(  0.0, -C2,  -C3 );
    vert[  8] = new PVector(   C3,  C1,  0.5 );
    vert[  9] = new PVector(   C3,  C1, -0.5 );
    vert[ 10] = new PVector(  -C3, -C1,  0.5 );
    vert[ 11] = new PVector(  -C3, -C1, -0.5 );
    vert[ 12] = new PVector(   C0,  C5,  0.0 );
    vert[ 13] = new PVector(  -C0, -C5,  0.0 );
    // set faces
    faces[ 0] = new int[] {  0,  6, 13,  7,  1,  9,  8 };
    faces[ 1] = new int[] {  2,  4, 12,  5,  3, 11, 10 };
    faces[ 2] = new int[] {  0,  4,  2,  2,  2,  2,  2 };  //added 4x 3rd number to fill gap
    faces[ 3] = new int[] {  0,  2,  6,  6,  6,  6,  6 };  //added 4x 3rd number to fill gap
    faces[ 4] = new int[] {  6,  2, 10, 10, 10, 10, 10 };  //added 4x 3rd number to fill gap
    faces[ 5] = new int[] {  6, 10, 13, 13, 13, 13, 13 };  //added 4x 3rd number to fill gap
    faces[ 6] = new int[] { 13, 10, 11, 11, 11, 11, 11 };  //added 4x 3rd number to fill gap
    faces[ 7] = new int[] { 13, 11,  7,  7,  7,  7,  7 };  //added 4x 3rd number to fill gap
    faces[ 8] = new int[] {  7, 11,  3,  3,  3,  3,  3 };  //added 4x 3rd number to fill gap
    faces[ 9] = new int[] {  7,  3,  1,  1,  1,  1,  1 };  //added 4x 3rd number to fill gap
    faces[10] = new int[] {  1,  3,  5,  5,  5,  5,  5 };  //added 4x 3rd number to fill gap
    faces[11] = new int[] {  1,  5,  9,  9,  9,  9,  9 };  //added 4x 3rd number to fill gap
    faces[12] = new int[] {  9,  5, 12, 12, 12, 12, 12 };  //added 4x 3rd number to fill gap
    faces[13] = new int[] {  9, 12,  8,  8,  8,  8,  8 };  //added 4x 3rd number to fill gap
    faces[14] = new int[] {  8, 12,  4,  4,  4,  4,  4 };  //added 4x 3rd number to fill gap
    faces[15] = new int[] {  8,  4,  0,  0,  0,  0,  0 };  //added 4x 3rd number to fill gap
  } //end HeptagonalAntiprism()

  public String name() {
    return "Heptagonal Antiprism";
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
   
} //end class HeptagonalAntiprism
