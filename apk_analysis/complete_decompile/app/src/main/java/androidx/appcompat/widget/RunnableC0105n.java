package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

/* renamed from: androidx.appcompat.widget.n */
/* loaded from: classes.dex */
public final class RunnableC0105n implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ SearchView.SearchAutoComplete f1624a;

    public RunnableC0105n(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f1624a = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f1624a;
        if (searchAutoComplete.f1412g) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f1412g = false;
        }
    }
}
