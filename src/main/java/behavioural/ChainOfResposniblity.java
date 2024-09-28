package behavioural;

public class ChainOfResposniblity {
    public static void main(String[] args) {
        LogProcessor processor = new InfoLogProcessor(new ErrorLogProcessor(null));

        processor.log(3, "Oops my fault");
        processor.log(1, "Just informing you");

    }
}


abstract class LogProcessor {

    static int INFO = 1;
    static int ERROR = 3;

    LogProcessor next;

    public LogProcessor(LogProcessor next) {
        this.next = next;
    }

    void log(int type, String msg) {
        if (next == null)
            return;
        next.log(type, msg);
    }

}

class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    void log(int type, String msg) {
        if (type == INFO) {
            System.out.println("INFO: " + msg);
        } else {
            super.log(type, msg);
        }
    }


}

class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    void log(int type, String msg) {
        if (type == ERROR) {
            System.out.println("ERROR:" + msg);
        } else {
            super.log(type, msg);
        }
    }

}