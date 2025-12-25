package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import p000.nw0;
import p000.x30;

/* renamed from: androidx.recyclerview.widget.u */
/* loaded from: classes.dex */
public final class RunnableC0508u implements Runnable {

    /* renamed from: e */
    public static final ThreadLocal f7504e = new ThreadLocal();

    /* renamed from: f */
    public static final x30 f7505f = new x30(1);

    /* renamed from: a */
    public ArrayList f7506a;

    /* renamed from: b */
    public long f7507b;

    /* renamed from: c */
    public long f7508c;

    /* renamed from: d */
    public ArrayList f7509d;

    /* renamed from: c */
    public static RecyclerView.ViewHolder m1897c(RecyclerView recyclerView, int i, long j) {
        int m1838h = recyclerView.f7110f.m1838h();
        for (int i2 = 0; i2 < m1838h; i2++) {
            RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(recyclerView.f7110f.m1837g(i2));
            if (m1672F.f7229b == i && !m1672F.m1761f()) {
                return null;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.f7104c;
        try {
            recyclerView.m1692N();
            RecyclerView.ViewHolder m1750j = recycler.m1750j(i, j);
            if (m1750j != null) {
                if (m1750j.m1760e() && !m1750j.m1761f()) {
                    recycler.recycleView(m1750j.itemView);
                } else {
                    recycler.m1741a(m1750j, false);
                }
            }
            recyclerView.m1693O(false);
            return m1750j;
        } catch (Throwable th) {
            recyclerView.m1693O(false);
            throw th;
        }
    }

    /* renamed from: a */
    public final void m1898a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.f7065C0 && !this.f7506a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f7507b == 0) {
                this.f7507b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        C0506t c0506t = recyclerView.f7115h0;
        c0506t.f7500a = i;
        c0506t.f7501b = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m1899b(long j) {
        nw0 nw0Var;
        RecyclerView recyclerView;
        long j2;
        RecyclerView recyclerView2;
        nw0 nw0Var2;
        boolean z;
        ArrayList arrayList = this.f7506a;
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i2);
            if (recyclerView3.getWindowVisibility() == 0) {
                C0506t c0506t = recyclerView3.f7115h0;
                c0506t.m1889a(recyclerView3, false);
                i += c0506t.f7503d;
            }
        }
        ArrayList arrayList2 = this.f7509d;
        arrayList2.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                C0506t c0506t2 = recyclerView4.f7115h0;
                int abs = Math.abs(c0506t2.f7501b) + Math.abs(c0506t2.f7500a);
                for (int i5 = 0; i5 < c0506t2.f7503d * 2; i5 += 2) {
                    if (i3 >= arrayList2.size()) {
                        Object obj = new Object();
                        arrayList2.add(obj);
                        nw0Var2 = obj;
                    } else {
                        nw0Var2 = (nw0) arrayList2.get(i3);
                    }
                    int[] iArr = c0506t2.f7502c;
                    int i6 = iArr[i5 + 1];
                    if (i6 <= abs) {
                        z = true;
                    } else {
                        z = false;
                    }
                    nw0Var2.f23508a = z;
                    nw0Var2.f23509b = abs;
                    nw0Var2.f23510c = i6;
                    nw0Var2.f23511d = recyclerView4;
                    nw0Var2.f23512e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(arrayList2, f7505f);
        for (int i7 = 0; i7 < arrayList2.size() && (recyclerView = (nw0Var = (nw0) arrayList2.get(i7)).f23511d) != null; i7++) {
            if (nw0Var.f23508a) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j;
            }
            RecyclerView.ViewHolder m1897c = m1897c(recyclerView, nw0Var.f23512e, j2);
            if (m1897c != null && m1897c.f7228a != null && m1897c.m1760e() && !m1897c.m1761f() && (recyclerView2 = (RecyclerView) m1897c.f7228a.get()) != null) {
                if (recyclerView2.f7081E && recyclerView2.f7110f.m1838h() != 0) {
                    RecyclerView.ItemAnimator itemAnimator = recyclerView2.f7090N;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimations();
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView2.f7126n;
                    RecyclerView.Recycler recycler = recyclerView2.f7104c;
                    if (layoutManager != null) {
                        layoutManager.removeAndRecycleAllViews(recycler);
                        recyclerView2.f7126n.m1732d(recycler);
                    }
                    recycler.clear();
                }
                C0506t c0506t3 = recyclerView2.f7115h0;
                c0506t3.m1889a(recyclerView2, true);
                if (c0506t3.f7503d != 0) {
                    try {
                        TraceCompat.beginSection("RV Nested Prefetch");
                        RecyclerView.State state = recyclerView2.f7117i0;
                        RecyclerView.Adapter adapter = recyclerView2.f7124m;
                        state.f7214e = 1;
                        state.f7215f = adapter.getItemCount();
                        state.f7217h = false;
                        state.f7218i = false;
                        state.f7219j = false;
                        for (int i8 = 0; i8 < c0506t3.f7503d * 2; i8 += 2) {
                            m1897c(recyclerView2, c0506t3.f7502c[i8], j);
                        }
                        nw0Var.f23508a = false;
                        nw0Var.f23509b = 0;
                        nw0Var.f23510c = 0;
                        nw0Var.f23511d = null;
                        nw0Var.f23512e = 0;
                    } finally {
                        TraceCompat.endSection();
                    }
                }
            }
            nw0Var.f23508a = false;
            nw0Var.f23509b = 0;
            nw0Var.f23510c = 0;
            nw0Var.f23511d = null;
            nw0Var.f23512e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            ArrayList arrayList = this.f7506a;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    m1899b(TimeUnit.MILLISECONDS.toNanos(j) + this.f7508c);
                    this.f7507b = 0L;
                    TraceCompat.endSection();
                }
            }
        } finally {
            this.f7507b = 0L;
            TraceCompat.endSection();
        }
    }
}
