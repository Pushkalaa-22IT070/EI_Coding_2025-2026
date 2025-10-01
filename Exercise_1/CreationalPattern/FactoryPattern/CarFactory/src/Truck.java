public class Truck implements Car {
    @Override
    public void drive() {
        System.out.println("Truck: Heavy-duty drive, made for cargo.");
    }

    @Override
    public void specs(String variant) {
        switch (variant.toLowerCase()) {
            case "base":
                System.out.println("Truck Base: Diesel engine, manual, no AC.");
                break;
            case "mid":
                System.out.println(" Truck Mid: Diesel engine, AC, power steering.");
                break;
            case "top":
                System.out.println(" Truck Top: Turbo engine, AC, sleeper cabin.");
                break;
            default:
                System.out.println(" Invalid variant for Truck.");
        }
    }
}
