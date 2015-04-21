/*
Polyhedron abstract class

david cool
http://davidcool.com
http://generactive.net
http://mystic.codes
*/

public abstract class Polyhedron {
	// position
  public float x = 0;
  public float y = 0;
  public float z = 0;
  //Spherical Coordinates
  public boolean parentSphere = false;
  public float radius;
  public float theta;
  public float phi;
  public float r;
  //Speed properties
  public float thetaSpeed = random(-0.01, 0.01);
  public float phiSpeed = random(-0.01, 0.01);
  //Stray
  public float stray = random(2,-2);
  // scale
  public float scaleSize = 5000;
  // rotation
  public boolean rotate = true;
  public float rx = 0;
  public float ry = 0;
  public float rz = 0;
  // fill
  public boolean nofill = false;
  public int fc0 = 255;
  public int fc1 = 255;
  public int fc2 = 255;
  public int fc3 = 255;
  // stroke
  public boolean nostroke = false;
  public float sw = 0.01;
  public int sc0 = 0;
  public int sc1 = 0;
  public int sc2 = 0;
  public int sc3 = 255;

  public void position(float _x, float _y, float _z) {
    x = _x;
    y = _y;
    z = _z;
  }

  public void positionSphere(float _radius, float _theta, float _phi) {
    parentSphere = true;
    radius = _radius;
    theta = _theta;
    phi = _phi;
  }
  
  public void speed(float _thetaSpeed, float _phiSpeed) {
    thetaSpeed = _thetaSpeed;
    phiSpeed = _phiSpeed;
  }
  
  public void strayFactor(float _stray) {
    stray = _stray;
  }
  
  public void scaleFactor(float _scaleSize) {
    scaleSize = _scaleSize;  
  }
  
  public void fillColor(int _fc0, int _fc1, int _fc2, int _fc3) {
    fc0 = _fc0;
    fc1 = _fc1;
    fc2 = _fc2;
    fc3 = _fc3;
  }
  
  public void noFillToggle(boolean _nofill) {
    nofill = _nofill;
  }
  
  public void strokeColor(int _sc0, int _sc1, int _sc2, int _sc3) {
    sc0 = _sc0;
    sc1 = _sc1;
    sc2 = _sc2;
    sc3 = _sc3;
  }
  
  public void noStrokeToggle(boolean _nostroke) {
    nostroke = _nostroke;
  }
  
  public void strokeColorWeight(float _sw) {
    sw = _sw;
  }
  
  public void rotate(float _rx, float _ry, float _rz) {
    rx = _rx;
    ry = _ry;
    rz = _rz;
  }
  
  public void update() {
    theta += thetaSpeed;
    phi += phiSpeed;
  }
  
  abstract String name();

  abstract void render();

} //end Polyhedron class