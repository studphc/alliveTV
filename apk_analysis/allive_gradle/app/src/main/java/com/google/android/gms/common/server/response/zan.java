package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
/* loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();

    /* renamed from: a */
    public final int f13613a;

    /* renamed from: b */
    public final HashMap f13614b;

    /* renamed from: c */
    public final String f13615c;

    public zan(int i, String str, ArrayList arrayList) {
        this.f13613a = i;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zalVar = (zal) arrayList.get(i2);
            String str2 = zalVar.f13608b;
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList2 = zalVar.f13609c;
            int size2 = ((ArrayList) Preconditions.checkNotNull(arrayList2)).size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zamVar = (zam) arrayList2.get(i3);
                hashMap2.put(zamVar.f13611b, zamVar.f13612c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f13614b = hashMap;
        this.f13615c = (String) Preconditions.checkNotNull(str);
        zad();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = this.f13614b;
        for (String str : hashMap.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) hashMap.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f13613a);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = this.f13614b;
        for (String str : hashMap.keySet()) {
            arrayList.add(new zal(str, (Map) hashMap.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.f13615c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zaa() {
        return this.f13615c;
    }

    @Nullable
    public final Map zab(String str) {
        return (Map) this.f13614b.get(str);
    }

    public final void zac() {
        HashMap hashMap = this.f13614b;
        for (String str : hashMap.keySet()) {
            Map map = (Map) hashMap.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap2.put(str2, ((FastJsonResponse.Field) map.get(str2)).zab());
            }
            hashMap.put(str, hashMap2);
        }
    }

    public final void zad() {
        HashMap hashMap = this.f13614b;
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) hashMap.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map.get((String) it2.next())).zai(this);
            }
        }
    }

    public final void zae(Class cls, Map map) {
        this.f13614b.put((String) Preconditions.checkNotNull(cls.getCanonicalName()), map);
    }

    public final boolean zaf(Class cls) {
        return this.f13614b.containsKey(Preconditions.checkNotNull(cls.getCanonicalName()));
    }

    public zan(Class cls) {
        this.f13613a = 1;
        this.f13614b = new HashMap();
        this.f13615c = (String) Preconditions.checkNotNull(cls.getCanonicalName());
    }
}
