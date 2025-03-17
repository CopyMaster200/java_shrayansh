package learnjava.patterns.chainofresponse;

public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String messge) {
        if (logLevel == LogProcessor.ERROR) {
            System.out.println("ERROR log: " + messge);
        } else {
            super.log(logLevel, messge);
        }
    }
}
