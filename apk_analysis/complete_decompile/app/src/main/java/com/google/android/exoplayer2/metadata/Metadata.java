package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;
import p000.C1749r5;

/* loaded from: classes.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new C1749r5(21);

    /* renamed from: a */
    public final Entry[] f10735a;

    /* loaded from: classes.dex */
    public interface Entry extends Parcelable {
        @Nullable
        byte[] getWrappedMetadataBytes();

        @Nullable
        Format getWrappedMetadataFormat();

        void populateMediaMetadata(MediaMetadata.Builder builder);
    }

    public Metadata(Entry... entryArr) {
        this.f10735a = entryArr;
    }

    public Metadata copyWithAppendedEntries(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        return new Metadata((Entry[]) Util.nullSafeArrayConcatenation(this.f10735a, entryArr));
    }

    public Metadata copyWithAppendedEntriesFrom(@Nullable Metadata metadata) {
        if (metadata == null) {
            return this;
        }
        return copyWithAppendedEntries(metadata.f10735a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Metadata.class == obj.getClass()) {
            return Arrays.equals(this.f10735a, ((Metadata) obj).f10735a);
        }
        return false;
    }

    public Entry get(int i) {
        return this.f10735a[i];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10735a);
    }

    public int length() {
        return this.f10735a.length;
    }

    public String toString() {
        return "entries=" + Arrays.toString(this.f10735a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Entry[] entryArr = this.f10735a;
        parcel.writeInt(entryArr.length);
        for (Entry entry : entryArr) {
            parcel.writeParcelable(entry, 0);
        }
    }

    public Metadata(List<? extends Entry> list) {
        this.f10735a = (Entry[]) list.toArray(new Entry[0]);
    }

    public Metadata(Parcel parcel) {
        this.f10735a = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.f10735a;
            if (i >= entryArr.length) {
                return;
            }
            entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i++;
        }
    }
}
