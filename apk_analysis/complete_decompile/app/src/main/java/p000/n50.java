package p000;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class n50 {
    @DoNotInline
    /* renamed from: a */
    public static Uri m6306a(String str, String str2) {
        return DocumentsContract.buildChildDocumentsUri(str, str2);
    }

    @DoNotInline
    /* renamed from: b */
    public static Uri m6307b(Uri uri, String str) {
        return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
    }

    @DoNotInline
    /* renamed from: c */
    public static Uri m6308c(Uri uri, String str) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, str);
    }

    @DoNotInline
    /* renamed from: d */
    public static Uri m6309d(String str, String str2) {
        return DocumentsContract.buildTreeDocumentUri(str, str2);
    }

    @DoNotInline
    /* renamed from: e */
    public static Uri m6310e(ContentResolver contentResolver, Uri uri, String str, String str2) {
        return DocumentsContract.createDocument(contentResolver, uri, str, str2);
    }

    @DoNotInline
    /* renamed from: f */
    public static String m6311f(Uri uri) {
        return DocumentsContract.getTreeDocumentId(uri);
    }

    @DoNotInline
    /* renamed from: g */
    public static Uri m6312g(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) {
        return DocumentsContract.renameDocument(contentResolver, uri, str);
    }
}
