package com.solvd.laba.threads;

public class EasySearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        long counter = 0;
        word = " " + word + " ";
        int index = -1;
        do {
            index = text.indexOf(word, index+1);
                if (index != -1) {
                    counter++;
                }
            } while (index != -1);

        return counter;
    }
}
