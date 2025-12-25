package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.TintContextWrapper;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class au2 extends gc2 {

    /* renamed from: b */
    public final WeakReference f7751b;

    public au2(TintContextWrapper tintContextWrapper, Resources resources) {
        super(resources);
        this.f7751b = new WeakReference(tintContextWrapper);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i) {
        ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks;
        Drawable m4936a = m4936a(i);
        Context context = (Context) this.f7751b.get();
        if (m4936a != null && context != null && (resourceManagerHooks = ResourceManagerInternal.get().f1345g) != null) {
            resourceManagerHooks.tintDrawableUsingColorFilter(context, i, m4936a);
        }
        return m4936a;
    }
}
