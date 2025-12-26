package p000;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w82 extends DocumentFile {

    /* renamed from: b */
    public File f28100b;

    public w82(w82 w82Var, File file) {
        super(w82Var);
        this.f28100b = file;
    }

    /* renamed from: a */
    public static boolean m8010a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= m8010a(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean canRead() {
        return this.f28100b.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean canWrite() {
        return this.f28100b.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile createDirectory(String str) {
        File file = new File(this.f28100b, str);
        if (!file.isDirectory() && !file.mkdir()) {
            return null;
        }
        return new w82(this, file);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = AbstractC1726qj.m7058n(str2, ".", extensionFromMimeType);
        }
        File file = new File(this.f28100b, str2);
        try {
            file.createNewFile();
            return new w82(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean delete() {
        m8010a(this.f28100b);
        return this.f28100b.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean exists() {
        return this.f28100b.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String getName() {
        return this.f28100b.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final String getType() {
        if (this.f28100b.isDirectory()) {
            return null;
        }
        String name = this.f28100b.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1).toLowerCase());
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final Uri getUri() {
        return Uri.fromFile(this.f28100b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean isDirectory() {
        return this.f28100b.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean isFile() {
        return this.f28100b.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean isVirtual() {
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long lastModified() {
        return this.f28100b.lastModified();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final long length() {
        return this.f28100b.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f28100b.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                arrayList.add(new w82(this, file));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public final boolean renameTo(String str) {
        File file = new File(this.f28100b.getParentFile(), str);
        if (this.f28100b.renameTo(file)) {
            this.f28100b = file;
            return true;
        }
        return false;
    }
}
