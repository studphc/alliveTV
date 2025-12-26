package p000;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class aj2 extends DocumentFile {

    /* renamed from: b */
    public final /* synthetic */ int f230b = 1;

    /* renamed from: c */
    public Context f231c;

    /* renamed from: d */
    public Uri f232d;

    public /* synthetic */ aj2(DocumentFile documentFile) {
        super(documentFile);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean canRead() {
        switch (this.f230b) {
            case 0:
                Context context = this.f231c;
                Uri uri = this.f232d;
                if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(yy2.m8339K(context, uri, "mime_type"))) {
                    return true;
                }
                return false;
            default:
                Context context2 = this.f231c;
                Uri uri2 = this.f232d;
                if (context2.checkCallingOrSelfUriPermission(uri2, 1) == 0 && !TextUtils.isEmpty(yy2.m8339K(context2, uri2, "mime_type"))) {
                    return true;
                }
                return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean canWrite() {
        switch (this.f230b) {
            case 0:
                return yy2.m8363h(this.f231c, this.f232d);
            default:
                return yy2.m8363h(this.f231c, this.f232d);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile createDirectory(String str) {
        Uri uri;
        switch (this.f230b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Uri uri2 = this.f232d;
                Context context = this.f231c;
                try {
                    uri = DocumentsContract.createDocument(context.getContentResolver(), uri2, "vnd.android.document/directory", str);
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return new aj2(this, context, uri);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile createFile(String str, String str2) {
        Uri uri;
        switch (this.f230b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Uri uri2 = this.f232d;
                Context context = this.f231c;
                try {
                    uri = DocumentsContract.createDocument(context.getContentResolver(), uri2, str, str2);
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return new aj2(this, context, uri);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean delete() {
        switch (this.f230b) {
            case 0:
                try {
                    return DocumentsContract.deleteDocument(this.f231c.getContentResolver(), this.f232d);
                } catch (Exception unused) {
                    return false;
                }
            default:
                try {
                    return DocumentsContract.deleteDocument(this.f231c.getContentResolver(), this.f232d);
                } catch (Exception unused2) {
                    return false;
                }
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean exists() {
        switch (this.f230b) {
            case 0:
                return yy2.m8368n(this.f231c, this.f232d);
            default:
                return yy2.m8368n(this.f231c, this.f232d);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String getName() {
        switch (this.f230b) {
            case 0:
                return yy2.m8339K(this.f231c, this.f232d, "_display_name");
            default:
                return yy2.m8339K(this.f231c, this.f232d, "_display_name");
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String getType() {
        switch (this.f230b) {
            case 0:
                String m8339K = yy2.m8339K(this.f231c, this.f232d, "mime_type");
                if ("vnd.android.document/directory".equals(m8339K)) {
                    return null;
                }
                return m8339K;
            default:
                String m8339K2 = yy2.m8339K(this.f231c, this.f232d, "mime_type");
                if ("vnd.android.document/directory".equals(m8339K2)) {
                    return null;
                }
                return m8339K2;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final Uri getUri() {
        switch (this.f230b) {
            case 0:
                return this.f232d;
            default:
                return this.f232d;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean isDirectory() {
        switch (this.f230b) {
            case 0:
                return "vnd.android.document/directory".equals(yy2.m8339K(this.f231c, this.f232d, "mime_type"));
            default:
                return "vnd.android.document/directory".equals(yy2.m8339K(this.f231c, this.f232d, "mime_type"));
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean isFile() {
        switch (this.f230b) {
            case 0:
                String m8339K = yy2.m8339K(this.f231c, this.f232d, "mime_type");
                if (!"vnd.android.document/directory".equals(m8339K) && !TextUtils.isEmpty(m8339K)) {
                    return true;
                }
                return false;
            default:
                String m8339K2 = yy2.m8339K(this.f231c, this.f232d, "mime_type");
                if (!"vnd.android.document/directory".equals(m8339K2) && !TextUtils.isEmpty(m8339K2)) {
                    return true;
                }
                return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean isVirtual() {
        switch (this.f230b) {
            case 0:
                Context context = this.f231c;
                Uri uri = this.f232d;
                if (!DocumentsContract.isDocumentUri(context, uri) || (yy2.m8338J(context, uri, "flags", 0L) & 512) == 0) {
                    return false;
                }
                return true;
            default:
                Context context2 = this.f231c;
                Uri uri2 = this.f232d;
                if (!DocumentsContract.isDocumentUri(context2, uri2) || (yy2.m8338J(context2, uri2, "flags", 0L) & 512) == 0) {
                    return false;
                }
                return true;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long lastModified() {
        switch (this.f230b) {
            case 0:
                return yy2.m8338J(this.f231c, this.f232d, "last_modified", 0L);
            default:
                return yy2.m8338J(this.f231c, this.f232d, "last_modified", 0L);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long length() {
        switch (this.f230b) {
            case 0:
                return yy2.m8338J(this.f231c, this.f232d, "_size", 0L);
            default:
                return yy2.m8338J(this.f231c, this.f232d, "_size", 0L);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile[] listFiles() {
        switch (this.f230b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Context context = this.f231c;
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = this.f232d;
                Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
                ArrayList arrayList = new ArrayList();
                Cursor cursor = null;
                try {
                    try {
                        cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                        while (cursor.moveToNext()) {
                            arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f232d, cursor.getString(0)));
                        }
                        try {
                            cursor.close();
                        } catch (RuntimeException e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        Log.w("DocumentFile", "Failed query: " + e2);
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (RuntimeException e3) {
                                throw e3;
                            }
                        }
                    }
                    Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
                    DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
                    for (int i = 0; i < uriArr.length; i++) {
                        documentFileArr[i] = new aj2(this, context, uriArr[i]);
                    }
                    return documentFileArr;
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (RuntimeException e4) {
                            throw e4;
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean renameTo(String str) {
        switch (this.f230b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                try {
                    Uri renameDocument = DocumentsContract.renameDocument(this.f231c.getContentResolver(), this.f232d, str);
                    if (renameDocument == null) {
                        return false;
                    }
                    this.f232d = renameDocument;
                    return true;
                } catch (Exception unused) {
                    return false;
                }
        }
    }

    public aj2(aj2 aj2Var, Context context, Uri uri) {
        super(aj2Var);
        this.f231c = context;
        this.f232d = uri;
    }
}
