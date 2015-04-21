/*
SnubIcosidodecadodecahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class SnubIcosidodecadodecahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 104;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.105398765906697216676314189282; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C1  = 0.139623637868037118589881535187; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 3840*(x^4) - 1792*(x^3) + 480*(x^2) - 60*x + 1
  final float C2  = 0.184961940339626297836961737414; //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) - 1024*(x^4) + 64*(x^3) + 80*(x^2) - 32*x + 1
  final float C3  = 0.245022403774734335266195724469; //square-root of a root of the polynomial:  4096*(x^6) - 2048*(x^5) - 1536*(x^4) - 704*(x^3) - 96*(x^2) - 8*x + 1
  final float C4  = 0.410877732043017261285800591418; //sqrt(6 * (12 - cbrt(12*(9 + sqrt(69))) - cbrt(12*(9 - sqrt(69))))) / 12
  final float C5  = 0.438898343962682737883306417824; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 1536*(x^4) - 512*(x^3) + 544*(x^2) - 96*x + 1
  final float C6  = 0.525190497798036582742263736641; //square-root of a root of the polynomial:  4096*(x^6) - 7168*(x^5) + 5120*(x^4) - 1664*(x^3) + 96*(x^2) + 24*x + 1
  final float C7  = 0.544297109869379954559620607106; //sqrt(6*(2+cbrt(4*(101 + 15*sqrt(69)))-cbrt(4*(15*sqrt(69) - 101)))) / 12
  final float C8  = 0.581416517652346986253630835588; //square-root of a root of the polynomial:  4096*(x^6) - 5120*(x^5) + 3840*(x^4) - 1792*(x^3) + 480*(x^2) - 60*x + 1
  final float C9  = 0.695729283407366307710093980810; //square-root of a root of the polynomial:  4096*(x^6) - 10240*(x^5) + 8960*(x^4) - 3648*(x^3) + 640*(x^2) - 20*x + 1
  final float C10 = 0.770212901572770918008459461110; //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) - 1024*(x^4) + 64*(x^3) + 80*(x^2) - 32*x + 1
  final float C11 = 0.835352921275403426299975515997; //square-root of a root of the polynomial:  4096*(x^6) - 7168*(x^5) + 5120*(x^4) - 1664*(x^3) + 96*(x^2) + 24*x + 1
  final float C12 = 0.955174841912397215845421198524; //sqrt(3 * (3 + cbrt(12 * (9 + sqrt(69))) + cbrt(12 * (9 - sqrt(69))))) / 6
  final float C13 = 1.02031486161502972413693725341;  //square-root of a root of the polynomial:  4096*(x^6) - 2048*(x^5) - 1536*(x^4) - 704*(x^3) - 96*(x^2) - 8*x + 1
  final float C14 = 1.10660701545038356899589457223;  //square-root of a root of the polynomial:  4096*(x^6) - 10240*(x^5) + 8960*(x^4) - 3648*(x^3) + 640*(x^2) - 20*x + 1

  private PVector[] vert = new PVector[60]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private SnubIcosidodecadodecahedron() {   
    // set vertices
    vert[  0] = new PVector(   C0,  -C2,  C14 );
    vert[  1] = new PVector(   C0,   C2, -C14 );
    vert[  2] = new PVector(  -C0,   C2,  C14 );
    vert[  3] = new PVector(  -C0,  -C2, -C14 );
    vert[  4] = new PVector(  C14,  -C0,   C2 );
    vert[  5] = new PVector(  C14,   C0,  -C2 );
    vert[  6] = new PVector( -C14,   C0,   C2 );
    vert[  7] = new PVector( -C14,  -C0,  -C2 );
    vert[  8] = new PVector(   C2, -C14,   C0 );
    vert[  9] = new PVector(   C2,  C14,  -C0 );
    vert[ 10] = new PVector(  -C2,  C14,   C0 );
    vert[ 11] = new PVector(  -C2, -C14,  -C0 );
    vert[ 12] = new PVector(   C3,   C4,  C13 );
    vert[ 13] = new PVector(   C3,  -C4, -C13 );
    vert[ 14] = new PVector(  -C3,  -C4,  C13 );
    vert[ 15] = new PVector(  -C3,   C4, -C13 );
    vert[ 16] = new PVector(  C13,   C3,   C4 );
    vert[ 17] = new PVector(  C13,  -C3,  -C4 );
    vert[ 18] = new PVector( -C13,  -C3,   C4 );
    vert[ 19] = new PVector( -C13,   C3,  -C4 );
    vert[ 20] = new PVector(   C4,  C13,   C3 );
    vert[ 21] = new PVector(   C4, -C13,  -C3 );
    vert[ 22] = new PVector(  -C4, -C13,   C3 );
    vert[ 23] = new PVector(  -C4,  C13,  -C3 );
    vert[ 24] = new PVector(   C1,  -C8,  C12 );
    vert[ 25] = new PVector(   C1,   C8, -C12 );
    vert[ 26] = new PVector(  -C1,   C8,  C12 );
    vert[ 27] = new PVector(  -C1,  -C8, -C12 );
    vert[ 28] = new PVector(  C12,  -C1,   C8 );
    vert[ 29] = new PVector(  C12,   C1,  -C8 );
    vert[ 30] = new PVector( -C12,   C1,   C8 );
    vert[ 31] = new PVector( -C12,  -C1,  -C8 );
    vert[ 32] = new PVector(   C8, -C12,   C1 );
    vert[ 33] = new PVector(   C8,  C12,  -C1 );
    vert[ 34] = new PVector(  -C8,  C12,   C1 );
    vert[ 35] = new PVector(  -C8, -C12,  -C1 );
    vert[ 36] = new PVector(   C7,  -C6,  C11 );
    vert[ 37] = new PVector(   C7,   C6, -C11 );
    vert[ 38] = new PVector(  -C7,   C6,  C11 );
    vert[ 39] = new PVector(  -C7,  -C6, -C11 );
    vert[ 40] = new PVector(  C11,  -C7,   C6 );
    vert[ 41] = new PVector(  C11,   C7,  -C6 );
    vert[ 42] = new PVector( -C11,   C7,   C6 );
    vert[ 43] = new PVector( -C11,  -C7,  -C6 );
    vert[ 44] = new PVector(   C6, -C11,   C7 );
    vert[ 45] = new PVector(   C6,  C11,  -C7 );
    vert[ 46] = new PVector(  -C6,  C11,   C7 );
    vert[ 47] = new PVector(  -C6, -C11,  -C7 );
    vert[ 48] = new PVector(   C5,   C9,  C10 );
    vert[ 49] = new PVector(   C5,  -C9, -C10 );
    vert[ 50] = new PVector(  -C5,  -C9,  C10 );
    vert[ 51] = new PVector(  -C5,   C9, -C10 );
    vert[ 52] = new PVector(  C10,   C5,   C9 );
    vert[ 53] = new PVector(  C10,  -C5,  -C9 );
    vert[ 54] = new PVector( -C10,  -C5,   C9 );
    vert[ 55] = new PVector( -C10,   C5,  -C9 );
    vert[ 56] = new PVector(   C9,  C10,   C5 );
    vert[ 57] = new PVector(   C9, -C10,  -C5 );
    vert[ 58] = new PVector(  -C9, -C10,   C5 );
    vert[ 59] = new PVector(  -C9,  C10,  -C5 );
    // set faces
    faces[  0] = new int[] {  0, 52, 36, 12, 28 };
    faces[  1] = new int[] {  1, 53, 37, 13, 29 };
    faces[  2] = new int[] {  2, 54, 38, 14, 30 };
    faces[  3] = new int[] {  3, 55, 39, 15, 31 };
    faces[  4] = new int[] {  4, 57, 40, 17, 32 };
    faces[  5] = new int[] {  5, 56, 41, 16, 33 };
    faces[  6] = new int[] {  6, 59, 42, 19, 34 };
    faces[  7] = new int[] {  7, 58, 43, 18, 35 };
    faces[  8] = new int[] {  8, 50, 44, 22, 24 };
    faces[  9] = new int[] {  9, 51, 45, 23, 25 };
    faces[ 10] = new int[] { 10, 48, 46, 20, 26 };
    faces[ 11] = new int[] { 11, 49, 47, 21, 27 };
    faces[ 12] = new int[] {  0, 54, 35, 21, 40 };
    faces[ 13] = new int[] {  1, 55, 34, 20, 41 };
    faces[ 14] = new int[] {  2, 52, 33, 23, 42 };
    faces[ 15] = new int[] {  3, 53, 32, 22, 43 };
    faces[ 16] = new int[] {  4, 56, 26, 14, 44 };
    faces[ 17] = new int[] {  5, 57, 27, 15, 45 };
    faces[ 18] = new int[] {  6, 58, 24, 12, 46 };
    faces[ 19] = new int[] {  7, 59, 25, 13, 47 };
    faces[ 20] = new int[] {  8, 49, 29, 16, 36 };
    faces[ 21] = new int[] {  9, 48, 28, 17, 37 };
    faces[ 22] = new int[] { 10, 51, 31, 18, 38 };
    faces[ 23] = new int[] { 11, 50, 30, 19, 39 };
    faces[ 24] = new int[] {  0, 28, 48, 48, 48 };  //added 2x 3rd row to fill gaps
    faces[ 25] = new int[] {  1, 29, 49, 49, 49 };  //added 2x 3rd row to fill gaps
    faces[ 26] = new int[] {  2, 30, 50, 50, 50 };  //added 2x 3rd row to fill gaps
    faces[ 27] = new int[] {  3, 31, 51, 51, 51 };  //added 2x 3rd row to fill gaps
    faces[ 28] = new int[] {  4, 32, 53, 53, 53 };  //added 2x 3rd row to fill gaps
    faces[ 29] = new int[] {  5, 33, 52, 52, 52 };  //added 2x 3rd row to fill gaps
    faces[ 30] = new int[] {  6, 34, 55, 55, 55 };  //added 2x 3rd row to fill gaps
    faces[ 31] = new int[] {  7, 35, 54, 54, 54 };  //added 2x 3rd row to fill gaps
    faces[ 32] = new int[] {  8, 24, 58, 58, 58 };  //added 2x 3rd row to fill gaps
    faces[ 33] = new int[] {  9, 25, 59, 59, 59 };  //added 2x 3rd row to fill gaps
    faces[ 34] = new int[] { 10, 26, 56, 56, 56 };  //added 2x 3rd row to fill gaps
    faces[ 35] = new int[] { 11, 27, 57, 57, 57 };  //added 2x 3rd row to fill gaps
    faces[ 36] = new int[] { 12, 20, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 37] = new int[] { 13, 21, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 38] = new int[] { 14, 22, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 39] = new int[] { 15, 23, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 40] = new int[] { 16, 12, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 41] = new int[] { 17, 13, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 42] = new int[] { 18, 14, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 43] = new int[] { 19, 15, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 44] = new int[] { 20, 16, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 45] = new int[] { 21, 17, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 46] = new int[] { 22, 18, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 47] = new int[] { 23, 19, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 48] = new int[] { 24, 28, 12, 12, 12 };  //added 2x 3rd row to fill gaps
    faces[ 49] = new int[] { 25, 29, 13, 13, 13 };  //added 2x 3rd row to fill gaps
    faces[ 50] = new int[] { 26, 30, 14, 14, 14 };  //added 2x 3rd row to fill gaps
    faces[ 51] = new int[] { 27, 31, 15, 15, 15 };  //added 2x 3rd row to fill gaps
    faces[ 52] = new int[] { 28, 32, 17, 17, 17 };  //added 2x 3rd row to fill gaps
    faces[ 53] = new int[] { 29, 33, 16, 16, 16 };  //added 2x 3rd row to fill gaps
    faces[ 54] = new int[] { 30, 34, 19, 19, 19 };  //added 2x 3rd row to fill gaps
    faces[ 55] = new int[] { 31, 35, 18, 18, 18 };  //added 2x 3rd row to fill gaps
    faces[ 56] = new int[] { 32, 24, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 57] = new int[] { 33, 25, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[ 58] = new int[] { 34, 26, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 59] = new int[] { 35, 27, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 60] = new int[] { 36, 50,  8,  8,  8 };  //added 2x 3rd row to fill gaps
    faces[ 61] = new int[] { 37, 51,  9,  9,  9 };  //added 2x 3rd row to fill gaps
    faces[ 62] = new int[] { 38, 48, 10, 10, 10 };  //added 2x 3rd row to fill gaps
    faces[ 63] = new int[] { 39, 49, 11, 11, 11 };  //added 2x 3rd row to fill gaps
    faces[ 64] = new int[] { 40, 52,  0,  0,  0 };  //added 2x 3rd row to fill gaps
    faces[ 65] = new int[] { 41, 53,  1,  1,  1 };  //added 2x 3rd row to fill gaps
    faces[ 66] = new int[] { 42, 54,  2,  2,  2 };  //added 2x 3rd row to fill gaps
    faces[ 67] = new int[] { 43, 55,  3,  3,  3 };  //added 2x 3rd row to fill gaps
    faces[ 68] = new int[] { 44, 57,  4,  4,  4 };  //added 2x 3rd row to fill gaps
    faces[ 69] = new int[] { 45, 56,  5,  5,  5 };  //added 2x 3rd row to fill gaps
    faces[ 70] = new int[] { 46, 59,  6,  6,  6 };  //added 2x 3rd row to fill gaps
    faces[ 71] = new int[] { 47, 58,  7,  7,  7 };  //added 2x 3rd row to fill gaps
    faces[ 72] = new int[] { 48,  9, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 73] = new int[] { 49,  8, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 74] = new int[] { 50, 11, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 75] = new int[] { 51, 10, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 76] = new int[] { 52,  2, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 77] = new int[] { 53,  3, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 78] = new int[] { 54,  0, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 79] = new int[] { 55,  1, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 80] = new int[] { 56,  4, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 81] = new int[] { 57,  5, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 82] = new int[] { 58,  6, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 83] = new int[] { 59,  7, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 84] = new int[] {  0, 48, 38, 38, 38 };  //added 2x 3rd row to fill gaps
    faces[ 85] = new int[] {  1, 49, 39, 39, 39 };  //added 2x 3rd row to fill gaps
    faces[ 86] = new int[] {  2, 50, 36, 36, 36 };  //added 2x 3rd row to fill gaps
    faces[ 87] = new int[] {  3, 51, 37, 37, 37 };  //added 2x 3rd row to fill gaps
    faces[ 88] = new int[] {  4, 53, 41, 41, 41 };  //added 2x 3rd row to fill gaps
    faces[ 89] = new int[] {  5, 52, 40, 40, 40 };  //added 2x 3rd row to fill gaps
    faces[ 90] = new int[] {  6, 55, 43, 43, 43 };  //added 2x 3rd row to fill gaps
    faces[ 91] = new int[] {  7, 54, 42, 42, 42 };  //added 2x 3rd row to fill gaps
    faces[ 92] = new int[] {  8, 58, 47, 47, 47 };  //added 2x 3rd row to fill gaps
    faces[ 93] = new int[] {  9, 59, 46, 46, 46 };  //added 2x 3rd row to fill gaps
    faces[ 94] = new int[] { 10, 56, 45, 45, 45 };  //added 2x 3rd row to fill gaps
    faces[ 95] = new int[] { 11, 57, 44, 44, 44 };  //added 2x 3rd row to fill gaps
    faces[ 96] = new int[] { 12, 16, 20, 20, 20 };  //added 2x 3rd row to fill gaps
    faces[ 97] = new int[] { 13, 17, 21, 21, 21 };  //added 2x 3rd row to fill gaps
    faces[ 98] = new int[] { 14, 18, 22, 22, 22 };  //added 2x 3rd row to fill gaps
    faces[ 99] = new int[] { 15, 19, 23, 23, 23 };  //added 2x 3rd row to fill gaps
    faces[100] = new int[] { 24, 32, 28, 28, 28 };  //added 2x 3rd row to fill gaps
    faces[101] = new int[] { 25, 33, 29, 29, 29 };  //added 2x 3rd row to fill gaps
    faces[102] = new int[] { 26, 34, 30, 30, 30 };  //added 2x 3rd row to fill gaps
    faces[103] = new int[] { 27, 35, 31, 31, 31 };  //added 2x 3rd row to fill gaps
  } //end SnubIcosidodecadodecahedron()

  public String name() {
    return "Snub Icosidodecadodecahedron";
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
   
} //end class SnubIcosidodecadodecahedron
