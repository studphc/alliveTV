package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class Descriptor {

    /* renamed from: id */
    @Nullable
    public final String f11324id;
    public final String schemeIdUri;

    @Nullable
    public final String value;

    public Descriptor(String str, @Nullable String str2, @Nullable String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.f11324id = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Descriptor.class != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        if (Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) && Util.areEqual(this.value, descriptor.value) && Util.areEqual(this.f11324id, descriptor.f11324id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.schemeIdUri.hashCode() * 31;
        String str = this.value;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = (hashCode + i) * 31;
        String str2 = this.f11324id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }
}
