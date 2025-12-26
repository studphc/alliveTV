package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentTabHost;

/* renamed from: androidx.fragment.app.t */
/* loaded from: classes.dex */
public final class C0265t implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.fragment.app.FragmentTabHost$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? baseSavedState = new View.BaseSavedState(parcel);
        baseSavedState.f4593a = parcel.readString();
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new FragmentTabHost.SavedState[i];
    }
}
