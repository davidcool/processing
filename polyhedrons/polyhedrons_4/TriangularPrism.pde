/*
TriangularPrism class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TriangularPrism extends Polyhedron {
  
  // polyhedron
  final int FACES = 5;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.288675134594812882254574390251;  //sqrt(3) / 6
  final float C1 = 0.577350269189625764509148780502;  //sqrt(3) / 3
  private PVector[] vert = new PVector[6]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TriangularPrism() {   
    // set vertices
    vert[  0] = new PVector(  0.5, -C0,  0.5 );
    vert[  1] = new PVector(  0.5, -C0, -0.5 );
    vert[  2] = new PVector( -0.5, -C0,  0.5 );
    vert[  3] = new PVector( -0.5, -C0, -0.5 );
    vert[  4] = new PVector(  0.0,  C1,  0.5 );
    vert[  5] = new PVector(  0.0,  C1, -0.5 );
    // set faces
    faces[ 0] = new int[] { 0, 1, 5, 4 };
    faces[ 1] = new int[] { 4, 5, 3, 2 };
    faces[ 2] = new int[] { 2, 3, 1, 0 };
    faces[ 3] = new int[] { 0, 4, 2, 2 };  //added 1x 3rd number to fill gap
    faces[ 4] = new int[] { 1, 3, 5, 5 };  //added 1x 3rd number to fill gap
  } //end TriangularPrism()

  public String name() {
    return "Triangular Prism";
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
   
} //end class TriangularPrism
