/*
SmallDodecicosidodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDodecicosidodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 44;     // number of faces 
  final int VERTICES = 10;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C1 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  final float C2 = 1.61803398874989484820458683437;   //(1 + sqrt(5)) / 2
  final float C3 = 1.80901699437494742410229341718;   //(5 + sqrt(5)) / 4
  final float C4 = 2.11803398874989484820458683437;   //(2 + sqrt(5)) / 2
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDodecicosidodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.5,  0.5,   C4 );
    vert[  1] = new PVector(  0.5,  0.5,  -C4 );
    vert[  2] = new PVector(  0.5, -0.5,   C4 );
    vert[  3] = new PVector(  0.5, -0.5,  -C4 );
    vert[  4] = new PVector( -0.5,  0.5,   C4 );
    vert[  5] = new PVector( -0.5,  0.5,  -C4 );
    vert[  6] = new PVector( -0.5, -0.5,   C4 );
    vert[  7] = new PVector( -0.5, -0.5,  -C4 );
    vert[  8] = new PVector(   C4,  0.5,  0.5 );
    vert[  9] = new PVector(   C4,  0.5, -0.5 );
    vert[ 10] = new PVector(   C4, -0.5,  0.5 );
    vert[ 11] = new PVector(   C4, -0.5, -0.5 );
    vert[ 12] = new PVector(  -C4,  0.5,  0.5 );
    vert[ 13] = new PVector(  -C4,  0.5, -0.5 );
    vert[ 14] = new PVector(  -C4, -0.5,  0.5 );
    vert[ 15] = new PVector(  -C4, -0.5, -0.5 );
    vert[ 16] = new PVector(  0.5,   C4,  0.5 );
    vert[ 17] = new PVector(  0.5,   C4, -0.5 );
    vert[ 18] = new PVector(  0.5,  -C4,  0.5 );
    vert[ 19] = new PVector(  0.5,  -C4, -0.5 );
    vert[ 20] = new PVector( -0.5,   C4,  0.5 );
    vert[ 21] = new PVector( -0.5,   C4, -0.5 );
    vert[ 22] = new PVector( -0.5,  -C4,  0.5 );
    vert[ 23] = new PVector( -0.5,  -C4, -0.5 );
    vert[ 24] = new PVector(  0.0,   C1,   C3 );
    vert[ 25] = new PVector(  0.0,   C1,  -C3 );
    vert[ 26] = new PVector(  0.0,  -C1,   C3 );
    vert[ 27] = new PVector(  0.0,  -C1,  -C3 );
    vert[ 28] = new PVector(   C3,  0.0,   C1 );
    vert[ 29] = new PVector(   C3,  0.0,  -C1 );
    vert[ 30] = new PVector(  -C3,  0.0,   C1 );
    vert[ 31] = new PVector(  -C3,  0.0,  -C1 );
    vert[ 32] = new PVector(   C1,   C3,  0.0 );
    vert[ 33] = new PVector(   C1,  -C3,  0.0 );
    vert[ 34] = new PVector(  -C1,   C3,  0.0 );
    vert[ 35] = new PVector(  -C1,  -C3,  0.0 );
    vert[ 36] = new PVector(   C1,   C0,   C2 );
    vert[ 37] = new PVector(   C1,   C0,  -C2 );
    vert[ 38] = new PVector(   C1,  -C0,   C2 );
    vert[ 39] = new PVector(   C1,  -C0,  -C2 );
    vert[ 40] = new PVector(  -C1,   C0,   C2 );
    vert[ 41] = new PVector(  -C1,   C0,  -C2 );
    vert[ 42] = new PVector(  -C1,  -C0,   C2 );
    vert[ 43] = new PVector(  -C1,  -C0,  -C2 );
    vert[ 44] = new PVector(   C2,   C1,   C0 );
    vert[ 45] = new PVector(   C2,   C1,  -C0 );
    vert[ 46] = new PVector(   C2,  -C1,   C0 );
    vert[ 47] = new PVector(   C2,  -C1,  -C0 );
    vert[ 48] = new PVector(  -C2,   C1,   C0 );
    vert[ 49] = new PVector(  -C2,   C1,  -C0 );
    vert[ 50] = new PVector(  -C2,  -C1,   C0 );
    vert[ 51] = new PVector(  -C2,  -C1,  -C0 );
    vert[ 52] = new PVector(   C0,   C2,   C1 );
    vert[ 53] = new PVector(   C0,   C2,  -C1 );
    vert[ 54] = new PVector(   C0,  -C2,   C1 );
    vert[ 55] = new PVector(   C0,  -C2,  -C1 );
    vert[ 56] = new PVector(  -C0,   C2,   C1 );
    vert[ 57] = new PVector(  -C0,   C2,  -C1 );
    vert[ 58] = new PVector(  -C0,  -C2,   C1 );
    vert[ 59] = new PVector(  -C0,  -C2,  -C1 );
    // set faces
    faces[ 0] = new int[] {  0, 24, 56, 48, 12, 14, 50, 58, 26,  2 };
    faces[ 1] = new int[] {  0, 36, 44, 32, 17, 21, 34, 48, 40,  4 };
    faces[ 2] = new int[] {  7,  3, 39, 47, 33, 18, 22, 35, 51, 43 };
    faces[ 3] = new int[] {  7,  5, 25, 53, 45,  9, 11, 47, 55, 27 };
    faces[ 4] = new int[] { 10,  8, 44, 52, 24,  4,  6, 26, 54, 46 };
    faces[ 5] = new int[] { 10, 11, 29, 37, 53, 17, 16, 52, 36, 28 };
    faces[ 6] = new int[] { 13, 31, 43, 59, 23, 22, 58, 42, 30, 12 };
    faces[ 7] = new int[] { 13, 49, 57, 25,  1,  3, 27, 59, 51, 15 };
    faces[ 8] = new int[] { 19, 33, 46, 38,  2,  6, 42, 50, 35, 23 };
    faces[ 9] = new int[] { 19, 55, 39, 29,  9,  8, 28, 38, 54, 18 };
    faces[10] = new int[] { 20, 16, 32, 45, 37,  1,  5, 41, 49, 34 };
    faces[11] = new int[] { 20, 21, 57, 41, 31, 15, 14, 30, 40, 56 };
    faces[12] = new int[] { 24, 52, 16, 20, 56, 56, 56, 56, 56, 56 };  // repated 5x 5th number to fill gap
    faces[13] = new int[] { 25, 57, 21, 17, 53, 53, 53, 53, 53, 53 };  // repated 5x 5th number to fill gap
    faces[14] = new int[] { 26, 58, 22, 18, 54, 54, 54, 54, 54, 54 };  // repated 5x 5th number to fill gap
    faces[15] = new int[] { 27, 55, 19, 23, 59, 59, 59, 59, 59, 59 };  // repated 5x 5th number to fill gap
    faces[16] = new int[] { 28, 36,  0,  2, 38, 38, 38, 38, 38, 38 };  // repated 5x 5th number to fill gap
    faces[17] = new int[] { 29, 39,  3,  1, 37, 37, 37, 37, 37, 37 };  // repated 5x 5th number to fill gap
    faces[18] = new int[] { 30, 42,  6,  4, 40, 40, 40, 40, 40, 40 };  // repated 5x 5th number to fill gap
    faces[19] = new int[] { 31, 41,  5,  7, 43, 43, 43, 43, 43, 43 };  // repated 5x 5th number to fill gap
    faces[20] = new int[] { 32, 44,  8,  9, 45, 45, 45, 45, 45, 45 };  // repated 5x 5th number to fill gap
    faces[21] = new int[] { 33, 47, 11, 10, 46, 46, 46, 46, 46, 46 };  // repated 5x 5th number to fill gap
    faces[22] = new int[] { 34, 49, 13, 12, 48, 48, 48, 48, 48, 48 };  // repated 5x 5th number to fill gap
    faces[23] = new int[] { 35, 50, 14, 15, 51, 51, 51, 51, 51, 51 };  // repated 5x 5th number to fill gap
    faces[24] = new int[] { 24,  0,  4,  4,  4,  4,  4,  4,  4,  4 };  // repated 7x 3rd number to fill gap
    faces[25] = new int[] { 25,  5,  1,  1,  1,  1,  1,  1,  1,  1 };  // repated 7x 3rd number to fill gap
    faces[26] = new int[] { 26,  6,  2,  2,  2,  2,  2,  2,  2,  2 };  // repated 7x 3rd number to fill gap
    faces[27] = new int[] { 27,  3,  7,  7,  7,  7,  7,  7,  7,  7 };  // repated 7x 3rd number to fill gap
    faces[28] = new int[] { 28,  8, 10, 10, 10, 10, 10, 10, 10, 10 };  // repated 7x 3rd number to fill gap
    faces[29] = new int[] { 29, 11,  9,  9,  9,  9,  9,  9,  9,  9 };  // repated 7x 3rd number to fill gap
    faces[30] = new int[] { 30, 14, 12, 12, 12, 12, 12, 12, 12, 12 };  // repated 7x 3rd number to fill gap
    faces[31] = new int[] { 31, 13, 15, 15, 15, 15, 15, 15, 15, 15 };  // repated 7x 3rd number to fill gap
    faces[32] = new int[] { 32, 16, 17, 17, 17, 17, 17, 17, 17, 17 };  // repated 7x 3rd number to fill gap
    faces[33] = new int[] { 33, 19, 18, 18, 18, 18, 18, 18, 18, 18 };  // repated 7x 3rd number to fill gap
    faces[34] = new int[] { 34, 21, 20, 20, 20, 20, 20, 20, 20, 20 };  // repated 7x 3rd number to fill gap
    faces[35] = new int[] { 35, 22, 23, 23, 23, 23, 23, 23, 23, 23 };  // repated 7x 3rd number to fill gap
    faces[36] = new int[] { 36, 52, 44, 44, 44, 44, 44, 44, 44, 44 };  // repated 7x 3rd number to fill gap
    faces[37] = new int[] { 37, 45, 53, 53, 53, 53, 53, 53, 53, 53 };  // repated 7x 3rd number to fill gap
    faces[38] = new int[] { 38, 46, 54, 54, 54, 54, 54, 54, 54, 54 };  // repated 7x 3rd number to fill gap
    faces[39] = new int[] { 39, 55, 47, 47, 47, 47, 47, 47, 47, 47 };  // repated 7x 3rd number to fill gap
    faces[40] = new int[] { 40, 48, 56, 56, 56, 56, 56, 56, 56, 56 };  // repated 7x 3rd number to fill gap
    faces[41] = new int[] { 41, 57, 49, 49, 49, 49, 49, 49, 49, 49 };  // repated 7x 3rd number to fill gap
    faces[42] = new int[] { 42, 58, 50, 50, 50, 50, 50, 50, 50, 50 };  // repated 7x 3rd number to fill gap
    faces[43] = new int[] { 43, 51, 59, 59, 59, 59, 59, 59, 59, 59 };  // repated 7x 3rd number to fill gap
  } //end SmallDodecicosidodecahedron()

  public String name() {
    return "Small Dodecicosidodecahedron";
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
   
} //end class SmallDodecicosidodecahedron
