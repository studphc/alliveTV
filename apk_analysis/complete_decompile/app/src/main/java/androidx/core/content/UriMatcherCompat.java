package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Predicate;
import p000.u41;

/* loaded from: classes.dex */
public class UriMatcherCompat {
    @NonNull
    public static Predicate<Uri> asPredicate(@NonNull UriMatcher uriMatcher) {
        return new u41(3, uriMatcher);
    }
}
