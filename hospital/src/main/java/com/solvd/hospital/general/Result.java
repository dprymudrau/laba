package com.solvd.hospital.general;

public class Result {
    private String url;
    private boolean redirect;

    public Result() {
    }

    public Result(String url, boolean redirect) {
        this.url = url;
        this.redirect = redirect;
    }

    public Result(String url) {
        this(url, false);
    }

    public String getUrl() {
        return url;
    }

    public boolean isRedirect() {
        return redirect;
    }
}
