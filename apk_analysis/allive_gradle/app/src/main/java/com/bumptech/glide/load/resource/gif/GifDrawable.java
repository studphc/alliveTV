package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import p000.vw0;
import p000.xw0;
import p000.zw0;

/* loaded from: classes.dex */
public class GifDrawable extends Drawable implements GifFrameLoader$FrameCallback, Animatable, Animatable2Compat {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;

    /* renamed from: a */
    public final vw0 f8941a;

    /* renamed from: b */
    public boolean f8942b;

    /* renamed from: c */
    public boolean f8943c;

    /* renamed from: d */
    public boolean f8944d;

    /* renamed from: e */
    public boolean f8945e;

    /* renamed from: f */
    public int f8946f;

    /* renamed from: g */
    public int f8947g;

    /* renamed from: h */
    public boolean f8948h;

    /* renamed from: i */
    public Paint f8949i;

    /* renamed from: j */
    public Rect f8950j;

    /* renamed from: k */
    public ArrayList f8951k;

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i, i2, bitmap);
    }

    /* renamed from: a */
    public final void m2363a() {
        Preconditions.checkArgument(!this.f8944d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        vw0 vw0Var = this.f8941a;
        if (vw0Var.f27980a.f29528a.getFrameCount() == 1) {
            invalidateSelf();
            return;
        }
        if (!this.f8942b) {
            this.f8942b = true;
            zw0 zw0Var = vw0Var.f27980a;
            if (!zw0Var.f29538k) {
                ArrayList arrayList = zw0Var.f29530c;
                if (!arrayList.contains(this)) {
                    boolean isEmpty = arrayList.isEmpty();
                    arrayList.add(this);
                    if (isEmpty && !zw0Var.f29533f) {
                        zw0Var.f29533f = true;
                        zw0Var.f29538k = false;
                        zw0Var.m8443a();
                    }
                    invalidateSelf();
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        ArrayList arrayList = this.f8951k;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (this.f8944d) {
            return;
        }
        if (this.f8948h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f8950j == null) {
                this.f8950j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f8950j);
            this.f8948h = false;
        }
        zw0 zw0Var = this.f8941a.f27980a;
        xw0 xw0Var = zw0Var.f29537j;
        if (xw0Var != null) {
            bitmap = xw0Var.f28752g;
        } else {
            bitmap = zw0Var.f29540m;
        }
        if (this.f8950j == null) {
            this.f8950j = new Rect();
        }
        Rect rect = this.f8950j;
        if (this.f8949i == null) {
            this.f8949i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f8949i);
    }

    public ByteBuffer getBuffer() {
        return this.f8941a.f27980a.f29528a.getData().asReadOnlyBuffer();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f8941a;
    }

    public Bitmap getFirstFrame() {
        return this.f8941a.f27980a.f29540m;
    }

    public int getFrameCount() {
        return this.f8941a.f27980a.f29528a.getFrameCount();
    }

    public int getFrameIndex() {
        xw0 xw0Var = this.f8941a.f27980a.f29537j;
        if (xw0Var != null) {
            return xw0Var.f28750e;
        }
        return -1;
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.f8941a.f27980a.f29541n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8941a.f27980a.f29545r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8941a.f27980a.f29544q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        zw0 zw0Var = this.f8941a.f27980a;
        return zw0Var.f29528a.getByteSize() + zw0Var.f29543p;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f8942b;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f8948h = true;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameCallback
    public void onFrameReady() {
        Object callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.f8946f++;
        }
        int i = this.f8947g;
        if (i != -1 && this.f8946f >= i) {
            ArrayList arrayList = this.f8951k;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((Animatable2Compat.AnimationCallback) this.f8951k.get(i2)).onAnimationEnd(this);
                }
            }
            stop();
        }
    }

    public void recycle() {
        this.f8944d = true;
        zw0 zw0Var = this.f8941a.f27980a;
        zw0Var.f29530c.clear();
        Bitmap bitmap = zw0Var.f29540m;
        if (bitmap != null) {
            zw0Var.f29532e.put(bitmap);
            zw0Var.f29540m = null;
        }
        zw0Var.f29533f = false;
        xw0 xw0Var = zw0Var.f29537j;
        RequestManager requestManager = zw0Var.f29531d;
        if (xw0Var != null) {
            requestManager.clear(xw0Var);
            zw0Var.f29537j = null;
        }
        xw0 xw0Var2 = zw0Var.f29539l;
        if (xw0Var2 != null) {
            requestManager.clear(xw0Var2);
            zw0Var.f29539l = null;
        }
        xw0 xw0Var3 = zw0Var.f29542o;
        if (xw0Var3 != null) {
            requestManager.clear(xw0Var3);
            zw0Var.f29542o = null;
        }
        zw0Var.f29528a.clear();
        zw0Var.f29538k = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f8951k == null) {
            this.f8951k = new ArrayList();
        }
        this.f8951k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f8949i == null) {
            this.f8949i = new Paint(2);
        }
        this.f8949i.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f8949i == null) {
            this.f8949i = new Paint(2);
        }
        this.f8949i.setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f8941a.f27980a.m8445c(transformation, bitmap);
    }

    public void setLoopCount(int i) {
        int i2 = -1;
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            int totalIterationCount = this.f8941a.f27980a.f29528a.getTotalIterationCount();
            if (totalIterationCount != 0) {
                i2 = totalIterationCount;
            }
            this.f8947g = i2;
            return;
        }
        this.f8947g = i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.checkArgument(!this.f8944d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f8945e = z;
        if (!z) {
            this.f8942b = false;
            zw0 zw0Var = this.f8941a.f27980a;
            ArrayList arrayList = zw0Var.f29530c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                zw0Var.f29533f = false;
            }
        } else if (this.f8943c) {
            m2363a();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f8943c = true;
        this.f8946f = 0;
        if (this.f8945e) {
            m2363a();
        }
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.f8942b, "You cannot restart a currently running animation.");
        zw0 zw0Var = this.f8941a.f27980a;
        Preconditions.checkArgument(!zw0Var.f29533f, "Can't restart a running animation");
        zw0Var.f29535h = true;
        xw0 xw0Var = zw0Var.f29542o;
        if (xw0Var != null) {
            zw0Var.f29531d.clear(xw0Var);
            zw0Var.f29542o = null;
        }
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f8943c = false;
        this.f8942b = false;
        zw0 zw0Var = this.f8941a.f27980a;
        ArrayList arrayList = zw0Var.f29530c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            zw0Var.f29533f = false;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        ArrayList arrayList = this.f8951k;
        if (arrayList != null && animationCallback != null) {
            return arrayList.remove(animationCallback);
        }
        return false;
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new vw0(new zw0(Glide.get(context), gifDecoder, i, i2, transformation, bitmap)));
    }

    public GifDrawable(vw0 vw0Var) {
        this.f8945e = true;
        this.f8947g = -1;
        this.f8941a = (vw0) Preconditions.checkNotNull(vw0Var);
    }
}
