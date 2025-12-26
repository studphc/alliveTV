package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.InlineMe;

@KeepForSdk
@SafeParcelable.Class(creator = "MethodInvocationCreator")
/* loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();

    /* renamed from: a */
    public final int f13451a;

    /* renamed from: b */
    public final int f13452b;

    /* renamed from: c */
    public final int f13453c;

    /* renamed from: d */
    public final long f13454d;

    /* renamed from: e */
    public final long f13455e;

    /* renamed from: f */
    public final String f13456f;

    /* renamed from: g */
    public final String f13457g;

    /* renamed from: h */
    public final int f13458h;

    /* renamed from: i */
    public final int f13459i;

    @InlineMe(replacement = "this(methodKey, resultStatusCode, connectionResultStatusCode, startTimeMillis, endTimeMillis, callingModuleId, callingEntryPoint, serviceId, -1)")
    @KeepForSdk
    @Deprecated
    public MethodInvocation(int i, int i2, int i3, long j, long j2, @Nullable String str, @Nullable String str2, int i4) {
        this(i, i2, i3, j, j2, str, str2, i4, -1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13451a);
        SafeParcelWriter.writeInt(parcel, 2, this.f13452b);
        SafeParcelWriter.writeInt(parcel, 3, this.f13453c);
        SafeParcelWriter.writeLong(parcel, 4, this.f13454d);
        SafeParcelWriter.writeLong(parcel, 5, this.f13455e);
        SafeParcelWriter.writeString(parcel, 6, this.f13456f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f13457g, false);
        SafeParcelWriter.writeInt(parcel, 8, this.f13458h);
        SafeParcelWriter.writeInt(parcel, 9, this.f13459i);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param(m3160id = 1) int i, @SafeParcelable.Param(m3160id = 2) int i2, @SafeParcelable.Param(m3160id = 3) int i3, @SafeParcelable.Param(m3160id = 4) long j, @SafeParcelable.Param(m3160id = 5) long j2, @Nullable @SafeParcelable.Param(m3160id = 6) String str, @Nullable @SafeParcelable.Param(m3160id = 7) String str2, @SafeParcelable.Param(m3160id = 8) int i4, @SafeParcelable.Param(m3160id = 9) int i5) {
        this.f13451a = i;
        this.f13452b = i2;
        this.f13453c = i3;
        this.f13454d = j;
        this.f13455e = j2;
        this.f13456f = str;
        this.f13457g = str2;
        this.f13458h = i4;
        this.f13459i = i5;
    }
}
