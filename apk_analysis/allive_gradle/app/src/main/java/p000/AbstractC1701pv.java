package p000;

import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;

/* renamed from: pv */
/* loaded from: classes.dex */
public abstract class AbstractC1701pv {
    @DoNotInline
    /* renamed from: a */
    public static AutofillId m6925a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
        return contentCaptureSession.newAutofillId(autofillId, j);
    }

    @DoNotInline
    /* renamed from: b */
    public static ViewStructure m6926b(ContentCaptureSession contentCaptureSession, View view) {
        return contentCaptureSession.newViewStructure(view);
    }

    @DoNotInline
    /* renamed from: c */
    public static ViewStructure m6927c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
        return contentCaptureSession.newVirtualViewStructure(autofillId, j);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m6928d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
        contentCaptureSession.notifyViewAppeared(viewStructure);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m6929e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
        contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m6930f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
        contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
    }
}
