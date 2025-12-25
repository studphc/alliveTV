package androidx.leanback.graphics;

import android.graphics.drawable.Drawable;
import androidx.leanback.graphics.CompositeDrawable;
import java.util.ArrayList;

/* renamed from: androidx.leanback.graphics.i */
/* loaded from: classes.dex */
public final class C0297i extends Drawable.ConstantState {

    /* renamed from: a */
    public final ArrayList f5377a;

    public C0297i() {
        this.f5377a = new ArrayList();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, androidx.leanback.graphics.CompositeDrawable] */
    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        ?? drawable = new Drawable();
        drawable.f5369b = false;
        drawable.f5368a = this;
        return drawable;
    }

    public C0297i(C0297i c0297i, CompositeDrawable compositeDrawable) {
        int size = c0297i.f5377a.size();
        this.f5377a = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.f5377a.add(new CompositeDrawable.ChildDrawable((CompositeDrawable.ChildDrawable) c0297i.f5377a.get(i), compositeDrawable));
        }
    }
}
