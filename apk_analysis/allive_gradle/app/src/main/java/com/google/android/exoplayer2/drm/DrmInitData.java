package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import p000.C1749r5;
import p000.ye0;

/* loaded from: classes.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new C1749r5(10);

    /* renamed from: a */
    public final SchemeData[] f9975a;

    /* renamed from: b */
    public int f9976b;
    public final int schemeDataCount;

    @Nullable
    public final String schemeType;

    /* loaded from: classes.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Object();

        /* renamed from: a */
        public int f9977a;

        @Nullable
        public final byte[] data;

        @Nullable
        public final String licenseServerUrl;
        public final String mimeType;
        public final UUID uuid;

        public SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public boolean canReplace(SchemeData schemeData) {
            if (hasData() && !schemeData.hasData() && matches(schemeData.uuid)) {
                return true;
            }
            return false;
        }

        @CheckResult
        public SchemeData copyWithData(@Nullable byte[] bArr) {
            return new SchemeData(this.uuid, this.licenseServerUrl, this.mimeType, bArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!Util.areEqual(this.licenseServerUrl, schemeData.licenseServerUrl) || !Util.areEqual(this.mimeType, schemeData.mimeType) || !Util.areEqual(this.uuid, schemeData.uuid) || !Arrays.equals(this.data, schemeData.data)) {
                return false;
            }
            return true;
        }

        public boolean hasData() {
            if (this.data != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            if (this.f9977a == 0) {
                int hashCode2 = this.uuid.hashCode() * 31;
                String str = this.licenseServerUrl;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                this.f9977a = Arrays.hashCode(this.data) + ye0.m8286f((hashCode2 + hashCode) * 31, 31, this.mimeType);
            }
            return this.f9977a;
        }

        public boolean matches(UUID uuid) {
            if (!C0643C.UUID_NIL.equals(this.uuid) && !uuid.equals(this.uuid)) {
                return false;
            }
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.licenseServerUrl);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
        }

        public SchemeData(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid);
            this.licenseServerUrl = str;
            this.mimeType = (String) Assertions.checkNotNull(str2);
            this.data = bArr;
        }

        public SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.licenseServerUrl = parcel.readString();
            this.mimeType = (String) Util.castNonNull(parcel.readString());
            this.data = parcel.createByteArray();
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    @Nullable
    public static DrmInitData createSessionCreationData(@Nullable DrmInitData drmInitData, @Nullable DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.schemeType;
            for (SchemeData schemeData : drmInitData.f9975a) {
                if (schemeData.hasData()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.schemeType;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f9975a) {
                if (schemeData2.hasData()) {
                    UUID uuid = schemeData2.uuid;
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (((SchemeData) arrayList.get(i)).uuid.equals(uuid)) {
                                break;
                            }
                            i++;
                        } else {
                            arrayList.add(schemeData2);
                            break;
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    @CheckResult
    public DrmInitData copyWithSchemeType(@Nullable String str) {
        if (Util.areEqual(this.schemeType, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.f9975a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        if (Util.areEqual(this.schemeType, drmInitData.schemeType) && Arrays.equals(this.f9975a, drmInitData.f9975a)) {
            return true;
        }
        return false;
    }

    public SchemeData get(int i) {
        return this.f9975a[i];
    }

    public int hashCode() {
        int hashCode;
        if (this.f9976b == 0) {
            String str = this.schemeType;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            this.f9976b = (hashCode * 31) + Arrays.hashCode(this.f9975a);
        }
        return this.f9976b;
    }

    public DrmInitData merge(DrmInitData drmInitData) {
        boolean z;
        String str;
        String str2 = this.schemeType;
        if (str2 != null && (str = drmInitData.schemeType) != null && !TextUtils.equals(str2, str)) {
            z = false;
        } else {
            z = true;
        }
        Assertions.checkState(z);
        String str3 = this.schemeType;
        if (str3 == null) {
            str3 = drmInitData.schemeType;
        }
        return new DrmInitData(str3, (SchemeData[]) Util.nullSafeArrayConcatenation(this.f9975a, drmInitData.f9975a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.schemeType);
        parcel.writeTypedArray(this.f9975a, 0);
    }

    public DrmInitData(@Nullable String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    @Override // java.util.Comparator
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = C0643C.UUID_NIL;
        if (uuid.equals(schemeData.uuid)) {
            return uuid.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(String str, boolean z, SchemeData... schemeDataArr) {
        this.schemeType = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f9975a = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    public DrmInitData(Parcel parcel) {
        this.schemeType = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) Util.castNonNull((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f9975a = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }
}
