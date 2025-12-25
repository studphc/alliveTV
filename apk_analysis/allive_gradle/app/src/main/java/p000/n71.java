package p000;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.LayoutInflaterFactory;

/* loaded from: classes.dex */
public final class n71 implements LayoutInflater.Factory2 {

    /* renamed from: a */
    public final LayoutInflaterFactory f23266a;

    public n71(LayoutInflaterFactory layoutInflaterFactory) {
        this.f23266a = layoutInflaterFactory;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f23266a.onCreateView(null, str, context, attributeSet);
    }

    public final String toString() {
        return n71.class.getName() + "{" + this.f23266a + "}";
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f23266a.onCreateView(view, str, context, attributeSet);
    }
}
