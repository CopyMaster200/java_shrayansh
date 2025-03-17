package learnjava.patterns.chainofresponse;

public class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String messge) {
        if (logLevel == LogProcessor.INFO) {
            System.out.println("INFO log: " + messge);
        } else {
            super.log(logLevel, messge);
        }
    }
}
