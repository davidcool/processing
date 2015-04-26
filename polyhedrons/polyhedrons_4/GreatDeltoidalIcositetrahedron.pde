/*
GreatDeltoidalIcositetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatDeltoidalIcositetrahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.369398062518129278742615896541;  //(4 - sqrt(2)) / 7
  final float C1 = 1.41421356237309504880168872421;   //sqrt(2)
  private PVector[] vert = new PVector[26]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatDeltoidalIcositetrahedron() {   
    // set vertices
    vert[  0] = new PVector(  0.0,  0.0,   C1 );
    vert[  1] = new PVector(  0.0,  0.0,  -C1 );
    vert[  2] = new PVector(   C1,  0.0,  0.0 );
    vert[  3] = new PVector(  -C1,  0.0,  0.0 );
    vert[  4] = new PVector(  0.0,   C1,  0.0 );
    vert[  5] = new PVector(  0.0,  -C1,  0.0 );
    vert[  6] = new PVector( -1.0,  0.0, -1.0 );
    vert[  7] = new PVector( -1.0,  0.0,  1.0 );
    vert[  8] = new PVector(  1.0,  0.0, -1.0 );
    vert[  9] = new PVector(  1.0,  0.0,  1.0 );
    vert[ 10] = new PVector( -1.0, -1.0,  0.0 );
    vert[ 11] = new PVector( -1.0,  1.0,  0.0 );
    vert[ 12] = new PVector(  1.0, -1.0,  0.0 );
    vert[ 13] = new PVector(  1.0,  1.0,  0.0 );
    vert[ 14] = new PVector(  0.0, -1.0, -1.0 );
    vert[ 15] = new PVector(  0.0, -1.0,  1.0 );
    vert[ 16] = new PVector(  0.0,  1.0, -1.0 );
    vert[ 17] = new PVector(  0.0,  1.0,  1.0 );
    vert[ 18] = new PVector(  -C0,  -C0,  -C0 );
    vert[ 19] = new PVector(  -C0,  -C0,   C0 );
    vert[ 20] = new PVector(  -C0,   C0,  -C0 );
    vert[ 21] = new PVector(  -C0,   C0,   C0 );
    vert[ 22] = new PVector(   C0,  -C0,  -C0 );
    vert[ 23] = new PVector(   C0,  -C0,   C0 );
    vert[ 24] = new PVector(   C0,   C0,  -C0 );
    vert[ 25] = new PVector(   C0,   C0,   C0 );
    // set faces
    faces[ 0] = new int[] { 0,  6, 18, 14 };
    faces[ 1] = new int[] { 0, 14, 22,  8 };
    faces[ 2] = new int[] { 0,  8, 24, 16 };
    faces[ 3] = new int[] { 0, 16, 20,  6 };
    faces[ 4] = new int[] { 1,  9, 23, 15 };
    faces[ 5] = new int[] { 1, 15, 19,  7 };
    faces[ 6] = new int[] { 1,  7, 21, 17 };
    faces[ 7] = new int[] { 1, 17, 25,  9 };
    faces[ 8] = new int[] { 2,  7, 19, 10 };
    faces[ 9] = new int[] { 2, 10, 18,  6 };
    faces[10] = new int[] { 2,  6, 20, 11 };
    faces[11] = new int[] { 2, 11, 21,  7 };
    faces[12] = new int[] { 3,  8, 22, 12 };
    faces[13] = new int[] { 3, 12, 23,  9 };
    faces[14] = new int[] { 3,  9, 25, 13 };
    faces[15] = new int[] { 3, 13, 24,  8 };
    faces[16] = new int[] { 4, 10, 19, 15 };
    faces[17] = new int[] { 4, 15, 23, 12 };
    faces[18] = new int[] { 4, 12, 22, 14 };
    faces[19] = new int[] { 4, 14, 18, 10 };
    faces[20] = new int[] { 5, 11, 20, 16 };
    faces[21] = new int[] { 5, 16, 24, 13 };
    faces[22] = new int[] { 5, 13, 25, 17 };
    faces[23] = new int[] { 5, 17, 21, 11 };
  } //end GreatDeltoidalIcositetrahedron()

  public String name() {
    return "Great Deltoidal Icositetrahedron";
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
   
} //end class GreatDeltoidalIcositetrahedron
