package androidx.appcompat.widget;

import android.widget.AutoCompleteTextView;
import androidx.annotation.DoNotInline;
import androidx.appcompat.widget.SearchView;

/* renamed from: androidx.appcompat.widget.l */
/* loaded from: classes.dex */
public abstract class AbstractC0103l {
    @DoNotInline
    /* renamed from: a */
    public static void m321a(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.refreshAutoCompleteResults();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m322b(SearchView.SearchAutoComplete searchAutoComplete, int i) {
        searchAutoComplete.setInputMethodMode(i);
    }
}
