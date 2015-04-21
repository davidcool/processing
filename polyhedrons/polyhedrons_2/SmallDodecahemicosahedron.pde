/*
SmallDodecahemicosahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallDodecahemicosahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 22;     // number of faces 
  final int VERTICES = 6;   // VERTICES per face
  final float C0 = 0.309016994374947424102293417183; //(sqrt(5) - 1) / 4
  final float C1 = 0.809016994374947424102293417183; //(1 + sqrt(5)) / 4
  private PVector[] vert = new PVector[30]; // list of vertices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallDodecahemicosahedron() {   
    // set vertices
    vert[ 0] = new PVector(  0.0,  0.0, -1.0 );
    vert[ 1] = new PVector(  0.0,  0.0,  1.0 );
    vert[ 2] = new PVector(  0.0, -1.0,  0.0 );
    vert[ 3] = new PVector(  0.0,  1.0,  0.0 );
    vert[ 4] = new PVector( -1.0,  0.0,  0.0 );
    vert[ 5] = new PVector(  1.0,  0.0,  0.0 );
    vert[ 6] = new PVector( -0.5,   C1,   C0 );
    vert[ 7] = new PVector( -0.5,   C1,  -C0 );
    vert[ 8] = new PVector(  0.5,   C1,   C0 );
    vert[ 9] = new PVector(  0.5,   C1,  -C0 );
    vert[10] = new PVector( -0.5,  -C1,   C0 );
    vert[11] = new PVector( -0.5,  -C1,  -C0 );
    vert[12] = new PVector(  0.5,  -C1,   C0 );
    vert[13] = new PVector(  0.5,  -C1,  -C0 );
    vert[14] = new PVector(   C1,   C0, -0.5 );
    vert[15] = new PVector(   C1,   C0,  0.5 );
    vert[16] = new PVector(  -C1,   C0, -0.5 );
    vert[17] = new PVector(  -C1,   C0,  0.5 );
    vert[18] = new PVector(   C1,  -C0, -0.5 );
    vert[19] = new PVector(   C1,  -C0,  0.5 );
    vert[20] = new PVector(  -C1,  -C0, -0.5 );
    vert[21] = new PVector(  -C1,  -C0,  0.5 );
    vert[22] = new PVector(   C0, -0.5,   C1 );
    vert[23] = new PVector(   C0, -0.5,  -C1 );
    vert[24] = new PVector(  -C0, -0.5,   C1 );
    vert[25] = new PVector(  -C0, -0.5,  -C1 );
    vert[26] = new PVector(   C0,  0.5,   C1 );
    vert[27] = new PVector(   C0,  0.5,  -C1 );
    vert[28] = new PVector(  -C0,  0.5,   C1 );
    vert[29] = new PVector(  -C0,  0.5,  -C1 );
    // set faces
    faces[ 0] = new int[] { 0, 14, 15,  1, 21, 20 };
    faces[ 1] = new int[] { 0, 16, 17,  1, 19, 18 };
    faces[ 2] = new int[] { 2, 22, 26,  3, 29, 25 };
    faces[ 3] = new int[] { 2, 23, 27,  3, 28, 24 };
    faces[ 4] = new int[] { 4,  6,  8,  5, 13, 11 };
    faces[ 5] = new int[] { 4,  7,  9,  5, 12, 10 };
    faces[ 6] = new int[] { 6, 16, 25, 13, 19, 26 };
    faces[ 7] = new int[] { 7, 17, 24, 12, 18, 27 };
    faces[ 8] = new int[] { 8, 14, 23, 11, 21, 28 };
    faces[ 9] = new int[] { 9, 15, 22, 10, 20, 29 };
    faces[10] = new int[] { 0, 14, 23, 27, 18, 18 }; //added 1x 5th number to fill gap
    faces[11] = new int[] { 0, 20, 29, 25, 16, 16 }; //added 1x 5th number to fill gap
    faces[12] = new int[] { 1, 17, 24, 28, 21, 21 }; //added 1x 5th number to fill gap
    faces[13] = new int[] { 1, 19, 26, 22, 15, 15 }; //added 1x 5th number to fill gap
    faces[14] = new int[] { 2, 22, 10, 12, 24, 24 }; //added 1x 5th number to fill gap
    faces[15] = new int[] { 2, 25, 13, 11, 23, 23 }; //added 1x 5th number to fill gap
    faces[16] = new int[] { 3, 27,  7,  9, 29, 29 }; //added 1x 5th number to fill gap
    faces[17] = new int[] { 3, 28,  8,  6, 26, 26 }; //added 1x 5th number to fill gap
    faces[18] = new int[] { 4,  6, 16, 17,  7,  7 }; //added 1x 5th number to fill gap
    faces[19] = new int[] { 4, 11, 21, 20, 10, 10 }; //added 1x 5th number to fill gap
    faces[20] = new int[] { 5, 12, 18, 19, 13, 13 }; //added 1x 5th number to fill gap
    faces[21] = new int[] { 5,  9, 15, 14,  8,  8 }; //added 1x 5th number to fill gap
  } //end SmallDodecahemicosahedron()

  public String name() {
    return "Small Dodecahemicosahedron";
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
   
} //end class SmallDodecahemicosahedron
