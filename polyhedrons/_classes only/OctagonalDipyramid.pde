/*
OctagonalDipyramid class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class OctagonalDipyramid extends Polyhedron {
  
  // polyhedron
  final int FACES = 16;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 1.41421356237309504880168872421;  //sqrt(2)
  final float C1 = 3.41421356237309504880168872421;  //2 + sqrt(2)
  private PVector[] vert = new PVector[10]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private OctagonalDipyramid() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,  C1 );
    vert[  1] = new PVector(  0.0,  0.0, -C1 );
    vert[  2] = new PVector(   C0,  0.0, 0.0 );
    vert[  3] = new PVector(  -C0,  0.0, 0.0 );
    vert[  4] = new PVector(  0.0,   C0, 0.0 );
    vert[  5] = new PVector(  0.0,  -C0, 0.0 );
    vert[  6] = new PVector(  1.0,  1.0, 0.0 );
    vert[  7] = new PVector(  1.0, -1.0, 0.0 );
    vert[  8] = new PVector( -1.0,  1.0, 0.0 );
    vert[  9] = new PVector( -1.0, -1.0, 0.0 );
    // set faces
    faces[ 0] = new int[] { 0, 2, 6 };
    faces[ 1] = new int[] { 0, 6, 4 };
    faces[ 2] = new int[] { 0, 4, 8 };
    faces[ 3] = new int[] { 0, 8, 3 };
    faces[ 4] = new int[] { 0, 3, 9 };
    faces[ 5] = new int[] { 0, 9, 5 };
    faces[ 6] = new int[] { 0, 5, 7 };
    faces[ 7] = new int[] { 0, 7, 2 };
    faces[ 8] = new int[] { 1, 2, 7 };
    faces[ 9] = new int[] { 1, 7, 5 };
    faces[10] = new int[] { 1, 5, 9 };
    faces[11] = new int[] { 1, 9, 3 };
    faces[12] = new int[] { 1, 3, 8 };
    faces[13] = new int[] { 1, 8, 4 };
    faces[14] = new int[] { 1, 4, 6 };
    faces[15] = new int[] { 1, 6, 2 };
  } //end OctagonalDipyramid()

  public String name() {
    return "Octagonal Dipyramid";
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
   
} //end class OctagonalDipyramid
