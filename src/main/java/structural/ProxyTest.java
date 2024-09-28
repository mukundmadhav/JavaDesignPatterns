package structural;
abstract class BaseImage {
  public abstract void display();
}

class RealImage extends BaseImage {

  String fileName;

  public RealImage(String fileName) {
    this.fileName = fileName;
    loadFromDisk(fileName);
  }

  void loadFromDisk(String fileName) {
    System.out.println("Loading " + fileName);
  }

  @Override
  public void display() {
    System.out.println("Displaying " + fileName);
  }
}

class ProxyImage extends BaseImage {

  RealImage realImage;
  String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    if (realImage == null) {
      realImage = new RealImage(fileName);
    }
    realImage.display();
  }
}

class ProxyTest {

  public static void main(String[] args) {
    BaseImage image = new ProxyImage("test.jpg");
    image.display();
  }
}
