package p000;

import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: of */
/* loaded from: classes.dex */
public final class C1620of extends OnChildViewHolderSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractFragmentC1722qf f23793a;

    public C1620of(AbstractFragmentC1722qf abstractFragmentC1722qf) {
        this.f23793a = abstractFragmentC1722qf;
    }

    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
    public final void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        AbstractFragmentC1722qf abstractFragmentC1722qf = this.f23793a;
        if (!abstractFragmentC1722qf.f25566g.f25143a) {
            abstractFragmentC1722qf.f25564e = i;
            abstractFragmentC1722qf.mo1303b(viewHolder, i, i2);
        }
    }
}
