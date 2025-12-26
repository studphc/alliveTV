package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@KeepForSdk
@SafeParcelable.Class(creator = "ApiFeatureRequestCreator")
/* loaded from: classes.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new zac();

    /* renamed from: e */
    public static final zab f13561e = zab.zaa;

    /* renamed from: a */
    public final List f13562a;

    /* renamed from: b */
    public final boolean f13563b;

    /* renamed from: c */
    public final String f13564c;

    /* renamed from: d */
    public final String f13565d;

    @SafeParcelable.Constructor
    public ApiFeatureRequest(@NonNull @SafeParcelable.Param(m3160id = 1) List list, @SafeParcelable.Param(m3160id = 2) boolean z, @Nullable @SafeParcelable.Param(m3160id = 3) String str, @Nullable @SafeParcelable.Param(m3160id = 4) String str2) {
        Preconditions.checkNotNull(list);
        this.f13562a = list;
        this.f13563b = z;
        this.f13564c = str;
        this.f13565d = str2;
    }

    /* renamed from: a */
    public static ApiFeatureRequest m3175a(List list, boolean z) {
        TreeSet treeSet = new TreeSet(f13561e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((OptionalModuleApi) it.next()).getOptionalFeatures());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z, null, null);
    }

    @NonNull
    @KeepForSdk
    public static ApiFeatureRequest fromModuleInstallRequest(@NonNull ModuleInstallRequest moduleInstallRequest) {
        return m3175a(moduleInstallRequest.getApis(), true);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        if (this.f13563b != apiFeatureRequest.f13563b || !Objects.equal(this.f13562a, apiFeatureRequest.f13562a) || !Objects.equal(this.f13564c, apiFeatureRequest.f13564c) || !Objects.equal(this.f13565d, apiFeatureRequest.f13565d)) {
            return false;
        }
        return true;
    }

    @NonNull
    @KeepForSdk
    public List<Feature> getApiFeatures() {
        return this.f13562a;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f13563b), this.f13562a, this.f13564c, this.f13565d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getApiFeatures(), false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f13563b);
        SafeParcelWriter.writeString(parcel, 3, this.f13564c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f13565d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
