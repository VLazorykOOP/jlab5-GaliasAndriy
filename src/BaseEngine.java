public abstract class BaseEngine implements Comparable<BaseEngine>{
    private String title;

    public BaseEngine() {
        title = "no type";
    }
    public BaseEngine(String t) {
        title = t;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String type){
        this.title = type;
    }
    @Override
    public int compareTo(BaseEngine other) {
        return this.getTitle().compareTo(other.getTitle());
    }
    public String show() {
        return "\n Title: " + title;
    }
}