/*
TetrakisHexahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TetrakisHexahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 1.06066017177982128660126654316;  //3 * sqrt(2) / 4
  final float C1 = 1.59099025766973192990189981474;  //9 * sqrt(2) / 8
  private PVector[] vert = new PVector[14]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TetrakisHexahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, 0.0,  C1 );
    vert[  1] = new PVector( 0.0, 0.0, -C1 );
    vert[  2] = new PVector(  C1, 0.0, 0.0 );
    vert[  3] = new PVector( -C1, 0.0, 0.0 );
    vert[  4] = new PVector( 0.0,  C1, 0.0 );
    vert[  5] = new PVector( 0.0, -C1, 0.0 );
    vert[  6] = new PVector(  C0,  C0,  C0 );
    vert[  7] = new PVector(  C0,  C0, -C0 );
    vert[  8] = new PVector(  C0, -C0,  C0 );
    vert[  9] = new PVector(  C0, -C0, -C0 );
    vert[ 10] = new PVector( -C0,  C0,  C0 );
    vert[ 11] = new PVector( -C0,  C0, -C0 );
    vert[ 12] = new PVector( -C0, -C0,  C0 );
    vert[ 13] = new PVector( -C0, -C0, -C0 );
    // set faces
    faces[  0] = new int[] { 0,  6, 10 };
    faces[  1] = new int[] { 0, 10, 12 };
    faces[  2] = new int[] { 0, 12,  8 };
    faces[  3] = new int[] { 0,  8,  6 };
    faces[  4] = new int[] { 1,  7,  9 };
    faces[  5] = new int[] { 1,  9, 13 };
    faces[  6] = new int[] { 1, 13, 11 };
    faces[  7] = new int[] { 1, 11,  7 };
    faces[  8] = new int[] { 2,  6,  8 };
    faces[  9] = new int[] { 2,  8,  9 };
    faces[ 10] = new int[] { 2,  9,  7 };
    faces[ 11] = new int[] { 2,  7,  6 };
    faces[ 12] = new int[] { 3, 10, 11 };
    faces[ 13] = new int[] { 3, 11, 13 };
    faces[ 14] = new int[] { 3, 13, 12 };
    faces[ 15] = new int[] { 3, 12, 10 };
    faces[ 16] = new int[] { 4,  6,  7 };
    faces[ 17] = new int[] { 4,  7, 11 };
    faces[ 18] = new int[] { 4, 11, 10 };
    faces[ 19] = new int[] { 4, 10,  6 };
    faces[ 20] = new int[] { 5,  8, 12 };
    faces[ 21] = new int[] { 5, 12, 13 };
    faces[ 22] = new int[] { 5, 13,  9 };
    faces[ 23] = new int[] { 5,  9,  8 };
  } //end TetrakisHexahedron()

  public String name() {
    return "Tetrakis Hexahedron";
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
   
} //end class TetrakisHexahedron
