package androidx.leanback.app;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.leanback.widget.BackgroundHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import p000.C1266he;
import p000.C1303ie;
import p000.C1351je;
import p000.C1508le;
import p000.C1582ne;
import p000.C1684pe;
import p000.RunnableC1545me;

/* loaded from: classes.dex */
public final class BackgroundManager {

    /* renamed from: a */
    public final Activity f4723a;

    /* renamed from: b */
    public final Handler f4724b;

    /* renamed from: c */
    public View f4725c;

    /* renamed from: d */
    public C1351je f4726d;

    /* renamed from: e */
    public int f4727e;

    /* renamed from: f */
    public final BackgroundFragment f4728f;

    /* renamed from: g */
    public boolean f4729g = true;

    /* renamed from: h */
    public final int f4730h;

    /* renamed from: i */
    public final int f4731i;

    /* renamed from: j */
    public int f4732j;

    /* renamed from: k */
    public Drawable f4733k;

    /* renamed from: l */
    public boolean f4734l;

    /* renamed from: m */
    public long f4735m;

    /* renamed from: n */
    public final ValueAnimator f4736n;

    /* renamed from: o */
    public C1684pe f4737o;

    /* renamed from: p */
    public int f4738p;

    /* renamed from: q */
    public RunnableC1545me f4739q;

    /* renamed from: r */
    public boolean f4740r;

    public BackgroundManager(Activity activity) {
        C1266he c1266he = new C1266he(this);
        C1303ie c1303ie = new C1303ie(0, this);
        this.f4723a = activity;
        C1351je c1351je = C1351je.f20476f;
        c1351je.f20479c++;
        this.f4726d = c1351je;
        this.f4730h = activity.getResources().getDisplayMetrics().heightPixels;
        this.f4731i = activity.getResources().getDisplayMetrics().widthPixels;
        this.f4724b = new Handler();
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        this.f4736n = ofInt;
        ofInt.addListener(c1266he);
        ofInt.addUpdateListener(c1303ie);
        ofInt.setInterpolator(fastOutLinearInInterpolator);
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowBackground});
        this.f4727e = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        BackgroundFragment backgroundFragment = (BackgroundFragment) activity.getFragmentManager().findFragmentByTag("androidx.leanback.app.BackgroundManager");
        if (backgroundFragment == null) {
            backgroundFragment = new BackgroundFragment();
            activity.getFragmentManager().beginTransaction().add(backgroundFragment, "androidx.leanback.app.BackgroundManager").commit();
        } else if (backgroundFragment.f4722a != null) {
            throw new IllegalStateException("Created duplicated BackgroundManager for same activity, please use getInstance() instead");
        }
        backgroundFragment.f4722a = this;
        this.f4728f = backgroundFragment;
    }

    /* renamed from: d */
    public static boolean m1253d(Drawable drawable, Drawable drawable2) {
        if (drawable != null && drawable2 != null) {
            if (drawable == drawable2) {
                return true;
            }
            if ((drawable instanceof C1508le) && (drawable2 instanceof C1508le) && ((C1508le) drawable).f22474a.f20832a.sameAs(((C1508le) drawable2).f22474a.f20832a)) {
                return true;
            }
            if ((drawable instanceof ColorDrawable) && (drawable2 instanceof ColorDrawable) && ((ColorDrawable) drawable).getColor() == ((ColorDrawable) drawable2).getColor()) {
                return true;
            }
        }
        return false;
    }

    public static BackgroundManager getInstance(Activity activity) {
        BackgroundManager backgroundManager;
        BackgroundFragment backgroundFragment = (BackgroundFragment) activity.getFragmentManager().findFragmentByTag("androidx.leanback.app.BackgroundManager");
        if (backgroundFragment != null && (backgroundManager = backgroundFragment.f4722a) != null) {
            return backgroundManager;
        }
        return new BackgroundManager(activity);
    }

    /* renamed from: a */
    public final void m1254a(View view) {
        Drawable mutate;
        if (!this.f4734l) {
            this.f4725c = view;
            this.f4734l = true;
            C1351je c1351je = this.f4726d;
            int i = c1351je.f20477a;
            Drawable drawable = c1351je.f20478b;
            this.f4732j = i;
            if (drawable == null) {
                mutate = null;
            } else {
                mutate = drawable.getConstantState().newDrawable().mutate();
            }
            this.f4733k = mutate;
            m1258f();
            return;
        }
        throw new IllegalStateException("Already attached to " + this.f4725c);
    }

    public void attach(Window window) {
        m1254a(window.getDecorView());
    }

    public void attachToView(View view) {
        ColorDrawable colorDrawable;
        m1254a(view);
        View decorView = this.f4723a.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 26) {
            colorDrawable = null;
        } else {
            colorDrawable = new ColorDrawable(0);
        }
        decorView.setBackground(colorDrawable);
    }

    /* renamed from: b */
    public final Drawable m1255b() {
        Drawable drawable;
        Drawable.ConstantState constantState;
        if (this.f4732j != 0) {
            return new ColorDrawable(this.f4732j);
        }
        int i = this.f4727e;
        Activity activity = this.f4723a;
        if (i != -1) {
            C1351je c1351je = this.f4726d;
            WeakReference weakReference = c1351je.f20481e;
            if (weakReference != null && c1351je.f20480d == i && (constantState = (Drawable.ConstantState) weakReference.get()) != null) {
                drawable = constantState.newDrawable();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = ContextCompat.getDrawable(activity, i);
                c1351je.f20481e = new WeakReference(drawable.getConstantState());
                c1351je.f20480d = i;
            }
        } else {
            drawable = null;
        }
        if (drawable == null) {
            activity.getResources();
            return new C1508le(null, null);
        }
        return drawable;
    }

    /* renamed from: c */
    public final void m1256c() {
        if (this.f4739q != null && this.f4740r && !this.f4736n.isStarted() && this.f4728f.isResumed() && this.f4737o.f25129b >= 255) {
            long max = Math.max(0L, (this.f4735m + 500) - System.currentTimeMillis());
            this.f4735m = System.currentTimeMillis();
            this.f4724b.postDelayed(this.f4739q, max);
            this.f4740r = false;
        }
    }

    public void clearDrawable() {
        setDrawable(null);
    }

    /* renamed from: e */
    public final void m1257e(Drawable drawable) {
        if (this.f4734l) {
            RunnableC1545me runnableC1545me = this.f4739q;
            if (runnableC1545me != null) {
                if (m1253d(drawable, runnableC1545me.f22905a)) {
                    return;
                }
                this.f4724b.removeCallbacks(this.f4739q);
                this.f4739q = null;
            }
            this.f4739q = new RunnableC1545me(this, drawable);
            this.f4740r = true;
            m1256c();
            return;
        }
        throw new IllegalStateException("Must attach before setting background drawable");
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.graphics.drawable.LayerDrawable, pe] */
    /* renamed from: f */
    public final void m1258f() {
        if (!this.f4734l) {
            return;
        }
        C1684pe c1684pe = this.f4737o;
        Activity activity = this.f4723a;
        if (c1684pe == null) {
            LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(activity, androidx.leanback.R.drawable.lb_background).mutate();
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                drawableArr[i] = layerDrawable.getDrawable(i);
            }
            ?? layerDrawable2 = new LayerDrawable(drawableArr);
            layerDrawable2.f25129b = 255;
            layerDrawable2.f25131d = new WeakReference(this);
            layerDrawable2.f25128a = new C1582ne[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.f25128a[i2] = new C1582ne(drawableArr[i2]);
            }
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
            }
            this.f4737o = layerDrawable2;
            int i4 = androidx.leanback.R.id.background_imagein;
            int i5 = 0;
            while (true) {
                if (i5 < layerDrawable2.getNumberOfLayers()) {
                    if (layerDrawable2.getId(i5) == i4) {
                        break;
                    } else {
                        i5++;
                    }
                } else {
                    i5 = -1;
                    break;
                }
            }
            this.f4738p = i5;
            C1684pe c1684pe2 = this.f4737o;
            int i6 = androidx.leanback.R.id.background_imageout;
            for (int i7 = 0; i7 < c1684pe2.getNumberOfLayers() && c1684pe2.getId(i7) != i6; i7++) {
            }
            BackgroundHelper.setBackgroundPreservingAlpha(this.f4725c, this.f4737o);
        }
        Drawable drawable = this.f4733k;
        if (drawable == null) {
            this.f4737o.m6912b(androidx.leanback.R.id.background_imagein, m1255b());
        } else {
            this.f4737o.m6912b(androidx.leanback.R.id.background_imagein, drawable);
        }
        this.f4737o.m6911a(androidx.leanback.R.id.background_imageout, activity);
    }

    @ColorInt
    public final int getColor() {
        return this.f4732j;
    }

    @Deprecated
    public Drawable getDefaultDimLayer() {
        return ContextCompat.getDrawable(this.f4723a, androidx.leanback.R.color.lb_background_protection);
    }

    @Deprecated
    public Drawable getDimLayer() {
        return null;
    }

    public Drawable getDrawable() {
        return this.f4733k;
    }

    public boolean isAttached() {
        return this.f4734l;
    }

    public boolean isAutoReleaseOnStop() {
        return this.f4729g;
    }

    public void release() {
        RunnableC1545me runnableC1545me = this.f4739q;
        if (runnableC1545me != null) {
            this.f4724b.removeCallbacks(runnableC1545me);
            this.f4739q = null;
        }
        ValueAnimator valueAnimator = this.f4736n;
        if (valueAnimator.isStarted()) {
            valueAnimator.cancel();
        }
        C1684pe c1684pe = this.f4737o;
        if (c1684pe != null) {
            int i = androidx.leanback.R.id.background_imagein;
            Activity activity = this.f4723a;
            c1684pe.m6911a(i, activity);
            this.f4737o.m6911a(androidx.leanback.R.id.background_imageout, activity);
            this.f4737o = null;
        }
        this.f4733k = null;
    }

    public void setAutoReleaseOnStop(boolean z) {
        this.f4729g = z;
    }

    public void setBitmap(Bitmap bitmap) {
        float f;
        Matrix matrix = null;
        if (bitmap == null) {
            setDrawable(null);
            return;
        }
        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            int width = bitmap.getWidth();
            int i = this.f4730h;
            int i2 = this.f4731i;
            if (width != i2 || bitmap.getHeight() != i) {
                int width2 = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width2 * i > i2 * height) {
                    f = i / height;
                } else {
                    f = i2 / width2;
                }
                int max = Math.max(0, (width2 - Math.min((int) (i2 / f), width2)) / 2);
                Matrix matrix2 = new Matrix();
                matrix2.setScale(f, f);
                matrix2.preTranslate(-max, RecyclerView.f7068F0);
                matrix = matrix2;
            }
            this.f4723a.getResources();
            setDrawable(new C1508le(bitmap, matrix));
        }
    }

    public void setColor(@ColorInt int i) {
        C1351je c1351je = this.f4726d;
        c1351je.f20477a = i;
        c1351je.f20478b = null;
        this.f4732j = i;
        this.f4733k = null;
        if (this.f4737o == null) {
            return;
        }
        m1257e(m1255b());
    }

    @Deprecated
    public void setDimLayer(Drawable drawable) {
    }

    public void setDrawable(Drawable drawable) {
        this.f4726d.f20478b = drawable;
        this.f4733k = drawable;
        if (this.f4737o == null) {
            return;
        }
        if (drawable == null) {
            m1257e(m1255b());
        } else {
            m1257e(drawable);
        }
    }

    public void setThemeDrawableResourceId(int i) {
        this.f4727e = i;
    }
}
