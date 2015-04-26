/*
Polyhedrons Demo 4

use left/right arrow keys to cycle through the polyhedrons
up arrow key to change colors
mouse wheel/trackpad scroll zooms in/out

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public ArrayList<Polyhedron> polyObjects = new ArrayList<Polyhedron>();
public Polyhedron poly;
public float zoom = 0.025;
public int num = 0;
public PFont f;

public void setup(){
  size(displayWidth,displayHeight,OPENGL);
  lights();
  smooth();
  frameRate(30);
  f = createFont("Arial",24,true);
  textFont(f,24);
  textAlign(CENTER);
  noCursor();
  //Instantiate each object
  //platonic solids
  polyObjects.add(new Tetrahedron());
  polyObjects.add(new Octahedron());
  polyObjects.add(new Cube());
  polyObjects.add(new Icosahedron());
  polyObjects.add(new Dodecahedron());
  //kepler-poinsot solids
  polyObjects.add(new SmallStellatedDodecahedron());
  polyObjects.add(new GreatDodecahedron());
  polyObjects.add(new GreatStellatedDodecahedron());
  polyObjects.add(new GreatIcosahedron());
  //versi-regular polyhedra
  polyObjects.add(new Tetrahemihexahedron());
  polyObjects.add(new Cubohemioctahedron());
  polyObjects.add(new Octahemioctahedron());
  polyObjects.add(new SmallDodecahemidodecahedron());
  polyObjects.add(new GreatDodecahemidodecahedron());
  polyObjects.add(new SmallDodecahemicosahedron());
  polyObjects.add(new GreatDodecahemicosahedron());
  polyObjects.add(new SmallIcosihemidodecahedron());
  polyObjects.add(new GreatIcosihemidodecahedron());
  //archimedean solids
  polyObjects.add(new TruncatedTetrahedron());
  polyObjects.add(new Cuboctahedron());
  polyObjects.add(new TruncatedOctahedron());
  polyObjects.add(new TruncatedCube());
  polyObjects.add(new Rhombicuboctahedron());
  polyObjects.add(new SnubCube());
  polyObjects.add(new Icosidodecahedron());
  polyObjects.add(new TruncatedCuboctahedron());
  polyObjects.add(new TruncatedIcosahedron());
  polyObjects.add(new TruncatedDodecahedron());
  polyObjects.add(new Rhombicosidodecahedron());
  polyObjects.add(new SnubDodecahedron());
  polyObjects.add(new TruncatedIcosidodecahedron());
  //catalan solids
  polyObjects.add(new TriakisTetrahedron());
  polyObjects.add(new RhombicDodecahedron());
  polyObjects.add(new TetrakisHexahedron());
  polyObjects.add(new TriakisOctahedron());
  polyObjects.add(new DeltoidalIcositetrahedron());
  polyObjects.add(new PentagonalIcositetrahedron());
  polyObjects.add(new RhombicTriacontahedron());
  polyObjects.add(new DisdyakisDodecahedron());
  polyObjects.add(new PentakisDodecahedron());
  polyObjects.add(new TriakisIcosahedron());
  polyObjects.add(new DeltoidalHexecontahedron());
  polyObjects.add(new PentagonalHexecontahedron());
  polyObjects.add(new DisdyakisTriacontahedron());
  //self-intersecting quasi-regular polyhedra
  polyObjects.add(new DitrigonalDodecadodecahedron());
  polyObjects.add(new SmallDitrigonalIcosidodecahedron());
  polyObjects.add(new GreatDitrigonalIcosidodecahedron());
  polyObjects.add(new Dodecadodecahedron());
  polyObjects.add(new GreatIcosidodecahedron());
  //self-intersecting quasi-regular duals
  polyObjects.add(new MedialTriambicIcosahedron());
  polyObjects.add(new SmallTriambicIcosahedron());
  polyObjects.add(new GreatTriambicIcosahedron());
  polyObjects.add(new MedialRhombicTriacontahedron());
  polyObjects.add(new GreatRhombicTriacontahedron());
  //self-intersecting quasi-quasi-regular polyhedra
  polyObjects.add(new SmallCubicuboctahedron());
  polyObjects.add(new GreatCubicuboctahedron());
  polyObjects.add(new UniformGreatRhombicuboctahedron());
  polyObjects.add(new SmallDodecicosidodecahedron());
  polyObjects.add(new GreatDodecicosidodecahedron());
  polyObjects.add(new SmallDitrigonalDodecicosidodecahedron());
  polyObjects.add(new GreatDitrigonalDodecicosidodecahedron());
  polyObjects.add(new Icosidodecadodecahedron());
  polyObjects.add(new SmallIcosicosidodecahedron());
  polyObjects.add(new GreatIcosicosidodecahedron());
  polyObjects.add(new Rhombidodecadodecahedron());
  polyObjects.add(new UniformGreatRhombicosidodecahedron());
  //self-intersecting quasi-quasi-regular duals
  polyObjects.add(new SmallHexacronicIcositetrahedron());
  polyObjects.add(new GreatHexacronicIcositetrahedron());
  polyObjects.add(new GreatDeltoidalIcositetrahedron());
  polyObjects.add(new SmallDodecacronicHexecontahedron());
  polyObjects.add(new GreatDodecacronicHexecontahedron());
  polyObjects.add(new SmallDitrigonalDodecacronicHexecontahedron());
  polyObjects.add(new GreatDitrigonalDodecacronicHexecontahedron());
  polyObjects.add(new MedialIcosacronicHexecontahedron());
  polyObjects.add(new SmallIcosacronicHexecontahedron());
  polyObjects.add(new GreatIcosacronicHexecontahedron());
  polyObjects.add(new MedialDeltoidalHexecontahedron());
  polyObjects.add(new GreatDeltoidalHexecontahedron());
  //versi-quasi-regular polyhedra
  polyObjects.add(new SmallRhombihexahedron());
  polyObjects.add(new GreatRhombihexahedron());
  polyObjects.add(new SmallDodecicosahedron());
  polyObjects.add(new GreatDodecicosahedron());
  polyObjects.add(new SmallRhombidodecahedron());
  polyObjects.add(new GreatRhombidodecahedron());
  polyObjects.add(new Rhombicosahedron());
  //versi-quasi-regular duals
  polyObjects.add(new SmallRhombihexacron());
  polyObjects.add(new GreatRhombihexacron());
  polyObjects.add(new SmallDodecicosacron());
  polyObjects.add(new GreatDodecicosacron());
  polyObjects.add(new SmallRhombidodecacron());
  polyObjects.add(new GreatRhombidodecacron());
  polyObjects.add(new Rhombicosacron());
  //self-intersecting truncated regular polyhedra
  polyObjects.add(new StellatedTruncatedHexahedron());
  polyObjects.add(new TruncatedGreatDodecahedron());
  polyObjects.add(new SmallStellatedTruncatedDodecahedron());
  polyObjects.add(new GreatStellatedTruncatedDodecahedron());
  polyObjects.add(new TruncatedGreatIcosahedron());
  //self-intersecting truncated regular duals
  polyObjects.add(new GreatTriakisOctahedron());
  polyObjects.add(new SmallStellapentakisDodecahedron());
  polyObjects.add(new GreatPentakisDodecahedron());
  polyObjects.add(new GreatTriakisIcosahedron());
  polyObjects.add(new GreatStellapentakisDodecahedron());
  //self-intersecting truncated quasi-regular polyhedra
  polyObjects.add(new CubitruncatedCuboctahedron());
  polyObjects.add(new GreatTruncatedCuboctahedron());
  polyObjects.add(new IcositruncatedDodecadodecahedron());
  polyObjects.add(new TruncatedDodecadodecahedron());
  polyObjects.add(new GreatTruncatedIcosidodecahedron());
  //self-intersecting truncated quasi-regular duals
  polyObjects.add(new TetradyakisHexahedron());
  polyObjects.add(new GreatDisdyakisDodecahedron());
  polyObjects.add(new TridyakisIcosahedron());
  polyObjects.add(new MedialDisdyakisTriacontahedron());
  polyObjects.add(new GreatDisdyakisTriacontahedron());
  //self-intersecting snub quasi-regular polyhedra
  polyObjects.add(new SnubDodecadodecahedron());
  polyObjects.add(new InvertedSnubDodecadodecahedron());
  polyObjects.add(new GreatSnubIcosidodecahedron());
  polyObjects.add(new GreatInvertedSnubIcosidodecahedron());
  polyObjects.add(new GreatRetrosnubIcosidodecahedron());
  polyObjects.add(new SnubIcosidodecadodecahedron());
  polyObjects.add(new GreatSnubDodecicosidodecahedron());
  polyObjects.add(new SmallSnubIcosicosidodecahedron());
  polyObjects.add(new SmallRetrosnubIcosicosidodecahedron());
  polyObjects.add(new GreatDirhombicosidodecahedron());
  //self-intersecting snub quasi-regular duals
  polyObjects.add(new MedialPentagonalHexecontahedron());
  polyObjects.add(new MedialInvertedPentagonalHexecontahedron());
  polyObjects.add(new GreatPentagonalHexecontahedron());
  polyObjects.add(new GreatInvertedPentagonalHexecontahedron());
  polyObjects.add(new GreatPentagrammicHexecontahedron());
  polyObjects.add(new MedialHexagonalHexecontahedron());
  polyObjects.add(new GreatHexagonalHexecontahedron());
  polyObjects.add(new SmallHexagonalHexecontahedron());
  polyObjects.add(new SmallHexagrammicHexecontahedron());
  //prisms & antiprisms
  polyObjects.add(new TriangularPrism());
  polyObjects.add(new SquarePrism());
  polyObjects.add(new PentagonalPrism());
  polyObjects.add(new HexagonalPrism());
  polyObjects.add(new HeptagonalPrism());
  polyObjects.add(new OctagonalPrism());
  polyObjects.add(new TriangularAntiprism());
  polyObjects.add(new SquareAntiprism());
  polyObjects.add(new PentagonalAntiprism());
  //non-regular toroidal solids
  polyObjects.add(new OctagonalIrisToroid());
  //regular hexagonal toroidal solids
  polyObjects.add(new RegularHexagonalToroid12faces());
  polyObjects.add(new RegularHexagonalToroid24Faces());
  
  for(Polyhedron p: polyObjects) {
    p.fillColor(int(random(255)), int(random(255)), int(random(255)), 255);
    p.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
  }
} //end setup()

public void draw(){
  noCursor();
  background(0);
  pointLight(200, 200, 600, width/2, height/2, 600);
  ambientLight(102, 102, 102);
  spotLight(51, 102, 126, 80, 20, 40, -1, 0, 0, PI/2, 2);
  translate(width/2, height/2, 0);
  poly = polyObjects.get(num);
  if (mousePressed) {
      poly.rotate(mouseX/100., mouseY/100., 0);
    } else {
      poly.rotate(radians(frameCount%360),radians(frameCount%360),0);
    }
  poly.scaleFactor(5000);
  poly.render();
  text(poly.name(),0,400);
} //end draw()

public void mouseWheel(MouseEvent e) {
  zoom += map(e.getCount(), -5, 5, 0.01, -0.01);
  zoom = constrain(zoom, 0.001, 0.2);
}

public void keyPressed() {
  if (key == CODED) {
    if (keyCode == LEFT) {
      if (num == 0) {
        num = (polyObjects.size() - 1);
      } else {
        num--;
      }
    } 
    if (keyCode == RIGHT) {
      if (num == (polyObjects.size() - 1)) {
        num = 0;
      } else {
        num++;
      }
    }
    if (keyCode == UP) {
      poly.fillColor(int(random(255)), int(random(255)), int(random(255)), 255);
      poly.noStrokeToggle(false);
      poly.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
      poly.strokeColorWeight(0.005);
    }
    if (keyCode == DOWN) {
      poly.noFillToggle(true);
      poly.noStrokeToggle(false);
      poly.strokeColorWeight(0.01);      
    } 
  }
  if (key == ' ') {        
    poly.noFillToggle(false);
    poly.noStrokeToggle(true);
  }
}