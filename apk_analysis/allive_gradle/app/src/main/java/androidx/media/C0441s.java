package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager;

/* renamed from: androidx.media.s */
/* loaded from: classes.dex */
public final class C0441s extends C0440q {

    /* renamed from: g */
    public final /* synthetic */ MediaBrowserServiceCompat f6724g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0441s(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.f6724g = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.AbstractC0436m, androidx.media.InterfaceC0432i
    /* renamed from: b */
    public final MediaSessionManager.RemoteUserInfo mo1560b() {
        MediaSessionManager.RemoteUserInfo currentBrowserInfo;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f6724g;
        C0431h c0431h = mediaBrowserServiceCompat.f6663e;
        if (c0431h != null) {
            if (c0431h == mediaBrowserServiceCompat.f6660b) {
                currentBrowserInfo = this.f6715b.getCurrentBrowserInfo();
                return new MediaSessionManager.RemoteUserInfo(currentBrowserInfo);
            }
            return c0431h.f6702d;
        }
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
}
