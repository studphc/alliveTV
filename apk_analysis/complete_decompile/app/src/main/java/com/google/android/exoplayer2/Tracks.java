package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import p000.t82;

/* loaded from: classes.dex */
public final class Tracks implements Bundleable {

    /* renamed from: a */
    public final ImmutableList f9504a;
    public static final Tracks EMPTY = new Tracks(ImmutableList.m3902of());
    public static final Bundleable.Creator<Tracks> CREATOR = new t82(11);

    /* loaded from: classes.dex */
    public static final class Group implements Bundleable {
        public static final Bundleable.Creator<Group> CREATOR = new t82(12);

        /* renamed from: a */
        public final TrackGroup f9505a;

        /* renamed from: b */
        public final boolean f9506b;

        /* renamed from: c */
        public final int[] f9507c;

        /* renamed from: d */
        public final boolean[] f9508d;
        public final int length;

        public Group(TrackGroup trackGroup, boolean z, int[] iArr, boolean[] zArr) {
            boolean z2;
            int i = trackGroup.length;
            this.length = i;
            boolean z3 = false;
            if (i == iArr.length && i == zArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkArgument(z2);
            this.f9505a = trackGroup;
            if (z && i > 1) {
                z3 = true;
            }
            this.f9506b = z3;
            this.f9507c = (int[]) iArr.clone();
            this.f9508d = (boolean[]) zArr.clone();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Group.class != obj.getClass()) {
                return false;
            }
            Group group = (Group) obj;
            if (this.f9506b == group.f9506b && this.f9505a.equals(group.f9505a) && Arrays.equals(this.f9507c, group.f9507c) && Arrays.equals(this.f9508d, group.f9508d)) {
                return true;
            }
            return false;
        }

        public TrackGroup getMediaTrackGroup() {
            return this.f9505a;
        }

        public Format getTrackFormat(int i) {
            return this.f9505a.getFormat(i);
        }

        public int getTrackSupport(int i) {
            return this.f9507c[i];
        }

        public int getType() {
            return this.f9505a.type;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f9508d) + ((Arrays.hashCode(this.f9507c) + (((this.f9505a.hashCode() * 31) + (this.f9506b ? 1 : 0)) * 31)) * 31);
        }

        public boolean isAdaptiveSupported() {
            return this.f9506b;
        }

        public boolean isSelected() {
            return Booleans.contains(this.f9508d, true);
        }

        public boolean isSupported() {
            return isSupported(false);
        }

        public boolean isTrackSelected(int i) {
            return this.f9508d[i];
        }

        public boolean isTrackSupported(int i) {
            return isTrackSupported(i, false);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(Integer.toString(0, 36), this.f9505a.toBundle());
            bundle.putIntArray(Integer.toString(1, 36), this.f9507c);
            bundle.putBooleanArray(Integer.toString(3, 36), this.f9508d);
            bundle.putBoolean(Integer.toString(4, 36), this.f9506b);
            return bundle;
        }

        public boolean isSupported(boolean z) {
            for (int i = 0; i < this.f9507c.length; i++) {
                if (isTrackSupported(i, z)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isTrackSupported(int i, boolean z) {
            int i2 = this.f9507c[i];
            return i2 == 4 || (z && i2 == 3);
        }
    }

    public Tracks(List<Group> list) {
        this.f9504a = ImmutableList.copyOf((Collection) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsType(int i) {
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f9504a;
            if (i2 >= immutableList.size()) {
                return false;
            }
            if (((Group) immutableList.get(i2)).getType() == i) {
                return true;
            }
            i2++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Tracks.class == obj.getClass()) {
            return this.f9504a.equals(((Tracks) obj).f9504a);
        }
        return false;
    }

    public ImmutableList<Group> getGroups() {
        return this.f9504a;
    }

    public int hashCode() {
        return this.f9504a.hashCode();
    }

    public boolean isEmpty() {
        return this.f9504a.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isTypeSelected(int i) {
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f9504a;
            if (i2 >= immutableList.size()) {
                return false;
            }
            Group group = (Group) immutableList.get(i2);
            if (group.isSelected() && group.getType() == i) {
                return true;
            }
            i2++;
        }
    }

    public boolean isTypeSupported(int i) {
        return isTypeSupported(i, false);
    }

    @Deprecated
    public boolean isTypeSupportedOrEmpty(int i) {
        return isTypeSupportedOrEmpty(i, false);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Integer.toString(0, 36), BundleableUtil.toBundleArrayList(this.f9504a));
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isTypeSupported(int i, boolean z) {
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f9504a;
            if (i2 >= immutableList.size()) {
                return false;
            }
            if (((Group) immutableList.get(i2)).getType() == i && ((Group) immutableList.get(i2)).isSupported(z)) {
                return true;
            }
            i2++;
        }
    }

    @Deprecated
    public boolean isTypeSupportedOrEmpty(int i, boolean z) {
        return !containsType(i) || isTypeSupported(i, z);
    }
}
