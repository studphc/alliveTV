package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import p000.r83;
import p000.s83;

/* loaded from: classes.dex */
public final class zak extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    public int f13718a;

    /* renamed from: b */
    public long f13719b;

    /* renamed from: c */
    public int f13720c;

    /* renamed from: d */
    public int f13721d;

    /* renamed from: e */
    public int f13722e;

    /* renamed from: f */
    public int f13723f;

    /* renamed from: g */
    public final boolean f13724g;

    /* renamed from: h */
    public boolean f13725h;

    /* renamed from: i */
    public final s83 f13726i;

    /* renamed from: j */
    public final Drawable f13727j;

    /* renamed from: k */
    public final Drawable f13728k;

    /* renamed from: l */
    public boolean f13729l;

    /* renamed from: m */
    public boolean f13730m;

    /* renamed from: n */
    public boolean f13731n;

    /* renamed from: o */
    public int f13732o;

    public zak(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this(null);
        drawable = drawable == null ? r83.f25902a : drawable;
        this.f13727j = drawable;
        drawable.setCallback(this);
        s83 s83Var = this.f13726i;
        s83Var.f26316b = drawable.getChangingConfigurations() | s83Var.f26316b;
        drawable2 = drawable2 == null ? r83.f25902a : drawable2;
        this.f13728k = drawable2;
        drawable2.setCallback(this);
        s83 s83Var2 = this.f13726i;
        s83Var2.f26316b = drawable2.getChangingConfigurations() | s83Var2.f26316b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x004f, code lost:
    
        if (r0 == 0) goto L22;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void draw(Canvas canvas) {
        boolean z;
        int i = this.f13718a;
        int i2 = 0;
        if (i != 1) {
            if (i != 2 || this.f13719b < 0) {
                z = true;
            } else {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f13719b)) / this.f13722e;
                if (uptimeMillis >= 1.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.f13718a = 0;
                }
                this.f13723f = (int) ((this.f13720c * Math.min(uptimeMillis, 1.0f)) + RecyclerView.f7068F0);
            }
        } else {
            this.f13719b = SystemClock.uptimeMillis();
            this.f13718a = 2;
            z = false;
        }
        int i3 = this.f13723f;
        boolean z2 = this.f13724g;
        Drawable drawable = this.f13727j;
        Drawable drawable2 = this.f13728k;
        if (z) {
            if (!z2) {
                i2 = i3;
            }
            drawable.draw(canvas);
            i3 = i2;
            int i4 = this.f13721d;
            if (i3 == i4) {
                drawable2.setAlpha(i4);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z2) {
            drawable.setAlpha(this.f13721d - i3);
            i2 = 1;
        }
        drawable.draw(canvas);
        if (i2 != 0) {
            drawable.setAlpha(this.f13721d);
        }
        if (i3 > 0) {
            drawable2.setAlpha(i3);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f13721d);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        s83 s83Var = this.f13726i;
        return changingConfigurations | s83Var.f26315a | s83Var.f26316b;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public final Drawable.ConstantState getConstantState() {
        if (zac()) {
            int changingConfigurations = getChangingConfigurations();
            s83 s83Var = this.f13726i;
            s83Var.f26315a = changingConfigurations;
            return s83Var;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f13727j.getIntrinsicHeight(), this.f13728k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f13727j.getIntrinsicWidth(), this.f13728k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.f13731n) {
            this.f13732o = Drawable.resolveOpacity(this.f13727j.getOpacity(), this.f13728k.getOpacity());
            this.f13731n = true;
        }
        return this.f13732o;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @CanIgnoreReturnValue
    public final Drawable mutate() {
        if (!this.f13725h && super.mutate() == this) {
            if (zac()) {
                this.f13727j.mutate();
                this.f13728k.mutate();
                this.f13725h = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f13727j.setBounds(rect);
        this.f13728k.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f13723f == this.f13721d) {
            this.f13723f = i;
        }
        this.f13721d = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f13727j.setColorFilter(colorFilter);
        this.f13728k.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zaa() {
        return this.f13728k;
    }

    public final void zab(int i) {
        this.f13720c = this.f13721d;
        this.f13723f = 0;
        this.f13722e = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.f13718a = 1;
        invalidateSelf();
    }

    public final boolean zac() {
        if (!this.f13729l) {
            boolean z = false;
            if (this.f13727j.getConstantState() != null && this.f13728k.getConstantState() != null) {
                z = true;
            }
            this.f13730m = z;
            this.f13729l = true;
        }
        return this.f13730m;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable$ConstantState, s83] */
    public zak(s83 s83Var) {
        this.f13718a = 0;
        this.f13721d = 255;
        this.f13723f = 0;
        this.f13724g = true;
        ?? constantState = new Drawable.ConstantState();
        if (s83Var != null) {
            constantState.f26315a = s83Var.f26315a;
            constantState.f26316b = s83Var.f26316b;
        }
        this.f13726i = constantState;
    }
}
