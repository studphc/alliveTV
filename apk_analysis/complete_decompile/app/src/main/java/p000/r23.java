package p000;

import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public final /* synthetic */ class r23 implements OnReceiveContentViewBehavior {
    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        int i = ViewCompat.OVER_SCROLL_ALWAYS;
        return contentInfoCompat;
    }
}
