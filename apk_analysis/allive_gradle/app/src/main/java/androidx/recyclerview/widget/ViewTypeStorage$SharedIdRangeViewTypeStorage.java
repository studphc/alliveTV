package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.List;
import p000.C1540m9;
import p000.g43;
import p000.ye0;

/* loaded from: classes.dex */
public class ViewTypeStorage$SharedIdRangeViewTypeStorage implements g43 {

    /* renamed from: a */
    public final SparseArray f7312a = new SparseArray();

    @Override // p000.g43
    @NonNull
    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(@NonNull C0487k0 c0487k0) {
        return new C1540m9(26, this, c0487k0, false);
    }

    @Override // p000.g43
    @NonNull
    public C0487k0 getWrapperForGlobalType(int i) {
        List list = (List) this.f7312a.get(i);
        if (list != null && !list.isEmpty()) {
            return (C0487k0) list.get(0);
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Cannot find the wrapper for global view type "));
    }
}
