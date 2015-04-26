/*
RhombicDodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class RhombicDodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.530330085889910643300633271579;  //3 * sqrt(2) / 8
  final float C1 = 1.06066017177982128660126654316;   //3 * sqrt(2) / 4
  private PVector[] vert = new PVector[14]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private RhombicDodecahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, 0.0,  C1 );
    vert[  1] = new PVector( 0.0, 0.0, -C1 );
    vert[  2] = new PVector(  C1, 0.0, 0.0 );
    vert[  3] = new PVector( -C1, 0.0, 0.0 );
    vert[  4] = new PVector( 0.0,  C1, 0.0 );
    vert[  5] = new PVector( 0.0, -C1, 0.0 );
    vert[  6] = new PVector(  C0,  C0,  C0 );
    vert[  7] = new PVector(  C0,  C0, -C0 );
    vert[  8] = new PVector(  C0, -C0,  C0 );
    vert[  9] = new PVector(  C0, -C0, -C0 );
    vert[ 10] = new PVector( -C0,  C0,  C0 );
    vert[ 11] = new PVector( -C0,  C0, -C0 );
    vert[ 12] = new PVector( -C0, -C0,  C0 );
    vert[ 13] = new PVector( -C0, -C0, -C0 );
    // set faces
    faces[  0] = new int[] {  6,  0,  8,  2 };
    faces[  1] = new int[] {  6,  2,  7,  4 };
    faces[  2] = new int[] {  6,  4, 10,  0 };
    faces[  3] = new int[] {  9,  1,  7,  2 };
    faces[  4] = new int[] {  9,  2,  8,  5 };
    faces[  5] = new int[] {  9,  5, 13,  1 };
    faces[  6] = new int[] { 11,  1, 13,  3 };
    faces[  7] = new int[] { 11,  3, 10,  4 };
    faces[  8] = new int[] { 11,  4,  7,  1 };
    faces[  9] = new int[] { 12,  0, 10,  3 };
    faces[ 10] = new int[] { 12,  3, 13,  5 };
    faces[ 11] = new int[] { 12,  5,  8,  0 };
  } //end RhombicDodecahedron()

  public String name() {
    return "Rhombic Dodecahedron";
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
   
} //end class RhombicDodecahedron
