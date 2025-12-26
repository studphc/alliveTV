package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzl implements Parcelable.Creator {
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.common.internal.zzk] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 2) {
                    if (fieldId != 3) {
                        if (fieldId != 4) {
                            SafeParcelReader.skipUnknownField(parcel, readHeader);
                        } else {
                            connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.createParcelable(parcel, readHeader, ConnectionTelemetryConfiguration.CREATOR);
                        }
                    } else {
                        i = SafeParcelReader.readInt(parcel, readHeader);
                    }
                } else {
                    featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel, readHeader, Feature.CREATOR);
                }
            } else {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ?? abstractSafeParcelable = new AbstractSafeParcelable();
        abstractSafeParcelable.f13527a = bundle;
        abstractSafeParcelable.f13528b = featureArr;
        abstractSafeParcelable.f13529c = i;
        abstractSafeParcelable.f13530d = connectionTelemetryConfiguration;
        return abstractSafeParcelable;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzk[i];
    }
}
