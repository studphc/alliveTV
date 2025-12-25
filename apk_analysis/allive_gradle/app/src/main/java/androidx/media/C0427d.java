package androidx.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

/* renamed from: androidx.media.d */
/* loaded from: classes.dex */
public final class C0427d extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ C0431h f6691f;

    /* renamed from: g */
    public final /* synthetic */ String f6692g;

    /* renamed from: h */
    public final /* synthetic */ Bundle f6693h;

    /* renamed from: i */
    public final /* synthetic */ Bundle f6694i;

    /* renamed from: j */
    public final /* synthetic */ MediaBrowserServiceCompat f6695j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0427d(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, C0431h c0431h, String str2, Bundle bundle, Bundle bundle2) {
        super(str);
        this.f6695j = mediaBrowserServiceCompat;
        this.f6691f = c0431h;
        this.f6692g = str2;
        this.f6693h = bundle;
        this.f6694i = bundle2;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        List list = (List) obj;
        ArrayMap arrayMap = this.f6695j.f6662d;
        C0431h c0431h = this.f6691f;
        Object obj2 = arrayMap.get(c0431h.f6704f.f255a.getBinder());
        String str = c0431h.f6699a;
        String str2 = this.f6692g;
        if (obj2 != c0431h) {
            if (MediaBrowserServiceCompat.f6658h) {
                Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + str + " id=" + str2);
                return;
            }
            return;
        }
        int i = this.f6672e & 1;
        Bundle bundle = this.f6693h;
        if (i != 0) {
            list = MediaBrowserServiceCompat.m1549a(list, bundle);
        }
        try {
            c0431h.f6704f.m114a(str2, list, bundle, this.f6694i);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + str);
        }
    }
}
