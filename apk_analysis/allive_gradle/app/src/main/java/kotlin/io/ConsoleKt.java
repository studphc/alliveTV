package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0002¨\u0006\u0005"}, m5569d2 = {"", "readln", "()Ljava/lang/String;", "readlnOrNull", "readLine", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmName(name = "ConsoleKt")
/* loaded from: classes2.dex */
public final class ConsoleKt {
    @Nullable
    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }

    @SinceKotlin(version = "1.6")
    @NotNull
    public static final String readln() {
        String readlnOrNull = readlnOrNull();
        if (readlnOrNull != null) {
            return readlnOrNull;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(version = "1.6")
    @Nullable
    public static final String readlnOrNull() {
        return readLine();
    }
}
