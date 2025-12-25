package p000;

import android.content.Context;
import android.service.media.MediaBrowserService;
import androidx.media.AbstractC0435l;
import androidx.media.C0437n;
import androidx.media.C0438o;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
public class tk1 extends AbstractC0435l {

    /* renamed from: b */
    public final /* synthetic */ C0438o f26852b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tk1(C0438o c0438o, Context context) {
        super(c0438o, context);
        this.f26852b = c0438o;
    }

    @Override // android.service.media.MediaBrowserService
    public final void onLoadItem(String str, MediaBrowserService.Result result) {
        b01 b01Var = new b01(23, result);
        C0438o c0438o = this.f26852b;
        c0438o.getClass();
        C0437n c0437n = new C0437n(str, b01Var);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = c0438o.f6719e;
        mediaBrowserServiceCompat.f6663e = mediaBrowserServiceCompat.f6660b;
        mediaBrowserServiceCompat.onLoadItem(str, c0437n);
        mediaBrowserServiceCompat.f6663e = null;
    }
}
