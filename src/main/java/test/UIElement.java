package test;

public class UIElement {
	private String name;
    private String xpath;

    public UIElement(String name, String xpath) {
        this.name = name;
        this.xpath = xpath;
    }

    public String getName() {
        return name;
    }

    public String getXpath() {
        return xpath;
    }

    @Override
    public String toString() {
        return "Element{name='" + name + "', xpath='" + xpath + "'}";
    }
}
