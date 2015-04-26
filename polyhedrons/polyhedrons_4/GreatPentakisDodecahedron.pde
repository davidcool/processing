/*
GreatPentakisDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatPentakisDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.427050983124842272306880251548;  //(3 * sqrt(5) - 5) / 4
  final float C1 = 0.690983005625052575897706582817;  //(5 - sqrt(5)) / 4
  final float C2 = 4.04508497187473712051146708591;   //5 * (1 + sqrt(5)) / 4
  final float C3 = 6.54508497187473712051146708591;   //5 * (3 + sqrt(5)) / 4
  private PVector[] vert = new PVector[24]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatPentakisDodecahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0,  C1, -C0 );
    vert[  1] = new PVector( 0.0,  C1,  C0 );
    vert[  2] = new PVector( 0.0, -C1, -C0 );
    vert[  3] = new PVector( 0.0, -C1,  C0 );
    vert[  4] = new PVector(  C1, -C0, 0.0 );
    vert[  5] = new PVector( -C1, -C0, 0.0 );
    vert[  6] = new PVector(  C1,  C0, 0.0 );
    vert[  7] = new PVector( -C1,  C0, 0.0 );
    vert[  8] = new PVector( -C0, 0.0,  C1 );
    vert[  9] = new PVector( -C0, 0.0, -C1 );
    vert[ 10] = new PVector(  C0, 0.0,  C1 );
    vert[ 11] = new PVector(  C0, 0.0, -C1 );
    vert[ 12] = new PVector( 0.0,  C3, -C2 );
    vert[ 13] = new PVector( 0.0,  C3,  C2 );
    vert[ 14] = new PVector( 0.0, -C3, -C2 );
    vert[ 15] = new PVector( 0.0, -C3,  C2 );
    vert[ 16] = new PVector(  C3, -C2, 0.0 );
    vert[ 17] = new PVector( -C3, -C2, 0.0 );
    vert[ 18] = new PVector(  C3,  C2, 0.0 );
    vert[ 19] = new PVector( -C3,  C2, 0.0 );
    vert[ 20] = new PVector( -C2, 0.0,  C3 );
    vert[ 21] = new PVector( -C2, 0.0, -C3 );
    vert[ 22] = new PVector(  C2, 0.0,  C3 );
    vert[ 23] = new PVector(  C2, 0.0, -C3 );
    // set faces
    faces[ 0] = new int[] { 12,  2,  5 };
    faces[ 1] = new int[] { 12,  5,  8 };
    faces[ 2] = new int[] { 12,  8, 10 };
    faces[ 3] = new int[] { 12, 10,  4 };
    faces[ 4] = new int[] { 12,  4,  2 };
    faces[ 5] = new int[] { 13,  3,  4 };
    faces[ 6] = new int[] { 13,  4, 11 };
    faces[ 7] = new int[] { 13, 11,  9 };
    faces[ 8] = new int[] { 13,  9,  5 };
    faces[ 9] = new int[] { 13,  5,  3 };
    faces[10] = new int[] { 14,  0,  6 };
    faces[11] = new int[] { 14,  6, 10 };
    faces[12] = new int[] { 14, 10,  8 };
    faces[13] = new int[] { 14,  8,  7 };
    faces[14] = new int[] { 14,  7,  0 };
    faces[15] = new int[] { 15,  1,  7 };
    faces[16] = new int[] { 15,  7,  9 };
    faces[17] = new int[] { 15,  9, 11 };
    faces[18] = new int[] { 15, 11,  6 };
    faces[19] = new int[] { 15,  6,  1 };
    faces[20] = new int[] { 16,  0,  1 };
    faces[21] = new int[] { 16,  1,  8 };
    faces[22] = new int[] { 16,  8,  5 };
    faces[23] = new int[] { 16,  5,  9 };
    faces[24] = new int[] { 16,  9,  0 };
    faces[25] = new int[] { 17,  1,  0 };
    faces[26] = new int[] { 17,  0, 11 };
    faces[27] = new int[] { 17, 11,  4 };
    faces[28] = new int[] { 17,  4, 10 };
    faces[29] = new int[] { 17, 10,  1 };
    faces[30] = new int[] { 18,  3,  2 };
    faces[31] = new int[] { 18,  2,  9 };
    faces[32] = new int[] { 18,  9,  7 };
    faces[33] = new int[] { 18,  7,  8 };
    faces[34] = new int[] { 18,  8,  3 };
    faces[35] = new int[] { 19,  2,  3 };
    faces[36] = new int[] { 19,  3, 10 };
    faces[37] = new int[] { 19, 10,  6 };
    faces[38] = new int[] { 19,  6, 11 };
    faces[39] = new int[] { 19, 11,  2 };
    faces[40] = new int[] { 20,  0,  9 };
    faces[41] = new int[] { 20,  9,  2 };
    faces[42] = new int[] { 20,  2,  4 };
    faces[43] = new int[] { 20,  4,  6 };
    faces[44] = new int[] { 20,  6,  0 };
    faces[45] = new int[] { 21,  1,  6 };
    faces[46] = new int[] { 21,  6,  4 };
    faces[47] = new int[] { 21,  4,  3 };
    faces[48] = new int[] { 21,  3,  8 };
    faces[49] = new int[] { 21,  8,  1 };
    faces[50] = new int[] { 22,  0,  7 };
    faces[51] = new int[] { 22,  7,  5 };
    faces[52] = new int[] { 22,  5,  2 };
    faces[53] = new int[] { 22,  2, 11 };
    faces[54] = new int[] { 22, 11,  0 };
    faces[55] = new int[] { 23,  1, 10 };
    faces[56] = new int[] { 23, 10,  3 };
    faces[57] = new int[] { 23,  3,  5 };
    faces[58] = new int[] { 23,  5,  7 };
    faces[59] = new int[] { 23,  7,  1 };
  } //end GreatPentakisDodecahedron()

  public String name() {
    return "Great Pentakis Dodecahedron";
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
   
} //end class GreatPentakisDodecahedron
