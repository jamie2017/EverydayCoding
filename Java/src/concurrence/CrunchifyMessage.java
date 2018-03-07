package concurrence;

/**
 * Created by JMYE on 5/10/17.
 * simple Message class to put and get message into queue
 */
public class CrunchifyMessage {
    private String crunchifyMsg;

    public CrunchifyMessage(String string) {
        this.crunchifyMsg = string;
    }

    public String getMsg() {
        return crunchifyMsg;
    }
}