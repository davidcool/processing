/*
Dodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Dodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float A = 1.618033989; // (1 + sqr(5) / 2) - wikipedia
  final float B = 0.618033989; // 1 / (1 + sqr(5) / 2) - wikipedia
  private PVector[] vert = new PVector[20]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Dodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 1,  1,  1);
    vert[ 1] = new PVector( 1,  1, -1);
    vert[ 2] = new PVector( 1, -1,  1);
    vert[ 3] = new PVector( 1, -1, -1);  
    vert[ 4] = new PVector(-1,  1,  1);
    vert[ 5] = new PVector(-1,  1, -1);
    vert[ 6] = new PVector(-1, -1,  1);
    vert[ 7] = new PVector(-1, -1, -1); 
    vert[ 8] = new PVector( 0,  B,  A);
    vert[ 9] = new PVector( 0,  B, -A);
    vert[10] = new PVector( 0, -B,  A);
    vert[11] = new PVector( 0, -B, -A); 
    vert[12] = new PVector( B,  A,  0);
    vert[13] = new PVector( B, -A,  0);
    vert[14] = new PVector(-B,  A,  0);
    vert[15] = new PVector(-B, -A,  0);
    vert[16] = new PVector( A,  0,  B);
    vert[17] = new PVector( A,  0, -B);
    vert[18] = new PVector(-A,  0,  B);
    vert[19] = new PVector(-A,  0, -B); 
    // set faces
    faces[ 0] = new int[] { 0, 16,  2, 10,  8};
    faces[ 1] = new int[] { 0,  8,  4, 14, 12};
    faces[ 2] = new int[] {16, 17,  1, 12,  0};
    faces[ 3] = new int[] { 1,  9, 11,  3, 17};
    faces[ 4] = new int[] { 1, 12, 14,  5,  9};
    faces[ 5] = new int[] { 2, 13, 15,  6, 10};
    faces[ 6] = new int[] {13,  3, 17, 16,  2};
    faces[ 7] = new int[] { 3, 11,  7, 15, 13};
    faces[ 8] = new int[] { 4,  8, 10,  6, 18};
    faces[ 9] = new int[] {14,  5, 19, 18,  4};
    faces[10] = new int[] { 5, 19,  7, 11,  9};
    faces[11] = new int[] {15,  7, 19, 18,  6};
  } //end dodecahedron()

  public String name() {
    return "Dodecahedron";
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
   
} //end class Dodecahedron
