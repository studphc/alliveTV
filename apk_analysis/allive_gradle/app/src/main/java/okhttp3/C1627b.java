package okhttp3;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: okhttp3.b */
/* loaded from: classes2.dex */
public final class C1627b implements CookieJar {
    @Override // okhttp3.CookieJar
    public final List loadForRequest(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // okhttp3.CookieJar
    public final void saveFromResponse(HttpUrl url, List cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
    }
}
