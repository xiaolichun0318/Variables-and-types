public class Main{
    public static void main(String[] args) {
        MusicBox mbox = new MusicBox("S34TG65", 'Y', "Raindrops", "ArtistName", "The path less traveled", "Country", "BZEE Music", "Rhythm Div");
        System.out.println("Now playing the song");
        mbox.playSong(mbox.getSongID(), mbox.getPremiumSong(), 2);

       
        MusicBox anotherMbox = new MusicBox("AnotherSongID", 'N', "AnotherSongTitle", "AnotherArtist", "AnotherAlbum", "AnotherGenre", "AnotherProducer", "AnotherLabel");
        System.out.println("Now playing another song");
        anotherMbox.playSong(anotherMbox.getSongID(), anotherMbox.getPremiumSong(), 1);
    }
}