package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0247b(3);

    /* renamed from: a */
    public final String f4563a;

    /* renamed from: b */
    public final String f4564b;

    /* renamed from: c */
    public final boolean f4565c;

    /* renamed from: d */
    public final boolean f4566d;

    /* renamed from: e */
    public final int f4567e;

    /* renamed from: f */
    public final int f4568f;

    /* renamed from: g */
    public final String f4569g;

    /* renamed from: h */
    public final boolean f4570h;

    /* renamed from: i */
    public final boolean f4571i;

    /* renamed from: j */
    public final boolean f4572j;

    /* renamed from: k */
    public final boolean f4573k;

    /* renamed from: l */
    public final int f4574l;

    /* renamed from: m */
    public final String f4575m;

    /* renamed from: n */
    public final int f4576n;

    /* renamed from: o */
    public final boolean f4577o;

    public FragmentState(Fragment fragment) {
        this.f4563a = fragment.getClass().getName();
        this.f4564b = fragment.f4452f;
        this.f4565c = fragment.f4462p;
        this.f4566d = fragment.f4464r;
        this.f4567e = fragment.f4472z;
        this.f4568f = fragment.f4418A;
        this.f4569g = fragment.f4419B;
        this.f4570h = fragment.f4422E;
        this.f4571i = fragment.f4459m;
        this.f4572j = fragment.f4421D;
        this.f4573k = fragment.f4420C;
        this.f4574l = fragment.f4437T.ordinal();
        this.f4575m = fragment.f4455i;
        this.f4576n = fragment.f4456j;
        this.f4577o = fragment.f4430M;
    }

    /* renamed from: a */
    public final Fragment m1203a(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        Fragment instantiate = fragmentFactory.instantiate(classLoader, this.f4563a);
        instantiate.f4452f = this.f4564b;
        instantiate.f4462p = this.f4565c;
        instantiate.f4464r = this.f4566d;
        instantiate.f4465s = true;
        instantiate.f4472z = this.f4567e;
        instantiate.f4418A = this.f4568f;
        instantiate.f4419B = this.f4569g;
        instantiate.f4422E = this.f4570h;
        instantiate.f4459m = this.f4571i;
        instantiate.f4421D = this.f4572j;
        instantiate.f4420C = this.f4573k;
        instantiate.f4437T = Lifecycle.State.values()[this.f4574l];
        instantiate.f4455i = this.f4575m;
        instantiate.f4456j = this.f4576n;
        instantiate.f4430M = this.f4577o;
        return instantiate;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f4563a);
        sb.append(" (");
        sb.append(this.f4564b);
        sb.append(")}:");
        if (this.f4565c) {
            sb.append(" fromLayout");
        }
        if (this.f4566d) {
            sb.append(" dynamicContainer");
        }
        int i = this.f4568f;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.f4569g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f4570h) {
            sb.append(" retainInstance");
        }
        if (this.f4571i) {
            sb.append(" removing");
        }
        if (this.f4572j) {
            sb.append(" detached");
        }
        if (this.f4573k) {
            sb.append(" hidden");
        }
        String str2 = this.f4575m;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.f4576n);
        }
        if (this.f4577o) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4563a);
        parcel.writeString(this.f4564b);
        parcel.writeInt(this.f4565c ? 1 : 0);
        parcel.writeInt(this.f4566d ? 1 : 0);
        parcel.writeInt(this.f4567e);
        parcel.writeInt(this.f4568f);
        parcel.writeString(this.f4569g);
        parcel.writeInt(this.f4570h ? 1 : 0);
        parcel.writeInt(this.f4571i ? 1 : 0);
        parcel.writeInt(this.f4572j ? 1 : 0);
        parcel.writeInt(this.f4573k ? 1 : 0);
        parcel.writeInt(this.f4574l);
        parcel.writeString(this.f4575m);
        parcel.writeInt(this.f4576n);
        parcel.writeInt(this.f4577o ? 1 : 0);
    }

    public FragmentState(Parcel parcel) {
        this.f4563a = parcel.readString();
        this.f4564b = parcel.readString();
        this.f4565c = parcel.readInt() != 0;
        this.f4566d = parcel.readInt() != 0;
        this.f4567e = parcel.readInt();
        this.f4568f = parcel.readInt();
        this.f4569g = parcel.readString();
        this.f4570h = parcel.readInt() != 0;
        this.f4571i = parcel.readInt() != 0;
        this.f4572j = parcel.readInt() != 0;
        this.f4573k = parcel.readInt() != 0;
        this.f4574l = parcel.readInt();
        this.f4575m = parcel.readString();
        this.f4576n = parcel.readInt();
        this.f4577o = parcel.readInt() != 0;
    }
}
