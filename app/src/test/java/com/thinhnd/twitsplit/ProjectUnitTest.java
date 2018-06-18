package com.thinhnd.twitsplit;

import com.thinhnd.twitsplit.utils.Constants;
import com.thinhnd.twitsplit.utils.StringUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ProjectUnitTest {
    /**
     * message < 50
     * Expected: "Test message length less than character limit"
     */
    @Test
    public void testMessageLengthLessThanCharacterLimit() {
        List<String> expected = new ArrayList<>();
        String message = "Test message length less than character limit";
        String ex = "Test message length less than character limit";
        expected.add(ex);
        assertEquals(expected, StringUtils.splitMessage(message));

    }

    /**
     * message > 50
     * Input : "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
     * Expected : "1/2 I can't believe Tweeter now supports chunking"
     * "2/2 my messages, so I don't have to do it myself."
     */
    @Test
    public void testMessageLengthGreaterThanCharacterLimit() {
        List<String> expected = new ArrayList<>();
        String message = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself.";
        String ex1 = "1/2 I can't believe Tweeter now supports chunking";
        String ex2 = "2/2 my messages, so I don't have to do it myself.";
        expected.add(ex1);
        expected.add(ex2);
        assertEquals(expected, StringUtils.splitMessage(message));
    }

    /**
     * If the message contains a span
     * of non-whitespace characters longer than 50 characters, display an error.
     * Input : "testMessageSpanOfNonWhiteSpaceLongerThanCharacterLimittestMessageSpanOfNonWhiteSpaceLongerThanCharacterLimit"
     * Expected : return empty list after split
     */
    @Test
    public void testMessageSpanOfNonWhiteSpaceLongerThanCharacterLimit() {
        List<String> expected = new ArrayList<>();
        String message = "testMessageSpanOfNonWhiteSpaceLongerThanCharacterLimittestMessageSpanOfNonWhiteSpaceLongerThanCharacterLimit";
        assertEquals(expected, StringUtils.splitMessage(message));
    }
}