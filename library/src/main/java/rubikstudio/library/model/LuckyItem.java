package rubikstudio.library.model;

/**
 * Created by kiennguyen on 11/5/16.
 */

public class LuckyItem {
    public String topText;
    public String secondaryText;
    public int secondaryTextOrientation;
    public int icon;
    public int color;

    public LuckyItem(String topText, int icon, int color) {
        this.topText = topText;
        this.icon = icon;
        this.color = color;
    }
    public LuckyItem(){

    }
}
