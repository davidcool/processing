/*
Octahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Octahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 8;     // number of faces 
  final int VERTICES = 3;  // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048;  //sqrt(2) / 2
  PVector[] vert = new PVector[6]; // list of vertices
  int[][] faces = new int[FACES][VERTICES]; // list of faces (joining vertices)
  
  private Octahedron() {   
    // set vertices
    vert[ 0] = new PVector(0.0, 0.0,  C0);
    vert[ 1] = new PVector(0.0, 0.0, -C0);
    vert[ 2] = new PVector( C0, 0.0, 0.0);
    vert[ 3] = new PVector(-C0, 0.0, 0.0);
    vert[ 4] = new PVector(0.0,  C0, 0.0);
    vert[ 5] = new PVector(0.0, -C0, 0.0);
    // set faces
    faces[ 0] = new int[] {0, 2, 4};
    faces[ 1] = new int[] {0, 4, 3};
    faces[ 2] = new int[] {0, 3, 5};
    faces[ 3] = new int[] {0, 5, 2};
    faces[ 4] = new int[] {1, 2, 5};
    faces[ 5] = new int[] {1, 5, 3};
    faces[ 6] = new int[] {1, 3, 4};
    faces[ 7] = new int[] {1, 4, 2};
  } //end Octahedron()

  public String name() {
    return "Octahedron";
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

} //end class Octahedron
