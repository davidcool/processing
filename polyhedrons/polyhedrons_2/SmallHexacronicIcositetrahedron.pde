/*
SmallHexacronicIcositetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SmallHexacronicIcositetrahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 4;   // VERTICES per face
  final float C0 = 0.773459080339013578400241246316;  //(4 + sqrt(2)) / 7
  final float C1 = 1.41421356237309504880168872421;   //sqrt(2)
  final float C2 = 3.41421356237309504880168872421;   //2 + sqrt(2)
  private PVector[] vert = new PVector[20]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SmallHexacronicIcositetrahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, 0.0,  C2 );
    vert[  1] = new PVector( 0.0, 0.0, -C2 );
    vert[  2] = new PVector(  C2, 0.0, 0.0 );
    vert[  3] = new PVector( -C2, 0.0, 0.0 );
    vert[  4] = new PVector( 0.0,  C2, 0.0 );
    vert[  5] = new PVector( 0.0, -C2, 0.0 );
    vert[  6] = new PVector( 0.0, 0.0,  C1 );
    vert[  7] = new PVector( 0.0, 0.0, -C1 );
    vert[  8] = new PVector(  C1, 0.0, 0.0 );
    vert[  9] = new PVector( -C1, 0.0, 0.0 );
    vert[ 10] = new PVector( 0.0,  C1, 0.0 );
    vert[ 11] = new PVector( 0.0, -C1, 0.0 );
    vert[ 12] = new PVector(  C0,  C0,  C0 );
    vert[ 13] = new PVector(  C0,  C0, -C0 );
    vert[ 14] = new PVector(  C0, -C0,  C0 );
    vert[ 15] = new PVector(  C0, -C0, -C0 );
    vert[ 16] = new PVector( -C0,  C0,  C0 );
    vert[ 17] = new PVector( -C0,  C0, -C0 );
    vert[ 18] = new PVector( -C0, -C0,  C0 );
    vert[ 19] = new PVector( -C0, -C0, -C0 );
    // set faces
    faces[ 0] = new int[] { 12,  0,  8,  4 };
    faces[ 1] = new int[] { 12,  4,  6,  2 };
    faces[ 2] = new int[] { 12,  2, 10,  0 };
    faces[ 3] = new int[] { 13,  1, 10,  2 };
    faces[ 4] = new int[] { 13,  2,  7,  4 };
    faces[ 5] = new int[] { 13,  4,  8,  1 };
    faces[ 6] = new int[] { 14,  0, 11,  2 };
    faces[ 7] = new int[] { 14,  2,  6,  5 };
    faces[ 8] = new int[] { 14,  5,  8,  0 };
    faces[ 9] = new int[] { 15,  1,  8,  5 };
    faces[10] = new int[] { 15,  5,  7,  2 };
    faces[11] = new int[] { 15,  2, 11,  1 };
    faces[12] = new int[] { 16,  0, 10,  3 };
    faces[13] = new int[] { 16,  3,  6,  4 };
    faces[14] = new int[] { 16,  4,  9,  0 };
    faces[15] = new int[] { 17,  1,  9,  4 };
    faces[16] = new int[] { 17,  4,  7,  3 };
    faces[17] = new int[] { 17,  3, 10,  1 };
    faces[18] = new int[] { 18,  0,  9,  5 };
    faces[19] = new int[] { 18,  5,  6,  3 };
    faces[20] = new int[] { 18,  3, 11,  0 };
    faces[21] = new int[] { 19,  1, 11,  3 };
    faces[22] = new int[] { 19,  3,  7,  5 };
    faces[23] = new int[] { 19,  5,  9,  1 };
  } //end SmallHexacronicIcositetrahedron()

  public String name() {
    return "Small Hexacronic Icositetrahedron";
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
   
} //end class SmallHexacronicIcositetrahedron
