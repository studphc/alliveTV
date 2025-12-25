package androidx.leanback.widget;

import android.view.View;
import android.widget.EditText;
import androidx.leanback.widget.GuidedActionAutofillSupport;

/* renamed from: androidx.leanback.widget.t0 */
/* loaded from: classes.dex */
public final class C0388t0 implements GuidedActionAutofillSupport.OnAutofillListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionAdapter f6414a;

    public C0388t0(GuidedActionAdapter guidedActionAdapter) {
        this.f6414a = guidedActionAdapter;
    }

    @Override // androidx.leanback.widget.GuidedActionAutofillSupport.OnAutofillListener
    public final void onAutofill(View view) {
        GuidedActionAdapter guidedActionAdapter = this.f6414a;
        guidedActionAdapter.f5772m.fillAndGoNext(guidedActionAdapter, (EditText) view);
    }
}
