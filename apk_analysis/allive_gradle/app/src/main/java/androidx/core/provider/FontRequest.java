package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {

    /* renamed from: a */
    public final String f3719a;

    /* renamed from: b */
    public final String f3720b;

    /* renamed from: c */
    public final String f3721c;

    /* renamed from: d */
    public final List f3722d;

    /* renamed from: e */
    public final int f3723e;

    /* renamed from: f */
    public final String f3724f;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.f3719a = (String) Preconditions.checkNotNull(str);
        this.f3720b = (String) Preconditions.checkNotNull(str2);
        this.f3721c = (String) Preconditions.checkNotNull(str3);
        this.f3722d = (List) Preconditions.checkNotNull(list);
        this.f3723e = 0;
        this.f3724f = str + "-" + str2 + "-" + str3;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.f3722d;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.f3723e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public String getIdentifier() {
        return this.f3724f;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.f3719a;
    }

    @NonNull
    public String getProviderPackage() {
        return this.f3720b;
    }

    @NonNull
    public String getQuery() {
        return this.f3721c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f3719a + ", mProviderPackage: " + this.f3720b + ", mQuery: " + this.f3721c + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.f3722d;
            if (i < list.size()) {
                sb.append(" [");
                List list2 = (List) list.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString((byte[]) list2.get(i2), 0));
                    sb.append("\"");
                }
                sb.append(" ]");
                i++;
            } else {
                sb.append("}");
                sb.append("mCertificatesArray: " + this.f3723e);
                return sb.toString();
            }
        }
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @ArrayRes int i) {
        this.f3719a = (String) Preconditions.checkNotNull(str);
        this.f3720b = (String) Preconditions.checkNotNull(str2);
        this.f3721c = (String) Preconditions.checkNotNull(str3);
        this.f3722d = null;
        Preconditions.checkArgument(i != 0);
        this.f3723e = i;
        this.f3724f = str + "-" + str2 + "-" + str3;
    }
}
