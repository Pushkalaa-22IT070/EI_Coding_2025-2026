public class SUV implements Car {
    @Override
    public void drive() {
        System.out.println("SUV: Powerful drive, perfect for adventures!");
    }

    @Override
    public void specs(String variant) {
        switch (variant.toLowerCase()) {
            case "base":
                System.out.println("SUV Base: Manual, 2 airbags, steel wheels.");
                break;
            case "mid":
                System.out.println("SUV Mid: Automatic, 4 airbags, alloy wheels.");
                break;
            case "top":
                System.out.println("SUV Top: 4x4 drive, 6 airbags, panoramic sunroof.");
                break;
            default:
                System.out.println("Invalid variant for SUV.");
        }
    }
}
