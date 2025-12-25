package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: androidx.recyclerview.widget.y0 */
/* loaded from: classes.dex */
public final class C0517y0 extends RecyclerView.AdapterDataObserver {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView f7525a;

    public C0517y0(RecyclerView recyclerView) {
        this.f7525a = recyclerView;
    }

    /* renamed from: a */
    public final void m1905a() {
        boolean z = RecyclerView.f7070H0;
        RecyclerView recyclerView = this.f7525a;
        if (z && recyclerView.f7140u && recyclerView.f7138t) {
            ViewCompat.postOnAnimation(recyclerView, recyclerView.f7116i);
        } else {
            recyclerView.f7077B = true;
            recyclerView.requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        RecyclerView recyclerView = this.f7525a;
        recyclerView.m1711h(null);
        recyclerView.f7117i0.f7216g = true;
        recyclerView.m1697S(true);
        if (!recyclerView.f7108e.m1814g()) {
            recyclerView.requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        RecyclerView recyclerView = this.f7525a;
        recyclerView.m1711h(null);
        C0456a c0456a = recyclerView.f7108e;
        if (i2 < 1) {
            c0456a.getClass();
            return;
        }
        ArrayList arrayList = c0456a.f7314b;
        arrayList.add(c0456a.m1815h(4, i, i2, obj));
        c0456a.f7318f |= 4;
        if (arrayList.size() == 1) {
            m1905a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i2) {
        RecyclerView recyclerView = this.f7525a;
        recyclerView.m1711h(null);
        C0456a c0456a = recyclerView.f7108e;
        if (i2 < 1) {
            c0456a.getClass();
            return;
        }
        ArrayList arrayList = c0456a.f7314b;
        arrayList.add(c0456a.m1815h(1, i, i2, null));
        c0456a.f7318f |= 1;
        if (arrayList.size() == 1) {
            m1905a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i, int i2, int i3) {
        RecyclerView recyclerView = this.f7525a;
        recyclerView.m1711h(null);
        C0456a c0456a = recyclerView.f7108e;
        c0456a.getClass();
        if (i != i2) {
            if (i3 == 1) {
                ArrayList arrayList = c0456a.f7314b;
                arrayList.add(c0456a.m1815h(8, i, i2, null));
                c0456a.f7318f |= 8;
                if (arrayList.size() == 1) {
                    m1905a();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i, int i2) {
        RecyclerView recyclerView = this.f7525a;
        recyclerView.m1711h(null);
        C0456a c0456a = recyclerView.f7108e;
        if (i2 < 1) {
            c0456a.getClass();
            return;
        }
        ArrayList arrayList = c0456a.f7314b;
        arrayList.add(c0456a.m1815h(2, i, i2, null));
        c0456a.f7318f |= 2;
        if (arrayList.size() == 1) {
            m1905a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onStateRestorationPolicyChanged() {
        RecyclerView.Adapter adapter;
        int i;
        RecyclerView recyclerView = this.f7525a;
        if (recyclerView.f7106d != null && (adapter = recyclerView.f7124m) != null && (i = AbstractC0505s0.f7499a[adapter.f7154c.ordinal()]) != 1) {
            if (i != 2 || adapter.getItemCount() > 0) {
                recyclerView.requestLayout();
            }
        }
    }
}
