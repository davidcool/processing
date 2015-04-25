/*
GreatInvertedPentagonalHexecontahedron class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public class GreatInvertedPentagonalHexecontahedron extends Polyhedron {
  
  // polyhedron
  final int FACES = 60;     // number of faces 
  final int VERTICES = 5;   // VERTICES per face
  final float C0  = 0.0374913943475815612447678400668;    //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) + 16896*(x^4) - 14528*(x^3) + 6112*(x^2) - 720*x + 1
  final float C1  = 0.0926952885354777710872481278869;    //square-root of a root of the polynomial:  4096*(x^6) - 1024*(x^5) + 4096*(x^4) - 4672*(x^3) + 1392*(x^2) - 128*x + 1
  final float C2  = 0.104151922611206820966596455724;     //square-root of a root of the polynomial:  4096*(x^6) - 18432*(x^5) + 16384*(x^4) - 8960*(x^3) + 8928*(x^2) - 188*x + 1
  final float C3  = 0.153357638875490426256644060007;     //square-root of a root of the polynomial:  4096*(x^6) + 3072*(x^5) - 16128*(x^4) - 17152*(x^3) + 2176*(x^2) - 84*x + 1
  final float C4  = 0.187475521794963058008011505776;     //square-root of a root of the polynomial:  4096*(x^6) + 6144*(x^5) + 4352*(x^4) - 3456*(x^3) + 672*(x^2) - 48*x + 1
  final float C5  = 0.196847211146684592053844583611;     //square-root of a root of the polynomial:  4096*(x^6) - 27648*(x^5) + 72704*(x^4) - 92160*(x^3) + 54448*(x^2) - 11292*x + 361
  final float C6  = 0.206012745126162897462898732354;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 14592*(x^4) - 4736*(x^3) + 752*(x^2) - 48*x + 1
  final float C7  = 0.210646477787394151932639597830;     //square-root of a root of the polynomial:  4096*(x^6) - 16384*(x^5) + 24832*(x^4) - 17344*(x^3) + 4992*(x^2) - 212*x + 1
  final float C8  = 0.233599921462949641107705607317;     //square-root of a root of the polynomial:  3936256*(x^6) - 14764032*(x^5) + 2619648*(x^4) - 103040*(x^3) - 736*(x^2) + 32*x + 1
  final float C9  = 0.257509561486697247223240515731;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 9216*(x^4) - 9472*(x^3) + 1872*(x^2) - 100*x + 1
  final float C10 = 0.333335623729800812354123280131;     //square-root of a root of the polynomial:  4096*(x^6) - 11264*(x^5) + 9472*(x^4) - 2944*(x^3) + 432*(x^2) - 32*x + 1
  final float C11 = 0.355996872573544394226142398063;     //square-root of a root of the polynomial:  4096*(x^6) - 13312*(x^5) + 4608*(x^4) + 9920*(x^3) - 96*(x^2) - 1108*x + 121
  final float C12 = 0.377972612696358579690731668528;     //square-root of a root of the polynomial:  3936256*(x^6) - 7502848*(x^5) + 3239168*(x^4) - 452480*(x^3) + 17264*(x^2) + 208*x + 1
  final float C13 = 0.379167828565975488150770490117;     //square-root of a root of the polynomial:  4096*(x^6) - 15360*(x^5) + 18944*(x^4) - 7168*(x^3) + 1024*(x^2) - 56*x + 1
  final float C14 = 0.407493688934078743986484181441;     //square-root of a root of the polynomial:  4096*(x^6) - 21504*(x^5) + 16384*(x^4) - 4672*(x^3) + 624*(x^2) - 40*x + 1
  final float C15 = 0.444985083281660305231252021507;     //square-root of a root of the polynomial:  4096*(x^6) - 19456*(x^5) + 40704*(x^4) - 44288*(x^3) + 21504*(x^2) - 3420*x + 121
  final float C16 = 0.471863117101453259238018618004;     //square-root of a root of the polynomial:  4096*(x^6) - 4096*(x^5) + 3840*(x^4) - 14720*(x^3) + 17040*(x^2) - 6876*x + 841
  final float C17 = 0.509354511449034820482786458071;     //square-root of a root of the polynomial:  4096*(x^6) - 12288*(x^5) - 768*(x^4) + 384*(x^3) + 272*(x^2) - 36*x + 1
  final float C18 = 0.5393483688559637098170220124854;    //square-root of a root of the polynomial:  4096*(x^6) - 14336*(x^5) + 14592*(x^4) - 6016*(x^3) + 992*(x^2) - 48*x + 1
  final float C19 = 0.566643350360938546158781995893;     //square-root of a root of the polynomial:  4096*(x^6) - 3072*(x^5) + 9728*(x^4) - 8960*(x^3) + 2944*(x^2) - 328*x + 1
  private PVector[] vert = new PVector[92]; // list of ve//rtices
  private int[][] faces =  new int[FACES][VERTICES];  // list of faces (joining vertices)
  
  private GreatInvertedPentagonalHexecontahedron() {   
    // set vertices
    vert[  0] = new PVector(   C3,  C13, -C14 );
    vert[  1] = new PVector(  -C3,  C13,  C14 );
    vert[  2] = new PVector(  -C3, -C13, -C14 );
    vert[  3] = new PVector(   C3, -C13,  C14 );
    vert[  4] = new PVector(  C13, -C14,   C3 );
    vert[  5] = new PVector( -C13, -C14,  -C3 );
    vert[  6] = new PVector( -C13,  C14,   C3 );
    vert[  7] = new PVector(  C13,  C14,  -C3 );
    vert[  8] = new PVector( -C14,   C3,  C13 );
    vert[  9] = new PVector(  C14,   C3, -C13 );
    vert[ 10] = new PVector(  C14,  -C3,  C13 );
    vert[ 11] = new PVector( -C14,  -C3, -C13 );
    vert[ 12] = new PVector(  C18, -0.0,   C6 );
    vert[ 13] = new PVector(  C18, -0.0,  -C6 );
    vert[ 14] = new PVector( -C18, -0.0,   C6 );
    vert[ 15] = new PVector( -C18, -0.0,  -C6 );
    vert[ 16] = new PVector(  0.0,   C6,  C18 );
    vert[ 17] = new PVector(  0.0,   C6, -C18 );
    vert[ 18] = new PVector(  0.0,  -C6,  C18 );
    vert[ 19] = new PVector(  0.0,  -C6, -C18 );
    vert[ 20] = new PVector(   C6,  C18,  0.0 );
    vert[ 21] = new PVector(  -C6,  C18,  0.0 );
    vert[ 22] = new PVector(   C6, -C18,  0.0 );
    vert[ 23] = new PVector(  -C6, -C18,  0.0 );
    vert[ 24] = new PVector(  0.0,  C12,  -C8 );
    vert[ 25] = new PVector(  0.0,  C12,   C8 );
    vert[ 26] = new PVector(  0.0, -C12,  -C8 );
    vert[ 27] = new PVector(  0.0, -C12,   C8 );
    vert[ 28] = new PVector(  C12,  -C8,  0.0 );
    vert[ 29] = new PVector( -C12,  -C8,  0.0 );
    vert[ 30] = new PVector(  C12,   C8,  0.0 );
    vert[ 31] = new PVector( -C12,   C8,  0.0 );
    vert[ 32] = new PVector(  -C8, -0.0,  C12 );
    vert[ 33] = new PVector(  -C8, -0.0, -C12 );
    vert[ 34] = new PVector(   C8, -0.0,  C12 );
    vert[ 35] = new PVector(   C8, -0.0, -C12 );
    vert[ 36] = new PVector(  -C0,  C19,  -C2 );
    vert[ 37] = new PVector(   C0,  C19,   C2 );
    vert[ 38] = new PVector(   C0, -C19,  -C2 );
    vert[ 39] = new PVector(  -C0, -C19,   C2 );
    vert[ 40] = new PVector( -C19,  -C2,   C0 );
    vert[ 41] = new PVector(  C19,  -C2,  -C0 );
    vert[ 42] = new PVector(  C19,   C2,   C0 );
    vert[ 43] = new PVector( -C19,   C2,  -C0 );
    vert[ 44] = new PVector(   C2,   C0,  C19 );
    vert[ 45] = new PVector(  -C2,   C0, -C19 );
    vert[ 46] = new PVector(  -C2,  -C0,  C19 );
    vert[ 47] = new PVector(   C2,  -C0, -C19 );
    vert[ 48] = new PVector(  -C5,   C4,  C17 );
    vert[ 49] = new PVector(   C5,   C4, -C17 );
    vert[ 50] = new PVector(   C5,  -C4,  C17 );
    vert[ 51] = new PVector(  -C5,  -C4, -C17 );
    vert[ 52] = new PVector(   C4,  C17,  -C5 );
    vert[ 53] = new PVector(  -C4,  C17,   C5 );
    vert[ 54] = new PVector(  -C4, -C17,  -C5 );
    vert[ 55] = new PVector(   C4, -C17,   C5 );
    vert[ 56] = new PVector(  C17,  -C5,   C4 );
    vert[ 57] = new PVector( -C17,  -C5,  -C4 );
    vert[ 58] = new PVector( -C17,   C5,   C4 );
    vert[ 59] = new PVector(  C17,   C5,  -C4 );
    vert[ 60] = new PVector(  -C7,  C16,  -C9 );
    vert[ 61] = new PVector(   C7,  C16,   C9 );
    vert[ 62] = new PVector(   C7, -C16,  -C9 );
    vert[ 63] = new PVector(  -C7, -C16,   C9 );
    vert[ 64] = new PVector(  C16,  -C9,  -C7 );
    vert[ 65] = new PVector( -C16,  -C9,   C7 );
    vert[ 66] = new PVector( -C16,   C9,  -C7 );
    vert[ 67] = new PVector(  C16,   C9,   C7 );
    vert[ 68] = new PVector(  -C9,  -C7,  C16 );
    vert[ 69] = new PVector(   C9,  -C7, -C16 );
    vert[ 70] = new PVector(   C9,   C7,  C16 );
    vert[ 71] = new PVector(  -C9,   C7, -C16 );
    vert[ 72] = new PVector(  C15,   C1,  C11 );
    vert[ 73] = new PVector( -C15,   C1, -C11 );
    vert[ 74] = new PVector( -C15,  -C1,  C11 );
    vert[ 75] = new PVector(  C15,  -C1, -C11 );
    vert[ 76] = new PVector(  -C1,  C11, -C15 );
    vert[ 77] = new PVector(   C1,  C11,  C15 );
    vert[ 78] = new PVector(   C1, -C11, -C15 );
    vert[ 79] = new PVector(  -C1, -C11,  C15 );
    vert[ 80] = new PVector( -C11, -C15,   C1 );
    vert[ 81] = new PVector(  C11, -C15,  -C1 );
    vert[ 82] = new PVector(  C11,  C15,   C1 );
    vert[ 83] = new PVector( -C11,  C15,  -C1 );
    vert[ 84] = new PVector( -C10, -C10, -C10 );
    vert[ 85] = new PVector( -C10, -C10,  C10 );
    vert[ 86] = new PVector(  C10, -C10, -C10 );
    vert[ 87] = new PVector(  C10, -C10,  C10 );
    vert[ 88] = new PVector( -C10,  C10, -C10 );
    vert[ 89] = new PVector( -C10,  C10,  C10 );
    vert[ 90] = new PVector(  C10,  C10, -C10 );
    vert[ 91] = new PVector(  C10,  C10,  C10 );
    // set faces
    faces[ 0] = new int[] { 24,  0,  2, 14, 36 };
    faces[ 1] = new int[] { 24, 36, 72, 86, 76 };
    faces[ 2] = new int[] { 24, 76, 40, 16, 52 };
    faces[ 3] = new int[] { 24, 52, 64, 84, 60 };
    faces[ 4] = new int[] { 24, 60, 48, 12,  0 };
    faces[ 5] = new int[] { 25,  1,  3, 13, 37 };
    faces[ 6] = new int[] { 25, 37, 73, 85, 77 };
    faces[ 7] = new int[] { 25, 77, 41, 17, 53 };
    faces[ 8] = new int[] { 25, 53, 65, 87, 61 };
    faces[ 9] = new int[] { 25, 61, 49, 15,  1 };
    faces[10] = new int[] { 26,  2,  0, 12, 38 };
    faces[11] = new int[] { 26, 38, 74, 88, 78 };
    faces[12] = new int[] { 26, 78, 42, 18, 54 };
    faces[13] = new int[] { 26, 54, 66, 90, 62 };
    faces[14] = new int[] { 26, 62, 50, 14,  2 };
    faces[15] = new int[] { 27,  3,  1, 15, 39 };
    faces[16] = new int[] { 27, 39, 75, 91, 79 };
    faces[17] = new int[] { 27, 79, 43, 19, 55 };
    faces[18] = new int[] { 27, 55, 67, 89, 63 };
    faces[19] = new int[] { 27, 63, 51, 13,  3 };
    faces[20] = new int[] { 28,  4,  5, 17, 41 };
    faces[21] = new int[] { 28, 41, 77, 85, 81 };
    faces[22] = new int[] { 28, 81, 45, 20, 56 };
    faces[23] = new int[] { 28, 56, 68, 84, 64 };
    faces[24] = new int[] { 28, 64, 52, 16,  4 };
    faces[25] = new int[] { 29,  5,  4, 16, 40 };
    faces[26] = new int[] { 29, 40, 76, 86, 80 };
    faces[27] = new int[] { 29, 80, 44, 21, 57 };
    faces[28] = new int[] { 29, 57, 69, 87, 65 };
    faces[29] = new int[] { 29, 65, 53, 17,  5 };
    faces[30] = new int[] { 30,  7,  6, 18, 42 };
    faces[31] = new int[] { 30, 42, 78, 88, 82 };
    faces[32] = new int[] { 30, 82, 46, 22, 59 };
    faces[33] = new int[] { 30, 59, 71, 89, 67 };
    faces[34] = new int[] { 30, 67, 55, 19,  7 };
    faces[35] = new int[] { 31,  6,  7, 19, 43 };
    faces[36] = new int[] { 31, 43, 79, 91, 83 };
    faces[37] = new int[] { 31, 83, 47, 23, 58 };
    faces[38] = new int[] { 31, 58, 70, 90, 66 };
    faces[39] = new int[] { 31, 66, 54, 18,  6 };
    faces[40] = new int[] { 32,  8, 11, 22, 46 };
    faces[41] = new int[] { 32, 46, 82, 88, 74 };
    faces[42] = new int[] { 32, 74, 38, 12, 48 };
    faces[43] = new int[] { 32, 48, 60, 84, 68 };
    faces[44] = new int[] { 32, 68, 56, 20,  8 };
    faces[45] = new int[] { 33, 11,  8, 20, 45 };
    faces[46] = new int[] { 33, 45, 81, 85, 73 };
    faces[47] = new int[] { 33, 73, 37, 13, 51 };
    faces[48] = new int[] { 33, 51, 63, 89, 71 };
    faces[49] = new int[] { 33, 71, 59, 22, 11 };
    faces[50] = new int[] { 34, 10,  9, 21, 44 };
    faces[51] = new int[] { 34, 44, 80, 86, 72 };
    faces[52] = new int[] { 34, 72, 36, 14, 50 };
    faces[53] = new int[] { 34, 50, 62, 90, 70 };
    faces[54] = new int[] { 34, 70, 58, 23, 10 };
    faces[55] = new int[] { 35,  9, 10, 23, 47 };
    faces[56] = new int[] { 35, 47, 83, 91, 75 };
    faces[57] = new int[] { 35, 75, 39, 15, 49 };
    faces[58] = new int[] { 35, 49, 61, 87, 69 };
    faces[59] = new int[] { 35, 69, 57, 21,  9 };
  } //end GreatInvertedPentagonalHexecontahedron()

  public String name() {
    return "Great Inverted Pentagonal Hexecontahedron";
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
   
} //end class GreatInvertedPentagonalHexecontahedron
