package androidx.leanback.widget;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.leanback.widget.ImeKeyMonitor;

/* renamed from: androidx.leanback.widget.u0 */
/* loaded from: classes.dex */
public final class C0392u0 implements TextView.OnEditorActionListener, ImeKeyMonitor.ImeKeyListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionAdapter f6419a;

    public C0392u0(GuidedActionAdapter guidedActionAdapter) {
        this.f6419a = guidedActionAdapter;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        GuidedActionAdapter guidedActionAdapter = this.f6419a;
        if (i != 5 && i != 6) {
            if (i == 1) {
                guidedActionAdapter.f5772m.fillAndStay(guidedActionAdapter, textView);
                return true;
            }
            return false;
        }
        guidedActionAdapter.f5772m.fillAndGoNext(guidedActionAdapter, textView);
        return true;
    }

    @Override // androidx.leanback.widget.ImeKeyMonitor.ImeKeyListener
    public final boolean onKeyPreIme(EditText editText, int i, KeyEvent keyEvent) {
        GuidedActionAdapter guidedActionAdapter = this.f6419a;
        if (i == 4 && keyEvent.getAction() == 1) {
            guidedActionAdapter.f5772m.fillAndStay(guidedActionAdapter, editText);
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 1) {
            guidedActionAdapter.f5772m.fillAndGoNext(guidedActionAdapter, editText);
            return true;
        }
        return false;
    }
}
