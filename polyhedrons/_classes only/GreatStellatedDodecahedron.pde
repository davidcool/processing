/*
GreatStellatedDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatStellatedDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;  // VERTICES per face
  final float C0 = 0.190983005625052575897706582817; // (3 - sqrt(5)) / 4
  final float C1 = 0.309016994374947424102293417183; // (sqrt(5) - 1) / 4
  PVector[] vert = new PVector[20]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private GreatStellatedDodecahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.5,  0.0,   C0);
    vert[ 1] = new PVector( 0.5,  0.0,  -C0);
    vert[ 2] = new PVector(-0.5,  0.0,   C0);
    vert[ 3] = new PVector(-0.5,  0.0,  -C0);
    vert[ 4] = new PVector( 0.0,   C0,  0.5);
    vert[ 5] = new PVector( 0.0,   C0, -0.5);
    vert[ 6] = new PVector( 0.0,  -C0,  0.5);
    vert[ 7] = new PVector( 0.0,  -C0, -0.5);
    vert[ 8] = new PVector(  C0,  0.5,  0.0);
    vert[ 9] = new PVector( -C0,  0.5,  0.0);
    vert[10] = new PVector(  C0, -0.5,  0.0);
    vert[11] = new PVector( -C0, -0.5,  0.0);
    vert[12] = new PVector( -C1,  -C1,  -C1);
    vert[13] = new PVector( -C1,  -C1,   C1);
    vert[14] = new PVector(  C1,  -C1,  -C1);
    vert[15] = new PVector(  C1,  -C1,   C1);
    vert[16] = new PVector( -C1,   C1,  -C1);
    vert[17] = new PVector( -C1,   C1,   C1);
    vert[18] = new PVector(  C1,   C1,  -C1);
    vert[19] = new PVector(  C1,   C1,   C1);
    // set faces
    faces[ 0] = new int[] {  0,  2, 14,  4, 12 };
    faces[ 1] = new int[] {  0, 12,  8, 10, 16 };
    faces[ 2] = new int[] {  0, 16,  6, 18,  2 };
    faces[ 3] = new int[] {  7,  6, 16, 10, 17 };
    faces[ 4] = new int[] {  7, 17,  1,  3, 19 };  
    faces[ 5] = new int[] {  7, 19, 11, 18,  6 };
    faces[ 6] = new int[] {  9, 11, 19,  3, 15 };
    faces[ 7] = new int[] {  9, 15,  5,  4, 14 };
    faces[ 8] = new int[] {  9, 14,  2, 18, 11 };
    faces[ 9] = new int[] { 13,  1, 17, 10,  8 };  
    faces[10] = new int[] { 13,  8, 12,  4,  5 };
    faces[11] = new int[] { 13,  5, 15,  3,  1 };
  } //end GreatStellatedDodecahedron()

  public String name() {
    return "Great Stellated Dodecahedron";
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
  
} //end class GreatStellatedDodecahedron
