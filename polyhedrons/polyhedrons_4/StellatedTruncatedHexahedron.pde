/*
StellatedTruncatedHexahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class StellatedTruncatedHexahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 14;     // number of faces 
  final int VERTICES = 8;   // VERTICES per face
  final float C0 = 0.2071067811865475244008443621048;  //(sqrt(2) - 1) / 2
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private StellatedTruncatedHexahedron() {   
    // set vertices
    vert[  0] = new PVector(  -C0,  0.5,  -C0 );
    vert[  1] = new PVector(  -C0,  0.5,   C0 );
    vert[  2] = new PVector(  -C0, -0.5,  -C0 );
    vert[  3] = new PVector(  -C0, -0.5,   C0 );
    vert[  4] = new PVector(   C0,  0.5,  -C0 );
    vert[  5] = new PVector(   C0,  0.5,   C0 );
    vert[  6] = new PVector(   C0, -0.5,  -C0 );
    vert[  7] = new PVector(   C0, -0.5,   C0 );
    vert[  8] = new PVector(  -C0,  -C0,  0.5 );
    vert[  9] = new PVector(  -C0,  -C0, -0.5 );
    vert[ 10] = new PVector(  -C0,   C0,  0.5 );
    vert[ 11] = new PVector(  -C0,   C0, -0.5 );
    vert[ 12] = new PVector(   C0,  -C0,  0.5 );
    vert[ 13] = new PVector(   C0,  -C0, -0.5 );
    vert[ 14] = new PVector(   C0,   C0,  0.5 );
    vert[ 15] = new PVector(   C0,   C0, -0.5 );
    vert[ 16] = new PVector(  0.5,  -C0,  -C0 );
    vert[ 17] = new PVector(  0.5,  -C0,   C0 );
    vert[ 18] = new PVector(  0.5,   C0,  -C0 );
    vert[ 19] = new PVector(  0.5,   C0,   C0 );
    vert[ 20] = new PVector( -0.5,  -C0,  -C0 );
    vert[ 21] = new PVector( -0.5,  -C0,   C0 );
    vert[ 22] = new PVector( -0.5,   C0,  -C0 );
    vert[ 23] = new PVector( -0.5,   C0,   C0 );
    // set faces
    faces[ 0] = new int[] {  0,  2, 10, 11,  3,  1,  9,  8 };
    faces[ 1] = new int[] {  0, 16, 20,  4,  6, 22, 18,  2 };
    faces[ 2] = new int[] { 12, 13,  5,  7, 15, 14,  6,  4 };
    faces[ 3] = new int[] { 12, 20, 16,  8,  9, 17, 21, 13 };
    faces[ 4] = new int[] { 19, 23,  7,  5, 21, 17,  1,  3 };
    faces[ 5] = new int[] { 19, 11, 10, 18, 22, 14, 15, 23 };
    faces[ 6] = new int[] {  0,  8, 16, 16, 16, 16, 16, 16 }; //repeat 5x 3rd line to fill gaps
    faces[ 7] = new int[] {  1, 17,  9,  9,  9,  9,  9,  9 }; //repeat 5x 3rd line to fill gaps
    faces[ 8] = new int[] {  2, 18, 10, 10, 10, 10, 10, 10 }; //repeat 5x 3rd line to fill gaps
    faces[ 9] = new int[] {  3, 11, 19, 19, 19, 19, 19, 19 }; //repeat 5x 3rd line to fill gaps
    faces[10] = new int[] {  4, 20, 12, 12, 12, 12, 12, 12 }; //repeat 5x 3rd line to fill gaps
    faces[11] = new int[] {  5, 13, 21, 21, 21, 21, 21, 21 }; //repeat 5x 3rd line to fill gaps
    faces[12] = new int[] {  6, 14, 22, 22, 22, 22, 22, 22 }; //repeat 5x 3rd line to fill gaps
    faces[13] = new int[] {  7, 23, 15, 15, 15, 15, 15, 15 }; //repeat 5x 3rd line to fill gaps
  } //end StellatedTruncatedHexahedron()

  public String name() {
    return "Stellated Truncated Hexahedron";
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
   
} //end class StellatedTruncatedHexahedron
