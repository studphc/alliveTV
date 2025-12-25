package p000;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;

/* renamed from: xv */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1997xv {
    /* renamed from: a */
    public static long m8193a(ContentMetadata contentMetadata) {
        return contentMetadata.get(ContentMetadata.KEY_CONTENT_LENGTH, -1L);
    }

    /* renamed from: b */
    public static Uri m8194b(ContentMetadata contentMetadata) {
        String str = contentMetadata.get(ContentMetadata.KEY_REDIRECTED_URI, (String) null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }
}
