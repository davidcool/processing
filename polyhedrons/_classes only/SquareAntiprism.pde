/*
SquareAntiprism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SquareAntiprism extends Polyhedron {
  
  // polyhedron
  final int FACES = 10;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.420448207626857271515562738117;   //sqrt(2 * sqrt(2)) / 4
  final float C1 = 0.7071067811865475244008443621048;  //sqrt(2) / 2
  private PVector[] vert = new PVector[8]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SquareAntiprism() {   
    // set vertices
    vert[  0] = new PVector(  0.5,  0.5,  C0 );
    vert[  1] = new PVector(  0.5, -0.5,  C0 );
    vert[  2] = new PVector( -0.5,  0.5,  C0 );
    vert[  3] = new PVector( -0.5, -0.5,  C0 );
    vert[  4] = new PVector(   C1,  0.0, -C0 );
    vert[  5] = new PVector(  -C1,  0.0, -C0 );
    vert[  6] = new PVector(  0.0,   C1, -C0 );
    vert[  7] = new PVector(  0.0,  -C1, -C0 );
    // set faces
    faces[ 0] = new int[] { 0, 2, 3, 1 };
    faces[ 1] = new int[] { 4, 7, 5, 6 };
    faces[ 2] = new int[] { 0, 1, 4, 4 };  //added 1x 3rd number to fill gap
    faces[ 3] = new int[] { 0, 4, 6, 6 };  //added 1x 3rd number to fill gap
    faces[ 4] = new int[] { 1, 3, 7, 7 };  //added 1x 3rd number to fill gap
    faces[ 5] = new int[] { 1, 7, 4, 4 };  //added 1x 3rd number to fill gap
    faces[ 6] = new int[] { 2, 0, 6, 6 };  //added 1x 3rd number to fill gap
    faces[ 7] = new int[] { 2, 6, 5, 5 };  //added 1x 3rd number to fill gap
    faces[ 8] = new int[] { 3, 2, 5, 5 };  //added 1x 3rd number to fill gap
    faces[ 9] = new int[] { 3, 5, 7, 7 };  //added 1x 3rd number to fill gap
  } //end SquareAntiprism()

  public String name() {
    return "Square Antiprism";
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
   
} //end class SquareAntiprism
