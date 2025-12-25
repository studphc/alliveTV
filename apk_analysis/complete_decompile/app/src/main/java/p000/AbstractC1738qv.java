package p000;

import android.view.ViewStructure;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import java.util.List;

/* renamed from: qv */
/* loaded from: classes.dex */
public abstract class AbstractC1738qv {
    @DoNotInline
    /* renamed from: a */
    public static void m7149a(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
        contentCaptureSession.notifyViewsAppeared(list);
    }
}
