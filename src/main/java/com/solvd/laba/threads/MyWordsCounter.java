package com.solvd.laba.threads;

import java.util.Collections;
import java.util.List;

public class MyWordsCounter implements Runnable {

    private final List<String> lines;
    private final ISearchEngine engine;
    private final String word;

    public MyWordsCounter(List<String> lines, ISearchEngine engine, String word) {
        this.lines = Collections.unmodifiableList(lines);
        this.engine = engine;
        this.word = word;
    }

    @Override
    public void run() {
        for (String line : this.lines) {
            this.engine.search(line, this.word);
        }
    }
}
