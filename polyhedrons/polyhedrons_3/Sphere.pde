class Sphere {
  
  float xPos = random(300,width-300);                //X Position of the Sphere
  float yPos = random(300,height-300);                 //Y Position of the Sphere
  float zPos = random(-300,300);                    //Z Position of the Sphere
  float radius = 300;                  //Radius of the Sphere    
  ArrayList<Polyhedron> items = new ArrayList<Polyhedron>();   //List of all of the items contained in the Sphere
  String type;
  
  public Sphere() {
    //Empty, for now!
  };
  
  public void addSphereItem() {
    Polyhedron si = new Dodecahedron();
    //Set random values for the spherical coordinates
    si.positionSphere(radius, random(PI * 2), random(PI * 2));
    //scale
    si.scaleFactor(2400);
    //fill
    si.fillColor(int(random(255)), int(random(255)), int(random(255)), 100);
    //stroke
    si.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
    //Add the new sphere item to the end of our ArrayList
    items.add(items.size(), si);
  };

  public void addSphereItem(String _type) {
    type = _type;
    if (type.equals("Dodecahedron") == true) {
      Polyhedron si = new Dodecahedron();
      //Set random values for the spherical coordinates
      si.positionSphere(radius, random(PI * 2), random(PI * 2));
      //scale
      si.scaleFactor(1000);
      //fill
      si.fillColor(int(random(255)), int(random(255)), int(random(255)), 100);
      //stroke
      si.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
      //Add the new sphere item to the end of our ArrayList
      items.add(items.size(), si);
    }
    if (type.equals("SmallStellatedDodecahedron") == true) {
      Polyhedron si = new SmallStellatedDodecahedron();
      //Set random values for the spherical coordinates
      si.positionSphere(radius, random(PI * 2), random(PI * 2));
      //scale
      si.scaleFactor(3400);
      //fill
      si.fillColor(int(random(255)), int(random(255)), int(random(255)), 100);
      //stroke
      si.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
      //Add the new sphere item to the end of our ArrayList
      items.add(items.size(), si);
    }
    if (type.equals("GreatDodecahedron") == true) {
      Polyhedron si = new GreatDodecahedron();
      //Set random values for the spherical coordinates
      si.positionSphere(radius, random(PI * 2), random(PI * 2));
      //scale
      si.scaleFactor(2400);
      //fill
      si.fillColor(int(random(255)), int(random(255)), int(random(255)), 100);
      //stroke
      si.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
      //Add the new sphere item to the end of our ArrayList
      items.add(items.size(), si);
    }
    if (type.equals("GreatStellatedDodecahedron") == true) {
      Polyhedron si = new GreatStellatedDodecahedron();
      //Set random values for the spherical coordinates
      si.positionSphere(radius, random(PI * 2), random(PI * 2));
      //scale
      si.scaleFactor(5400);
      //fill
      si.fillColor(int(random(255)), int(random(255)), int(random(255)), 100);
      //stroke
      si.strokeColor(int(random(255)), int(random(255)), int(random(255)), 255);
      //Add the new sphere item to the end of our ArrayList
      items.add(items.size(), si);
    }
  };

  public void removeSphereItem() {
    if (items.size() != 0) {
      items.remove((items.size()-1));
    } 
    if (items.size() == 0){
      toggle = true;
    }
  };
  
  public void update() {
    for (Polyhedron p: items) {
      p.update();
    };
  };
  
  public void render() {
    //Move to the center point of the sphere
    translate(xPos, yPos, zPos);
    //Mark our position in 3d space
    pushMatrix();
    //noFill();
    //stroke(255,255,255,100);
    //strokeWeight(1);
    //sphere(280);
    //Render each GreatStellatedDodecahedron
    for (Polyhedron p: items) {
      p.rotate(radians(random(-0.08,0.08)-frameCount%360), radians(random(-0.05,0.05)+frameCount%360), 0);
      p.render();
    };
    //Go back to our original position in 3d space
    popMatrix();
  };
 
};