package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p000.f92;

/* renamed from: androidx.recyclerview.widget.b1 */
/* loaded from: classes.dex */
public final class RunnableC0461b1 implements Runnable {

    /* renamed from: a */
    public int f7322a;

    /* renamed from: b */
    public int f7323b;

    /* renamed from: c */
    public OverScroller f7324c;

    /* renamed from: d */
    public Interpolator f7325d;

    /* renamed from: e */
    public boolean f7326e;

    /* renamed from: f */
    public boolean f7327f;

    /* renamed from: g */
    public final /* synthetic */ RecyclerView f7328g;

    public RunnableC0461b1(RecyclerView recyclerView) {
        this.f7328g = recyclerView;
        f92 f92Var = RecyclerView.f7073K0;
        this.f7325d = f92Var;
        this.f7326e = false;
        this.f7327f = false;
        this.f7324c = new OverScroller(recyclerView.getContext(), f92Var);
    }

    /* renamed from: a */
    public final void m1820a(int i, int i2) {
        RecyclerView recyclerView = this.f7328g;
        recyclerView.setScrollState(2);
        this.f7323b = 0;
        this.f7322a = 0;
        Interpolator interpolator = this.f7325d;
        f92 f92Var = RecyclerView.f7073K0;
        if (interpolator != f92Var) {
            this.f7325d = f92Var;
            this.f7324c = new OverScroller(recyclerView.getContext(), f92Var);
        }
        this.f7324c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        m1821b();
    }

    /* renamed from: b */
    public final void m1821b() {
        if (this.f7326e) {
            this.f7327f = true;
            return;
        }
        RecyclerView recyclerView = this.f7328g;
        recyclerView.removeCallbacks(this);
        ViewCompat.postOnAnimation(recyclerView, this);
    }

    /* renamed from: c */
    public final void m1822c(int i, int i2, int i3, Interpolator interpolator) {
        boolean z;
        int height;
        RecyclerView recyclerView = this.f7328g;
        if (i3 == Integer.MIN_VALUE) {
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            if (abs > abs2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            if (!z) {
                abs = abs2;
            }
            i3 = Math.min((int) (((abs / height) + 1.0f) * 300.0f), 2000);
        }
        int i4 = i3;
        if (interpolator == null) {
            interpolator = RecyclerView.f7073K0;
        }
        if (this.f7325d != interpolator) {
            this.f7325d = interpolator;
            this.f7324c = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f7323b = 0;
        this.f7322a = 0;
        recyclerView.setScrollState(2);
        this.f7324c.startScroll(0, 0, i, i2, i4);
        m1821b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean awakenScrollBars;
        boolean z;
        boolean z2;
        boolean z3;
        int i5;
        RecyclerView recyclerView = this.f7328g;
        if (recyclerView.f7126n == null) {
            recyclerView.removeCallbacks(this);
            this.f7324c.abortAnimation();
            return;
        }
        this.f7327f = false;
        this.f7326e = true;
        recyclerView.m1714m();
        OverScroller overScroller = this.f7324c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i6 = currX - this.f7322a;
            int i7 = currY - this.f7323b;
            this.f7322a = currX;
            this.f7323b = currY;
            int m1681l = RecyclerView.m1681l(i6, recyclerView.f7086J, recyclerView.f7088L, recyclerView.getWidth());
            int m1681l2 = RecyclerView.m1681l(i7, recyclerView.f7087K, recyclerView.f7089M, recyclerView.getHeight());
            int[] iArr = recyclerView.f7143v0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean dispatchNestedPreScroll = recyclerView.dispatchNestedPreScroll(m1681l, m1681l2, iArr, null, 1);
            int[] iArr2 = recyclerView.f7143v0;
            if (dispatchNestedPreScroll) {
                m1681l -= iArr2[0];
                m1681l2 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.m1713k(m1681l, m1681l2);
            }
            if (recyclerView.f7124m != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.m1704Z(m1681l, m1681l2, iArr2);
                int i8 = iArr2[0];
                int i9 = iArr2[1];
                int i10 = m1681l - i8;
                int i11 = m1681l2 - i9;
                RecyclerView.SmoothScroller smoothScroller = recyclerView.f7126n.f7166e;
                if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                    int itemCount = recyclerView.f7117i0.getItemCount();
                    if (itemCount == 0) {
                        smoothScroller.stop();
                    } else if (smoothScroller.getTargetPosition() >= itemCount) {
                        smoothScroller.setTargetPosition(itemCount - 1);
                        smoothScroller.m1753a(i8, i9);
                    } else {
                        smoothScroller.m1753a(i8, i9);
                    }
                }
                i4 = i8;
                i = i10;
                i2 = i11;
                i3 = i9;
            } else {
                i = m1681l;
                i2 = m1681l2;
                i3 = 0;
                i4 = 0;
            }
            if (!recyclerView.f7132q.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f7143v0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            int i12 = i3;
            recyclerView.dispatchNestedScroll(i4, i3, i, i2, null, 1, iArr3);
            int i13 = i - iArr2[0];
            int i14 = i2 - iArr2[1];
            if (i4 != 0 || i12 != 0) {
                recyclerView.m1720s(i4, i12);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            if (overScroller.getCurrX() == overScroller.getFinalX()) {
                z = true;
            } else {
                z = false;
            }
            if (overScroller.getCurrY() == overScroller.getFinalY()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!overScroller.isFinished() && ((!z && i13 == 0) || (!z2 && i14 == 0))) {
                z3 = false;
            } else {
                z3 = true;
            }
            RecyclerView.SmoothScroller smoothScroller2 = recyclerView.f7126n.f7166e;
            if ((smoothScroller2 == null || !smoothScroller2.isPendingInitialRun()) && z3) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i13 < 0) {
                        i5 = -currVelocity;
                    } else if (i13 > 0) {
                        i5 = currVelocity;
                    } else {
                        i5 = 0;
                    }
                    if (i14 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i14 <= 0) {
                        currVelocity = 0;
                    }
                    if (i5 < 0) {
                        recyclerView.m1722u();
                        if (recyclerView.f7086J.isFinished()) {
                            recyclerView.f7086J.onAbsorb(-i5);
                        }
                    } else if (i5 > 0) {
                        recyclerView.m1723v();
                        if (recyclerView.f7088L.isFinished()) {
                            recyclerView.f7088L.onAbsorb(i5);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.m1724w();
                        if (recyclerView.f7087K.isFinished()) {
                            recyclerView.f7087K.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.m1721t();
                        if (recyclerView.f7089M.isFinished()) {
                            recyclerView.f7089M.onAbsorb(currVelocity);
                        }
                    }
                    if (i5 != 0 || currVelocity != 0) {
                        ViewCompat.postInvalidateOnAnimation(recyclerView);
                    }
                }
                if (RecyclerView.f7071I0) {
                    C0506t c0506t = recyclerView.f7115h0;
                    int[] iArr4 = c0506t.f7502c;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    c0506t.f7503d = 0;
                }
            } else {
                m1821b();
                RunnableC0508u runnableC0508u = recyclerView.f7113g0;
                if (runnableC0508u != null) {
                    runnableC0508u.m1898a(recyclerView, i4, i12);
                }
            }
        }
        RecyclerView.SmoothScroller smoothScroller3 = recyclerView.f7126n.f7166e;
        if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
            smoothScroller3.m1753a(0, 0);
        }
        this.f7326e = false;
        if (this.f7327f) {
            recyclerView.removeCallbacks(this);
            ViewCompat.postOnAnimation(recyclerView, this);
        } else {
            recyclerView.setScrollState(0);
            recyclerView.stopNestedScroll(1);
        }
    }
}
