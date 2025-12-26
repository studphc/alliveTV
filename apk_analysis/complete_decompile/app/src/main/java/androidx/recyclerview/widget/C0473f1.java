package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.recyclerview.widget.f1 */
/* loaded from: classes.dex */
public final class C0473f1 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f7295a = parcel.readInt();
        obj.f7296b = parcel.readInt();
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        obj.f7298d = z;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            obj.f7297c = iArr;
            parcel.readIntArray(iArr);
        }
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[i];
    }
}
