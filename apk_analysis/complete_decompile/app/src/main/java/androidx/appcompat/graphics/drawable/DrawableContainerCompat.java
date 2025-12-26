package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;
import p000.C0584c8;
import p000.RunnableC1104d;
import p000.rn2;

/* loaded from: classes.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: m */
    public static final /* synthetic */ int f751m = 0;

    /* renamed from: a */
    public rn2 f752a;

    /* renamed from: b */
    public Rect f753b;

    /* renamed from: c */
    public Drawable f754c;

    /* renamed from: d */
    public Drawable f755d;

    /* renamed from: f */
    public boolean f757f;

    /* renamed from: h */
    public boolean f759h;

    /* renamed from: i */
    public RunnableC1104d f760i;

    /* renamed from: j */
    public long f761j;

    /* renamed from: k */
    public long f762k;

    /* renamed from: l */
    public C0584c8 f763l;

    /* renamed from: e */
    public int f756e = 255;

    /* renamed from: g */
    public int f758g = -1;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m200a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.f757f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f754c;
        if (drawable2 != null) {
            long j = this.f761j;
            if (j != 0) {
                if (j <= uptimeMillis) {
                    drawable2.setAlpha(this.f756e);
                    this.f761j = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j - uptimeMillis) * 255)) / this.f752a.f26076z)) * this.f756e) / 255);
                    z2 = true;
                    drawable = this.f755d;
                    if (drawable == null) {
                        long j2 = this.f762k;
                        if (j2 != 0) {
                            if (j2 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f755d = null;
                                this.f762k = 0L;
                            } else {
                                drawable.setAlpha(((((int) ((j2 - uptimeMillis) * 255)) / this.f752a.f26042A) * this.f756e) / 255);
                                if (z && z3) {
                                    scheduleSelf(this.f760i, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.f762k = 0L;
                    }
                    z3 = z2;
                    if (z) {
                        return;
                    } else {
                        return;
                    }
                }
            }
        } else {
            this.f761j = 0L;
        }
        z2 = false;
        drawable = this.f755d;
        if (drawable == null) {
        }
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        rn2 rn2Var = this.f752a;
        if (theme != null) {
            rn2Var.m7290c();
            int i = rn2Var.f26058h;
            Drawable[] drawableArr = rn2Var.f26057g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null && DrawableCompat.canApplyTheme(drawable)) {
                    DrawableCompat.applyTheme(drawableArr[i2], theme);
                    rn2Var.f26055e |= drawableArr[i2].getChangingConfigurations();
                }
            }
            Resources resources = theme.getResources();
            if (resources != null) {
                rn2Var.f26052b = resources;
                int i3 = resources.getDisplayMetrics().densityDpi;
                if (i3 == 0) {
                    i3 = 160;
                }
                int i4 = rn2Var.f26053c;
                rn2Var.f26053c = i3;
                if (i4 != i3) {
                    rn2Var.f26063m = false;
                    rn2Var.f26060j = false;
                    return;
                }
                return;
            }
            return;
        }
        rn2Var.getClass();
    }

    /* renamed from: b */
    public rn2 mo197b() {
        return this.f752a;
    }

    /* renamed from: c */
    public final void m201c(Drawable drawable) {
        if (this.f763l == null) {
            this.f763l = new C0584c8();
        }
        C0584c8 c0584c8 = this.f763l;
        c0584c8.f8286b = drawable.getCallback();
        drawable.setCallback(c0584c8);
        try {
            if (this.f752a.f26076z <= 0 && this.f757f) {
                drawable.setAlpha(this.f756e);
            }
            rn2 rn2Var = this.f752a;
            if (rn2Var.f26045D) {
                drawable.setColorFilter(rn2Var.f26044C);
            } else {
                if (rn2Var.f26048G) {
                    DrawableCompat.setTintList(drawable, rn2Var.f26046E);
                }
                rn2 rn2Var2 = this.f752a;
                if (rn2Var2.f26049H) {
                    DrawableCompat.setTintMode(drawable, rn2Var2.f26047F);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f752a.f26074x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            DrawableCompat.setAutoMirrored(drawable, this.f752a.f26043B);
            Rect rect = this.f753b;
            if (rect != null) {
                DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            C0584c8 c0584c82 = this.f763l;
            Drawable.Callback callback = (Drawable.Callback) c0584c82.f8286b;
            c0584c82.f8286b = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            C0584c8 c0584c83 = this.f763l;
            Drawable.Callback callback2 = (Drawable.Callback) c0584c83.f8286b;
            c0584c83.f8286b = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.f752a.canApplyTheme();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m202d(int i) {
        RunnableC1104d runnableC1104d;
        if (i == this.f758g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f752a.f26042A > 0) {
            Drawable drawable = this.f755d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f754c;
            if (drawable2 != null) {
                this.f755d = drawable2;
                this.f762k = this.f752a.f26042A + uptimeMillis;
            } else {
                this.f755d = null;
                this.f762k = 0L;
            }
        } else {
            Drawable drawable3 = this.f754c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0) {
            rn2 rn2Var = this.f752a;
            if (i < rn2Var.f26058h) {
                Drawable m7291d = rn2Var.m7291d(i);
                this.f754c = m7291d;
                this.f758g = i;
                if (m7291d != null) {
                    int i2 = this.f752a.f26076z;
                    if (i2 > 0) {
                        this.f761j = uptimeMillis + i2;
                    }
                    m201c(m7291d);
                }
                if (this.f761j == 0 || this.f762k != 0) {
                    runnableC1104d = this.f760i;
                    if (runnableC1104d != null) {
                        this.f760i = new RunnableC1104d(13, (StateListDrawableCompat) this);
                    } else {
                        unscheduleSelf(runnableC1104d);
                    }
                    m200a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f754c = null;
        this.f758g = -1;
        if (this.f761j == 0) {
        }
        runnableC1104d = this.f760i;
        if (runnableC1104d != null) {
        }
        m200a(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f754c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f755d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* renamed from: e */
    public void mo198e(rn2 rn2Var) {
        this.f752a = rn2Var;
        int i = this.f758g;
        if (i >= 0) {
            Drawable m7291d = rn2Var.m7291d(i);
            this.f754c = m7291d;
            if (m7291d != null) {
                m201c(m7291d);
            }
        }
        this.f755d = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f756e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f752a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26072v) {
            z = rn2Var.f26073w;
        } else {
            rn2Var.m7290c();
            rn2Var.f26072v = true;
            int i = rn2Var.f26058h;
            Drawable[] drawableArr = rn2Var.f26057g;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (drawableArr[i2].getConstantState() == null) {
                        rn2Var.f26073w = false;
                        z = false;
                        break;
                    }
                    i2++;
                } else {
                    rn2Var.f26073w = true;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.f752a.f26054d = getChangingConfigurations();
            return this.f752a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f754c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f753b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26062l) {
            if (!rn2Var.f26063m) {
                rn2Var.m7289b();
            }
            return rn2Var.f26065o;
        }
        Drawable drawable = this.f754c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26062l) {
            if (!rn2Var.f26063m) {
                rn2Var.m7289b();
            }
            return rn2Var.f26064n;
        }
        Drawable drawable = this.f754c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26062l) {
            if (!rn2Var.f26063m) {
                rn2Var.m7289b();
            }
            return rn2Var.f26067q;
        }
        Drawable drawable = this.f754c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26062l) {
            if (!rn2Var.f26063m) {
                rn2Var.m7289b();
            }
            return rn2Var.f26066p;
        }
        Drawable drawable = this.f754c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f754c;
        int i = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26068r) {
            return rn2Var.f26069s;
        }
        rn2Var.m7290c();
        int i2 = rn2Var.f26058h;
        Drawable[] drawableArr = rn2Var.f26057g;
        if (i2 > 0) {
            i = drawableArr[0].getOpacity();
        }
        for (int i3 = 1; i3 < i2; i3++) {
            i = Drawable.resolveOpacity(i, drawableArr[i3].getOpacity());
        }
        rn2Var.f26069s = i;
        rn2Var.f26068r = true;
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f754c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        rn2 rn2Var = this.f752a;
        boolean z = false;
        Rect rect2 = null;
        if (!rn2Var.f26059i) {
            Rect rect3 = rn2Var.f26061k;
            if (rect3 == null && !rn2Var.f26060j) {
                rn2Var.m7290c();
                Rect rect4 = new Rect();
                int i = rn2Var.f26058h;
                Drawable[] drawableArr = rn2Var.f26057g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                rn2Var.f26060j = true;
                rn2Var.f26061k = rect2;
            } else {
                rect2 = rect3;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                z = true;
            }
        } else {
            Drawable drawable = this.f754c;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        rn2 rn2Var = this.f752a;
        if (rn2Var != null) {
            rn2Var.f26068r = false;
            rn2Var.f26070t = false;
        }
        if (drawable == this.f754c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f752a.f26043B;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26070t) {
            return rn2Var.f26071u;
        }
        rn2Var.m7290c();
        int i = rn2Var.f26058h;
        Drawable[] drawableArr = rn2Var.f26057g;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (drawableArr[i2].isStateful()) {
                z = true;
                break;
            }
            i2++;
        }
        rn2Var.f26071u = z;
        rn2Var.f26070t = true;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f755d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f755d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f754c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f757f) {
                this.f754c.setAlpha(this.f756e);
            }
        }
        if (this.f762k != 0) {
            this.f762k = 0L;
            z = true;
        }
        if (this.f761j != 0) {
            this.f761j = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f759h && super.mutate() == this) {
            rn2 mo197b = mo197b();
            mo197b.mo7293f();
            mo198e(mo197b);
            this.f759h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f755d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f754c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        rn2 rn2Var = this.f752a;
        int i2 = this.f758g;
        int i3 = rn2Var.f26058h;
        Drawable[] drawableArr = rn2Var.f26057g;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                boolean layoutDirection = DrawableCompat.setLayoutDirection(drawable, i);
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        rn2Var.f26075y = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f755d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f754c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.f755d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f754c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        if (drawable == this.f754c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (!this.f757f || this.f756e != i) {
            this.f757f = true;
            this.f756e = i;
            Drawable drawable = this.f754c;
            if (drawable != null) {
                if (this.f761j == 0) {
                    drawable.setAlpha(i);
                } else {
                    m200a(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26043B != z) {
            rn2Var.f26043B = z;
            Drawable drawable = this.f754c;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        rn2 rn2Var = this.f752a;
        rn2Var.f26045D = true;
        if (rn2Var.f26044C != colorFilter) {
            rn2Var.f26044C = colorFilter;
            Drawable drawable = this.f754c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        rn2 rn2Var = this.f752a;
        if (rn2Var.f26074x != z) {
            rn2Var.f26074x = z;
            Drawable drawable = this.f754c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setEnterFadeDuration(int i) {
        this.f752a.f26076z = i;
    }

    public void setExitFadeDuration(int i) {
        this.f752a.f26042A = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f754c;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f753b;
        if (rect == null) {
            this.f753b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f754c;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(@ColorInt int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        rn2 rn2Var = this.f752a;
        rn2Var.f26048G = true;
        if (rn2Var.f26046E != colorStateList) {
            rn2Var.f26046E = colorStateList;
            DrawableCompat.setTintList(this.f754c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        rn2 rn2Var = this.f752a;
        rn2Var.f26049H = true;
        if (rn2Var.f26047F != mode) {
            rn2Var.f26047F = mode;
            DrawableCompat.setTintMode(this.f754c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f755d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f754c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.f754c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
