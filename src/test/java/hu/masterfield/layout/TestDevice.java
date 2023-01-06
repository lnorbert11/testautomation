package hu.masterfield.layout;

import org.openqa.selenium.Dimension;

import java.util.List;

//objektum ami adatokat tárol
public class TestDevice {
    private String name;
    private Dimension screenSize; //szélesség magasság

    public TestDevice(String name, Dimension screenSize, List<String> tags) {
        this.name = name;
        this.screenSize = screenSize;
        this.tags = tags;
    }

    private List<String> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Dimension screenSize) {
        this.screenSize = screenSize;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestDevice{");
        sb.append("name='").append(name).append('\'');
        sb.append(", screenSize=").append(screenSize);
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }





}
