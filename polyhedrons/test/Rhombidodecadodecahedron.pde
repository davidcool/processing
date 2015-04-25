/*
Rhombidodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Rhombidodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 54;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.190983005625052575897706582817;  //(3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C2 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  final float C3 = 1.11803398874989484820458683437;   //sqrt(5) / 2
  final float C4 = 1.30901699437494742410229341718;   //(3 + sqrt(5)) / 4
  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Rhombidodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  0.0,   C4 );
    vert[  1] = new PVector(   C0,  0.0,  -C4 );
    vert[  2] = new PVector(  -C0,  0.0,   C4 );
    vert[  3] = new PVector(  -C0,  0.0,  -C4 );
    vert[  4] = new PVector(   C4,   C0,  0.0 );
    vert[  5] = new PVector(   C4,  -C0,  0.0 );
    vert[  6] = new PVector(  -C4,   C0,  0.0 );
    vert[  7] = new PVector(  -C4,  -C0,  0.0 );
    vert[  8] = new PVector(  0.0,   C4,   C0 );
    vert[  9] = new PVector(  0.0,   C4,  -C0 );
    vert[ 10] = new PVector(  0.0,  -C4,   C0 );
    vert[ 11] = new PVector(  0.0,  -C4,  -C0 );
    vert[ 12] = new PVector(  0.5,  0.5,   C3 );
    vert[ 13] = new PVector(  0.5,  0.5,  -C3 );
    vert[ 14] = new PVector(  0.5, -0.5,   C3 );
    vert[ 15] = new PVector(  0.5, -0.5,  -C3 );
    vert[ 16] = new PVector( -0.5,  0.5,   C3 );
    vert[ 17] = new PVector( -0.5,  0.5,  -C3 );
    vert[ 18] = new PVector( -0.5, -0.5,   C3 );
    vert[ 19] = new PVector( -0.5, -0.5,  -C3 );
    vert[ 20] = new PVector(   C3,  0.5,  0.5 );
    vert[ 21] = new PVector(   C3,  0.5, -0.5 );
    vert[ 22] = new PVector(   C3, -0.5,  0.5 );
    vert[ 23] = new PVector(   C3, -0.5, -0.5 );
    vert[ 24] = new PVector(  -C3,  0.5,  0.5 );
    vert[ 25] = new PVector(  -C3,  0.5, -0.5 );
    vert[ 26] = new PVector(  -C3, -0.5,  0.5 );
    vert[ 27] = new PVector(  -C3, -0.5, -0.5 );
    vert[ 28] = new PVector(  0.5,   C3,  0.5 );
    vert[ 29] = new PVector(  0.5,   C3, -0.5 );
    vert[ 30] = new PVector(  0.5,  -C3,  0.5 );
    vert[ 31] = new PVector(  0.5,  -C3, -0.5 );
    vert[ 32] = new PVector( -0.5,   C3,  0.5 );
    vert[ 33] = new PVector( -0.5,   C3, -0.5 );
    vert[ 34] = new PVector( -0.5,  -C3,  0.5 );
    vert[ 35] = new PVector( -0.5,  -C3, -0.5 );
    vert[ 36] = new PVector(   C1,   C2,  1.0 );
    vert[ 37] = new PVector(   C1,   C2, -1.0 );
    vert[ 38] = new PVector(   C1,  -C2,  1.0 );
    vert[ 39] = new PVector(   C1,  -C2, -1.0 );
    vert[ 40] = new PVector(  -C1,   C2,  1.0 );
    vert[ 41] = new PVector(  -C1,   C2, -1.0 );
    vert[ 42] = new PVector(  -C1,  -C2,  1.0 );
    vert[ 43] = new PVector(  -C1,  -C2, -1.0 );
    vert[ 44] = new PVector(  1.0,   C1,   C2 );
    vert[ 45] = new PVector(  1.0,   C1,  -C2 );
    vert[ 46] = new PVector(  1.0,  -C1,   C2 );
    vert[ 47] = new PVector(  1.0,  -C1,  -C2 );
    vert[ 48] = new PVector( -1.0,   C1,   C2 );
    vert[ 49] = new PVector( -1.0,   C1,  -C2 );
    vert[ 50] = new PVector( -1.0,  -C1,   C2 );
    vert[ 51] = new PVector( -1.0,  -C1,  -C2 );
    vert[ 52] = new PVector(   C2,  1.0,   C1 );
    vert[ 53] = new PVector(   C2,  1.0,  -C1 );
    vert[ 54] = new PVector(   C2, -1.0,   C1 );
    vert[ 55] = new PVector(   C2, -1.0,  -C1 );
    vert[ 56] = new PVector(  -C2,  1.0,   C1 );
    vert[ 57] = new PVector(  -C2,  1.0,  -C1 );
    vert[ 58] = new PVector(  -C2, -1.0,   C1 );
    vert[ 59] = new PVector(  -C2, -1.0,  -C1 );
    // set faces
    faces[ 0] = new int[] {  0, 40, 24, 26, 42 };
    faces[ 1] = new int[] {  1, 43, 27, 25, 41 };
    faces[ 2] = new int[] {  2, 38, 22, 20, 36 };
    faces[ 3] = new int[] {  3, 37, 21, 23, 39 };
    faces[ 4] = new int[] {  4, 46, 30, 31, 47 };
    faces[ 5] = new int[] {  5, 45, 29, 28, 44 };
    faces[ 6] = new int[] {  6, 51, 35, 34, 50 };
    faces[ 7] = new int[] {  7, 48, 32, 33, 49 };
    faces[ 8] = new int[] {  8, 53, 13, 17, 57 };
    faces[ 9] = new int[] {  9, 56, 16, 12, 52 };
    faces[10] = new int[] { 10, 59, 19, 15, 55 };
    faces[11] = new int[] { 11, 54, 14, 18, 58 };
    faces[12] = new int[] {  0, 46, 12, 14, 44 };
    faces[13] = new int[] {  1, 45, 15, 13, 47 };
    faces[14] = new int[] {  2, 48, 18, 16, 50 };
    faces[15] = new int[] {  3, 51, 17, 19, 49 };
    faces[16] = new int[] {  4, 53, 20, 21, 52 };
    faces[17] = new int[] {  5, 54, 23, 22, 55 };
    faces[18] = new int[] {  6, 56, 25, 24, 57 };
    faces[19] = new int[] {  7, 59, 26, 27, 58 };
    faces[20] = new int[] {  8, 40, 28, 32, 36 };
    faces[21] = new int[] {  9, 37, 33, 29, 41 };
    faces[22] = new int[] { 10, 38, 34, 30, 42 };
    faces[23] = new int[] { 11, 43, 31, 35, 39 };
    faces[24] = new int[] {  0, 42, 30, 46, 46 };  // repated 1x 4th number to fill gap
    faces[25] = new int[] {  0, 44, 28, 40, 40 };  // repated 1x 4th number to fill gap
    faces[26] = new int[] {  1, 41, 29, 45, 45 };  // repated 1x 4th number to fill gap
    faces[27] = new int[] {  1, 47, 31, 43, 43 };  // repated 1x 4th number to fill gap
    faces[28] = new int[] {  3, 39, 35, 51, 51 };  // repated 1x 4th number to fill gap
    faces[29] = new int[] {  3, 49, 33, 37, 37 };  // repated 1x 4th number to fill gap
    faces[30] = new int[] {  5, 44, 14, 54, 54 };  // repated 1x 4th number to fill gap
    faces[31] = new int[] {  5, 55, 15, 45, 45 };  // repated 1x 4th number to fill gap
    faces[32] = new int[] {  6, 50, 16, 56, 56 };  // repated 1x 4rd number to fill gap
    faces[33] = new int[] {  6, 57, 17, 51, 51 };  // repated 1x 4rd number to fill gap
    faces[34] = new int[] {  7, 49, 19, 59, 59 };  // repated 1x 4rd number to fill gap
    faces[35] = new int[] {  7, 58, 18, 48, 48 };  // repated 1x 4rd number to fill gap
    faces[36] = new int[] {  8, 36, 20, 53, 53 };  // repated 1x 4rd number to fill gap
    faces[37] = new int[] {  8, 57, 24, 40, 40 };  // repated 1x 4rd number to fill gap
    faces[38] = new int[] {  9, 41, 25, 56, 56 };  // repated 1x 4rd number to fill gap
    faces[39] = new int[] {  9, 52, 21, 37, 37 };  // repated 1x 4rd number to fill gap
    faces[40] = new int[] { 11, 39, 23, 54, 54 };  // repated 1x 4rd number to fill gap
    faces[41] = new int[] { 11, 58, 27, 43, 43 };  // repated 1x 4rd number to fill gap
    faces[42] = new int[] { 12, 16, 18, 14, 14 };  // repated 1x 4rd number to fill gap
    faces[43] = new int[] { 12, 46,  4, 52, 52 };  // repated 1x 4rd number to fill gap
    faces[44] = new int[] { 13, 15, 19, 17, 17 };  // repated 1x 4rd number to fill gap
    faces[45] = new int[] { 13, 53,  4, 47, 47 };  // repated 1x 4rd number to fill gap
    faces[46] = new int[] { 22, 23, 21, 20, 20 };  // repated 1x 4rd number to fill gap
    faces[47] = new int[] { 22, 38, 10, 55, 55 };  // repated 1x 4rd number to fill gap
    faces[48] = new int[] { 26, 24, 25, 27, 27 };  // repated 1x 4rd number to fill gap
    faces[49] = new int[] { 26, 59, 10, 42, 42 };  // repated 1x 4rd number to fill gap
    faces[50] = new int[] { 32, 28, 29, 33, 33 };  // repated 1x 4rd number to fill gap
    faces[51] = new int[] { 32, 48,  2, 36, 36 };  // repated 1x 4rd number to fill gap
    faces[52] = new int[] { 34, 35, 31, 30, 30 };  // repated 1x 4rd number to fill gap
    faces[53] = new int[] { 34, 38,  2, 50, 50 };  // repated 1x 4rd number to fill gap
  } //end Rhombidodecadodecahedron()

  public String name() {
    return "Rhombidodecadodecahedron";
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
   
} //end class Rhombidodecadodecahedron
