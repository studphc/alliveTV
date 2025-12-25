package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p000.AbstractC1726qj;
import p000.C1972x6;

/* renamed from: androidx.recyclerview.widget.g */
/* loaded from: classes.dex */
public final class C0474g {

    /* renamed from: a */
    public final C0501q0 f7375a;

    /* renamed from: e */
    public View f7379e;

    /* renamed from: d */
    public int f7378d = 0;

    /* renamed from: b */
    public final C1972x6 f7376b = new C1972x6(1);

    /* renamed from: c */
    public final ArrayList f7377c = new ArrayList();

    public C0474g(C0501q0 c0501q0) {
        this.f7375a = c0501q0;
    }

    /* renamed from: a */
    public final void m1831a(int i, View view, boolean z) {
        int m1836f;
        RecyclerView recyclerView = this.f7375a.f7466a;
        if (i < 0) {
            m1836f = recyclerView.getChildCount();
        } else {
            m1836f = m1836f(i);
        }
        this.f7376b.m8141e(m1836f, z);
        if (z) {
            m1839i(view);
        }
        recyclerView.addView(view, m1836f);
        RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(view);
        recyclerView.onChildAttachedToWindow(view);
        RecyclerView.Adapter adapter = recyclerView.f7124m;
        if (adapter != null && m1672F != null) {
            adapter.onViewAttachedToWindow(m1672F);
        }
        ArrayList arrayList = recyclerView.f7080D;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((RecyclerView.OnChildAttachStateChangeListener) recyclerView.f7080D.get(size)).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* renamed from: b */
    public final void m1832b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int m1836f;
        RecyclerView recyclerView = this.f7375a.f7466a;
        if (i < 0) {
            m1836f = recyclerView.getChildCount();
        } else {
            m1836f = m1836f(i);
        }
        this.f7376b.m8141e(m1836f, z);
        if (z) {
            m1839i(view);
        }
        RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(view);
        if (m1672F != null) {
            if (!m1672F.m1764i() && !m1672F.m1768m()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(m1672F);
                throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, sb));
            }
            if (RecyclerView.f7066D0) {
                Log.d("RecyclerView", "reAttach " + m1672F);
            }
            m1672F.f7236i &= -257;
        } else if (RecyclerView.f7065C0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(m1836f);
            throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, m1836f, layoutParams);
    }

    /* renamed from: c */
    public final void m1833c(int i) {
        int m1836f = m1836f(i);
        this.f7376b.m8142f(m1836f);
        RecyclerView recyclerView = this.f7375a.f7466a;
        View childAt = recyclerView.getChildAt(m1836f);
        if (childAt != null) {
            RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(childAt);
            if (m1672F != null) {
                if (m1672F.m1764i() && !m1672F.m1768m()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(m1672F);
                    throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, sb));
                }
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "tmpDetach " + m1672F);
                }
                m1672F.m1756a(256);
            }
        } else if (RecyclerView.f7065C0) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(m1836f);
            throw new IllegalArgumentException(AbstractC1726qj.m7056l(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(m1836f);
    }

    /* renamed from: d */
    public final View m1834d(int i) {
        return this.f7375a.f7466a.getChildAt(m1836f(i));
    }

    /* renamed from: e */
    public final int m1835e() {
        return this.f7375a.f7466a.getChildCount() - this.f7377c.size();
    }

    /* renamed from: f */
    public final int m1836f(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.f7375a.f7466a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            C1972x6 c1972x6 = this.f7376b;
            int m8138b = i - (i2 - c1972x6.m8138b(i2));
            if (m8138b == 0) {
                while (c1972x6.m8140d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += m8138b;
        }
        return -1;
    }

    /* renamed from: g */
    public final View m1837g(int i) {
        return this.f7375a.f7466a.getChildAt(i);
    }

    /* renamed from: h */
    public final int m1838h() {
        return this.f7375a.f7466a.getChildCount();
    }

    /* renamed from: i */
    public final void m1839i(View view) {
        this.f7377c.add(view);
        C0501q0 c0501q0 = this.f7375a;
        RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(view);
        if (m1672F != null) {
            int i = m1672F.f7243p;
            if (i != -1) {
                m1672F.f7242o = i;
            } else {
                m1672F.f7242o = ViewCompat.getImportantForAccessibility(m1672F.itemView);
            }
            RecyclerView recyclerView = c0501q0.f7466a;
            if (recyclerView.isComputingLayout()) {
                m1672F.f7243p = 4;
                recyclerView.f7145w0.add(m1672F);
            } else {
                ViewCompat.setImportantForAccessibility(m1672F.itemView, 4);
            }
        }
    }

    /* renamed from: j */
    public final int m1840j(View view) {
        int indexOfChild = this.f7375a.f7466a.indexOfChild(view);
        if (indexOfChild == -1) {
            return -1;
        }
        C1972x6 c1972x6 = this.f7376b;
        if (c1972x6.m8140d(indexOfChild)) {
            return -1;
        }
        return indexOfChild - c1972x6.m8138b(indexOfChild);
    }

    /* renamed from: k */
    public final void m1841k(int i) {
        C0501q0 c0501q0 = this.f7375a;
        int i2 = this.f7378d;
        if (i2 != 1) {
            if (i2 != 2) {
                try {
                    int m1836f = m1836f(i);
                    View childAt = c0501q0.f7466a.getChildAt(m1836f);
                    if (childAt == null) {
                        this.f7378d = 0;
                        this.f7379e = null;
                        return;
                    }
                    this.f7378d = 1;
                    this.f7379e = childAt;
                    if (this.f7376b.m8142f(m1836f)) {
                        m1842l(childAt);
                    }
                    c0501q0.m1878a(m1836f);
                    this.f7378d = 0;
                    this.f7379e = null;
                    return;
                } catch (Throwable th) {
                    this.f7378d = 0;
                    this.f7379e = null;
                    throw th;
                }
            }
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
    }

    /* renamed from: l */
    public final void m1842l(View view) {
        if (this.f7377c.remove(view)) {
            C0501q0 c0501q0 = this.f7375a;
            RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(view);
            if (m1672F != null) {
                int i = m1672F.f7242o;
                RecyclerView recyclerView = c0501q0.f7466a;
                if (recyclerView.isComputingLayout()) {
                    m1672F.f7243p = i;
                    recyclerView.f7145w0.add(m1672F);
                } else {
                    ViewCompat.setImportantForAccessibility(m1672F.itemView, i);
                }
                m1672F.f7242o = 0;
            }
        }
    }

    public final String toString() {
        return this.f7376b.toString() + ", hidden list:" + this.f7377c.size();
    }
}
