package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import com.google.android.exoplayer2.C0643C;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Set;
import p000.bi2;
import p000.u13;
import p000.ye0;

/* renamed from: androidx.versionedparcelable.a */
/* loaded from: classes.dex */
public final class C0523a extends VersionedParcel {

    /* renamed from: m */
    public static final Charset f7572m = Charset.forName(C0643C.UTF16_NAME);

    /* renamed from: d */
    public final DataInputStream f7573d;

    /* renamed from: e */
    public final DataOutputStream f7574e;

    /* renamed from: f */
    public final DataInputStream f7575f;

    /* renamed from: g */
    public DataOutputStream f7576g;

    /* renamed from: h */
    public bi2 f7577h;

    /* renamed from: i */
    public boolean f7578i;

    /* renamed from: j */
    public int f7579j;

    /* renamed from: k */
    public int f7580k;

    /* renamed from: l */
    public int f7581l;

    public C0523a(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new SimpleArrayMap(), new SimpleArrayMap(), new SimpleArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void closeField() {
        int i;
        bi2 bi2Var = this.f7577h;
        if (bi2Var != null) {
            try {
                if (((ByteArrayOutputStream) bi2Var.f8028b).size() != 0) {
                    bi2 bi2Var2 = this.f7577h;
                    ((DataOutputStream) bi2Var2.f8029c).flush();
                    ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) bi2Var2.f8028b;
                    int size = byteArrayOutputStream.size();
                    int i2 = bi2Var2.f8027a << 16;
                    if (size >= 65535) {
                        i = 65535;
                    } else {
                        i = size;
                    }
                    DataOutputStream dataOutputStream = (DataOutputStream) bi2Var2.f8030d;
                    dataOutputStream.writeInt(i2 | i);
                    if (size >= 65535) {
                        dataOutputStream.writeInt(size);
                    }
                    byteArrayOutputStream.writeTo(dataOutputStream);
                }
                this.f7577h = null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final VersionedParcel createSubParcel() {
        return new C0523a(this.f7575f, this.f7576g, this.f7569a, this.f7570b, this.f7571c);
    }

    /* renamed from: h */
    public final void m1926h(Object obj) {
        if (obj == null) {
            writeInt(0);
            return;
        }
        if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
            return;
        }
        if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
            return;
        }
        if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
            return;
        }
        if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
            return;
        }
        if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
            return;
        }
        if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
            return;
        }
        if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
            return;
        }
        if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readBoolean() {
        try {
            return this.f7575f.readBoolean();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i = 0; i < readInt; i++) {
            String readString = readString();
            int readInt2 = readInt();
            switch (readInt2) {
                case 0:
                    bundle.putParcelable(readString, null);
                    break;
                case 1:
                    bundle.putBundle(readString, readBundle());
                    break;
                case 2:
                    bundle.putBundle(readString, readBundle());
                    break;
                case 3:
                    bundle.putString(readString, readString());
                    break;
                case 4:
                    bundle.putStringArray(readString, (String[]) readArray(new String[0]));
                    break;
                case 5:
                    bundle.putBoolean(readString, readBoolean());
                    break;
                case 6:
                    bundle.putBooleanArray(readString, readBooleanArray());
                    break;
                case 7:
                    bundle.putDouble(readString, readDouble());
                    break;
                case 8:
                    bundle.putDoubleArray(readString, readDoubleArray());
                    break;
                case 9:
                    bundle.putInt(readString, readInt());
                    break;
                case 10:
                    bundle.putIntArray(readString, readIntArray());
                    break;
                case 11:
                    bundle.putLong(readString, readLong());
                    break;
                case 12:
                    bundle.putLongArray(readString, readLongArray());
                    break;
                case 13:
                    bundle.putFloat(readString, readFloat());
                    break;
                case 14:
                    bundle.putFloatArray(readString, readFloatArray());
                    break;
                default:
                    throw new RuntimeException(ye0.m8291k(readInt2, "Unknown type "));
            }
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] readByteArray() {
        DataInputStream dataInputStream = this.f7575f;
        try {
            int readInt = dataInputStream.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                dataInputStream.readFully(bArr);
                return bArr;
            }
            return null;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final double readDouble() {
        try {
            return this.f7575f.readDouble();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readField(int i) {
        while (true) {
            try {
                int i2 = this.f7580k;
                if (i2 == i) {
                    return true;
                }
                if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                    return false;
                }
                int i3 = this.f7579j;
                int i4 = this.f7581l;
                DataInputStream dataInputStream = this.f7573d;
                if (i3 < i4) {
                    dataInputStream.skip(i4 - i3);
                }
                this.f7581l = -1;
                int readInt = dataInputStream.readInt();
                this.f7579j = 0;
                int i5 = readInt & 65535;
                if (i5 == 65535) {
                    i5 = dataInputStream.readInt();
                }
                this.f7580k = (readInt >> 16) & 65535;
                this.f7581l = i5;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final float readFloat() {
        try {
            return this.f7575f.readFloat();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int readInt() {
        try {
            return this.f7575f.readInt();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final long readLong() {
        try {
            return this.f7575f.readLong();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final Parcelable readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String readString() {
        DataInputStream dataInputStream = this.f7575f;
        try {
            int readInt = dataInputStream.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                dataInputStream.readFully(bArr);
                return new String(bArr, f7572m);
            }
            return null;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void setOutputField(int i) {
        closeField();
        bi2 bi2Var = new bi2(i, this.f7574e);
        this.f7577h = bi2Var;
        this.f7576g = (DataOutputStream) bi2Var.f8029c;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void setSerializationFlags(boolean z, boolean z2) {
        if (z) {
            this.f7578i = z2;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeBoolean(boolean z) {
        try {
            this.f7576g.writeBoolean(z);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeBundle(Bundle bundle) {
        try {
            if (bundle != null) {
                Set<String> keySet = bundle.keySet();
                this.f7576g.writeInt(keySet.size());
                for (String str : keySet) {
                    writeString(str);
                    m1926h(bundle.get(str));
                }
                return;
            }
            this.f7576g.writeInt(-1);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeByteArray(byte[] bArr) {
        try {
            if (bArr != null) {
                this.f7576g.writeInt(bArr.length);
                this.f7576g.write(bArr);
            } else {
                this.f7576g.writeInt(-1);
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeCharSequence(CharSequence charSequence) {
        if (this.f7578i) {
        } else {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeDouble(double d) {
        try {
            this.f7576g.writeDouble(d);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeFloat(float f) {
        try {
            this.f7576g.writeFloat(f);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeInt(int i) {
        try {
            this.f7576g.writeInt(i);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeLong(long j) {
        try {
            this.f7576g.writeLong(j);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeParcelable(Parcelable parcelable) {
        if (this.f7578i) {
        } else {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeString(String str) {
        try {
            if (str != null) {
                byte[] bytes = str.getBytes(f7572m);
                this.f7576g.writeInt(bytes.length);
                this.f7576g.write(bytes);
            } else {
                this.f7576g.writeInt(-1);
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeStrongBinder(IBinder iBinder) {
        if (this.f7578i) {
        } else {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeStrongInterface(IInterface iInterface) {
        if (this.f7578i) {
        } else {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public C0523a(InputStream inputStream, OutputStream outputStream, SimpleArrayMap simpleArrayMap, SimpleArrayMap simpleArrayMap2, SimpleArrayMap simpleArrayMap3) {
        super(simpleArrayMap, simpleArrayMap2, simpleArrayMap3);
        this.f7579j = 0;
        this.f7580k = -1;
        this.f7581l = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new u13(this, inputStream)) : null;
        this.f7573d = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.f7574e = dataOutputStream;
        this.f7575f = dataInputStream;
        this.f7576g = dataOutputStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeByteArray(byte[] bArr, int i, int i2) {
        try {
            if (bArr != null) {
                this.f7576g.writeInt(i2);
                this.f7576g.write(bArr, i, i2);
            } else {
                this.f7576g.writeInt(-1);
            }
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }
}
