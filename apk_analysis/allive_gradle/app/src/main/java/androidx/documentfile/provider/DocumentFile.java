package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import p000.aj2;
import p000.w82;

/* loaded from: classes.dex */
public abstract class DocumentFile {

    /* renamed from: a */
    public final DocumentFile f4135a;

    public DocumentFile(DocumentFile documentFile) {
        this.f4135a = documentFile;
    }

    @NonNull
    public static DocumentFile fromFile(@NonNull File file) {
        return new w82(null, file);
    }

    @Nullable
    public static DocumentFile fromSingleUri(@NonNull Context context, @NonNull Uri uri) {
        aj2 aj2Var = new aj2(null);
        aj2Var.f231c = context;
        aj2Var.f232d = uri;
        return aj2Var;
    }

    @Nullable
    public static DocumentFile fromTreeUri(@NonNull Context context, @NonNull Uri uri) {
        return new aj2(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }

    public static boolean isDocumentUri(@NonNull Context context, @Nullable Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    @Nullable
    public abstract DocumentFile createDirectory(@NonNull String str);

    @Nullable
    public abstract DocumentFile createFile(@NonNull String str, @NonNull String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    @Nullable
    public DocumentFile findFile(@NonNull String str) {
        for (DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }

    @Nullable
    public abstract String getName();

    @Nullable
    public DocumentFile getParentFile() {
        return this.f4135a;
    }

    @Nullable
    public abstract String getType();

    @NonNull
    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    @NonNull
    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(@NonNull String str);
}
