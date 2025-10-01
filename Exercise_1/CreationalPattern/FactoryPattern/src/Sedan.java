public class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Sedan: Smooth and comfortable drive.");
    }

    @Override
    public void specs(String variant) {
        switch (variant.toLowerCase()) {
            case "base":
                System.out.println("Sedan Base: Manual, 2 airbags, simple interior.");
                break;
            case "mid":
                System.out.println("Sedan Mid: Automatic, 4 airbags, touchscreen.");
                break;
            case "top":
                System.out.println("Sedan Top: Sunroof, 6 airbags, luxury interior.");
                break;
            default:
                System.out.println("Invalid variant for Sedan.");
        }
    }
}
