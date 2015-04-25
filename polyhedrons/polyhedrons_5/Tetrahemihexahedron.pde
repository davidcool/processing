/*
Tetrahemihexahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Tetrahemihexahedron extends Polyhedron {

  // polyhedron
  final int FACES = 7;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048; //sqrt(2) / 2
  private PVector[] vert = new PVector[28]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Tetrahemihexahedron() {   
    // set vertices
    vert[ 0] = new PVector( 0.0,  0.0,   C0);
    vert[ 1] = new PVector( 0.0,  0.0,  -C0);
    vert[ 2] = new PVector(  C0,  0.0,  0.0);
    vert[ 3] = new PVector( -C0,  0.0,  0.0);
    vert[ 4] = new PVector( 0.0,   C0,  0.0);
    vert[ 5] = new PVector( 0.0,  -C0,  0.0);
    // set faces
    faces[ 0] = new int[] { 0,  2,  1,  3};
    faces[ 1] = new int[] { 0,  5,  1,  4};
    faces[ 2] = new int[] { 2,  4,  3,  5};
    faces[ 3] = new int[] { 0,  2,  4,  4}; //added 1x 3rd number to fill gap
    faces[ 4] = new int[] { 0,  3,  5,  5}; //added 1x 3rd number to fill gap
    faces[ 5] = new int[] { 1,  2,  5,  5}; //added 1x 3rd number to fill gap
    faces[ 6] = new int[] { 1,  3,  4,  4}; //added 1x 3rd number to fill gap
  } //end Tetrahemihexahedron()

  public String name() {
    return "Tetrahemihexahedron";
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

} //end class Tetrahemihexahedron
