import java.util.ArrayList;
import java.util.List;

public class Broadcast {

    int maxDurationMin;
    int maxDurationSec;

    List<BroadcastItemInterface> items = new ArrayList<>();

    Broadcast(int minutes) {
        this.maxDurationMin = minutes;
        this.maxDurationSec = minutes * 60;
    }

    public void printReport() {

        for (BroadcastItemInterface item : items) {
            String report = "";

            report += item.getClass().getName() + " : duration : " + item.getDuration() + " : " + item.getTitle();

            if (item.isPaidContent()) {
                report += " : Paid content : " + item.getProfit();
            } else {
                report += " : Free Content";
            }

            System.out.println(report);
        }

        System.out.println("Max durations : " + this.getMaxDuration());
        System.out.println("Total items durations : " + this.getItemsDuration());
        System.out.println("Total paid content duration: " + this.getPaidContentDuration());
        System.out.println("Total free duration : " + this.getFreeDuration() + " [ " + this.getFreeDurationMinutes() + " ] ");
        System.out.println("Profit : " + this.getProfit());
    }

    public boolean exists(BroadcastItemInterface item) {
        return items.contains(item);
    }

    public void add(BroadcastItemInterface item) {
        if (this.exists(item)) {
            System.out.println("This Item already in broadcast | " + item.getTitle() + " | " + item);
            return;
        }
        //add logic with check total durations
        int free = this.getFreeDuration();
        if (free < item.getDuration()) {
            System.out.println("Not enough space for : " + item.getTitle() + " | " + item + " | free duration : " + free);
            return;
        }

        if (item.isPaidContent() && this.getFreeDurationForPaidContent() <= item.getDuration()) {
            System.out.println("To much paid content  : " + item.getTitle()  + " | has only free duration : " + this.getFreeDurationForPaidContent());
            return;
        }
        this.items.add(item);

    }

    public BroadcastItemInterface get(int index) {
        if (index < 0 || this.items.size() < index) {
            return null;
        }
        return this.items.get(index);
    }

    public int count() {
        return this.items.size();
    }

    public BroadcastItemInterface remove(int index) {
        if (index < 0 || this.items.size() < index) {
            return null;
        }
        return this.items.remove(index);
    }

    public BroadcastItemInterface next(BroadcastItemInterface item) {
        return this.get(this.items.indexOf(item) + 1);
    }

    public BroadcastItemInterface previous(BroadcastItemInterface item) {
        return this.get(this.items.indexOf(item) - 1);
    }

    public boolean remove(BroadcastItemInterface item) {
        return this.items.remove(item);
    }

    public int getPaidContentDuration() {
        int result = 0;
        for (BroadcastItemInterface item : items) {
            if (item.isPaidContent()) {
                result += item.getDuration();
            }
        }
        return result;
    }

    public int getMaxDuration() {
        return maxDurationSec;
    }

    public int getItemsDuration() {
        int result = 0;
        for (BroadcastItemInterface item : items) {
            result += item.getDuration();
        }
        return result;
    }


    public int getFreeDuration() {
        return maxDurationSec - this.getItemsDuration();
    }

    public double getFreeDurationMinutes() {
        return (double) this.getFreeDuration() / 60;
    }

    public int getFreeDurationForPaidContent() {
        return maxDurationSec/2 - this.getPaidContentDuration();
    }

    public boolean isCanBeAddPaidContent(int duration) {
        return (this.getPaidContentDuration() + duration <= maxDurationSec / 2);
    }

    public double getProfit() {
        int result = 0;
        for (BroadcastItemInterface item : items) {
            result += item.getProfit();
        }
        return result;
    }
}
