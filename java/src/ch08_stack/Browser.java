package ch08_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Browser {
    // visited url list
    private final List<String> historyStack;
    // can go to the url list
    private final List<String> forwardStack;

    public Browser() {
        this.historyStack = new ArrayList<>();
        this.forwardStack = new ArrayList<>();
    }

    // click url while push the url to the historyStack and clear the forwardStack
    public void clickUrl(String url) {
        historyStack.add(url);
        forwardStack.clear();
    }

    // pop url form the forwardStack and push it into the historyStack
    public void forward() {
        if (forwardStack.size() > 0) {
            int lastIndex = forwardStack.size() - 1;
            String popUrl = forwardStack.remove(lastIndex);
            historyStack.add(popUrl);
            System.out.println("Now we in " + this.historyStack.get(historyStack.size() -1) + "page");
        } else {
            System.out.println("Don't have page for forward");
        }
    }

    // go to the url we just visited it.
    public void goBack() {
        if (historyStack.size() > 0) {
            int lastIndex = historyStack.size() - 1;
            String popUrl = historyStack.remove(lastIndex);
            forwardStack.add(popUrl);
            System.out.println("Now we in " + this.historyStack.get(historyStack.size() -1) + "page");
        } else {
            System.out.println("Don't have page for go back");
        }
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.historyStack.add("index");
        browser.historyStack.add("home");
        browser.historyStack.add("user");
        // browser.forward();
        browser.goBack();
        // browser.forward();
        Collections.reverse(browser.historyStack);
        System.out.println("=============history");
        browser.historyStack.forEach(System.out::println);
        System.out.println();
        System.out.println("===============future");
        browser.forwardStack.forEach(System.out::println);

    }
}
