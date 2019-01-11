package com.zaferayan.creditcard.drawable;

import android.graphics.*;
import android.graphics.Bitmap.Config;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

public final class TileDrawable extends Drawable {
    private final Paint paint;

    public void draw(Canvas canvas) {
        canvas.drawPaint(this.paint);
    }

    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    private final Bitmap getBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        } else {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        }
    }

    public TileDrawable( Drawable drawable, TileMode tileMode) {
        super();
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(this.getBitmap(drawable), tileMode, tileMode));
        this.paint = paint;
    }
}
