package p000;

import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class cd2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.ViewHolder f8338a;

    /* renamed from: b */
    public final /* synthetic */ dd2 f8339b;

    public cd2(dd2 dd2Var, RecyclerView.ViewHolder viewHolder) {
        this.f8339b = dd2Var;
        this.f8338a = viewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8339b.f16347a.run(RowsSupportFragment.m1342q((ItemBridgeAdapter.ViewHolder) this.f8338a));
    }
}
