package cacheopgv;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class User {

    int id;

    public User(int id) {
        this.id = id;
    }

    public UserData getUserData() throws InterruptedException {
        UserData uData = new UserData();
        if (Cache.has(id)) {
            uData = Cache.get(id);
        } else {
            uData.setData(getDataSlow());
            Cache.set(id, uData);
        }
        return uData;
    }

    public String getDataSlow() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return RandomStringUtils.randomAlphabetic(1000);
    }

    public void setTTL(int key, int minutes) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Cache.delete(key);
            }
        };
        timer.schedule(task, minutes * 60000);
    }
}
