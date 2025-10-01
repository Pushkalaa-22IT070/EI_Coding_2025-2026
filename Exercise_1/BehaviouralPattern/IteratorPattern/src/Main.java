public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song 1 - Princess Doesn't Cry"));
        playlist.addSong(new Song("Song 2 - Believer"));
        playlist.addSong(new Song("Song 3 - Perfect"));

        Iterator it = playlist.iterator();

        System.out.println("Playing Playlist:");

        while (it.hasNext()) {
            Song song = (Song) it.next();
            System.out.println("Playing: " + song.getTitle());

            try {
                // wait for 2 seconds before playing next song
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
