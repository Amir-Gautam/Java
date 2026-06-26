class Song {
    String title;
    String artist;

    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}

class PopSong extends Song {
    PopSong(String title, String artist) {
        super(title, artist);
    }

    @Override
    void play() {
        System.out.println("Pop hit playing: " + title + " by " + artist + " - turn it up!");
    }
}

class RockSong extends Song {
    RockSong(String title, String artist) {
        super(title, artist);
    }

    @Override
    void play() {
        System.out.println("Rock anthem blasting: " + title + " by " + artist + " - guitars on full volume!");
    }
}

class JazzSong extends Song {
    JazzSong(String title, String artist) {
        super(title, artist);
    }

    @Override
    void play() {
        System.out.println("Smooth jazz flowing: " + title + " by " + artist + " - relax and enjoy.");
    }
}

public class MusicApp {
    public static void main(String[] args) {
        Song[] playlist = {
            new PopSong("Resham Firiri", "Traditional Folk"),
            new RockSong("Mero Maan", "Albatross"),
            new JazzSong("Malai Yo Sahar", "Sajjan Raj Vaidya")
        };

        for (Song song : playlist) {
            song.play();
        }
    }
}
