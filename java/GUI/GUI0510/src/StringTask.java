public class StringTask implements Runnable {

    private volatile TaskState threadState;
    private Thread mainThread;
    private String result;
    private String text;
    private int multiplier;

    public StringTask (String text, int multiplier) {
        this.text = text;
        this.multiplier = multiplier;
        this.threadState = TaskState.CREATED;
        this.result = "";
    }

    public void start () {
        mainThread = new Thread(this, text);
        mainThread.start();
    }

    public void abort () {
        threadState = TaskState.ABORTED;
        mainThread.interrupt();
    }

    public String getResult () {
        return result;
    }

    public TaskState getState () {
        return threadState;
    }

    public boolean isDone () {
        if(this.threadState == TaskState.READY || this.threadState == TaskState.ABORTED){
            return true;
        }else{
            return false;
        }
    }

    public void run () {
        this.threadState = TaskState.RUNNING;

        String reversedString = "";

        for(int i = this.text.length() - 1; i >= 0; i--) {
            reversedString += this.text.charAt(i);
        }

        for(int i = 0; i < this.multiplier; i++){
            this.result += reversedString;
        }

        if (this.threadState != TaskState.ABORTED) {
            this.threadState = TaskState.READY;
        }
    }

    public String getTxt(){
        return this.text;
    }
}