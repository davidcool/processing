/*
Octahemioctahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class Octahemioctahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 12;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.7071067811865475244008443621048; //sqrt(2) / 2
  private PVector[] vert = new PVector[12]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private Octahemioctahedron() {   
    // set vertices
    vert[ 0] = new PVector(  C0, 0.0,  C0 );
    vert[ 1] = new PVector(  C0, 0.0, -C0 );
    vert[ 2] = new PVector( -C0, 0.0,  C0 );
    vert[ 3] = new PVector( -C0, 0.0, -C0 );
    vert[ 4] = new PVector(  C0,  C0, 0.0 );
    vert[ 5] = new PVector(  C0, -C0, 0.0 );
    vert[ 6] = new PVector( -C0,  C0, 0.0 );
    vert[ 7] = new PVector( -C0, -C0, 0.0 );
    vert[ 8] = new PVector( 0.0,  C0,  C0 );
    vert[ 9] = new PVector( 0.0,  C0, -C0 );
    vert[10] = new PVector( 0.0, -C0,  C0 );
    vert[11] = new PVector( 0.0, -C0, -C0 );
    // set faces
    faces[ 0] = new int[] {  0,  4,  9,  3,  7, 10 };
    faces[ 1] = new int[] {  0,  5, 11,  3,  6,  8 };
    faces[ 2] = new int[] {  1,  4,  8,  2,  7, 11 };
    faces[ 3] = new int[] {  1,  5, 10,  2,  6,  9 };
    faces[ 4] = new int[] {  0,  8,  4,  4,  4,  4 }; //added 3x 3rd number to fill gap
    faces[ 5] = new int[] {  0, 10,  5,  5,  5,  5 }; //added 3x 3rd number to fill gap
    faces[ 6] = new int[] {  1,  9,  4,  4,  4,  4 }; //added 3x 3rd number to fill gap
    faces[ 7] = new int[] {  1, 11,  5,  5,  5,  5 }; //added 3x 3rd number to fill gap
    faces[ 8] = new int[] {  2,  8,  6,  6,  6,  6 }; //added 3x 3rd number to fill gap
    faces[ 9] = new int[] {  2, 10,  7,  7,  7,  7 }; //added 3x 3rd number to fill gap
    faces[10] = new int[] {  3,  9,  6,  6,  6,  6 }; //added 3x 3rd number to fill gap
    faces[11] = new int[] {  3, 11,  7,  7,  7,  7 }; //added 3x 3rd number to fill gap
  } //end Octahemioctahedron()
 
  public String name() {
    return "Octahemioctahedron";
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
   
} //end class Octahemioctahedron
