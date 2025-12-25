package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AtomicFile {

    /* renamed from: a */
    public final File f3815a;

    /* renamed from: b */
    public final File f3816b;

    /* renamed from: c */
    public final File f3817c;

    public AtomicFile(@NonNull File file) {
        this.f3815a = file;
        this.f3816b = new File(file.getPath() + ".new");
        this.f3817c = new File(file.getPath() + ".bak");
    }

    /* renamed from: a */
    public static void m895a(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (!file.renameTo(file2)) {
            Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
        }
    }

    public void delete() {
        this.f3815a.delete();
        this.f3816b.delete();
        this.f3817c.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        boolean z;
        if (fileOutputStream == null) {
            return;
        }
        try {
            fileOutputStream.getFD().sync();
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        if (!z) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        File file = this.f3816b;
        if (!file.delete()) {
            Log.e("AtomicFile", "Failed to delete new file " + file);
        }
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        boolean z;
        if (fileOutputStream == null) {
            return;
        }
        try {
            fileOutputStream.getFD().sync();
            z = true;
        } catch (IOException unused) {
            z = false;
        }
        if (!z) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        m895a(this.f3816b, this.f3815a);
    }

    @NonNull
    public File getBaseFile() {
        return this.f3815a;
    }

    @NonNull
    public FileInputStream openRead() {
        File file = this.f3817c;
        boolean exists = file.exists();
        File file2 = this.f3815a;
        if (exists) {
            m895a(file, file2);
        }
        File file3 = this.f3816b;
        if (file3.exists() && file2.exists() && !file3.delete()) {
            Log.e("AtomicFile", "Failed to delete outdated new file " + file3);
        }
        return new FileInputStream(file2);
    }

    @NonNull
    public byte[] readFully() {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[available + i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @NonNull
    public FileOutputStream startWrite() {
        File file = this.f3816b;
        File file2 = this.f3817c;
        if (file2.exists()) {
            m895a(file2, this.f3815a);
        }
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException unused) {
            if (file.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    throw new IOException("Failed to create new file " + file, e);
                }
            }
            throw new IOException("Failed to create directory for " + file);
        }
    }
}
