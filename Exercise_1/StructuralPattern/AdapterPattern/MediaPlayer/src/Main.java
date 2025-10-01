import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter audio type (mp3/vlc/mp4): ");
        String type = sc.nextLine();
        System.out.println("Enter file name: ");
        String name = sc.nextLine();

        player.play(type, name);
        sc.close();
    }
}
