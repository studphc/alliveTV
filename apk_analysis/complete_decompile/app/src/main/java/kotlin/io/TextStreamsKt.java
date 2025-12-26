package kotlin.io;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import p000.ed0;
import p000.n81;

@Metadata(m5568d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b*\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0011\u0010\u001d\u001a\u00020\u001c*\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m5569d2 = {"Ljava/io/Reader;", "Lkotlin/Function1;", "", "", "action", "forEachLine", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)V", "", "readLines", "(Ljava/io/Reader;)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "block", "useLines", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/io/BufferedReader;", "lineSequence", "(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;", "readText", "(Ljava/io/Reader;)Ljava/lang/String;", "Ljava/io/Writer;", "out", "", "bufferSize", "", "copyTo", "(Ljava/io/Reader;Ljava/io/Writer;I)J", "Ljava/net/URL;", "", "readBytes", "(Ljava/net/URL;)[B", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmName(name = "TextStreamsKt")
@SourceDebugExtension({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,151:1\n52#1:152\n1#2:153\n1#2:156\n1295#3,2:154\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n33#1:152\n33#1:153\n33#1:154,2\n*E\n"})
/* loaded from: classes2.dex */
public final class TextStreamsKt {
    public static final long copyTo(@NotNull Reader reader, @NotNull Writer out, int i) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j += read;
            read = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(reader, writer, i);
    }

    public static final void forEachLine(@NotNull Reader reader, @NotNull Function1<? super String, Unit> action) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            Iterator<String> it = lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            CloseableKt.closeFinally(bufferedReader, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.constrainOnce(new n81(bufferedReader));
    }

    @NotNull
    public static final byte[] readBytes(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        InputStream it = url.openStream();
        try {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            byte[] readBytes = ByteStreamsKt.readBytes(it);
            CloseableKt.closeFinally(it, null);
            return readBytes;
        } finally {
        }
    }

    @NotNull
    public static final List<String> readLines(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        forEachLine(reader, new ed0(arrayList, 1));
        return arrayList;
    }

    @NotNull
    public static final String readText(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static final <T> T useLines(@NotNull Reader reader, @NotNull Function1<? super Sequence<String>, ? extends T> block) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            T invoke = block.invoke(lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }
}
