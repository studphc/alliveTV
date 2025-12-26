package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.core.graphics.drawable.DrawableCompat;

/* loaded from: classes.dex */
public class rn2 extends Drawable.ConstantState {

    /* renamed from: A */
    public int f26042A;

    /* renamed from: B */
    public boolean f26043B;

    /* renamed from: C */
    public ColorFilter f26044C;

    /* renamed from: D */
    public boolean f26045D;

    /* renamed from: E */
    public ColorStateList f26046E;

    /* renamed from: F */
    public PorterDuff.Mode f26047F;

    /* renamed from: G */
    public boolean f26048G;

    /* renamed from: H */
    public boolean f26049H;

    /* renamed from: I */
    public int[][] f26050I;

    /* renamed from: a */
    public final StateListDrawableCompat f26051a;

    /* renamed from: b */
    public Resources f26052b;

    /* renamed from: c */
    public int f26053c;

    /* renamed from: d */
    public int f26054d;

    /* renamed from: e */
    public int f26055e;

    /* renamed from: f */
    public SparseArray f26056f;

    /* renamed from: g */
    public Drawable[] f26057g;

    /* renamed from: h */
    public int f26058h;

    /* renamed from: i */
    public boolean f26059i;

    /* renamed from: j */
    public boolean f26060j;

    /* renamed from: k */
    public Rect f26061k;

    /* renamed from: l */
    public boolean f26062l;

    /* renamed from: m */
    public boolean f26063m;

    /* renamed from: n */
    public int f26064n;

    /* renamed from: o */
    public int f26065o;

    /* renamed from: p */
    public int f26066p;

    /* renamed from: q */
    public int f26067q;

    /* renamed from: r */
    public boolean f26068r;

    /* renamed from: s */
    public int f26069s;

    /* renamed from: t */
    public boolean f26070t;

    /* renamed from: u */
    public boolean f26071u;

    /* renamed from: v */
    public boolean f26072v;

    /* renamed from: w */
    public boolean f26073w;

    /* renamed from: x */
    public boolean f26074x;

    /* renamed from: y */
    public int f26075y;

    /* renamed from: z */
    public int f26076z;

    public rn2(rn2 rn2Var, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
        Resources resources2;
        int i;
        this.f26059i = false;
        this.f26062l = false;
        this.f26074x = true;
        this.f26076z = 0;
        this.f26042A = 0;
        this.f26051a = stateListDrawableCompat;
        if (resources != null) {
            resources2 = resources;
        } else if (rn2Var != null) {
            resources2 = rn2Var.f26052b;
        } else {
            resources2 = null;
        }
        this.f26052b = resources2;
        if (rn2Var != null) {
            i = rn2Var.f26053c;
        } else {
            i = 0;
        }
        int i2 = DrawableContainerCompat.f751m;
        i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
        i = i == 0 ? 160 : i;
        this.f26053c = i;
        if (rn2Var != null) {
            this.f26054d = rn2Var.f26054d;
            this.f26055e = rn2Var.f26055e;
            this.f26072v = true;
            this.f26073w = true;
            this.f26059i = rn2Var.f26059i;
            this.f26062l = rn2Var.f26062l;
            this.f26074x = rn2Var.f26074x;
            this.f26075y = rn2Var.f26075y;
            this.f26076z = rn2Var.f26076z;
            this.f26042A = rn2Var.f26042A;
            this.f26043B = rn2Var.f26043B;
            this.f26044C = rn2Var.f26044C;
            this.f26045D = rn2Var.f26045D;
            this.f26046E = rn2Var.f26046E;
            this.f26047F = rn2Var.f26047F;
            this.f26048G = rn2Var.f26048G;
            this.f26049H = rn2Var.f26049H;
            if (rn2Var.f26053c == i) {
                if (rn2Var.f26060j) {
                    this.f26061k = rn2Var.f26061k != null ? new Rect(rn2Var.f26061k) : null;
                    this.f26060j = true;
                }
                if (rn2Var.f26063m) {
                    this.f26064n = rn2Var.f26064n;
                    this.f26065o = rn2Var.f26065o;
                    this.f26066p = rn2Var.f26066p;
                    this.f26067q = rn2Var.f26067q;
                    this.f26063m = true;
                }
            }
            if (rn2Var.f26068r) {
                this.f26069s = rn2Var.f26069s;
                this.f26068r = true;
            }
            if (rn2Var.f26070t) {
                this.f26071u = rn2Var.f26071u;
                this.f26070t = true;
            }
            Drawable[] drawableArr = rn2Var.f26057g;
            this.f26057g = new Drawable[drawableArr.length];
            this.f26058h = rn2Var.f26058h;
            SparseArray sparseArray = rn2Var.f26056f;
            if (sparseArray != null) {
                this.f26056f = sparseArray.clone();
            } else {
                this.f26056f = new SparseArray(this.f26058h);
            }
            int i3 = this.f26058h;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f26056f.put(i4, constantState);
                    } else {
                        this.f26057g[i4] = drawableArr[i4];
                    }
                }
            }
        } else {
            this.f26057g = new Drawable[10];
            this.f26058h = 0;
        }
        if (rn2Var != null) {
            this.f26050I = rn2Var.f26050I;
        } else {
            this.f26050I = new int[this.f26057g.length];
        }
    }

    /* renamed from: a */
    public final int m7288a(Drawable drawable) {
        int i = this.f26058h;
        Drawable[] drawableArr = this.f26057g;
        if (i >= drawableArr.length) {
            int i2 = i + 10;
            Drawable[] drawableArr2 = new Drawable[i2];
            System.arraycopy(drawableArr, 0, drawableArr2, 0, i);
            this.f26057g = drawableArr2;
            int[][] iArr = new int[i2];
            System.arraycopy(this.f26050I, 0, iArr, 0, i);
            this.f26050I = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f26051a);
        this.f26057g[i] = drawable;
        this.f26058h++;
        this.f26055e = drawable.getChangingConfigurations() | this.f26055e;
        this.f26068r = false;
        this.f26070t = false;
        this.f26061k = null;
        this.f26060j = false;
        this.f26063m = false;
        this.f26072v = false;
        return i;
    }

    /* renamed from: b */
    public final void m7289b() {
        this.f26063m = true;
        m7290c();
        int i = this.f26058h;
        Drawable[] drawableArr = this.f26057g;
        this.f26065o = -1;
        this.f26064n = -1;
        this.f26067q = 0;
        this.f26066p = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f26064n) {
                this.f26064n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f26065o) {
                this.f26065o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f26066p) {
                this.f26066p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f26067q) {
                this.f26067q = minimumHeight;
            }
        }
    }

    /* renamed from: c */
    public final void m7290c() {
        SparseArray sparseArray = this.f26056f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.f26056f.keyAt(i);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f26056f.valueAt(i);
                Drawable[] drawableArr = this.f26057g;
                Drawable newDrawable = constantState.newDrawable(this.f26052b);
                DrawableCompat.setLayoutDirection(newDrawable, this.f26075y);
                Drawable mutate = newDrawable.mutate();
                mutate.setCallback(this.f26051a);
                drawableArr[keyAt] = mutate;
            }
            this.f26056f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i = this.f26058h;
        Drawable[] drawableArr = this.f26057g;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                if (DrawableCompat.canApplyTheme(drawable)) {
                    return true;
                }
            } else {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f26056f.get(i2);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public final Drawable m7291d(int i) {
        int indexOfKey;
        Drawable drawable = this.f26057g[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f26056f;
        if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable newDrawable = ((Drawable.ConstantState) this.f26056f.valueAt(indexOfKey)).newDrawable(this.f26052b);
        DrawableCompat.setLayoutDirection(newDrawable, this.f26075y);
        Drawable mutate = newDrawable.mutate();
        mutate.setCallback(this.f26051a);
        this.f26057g[i] = mutate;
        this.f26056f.removeAt(indexOfKey);
        if (this.f26056f.size() == 0) {
            this.f26056f = null;
        }
        return mutate;
    }

    /* renamed from: e */
    public final int m7292e(int[] iArr) {
        int[][] iArr2 = this.f26050I;
        int i = this.f26058h;
        for (int i2 = 0; i2 < i; i2++) {
            if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: f */
    public void mo7293f() {
        int[] iArr;
        int[][] iArr2 = this.f26050I;
        int[][] iArr3 = new int[iArr2.length];
        for (int length = iArr2.length - 1; length >= 0; length--) {
            int[] iArr4 = this.f26050I[length];
            if (iArr4 != null) {
                iArr = (int[]) iArr4.clone();
            } else {
                iArr = null;
            }
            iArr3[length] = iArr;
        }
        this.f26050I = iArr3;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f26054d | this.f26055e;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new StateListDrawableCompat(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new StateListDrawableCompat(this, resources);
    }
}
