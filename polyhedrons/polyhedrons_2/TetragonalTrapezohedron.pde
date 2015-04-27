/*
TetragonalTrapezohedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TetragonalTrapezohedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 8;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.174155349874503261843187247164;   //sqrt(2 * (3 * sqrt(2) - 4)) / 4
  final float C1 = 0.7071067811865475244008443621048;  //sqrt(2) / 2
  final float C2 = 1.01505176512821780487431272340;    //sqrt(2 * (4 + 3 * sqrt(2))) / 4
  private PVector[] vert = new PVector[10]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TetragonalTrapezohedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,  C2 );
    vert[  1] = new PVector(  0.0,  0.0, -C2 );
    vert[  2] = new PVector(   C1,  0.0,  C0 );
    vert[  3] = new PVector(  -C1,  0.0,  C0 );
    vert[  4] = new PVector(  0.0,   C1,  C0 );
    vert[  5] = new PVector(  0.0,  -C1,  C0 );
    vert[  6] = new PVector(  0.5,  0.5, -C0 );
    vert[  7] = new PVector(  0.5, -0.5, -C0 );
    vert[  8] = new PVector( -0.5,  0.5, -C0 );
    vert[  9] = new PVector( -0.5, -0.5, -C0 );
    // set faces
    faces[ 0] = new int[] { 0, 2, 6, 4 };
    faces[ 1] = new int[] { 0, 4, 8, 3 };
    faces[ 2] = new int[] { 0, 3, 9, 5 };
    faces[ 3] = new int[] { 0, 5, 7, 2 };
    faces[ 4] = new int[] { 1, 6, 2, 7 };
    faces[ 5] = new int[] { 1, 7, 5, 9 };
    faces[ 6] = new int[] { 1, 9, 3, 8 };
    faces[ 7] = new int[] { 1, 8, 4, 6 };
  } //end TetragonalTrapezohedron()

  public String name() {
    return "Tetragonal Trapezohedron";
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
   
} //end class TetragonalTrapezohedron
