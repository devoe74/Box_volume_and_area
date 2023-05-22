public class Calculate {
    public double calculateVolume(double height , double width , double length){
        return height * width * length;
    }
    public double calculateArea(double height , double width , double length){
        return (height * width * 2) + (width * length * 2) + (height * length * 2);
    }
}
