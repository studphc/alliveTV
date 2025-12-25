package p000;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* renamed from: e */
/* loaded from: classes.dex */
public final class C1140e implements Parcelable.ClassLoaderCreator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        if (parcel.readParcelable(null) == null) {
            return AbsSavedState.EMPTY_STATE;
        }
        throw new IllegalStateException("superState must be null");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AbsSavedState[i];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.EMPTY_STATE;
        }
        throw new IllegalStateException("superState must be null");
    }
}
