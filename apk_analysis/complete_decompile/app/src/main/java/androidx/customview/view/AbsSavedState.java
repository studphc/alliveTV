package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {

    /* renamed from: a */
    public final Parcelable f4098a;
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Object();

    /* renamed from: androidx.customview.view.AbsSavedState$1 */
    /* loaded from: classes.dex */
    public static class C02301 extends AbsSavedState {
    }

    public AbsSavedState() {
        this.f4098a = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Parcelable getSuperState() {
        return this.f4098a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4098a, i);
    }

    public AbsSavedState(@NonNull Parcelable parcelable) {
        if (parcelable != null) {
            this.f4098a = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(@NonNull Parcel parcel) {
        this(parcel, null);
    }

    public AbsSavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f4098a = readParcelable == null ? EMPTY_STATE : readParcelable;
    }
}
