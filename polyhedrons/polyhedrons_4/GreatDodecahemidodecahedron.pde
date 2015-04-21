/*
GreatDodecahemidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDodecahemidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 18;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817; //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183; //(sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366; //(sqrt(5) - 1) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDodecahemidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0,  0.0,   C2 );
    vert[ 1] = new PVector(  0.0,  0.0,  -C2 );
    vert[ 2] = new PVector(  0.0,   C2,  0.0 );
    vert[ 3] = new PVector(  0.0,  -C2,  0.0 );
    vert[ 4] = new PVector(   C2,  0.0,  0.0 );
    vert[ 5] = new PVector(  -C2,  0.0,  0.0 );
    vert[ 6] = new PVector(   C1, -0.5,  -C0 );
    vert[ 7] = new PVector(   C1, -0.5,   C0 );
    vert[ 8] = new PVector(  -C1, -0.5,  -C0 );
    vert[ 9] = new PVector(  -C1, -0.5,   C0 );
    vert[10] = new PVector(   C1,  0.5,  -C0 );
    vert[11] = new PVector(   C1,  0.5,   C0 );
    vert[12] = new PVector(  -C1,  0.5,  -C0 );
    vert[13] = new PVector(  -C1,  0.5,   C0 );
    vert[14] = new PVector( -0.5,  -C0,   C1 );
    vert[15] = new PVector( -0.5,  -C0,  -C1 );
    vert[16] = new PVector(  0.5,  -C0,   C1 );
    vert[17] = new PVector(  0.5,  -C0,  -C1 );
    vert[18] = new PVector( -0.5,   C0,   C1 );
    vert[19] = new PVector( -0.5,   C0,  -C1 );
    vert[20] = new PVector(  0.5,   C0,   C1 );
    vert[21] = new PVector(  0.5,   C0,  -C1 );
    vert[22] = new PVector(  -C0,   C1, -0.5 );
    vert[23] = new PVector(  -C0,   C1,  0.5 );
    vert[24] = new PVector(   C0,   C1, -0.5 );
    vert[25] = new PVector(   C0,   C1,  0.5 );
    vert[26] = new PVector(  -C0,  -C1, -0.5 );
    vert[27] = new PVector(  -C0,  -C1,  0.5 );
    vert[28] = new PVector(   C0,  -C1, -0.5 );
    vert[29] = new PVector(   C0,  -C1,  0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  6, 22, 23,  7,  1, 13, 29, 28, 12 };
    faces[ 1] = new int[] {  0,  8, 24, 25,  9,  1, 11, 27, 26, 10 };
    faces[ 2] = new int[] {  2, 14,  6, 10, 18,  3, 21, 13,  9, 17 };
    faces[ 3] = new int[] {  2, 15,  7, 11, 19,  3, 20, 12,  8, 16 };
    faces[ 4] = new int[] {  4, 22, 14, 16, 24,  5, 29, 21, 19, 27 };
    faces[ 5] = new int[] {  4, 23, 15, 17, 25,  5, 28, 20, 18, 26 };
    faces[ 6] = new int[] {  0,  8, 16, 14,  6,  6,  6,  6,  6,  6 }; //added 5x 5th number to fill gap
    faces[ 7] = new int[] {  0, 10, 18, 20, 12, 12, 12, 12, 12, 12 }; //added 5x 5th number to fill gap
    faces[ 8] = new int[] {  1,  7, 15, 17,  9,  9,  9,  9,  9,  9 }; //added 5x 5th number to fill gap
    faces[ 9] = new int[] {  1, 13, 21, 19, 11, 11, 11, 11, 11, 11 }; //added 5x 5th number to fill gap
    faces[10] = new int[] {  2, 15, 23, 22, 14, 14, 14, 14, 14, 14 }; //added 5x 5th number to fill gap
    faces[11] = new int[] {  2, 16, 24, 25, 17, 17, 17, 17, 17, 17 }; //added 5x 5th number to fill gap
    faces[12] = new int[] {  3, 18, 26, 27, 19, 19, 19, 19, 19, 19 }; //added 5x 5th number to fill gap
    faces[13] = new int[] {  3, 21, 29, 28, 20, 20, 20, 20, 20, 20 }; //added 5x 5th number to fill gap
    faces[14] = new int[] {  4, 23,  7, 11, 27, 27, 27, 27, 27, 27 }; //added 5x 5th number to fill gap
    faces[15] = new int[] {  4, 26, 10,  6, 22, 22, 22, 22, 22, 22 }; //added 5x 5th number to fill gap
    faces[16] = new int[] {  5, 24,  8, 12, 28, 28, 28, 28, 28, 28 }; //added 5x 5th number to fill gap
    faces[17] = new int[] {  5, 29, 13,  9, 25, 25, 25, 25, 25, 25 }; //added 5x 5th number to fill gap
  } //end GreatDodecahemidodecahedron()

  public String name() {
    return "Great Dodecahemidodecahedron";
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
   
} //end class GreatDodecahemidodecahedron
