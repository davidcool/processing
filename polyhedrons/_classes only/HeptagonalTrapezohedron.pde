/*
HeptagonalTrapezohedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HeptagonalTrapezohedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.1531927682625616683458021483497;
  final float C1 = 0.256429215818138474873324904069;
  final float C2 = 0.7184986963636851321448067789251;
  final float C3 = 0.900968867902419126236102319507;
  final float C4 = 1.03826069828616828358176943074;
  final float C5 = 1.12348980185873353052500488400;
  final float C6 = 1.15238243548124325262057511177;
  final float C7 = 2.94063772761851796655260234634;
  /*
  C0 = square-root of a root of the polynomial:  448*(x^3)+560*(x^2)-56*x+1
      = sqrt(14 * (3 - 8 * sin(pi/14) - 18 * (sin(pi/14)^2))) / 14
  C1 = square-root of a root of the polynomial:  448*(x^3)-224*(x^2)+28*x-1
      = 1 / (4 * cos(pi/14))
  C2 = square-root of a root of the polynomial:  448*(x^3)-336*(x^2)+56*x-1
      = (1 + cos(pi/7)) * sqrt(7) / 7
  C3 = root of the polynomial:  8*(x^3) - 4*(x^2) - 4*x + 1
      = cos(pi/7)
  C4 = square-root of a root of the polynomial:  448*(x^3)-560*(x^2)+84*x-1
      = cot(pi/7) / 2
  C5 = root of the polynomial:  8*(x^3) - 8*(x^2) - 2*x + 1
      = 1 / (4 * sin(pi/14))
  C6 = square-root of a root of the polynomial:  7*(x^3) - 14*(x^2) + 7*x - 1
      = 1 / (2 * sin(pi/7))
  C7 = square-root of a root of the polynomial:  64*(x^3)-560*(x^2)+56*x+7
      = sqrt(2 * (16 * (cos(pi/7)^2) + 7 * cos(pi/7) - 2)) / 2
  */
  private PVector[] vert = new PVector[16]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HeptagonalTrapezohedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0, 0.0,  C7 );
    vert[  1] = new PVector(  0.0, 0.0, -C7 );
    vert[  2] = new PVector(   C5,  C1,  C0 );
    vert[  3] = new PVector(   C5, -C1, -C0 );
    vert[  4] = new PVector(  -C5,  C1,  C0 );
    vert[  5] = new PVector(  -C5, -C1, -C0 );
    vert[  6] = new PVector(   C3, -C2,  C0 );
    vert[  7] = new PVector(   C3,  C2, -C0 );
    vert[  8] = new PVector(  -C3, -C2,  C0 );
    vert[  9] = new PVector(  -C3,  C2, -C0 );
    vert[ 10] = new PVector(  0.5,  C4,  C0 );
    vert[ 11] = new PVector(  0.5, -C4, -C0 );
    vert[ 12] = new PVector( -0.5,  C4,  C0 );
    vert[ 13] = new PVector( -0.5, -C4, -C0 );
    vert[ 14] = new PVector(  0.0, -C6,  C0 );
    vert[ 15] = new PVector(  0.0,  C6, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  2,  7, 10 };
    faces[ 1] = new int[] { 0, 10, 15, 12 };
    faces[ 2] = new int[] { 0, 12,  9,  4 };
    faces[ 3] = new int[] { 0,  4,  5,  8 };
    faces[ 4] = new int[] { 0,  8, 13, 14 };
    faces[ 5] = new int[] { 0, 14, 11,  6 };
    faces[ 6] = new int[] { 0,  6,  3,  2 };
    faces[ 7] = new int[] { 1,  3,  6, 11 };
    faces[ 8] = new int[] { 1, 11, 14, 13 };
    faces[ 9] = new int[] { 1, 13,  8,  5 };
    faces[10] = new int[] { 1,  5,  4,  9 };
    faces[11] = new int[] { 1,  9, 12, 15 };
    faces[12] = new int[] { 1, 15, 10,  7 };
    faces[13] = new int[] { 1,  7,  2,  3 };
  } //end HeptagonalTrapezohedron()

  public String name() {
    return "Heptagonal Trapezohedron";
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
   
} //end class HeptagonalTrapezohedron
