/*
TriakisOctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TriakisOctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 2.41421356237309504880168872421;  //1 + sqrt(2)
  private PVector[] vert = new PVector[14]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TriakisOctahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,   C0 );
    vert[  1] = new PVector(  0.0,  0.0,  -C0 );
    vert[  2] = new PVector(   C0,  0.0,  0.0 );
    vert[  3] = new PVector(  -C0,  0.0,  0.0 );
    vert[  4] = new PVector(  0.0,   C0,  0.0 );
    vert[  5] = new PVector(  0.0,  -C0,  0.0 );
    vert[  6] = new PVector(  1.0,  1.0,  1.0 );
    vert[  7] = new PVector(  1.0,  1.0, -1.0 );
    vert[  8] = new PVector(  1.0, -1.0,  1.0 );
    vert[  9] = new PVector(  1.0, -1.0, -1.0 );
    vert[ 10] = new PVector( -1.0,  1.0,  1.0 );
    vert[ 11] = new PVector( -1.0,  1.0, -1.0 );
    vert[ 12] = new PVector( -1.0, -1.0,  1.0 );
    vert[ 13] = new PVector( -1.0, -1.0, -1.0 );
    // set faces
    faces[  0] = new int[] {  6,  0,  2 };
    faces[  1] = new int[] {  6,  2,  4 };
    faces[  2] = new int[] {  6,  4,  0 };
    faces[  3] = new int[] {  7,  1,  4 };
    faces[  4] = new int[] {  7,  4,  2 };
    faces[  5] = new int[] {  7,  2,  1 };
    faces[  6] = new int[] {  8,  0,  5 };
    faces[  7] = new int[] {  8,  5,  2 };
    faces[  8] = new int[] {  8,  2,  0 };
    faces[  9] = new int[] {  9,  1,  2 };
    faces[ 10] = new int[] {  9,  2,  5 };
    faces[ 11] = new int[] {  9,  5,  1 };
    faces[ 12] = new int[] { 10,  0,  4 };
    faces[ 13] = new int[] { 10,  4,  3 };
    faces[ 14] = new int[] { 10,  3,  0 };
    faces[ 15] = new int[] { 11,  1,  3 };
    faces[ 16] = new int[] { 11,  3,  4 };
    faces[ 17] = new int[] { 11,  4,  1 };
    faces[ 18] = new int[] { 12,  0,  3 };
    faces[ 19] = new int[] { 12,  3,  5 };
    faces[ 20] = new int[] { 12,  5,  0 };
    faces[ 21] = new int[] { 13,  1,  5 };
    faces[ 22] = new int[] { 13,  5,  3 };
    faces[ 23] = new int[] { 13,  3,  1 };
  } //end TriakisOctahedron()

  public String name() {
    return "Triakis Octahedron";
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
   
} //end class TriakisOctahedron
