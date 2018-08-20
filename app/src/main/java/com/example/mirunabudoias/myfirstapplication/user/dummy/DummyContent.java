package com.example.mirunabudoias.myfirstapplication.user.dummy;

import com.example.mirunabudoias.myfirstapplication.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    public static final List<User> ITEMS = new ArrayList<User>();


    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(User item) {
        ITEMS.add(item);
    }

    private static User createDummyItem(int position) {
        return new User(String.valueOf("User name "+ position), 20+position, "Address "+ position*100);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }


}
