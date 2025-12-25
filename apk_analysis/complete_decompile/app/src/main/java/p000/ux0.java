package p000;

import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class ux0 {

    /* renamed from: b */
    public vx0 f27513b;

    /* renamed from: c */
    public boolean f27514c;

    /* renamed from: d */
    public int f27515d;

    /* renamed from: e */
    public int f27516e;

    /* renamed from: h */
    public CircularIntArray[] f27519h;

    /* renamed from: a */
    public final Object[] f27512a = new Object[1];

    /* renamed from: f */
    public int f27517f = -1;

    /* renamed from: g */
    public int f27518g = -1;

    /* renamed from: i */
    public int f27520i = -1;

    /* renamed from: a */
    public final boolean m7782a() {
        int i;
        if (this.f27514c) {
            i = Integer.MAX_VALUE;
        } else {
            i = Integer.MIN_VALUE;
        }
        return mo7272b(i, true);
    }

    /* renamed from: b */
    public abstract boolean mo7272b(int i, boolean z);

    /* renamed from: c */
    public final boolean m7783c(int i) {
        if (this.f27518g < 0) {
            return false;
        }
        if (this.f27514c) {
            if (m7786i(true, null) > i + this.f27515d) {
                return false;
            }
        } else if (m7785g(false, null) < i - this.f27515d) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public final boolean m7784d(int i) {
        if (this.f27518g < 0) {
            return false;
        }
        if (this.f27514c) {
            if (m7785g(false, null) < i - this.f27515d) {
                return false;
            }
        } else if (m7786i(true, null) > i + this.f27515d) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public abstract int mo7274f(int i, boolean z, int[] iArr);

    /* renamed from: g */
    public final int m7785g(boolean z, int[] iArr) {
        int i;
        if (this.f27514c) {
            i = this.f27517f;
        } else {
            i = this.f27518g;
        }
        return mo7274f(i, z, iArr);
    }

    /* renamed from: h */
    public abstract int mo7275h(int i, boolean z, int[] iArr);

    /* renamed from: i */
    public final int m7786i(boolean z, int[] iArr) {
        int i;
        if (this.f27514c) {
            i = this.f27518g;
        } else {
            i = this.f27517f;
        }
        return mo7275h(i, z, iArr);
    }

    /* renamed from: j */
    public abstract CircularIntArray[] mo7276j(int i, int i2);

    /* renamed from: k */
    public abstract tx0 mo7277k(int i);

    /* renamed from: l */
    public void mo7382l(int i) {
        int i2;
        if (i < 0 || (i2 = this.f27518g) < 0) {
            return;
        }
        if (i2 >= i) {
            this.f27518g = i - 1;
        }
        if (this.f27518g < this.f27517f) {
            this.f27518g = -1;
            this.f27517f = -1;
        }
        if (this.f27517f < 0) {
            this.f27520i = i;
        }
    }

    /* renamed from: m */
    public abstract boolean mo7278m(int i, boolean z);

    /* renamed from: n */
    public final void m7787n(int i) {
        if (i > 0) {
            if (this.f27516e == i) {
                return;
            }
            this.f27516e = i;
            this.f27519h = new CircularIntArray[i];
            for (int i2 = 0; i2 < this.f27516e; i2++) {
                this.f27519h[i2] = new CircularIntArray();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: e */
    public void mo7273e(int i, int i2, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }
}
