package p000;

import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: rf */
/* loaded from: classes.dex */
public final class C1759rf extends OnChildViewHolderSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractC1833tf f25951a;

    public C1759rf(AbstractC1833tf abstractC1833tf) {
        this.f25951a = abstractC1833tf;
    }

    @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
    public final void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        AbstractC1833tf abstractC1833tf = this.f25951a;
        if (!abstractC1833tf.f26798k0.f26401a) {
            abstractC1833tf.f26796i0 = i;
            abstractC1833tf.mo1308m(viewHolder, i, i2);
        }
    }
}
