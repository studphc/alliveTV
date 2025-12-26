package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import p000.n50;
import p000.o50;

/* loaded from: classes.dex */
public final class DocumentsContractCompat {

    /* loaded from: classes.dex */
    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String str, @Nullable String str2) {
        return n50.m6306a(str, str2);
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri uri, @NonNull String str) {
        return n50.m6307b(uri, str);
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String str, @NonNull String str2) {
        return DocumentsContract.buildDocumentUri(str, str2);
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri uri, @NonNull String str) {
        return n50.m6308c(uri, str);
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String str, @NonNull String str2) {
        return n50.m6309d(str, str2);
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str, @NonNull String str2) {
        return n50.m6310e(contentResolver, uri, str, str2);
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri uri) {
        return DocumentsContract.getDocumentId(uri);
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri uri) {
        return n50.m6311f(uri);
    }

    public static boolean isDocumentUri(@NonNull Context context, @Nullable Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isTreeUri(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT < 24) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() < 2 || !"tree".equals(pathSegments.get(0))) {
                return false;
            }
            return true;
        }
        return o50.m6441a(uri);
    }

    public static boolean removeDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull Uri uri2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return o50.m6442b(contentResolver, uri, uri2);
        }
        return DocumentsContract.deleteDocument(contentResolver, uri);
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) {
        return n50.m6312g(contentResolver, uri, str);
    }
}
