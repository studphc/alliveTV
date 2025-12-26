package androidx.media;

import android.os.Bundle;
import p000.vk1;

/* renamed from: androidx.media.q */
/* loaded from: classes.dex */
public class C0440q extends C0438o {

    /* renamed from: f */
    public final /* synthetic */ MediaBrowserServiceCompat f6723f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0440q(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f6723f = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.AbstractC0436m, androidx.media.InterfaceC0432i
    /* renamed from: a */
    public final Bundle mo1559a() {
        Bundle browserRootHints;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f6723f;
        C0431h c0431h = mediaBrowserServiceCompat.f6663e;
        if (c0431h != null) {
            if (c0431h == mediaBrowserServiceCompat.f6660b) {
                browserRootHints = this.f6715b.getBrowserRootHints();
                return browserRootHints;
            }
            if (c0431h.f6703e == null) {
                return null;
            }
            return new Bundle(mediaBrowserServiceCompat.f6663e.f6703e);
        }
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    @Override // androidx.media.AbstractC0436m
    /* renamed from: d */
    public final void mo1562d(String str, Bundle bundle) {
        if (bundle != null) {
            this.f6715b.notifyChildrenChanged(str, bundle);
        } else {
            super.mo1562d(str, bundle);
        }
    }

    @Override // androidx.media.C0438o, androidx.media.InterfaceC0432i
    public final void onCreate() {
        vk1 vk1Var = new vk1(this, this.f6723f);
        this.f6715b = vk1Var;
        vk1Var.onCreate();
    }
}
