/*
HeptagonalPrism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HeptagonalPrism extends Polyhedron {
  
  // polyhedron
  final int FACES = 9;     // number of faces 
  final int VERTICES = 7;   // VERTICES per face
  final float C0 = 0.256429215818138474873324904069;   //1 / (4 * cos(pi/14))
  final float C1 = 0.7184986963636851321448067789251;  //(1 + cos(pi/7)) * sqrt(7) / 7
  final float C2 = 0.900968867902419126236102319507;   //cos(pi/7)
  final float C3 = 1.03826069828616828358176943074;    //cot(pi/7) / 2
  final float C4 = 1.12348980185873353052500488400;    //1 / (4 * sin(pi/14))
  final float C5 = 1.15238243548124325262057511177;    //1 / (2 * sin(pi/7))
  //C0 = square-root of a root of the polynomial:  448*(x^3) - 224*(x^2) + 28*x - 1
  //C1 = square-root of a root of the polynomial:  448*(x^3) - 336*(x^2) + 56*x - 1
  //C2 = root of the polynomial:  8*(x^3) - 4*(x^2) - 4*x + 1
  //C3 = square-root of a root of the polynomial:  448*(x^3) - 560*(x^2) + 84*x - 1
  //C4 = root of the polynomial:  8*(x^3) - 8*(x^2) - 2*x + 1
  //C5 = square-root of a root of the polynomial:  7*(x^3) - 14*(x^2) + 7*x - 1
  private PVector[] vert = new PVector[14]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HeptagonalPrism() {   
    // set vertices
    vert[  0] = new PVector(   C4, -C0,  0.5 );
    vert[  1] = new PVector(   C4, -C0, -0.5 );
    vert[  2] = new PVector(  -C4, -C0,  0.5 );
    vert[  3] = new PVector(  -C4, -C0, -0.5 );
    vert[  4] = new PVector(   C2,  C1,  0.5 );
    vert[  5] = new PVector(   C2,  C1, -0.5 );
    vert[  6] = new PVector(  -C2,  C1,  0.5 );
    vert[  7] = new PVector(  -C2,  C1, -0.5 );
    vert[  8] = new PVector(  0.5, -C3,  0.5 );
    vert[  9] = new PVector(  0.5, -C3, -0.5 );
    vert[ 10] = new PVector( -0.5, -C3,  0.5 );
    vert[ 11] = new PVector( -0.5, -C3, -0.5 );
    vert[ 12] = new PVector(  0.0,  C5,  0.5 );
    vert[ 13] = new PVector(  0.0,  C5, -0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  4, 12,  6,  2, 10,  8 };
    faces[ 1] = new int[] {  1,  9, 11,  3,  7, 13,  5 };
    faces[ 2] = new int[] {  0,  1,  5,  4,  4,  4,  4 };  //added 3x 4th number to fill gap
    faces[ 3] = new int[] {  4,  5, 13, 12, 12, 12, 12 };  //added 3x 4th number to fill gap
    faces[ 4] = new int[] { 12, 13,  7,  6,  6,  6,  6 };  //added 3x 4th number to fill gap
    faces[ 5] = new int[] {  6,  7,  3,  2,  2,  2,  2 };  //added 3x 4th number to fill gap
    faces[ 6] = new int[] {  2,  3, 11, 10, 10, 10, 10 };  //added 3x 4th number to fill gap
    faces[ 7] = new int[] { 10, 11,  9,  8,  8,  8,  8 };  //added 3x 4th number to fill gap
    faces[ 8] = new int[] {  8,  9,  1,  0,  0,  0,  0 };  //added 3x 4th number to fill gap
  } //end HeptagonalPrism()

  public String name() {
    return "Heptagonal Prism";
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
   
} //end class HeptagonalPrism
