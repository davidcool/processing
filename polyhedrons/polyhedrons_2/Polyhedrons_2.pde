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
  //archimedean solids
  polyObjects.add(new TruncatedTetrahedron());
  polyObjects.add(new Cuboctahedron());
  polyObjects.add(new TruncatedOctahedron());
  polyObjects.add(new TruncatedCube());
  polyObjects.add(new Rhombicuboctahedron());
  polyObjects.add(new SnubCube());
  polyObjects.add(new Icosidodecahedron());
  polyObjects.add(new TruncatedCuboctahedron());
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
  //self-intersecting truncated regular polyhedra
  polyObjects.add(new StellatedTruncatedHexahedron());
  polyObjects.add(new TruncatedGreatDodecahedron());
  polyObjects.add(new SmallStellatedTruncatedDodecahedron());
  polyObjects.add(new GreatStellatedTruncatedDodecahedron());
  polyObjects.add(new TruncatedGreatIcosahedron());
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
  //self-intersecting truncated quasi-regular duals
  polyObjects.add(new TetradyakisHexahedron());
  polyObjects.add(new GreatDisdyakisDodecahedron());
  polyObjects.add(new TridyakisIcosahedron());
  polyObjects.add(new MedialDisdyakisTriacontahedron());
  polyObjects.add(new GreatDisdyakisTriacontahedron());
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