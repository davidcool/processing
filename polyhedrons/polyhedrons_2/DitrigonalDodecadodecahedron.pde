/*
DitrigonalDodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class DitrigonalDodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183;  //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
   private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private DitrigonalDodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,   C0,   C1 );
    vert[  1] = new PVector(  0.0,   C0,  -C1 );
    vert[  2] = new PVector(  0.0,  -C0,   C1 );
    vert[  3] = new PVector(  0.0,  -C0,  -C1 );
    vert[  4] = new PVector(   C1,  0.0,   C0 );
    vert[  5] = new PVector(   C1,  0.0,  -C0 );
    vert[  6] = new PVector(  -C1,  0.0,   C0 );
    vert[  7] = new PVector(  -C1,  0.0,  -C0 );
    vert[  8] = new PVector(   C0,   C1,  0.0 );
    vert[  9] = new PVector(   C0,  -C1,  0.0 );
    vert[ 10] = new PVector(  -C0,   C1,  0.0 );
    vert[ 11] = new PVector(  -C0,  -C1,  0.0 );
    vert[ 12] = new PVector(  0.5,  0.5,  0.5 );
    vert[ 13] = new PVector(  0.5,  0.5, -0.5 );
    vert[ 14] = new PVector(  0.5, -0.5,  0.5 );
    vert[ 15] = new PVector(  0.5, -0.5, -0.5 );
    vert[ 16] = new PVector( -0.5,  0.5,  0.5 );
    vert[ 17] = new PVector( -0.5,  0.5, -0.5 );
    vert[ 18] = new PVector( -0.5, -0.5,  0.5 );
    vert[ 19] = new PVector( -0.5, -0.5, -0.5 );
    // set faces
    faces[ 0] = new int[] {  0,  6,  2, 16, 18 };
    faces[ 1] = new int[] {  0,  8, 16, 12, 10 };
    faces[ 2] = new int[] {  0, 14, 12,  2,  4 };
    faces[ 3] = new int[] {  7,  1, 19, 17,  3 };
    faces[ 4] = new int[] {  7, 11,  6, 19, 18 };
    faces[ 5] = new int[] {  7, 16, 17,  6, 10 };
    faces[ 6] = new int[] {  9,  2, 11, 14, 18 };
    faces[ 7] = new int[] {  9,  5, 14, 15,  4 };
    faces[ 8] = new int[] {  9, 19, 15, 11,  3 };
    faces[ 9] = new int[] { 13, 12,  5,  8,  4 };
    faces[10] = new int[] { 13, 15,  1,  5,  3 };
    faces[11] = new int[] { 13, 17,  8,  1, 10 };
    faces[12] = new int[] {  0,  4, 15, 19,  6 };
    faces[13] = new int[] {  0, 10,  1, 15, 14 };
    faces[14] = new int[] {  0, 18, 19,  1,  8 };
    faces[15] = new int[] {  7,  3,  5, 12, 16 };
    faces[16] = new int[] {  7, 10, 12, 14, 11 };
    faces[17] = new int[] {  7, 18, 14,  5,  1 };
    faces[18] = new int[] {  9,  3, 17, 16,  2 };
    faces[19] = new int[] {  9,  4,  8, 17, 19 };
    faces[20] = new int[] {  9, 18, 16,  8,  5 };
    faces[21] = new int[] { 13,  3, 11,  2, 12 };
    faces[22] = new int[] { 13,  4,  2,  6, 17 };
    faces[23] = new int[] { 13, 10,  6, 11, 15 };
  } //end DitrigonalDodecadodecahedron()

  public String name() {
    return "Ditrigonal Dodecadodecahedron";
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
   
} //end class DitrigonalDodecadodecahedron
