package blacklinden.com.servicetest;

public class Constants {


    public interface ACTION {
        public static String MAIN_ACTION = "blacklinden.com.servicetest.action.main";
        public static String INIT_ACTION = "blacklinden.com.servicetest.action.init";
        public static String PREV_ACTION = "blacklinden.com.servicetest.action.prev";
        public static String PLAY_ACTION = "blacklinden.com.servicetest.action.play";
        public static String NEXT_ACTION = "blacklinden.com.servicetest.action.next";
        public static String STARTFOREGROUND_ACTION = "blacklinden.com.servicetest.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "blacklinden.com.servicetest.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
      int FOREGROUND_SERVICE = 101;
    }
}
