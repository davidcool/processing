/*
HeptagonalDipyramid class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HeptagonalDipyramid extends Polyhedron {
  
  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.284614957246127011669038446077;  //1 / (2 * sin(pi/7)) - 2 * sin(pi/7)
  final float C1 = 0.554958132087371191422194871006;  //1 / (2 * cos(pi/7))
  final float C2 = 0.797473388882403961415688254214;  //cot(2*pi/7)
  final float C3 = 1.15238243548124325262057511177;   //1 / (2 * sin(pi/7))
  final float C4 = 1.24697960371746706105000976801;   //2 * cos(2*pi/7)
  final float C5 = 1.27904800768993260574785060727;   //1 / sin(2*pi/7)
  final float C6 = 2.65597055521136353559206405001;   //1 / (2 * (sin(pi/7)^2))
  //C0 = square-root of a root of the polynomial:  7*(x^3) - 21*(x^2) + 14*x - 1
  //C1 = root of the polynomial:  (x^3) - 2*(x^2) - x + 1
  //C2 = square-root of a root of the polynomial:  7*(x^3) - 35*(x^2) + 21*x - 1
  //C3 = square-root of a root of the polynomial:  7*(x^3) - 14*(x^2) + 7*x - 1
  //C4 = root of the polynomial:  (x^3) + (x^2) - 2*x - 1
  //C5 = square-root of a root of the polynomial:  7*(x^3) - 56*(x^2) + 112*x - 64
  //C6 = root of the polynomial:  7*(x^3) - 28*(x^2) + 28*x - 8
  private PVector[] vert = new PVector[9]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HeptagonalDipyramid() {   
    // set vertices
    vert[  0] = new PVector(  0.0, 0.0,  C6 );
    vert[  1] = new PVector(  0.0, 0.0, -C6 );
    vert[  2] = new PVector(   C4,  C0, 0.0 );
    vert[  3] = new PVector(  -C4,  C0, 0.0 );
    vert[  4] = new PVector(  1.0, -C2, 0.0 );
    vert[  5] = new PVector( -1.0, -C2, 0.0 );
    vert[  6] = new PVector(   C1,  C3, 0.0 );
    vert[  7] = new PVector(  -C1,  C3, 0.0 );
    vert[  8] = new PVector(  0.0, -C5, 0.0 );
    // set faces
    faces[ 0] = new int[] { 0, 2, 6 };
    faces[ 1] = new int[] { 0, 6, 7 };
    faces[ 2] = new int[] { 0, 7, 3 };
    faces[ 3] = new int[] { 0, 3, 5 };
    faces[ 4] = new int[] { 0, 5, 8 };
    faces[ 5] = new int[] { 0, 8, 4 };
    faces[ 6] = new int[] { 0, 4, 2 };
    faces[ 7] = new int[] { 1, 2, 4 };
    faces[ 8] = new int[] { 1, 4, 8 };
    faces[ 9] = new int[] { 1, 8, 5 };
    faces[10] = new int[] { 1, 5, 3 };
    faces[11] = new int[] { 1, 3, 7 };
    faces[12] = new int[] { 1, 7, 6 };
    faces[13] = new int[] { 1, 6, 2 };
  } //end HeptagonalDipyramid()

  public String name() {
    return "Heptagonal Dipyramid";
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
   
} //end class HeptagonalDipyramid
