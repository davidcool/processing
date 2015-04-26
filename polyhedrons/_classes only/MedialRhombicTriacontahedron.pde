/*
MedialRhombicTriacontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class MedialRhombicTriacontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 30;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.463525491562421136153440125774;  //3 * (sqrt(5) - 1) / 8
  final float C1 = 1.21352549156242113615344012577;   //3 * (1 + sqrt(5)) / 8
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private MedialRhombicTriacontahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.75,   0.0,    C1 );
    vert[  1] = new PVector(  0.75,   0.0,   -C1 );
    vert[  2] = new PVector( -0.75,   0.0,    C1 );
    vert[  3] = new PVector( -0.75,   0.0,   -C1 );
    vert[  4] = new PVector(    C1,  0.75,   0.0 );
    vert[  5] = new PVector(    C1, -0.75,   0.0 );
    vert[  6] = new PVector(   -C1,  0.75,   0.0 );
    vert[  7] = new PVector(   -C1, -0.75,   0.0 );
    vert[  8] = new PVector(   0.0,    C1,  0.75 );
    vert[  9] = new PVector(   0.0,    C1, -0.75 );
    vert[ 10] = new PVector(   0.0,   -C1,  0.75 );
    vert[ 11] = new PVector(   0.0,   -C1, -0.75 );
    vert[ 12] = new PVector(    C0,   0.0,  0.75 );
    vert[ 13] = new PVector(    C0,   0.0, -0.75 );
    vert[ 14] = new PVector(   -C0,   0.0,  0.75 );
    vert[ 15] = new PVector(   -C0,   0.0, -0.75 );
    vert[ 16] = new PVector(  0.75,    C0,   0.0 );
    vert[ 17] = new PVector(  0.75,   -C0,   0.0 );
    vert[ 18] = new PVector( -0.75,    C0,   0.0 );
    vert[ 19] = new PVector( -0.75,   -C0,   0.0 );
    vert[ 20] = new PVector(   0.0,  0.75,    C0 );
    vert[ 21] = new PVector(   0.0,  0.75,   -C0 );
    vert[ 22] = new PVector(   0.0, -0.75,    C0 );
    vert[ 23] = new PVector(   0.0, -0.75,   -C0 );
    // set faces
    faces[ 0] = new int[] {  0, 14,  7, 22 };
    faces[ 1] = new int[] {  0, 22, 11, 17 };
    faces[ 2] = new int[] {  0, 17,  1, 16 };
    faces[ 3] = new int[] {  0, 16,  9, 20 };
    faces[ 4] = new int[] {  0, 20,  6, 14 };
    faces[ 5] = new int[] {  3, 13,  5, 23 };
    faces[ 6] = new int[] {  3, 23, 10, 19 };
    faces[ 7] = new int[] {  3, 19,  2, 18 };
    faces[ 8] = new int[] {  3, 18,  8, 21 };
    faces[ 9] = new int[] {  3, 21,  4, 13 };
    faces[10] = new int[] {  1, 15,  6, 21 };
    faces[11] = new int[] {  1, 21,  8, 16 };
    faces[12] = new int[] {  2, 19, 11, 22 };
    faces[13] = new int[] {  2, 22,  5, 12 };
    faces[14] = new int[] {  4, 21,  6, 20 };
    faces[15] = new int[] {  4, 20,  2, 12 };
    faces[16] = new int[] {  5, 13,  9, 16 };
    faces[17] = new int[] {  5, 16,  8, 12 };
    faces[18] = new int[] {  6, 15, 11, 19 };
    faces[19] = new int[] {  6, 19, 10, 14 };
    faces[20] = new int[] {  7, 15,  1, 23 };
    faces[21] = new int[] {  7, 23,  5, 22 };
    faces[22] = new int[] {  8, 18,  7, 14 };
    faces[23] = new int[] {  8, 14, 10, 12 };
    faces[24] = new int[] {  9, 15,  7, 18 };
    faces[25] = new int[] {  9, 18,  2, 20 };
    faces[26] = new int[] { 10, 23,  1, 17 };
    faces[27] = new int[] { 10, 17,  4, 12 };
    faces[28] = new int[] { 11, 15,  9, 13 };
    faces[29] = new int[] { 11, 13,  4, 17 };
  } //end MedialRhombicTriacontahedron()

  public String name() {
    return "Medial Rhombic Triacontahedron";
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
   
} //end class MedialRhombicTriacontahedron
