package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, m5569d2 = {"okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "initialValue", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DatesKt$STANDARD_DATE_FORMAT$1 extends ThreadLocal<DateFormat> {
    @Override // java.lang.ThreadLocal
    @NotNull
    public DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(_UtilJvmKt.UTC);
        return simpleDateFormat;
    }
}
