/*
Dodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Dodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
   private PVector[] vert = new PVector[30]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Dodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,  1.0 );
    vert[  1] = new PVector(  0.0,  0.0, -1.0 );
    vert[  2] = new PVector(  1.0,  0.0,  0.0 );
    vert[  3] = new PVector( -1.0,  0.0,  0.0 );
    vert[  4] = new PVector(  0.0,  1.0,  0.0 );
    vert[  5] = new PVector(  0.0, -1.0,  0.0 );
    vert[  6] = new PVector(   C0,  0.5,   C1 );
    vert[  7] = new PVector(   C0,  0.5,  -C1 );
    vert[  8] = new PVector(   C0, -0.5,   C1 );
    vert[  9] = new PVector(   C0, -0.5,  -C1 );
    vert[ 10] = new PVector(  -C0,  0.5,   C1 );
    vert[ 11] = new PVector(  -C0,  0.5,  -C1 );
    vert[ 12] = new PVector(  -C0, -0.5,   C1 );
    vert[ 13] = new PVector(  -C0, -0.5,  -C1 );
    vert[ 14] = new PVector(   C1,   C0,  0.5 );
    vert[ 15] = new PVector(   C1,   C0, -0.5 );
    vert[ 16] = new PVector(   C1,  -C0,  0.5 );
    vert[ 17] = new PVector(   C1,  -C0, -0.5 );
    vert[ 18] = new PVector(  -C1,   C0,  0.5 );
    vert[ 19] = new PVector(  -C1,   C0, -0.5 );
    vert[ 20] = new PVector(  -C1,  -C0,  0.5 );
    vert[ 21] = new PVector(  -C1,  -C0, -0.5 );
    vert[ 22] = new PVector(  0.5,   C1,   C0 );
    vert[ 23] = new PVector(  0.5,   C1,  -C0 );
    vert[ 24] = new PVector(  0.5,  -C1,   C0 );
    vert[ 25] = new PVector(  0.5,  -C1,  -C0 );
    vert[ 26] = new PVector( -0.5,   C1,   C0 );
    vert[ 27] = new PVector( -0.5,   C1,  -C0 );
    vert[ 28] = new PVector( -0.5,  -C1,   C0 );
    vert[ 29] = new PVector( -0.5,  -C1,  -C0 );
    // set faces
    faces[ 0] = new int[] { 0, 14, 23, 27, 18 };
    faces[ 1] = new int[] { 0, 18, 12, 10, 20 };
    faces[ 2] = new int[] { 0, 20, 29, 25, 16 };
    faces[ 3] = new int[] { 0, 16,  6,  8, 14 };
    faces[ 4] = new int[] { 1, 17, 24, 28, 21 };
    faces[ 5] = new int[] { 1, 21, 11, 13, 19 };
    faces[ 6] = new int[] { 1, 19, 26, 22, 15 };
    faces[ 7] = new int[] { 1, 15,  9,  7, 17 };
    faces[ 8] = new int[] { 2, 22, 10, 12, 24 };
    faces[ 9] = new int[] { 2, 24, 17, 16, 25 };
    faces[10] = new int[] { 2, 25, 13, 11, 23 };
    faces[11] = new int[] { 2, 23, 14, 15, 22 };
    faces[12] = new int[] { 3, 27,  7,  9, 29 };
    faces[13] = new int[] { 3, 29, 20, 21, 28 };
    faces[14] = new int[] { 3, 28,  8,  6, 26 };
    faces[15] = new int[] { 3, 26, 19, 18, 27 };
    faces[16] = new int[] { 4,  6, 16, 17,  7 };
    faces[17] = new int[] { 4,  7, 27, 23, 11 };
    faces[18] = new int[] { 4, 11, 21, 20, 10 };
    faces[19] = new int[] { 4, 10, 22, 26,  6 };
    faces[20] = new int[] { 5,  8, 28, 24, 12 };
    faces[21] = new int[] { 5, 12, 18, 19, 13 };
    faces[22] = new int[] { 5, 13, 25, 29,  9 };
    faces[23] = new int[] { 5,  9, 15, 14,  8 };
  } //end Dodecadodecahedron  //added 2x 3rd number to fill gap()

  public String name() {
    return "Dodecadodecahedron";
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
   
} //end class Dodecadodecahedron
