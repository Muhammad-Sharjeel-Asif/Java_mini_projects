public class open_cmd{
    public static void main(String[] args){
        try{
            // Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
            Runtime.getRuntime().exec(new String[] {"notepad"});
        }
        catch(Exception e){
            System .out.println("Error");
            e.printStackTrace();
        }
    }
}