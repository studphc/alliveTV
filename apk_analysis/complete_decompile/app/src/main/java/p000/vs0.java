package p000;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
public final class vs0 {

    /* renamed from: a */
    public final /* synthetic */ int f27941a;

    /* renamed from: b */
    public final ContentProviderClient f27942b;

    public vs0(Context context, Uri uri, int i) {
        this.f27941a = i;
        switch (i) {
            case 1:
                this.f27942b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                return;
            default:
                this.f27942b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                return;
        }
    }

    /* renamed from: a */
    public final void m7931a() {
        switch (this.f27941a) {
            case 0:
                ContentProviderClient contentProviderClient = this.f27942b;
                if (contentProviderClient != null) {
                    contentProviderClient.release();
                    return;
                }
                return;
            default:
                ContentProviderClient contentProviderClient2 = this.f27942b;
                if (contentProviderClient2 != null) {
                    contentProviderClient2.release();
                    return;
                }
                return;
        }
    }
}
