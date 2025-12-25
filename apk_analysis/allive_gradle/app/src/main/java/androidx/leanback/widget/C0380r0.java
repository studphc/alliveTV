package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.leanback.widget.GridLayoutManager;

/* renamed from: androidx.leanback.widget.r0 */
/* loaded from: classes.dex */
public final class C0380r0 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.leanback.widget.GridLayoutManager$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? obj = new Object();
        obj.f5723b = Bundle.EMPTY;
        obj.f5722a = parcel.readInt();
        obj.f5723b = parcel.readBundle(GridLayoutManager.class.getClassLoader());
        return obj;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new GridLayoutManager.SavedState[i];
    }
}
