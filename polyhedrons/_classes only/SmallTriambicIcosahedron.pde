/*
SmallTriambicIcosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallTriambicIcosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 20;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.276393202250021030359082633127;  //(5 - sqrt(5)) / 10
  final float C1 = 0.381966011250105151795413165634;  //(3 - sqrt(5)) / 2
  final float C2 = 0.447213595499957939281834733746;  //sqrt(5) / 5
  final float C3 = 0.618033988749894848204586834366;  //(sqrt(5) - 1) / 2
  final float C4 = 0.723606797749978969640917366873;  //(5 + sqrt(5)) / 10
  private PVector[] vert = new PVector[32]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallTriambicIcosahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0,  C0,  C4 );
    vert[  1] = new PVector( 0.0,  C0, -C4 );
    vert[  2] = new PVector( 0.0, -C0,  C4 );
    vert[  3] = new PVector( 0.0, -C0, -C4 );
    vert[  4] = new PVector(  C4, 0.0,  C0 );
    vert[  5] = new PVector(  C4, 0.0, -C0 );
    vert[  6] = new PVector( -C4, 0.0,  C0 );
    vert[  7] = new PVector( -C4, 0.0, -C0 );
    vert[  8] = new PVector(  C0,  C4, 0.0 );
    vert[  9] = new PVector(  C0, -C4, 0.0 );
    vert[ 10] = new PVector( -C0,  C4, 0.0 );
    vert[ 11] = new PVector( -C0, -C4, 0.0 );
    vert[ 12] = new PVector(  C1, 0.0,  C3 );
    vert[ 13] = new PVector(  C1, 0.0, -C3 );
    vert[ 14] = new PVector( -C1, 0.0,  C3 );
    vert[ 15] = new PVector( -C1, 0.0, -C3 );
    vert[ 16] = new PVector(  C3,  C1, 0.0 );
    vert[ 17] = new PVector(  C3, -C1, 0.0 );
    vert[ 18] = new PVector( -C3,  C1, 0.0 );
    vert[ 19] = new PVector( -C3, -C1, 0.0 );
    vert[ 20] = new PVector( 0.0,  C3,  C1 );
    vert[ 21] = new PVector( 0.0,  C3, -C1 );
    vert[ 22] = new PVector( 0.0, -C3,  C1 );
    vert[ 23] = new PVector( 0.0, -C3, -C1 );
    vert[ 24] = new PVector(  C2,  C2,  C2 );
    vert[ 25] = new PVector(  C2,  C2, -C2 );
    vert[ 26] = new PVector(  C2, -C2,  C2 );
    vert[ 27] = new PVector(  C2, -C2, -C2 );
    vert[ 28] = new PVector( -C2,  C2,  C2 );
    vert[ 29] = new PVector( -C2,  C2, -C2 );
    vert[ 30] = new PVector( -C2, -C2,  C2 );
    vert[ 31] = new PVector( -C2, -C2, -C2 );
    // set faces
    faces[ 0] = new int[] { 12,  0, 14, 30, 22, 26 };
    faces[ 1] = new int[] { 12, 26, 17,  5, 16, 24 };
    faces[ 2] = new int[] { 12, 24, 20, 28, 14,  2 };
    faces[ 3] = new int[] { 12,  2, 22,  9, 17,  4 };
    faces[ 4] = new int[] { 12,  4, 16,  8, 20,  0 };
    faces[ 5] = new int[] { 15,  1, 13, 27, 23, 31 };
    faces[ 6] = new int[] { 15, 31, 19,  6, 18, 29 };
    faces[ 7] = new int[] { 15, 29, 21, 25, 13,  3 };
    faces[ 8] = new int[] { 15,  3, 23, 11, 19,  7 };
    faces[ 9] = new int[] { 15,  7, 18, 10, 21,  1 };
    faces[10] = new int[] { 13,  1, 21,  8, 16,  5 };
    faces[11] = new int[] { 13,  5, 17,  9, 23,  3 };
    faces[12] = new int[] { 13, 25, 16,  4, 17, 27 };
    faces[13] = new int[] { 14,  0, 20, 10, 18,  6 };
    faces[14] = new int[] { 14,  6, 19, 11, 22,  2 };
    faces[15] = new int[] { 14, 28, 18,  7, 19, 30 };
    faces[16] = new int[] { 20,  8, 21, 29, 18, 28 };
    faces[17] = new int[] { 20, 24, 16, 25, 21, 10 };
    faces[18] = new int[] { 22, 11, 23, 27, 17, 26 };
    faces[19] = new int[] { 22, 30, 19, 31, 23,  9 };
  } //end SmallTriambicIcosahedron()

  public String name() {
    return "Small Triambic Icosahedron";
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
   
} //end class SmallTriambicIcosahedron
