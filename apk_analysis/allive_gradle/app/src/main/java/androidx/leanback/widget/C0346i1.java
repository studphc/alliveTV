package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ListRowPresenter;

/* renamed from: androidx.leanback.widget.i1 */
/* loaded from: classes.dex */
public final class C0346i1 implements OnChildSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ ListRowPresenter.ViewHolder f6307a;

    /* renamed from: b */
    public final /* synthetic */ ListRowPresenter f6308b;

    public C0346i1(ListRowPresenter listRowPresenter, ListRowPresenter.ViewHolder viewHolder) {
        this.f6308b = listRowPresenter;
        this.f6307a = viewHolder;
    }

    @Override // androidx.leanback.widget.OnChildSelectedListener
    public final void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
        this.f6308b.m1447c(this.f6307a, view, true);
    }
}
