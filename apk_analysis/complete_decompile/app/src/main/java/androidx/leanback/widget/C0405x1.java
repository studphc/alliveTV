package androidx.leanback.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* renamed from: androidx.leanback.widget.x1 */
/* loaded from: classes.dex */
public final class C0405x1 implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.leanback.widget.PersistentFocusWrapper$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? baseSavedState = new View.BaseSavedState(parcel);
        baseSavedState.f5985a = parcel.readInt();
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new PersistentFocusWrapper$SavedState[i];
    }
}
