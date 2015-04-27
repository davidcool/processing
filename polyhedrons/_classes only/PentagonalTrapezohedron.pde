/*
PentagonalTrapezohedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class PentagonalTrapezohedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 10;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C2 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  private PVector[] vert = new PVector[12]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private PentagonalTrapezohedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,   C0,   C1 );
    vert[  1] = new PVector(  0.0,   C0,  -C1 );
    vert[  2] = new PVector(  0.0,  -C0,   C1 );
    vert[  3] = new PVector(  0.0,  -C0,  -C1 );
    vert[  4] = new PVector(  0.5,  0.5,  0.5 );
    vert[  5] = new PVector(  0.5,  0.5, -0.5 );
    vert[  6] = new PVector( -0.5, -0.5,  0.5 );
    vert[  7] = new PVector( -0.5, -0.5, -0.5 );
    vert[  8] = new PVector(   C2,  -C1,  0.0 );
    vert[  9] = new PVector(  -C2,   C1,  0.0 );
    vert[ 10] = new PVector(   C0,   C1,  0.0 );
    vert[ 11] = new PVector(  -C0,  -C1,  0.0 );
    // set faces
    faces[ 0] = new int[] { 8,  2,  6, 11 };
    faces[ 1] = new int[] { 8, 11,  7,  3 };
    faces[ 2] = new int[] { 8,  3,  1,  5 };
    faces[ 3] = new int[] { 8,  5, 10,  4 };
    faces[ 4] = new int[] { 8,  4,  0,  2 };
    faces[ 5] = new int[] { 9,  0,  4, 10 };
    faces[ 6] = new int[] { 9, 10,  5,  1 };
    faces[ 7] = new int[] { 9,  1,  3,  7 };
    faces[ 8] = new int[] { 9,  7, 11,  6 };
    faces[ 9] = new int[] { 9,  6,  2,  0 };
  } //end PentagonalTrapezohedron()

  public String name() {
    return "Pentagonal Trapezohedron";
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
   
} //end class PentagonalTrapezohedron
