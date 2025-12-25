package androidx.leanback.widget;

import androidx.leanback.widget.SearchEditText;

/* renamed from: androidx.leanback.widget.t2 */
/* loaded from: classes.dex */
public final class RunnableC0390t2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ SearchEditText f6417a;

    public RunnableC0390t2(SearchEditText searchEditText) {
        this.f6417a = searchEditText;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchEditText.OnKeyboardDismissListener onKeyboardDismissListener = this.f6417a.f6152h;
        if (onKeyboardDismissListener != null) {
            onKeyboardDismissListener.onKeyboardDismiss();
        }
    }
}
