/*
SmallIcosihemidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallIcosihemidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 26;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183; //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718;  //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallIcosihemidodecahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0,  0.0,   C2 );
    vert[ 1] = new PVector(  0.0,  0.0,  -C2 );
    vert[ 2] = new PVector(   C2,  0.0,  0.0 );
    vert[ 3] = new PVector(  -C2,  0.0,  0.0 );
    vert[ 4] = new PVector(  0.0,   C2,  0.0 );
    vert[ 5] = new PVector(  0.0,  -C2,  0.0 );
    vert[ 6] = new PVector(  0.5,   C0,   C1 );
    vert[ 7] = new PVector(  0.5,   C0,  -C1 );
    vert[ 8] = new PVector(  0.5,  -C0,   C1 );
    vert[ 9] = new PVector(  0.5,  -C0,  -C1 );
    vert[10] = new PVector( -0.5,   C0,   C1 );
    vert[11] = new PVector( -0.5,   C0,  -C1 );
    vert[12] = new PVector( -0.5,  -C0,   C1 );
    vert[13] = new PVector( -0.5,  -C0,  -C1 );
    vert[14] = new PVector(   C1,  0.5,   C0 );
    vert[15] = new PVector(   C1,  0.5,  -C0 );
    vert[16] = new PVector(   C1, -0.5,   C0 );
    vert[17] = new PVector(   C1, -0.5,  -C0 );
    vert[18] = new PVector(  -C1,  0.5,   C0 );
    vert[19] = new PVector(  -C1,  0.5,  -C0 );
    vert[20] = new PVector(  -C1, -0.5,   C0 );
    vert[21] = new PVector(  -C1, -0.5,  -C0 );
    vert[22] = new PVector(   C0,   C1,  0.5 );
    vert[23] = new PVector(   C0,   C1, -0.5 );
    vert[24] = new PVector(   C0,  -C1,  0.5 );
    vert[25] = new PVector(   C0,  -C1, -0.5 );
    vert[26] = new PVector(  -C0,   C1,  0.5 );
    vert[27] = new PVector(  -C0,   C1, -0.5 );
    vert[28] = new PVector(  -C0,  -C1,  0.5 );
    vert[29] = new PVector(  -C0,  -C1, -0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  6, 22, 23,  7,  1, 13, 29, 28, 12 };
    faces[ 1] = new int[] {  0,  8, 24, 25,  9,  1, 11, 27, 26, 10 };
    faces[ 2] = new int[] {  2, 14,  6, 10, 18,  3, 21, 13,  9, 17 };
    faces[ 3] = new int[] {  2, 15,  7, 11, 19,  3, 20, 12,  8, 16 };
    faces[ 4] = new int[] {  4, 22, 14, 16, 24,  5, 29, 21, 19, 27 };
    faces[ 5] = new int[] {  4, 23, 15, 17, 25,  5, 28, 20, 18, 26 };
    faces[ 6] = new int[] {  0,  6, 10, 10, 10, 10, 10, 10, 10, 10 }; //added 7x 3rd number to fill gap
    faces[ 7] = new int[] {  0, 12,  8,  8,  8,  8,  8,  8,  8,  8 }; //added 7x 3rd number to fill gap
    faces[ 8] = new int[] {  1,  9, 13, 13, 13, 13, 13, 13, 13, 13 }; //added 7x 3rd number to fill gap
    faces[ 9] = new int[] {  1, 11,  7,  7,  7,  7,  7,  7,  7,  7 }; //added 7x 3rd number to fill gap
    faces[10] = new int[] { 14, 16,  2,  2,  2,  2,  2,  2,  2,  2 }; //added 7x 3rd number to fill gap
    faces[11] = new int[] { 14, 22,  6,  6,  6,  6,  6,  6,  6,  6 }; //added 7x 3rd number to fill gap
    faces[12] = new int[] { 17, 15,  2,  2,  2,  2,  2,  2,  2,  2 }; //added 7x 3rd number to fill gap
    faces[13] = new int[] { 17, 25,  9,  9,  9,  9,  9,  9,  9,  9 }; //added 7x 3rd number to fill gap
    faces[14] = new int[] { 19, 21,  3,  3,  3,  3,  3,  3,  3,  3 }; //added 7x 3rd number to fill gap
    faces[15] = new int[] { 19, 27, 11, 11, 11, 11, 11, 11, 11, 11 }; //added 7x 3rd number to fill gap
    faces[16] = new int[] { 20, 18,  3,  3,  3,  3,  3,  3,  3,  3 }; //added 7x 3rd number to fill gap
    faces[17] = new int[] { 20, 28, 12, 12, 12, 12, 12, 12, 12, 12 }; //added 7x 3rd number to fill gap
    faces[18] = new int[] { 23,  4, 22, 22, 22, 22, 22, 22, 22, 22 }; //added 7x 3rd number to fill gap
    faces[19] = new int[] { 23, 15,  7,  7,  7,  7,  7,  7,  7,  7 }; //added 7x 3rd number to fill gap
    faces[20] = new int[] { 24,  5, 25, 25, 25, 25, 25, 25, 25, 25 }; //added 7x 3rd number to fill gap
    faces[21] = new int[] { 24, 16,  8,  8,  8,  8,  8,  8,  8,  8 }; //added 7x 3rd number to fill gap
    faces[22] = new int[] { 26,  4, 27, 27, 27, 27, 27, 27, 27, 27 }; //added 7x 3rd number to fill gap
    faces[23] = new int[] { 26, 18, 10, 10, 10, 10, 10, 10, 10, 10 }; //added 7x 3rd number to fill gap
    faces[24] = new int[] { 29,  5, 28, 28, 28, 28, 28, 28, 28, 28 }; //added 7x 3rd number to fill gap
    faces[25] = new int[] { 29, 21, 13, 13, 13, 13, 13, 13, 13, 13 }; //added 7x 3rd number to fill gap
  } //end SmallIcosihemidodecahedron()

  public String name() {
    return "Small Icosihemidodecahedron";
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
   
} //end class SmallIcosihemidodecahedron
