package p000;

import androidx.leanback.app.RowsFragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class yc2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.ViewHolder f28897a;

    /* renamed from: b */
    public final /* synthetic */ zc2 f28898b;

    public yc2(zc2 zc2Var, RecyclerView.ViewHolder viewHolder) {
        this.f28898b = zc2Var;
        this.f28897a = viewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f28898b.f29311a.run(RowsFragment.m1339f((ItemBridgeAdapter.ViewHolder) this.f28897a));
    }
}
