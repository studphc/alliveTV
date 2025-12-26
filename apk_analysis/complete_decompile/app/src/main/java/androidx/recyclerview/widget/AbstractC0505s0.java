package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.s0 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0505s0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f7499a;

    static {
        int[] iArr = new int[RecyclerView.Adapter.StateRestorationPolicy.values().length];
        f7499a = iArr;
        try {
            iArr[RecyclerView.Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7499a[RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
