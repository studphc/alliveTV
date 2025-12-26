package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class FlagSet {

    /* renamed from: a */
    public final SparseBooleanArray f12700a;

    public FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.f12700a = sparseBooleanArray;
    }

    public boolean contains(int i) {
        return this.f12700a.get(i);
    }

    public boolean containsAny(int... iArr) {
        for (int i : iArr) {
            if (contains(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (Util.SDK_INT < 24) {
            if (size() != flagSet.size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if (get(i) != flagSet.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return this.f12700a.equals(flagSet.f12700a);
    }

    public int get(int i) {
        Assertions.checkIndex(i, 0, size());
        return this.f12700a.keyAt(i);
    }

    public int hashCode() {
        if (Util.SDK_INT < 24) {
            int size = size();
            for (int i = 0; i < size(); i++) {
                size = (size * 31) + get(i);
            }
            return size;
        }
        return this.f12700a.hashCode();
    }

    public int size() {
        return this.f12700a.size();
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final SparseBooleanArray f12701a = new SparseBooleanArray();

        /* renamed from: b */
        public boolean f12702b;

        public Builder add(int i) {
            Assertions.checkState(!this.f12702b);
            this.f12701a.append(i, true);
            return this;
        }

        public Builder addAll(int... iArr) {
            for (int i : iArr) {
                add(i);
            }
            return this;
        }

        public Builder addIf(int i, boolean z) {
            if (z) {
                return add(i);
            }
            return this;
        }

        public FlagSet build() {
            Assertions.checkState(!this.f12702b);
            this.f12702b = true;
            return new FlagSet(this.f12701a);
        }

        public Builder remove(int i) {
            Assertions.checkState(!this.f12702b);
            this.f12701a.delete(i);
            return this;
        }

        public Builder removeAll(int... iArr) {
            for (int i : iArr) {
                remove(i);
            }
            return this;
        }

        public Builder removeIf(int i, boolean z) {
            if (z) {
                return remove(i);
            }
            return this;
        }

        public Builder addAll(FlagSet flagSet) {
            for (int i = 0; i < flagSet.size(); i++) {
                add(flagSet.get(i));
            }
            return this;
        }
    }
}
