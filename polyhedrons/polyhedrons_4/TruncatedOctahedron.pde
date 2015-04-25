/*
TruncatedOctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TruncatedOctahedron extends Polyhedron {

  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 6;  // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048; //sqrt(2) / 2
  final float C1 = 1.41421356237309504880168872421;   //sqrt(2)
  PVector[] vert = new PVector[24]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private TruncatedOctahedron() {   
    // set vertices
    vert[ 0] = new PVector( C0, 0.0,  C1);
    vert[ 1] = new PVector( C0, 0.0, -C1);
    vert[ 2] = new PVector(-C0, 0.0,  C1);
    vert[ 3] = new PVector(-C0, 0.0, -C1);
    vert[ 4] = new PVector( C1,  C0, 0.0);
    vert[ 5] = new PVector( C1, -C0, 0.0);
    vert[ 6] = new PVector(-C1,  C0, 0.0);
    vert[ 7] = new PVector(-C1, -C0, 0.0);
    vert[ 8] = new PVector(0.0,  C1,  C0);
    vert[ 9] = new PVector(0.0,  C1, -C0);
    vert[10] = new PVector(0.0, -C1,  C0);
    vert[11] = new PVector(0.0, -C1, -C0);  
    vert[12] = new PVector(0.0,  C0,  C1);
    vert[13] = new PVector(0.0,  C0, -C1);
    vert[14] = new PVector(0.0, -C0,  C1);
    vert[15] = new PVector(0.0, -C0, -C1);
    vert[16] = new PVector( C1, 0.0,  C0);
    vert[17] = new PVector( C1, 0.0, -C0);
    vert[18] = new PVector(-C1, 0.0,  C0);
    vert[19] = new PVector(-C1, 0.0, -C0);
    vert[20] = new PVector( C0,  C1, 0.0);
    vert[21] = new PVector( C0, -C1, 0.0);
    vert[22] = new PVector(-C0,  C1, 0.0);
    vert[23] = new PVector(-C0, -C1, 0.0);
    // set faces
    faces[ 0] = new int[] { 0, 14, 10, 21,  5, 16};
    faces[ 1] = new int[] { 1, 13,  9, 20,  4, 17};
    faces[ 2] = new int[] { 2, 12,  8, 22,  6, 18};
    faces[ 3] = new int[] { 3, 15, 11, 23,  7, 19};
    faces[ 4] = new int[] { 4, 20,  8, 12,  0, 16};  
    faces[ 5] = new int[] { 5, 21, 11, 15,  1, 17};
    faces[ 6] = new int[] { 7, 23, 10, 14,  2, 18};
    faces[ 7] = new int[] { 6, 22,  9, 13,  3, 19};
    faces[ 8] = new int[] { 0, 12,  2, 14, 14, 14}; //added 2x 4th number to fill gap
    faces[ 9] = new int[] { 1, 15,  3, 13, 13, 13}; //added 2x 4th number to fill gap
    faces[10] = new int[] { 4, 16,  5, 17, 17, 17}; //added 2x 4th number to fill gap
    faces[11] = new int[] { 6, 19,  7, 18, 18, 18}; //added 2x 4th number to fill gap
    faces[12] = new int[] { 8, 20,  9, 22, 22, 22}; //added 2x 4th number to fill gap
    faces[13] = new int[] {10, 23, 11, 21, 21, 21}; //added 2x 4th number to fill gap
  } //end TruncatedOctahedron()

  public String name() {
    return "Truncated Octahedron";
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

} //end class TruncatedOctahedron
