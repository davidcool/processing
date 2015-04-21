/*
Tetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Tetrahedron extends Polyhedron {

  // polyhedron
  final int FACES = 4;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.353553390593273762200422181052; // sqrt(2) / 4
  private PVector[] vert = new PVector[20]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Tetrahedron() {   
    // set vertices
    vert[ 0] = new PVector( C0, -C0,  C0);
    vert[ 1] = new PVector( C0,  C0, -C0);
    vert[ 2] = new PVector(-C0,  C0,  C0);
    vert[ 3] = new PVector(-C0, -C0, -C0);
    // set faces
    faces[ 0] = new int[] {0, 1, 2};
    faces[ 1] = new int[] {1, 0, 3};
    faces[ 2] = new int[] {2, 3, 0};
    faces[ 3] = new int[] {3, 2, 1};
  } //end Tetrahedron()

  public String name() {
    return "Tetrahedron";
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
  
} //end class Tetrahedron
