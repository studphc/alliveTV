package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import p000.C1935w6;

/* renamed from: androidx.recyclerview.widget.r0 */
/* loaded from: classes.dex */
public final class C0503r0 {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView f7468a;

    public C0503r0(RecyclerView recyclerView) {
        this.f7468a = recyclerView;
    }

    /* renamed from: a */
    public final void m1879a(C1935w6 c1935w6) {
        int i = c1935w6.f28079a;
        RecyclerView recyclerView = this.f7468a;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i == 8) {
                        recyclerView.f7126n.onItemsMoved(recyclerView, c1935w6.f28080b, c1935w6.f28082d, 1);
                        return;
                    }
                    return;
                }
                recyclerView.f7126n.onItemsUpdated(recyclerView, c1935w6.f28080b, c1935w6.f28082d, c1935w6.f28081c);
                return;
            }
            recyclerView.f7126n.onItemsRemoved(recyclerView, c1935w6.f28080b, c1935w6.f28082d);
            return;
        }
        recyclerView.f7126n.onItemsAdded(recyclerView, c1935w6.f28080b, c1935w6.f28082d);
    }

    /* renamed from: b */
    public final RecyclerView.ViewHolder m1880b(int i) {
        RecyclerView recyclerView = this.f7468a;
        RecyclerView.ViewHolder m1683C = recyclerView.m1683C(i, true);
        if (m1683C == null) {
            return null;
        }
        C0474g c0474g = recyclerView.f7110f;
        if (c0474g.f7377c.contains(m1683C.itemView)) {
            if (RecyclerView.f7066D0) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
            return null;
        }
        return m1683C;
    }

    /* renamed from: c */
    public final void m1881c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.f7468a;
        int m1838h = recyclerView.f7110f.m1838h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < m1838h; i6++) {
            View m1837g = recyclerView.f7110f.m1837g(i6);
            RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(m1837g);
            if (m1672F != null && !m1672F.m1768m() && (i4 = m1672F.f7229b) >= i && i4 < i5) {
                m1672F.m1756a(2);
                if (obj == null) {
                    m1672F.m1756a(1024);
                } else if ((1024 & m1672F.f7236i) == 0) {
                    if (m1672F.f7237j == null) {
                        ArrayList arrayList = new ArrayList();
                        m1672F.f7237j = arrayList;
                        m1672F.f7238k = Collections.unmodifiableList(arrayList);
                    }
                    m1672F.f7237j.add(obj);
                }
                ((RecyclerView.LayoutParams) m1837g.getLayoutParams()).f7180c = true;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.f7104c;
        ArrayList arrayList2 = recycler.f7187c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) arrayList2.get(size);
            if (viewHolder != null && (i3 = viewHolder.f7229b) >= i && i3 < i5) {
                viewHolder.m1756a(2);
                recycler.m1746f(size);
            }
        }
        recyclerView.f7125m0 = true;
    }

    /* renamed from: d */
    public final void m1882d(int i, int i2) {
        RecyclerView recyclerView = this.f7468a;
        int m1838h = recyclerView.f7110f.m1838h();
        for (int i3 = 0; i3 < m1838h; i3++) {
            RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(recyclerView.f7110f.m1837g(i3));
            if (m1672F != null && !m1672F.m1768m() && m1672F.f7229b >= i) {
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i3 + " holder " + m1672F + " now at position " + (m1672F.f7229b + i2));
                }
                m1672F.m1766k(i2, false);
                recyclerView.f7117i0.f7216g = true;
            }
        }
        ArrayList arrayList = recyclerView.f7104c.f7187c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) arrayList.get(i4);
            if (viewHolder != null && viewHolder.f7229b >= i) {
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i4 + " holder " + viewHolder + " now at position " + (viewHolder.f7229b + i2));
                }
                viewHolder.m1766k(i2, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f7123l0 = true;
    }

    /* renamed from: e */
    public final void m1883e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        RecyclerView recyclerView = this.f7468a;
        int m1838h = recyclerView.f7110f.m1838h();
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        boolean z = false;
        for (int i11 = 0; i11 < m1838h; i11++) {
            RecyclerView.ViewHolder m1672F = RecyclerView.m1672F(recyclerView.f7110f.m1837g(i11));
            if (m1672F != null && (i10 = m1672F.f7229b) >= i4 && i10 <= i3) {
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i11 + " holder " + m1672F);
                }
                if (m1672F.f7229b == i) {
                    m1672F.m1766k(i2 - i, false);
                } else {
                    m1672F.m1766k(i5, false);
                }
                recyclerView.f7117i0.f7216g = true;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.f7104c;
        recycler.getClass();
        if (i < i2) {
            i7 = i;
            i6 = i2;
            i8 = -1;
        } else {
            i6 = i;
            i7 = i2;
            i8 = 1;
        }
        ArrayList arrayList = recycler.f7187c;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) arrayList.get(i12);
            if (viewHolder != null && (i9 = viewHolder.f7229b) >= i7 && i9 <= i6) {
                if (i9 == i) {
                    viewHolder.m1766k(i2 - i, z);
                } else {
                    viewHolder.m1766k(i8, z);
                }
                if (RecyclerView.f7066D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i12 + " holder " + viewHolder);
                }
            }
            i12++;
            z = false;
        }
        recyclerView.requestLayout();
        recyclerView.f7123l0 = true;
    }
}
