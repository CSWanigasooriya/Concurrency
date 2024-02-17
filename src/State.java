import util.ANSI;

public class State implements Runnable {
    private boolean logStates = false;

    public State() {
    }

    public State(boolean logStates) {
        this.logStates = true;
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            if (logStates)
                System.out.println(ANSI.ANSI_RED.getAnsiCode() + "THREAD_NAME: " + Thread.currentThread().getName() + ANSI.ANSI_RESET.getAnsiCode() + ANSI.ANSI_CYAN.getAnsiCode() + " SLEEP_TIME: " + i + ANSI.ANSI_RESET.getAnsiCode());
            try {
                Thread.sleep(i);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
