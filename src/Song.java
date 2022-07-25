public class Song extends BroadcastItem {
    private String name = ""; //song name
    private Singer singer;

    Song() {

    }

    Song(int duration, Singer singer, String name) {
        this.duration = duration;
        this.singer = singer;
        this.name = name;
    }

    public String getTitle() {
        return this.singer.getName() + " : " + name;
    }

    public Singer getSinger() {
        return this.singer;
    }

    public String getName() {
        return this.name;
    }

}
