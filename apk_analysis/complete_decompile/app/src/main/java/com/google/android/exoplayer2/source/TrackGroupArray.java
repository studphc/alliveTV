package com.google.android.exoplayer2.source;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import p000.t82;

/* loaded from: classes.dex */
public final class TrackGroupArray implements Bundleable {

    /* renamed from: a */
    public final ImmutableList f11090a;

    /* renamed from: b */
    public int f11091b;
    public final int length;
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    public static final Bundleable.Creator<TrackGroupArray> CREATOR = new t82(8);

    /* JADX WARN: Multi-variable type inference failed */
    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f11090a = ImmutableList.copyOf(trackGroupArr);
        this.length = trackGroupArr.length;
        int i = 0;
        while (true) {
            ImmutableList immutableList = this.f11090a;
            if (i < immutableList.size()) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < immutableList.size(); i3++) {
                    if (((TrackGroup) immutableList.get(i)).equals(immutableList.get(i3))) {
                        Log.m3024e("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.length == trackGroupArray.length && this.f11090a.equals(trackGroupArray.f11090a)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrackGroup get(int i) {
        return (TrackGroup) this.f11090a.get(i);
    }

    public int hashCode() {
        if (this.f11091b == 0) {
            this.f11091b = this.f11090a.hashCode();
        }
        return this.f11091b;
    }

    public int indexOf(TrackGroup trackGroup) {
        int indexOf = this.f11090a.indexOf(trackGroup);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf;
    }

    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Integer.toString(0, 36), BundleableUtil.toBundleArrayList(this.f11090a));
        return bundle;
    }
}
