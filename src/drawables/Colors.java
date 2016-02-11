package drawables;

/**
 * Created by jgecy on 2016-02-11.
 */
public class Colors {
    private static Colors ourInstance = new Colors();

    public static Colors getInstance() {
        return ourInstance;
    }


    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";


    public String[] colors = new String[]{RESET, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN};

    int i = 0;

    private Colors() {
    }

    public String getNext(){
        String color = colors[i++];
        if(i >= color.length()){
            i = 0;
        }
        return color;
    }

}
