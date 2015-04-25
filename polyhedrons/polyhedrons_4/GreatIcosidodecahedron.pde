/*
GreatIcosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatIcosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 32;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817;  //3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183;  //sqrt(5) - 1) / 4
  final float C2 = 0.618033988749894848204586834366;  //sqrt(5) - 1) / 2
   private PVector[] vert = new PVector[30]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatIcosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,   C2 );
    vert[  1] = new PVector(  0.0,  0.0,  -C2 );
    vert[  2] = new PVector(  0.0,   C2,  0.0 );
    vert[  3] = new PVector(  0.0,  -C2,  0.0 );
    vert[  4] = new PVector(   C2,  0.0,  0.0 );
    vert[  5] = new PVector(  -C2,  0.0,  0.0 );
    vert[  6] = new PVector(   C1, -0.5,  -C0 );
    vert[  7] = new PVector(   C1, -0.5,   C0 );
    vert[  8] = new PVector(  -C1, -0.5,  -C0 );
    vert[  9] = new PVector(  -C1, -0.5,   C0 );
    vert[ 10] = new PVector(   C1,  0.5,  -C0 );
    vert[ 11] = new PVector(   C1,  0.5,   C0 );
    vert[ 12] = new PVector(  -C1,  0.5,  -C0 );
    vert[ 13] = new PVector(  -C1,  0.5,   C0 );
    vert[ 14] = new PVector( -0.5,  -C0,   C1 );
    vert[ 15] = new PVector( -0.5,  -C0,  -C1 );
    vert[ 16] = new PVector(  0.5,  -C0,   C1 );
    vert[ 17] = new PVector(  0.5,  -C0,  -C1 );
    vert[ 18] = new PVector( -0.5,   C0,   C1 );
    vert[ 19] = new PVector( -0.5,   C0,  -C1 );
    vert[ 20] = new PVector(  0.5,   C0,   C1 );
    vert[ 21] = new PVector(  0.5,   C0,  -C1 );
    vert[ 22] = new PVector(  -C0,   C1, -0.5 );
    vert[ 23] = new PVector(  -C0,   C1,  0.5 );
    vert[ 24] = new PVector(   C0,   C1, -0.5 );
    vert[ 25] = new PVector(   C0,   C1,  0.5 );
    vert[ 26] = new PVector(  -C0,  -C1, -0.5 );
    vert[ 27] = new PVector(  -C0,  -C1,  0.5 );
    vert[ 28] = new PVector(   C0,  -C1, -0.5 );
    vert[ 29] = new PVector(   C0,  -C1,  0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  8, 16, 14,  6 };
    faces[ 1] = new int[] {  0, 10, 18, 20, 12 };
    faces[ 2] = new int[] {  1,  7, 15, 17,  9 };
    faces[ 3] = new int[] {  1, 13, 21, 19, 11 };
    faces[ 4] = new int[] {  2, 15, 23, 22, 14 };
    faces[ 5] = new int[] {  2, 16, 24, 25, 17 };
    faces[ 6] = new int[] {  3, 18, 26, 27, 19 };
    faces[ 7] = new int[] {  3, 21, 29, 28, 20 };
    faces[ 8] = new int[] {  4, 23,  7, 11, 27 };
    faces[ 9] = new int[] {  4, 26, 10,  6, 22 };
    faces[10] = new int[] {  5, 24,  8, 12, 28 };
    faces[11] = new int[] {  5, 29, 13,  9, 25 };
    faces[12] = new int[] {  0,  6, 10, 10, 10 };  // added 2x 3rd number to fill gap
    faces[13] = new int[] {  0, 12,  8,  8,  8 };  // added 2x 3rd number to fill gap
    faces[14] = new int[] {  1,  9, 13, 13, 13 };  // added 2x 3rd number to fill gap
    faces[15] = new int[] {  1, 11,  7,  7,  7 };  // added 2x 3rd number to fill gap
    faces[16] = new int[] {  2, 14, 16, 16, 16 };  // added 2x 3rd number to fill gap
    faces[17] = new int[] {  2, 17, 15, 15, 15 };  // added 2x 3rd number to fill gap
    faces[18] = new int[] {  3, 19, 21, 21, 21 };  // added 2x 3rd number to fill gap
    faces[19] = new int[] {  3, 20, 18, 18, 18 };  // added 2x 3rd number to fill gap
    faces[20] = new int[] {  4, 22, 23, 23, 23 };  // added 2x 3rd number to fill gap
    faces[21] = new int[] {  4, 27, 26, 26, 26 };  // added 2x 3rd number to fill gap
    faces[22] = new int[] {  5, 25, 24, 24, 24 };  // added 2x 3rd number to fill gap
    faces[23] = new int[] {  5, 28, 29, 29, 29 };  // added 2x 3rd number to fill gap
    faces[24] = new int[] {  6, 14, 22, 22, 22 };  // added 2x 3rd number to fill gap
    faces[25] = new int[] {  7, 23, 15, 15, 15 };  // added 2x 3rd number to fill gap
    faces[26] = new int[] {  8, 24, 16, 16, 16 };  // added 2x 3rd number to fill gap
    faces[27] = new int[] {  9, 17, 25, 25, 25 };  // added 2x 3rd number to fill gap
    faces[28] = new int[] { 10, 26, 18, 18, 18 };  // added 2x 3rd number to fill gap
    faces[29] = new int[] { 11, 19, 27, 27, 27 };  // added 2x 3rd number to fill gap
    faces[30] = new int[] { 12, 20, 28, 28, 28 };  // added 2x 3rd number to fill gap
    faces[31] = new int[] { 13, 29, 21, 21, 21 };  // added 2x 3rd number to fill gap
  } //end GreatIcosidodecahedron  //added 2x 3rd number to fill gap()

  public String name() {
    return "Great Icosidodecahedron";
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
   
} //end class GreatIcosidodecahedron
