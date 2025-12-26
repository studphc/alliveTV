package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import p000.g43;
import p000.ye0;

/* loaded from: classes.dex */
public class ViewTypeStorage$IsolatedViewTypeStorage implements g43 {

    /* renamed from: a */
    public final SparseArray f7310a = new SparseArray();

    /* renamed from: b */
    public int f7311b = 0;

    @Override // p000.g43
    @NonNull
    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(@NonNull C0487k0 c0487k0) {
        return new C0491l1(this, c0487k0);
    }

    @Override // p000.g43
    @NonNull
    public C0487k0 getWrapperForGlobalType(int i) {
        C0487k0 c0487k0 = (C0487k0) this.f7310a.get(i);
        if (c0487k0 != null) {
            return c0487k0;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Cannot find the wrapper for global view type "));
    }
}
