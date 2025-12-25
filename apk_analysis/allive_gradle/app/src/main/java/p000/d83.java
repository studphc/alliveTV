package p000;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class d83 {

    /* renamed from: a */
    public final Uri f16292a;

    public d83(Uri uri) {
        this.f16292a = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d83)) {
            return false;
        }
        return Objects.equal(((d83) obj).f16292a, this.f16292a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f16292a);
    }
}
