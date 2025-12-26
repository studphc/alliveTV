package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.core.widget.NestedScrollView;

/* renamed from: androidx.core.widget.a */
/* loaded from: classes.dex */
public final class C0228a implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, androidx.core.widget.NestedScrollView$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ?? baseSavedState = new View.BaseSavedState(parcel);
        baseSavedState.f4080a = parcel.readInt();
        return baseSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new NestedScrollView.SavedState[i];
    }
}
