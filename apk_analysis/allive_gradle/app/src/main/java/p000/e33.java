package p000;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import androidx.core.view.ContentInfoCompat;

/* loaded from: classes.dex */
public final class e33 implements OnReceiveContentListener {

    /* renamed from: a */
    public final androidx.core.view.OnReceiveContentListener f16665a;

    public e33(androidx.core.view.OnReceiveContentListener onReceiveContentListener) {
        this.f16665a = onReceiveContentListener;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(contentInfo);
        ContentInfoCompat onReceiveContent = this.f16665a.onReceiveContent(view, contentInfoCompat);
        if (onReceiveContent == null) {
            return null;
        }
        if (onReceiveContent == contentInfoCompat) {
            return contentInfo;
        }
        return onReceiveContent.toContentInfo();
    }
}
