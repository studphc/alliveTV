package p000;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public abstract class m60 {

    /* renamed from: a */
    public static final l60 f22822a = new BitmapPoolAdapter();

    /* renamed from: a */
    public static BitmapResource m6082a(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i == Integer.MIN_VALUE && current.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                }
            } else if (i2 == Integer.MIN_VALUE && current.getIntrinsicHeight() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
            } else {
                if (current.getIntrinsicWidth() > 0) {
                    i = current.getIntrinsicWidth();
                }
                if (current.getIntrinsicHeight() > 0) {
                    i2 = current.getIntrinsicHeight();
                }
                Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
                bitmapDrawableLock.lock();
                Bitmap bitmap2 = bitmapPool.get(i, i2, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(bitmap2);
                    current.setBounds(0, 0, i, i2);
                    current.draw(canvas);
                    canvas.setBitmap(null);
                    bitmapDrawableLock.unlock();
                    bitmap = bitmap2;
                    z = true;
                } catch (Throwable th) {
                    bitmapDrawableLock.unlock();
                    throw th;
                }
            }
            bitmap = null;
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            bitmapPool = f22822a;
        }
        return BitmapResource.obtain(bitmap, bitmapPool);
    }
}
