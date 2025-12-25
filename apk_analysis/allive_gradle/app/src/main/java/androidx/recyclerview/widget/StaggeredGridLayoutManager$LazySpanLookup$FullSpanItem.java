package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new Object();

    /* renamed from: a */
    public int f7295a;

    /* renamed from: b */
    public int f7296b;

    /* renamed from: c */
    public int[] f7297c;

    /* renamed from: d */
    public boolean f7298d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f7295a + ", mGapDir=" + this.f7296b + ", mHasUnwantedGapAfter=" + this.f7298d + ", mGapPerSpan=" + Arrays.toString(this.f7297c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7295a);
        parcel.writeInt(this.f7296b);
        parcel.writeInt(this.f7298d ? 1 : 0);
        int[] iArr = this.f7297c;
        if (iArr != null && iArr.length > 0) {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f7297c);
        } else {
            parcel.writeInt(0);
        }
    }
}
