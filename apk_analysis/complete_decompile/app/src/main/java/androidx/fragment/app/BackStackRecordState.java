package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import p000.hu0;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new C0247b(0);

    /* renamed from: a */
    public final int[] f4374a;

    /* renamed from: b */
    public final ArrayList f4375b;

    /* renamed from: c */
    public final int[] f4376c;

    /* renamed from: d */
    public final int[] f4377d;

    /* renamed from: e */
    public final int f4378e;

    /* renamed from: f */
    public final String f4379f;

    /* renamed from: g */
    public final int f4380g;

    /* renamed from: h */
    public final int f4381h;

    /* renamed from: i */
    public final CharSequence f4382i;

    /* renamed from: j */
    public final int f4383j;

    /* renamed from: k */
    public final CharSequence f4384k;

    /* renamed from: l */
    public final ArrayList f4385l;

    /* renamed from: m */
    public final ArrayList f4386m;

    /* renamed from: n */
    public final boolean f4387n;

    public BackStackRecordState(C0246a c0246a) {
        int size = c0246a.f4596c.size();
        this.f4374a = new int[size * 6];
        if (c0246a.f4602i) {
            this.f4375b = new ArrayList(size);
            this.f4376c = new int[size];
            this.f4377d = new int[size];
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                hu0 hu0Var = (hu0) c0246a.f4596c.get(i2);
                int i3 = i + 1;
                this.f4374a[i] = hu0Var.f18174a;
                ArrayList arrayList = this.f4375b;
                Fragment fragment = hu0Var.f18175b;
                arrayList.add(fragment != null ? fragment.f4452f : null);
                int[] iArr = this.f4374a;
                iArr[i3] = hu0Var.f18176c ? 1 : 0;
                iArr[i + 2] = hu0Var.f18177d;
                iArr[i + 3] = hu0Var.f18178e;
                int i4 = i + 5;
                iArr[i + 4] = hu0Var.f18179f;
                i += 6;
                iArr[i4] = hu0Var.f18180g;
                this.f4376c[i2] = hu0Var.f18181h.ordinal();
                this.f4377d[i2] = hu0Var.f18182i.ordinal();
            }
            this.f4378e = c0246a.f4601h;
            this.f4379f = c0246a.f4604k;
            this.f4380g = c0246a.f4647v;
            this.f4381h = c0246a.f4605l;
            this.f4382i = c0246a.f4606m;
            this.f4383j = c0246a.f4607n;
            this.f4384k = c0246a.f4608o;
            this.f4385l = c0246a.f4609p;
            this.f4386m = c0246a.f4610q;
            this.f4387n = c0246a.f4611r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [hu0, java.lang.Object] */
    /* renamed from: a */
    public final void m1131a(C0246a c0246a) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4374a;
            boolean z = true;
            if (i < iArr.length) {
                ?? obj = new Object();
                int i3 = i + 1;
                obj.f18174a = iArr[i];
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Instantiate " + c0246a + " op #" + i2 + " base fragment #" + iArr[i3]);
                }
                obj.f18181h = Lifecycle.State.values()[this.f4376c[i2]];
                obj.f18182i = Lifecycle.State.values()[this.f4377d[i2]];
                int i4 = i + 2;
                if (iArr[i3] == 0) {
                    z = false;
                }
                obj.f18176c = z;
                int i5 = iArr[i4];
                obj.f18177d = i5;
                int i6 = iArr[i + 3];
                obj.f18178e = i6;
                int i7 = i + 5;
                int i8 = iArr[i + 4];
                obj.f18179f = i8;
                i += 6;
                int i9 = iArr[i7];
                obj.f18180g = i9;
                c0246a.f4597d = i5;
                c0246a.f4598e = i6;
                c0246a.f4599f = i8;
                c0246a.f4600g = i9;
                c0246a.m1207b(obj);
                i2++;
            } else {
                c0246a.f4601h = this.f4378e;
                c0246a.f4604k = this.f4379f;
                c0246a.f4602i = true;
                c0246a.f4605l = this.f4381h;
                c0246a.f4606m = this.f4382i;
                c0246a.f4607n = this.f4383j;
                c0246a.f4608o = this.f4384k;
                c0246a.f4609p = this.f4385l;
                c0246a.f4610q = this.f4386m;
                c0246a.f4611r = this.f4387n;
                return;
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f4374a);
        parcel.writeStringList(this.f4375b);
        parcel.writeIntArray(this.f4376c);
        parcel.writeIntArray(this.f4377d);
        parcel.writeInt(this.f4378e);
        parcel.writeString(this.f4379f);
        parcel.writeInt(this.f4380g);
        parcel.writeInt(this.f4381h);
        TextUtils.writeToParcel(this.f4382i, parcel, 0);
        parcel.writeInt(this.f4383j);
        TextUtils.writeToParcel(this.f4384k, parcel, 0);
        parcel.writeStringList(this.f4385l);
        parcel.writeStringList(this.f4386m);
        parcel.writeInt(this.f4387n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f4374a = parcel.createIntArray();
        this.f4375b = parcel.createStringArrayList();
        this.f4376c = parcel.createIntArray();
        this.f4377d = parcel.createIntArray();
        this.f4378e = parcel.readInt();
        this.f4379f = parcel.readString();
        this.f4380g = parcel.readInt();
        this.f4381h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f4382i = (CharSequence) creator.createFromParcel(parcel);
        this.f4383j = parcel.readInt();
        this.f4384k = (CharSequence) creator.createFromParcel(parcel);
        this.f4385l = parcel.createStringArrayList();
        this.f4386m = parcel.createStringArrayList();
        this.f4387n = parcel.readInt() != 0;
    }
}
