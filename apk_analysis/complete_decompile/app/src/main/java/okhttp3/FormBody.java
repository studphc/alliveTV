package okhttp3;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001dB%\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001f"}, m5569d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "", "", "encodedNames", "encodedValues", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "-deprecated_size", "()I", "size", FirebaseAnalytics.Param.INDEX, "encodedName", "(I)Ljava/lang/String;", AppMeasurementSdk.ConditionalUserProperty.NAME, "encodedValue", "value", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Lokio/BufferedSink;", "sink", "", "writeTo", "(Lokio/BufferedSink;)V", "Companion", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FormBody extends RequestBody {

    /* renamed from: c */
    public static final MediaType f23947c = MediaType.INSTANCE.get(HttpRequest.CONTENT_TYPE_FORM);

    /* renamed from: a */
    public final List f23948a;

    /* renamed from: b */
    public final List f23949b;

    @Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lokhttp3/FormBody$Builder;", "", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "<init>", "(Ljava/nio/charset/Charset;)V", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "add", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/FormBody$Builder;", "addEncoded", "Lokhttp3/FormBody;", "build", "()Lokhttp3/FormBody;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public final Charset f23950a;

        /* renamed from: b */
        public final ArrayList f23951b;

        /* renamed from: c */
        public final ArrayList f23952c;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = this.f23951b;
            HttpUrl.Companion companion = HttpUrl.INSTANCE;
            arrayList.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, false, false, this.f23950a, 91, null));
            this.f23952c.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, false, false, this.f23950a, 91, null));
            return this;
        }

        @NotNull
        public final Builder addEncoded(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = this.f23951b;
            HttpUrl.Companion companion = HttpUrl.INSTANCE;
            arrayList.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.f23950a, 83, null));
            this.f23952c.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.f23950a, 83, null));
            return this;
        }

        @NotNull
        public final FormBody build() {
            return new FormBody(this.f23951b, this.f23952c);
        }

        @JvmOverloads
        public Builder(@Nullable Charset charset) {
            this.f23950a = charset;
            this.f23951b = new ArrayList();
            this.f23952c = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : charset);
        }
    }

    public FormBody(@NotNull List<String> encodedNames, @NotNull List<String> encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.f23948a = _UtilJvmKt.toImmutableList(encodedNames);
        this.f23949b = _UtilJvmKt.toImmutableList(encodedValues);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m8955deprecated_size() {
        return size();
    }

    /* renamed from: a */
    public final long m6587a(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            Intrinsics.checkNotNull(bufferedSink);
            buffer = bufferedSink.getBuffer();
        }
        List list = this.f23948a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8((String) list.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8((String) this.f23949b.get(i));
        }
        if (z) {
            long size2 = buffer.size();
            buffer.clear();
            return size2;
        }
        return 0L;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return m6587a(null, true);
    }

    @Override // okhttp3.RequestBody
    @NotNull
    /* renamed from: contentType */
    public MediaType getF24151a() {
        return f23947c;
    }

    @NotNull
    public final String encodedName(int index) {
        return (String) this.f23948a.get(index);
    }

    @NotNull
    public final String encodedValue(int index) {
        return (String) this.f23949b.get(index);
    }

    @NotNull
    public final String name(int index) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, encodedName(index), 0, 0, true, 3, null);
    }

    @JvmName(name = "size")
    public final int size() {
        return this.f23948a.size();
    }

    @NotNull
    public final String value(int index) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, encodedValue(index), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        m6587a(sink, false);
    }
}
