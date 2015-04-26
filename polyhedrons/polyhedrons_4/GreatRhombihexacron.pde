/*
GreatRhombihexacron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatRhombihexacron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.585786437626904951198311275790;  //2 - sqrt(2)
  private PVector[] vert = new PVector[18]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatRhombihexacron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,   C0 );
    vert[  1] = new PVector(  0.0,  0.0,  -C0 );
    vert[  2] = new PVector(   C0,  0.0,  0.0 );
    vert[  3] = new PVector(  -C0,  0.0,  0.0 );
    vert[  4] = new PVector(  0.0,   C0,  0.0 );
    vert[  5] = new PVector(  0.0,  -C0,  0.0 );
    vert[  6] = new PVector(  1.0,  0.0,  1.0 );
    vert[  7] = new PVector(  1.0,  0.0, -1.0 );
    vert[  8] = new PVector( -1.0,  0.0,  1.0 );
    vert[  9] = new PVector( -1.0,  0.0, -1.0 );
    vert[ 10] = new PVector(  1.0,  1.0,  0.0 );
    vert[ 11] = new PVector(  1.0, -1.0,  0.0 );
    vert[ 12] = new PVector( -1.0,  1.0,  0.0 );
    vert[ 13] = new PVector( -1.0, -1.0,  0.0 );
    vert[ 14] = new PVector(  0.0,  1.0,  1.0 );
    vert[ 15] = new PVector(  0.0,  1.0, -1.0 );
    vert[ 16] = new PVector(  0.0, -1.0,  1.0 );
    vert[ 17] = new PVector(  0.0, -1.0, -1.0 );
    // set faces
    faces[ 0] = new int[] { 0, 10,  2, 14 };
    faces[ 1] = new int[] { 0, 11,  5,  6 };
    faces[ 2] = new int[] { 0, 12,  4,  8 };
    faces[ 3] = new int[] { 0, 13,  3, 16 };
    faces[ 4] = new int[] { 1, 10,  4,  7 };
    faces[ 5] = new int[] { 1, 11,  2, 17 };
    faces[ 6] = new int[] { 1, 12,  3, 15 };
    faces[ 7] = new int[] { 1, 13,  5,  9 };
    faces[ 8] = new int[] { 2, 14,  4,  6 };
    faces[ 9] = new int[] { 2, 15,  1, 10 };
    faces[10] = new int[] { 2, 16,  0, 11 };
    faces[11] = new int[] { 2, 17,  5,  7 };
    faces[12] = new int[] { 3, 14,  0, 12 };
    faces[13] = new int[] { 3, 15,  4,  9 };
    faces[14] = new int[] { 3, 16,  5,  8 };
    faces[15] = new int[] { 3, 17,  1, 13 };
    faces[16] = new int[] { 4,  6,  0, 10 };
    faces[17] = new int[] { 4,  7,  2, 15 };
    faces[18] = new int[] { 4,  8,  3, 14 };
    faces[19] = new int[] { 4,  9,  1, 12 };
    faces[20] = new int[] { 5,  6,  2, 16 };
    faces[21] = new int[] { 5,  7,  1, 11 };
    faces[22] = new int[] { 5,  8,  0, 13 };
    faces[23] = new int[] { 5,  9,  3, 17 };
  } //end GreatRhombihexacron()

  public String name() {
    return "Great Rhombihexacron";
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
   
} //end class GreatRhombihexacron
