package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: androidx.appcompat.widget.g */
/* loaded from: classes.dex */
public final class C0098g implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.appcompat.widget.AppCompatSpinner$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z;
        ?? baseSavedState = new View.BaseSavedState(parcel);
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        baseSavedState.f1214a = z;
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AppCompatSpinner.SavedState[i];
    }
}
