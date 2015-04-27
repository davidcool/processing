/*
OctagonalTrapezohedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class OctagonalTrapezohedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 16;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.151047815180276180953489848716;
  final float C1 = 0.923879532511286756128183189397;
  final float C2 = 1.20710678118654752440084436210;
  final float C3 = 1.30656296487637652785664317343;
  final float C4 = 3.817603985406019048222189005746;
  //C0 = sqrt(2 * (3 * sqrt(2 * (2 + sqrt(2))) - 2 - 4 * sqrt(2))) / 4
  //C1 = sqrt(2 + sqrt(2)) / 2
  //C2 = (1 + sqrt(2)) / 2
  //C3 = sqrt(2 * (2 + sqrt(2))) / 2
  //C4 = sqrt(2 * (30 + 20 * sqrt(2) + sqrt(2 * (850 + 601 * sqrt(2))))) / 4
  private PVector[] vert = new PVector[18]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private OctagonalTrapezohedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,  C4 );
    vert[  1] = new PVector(  0.0,  0.0, -C4 );
    vert[  2] = new PVector(   C3,  0.0,  C0 );
    vert[  3] = new PVector(  -C3,  0.0,  C0 );
    vert[  4] = new PVector(  0.0,   C3,  C0 );
    vert[  5] = new PVector(  0.0,  -C3,  C0 );
    vert[  6] = new PVector(   C1,   C1,  C0 );
    vert[  7] = new PVector(   C1,  -C1,  C0 );
    vert[  8] = new PVector(  -C1,   C1,  C0 );
    vert[  9] = new PVector(  -C1,  -C1,  C0 );
    vert[ 10] = new PVector(   C2,  0.5, -C0 );
    vert[ 11] = new PVector(   C2, -0.5, -C0 );
    vert[ 12] = new PVector(  -C2,  0.5, -C0 );
    vert[ 13] = new PVector(  -C2, -0.5, -C0 );
    vert[ 14] = new PVector(  0.5,   C2, -C0 );
    vert[ 15] = new PVector(  0.5,  -C2, -C0 );
    vert[ 16] = new PVector( -0.5,   C2, -C0 );
    vert[ 17] = new PVector( -0.5,  -C2, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  2, 10,  6 };
    faces[ 1] = new int[] { 0,  6, 14,  4 };
    faces[ 2] = new int[] { 0,  4, 16,  8 };
    faces[ 3] = new int[] { 0,  8, 12,  3 };
    faces[ 4] = new int[] { 0,  3, 13,  9 };
    faces[ 5] = new int[] { 0,  9, 17,  5 };
    faces[ 6] = new int[] { 0,  5, 15,  7 };
    faces[ 7] = new int[] { 0,  7, 11,  2 };
    faces[ 8] = new int[] { 1, 10,  2, 11 };
    faces[ 9] = new int[] { 1, 11,  7, 15 };
    faces[10] = new int[] { 1, 15,  5, 17 };
    faces[11] = new int[] { 1, 17,  9, 13 };
    faces[12] = new int[] { 1, 13,  3, 12 };
    faces[13] = new int[] { 1, 12,  8, 16 };
    faces[14] = new int[] { 1, 16,  4, 14 };
    faces[15] = new int[] { 1, 14,  6, 10 };
  } //end OctagonalTrapezohedron()

  public String name() {
    return "Octagonal Trapezohedron";
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
   
} //end class OctagonalTrapezohedron
