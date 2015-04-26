/*
TriakisTetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class TriakisTetrahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 3;   // VERTICES per face
  final float C0 = 0.636396103067892771960759925894;  //9 * sqrt(2) / 20
  final float C1 = 1.06066017177982128660126654316;   //3 * sqrt(2) / 4
  private PVector[] vert = new PVector[8]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private TriakisTetrahedron() {   
    // set vertices
    vert[  0] = new PVector(  C1,  C1,  C1 );
    vert[  1] = new PVector(  C1, -C1, -C1 );
    vert[  2] = new PVector( -C1, -C1,  C1 );
    vert[  3] = new PVector( -C1,  C1, -C1 );
    vert[  4] = new PVector(  C0, -C0,  C0 );
    vert[  5] = new PVector(  C0,  C0, -C0 );
    vert[  6] = new PVector( -C0,  C0,  C0 );
    vert[  7] = new PVector( -C0, -C0, -C0 );
    // set faces
    faces[  0] = new int[] { 4, 0, 2 };
    faces[  1] = new int[] { 4, 2, 1 };
    faces[  2] = new int[] { 4, 1, 0 };
    faces[  3] = new int[] { 5, 0, 1 };
    faces[  4] = new int[] { 5, 1, 3 };
    faces[  5] = new int[] { 5, 3, 0 };
    faces[  6] = new int[] { 6, 0, 3 };
    faces[  7] = new int[] { 6, 3, 2 };
    faces[  8] = new int[] { 6, 2, 0 };
    faces[  9] = new int[] { 7, 1, 2 };
    faces[ 10] = new int[] { 7, 2, 3 };
    faces[ 11] = new int[] { 7, 3, 1 };
  } //end TriakisTetrahedron()

  public String name() {
    return "Triakis Tetrahedron";
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
   
} //end class TriakisTetrahedron
