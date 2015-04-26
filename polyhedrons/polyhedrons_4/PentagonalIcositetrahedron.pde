/*
PentagonalIcositetrahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class PentagonalIcositetrahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 24;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0 = 0.218796643000480441021525033712;  //sqrt(6 * (cbrt(6*(9 + sqrt(33))) + cbrt(6*(9 - sqrt(33))) - 6)) / 12
  final float C1 = 0.740183741369857222808508165943;  //sqrt(6 * (6 + cbrt(6*(9 + sqrt(33))) + cbrt(6*(9 - sqrt(33))))) / 12
  final float C2 = 1.02365617811269018236347687527;  //sqrt(6 * (18 + cbrt(6*(9 + sqrt(33))) + cbrt(6*(9 - sqrt(33))))) / 12
  final float C3 = 1.36141015192644253450100912043;  //sqrt(6 * (14+cbrt(2*(1777+33*sqrt(33)))+cbrt(2*(1777-33*sqrt(33))))) / 12
  private PVector[] vert = new PVector[38]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private PentagonalIcositetrahedron() {   
    // set vertices
    vert[  0] = new PVector( 0.0, 0.0, -C3 );
    vert[  1] = new PVector( 0.0, 0.0,  C3 );
    vert[  2] = new PVector( -C3, 0.0, 0.0 );
    vert[  3] = new PVector(  C3, 0.0, 0.0 );
    vert[  4] = new PVector( 0.0, -C3, 0.0 );
    vert[  5] = new PVector( 0.0,  C3, 0.0 );
    vert[  6] = new PVector( -C1,  C0, -C2 );
    vert[  7] = new PVector( -C1, -C0,  C2 );
    vert[  8] = new PVector(  C1, -C0, -C2 );
    vert[  9] = new PVector(  C1,  C0,  C2 );
    vert[ 10] = new PVector( -C2,  C1, -C0 );
    vert[ 11] = new PVector( -C2, -C1,  C0 );
    vert[ 12] = new PVector(  C2, -C1, -C0 );
    vert[ 13] = new PVector(  C2,  C1,  C0 );
    vert[ 14] = new PVector( -C0,  C2, -C1 );
    vert[ 15] = new PVector( -C0, -C2,  C1 );
    vert[ 16] = new PVector(  C0, -C2, -C1 );
    vert[ 17] = new PVector(  C0,  C2,  C1 );
    vert[ 18] = new PVector( -C0, -C1, -C2 );
    vert[ 19] = new PVector( -C0,  C1,  C2 );
    vert[ 20] = new PVector(  C0,  C1, -C2 );
    vert[ 21] = new PVector(  C0, -C1,  C2 );
    vert[ 22] = new PVector( -C2, -C0, -C1 );
    vert[ 23] = new PVector( -C2,  C0,  C1 );
    vert[ 24] = new PVector(  C2,  C0, -C1 );
    vert[ 25] = new PVector(  C2, -C0,  C1 );
    vert[ 26] = new PVector( -C1, -C2, -C0 );
    vert[ 27] = new PVector( -C1,  C2,  C0 );
    vert[ 28] = new PVector(  C1,  C2, -C0 );
    vert[ 29] = new PVector(  C1, -C2,  C0 );
    vert[ 30] = new PVector( -C1, -C1, -C1 );
    vert[ 31] = new PVector( -C1, -C1,  C1 );
    vert[ 32] = new PVector( -C1,  C1, -C1 );
    vert[ 33] = new PVector( -C1,  C1,  C1 );
    vert[ 34] = new PVector(  C1, -C1, -C1 );
    vert[ 35] = new PVector(  C1, -C1,  C1 );
    vert[ 36] = new PVector(  C1,  C1, -C1 );
    vert[ 37] = new PVector(  C1,  C1,  C1 );
    // set faces
    faces[  0] = new int[] { 0, 18, 30, 22,  6 };
    faces[  1] = new int[] { 0,  8, 34, 16, 18 };
    faces[  2] = new int[] { 0, 20, 36, 24,  8 };
    faces[  3] = new int[] { 0,  6, 32, 14, 20 };
    faces[  4] = new int[] { 1, 19, 33, 23,  7 };
    faces[  5] = new int[] { 1,  9, 37, 17, 19 };
    faces[  6] = new int[] { 1, 21, 35, 25,  9 };
    faces[  7] = new int[] { 1,  7, 31, 15, 21 };
    faces[  8] = new int[] { 2, 23, 33, 27, 10 };
    faces[  9] = new int[] { 2, 11, 31,  7, 23 };
    faces[ 10] = new int[] { 2, 22, 30, 26, 11 };
    faces[ 11] = new int[] { 2, 10, 32,  6, 22 };
    faces[ 12] = new int[] { 3, 25, 35, 29, 12 };
    faces[ 13] = new int[] { 3, 13, 37,  9, 25 };
    faces[ 14] = new int[] { 3, 24, 36, 28, 13 };
    faces[ 15] = new int[] { 3, 12, 34,  8, 24 };
    faces[ 16] = new int[] { 4, 29, 35, 21, 15 };
    faces[ 17] = new int[] { 4, 16, 34, 12, 29 };
    faces[ 18] = new int[] { 4, 26, 30, 18, 16 };
    faces[ 19] = new int[] { 4, 15, 31, 11, 26 };
    faces[ 20] = new int[] { 5, 28, 36, 20, 14 };
    faces[ 21] = new int[] { 5, 17, 37, 13, 28 };
    faces[ 22] = new int[] { 5, 27, 33, 19, 17 };
    faces[ 23] = new int[] { 5, 14, 32, 10, 27 };
  } //end PentagonalIcositetrahedron()

  public String name() {
    return "Pentagonal Icositetrahedron (laevo)";
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
   
} //end class PentagonalIcositetrahedron
