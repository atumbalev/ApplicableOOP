package clock;

import alarm.AlarmActionEventHandler;
import alarm.AlarmEvent;

public class AlarmClock {

    private AlarmActionEventHandler alarm;
    private int nrings;

    public AlarmClock(AlarmActionEventHandler alarm, int nrings) { //
        this.alarm = alarm;
        this.nrings = nrings;
    }

    public AlarmActionEventHandler getAlarm() {
        return alarm;
    }

    public void setAlarm(AlarmActionEventHandler alarm) {
        this.alarm = alarm;
    }

    public int getNrings() {
        return nrings;
    }

    public void setNrings(int nrings) {
        this.nrings = nrings;
    }

    public void onAlarm(AlarmEvent e) {
        if (alarm != null) {
            //Invoke the event handler.
            alarm.alarmActionPerformed(e);
        }
    }

    // event handling method
    public void start() {
        for (;;) {
            nrings--;
            if (nrings < 0) {
                break;
            } else {
                AlarmEvent e = new AlarmEvent(nrings);
                onAlarm(e);
            }
        }
    }

}
