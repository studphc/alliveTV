package androidx.privacysandbox.ads.adservices.appsetid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\r¨\u0006\u0017"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "", "", "id", "", "scope", "<init>", "(Ljava/lang/String;I)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "getId", "b", "I", "getScope", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nAppSetId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSetId.kt\nandroidx/privacysandbox/ads/adservices/appsetid/AppSetId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
/* loaded from: classes.dex */
public final class AppSetId {
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;

    /* renamed from: a, reason: from kotlin metadata */
    public final String id;

    /* renamed from: b, reason: from kotlin metadata */
    public final int scope;

    public AppSetId(@NotNull String id, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.scope = i;
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Scope undefined.");
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) other;
        if (Intrinsics.areEqual(this.id, appSetId.id) && this.scope == appSetId.scope) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getScope() {
        return this.scope;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.scope;
    }

    @NotNull
    public String toString() {
        String str;
        if (this.scope == 1) {
            str = "SCOPE_APP";
        } else {
            str = "SCOPE_DEVELOPER";
        }
        return "AppSetId: id=" + this.id + ", scope=" + str;
    }
}
