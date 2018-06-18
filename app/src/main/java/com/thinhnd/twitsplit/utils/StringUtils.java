package com.thinhnd.twitsplit.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinhND on 6/16/2018.
 */
public class StringUtils {
    public static List<String> splitMessage (String message) {

        List<String> messageList = new ArrayList<>();
        if (TextUtils.isEmpty(message)) {
            return messageList;
        }

        //Replace multi white space and new line \n
        message = message.replaceAll("\n", " ").replaceAll("\\s{2,}", " ");

        if (message.length() <= Constants.LIMIT_MESSAGE_LENGTH) {
            messageList.add(message);
            return messageList;
        }

        int totalParts = message.length() / Constants.LIMIT_MESSAGE_LENGTH
                + ((message.length() % Constants.LIMIT_MESSAGE_LENGTH > 0) ? 1 : 0);

        String[] words = message.split("\\s");
        if (words.length == 0) {
            return new ArrayList<>();
        } else {
            for (String word : words) {
                if (word.length() > Constants.LIMIT_MESSAGE_LENGTH) {
                    return new ArrayList<>();
                }
            }
        }
        return getIndicatorParts(words, totalParts, Constants.LIMIT_MESSAGE_LENGTH);
    }

    private static List<String> getIndicatorParts(String[] words, int totalParts, int limit) {
        List<String> messageParts = new ArrayList<>();
        int index = -1;
        for (int i = 1; i <= totalParts; i++) {
            StringBuilder part = new StringBuilder();
            part.append(i).append("/").append(totalParts);
            String indicator = part.toString();
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (index >= j)
                    continue;
                if (part.length() + word.length() + 1> limit) {
                    break;
                } else {
                    part.append(" ").append(word);
                    index = j;
                }
            }
            if (indicator.equals(part.toString())) {
                messageParts.clear();
                return messageParts;
            }
            messageParts.add(part.toString());
            part.setLength(0);
        }
        //Recursive if total part cannot stock all indicator part
        if (index < words.length - 1) {
            messageParts.clear();
            messageParts = getIndicatorParts(words, totalParts + 1, limit);
        }
        return messageParts;
    }
}
