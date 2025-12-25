package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.C1234gj;
import p000.C1869ue;
import p000.cd0;
import p000.yc0;
import p000.ye0;
import p000.zc0;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class Files {

    /* renamed from: a */
    public static final zc0 f15083a = new Object();

    /* renamed from: a */
    public static MappedByteBuffer m4204a(File file, FileChannel.MapMode mapMode, long j) {
        String str;
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        Closer create = Closer.create();
        try {
            if (mapMode == FileChannel.MapMode.READ_ONLY) {
                str = "r";
            } else {
                str = "rw";
            }
            FileChannel fileChannel = (FileChannel) create.register(((RandomAccessFile) create.register(new RandomAccessFile(file, str))).getChannel());
            if (j == -1) {
                j = fileChannel.size();
            }
            return fileChannel.map(mapMode, 0L, j);
        } finally {
        }
    }

    @InlineMe(imports = {"com.google.common.io.FileWriteMode", "com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset, FileWriteMode.APPEND).write(from)")
    @Deprecated
    public static void append(CharSequence charSequence, File file, Charset charset) {
        asCharSink(file, charset, FileWriteMode.APPEND).write(charSequence);
    }

    public static ByteSink asByteSink(File file, FileWriteMode... fileWriteModeArr) {
        return new C1869ue(file, fileWriteModeArr);
    }

    public static ByteSource asByteSource(File file) {
        return new C1234gj(file);
    }

    public static CharSink asCharSink(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return asByteSink(file, fileWriteModeArr).asCharSink(charset);
    }

    public static CharSource asCharSource(File file, Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }

    public static void copy(File file, OutputStream outputStream) {
        asByteSource(file).copyTo(outputStream);
    }

    public static void createParentDirs(File file) {
        Preconditions.checkNotNull(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        String valueOf = String.valueOf(file);
        throw new IOException(AbstractC1726qj.m7054j(valueOf.length() + 39, "Unable to create parent directories of ", valueOf));
    }

    @Beta
    @Deprecated
    public static File createTempDir() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(21);
        sb.append(currentTimeMillis);
        sb.append("-");
        String sb2 = sb.toString();
        for (int i = 0; i < 10000; i++) {
            File file2 = new File(file, ye0.m8290j(AbstractC1726qj.m7052h(11, sb2), i, sb2));
            if (file2.mkdir()) {
                return file2;
            }
        }
        StringBuilder m7062r = AbstractC1726qj.m7062r(AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(66, sb2), sb2), "Failed to create directory within 10000 attempts (tried ", sb2, "0 to ", sb2);
        m7062r.append("9999)");
        throw new IllegalStateException(m7062r.toString());
    }

    public static boolean equal(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file != file2 && !file.equals(file2)) {
            long length = file.length();
            long length2 = file2.length();
            if (length != 0 && length2 != 0 && length != length2) {
                return false;
            }
            return asByteSource(file).contentEquals(asByteSource(file2));
        }
        return true;
    }

    @Beta
    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(f15083a);
    }

    public static String getFileExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public static String getNameWithoutExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return name.substring(0, lastIndexOf);
        }
        return name;
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).hash(hashFunction)")
    @Deprecated
    public static HashCode hash(File file, HashFunction hashFunction) {
        return asByteSource(file).hash(hashFunction);
    }

    public static Predicate<File> isDirectory() {
        return cd0.f8335a;
    }

    public static Predicate<File> isFile() {
        return cd0.f8336b;
    }

    public static MappedByteBuffer map(File file) {
        Preconditions.checkNotNull(file);
        return map(file, FileChannel.MapMode.READ_ONLY);
    }

    public static void move(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (!file.renameTo(file2)) {
            copy(file, file2);
            if (!file.delete()) {
                if (!file2.delete()) {
                    String valueOf = String.valueOf(file2);
                    throw new IOException(AbstractC1726qj.m7054j(valueOf.length() + 17, "Unable to delete ", valueOf));
                }
                String valueOf2 = String.valueOf(file);
                throw new IOException(AbstractC1726qj.m7054j(valueOf2.length() + 17, "Unable to delete ", valueOf2));
            }
        }
    }

    public static BufferedReader newReader(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static BufferedWriter newWriter(File file, Charset charset) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @CanIgnoreReturnValue
    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).read(processor)")
    @Deprecated
    public static <T> T readBytes(File file, ByteProcessor<T> byteProcessor) {
        return (T) asByteSource(file).read(byteProcessor);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readFirstLine()")
    @CheckForNull
    @Deprecated
    public static String readFirstLine(File file, Charset charset) {
        return asCharSource(file, charset).readFirstLine();
    }

    public static List<String> readLines(File file, Charset charset) {
        return (List) asCharSource(file, charset).readLines(new yc0(0));
    }

    public static String simplifyPath(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            return ".";
        }
        Iterable<String> split = Splitter.m3782on('/').omitEmptyStrings().split(str);
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            str3.getClass();
            if (!str3.equals(".")) {
                if (!str3.equals("..")) {
                    arrayList.add(str3);
                } else if (arrayList.size() > 0 && !((String) AbstractC1726qj.m7053i(arrayList, 1)).equals("..")) {
                    arrayList.remove(arrayList.size() - 1);
                } else {
                    arrayList.add("..");
                }
            }
        }
        String join = Joiner.m3765on('/').join(arrayList);
        if (str.charAt(0) == '/') {
            String valueOf = String.valueOf(join);
            if (valueOf.length() != 0) {
                str2 = "/".concat(valueOf);
            } else {
                str2 = new String("/");
            }
            join = str2;
        }
        while (join.startsWith("/../")) {
            join = join.substring(3);
        }
        if (join.equals("/..")) {
            return "/";
        }
        if ("".equals(join)) {
            return ".";
        }
        return join;
    }

    public static byte[] toByteArray(File file) {
        return asByteSource(file).read();
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).read()")
    @Deprecated
    public static String toString(File file, Charset charset) {
        return asCharSource(file, charset).read();
    }

    public static void touch(File file) {
        Preconditions.checkNotNull(file);
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            String valueOf = String.valueOf(file);
            throw new IOException(AbstractC1726qj.m7054j(valueOf.length() + 38, "Unable to update modification time of ", valueOf));
        }
    }

    public static void write(byte[] bArr, File file) {
        asByteSink(file, new FileWriteMode[0]).write(bArr);
    }

    public static void copy(File file, File file2) {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        asByteSource(file).copyTo(asByteSink(file2, new FileWriteMode[0]));
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset).write(from)")
    @Deprecated
    public static void write(CharSequence charSequence, File file, Charset charset) {
        asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) {
        return m4204a(file, mapMode, -1L);
    }

    @CanIgnoreReturnValue
    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readLines(callback)")
    @Deprecated
    public static <T> T readLines(File file, Charset charset, LineProcessor<T> lineProcessor) {
        return (T) asCharSource(file, charset).readLines(lineProcessor);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(from, charset).copyTo(to)")
    @Deprecated
    public static void copy(File file, Charset charset, Appendable appendable) {
        asCharSource(file, charset).copyTo(appendable);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long j) {
        Preconditions.checkArgument(j >= 0, "size (%s) may not be negative", j);
        return m4204a(file, mapMode, j);
    }
}
