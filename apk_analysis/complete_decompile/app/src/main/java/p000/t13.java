package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.SimpleArrayMap;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class t13 extends VersionedParcel {

    /* renamed from: d */
    public final SparseIntArray f26660d;

    /* renamed from: e */
    public final Parcel f26661e;

    /* renamed from: f */
    public final int f26662f;

    /* renamed from: g */
    public final int f26663g;

    /* renamed from: h */
    public final String f26664h;

    /* renamed from: i */
    public int f26665i;

    /* renamed from: j */
    public int f26666j;

    /* renamed from: k */
    public int f26667k;

    public t13(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new SimpleArrayMap(), new SimpleArrayMap(), new SimpleArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void closeField() {
        int i = this.f26665i;
        if (i >= 0) {
            int i2 = this.f26660d.get(i);
            Parcel parcel = this.f26661e;
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i2);
            parcel.writeInt(dataPosition - i2);
            parcel.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final VersionedParcel createSubParcel() {
        Parcel parcel = this.f26661e;
        int dataPosition = parcel.dataPosition();
        int i = this.f26666j;
        if (i == this.f26662f) {
            i = this.f26663g;
        }
        return new t13(parcel, dataPosition, i, AbstractC1726qj.m7061q(new StringBuilder(), this.f26664h, "  "), this.f7569a, this.f7570b, this.f7571c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readBoolean() {
        if (this.f26661e.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final Bundle readBundle() {
        return this.f26661e.readBundle(t13.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] readByteArray() {
        Parcel parcel = this.f26661e;
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        parcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f26661e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final double readDouble() {
        return this.f26661e.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readField(int i) {
        while (this.f26666j < this.f26663g) {
            int i2 = this.f26667k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i3 = this.f26666j;
            Parcel parcel = this.f26661e;
            parcel.setDataPosition(i3);
            int readInt = parcel.readInt();
            this.f26667k = parcel.readInt();
            this.f26666j += readInt;
        }
        if (this.f26667k != i) {
            return false;
        }
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final float readFloat() {
        return this.f26661e.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int readInt() {
        return this.f26661e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final long readLong() {
        return this.f26661e.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final Parcelable readParcelable() {
        return this.f26661e.readParcelable(t13.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String readString() {
        return this.f26661e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final IBinder readStrongBinder() {
        return this.f26661e.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void setOutputField(int i) {
        closeField();
        this.f26665i = i;
        this.f26660d.put(i, this.f26661e.dataPosition());
        writeInt(0);
        writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeBoolean(boolean z) {
        this.f26661e.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeBundle(Bundle bundle) {
        this.f26661e.writeBundle(bundle);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeByteArray(byte[] bArr) {
        Parcel parcel = this.f26661e;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        } else {
            parcel.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f26661e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeDouble(double d) {
        this.f26661e.writeDouble(d);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeFloat(float f) {
        this.f26661e.writeFloat(f);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeInt(int i) {
        this.f26661e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeLong(long j) {
        this.f26661e.writeLong(j);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeParcelable(Parcelable parcelable) {
        this.f26661e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeString(String str) {
        this.f26661e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeStrongBinder(IBinder iBinder) {
        this.f26661e.writeStrongBinder(iBinder);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeStrongInterface(IInterface iInterface) {
        this.f26661e.writeStrongInterface(iInterface);
    }

    public t13(Parcel parcel, int i, int i2, String str, SimpleArrayMap simpleArrayMap, SimpleArrayMap simpleArrayMap2, SimpleArrayMap simpleArrayMap3) {
        super(simpleArrayMap, simpleArrayMap2, simpleArrayMap3);
        this.f26660d = new SparseIntArray();
        this.f26665i = -1;
        this.f26667k = -1;
        this.f26661e = parcel;
        this.f26662f = i;
        this.f26663g = i2;
        this.f26666j = i;
        this.f26664h = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeByteArray(byte[] bArr, int i, int i2) {
        Parcel parcel = this.f26661e;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr, i, i2);
        } else {
            parcel.writeInt(-1);
        }
    }
}
