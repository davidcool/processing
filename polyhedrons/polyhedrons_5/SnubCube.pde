/*
SnubCube class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubCube extends Polyhedron {
  
  // polyhedron
  final int FACES = 38;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.33775397381375235213753224516503; //C0 = sqrt(3 * (4 - cbrt(17 + 3*sqrt(33)) - cbrt(17 - 3*sqrt(33)))) / 6
  final float C1 = 0.621226410556585311692500954490;   //C1 = sqrt(3 * (2 + cbrt(17 + 3*sqrt(33)) + cbrt(17 - 3*sqrt(33)))) / 6
  final float C2 = 1.14261350892596209347948408672;    //C2 = sqrt(3 * (4 + cbrt(199 + 3*sqrt(33)) + cbrt(199 - 3*sqrt(33)))) / 6
  private PVector[] vert = new PVector[24]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubCube() {   
    // set vertices
    vert[ 0] = new PVector(  C1,  C0,  C2 );
    vert[ 1] = new PVector(  C1, -C0, -C2 );
    vert[ 2] = new PVector( -C1, -C0,  C2 );
    vert[ 3] = new PVector( -C1,  C0, -C2 );
    vert[ 4] = new PVector(  C2,  C1,  C0 );
    vert[ 5] = new PVector(  C2, -C1, -C0 );
    vert[ 6] = new PVector( -C2, -C1,  C0 );
    vert[ 7] = new PVector( -C2,  C1, -C0 );
    vert[ 8] = new PVector(  C0,  C2,  C1 );
    vert[ 9] = new PVector(  C0, -C2, -C1 );
    vert[10] = new PVector( -C0, -C2,  C1 );
    vert[11] = new PVector( -C0,  C2, -C1 );
    vert[12] = new PVector(  C0, -C1,  C2 );
    vert[13] = new PVector(  C0,  C1, -C2 );
    vert[14] = new PVector( -C0,  C1,  C2 );
    vert[15] = new PVector( -C0, -C1, -C2 );
    vert[16] = new PVector(  C2, -C0,  C1 );
    vert[17] = new PVector(  C2,  C0, -C1 );
    vert[18] = new PVector( -C2,  C0,  C1 );
    vert[19] = new PVector( -C2, -C0, -C1 );
    vert[20] = new PVector(  C1, -C2,  C0 );
    vert[21] = new PVector(  C1,  C2, -C0 );
    vert[22] = new PVector( -C1,  C2,  C0 );
    vert[23] = new PVector( -C1, -C2, -C0 );
    // set faces
    faces[ 0] = new int[] {  2, 12,  0, 14 };
    faces[ 1] = new int[] {  3, 13,  1, 15 };
    faces[ 2] = new int[] {  4, 16,  5, 17 };
    faces[ 3] = new int[] {  7, 19,  6, 18 };
    faces[ 4] = new int[] {  8, 21, 11, 22 };
    faces[ 5] = new int[] {  9, 20, 10, 23 };
    faces[ 6] = new int[] {  0,  8, 14, 14 }; //added 1x 3rd number to fill gap
    faces[ 7] = new int[] {  1,  9, 15, 15 }; //added 1x 3rd number to fill gap
    faces[ 8] = new int[] {  2, 10, 12, 12 }; //added 1x 3rd number to fill gap
    faces[ 9] = new int[] {  3, 11, 13, 13 }; //added 1x 3rd number to fill gap
    faces[10] = new int[] {  4,  0, 16, 16 }; //added 1x 3rd number to fill gap
    faces[11] = new int[] {  5,  1, 17, 17 }; //added 1x 3rd number to fill gap
    faces[12] = new int[] {  6,  2, 18, 18 }; //added 1x 3rd number to fill gap
    faces[13] = new int[] {  7,  3, 19, 19 }; //added 1x 3rd number to fill gap
    faces[14] = new int[] {  8,  4, 21, 21 }; //added 1x 3rd number to fill gap
    faces[15] = new int[] {  9,  5, 20, 20 }; //added 1x 3rd number to fill gap
    faces[16] = new int[] { 10,  6, 23, 23 }; //added 1x 3rd number to fill gap
    faces[17] = new int[] { 11,  7, 22, 22 }; //added 1x 3rd number to fill gap
    faces[18] = new int[] { 12, 16,  0,  0 }; //added 1x 3rd number to fill gap
    faces[19] = new int[] { 13, 17,  1,  1 }; //added 1x 3rd number to fill gap
    faces[20] = new int[] { 14, 18,  2,  2 }; //added 1x 3rd number to fill gap
    faces[21] = new int[] { 15, 19,  3,  3 }; //added 1x 3rd number to fill gap
    faces[22] = new int[] { 16, 20,  5,  5 }; //added 1x 3rd number to fill gap
    faces[23] = new int[] { 17, 21,  4,  4 }; //added 1x 3rd number to fill gap
    faces[24] = new int[] { 18, 22,  7,  7 }; //added 1x 3rd number to fill gap
    faces[25] = new int[] { 19, 23,  6,  6 }; //added 1x 3rd number to fill gap
    faces[26] = new int[] { 20, 12, 10, 10 }; //added 1x 3rd number to fill gap
    faces[27] = new int[] { 21, 13, 11, 11 }; //added 1x 3rd number to fill gap
    faces[28] = new int[] { 22, 14,  8,  8 }; //added 1x 3rd number to fill gap
    faces[29] = new int[] { 23, 15,  9,  9 }; //added 1x 3rd number to fill gap
    faces[30] = new int[] {  8,  0,  4,  4 }; //added 1x 3rd number to fill gap
    faces[31] = new int[] {  9,  1,  5,  5 }; //added 1x 3rd number to fill gap
    faces[32] = new int[] { 10,  2,  6,  6 }; //added 1x 3rd number to fill gap
    faces[33] = new int[] { 11,  3,  7,  7 }; //added 1x 3rd number to fill gap
    faces[34] = new int[] { 12, 20, 16, 16 }; //added 1x 3rd number to fill gap
    faces[35] = new int[] { 13, 21, 17, 17 }; //added 1x 3rd number to fill gap
    faces[36] = new int[] { 14, 22, 18, 18 }; //added 1x 3rd number to fill gap
    faces[37] = new int[] { 15, 23, 19, 19 }; //added 1x 3rd number to fill gap
  } //end SnubCube()

  public String name() {
    return "Snub Cube (laevo)";
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
   
} //end class SnubCube
