package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0247b(2);

    /* renamed from: a */
    public ArrayList f4550a;

    /* renamed from: b */
    public ArrayList f4551b;

    /* renamed from: c */
    public BackStackRecordState[] f4552c;

    /* renamed from: d */
    public int f4553d;

    /* renamed from: e */
    public String f4554e;

    /* renamed from: f */
    public ArrayList f4555f;

    /* renamed from: g */
    public ArrayList f4556g;

    /* renamed from: h */
    public ArrayList f4557h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f4550a);
        parcel.writeStringList(this.f4551b);
        parcel.writeTypedArray(this.f4552c, i);
        parcel.writeInt(this.f4553d);
        parcel.writeString(this.f4554e);
        parcel.writeStringList(this.f4555f);
        parcel.writeTypedList(this.f4556g);
        parcel.writeTypedList(this.f4557h);
    }
}
