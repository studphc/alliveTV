package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p000.C1756rc;

/* loaded from: classes.dex */
public final class AtomicFile {

    /* renamed from: a */
    public final File f12665a;

    /* renamed from: b */
    public final File f12666b;

    public AtomicFile(File file) {
        this.f12665a = file;
        this.f12666b = new File(file.getPath() + ".bak");
    }

    public void delete() {
        this.f12665a.delete();
        this.f12666b.delete();
    }

    public void endWrite(OutputStream outputStream) {
        outputStream.close();
        this.f12666b.delete();
    }

    public boolean exists() {
        if (!this.f12665a.exists() && !this.f12666b.exists()) {
            return false;
        }
        return true;
    }

    public InputStream openRead() {
        File file = this.f12666b;
        boolean exists = file.exists();
        File file2 = this.f12665a;
        if (exists) {
            file2.delete();
            file.renameTo(file2);
        }
        return new FileInputStream(file2);
    }

    public OutputStream startWrite() {
        File file = this.f12665a;
        if (file.exists()) {
            File file2 = this.f12666b;
            if (!file2.exists()) {
                if (!file.renameTo(file2)) {
                    Log.m3027w("AtomicFile", "Couldn't rename file " + file + " to backup file " + file2);
                }
            } else {
                file.delete();
            }
        }
        try {
            return new C1756rc(file);
        } catch (FileNotFoundException e) {
            File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    return new C1756rc(file);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Couldn't create " + file, e2);
                }
            }
            throw new IOException("Couldn't create " + file, e);
        }
    }
}
