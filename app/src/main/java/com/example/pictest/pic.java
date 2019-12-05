package com.example.pictest;

import android.graphics.Bitmap;

public class pic {
    private Bitmap pic;

    public pic(Bitmap pic) {
        this.pic = pic;
    }

    public Bitmap getPic() {
        return pic;
    }

    public void setPic(Bitmap pic) {
        this.pic = pic;
    }
}
