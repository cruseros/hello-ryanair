package domain;

public class SearchPaxs {
    private int numAdults;
    private int numChildren;

    public SearchPaxs(int numAdults, int numChildren) {
        this.numAdults = numAdults;
        this.numChildren = numChildren;
    }

    public int getNumAdults() {
        return numAdults;
    }

    public int getNumChildren() {
        return numChildren;
    }
}
