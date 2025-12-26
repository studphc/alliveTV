package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0247b(1);

    /* renamed from: a */
    public final ArrayList f4388a;

    /* renamed from: b */
    public final ArrayList f4389b;

    public BackStackState(ArrayList arrayList, ArrayList arrayList2) {
        this.f4388a = arrayList;
        this.f4389b = arrayList2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f4388a);
        parcel.writeTypedList(this.f4389b);
    }

    public BackStackState(Parcel parcel) {
        this.f4388a = parcel.createStringArrayList();
        this.f4389b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
