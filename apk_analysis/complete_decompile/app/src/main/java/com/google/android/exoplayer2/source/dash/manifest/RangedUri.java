package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.UriUtil;
import p000.ye0;

/* loaded from: classes.dex */
public final class RangedUri {

    /* renamed from: a */
    public final String f11326a;

    /* renamed from: b */
    public int f11327b;
    public final long length;
    public final long start;

    public RangedUri(@Nullable String str, long j, long j2) {
        this.f11326a = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    @Nullable
    public RangedUri attemptMerge(@Nullable RangedUri rangedUri, String str) {
        String resolveUriString = resolveUriString(str);
        if (rangedUri != null && resolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j = this.length;
            long j2 = -1;
            if (j != -1) {
                long j3 = this.start;
                if (j3 + j == rangedUri.start) {
                    long j4 = rangedUri.length;
                    if (j4 != -1) {
                        j2 = j + j4;
                    }
                    return new RangedUri(resolveUriString, j3, j2);
                }
            }
            long j5 = rangedUri.length;
            if (j5 != -1) {
                long j6 = rangedUri.start;
                if (j6 + j5 == this.start) {
                    if (j != -1) {
                        j2 = j5 + j;
                    }
                    return new RangedUri(resolveUriString, j6, j2);
                }
            }
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RangedUri.class != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        if (this.start == rangedUri.start && this.length == rangedUri.length && this.f11326a.equals(rangedUri.f11326a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f11327b == 0) {
            this.f11327b = this.f11326a.hashCode() + ((((527 + ((int) this.start)) * 31) + ((int) this.length)) * 31);
        }
        return this.f11327b;
    }

    public Uri resolveUri(String str) {
        return UriUtil.resolveToUri(str, this.f11326a);
    }

    public String resolveUriString(String str) {
        return UriUtil.resolve(str, this.f11326a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RangedUri(referenceUri=");
        sb.append(this.f11326a);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", length=");
        return ye0.m8297q(sb, this.length, ")");
    }
}
