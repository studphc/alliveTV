package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import p000.C1303ie;
import p000.RunnableC1104d;
import p000.dc0;

/* renamed from: androidx.recyclerview.widget.s */
/* loaded from: classes.dex */
public final class C0504s extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {

    /* renamed from: C */
    public static final int[] f7469C = {R.attr.state_pressed};

    /* renamed from: D */
    public static final int[] f7470D = new int[0];

    /* renamed from: A */
    public int f7471A;

    /* renamed from: B */
    public final RunnableC1104d f7472B;

    /* renamed from: a */
    public final int f7473a;

    /* renamed from: b */
    public final int f7474b;

    /* renamed from: c */
    public final StateListDrawable f7475c;

    /* renamed from: d */
    public final Drawable f7476d;

    /* renamed from: e */
    public final int f7477e;

    /* renamed from: f */
    public final int f7478f;

    /* renamed from: g */
    public final StateListDrawable f7479g;

    /* renamed from: h */
    public final Drawable f7480h;

    /* renamed from: i */
    public final int f7481i;

    /* renamed from: j */
    public final int f7482j;

    /* renamed from: k */
    public int f7483k;

    /* renamed from: l */
    public int f7484l;

    /* renamed from: m */
    public float f7485m;

    /* renamed from: n */
    public int f7486n;

    /* renamed from: o */
    public int f7487o;

    /* renamed from: p */
    public float f7488p;

    /* renamed from: s */
    public final RecyclerView f7491s;

    /* renamed from: z */
    public final ValueAnimator f7498z;

    /* renamed from: q */
    public int f7489q = 0;

    /* renamed from: r */
    public int f7490r = 0;

    /* renamed from: t */
    public boolean f7492t = false;

    /* renamed from: u */
    public boolean f7493u = false;

    /* renamed from: v */
    public int f7494v = 0;

    /* renamed from: w */
    public int f7495w = 0;

    /* renamed from: x */
    public final int[] f7496x = new int[2];

    /* renamed from: y */
    public final int[] f7497y = new int[2];

    public C0504s(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
        this.f7498z = ofFloat;
        this.f7471A = 0;
        RunnableC1104d runnableC1104d = new RunnableC1104d(16, this);
        this.f7472B = runnableC1104d;
        C0502r c0502r = new C0502r(this);
        this.f7475c = stateListDrawable;
        this.f7476d = drawable;
        this.f7479g = stateListDrawable2;
        this.f7480h = drawable2;
        this.f7477e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f7478f = Math.max(i, drawable.getIntrinsicWidth());
        this.f7481i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f7482j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f7473a = i2;
        this.f7474b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new dc0(this));
        ofFloat.addUpdateListener(new C1303ie(2, this));
        RecyclerView recyclerView2 = this.f7491s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.f7491s.removeOnItemTouchListener(this);
                this.f7491s.removeOnScrollListener(c0502r);
                this.f7491s.removeCallbacks(runnableC1104d);
            }
            this.f7491s = recyclerView;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(this);
                this.f7491s.addOnItemTouchListener(this);
                this.f7491s.addOnScrollListener(c0502r);
            }
        }
    }

    /* renamed from: c */
    public static int m1884c(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: a */
    public final boolean m1885a(float f, float f2) {
        if (f2 >= this.f7490r - this.f7481i) {
            int i = this.f7487o;
            int i2 = this.f7486n;
            if (f >= i - (i2 / 2) && f <= (i2 / 2) + i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m1886b(float f, float f2) {
        boolean z;
        if (ViewCompat.getLayoutDirection(this.f7491s) == 1) {
            z = true;
        } else {
            z = false;
        }
        int i = this.f7477e;
        if (z) {
            if (f > i) {
                return false;
            }
        } else if (f < this.f7489q - i) {
            return false;
        }
        int i2 = this.f7484l;
        int i3 = this.f7483k / 2;
        if (f2 < i2 - i3 || f2 > i3 + i2) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public final void m1887d(int i) {
        RunnableC1104d runnableC1104d = this.f7472B;
        StateListDrawable stateListDrawable = this.f7475c;
        if (i == 2 && this.f7494v != 2) {
            stateListDrawable.setState(f7469C);
            this.f7491s.removeCallbacks(runnableC1104d);
        }
        if (i == 0) {
            this.f7491s.invalidate();
        } else {
            m1888e();
        }
        if (this.f7494v == 2 && i != 2) {
            stateListDrawable.setState(f7470D);
            this.f7491s.removeCallbacks(runnableC1104d);
            this.f7491s.postDelayed(runnableC1104d, 1200);
        } else if (i == 1) {
            this.f7491s.removeCallbacks(runnableC1104d);
            this.f7491s.postDelayed(runnableC1104d, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f7494v = i;
    }

    /* renamed from: e */
    public final void m1888e() {
        int i = this.f7471A;
        ValueAnimator valueAnimator = this.f7498z;
        if (i != 0) {
            if (i == 3) {
                valueAnimator.cancel();
            } else {
                return;
            }
        }
        this.f7471A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f7489q == this.f7491s.getWidth() && this.f7490r == this.f7491s.getHeight()) {
            if (this.f7471A != 0) {
                if (this.f7492t) {
                    int i = this.f7489q;
                    int i2 = this.f7477e;
                    int i3 = i - i2;
                    int i4 = this.f7484l;
                    int i5 = this.f7483k;
                    int i6 = i4 - (i5 / 2);
                    StateListDrawable stateListDrawable = this.f7475c;
                    stateListDrawable.setBounds(0, 0, i2, i5);
                    int i7 = this.f7490r;
                    int i8 = this.f7478f;
                    Drawable drawable = this.f7476d;
                    drawable.setBounds(0, 0, i8, i7);
                    if (ViewCompat.getLayoutDirection(this.f7491s) == 1) {
                        drawable.draw(canvas);
                        canvas.translate(i2, i6);
                        canvas.scale(-1.0f, 1.0f);
                        stateListDrawable.draw(canvas);
                        canvas.scale(-1.0f, 1.0f);
                        canvas.translate(-i2, -i6);
                    } else {
                        canvas.translate(i3, RecyclerView.f7068F0);
                        drawable.draw(canvas);
                        canvas.translate(RecyclerView.f7068F0, i6);
                        stateListDrawable.draw(canvas);
                        canvas.translate(-i3, -i6);
                    }
                }
                if (this.f7493u) {
                    int i9 = this.f7490r;
                    int i10 = this.f7481i;
                    int i11 = i9 - i10;
                    int i12 = this.f7487o;
                    int i13 = this.f7486n;
                    int i14 = i12 - (i13 / 2);
                    StateListDrawable stateListDrawable2 = this.f7479g;
                    stateListDrawable2.setBounds(0, 0, i13, i10);
                    int i15 = this.f7489q;
                    int i16 = this.f7482j;
                    Drawable drawable2 = this.f7480h;
                    drawable2.setBounds(0, 0, i15, i16);
                    canvas.translate(RecyclerView.f7068F0, i11);
                    drawable2.draw(canvas);
                    canvas.translate(i14, RecyclerView.f7068F0);
                    stateListDrawable2.draw(canvas);
                    canvas.translate(-i14, -i11);
                    return;
                }
                return;
            }
            return;
        }
        this.f7489q = this.f7491s.getWidth();
        this.f7490r = this.f7491s.getHeight();
        m1887d(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f7494v;
        if (i == 1) {
            boolean m1886b = m1886b(motionEvent.getX(), motionEvent.getY());
            boolean m1885a = m1885a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!m1886b && !m1885a) {
                return false;
            }
            if (m1885a) {
                this.f7495w = 1;
                this.f7488p = (int) motionEvent.getX();
            } else if (m1886b) {
                this.f7495w = 2;
                this.f7485m = (int) motionEvent.getY();
            }
            m1887d(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f7494v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean m1886b = m1886b(motionEvent.getX(), motionEvent.getY());
            boolean m1885a = m1885a(motionEvent.getX(), motionEvent.getY());
            if (m1886b || m1885a) {
                if (m1885a) {
                    this.f7495w = 1;
                    this.f7488p = (int) motionEvent.getX();
                } else if (m1886b) {
                    this.f7495w = 2;
                    this.f7485m = (int) motionEvent.getY();
                }
                m1887d(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f7494v == 2) {
            this.f7485m = RecyclerView.f7068F0;
            this.f7488p = RecyclerView.f7068F0;
            m1887d(1);
            this.f7495w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f7494v == 2) {
            m1888e();
            int i = this.f7495w;
            int i2 = this.f7474b;
            if (i == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.f7497y;
                iArr[0] = i2;
                int i3 = this.f7489q - i2;
                iArr[1] = i3;
                float max = Math.max(i2, Math.min(i3, x));
                if (Math.abs(this.f7487o - max) >= 2.0f) {
                    int m1884c = m1884c(this.f7488p, max, iArr, this.f7491s.computeHorizontalScrollRange(), this.f7491s.computeHorizontalScrollOffset(), this.f7489q);
                    if (m1884c != 0) {
                        this.f7491s.scrollBy(m1884c, 0);
                    }
                    this.f7488p = max;
                }
            }
            if (this.f7495w == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.f7496x;
                iArr2[0] = i2;
                int i4 = this.f7490r - i2;
                iArr2[1] = i4;
                float max2 = Math.max(i2, Math.min(i4, y));
                if (Math.abs(this.f7484l - max2) >= 2.0f) {
                    int m1884c2 = m1884c(this.f7485m, max2, iArr2, this.f7491s.computeVerticalScrollRange(), this.f7491s.computeVerticalScrollOffset(), this.f7490r);
                    if (m1884c2 != 0) {
                        this.f7491s.scrollBy(0, m1884c2);
                    }
                    this.f7485m = max2;
                }
            }
        }
    }
}
