package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {

    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();

    /* renamed from: a */
    public final int f13569a;

    /* renamed from: b */
    public final HashMap f13570b;

    /* renamed from: c */
    public final SparseArray f13571c;

    @KeepForSdk
    public StringToIntConverter() {
        this.f13569a = 1;
        this.f13570b = new HashMap();
        this.f13571c = new SparseArray();
    }

    @NonNull
    @CanIgnoreReturnValue
    @KeepForSdk
    public StringToIntConverter add(@NonNull String str, int i) {
        this.f13570b.put(str, Integer.valueOf(i));
        this.f13571c.put(i, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13569a);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = this.f13570b;
        for (String str : hashMap.keySet()) {
            arrayList.add(new zac(str, ((Integer) hashMap.get(str)).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int zaa() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int zab() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    @Nullable
    public final /* bridge */ /* synthetic */ Object zac(@NonNull Object obj) {
        HashMap hashMap = this.f13570b;
        Integer num = (Integer) hashMap.get((String) obj);
        if (num == null) {
            return (Integer) hashMap.get("gms_unknown");
        }
        return num;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    @NonNull
    public final /* bridge */ /* synthetic */ Object zad(@NonNull Object obj) {
        String str = (String) this.f13571c.get(((Integer) obj).intValue());
        if (str == null && this.f13570b.containsKey("gms_unknown")) {
            return "gms_unknown";
        }
        return str;
    }

    public StringToIntConverter(ArrayList arrayList, int i) {
        this.f13569a = i;
        this.f13570b = new HashMap();
        this.f13571c = new SparseArray();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zac zacVar = (zac) arrayList.get(i2);
            add(zacVar.f13575b, zacVar.f13576c);
        }
    }
}
