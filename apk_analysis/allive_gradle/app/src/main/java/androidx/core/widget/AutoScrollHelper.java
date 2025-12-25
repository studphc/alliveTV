package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.C1794sd;
import p000.RunnableC1104d;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;

    /* renamed from: r */
    public static final int f4025r = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    public final C1794sd f4026a;

    /* renamed from: b */
    public final AccelerateInterpolator f4027b;

    /* renamed from: c */
    public final View f4028c;

    /* renamed from: d */
    public RunnableC1104d f4029d;

    /* renamed from: e */
    public final float[] f4030e;

    /* renamed from: f */
    public final float[] f4031f;

    /* renamed from: g */
    public int f4032g;

    /* renamed from: h */
    public int f4033h;

    /* renamed from: i */
    public final float[] f4034i;

    /* renamed from: j */
    public final float[] f4035j;

    /* renamed from: k */
    public final float[] f4036k;

    /* renamed from: l */
    public boolean f4037l;

    /* renamed from: m */
    public boolean f4038m;

    /* renamed from: n */
    public boolean f4039n;

    /* renamed from: o */
    public boolean f4040o;

    /* renamed from: p */
    public boolean f4041p;

    /* renamed from: q */
    public boolean f4042q;

    /* JADX WARN: Type inference failed for: r1v0, types: [sd, java.lang.Object] */
    public AutoScrollHelper(@NonNull View view) {
        ?? obj = new Object();
        obj.f26384e = Long.MIN_VALUE;
        obj.f26386g = -1L;
        obj.f26385f = 0L;
        this.f4026a = obj;
        this.f4027b = new AccelerateInterpolator();
        this.f4030e = new float[]{RecyclerView.f7068F0, RecyclerView.f7068F0};
        this.f4031f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f4034i = new float[]{RecyclerView.f7068F0, RecyclerView.f7068F0};
        this.f4035j = new float[]{RecyclerView.f7068F0, RecyclerView.f7068F0};
        this.f4036k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f4028c = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        setMaximumVelocity(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        setMinimumVelocity(f3, f3);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(f4025r);
        setRampUpDuration(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR);
        setRampDownDuration(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: b */
    public static float m1012b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float m1013a(int i, float f, float f2, float f3) {
        float f4;
        float interpolation;
        float m1012b = m1012b(this.f4030e[i] * f2, RecyclerView.f7068F0, this.f4031f[i]);
        float m1014c = m1014c(f2 - f, m1012b) - m1014c(f, m1012b);
        AccelerateInterpolator accelerateInterpolator = this.f4027b;
        if (m1014c < RecyclerView.f7068F0) {
            interpolation = -accelerateInterpolator.getInterpolation(-m1014c);
        } else if (m1014c > RecyclerView.f7068F0) {
            interpolation = accelerateInterpolator.getInterpolation(m1014c);
        } else {
            f4 = 0.0f;
            if (f4 != RecyclerView.f7068F0) {
                return RecyclerView.f7068F0;
            }
            float f5 = this.f4034i[i];
            float f6 = this.f4035j[i];
            float f7 = this.f4036k[i];
            float f8 = f5 * f3;
            if (f4 > RecyclerView.f7068F0) {
                return m1012b(f4 * f8, f6, f7);
            }
            return -m1012b((-f4) * f8, f6, f7);
        }
        f4 = m1012b(interpolation, -1.0f, 1.0f);
        if (f4 != RecyclerView.f7068F0) {
        }
    }

    /* renamed from: c */
    public final float m1014c(float f, float f2) {
        if (f2 == RecyclerView.f7068F0) {
            return RecyclerView.f7068F0;
        }
        int i = this.f4032g;
        if (i != 0 && i != 1) {
            if (i == 2 && f < RecyclerView.f7068F0) {
                return f / (-f2);
            }
        } else if (f < f2) {
            if (f >= RecyclerView.f7068F0) {
                return 1.0f - (f / f2);
            }
            if (this.f4040o && i == 1) {
                return 1.0f;
            }
        }
        return RecyclerView.f7068F0;
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    /* renamed from: d */
    public final void m1015d() {
        int i = 0;
        if (this.f4038m) {
            this.f4040o = false;
            return;
        }
        C1794sd c1794sd = this.f4026a;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - c1794sd.f26384e);
        int i3 = c1794sd.f26381b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        c1794sd.f26388i = i;
        c1794sd.f26387h = c1794sd.m7359a(currentAnimationTimeMillis);
        c1794sd.f26386g = currentAnimationTimeMillis;
    }

    /* renamed from: e */
    public final boolean m1016e() {
        C1794sd c1794sd = this.f4026a;
        float f = c1794sd.f26383d;
        int abs = (int) (f / Math.abs(f));
        float f2 = c1794sd.f26382c;
        int abs2 = (int) (f2 / Math.abs(f2));
        if ((abs != 0 && canTargetScrollVertically(abs)) || (abs2 != 0 && canTargetScrollHorizontally(abs2))) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        return this.f4041p;
    }

    public boolean isExclusive() {
        return this.f4042q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L29;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (!this.f4041p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            m1015d();
            if (!this.f4042q && this.f4040o) {
                return true;
            }
        }
        this.f4039n = true;
        this.f4037l = false;
        float x = motionEvent.getX();
        float width = view.getWidth();
        View view2 = this.f4028c;
        float m1013a = m1013a(0, x, width, view2.getWidth());
        float m1013a2 = m1013a(1, motionEvent.getY(), view.getHeight(), view2.getHeight());
        C1794sd c1794sd = this.f4026a;
        c1794sd.f26382c = m1013a;
        c1794sd.f26383d = m1013a2;
        if (!this.f4040o && m1016e()) {
            if (this.f4029d == null) {
                this.f4029d = new RunnableC1104d(5, this);
            }
            this.f4040o = true;
            this.f4038m = true;
            if (!this.f4037l && (i = this.f4033h) > 0) {
                ViewCompat.postOnAnimationDelayed(view2, this.f4029d, i);
            } else {
                this.f4029d.run();
            }
            this.f4037l = true;
        }
        return !this.f4042q ? false : false;
    }

    public abstract void scrollTargetBy(int i, int i2);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i) {
        this.f4033h = i;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i) {
        this.f4032g = i;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.f4041p && !z) {
            m1015d();
        }
        this.f4041p = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.f4042q = z;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        float[] fArr = this.f4031f;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        float[] fArr = this.f4036k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        float[] fArr = this.f4035j;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i) {
        this.f4026a.f26381b = i;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i) {
        this.f4026a.f26380a = i;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        float[] fArr = this.f4030e;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        float[] fArr = this.f4034i;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }
}
