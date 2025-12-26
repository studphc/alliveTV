package p000;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.C0431h;
import androidx.media.C0439p;
import androidx.media.C0440q;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
public final class vk1 extends tk1 {

    /* renamed from: c */
    public final /* synthetic */ C0440q f27831c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vk1(C0440q c0440q, Context context) {
        super(c0440q, context);
        this.f27831c = c0440q;
    }

    @Override // android.service.media.MediaBrowserService
    public final void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        C0440q c0440q = this.f27831c;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = c0440q.f6723f;
        C0431h c0431h = mediaBrowserServiceCompat.f6660b;
        C0439p c0439p = new C0439p(c0440q, str, new b01(23, result), bundle);
        mediaBrowserServiceCompat.f6663e = c0431h;
        mediaBrowserServiceCompat.onLoadChildren(str, c0439p, bundle);
        mediaBrowserServiceCompat.f6663e = null;
        c0440q.f6723f.f6663e = null;
    }
}
