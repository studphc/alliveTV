package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class DataBufferRef {

    /* renamed from: a */
    public int f13321a;

    @NonNull
    @KeepForSdk
    protected final DataHolder mDataHolder;

    @KeepForSdk
    protected int mDataRow;

    @KeepForSdk
    public DataBufferRef(@NonNull DataHolder dataHolder, int i) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        zaa(i);
    }

    @KeepForSdk
    public void copyToBuffer(@NonNull String str, @NonNull CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.zac(str, this.mDataRow, this.f13321a, charArrayBuffer);
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.f13321a), Integer.valueOf(this.f13321a)) && dataBufferRef.mDataHolder == this.mDataHolder) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean getBoolean(@NonNull String str) {
        return this.mDataHolder.getBoolean(str, this.mDataRow, this.f13321a);
    }

    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str) {
        return this.mDataHolder.getByteArray(str, this.mDataRow, this.f13321a);
    }

    @KeepForSdk
    public int getDataRow() {
        return this.mDataRow;
    }

    @KeepForSdk
    public double getDouble(@NonNull String str) {
        return this.mDataHolder.zaa(str, this.mDataRow, this.f13321a);
    }

    @KeepForSdk
    public float getFloat(@NonNull String str) {
        return this.mDataHolder.zab(str, this.mDataRow, this.f13321a);
    }

    @KeepForSdk
    public int getInteger(@NonNull String str) {
        return this.mDataHolder.getInteger(str, this.mDataRow, this.f13321a);
    }

    @KeepForSdk
    public long getLong(@NonNull String str) {
        return this.mDataHolder.getLong(str, this.mDataRow, this.f13321a);
    }

    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str) {
        return this.mDataHolder.getString(str, this.mDataRow, this.f13321a);
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.mDataHolder.hasColumn(str);
    }

    @KeepForSdk
    public boolean hasNull(@NonNull String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.f13321a);
    }

    @KeepForSdk
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.f13321a), this.mDataHolder);
    }

    @KeepForSdk
    public boolean isDataValid() {
        if (!this.mDataHolder.isClosed()) {
            return true;
        }
        return false;
    }

    @Nullable
    @KeepForSdk
    public Uri parseUri(@NonNull String str) {
        String string = this.mDataHolder.getString(str, this.mDataRow, this.f13321a);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public final void zaa(int i) {
        boolean z = false;
        if (i >= 0 && i < this.mDataHolder.getCount()) {
            z = true;
        }
        Preconditions.checkState(z);
        this.mDataRow = i;
        this.f13321a = this.mDataHolder.getWindowIndex(i);
    }
}
