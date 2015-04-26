/*
PentagonalPrism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class PentagonalPrism extends Polyhedron {
  
  // polyhedron
  final int FACES = 7;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.262865556059566803012834542424;   //sqrt(10 * (5 - sqrt(5))) / 20
  final float C1 = 0.6881909602355867691036047909554;  //sqrt(5 * (5 + 2 * sqrt(5))) / 10
  final float C2 = 0.809016994374947424102293417183;   //(1 + sqrt(5)) / 4
  final float C3 = 0.850650808352039932181540497063;   //sqrt(10 * (5 + sqrt(5))) / 10
  private PVector[] vert = new PVector[10]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private PentagonalPrism() {   
    // set vertices
    vert[  0] = new PVector(   C2,  C0,  0.5 );
    vert[  1] = new PVector(   C2,  C0, -0.5 );
    vert[  2] = new PVector(  -C2,  C0,  0.5 );
    vert[  3] = new PVector(  -C2,  C0, -0.5 );
    vert[  4] = new PVector(  0.5, -C1,  0.5 );
    vert[  5] = new PVector(  0.5, -C1, -0.5 );
    vert[  6] = new PVector( -0.5, -C1,  0.5 );
    vert[  7] = new PVector( -0.5, -C1, -0.5 );
    vert[  8] = new PVector(  0.0,  C3,  0.5 );
    vert[  9] = new PVector(  0.0,  C3, -0.5 );
    // set faces
    faces[ 0] = new int[] { 0, 8, 2, 6, 4 };
    faces[ 1] = new int[] { 1, 5, 7, 3, 9 };
    faces[ 2] = new int[] { 0, 1, 9, 8, 8 };  //added 1x 4th number to fill gap
    faces[ 3] = new int[] { 8, 9, 3, 2, 2 };  //added 1x 4th number to fill gap
    faces[ 4] = new int[] { 2, 3, 7, 6, 6 };  //added 1x 4th number to fill gap
    faces[ 5] = new int[] { 6, 7, 5, 4, 4 };  //added 1x 4th number to fill gap
    faces[ 6] = new int[] { 4, 5, 1, 0, 0 };  //added 1x 4th number to fill gap
  } //end PentagonalPrism()

  public String name() {
    return "Pentagonal Prism";
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
   
} //end class PentagonalPrism
