package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* renamed from: androidx.recyclerview.widget.h1 */
/* loaded from: classes.dex */
public final class C0479h1 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z;
        boolean z2;
        ?? obj = new Object();
        obj.f7299a = parcel.readInt();
        obj.f7300b = parcel.readInt();
        int readInt = parcel.readInt();
        obj.f7301c = readInt;
        if (readInt > 0) {
            int[] iArr = new int[readInt];
            obj.f7302d = iArr;
            parcel.readIntArray(iArr);
        }
        int readInt2 = parcel.readInt();
        obj.f7303e = readInt2;
        if (readInt2 > 0) {
            int[] iArr2 = new int[readInt2];
            obj.f7304f = iArr2;
            parcel.readIntArray(iArr2);
        }
        boolean z3 = false;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        obj.f7306h = z;
        if (parcel.readInt() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        obj.f7307i = z2;
        if (parcel.readInt() == 1) {
            z3 = true;
        }
        obj.f7308j = z3;
        obj.f7305g = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new StaggeredGridLayoutManager.SavedState[i];
    }
}
