package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import p000.C1203fp;
import p000.C1865ua;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class CharStreams {
    @Beta
    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new C1865ua(appendable);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) {
        long j = 0;
        if (readable instanceof Reader) {
            if (appendable instanceof StringBuilder) {
                Reader reader = (Reader) readable;
                StringBuilder sb = (StringBuilder) appendable;
                Preconditions.checkNotNull(reader);
                Preconditions.checkNotNull(sb);
                char[] cArr = new char[2048];
                while (true) {
                    int read = reader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                        j += read;
                    } else {
                        return j;
                    }
                }
            } else {
                Reader reader2 = (Reader) readable;
                Writer asWriter = asWriter(appendable);
                Preconditions.checkNotNull(reader2);
                Preconditions.checkNotNull(asWriter);
                char[] cArr2 = new char[2048];
                while (true) {
                    int read2 = reader2.read(cArr2);
                    if (read2 != -1) {
                        asWriter.write(cArr2, 0, read2);
                        j += read2;
                    } else {
                        return j;
                    }
                }
            }
        } else {
            Preconditions.checkNotNull(readable);
            Preconditions.checkNotNull(appendable);
            CharBuffer allocate = CharBuffer.allocate(2048);
            while (readable.read(allocate) != -1) {
                allocate.flip();
                appendable.append(allocate);
                j += allocate.remaining();
                allocate.clear();
            }
            return j;
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) {
        CharBuffer allocate = CharBuffer.allocate(2048);
        long j = 0;
        while (true) {
            long read = readable.read(allocate);
            if (read != -1) {
                j += read;
                allocate.clear();
            } else {
                return j;
            }
        }
    }

    @Beta
    public static Writer nullWriter() {
        return C1203fp.f17357a;
    }

    @Beta
    public static List<String> readLines(Readable readable) {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    @Beta
    public static void skipFully(Reader reader, long j) {
        Preconditions.checkNotNull(reader);
        while (j > 0) {
            long skip = reader.skip(j);
            if (skip != 0) {
                j -= skip;
            } else {
                throw new EOFException();
            }
        }
    }

    public static String toString(Readable readable) {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            Preconditions.checkNotNull(reader);
            Preconditions.checkNotNull(sb);
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } else {
            copy(readable, sb);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }
}
