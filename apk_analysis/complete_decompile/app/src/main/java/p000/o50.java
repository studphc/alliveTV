package p000;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class o50 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m6441a(@NonNull Uri uri) {
        return DocumentsContract.isTreeUri(uri);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m6442b(ContentResolver contentResolver, Uri uri, Uri uri2) {
        return DocumentsContract.removeDocument(contentResolver, uri, uri2);
    }
}
