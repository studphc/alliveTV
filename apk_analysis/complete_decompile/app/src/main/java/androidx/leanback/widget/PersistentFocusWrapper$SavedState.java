package androidx.leanback.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class PersistentFocusWrapper$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<PersistentFocusWrapper$SavedState> CREATOR = new Object();

    /* renamed from: a */
    public int f5985a;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f5985a);
    }
}
