package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import p000.cl2;
import p000.ha0;
import p000.l41;
import p000.t02;
import p000.t12;

@Metadata(m5568d1 = {"t02"}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Okio {
    @NotNull
    public static final Sink appendingSink(@NotNull File file) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return sink(new FileOutputStream(file, true));
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader classLoader) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, okio.Sink] */
    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new Object();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink sink, @NotNull Cipher cipher) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(sink, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSink(buffer(sink), cipher);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source source, @NotNull Cipher cipher) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSource(buffer(source), cipher);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink, @NotNull MessageDigest digest) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(sink, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSink(sink, digest);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source, @NotNull MessageDigest digest) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSource(source, digest);
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError assertionError) {
        boolean z;
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message != null) {
            z = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem fileSystem, @NotNull Path zipPath) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        return ZipKt.openZip$default(zipPath, fileSystem, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return sink$default(file, false, 1, null);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) {
        Logger logger = t02.f26653a;
        if ((i & 1) != 0) {
            z = false;
        }
        return sink(file, z);
    }

    @NotNull
    public static final Source source(@NotNull File file) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new l41(new FileInputStream(file), Timeout.NONE);
    }

    public static final <T extends Closeable, R> R use(T t, @NotNull Function1<? super T, ? extends R> block) {
        R r;
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable th = null;
        try {
            r = block.invoke(t);
        } catch (Throwable th2) {
            th = th2;
            r = null;
        }
        if (t != null) {
            try {
                t.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ha0.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(r);
            return r;
        }
        throw th;
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RealBufferedSource(source);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File file, boolean z) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(file, "<this>");
        return sink(new FileOutputStream(file, z));
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink, @NotNull Mac mac) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(sink, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSink(sink, mac);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source, @NotNull Mac mac) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSource(source, mac);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new l41(inputStream, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return new t12(outputStream, new Timeout());
    }

    @NotNull
    public static final Source source(@NotNull Socket socket) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        cl2 cl2Var = new cl2(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return cl2Var.source(new l41(inputStream, cl2Var));
    }

    @NotNull
    public static final Sink sink(@NotNull Socket socket) {
        Logger logger = t02.f26653a;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        cl2 cl2Var = new cl2(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return cl2Var.sink(new t12(outputStream, cl2Var));
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull java.nio.file.Path path, @NotNull OpenOption... openOptionArr) {
        return t02.m7429b(path, openOptionArr);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull java.nio.file.Path path, @NotNull OpenOption... openOptionArr) {
        return t02.m7428a(path, openOptionArr);
    }
}
