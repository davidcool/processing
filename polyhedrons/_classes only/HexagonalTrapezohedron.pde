/*
HexagonalTrapezohedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class HexagonalTrapezohedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.156585608656507718901567227964;  //sqrt(2 * (3 * sqrt(3) - 5)) / 4
  final float C1 = 0.866025403784438646763723170753;  //sqrt(3) / 2
  final float C2 = 2.18095618030422754264317321632;   //sqrt(2 * (19 + 11 * sqrt(3))) / 4
  private PVector[] vert = new PVector[14]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private HexagonalTrapezohedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,  C2 );
    vert[  1] = new PVector(  0.0,  0.0, -C2 );
    vert[  2] = new PVector(  0.0,  1.0,  C0 );
    vert[  3] = new PVector(  0.0, -1.0,  C0 );
    vert[  4] = new PVector(  1.0,  0.0, -C0 );
    vert[  5] = new PVector( -1.0,  0.0, -C0 );
    vert[  6] = new PVector(   C1,  0.5,  C0 );
    vert[  7] = new PVector(   C1, -0.5,  C0 );
    vert[  8] = new PVector(  -C1,  0.5,  C0 );
    vert[  9] = new PVector(  -C1, -0.5,  C0 );
    vert[ 10] = new PVector(  0.5,   C1, -C0 );
    vert[ 11] = new PVector(  0.5,  -C1, -C0 );
    vert[ 12] = new PVector( -0.5,   C1, -C0 );
    vert[ 13] = new PVector( -0.5,  -C1, -C0 );
    // set faces
    faces[ 0] = new int[] { 0,  2, 12,  8 };
    faces[ 1] = new int[] { 0,  8,  5,  9 };
    faces[ 2] = new int[] { 0,  9, 13,  3 };
    faces[ 3] = new int[] { 0,  3, 11,  7 };
    faces[ 4] = new int[] { 0,  7,  4,  6 };
    faces[ 5] = new int[] { 0,  6, 10,  2 };
    faces[ 6] = new int[] { 1,  4,  7, 11 };
    faces[ 7] = new int[] { 1, 11,  3, 13 };
    faces[ 8] = new int[] { 1, 13,  9,  5 };
    faces[ 9] = new int[] { 1,  5,  8, 12 };
    faces[10] = new int[] { 1, 12,  2, 10 };
    faces[11] = new int[] { 1, 10,  6,  4 };
  } //end HexagonalTrapezohedron()

  public String name() {
    return "Hexagonal Trapezohedron";
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
   
} //end class HexagonalTrapezohedron
