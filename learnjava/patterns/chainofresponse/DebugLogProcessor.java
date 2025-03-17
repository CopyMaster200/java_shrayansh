package learnjava.patterns.chainofresponse;

public class DebugLogProcessor extends LogProcessor {
    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String messge) {
        if (logLevel == LogProcessor.DEBUG) {
            System.out.println("DEBUG log: " + messge);
        } else {
            super.log(logLevel, messge);
        }
    }
}
