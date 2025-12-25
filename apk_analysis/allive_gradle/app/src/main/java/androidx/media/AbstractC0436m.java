package androidx.media;

import android.os.Bundle;
import android.os.Messenger;
import androidx.core.util.Pair;
import androidx.media.MediaSessionManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.media.m */
/* loaded from: classes.dex */
public abstract class AbstractC0436m implements InterfaceC0432i {

    /* renamed from: a */
    public final ArrayList f6714a = new ArrayList();

    /* renamed from: b */
    public AbstractC0435l f6715b;

    /* renamed from: c */
    public Messenger f6716c;

    /* renamed from: d */
    public final /* synthetic */ MediaBrowserServiceCompat f6717d;

    public AbstractC0436m(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f6717d = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.InterfaceC0432i
    /* renamed from: a */
    public Bundle mo1559a() {
        if (this.f6716c == null) {
            return null;
        }
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f6717d;
        C0431h c0431h = mediaBrowserServiceCompat.f6663e;
        if (c0431h != null) {
            if (c0431h.f6703e == null) {
                return null;
            }
            return new Bundle(mediaBrowserServiceCompat.f6663e.f6703e);
        }
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    @Override // androidx.media.InterfaceC0432i
    /* renamed from: b */
    public MediaSessionManager.RemoteUserInfo mo1560b() {
        C0431h c0431h = this.f6717d.f6663e;
        if (c0431h != null) {
            return c0431h.f6702d;
        }
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final void m1561c(C0431h c0431h, String str, Bundle bundle) {
        List<Pair> list = (List) c0431h.f6705g.get(str);
        if (list != null) {
            for (Pair pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                    this.f6717d.m1550b(str, c0431h, (Bundle) pair.second, bundle);
                }
            }
        }
    }

    /* renamed from: d */
    public void mo1562d(String str, Bundle bundle) {
        this.f6715b.notifyChildrenChanged(str);
    }
}
