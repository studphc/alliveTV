package p000;

import android.content.ClipData;
import android.location.LocationRequest;
import android.media.MediaDrm;
import android.view.ContentInfo;

/* renamed from: hf */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1267hf {
    /* renamed from: d */
    public static /* bridge */ /* synthetic */ LocationRequest m5063d(Object obj) {
        return (LocationRequest) obj;
    }

    /* renamed from: f */
    public static /* bridge */ /* synthetic */ MediaDrm.PlaybackComponent m5065f(Object obj) {
        return (MediaDrm.PlaybackComponent) obj;
    }

    /* renamed from: l */
    public static /* synthetic */ ContentInfo.Builder m5071l(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    /* renamed from: m */
    public static /* synthetic */ ContentInfo.Builder m5072m(ContentInfo contentInfo) {
        return new ContentInfo.Builder(contentInfo);
    }

    /* renamed from: o */
    public static /* bridge */ /* synthetic */ ContentInfo m5074o(Object obj) {
        return (ContentInfo) obj;
    }

    /* renamed from: r */
    public static /* synthetic */ void m5077r() {
    }
}
