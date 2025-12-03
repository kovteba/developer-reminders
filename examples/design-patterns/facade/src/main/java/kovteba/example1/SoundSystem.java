package kovteba.example1;

// tag::SoundSystem[]
public class SoundSystem {
    public void on() {
        System.out.println("SoundSystem: turning ON");
    }

    public void off() {
        System.out.println("SoundSystem: turning OFF");
    }

    public void setVolume(int level) {
        System.out.println("SoundSystem: volume set to " + level);
    }
}
// end::SoundSystem[]
