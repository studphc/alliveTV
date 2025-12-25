package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@ShowFirstParty
@KeepForSdk
@SafeParcelable.Class(creator = "BitmapTeleporterCreator")
/* loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();

    /* renamed from: a */
    public final int f13314a;

    /* renamed from: b */
    public ParcelFileDescriptor f13315b;

    /* renamed from: c */
    public final int f13316c;

    /* renamed from: d */
    public Bitmap f13317d;

    /* renamed from: e */
    public boolean f13318e;

    /* renamed from: f */
    public File f13319f;

    public BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.f13314a = i;
        this.f13315b = parcelFileDescriptor;
        this.f13316c = i2;
        this.f13317d = null;
        this.f13318e = false;
    }

    /* renamed from: a */
    public static final void m3129a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    @Nullable
    @KeepForSdk
    public Bitmap get() {
        if (!this.f13318e) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.checkNotNull(this.f13315b)));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                    dataInputStream.read(bArr);
                    m3129a(dataInputStream);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                    createBitmap.copyPixelsFromBuffer(wrap);
                    this.f13317d = createBitmap;
                    this.f13318e = true;
                } catch (IOException e) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e);
                }
            } catch (Throwable th) {
                m3129a(dataInputStream);
                throw th;
            }
        }
        return this.f13317d;
    }

    @KeepForSdk
    public void release() {
        if (!this.f13318e) {
            try {
                ((ParcelFileDescriptor) Preconditions.checkNotNull(this.f13315b)).close();
            } catch (IOException e) {
                Log.w("BitmapTeleporter", "Could not close PFD", e);
            }
        }
    }

    @KeepForSdk
    public void setTempDir(@NonNull File file) {
        if (file != null) {
            this.f13319f = file;
            return;
        }
        throw new NullPointerException("Cannot set null temp directory");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        if (this.f13315b == null) {
            Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(this.f13317d);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            File file = this.f13319f;
            if (file != null) {
                try {
                    File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        this.f13315b = ParcelFileDescriptor.open(createTempFile, 268435456);
                        createTempFile.delete();
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            try {
                                dataOutputStream.writeInt(array.length);
                                dataOutputStream.writeInt(bitmap.getWidth());
                                dataOutputStream.writeInt(bitmap.getHeight());
                                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                                dataOutputStream.write(array);
                            } catch (IOException e) {
                                throw new IllegalStateException("Could not write into unlinked file", e);
                            }
                        } finally {
                            m3129a(dataOutputStream);
                        }
                    } catch (FileNotFoundException unused) {
                        throw new IllegalStateException("Temporary file is somehow already deleted");
                    }
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not create temporary file", e2);
                }
            } else {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13314a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f13315b, i | 1, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f13316c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        this.f13315b = null;
    }

    @KeepForSdk
    public BitmapTeleporter(@NonNull Bitmap bitmap) {
        this.f13314a = 1;
        this.f13315b = null;
        this.f13316c = 0;
        this.f13317d = bitmap;
        this.f13318e = true;
    }
}
