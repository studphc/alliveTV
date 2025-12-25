package p000;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import java.lang.ref.WeakReference;

/* renamed from: y9 */
/* loaded from: classes.dex */
public final class C2012y9 extends ResourcesCompat.FontCallback {

    /* renamed from: a */
    public final /* synthetic */ int f28867a;

    /* renamed from: b */
    public final /* synthetic */ int f28868b;

    /* renamed from: c */
    public final /* synthetic */ WeakReference f28869c;

    /* renamed from: d */
    public final /* synthetic */ C1151ea f28870d;

    public C2012y9(C1151ea c1151ea, int i, int i2, WeakReference weakReference) {
        this.f28870d = c1151ea;
        this.f28867a = i;
        this.f28868b = i2;
        this.f28869c = weakReference;
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    public final void onFontRetrieved(Typeface typeface) {
        int i;
        boolean z;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f28867a) != -1) {
            if ((this.f28868b & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            typeface = AbstractC1115da.m4557a(typeface, i, z);
        }
        C1151ea c1151ea = this.f28870d;
        if (c1151ea.f16739m) {
            c1151ea.f16738l = typeface;
            TextView textView = (TextView) this.f28869c.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new RunnableC2049z9(textView, typeface, c1151ea.f16736j, 0));
                } else {
                    textView.setTypeface(typeface, c1151ea.f16736j);
                }
            }
        }
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    public final void onFontRetrievalFailed(int i) {
    }
}
