package p000;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.SinceKotlin;
import kotlin.io.encoding.Base64;
import kotlin.io.encoding.ExperimentalEncodingApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class wn2 {
    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @NotNull
    public static final InputStream decodingWith(@NotNull InputStream inputStream, @NotNull Base64 base64) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(base64, "base64");
        return new C0574bz(inputStream, base64);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @NotNull
    public static final OutputStream encodingWith(@NotNull OutputStream outputStream, @NotNull Base64 base64) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(base64, "base64");
        return new x80(outputStream, base64);
    }
}
