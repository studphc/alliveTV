package p000;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* loaded from: classes.dex */
public final class g83 implements o83 {

    /* renamed from: a */
    public final /* synthetic */ FrameLayout f17609a;

    /* renamed from: b */
    public final /* synthetic */ LayoutInflater f17610b;

    /* renamed from: c */
    public final /* synthetic */ ViewGroup f17611c;

    /* renamed from: d */
    public final /* synthetic */ Bundle f17612d;

    /* renamed from: e */
    public final /* synthetic */ DeferredLifecycleHelper f17613e;

    public g83(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17613e = deferredLifecycleHelper;
        this.f17609a = frameLayout;
        this.f17610b = layoutInflater;
        this.f17611c = viewGroup;
        this.f17612d = bundle;
    }

    @Override // p000.o83
    public final int zaa() {
        return 2;
    }

    @Override // p000.o83
    public final void zab() {
        FrameLayout frameLayout = this.f17609a;
        frameLayout.removeAllViews();
        frameLayout.addView(this.f17613e.f13692a.onCreateView(this.f17610b, this.f17611c, this.f17612d));
    }
}
