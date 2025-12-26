package androidx.leanback.widget;

import androidx.leanback.widget.PlaybackTransportRowPresenter;
import androidx.leanback.widget.Presenter;
import p000.a52;

/* renamed from: androidx.leanback.widget.g2 */
/* loaded from: classes.dex */
public final class C0339g2 implements InterfaceC0356l {
    @Override // androidx.leanback.widget.InterfaceC0356l
    /* renamed from: a */
    public final void mo1495a(Presenter.ViewHolder viewHolder, Object obj, a52 a52Var) {
        PlaybackTransportRowPresenter.ViewHolder viewHolder2 = ((C0351j2) a52Var).f6313d;
        if (viewHolder2.f6043D != viewHolder || viewHolder2.f6044E != obj) {
            viewHolder2.f6043D = viewHolder;
            viewHolder2.f6044E = obj;
            viewHolder2.m1472a();
        }
    }
}
