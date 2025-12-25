package p000;

import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.ViewHolderTask;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: kf */
/* loaded from: classes.dex */
public final class C1389kf extends OnChildViewHolderSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ int f20840a;

    /* renamed from: b */
    public final /* synthetic */ ViewHolderTask f20841b;

    /* renamed from: c */
    public final /* synthetic */ BaseGridView f20842c;

    public C1389kf(BaseGridView baseGridView, int i, ViewHolderTask viewHolderTask) {
        this.f20842c = baseGridView;
        this.f20840a = i;
        this.f20841b = viewHolderTask;
    }

    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
    public final void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        if (i == this.f20840a) {
            this.f20842c.removeOnChildViewHolderSelectedListener(this);
            this.f20841b.run(viewHolder);
        }
    }
}
