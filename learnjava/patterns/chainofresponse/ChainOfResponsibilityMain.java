package learnjava.patterns.chainofresponse;

public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.INFO, "test info");
    }

}
