/*
GreatStellapentakisDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatStellapentakisDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.495040249835401793926484409117;  //9 * (5 * sqrt(5) - 7) / 76
  final float C1 = 0.800991950032919641214703118177;  //9 * (9 - sqrt(5)) / 76
  final float C2 = 0.927050983124842272306880251548;  //3 * (sqrt(5) - 1) / 4
  final float C3 = 2.427050983124842272306880251548;  //3 * (1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[32]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatStellapentakisDodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C3,  0.0,   C2 );
    vert[  1] = new PVector(   C3,  0.0,  -C2 );
    vert[  2] = new PVector(  -C3,  0.0,   C2 );
    vert[  3] = new PVector(  -C3,  0.0,  -C2 );
    vert[  4] = new PVector(  0.0,   C2,   C3 );
    vert[  5] = new PVector(  0.0,   C2,  -C3 );
    vert[  6] = new PVector(  0.0,  -C2,   C3 );
    vert[  7] = new PVector(  0.0,  -C2,  -C3 );
    vert[  8] = new PVector(   C2,   C3,  0.0 );
    vert[  9] = new PVector(  -C2,   C3,  0.0 );
    vert[ 10] = new PVector(   C2,  -C3,  0.0 );
    vert[ 11] = new PVector(  -C2,  -C3,  0.0 );
    vert[ 12] = new PVector(  0.0,  -C1,   C0 );
    vert[ 13] = new PVector(  0.0,  -C1,  -C0 );
    vert[ 14] = new PVector(  0.0,   C1,   C0 );
    vert[ 15] = new PVector(  0.0,   C1,  -C0 );
    vert[ 16] = new PVector(  -C1,   C0,  0.0 );
    vert[ 17] = new PVector(   C1,   C0,  0.0 );
    vert[ 18] = new PVector(  -C1,  -C0,  0.0 );
    vert[ 19] = new PVector(   C1,  -C0,  0.0 );
    vert[ 20] = new PVector(   C0,  0.0,  -C1 );
    vert[ 21] = new PVector(   C0,  0.0,   C1 );
    vert[ 22] = new PVector(  -C0,  0.0,  -C1 );
    vert[ 23] = new PVector(  -C0,  0.0,   C1 );
    vert[ 24] = new PVector( -1.5, -1.5, -1.5 );
    vert[ 25] = new PVector( -1.5, -1.5,  1.5 );
    vert[ 26] = new PVector(  1.5, -1.5, -1.5 );
    vert[ 27] = new PVector(  1.5, -1.5,  1.5 );
    vert[ 28] = new PVector( -1.5,  1.5, -1.5 );
    vert[ 29] = new PVector( -1.5,  1.5,  1.5 );
    vert[ 30] = new PVector(  1.5,  1.5, -1.5 );
    vert[ 31] = new PVector(  1.5,  1.5,  1.5 );
    // set faces
    faces[ 0] = new int[] { 12,  0,  2 };
    faces[ 1] = new int[] { 12,  2, 26 };
    faces[ 2] = new int[] { 12, 26,  4 };
    faces[ 3] = new int[] { 12,  4, 24 };
    faces[ 4] = new int[] { 12, 24,  0 };
    faces[ 5] = new int[] { 13,  3,  1 };
    faces[ 6] = new int[] { 13,  1, 25 };
    faces[ 7] = new int[] { 13, 25,  5 };
    faces[ 8] = new int[] { 13,  5, 27 };
    faces[ 9] = new int[] { 13, 27,  3 };
    faces[10] = new int[] { 14,  2,  0 };
    faces[11] = new int[] { 14,  0, 28 };
    faces[12] = new int[] { 14, 28,  6 };
    faces[13] = new int[] { 14,  6, 30 };
    faces[14] = new int[] { 14, 30,  2 };
    faces[15] = new int[] { 15,  1,  3 };
    faces[16] = new int[] { 15,  3, 31 };
    faces[17] = new int[] { 15, 31,  7 };
    faces[18] = new int[] { 15,  7, 29 };
    faces[19] = new int[] { 15, 29,  1 };
    faces[20] = new int[] { 16,  4,  5 };
    faces[21] = new int[] { 16,  5, 25 };
    faces[22] = new int[] { 16, 25,  8 };
    faces[23] = new int[] { 16,  8, 24 };
    faces[24] = new int[] { 16, 24,  4 };
    faces[25] = new int[] { 17,  5,  4 };
    faces[26] = new int[] { 17,  4, 26 };
    faces[27] = new int[] { 17, 26,  9 };
    faces[28] = new int[] { 17,  9, 27 };
    faces[29] = new int[] { 17, 27,  5 };
    faces[30] = new int[] { 18,  7,  6 };
    faces[31] = new int[] { 18,  6, 28 };
    faces[32] = new int[] { 18, 28, 10 };
    faces[33] = new int[] { 18, 10, 29 };
    faces[34] = new int[] { 18, 29,  7 };
    faces[35] = new int[] { 19,  6,  7 };
    faces[36] = new int[] { 19,  7, 31 };
    faces[37] = new int[] { 19, 31, 11 };
    faces[38] = new int[] { 19, 11, 30 };
    faces[39] = new int[] { 19, 30,  6 };
    faces[40] = new int[] { 20,  8, 10 };
    faces[41] = new int[] { 20, 10, 28 };
    faces[42] = new int[] { 20, 28,  0 };
    faces[43] = new int[] { 20,  0, 24 };
    faces[44] = new int[] { 20, 24,  8 };
    faces[45] = new int[] { 21, 10,  8 };
    faces[46] = new int[] { 21,  8, 25 };
    faces[47] = new int[] { 21, 25,  1 };
    faces[48] = new int[] { 21,  1, 29 };
    faces[49] = new int[] { 21, 29, 10 };
    faces[50] = new int[] { 22, 11,  9 };
    faces[51] = new int[] { 22,  9, 26 };
    faces[52] = new int[] { 22, 26,  2 };
    faces[53] = new int[] { 22,  2, 30 };
    faces[54] = new int[] { 22, 30, 11 };
    faces[55] = new int[] { 23,  9, 11 };
    faces[56] = new int[] { 23, 11, 31 };
    faces[57] = new int[] { 23, 31,  3 };
    faces[58] = new int[] { 23,  3, 27 };
    faces[59] = new int[] { 23, 27,  9 };
  } //end GreatStellapentakisDodecahedron()

  public String name() {
    return "Great Stellapentakis Dodecahedron";
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
   
} //end class GreatStellapentakisDodecahedron
