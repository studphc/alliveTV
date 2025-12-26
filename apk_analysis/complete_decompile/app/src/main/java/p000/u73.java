package p000;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class u73 {

    /* renamed from: a */
    public final ApiKey f27143a;

    /* renamed from: b */
    public final Feature f27144b;

    public /* synthetic */ u73(ApiKey apiKey, Feature feature) {
        this.f27143a = apiKey;
        this.f27144b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof u73)) {
            u73 u73Var = (u73) obj;
            if (Objects.equal(this.f27143a, u73Var.f27143a) && Objects.equal(this.f27144b, u73Var.f27144b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f27143a, this.f27144b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.f27143a).add("feature", this.f27144b).toString();
    }
}
