public class CarFactory {
    public Car getCar(String carType) {
        if (carType == null) {
            return null;
        }
        switch (carType.toLowerCase()) {
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            case "truck":
                return new Truck();
            default:
                return null;
        }
    }
}
