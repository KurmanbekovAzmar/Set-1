package Model;

public class GeneratedId {
    public static Long groupid= 0L;
    public  static Long groupid(){
        return ++groupid;
    }

    public static Long studentId=0L;
    public static Long studentId() {
        return ++studentId;
    }
   public static Long lessonid=0L;
    public static Long lessonid(){
        return ++lessonid;
    }
}
