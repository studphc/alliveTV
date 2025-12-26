package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryEntryCreator")
/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zap();

    /* renamed from: a */
    public final int f13607a;

    /* renamed from: b */
    public final String f13608b;

    /* renamed from: c */
    public final ArrayList f13609c;

    public zal(int i, String str, ArrayList arrayList) {
        this.f13607a = i;
        this.f13608b = str;
        this.f13609c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13607a);
        SafeParcelWriter.writeString(parcel, 2, this.f13608b, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.f13609c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f13607a = 1;
        this.f13608b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam((FastJsonResponse.Field) map.get(str2), str2));
            }
        }
        this.f13609c = arrayList;
    }
}
