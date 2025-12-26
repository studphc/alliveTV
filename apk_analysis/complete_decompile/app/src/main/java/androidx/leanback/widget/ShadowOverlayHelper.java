package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import p000.o63;
import p000.p63;
import p000.uh2;
import p000.un2;
import p000.vh2;
import p000.wh2;

/* loaded from: classes.dex */
public final class ShadowOverlayHelper {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;

    /* renamed from: a */
    public int f6197a;

    /* renamed from: b */
    public boolean f6198b;

    /* renamed from: c */
    public boolean f6199c;

    /* renamed from: d */
    public boolean f6200d;

    /* renamed from: e */
    public boolean f6201e;

    /* renamed from: f */
    public int f6202f;

    /* renamed from: g */
    public float f6203g;

    /* renamed from: h */
    public float f6204h;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public boolean f6205a;

        /* renamed from: b */
        public boolean f6206b;

        /* renamed from: c */
        public boolean f6207c;

        /* renamed from: e */
        public boolean f6209e;

        /* renamed from: d */
        public boolean f6208d = true;

        /* renamed from: f */
        public Options f6210f = Options.DEFAULT;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.leanback.widget.ShadowOverlayHelper] */
        public ShadowOverlayHelper build(Context context) {
            boolean z;
            boolean z2;
            ?? obj = new Object();
            boolean z3 = true;
            obj.f6197a = 1;
            obj.f6198b = this.f6205a;
            if (this.f6206b && ShadowOverlayHelper.supportsRoundedCorner()) {
                z = true;
            } else {
                z = false;
            }
            obj.f6199c = z;
            if (this.f6207c && ShadowOverlayHelper.supportsShadow()) {
                z2 = true;
            } else {
                z2 = false;
            }
            obj.f6200d = z2;
            if (obj.f6199c) {
                Options options = this.f6210f;
                if (options.getRoundedCornerRadius() == 0) {
                    obj.f6202f = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius);
                } else {
                    obj.f6202f = options.getRoundedCornerRadius();
                }
            }
            if (obj.f6200d) {
                if (this.f6208d && ShadowOverlayHelper.supportsDynamicShadow()) {
                    obj.f6197a = 3;
                    Options options2 = this.f6210f;
                    if (options2.getDynamicShadowUnfocusedZ() < RecyclerView.f7068F0) {
                        Resources resources = context.getResources();
                        obj.f6204h = resources.getDimension(androidx.leanback.R.dimen.lb_material_shadow_focused_z);
                        obj.f6203g = resources.getDimension(androidx.leanback.R.dimen.lb_material_shadow_normal_z);
                    } else {
                        obj.f6204h = options2.getDynamicShadowFocusedZ();
                        obj.f6203g = options2.getDynamicShadowUnfocusedZ();
                    }
                    if ((ShadowOverlayHelper.supportsForeground() && !this.f6209e) || !obj.f6198b) {
                        z3 = false;
                    }
                    obj.f6201e = z3;
                } else {
                    obj.f6197a = 2;
                    obj.f6201e = true;
                }
            } else {
                obj.f6197a = 1;
                if ((ShadowOverlayHelper.supportsForeground() && !this.f6209e) || !obj.f6198b) {
                    z3 = false;
                }
                obj.f6201e = z3;
            }
            return obj;
        }

        public Builder keepForegroundDrawable(boolean z) {
            this.f6209e = z;
            return this;
        }

        public Builder needsOverlay(boolean z) {
            this.f6205a = z;
            return this;
        }

        public Builder needsRoundedCorner(boolean z) {
            this.f6206b = z;
            return this;
        }

        public Builder needsShadow(boolean z) {
            this.f6207c = z;
            return this;
        }

        public Builder options(Options options) {
            this.f6210f = options;
            return this;
        }

        public Builder preferZOrder(boolean z) {
            this.f6208d = z;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class Options {
        public static final Options DEFAULT = new Options();

        /* renamed from: a */
        public int f6211a = 0;

        /* renamed from: b */
        public float f6212b = -1.0f;

        /* renamed from: c */
        public float f6213c = -1.0f;

        public Options dynamicShadowZ(float f, float f2) {
            this.f6212b = f;
            this.f6213c = f2;
            return this;
        }

        public final float getDynamicShadowFocusedZ() {
            return this.f6213c;
        }

        public final float getDynamicShadowUnfocusedZ() {
            return this.f6212b;
        }

        public final int getRoundedCornerRadius() {
            return this.f6211a;
        }

        public Options roundedCornerRadius(int i) {
            this.f6211a = i;
            return this;
        }
    }

    /* renamed from: a */
    public static void m1488a(Object obj, int i, float f) {
        if (obj != null) {
            if (f < RecyclerView.f7068F0) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            if (i != 2) {
                if (i == 3) {
                    uh2 uh2Var = wh2.f28193a;
                    vh2 vh2Var = (vh2) obj;
                    View view = vh2Var.f27794a;
                    float f2 = vh2Var.f27795b;
                    view.setZ(((vh2Var.f27796c - f2) * f) + f2);
                    return;
                }
                return;
            }
            un2 un2Var = (un2) obj;
            un2Var.f27394a.setAlpha(1.0f - f);
            un2Var.f27395b.setAlpha(f);
        }
    }

    public static void setNoneWrapperOverlayColor(View view, int i) {
        Drawable foreground = view.getForeground();
        if (foreground instanceof ColorDrawable) {
            ((ColorDrawable) foreground).setColor(i);
        } else {
            view.setForeground(new ColorDrawable(i));
        }
    }

    public static void setNoneWrapperShadowFocusLevel(View view, float f) {
        m1488a(view.getTag(androidx.leanback.R.id.lb_shadow_impl), 3, f);
    }

    public static boolean supportsDynamicShadow() {
        return true;
    }

    public static boolean supportsForeground() {
        return true;
    }

    public static boolean supportsRoundedCorner() {
        return true;
    }

    public static boolean supportsShadow() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.leanback.widget.ShadowOverlayContainer, android.widget.FrameLayout] */
    public ShadowOverlayContainer createShadowOverlayContainer(Context context) {
        if (needsWrapper()) {
            int i = this.f6197a;
            boolean z = this.f6198b;
            float f = this.f6203g;
            float f2 = this.f6204h;
            int i2 = this.f6202f;
            ?? frameLayout = new FrameLayout(context);
            frameLayout.f6192e = 1;
            frameLayout.f6193f = f;
            frameLayout.f6194g = f2;
            frameLayout.m1487a(i, i2, z);
            return frameLayout;
        }
        throw new IllegalArgumentException();
    }

    public int getShadowType() {
        return this.f6197a;
    }

    public boolean needsOverlay() {
        return this.f6198b;
    }

    public boolean needsRoundedCorner() {
        return this.f6199c;
    }

    public boolean needsWrapper() {
        return this.f6201e;
    }

    public void onViewCreated(View view) {
        if (!needsWrapper()) {
            if (!this.f6200d) {
                if (this.f6199c) {
                    p63.m6850J(this.f6202f, view, true);
                }
            } else if (this.f6197a == 3) {
                view.setTag(androidx.leanback.R.id.lb_shadow_impl, o63.m6462a(view, this.f6203g, this.f6204h, this.f6202f));
            } else if (this.f6199c) {
                p63.m6850J(this.f6202f, view, true);
            }
        }
    }

    public void prepareParentForShadow(ViewGroup viewGroup) {
        if (this.f6197a == 2) {
            viewGroup.setLayoutMode(1);
        }
    }

    public void setOverlayColor(View view, int i) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setOverlayColor(i);
        } else {
            setNoneWrapperOverlayColor(view, i);
        }
    }

    public void setShadowFocusLevel(View view, float f) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setShadowFocusLevel(f);
        } else {
            m1488a(view.getTag(androidx.leanback.R.id.lb_shadow_impl), 3, f);
        }
    }
}
