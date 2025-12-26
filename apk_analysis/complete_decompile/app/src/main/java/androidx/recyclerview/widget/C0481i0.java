package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.i0 */
/* loaded from: classes.dex */
public final class C0481i0 implements AsyncListDiffer.ListListener {

    /* renamed from: a */
    public final /* synthetic */ ListAdapter f7404a;

    public C0481i0(ListAdapter listAdapter) {
        this.f7404a = listAdapter;
    }

    @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
    public final void onCurrentListChanged(List list, List list2) {
        this.f7404a.onCurrentListChanged(list, list2);
    }
}
