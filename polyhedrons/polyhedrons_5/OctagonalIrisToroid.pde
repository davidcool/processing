/*
OctagonalIrisToroid class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class OctagonalIrisToroid extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 1.20710678118654752440084436210; //(1 + sqrt(2)) / 2
  private PVector[] vert = new PVector[16]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private OctagonalIrisToroid() {   
    // set vertices
    vert[ 0] = new PVector(  C0,  0.5,  0.5);
    vert[ 1] = new PVector(  C0,  0.5, -0.5);
    vert[ 2] = new PVector(  C0, -0.5,  0.5);
    vert[ 3] = new PVector(  C0, -0.5, -0.5);
    vert[ 4] = new PVector( -C0,  0.5,  0.5);
    vert[ 5] = new PVector( -C0,  0.5, -0.5);
    vert[ 6] = new PVector( -C0, -0.5,  0.5);
    vert[ 7] = new PVector( -C0, -0.5, -0.5);
    vert[ 8] = new PVector( 0.5,   C0,  0.5);
    vert[ 9] = new PVector( 0.5,   C0, -0.5);
    vert[10] = new PVector( 0.5,  -C0,  0.5);
    vert[11] = new PVector( 0.5,  -C0, -0.5);
    vert[12] = new PVector(-0.5,   C0,  0.5);
    vert[13] = new PVector(-0.5,   C0, -0.5);
    vert[14] = new PVector(-0.5,  -C0,  0.5);
    vert[15] = new PVector(-0.5,  -C0, -0.5);
    // set faces
    faces[ 0] = new int[] {  0,  1,  9,  8 };
    faces[ 1] = new int[] {  8,  9, 13, 12 };
    faces[ 2] = new int[] { 12, 13,  5,  4 };
    faces[ 3] = new int[] {  4,  5,  7,  6 };
    faces[ 4] = new int[] {  6,  7, 15, 14 };
    faces[ 5] = new int[] { 14, 15, 11, 10 };
    faces[ 6] = new int[] { 10, 11,  3,  2 };
    faces[ 7] = new int[] {  2,  3,  1,  0 };
    faces[ 8] = new int[] {  0, 11, 15, 15 }; //added 1x 3rd number to fill gap
    faces[ 9] = new int[] {  0, 15,  2,  2 }; //added 1x 3rd number to fill gap
    faces[10] = new int[] {  2, 15,  7,  7 }; //added 1x 3rd number to fill gap
    faces[11] = new int[] {  2,  7, 10, 10 }; //added 1x 3rd number to fill gap
    faces[12] = new int[] {  4,  9,  1,  1 }; //added 1x 3rd number to fill gap
    faces[13] = new int[] {  4,  1, 12, 12 }; //added 1x 3rd number to fill gap
    faces[14] = new int[] {  6, 13,  9,  9 }; //added 1x 3rd number to fill gap
    faces[15] = new int[] {  6,  9,  4,  4 }; //added 1x 3rd number to fill gap
    faces[16] = new int[] {  8,  3, 11, 11 }; //added 1x 3rd number to fill gap
    faces[17] = new int[] {  8, 11,  0,  0 }; //added 1x 3rd number to fill gap
    faces[18] = new int[] { 10,  7,  5,  5 }; //added 1x 3rd number to fill gap
    faces[19] = new int[] { 10,  5, 14, 14 }; //added 1x 3rd number to fill gap
    faces[20] = new int[] { 12,  1,  3,  3 }; //added 1x 3rd number to fill gap
    faces[21] = new int[] { 12,  3,  8,  8 }; //added 1x 3rd number to fill gap
    faces[22] = new int[] { 14, 13,  6,  6 }; //added 1x 3rd number to fill gap
    faces[23] = new int[] { 14,  5, 13, 13 }; //added 1x 3rd number to fill gap
  } //end OctagonalIrisToroid()

  public String name() {
    return "Octagonal Iris Toroid";
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
   
} //end class OctagonalIrisToroid
