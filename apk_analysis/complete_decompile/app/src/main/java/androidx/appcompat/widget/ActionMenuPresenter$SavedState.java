package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class ActionMenuPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<ActionMenuPresenter$SavedState> CREATOR = new Object();

    /* renamed from: a */
    public int f1071a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1071a);
    }
}
