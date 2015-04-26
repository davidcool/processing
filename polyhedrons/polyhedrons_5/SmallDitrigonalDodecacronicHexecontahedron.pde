/*
SmallDitrigonalDodecacronicHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDitrigonalDodecacronicHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.597024149901241076355890645470;  //3 * (9 * sqrt(5) - 5) / 76
  final float C1 = 0.870268092443196157063010886223;  //3 * (15 - sqrt(5)) / 44
  final float C2 = 0.966005366644720239190197921216;  //3 * (10 + sqrt(5)) / 38
  final float C3 = 1.40812335289762690055892379644;   //3 * (5 + 7 * sqrt(5)) / 44
  final float C4 = 1.56302951654596131554608856669;   //3 * (15 + 11 * sqrt(5)) / 76
  final float C5 = 2.427050983124842272306880251548;  //3 * (1 + sqrt(5)) / 4
  final float C6 = 3.927050983124842272306880251548;  //3 * (3 + sqrt(5)) / 4
  private PVector[] vert = new PVector[44]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDitrigonalDodecacronicHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(  C5, 0.0,  C6 );
    vert[  1] = new PVector(  C5, 0.0, -C6 );
    vert[  2] = new PVector( -C5, 0.0,  C6 );
    vert[  3] = new PVector( -C5, 0.0, -C6 );
    vert[  4] = new PVector(  C6,  C5, 0.0 );
    vert[  5] = new PVector(  C6, -C5, 0.0 );
    vert[  6] = new PVector( -C6,  C5, 0.0 );
    vert[  7] = new PVector( -C6, -C5, 0.0 );
    vert[  8] = new PVector( 0.0,  C6,  C5 );
    vert[  9] = new PVector( 0.0,  C6, -C5 );
    vert[ 10] = new PVector( 0.0, -C6,  C5 );
    vert[ 11] = new PVector( 0.0, -C6, -C5 );
    vert[ 12] = new PVector( 0.0,  C0,  C4 );
    vert[ 13] = new PVector( 0.0,  C0, -C4 );
    vert[ 14] = new PVector( 0.0, -C0,  C4 );
    vert[ 15] = new PVector( 0.0, -C0, -C4 );
    vert[ 16] = new PVector(  C4, 0.0,  C0 );
    vert[ 17] = new PVector(  C4, 0.0, -C0 );
    vert[ 18] = new PVector( -C4, 0.0,  C0 );
    vert[ 19] = new PVector( -C4, 0.0, -C0 );
    vert[ 20] = new PVector(  C0,  C4, 0.0 );
    vert[ 21] = new PVector(  C0, -C4, 0.0 );
    vert[ 22] = new PVector( -C0,  C4, 0.0 );
    vert[ 23] = new PVector( -C0, -C4, 0.0 );
    vert[ 24] = new PVector(  C1, 0.0,  C3 );
    vert[ 25] = new PVector(  C1, 0.0, -C3 );
    vert[ 26] = new PVector( -C1, 0.0,  C3 );
    vert[ 27] = new PVector( -C1, 0.0, -C3 );
    vert[ 28] = new PVector(  C3,  C1, 0.0 );
    vert[ 29] = new PVector(  C3, -C1, 0.0 );
    vert[ 30] = new PVector( -C3,  C1, 0.0 );
    vert[ 31] = new PVector( -C3, -C1, 0.0 );
    vert[ 32] = new PVector( 0.0,  C3,  C1 );
    vert[ 33] = new PVector( 0.0,  C3, -C1 );
    vert[ 34] = new PVector( 0.0, -C3,  C1 );
    vert[ 35] = new PVector( 0.0, -C3, -C1 );
    vert[ 36] = new PVector(  C2,  C2,  C2 );
    vert[ 37] = new PVector(  C2,  C2, -C2 );
    vert[ 38] = new PVector(  C2, -C2,  C2 );
    vert[ 39] = new PVector(  C2, -C2, -C2 );
    vert[ 40] = new PVector( -C2,  C2,  C2 );
    vert[ 41] = new PVector( -C2,  C2, -C2 );
    vert[ 42] = new PVector( -C2, -C2,  C2 );
    vert[ 43] = new PVector( -C2, -C2, -C2 );
    // set faces
    faces[ 0] = new int[] { 24,  2, 38,  4 };
    faces[ 1] = new int[] { 24,  4, 12, 10 };
    faces[ 2] = new int[] { 24, 10, 16,  8 };
    faces[ 3] = new int[] { 24,  8, 14,  5 };
    faces[ 4] = new int[] { 24,  5, 36,  2 };
    faces[ 5] = new int[] { 25,  4, 39,  3 };
    faces[ 6] = new int[] { 25,  3, 37,  5 };
    faces[ 7] = new int[] { 25,  5, 15,  9 };
    faces[ 8] = new int[] { 25,  9, 17, 11 };
    faces[ 9] = new int[] { 25, 11, 13,  4 };
    faces[10] = new int[] { 26,  0, 40,  7 };
    faces[11] = new int[] { 26,  7, 14,  8 };
    faces[12] = new int[] { 26,  8, 18, 10 };
    faces[13] = new int[] { 26, 10, 12,  6 };
    faces[14] = new int[] { 26,  6, 42,  0 };
    faces[15] = new int[] { 27,  1, 43,  6 };
    faces[16] = new int[] { 27,  6, 13, 11 };
    faces[17] = new int[] { 27, 11, 19,  9 };
    faces[18] = new int[] { 27,  9, 15,  7 };
    faces[19] = new int[] { 27,  7, 41,  1 };
    faces[20] = new int[] { 28,  0, 17,  9 };
    faces[21] = new int[] { 28,  9, 36,  5 };
    faces[22] = new int[] { 28,  5, 37,  8 };
    faces[23] = new int[] { 28,  8, 16,  1 };
    faces[24] = new int[] { 28,  1, 20,  0 };
    faces[25] = new int[] { 29,  0, 21,  1 };
    faces[26] = new int[] { 29,  1, 16, 10 };
    faces[27] = new int[] { 29, 10, 39,  4 };
    faces[28] = new int[] { 29,  4, 38, 11 };
    faces[29] = new int[] { 29, 11, 17,  0 };
    faces[30] = new int[] { 30,  2, 22,  3 };
    faces[31] = new int[] { 30,  3, 18,  8 };
    faces[32] = new int[] { 30,  8, 41,  7 };
    faces[33] = new int[] { 30,  7, 40,  9 };
    faces[34] = new int[] { 30,  9, 19,  2 };
    faces[35] = new int[] { 31,  2, 19, 11 };
    faces[36] = new int[] { 31, 11, 42,  6 };
    faces[37] = new int[] { 31,  6, 43, 10 };
    faces[38] = new int[] { 31, 10, 18,  3 };
    faces[39] = new int[] { 31,  3, 23,  2 };
    faces[40] = new int[] { 32,  0, 20,  6 };
    faces[41] = new int[] { 32,  6, 12,  4 };
    faces[42] = new int[] { 32,  4, 22,  2 };
    faces[43] = new int[] { 32,  2, 36,  9 };
    faces[44] = new int[] { 32,  9, 40,  0 };
    faces[45] = new int[] { 33,  1, 41,  8 };
    faces[46] = new int[] { 33,  8, 37,  3 };
    faces[47] = new int[] { 33,  3, 22,  4 };
    faces[48] = new int[] { 33,  4, 13,  6 };
    faces[49] = new int[] { 33,  6, 20,  1 };
    faces[50] = new int[] { 34,  0, 42, 11 };
    faces[51] = new int[] { 34, 11, 38,  2 };
    faces[52] = new int[] { 34,  2, 23,  5 };
    faces[53] = new int[] { 34,  5, 14,  7 };
    faces[54] = new int[] { 34,  7, 21,  0 };
    faces[55] = new int[] { 35,  1, 21,  7 };
    faces[56] = new int[] { 35,  7, 15,  5 };
    faces[57] = new int[] { 35,  5, 23,  3 };
    faces[58] = new int[] { 35,  3, 39, 10 };
    faces[59] = new int[] { 35, 10, 43,  1 };
  } //end SmallDitrigonalDodecacronicHexecontahedron()

  public String name() {
    return "Small Ditrigonal Dodecacronic Hexecontahedron";
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
   
} //end class SmallDitrigonalDodecacronicHexecontahedron
