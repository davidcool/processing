/*
PentagonalAntiprism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class PentagonalAntiprism extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.809016994374947424102293417183;  //(1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[10]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private PentagonalAntiprism() {   
    // set vertices
    vert[  0] = new PVector(  0.5,  0.0,   C0 );
    vert[  1] = new PVector(  0.5,  0.0,  -C0 );
    vert[  2] = new PVector( -0.5,  0.0,   C0 );
    vert[  3] = new PVector( -0.5,  0.0,  -C0 );
    vert[  4] = new PVector(  0.0,   C0,  0.5 );
    vert[  5] = new PVector(  0.0,   C0, -0.5 );
    vert[  6] = new PVector(  0.0,  -C0,  0.5 );
    vert[  7] = new PVector(  0.0,  -C0, -0.5 );
    vert[  8] = new PVector(   C0,  0.5,  0.0 );
    vert[  9] = new PVector(  -C0, -0.5,  0.0 );
    // set faces
    faces[ 0] = new int[] { 0, 6, 7, 1, 8 };
    faces[ 1] = new int[] { 2, 4, 5, 3, 9 };
    faces[ 2] = new int[] { 0, 4, 2, 2, 2 };  //added 2x 3rd number to fill gap
    faces[ 3] = new int[] { 0, 2, 6, 6, 6 };  //added 2x 3rd number to fill gap
    faces[ 4] = new int[] { 6, 2, 9, 9, 9 };  //added 2x 3rd number to fill gap
    faces[ 5] = new int[] { 6, 9, 7, 7, 7 };  //added 2x 3rd number to fill gap
    faces[ 6] = new int[] { 7, 9, 3, 3, 3 };  //added 2x 3rd number to fill gap
    faces[ 7] = new int[] { 7, 3, 1, 1, 1 };  //added 2x 3rd number to fill gap
    faces[ 8] = new int[] { 1, 3, 5, 5, 5 };  //added 2x 3rd number to fill gap
    faces[ 9] = new int[] { 1, 5, 8, 8, 8 };  //added 2x 3rd number to fill gap
    faces[10] = new int[] { 8, 5, 4, 4, 4 };  //added 2x 3rd number to fill gap
    faces[11] = new int[] { 8, 4, 0, 0, 0 };  //added 2x 3rd number to fill gap
  } //end PentagonalAntiprism()

  public String name() {
    return "Pentagonal Antiprism";
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
   
} //end class PentagonalAntiprism
