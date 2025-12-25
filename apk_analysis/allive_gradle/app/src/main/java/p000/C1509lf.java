package p000;

import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.ViewHolderTask;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: lf */
/* loaded from: classes.dex */
public final class C1509lf extends OnChildViewHolderSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ int f22485a;

    /* renamed from: b */
    public final /* synthetic */ ViewHolderTask f22486b;

    /* renamed from: c */
    public final /* synthetic */ BaseGridView f22487c;

    public C1509lf(BaseGridView baseGridView, int i, ViewHolderTask viewHolderTask) {
        this.f22487c = baseGridView;
        this.f22485a = i;
        this.f22486b = viewHolderTask;
    }

    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
    public final void onChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        if (i == this.f22485a) {
            this.f22487c.removeOnChildViewHolderSelectedListener(this);
            this.f22486b.run(viewHolder);
        }
    }
}
