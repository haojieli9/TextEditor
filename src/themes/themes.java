package themes;

import com.formdev.flatlaf.FlatLaf;

public class themes {
    private String themeName;

    public themes() {
        themeName = "LightLaf"; // Valor predeterminado
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}

