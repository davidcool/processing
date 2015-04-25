/*
GreatIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.0, -0.5,   C0);
    vert[ 1] = new PVector( 0.0, -0.5,  -C0);
    vert[ 2] = new PVector( 0.0,  0.5,   C0);
    vert[ 3] = new PVector( 0.0,  0.5,  -C0);
    vert[ 4] = new PVector(-0.5,   C0,  0.0);
    vert[ 5] = new PVector( 0.5,   C0,  0.0);
    vert[ 6] = new PVector(-0.5,  -C0,  0.0);
    vert[ 7] = new PVector( 0.5,  -C0,  0.0);  
    vert[ 8] = new PVector(  C0,  0.0, -0.5);
    vert[ 9] = new PVector(  C0,  0.0,  0.5);
    vert[10] = new PVector( -C0,  0.0, -0.5);
    vert[11] = new PVector( -C0,  0.0,  0.5);
    // set faces
    faces[ 0] = new int[] { 0,  2, 10};
    faces[ 1] = new int[] { 0, 10,  5};
    faces[ 2] = new int[] { 0,  5,  4};
    faces[ 3] = new int[] { 0,  4,  8};
    faces[ 4] = new int[] { 0,  8,  2};
    faces[ 5] = new int[] { 3,  1, 11};
    faces[ 6] = new int[] { 3, 11,  7};
    faces[ 7] = new int[] { 3,  7,  6};
    faces[ 8] = new int[] { 3,  6,  9};
    faces[ 9] = new int[] { 3,  9,  1};
    faces[10] = new int[] { 2,  6,  7};
    faces[11] = new int[] { 2,  7, 10};
    faces[12] = new int[] {10,  7, 11};
    faces[13] = new int[] {10, 11,  5};
    faces[14] = new int[] { 5, 11,  1};
    faces[15] = new int[] { 5,  1,  4};
    faces[16] = new int[] { 4,  1,  9};
    faces[17] = new int[] { 4,  9,  8};
    faces[18] = new int[] { 8,  9,  6};
    faces[19] = new int[] { 8,  6,  2};
  } //end GreatIcosahedron()

  public String name() {
    return "Great Icosahedron";
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
  
} //end class GreatIcosahedron
